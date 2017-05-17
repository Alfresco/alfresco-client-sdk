package org.alfresco.client.services.process.activiti.core.api;

import java.io.IOException;

import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;
import org.alfresco.client.services.process.activiti.core.ActivitiAPITestCase;
import org.alfresco.client.services.process.activiti.core.model.body.UserRequest;
import org.alfresco.client.services.process.activiti.core.model.representation.UserResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UsersApiIT extends ActivitiAPITestCase
{

    public static final String U1_USERNAME = "user1";

    public static final String U1_PASSWORD = "user1";

    public static final String U1_FIRST_NAME = "User";

    public static final String U1_LAST_NAME = "Number 1";

    public static final String U1_EMAIL = "user1@activiti.org";

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void manageUsers() throws IOException
    {
        if (isActiviti6())
        {
            client = prepareClient(TEST_ENDPOINT, TEST_USERNAME_V6, TEST_PASSWORD_V6);
        }

        UsersAPI usersAPI = client.getUsersAPI();

        if (!isActiviti6())
        {
            // Get a specific user
            UserResponse response = usersAPI.getUserCall(TEST_USERNAME).execute().body();
            checkUser(response);

            // Get a list of users
            ResultList<UserResponse> users = usersAPI.listUsersCall().execute().body();
            Assert.assertEquals(users.getSize(), 3);

            users = usersAPI.listUsersCall(TEST_USERNAME, null, null, null, null, null, null, null, null, null)
                    .execute().body();
            Assert.assertEquals(users.getSize(), 1);
            checkUser(users.getList().get(0));

            users = usersAPI.listUsersCall(null, TEST_FIRST_NAME, null, null, null, null, null, null, null, null)
                    .execute().body();
            Assert.assertEquals(users.getSize(), 1);
            checkUser(users.getList().get(0));

            users = usersAPI.listUsersCall(null, null, TEST_LAST_NAME, null, null, null, null, null, null, null)
                    .execute().body();
            Assert.assertEquals(users.getSize(), 1);
            checkUser(users.getList().get(0));

            users = usersAPI.listUsersCall(null, null, null, TEST_EMAIL, null, null, null, null, null, null).execute()
                    .body();
            Assert.assertEquals(users.getSize(), 1);
            checkUser(users.getList().get(0));

            // Create a user
            UserRequest request = new UserRequest(U1_USERNAME, U1_FIRST_NAME, U1_LAST_NAME, null, U1_EMAIL, null,
                    U1_PASSWORD);
            UserResponse user1 = usersAPI.createUserCall(request).execute().body();

        }

    }

    private void checkUser(UserResponse user)
    {
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getId(), TEST_USERNAME);
        Assert.assertEquals(user.getEmail(), TEST_EMAIL);
        Assert.assertEquals(user.getFirstName(), TEST_FIRST_NAME);
        Assert.assertEquals(user.getLastName(), TEST_LAST_NAME);
        Assert.assertEquals(user.getEmail(), TEST_EMAIL);
    }
}
