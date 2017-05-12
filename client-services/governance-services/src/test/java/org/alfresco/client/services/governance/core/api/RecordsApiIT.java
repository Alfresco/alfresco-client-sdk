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
import org.alfresco.client.services.content.core.model.ContentModel;
import org.alfresco.client.services.content.core.model.body.NodeBodyCreate;
import org.alfresco.client.services.governance.GSAPIRegistry;
import org.alfresco.client.services.governance.core.model.RMSiteCompliance;
import org.alfresco.client.services.governance.core.model.RecordsManagementModel;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyCreate;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyUpdate;
import org.alfresco.client.services.governance.core.model.body.RMSiteBodyCreate;
import org.alfresco.client.services.governance.core.model.representation.RMNodeRepresentation;
import org.alfresco.client.services.governance.core.model.representation.RMSiteRepresentation;
import org.alfresco.client.services.governance.core.model.representation.RecordCategoryRepresentation;
import org.alfresco.client.services.governance.core.model.representation.RecordRepresentation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class RecordsApiIT extends GSAPITestCase
{

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test(enabled = true)
    public void recordsLifeCycle() throws IOException
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

        // Get Record
        RecordRepresentation record = gsRegistry.getRecordsAPI().getRecordCall(record1.getId()).execute().body();
        Assert.assertEquals(record.getNodeType(), RecordsManagementModel.TYPE_NON_ELECTRONIC_DOCUMENT);
        Assert.assertEquals(record.getClass(), RecordRepresentation.class);
        Assert.assertEquals(record.getProperties().get(ContentModel.PROP_TITLE), "My Non-electronic Record Title");
        Assert.assertEquals(((Double) record.getProperties().get(RecordsManagementModel.PROP_PHYSICAL_SIZE)).intValue(),
                30);
        Assert.assertEquals(record.getProperties().get(RecordsManagementModel.PROP_STORAGE_LOCATION),
                "My Non-electronic Record Location");

        // Update Record
        Map<String, Object> rmProps = new HashMap<String, Object>()
        {
            {
                put(RecordsManagementModel.PROP_PHYSICAL_SIZE, 90);
            }
        };
        RMNodeBodyUpdate update = new RMNodeBodyUpdate("NERecord", null, rmProps);
        RecordRepresentation recordUpdated = gsRegistry.getRecordsAPI().updateRecordCall(record.getId(), update)
                .execute().body();
        Assert.assertEquals(recordUpdated.getName(), "NERecord");
        Assert.assertEquals(
                ((Double) recordUpdated.getProperties().get(RecordsManagementModel.PROP_PHYSICAL_SIZE)).intValue(), 90);

        // Delete Record
        gsRegistry.getRecordsAPI().deleteRecordCall(record.getId()).execute();
        Assert.assertEquals(gsRegistry.getRecordFoldersAPI().listRecordFolderChildrenCall(rmFolder.getId()).execute()
                .body().getCount(), 0);

        // Create Non Empty Electronic Record
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
        record = gsRegistry.getRecordFoldersAPI()
                .createRecordFolderChildCall(rmFolder.getId(), map, new IncludeParam(Arrays.asList("content")), null)
                .execute().body();
        Assert.assertEquals(record.getNodeType(), ContentModel.TYPE_CONTENT);
        Assert.assertEquals(record.getClass(), RecordRepresentation.class);
        Assert.assertNull(record.getProperties().get(ContentModel.PROP_TITLE));
        Assert.assertEquals(record.getName(), "Non-Empty Electronic Record");
        Assert.assertNotNull(record.getContent());

        // Get Record Content FIXME
        // File dlFile = new File("W:\\", "dl.txt");
        // IOUtils.copyFile(gsRegistry.getRecordsAPI().getRecordContentCall(record.getId(),
        // true, null).execute().body().byteStream(), dlFile);
        // Assert.assertEquals( dlFile.length(),
        // record.getContent().getSizeInBytes());

        // File a Record
        /*
         * RecordRepresentation filedRecord =
         * gsRegistry.getRecordsAPI().fileRecordCall(record.getId(), new
         * RecordBodyFile(rmFolder.getId())).execute().body();
         * Assert.assertEquals(filedRecord.getNodeType(),
         * ContentModel.TYPE_CONTENT);
         * Assert.assertEquals(filedRecord.getClass(),
         * RecordRepresentation.class);
         * Assert.assertNull(filedRecord.getProperties().get(ContentModel.
         * PROP_TITLE)); Assert.assertEquals(filedRecord.getName(),
         * "Non-Empty Electronic Record");
         * Assert.assertNotNull(filedRecord.getContent());
         */

        // Delete RM Site
        gsRegistry.getGsSitesAPI().deleteRMSiteCall().execute();
        Assert.assertFalse(gsRegistry.getGsSitesAPI().getRMSiteCall().execute().isSuccessful());
    }

}
