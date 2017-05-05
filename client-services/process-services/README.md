# Alfresco Process Services - Java Client (Early Access)

## Introduction
The idea behind this project is to enable developers to interact easily with Alfresco Process Services Public REST API V1.
To achieve this goal this project provide a **single JAR** file that can be used in Java or Android applications.

### Status
**Please note this project is currently under development and is available only on Early Access Mode**

## Requirements

### Alfresco
Process Services REST API v1 is only available with **Alfresco Process Services 1.5** and onwards

## Installation

### MAVEN

```xml
<dependency>
  <groupId>org.alfresco.client</groupId>
  <artifactId>process-services</artifactId>
  <version>1.0.0-beta2</version>
</dependency>
```

### GRADLE
```gradle
compile 'org.alfresco.client:process-services:1.0.0-beta2'
```

## Usage

### Create Client/Session Object

**Basic Auth**
```java
PSClient client = new PSClient.Builder().connect(endpoint, username, password).build();
```

**Ticket based (like SAML or Alfresco Ticket)**
```java
PSClient client =  new PSClient.Builder().connectWithTicket(baseUrl, ticketValue).build();
```

**Token based (like oAuth)**
```java
PSClient client =  new PSClient.Builder().connectWithToken(baseUrl, tokenValue).build();
```


### Create Services
```java

AboutAPI aboutAPI = client.getAboutAPI();

AdminAPI adminAPI = client.getAdmiAPI();

ContentAPI contentAPI = client.getContentAPI();

ModelsAPI modelsAPI = client.getModelsAPI();

ProcessDefinitionAPI processDefinitionAPI = client.getProcessDefinitionAPI();

ProcessInstanceAPI processInstanceAPI = client.getProcessInstanceAPI();

ProfileAPI profileAPI = client.getProfileAPI();

RuntimeAppDefinitionAPI runtimeAppDefinitionAPI = client.getRuntimeAppDefinitionAPI();

TaskAPI taskAPI = client.getTaskAPI();

UserFiltersAPI userFiltersAPI = client.getUserFiltersAPI();

UserGroupAPI sserGroupAPI = client.getUserGroupAPI();

```

### Retrieve Task by Id

**Synchronuously**
```java
Response<TaskRepresentation> response = client.getTasksAPI().getTaskCall("123").execute();
```

**Asynchronuously**
```java
 client.getTasksAPI().getTaskCall("123").enqueue(new Callback<TaskRepresentation>() {
             @Override
             public void onResponse(Call<TaskRepresentation> call, Response<TaskRepresentation> response) {
                 
             }
 
             @Override
             public void onFailure(Call<TaskRepresentation> call, Throwable throwable) {
 
             }
         });
```

**RxJava**
```java
client.getTasksAPI().getTaskObservable("123").subscribe(root -> Assert.assertEquals(root.getName(), "Task"));
```

### Task Actions
```java
    // CREATE STANDALONE TASK
    TaskRepresentation representation = new TaskRepresentation();
    representation.setName("Task 1");
    representation.setDescription("Description 1");
    Response<TaskRepresentation> response = api.createNewTask(representation).execute();
    
    // ATTACH DOCUMENT
    File file = getResourceFile("/org/alfresco/client/services/process/tests/test.txt");
    RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.addFormDataPart("file", "test.txt", requestBody);
    RequestBody fileRequestBody = multipartBuilder.build();

    Response<RelatedContentRepresentation> resp = api.createRelatedContentOnTask(taskRep.getId(), fileRequestBody)
            .execute();
            
    // COMPLETE STANDALONE TASK
    Response<Void> completionResponse = api.completeTask(taskRep.getId()).execute();         

```

## Running tests

### Requirements

Tests can be executed only with **Alfresco Process Services 1.5** and onwards

### Usage 

Tests can be executed with a fresh install on localhost:8080 with user admin/admin

Want to manage other tests ?

Replace all TEST_X in [Client API: PSAPITestCase](src/test/java/org/alfresco/client/services/process/enterprise/PSAPITestCase.java)
