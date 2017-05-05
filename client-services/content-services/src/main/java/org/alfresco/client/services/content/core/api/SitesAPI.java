/*
 *   Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *   This file is part of Alfresco Java Client.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.alfresco.client.services.content.core.api;

import static org.alfresco.client.services.common.constant.ApiConstant.*;

import org.alfresco.client.services.common.model.parameters.FieldsParam;
import org.alfresco.client.services.common.model.parameters.OrderByParam;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.core.CoreConstant;
import org.alfresco.client.services.content.core.model.body.*;
import org.alfresco.client.services.content.core.model.representation.*;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface SitesAPI
{
    // TODO Add Default Site Container id

    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List sites Gets a list of sites in this repository. You can use the
     * **where** parameter to filter the returned sites by **visibility**. For
     * example, any one of: &#x60;&#x60;&#x60; (visibility&#x3D;PRIVATE)
     * (visibility&#x3D;PUBLIC) (visibility&#x3D;MODERATED) &#x60;&#x60;&#x60;
     * The default sort order for the returned list is for sites to be sorted by
     * ascending title. You can override the default by using the **orderBy**
     * parameter. You can specify one or more of the following fields in the
     * **orderBy** parameter: * id * title * description You can use the
     * **relations** parameter to include one or more related entities in a
     * single response and so reduce network traffic. The entity types in
     * Alfresco are organized in a tree structure. The **sites** entity has two
     * children, **containers** and **members**. The following relations
     * parameter returns all the container and member objects related to each
     * site: &#x60;&#x60;&#x60; containers,members &#x60;&#x60;&#x60;
     * 
     * @return SitePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites")
    Call<ResultPaging<SiteRepresentation>> listSitesCall();

    /**
     * List sites Gets a list of sites in this repository. You can use the
     * **where** parameter to filter the returned sites by **visibility**. For
     * example, any one of: &#x60;&#x60;&#x60; (visibility&#x3D;PRIVATE)
     * (visibility&#x3D;PUBLIC) (visibility&#x3D;MODERATED) &#x60;&#x60;&#x60;
     * The default sort order for the returned list is for sites to be sorted by
     * ascending title. You can override the default by using the **orderBy**
     * parameter. You can specify one or more of the following fields in the
     * **orderBy** parameter: * id * title * description You can use the
     * **relations** parameter to include one or more related entities in a
     * single response and so reduce network traffic. The entity types in
     * Alfresco are organized in a tree structure. The **sites** entity has two
     * children, **containers** and **members**. The following relations
     * parameter returns all the container and member objects related to each
     * site: &#x60;&#x60;&#x60; containers,members &#x60;&#x60;&#x60;
     * 
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param orderBy A string to control the order of the entities returned in
     *            a list. You can use the **orderBy** parameter to sort the list
     *            by one or more fields. Each field has a default sort order,
     *            which is normally acending order. Read the API method
     *            implementation notes above to check if any fields used in this
     *            method have a descending default search order. To sort the
     *            entities in a specific order, you can use the **ASC** and
     *            **DESC** keywords for any field. (optional)
     * @param relations Use the relations parameter to include one or more
     *            related entities in a single response. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @param where A string to restrict the returned objects by using a
     *            predicate. (optional)
     * @return SitePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites")
    Call<ResultPaging<SiteRepresentation>> listSitesCall(@Query(SKIP_COUNT) Integer skipCount,
            @Query(MAX_ITEMS) Integer maxItems, @Query(ORDER_BY) OrderByParam orderBy, @Query(RELATIONS) int relations,
            @Query(FIELDS) FieldsParam fields, @Query(WHERE) String where);

    // ///////////////////////////////////////////////////////////////////////////
    // INFO
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a site Returns information for site **siteId**. You can use the
     * **relations** parameter to include one or more related entities in a
     * single response and so reduce network traffic. The entity types in
     * Alfresco are organized in a tree structure. The **sites** entity has two
     * children, **containers** and **members**. The following relations
     * parameter returns all the container and member objects related to the
     * site **siteId**: &#x60;&#x60;&#x60; containers,members &#x60;&#x60;&#x60;
     * 
     * @param siteId The identifier of a site. (required)
     * @return SiteRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}")
    Call<SiteRepresentation> getSiteCall(@Path(SITE_ID) String siteId);

    /**
     * Get a site Returns information for site **siteId**. You can use the
     * **relations** parameter to include one or more related entities in a
     * single response and so reduce network traffic. The entity types in
     * Alfresco are organized in a tree structure. The **sites** entity has two
     * children, **containers** and **members**. The following relations
     * parameter returns all the container and member objects related to the
     * site **siteId**: &#x60;&#x60;&#x60; containers,members &#x60;&#x60;&#x60;
     * 
     * @param siteId The identifier of a site. (required)
     * @param relations Use the relations parameter to include one or more
     *            related entities in a single response. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SiteRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}")
    Call<SiteRepresentation> getSiteCall(@Path(SITE_ID) String siteId, @Query(RELATIONS) int relations,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create a site Creates a default site with the given details. Unless
     * explicitly specified, the site id will be generated from the site title.
     * The site id must be unique and only contain alphanumeric and/or dash
     * characters. For example, to create a public site called
     * \&quot;Marketing\&quot; the following body could be used:
     * &#x60;&#x60;&#x60;JSON { \&quot;title\&quot;: \&quot;Marketing\&quot;,
     * \&quot;visibility\&quot;: \&quot;PUBLIC\&quot; } &#x60;&#x60;&#x60; The
     * creation of the (surf) configuration files required by Share can be
     * skipped via the **skipConfiguration** query parameter. **Please note: if
     * skipped then such a site will *not* work within Share.** The addition of
     * the site to the user&#39;s site favorites can be skipped via the
     * **skipAddToFavorites** query parameter. The creator will be added as a
     * member with Site Manager role.
     * 
     * @param siteBodyCreate The site details (required)
     * @return SiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/sites")
    Call<SiteRepresentation> createSiteCall(@Body SiteBodyCreate siteBodyCreate);

    /**
     * Create a site Creates a default site with the given details. Unless
     * explicitly specified, the site id will be generated from the site title.
     * The site id must be unique and only contain alphanumeric and/or dash
     * characters. For example, to create a public site called
     * \&quot;Marketing\&quot; the following body could be used:
     * &#x60;&#x60;&#x60;JSON { \&quot;title\&quot;: \&quot;Marketing\&quot;,
     * \&quot;visibility\&quot;: \&quot;PUBLIC\&quot; } &#x60;&#x60;&#x60; The
     * creation of the (surf) configuration files required by Share can be
     * skipped via the **skipConfiguration** query parameter. **Please note: if
     * skipped then such a site will *not* work within Share.** The addition of
     * the site to the user&#39;s site favorites can be skipped via the
     * **skipAddToFavorites** query parameter. The creator will be added as a
     * member with Site Manager role.
     * 
     * @param siteBodyCreate The site details (required)
     * @param skipConfiguration Flag to indicate whether the Share-specific
     *            (surf) configuration files for the site should not be created.
     *            (optional, default to false)
     * @param skipAddToFavorites Flag to indicate whether the site should not be
     *            added to the user&#39;s site favorites. (optional, default to
     *            false)
     * @return SiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/sites")
    Call<SiteRepresentation> createSiteCall(@Body SiteBodyCreate siteBodyCreate,
            @Query(SKIP_CONFIGURATION) int skipConfiguration, @Query(SKIP_ADD_TO_FAVORITES) int skipAddToFavorites,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
     * Update the details for the given site **siteId**. Site Manager or
     * otherwise a (site) admin can update title, description or visibility.
     * Note: the id of a site cannot be updated once the site has been created.
     *
     * @param siteId The identifier of a site. (required)
     * @param siteBodyUpdate The site details (required)
     * @return SiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}")
    Call<SiteRepresentation> updateSiteCall(@Path(SITE_ID) String siteId, @Body SiteBodyUpdate siteBodyUpdate);

    /**
     * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
     * Update the details for the given site **siteId**. Site Manager or
     * otherwise a (site) admin can update title, description or visibility.
     * Note: the id of a site cannot be updated once the site has been created.
     *
     * @param siteId The identifier of a site. (required)
     * @param siteBodyUpdate The site details (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}")
    Call<SiteRepresentation> updateSiteCall(@Path(SITE_ID) String siteId, @Body SiteBodyUpdate siteBodyUpdate,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete a site Deletes the site with **siteId**.
     * 
     * @param siteId The identifier of a site. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}")
    Call<Void> deleteSiteCall(@Path(SITE_ID) String siteId);

    /**
     * Delete a site Deletes the site with **siteId**.
     * 
     * @param siteId The identifier of a site. (required)
     * @param permanent Flag to indicate whether the site should be permanently
     *            deleted i.e. bypass the trashcan. (optional, default to false)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}")
    Call<Void> deleteSiteCall(@Path(SITE_ID) String siteId, @Query(PERMANENT) Boolean permanent);

    // ///////////////////////////////////////////////////////////////////////////
    // CONTAINERS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get containers Returns a list of containers information for site
     * identified by **siteId**.
     * 
     * @param siteId The identifier of a site. (required)
     * @return SiteContainerPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/containers")
    Call<ResultPaging<SiteContainerRepresentation>> listSiteContainersCall(@Path(SITE_ID) String siteId);

    /**
     * Get containers Returns a list of containers information for site
     * identified by **siteId**.
     * 
     * @param siteId The identifier of a site. (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SiteContainerPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites")
    Call<ResultPaging<SiteContainerRepresentation>> listSiteContainersCall(@Path(SITE_ID) String siteId,
            @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(FIELDS) FieldsParam fields);

    /**
     * Get a container Returns information on the container **containerId** in
     * site **siteId**.
     * 
     * @param siteId The identifier of a site. (required)
     * @param containerId The unique identifier of a site container. (required)
     * @return SiteContainerEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/containers/{containerId}")
    Call<SiteContainerRepresentation> getSiteContainerCall(@Path(SITE_ID) String siteId,
            @Path(CONTAINER_ID) String containerId);

    /**
     * Get a container Returns information on the container **containerId** in
     * site **siteId**.
     * 
     * @param siteId The identifier of a site. (required)
     * @param containerId The unique identifier of a site container. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SiteContainerEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/containers/{containerId}")
    Call<SiteContainerRepresentation> getSiteContainerCall(@Path(SITE_ID) String siteId,
            @Path(CONTAINER_ID) String containerId, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // MEMBERSHIP
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get members Returns a list of site memberships for site **siteId**.
     * 
     * @param siteId The identifier of a site. (required)
     * @return SiteMemberPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/members")
    Call<ResultPaging<SiteMemberRepresentation>> listSiteMembershipsCall(@Path(SITE_ID) String siteId);

    /**
     * Get members Returns a list of site memberships for site **siteId**.
     * 
     * @param siteId The identifier of a site. (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SiteMemberPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/members")
    Call<ResultPaging<SiteMemberRepresentation>> listSiteMembershipsCall(@Path(SITE_ID) String siteId,
            @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(FIELDS) FieldsParam fields);

    /**
     * Add a person Adds person **personId** as a member of site **siteId**. You
     * can set the **role** to one of four types: * SiteConsumer *
     * SiteCollaborator * SiteContributor * SiteManager
     * 
     * @param siteId The identifier of a site. (required)
     * @param siteMembershipBodyCreate The person to add and their role
     *            (required)
     * @return SiteMemberEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/members")
    Call<SiteMemberRepresentation> createSiteMembershipCall(@Path(SITE_ID) String siteId,
            @Body SiteMembershipBodyCreate siteMembershipBodyCreate,
            @Query(FIELDS) FieldsParam fields);

    /**
     * Get a site member Returns site membership information for person
     * **personId** on site **siteId**. You can use the &#x60;-me-&#x60; string
     * in place of &#x60;&lt;personId&gt;&#x60; to specify the currently
     * authenticated user.
     * 
     * @param siteId The identifier of a site. (required)
     * @param personId The identifier of a person. (required)
     * @return SiteMemberEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/members/{personId}")
    Call<SiteMemberRepresentation> getSiteMembershipCall(@Path(SITE_ID) String siteId,
            @Path(PERSON_ID) String personId);

    /**
     * Update a site member Update the membership of person **personId** in site
     * **siteId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * You can set the **role** to one of four types: * SiteConsumer *
     * SiteCollaborator * SiteContributor * SiteManager
     * 
     * @param siteId The identifier of a site. (required)
     * @param personId The identifier of a person. (required)
     * @param siteMemberRoleBody The persons new role (required)
     * @return SiteMemberEntry
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/members/{personId}")
    Call<SiteMemberRepresentation> updateSiteMembershipCall(@Path(SITE_ID) String siteId,
            @Path(PERSON_ID) String personId, @Body SiteMembershipBodyUpdate siteMemberRoleBody,
            @Query(FIELDS) FieldsParam fields);

    /**
     * Delete a site member Removes person **personId** as a member of site
     * **siteId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * 
     * @param siteId The identifier of a site. (required)
     * @param personId The identifier of a person. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/members/{personId}")
    Call<Void> deleteSiteMembershipCall(@Path(SITE_ID) String siteId, @Path(PERSON_ID) String personId);

    // ///////////////////////////////////////////////////////////////////////////
    // LISTING PERSON SITE MEMBERSHIP
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List site memberships Gets a list of site membership information for
     * person **personId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * You can use the **where** parameter to filter the returned sites by
     * **visibility**. For example, any one of: &#x60;&#x60;&#x60;
     * (visibility&#x3D;PRIVATE) (visibility&#x3D;PUBLIC)
     * (visibility&#x3D;MODERATED) &#x60;&#x60;&#x60; The default sort order for
     * the returned list is for sites to be sorted by ascending title. You can
     * override the default by using the **orderBy** parameter. You can specify
     * one or more of the following fields in the **orderBy** parameter: * id *
     * title * role
     * 
     * @param personId The identifier of a person. (required)
     * @return SiteRolePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/sites")
    Call<ResultPaging<SiteRoleRepresentation>> listSiteMembershipsForPersonCall(@Path(PERSON_ID) String personId);

    /**
     * List site memberships Gets a list of site membership information for
     * person **personId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * You can use the **where** parameter to filter the returned sites by
     * **visibility**. For example, any one of: &#x60;&#x60;&#x60;
     * (visibility&#x3D;PRIVATE) (visibility&#x3D;PUBLIC)
     * (visibility&#x3D;MODERATED) &#x60;&#x60;&#x60; The default sort order for
     * the returned list is for sites to be sorted by ascending title. You can
     * override the default by using the **orderBy** parameter. You can specify
     * one or more of the following fields in the **orderBy** parameter: * id *
     * title * role
     * 
     * @param personId The identifier of a person. (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param orderBy A string to control the order of the entities returned in
     *            a list. You can use the **orderBy** parameter to sort the list
     *            by one or more fields. Each field has a default sort order,
     *            which is normally acending order. Read the API method
     *            implementation notes above to check if any fields used in this
     *            method have a descending default search order. To sort the
     *            entities in a specific order, you can use the **ASC** and
     *            **DESC** keywords for any field. (optional)
     * @param relations Use the relations parameter to include one or more
     *            related entities in a single response. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @param where A string to restrict the returned objects by using a
     *            predicate. (optional)
     * @return SiteRolePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/sites")
    Call<ResultPaging<SiteRoleRepresentation>> listSiteMembershipsForPersonCall(@Path(PERSON_ID) String personId,
            @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(ORDER_BY) OrderByParam orderBy, @Query(RELATIONS) String relations,
            @Query(FIELDS) FieldsParam fields, @Query(WHERE) String where);

    // ///////////////////////////////////////////////////////////////////////////
    // INFO PERSON SITE MEMBERSHIP
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Get site membership for a site Returns site membership information for
     * person **personId** on site **siteId**. You can use the &#x60;-me-&#x60;
     * string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently
     * authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param siteId The identifier of a site. (required)
     * @return SiteRoleRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/sites/{siteId}")
    Call<SiteRoleRepresentation> getSiteMembershipForPersonCall(@Path(PERSON_ID) String personId,
            @Path(SITE_ID) String siteId);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE PERSON SITE MEMBERSHIP
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Delete a site membership Deletes person **personId** as a member of site
     * **siteId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * 
     * @param personId The identifier of a person. (required)
     * @param siteId The identifier of a site. (required)
     * @return ApiResponse&lt;Void&gt;
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/sites/{siteId}")
    Call<Void> deleteSiteMembershipForPersonCall(@Path(PERSON_ID) String personId, @Path(SITE_ID) String siteId);

    // ///////////////////////////////////////////////////////////////////////////
    // SITE MEMBERSHIP REQUEST
    // ///////////////////////////////////////////////////////////////////////////
    // LISTING

    /**
     * Get site membership requests Returns the current site membership requests
     * for person **personId**. You can use the &#x60;-me-&#x60; string in place
     * of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated
     * user.
     *
     * @param personId The identifier of a person. (required)
     * @return ResultPaging<SiteMembershipRequestRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests")
    Call<ResultPaging<SiteMembershipRequestRepresentation>> listSiteMembershipRequestsForPersonCall(
            @Path(PERSON_ID) String personId);

    /**
     * Get site membership requests Returns the current site membership requests
     * for person **personId**. You can use the &#x60;-me-&#x60; string in place
     * of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated
     * user.
     *
     * @param personId The identifier of a person. (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return ResultPaging<SiteMembershipRequestRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests")
    Call<ResultPaging<SiteMembershipRequestRepresentation>> listSiteMembershipRequestsForPersonCall(
            @Path(PERSON_ID) String personId, @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(FIELDS) FieldsParam fields);

    // SITE MEMBERSHIP REQUEST
    // CREATE

    /**
     * Create a site membership body Create a site membership body for yourself
     * on the site with the identifier of **id**, specified in the JSON body.
     * The result of the body differs depending on the type of site. * For a
     * **public** site, you join the site immediately as a SiteConsumer. * For a
     * **moderated** site, your body is added to the site membership body list.
     * The body waits for approval from the Site Manager. * You cannot body
     * membership of a **private** site. Members are invited by the site
     * administrator. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * **Note:** You can create site membership requests for more than one site
     * by specifying a list of sites in the JSON body like this:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;message\&quot;: \&quot;Please can you
     * add me\&quot;, \&quot;id\&quot;: \&quot;test-site-1\&quot;,
     * \&quot;title\&quot;: \&quot;Request for test site 1\&quot;, }, {
     * \&quot;message\&quot;: \&quot;Please can you add me\&quot;,
     * \&quot;id\&quot;: \&quot;test-site-2\&quot;, \&quot;title\&quot;:
     * \&quot;Request for test site 2\&quot;, } ] &#x60;&#x60;&#x60; If you
     * specify a list as input, then a paginated list rather than an entry is
     * returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param personId The identifier of a person. (required)
     * @param siteMembershipBodyCreate Site membership body details (required)
     * @return SiteMembershipRequestRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests")
    Call<SiteMembershipRequestRepresentation> createSiteMembershipRequestForPersonCall(
            @Path(PERSON_ID) String personId, @Body SiteMembershipRequestBodyCreate siteMembershipBodyCreate,
            @Query(FIELDS) FieldsParam fields);

    // SITE MEMBERSHIP REQUEST FOR A SPECIFIC SITE
    // INFO

    /**
     * Get a site membership body Returns the site membership body for site
     * **siteId** for person **personId**, if one exists. You can use the
     * &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param siteId The identifier of a site. (required)
     * @return SiteMembershipRequestRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests/{siteId}")
    Call<SiteMembershipRequestRepresentation> getSiteMembershipRequestForPersonCall(@Path(PERSON_ID) String personId,
            @Path(SITE_ID) String siteId);

    /**
     * Get a site membership body Returns the site membership body for site
     * **siteId** for person **personId**, if one exists. You can use the
     * &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param siteId The identifier of a site. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SiteMembershipRequestRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests/{siteId}")
    Call<SiteMembershipRequestRepresentation> getSiteMembershipRequestsForPersonCall(@Path(PERSON_ID) String personId,
            @Path(SITE_ID) String siteId, @Query(FIELDS) FieldsParam fields);

    // SITE MEMBERSHIP REQUEST FOR A SPECIFIC SITE
    // UPDATE

    /**
     * Update a site membership body Updates the message for the site membership
     * body to site **siteId** for person **personId**. You can use the
     * &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param siteId The identifier of a site. (required)
     * @param siteMembershipRequestBodyUpdate The new message to display
     *            (required)
     * @return SiteMembershipRequestRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests/{siteId}")
    Call<SiteMembershipRequestRepresentation> updateSiteMembershipRequestForPersonCall(
            @Path(PERSON_ID) String personId, @Path(SITE_ID) String siteId,
            @Body SiteMembershipRequestBodyUpdate siteMembershipRequestBodyUpdate,
            @Query(FIELDS) FieldsParam fields);

    // SITE MEMBERSHIP REQUEST FOR A SPECIFIC SITE
    // CANCEL

    /**
     * Cancel a site membership Cancels the site membership body to site
     * **siteId** for person **personId**. You can use the &#x60;-me-&#x60;
     * string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently
     * authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param siteId The identifier of a site. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests/{siteId}")
    Call<Void> deleteSiteMembershipRequestCall(@Path(PERSON_ID) String personId, @Path(SITE_ID) String siteId);

    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////

    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * List sites Gets a list of sites in this repository. You can use the
     * **where** parameter to filter the returned sites by **visibility**. For
     * example, any one of: &#x60;&#x60;&#x60; (visibility&#x3D;PRIVATE)
     * (visibility&#x3D;PUBLIC) (visibility&#x3D;MODERATED) &#x60;&#x60;&#x60;
     * The default sort order for the returned list is for sites to be sorted by
     * ascending title. You can override the default by using the **orderBy**
     * parameter. You can specify one or more of the following fields in the
     * **orderBy** parameter: * id * title * description You can use the
     * **relations** parameter to include one or more related entities in a
     * single response and so reduce network traffic. The entity types in
     * Alfresco are organized in a tree structure. The **sites** entity has two
     * children, **containers** and **members**. The following relations
     * parameter returns all the container and member objects related to each
     * site: &#x60;&#x60;&#x60; containers,members &#x60;&#x60;&#x60;
     *
     * @return SitePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites")
    Observable<ResultPaging<SiteRepresentation>> listSitesObservable();

    /**
     * List sites Gets a list of sites in this repository. You can use the
     * **where** parameter to filter the returned sites by **visibility**. For
     * example, any one of: &#x60;&#x60;&#x60; (visibility&#x3D;PRIVATE)
     * (visibility&#x3D;PUBLIC) (visibility&#x3D;MODERATED) &#x60;&#x60;&#x60;
     * The default sort order for the returned list is for sites to be sorted by
     * ascending title. You can override the default by using the **orderBy**
     * parameter. You can specify one or more of the following fields in the
     * **orderBy** parameter: * id * title * description You can use the
     * **relations** parameter to include one or more related entities in a
     * single response and so reduce network traffic. The entity types in
     * Alfresco are organized in a tree structure. The **sites** entity has two
     * children, **containers** and **members**. The following relations
     * parameter returns all the container and member objects related to each
     * site: &#x60;&#x60;&#x60; containers,members &#x60;&#x60;&#x60;
     *
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param orderBy A string to control the order of the entities returned in
     *            a list. You can use the **orderBy** parameter to sort the list
     *            by one or more fields. Each field has a default sort order,
     *            which is normally acending order. Read the API method
     *            implementation notes above to check if any fields used in this
     *            method have a descending default search order. To sort the
     *            entities in a specific order, you can use the **ASC** and
     *            **DESC** keywords for any field. (optional)
     * @param relations Use the relations parameter to include one or more
     *            related entities in a single response. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @param where A string to restrict the returned objects by using a
     *            predicate. (optional)
     * @return SitePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites")
    Observable<ResultPaging<SiteRepresentation>> listSitesObservable(
            @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(ORDER_BY) OrderByParam orderBy, @Query(RELATIONS) int relations, @Query(FIELDS) FieldsParam fields,
            @Query(WHERE) String where);

    // ///////////////////////////////////////////////////////////////////////////
    // INFO
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Get a site Returns information for site **siteId**. You can use the
     * **relations** parameter to include one or more related entities in a
     * single response and so reduce network traffic. The entity types in
     * Alfresco are organized in a tree structure. The **sites** entity has two
     * children, **containers** and **members**. The following relations
     * parameter returns all the container and member objects related to the
     * site **siteId**: &#x60;&#x60;&#x60; containers,members &#x60;&#x60;&#x60;
     *
     * @param siteId The identifier of a site. (required)
     * @return SiteRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}")
    Observable<SiteRepresentation> getSiteObservable(@Path(SITE_ID) String siteId);

    /**
     * Get a site Returns information for site **siteId**. You can use the
     * **relations** parameter to include one or more related entities in a
     * single response and so reduce network traffic. The entity types in
     * Alfresco are organized in a tree structure. The **sites** entity has two
     * children, **containers** and **members**. The following relations
     * parameter returns all the container and member objects related to the
     * site **siteId**: &#x60;&#x60;&#x60; containers,members &#x60;&#x60;&#x60;
     *
     * @param siteId The identifier of a site. (required)
     * @param relations Use the relations parameter to include one or more
     *            related entities in a single response. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SiteRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}")
    Observable<SiteRepresentation> getSiteObservable(@Path(SITE_ID) String siteId, @Query(RELATIONS) int relations,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Create a site Creates a default site with the given details. Unless
     * explicitly specified, the site id will be generated from the site title.
     * The site id must be unique and only contain alphanumeric and/or dash
     * characters. For example, to create a public site called
     * \&quot;Marketing\&quot; the following body could be used:
     * &#x60;&#x60;&#x60;JSON { \&quot;title\&quot;: \&quot;Marketing\&quot;,
     * \&quot;visibility\&quot;: \&quot;PUBLIC\&quot; } &#x60;&#x60;&#x60; The
     * creation of the (surf) configuration files required by Share can be
     * skipped via the **skipConfiguration** query parameter. **Please note: if
     * skipped then such a site will *not* work within Share.** The addition of
     * the site to the user&#39;s site favorites can be skipped via the
     * **skipAddToFavorites** query parameter. The creator will be added as a
     * member with Site Manager role.
     *
     * @param siteBodyCreate The site details (required)
     * @return SiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/sites")
    Observable<SiteRepresentation> createSiteObservable(@Body SiteBodyCreate siteBodyCreate);

    /**
     * Create a site Creates a default site with the given details. Unless
     * explicitly specified, the site id will be generated from the site title.
     * The site id must be unique and only contain alphanumeric and/or dash
     * characters. For example, to create a public site called
     * \&quot;Marketing\&quot; the following body could be used:
     * &#x60;&#x60;&#x60;JSON { \&quot;title\&quot;: \&quot;Marketing\&quot;,
     * \&quot;visibility\&quot;: \&quot;PUBLIC\&quot; } &#x60;&#x60;&#x60; The
     * creation of the (surf) configuration files required by Share can be
     * skipped via the **skipConfiguration** query parameter. **Please note: if
     * skipped then such a site will *not* work within Share.** The addition of
     * the site to the user&#39;s site favorites can be skipped via the
     * **skipAddToFavorites** query parameter. The creator will be added as a
     * member with Site Manager role.
     *
     * @param siteBodyCreate The site details (required)
     * @param skipConfiguration Flag to indicate whether the Share-specific
     *            (surf) configuration files for the site should not be created.
     *            (optional, default to false)
     * @param skipAddToFavorites Flag to indicate whether the site should not be
     *            added to the user&#39;s site favorites. (optional, default to
     *            false)
     * @return SiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/sites")
    Observable<SiteRepresentation> createSiteObservable(@Body SiteBodyCreate siteBodyCreate,
            @Query(SKIP_CONFIGURATION) int skipConfiguration, @Query(SKIP_ADD_TO_FAVORITES) int skipAddToFavorites,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
     * Update the details for the given site **siteId**. Site Manager or
     * otherwise a (site) admin can update title, description or visibility.
     * Note: the id of a site cannot be updated once the site has been created.
     *
     * @param siteId The identifier of a site. (required)
     * @param siteBodyUpdate The site details (required)
     * @return SiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}")
    Observable<SiteRepresentation> updateSiteObservable(@Path(SITE_ID) String siteId,
            @Body SiteBodyUpdate siteBodyUpdate);

    /**
     * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
     * Update the details for the given site **siteId**. Site Manager or
     * otherwise a (site) admin can update title, description or visibility.
     * Note: the id of a site cannot be updated once the site has been created.
     *
     * @param siteId The identifier of a site. (required)
     * @param siteBodyUpdate The site details (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}")
    Observable<SiteRepresentation> updateSiteObservable(@Path(SITE_ID) String siteId,
            @Body SiteBodyUpdate siteBodyUpdate, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Delete a site Deletes the site with **siteId**.
     *
     * @param siteId The identifier of a site. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}")
    Observable<Void> deleteSiteObservable(@Path(SITE_ID) String siteId);

    /**
     * Delete a site Deletes the site with **siteId**.
     *
     * @param siteId The identifier of a site. (required)
     * @param permanent Flag to indicate whether the site should be permanently
     *            deleted i.e. bypass the trashcan. (optional, default to false)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}")
    Observable<Void> deleteSiteObservable(@Path(SITE_ID) String siteId, @Query(PERMANENT) Boolean permanent);

    // ///////////////////////////////////////////////////////////////////////////
    // CONTAINERS
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Get containers Returns a list of containers information for site
     * identified by **siteId**.
     *
     * @param siteId The identifier of a site. (required)
     * @return SiteContainerPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/containers")
    Observable<ResultPaging<SiteContainerRepresentation>> listSiteContainersObservable(@Path(SITE_ID) String siteId);

    /**
     * Get containers Returns a list of containers information for site
     * identified by **siteId**.
     *
     * @param siteId The identifier of a site. (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SiteContainerPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites")
    Observable<ResultPaging<SiteContainerRepresentation>> listSiteContainersObservable(@Path(SITE_ID) String siteId,
            @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(FIELDS) FieldsParam fields);

    /**
     * Get a container Returns information on the container **containerId** in
     * site **siteId**.
     *
     * @param siteId The identifier of a site. (required)
     * @param containerId The unique identifier of a site container. (required)
     * @return SiteContainerEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/containers/{containerId}")
    Observable<SiteContainerRepresentation> getSiteContainerObservable(@Path(SITE_ID) String siteId,
            @Path(CONTAINER_ID) String containerId);

    /**
     * Get a container Returns information on the container **containerId** in
     * site **siteId**.
     *
     * @param siteId The identifier of a site. (required)
     * @param containerId The unique identifier of a site container. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SiteContainerEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/containers/{containerId}")
    Observable<SiteContainerRepresentation> getSiteContainerObservable(@Path(SITE_ID) String siteId,
            @Path(CONTAINER_ID) String containerId, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // MEMBERSHIP
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Get members Returns a list of site memberships for site **siteId**.
     *
     * @param siteId The identifier of a site. (required)
     * @return SiteMemberPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/members")
    Observable<ResultPaging<SiteMemberRepresentation>> listSiteMembershipsObservable(@Path(SITE_ID) String siteId);

    /**
     * Get members Returns a list of site memberships for site **siteId**.
     *
     * @param siteId The identifier of a site. (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SiteMemberPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/members")
    Observable<ResultPaging<SiteMemberRepresentation>> listSiteMembershipsObservable(@Path(SITE_ID) String siteId,
            @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(FIELDS) FieldsParam fields);

    /**
     * Add a person Adds person **personId** as a member of site **siteId**. You
     * can set the **role** to one of four types: * SiteConsumer *
     * SiteCollaborator * SiteContributor * SiteManager
     *
     * @param siteId The identifier of a site. (required)
     * @param siteMembershipBodyCreate The person to add and their role
     *            (required)
     * @return SiteMemberEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/members")
    Observable<SiteMemberRepresentation> createSiteMembershipObservable(@Path(SITE_ID) String siteId,
            @Body SiteMembershipBodyCreate siteMembershipBodyCreate,
            @Query(FIELDS) FieldsParam fields);

    /**
     * Get a site member Returns site membership information for person
     * **personId** on site **siteId**. You can use the &#x60;-me-&#x60; string
     * in place of &#x60;&lt;personId&gt;&#x60; to specify the currently
     * authenticated user.
     *
     * @param siteId The identifier of a site. (required)
     * @param personId The identifier of a person. (required)
     * @return SiteMemberEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/members/{personId}")
    Observable<SiteMemberRepresentation> getSiteMembershipObservable(@Path(SITE_ID) String siteId,
            @Path(PERSON_ID) String personId);

    /**
     * Update a site member Update the membership of person **personId** in site
     * **siteId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * You can set the **role** to one of four types: * SiteConsumer *
     * SiteCollaborator * SiteContributor * SiteManager
     *
     * @param siteId The identifier of a site. (required)
     * @param personId The identifier of a person. (required)
     * @param siteMemberRoleBody The persons new role (required)
     * @return SiteMemberEntry
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/members/{personId}")
    Observable<SiteMemberRepresentation> updateSiteMembershipObservable(@Path(SITE_ID) String siteId,
            @Path(PERSON_ID) String personId, @Body SiteMembershipBodyUpdate siteMemberRoleBody,
            @Query(FIELDS) FieldsParam fields);

    /**
     * Delete a site member Removes person **personId** as a member of site
     * **siteId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     *
     * @param siteId The identifier of a site. (required)
     * @param personId The identifier of a person. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/sites/{siteId}/members/{personId}")
    Observable<Void> deleteSiteMembershipObservable(@Path(SITE_ID) String siteId, @Path(PERSON_ID) String personId);

    // ///////////////////////////////////////////////////////////////////////////
    // LISTING PERSON SITE MEMBERSHIP
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * List site memberships Gets a list of site membership information for
     * person **personId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * You can use the **where** parameter to filter the returned sites by
     * **visibility**. For example, any one of: &#x60;&#x60;&#x60;
     * (visibility&#x3D;PRIVATE) (visibility&#x3D;PUBLIC)
     * (visibility&#x3D;MODERATED) &#x60;&#x60;&#x60; The default sort order for
     * the returned list is for sites to be sorted by ascending title. You can
     * override the default by using the **orderBy** parameter. You can specify
     * one or more of the following fields in the **orderBy** parameter: * id *
     * title * role
     *
     * @param personId The identifier of a person. (required)
     * @return SiteRolePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/sites")
    Observable<ResultPaging<SiteRoleRepresentation>> listSiteMembershipsForPersonObservable(
            @Path(PERSON_ID) String personId);

    /**
     * List site memberships Gets a list of site membership information for
     * person **personId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * You can use the **where** parameter to filter the returned sites by
     * **visibility**. For example, any one of: &#x60;&#x60;&#x60;
     * (visibility&#x3D;PRIVATE) (visibility&#x3D;PUBLIC)
     * (visibility&#x3D;MODERATED) &#x60;&#x60;&#x60; The default sort order for
     * the returned list is for sites to be sorted by ascending title. You can
     * override the default by using the **orderBy** parameter. You can specify
     * one or more of the following fields in the **orderBy** parameter: * id *
     * title * role
     *
     * @param personId The identifier of a person. (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param orderBy A string to control the order of the entities returned in
     *            a list. You can use the **orderBy** parameter to sort the list
     *            by one or more fields. Each field has a default sort order,
     *            which is normally acending order. Read the API method
     *            implementation notes above to check if any fields used in this
     *            method have a descending default search order. To sort the
     *            entities in a specific order, you can use the **ASC** and
     *            **DESC** keywords for any field. (optional)
     * @param relations Use the relations parameter to include one or more
     *            related entities in a single response. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @param where A string to restrict the returned objects by using a
     *            predicate. (optional)
     * @return SiteRolePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/sites")
    Observable<ResultPaging<SiteRoleRepresentation>> listSiteMembershipsForPersonObservable(
            @Path(PERSON_ID) String personId, @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(ORDER_BY) OrderByParam orderBy, @Query(RELATIONS) String relations,
            @Query(FIELDS) FieldsParam fields, @Query(WHERE) String where);

    // ///////////////////////////////////////////////////////////////////////////
    // INFO PERSON SITE MEMBERSHIP
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Get site membership for a site Returns site membership information for
     * person **personId** on site **siteId**. You can use the &#x60;-me-&#x60;
     * string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently
     * authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param siteId The identifier of a site. (required)
     * @return SiteRoleRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/sites/{siteId}")
    Observable<SiteRoleRepresentation> getSiteMembershipForPersonObservable(@Path(PERSON_ID) String personId,
            @Path(SITE_ID) String siteId);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE PERSON SITE MEMBERSHIP
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Delete a site membership Deletes person **personId** as a member of site
     * **siteId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param siteId The identifier of a site. (required)
     * @return ApiResponse&lt;Void&gt;
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/sites/{siteId}")
    Observable<Void> deleteSiteMembershipForPersonObservable(@Path(PERSON_ID) String personId,
            @Path(SITE_ID) String siteId);

    // ///////////////////////////////////////////////////////////////////////////
    // SITE MEMBERSHIP REQUEST
    // ///////////////////////////////////////////////////////////////////////////
    // LISTING

    /**
     * Get site membership requests Returns the current site membership requests
     * for person **personId**. You can use the &#x60;-me-&#x60; string in place
     * of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated
     * user.
     *
     * @param personId The identifier of a person. (required)
     * @return ResultPaging<SiteMembershipRequestRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests")
    Observable<ResultPaging<SiteMembershipRequestRepresentation>> listSiteMembershipRequestsForPersonObservable(
            @Path(PERSON_ID) String personId);

    /**
     * Get site membership requests Returns the current site membership requests
     * for person **personId**. You can use the &#x60;-me-&#x60; string in place
     * of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated
     * user.
     *
     * @param personId The identifier of a person. (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return ResultPaging<SiteMembershipRequestRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests")
    Observable<ResultPaging<SiteMembershipRequestRepresentation>> listSiteMembershipRequestsForPersonObservable(
            @Path(PERSON_ID) String personId, @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(FIELDS) FieldsParam fields);

    // SITE MEMBERSHIP REQUEST
    // CREATE

    /**
     * Create a site membership body Create a site membership body for yourself
     * on the site with the identifier of **id**, specified in the JSON body.
     * The result of the body differs depending on the type of site. * For a
     * **public** site, you join the site immediately as a SiteConsumer. * For a
     * **moderated** site, your body is added to the site membership body list.
     * The body waits for approval from the Site Manager. * You cannot body
     * membership of a **private** site. Members are invited by the site
     * administrator. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * **Note:** You can create site membership requests for more than one site
     * by specifying a list of sites in the JSON body like this:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;message\&quot;: \&quot;Please can you
     * add me\&quot;, \&quot;id\&quot;: \&quot;test-site-1\&quot;,
     * \&quot;title\&quot;: \&quot;Request for test site 1\&quot;, }, {
     * \&quot;message\&quot;: \&quot;Please can you add me\&quot;,
     * \&quot;id\&quot;: \&quot;test-site-2\&quot;, \&quot;title\&quot;:
     * \&quot;Request for test site 2\&quot;, } ] &#x60;&#x60;&#x60; If you
     * specify a list as input, then a paginated list rather than an entry is
     * returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param personId The identifier of a person. (required)
     * @param siteMembershipBodyCreate Site membership body details (required)
     * @return SiteMembershipRequestRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests")
    Observable<SiteMembershipRequestRepresentation> createSiteMembershipRequestForPersonObservable(
            @Path(PERSON_ID) String personId, @Body SiteMembershipRequestBodyCreate siteMembershipBodyCreate,
            @Query(FIELDS) FieldsParam fields);

    // SITE MEMBERSHIP REQUEST FOR A SPECIFIC SITE
    // INFO

    /**
     * Get a site membership body Returns the site membership body for site
     * **siteId** for person **personId**, if one exists. You can use the
     * &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param siteId The identifier of a site. (required)
     * @return SiteMembershipRequestRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests/{siteId}")
    Observable<SiteMembershipRequestRepresentation> getSiteMembershipRequestForPersonObservable(
            @Path(PERSON_ID) String personId, @Path(SITE_ID) String siteId);

    /**
     * Get a site membership body Returns the site membership body for site
     * **siteId** for person **personId**, if one exists. You can use the
     * &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param siteId The identifier of a site. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SiteMembershipRequestRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests/{siteId}")
    Observable<SiteMembershipRequestRepresentation> getSiteMembershipRequestForPersonObservable(
            @Path(PERSON_ID) String personId, @Path(SITE_ID) String siteId, @Query(FIELDS) FieldsParam fields);

    // SITE MEMBERSHIP REQUEST FOR A SPECIFIC SITE
    // UPDATE

    /**
     * Update a site membership body Updates the message for the site membership
     * body to site **siteId** for person **personId**. You can use the
     * &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param siteId The identifier of a site. (required)
     * @param siteMembershipRequestBodyUpdate The new message to display
     *            (required)
     * @return SiteMembershipRequestRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests/{siteId}")
    Observable<SiteMembershipRequestRepresentation> updateSiteMembershipRequestForPersonObservable(
            @Path(PERSON_ID) String personId, @Path(SITE_ID) String siteId,
            @Body SiteMembershipRequestBodyUpdate siteMembershipRequestBodyUpdate,
            @Query(FIELDS) FieldsParam fields);

    // SITE MEMBERSHIP REQUEST FOR A SPECIFIC SITE
    // CANCEL

    /**
     * Cancel a site membership Cancels the site membership body to site
     * **siteId** for person **personId**. You can use the &#x60;-me-&#x60;
     * string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently
     * authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param siteId The identifier of a site. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/site-membership-requests/{siteId}")
    Observable<Void> deleteSiteMembershipRequestObservable(@Path(PERSON_ID) String personId,
            @Path(SITE_ID) String siteId);
}
