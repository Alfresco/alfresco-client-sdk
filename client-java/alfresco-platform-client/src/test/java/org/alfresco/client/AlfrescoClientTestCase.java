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

package org.alfresco.client;

import java.io.IOException;

import org.alfresco.client.services.content.CSClient;
import org.alfresco.client.services.process.PSClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class AlfrescoClientTestCase
{
    // ///////////////////////////////////////////////////////////////////////////
    // CONSTANTS
    // ///////////////////////////////////////////////////////////////////////////
    public static final boolean ENABLE_HTTP_LOGGING = true;

    // Endpoint must end with "/" like https://localhost:8080/alfresco/
    public static final String CS_ENDPOINT = "http://localhost:8080/alfresco/";

    public static final String CS_USERNAME = "admin";

    public static final String CS_PASSWORD = "admin";

    // Endpoint must end with "/" like https://localhost:8080/alfresco/
    public static final String PS_ENDPOINT = "http://localhost:8080/activiti-app/";

    public static final String PS_USERNAME = "admin@app.activiti.com";

    public static final String PS_PASSWORD = "admin";

    // Endpoint must end with "/" like https://localhost:8080/alfresco/
    public static final String ACTIVITI_ENDPOINT = "http://localhost:8080/activiti-rest/";

    public static final String ACTIVITI_USERNAME = "admin";

    public static final String ACTIVITI_PASSWORD = "test";

    // ///////////////////////////////////////////////////////////////////////////
    // VARIABLES
    // ///////////////////////////////////////////////////////////////////////////
    protected Logger logger = null;

    // ///////////////////////////////////////////////////////////////////////////
    // LOGGING
    // ///////////////////////////////////////////////////////////////////////////
    @BeforeClass
    public void prepareLogger() throws Exception
    {
        Class<? extends AlfrescoClientTestCase> currTestClass = getClass();
        this.logger = Logger.getLogger(currTestClass);
        String message = "Started executing class " + this.getClass().getName();
        logger.info(message);
    }

    @Test(enabled = false)
    public void createCSClientTest() throws IOException
    {
        // Connect to Alfresco CS
        AlfrescoClient client = new AlfrescoClient.Builder()
                .connectTo("http://cmis.alfresco.com", ServicesEnum.CONTENT_SERVICES).withUser("admin", "admin")
                .build();

        Assert.assertNotNull(client);
        Assert.assertNotNull(client.getContentServices());
        Assert.assertNull(client.getGovernanceServices());
        Assert.assertNull(client.getProcessServices());

        // Connect to Alfresco CS with CSClient Builder
        client = new AlfrescoClient.Builder()
                .addServiceClientBuilder(new CSClient.Builder().connect("http://cmis.alfresco.com", "admin", "admin"))
                .build();

        Assert.assertNotNull(client);
        Assert.assertNotNull(client.getContentServices());
        Assert.assertNull(client.getGovernanceServices());
        Assert.assertNull(client.getProcessServices());

        // Connect to Alfresco CS + GS
        client = new AlfrescoClient.Builder().connectTo("http://cmis.alfresco.com", ServicesEnum.CONTENT_SERVICES)
                .addService(ServicesEnum.GOVERNANCE_SERVICES).withUser("admin", "admin").build();

        Assert.assertNotNull(client);
        Assert.assertNotNull(client.getContentServices());
        Assert.assertNotNull(client.getGovernanceServices());
        Assert.assertNull(client.getProcessServices());

        // Connect to Alfresco CS + GS
        client = new AlfrescoClient.Builder().connectTo("http://cmis.alfresco.com")
                .addService(ServicesEnum.CONTENT_SERVICES).addService(ServicesEnum.GOVERNANCE_SERVICES)
                .withUser("admin", "admin").build();

        Assert.assertNotNull(client);
        Assert.assertNotNull(client.getContentServices());
        Assert.assertNotNull(client.getGovernanceServices());
        Assert.assertNull(client.getProcessServices());
    }

    @Test(enabled = false)
    public void createPSCSClientTest() throws IOException
    {
        // Connect to Alfresco CS + PS with same user
        AlfrescoClient client = new AlfrescoClient.Builder()
                .connectTo("http://cmis.alfresco.com", ServicesEnum.CONTENT_SERVICES)
                .connectTo("http://localhost:8080/activiti-app", ServicesEnum.CONTENT_SERVICES)
                .withUser("admin", "admin")
                .build();

        Assert.assertNotNull(client);
        Assert.assertNotNull(client.getContentServices());
        Assert.assertNull(client.getGovernanceServices());
        Assert.assertNotNull(client.getProcessServices());

        // Connect to Alfresco CS + PS with different user
        client = new AlfrescoClient.Builder()
                .addServiceClientBuilder(new CSClient.Builder().connect("http://cmis.alfresco.com", "admin", "admin"))
                .addServiceClientBuilder(new PSClient.Builder().connect("http://localhost:8080/activiti-app",
                        "admin@app.activiti.com", "admin"))
                .build();

        Assert.assertNotNull(client);
        Assert.assertNotNull(client.getContentServices());
        Assert.assertNull(client.getGovernanceServices());
        Assert.assertNotNull(client.getProcessServices());
    }

}