package org.alfresco.client.services.process.activiti.core.api;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;
import org.alfresco.client.services.process.activiti.core.ActivitiAPITestCase;
import org.alfresco.client.services.process.activiti.core.model.body.AttachmentRequest;
import org.alfresco.client.services.process.activiti.core.model.body.TaskActionRequest;
import org.alfresco.client.services.process.activiti.core.model.body.TaskQueryRequest;
import org.alfresco.client.services.process.activiti.core.model.body.TaskRequest;
import org.alfresco.client.services.process.activiti.core.model.representation.AttachmentResponse;
import org.alfresco.client.services.process.activiti.core.model.representation.TaskResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;

public class TasksApiIT extends ActivitiAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void tasksTest() throws IOException
    {
        TasksAPI tasksAPI = client.getTasksAPI();

        // Clean Preceding task
        ResultList<TaskResponse> tasks = tasksAPI.getQueryResultCall(new TaskQueryRequest().assignee("kermit"))
                .execute().body();
        Assert.assertNotNull(tasks);
        for (TaskResponse task : tasks.getList())
        {
            tasksAPI.deleteTaskCall(task.getId()).execute();
        }

        // Create Task
        TaskResponse task = tasksAPI.createTaskCall(new TaskRequest("Task 1", "Description 1", "kermit", "kermit"))
                .execute().body();
        Assert.assertNotNull(task);
        Assert.assertEquals(
                tasksAPI.getQueryResultCall(new TaskQueryRequest().assignee("kermit")).execute().body().getSize(), 1);

        // Add Attachment
        File file = getResourceFile("/org/alfresco/client/services/process/tests/test.txt");
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filedata", "test.txt", requestBody);
        RequestBody fileRequestBody = multipartBuilder.build();
        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("filedata", fileRequestBody);
        map.put("name", RequestBody.create(MediaType.parse("multipart/form-data"), "my-file.txt"));

        Response<AttachmentResponse> attachment = tasksAPI.createAttachmentCall(task.getId(), map).execute();
        Assert.assertNotNull(attachment);

        // Add External Attachment
        AttachmentRequest request = new AttachmentRequest("ExtenalFile", "External", "simpleType",
                "http://www.activiti.org");
        attachment = tasksAPI.createAttachmentCall(task.getId(), request).execute();
        Assert.assertNotNull(attachment);

        // Complete Task
        tasksAPI.executeTaskActionCall(task.getId(), new TaskActionRequest(TaskActionRequest.ACTION_RESOLVE));
        TaskResponse taskCompleted = tasksAPI.getTaskCall(task.getId()).execute().body();
        Assert.assertNotNull(taskCompleted);

    }
}
