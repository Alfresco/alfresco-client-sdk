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

package org.alfresco.client.services.governance.core.api;

import org.alfresco.client.services.common.constant.PublicAPIConstant;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.core.model.body.NodeBodyCreate;
import org.alfresco.client.services.content.core.model.parameters.FieldsParam;
import org.alfresco.client.services.content.core.model.parameters.IncludeParam;
import org.alfresco.client.services.content.core.model.parameters.OrderByParam;
import org.alfresco.client.services.governance.core.GovernanceConstant;
import org.alfresco.client.services.governance.core.model.body.FilePlanBodyUpdate;
import org.alfresco.client.services.governance.core.model.representation.FilePlanRepresentation;
import org.alfresco.client.services.governance.core.model.representation.RecordCategoryRepresentation;

import retrofit2.Call;
import retrofit2.http.*;

public interface FilePlansAPI
{
    String DEFAULT_FILE_PLAN = "-filePlan-";

    // ///////////////////////////////////////////////////////////////////////////
    // GET
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a file plan Get information for file plan **filePlanId** Besides
     * mandatory fields the file plan&#39;s aspects and properties are returned
     * by default.
     * 
     * @param filePlanId The identifier of a file plan. You can also use the
     *            -filePlan- alias. (required)
     * @return FilePlanEntry
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/file-plans/{filePlanId}")
    Call<FilePlanRepresentation> getFilePlanCall(@Path("filePlanId") String filePlanId);

    /**
     * Get a file plan Get information for file plan **filePlanId** Besides
     * mandatory fields the file plan&#39;s aspects and properties are returned
     * by default.
     * 
     * @param filePlanId The identifier of a file plan. You can also use the
     *            -filePlan- alias. (required)
     * @param include Returns additional information about the file plan. Any
     *            optional field from the response model can be requested. For
     *            example: * allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return FilePlanEntry
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/file-plans/{filePlanId}")
    Call<FilePlanRepresentation> getFilePlanCall(@Path("filePlanId") String filePlanId,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update a file plan Updates file plan **filePlanId**. You can only set or
     * update description and title properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;cm:description\&quot;: \&quot;New
     * Description\&quot;, \&quot;cm:title\&quot;:\&quot;New Title\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** Currently there is no optimistic locking for
     * updates, so they are applied in \&quot;last one wins\&quot; order.
     *
     * @param filePlanId The identifier of a file plan. You can also use the
     *            -filePlan- alias. (required)
     * @param filePlanBodyUpdate The file plan information to update. (required)
     * @return FilePlanRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/file-plans/{filePlanId}")
    Call<FilePlanRepresentation> updateFilePlanCall(@Path("filePlanId") String filePlanId,
            @Body FilePlanBodyUpdate filePlanBodyUpdate);

    /**
     * Update a file plan Updates file plan **filePlanId**. You can only set or
     * update description and title properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;cm:description\&quot;: \&quot;New
     * Description\&quot;, \&quot;cm:title\&quot;:\&quot;New Title\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** Currently there is no optimistic locking for
     * updates, so they are applied in \&quot;last one wins\&quot; order.
     *
     * @param filePlanId The identifier of a file plan. You can also use the
     *            -filePlan- alias. (required)
     * @param filePlanBodyUpdate The file plan information to update. (required)
     * @param include Returns additional information about the file plan. Any
     *            optional field from the response model can be requested. For
     *            example: * allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return FilePlanRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/file-plans/{filePlanId}")
    Call<FilePlanRepresentation> updateFilePlanCall(@Path("filePlanId") String filePlanId,
            @Body FilePlanBodyUpdate filePlanBodyUpdate, @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CATEGORIES LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List file plans&#39;s children Returns a list of record categories.
     * Minimal information for each child is returned by default. You can use
     * the **include** parameter to return additional information. You can use
     * the **include** parameter (include&#x3D;association) to return child
     * association details for each child, including the **assocType** and the
     * **isPrimary** flag.
     *
     * @param filePlanId The identifier of a file plan. You can also use the
     *            -filePlan- alias. (required)
     * @return ResultPaging<RatingRepresentation>
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/file-plans/{filePlanId}/categories")
    Call<ResultPaging<RecordCategoryRepresentation>> listFilePlanCategoriesCall(@Path("filePlanId") String filePlanId);

    /**
     * List file plans&#39;s children Returns a list of record categories.
     * Minimal information for each child is returned by default. You can use
     * the **include** parameter to return additional information. You can use
     * the **include** parameter (include&#x3D;association) to return child
     * association details for each child, including the **assocType** and the
     * **isPrimary** flag.
     *
     * @param filePlanId The identifier of a file plan. You can also use the
     *            -filePlan- alias. (required)
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
     * @return ResultPaging<RatingRepresentation>
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/file-plans/{filePlanId}/categories")
    Call<ResultPaging<RecordCategoryRepresentation>> listFilePlanCategoriesCall(@Path("filePlanId") String filePlanId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy);

    /**
     * List file plans&#39;s children Returns a list of record categories.
     * Minimal information for each child is returned by default. You can use
     * the **include** parameter to return additional information. You can use
     * the **include** parameter (include&#x3D;association) to return child
     * association details for each child, including the **assocType** and the
     * **isPrimary** flag.
     *
     * @param filePlanId The identifier of a file plan. You can also use the
     *            -filePlan- alias. (required)
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
     * @param include Returns additional information about the record category.
     *            Any optional field from the response model can be requested.
     *            For example: * hasRetentionSchedule * isRecordCategory *
     *            allowableOperations * path (optional)
     * @param includeSource Also include **source** in addition to **entries**
     *            with folder information on the parent node � the specified
     *            parent **filePlanId** (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordCategoryAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/file-plans/{filePlanId}/categories")
    Call<ResultPaging<RecordCategoryRepresentation>> listFilePlanCategoriesCall(@Path("filePlanId") String filePlanId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.INCLUDE_SOURCE_VALUE) Boolean includeSource,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CATEGORIES CREATION
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create record categories for given file plan Create a record category as
     * a primary child of **filePlanId**. You can set the **autoRename** boolean
     * field to automatically resolve name clashes. If there is a name clash,
     * then the API method tries to create a unique name using an integer
     * suffix. Any field in the JSON body defined below can also be passed as a
     * form-data field. This API method also supports record category creation
     * using application/json. You must specify at least a **name**. You can
     * create a category like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Record Category\&quot; } &#x60;&#x60;&#x60;
     * You can set properties when creating a record category:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;properties\&quot;: {
     * \&quot;rma:vitalRecordIndicator\&quot;:\&quot;true\&quot;,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|1\&quot; } }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field. If you
     * specify a list as input, then a paginated list rather than an entry is
     * returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     * 
     * @param filePlanId The identifier of a file plan. You can also use the
     *            -filePlan- alias. (required)
     * @param nodeBodyCreate The node information to create. (required)
     * @return RecordCategoryRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/file-plans/{filePlanId}/categories")
    Call<RecordCategoryRepresentation> createFilePlanCategoriesCall(@Path("filePlanId") String filePlanId,
            @Body NodeBodyCreate nodeBodyCreate);

    /**
     * Create record categories for given file plan Create a record category as
     * a primary child of **filePlanId**. You can set the **autoRename** boolean
     * field to automatically resolve name clashes. If there is a name clash,
     * then the API method tries to create a unique name using an integer
     * suffix. Any field in the JSON body defined below can also be passed as a
     * form-data field. This API method also supports record category creation
     * using application/json. You must specify at least a **name**. You can
     * create a category like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Record Category\&quot; } &#x60;&#x60;&#x60;
     * You can set properties when creating a record category:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;properties\&quot;: {
     * \&quot;rma:vitalRecordIndicator\&quot;:\&quot;true\&quot;,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|1\&quot; } }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field. If you
     * specify a list as input, then a paginated list rather than an entry is
     * returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     * 
     * @param filePlanId The identifier of a file plan. You can also use the
     *            -filePlan- alias. (required)
     * @param nodeBodyCreate The node information to create. (required)
     * @param autoRename If true, then a name clash will cause an attempt to
     *            auto rename by finding a unique name using an integer suffix.
     *            (optional)
     * @param include Returns additional information about the record category.
     *            Any optional field from the response model can be requested.
     *            For example: * hasRetentionSchedule * isRecordCategory *
     *            allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordCategoryEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/file-plans/{filePlanId}/categories")
    Call<RecordCategoryRepresentation> createFilePlanCategoriesCall(@Path("filePlanId") String filePlanId,
            @Body NodeBodyCreate nodeBodyCreate, @Query(PublicAPIConstant.AUTO_RENAME_VALUE) boolean autoRename,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);
}
