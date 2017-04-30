# Alfresco Digital Business Platform Java Client

## Introduction
The idea behind this project is to enable developers to interact easily with Alfresco REST API.
To achieve this goal this project provide a **single JAR** file that can be used in Java or Android applications.

### Status
**Please note this project is currently under development and is available only on Early Access Mode**

## Installation

### MAVEN

```xml
<dependency>
  <groupId>org.alfresco.client</groupId>
  <artifactId>alfresco-platform-client</artifactId>
  <version>1.0.0-beta2</version>
</dependency>
```

### GRADLE
```gradle
compile 'org.alfresco.client:alfresco-platform-client:1.0.0-beta2'
```

## Usage
```java
//Connect to Alfresco CS
AlfrescoClient client = new AlfrescoClient.Builder()
        .connectTo("http://cmis.alfresco.com", ServicesEnum.CONTENT_SERVICES)
        .withUser("admin", "admin")
        .build();

//Connect to Alfresco CS with CSClient Builder
AlfrescoClient client = new AlfrescoClient.Builder()
        .addServiceClientBuilder(new CSClient.Builder().connect("http://cmis.alfresco.com", "admin", "admin"))
        .build();

//Connect to Alfresco CS + GS
AlfrescoClient client = new AlfrescoClient.Builder()()
        .connectTo("http://cmis.alfresco.com", ServicesEnum.CONTENT_SERVICES)
        .addService(ServicesEnum.GOVERNANCE_SERVICES)
        .withUser("admin", "admin")
        .build();

//Connect to Alfresco CS + GS
AlfrescoClient client = new AlfrescoClient.Builder()
        .connectTo("http://cmis.alfresco.com")
        .addService(ServicesEnum.CONTENT_SERVICES)
        .addService(ServicesEnum.GOVERNANCE_SERVICES)
        .withUser("admin", "admin")
        .build();

//Connect to Alfresco CS + PS with same user
AlfrescoClient client = new AlfrescoClient.Builder()
        .addServiceClientBuilder(new CSClient.Builder().connect("http://cmis.alfresco.com", "admin", "admin"))
        .addServiceClientBuilder(new PSClient.Builder().connect("http://localhost:8080/activiti-app", "admin@app.activiti.com", "admin"))
        .build();
        
 //Connect to Alfresco CS + PS with different user      
 AlfrescoClient client = new AlfrescoClient.Builder()
         .addServiceClientBuilder(new CSClient.Builder().connect("http://cmis.alfresco.com", "admin", "admin"))
         .addServiceClientBuilder(new PSClient.Builder().connect("http://localhost:8080/activiti-app", "admin@app.activiti.com", "admin"))
         .build();
```
