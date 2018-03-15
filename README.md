# NOTICE
```diff
- THIS PROJECT IS UNSUPPORTED AND NO LONGER UNDER ACTIVE DEVELOPMENT -
```


# Alfresco Java Client (Early Access)

## Introduction
This project contains Java lib project to consume easily Alfresco Public REST API.

It include a set of APIs that allows developers to quickly build Alfresco-enabled Java & Android applications. 

Those projects are currently the foundation of our major next version of [Alfresco Android APP](https://github.com/Alfresco/alfresco-android-app) available on the [Google Play Store](https://play.google.com/store/apps/details?id=org.alfresco.mobile.android.application)

## Important Notice

Alfresco Client is currently in **Early Access mode**. It evolves as you use them, as you give feedback, and as the developers update and add file. We like to think app & lib development as services that grow and evolve with the involvement of the community.

Alfresco Client doesn't support workflow API (i.e interacting with embedded Activiti)
If you are looking for a client to interact with Activiti Rest API (Enterprise Only), please have a look to [Activiti Java Client Github Repo](https://github.com/Alfresco/activiti-client-sdk)

## Requirements

Alfresco REST API v1 is currently on Early Access Mode and it's only available with the latest version of Alfresco Community 201606.
Before using this library you have to install this platform [available here](https://wiki.alfresco.com/wiki/Alfresco_Community_Edition_201606_EA_Release_Notes)

For more information about Alfresco REST API
- [v1 REST API - Part 1 - Introduction](https://community.alfresco.com/community/ecm/blog/2016/10/11/v1-rest-api-part-1-introduction)
- [v1 REST API - Part 2 - Navigation](https://community.alfresco.com/community/ecm/blog/2016/10/17/v1-rest-api-part-2-navigation)
- [v1 REST API - Part 3 - Creating Nodes](https://community.alfresco.com/community/ecm/blog/2016/10/24/v1-rest-api-part-3-creating-nodes)
- [v1 REST API - Part 4 - Managing Nodes](https://community.alfresco.com/community/ecm/blog/2016/11/02/v1-rest-api-part-4-managing-nodes)
- [v1 REST API - Part 5 - Versioning & Locking](https://community.alfresco.com/community/ecm/blog/2016/11/11/v1-rest-api-part-5-versioning-locking)
- [v1 REST API - Part 6 - Assocations](https://community.alfresco.com/community/ecm/blog/2016/11/23/v1-rest-api-part-6-associations)
- [v1 REST API - Part 7 - Collaboration](https://community.alfresco.com/community/ecm/blog/2016/12/14/v1-rest-api-part-7-collaboration)
- [v1 REST API - Part 8 - Sites](https://community.alfresco.com/community/ecm/blog/2017/02/24/v1-rest-api-part-8-sites)
- [v1 REST API - Part 9 - Queries & Search](https://community.alfresco.com/community/ecm/blog/2017/04/11/v1-rest-api-part-9-queries-search)
- [v1 REST API - Part 10 - People](https://community.alfresco.com/community/ecm/blog/2017/04/18/v1-rest-api-part-10-people)
- [v1 REST API - Part 11 - Trashcan](https://community.alfresco.com/community/ecm/blog/2017/04/24/v1-rest-api-part-11-trashcan)
- [Alfresco REST API Explorer](https://api-explorer.alfresco.com/api-explorer/)
- ["The Future of REST APIs” Tech Talk Live session](https://www.youtube.com/watch?v=LCw7fe1pVSw)
- ["Alfresco REST API of the future" BeeCon slides](http://www.slideshare.net/jvonka/alfresco-rest-api-of-the-future-is-closer-than-you-think)


## Overview
- **Client Java**: Contains Client API Project for Alfresco
    * **Alfresco Java Client** set of APIs to interact with Alfresco Alfresco Public API 1.0 (Alfresco 5.2+)
    * **Client API Commons** utility used by all client APIs
- **Docs**: contains informations about Alfresco REST API as implemented in the current version. For up to date info see [API Explorer github Repository](https://github.com/Alfresco/rest-api-explorer/tree/master/src/main/webapp/definitions)
- **Client Samples** : Various sample project. They illustrate different ways to use, consume and customize Client API & SDK.
    * **Client Samples Java** Sample simple project using different java technique: java7, java8, RxJava...
    * **Client Samples Command Line Tool** Illustrate how to use Client API as command Line tool.

### Status
| Projects | Status | Informations |
| --- | --- | --- | --- |
| [Alfresco Java Client](client-java/alfresco-java-client) | **Beta** | Full API coverage, simple test |
| [Client API Commons](client-java/client-commons) | **Beta** | To evolve regarding other evolution |
| [Client Samples](client-samples/client-samples-java) | **Beta** | Under development |
| [Client Command Line](client-samples/client-samples-cli) | **Beta** | Under development |

## Build

**Build Librairies**
    
    mvn clean install -DskipTests=true

## Usage

Documentation samples are available ["Alfresco Java Client” README](https://github.com/Alfresco/alfresco-client-sdk/tree/master/client-java/alfresco-java-client)<br/>
There's also a series of blog post illustrating some usage
- [Alfresco Java Client SDK](https://community.alfresco.com/community/ecm/blog/2016/11/17/alfresco-java-client-sdk)
- [Alfresco Java Client SDK - Part 2 - Navigation](https://community.alfresco.com/community/ecm/blog/2016/11/17/alfresco-java-client-sdk-usage)
- [Alfresco Java Client SDK - Part 3 - Creating Nodes](https://community.alfresco.com/community/ecm/blog/2016/11/17/alfresco-java-client-sdk-usage-part-3)
- [Alfresco Java Client SDK - Part 4 - Managing Nodes](https://community.alfresco.com/community/ecm/blog/2016/11/17/alfresco-java-client-sdk-usage-part-4)
- [Alfresco Java Client SDK - Part 5 - Versioning & Locking](https://community.alfresco.com/community/ecm/blog/2016/11/17/alfresco-java-client-sdk-usage-part-5)
- [Alfresco Java Client SDK - Part 6 - Assocations](https://community.alfresco.com/community/ecm/blog/2016/11/25/alfresco-java-client-sdk-usage-part-6)
- [Alfresco Java Client SDK - Part 7 - Collaboration](https://community.alfresco.com/community/ecm/blog/2017/04/26/alfresco-java-client-sdk-usage-part-7)
- [Alfresco Java Client SDK - Part 8 - Sites](https://community.alfresco.com/community/ecm/blog/2017/04/26/alfresco-java-client-sdk-usage-part-8)
- [Alfresco Java Client SDK - Part 9 - Queries & Search](https://community.alfresco.com/community/ecm/blog/2017/04/26/alfresco-java-client-sdk-usage-part-9)
- [Alfresco Java Client SDK - Part 10 - People](https://community.alfresco.com/community/ecm/blog/2017/04/26/alfresco-java-client-sdk-usage-part-10)
- [Alfresco Java Client SDK - Part 11 - Trashcan](https://community.alfresco.com/community/ecm/blog/2017/04/26/alfresco-java-client-sdk-usage-part-11)
	
## How to Contribute ?

If you spot a bug then please raise an issue on [Github](https://github.com/Alfresco/alfresco-client-sdk/issues?q=is%3Aopen+sort%3Acreated-desc)<br/>
If you would like to contribute code you can do so through GitHub by forking the repository and sending a pull request.<br/>
When submitting code, please make every effort to follow existing conventions and style in order to keep the code as readable as possible.<br/>
	
## License

    Alfresco Client Librairies

    Copyright © 2017 Alfresco Software, Ltd. and others.

    This product distribution is made available under the Apache 2.0 license.
    
 

## Technical Overview
Client API projects are based on 3 Java/Android librairies

* [OkHttp][2]
* [Retrofit][1]
* [Gson][3]

[Retrofit][1] is a type-safe REST client for Java/Android built by Square. The library provides a powerful framework for authenticating and interacting with APIs.

Retrofit send network requests with [OkHttp][2] an HTTP & HTTP/2 client for Android and Java applications also built by Square. This library makes downloading JSON or XML data from a web API fairly straightforward. 

Once the data is downloaded then it is parsed into a Plain Old Java Object (POJO) which must be defined for each "resource" in the response. Retrofit supports many different parsers for processing network response data ([Gson][3], [Jackson][4], [Moshi][5], [Protobuf][6], [Wire][7], [Simple XML][8])

### Advantages

* Easy to consume: API can be consumed synchronuously and/or asynchronuously and/or in a Reactive Approach ([RxJava][9])
* Easy to setup: API declaration is simple and POJO model can be easily generated via Swagger Definition
* Simple architecture & Easy to customize: Each component can be modified and customized to match 
* Large community and Open Source compatible	
	
### More informations

**Retrofit**

- [Simple HTTP with Retrofit 2 (Droidcon NYC 2015)](https://speakerdeck.com/jakewharton/simple-http-with-retrofit-2-droidcon-nyc-2015)
- [Consuming APIs with Retrofit](https://guides.codepath.com/android/Consuming-APIs-with-Retrofit#setup)
- [Retrofit 2.0: The biggest update yet on the best HTTP Client Library for Android](http://inthecheesefactory.com/blog/retrofit-2.0/en)
- [Retrofit Series](https://futurestud.io/blog/retrofit-2-upgrade-guide-from-1-9)

**OkHttp**

- [A Few 'Ok' Libraries (Droidcon MTL 2015)](https://speakerdeck.com/jakewharton/a-few-ok-libraries-droidcon-mtl-2015)

**Gson**

- [Gson User Guide](https://github.com/google/gson/blob/master/UserGuide.md)

**RxJava & RxAndroid**

- [Grokking RxJava](http://blog.danlew.net/2014/09/15/grokking-rxjava-part-1/)
- [Retrofit and RxJava, Android multi-threaded REST requests](http://randomdotnext.com/retrofit-rxjava/)

   
[1]: http://square.github.io/retrofit/
[2]: http://square.github.io/okhttp/
[3]: https://github.com/google/gson
[4]: http://wiki.fasterxml.com/JacksonHome
[5]: http://github.com/square/moshi
[6]: http://github.com/google/protobuf
[7]: http://github.com/square/wire
[8]: http://simple.sourceforge.net/
[9]: https://github.com/ReactiveX/RxJava
