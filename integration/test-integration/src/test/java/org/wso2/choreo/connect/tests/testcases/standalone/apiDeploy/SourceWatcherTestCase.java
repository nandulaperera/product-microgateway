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

package org.wso2.choreo.connect.tests.testcases.standalone.apiDeploy;

import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus;
import io.netty.handler.codec.http.HttpHeaderNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.choreo.connect.tests.util.*;

import java.util.HashMap;
import java.util.Map;

public class SourceWatcherTestCase {

    private static final Logger log = LoggerFactory.getLogger(SourceWatcherTestCase.class);
    protected String jwtToken;

    @BeforeClass(description = "Initialize the setup")
    void start() throws Exception{
        jwtToken = TokenUtil.getJwtForPetstore(TestConstant.KEY_TYPE_PRODUCTION, "read:pets",
                false);
    }

    @Test(description = "Test if artifacts from source version control are deployed")
    public void SourceWatcherTest() throws Exception{
        Map<String, String> headers = new HashMap<>();
        headers.put(HttpHeaderNames.AUTHORIZATION.toString(), "Bearer " + jwtToken);
        HttpResponse response = HttpsClientRequest.doGet(Utils.getServiceURLHttps("/v2/pet/findByStatus?status=available") , headers);

        Assert.assertNotNull(response);
        Assert.assertEquals(response.getResponseCode(), HttpStatus.SC_OK,"Response code mismatched");
    }

}
