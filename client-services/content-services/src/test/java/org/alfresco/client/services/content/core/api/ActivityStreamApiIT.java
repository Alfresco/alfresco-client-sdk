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

package org.alfresco.client.services.content.core.api;

import java.io.IOException;
import java.util.List;

import org.alfresco.client.services.CSAPITestCase;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.core.model.representation.ActivityRepresentation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retrofit2.Response;

public class ActivityStreamApiIT extends CSAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test(groups = { "core" })
    public void retrieveActivities() throws IOException
    {
        // Request All Comments for a document
        Response<ResultPaging<ActivityRepresentation>> response = client.getAPI(ActivitiesAPI.class)
                .listActivitiesForPersonCall(TEST_USERNAME).execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        ResultPaging<ActivityRepresentation> activitiPaging = response.body();
        Assert.assertNotNull(activitiPaging, "Response is empty");
        Assert.assertNotNull(activitiPaging.getList(), "Response has no listActivitiesForPersonCall of comments");

        // Check Pagination & Entries
        List<ActivityRepresentation> activities = activitiPaging.getList();
        Assert.assertNotNull(activities, "Response has no pagination");

        // Check Entry
        for (int i = 0; i < activitiPaging.getCount(); i++)
        {
            Assert.assertNotNull(activities.get(i));
            Assert.assertNotNull(activities.get(i).getActivitySummary());
        }
    }
}
