# Alfresco Activiti - Java Client (Early Access)

## Introduction
The idea behind this project is to enable developers to interact easily with Alfresco Process Services Public REST API V1.
To achieve this goal this project provide a **single JAR** file that can be used in Java or Android applications.

### Status
**Please note this project is currently under development and is available only on Early Access Mode**

## Requirements

### Alfresco
Activiti REST API is available with **Activiti 5.20** and onwards

## Installation

### MAVEN

```xml
<dependency>
  <groupId>org.alfresco.client</groupId>
  <artifactId>activiti</artifactId>
  <version>1.0.0-beta2</version>
</dependency>
```

### GRADLE
```gradle
compile 'org.alfresco.client:activiti:1.0.0-beta2'
```

## Usage

### Create Client/Session Object

**Basic Auth**
```java
ActivitiClient client = new ActivitiClient.Builder().connect(endpoint, username, password).build();
```

**Ticket based (like SAML or Alfresco Ticket)**
```java
ActivitiClient client =  new ActivitiClient.Builder().connectWithTicket(baseUrl, ticketValue).build();
```

**Token based (like oAuth)**
```java
ActivitiClient client =  new ActivitiClient.Builder().connectWithToken(baseUrl, tokenValue).build();
```


### Create Services
```java

 DatabaseTablesAPI databaseTablesAPI = client.getDatabaseTablesAPI();

 DeploymentsAPI deploymentsAPI = client.getDeploymentsAPI();

 EngineAPI engineAPI = client.getEngineAPI();

 ExecutionsAPI executionsAPI = client.getExecutionsAPI();

 FormsAPI formsAPI = client.getFormsAPI();

 GroupsAPI groupsAPI = client.getGroupsAPI();

 HistoryAPI historyAPI = client.getHistoryAPI();

 JobsAPI jobsAPI = client.getJobsAPI();

 ModelsAPI modelsAPI = client.getModelsAPI();

 ProcessDefinitionsAPI processDefinitionsAPI = client.getProcessDefinitionsAPI();

 ProcessInstancesAPI processInstancesAPI = client.getProcessInstancesAPI();

 RuntimeAPI runtimeAPI = client.getRuntimeAPI();

 TasksAPI tasksAPI = client.getTasksAPI();

 UsersAPI usersAPI = client.getUsersAPI();

```


