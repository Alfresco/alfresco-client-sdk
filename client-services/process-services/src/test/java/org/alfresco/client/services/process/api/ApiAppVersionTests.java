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

import java.io.IOException;

import org.alfresco.client.services.ActivitiAPITestCase;
import org.alfresco.client.services.process.enterprise.discovery.api.DiscoveryAPI;
import org.alfresco.client.services.process.enterprise.discovery.model.runtime.AppVersionRepresentation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiAppVersionTests extends ActivitiAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void retrieveAppVersionInfo() throws IOException
    {
        // Request All Comments for a document
        Response<AppVersionRepresentation> response = client.getAPI(DiscoveryAPI.class).getAppVersionCall().execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        AppVersionRepresentation activitiesResponse = response.body();
        Assert.assertNotNull(activitiesResponse, "Response is empty");
        // Assert.assertNotNull(activitiesResponse.getGitVersion(), "Response
        // has a No Git Version");
        Assert.assertNotNull(activitiesResponse.getType(), "Response has a No Type");
        Assert.assertNotNull(activitiesResponse.getEdition(), "Response has a No Edition");
        Assert.assertNotNull(activitiesResponse.getFullVersion(), "Response has a No Full Version");
        Assert.assertNotNull(activitiesResponse.getMajorVersion(), "Response has a No Major Version");
        Assert.assertNotNull(activitiesResponse.getMinorVersion(), "Response has a No Minor Version");
        Assert.assertNotNull(activitiesResponse.getRevisionVersion(), "Response has a No Revision Version");

        client.getAPI(DiscoveryAPI.class).getAppVersionCall().enqueue(new Callback<AppVersionRepresentation>()
        {
            @Override
            public void onResponse(Call<AppVersionRepresentation> call, Response<AppVersionRepresentation> response)
            {
                // TODO When response is correct
            }

            @Override
            public void onFailure(Call<AppVersionRepresentation> call, Throwable t)
            {
                // TODO When request has failed
            }
        });
    }
}
