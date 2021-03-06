/*
* Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.wso2.appcloud.integration.test.scenarios;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.wso2.appcloud.integration.test.utils.AppCloudIntegrationTestConstants;
import org.wso2.appcloud.integration.test.utils.AppCloudIntegrationTestUtils;

public class DSSApplicationTestCase extends AppCloudIntegrationBaseTestCase {

	private static final Log log = LogFactory.getLog(DSSApplicationTestCase.class);
	public static final String DSS_SERVER_STARTED_MESSAGE = "Mgt Console URL  :";
	public static final String DSS_APPLICATION_TYPE = "wso2dataservice";

    public DSSApplicationTestCase() {
        super(AppCloudIntegrationTestUtils.getPropertyValue(AppCloudIntegrationTestConstants.DSS_APP_RUNTIME_ID_KEY),
                AppCloudIntegrationTestUtils.getPropertyValue(AppCloudIntegrationTestConstants.DSS_APP_FILE_NAME_KEY),
                DSS_APPLICATION_TYPE, AppCloudIntegrationTestUtils.getPropertyValue(AppCloudIntegrationTestConstants.
                        DSS_APP_CONTENT), Long.parseLong(AppCloudIntegrationTestUtils
                        .getPropertyValue(AppCloudIntegrationTestConstants.DSS_RUNTIME_START_TIMEOUT)));
    }

	@Override
	protected void assertLogContent(String logContent) {
        Assert.assertTrue("Received log:" + logContent + " but expected line: " + DSS_SERVER_STARTED_MESSAGE,
                logContent.contains(DSS_SERVER_STARTED_MESSAGE));
	}
}
