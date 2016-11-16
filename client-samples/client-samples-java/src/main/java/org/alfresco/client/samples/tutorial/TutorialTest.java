package org.alfresco.client.samples.tutorial;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.alfresco.client.AlfrescoClient;
import com.alfresco.client.api.common.constant.ContentModel;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.NodesAPI;
import com.alfresco.client.api.core.model.body.NodeBodyCreate;
import com.alfresco.client.api.core.model.body.NodeBodyUpdate;
import com.alfresco.client.api.core.model.parameters.IncludeParam;
import com.alfresco.client.api.core.model.parameters.OrderByParam;
import com.alfresco.client.api.core.model.representation.NodeRepresentation;
import com.google.gson.internal.LinkedTreeMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jpascal on 16/11/2016.
 */
public class TutorialTest {
    private static AlfrescoClient client;

    public static void main(String[] args) throws IOException {
        tutorialInitiation();
        tutorialPart4ManagingNodes();
        Assert.assertTrue(true);
    }

    static void tutorialInitiation() throws IOException {
        // Create Client and connect with default admin/admin user
        client = new AlfrescoClient.Builder().httpLogging(HttpLoggingInterceptor.Level.BODY)
                .connect("http://localhost:8080/alfresco", "admin", "admin").build();

        // Select NodesAPI
        NodesAPI nodesAPI = client.getNodesAPI();

        // Retrieve Root Node Info Synchronuously
        Response<NodeRepresentation> rootFolderResponse = nodesAPI.getNodeCall(NodesAPI.FOLDER_ROOT).execute();

        // Retrieve Root Node Info Asynchronuously
        nodesAPI.getNodeCall(NodesAPI.FOLDER_ROOT).enqueue(new Callback<NodeRepresentation>() {
            @Override
            public void onResponse(Call<NodeRepresentation> call, Response<NodeRepresentation> response) {
                // Retrieve Root Node Info
            }

            @Override
            public void onFailure(Call<NodeRepresentation> call, Throwable t) {
                // Something wrong happened
            }
        });

        // Retrieve Root Node Info in Reactive Way
        nodesAPI.getNodeObservable(NodesAPI.FOLDER_ROOT)
                .subscribe(root -> Assert.assertEquals(root.getName(), "Company Home"));
    }

    static void tutorialPart2Navigation() throws IOException {
        // Select NodesAPI
        NodesAPI nodesAPI = client.getNodesAPI();

        // List Root Children
        Response<ResultPaging<NodeRepresentation>> rootChildrenResponse = nodesAPI
                .listNodeChildrenCall(NodesAPI.FOLDER_ROOT).execute();

        // Check Response status
        if (rootChildrenResponse.isSuccessful()) {
            // Iterate over the listing
            for (NodeRepresentation node : rootChildrenResponse.body().getList()) {
                Assert.assertNotNull(node.getId());
            }
        }

        // List Root Children with Include Parameters
        ResultPaging<NodeRepresentation> rootChildren = nodesAPI
                .listNodeChildrenCall(NodesAPI.FOLDER_ROOT, null, null, null, null,
                        new IncludeParam(Arrays.asList("properties", "aspectNames")), null, null, null)
                .execute().body();

        // Retrieve child nodes 3 through 5
        Assert.assertEquals(nodesAPI.listNodeChildrenCall(NodesAPI.FOLDER_ROOT, 2, 3, null).execute().body()
                .getPagination().getCount(), 3);

        // Retrieve files only
        Assert.assertEquals(nodesAPI
                .listNodeChildrenCall(NodesAPI.FOLDER_ROOT, null, null, null, "(isFile=true)", null, null, null, null)
                .execute().body().getPagination().getCount(), 0);

        // Retrieve Sites folder only
        Assert.assertEquals(nodesAPI.listNodeChildrenCall(NodesAPI.FOLDER_ROOT, null, null, null, "(nodeType=st:sites)",
                null, null, null, null).execute().body().getList().get(0).getName(), "Sites");

        // Retrieve children ordered by name
        Assert.assertEquals(nodesAPI
                .listNodeChildrenCall(NodesAPI.FOLDER_ROOT, null, null, new OrderByParam(Arrays.asList("name ASC")))
                .execute().body().getList().size(), 7);
    }

    static void tutorialPart3CreateNodes() throws IOException {
        // Select NodesAPI
        NodesAPI nodesAPI = client.getNodesAPI();

        //Create Folder
        /*NodeBodyCreate nodeBodyCreate = new NodeBodyCreate("My Folder", ContentModel.TYPE_FOLDER);
        Response<NodeRepresentation> nodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, nodeBodyCreate).execute();
        NodeRepresentation folder = nodeResponse.body();
        Assert.assertEquals(folder.getName(), "My Folder");*/

        //Create Empty File
        /*NodeBodyCreate emptyFileBody = new NodeBodyCreate("my-file.txt", ContentModel.TYPE_CONTENT);
        Response<NodeRepresentation> emptyNodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, emptyFileBody).execute();
        NodeRepresentation emptyNode = emptyNodeResponse.body();
        Assert.assertEquals(emptyNode.getContent().getSizeInBytes(), 0);*/

        //Create Content
        // Create Body
         /*File file = new File("W:\\test.txt");
         RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
         MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
         multipartBuilder.addFormDataPart("filedata", "test.txt", requestBody);
         RequestBody fileRequestBody = multipartBuilder.build();

         //Create Content
         Response<NodeRepresentation> createdNodeResponse = nodesAPI
                 .createNodeCall(NodesAPI.FOLDER_MY, fileRequestBody).execute();*/


        //Create content with name
        // Create Body
         /*File file = new File("W:\\test.txt");
         RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
         MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
         multipartBuilder.addFormDataPart("filedata", "test.txt", requestBody);
         RequestBody fileRequestBody = multipartBuilder.build();

         HashMap<String, RequestBody> map = new HashMap<>();
         map.put("filedata", fileRequestBody);
         map.put("name", RequestBody.create(MediaType.parse("multipart/form-data"), "my-name.txt"));

         //Create Content
         Response<NodeRepresentation> createdNodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, map).execute();*/

        // Create content with auto rename
        // Create Body
         /*File file = new File("W:\\test.txt");
         RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
         MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
         multipartBuilder.addFormDataPart("filedata", "test.txt", requestBody);
         RequestBody fileRequestBody = multipartBuilder.build();

         HashMap<String, RequestBody> map = new HashMap<>();
         map.put("filedata", fileRequestBody);
         map.put("name", RequestBody.create(MediaType.parse("multipart/form-data"), "my-name.txt"));
         map.put("autorename", RequestBody.create(MediaType.parse("multipart/form-data"), "true"));

         //Create Content
         Response<NodeRepresentation> createdNodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, map).execute();*/


        // Create content in relative path
        // Create Body
        /*File file = new File("W:\\test.txt");
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filedata", "test.txt", requestBody);
        RequestBody fileRequestBody = multipartBuilder.build();

        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("filedata", fileRequestBody);
        map.put("name", RequestBody.create(MediaType.parse("multipart/form-data"), "my-file.txt"));
        map.put("relativePath", RequestBody.create(MediaType.parse("multipart/form-data"), "/My Folder"));

        //Create Content
        Response<NodeRepresentation> createdNodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, map).execute();*/

        // Create content with rendition
        // Create Body
        /*File file = new File("W:\\test.txt");
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filedata", "test.txt", requestBody);
        RequestBody fileRequestBody = multipartBuilder.build();
        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("filedata", fileRequestBody);
        map.put("renditions", RequestBody.create(MediaType.parse("multipart/form-data"), "doclib"));
        //Create Content
        Response<NodeRepresentation> createdNodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, map).execute();*/

        // Create content with properties
        // Create Body
        File file = new File("W:\\test.txt");
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filedata", "test.txt", requestBody);
        RequestBody fileRequestBody = multipartBuilder.build();
        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("filedata", fileRequestBody);
        map.put("name", RequestBody.create(MediaType.parse("multipart/form-data"), "my-file.txt"));
        map.put("autoRename", RequestBody.create(MediaType.parse("multipart/form-data"), "true"));
        map.put(ContentModel.PROP_TITLE, RequestBody.create(MediaType.parse("multipart/form-data"), "The Title"));
        map.put(ContentModel.PROP_DESCRIPTION, RequestBody.create(MediaType.parse("multipart/form-data"), "The Description"));
        map.put(ContentModel.PROP_MANUFACTURER, RequestBody.create(MediaType.parse("multipart/form-data"), "Canon"));

        //Create Content
        Response<NodeRepresentation> createdNodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, map).execute();

    }

    static void tutorialPart4ManagingNodes() throws IOException {

        // Select NodesAPI
        NodesAPI nodesAPI = client.getNodesAPI();

        //Create Empty Node with Properties
        LinkedTreeMap<String, Object> properties = new LinkedTreeMap<>();
        properties.put(ContentModel.PROP_TITLE, "The Title");

        NodeBodyCreate emptyFileBody = new NodeBodyCreate("my-file.txt", ContentModel.TYPE_CONTENT, properties, null);

        Response<NodeRepresentation> emptyNodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, emptyFileBody, true, null, null).execute();

        NodeRepresentation emptyNode = emptyNodeResponse.body();
        Assert.assertEquals(emptyNode.getContent().getSizeInBytes(), 0);

        //Get Node Information
        String nodeId = emptyNode.getId();
        NodeRepresentation node = nodesAPI.getNodeCall(nodeId).execute().body();
        Assert.assertNotNull(node.getProperties());
        Assert.assertNotNull(node.getAspects());
        Assert.assertTrue(node.isFile());
        Assert.assertFalse(node.isFolder());
        Assert.assertNull(node.isLink());
        Assert.assertNull(node.getPath());

        //Get node information with isLink and path
        node = nodesAPI.getNodeCall(nodeId, new IncludeParam(Arrays.asList("isLink", "path")), null, null).execute().body();
        Assert.assertFalse(node.isLink());
        Assert.assertNotNull(node.getPath());

        //Update Node Information
        LinkedTreeMap<String, Object> props = new LinkedTreeMap<>();
        props.put(ContentModel.PROP_DESCRIPTION, "The Description");
        props.put(ContentModel.PROP_MANUFACTURER, "Canon");
        NodeRepresentation updatedNode = nodesAPI.updateNodeCall(nodeId, new NodeBodyUpdate(props)).execute().body();
        Assert.assertEquals(updatedNode.getProperties().get(ContentModel.PROP_DESCRIPTION), "The Description");
        Assert.assertEquals(updatedNode.getProperties().get(ContentModel.PROP_MANUFACTURER), "Canon");

        //Rename Node
        NodeRepresentation renamedNode = nodesAPI.updateNodeCall(nodeId, new NodeBodyUpdate("renamed-file.txt")).execute().body();
        Assert.assertEquals(renamedNode.getName(), "renamed-file.txt");

        //Change owner
        props = new LinkedTreeMap<>();
        props.put("cm:owner", "gavinc");
        NodeRepresentation ownerNode = nodesAPI.updateNodeCall(nodeId, new NodeBodyUpdate(props)).execute().body();
        Assert.assertEquals(((LinkedTreeMap) ownerNode.getProperties().get("cm:owner")).get("id"), "gavinc");

        //Remove Exif Aspects
        List<String> aspectNames = new ArrayList<>();
        aspectNames.add(ContentModel.ASPECT_TITLED);
        aspectNames.add(ContentModel.ASPECT_AUDITABLE);
        aspectNames.add("cm:ownable");
        NodeRepresentation aspectNode = nodesAPI.updateNodeCall(nodeId, new NodeBodyUpdate(null, null, null, aspectNames)).execute().body();
        Assert.assertTrue(aspectNode.getAspects().contains(ContentModel.ASPECT_TITLED));
        Assert.assertTrue(aspectNode.getAspects().contains(ContentModel.ASPECT_AUDITABLE));
        Assert.assertTrue(aspectNode.getAspects().contains("cm:ownable"));
        Assert.assertFalse(aspectNode.getAspects().contains(ContentModel.ASPECT_EXIF));

        //Change Node Type
        NodeRepresentation changedTypeNode = nodesAPI.updateNodeCall(nodeId, new NodeBodyUpdate(null, "cm:savedquery", null, null)).execute().body();
        Assert.assertEquals(changedTypeNode.getNodeType(), "cm:savedquery");

        //Update Content
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), "This is the initial content for the file.");
        NodeRepresentation updatedContentNode = nodesAPI.updateNodeContentCall(nodeId, requestBody).execute().body();
        Assert.assertEquals(updatedContentNode.getContent().getSizeInBytes(), 41);

        //Get Content
        Call<ResponseBody> downloadCall = nodesAPI.getNodeContentCall(nodeId);
        File dlFile = new File("W:\\", "dl.txt");
        IOUtils.copyFile(downloadCall.execute().body().byteStream(), dlFile);

        //Delete Node
        Response<Void> deleteCall = nodesAPI.deleteNodeCall(nodeId).execute();
        Assert.assertTrue(deleteCall.isSuccessful());

        //Delete Node Permanently
        Response<Void> deleteCallPermanently = nodesAPI.deleteNodeCall(nodeId, true).execute();
        Assert.assertTrue(deleteCallPermanently.isSuccessful());

    }


}
