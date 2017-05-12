# Alfresco Governance Services - Java Client (Early Access)

## Introduction
The idea behind this project is to enable developers to interact easily with Alfresco Governance Services Public REST API V1.
To achieve this goal this project provide a **single JAR** file that can be used in Java or Android applications.

### Status
**Please note this project is currently under development and is available only on Early Access Mode**

## Requirements

### Alfresco
Governance Services REST API v1 is currently not available. It will be available with **Records Management Community 2.6** and **Records Management Enterprise 2.6** modules.

## Installation

### MAVEN

```xml
<dependency>
  <groupId>org.alfresco.client</groupId>
  <artifactId>governance-services</artifactId>
  <version>1.0.0-beta2</version>
</dependency>
```

### GRADLE
```gradle
compile 'org.alfresco.client:governance-services:1.0.0-beta2'
```

## Usage

### Create Client/Session Object

**Basic Auth**
```java
GSClient client = new GSClient.Builder().connect(endpoint, username, password).build();
```

**Ticket based (like SAML or Alfresco Ticket)**
```java
GSClient client =  new GSClient.Builder().connectWithTicket(baseUrl, ticketValue).build();
```

**Token based (like oAuth)**
```java
GSClient client =  new GSClient.Builder().connectWithToken(baseUrl, tokenValue).build();
```


### Create Services
```java

// Perform operations on non-record files
FilesAPI filesAPI = client.getFilesAPI();

//Retrieve and manage the RM site
GsSitesAPI gsSitesAPI = client.getGsSitesAPI();

// Retrieve and manage file plans
FilePlansAPI filePlansAPI = client.getFilePlansAPI();

// Retrieve and manage record categories
RecordCategoriesAPI recordCategoriesAPI = client.getRecordCategoriesAPI();

// Retrieve and manage record folders
RecordFoldersAPI recordFoldersAPI = client.getRecordFoldersAPI();

// Perform record specific operations
RecordsAPI recordsAPI = client.getRecordsAPI();

// Retrieve and manage unfiled records containers
UnfiledContainersAPI UufiledContainersAPI = client.getUnfiledContainersAPI();

// Retrieve and manage unfiled record folders
UnfiledRecordFoldersAPI unfiledRecordFoldersAPI = client.getUnfiledRecordFoldersAPI();

// Retrieve and manage transfer containers
TransferContainersAPI transferContainersAPI = client.getTransferContainersAPI();

// Retrieve and manage transfers
TransfersAPI transfersAPI = client.getTransfersAPI();

```

### Retrieve RM Site (Root Folder) Information

**Synchronuously**
```java
Response<RMSiteRepresentation> response = client.getGsSitesAPI().getRMSiteCall().execute();
```

**Asynchronuously**
```java
 client.getGsSitesAPI().getRMSiteCall().enqueue(new Callback<RMSiteRepresentation>() {
            @Override
            public void onResponse(Call<RMSiteRepresentation> call, Response<RMSiteRepresentation> response)
                //TODO When response is correct
            }

            @Override
            public void onFailure(Call<RMSiteRepresentation> call, Throwable t)
                //TODO When request has failed
            }
        });
```

**RxJava**
```java
nodesAPI.getRMSiteObservable().subscribe(root -> Assert.assertEquals(root.getName(), "RM Site"));
```

### Create RM Sites, Category, Folder and Record
```java
  // Create RM Site
 RMSiteBodyCreate rmSiteBodyCreate = new RMSiteBodyCreate("RM Test", "RM Test Side Made by Client SDK",
         RMSiteCompliance.STANDARD);
 RMSiteRepresentation rmSite = gsRegistry.getGsSitesAPI().createRMSiteCall(rmSiteBodyCreate, false).execute()
         .body();

 // Create 1 RM Category
 NodeBodyCreate create = new NodeBodyCreate("RM Category 1", RecordsManagementModel.TYPE_RECORD_CATEGORY);
 RecordCategoryRepresentation category1 = gsRegistry.getFilePlansAPI()
         .createFilePlanCategoriesCall(FilePlansAPI.DEFAULT_FILE_PLAN, create).execute().body();

 // Create Record Folder Children
 create = new NodeBodyCreate("RM Folder", RecordsManagementModel.TYPE_RECORD_FOLDER);
 RMNodeRepresentation rmFolder = gsRegistry.getRecordCategoriesAPI()
         .createRecordCategoryChildCall(category1.getId(), create).execute().body();

 // Create Non-Electronic Record
 Map<String, Object> recordProps = new HashMap<String, Object>()
 {
     {
         put(ContentModel.PROP_DESCRIPTION, "My Non-electronic Record Description");
         put(ContentModel.PROP_TITLE, "My Non-electronic Record Title");
         put(RecordsManagementModel.PROP_BOX, "My Non-electronic Record Box");
         put(RecordsManagementModel.PROP_FILE, "My Non-electronic Record File");
         put(RecordsManagementModel.PROP_NUMBER_OF_COPIES, 1);
         put(RecordsManagementModel.PROP_PHYSICAL_SIZE, 30);
         put(RecordsManagementModel.PROP_SHELF, "My Non-electronic Record Shelf");
         put(RecordsManagementModel.PROP_STORAGE_LOCATION, "My Non-electronic Record Location");

     }
 };
 RMNodeBodyCreate recordCreate = new RMNodeBodyCreate("Non-Electronic Record",
         RecordsManagementModel.TYPE_NON_ELECTRONIC_DOCUMENT, recordProps);
 RecordRepresentation record1 = gsRegistry.getRecordFoldersAPI()
         .createRecordFolderChildCall(rmFolder.getId(), recordCreate).execute().body();

```

## Build

**Simple Build**
    
    mvn clean install

**Build + Integration Test**
    
    mvn clean install -Ptest


## Running tests

### Requirements

Tests can be executed only with **Records Management Community 2.6** and **Records Management Enterprise 2.6** modules.

### Usage 

Tests can be executed with a fresh Alfresco install on localhost:8080 with user admin/admin

Want to manage other tests ?

Replace all TEST_X in [Client API: CSAPITestCase](src/test/java/org/alfresco/client/services/GSAPITestCase.java)