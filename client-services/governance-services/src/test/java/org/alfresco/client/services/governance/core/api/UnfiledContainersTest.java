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
import org.alfresco.client.services.governance.core.model.body.RMSiteBodyCreate;
import org.alfresco.client.services.governance.core.model.representation.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UnfiledContainersTest extends GSAPITestCase
{

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test(enabled = true)
    public void recordContainerLifeCycle() throws IOException
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

        // Get Unfiled Records Containers
        UnfiledContainerRepresentation unfiledContainer = gsRegistry.getUnfiledContainersAPI()
                .getUnfiledContainerCall(UnfiledContainersAPI.DEFAULT_UNFILED).execute().body();
        Assert.assertNotNull(unfiledContainer);
        Assert.assertEquals(unfiledContainer.getNodeType(), RecordsManagementModel.TYPE_UNFILED_RECORD_CONTAINER);

        // List children
        ResultPaging<RMNodeRepresentation> containerchildren = gsRegistry.getUnfiledContainersAPI()
                .listUnfiledContainerChildrenCall(unfiledContainer.getId()).execute().body();
        Assert.assertEquals(containerchildren.getCount(), 0);

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
        Assert.assertEquals(unfiledFolder.getNodeType(), RecordsManagementModel.TYPE_UNFILED_RECORD_FOLDER);
        Assert.assertEquals(unfiledFolder.getClass(), UnfiledRecordFolderRepresentation.class);
        Assert.assertEquals(unfiledFolder.getProperties().get(ContentModel.PROP_TITLE), "Unfiled Record Folder Title");
        Assert.assertNotNull(unfiledFolder.getProperties().get(RecordsManagementModel.PROP_IDENTIFIER));

        // List children
        containerchildren = gsRegistry.getUnfiledContainersAPI()
                .listUnfiledContainerChildrenCall(unfiledContainer.getId()).execute().body();
        Assert.assertEquals(containerchildren.getCount(), 1);

        // Delete RM Site
        gsRegistry.getGsSitesAPI().deleteRMSiteCall().execute();
        Assert.assertFalse(gsRegistry.getGsSitesAPI().getRMSiteCall().execute().isSuccessful());
    }

}
