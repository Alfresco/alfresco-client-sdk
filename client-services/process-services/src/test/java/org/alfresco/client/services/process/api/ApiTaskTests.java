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
import org.alfresco.client.services.process.core.api.TaskAPI;
import org.alfresco.client.services.process.core.model.common.ResultList;
import org.alfresco.client.services.process.core.model.runtime.RelatedContentRepresentation;
import org.alfresco.client.services.process.core.model.runtime.TaskRepresentation;
import org.alfresco.client.services.process.core.model.runtime.request.QueryTasksRepresentation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;

public class ApiTaskTests extends ActivitiAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void standAloneLifeCycle() throws IOException
    {
        TaskAPI api = client.getTaskAPI();

        // CLEAN ALL STANDALONE TASKS
        QueryTasksRepresentation rep = new QueryTasksRepresentation(null, 1L, null);
        Response<ResultList<TaskRepresentation>> response0 = api.listTasks(rep).execute();
        Assert.assertNotNull(response0);
        Assert.assertEquals(response0.isSuccessful(), true);

        ResultList<TaskRepresentation> tasksRep = response0.body();
        if (tasksRep.getSize() > 0)
        {
            for (TaskRepresentation task : tasksRep.getList())
            {
                if (task.getFormKey() == null)
                {
                    api.completeTask(task.getId()).execute();
                }
                else
                {
                    api.deleteTask(task.getId()).execute();
                }
            }
        }

        // CREATE STANDALONE TASK
        TaskRepresentation representation = new TaskRepresentation();
        representation.setName("Task 1");
        representation.setDescription("Description 1");

        Response<TaskRepresentation> response = api.createNewTask(representation).execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        TaskRepresentation taskRep = response.body();
        Assert.assertNotNull(taskRep, "Response is empty");
        Assert.assertNotNull(taskRep.getCreated(), "Response has No Created");
        Assert.assertNotNull(taskRep.getDescription(), "Response has No Description");
        Assert.assertNotNull(taskRep.getId(), "Response has No Id");
        Assert.assertNotNull(taskRep.getName(), "Response has No Name");
        Assert.assertNotNull(taskRep.getPriority(), "Response has No Priority");
        Assert.assertFalse(taskRep.isAdhocTaskCanBeReassigned(), "Response has No Priority");
        Assert.assertFalse(taskRep.isInitiatorCanCompleteTask(), "InitiaterCanComplete Task should be true");

        Assert.assertNull(taskRep.getInvolvedPeople(), "Response has No Involved People");
        Assert.assertNull(taskRep.getCategory(), "Response has No Category");
        Assert.assertNull(taskRep.getAssignee(), "Response has No Assignee");
        Assert.assertNull(taskRep.getDueDate(), "Response has No Due Date");
        Assert.assertNull(taskRep.getDuration(), "Response has No Duration");
        Assert.assertNull(taskRep.getEndDate(), "Response has No EndDate");
        Assert.assertNull(taskRep.getFormKey(), "Response has No FormKey");
        Assert.assertNull(taskRep.getParentTaskId(), "Response has No Parent Task Id");
        Assert.assertNull(taskRep.getParentTaskName(), "Response has No Parent Task Name");
        Assert.assertNull(taskRep.getProcessDefinitionCategory(), "Response has No Process Definition Category");
        Assert.assertNull(taskRep.getProcessDefinitionDeploymentId(),
                "Response has No Process Definition Deployment Id");
        Assert.assertNull(taskRep.getProcessDefinitionDescription(), "Response has No Process Definition Description");
        Assert.assertNull(taskRep.getProcessDefinitionId(), "Response has No Process Definition Id");
        Assert.assertNull(taskRep.getProcessDefinitionKey(), "Response has No Process Definition Key");
        Assert.assertNull(taskRep.getProcessDefinitionName(), "Response has No Process Definition Name");
        Assert.assertEquals(taskRep.getProcessDefinitionVersion(), (Integer) 0);
        Assert.assertNull(taskRep.getProcessInstanceId(), "Response has No Process Instance Id");
        Assert.assertNull(taskRep.getProcessInstanceName(), "Response has No Process Instance Name");
        Assert.assertNull(taskRep.getProcessInstanceStartUserId(), "Response has No Process Instance Name");
        Assert.assertNull(taskRep.isMemberOfCandidateGroup(), "Response has No Priority");
        Assert.assertNull(taskRep.isMemberOfCandidateUsers(), "Response has No Priority");

        // ATTACH DOCUMENT
        File file = getResourceFile("/org/alfresco/client/services/process/tests/test.txt");
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("file", "test.txt", requestBody);
        RequestBody fileRequestBody = multipartBuilder.build();

        Response<RelatedContentRepresentation> resp = api.createRelatedContentOnTask(taskRep.getId(), fileRequestBody)
                .execute();
        hasSuceedReponse(resp);

        // COMPLETE STANDALONE TASK
        Response<Void> completionResponse = api.completeTask(taskRep.getId()).execute();
        hasSuceedReponse(completionResponse);

        // Check Values
        Response<TaskRepresentation> resp3 = api.getTask(taskRep.getId()).execute();
        Assert.assertNotNull(resp3);
        Assert.assertEquals(resp3.isSuccessful(), true);

        // Check Response
        TaskRepresentation taskCompleted = resp3.body();
        Assert.assertNotNull(taskCompleted, "Response is empty");
        Assert.assertNotNull(taskCompleted.getCreated(), "Response has No Created");
        Assert.assertNotNull(taskCompleted.getDescription(), "Response has No Description");
        Assert.assertNotNull(taskCompleted.getId(), "Response has No Id");
        Assert.assertNotNull(taskCompleted.getName(), "Response has No Name");
        Assert.assertNotNull(taskCompleted.getPriority(), "Response has No Priority");
        Assert.assertFalse(taskCompleted.isAdhocTaskCanBeReassigned(), "Response has No Reassign flag");

        // Check Task value changed due to completion
        Assert.assertFalse(taskCompleted.isInitiatorCanCompleteTask(), "Response has No Priority");
        Assert.assertNotNull(taskCompleted.getDuration(), "Response has No Duration");
        Assert.assertNotNull(taskCompleted.getEndDate(), "Response has No EndDate");
        Assert.assertNotNull(taskCompleted.getInvolvedPeople(), "Response has No Involved People");
        Assert.assertNotNull(taskCompleted.getAssignee(), "Response has No Assignee");

        Assert.assertNull(taskCompleted.getCategory(), "Response has No Category");
        Assert.assertNull(taskCompleted.getDueDate(), "Response has No Due Date");
        Assert.assertNull(taskCompleted.getFormKey(), "Response has No FormKey");
        Assert.assertNull(taskCompleted.getParentTaskId(), "Response has No Parent Task Id");
        Assert.assertNull(taskCompleted.getParentTaskName(), "Response has No Parent Task Name");
        Assert.assertNull(taskCompleted.getProcessDefinitionCategory(), "Response has No Process Definition Category");
        Assert.assertNull(taskCompleted.getProcessDefinitionDeploymentId(),
                "Response has No Process Definition Deployment Id");
        Assert.assertNull(taskCompleted.getProcessDefinitionDescription(),
                "Response has No Process Definition Description");
        Assert.assertNull(taskCompleted.getProcessDefinitionId(), "Response has No Process Definition Id");
        Assert.assertNull(taskCompleted.getProcessDefinitionKey(), "Response has No Process Definition Key");
        Assert.assertNull(taskCompleted.getProcessDefinitionName(), "Response has No Process Definition Name");
        Assert.assertEquals(taskCompleted.getProcessDefinitionVersion(), (Integer) 0);
        Assert.assertNull(taskCompleted.getProcessInstanceId(), "Response has No Process Instance Id");
        Assert.assertNull(taskCompleted.getProcessInstanceName(), "Response has No Process Instance Name");
        Assert.assertNull(taskCompleted.getProcessInstanceStartUserId(), "Response has No Process Instance Name");
        Assert.assertNull(taskCompleted.isMemberOfCandidateGroup(), "Response has No Priority");
        Assert.assertNull(taskCompleted.isMemberOfCandidateUsers(), "Response has No Priority");

    }
}
