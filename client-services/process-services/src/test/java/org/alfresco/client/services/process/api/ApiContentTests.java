/*
 *  Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *  This file is part of Alfresco Activiti Client.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.alfresco.client.services.process.api;

import java.io.File;
import java.io.IOException;

import org.alfresco.client.services.ActivitiAPITestCase;
import org.alfresco.client.services.process.core.api.ContentAPI;
import org.alfresco.client.services.process.core.model.runtime.RelatedContentRepresentation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiContentTests extends ActivitiAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void contentLifeCycle() throws IOException
    {
        ContentAPI api = client.getAPI(ContentAPI.class);

        // Create a Content
        // Create Body
        File file = getResourceFile("/org/alfresco/client/services/process/tests/test.txt");
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filename", "test.txt", requestBody);
        RequestBody fileRequestBody = multipartBuilder.build();

        Response<RelatedContentRepresentation> response = api.createTemporaryRawRelatedContent(fileRequestBody)
                .execute();
        hasSuceedReponse(response);

        // Check Response
        RelatedContentRepresentation contentRep = response.body();
        Assert.assertNotNull(contentRep, "Response is empty");
        Assert.assertNotNull(contentRep.getCreated(), "Response has No Created");
        Assert.assertNotNull(contentRep.getCreatedBy(), "Response has No Created");
        Assert.assertEquals(contentRep.getCreatedBy().getEmail(), "admin@app.activiti.com",
                "Response has No Created By");
        Assert.assertNotNull(contentRep.getId(), "Response has No Id");
        Assert.assertEquals(contentRep.getMimeType(), "text/plain");
        Assert.assertNotNull(contentRep.getName(), "Response has No Name");
        Assert.assertNotNull(contentRep.getSimpleType(), "Response has No Simple Type");
        Assert.assertNull(contentRep.getLinkUrl(), "Response has No Link Url");
        Assert.assertNull(contentRep.getSource(), "Response has No Source");
        Assert.assertNull(contentRep.getSourceId(), "Response has No Source Id");
        Assert.assertNotNull(contentRep.getPreviewStatus(), "Response has No Preview Status");
        Assert.assertNotNull(contentRep.getThumbnailStatus(), "Response has No Thumbnail Status");

        // DELETE a Content
        api.deleteContent(Long.toString(contentRep.getId())).enqueue(new Callback<Void>()
        {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response)
            {
                Assert.assertNotNull(response);
                Assert.assertEquals(response.isSuccessful(), true);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t)
            {
                Assert.fail();
            }
        });

        // GET a Content
        api.getContent(Long.toString(contentRep.getId())).enqueue(new Callback<RelatedContentRepresentation>()
        {
            @Override
            public void onResponse(Call<RelatedContentRepresentation> call,
                    Response<RelatedContentRepresentation> response)
            {
                Assert.assertNotNull(response);
                Assert.assertEquals(response.isSuccessful(), false);
                Assert.assertEquals(response.code(), 403);
            }

            @Override
            public void onFailure(Call<RelatedContentRepresentation> call, Throwable t)
            {
                Assert.fail();
            }
        });
    }
}
