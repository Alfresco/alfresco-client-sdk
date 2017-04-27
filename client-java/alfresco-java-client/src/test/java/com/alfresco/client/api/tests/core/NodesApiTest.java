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
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.alfresco.client.api.AlfrescoAPITestCase;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.NodesAPI;
import com.alfresco.client.api.core.model.body.*;
import com.alfresco.client.api.core.model.representation.AssociationInfoRepresentation;
import com.alfresco.client.api.core.model.representation.NodeRepresentation;
import com.alfresco.client.api.tests.utils.IOUtils;
import com.alfresco.client.api.tests.utils.NodeRefUtils;
import com.google.gson.internal.LinkedTreeMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class NodesApiTest extends AlfrescoAPITestCase
{
    // ///////////////////////////////////////////////////////////////////////////
    // CONSTANTS
    // ///////////////////////////////////////////////////////////////////////////
    public static final String USERID_SYSTEM = "System";

    public static final String USERID_ADMIN = "admin";

    public static final String USER_DISPLAY_ADMIN = "Administrator";

    public static final ArrayList<String> DEFAULT_FOLDER_ASPECTS = new ArrayList<String>(3)
    {
        {
            add("cm:titled");
            add("cm:auditable");
            add("app:uifacets");
        }
    };

    public static final ArrayList<String> DEFAULT_FILE_ASPECTS = new ArrayList<String>(3)
    {
        {
            add("cm:titled");
            add("cm:auditable");
            add("app:uifacets");
            add("cm:versionable");
            add("cm:author");
        }
    };

    // ///////////////////////////////////////////////////////////////////////////
    // TESTS PREPARATION
    // ///////////////////////////////////////////////////////////////////////////
    @BeforeClass
    public void prepare() throws Exception
    {
        // Start from a vanilla server installation
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

    // ///////////////////////////////////////////////////////////////////////////
    // TESTS
    // ///////////////////////////////////////////////////////////////////////////
    @Test
    public void nodeAPITests() throws IOException
    {
        // Create Node API
        NodesAPI nodeService = client.getAPI(NodesAPI.class);

        // Request Node By Id
        Response<NodeRepresentation> response = nodeService.getNodeCall(NodesAPI.FOLDER_ROOT).execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        NodeRepresentation nodeResponse = response.body();
        Assert.assertNotNull(nodeResponse, "Response is empty");
        Assert.assertNotNull(nodeResponse, "Response has no data");

        // Check Node Info
        NodeRepresentation rootNode = nodeResponse;
        Assert.assertTrue(rootNode.isFolder(), "Root Folder is not a Folder ??");
        Assert.assertEquals(rootNode.getName(), "Company Home", "Root Folder is not Company Home");
        Assert.assertEquals(rootNode.getNodeType(), "cm:folder", "Root Folder is not a Folder ??");
        Assert.assertNotNull(rootNode.getId(), "Node Identifier is empty");
        Assert.assertTrue(NodeRefUtils.isIdentifier(rootNode.getId()), "Node Identifier is not an identifier");
        Assert.assertNull(rootNode.getParentId(), "Company Home has a Parent ?");

        // Aspects
        Assert.assertFalse(rootNode.getAspects().isEmpty(), "Root Folder is not a Folder ??");
        Assert.assertEquals(rootNode.getAspects().size(), 3, "Root folder has more aspects");
        for (String aspect : rootNode.getAspects())
        {
            Assert.assertTrue(DEFAULT_FOLDER_ASPECTS.contains(aspect), aspect + "is not a default aspect");
        }

        // CreatedAt & ModifiedAt
        Assert.assertNotNull(rootNode.getCreatedAt(), "createdAt is empty");
        Assert.assertNotNull(rootNode.getModifiedAt(), "modifiedAt is empty");

        // createdByUser & modifiedByUser
        Assert.assertNotNull(rootNode.getCreatedByUser(), "createdByUser is empty");
        Assert.assertNotNull(rootNode.getModifiedByUser(), "modifiedByUser is empty");
        if (USERID_SYSTEM.equals(rootNode.getModifiedByUser().getDisplayName()))
        {
            Assert.assertEquals(rootNode.getModifiedByUser().getDisplayName(), USERID_SYSTEM);
            Assert.assertEquals(rootNode.getModifiedByUser().getId(), null);
            Assert.assertEquals(rootNode.getCreatedByUser().getId(), null);
            Assert.assertEquals(rootNode.getCreatedByUser().getDisplayName(), USERID_SYSTEM);
        }
        else
        {
            Assert.assertEquals(rootNode.getModifiedByUser().getDisplayName(), USER_DISPLAY_ADMIN);
            Assert.assertEquals(rootNode.getModifiedByUser().getId(), USERID_ADMIN);
            Assert.assertEquals(rootNode.getCreatedByUser().getId(), USERID_SYSTEM);
            Assert.assertEquals(rootNode.getCreatedByUser().getDisplayName(), USERID_SYSTEM);
        }

        // Properties
        Assert.assertNotNull(rootNode.getProperties(), "Properties is empty");
        Assert.assertEquals(rootNode.getProperties().get("cm:title"), "Company Home", "Wrong value for cm:title");

    }

    @Test
    public void folderLifeCycleTests() throws IOException
    {
        // Request Node By Id
        NodesAPI nodeService = client.getAPI(NodesAPI.class);

        // Request Site By Id
        Response<ResultPaging<NodeRepresentation>> response = nodeService.listNodeChildrenCall(NodesAPI.FOLDER_MY)
                .execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        ResultPaging<NodeRepresentation> nodesResponse = response.body();
        Assert.assertNotNull(nodesResponse, "Response is empty");
        Assert.assertNotNull(nodesResponse.getList(), "Response has no listActivitiesForPersonCall object");
        // Assert.assertNotNull(nodesResponse.getList().getPagination(),
        // "Response has no pagination");

        // Clean Up if necessary
        if (nodesResponse.getCount() != 7)
        {
            for (int i = 0; i < nodesResponse.getCount(); i++)
            {
                String name = nodesResponse.getList().get(i).getName();
                if (name.equals("TestV3") || name.equals("TestV2") || name.equals("Test"))
                {
                    nodeService.deleteNodeCall(nodesResponse.getList().get(i).getId()).execute();
                }
            }
            nodesResponse = nodeService.listNodeChildrenCall(NodesAPI.FOLDER_MY).execute().body();
        }

        Assert.assertEquals(nodesResponse.getCount(), 7, "Pagination Total items is wrong. Stale state ?");
        // Assert.assertEquals(nodesResponse.getCount(), 7,
        // "Pagination Count is wrong. Stale state ?");

        Assert.assertNotNull(nodesResponse.getList().get(0), "Response has no pagination");

        // CREATE
        NodeBodyCreate request = new NodeBodyCreate("Test", "cm:folder");
        Response<NodeRepresentation> testNodeResponse = nodeService.createNodeCall(NodesAPI.FOLDER_ROOT, request)
                .execute();
        Assert.assertNotNull(testNodeResponse, "Response is empty");
        Assert.assertEquals(testNodeResponse.isSuccessful(), true);
        Assert.assertNotNull(testNodeResponse.body(), "Response body is empty");

        // Check Node Info
        NodeRepresentation testNode = testNodeResponse.body();
        Assert.assertTrue(testNode.isFolder(), "Test Folder is not a Folder ??");
        Assert.assertEquals(testNode.getName(), "Test", "Root Folder is not Company Home");
        Assert.assertEquals(testNode.getNodeType(), "cm:folder", "Root Folder is not a Folder ??");
        Assert.assertNotNull(testNode.getId(), "Node Identifier is empty");
        Assert.assertTrue(NodeRefUtils.isIdentifier(testNode.getId()), "Node Identifier is not an identifier");
        Assert.assertNotNull(testNode.getParentId(), "Test has a Parent ?");
        for (String aspect : testNode.getAspects())
        {
            Assert.assertTrue(DEFAULT_FOLDER_ASPECTS.contains(aspect), aspect + "is not a default aspect");
        }

        Assert.assertFalse(testNode.hasAspects("cm:titled"), "Titled has been set without requesting");
        Assert.assertNull(testNode.getProperties(), "Properties is defined");

        // RENAME
        NodeBodyUpdate renameRequest = new NodeBodyUpdate("TestV2");
        Response<NodeRepresentation> updatedResponse = nodeService.updateNodeCall(testNode.getId(), renameRequest)
                .execute();
        Assert.assertEquals(updatedResponse.body().getName(), "TestV2", "Folder renaming is wrong");

        Response<NodeRepresentation> updated2Response = nodeService.getNodeCall(testNode.getId()).execute();
        Assert.assertEquals(updated2Response.body().getName(), "TestV2", "Folder renaming is wrong");
        Assert.assertEquals(updated2Response.body().getName(), updatedResponse.body().getName(),
                "Folder renaming is wrong");

        // EDIT PROPERTIES
        LinkedTreeMap<String, Object> properties = new LinkedTreeMap<>();
        properties.put("cm:title", "ALFRESCO");
        NodeBodyUpdate editRequest = new NodeBodyUpdate("TestV3", null, properties, null);
        Response<NodeRepresentation> editedResponse = nodeService.updateNodeCall(testNode.getId(), editRequest)
                .execute();

        Assert.assertEquals(editedResponse.body().getProperties().get("cm:title"), "ALFRESCO",
                "Wrong value for cm:title");
        Assert.assertNull(editedResponse.body().getProperties().get("cm:description"),
                "Wrong value for cm:description");

        // DELETE
        Response<Void> deleteResponse = nodeService.deleteNodeCall(testNode.getId()).execute();
        Assert.assertNotNull(deleteResponse, "Response is empty");
        Assert.assertEquals(deleteResponse.isSuccessful(), true);
        Assert.assertNull(deleteResponse.body(), "Response body is not empty");
    }

    @Test(enabled = false)
    public void ContentLifeCycleTests() throws IOException
    {
        NodesAPI nodeService = client.getAPI(NodesAPI.class);

        // Clean Up if necessary
        Response<ResultPaging<NodeRepresentation>> response = nodeService.listNodeChildrenCall(NodesAPI.FOLDER_MY)
                .execute();
        ResultPaging<NodeRepresentation> nodesResponse = response.body();
        if (nodesResponse.getCount() != 7)
        {
            for (int i = 0; i < nodesResponse.getCount(); i++)
            {
                String name = nodesResponse.getList().get(i).getName();
                if (name.equals("test.txt"))
                {
                    nodeService.deleteNodeCall(nodesResponse.getList().get(i).getId()).execute();
                }
            }
        }

        // Check if test file is present
        checkResourceFile("/com/alfresco/client/api/tests/test.txt");

        // Create Body
        File file = getResourceFile("/com/alfresco/client/api/tests/test.txt");
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filename", "test.txt", requestBody);
        RequestBody fileRequestBody = multipartBuilder.build();

        // Let's Create
        Response<NodeRepresentation> createdNodeResponse = nodeService
                .createNodeCall(NodesAPI.FOLDER_MY, fileRequestBody).execute();

        // Check Result
        Assert.assertNotNull(createdNodeResponse);
        Assert.assertEquals(createdNodeResponse.isSuccessful(), true, "Upload doesn't work");

        // Check Response
        NodeRepresentation testNode = createdNodeResponse.body();
        Assert.assertNotNull(testNode, "Response is empty");
        Assert.assertFalse(testNode.isFolder(), "Test Content is a Folder ??");
        Assert.assertTrue(testNode.isFile(), "Test Content is not a Content ??");
        Assert.assertEquals(testNode.getName(), "test.txt", "Root Folder is not Company Home");
        Assert.assertEquals(testNode.getNodeType(), "cm:content", "Root Folder is not a Folder ??");
        Assert.assertNotNull(testNode.getId(), "Node Identifier is empty");
        Assert.assertTrue(NodeRefUtils.isIdentifier(testNode.getId()), "Node Identifier is not an identifier");
        Assert.assertNotNull(testNode.getParentId(), "Test has a Parent ?");
        for (String aspect : testNode.getAspects())
        {
            Assert.assertTrue(DEFAULT_FILE_ASPECTS.contains(aspect), aspect + " is not a default aspect");
        }

        Assert.assertNotNull(testNode.getParentId(), "Test has a Parent ?");

        Assert.assertNotNull(testNode.getContent(), "Content is empty.");
        Assert.assertEquals(testNode.getContent().getSizeInBytes(), 12, "Content Size is wrong");
        Assert.assertEquals(testNode.getContent().getMimeType(), "text/plain", "Content Mimetype is wrong");
        Assert.assertEquals(testNode.getContent().getMimeTypeName(), "Plain Text", "Content MimeType Name is false");

        // Download Content
        Call<ResponseBody> downloadCall = nodeService.getNodeContentCall(testNode.getId());
        File dlFile = new File(tmpFolder, "dl.txt");
        IOUtils.copyFile(downloadCall.execute().body().byteStream(), dlFile);

        Assert.assertTrue(dlFile.exists());
        Assert.assertEquals(12, dlFile.length());

        // Create Body
        checkResourceFile("/com/alfresco/client/api/tests/test2.txt");
        file = getResourceFile("/com/alfresco/client/api/tests/test2.txt");
        requestBody = RequestBody.create(MediaType.parse("text/plain"), file);

        // Let's createCommentsCall
        Response<NodeRepresentation> updateNodeResponse = nodeService
                .updateNodeContentCall(testNode.getId(), requestBody).execute();
        // Check Result
        Assert.assertNotNull(updateNodeResponse);
        Assert.assertEquals(updateNodeResponse.isSuccessful(), true, "Update doesn't work");

        // Check Response
        NodeRepresentation nodeUpdatedResponse = updateNodeResponse.body();
        Assert.assertNotNull(nodeUpdatedResponse, "Response is empty");
        Assert.assertNotNull(nodeUpdatedResponse.getName(), "Response has no data");
        Assert.assertEquals(nodeUpdatedResponse.getContent().getSizeInBytes(), 30, "Content Size is wrong");
        Assert.assertEquals(nodeUpdatedResponse.getContent().getMimeType(), "text/plain", "Content Mimetype is wrong");
        Assert.assertEquals(nodeUpdatedResponse.getContent().getMimeTypeName(), "Plain Text",
                "Content MimeType Name is false");

        // COPY
        NodeBodyCreate request = new NodeBodyCreate("Test", "cm:folder");
        NodeRepresentation testFolder = nodeService.createNodeCall(NodesAPI.FOLDER_ROOT, request).execute().body();

        NodeBodyCopy copyRequest = new NodeBodyCopy(testFolder.getId(), "Copied.txt");
        Response<NodeRepresentation> copiedNodeResponse = nodeService
                .copyNodeCall(nodeUpdatedResponse.getId(), copyRequest).execute();

        // Check Result
        Assert.assertNotNull(copiedNodeResponse);
        Assert.assertEquals(copiedNodeResponse.isSuccessful(), true, "Update doesn't work");

        // Check Response
        NodeRepresentation copiedNode = copiedNodeResponse.body();
        Assert.assertNotNull(copiedNode, "Response is empty");
        Assert.assertEquals(copiedNode.getName(), "Copied.txt");
        Assert.assertEquals(copiedNode.getParentId(), testFolder.getId());

        // DELETE
        Response<Void> deleteResponse = nodeService.deleteNodeCall(testNode.getId()).execute();
        Assert.assertTrue(deleteResponse.isSuccessful(), "Deletion has failed");

        // MOVE
        NodeRepresentation rootFolder = nodeService.getNodeCall(NodesAPI.FOLDER_ROOT).execute().body();
        copyRequest = new NodeBodyCopy(rootFolder.getId(), "MovedText.txt");
        Response<NodeRepresentation> movedNodeResponse = nodeService.moveNodeCall(copiedNode.getId(), copyRequest)
                .execute();

        // Check Result
        Assert.assertNotNull(movedNodeResponse);
        Assert.assertEquals(movedNodeResponse.isSuccessful(), true, "Update doesn't work");

        // Check Response
        NodeRepresentation movedNode = movedNodeResponse.body();
        Assert.assertNotNull(movedNode, "Response is empty");
        Assert.assertEquals(movedNode.getName(), "MovedText.txt");
        Assert.assertEquals(movedNode.getParentId(), rootFolder.getId());

        // DELETE
        nodeService.deleteNodeCall(testFolder.getId()).execute();
        nodeService.deleteNodeCall(movedNode.getId()).execute();

    }

    public static final String CM_ORIGINAL = "cm:original";

    @Test
    public void nodeAssociationsTest() throws IOException
    {

        NodesAPI nodeService = client.getNodesAPI();

        // Create a file
        NodeRepresentation originalNode = createDummyFile();

        // Create a copy
        NodeRepresentation copiedNode = nodeService
                .copyNodeCall(originalNode.getId(), new NodeBodyCopy(originalNode.getParentId(), "DummyCopy.txt"))
                .execute().body();

        // CopiedNode contains a target association
        ResultPaging<NodeRepresentation> targetAssocNodes = nodeService.listTargetAssociationsCall(copiedNode.getId())
                .execute().body();
        Assert.assertEquals(targetAssocNodes.getCount(), 1, "Copied Association is not present after copy");
        AssociationInfoRepresentation association = targetAssocNodes.getList().get(0).getAssociation();
        Assert.assertNotNull(association);
        Assert.assertEquals(association.getAssocType(), CM_ORIGINAL, "AssocType is not cm:original");

        // dummyNode contains source association
        ResultPaging<NodeRepresentation> sourceAssocNodes = nodeService.listSourceAssociationsCall(originalNode.getId())
                .execute().body();
        Assert.assertEquals(sourceAssocNodes.getCount(), 1, "Copied Association is not present after copy");
        AssociationInfoRepresentation sourceAssociation = sourceAssocNodes.getList().get(0).getAssociation();
        Assert.assertNotNull(sourceAssociation);
        Assert.assertEquals(sourceAssociation.getAssocType(), CM_ORIGINAL, "AssocType is not cm:original");

        // Remove Association
        nodeService.deleteAssocationCall(copiedNode.getId(), originalNode.getId(), CM_ORIGINAL).execute();

        targetAssocNodes = nodeService.listTargetAssociationsCall(copiedNode.getId()).execute().body();
        Assert.assertEquals(targetAssocNodes.getCount(), 0, "Copied Association is still present after copy");
        sourceAssocNodes = nodeService.listSourceAssociationsCall(originalNode.getId()).execute().body();
        Assert.assertEquals(sourceAssocNodes.getCount(), 0, "Copied Association is still present after copy");

        // Recreate Association
        nodeService
                .createAssocationCall(copiedNode.getId(), new AssociationBody(originalNode.getId(), CM_ORIGINAL), null)
                .execute();

        targetAssocNodes = nodeService.listTargetAssociationsCall(copiedNode.getId()).execute().body();
        Assert.assertEquals(targetAssocNodes.getCount(), 1, "Copied Association is still present after copy");
        sourceAssocNodes = nodeService.listSourceAssociationsCall(originalNode.getId()).execute().body();
        Assert.assertEquals(sourceAssocNodes.getCount(), 1, "Copied Association is still present after copy");

        // Secondary Children
        // Create a folder and add it as second parent for copied Node
        NodeRepresentation parentNode2 = nodeService
                .createNodeCall(originalNode.getParentId(), new NodeBodyCreate("T", "cm:folder")).execute().body();
        ResultPaging<NodeRepresentation> childrenNodes = nodeService.listNodeChildrenCall(parentNode2.getId()).execute()
                .body();
        Assert.assertEquals(childrenNodes.getCount(), 0, "Wrong number of children for newly created folder");

        nodeService.createSecondaryChildAssocationCall(parentNode2.getId(),
                new ChildAssociationBody(copiedNode.getId(), "cm:contains"), null).execute();

        // List children as usual
        childrenNodes = nodeService.listNodeChildrenCall(parentNode2.getId()).execute().body();
        Assert.assertEquals(childrenNodes.getCount(), 1,
                "Wrong number of children after adding a node as second children");
        Assert.assertEquals(childrenNodes.getList().get(0).getId(), copiedNode.getId(),
                "CopiedId is not the node expected");

        // List secondary children
        ResultPaging<NodeRepresentation> secondaryChildrenNodes = nodeService
                .listSecondaryChildrenCall(parentNode2.getId()).execute().body();
        Assert.assertEquals(secondaryChildrenNodes.getCount(), 1,
                "Wrong number of children after adding a node as second children");
        Assert.assertEquals(secondaryChildrenNodes.getList().get(0).getId(), copiedNode.getId(),
                "CopiedId is not the node expected");

        // List parents
        ResultPaging<NodeRepresentation> parentCopiedNode = nodeService.listParentsCall(copiedNode.getId()).execute()
                .body();
        Assert.assertEquals(parentCopiedNode.getCount(), 2,
                "Wrong number of parents. It should be 2 (primary & secondary)");

        for (NodeRepresentation parent : parentCopiedNode.getList())
        {
            Assert.assertNotNull(parent);
            Assert.assertTrue(
                    originalNode.getParentId().equals(parent.getId()) || parentNode2.getId().equals(parent.getId()));
        }

        nodeService.deleteSecondaryChildAssocationCall(parentNode2.getId(), copiedNode.getId()).execute();

        // List parents
        parentCopiedNode = nodeService.listParentsCall(copiedNode.getId()).execute().body();
        Assert.assertEquals(parentCopiedNode.getCount(), 1, "Wrong number of parents. It should be 1 (primary only)");

        for (NodeRepresentation parent : parentCopiedNode.getList())
        {
            Assert.assertNotNull(parent);
            Assert.assertTrue(originalNode.getParentId().equals(parent.getId()));
        }
    }

    @Test
    public void nodeLockTests() throws IOException
    {

        NodesAPI nodeService = client.getNodesAPI();

        // Create a file
        NodeRepresentation originalNode = createDummyFile();

        Response<NodeRepresentation> response = nodeService.lockNodeCall(originalNode.getId(),
                new NodeBodyLock(0, NodeBodyLock.TypeEnum.ALLOW_OWNER_CHANGES, NodeBodyLock.LifetimeEnum.EPHEMERAL))
                .execute();

        // TODO

    }

    // ///////////////////////////////////////////////////////////////////////////
    // COPY
    // ///////////////////////////////////////////////////////////////////////////

}
