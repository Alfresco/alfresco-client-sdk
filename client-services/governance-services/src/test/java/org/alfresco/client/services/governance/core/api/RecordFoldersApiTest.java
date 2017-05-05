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

import java.io.File;
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
import org.alfresco.client.services.governance.core.model.RecordsManagementModel;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyCreate;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyUpdate;
import org.alfresco.client.services.governance.core.model.body.RMSiteBodyCreate;
import org.alfresco.client.services.governance.core.model.representation.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class RecordFoldersApiTest extends GSAPITestCase
{

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test(enabled = true)
    public void recordFoldersLifeCycle() throws IOException
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
        Assert.assertEquals(category1.getName(), "RM Category 1");

        // Check 1 Category
        ResultPaging<RecordCategoryRepresentation> categories = gsRegistry.getFilePlansAPI()
                .listFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN).execute().body();
        Assert.assertEquals(categories.getCount(), 1);

        // Create Record Folder Children
        create = new NodeBodyCreate("RM Folder", RecordsManagementModel.TYPE_RECORD_FOLDER);
        RMNodeRepresentation rmFolder = gsRegistry.getRecordCategoriesAPI()
                .createRecordCategoryChildCall(category1.getId(), create).execute().body();
        Assert.assertEquals(rmFolder.getName(), "RM Folder");
        Assert.assertEquals(rmFolder.getNodeType(), RecordsManagementModel.TYPE_RECORD_FOLDER);
        Assert.assertEquals(RecordFolderRepresentation.class, rmFolder.getClass());

        // Get Record Folder Info
        RMNodeRepresentation rmFolder1 = gsRegistry.getRecordFoldersAPI().getRecordFolderCall(rmFolder.getId())
                .execute().body();
        Assert.assertEquals(rmFolder1.getId(), rmFolder.getId());
        Assert.assertEquals(rmFolder1.getName(), "RM Folder");
        Assert.assertEquals(rmFolder1.getNodeType(), RecordsManagementModel.TYPE_RECORD_FOLDER);
        Assert.assertEquals(RecordFolderRepresentation.class, rmFolder1.getClass());

        // Edit Record Folder
        RMNodeBodyUpdate update = new RMNodeBodyUpdate("RMFolder Updated");
        RMNodeRepresentation rmFolderUpdated = gsRegistry.getRecordFoldersAPI()
                .updateRecordFolderCall(rmFolder.getId(), update).execute().body();
        Assert.assertEquals(rmFolderUpdated.getId(), rmFolder.getId());
        Assert.assertEquals(rmFolderUpdated.getName(), "RMFolder Updated");
        Assert.assertEquals(rmFolderUpdated.getNodeType(), RecordsManagementModel.TYPE_RECORD_FOLDER);
        Assert.assertEquals(RecordFolderRepresentation.class, rmFolderUpdated.getClass());

        // Delete Record Folder
        Assert.assertEquals(gsRegistry.getRecordCategoriesAPI().listRecordCategoryChildrenCall(category1.getId())
                .execute().body().getCount(), 1);
        gsRegistry.getRecordFoldersAPI().deleteRecordFolderCall(rmFolderUpdated.getId()).execute();
        Assert.assertEquals(gsRegistry.getRecordCategoriesAPI().listRecordCategoryChildrenCall(category1.getId())
                .execute().body().getCount(), 0);

        // ReCreate Record Folder
        create = new NodeBodyCreate("RM Folder", RecordsManagementModel.TYPE_RECORD_FOLDER);
        rmFolder = gsRegistry.getRecordCategoriesAPI().createRecordCategoryChildCall(category1.getId(), create)
                .execute().body();

        // Create Record Folder Children
        Assert.assertEquals(gsRegistry.getRecordFoldersAPI().listRecordFolderChildrenCall(rmFolder.getId()).execute()
                .body().getCount(), 0);

        // Create Non-Electronic Record
        Map<String, Object> recordProps = new HashMap<String, Object>()
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
        RecordRepresentation record1 = gsRegistry.getRecordFoldersAPI()
                .createRecordFolderChildCall(rmFolder.getId(), recordCreate).execute().body();
        Assert.assertEquals(record1.getNodeType(), RecordsManagementModel.TYPE_NON_ELECTRONIC_DOCUMENT);
        Assert.assertEquals(record1.getClass(), RecordRepresentation.class);
        Assert.assertEquals(record1.getProperties().get(ContentModel.PROP_TITLE), "My Non-electronic Record Title");
        Assert.assertEquals(
                ((Double) record1.getProperties().get(RecordsManagementModel.PROP_PHYSICAL_SIZE)).intValue(), 30);
        Assert.assertEquals(record1.getProperties().get(RecordsManagementModel.PROP_STORAGE_LOCATION),
                "My Non-electronic Record Location");

        // Create Empty Electronic Record
        recordCreate = new RMNodeBodyCreate("Empty Electronic Record", ContentModel.TYPE_CONTENT, null);
        RecordRepresentation recordEmpty = gsRegistry.getRecordFoldersAPI()
                .createRecordFolderChildCall(rmFolder.getId(), recordCreate).execute().body();
        Assert.assertEquals(recordEmpty.getName(), "Empty Electronic Record");
        Assert.assertEquals(recordEmpty.getNodeType(), ContentModel.TYPE_CONTENT);
        Assert.assertEquals(recordEmpty.getClass(), RecordRepresentation.class);
        Assert.assertNull(recordEmpty.getProperties().get(ContentModel.PROP_TITLE));
        Assert.assertNull(recordEmpty.getContent());

        // Non Empty Electronic Record
        File file = new File("W:\\test.txt");
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filedata", "test.txt", requestBody);
        RequestBody fileRequestBody = multipartBuilder.build();

        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("filedata", fileRequestBody);
        map.put("name", RequestBody.create(MediaType.parse("multipart/form-data"), "Non-Empty Electronic Record"));
        map.put("nodeType", RequestBody.create(MediaType.parse("multipart/form-data"), "cm:content"));

        // Create Content
        RecordRepresentation recordNonEmpty = gsRegistry.getRecordFoldersAPI()
                .createRecordFolderChildCall(rmFolder.getId(), map, new IncludeParam(Arrays.asList("content")), null)
                .execute().body();
        Assert.assertEquals(recordNonEmpty.getNodeType(), ContentModel.TYPE_CONTENT);
        Assert.assertEquals(recordNonEmpty.getClass(), RecordRepresentation.class);
        Assert.assertEquals(recordNonEmpty.getName(), "Non-Empty Electronic Record");
        Assert.assertEquals(recordNonEmpty.getContent().getMimeType(), "text/plain");

        // List Records
        Assert.assertEquals(gsRegistry.getRecordFoldersAPI().listRecordFolderChildrenCall(rmFolder.getId()).execute()
                .body().getCount(), 3);

        // Delete RM Site
        gsRegistry.getGsSitesAPI().deleteRMSiteCall().execute();
        Assert.assertFalse(gsRegistry.getGsSitesAPI().getRMSiteCall().execute().isSuccessful());
    }

}
