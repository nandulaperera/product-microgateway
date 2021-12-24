/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package sourcewatcher

import (
	"path/filepath"
	"time"

	"github.com/wso2/product-microgateway/adapter/internal/loggers"
	"github.com/wso2/product-microgateway/adapter/config"
	"github.com/go-git/go-git/v5"
	"github.com/go-git/go-git/v5/plumbing/transport/http"
	"github.com/wso2/product-microgateway/adapter/internal/api"
)

const (
	apisArtifactDir string = "apis"
)

// Start fetches the API artifacts at the startup and polls for changes from the remote repository
func Start(conf *config.Config) error{
	loggers.LoggerAPI.Info("Starting source watcher")
	repository, err := fetchArtifacts(conf)

	if err != nil{
		loggers.LoggerAPI.Error("Error while fetching API artifacts during startup. ", err)
		return err
	}
	loggers.LoggerAPI.Info("Polling for changes")
	go pollChanges(conf, repository)
	return nil
}

// fetchArtifacts clones the API artifacts from the remote repository into the APIs directory in the adapter
func fetchArtifacts(conf *config.Config) (*git.Repository,error) {
	// Populate data from config
	artifactsDirName := filepath.FromSlash(conf.Adapter.ArtifactsDirectory + "/" + apisArtifactDir)
	username := conf.Adapter.SourceControl.Repository.Username
	accessToken := conf.Adapter.SourceControl.Repository.AccessToken
	repositoryURL := conf.Adapter.SourceControl.Repository.URL

	// Opens the local repository, if exists
	repository, _ := git.PlainOpen(artifactsDirName)

	// If a local repository exists, pull the changes from the remote repository
	if repository != nil {
		loggers.LoggerAPI.Info("Starting to fetch changes from remote repository")

		compareRepository(conf, repository)

		return repository, nil
	}

	// If a local repository does not exist, clone the remote repository
	loggers.LoggerAPI.Info("Fetching API artifacts from remote repository")

	// Clones the  remote repository
	repository, err := git.PlainClone(artifactsDirName, false, &git.CloneOptions{
		URL: repositoryURL,
		Auth: &http.BasicAuth{
			Username: username,
			Password: accessToken,
		},
	})

	if err != nil {
		loggers.LoggerAPI.Error("Error while fetching artifacts from the remote repository ", err)
	}

	return repository, err

}

// pollChanges polls for changes from the remote repository
func pollChanges(conf *config.Config, repository *git.Repository){
	for {
		<- time.After(30 * time.Second)
		go compareRepository(conf, repository)
	}
}

// compareRepository compares the hashes of the local and remote repositories and pulls if there are any changes
func compareRepository(conf *config.Config, localRepository *git.Repository){

	username := conf.Adapter.SourceControl.Repository.Username
	accessToken := conf.Adapter.SourceControl.Repository.AccessToken

	remote, err := localRepository.Remote("origin")

	if err != nil{
		loggers.LoggerAPI.Error("Error while returning remote. ", err)
	}

	remoteList, err := remote.List(&git.ListOptions{
		Auth: &http.BasicAuth{
			Username: username,
			Password: accessToken,
		},
	})

	if err != nil {
		loggers.LoggerAPI.Error("Error while listing remote. ", err)
	}

	ref, err := localRepository.Head()

	if err != nil {
		loggers.LoggerAPI.Error("Error while retrieving Head. ", err)
	}

	refName := ref.Name()

	localRepositoryHash := ref.Hash().String()

	for _, r := range remoteList {
		if r.Name() == refName && !r.Hash().IsZero() && localRepositoryHash != r.Hash().String() {
			loggers.LoggerAPI.Info("Fetching changes from remote repository")
			pullChanges(conf, localRepository)

			//Redeploy changes
			err = api.ProcessMountedAPIProjects()
			if err != nil {
				loggers.LoggerAPI.Error("Local api artifacts processing has failed.")
				return
			}
		}
	}

}

// pullChanges pulls changes from the given repository
func pullChanges(conf *config.Config, localRepository *git.Repository){

	username := conf.Adapter.SourceControl.Repository.Username
	accessToken := conf.Adapter.SourceControl.Repository.AccessToken

	workTree, err := localRepository.Worktree()

	if err != nil {
		loggers.LoggerAPI.Error("Error while retrieving the worktree. ", err)
	}

	err = workTree.Pull(&git.PullOptions{
		Auth: &http.BasicAuth{
			Username: username,
			Password: accessToken,
		},
	})

	if err != nil {
		loggers.LoggerAPI.Error("Error while pulling changes from repository. ", err)
	}
}


