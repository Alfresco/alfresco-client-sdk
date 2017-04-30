package org.alfresco.client.samples.customclient;

import java.io.IOException;
import java.util.ArrayList;

import org.alfresco.client.samples.customclient.deserializer.NodeDeserializer;
import org.alfresco.client.samples.customclient.deserializer.ServerInfoDeserializer;
import org.alfresco.client.samples.customclient.model.Node;
import org.alfresco.client.samples.customclient.services.NodeService;
import org.alfresco.client.samples.customclient.services.ServerInfoService;
import org.alfresco.client.services.common.model.deserializer.PagingDeserializer;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.CSClient;
import org.alfresco.client.services.content.core.model.representation.ServerInfoRepresentation;
import org.testng.Assert;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import retrofit2.Response;

/**
 * Created by jpascal on 18/01/2016.
 */
public class CustomECM
{
    public static final String USERID_SYSTEM = "System";

    public static final String USER_DISPLAY_ADMIN = "Administrator";

    public static final ArrayList<String> DEFAULT_FOLDER_ASPECTS = new ArrayList<String>(3)
    {
        {
            add("cm:titled");
            add("cm:auditable");
            add("app:uifacets");
        }
    };

    public static void main(String[] args) throws IOException
    {
        // Create Custom GSON Builder
        GsonBuilder builder = new CSClient.Builder().getDefaultGsonBuilder();
        builder.registerTypeAdapter(ServerInfoRepresentation.class, new ServerInfoDeserializer());
        builder.registerTypeAdapter(Node.class, new NodeDeserializer());
        builder.registerTypeAdapter(new TypeToken<ResultPaging<Node>>()
        {
        }.getType(), new PagingDeserializer<>(Node.class));

        // Create AlfrescoCoreClient
        CSClient client = new CSClient.Builder()
                .connect("http://localhost:8080/alfresco/", "admin", "admin")
                .gsonBuilder(builder).build();

        // Create New API
        ServerInfoService serverService = client.getAPI(ServerInfoService.class);
        Response<ServerInfoRepresentation> response = serverService.getInfo().execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check ServerInfo Representation
        ServerInfoRepresentation serverInfo = response.body();
        Assert.assertNotNull(serverInfo, "Response is empty");
        Assert.assertEquals(serverInfo.getEdition(), "Community", "Edition seems wrong. Is it correct Alfresco ?");
        Assert.assertEquals(serverInfo.getVersion(), "5.2.0 (r132772-b11)",
                "Version seems wrong. Is it correct AlfrescoAPI ?");
        Assert.assertEquals(serverInfo.getSchema(), "10005", "Schema seems wrong. Is it correct Alfresco ?");

        // Create Custom Node API
        NodeService nodeService = client.getAPI(NodeService.class);
        Response<Node> nodeResponse = nodeService.getRootNode().execute();
        Assert.assertNotNull(nodeResponse);
        Assert.assertEquals(nodeResponse.isSuccessful(), true);

        // We retrieve Node Object instead of NodeRepresentation
        Node rootNode = nodeResponse.body();
        Assert.assertTrue(rootNode.isFolder(), "Root Folder is not a Folder ??");
        Assert.assertEquals(rootNode.getName(), "Company Home", "Root Folder is not Company Home");
        Assert.assertEquals(rootNode.getNodeType(), "cm:folder", "Root Folder is not a Folder ??");
        Assert.assertNotNull(rootNode.getIdentifier(), "Node Identifier is empty");
        Assert.assertNull(rootNode.getParentId(), "Company Home has a Parent ?");

        // Aspects
        Assert.assertFalse(rootNode.getAspects().isEmpty(), "Root Folder is not a Folder ??");
        Assert.assertEquals(rootNode.getAspects().size(), 3, "Root folder has more aspects");
        for (String aspect : rootNode.getAspects())
        {
            Assert.assertTrue(DEFAULT_FOLDER_ASPECTS.contains(aspect), aspect + "is not a default aspect");
        }

        // CreatedAt & ModifiedAt
        Assert.assertNotNull(rootNode.getCreatedAt(), "createdAt is empty");
        Assert.assertNotNull(rootNode.getModifiedAt(), "modifiedAt is empty");

        // createdByUser & modifiedByUser
        Assert.assertNotNull(rootNode.getCreatedBy(), "createdByUser is empty");
        Assert.assertNotNull(rootNode.getModifiedBy(), "modifiedByUser is empty");
        Assert.assertEquals(rootNode.getModifiedBy().getDisplayName(), USERID_SYSTEM);

        // Properties
        Assert.assertNotNull(rootNode.getProperties(), "Properties is empty");
        Assert.assertEquals(rootNode.getProperties().get("cm:title"), "Company Home", "Wrong value for cm:title");

    }
}
