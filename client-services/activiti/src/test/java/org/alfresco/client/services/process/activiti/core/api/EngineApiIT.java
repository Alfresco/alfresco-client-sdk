package org.alfresco.client.services.process.activiti.core.api;

import java.io.IOException;
import java.util.Map;

import org.alfresco.client.services.process.activiti.core.ActivitiAPITestCase;
import org.alfresco.client.services.process.activiti.core.model.representation.ProcessEngineInfoResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EngineApiIT extends ActivitiAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void engineInfoTest() throws IOException
    {
        EngineAPI engineAPI = client.getEngineAPI();

        ProcessEngineInfoResponse response = engineAPI.getEngineInfoCall().execute().body();
        Assert.assertEquals(response.getName(), "default");
        Assert.assertNotNull(response.getVersion());
        Assert.assertNull(response.getResourceUrl());
        Assert.assertNull(response.getException());

        Map<String, String> properties = engineAPI.getPropertiesCall().execute().body();
        Assert.assertNotNull(properties);

    }
}
