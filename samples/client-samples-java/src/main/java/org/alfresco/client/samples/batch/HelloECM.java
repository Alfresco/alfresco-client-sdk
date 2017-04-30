package org.alfresco.client.samples.batch;

import java.io.IOException;

import org.alfresco.client.services.content.CSClient;
import org.alfresco.client.services.content.core.api.NodesAPI;
import org.alfresco.client.services.content.core.model.representation.NodeRepresentation;
import org.testng.Assert;

import retrofit2.Response;

/**
 * Created by jpascal on 18/01/2016.
 */
public class HelloECM
{
    public static void main(String[] args) throws IOException
    {
        CSClient client = new CSClient.Builder()
                .connect("http://localhost:8080/alfresco/", "admin", "admin").build();

        // Create Custom Node API
        NodesAPI nodeService = client.getNodesAPI();
        Response<NodeRepresentation> nodeResponse = nodeService.getNodeCall(NodesAPI.FOLDER_ROOT).execute();
        Assert.assertNotNull(nodeResponse);
        Assert.assertEquals(nodeResponse.isSuccessful(), true);
        Assert.assertEquals(nodeResponse.body().getName(), "Company Home");
    }
}
