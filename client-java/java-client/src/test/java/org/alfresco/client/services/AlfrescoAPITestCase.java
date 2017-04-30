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

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.log4testng.Logger;

import retrofit2.Response;

public abstract class AlfrescoAPITestCase
{
    // ///////////////////////////////////////////////////////////////////////////
    // CONSTANTS
    // ///////////////////////////////////////////////////////////////////////////
    public static final boolean ENABLE_HTTP_LOGGING = true;

    // Endpoint must end with "/" like https://localhost:8080/alfresco/
    public static final String TEST_ENDPOINT = "http://localhost:8080/alfresco/";

    public static final String TEST_USERNAME = "admin";

    public static final String TEST_PASSWORD = "admin";

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
        Class<? extends AlfrescoAPITestCase> currTestClass = getClass();
        this.logger = Logger.getLogger(currTestClass);
        String message = "Started executing class " + this.getClass().getName();
        logger.info(message);
    }

    // ///////////////////////////////////////////////////////////////////////////
    // FILE MANAGEMENT
    // ///////////////////////////////////////////////////////////////////////////
    public void checkResourceFile(String path)
    {
        Assert.assertNotNull(getClass().getResource(path), "Resource file missing : " + path);
    }

    public File getResourceFile(String path)
    {
        return new File(getClass().getResource(path).getFile());
    }

    // ///////////////////////////////////////////////////////////////////////////
    // RESPONSE CHECK
    // ///////////////////////////////////////////////////////////////////////////
    public void hasSuceedReponse(Response response)
    {
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true, response.message());
    }
}