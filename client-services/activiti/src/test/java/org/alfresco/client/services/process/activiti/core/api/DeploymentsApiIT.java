package org.alfresco.client.services.process.activiti.core.api;

import java.io.IOException;

import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;
import org.alfresco.client.services.process.activiti.core.ActivitiAPITestCase;
import org.alfresco.client.services.process.activiti.core.model.representation.DeploymentResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeploymentsApiIT extends ActivitiAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void deplymentTests() throws IOException
    {
        DeploymentsAPI deploymentsAPI = client.getDeploymentsAPI();

        ResultList<DeploymentResponse> deployments = deploymentsAPI.getDeploymentsCall().execute().body();
        Assert.assertNotNull(deployments);


    }
}
