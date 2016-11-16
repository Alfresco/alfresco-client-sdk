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

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alfresco.client.api.AlfrescoAPITestCase;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.NodesAPI;
import com.alfresco.client.api.core.TagsAPI;
import com.alfresco.client.api.core.model.body.TagBody;
import com.alfresco.client.api.core.model.representation.NodeRepresentation;
import com.alfresco.client.api.core.model.representation.TagRepresentation;

import retrofit2.Response;

public class TagApiTest extends AlfrescoAPITestCase
{

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test(enabled = false)
    public void retrieveTags() throws IOException
    {
        // Request All Sites
        Response<ResultPaging<TagRepresentation>> response = client.getAPI(TagsAPI.class)
                .listTagsForNodeCall("0cbd8c7e-7c1c-4077-92bf-dc944a2484f9").execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        ResultPaging<TagRepresentation> tagsResponse = response.body();
        Assert.assertNotNull(tagsResponse, "Response is empty");
        Assert.assertNotNull(tagsResponse.getList(), "Response has no listActivitiesForPersonCall of tags");
        Assert.assertNotNull(tagsResponse.getPagination(), "Response has no listActivitiesForPersonCall of tags");

        // Check Pagination & Entries
        List<TagRepresentation> tagRepresentation = tagsResponse.getList();
        Assert.assertNotNull(tagRepresentation, "Response has no pagination");

    }

    // No way to delete tag globally
    // Need to delete nodes associated
    @Test(enabled = false)
    public void tagLifeCycleTest() throws IOException, InterruptedException
    {
        NodesAPI nodesAPI = client.getAPI(NodesAPI.class);
        TagsAPI tagAPI = client.getAPI(TagsAPI.class);

        // Create a file and check no tag applied
        NodeRepresentation dummyNode = createDummyFile();
        Response<ResultPaging<TagRepresentation>> response = tagAPI.listTagsForNodeCall(dummyNode.getId()).execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);
        Assert.assertEquals(response.body().getCount(), 0, "Listing contains one+ tag");

        // Add and remove one tag
        TagBody request = new TagBody("test");

        Response<TagRepresentation> responseTag = tagAPI.createTagForNodeCall(dummyNode.getId(), request, null)
                .execute();
        Assert.assertNotNull(responseTag);
        Assert.assertEquals(responseTag.isSuccessful(), true);
        TagRepresentation tag = responseTag.body();
        Assert.assertEquals(tag.getTag(), "test", "Tag value is empty");
        Assert.assertNotNull(tag.getId(), "Id is empty");

        response = tagAPI.listTagsForNodeCall(dummyNode.getId()).execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);
        Assert.assertEquals(response.body().getCount(), 1, "Listing doesn't contain only one tag");

        tagAPI.deleteTagFromNodeCall(dummyNode.getId(), responseTag.body().getId()).execute();
        response = tagAPI.listTagsForNodeCall(dummyNode.getId()).execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);
        Assert.assertEquals(response.body().getCount(), 0, "Listing contains one+ tag");

        // Add multiple tags
        TagBody[] tags = { request, new TagBody("test2"), new TagBody("test3") };
        Response<ResultPaging<TagRepresentation>> responseTags = tagAPI
                .createTagsForNodeCall(dummyNode.getId(), tags, null)
                .execute();
        Assert.assertEquals(responseTags.isSuccessful(), true);
        Assert.assertEquals(responseTags.body().getCount(), 3);

        response = tagAPI.listTagsForNodeCall(dummyNode.getId()).execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);
        Assert.assertEquals(response.body().getCount(), 3, "Listing doesn't contain only one tag");
        List<TagRepresentation> testTags = response.body().getList();
        for (TagRepresentation tagRepresentation : testTags)
        {
            Assert.assertTrue(tagRepresentation.getTag().startsWith("test"));
        }

        // List all Tags
        ResultPaging<TagRepresentation> allTags = tagAPI.listTagsCall().execute().body();
        Assert.assertEquals(allTags.getCount(), 3);

        // Lets change Tag
        TagBody updateRequest = new TagBody("test5");
        for (TagRepresentation tagToUpdate : testTags)
        {
            TagRepresentation tempTag = tagAPI.updateTagCall(tagToUpdate.getId(), updateRequest, null).execute().body();
            // Assert.assertEquals(tempTag.getId(), tagToUpdate.getId());
            Assert.assertEquals(tempTag.getTag(), "test5");
        }

        // List all Tags
        allTags = tagAPI.listTagsCall().execute().body();
        Assert.assertEquals(allTags.getCount(), 0);

        // Clean Up
        nodesAPI.deleteNodeCall(dummyNode.getId()).execute();

    }
}
