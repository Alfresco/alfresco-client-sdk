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

package com.alfresco.client.api.tests.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.alfresco.client.api.AlfrescoAPITestCase;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.NodesAPI;
import com.alfresco.client.api.core.SharedLinksAPI;
import com.alfresco.client.api.core.model.body.SharedLinkBodyCreate;
import com.alfresco.client.api.core.model.representation.NodeRepresentation;
import com.alfresco.client.api.core.model.representation.SharedLinkRepresentation;
import com.alfresco.client.api.tests.utils.IOUtils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class SharedLinkTest extends AlfrescoAPITestCase
{

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @BeforeMethod
    public void createLocalTmpFolder()
    {
        try
        {
            tmpFolder = Files.createTempDirectory("AlfrescoApiTests").toFile();
            tmpFolder.deleteOnExit();
        }
        catch (Exception e)
        {

        }
    }

    @AfterMethod
    public void cleanLocalTmpFolder()
    {
        tmpFolder.delete();
    }

    @Test
    public void retrieveSharedLinks() throws IOException
    {
        // Request All Sites
        Response<ResultPaging<SharedLinkRepresentation>> response = client.getAPI(SharedLinksAPI.class)
                .listSharedLinksCall().execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        ResultPaging<SharedLinkRepresentation> tagsResponse = response.body();
        Assert.assertNotNull(tagsResponse, "Response is empty");
        Assert.assertNotNull(tagsResponse.getList(), "Response has no listActivitiesForPersonCall of tags");
        Assert.assertNotNull(tagsResponse.getPagination(), "Response has no listActivitiesForPersonCall of tags");

        // Check Pagination & Entries
        List<SharedLinkRepresentation> tagRepresentation = tagsResponse.getList();
        Assert.assertNotNull(tagRepresentation, "Response has no pagination");

    }

    @Test
    public void sharedLinkLifeCycleTest() throws IOException, InterruptedException
    {
        NodesAPI nodesAPI = client.getAPI(NodesAPI.class);
        SharedLinksAPI sharedLinkAPI = client.getAPI(SharedLinksAPI.class);

        // Create a file & check theres no links
        NodeRepresentation dummyNode = createDummyFile();
        Response<ResultPaging<SharedLinkRepresentation>> response = sharedLinkAPI.listSharedLinksCall().execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);
        Assert.assertEquals(response.body().getCount(), 0, "Listing contains at least one shared Link");

        // Add and remove one shared link
        SharedLinkBodyCreate request = new SharedLinkBodyCreate(dummyNode.getId());

        Response<SharedLinkRepresentation> responseLink = sharedLinkAPI.createSharedLinkCall(request).execute();
        Assert.assertNotNull(responseLink);
        Assert.assertEquals(responseLink.isSuccessful(), true);
        SharedLinkRepresentation link = responseLink.body();
        Assert.assertEquals(link.getName(), dummyNode.getName(), "Tag value is empty");
        Assert.assertNotNull(link.getId(), "Id is empty");

        // Retrieve by its Id
        responseLink = sharedLinkAPI.getSharedLinkCall(link.getId()).execute();
        Assert.assertNotNull(responseLink);
        Assert.assertEquals(responseLink.isSuccessful(), true);
        Assert.assertEquals(responseLink.body().getId(), link.getId(), "IDs are different");

        for (int i = 0; i < 5; i++)
        {
            // Creating sharedLink might takes time so we have to wait few
            // moments
            Thread.sleep(5000);

            // Retrieve by its Id
            response = sharedLinkAPI.listSharedLinksCall().execute();
            Assert.assertNotNull(response);
            Assert.assertEquals(response.isSuccessful(), true);

            if (response.body().getCount() == 1)
            {
                break;
            }

            if (i == 5)
            {
                Assert.fail("Unable to retrieve sharedLink even after waiting");
            }
        }
        Assert.assertEquals(response.body().getCount(), 1, "Listing doesn't contain only one tag");

        // Download Content
        Call<ResponseBody> downloadCall = sharedLinkAPI.getSharedLinkContentCall(link.getId());
        File dlFile = new File(tmpFolder, "dl.txt");
        IOUtils.copyFile(downloadCall.execute().body().byteStream(), dlFile);

        Assert.assertTrue(dlFile.exists());
        Assert.assertEquals(12, dlFile.length());

        // Remove Shared Link & Check
        sharedLinkAPI.deleteSharedLinkCall(link.getId()).execute();

        for (int i = 0; i < 5; i++)
        {
            // Deleting sharedLink might takes time so we have to wait few
            // moments
            Thread.sleep(5000);

            // Retrieve by its Id
            response = sharedLinkAPI.listSharedLinksCall().execute();
            Assert.assertNotNull(response);
            Assert.assertEquals(response.isSuccessful(), true);

            if (response.body().getCount() == 0)
            {
                break;
            }

            if (i == 5)
            {
                Assert.fail("Unable to retrieve sharedLink even after waiting");
            }
        }

        response = sharedLinkAPI.listSharedLinksCall().execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);
        Assert.assertEquals(response.body().getCount(), 0, "Listing contains one+ tag");

        // Clean Up
        nodesAPI.deleteNodeCall(dummyNode.getId()).execute();
    }
}
