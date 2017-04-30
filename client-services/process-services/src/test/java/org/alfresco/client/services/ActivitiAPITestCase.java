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

package org.alfresco.client.services;

import org.alfresco.client.services.process.PSClient;

import okhttp3.logging.HttpLoggingInterceptor;

public abstract class ActivitiAPITestCase extends AlfrescoAPITestCase
{
    // ///////////////////////////////////////////////////////////////////////////
    // CONSTANTS
    // ///////////////////////////////////////////////////////////////////////////
    // Endpoint must end with "/" like
    // https://activiti.alfresco.com/activiti-app/
    public static final String TEST_ENDPOINT = "http://localhost:8080/activiti-app/";

    public static final String TEST_USERNAME = "admin@app.activiti.com";

    public static final String TEST_PASSWORD = "admin";

    // ///////////////////////////////////////////////////////////////////////////
    // VARIABLES
    // ///////////////////////////////////////////////////////////////////////////
    protected PSClient client;

    // ///////////////////////////////////////////////////////////////////////////
    // ALFRESCO CLIENT UTILS
    // ///////////////////////////////////////////////////////////////////////////
    public void prepareDefaultClient()
    {
        client = new PSClient.Builder().connect(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD)
                .httpLogging(HttpLoggingInterceptor.Level.BODY).build();
    }

    public PSClient prepareClient(String endpoint, String username, String password)
    {
        return new PSClient.Builder().connect(endpoint, username, password)
                .httpLogging(HttpLoggingInterceptor.Level.BODY).build();
    }

}