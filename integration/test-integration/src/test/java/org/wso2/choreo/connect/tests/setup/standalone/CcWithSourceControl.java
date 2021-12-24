/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.choreo.connect.tests.setup.standalone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.wso2.choreo.connect.tests.context.CCTestException;
import org.wso2.choreo.connect.tests.context.CcInstance;
import org.wso2.choreo.connect.tests.util.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class CcWithSourceControl {
    private static final Logger log = LoggerFactory.getLogger(CcWithSourceControl.class);

    CcInstance ccInstance;
    CcInstance gitInstance;

    private String accessToken = "";

    @BeforeTest(description = "initialise the setup")
    void start() throws Exception {
        setupGitInstance();
        startCcInstance();

        ApictlUtils.addEnv("test");
        ApictlUtils.login("test");

        TimeUnit.SECONDS.sleep(5);
    }

    private void startCcInstance() throws Exception {
        ccInstance = new CcInstance.Builder()
                .withNewDockerCompose("cc-with-git-network-docker-compose.yaml")
                .withNewConfig("cc-with-source-control.toml")
                .withBackendServiceFile("cc-git-backend-service.yaml")
                .build();
        ccInstance.start();
    }

    private void startGitInstance() throws Exception {
        gitInstance = new CcInstance.Builder()
                .withNewDockerCompose("cc-with-source-control-docker-compose.yaml")
                .buildContainer();
        log.info("Starting Git instance");
        gitInstance.startContainer();

        // Sleep until the container is healthy
        TimeUnit.MINUTES.sleep(4);
    }

    private void setupGitInstance() throws Exception{
        startGitInstance();
        log.info("Started Git instance");
        accessToken = SourceControlUtils.getAccessToken(SourceControlUtils.GIT_USERNAME, SourceControlUtils.GIT_PASSWORD);
        SourceControlUtils.testGitStatus(accessToken);
        SourceControlUtils.createProject(accessToken, SourceControlUtils.GIT_PROJECT_NAME, SourceControlUtils.GIT_PROJECT_PATH);
        SourceControlUtils.commitFiles(Utils.getTargetDirPath() + TestConstant.TEST_RESOURCES_PATH + SourceControlUtils.ARTIFACTS_DIR, SourceControlUtils.GIT_USERNAME, SourceControlUtils.GIT_PROJECT_PATH, SourceControlUtils.GIT_PROJECT_BRANCH, "Initial Commit", accessToken);
        TimeUnit.MINUTES.sleep(1);
    }

    @AfterTest(description = "stop the setup")
    void stop() throws CCTestException {
        ccInstance.stop();
        gitInstance.stop();
        ApictlUtils.removeEnv("test");
        Utils.deleteFolder(new File(SourceControlUtils.GIT_DIRECTORY));
    }

}
