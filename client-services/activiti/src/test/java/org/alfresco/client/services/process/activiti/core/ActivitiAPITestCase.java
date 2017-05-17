/*
 *  Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *  This file is part of Alfresco Activiti Client.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.alfresco.client.services.process.activiti.core;

import org.alfresco.client.services.AlfrescoAPITestCase;
import org.alfresco.client.services.process.activiti.ActivitiClient;
import org.alfresco.client.services.process.activiti.core.model.representation.ProcessEngineInfoResponse;

import okhttp3.logging.HttpLoggingInterceptor;

public abstract class ActivitiAPITestCase extends AlfrescoAPITestCase
{
    // ///////////////////////////////////////////////////////////////////////////
    // CONSTANTS
    // ///////////////////////////////////////////////////////////////////////////
    // Endpoint must end with "/" like
    // https://activiti.alfresco.com/activiti-app/
    public static final String TEST_ENDPOINT = "http://localhost:8080/activiti-rest/";

    public static final String TEST_USERNAME = "kermit";

    public static final String TEST_PASSWORD = "kermit";

    public static final String TEST_FIRST_NAME = "Kermit";

    public static final String TEST_LAST_NAME = "The Frog";

    public static final String TEST_EMAIL = "kermit@activiti.org";

    public static final String TEST_PICTURE_URL = null;

    public static final String TEST_ENDPOINT_V6 = "http://localhost:8080/activiti-rest/";

    public static final String TEST_USERNAME_V6 = "admin";

    public static final String TEST_PASSWORD_V6 = "password";

    // ///////////////////////////////////////////////////////////////////////////
    // VARIABLES
    // ///////////////////////////////////////////////////////////////////////////
    protected ActivitiClient client;

    // ///////////////////////////////////////////////////////////////////////////
    // ALFRESCO CLIENT UTILS
    // ///////////////////////////////////////////////////////////////////////////
    public void prepareDefaultClient()
    {
        client = new ActivitiClient.Builder().connect(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD)
                .httpLogging(HttpLoggingInterceptor.Level.BODY).build();
    }

    public ActivitiClient prepareClient(String endpoint, String username, String password)
    {
        return new ActivitiClient.Builder().connect(endpoint, username, password)
                .httpLogging(HttpLoggingInterceptor.Level.BODY).build();
    }

    // ///////////////////////////////////////////////////////////////////////////
    // Check Activiti Version
    // ///////////////////////////////////////////////////////////////////////////
    public boolean isActiviti6()
    {
        try
        {
            ProcessEngineInfoResponse info = client.getEngineAPI().getEngineInfoCall().execute().body();
            if (info.getVersion().startsWith("6"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }

}