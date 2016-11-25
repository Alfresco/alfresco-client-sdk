package org.alfresco.client.samples.tutorial;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.testng.Assert;

import com.alfresco.client.AlfrescoClient;
import com.alfresco.client.api.common.constant.ContentModel;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.NodesAPI;
import com.alfresco.client.api.core.VersionAPI;
import com.alfresco.client.api.core.model.body.*;
import com.alfresco.client.api.core.model.parameters.IncludeParam;
import com.alfresco.client.api.core.model.parameters.OrderByParam;
import com.alfresco.client.api.core.model.representation.AssociationRepresentation;
import com.alfresco.client.api.core.model.representation.ChildAssociationRepresentation;
import com.alfresco.client.api.core.model.representation.NodeRepresentation;
import com.alfresco.client.api.core.model.representation.VersionRepresentation;
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
        tutorialPart6Associations();
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


    static void tutorialPart5VersioningLocking() throws IOException {

        // Select NodesAPI
        NodesAPI nodesAPI = client.getNodesAPI();

        //Create Empty Node
        NodeBodyCreate emptyFileBody = new NodeBodyCreate("version.txt", ContentModel.TYPE_CONTENT);
        Response<NodeRepresentation> initialNodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, emptyFileBody).execute();

        //Update content as Major Version
        String nodeId = initialNodeResponse.body().getId();
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), "This is the initial content for the file.");
        NodeRepresentation updatedContentNode = nodesAPI.updateNodeContentCall(nodeId, requestBody, true, "First version").execute().body();
        Assert.assertEquals(updatedContentNode.getContent().getSizeInBytes(), 41);
        Assert.assertEquals(updatedContentNode.getProperties().get(ContentModel.PROP_VERSION_LABEL), "1.0");

        //Retrieve version history
        VersionAPI versionAPI = client.getVersionAPI();
        ResultPaging<VersionRepresentation> versions = versionAPI.listVersionHistoryCall(nodeId).execute().body();
        Assert.assertEquals(versions.getCount(), 1);
        Assert.assertEquals(versions.getPagination().getCount(), 1);

        //Update content as minor version
        RequestBody minorRequestBody = RequestBody.create(MediaType.parse("text/plain"), "This is the second version of the content, v1.1.");
        NodeRepresentation minorupdatedContentNode = nodesAPI.updateNodeContentCall(nodeId, minorRequestBody, false, "Second version").execute().body();
        Assert.assertEquals(minorupdatedContentNode.getContent().getSizeInBytes(), 48);
        Assert.assertEquals(minorupdatedContentNode.getProperties().get(ContentModel.PROP_VERSION_LABEL), "1.1");

        //Get Content
        Call<ResponseBody> downloadCall = nodesAPI.getNodeContentCall(nodeId);
        File dlFile = new File("W:\\", "version-1.1.txt");
        IOUtils.copyFile(downloadCall.execute().body().byteStream(), dlFile);
        Assert.assertEquals(dlFile.length(), 48);

        //Retrieve Version Content
        Call<ResponseBody> downloadOriginalCall = versionAPI.getVersionContentCall(nodeId, "1.0");
        File originalFile = new File("W:\\", "version-1.0.txt");
        IOUtils.copyFile(downloadOriginalCall.execute().body().byteStream(), originalFile);
        Assert.assertEquals(originalFile.length(), 41);

        //Revert Version
        RevertBody revertBody = new RevertBody("Reverted to original", true);
        VersionRepresentation versionReverted = versionAPI.revertVersionCall(nodeId, "1.0", revertBody).execute().body();
        Assert.assertEquals(versionReverted.getContent().getSizeInBytes(), 41);
        Assert.assertEquals(versionReverted.getProperties().get(ContentModel.PROP_VERSION_LABEL), "2.0");

        //Lock File
        NodeRepresentation lockedNode = nodesAPI.lockNodeCall(nodeId, new NodeBodyLock(), new IncludeParam(Arrays.asList("isLocked")), null).execute().body();
        Assert.assertTrue(lockedNode.isLocked());
        Assert.assertTrue(lockedNode.getAspects().contains(ContentModel.ASPECT_LOCKABLE));
        Assert.assertEquals(lockedNode.getProperties().get(ContentModel.PROP_LOCK_TYPE), "WRITE_LOCK");
        Assert.assertEquals(lockedNode.getProperties().get(ContentModel.PROP_LOCK_LIFETIME), NodeBodyLock.LifetimeEnum.PERSISTENT.toString());

        //UnLock File
        NodeRepresentation unlockedNode = nodesAPI.unlockNodeCall(nodeId, new NodeBodyUnLock(), new IncludeParam(Arrays.asList("isLocked")), null).execute().body();
        Assert.assertFalse(unlockedNode.isLocked());
        Assert.assertFalse(unlockedNode.getAspects().contains(ContentModel.ASPECT_LOCKABLE));
    }

    static void tutorialPart6Associations() throws IOException {
        // Select NodesAPI
        NodesAPI nodesAPI = client.getNodesAPI();

        //Attempt creation of fdk:gadget node
        NodeBodyCreate emptyFileBody = new NodeBodyCreate("fdk.txt", "fdk:gadget");
        Response<NodeRepresentation> initialNodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, emptyFileBody).execute();
        Assert.assertFalse(initialNodeResponse.isSuccessful());
        Assert.assertEquals(initialNodeResponse.code(), 422);

        //Create Images Folder
        NodeBodyCreate creationBody = new NodeBodyCreate("Images", ContentModel.TYPE_FOLDER);
        Response<NodeRepresentation> folderCreationResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, creationBody).execute();
        Assert.assertTrue(folderCreationResponse.isSuccessful());
        Assert.assertEquals(folderCreationResponse.body().getName(), "Images");

        //Upload First Image
        File file = new File("W:\\image.png");
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filedata", "image.png", requestBody);
        RequestBody fileRequestBody = multipartBuilder.build();

        //Create Content
        Response<NodeRepresentation> firstImageResponse = nodesAPI.createNodeCall(folderCreationResponse.body().getId(), fileRequestBody).execute();

        //Upload Second Image
        file = new File("W:\\image.png");
        requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filedata", "image2.png", requestBody);
        fileRequestBody = multipartBuilder.build();

        //Create Content
        Response<NodeRepresentation> secondImageResponse = nodesAPI.createNodeCall(folderCreationResponse.body().getId(), fileRequestBody).execute();

        //Upload review text
        file = new File("W:\\test.txt");
        requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filedata", "test.txt", requestBody);
        fileRequestBody = multipartBuilder.build();

        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("filedata", fileRequestBody);
        map.put("name", RequestBody.create(MediaType.parse("multipart/form-data"), "review-text.txt"));

        //Create Content
        Response<NodeRepresentation> reviewTextResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, map).execute();

        //Create Amazon company node
        Map<String, Object> props = new HashMap<>();
        props.put("fdk:email", "info@amazon.com");
        props.put("fdk:url", "http://www.amazon.com");
        props.put("fdk:city", "Seattle");

        NodeBodyCreate amazonNode = new NodeBodyCreate("Amazon", "fdk:company", props, null);
        Response<NodeRepresentation> amazonNodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, amazonNode).execute();
        Assert.assertTrue(amazonNodeResponse.isSuccessful());


        //Create fdk:gadget node
        //Secondary Children
        ChildAssociationBody firstImage = new ChildAssociationBody(firstImageResponse.body().getId(), "fdk:images");
        ChildAssociationBody secondImage = new ChildAssociationBody(secondImageResponse.body().getId(), "fdk:images");
        List<ChildAssociationBody> secondaryChildren = Arrays.asList(firstImage, secondImage);

        //Target
        AssociationBody review = new AssociationBody(reviewTextResponse.body().getId(), "fdk:reviews");
        AssociationBody company = new AssociationBody(amazonNodeResponse.body().getId(), "fdk:company");
        List<AssociationBody> targets = Arrays.asList(review, company);

        //Create Gadget
        NodeBodyCreate gadgetNode = new NodeBodyCreate("Amazon Echo", "fdk:gadget", null, null, null, null, secondaryChildren, targets);
        Response<NodeRepresentation> amazonEchoResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, gadgetNode).execute();
        Assert.assertTrue(amazonEchoResponse.isSuccessful());

        //Get fdk:gadget peer associations
        Response<ResultPaging<NodeRepresentation>> targetsAssocsResponse = nodesAPI.listTargetAssociationsCall(amazonEchoResponse.body().getId()).execute();
        Assert.assertTrue(targetsAssocsResponse.isSuccessful());
        Assert.assertEquals(targetsAssocsResponse.body().getCount(), 2);

        //Get fdk:gadget peer associations
        Response<ResultPaging<NodeRepresentation>> targetsAssocsResponse2 = nodesAPI.listTargetAssociationsCall(
                amazonEchoResponse.body().getId(),
                "(assocType='fdk:reviews')",
                new IncludeParam(Arrays.asList("properties", "path")), null).execute();
        Assert.assertTrue(targetsAssocsResponse2.isSuccessful());
        Assert.assertEquals(targetsAssocsResponse2.body().getCount(), 1);

        //Get fdk:gadget secondary child associations
        Response<ResultPaging<NodeRepresentation>> childAssocsResponse = nodesAPI.listSecondaryChildrenCall(amazonEchoResponse.body().getId()).execute();
        Assert.assertTrue(childAssocsResponse.isSuccessful());
        Assert.assertEquals(childAssocsResponse.body().getCount(), 2);

        //Get review text sources
        Response<ResultPaging<NodeRepresentation>> reviewAssocsResponse = nodesAPI.listSourceAssociationsCall(reviewTextResponse.body().getId()).execute();
        Assert.assertTrue(reviewAssocsResponse.isSuccessful());
        Assert.assertEquals(reviewAssocsResponse.body().getCount(), 1);

        //Get first image parents
        Response<ResultPaging<NodeRepresentation>> firstImageParentResponse = nodesAPI.listParentsCall(firstImageResponse.body().getId()).execute();
        Assert.assertTrue(firstImageParentResponse.isSuccessful());
        Assert.assertEquals(firstImageParentResponse.body().getCount(), 2);

        //Upload Third image
        file = new File("W:\\image.png");
        requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filedata", "image3.png", requestBody);
        fileRequestBody = multipartBuilder.build();

        //Create Content
        Response<NodeRepresentation> thirdImageResponse = nodesAPI.createNodeCall(folderCreationResponse.body().getId(), fileRequestBody).execute();

        //Upload second review text
        file = new File("W:\\test.txt");
        requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filedata", "test.txt", requestBody);
        fileRequestBody = multipartBuilder.build();

        HashMap<String, RequestBody> map2 = new HashMap<>();
        map2.put("filedata", fileRequestBody);
        map2.put("name", RequestBody.create(MediaType.parse("multipart/form-data"), "2nd-review-text.txt"));

        //Create Content
        Response<NodeRepresentation> secondReviewTextResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, map2).execute();

        //Create fdk:images child association
        ChildAssociationBody thirdImage = new ChildAssociationBody(thirdImageResponse.body().getId(), "fdk:images");
        Response<ChildAssociationRepresentation> imageAssoc = nodesAPI.createSecondaryChildAssocationCall(amazonEchoResponse.body().getId(), thirdImage, null).execute();
        Assert.assertTrue(imageAssoc.isSuccessful());

        //Create fdk:reviews peer association
        AssociationBody secondReview = new AssociationBody(secondReviewTextResponse.body().getId(), "fdk:reviews");
        Response<AssociationRepresentation> reviewAssoc = nodesAPI.createAssocationCall(amazonEchoResponse.body().getId(), secondReview, null).execute();
        Assert.assertTrue(reviewAssoc.isSuccessful());

        //Multi-file review text
        ChildAssociationBody reviewChild = new ChildAssociationBody(reviewTextResponse.body().getId(), "cm:contains");
        Response<ChildAssociationRepresentation> reviewChildAssoc = nodesAPI.createSecondaryChildAssocationCall(folderCreationResponse.body().getId(), reviewChild, null).execute();
        Assert.assertTrue(reviewChildAssoc.isSuccessful());

        //Get images folder children
        Response<ResultPaging<NodeRepresentation>> imageFolderChildrenResponse =
                nodesAPI.listNodeChildrenCall(folderCreationResponse.body().getId(), null, null, null, null, new IncludeParam(Arrays.asList("association")), null, null, null).execute();
        Assert.assertTrue(imageFolderChildrenResponse.isSuccessful());
        Assert.assertEquals(imageFolderChildrenResponse.body().getCount(), 4);

        //Get images folder primary children only
        Response<ResultPaging<NodeRepresentation>> imageFolderPrimaryChildrenResponse =
                nodesAPI.listNodeChildrenCall(folderCreationResponse.body().getId(), null, null, null, "(isPrimary=true)", null, null, null, null).execute();
        Assert.assertTrue(imageFolderPrimaryChildrenResponse.isSuccessful());
        Assert.assertEquals(imageFolderPrimaryChildrenResponse.body().getCount(), 3);

        //Delete second review text peer association
        Response<Void> deleteAssocResponse = nodesAPI.deleteAssocationCall(amazonEchoResponse.body().getId(), secondReviewTextResponse.body().getId(), "fdk:reviews").execute();
        Assert.assertTrue(deleteAssocResponse.isSuccessful());

        //Delete third image child association
        Response<Void> deleteChildAssocResponse = nodesAPI.deleteSecondaryChildAssocationCall(amazonEchoResponse.body().getId(), thirdImageResponse.body().getId(), "fdk:images").execute();
        Assert.assertTrue(deleteChildAssocResponse.isSuccessful());
    }
}
