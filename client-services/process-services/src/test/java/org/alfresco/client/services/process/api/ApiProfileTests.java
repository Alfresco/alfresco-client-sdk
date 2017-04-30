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
import org.alfresco.client.services.process.core.api.ProfileAPI;
import org.alfresco.client.services.process.core.model.idm.UserRepresentation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiProfileTests extends ActivitiAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void profileTests() throws IOException
    {
        client.getAPI(ProfileAPI.class).getProfile().enqueue(new Callback<UserRepresentation>()
        {
            @Override
            public void onResponse(Call<UserRepresentation> call, Response<UserRepresentation> response)
            {
                Assert.assertNotNull(response);
                Assert.assertEquals(response.isSuccessful(), true);

                // Check Response
                UserRepresentation user = response.body();
                Assert.assertNotNull(user, "Response is empty");
                Assert.assertNotNull(user.getTenantId(), "Response has a No Type");
                Assert.assertNotNull(user.getFirstName(), "Response has a No First Name");
                Assert.assertNotNull(user.getLastName(), "Response has a No Last Name");
                Assert.assertNotNull(user.getPassword(), "Response has a No Password");
                Assert.assertNotNull(user.getType(), "Response has a No Type");
                Assert.assertNotNull(user.getCompany(), "Response has a No Company");
                Assert.assertNotNull(user.getExternalId(), "Response has a No External Id");
                Assert.assertNotNull(user.getCapabilities(), "Response has a No Capabilities");
                Assert.assertNotNull(user.getTenantPictureId(), "Response has a No Tenant Picture Id");
                Assert.assertNotNull(user.getCreated(), "Response has a No Created date");
                Assert.assertNotNull(user.getPictureId(), "Response has a No Picture Id");
                Assert.assertNotNull(user.getLatestSyncTimeStamp(), "Response has a No Latest Sync Timestamp");
                Assert.assertNotNull(user.getTenantName(), "Response has a No Tenant Name");
                Assert.assertNotNull(user.getId(), "Response has a No Id");
                Assert.assertNotNull(user.getLastUpdate(), "Response has a No Last Update");
                Assert.assertNotNull(user.getEmail(), "Response has a No Email");
                Assert.assertNotNull(user.getStatus(), "Response has a No Status");
                Assert.assertNotNull(user.getFullname(), "Response has a No FullName");
                Assert.assertNotNull(user.getGroups(), "Response has a No Groups");
            }

            @Override
            public void onFailure(Call<UserRepresentation> call, Throwable t)
            {

            }
        });

        // Request All Comments for a document
        Response<UserRepresentation> response = client.getAPI(ProfileAPI.class).getProfile().execute();

    }
}
