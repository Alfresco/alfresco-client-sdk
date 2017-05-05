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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.alfresco.client.services.GSAPITestCase;
import org.alfresco.client.services.common.model.parameters.IncludeParam;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.core.model.body.NodeBodyCreate;
import org.alfresco.client.services.governance.GSAPIRegistry;
import org.alfresco.client.services.governance.core.model.RMSiteCompliance;
import org.alfresco.client.services.governance.core.model.RecordsManagementModel;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyUpdate;
import org.alfresco.client.services.governance.core.model.body.RMSiteBodyCreate;
import org.alfresco.client.services.governance.core.model.representation.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RecordCategoriesApiTest extends GSAPITestCase
{

    private IncludeParam defaultTestInclude = new IncludeParam(
            Arrays.asList("hasRetentionSchedule", "isRecordCategory", "allowableOperations", "path", "association"));

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test(enabled = true)
    public void recordCategoriesLifeCycle() throws IOException
    {
        GSAPIRegistry gsRegistry = client.getApiRegistry();

        // Delete preventively
        gsRegistry.getGsSitesAPI().deleteRMSiteCall().execute();

        // Create RM Site
        RMSiteBodyCreate rmSiteBodyCreate = new RMSiteBodyCreate("RM Test", "RM Test Side Made by Client SDK",
                RMSiteCompliance.STANDARD);
        RMSiteRepresentation rmSite = gsRegistry.getGsSitesAPI().createRMSiteCall(rmSiteBodyCreate, false).execute()
                .body();

        // Get File Plan
        FilePlanRepresentation filePlanRepresentation = gsRegistry.getFilePlansAPI()
                .getFilePlanCall(FilePlansAPI.DEFAULT_FILE_PLAN).execute().body();

        // Check 0 Categories
        ResultPaging<RecordCategoryRepresentation> categories = gsRegistry.getFilePlansAPI()
                .listFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN).execute().body();
        Assert.assertEquals(categories.getCount(), 0);

        // Create 3 Categories
        NodeBodyCreate create = new NodeBodyCreate("RM Category 1", (Map) null);
        RecordCategoryRepresentation category1 = gsRegistry.getFilePlansAPI()
                .createFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN, create).execute().body();
        Assert.assertEquals(category1.getName(), "RM Category 1");

        create = new NodeBodyCreate("RM Category 2", (Map) null);
        RecordCategoryRepresentation category2 = gsRegistry.getFilePlansAPI()
                .createFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN, create).execute().body();
        Assert.assertEquals(category2.getName(), "RM Category 2");

        create = new NodeBodyCreate("RM Category 3", (Map) null);
        RecordCategoryRepresentation category3 = gsRegistry.getFilePlansAPI()
                .createFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN, create).execute().body();
        Assert.assertEquals(category3.getName(), "RM Category 3");

        // Check 3 Categories
        categories = gsRegistry.getFilePlansAPI().listFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN).execute()
                .body();
        Assert.assertEquals(categories.getCount(), 3);

        // Get 1 RM Category
        RecordCategoryRepresentation category1L = gsRegistry.getRecordCategoriesAPI()
                .getRecordCategoryCall(category1.getId(), defaultTestInclude, null, null).execute().body();

        Assert.assertEquals(category1L.getName(), "RM Category 1");
        Assert.assertEquals(category1L.getNodeType(), "rma:recordCategory");
        Assert.assertFalse(category1L.hasRetentionSchedule());
        Assert.assertNotNull(category1L.getPath());
        Assert.assertNull(category1L.getAssociation());// Should be not null
        Assert.assertEquals(category1.getProperties().get("rma:vitalRecordIndicator"), false);

        // Update Category 2
        Map<String, Object> categoryProps = new HashMap<String, Object>()
        {
            {
                put("rma:vitalRecordIndicator", "true");
                put("rma:reviewPeriod", "month|1");
            }
        };
        RMNodeBodyUpdate update = new RMNodeBodyUpdate("RM 2", null, categoryProps);
        RecordCategoryRepresentation category2L = gsRegistry.getRecordCategoriesAPI()
                .updateRecordCategoryCall(category2.getId(), update, defaultTestInclude, null).execute().body();
        Assert.assertEquals(category2L.getName(), "RM 2");
        Assert.assertEquals(category2L.getNodeType(), RecordsManagementModel.TYPE_RECORD_CATEGORY);
        Assert.assertFalse(category2L.hasRetentionSchedule());
        Assert.assertNotNull(category2L.getPath());
        Assert.assertNull(category2L.getAssociation());// Should be not null
        Assert.assertEquals(category2L.getProperties().get("rma:vitalRecordIndicator"), true);

        // Delete Categories
        gsRegistry.getRecordCategoriesAPI().deleteRecordCategoryCall(category1L.getId()).execute();
        gsRegistry.getRecordCategoriesAPI().deleteRecordCategoryCall(category2L.getId()).execute();

        // Check 1 Category
        categories = gsRegistry.getFilePlansAPI().listFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN).execute()
                .body();
        Assert.assertEquals(categories.getCount(), 1);

        // List Children
        ResultPaging<RMNodeRepresentation> Category1Children = gsRegistry.getRecordCategoriesAPI()
                .listRecordCategoryChildrenCall(category3.getId()).execute().body();
        Assert.assertEquals(Category1Children.getCount(), 0);

        // Create Category Children
        create = new NodeBodyCreate("Sub Category 1", RecordsManagementModel.TYPE_RECORD_CATEGORY);
        RMNodeRepresentation subCategory1 = gsRegistry.getRecordCategoriesAPI()
                .createRecordCategoryChildCall(category3.getId(), create).execute().body();
        Assert.assertEquals(subCategory1.getName(), "Sub Category 1");
        Assert.assertEquals(subCategory1.getNodeType(), RecordsManagementModel.TYPE_RECORD_CATEGORY);
        Assert.assertEquals(RecordCategoryRepresentation.class, subCategory1.getClass());

        // Create Record Folder Children
        create = new NodeBodyCreate("Sub Folder 1", RecordsManagementModel.TYPE_RECORD_FOLDER);
        RMNodeRepresentation subFolder1 = gsRegistry.getRecordCategoriesAPI()
                .createRecordCategoryChildCall(category3.getId(), create).execute().body();
        Assert.assertEquals(subFolder1.getName(), "Sub Folder 1");
        Assert.assertEquals(subFolder1.getNodeType(), RecordsManagementModel.TYPE_RECORD_FOLDER);
        Assert.assertEquals(RecordFolderRepresentation.class, subFolder1.getClass());

        // List Children
        Category1Children = gsRegistry.getRecordCategoriesAPI().listRecordCategoryChildrenCall(category3.getId())
                .execute().body();
        Assert.assertEquals(Category1Children.getCount(), 2);

        for (RMNodeRepresentation rep : Category1Children.getList())
        {
            if (rep instanceof RecordCategoryRepresentation)
            {
                Assert.assertEquals(rep.getName(), "Sub Category 1");
            }
            else
            {
                Assert.assertEquals(rep.getName(), "Sub Folder 1");
            }
        }

        // Delete RM Site
        gsRegistry.getGsSitesAPI().deleteRMSiteCall().execute();
        Assert.assertFalse(gsRegistry.getGsSitesAPI().getRMSiteCall().execute().isSuccessful());
    }

}
