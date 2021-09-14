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

package org.wso2.choreo.connect.enforcer.security.jwt;

import org.wso2.choreo.connect.enforcer.constants.APIConstants;
import org.wso2.choreo.connect.enforcer.constants.GeneralErrorCodeConstants;
import org.wso2.choreo.connect.enforcer.exception.APISecurityException;
import org.wso2.choreo.connect.enforcer.models.API;
import org.wso2.choreo.connect.enforcer.security.Authenticator;
import org.wso2.choreo.connect.enforcer.subscription.SubscriptionDataHolder;
import org.wso2.choreo.connect.enforcer.subscription.SubscriptionDataStore;
import org.wso2.choreo.connect.enforcer.util.FilterUtils;
import org.wso2.choreo.connect.filter.model.AuthenticationContext;
import org.wso2.choreo.connect.filter.model.RequestContext;
import org.wso2.choreo.connect.filter.model.ResourceConfig;

/**
 * Implements the authenticator interface to authenticate non-secured APIs.
 */

public class UnsecuredAPIAuthenticator implements Authenticator {

    @Override
    public boolean canAuthenticate(RequestContext requestContext) {
        // Retrieve the disable security value. If security is disabled, then you can proceed directly with the
        // authentication.
        if (isDisableSecurity(requestContext.getMatchedResourcePath())) {
            return true;
        }
        return false;
    }

    @Override
    public AuthenticationContext authenticate(RequestContext requestContext) throws APISecurityException {
        String uuid = requestContext.getMatchedAPI().getUuid();
        String context = requestContext.getMatchedAPI().getBasePath();
        String apiTenantDomain = FilterUtils.getTenantDomainFromRequestURL(context);
        SubscriptionDataStore datastore = SubscriptionDataHolder.getInstance()
                .getTenantSubscriptionStore(apiTenantDomain);
        API api = datastore.getApiByContextAndVersion(uuid);
        if (api != null && APIConstants.LifecycleStatus.BLOCKED.equals(api.getLcState())) {
            requestContext.getProperties()
                    .put(APIConstants.MessageFormat.ERROR_MESSAGE, GeneralErrorCodeConstants.API_BLOCKED_MESSAGE);
            requestContext.getProperties().put(APIConstants.MessageFormat.ERROR_DESCRIPTION,
                    GeneralErrorCodeConstants.API_BLOCKED_DESCRIPTION);
            throw new APISecurityException(APIConstants.StatusCodes.SERVICE_UNAVAILABLE.getCode(),
                    GeneralErrorCodeConstants.API_BLOCKED_CODE, GeneralErrorCodeConstants.API_BLOCKED_MESSAGE);
        }
        return FilterUtils.generateAuthenticationContext(requestContext);
    }

    @Override
    public String getChallengeString() {
        return "";
    }

    @Override public int getPriority() {
        return -20;
    }

    /**
     * This method retrieve the proper auth type for the given request context.
     * AuthType can be deduced from API level and resource level. If both are defined,
     * resource level gets the precedence.
     * If nothing declared, it will return the authType as "default".
     * @param matchingResource matching resource related configurations
     * @return value of the authType from API definition. If not present "default"
     */
    private boolean isDisableSecurity(ResourceConfig matchingResource) {

        return matchingResource.isDisableSecurity();
    }
}
