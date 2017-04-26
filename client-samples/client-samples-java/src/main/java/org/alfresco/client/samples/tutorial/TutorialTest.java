package org.alfresco.client.samples.tutorial;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.testng.Assert;

import com.alfresco.client.AlfrescoClient;
import com.alfresco.client.api.common.constant.ContentModel;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.*;
import com.alfresco.client.api.core.model.body.*;
import com.alfresco.client.api.core.model.parameters.IncludeParam;
import com.alfresco.client.api.core.model.parameters.OrderByParam;
import com.alfresco.client.api.core.model.representation.*;
import com.alfresco.client.api.search.SearchAPI;
import com.alfresco.client.api.search.body.*;
import com.alfresco.client.api.search.model.ResultNodeRepresentation;
import com.alfresco.client.api.search.model.ResultSetRepresentation;
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
        tutorialPart11Trashcan();
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
        NodeBodyCreate nodeBodyCreate = new NodeBodyCreate("My Folder", ContentModel.TYPE_FOLDER);
        Response<NodeRepresentation> nodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, nodeBodyCreate).execute();
        NodeRepresentation folder = nodeResponse.body();
        Assert.assertEquals(folder.getName(), "My Folder");

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

    static void tutorialPart7Collaboration() throws IOException
    {
        // Select NodesAPI
        NodesAPI nodesAPI = client.getNodesAPI();

        //Create Content
        NodeBodyCreate emptyFileBody = new NodeBodyCreate("collaboration.txt", ContentModel.TYPE_CONTENT);
        Response<NodeRepresentation> emptyNodeResponse = nodesAPI.createNodeCall(NodesAPI.FOLDER_MY, emptyFileBody).execute();
        NodeRepresentation emptyNode = emptyNodeResponse.body();
        Assert.assertEquals(emptyNode.getContent().getSizeInBytes(), 0);

        ////////////////////////////////////////
        // COMMENTS
        ////////////////////////////////////////
        //Setting up Comments API
        CommentsAPI commentsAPI = client.getCommentsAPI();

        //Add a comment
        String commentValue = "This is my comment";
        CommentBody commentBody = new CommentBody(commentValue);
        Response<CommentRepresentation> commentResponse = commentsAPI.createCommentCall(emptyNode.getId(), commentBody).execute();
        CommentRepresentation commentRepresentation = commentResponse.body();
        Assert.assertEquals(commentRepresentation.getContent(), commentValue);
        Assert.assertEquals(commentRepresentation.getCreatedBy().getId(), "admin");

        //Retrieve Comment
        Response<ResultPaging<CommentRepresentation>> commentsListResponse = commentsAPI.listCommentsCall(emptyNode.getId()).execute();
        ResultPaging<CommentRepresentation> commentListing = commentsListResponse.body();
        Assert.assertEquals(commentListing.getCount(), 1);
        Assert.assertEquals(commentListing.getList().get(0), commentRepresentation);
        Assert.assertEquals(commentListing.getList().get(0).getCanEdit(), Boolean.TRUE);
        Assert.assertEquals(commentListing.getList().get(0).getCanDelete(), Boolean.TRUE);

        //Update Comment
        String updatedCommentValue = "Updated comment";
        CommentBody updatedCommentBody = new CommentBody(updatedCommentValue);
        Response<CommentRepresentation> updatedCommentResponse = commentsAPI.updateCommentCall(emptyNode.getId(), commentRepresentation.getId(), updatedCommentBody).execute();
        CommentRepresentation updatedCommentRepresentation = updatedCommentResponse.body();
        Assert.assertEquals(updatedCommentRepresentation.getContent(), updatedCommentValue);
        //Uncomment to test async flag issue
        //Assert.assertEquals(updatedCommentRepresentation.isEdited(), Boolean.TRUE);

        //Delete Comment
        Response<Void> deleteResponse = commentsAPI.deleteCommentCall(emptyNode.getId(), commentRepresentation.getId()).execute();
        Assert.assertEquals(deleteResponse.isSuccessful(), true);
        Assert.assertEquals(commentsAPI.listCommentsCall(emptyNode.getId()).execute().body().getCount(), 0);

        ////////////////////////////////////////
        // RATINGS
        ////////////////////////////////////////
        //Setting up Ratings API
        RatingsAPI ratingsAPI = client.getRatingsAPI();

        //Like a node
        RatingBody likeBody = new RatingBody(RatingsAPI.LIKES, true);
        Response<RatingRepresentation> likeResponse = ratingsAPI.rateNodeCall(emptyNode.getId(), likeBody).execute();
        Assert.assertEquals(likeResponse.body().getId(), RatingsAPI.LIKES);
        Assert.assertEquals(likeResponse.body().getMyRating(), Boolean.TRUE);
        Assert.assertEquals(likeResponse.body().getAggregate().getNumberOfRatings(), (Integer) 1);

        //Retrieve Ratings
        Response<ResultPaging<RatingRepresentation>> ratingListingResponse = ratingsAPI.listRatingsCall(emptyNode.getId()).execute();
        ResultPaging<RatingRepresentation> ratingListing = ratingListingResponse.body();
        Assert.assertEquals(ratingListing.getCount(), 2);
        Assert.assertEquals(ratingListing.getList().get(0).getId(),RatingsAPI.FIVE_STAR);
        Assert.assertEquals(ratingListing.getList().get(1).getId(),RatingsAPI.LIKES);

        //Unlike a node
        Response<Void> unlikeResponse = ratingsAPI.deleteRatingCall(emptyNode.getId(), RatingsAPI.LIKES).execute();
        Assert.assertEquals(unlikeResponse.isSuccessful(), true);

        //Retrieve Like Rating
        Response<RatingRepresentation> ratingRepresentationResponse = ratingsAPI.getRatingCall(emptyNode.getId(), RatingsAPI.LIKES).execute();
        Assert.assertNull(ratingRepresentationResponse.body().getMyRating());
        Assert.assertEquals(ratingRepresentationResponse.body().getAggregate().getNumberOfRatings(), (Integer) 0);

        ////////////////////////////////////////
        // TAGGING
        ////////////////////////////////////////
        //Setting up Tagging API
        TagsAPI tagsApi = client.getTagsAPI();

        //Add Blog Tag
        String blog = "blog";
        TagBody tagBody = new TagBody(blog);
        Response<TagRepresentation> tagRepresentationResponse = tagsApi.createTagForNodeCall(emptyNode.getId(), tagBody).execute();
        TagRepresentation tagBlog = tagRepresentationResponse.body();
        Assert.assertEquals(tagBlog.getTag(), blog);

        //Add Post Tag
        String post = "post";
        TagBody tag2Body = new TagBody(post);
        Response<TagRepresentation> tag2RepresentationResponse = tagsApi.createTagForNodeCall(emptyNode.getId(), tag2Body).execute();
        Assert.assertEquals(tag2RepresentationResponse.body().getTag(), post);

        //Retrieve node Tags
        Response<ResultPaging<TagRepresentation>> tagListResponse = tagsApi.listTagsForNodeCall(emptyNode.getId()).execute();
        ResultPaging<TagRepresentation> tagList = tagListResponse.body();
        Assert.assertEquals(tagList.getCount(), 2);
        Assert.assertEquals(tagList.getList().get(0).getTag(), blog);
        Assert.assertEquals(tagList.getList().get(1).getTag(), post);

        //Retrieve Repository Tags
        Response<ResultPaging<TagRepresentation>> tagRepoListResponse = tagsApi.listTagsCall().execute();
        ResultPaging<TagRepresentation> tagRepoList = tagRepoListResponse.body();
        Assert.assertEquals(tagRepoList.getCount(), 2);
        Assert.assertEquals(tagRepoList.getList().get(0).getTag(), blog);
        Assert.assertEquals(tagRepoList.getList().get(1).getTag(), post);

        //Delete Tag from Node
        Response<Void> deleteTagResponse = tagsApi.deleteTagFromNodeCall(emptyNode.getId(), tagBlog.getId()).execute();
        Assert.assertEquals(deleteTagResponse.isSuccessful(), true);
        Assert.assertEquals(tagsApi.listTagsForNodeCall(emptyNode.getId()).execute().body().getCount(), 1);
    }

    static void tutorialPart8Sites() throws IOException{

        // Select PeopleAPI
        PeopleAPI peopleAPI = client.getPeopleAPI();

        //Create Test user
        /*PersonBodyCreate personBodyCreate = new PersonBodyCreate("test", "Test", "User", "test@alfresco.com", "test");
        Response<PersonRepresentation> personRepresentationResponse = peopleAPI.createPersonCall(personBodyCreate).execute();
        PersonRepresentation personRepresentation = personRepresentationResponse.body();
        Assert.assertEquals(personRepresentation.getId(), "test");*/


        // Create new Client and connect with new user test/test user
        client = new AlfrescoClient.Builder().httpLogging(HttpLoggingInterceptor.Level.BODY)
                .connect("http://localhost:8080/alfresco", "test", "test").build();

        //Create a public Site
        SitesAPI sitesAPI = client.getSitesAPI();

        //Create public site
        /*SiteBodyCreate siteBodyCreate = new SiteBodyCreate("publicSite", "Public Site", "Public site created for blog post", SiteVisibilityEnum.PUBLIC);
        Response<SiteRepresentation> siteRepresentationResponse = sitesAPI.createSiteCall(siteBodyCreate).execute();
        SiteRepresentation siteRepresentation = siteRepresentationResponse.body();
        Assert.assertEquals(siteRepresentation.getId(), "publicSite");
        Assert.assertEquals(siteRepresentation.getVisibilityEnum(), SiteVisibilityEnum.PUBLIC);
        Assert.assertEquals(siteRepresentation.getRole(), "SiteManager");

        //Retrieve document library container
        Response<SiteContainerRepresentation> doclibContainerResponse = sitesAPI.getSiteContainerCall("publicSite", "documentLibrary").execute();
        SiteContainerRepresentation doclibContainer = doclibContainerResponse.body();
        Assert.assertEquals(doclibContainer.getFolderId(), "documentLibrary");

        //Update site description
        SiteBodyUpdate update = new SiteBodyUpdate("Public site created for blog post - part 8");
        Response<SiteRepresentation> siteRepresentationResponse = sitesAPI.updateSiteCall("publicSite", update).execute();
        SiteRepresentation siteRepresentation = siteRepresentationResponse.body();
        Assert.assertEquals(siteRepresentation.getId(), "publicSite");
        Assert.assertEquals(siteRepresentation.getDescription(), "Public site created for blog post - part 8");*/

        // Create Moderated Site
        /*SiteBodyCreate siteBodyCreate = new SiteBodyCreate("moderatedSite", "Moderated Site",
                "Moderated site created for blog post", SiteVisibilityEnum.MODERATED);
        Response<SiteRepresentation> siteRepresentationResponse = sitesAPI.createSiteCall(siteBodyCreate).execute();
        SiteRepresentation siteRepresentation = siteRepresentationResponse.body();
        Assert.assertEquals(siteRepresentation.getId(), "moderatedSite");
        Assert.assertEquals(siteRepresentation.getVisibilityEnum(), SiteVisibilityEnum.MODERATED);
        Assert.assertEquals(siteRepresentation.getRole(), "SiteManager");

        // Create 2nd Test user
        PersonBodyCreate personBodyCreate = new PersonBodyCreate("test2", "Test", "User2", "test2@alfresco.com",
                "test2");
        Response<PersonRepresentation> personRepresentationResponse = peopleAPI.createPersonCall(personBodyCreate)
                .execute();
        PersonRepresentation personRepresentation = personRepresentationResponse.body();
        Assert.assertEquals(personRepresentation.getId(), "test2");*/

        // Create new Client and connect with new user test2/test2 user
        AlfrescoClient client2 = new AlfrescoClient.Builder().httpLogging(HttpLoggingInterceptor.Level.BODY)
                .connect("http://localhost:8080/alfresco", "test2", "test2").build();

        // Join public site
        /*SiteMembershipRequestBodyCreate requestBodyCreate = new SiteMembershipRequestBodyCreate("publicSite");
        Response<SiteMembershipRequestRepresentation> publicSiteRepresentationResponse = client2.getSitesAPI()
                .createSiteMembershipRequestForPersonCall("test2", requestBodyCreate, null).execute();
        SiteMembershipRequestRepresentation requestRepresentation = publicSiteRepresentationResponse.body();
        Assert.assertEquals(requestRepresentation.getSite().getRole(), "SiteConsumer");
        Assert.assertEquals(requestRepresentation.getSite().getId(), "publicSite");
        Assert.assertEquals(requestRepresentation.getId(), "publicSite");

        // Join moderated site
        SiteMembershipRequestBodyCreate requestModeratedBodyCreate = new SiteMembershipRequestBodyCreate(
                "moderatedSite", "I would like to join this site as it looks interesting", null);
        Response<SiteMembershipRequestRepresentation> moderatedSiteRepresentationResponse = client2.getSitesAPI()
                .createSiteMembershipRequestForPersonCall("test2", requestModeratedBodyCreate, null).execute();
        SiteMembershipRequestRepresentation moderatedRequestRepresentation = moderatedSiteRepresentationResponse.body();
        Assert.assertNull(moderatedRequestRepresentation.getSite().getRole());
        Assert.assertEquals(moderatedRequestRepresentation.getSite().getId(), "moderatedSite");
        Assert.assertEquals(moderatedRequestRepresentation.getId(), "moderatedSite");
        
        // Review site membership requests
        ResultPaging<SiteMembershipRequestRepresentation> siteMembershipRequestPaging = client2.getSitesAPI()
                .listSiteMembershipRequestsForPersonCall("test2").execute().body();
        Assert.assertEquals(siteMembershipRequestPaging.getCount(), 1);
        Assert.assertEquals(siteMembershipRequestPaging.getList().get(0).getId(), "moderatedSite");*/

        //List site members
       /* ResultPaging<SiteMemberRepresentation> siteMembers = client2.getSitesAPI().listSiteMembershipsCall("publicSite").execute().body();
        Assert.assertEquals(siteMembers.getCount(), 2);
        Assert.assertEquals(siteMembers.getList().size(), 2);

        //List my sites
        ResultPaging<SiteRoleRepresentation> mySites = client2.getSitesAPI().listSiteMembershipsForPersonCall("test2").execute().body();
        Assert.assertEquals(mySites.getCount(), 1);
        Assert.assertEquals(mySites.getList().get(0).getRole(), "SiteConsumer");

        //List all sites
        ResultPaging<SiteRepresentation> allSites = client2.getSitesAPI().listSitesCall().execute().body();
        Assert.assertEquals(allSites.getCount(), 3);

        //Find site
        ResultPaging<SiteRepresentation> findSites = client2.getQueriesAPI().findSitesCall("public").execute().body();
        Assert.assertEquals(findSites.getCount(), 1);
        Assert.assertEquals(findSites.getList().get(0).getId(), "publicSite");

        //Leave Site
        Response<Void> leaveSiteResponse = client2.getSitesAPI().deleteSiteMembershipForPersonCall("test2", "publicSite").execute();
        Assert.assertEquals(leaveSiteResponse.isSuccessful(), true);
        Assert.assertEquals(client2.getSitesAPI().listSiteMembershipsForPersonCall("test2").execute().body().getCount(), 0);*/

        // Add Site Member
        /*SiteMembershipBodyCreate siteMembershipBodyCreate = new SiteMembershipBodyCreate("test2", "SiteContributor");
        SiteMemberRepresentation siteMember = client.getSitesAPI()
                .createSiteMembershipCall("publicSite", siteMembershipBodyCreate, null).execute().body();
        Assert.assertEquals(siteMember.getRole(), "SiteContributor");
        Assert.assertEquals(siteMember.getId(), "test2");
        Assert.assertEquals(client2.getSitesAPI().listSiteMembershipsForPersonCall("test2").execute().body().getCount(), 1);*/

        //Change member role
        SiteMembershipBodyUpdate siteMembershipBodyUpdate = new SiteMembershipBodyUpdate("SiteManager");
        SiteMemberRepresentation siteMemberUpdated = client.getSitesAPI()
                .updateSiteMembershipCall("publicSite", "test2", siteMembershipBodyUpdate, null).execute().body();
        Assert.assertEquals(siteMemberUpdated.getRole(), "SiteManager");
        Assert.assertEquals(siteMemberUpdated.getId(), "test2");
        Assert.assertEquals(client2.getSitesAPI().listSiteMembershipsForPersonCall("test2").execute().body().getCount(), 1);

        //Delete Site
        Response<Void> deleteSiteResponse = client.getSitesAPI().deleteSiteCall("publicSite").execute();
        Assert.assertTrue(deleteSiteResponse.isSuccessful());
    }

    static void tutorialPart9Queries() throws IOException
    {
        //Create a public Site
        SitesAPI sitesAPI = client.getSitesAPI();

        //Create public site
        /*SiteBodyCreate siteBodyCreate = new SiteBodyCreate("queriesSearchSite", "Queries and Search Site", "Site created for queries and search blog post", SiteVisibilityEnum.PUBLIC);
        Response<SiteRepresentation> siteRepresentationResponse = sitesAPI.createSiteCall(siteBodyCreate).execute();
        SiteRepresentation siteRepresentation = siteRepresentationResponse.body();
        Assert.assertEquals(siteRepresentation.getId(), "queriesSearchSite");
        Assert.assertEquals(siteRepresentation.getVisibilityEnum(), SiteVisibilityEnum.PUBLIC);

        //Retrieve Document Library Container
        Response<SiteContainerRepresentation> doclibContainerResponse = sitesAPI.getSiteContainerCall("queriesSearchSite", "documentLibrary").execute();
        SiteContainerRepresentation doclibContainer = doclibContainerResponse.body();
        Assert.assertEquals(doclibContainer.getFolderId(), "documentLibrary");

         //Create text file
         File file = new File("W:\\test.txt");
         RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
         MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
         multipartBuilder.addFormDataPart("filedata", "test.txt", requestBody);
         RequestBody fileRequestBody = multipartBuilder.build();
         client.getNodesAPI().createNodeCall(doclibContainer.getId(), fileRequestBody).execute();

        //Create image file
        file = new File("W:\\image.png");
        requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filedata", "image.png", requestBody);
        fileRequestBody = multipartBuilder.build();
        client.getNodesAPI().createNodeCall(doclibContainer.getId(), fileRequestBody).execute();*/

        //Nodes query
        /*ResultPaging<NodeRepresentation> loremResult = client.getQueriesAPI().findNodesCall("lorem").execute().body();
        Assert.assertTrue(loremResult.getCount() >= 7);

        //Sites query
        ResultPaging<SiteRepresentation> siteResult = client.getQueriesAPI().findSitesCall("queries").execute().body();
        Assert.assertEquals(siteResult.getCount(), 1);
        Assert.assertEquals(siteResult.getList().get(0).getId(), "queriesSearchSite");

        //People Query
        ResultPaging<PersonRepresentation> personResult = client.getQueriesAPI().findPeopleCall("jackson").execute().body();
        Assert.assertEquals(personResult.getCount(), 1);
        Assert.assertEquals(personResult.getList().get(0).getId(), "mjackson");*/


        // Basic Search
        SearchAPI searchAPI = client.getSearchAPI();

       /* QueryBody body = new QueryBody().query(new RequestQuery().query("lorem"));
        ResultSetRepresentation<ResultNodeRepresentation> loremSearchResult = searchAPI.searchCall(body).execute().body();
        Assert.assertTrue(loremSearchResult.getCount() >= 7);

        // Basic CMIS Search
        RequestQuery cmisQuery = new RequestQuery().query("select * from cmis:document WHERE cmis:name LIKE 'test.%'")
                .language(RequestQuery.LanguageEnum.CMIS);
        QueryBody cmisbody = new QueryBody().query(cmisQuery);
        ResultSetRepresentation<ResultNodeRepresentation> cmisResult = searchAPI.searchCall(cmisbody).execute().body();
        Assert.assertTrue(cmisResult.getCount() >= 1);

        // Basic Lucene Search
        RequestQuery luceneQuery = new RequestQuery().query("+@cm\\:modified:[NOW/DAY-7DAYS TO NOW/DAY+1DAY] +TYPE:\"cm:content\"")
                .language(RequestQuery.LanguageEnum.LUCENE);
        QueryBody lucenebody = new QueryBody().query(luceneQuery);
        ResultSetRepresentation<ResultNodeRepresentation> luceneResult = searchAPI.searchCall(lucenebody).execute().body();
        Assert.assertTrue(luceneResult.getCount() == 100);

        //Search with Paging & Sorting
        RequestQuery pagingQuery = new RequestQuery().query("+TYPE:\"cm:content\"").language(RequestQuery.LanguageEnum.AFTS);

        List<RequestSortDefinition> sortDefinitions = Arrays.asList(
                new RequestSortDefinition().type(RequestSortDefinition.TypeEnum.FIELD).field("cm:name").ascending(false));

        RequestPagination pagination = new RequestPagination().skipCount(10).maxItems(25);

        QueryBody pagingQueryBody = new QueryBody().query(pagingQuery).sort(sortDefinitions).paging(pagination);
        ResultSetRepresentation<ResultNodeRepresentation> pagingResult = searchAPI.searchCall(pagingQueryBody).execute().body();
        Assert.assertTrue(pagingResult.getCount() == 25);
        Assert.assertEquals(pagingResult.getPagination().getMaxItems(), 25);
        Assert.assertEquals(pagingResult.getPagination().getSkipCount(), 10);*/

        //Search with Facets
        RequestQuery facetQuery = new RequestQuery().query("(name:\"test*\" OR title:\"test*\") AND TYPE:\"cm:content\"");

        List<RequestFacetQuery> facetsQuery = Arrays.asList(
                new RequestFacetQuery().query("content.size:[0 TO 10240]").label("Small Files"),
                new RequestFacetQuery().query("content.mimetype:'text/plain'").label("Plain Text"),
                new RequestFacetQuery().query("content.mimetype:'image/jpeg' OR content.mimetype:'image/png' OR content.mimetype:'image/gif'").label("Images"),
                new RequestFacetQuery().query("content.mimetype:'application/msword' OR content.mimetype:'application/vnd.ms-excel'").label("Office")
                );

        RequestFacetFields facetFields = new RequestFacetFields().facets(Arrays.asList(new RequestFacetFieldsFacets().field("creator")));

        QueryBody facetQueryBody = new QueryBody().query(facetQuery).facetQueries(facetsQuery).facetFields(facetFields);
        ResultSetRepresentation<ResultNodeRepresentation> facetResult = searchAPI.searchCall(facetQueryBody).execute().body();
        Assert.assertTrue(facetResult.getCount() >= 3);
        Assert.assertEquals(facetResult.getContext().getFacetQueries().size(), 4);
        Assert.assertEquals(facetResult.getContext().getFacetFields().get(0).getBuckets().size(), 2);
        Assert.assertEquals(facetResult.getList().size(), 3);

        //Search with term highlighting
        RequestQuery highlightQuery = new RequestQuery().query("(name:\"test*\" OR title:\"test*\") AND TYPE:\"cm:content\"");

        List<RequestHighlightField> highlightField = Arrays.asList(
                new RequestHighlightField().field("cm:name").prefix("(").postfix(")"),
                new RequestHighlightField().field("{http://www.alfresco.org/model/content/1.0}title")
        );

        RequestHighlight highlight = new RequestHighlight().fields(highlightField);

        QueryBody highlightQueryBody = new QueryBody().query(highlightQuery).highlight(highlight);
        ResultSetRepresentation<ResultNodeRepresentation> highlightResult = searchAPI.searchCall(highlightQueryBody).execute().body();
        Assert.assertTrue(highlightResult.getCount() >= 3);
        Assert.assertEquals(highlightResult.getList().size(), 3);
        Assert.assertEquals(highlightResult.getList().get(0).getSearch().getHighlight().size(), 2);
    }

    static void tutorialPart10People() throws IOException{
        //Create Person
        PeopleAPI peopleAPI = client.getPeopleAPI();

        PersonBodyCreate bodyCreate = new PersonBodyCreate("jdoe").firstName("John").lastName("Doe")
                .email("john.doe@example.com").password("jdoe").skypeId("johndoe_skype").jobTitle("Software Engineer");

        PersonRepresentation personRepresentation = peopleAPI.createPersonCall(bodyCreate).execute().body();
        Assert.assertEquals(personRepresentation.getId(), "jdoe");
        Assert.assertEquals(personRepresentation.getFirstName(), "John");
        Assert.assertEquals(personRepresentation.getLastName(), "Doe");
        Assert.assertEquals(personRepresentation.getEmail(), "john.doe@example.com");
        Assert.assertEquals(personRepresentation.getSkypeId(), "johndoe_skype");
        Assert.assertEquals(personRepresentation.getJobTitle(), "Software Engineer");

        //List People
        ResultPaging<PersonRepresentation> personList = peopleAPI.listPeopleCall().execute().body();
        Assert.assertEquals(personList.getCount(), 7);

        //Find People
        ResultPaging<PersonRepresentation> searchPersonList = client.getQueriesAPI().findPeopleCall("jdoe").execute().body();
        Assert.assertEquals(searchPersonList.getCount(), 1);
        Assert.assertEquals(searchPersonList.getList().get(0).getId(), "jdoe");

        //Person Details
        PersonRepresentation jdoeDetails = peopleAPI.getPersonCall("jdoe").execute().body();
        Assert.assertEquals(jdoeDetails.getId(), "jdoe");
        Assert.assertEquals(jdoeDetails.getFirstName(), "John");
        Assert.assertEquals(jdoeDetails.getLastName(), "Doe");
        Assert.assertEquals(jdoeDetails.getEmail(), "john.doe@example.com");
        Assert.assertEquals(jdoeDetails.getSkypeId(), "johndoe_skype");
        Assert.assertEquals(jdoeDetails.getJobTitle(), "Software Engineer");

        //Update Person Details
        PersonBodyUpdate bodyUpdate = new PersonBodyUpdate().firstName("Johnathon").mobile("07000 123456");

        PersonRepresentation updatedPerson = peopleAPI.updatePersonCall("jdoe", bodyUpdate, null).execute().body();
        Assert.assertEquals(updatedPerson.getMobile(), "07000 123456");
        Assert.assertEquals(updatedPerson.getFirstName(), "Johnathon");

        //Change Password
        PersonBodyUpdate changePassword = new PersonBodyUpdate().oldPassword("jdoe").password("my-new-password");

        PersonRepresentation updatedPPerson = peopleAPI.updatePersonCall("jdoe", changePassword, null).execute().body();


        //Disable Person
        PersonBodyUpdate disablePersonBody = new PersonBodyUpdate().enabled(false);

        PersonRepresentation disablePerson = peopleAPI.updatePersonCall("jdoe", disablePersonBody, null).execute().body();
        Assert.assertEquals(disablePerson.isEnabled(), Boolean.FALSE);
    }

    static void tutorialPart11Trashcan() throws IOException {

        //Create text file
        File file = new File("W:\\test.txt");
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.addFormDataPart("filedata", "content-to-be-deleted.txt", requestBody);
        RequestBody fileRequestBody = multipartBuilder.build();
        NodeRepresentation nodeToDelete = client.getNodesAPI().createNodeCall(NodesAPI.FOLDER_MY, fileRequestBody).execute().body();

        //Delete file
        client.getNodesAPI().deleteNodeCall(nodeToDelete.getId()).execute();
        Assert.assertFalse(client.getNodesAPI().getNodeCall(nodeToDelete.getId()).execute().isSuccessful());

        //List deleted Nodes
        TrashcanAPI trashcanAPI = client.getTrashcanAPI();
        ResultPaging<DeletedNodeRepresentation> deletedNodes = trashcanAPI.listDeletedNodesCall().execute().body();
        Assert.assertTrue(deletedNodes.getCount() > 10);

        //Deleted Node details
        DeletedNodeRepresentation deletedNodeInfo = trashcanAPI.getDeletedNodeCall(nodeToDelete.getId()).execute().body();
        Assert.assertEquals(deletedNodeInfo.getId() , nodeToDelete.getId());

        //Restore node
        NodeRepresentation restoredNode = trashcanAPI.restoreDeletedNodeCall(nodeToDelete.getId(), null).execute().body();
        Assert.assertEquals(restoredNode.getId() , nodeToDelete.getId());
        Assert.assertTrue(client.getNodesAPI().getNodeCall(nodeToDelete.getId()).execute().isSuccessful());

        //Permanently delete node
        client.getNodesAPI().deleteNodeCall(nodeToDelete.getId()).execute();
        Response<Void> purgedNodeResponse = trashcanAPI.purgeDeletedNodeCall(restoredNode.getId()).execute();
        Assert.assertTrue(purgedNodeResponse.isSuccessful());
        Assert.assertFalse(client.getNodesAPI().getNodeCall(nodeToDelete.getId()).execute().isSuccessful());
    }
}
