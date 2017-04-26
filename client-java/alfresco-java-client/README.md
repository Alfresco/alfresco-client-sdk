# Alfresco Java Client

## Introduction
The idea behind this project is to enable developers to interact easily with Alfresco One Public REST API V1.
To achieve this goal this project provide a **single JAR** file that can be used in Java or Android applications.

### Status
**Please note this project is currently under development and is available only on Early Access Mode**

## Requirements

### Alfresco
Alfresco REST API v1 is currently on Early Access Mode and it's only available with the latest version of Alfresco Community 201606 and onward.
Before using this library you have to install this platform [available here](https://wiki.alfresco.com/wiki/Alfresco_Community_Edition_201606_EA_Release_Notes)

For more information about Alfresco REST API
- ["The Future of REST APIs” Tech Talk Live session](https://www.youtube.com/watch?v=LCw7fe1pVSw)
- ["Alfresco REST API of the future" BeeCon slides](http://www.slideshare.net/jvonka/alfresco-rest-api-of-the-future-is-closer-than-you-think)
- [Alfresco Core REST API](https://api-explorer.alfresco.com/api-explorer/)

## Installation

### MAVEN

```xml
<dependency>
  <groupId>org.alfresco.client</groupId>
  <artifactId>alfresco-java-client</artifactId>
  <version>1.0.0-beta1</version>
</dependency>
```

### GRADLE
```gradle
compile 'org.alfresco.client:alfresco-java-client:1.0.0-beta1'
```


## Usage


### Create Client/Session Object

**Basic Auth**
```java
AlfrescoClient client = new AlfrescoClient.Builder().connect(endpoint, username, password).build();
```

**Ticket based (like SAML or Alfresco Ticket)**
```java
AlfrescoClient client =  new AlfrescoClient.Builder().connectWithTicket(baseUrl, ticketValue).build();
```

**Token based (like oAuth)**
```java
AlfrescoClient client =  new AlfrescoClient.Builder().connectWithToken(baseUrl, tokenValue).build();
```


### Create Services
```java
//Retrieve user activities and site activities
ActivityStreamAPI activityAPI = client.getActivityStreamAPI();

//Retrieve and manage comments
CommentAPI commentAPI = client.getCommentsAPI();

//Retrieve Favorites information, 
FavoritesAPI favoritesAPI = client.getFavoritesAPI();

//Retrieve and manage file/folder (bound to 5.1 File/Folder API)
NodesAPI nodesAPI = client.getNodesAPI();

//Retrieve user information, 
PeopleAPI peopleAPI = client.getPeopleAPI();

//Retrieve and manage ratings
RatingsAPI ratingAPI = client.getRatingsAPI();

//Retrieve and manage sites informations
SitesAPI siteAPI = client.getSitesAPI();

//Retrieve and manage tags 
TagAPI tagAPI = client.getTagsAPI();

//Retrieve and manage tags 
RenditionsAPI renditionAPI = client.getRenditionsAPI();

//Retrieve and manage Shared Links 
SharedLinksAPI sharedLinkAPI = client.getSharedLinksAPI();

//Retrieve and manage Trashcan 
TrashcanAPI trashcanAPI = client.getTrashcanAPI();

```

### Retrieve Company Home (Root Folder) Information

**Synchronuously**
```java
Response<NodeRepresentation> response = client.getNodesAPI().getNodeCall(NodeAPI.FOLDER_ROOT).execute();
```

**Asynchronuously**
```java
 client.getNodesAPI().getNodeCall(NodesAPI.FOLDER_ROOT).enqueue(new Callback<NodeRepresentation>() {
            @Override
            public void onResponse(Call<NodeRepresentation> call, Response<NodeRepresentation> response)
                //TODO When response is correct
            }

            @Override
            public void onFailure(Call<NodeRepresentation> call, Throwable t)
                //TODO When request has failed
            }
        });
```

**RxJava**
```java
nodesAPI.getNodeObservable(NodeAPI.FOLDER_ROOT).subscribe(root -> Assert.assertEquals(root.getName(), "Company Home"));
```

### Create, Edit & Delete Folder
```java
 // Retrieve NODE API
 NodesAPI nodeService = client.getNodesAPI();

 // Retrieve Company Home
 Response<NodeRepresentation> response = nodeService.getNode(ApiNode.FOLDER_ROOT).execute();
 NodeRepresentation rootNode = response.body();

 //Create a Folder
 CreateNodeRequest request = new CreateNodeRequest("Test", "cm:folder");
 Response<NodeRepresentation> testNodeResponse = nodeService.createNode(rootNode.getId(), request).execute();
 NodeRepresentation testNode = testNodeResponse.body();

 //Rename Folder
 EditNodeRequest renameRequest = new EditNodeRequest("TestV2");
 Response<NodeRepresentation> updatedResponse = nodeService.editNode(testNode.getIdentifier(), renameRequest).execute();

 //Delete Node
 Response<Void> deleteResponse = nodeService.removeNode(testNode.getIdentifier()).execute();
 Assert.assertEquals(deleteResponse.isSuccess(), true);

```

### Print the Number of site (RxJava)
```java
//Print the number of sites
nodesAPI.getNodeObservable(NodesAPI.FOLDER_ROOT)
        .flatMap(node -> nodesAPI.getChildrenObservable(node.getIdentifier()))
        .flatMap(nodes -> Observable.from(nodes.getList()))
        .filter(node -> node.isFolder() && "Sites".equals(node.getName()))
        .flatMap(siteNode -> nodesAPI.getChildrenObservable(siteNode.getIdentifier()))
        .subscribe(sites -> System.out.println(sites.getPagination().getTotalItems()));
```

### Others

You can retrieve other usage of the lib in [unit tests defined here](src/test/java/com/alfresco/client/api/tests)

## Running tests

### Requirements

Tests can be executed only with the latest version of Alfresco One i.e Alfresco One Enterprise 5.2 or Alfresco Community 201609 and onwards.

### Usage 

Tests can be executed with a fresh Alfresco install on localhost:8080 with user admin/admin

Want to manage other tests ?
Replace all TEST_X in [Client API: AlfrescoAPITestCase](src/test/java/com/alfresco/client/api/AlfrescoAPITestCase.java)
