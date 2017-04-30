# Alfresco Content Services - Java Client (Early Access)

## Introduction
The idea behind this project is to enable developers to interact easily with Alfresco Content Services Public REST API V1.
To achieve this goal this project provide a **single JAR** file that can be used in Java or Android applications.

### Status
**Please note this project is currently under development and is available only on Early Access Mode**

## Requirements

### Alfresco
Alfresco REST API v1 is available since **Alfresco Community Edition 201606** and onward or **Alfresco Content Services 5.2 EE** and onward 
We strongly recommend to use the latest version of each edition i.e **Alfresco Community Edition 201704** or **Alfresco Content Services 5.2 EE**

**Alfresco Community Edition 201704** is [available here](https://community.alfresco.com/docs/DOC-6829-draft-alfresco-community-edition-201704-ga-release-draft)

## Installation

### MAVEN

```xml
<dependency>
  <groupId>org.alfresco.client</groupId>
  <artifactId>content-services</artifactId>
  <version>1.0.0-beta2</version>
</dependency>
```

### GRADLE
```gradle
compile 'org.alfresco.client:content-services:1.0.0-beta2'
```

## Usage


### Create Client/Session Object

**Basic Auth**
```java
CSClient client = new CSClient.Builder().connect(endpoint, username, password).build();
```

**Ticket based (like SAML or Alfresco Ticket)**
```java
CSClient client =  new CSClient.Builder().connectWithTicket(baseUrl, ticketValue).build();
```

**Token based (like oAuth)**
```java
CSClient client =  new CSClient.Builder().connectWithToken(baseUrl, tokenValue).build();
```


### Create Services
```java
//Retrieve user activities and site activities
ActivitiesAPI activityAPI = client.getActivitiesAPI();

//Retrieve and manage comments
CommentsAPI commentAPI = client.getCommentsAPI();

//Retrieve Favorites information, 
FavoritesAPI favoritesAPI = client.getFavoritesAPI();

//Retrieve and manage networks
NetworksAPI networksAPI = client.getNetworksAPI();

//Retrieve and manage file/folder (bound to 5.1 File/Folder API)
NodesAPI nodesAPI = client.getNodesAPI();

//Retrieve user information
PeopleAPI peopleAPI = client.getPeopleAPI();

//Retrieve user preferences,
PreferencesAPI preferencesAPI = client.getPreferencesAPI();

// Find nodes, sites, and people using a simple search term
QueriesAPI queriesAPI = client.getQueriesAPI();

//Retrieve and manage ratings
RatingsAPI ratingAPI = client.getRatingsAPI();

//Retrieve and manage tags 
RenditionsAPI renditionAPI = client.getRenditionsAPI();

//Retrieve and manage Shared Links 
SharedLinksAPI sharedLinkAPI = client.getSharedLinksAPI();

//Retrieve and manage sites informations
SitesAPI siteAPI = client.getSitesAPI();

//Retrieve and manage tags 
TagAPI tagAPI = client.getTagsAPI();

//Retrieve and manage Trashcan 
TrashcanAPI trashcanAPI = client.getTrashcanAPI();

//Retrieve and manage Versionning
VersionAPI versionAPI = client.getVersionAPI();

//Search
SearchAPI searchAPI = client.getSearchAPI();

//Get Repository Information
DiscoveryAPI discoveryAPI = client.getDiscoveryAPI();

//Ticket Authentication
Authentication authenticationAPI = client.getAuthentication();

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

You can retrieve other usage of the lib in [unit tests defined here](src/test/java/com/alfresco/client/services/content)

## Running tests

### Requirements

Tests can be executed only with **Alfresco Community Edition 201606** and onward or **Alfresco Content Services 5.2 EE** and onward 

### Usage 

Tests can be executed with a fresh Alfresco install on localhost:8080 with user admin/admin

Want to manage other tests ?

Replace all TEST_X in [Client API: CSAPITestCase](src/test/java/com/alfresco/client/services/content/CSAPITestCase.java)
