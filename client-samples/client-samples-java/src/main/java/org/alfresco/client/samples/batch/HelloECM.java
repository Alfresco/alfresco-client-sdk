package org.alfresco.client.samples.batch;

import java.io.IOException;

import org.testng.Assert;

import com.alfresco.client.AlfrescoClient;
import com.alfresco.client.api.core.NodesAPI;
import com.alfresco.client.api.core.model.representation.NodeRepresentation;

import retrofit2.Response;

/**
 * Created by jpascal on 18/01/2016.
 */
public class HelloECM
{
    public static void main(String[] args) throws IOException
    {
        AlfrescoClient client = new AlfrescoClient.Builder()
                .connect("http://localhost:8080/alfresco/", "admin", "admin").build();

        // Create Custom Node API
        NodesAPI nodeService = client.getNodesAPI();
        Response<NodeRepresentation> nodeResponse = nodeService.getNodeCall(NodesAPI.FOLDER_ROOT).execute();
        Assert.assertNotNull(nodeResponse);
        Assert.assertEquals(nodeResponse.isSuccessful(), true);
        Assert.assertEquals(nodeResponse.body().getName(), "Company Home");
    }
}
