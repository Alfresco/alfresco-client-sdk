package org.alfresco.client.services.process.activiti.core.api;

import java.io.IOException;

import org.alfresco.client.services.process.activiti.core.ActivitiAPITestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserAPITest extends ActivitiAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void manageUsers() throws IOException
    {
        UsersAPI usersAPI = client.getUsersAPI();

        Assert.assertNotNull(usersAPI.getUserCall(TEST_USERNAME).execute().body());

    }
}
