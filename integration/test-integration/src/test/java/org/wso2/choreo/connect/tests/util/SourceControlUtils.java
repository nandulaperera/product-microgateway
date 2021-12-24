/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org).
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.choreo.connect.tests.util;

import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus;
import com.google.common.net.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SourceControlUtils {

    private static final Logger log = LoggerFactory.getLogger(SourceControlUtils.class);

    public static final String GIT_URL = "http://localhost";
    public static final String GIT_API_URL = "http://localhost/api/v4";
    public static final String ARTIFACTS_DIR = File.separator + "artifacts";
    public static final String GIT_USERNAME = "root";
    public static final String GIT_PASSWORD = "svcAdmin";
    public static final String GIT_PROJECT_NAME = "testProject";
    public static final String GIT_PROJECT_PATH = "testProject";
    public static final String GIT_PROJECT_BRANCH = "main";
    public static final String GIT_DIRECTORY = "/srv/gitlab";

    /**
     * Get an access token for invoking the Gitlab REST API
     *
     * @param username      Username of the Git user
     * @param password      Password of the Git user
     * @return              Access token required to invoke the Gitlab REST API
     * @throws IOException  If an error occurs while sending the POST request
     */
    public static String getAccessToken(String username, String password) throws IOException {
        String postBody = "grant_type=password&username=" + username + "&password=" + password;
        Map<String, String> headers = new HashMap<String, String>(0);
        HttpResponse response = HttpClientRequest.doPost(GIT_URL + "/oauth/token", postBody, headers);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getResponseCode(), HttpStatus.SC_OK);
        JSONObject tokenDataObject = new JSONObject(response.getData());
        return tokenDataObject.getString("access_token");
    }

    /**
     * Test the status of the Gitlab REST API with the accessToken - To be used before invoking the Gitlab REST API
     *
     * @param accessToken   Access token required to invoke the Gitlab REST API
     * @throws IOException  If an error occurs while sending the GET request
     */
    public static void testGitStatus(String accessToken) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        HttpResponse response = HttpClientRequest.doGet(GIT_API_URL + "/projects", headers);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getResponseCode(), HttpStatus.SC_OK);
        log.info("REST API invoked successfully");
    }

    /**
     * Create a new Gitlab project owned by the authenticated user
     *
     * @param accessToken   Access token required to invoke the Gitlab REST API
     * @param projectName   Name of the new project
     * @param projectPath   Repository name for the new project
     * @throws IOException  If an error occurs while sending the POST request
     */
    public static void createProject(String accessToken, String projectName, String projectPath) throws IOException {
        String postBody = "name=" + projectName + "&path=" + projectPath;
        Map<String, String> headers = new HashMap<>();
        headers.put(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        HttpResponse response = HttpClientRequest.doPost(GIT_API_URL + "/projects", postBody, headers);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getResponseCode(), HttpStatus.SC_CREATED);
        log.info("New project created at " + GIT_URL + "/root/" + projectPath + ".git");
    }

    /**
     * Commits files to the given Gitlab repository
     *
     * @param artifactsDirectoryPath    Path of the artifacts directory
     * @param username              Username of the Git user
     * @param projectPath           Repository name for the new project
     * @param branchName            Name of the branch to commit into
     * @param commitMessage         Commit Message
     * @param accessToken           Access token required to invoke the Gitlab REST API
     * @throws Exception
     */
    public static void commitFiles(String artifactsDirectoryPath, String username, String projectPath, String branchName, String commitMessage, String accessToken) throws Exception{
        JSONObject payload = new JSONObject();

        JSONArray actions = new JSONArray();
        File artifactsDir = new File(artifactsDirectoryPath);
        readArtifactsDirectory(artifactsDir, artifactsDirectoryPath, actions);

        payload.put("branch", branchName);
        payload.put("commit_message", commitMessage);
        payload.put("actions", actions);
        String payloadString = payload.toString();

        Map<String, String> headers = new HashMap<>();
        headers.put(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        headers.put("Content-Type", "application/json");

        HttpResponse response = HttpClientRequest.doPost(GIT_API_URL + "/projects/" + username + "%2F" + projectPath + "/repository/commits", payloadString, headers);

        Assert.assertNotNull(response);
        Assert.assertEquals(response.getResponseCode(), HttpStatus.SC_CREATED);

        log.info("Artifacts committed to Git repository successfully");
    }

    /**
     * Reads the given directory
     *
     * @param directory                Path of the directory
     * @param baseDirectory            Path of the base directory (artifacts directory)
     * @param actions                  JSON Array of actions for committing the files to the repository
     * @throws FileNotFoundException   If an error occurs when reading the directory
     */
    public static void readArtifactsDirectory(File directory, String baseDirectory, JSONArray actions) throws FileNotFoundException {
        File[] files = directory.listFiles();
        for (File file : files){
            if(file.isDirectory()){
                readArtifactsDirectory(file, baseDirectory, actions);
            } else {
                String content = readFile(file);
                String filePath = file.getPath().replace(baseDirectory, ".");
                JSONObject action = new JSONObject();
                action.put("action", "create");
                action.put("file_path", filePath);
                action.put("content", content);
                actions.put(action);
            }
        }
    }

    /**
     * Reads the content of the given file
     *
     * @param file
     * @return                          The content of the file
     * @throws FileNotFoundException    If any error occurs when reading the file
     */
    public static String readFile(File file) throws FileNotFoundException {
        String line = "";
        Scanner sc = new Scanner(file);
        StringBuffer buffer = new StringBuffer();
        while(sc.hasNextLine()){
            line = sc.nextLine();
            buffer.append(line + "\n");
        }
        return buffer.toString();
    }
}
