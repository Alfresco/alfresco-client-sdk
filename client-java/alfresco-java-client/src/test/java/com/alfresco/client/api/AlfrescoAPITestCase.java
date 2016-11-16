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

package com.alfresco.client.api;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.log4testng.Logger;

import com.alfresco.client.AlfrescoClient;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.NodesAPI;
import com.alfresco.client.api.core.model.body.NodeBodyCreate;
import com.alfresco.client.api.core.model.representation.NodeRepresentation;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
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

    protected AlfrescoClient client;

    protected File tmpFolder;

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
    // ALFRESCO CLIENT UTILS
    // ///////////////////////////////////////////////////////////////////////////
    public void prepareDefaultClient()
    {
        client = new AlfrescoClient.Builder().connect("http://cmis.alfresco.com/", "admin", "admin")
                .httpLogging(HttpLoggingInterceptor.Level.BODY).build();
    }

    public AlfrescoClient prepareClient(String endpoint, String username, String password)
    {
        return new AlfrescoClient.Builder().connect(endpoint, username, password)
                .httpLogging(HttpLoggingInterceptor.Level.BODY).build();
    }

    // TODO Design it better.
    public AlfrescoClient prepareClientTicket(String endpoint, String ticket)
    {
        return new AlfrescoClient.Builder().connectWithTicket(endpoint, ticket)
                .httpLogging(HttpLoggingInterceptor.Level.BODY).build();
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
    // DUMMY NODES
    // ///////////////////////////////////////////////////////////////////////////
    public static final String DUMMY_TXT_NAME = "dummy.txt";

    public static final String TEST_FOLDER_NAME = "Test";

    public NodeRepresentation createDummyFile() throws IOException
    {

        NodesAPI nodeService = client.getAPI(NodesAPI.class);

        // Create Test Folder
        NodeBodyCreate request = new NodeBodyCreate(TEST_FOLDER_NAME, "cm:folder");
        Response<NodeRepresentation> testNodeResponse = nodeService.createNodeCall(NodesAPI.FOLDER_MY, request)
                .execute();

        // If Folder already exist it's a failure so we delete & recreate
        if (!testNodeResponse.isSuccessful())
        {
            ResultPaging<NodeRepresentation> nodeResponse = nodeService
                    .listNodeChildrenCall(NodesAPI.FOLDER_MY, 0, 25, null, "(isFolder=true)", null, null, null, null)
                    .execute().body();
            for (NodeRepresentation folder : nodeResponse.getList())
            {
                if (TEST_FOLDER_NAME.equals(folder.getName()))
                {
                    nodeService.deleteNodeCall(folder.getId()).execute();
                }
            }
            testNodeResponse = nodeService.createNodeCall(NodesAPI.FOLDER_MY, request).execute();
        }

        NodeRepresentation testFolder = testNodeResponse.body();

        // Check if test file is present
        checkResourceFile("/com/alfresco/client/api/tests/test.txt");

        // Create Body
        File file = getResourceFile("/com/alfresco/client/api/tests/test.txt");
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filename", DUMMY_TXT_NAME, requestBody);
        RequestBody fileRequestBody = multipartBuilder.build();

        // Let's Create
        Response<NodeRepresentation> createdNodeResponse = nodeService
                .createNodeCall(testFolder.getId(), fileRequestBody).execute();

        if (!createdNodeResponse.isSuccessful())
        {
            Response<ResultPaging<NodeRepresentation>> nodeResponse = nodeService
                    .listNodeChildrenCall(NodesAPI.FOLDER_MY, 0, 1, null, "(isFile=true)", null, null, null, null)
                    .execute();
            if (nodeResponse.body().getCount() == 1
                    && DUMMY_TXT_NAME.equals(nodeResponse.body().getList().get(0).getName()))
            {
                nodeService.deleteNodeCall(nodeResponse.body().getList().get(0).getId()).execute();
                createdNodeResponse = nodeService.createNodeCall(NodesAPI.FOLDER_MY, fileRequestBody).execute();
            }
        }

        return createdNodeResponse.body();
    }

}