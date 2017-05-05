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
import org.alfresco.client.services.content.core.model.ContentModel;
import org.alfresco.client.services.content.core.model.body.NodeBodyCreate;
import org.alfresco.client.services.governance.GSAPIRegistry;
import org.alfresco.client.services.governance.core.model.RMSiteCompliance;
import org.alfresco.client.services.governance.core.model.body.FilePlanBodyUpdate;
import org.alfresco.client.services.governance.core.model.body.RMSiteBodyCreate;
import org.alfresco.client.services.governance.core.model.representation.FilePlanRepresentation;
import org.alfresco.client.services.governance.core.model.representation.RMSiteRepresentation;
import org.alfresco.client.services.governance.core.model.representation.RecordCategoryRepresentation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retrofit2.Response;

public class FilePlanApiTest extends GSAPITestCase
{

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test(enabled = true)
    public void filePlanTest() throws IOException
    {
        GSAPIRegistry gsRegistry = client.getApiRegistry();

        // Delete preventively
        gsRegistry.getGsSitesAPI().deleteRMSiteCall().execute();

        // Create RM Site
        RMSiteBodyCreate rmSiteBodyCreate = new RMSiteBodyCreate("RM Test", "RM Test Side Made by Client SDK",
                RMSiteCompliance.STANDARD);
        Response<RMSiteRepresentation> rmCreateSiteResponse = gsRegistry.getGsSitesAPI()
                .createRMSiteCall(rmSiteBodyCreate, false).execute();
        Assert.assertTrue(rmCreateSiteResponse.isSuccessful());

        // Get File Plan
        FilePlanRepresentation filePlanRepresentation = gsRegistry.getFilePlansAPI()
                .getFilePlanCall(FilePlansAPI.DEFAULT_FILE_PLAN).execute().body();
        Assert.assertNotNull(filePlanRepresentation);
        Assert.assertEquals(filePlanRepresentation.getName(), "documentLibrary");
        Assert.assertEquals(filePlanRepresentation.getNodeType(), "rma:filePlan");
        Assert.assertEquals(filePlanRepresentation.getAspectNames().size(), 8);
        Assert.assertEquals(filePlanRepresentation.getProperties().size(), 4);

        // Update File Plan
        Map<String, Object> props = new HashMap<String, Object>()
        {
            {
                put(ContentModel.PROP_DESCRIPTION, "Description");
                put(ContentModel.PROP_TITLE, "Title");
            }
        };
        FilePlanBodyUpdate bodyUpdate = new FilePlanBodyUpdate(null, props);
        FilePlanRepresentation updatedFilePlan = gsRegistry.getFilePlansAPI()
                .updateFilePlanCall(FilePlansAPI.DEFAULT_FILE_PLAN, bodyUpdate).execute().body();
        Assert.assertEquals(updatedFilePlan.getProperties().get(ContentModel.PROP_DESCRIPTION), "Description");
        Assert.assertEquals(updatedFilePlan.getProperties().get(ContentModel.PROP_TITLE), "Title");

        // List Categories
        ResultPaging<RecordCategoryRepresentation> categories = gsRegistry.getFilePlansAPI()
                .listFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN).execute().body();
        Assert.assertNotNull(categories);
        Assert.assertEquals(categories.getCount(), 0);
        Assert.assertEquals(categories.getList().size(), 0);

        // Create Record Categories
        Map<String, Object> categoryProps = new HashMap<String, Object>()
        {
            {
                put("rma:vitalRecordIndicator", "true");
                put("rma:reviewPeriod", "month|1");
            }
        };
        NodeBodyCreate create = new NodeBodyCreate("My Record Category", categoryProps);
        RecordCategoryRepresentation category1 = gsRegistry.getFilePlansAPI()
                .createFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN, create).execute().body();
        Assert.assertNotNull(category1);
        Assert.assertEquals(category1.getName(), "My Record Category");
        Assert.assertEquals(category1.getNodeType(), "rma:recordCategory");
        Assert.assertNull(category1.hasRetentionSchedule());
        Assert.assertNull(category1.getPath());
        Assert.assertNull(category1.getAssociation());
        Assert.assertEquals(category1.getProperties().get("rma:vitalRecordIndicator"), true);

        // List Categories
        categories = gsRegistry.getFilePlansAPI().listFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN).execute()
                .body();
        Assert.assertNotNull(categories);
        Assert.assertEquals(categories.getCount(), 1);
        Assert.assertEquals(categories.getList().size(), 1);

        // List Categories
        categories = gsRegistry.getFilePlansAPI()
                .listFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN, 0, 1, null,
                        new IncludeParam(Arrays.asList("hasRetentionSchedule", "isRecordCategory",
                                "allowableOperations", "path", "association")),
                        null, null)
                .execute().body();
        Assert.assertNotNull(categories);
        Assert.assertEquals(categories.getCount(), 1);
        Assert.assertEquals(categories.getList().size(), 1);

        RecordCategoryRepresentation category = categories.getList().get(0);
        Assert.assertEquals(category.getName(), "My Record Category");
        Assert.assertEquals(category.getNodeType(), "rma:recordCategory");
        Assert.assertFalse(category.hasRetentionSchedule());
        Assert.assertNotNull(category.getPath());
        Assert.assertNull(category.getAssociation());// Should be not null
        Assert.assertNull(category.getProperties().get("rma:vitalRecordIndicator"));

        // Delete RM Site
        gsRegistry.getGsSitesAPI().deleteRMSiteCall().execute();
        Assert.assertFalse(gsRegistry.getGsSitesAPI().getRMSiteCall().execute().isSuccessful());
    }

}
