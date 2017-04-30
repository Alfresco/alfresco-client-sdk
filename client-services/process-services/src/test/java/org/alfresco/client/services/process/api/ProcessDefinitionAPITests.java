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
import org.alfresco.client.services.process.core.api.ProcessDefinitionAPI;
import org.alfresco.client.services.process.core.model.common.ResultList;
import org.alfresco.client.services.process.core.model.runtime.ProcessDefinitionRepresentation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retrofit2.Response;

public class ProcessDefinitionAPITests extends ActivitiAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void listProcessDefinitions() throws IOException
    {
        ProcessDefinitionAPI processDefAPI = client.getAPI(ProcessDefinitionAPI.class);

        // Check if the user is present
        Response<ResultList<ProcessDefinitionRepresentation>> response = processDefAPI.getProcessDefinitions()
                .execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        ResultList<ProcessDefinitionRepresentation> list = response.body();
        Assert.assertNotNull(list);
        Assert.assertEquals(list.getSize(), 0);
        Assert.assertNotNull(list.getList());
        Assert.assertEquals(list.getList().size(), 0);

    }
}
