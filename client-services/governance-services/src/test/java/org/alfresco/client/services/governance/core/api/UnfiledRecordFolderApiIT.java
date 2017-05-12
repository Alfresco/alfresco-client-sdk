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

package org.alfresco.client.services.governance.core.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.alfresco.client.services.GSAPITestCase;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.core.model.ContentModel;
import org.alfresco.client.services.content.core.model.body.NodeBodyCreate;
import org.alfresco.client.services.governance.GSAPIRegistry;
import org.alfresco.client.services.governance.core.model.RMSiteCompliance;
import org.alfresco.client.services.governance.core.model.RecordsManagementModel;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyCreate;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyUpdate;
import org.alfresco.client.services.governance.core.model.body.RMSiteBodyCreate;
import org.alfresco.client.services.governance.core.model.representation.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UnfiledRecordFolderApiIT extends GSAPITestCase
{

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test(enabled = true)
    public void recordFolderLifeCycle() throws IOException
    {
        GSAPIRegistry gsRegistry = client.getApiRegistry();

        // Delete preventively
        gsRegistry.getGsSitesAPI().deleteRMSiteCall().execute();

        // Create RM Site
        RMSiteBodyCreate rmSiteBodyCreate = new RMSiteBodyCreate("RM Test", "RM Test Side Made by Client SDK",
                RMSiteCompliance.STANDARD);
        RMSiteRepresentation rmSite = gsRegistry.getGsSitesAPI().createRMSiteCall(rmSiteBodyCreate, false).execute()
                .body();

        // Create 1 Categories
        NodeBodyCreate create = new NodeBodyCreate("RM Category 1", RecordsManagementModel.TYPE_RECORD_CATEGORY);
        RecordCategoryRepresentation category1 = gsRegistry.getFilePlansAPI()
                .createFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN, create).execute().body();

        // Create Record Folder Children
        create = new NodeBodyCreate("RM Folder", RecordsManagementModel.TYPE_RECORD_FOLDER);
        RMNodeRepresentation rmFolder = gsRegistry.getRecordCategoriesAPI()
                .createRecordCategoryChildCall(category1.getId(), create).execute().body();

        // Create an unfiled record folder
        Map<String, Object> recordProps = new HashMap<String, Object>()
        {
            {
                put(ContentModel.PROP_TITLE, "Unfiled Record Folder Title");
            }
        };
        RMNodeBodyCreate unfiledRecordBody = new RMNodeBodyCreate("Unfiled Record Folder",
                RecordsManagementModel.TYPE_UNFILED_RECORD_FOLDER, recordProps);
        UnfiledRecordFolderRepresentation unfiledFolder = (UnfiledRecordFolderRepresentation) gsRegistry
                .getUnfiledContainersAPI()
                .createUnfiledContainerChildrenCall(UnfiledContainersAPI.DEFAULT_UNFILED, unfiledRecordBody).execute()
                .body();

        // Get Unfiled Record Folder
        UnfiledRecordFolderRepresentation unfiledFolder1 = gsRegistry.getUnfiledRecordFoldersAPI()
                .getUnfiledRecordFolderCall(unfiledFolder.getId()).execute().body();
        Assert.assertEquals(unfiledFolder1.getNodeType(), RecordsManagementModel.TYPE_UNFILED_RECORD_FOLDER);
        Assert.assertEquals(unfiledFolder1.getClass(), UnfiledRecordFolderRepresentation.class);
        Assert.assertEquals(unfiledFolder1.getProperties().get(ContentModel.PROP_TITLE), "Unfiled Record Folder Title");
        Assert.assertNotNull(unfiledFolder1.getProperties().get(RecordsManagementModel.PROP_IDENTIFIER));

        // Update Unfiled Record Folder
        recordProps = new HashMap<String, Object>()
        {
            {
                put(ContentModel.PROP_TITLE, "Title");
            }
        };
        RMNodeBodyUpdate update = new RMNodeBodyUpdate("URF", recordProps);
        UnfiledRecordFolderRepresentation updatedUnfiledFolder = gsRegistry.getUnfiledRecordFoldersAPI()
                .updateUnfiledRecordFolderCall(unfiledFolder.getId(), update).execute().body();
        Assert.assertEquals(updatedUnfiledFolder.getNodeType(), RecordsManagementModel.TYPE_UNFILED_RECORD_FOLDER);
        Assert.assertEquals(updatedUnfiledFolder.getId(), unfiledFolder1.getId());
        Assert.assertEquals(updatedUnfiledFolder.getProperties().get(ContentModel.PROP_TITLE), "Title");
        Assert.assertNotNull(updatedUnfiledFolder.getName(), "URF");

        // List children
        ResultPaging<RMNodeRepresentation> containerchildren = gsRegistry.getUnfiledRecordFoldersAPI()
                .listUnfiledRecordFolderChildrenCall(updatedUnfiledFolder.getId()).execute().body();
        Assert.assertEquals(containerchildren.getCount(), 0);

        // Create Non-Electronic Record
        recordProps = new HashMap<String, Object>()
        {
            {
                put(ContentModel.PROP_DESCRIPTION, "My Non-electronic Record Description");
                put(ContentModel.PROP_TITLE, "My Non-electronic Record Title");
                put(RecordsManagementModel.PROP_BOX, "My Non-electronic Record Box");
                put(RecordsManagementModel.PROP_FILE, "My Non-electronic Record File");
                put(RecordsManagementModel.PROP_NUMBER_OF_COPIES, 1);
                put(RecordsManagementModel.PROP_PHYSICAL_SIZE, 30);
                put(RecordsManagementModel.PROP_SHELF, "My Non-electronic Record Shelf");
                put(RecordsManagementModel.PROP_STORAGE_LOCATION, "My Non-electronic Record Location");

            }
        };
        RMNodeBodyCreate recordCreate = new RMNodeBodyCreate("Non-Electronic Record",
                RecordsManagementModel.TYPE_NON_ELECTRONIC_DOCUMENT, recordProps);
        RMNodeRepresentation record1 = gsRegistry.getUnfiledRecordFoldersAPI()
                .createUnfiledRecordFolderChildrenCall(updatedUnfiledFolder.getId(), recordCreate).execute().body();
        Assert.assertEquals(record1.getNodeType(), RecordsManagementModel.TYPE_NON_ELECTRONIC_DOCUMENT);
        Assert.assertEquals(record1.getClass(), RecordRepresentation.class);
        Assert.assertEquals(record1.getProperties().get(ContentModel.PROP_TITLE), "My Non-electronic Record Title");
        Assert.assertEquals(
                ((Double) record1.getProperties().get(RecordsManagementModel.PROP_PHYSICAL_SIZE)).intValue(), 30);
        Assert.assertEquals(record1.getProperties().get(RecordsManagementModel.PROP_STORAGE_LOCATION),
                "My Non-electronic Record Location");

        // List children
        containerchildren = gsRegistry.getUnfiledRecordFoldersAPI()
                .listUnfiledRecordFolderChildrenCall(updatedUnfiledFolder.getId()).execute().body();
        Assert.assertEquals(containerchildren.getCount(), 1);

        // Delete RM Site
        gsRegistry.getGsSitesAPI().deleteRMSiteCall().execute();
        Assert.assertFalse(gsRegistry.getGsSitesAPI().getRMSiteCall().execute().isSuccessful());
    }

}
