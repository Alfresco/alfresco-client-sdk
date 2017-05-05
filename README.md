# Alfresco Digital Business Platform - Java Client (Early Access)

## Introduction
This project contains Java lib projects to consume easily **Alfresco Digital Business Platform Public REST API** including **Alfresco Content Services**, **Alfresco Process Services**, **Alfresco Governance Services** and **Activiti**.

It include a set of APIs that allows developers to quickly build Alfresco-enabled Java & Android applications. 

Those projects are currently the foundation of our major next version of [Alfresco Android APP](https://github.com/Alfresco/alfresco-android-app) available on the [Google Play Store](https://play.google.com/store/apps/details?id=org.alfresco.mobile.android.application)

## Important Notice

Alfresco Digital Business Platform Java Client is currently in **Early Access mode**. It evolves as you use them, as you give feedback, and as the developers update and add file. We like to think app & lib development as services that grow and evolve with the involvement of the community.

## Usage

If you are a developer trying to interact with only one Alfresco Services have a look to one of the **[Services Client](client-services)**

If you are a developer trying to interact with more than one Alfresco Services have a look to **[Alfresco Platform Client](client-java/alfresco-platform-client)**


## Overview
- **Client Java**
    * **[Alfresco Platform Client](client-java/alfresco-platform-client)** Helpers to interact with Alfresco Digital Business Platform Public REST API
    * **[Java Client](client-java/java-client)** utility used by all client services APIs
- **Client Services**
    * **[Alfresco Content Services Client](client-services/content-services)** set of APIs to interact with Content Services Public API 1.0 (CS 5.2+)
    * **[Alfresco Governance Services Client](client-services/governance-services)** set of APIs to interact with Governance Services Public API 1.0 (GS 2.6+)
    * **[Alfresco Process Services Client](client-services/process-services)** set of APIs to interact with Alfresco Process Services Public API (PS 1.5+)
    * **[Alfresco Activiti Client](client-services/activiti)** set of APIs to interact with Activiti REST API (Activiti 5.20+)
- **Client Samples**
    * **[Client Samples Java](samples/client-samples-java)** Sample simple project using different java technique: java7, java8, RxJava...
    * **[Client Samples Command Line Tool](samples/client-samples-cli)** Illustrate how to use Client API as command Line tool.


## Build

**Build Librairies**
    
    mvn clean install -DskipTests=true
	
## How to Contribute ?

If you spot a bug then please raise an issue on [Github](https://github.com/Alfresco/alfresco-client-sdk/issues?q=is%3Aopen+sort%3Acreated-desc)<br/>
If you would like to contribute code you can do so through GitHub by forking the repository and sending a pull request.<br/>
When submitting code, please make every effort to follow existing conventions and style in order to keep the code as readable as possible.<br/>
	
## License

    Alfresco Client Librairies

    Copyright © 2017 Alfresco Software, Ltd. and others.

    This product distribution is made available under the Apache 2.0 license.