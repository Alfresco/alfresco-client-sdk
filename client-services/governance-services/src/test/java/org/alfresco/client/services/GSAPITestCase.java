/*
 *   Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *   This file is part of Alfresco Java Client.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.alfresco.client.services;

import org.alfresco.client.services.governance.GSClient;

import okhttp3.logging.HttpLoggingInterceptor;

public abstract class GSAPITestCase extends AlfrescoAPITestCase
{
    // ///////////////////////////////////////////////////////////////////////////
    // CONSTANTS
    // ///////////////////////////////////////////////////////////////////////////

    // ///////////////////////////////////////////////////////////////////////////
    // VARIABLES
    // ///////////////////////////////////////////////////////////////////////////
    protected GSClient client;

    // ///////////////////////////////////////////////////////////////////////////
    // ALFRESCO CLIENT UTILS
    // ///////////////////////////////////////////////////////////////////////////
    public void prepareDefaultClient()
    {
        client = new GSClient.Builder().connect("http://cmis.alfresco.com/", "admin", "admin")
                .httpLogging(HttpLoggingInterceptor.Level.BODY).build();
    }

    public GSClient prepareClient(String endpoint, String username, String password)
    {
        return new GSClient.Builder().connect(endpoint, username, password)
                .httpLogging(HttpLoggingInterceptor.Level.BODY).build();
    }

    // TODO Design it better.
    public GSClient prepareClientTicket(String endpoint, String ticket)
    {
        return new GSClient.Builder().connectWithTicket(endpoint, ticket).httpLogging(HttpLoggingInterceptor.Level.BODY)
                .build();
    }
}