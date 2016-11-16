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
import com.alfresco.client.api.core.TrashcanAPI;
import com.alfresco.client.api.core.model.representation.DeletedNodeRepresentation;
import com.alfresco.client.api.core.model.representation.NodeRepresentation;

import retrofit2.Response;

public class TrashcanApiTest extends AlfrescoAPITestCase
{

    // ///////////////////////////////////////////////////////////////////////////
    // TESTS PREPARATION
    // ///////////////////////////////////////////////////////////////////////////
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    // ///////////////////////////////////////////////////////////////////////////
    // TESTS
    // ///////////////////////////////////////////////////////////////////////////
    @Test
    public void retrieveDeletedNodes() throws IOException
    {
        // Request All Sites
        Response<ResultPaging<DeletedNodeRepresentation>> response = client.getAPI(TrashcanAPI.class)
                .listDeletedNodesCall().execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        ResultPaging<DeletedNodeRepresentation> deletedNodeResponse = response.body();
        Assert.assertNotNull(deletedNodeResponse, "Response is empty");
        Assert.assertNotNull(deletedNodeResponse.getList(), "Response has no List");
        Assert.assertNotNull(deletedNodeResponse.getPagination(), "Response has no Pagination");

        // Check Pagination & Entries
        List<DeletedNodeRepresentation> deletedNodesRepresentation = deletedNodeResponse.getList();
        Assert.assertNotNull(deletedNodesRepresentation, "Response has no pagination");
    }

    @Test
    public void deletedNodeLifeCycleTest() throws IOException
    {
        NodesAPI nodesAPI = client.getAPI(NodesAPI.class);
        TrashcanAPI trashcanAPI = client.getAPI(TrashcanAPI.class);

        // Create a file and delete it
        NodeRepresentation dummyNode = createDummyFile();
        nodesAPI.deleteNodeCall(dummyNode.getId()).execute();

        // Retrieve it via Trashcan
        DeletedNodeRepresentation deletedNode = trashcanAPI.getDeletedNodeCall(dummyNode.getId()).execute().body();
        Assert.assertEquals(deletedNode.getId(), dummyNode.getId());
        Assert.assertNotNull(deletedNode.getArchivedAt(), "Deletednode has no archivedDate");
        Assert.assertNotNull(deletedNode.getArchivedByUser(), "Deletednode has no ArchivedByUser");

        // Check the NodesAPI
        NodeRepresentation checkNode = nodesAPI.getNodeCall(dummyNode.getId()).execute().body();
        Assert.assertNull(checkNode, "checkNode is not null");

        // Restore it via Trashcan
        NodeRepresentation restoredNode = trashcanAPI.restoreDeletedNodeCall(deletedNode.getId(), null).execute()
                .body();
        Assert.assertEquals(restoredNode.getId(), dummyNode.getId());
        checkNode = nodesAPI.getNodeCall(dummyNode.getId()).execute().body();
        Assert.assertEquals(restoredNode.getId(), checkNode.getId());

        // Delete It and purge it
        nodesAPI.deleteNodeCall(restoredNode.getId()).execute().body();
        deletedNode = trashcanAPI.getDeletedNodeCall(deletedNode.getId()).execute().body();
        Assert.assertEquals(deletedNode.getId(), dummyNode.getId());
        trashcanAPI.purgeDeletedNodeCall(deletedNode.getId()).execute().body();

        checkNode = nodesAPI.getNodeCall(dummyNode.getId()).execute().body();
        Assert.assertNull(checkNode, "checkNode is not null");

        deletedNode = trashcanAPI.getDeletedNodeCall(dummyNode.getId()).execute().body();
        Assert.assertNull(deletedNode, "deletedNode is not null");

    }

}
