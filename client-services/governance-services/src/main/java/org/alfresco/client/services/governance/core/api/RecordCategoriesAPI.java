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

import static org.alfresco.client.services.common.constant.ApiConstant.*;

import org.alfresco.client.services.common.model.parameters.FieldsParam;
import org.alfresco.client.services.common.model.parameters.IncludeParam;
import org.alfresco.client.services.common.model.parameters.OrderByParam;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.core.model.body.NodeBodyCreate;
import org.alfresco.client.services.governance.core.GovernanceConstant;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyUpdate;
import org.alfresco.client.services.governance.core.model.representation.RMNodeRepresentation;
import org.alfresco.client.services.governance.core.model.representation.RecordCategoryRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface RecordCategoriesAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // GET
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a record category Get information for record category
     * **recordCategoryId** Besides mandatory fields the record category&#39;s
     * aspects and properties are returned by default.
     * 
     * @param recordCategoryId The identifier of a record category. (required)
     * @return RecordCategoryRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}")
    Call<RecordCategoryRepresentation> getRecordCategoryCall(@Path(RECORD_CATEGORY_ID) String recordCategoryId);

    /**
     * Get a record category Get information for record category
     * **recordCategoryId** Besides mandatory fields the record category&#39;s
     * aspects and properties are returned by default.
     * 
     * @param recordCategoryId The identifier of a record category. (required)
     * @param include Returns additional information about the record category.
     *            Any optional field from the response model can be requested.
     *            For example: * hasRetentionSchedule * isRecordCategory *
     *            allowableOperations * path (optional)
     * @param relativePath Return information on children in the record category
     *            resolved by this path. The path is relative to
     *            **recordCategoryId**. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordCategoryRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}")
    Call<RecordCategoryRepresentation> getRecordCategoryCall(@Path(RECORD_CATEGORY_ID) String recordCategoryId,
            @Query(INCLUDE) IncludeParam include, @Query(RELATIVE_PATH) String relativePath,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update a record category Updates record category **recordCategoryId**.
     * For example, you can rename a record category: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My new name\&quot; } &#x60;&#x60;&#x60; You can
     * also set or update one or more properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;rma:vitalRecordIndicator\&quot;: true,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|6\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** If you want to add or remove aspects, then
     * you must use **GET /record-categories/{recordCategoryId}** first to get
     * the complete set of *aspectNames*. **Note:** Currently there is no
     * optimistic locking for updates, so they are applied in \&quot;last one
     * wins\&quot; order.
     *
     * @param recordCategoryId The identifier of a record category. (required)
     * @param recordCategoryBodyUpdate The record category information to
     *            update. (required)
     * @return RecordCategoryEntry
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}")
    Call<RecordCategoryRepresentation> updateRecordCategoryCall(@Path(RECORD_CATEGORY_ID) String recordCategoryId,
            @Body RMNodeBodyUpdate recordCategoryBodyUpdate);

    /**
     * Update a record category Updates record category **recordCategoryId**.
     * For example, you can rename a record category: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My new name\&quot; } &#x60;&#x60;&#x60; You can
     * also set or update one or more properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;rma:vitalRecordIndicator\&quot;: true,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|6\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** If you want to add or remove aspects, then
     * you must use **GET /record-categories/{recordCategoryId}** first to get
     * the complete set of *aspectNames*. **Note:** Currently there is no
     * optimistic locking for updates, so they are applied in \&quot;last one
     * wins\&quot; order.
     * 
     * @param recordCategoryId The identifier of a record category. (required)
     * @param recordCategoryBodyUpdate The record category information to
     *            update. (required)
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
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}")
    Call<RecordCategoryRepresentation> updateRecordCategoryCall(@Path(RECORD_CATEGORY_ID) String recordCategoryId,
            @Body RMNodeBodyUpdate recordCategoryBodyUpdate,
            @Query(INCLUDE) IncludeParam include, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete a record category Deletes record category **recordCategoryId**.
     * 
     * @param recordCategoryId The identifier of a record category. (required)
     */
    @DELETE(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}")
    Call<Void> deleteRecordCategoryCall(@Path(RECORD_CATEGORY_ID) String recordCategoryId);

    // ///////////////////////////////////////////////////////////////////////////
    // CHILDREN LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List record category&#39;s children Returns a list of record categories
     * and/or record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information. The list of child nodes includes primary children and
     * secondary children, if there are any. You can use the **include**
     * parameter (include&#x3D;association) to return child association details
     * for each child, including the **assocType** and the **isPrimary** flag.
     *
     * @param recordCategoryId The identifier of a record category. (required)
     * @return RecordCategoryAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}/children")
    Call<ResultPaging<RMNodeRepresentation>> listRecordCategoryChildrenCall(
            @Path(RECORD_CATEGORY_ID) String recordCategoryId);

    /**
     * List record category&#39;s children Returns a list of record categories
     * and/or record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information. The list of child nodes includes primary children and
     * secondary children, if there are any. You can use the **include**
     * parameter (include&#x3D;association) to return child association details
     * for each child, including the **assocType** and the **isPrimary** flag.
     *
     * @param recordCategoryId The identifier of a record category. (required)
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
     * @return RecordCategoryAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}/children")
    Call<ResultPaging<RMNodeRepresentation>> listRecordCategoryChildrenCall(
            @Path(RECORD_CATEGORY_ID) String recordCategoryId, @Query(SKIP_COUNT) Integer skipCount,
            @Query(MAX_ITEMS) Integer maxItems, @Query(ORDER_BY) OrderByParam orderBy);

    /**
     * List record category&#39;s children Returns a list of record categories
     * and/or record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information. The list of child nodes includes primary children and
     * secondary children, if there are any. You can use the **include**
     * parameter (include&#x3D;association) to return child association details
     * for each child, including the **assocType** and the **isPrimary** flag.
     * 
     * @param recordCategoryId The identifier of a record category. (required)
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
     * @param where Optionally filter the list. Here are some examples: *
     *            &#x60;&#x60;&#x60;where&#x3D;(nodeType&#x3D;&#39;rma:
     *            recordFolder&#39;)&#x60;&#x60;&#x60; *
     *            &#x60;&#x60;&#x60;where&#x3D;(nodeType&#x3D;&#39;rma:
     *            recordCategory&#39;)&#x60;&#x60;&#x60; *
     *            &#x60;&#x60;&#x60;where&#x3D;(isRecordFolder&#x3D;true AND
     *            isClosed&#x3D;false)&#x60;&#x60;&#x60; (optional)
     * @param include Returns additional information about the record category.
     *            Any optional field from the response model can be requested.
     *            For example: * properties * aspectNames * hasRetentionSchedule
     *            * isClosed * isRecordCategory * isRecordFolder *
     *            allowableOperations * path (optional)
     * @param relativePath Return information on children in the record category
     *            resolved by this path. The path is relative to
     *            **recordCategoryId**. (optional)
     * @param includeSource Also include **source** in addition to **entries**
     *            with folder information on the parent node � either the
     *            specified parent **recordCategoryId**, or as resolved by
     *            **relativePath**. (optional)
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
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}/children")
    Call<ResultPaging<RMNodeRepresentation>> listRecordCategoryChildrenCall(
            @Path(RECORD_CATEGORY_ID) String recordCategoryId, @Query(SKIP_COUNT) Integer skipCount,
            @Query(MAX_ITEMS) Integer maxItems, @Query(ORDER_BY) OrderByParam orderBy, @Query(WHERE) String where,
            @Query(INCLUDE) IncludeParam include, @Query(RELATIVE_PATH) String relativePath,
            @Query(INCLUDE_SOURCE) Boolean includeSource, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CHILDREN CREATION
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create a record category or a record folder Create a record category or a
     * record folder as a primary child of **recordCategoryId**. You can set the
     * **autoRename** boolean field to automatically resolve name clashes. If
     * there is a name clash, then the API method tries to create a unique name
     * using an integer suffix. Any field in the JSON body defined below can
     * also be passed as a form-data field. This API method also supports record
     * category or record folder creation using application/json. You must
     * specify at least a **name** and **nodeType**. You can create a category
     * like this: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordCategory\&quot;
     * } &#x60;&#x60;&#x60; You can create a record folder like this:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Folder\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordFolder\&quot; }
     * &#x60;&#x60;&#x60; You can create a record folder inside a container
     * hierarchy (applies to record categories as well): &#x60;&#x60;&#x60;JSON
     * { \&quot;name\&quot;:\&quot;My Fileplan Component\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:recordFolder\&quot;,
     * \&quot;relativePath\&quot;:\&quot;X/Y/Z\&quot; } &#x60;&#x60;&#x60; The
     * **relativePath** specifies the container structure to create relative to
     * the node (record category or record folder). Containers in the
     * **relativePath** that do not exist are created before the node is
     * created. The container type is decided considering the type of the parent
     * container and the type of the node to be created. You can set properties
     * when creating a record category (applies to record folders as well):
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordCategory\&quot;,
     * \&quot;properties\&quot;: {
     * \&quot;rma:vitalRecordIndicator\&quot;:\&quot;true\&quot;,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|1\&quot; } }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record category and a record folder inside the specified **categoryId**:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordCategory\&quot;
     * }, { \&quot;name\&quot;:\&quot;My Record Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:recordFolder\&quot; } ]
     * &#x60;&#x60;&#x60; If you specify a list as input, then a paginated list
     * rather than an entry is returned in the response body. For example:
     * &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: { \&quot;pagination\&quot;:
     * { \&quot;count\&quot;: 2, \&quot;hasMoreItems\&quot;: false,
     * \&quot;totalItems\&quot;: 2, \&quot;skipCount\&quot;: 0,
     * \&quot;maxItems\&quot;: 100 }, \&quot;entries\&quot;: [ {
     * \&quot;entry\&quot;: { ... } }, { \&quot;entry\&quot;: { ... } } ] } }
     * &#x60;&#x60;&#x60;
     *
     * @param recordCategoryId The identifier of a record category. (required)
     * @param nodeBodyCreate The node information to create. (required)
     * @return RecordCategoryChildEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}/children")
    Call<RMNodeRepresentation> createRecordCategoryChildCall(@Path(RECORD_CATEGORY_ID) String recordCategoryId,
            @Body NodeBodyCreate nodeBodyCreate);

    /**
     * Create a record category or a record folder Create a record category or a
     * record folder as a primary child of **recordCategoryId**. You can set the
     * **autoRename** boolean field to automatically resolve name clashes. If
     * there is a name clash, then the API method tries to create a unique name
     * using an integer suffix. Any field in the JSON body defined below can
     * also be passed as a form-data field. This API method also supports record
     * category or record folder creation using application/json. You must
     * specify at least a **name** and **nodeType**. You can create a category
     * like this: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordCategory\&quot;
     * } &#x60;&#x60;&#x60; You can create a record folder like this:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Folder\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordFolder\&quot; }
     * &#x60;&#x60;&#x60; You can create a record folder inside a container
     * hierarchy (applies to record categories as well): &#x60;&#x60;&#x60;JSON
     * { \&quot;name\&quot;:\&quot;My Fileplan Component\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:recordFolder\&quot;,
     * \&quot;relativePath\&quot;:\&quot;X/Y/Z\&quot; } &#x60;&#x60;&#x60; The
     * **relativePath** specifies the container structure to create relative to
     * the node (record category or record folder). Containers in the
     * **relativePath** that do not exist are created before the node is
     * created. The container type is decided considering the type of the parent
     * container and the type of the node to be created. You can set properties
     * when creating a record category (applies to record folders as well):
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordCategory\&quot;,
     * \&quot;properties\&quot;: {
     * \&quot;rma:vitalRecordIndicator\&quot;:\&quot;true\&quot;,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|1\&quot; } }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record category and a record folder inside the specified **categoryId**:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordCategory\&quot;
     * }, { \&quot;name\&quot;:\&quot;My Record Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:recordFolder\&quot; } ]
     * &#x60;&#x60;&#x60; If you specify a list as input, then a paginated list
     * rather than an entry is returned in the response body. For example:
     * &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: { \&quot;pagination\&quot;:
     * { \&quot;count\&quot;: 2, \&quot;hasMoreItems\&quot;: false,
     * \&quot;totalItems\&quot;: 2, \&quot;skipCount\&quot;: 0,
     * \&quot;maxItems\&quot;: 100 }, \&quot;entries\&quot;: [ {
     * \&quot;entry\&quot;: { ... } }, { \&quot;entry\&quot;: { ... } } ] } }
     * &#x60;&#x60;&#x60;
     * 
     * @param recordCategoryId The identifier of a record category. (required)
     * @param nodeBodyCreate The node information to create. (required)
     * @param autoRename If true, then a name clash will cause an attempt to
     *            auto rename by finding a unique name using an integer suffix.
     *            (optional)
     * @param include Returns additional information about the record category.
     *            Any optional field from the response model can be requested.
     *            For example: * allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordCategoryChildEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}/children")
    Call<RMNodeRepresentation> createRecordCategoryChildCall(@Path(RECORD_CATEGORY_ID) String recordCategoryId,
            @Body NodeBodyCreate nodeBodyCreate, @Query(AUTO_RENAME) boolean autoRename,
            @Query(INCLUDE) IncludeParam include, @Query(FIELDS) FieldsParam fields);

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
    // GET
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a record category Get information for record category
     * **recordCategoryId** Besides mandatory fields the record category&#39;s
     * aspects and properties are returned by default.
     *
     * @param recordCategoryId The identifier of a record category. (required)
     * @return RecordCategoryRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}")
    Observable<RecordCategoryRepresentation> getRecordCategoryObservable(
            @Path(RECORD_CATEGORY_ID) String recordCategoryId);

    /**
     * Get a record category Get information for record category
     * **recordCategoryId** Besides mandatory fields the record category&#39;s
     * aspects and properties are returned by default.
     *
     * @param recordCategoryId The identifier of a record category. (required)
     * @param include Returns additional information about the record category.
     *            Any optional field from the response model can be requested.
     *            For example: * hasRetentionSchedule * isRecordCategory *
     *            allowableOperations * path (optional)
     * @param relativePath Return information on children in the record category
     *            resolved by this path. The path is relative to
     *            **recordCategoryId**. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordCategoryRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}")
    Observable<RecordCategoryRepresentation> getRecordCategoryObservable(
            @Path(RECORD_CATEGORY_ID) String recordCategoryId, @Query(INCLUDE) IncludeParam include,
            @Query(RELATIVE_PATH) String relativePath, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update a record category Updates record category **recordCategoryId**.
     * For example, you can rename a record category: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My new name\&quot; } &#x60;&#x60;&#x60; You can
     * also set or update one or more properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;rma:vitalRecordIndicator\&quot;: true,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|6\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** If you want to add or remove aspects, then
     * you must use **GET /record-categories/{recordCategoryId}** first to get
     * the complete set of *aspectNames*. **Note:** Currently there is no
     * optimistic locking for updates, so they are applied in \&quot;last one
     * wins\&quot; order.
     *
     * @param recordCategoryId The identifier of a record category. (required)
     * @param recordCategoryBodyUpdate The record category information to
     *            update. (required)
     * @return RecordCategoryEntry
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}")
    Observable<RecordCategoryRepresentation> updateRecordCategoryObservable(
            @Path(RECORD_CATEGORY_ID) String recordCategoryId, @Body RMNodeBodyUpdate recordCategoryBodyUpdate);

    /**
     * Update a record category Updates record category **recordCategoryId**.
     * For example, you can rename a record category: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My new name\&quot; } &#x60;&#x60;&#x60; You can
     * also set or update one or more properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;rma:vitalRecordIndicator\&quot;: true,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|6\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** If you want to add or remove aspects, then
     * you must use **GET /record-categories/{recordCategoryId}** first to get
     * the complete set of *aspectNames*. **Note:** Currently there is no
     * optimistic locking for updates, so they are applied in \&quot;last one
     * wins\&quot; order.
     *
     * @param recordCategoryId The identifier of a record category. (required)
     * @param recordCategoryBodyUpdate The record category information to
     *            update. (required)
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
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}")
    Observable<RecordCategoryRepresentation> updateRecordCategoryObservable(
            @Path(RECORD_CATEGORY_ID) String recordCategoryId, @Body RMNodeBodyUpdate recordCategoryBodyUpdate,
            @Query(INCLUDE) IncludeParam include, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete a record category Deletes record category **recordCategoryId**.
     *
     * @param recordCategoryId The identifier of a record category. (required)
     */
    @DELETE(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}")
    Observable<Void> deleteRecordCategoryObservable(@Path(RECORD_CATEGORY_ID) String recordCategoryId);

    // ///////////////////////////////////////////////////////////////////////////
    // CHILDREN LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List record category&#39;s children Returns a list of record categories
     * and/or record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information. The list of child nodes includes primary children and
     * secondary children, if there are any. You can use the **include**
     * parameter (include&#x3D;association) to return child association details
     * for each child, including the **assocType** and the **isPrimary** flag.
     *
     * @param recordCategoryId The identifier of a record category. (required)
     * @return RecordCategoryAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}/children")
    Observable<ResultPaging<RMNodeRepresentation>> listRecordCategoryChildrenObservable(
            @Path(RECORD_CATEGORY_ID) String recordCategoryId);

    /**
     * List record category&#39;s children Returns a list of record categories
     * and/or record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information. The list of child nodes includes primary children and
     * secondary children, if there are any. You can use the **include**
     * parameter (include&#x3D;association) to return child association details
     * for each child, including the **assocType** and the **isPrimary** flag.
     *
     * @param recordCategoryId The identifier of a record category. (required)
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
     * @return RecordCategoryAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}/children")
    Observable<ResultPaging<RMNodeRepresentation>> listRecordCategoryChildrenObservable(
            @Path(RECORD_CATEGORY_ID) String recordCategoryId, @Query(SKIP_COUNT) Integer skipCount,
            @Query(MAX_ITEMS) Integer maxItems, @Query(ORDER_BY) OrderByParam orderBy);

    /**
     * List record category&#39;s children Returns a list of record categories
     * and/or record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information. The list of child nodes includes primary children and
     * secondary children, if there are any. You can use the **include**
     * parameter (include&#x3D;association) to return child association details
     * for each child, including the **assocType** and the **isPrimary** flag.
     *
     * @param recordCategoryId The identifier of a record category. (required)
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
     * @param where Optionally filter the list. Here are some examples: *
     *            &#x60;&#x60;&#x60;where&#x3D;(nodeType&#x3D;&#39;rma:
     *            recordFolder&#39;)&#x60;&#x60;&#x60; *
     *            &#x60;&#x60;&#x60;where&#x3D;(nodeType&#x3D;&#39;rma:
     *            recordCategory&#39;)&#x60;&#x60;&#x60; *
     *            &#x60;&#x60;&#x60;where&#x3D;(isRecordFolder&#x3D;true AND
     *            isClosed&#x3D;false)&#x60;&#x60;&#x60; (optional)
     * @param include Returns additional information about the record category.
     *            Any optional field from the response model can be requested.
     *            For example: * properties * aspectNames * hasRetentionSchedule
     *            * isClosed * isRecordCategory * isRecordFolder *
     *            allowableOperations * path (optional)
     * @param relativePath Return information on children in the record category
     *            resolved by this path. The path is relative to
     *            **recordCategoryId**. (optional)
     * @param includeSource Also include **source** in addition to **entries**
     *            with folder information on the parent node � either the
     *            specified parent **recordCategoryId**, or as resolved by
     *            **relativePath**. (optional)
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
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}/children")
    Observable<ResultPaging<RMNodeRepresentation>> listRecordCategoryChildrenObservable(
            @Path(RECORD_CATEGORY_ID) String recordCategoryId, @Query(SKIP_COUNT) Integer skipCount,
            @Query(MAX_ITEMS) Integer maxItems, @Query(ORDER_BY) OrderByParam orderBy, @Query(WHERE) String where,
            @Query(INCLUDE) IncludeParam include, @Query(RELATIVE_PATH) String relativePath,
            @Query(INCLUDE_SOURCE) Boolean includeSource, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CHILDREN CREATION
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create a record category or a record folder Create a record category or a
     * record folder as a primary child of **recordCategoryId**. You can set the
     * **autoRename** boolean field to automatically resolve name clashes. If
     * there is a name clash, then the API method tries to create a unique name
     * using an integer suffix. Any field in the JSON body defined below can
     * also be passed as a form-data field. This API method also supports record
     * category or record folder creation using application/json. You must
     * specify at least a **name** and **nodeType**. You can create a category
     * like this: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordCategory\&quot;
     * } &#x60;&#x60;&#x60; You can create a record folder like this:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Folder\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordFolder\&quot; }
     * &#x60;&#x60;&#x60; You can create a record folder inside a container
     * hierarchy (applies to record categories as well): &#x60;&#x60;&#x60;JSON
     * { \&quot;name\&quot;:\&quot;My Fileplan Component\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:recordFolder\&quot;,
     * \&quot;relativePath\&quot;:\&quot;X/Y/Z\&quot; } &#x60;&#x60;&#x60; The
     * **relativePath** specifies the container structure to create relative to
     * the node (record category or record folder). Containers in the
     * **relativePath** that do not exist are created before the node is
     * created. The container type is decided considering the type of the parent
     * container and the type of the node to be created. You can set properties
     * when creating a record category (applies to record folders as well):
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordCategory\&quot;,
     * \&quot;properties\&quot;: {
     * \&quot;rma:vitalRecordIndicator\&quot;:\&quot;true\&quot;,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|1\&quot; } }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record category and a record folder inside the specified **categoryId**:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordCategory\&quot;
     * }, { \&quot;name\&quot;:\&quot;My Record Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:recordFolder\&quot; } ]
     * &#x60;&#x60;&#x60; If you specify a list as input, then a paginated list
     * rather than an entry is returned in the response body. For example:
     * &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: { \&quot;pagination\&quot;:
     * { \&quot;count\&quot;: 2, \&quot;hasMoreItems\&quot;: false,
     * \&quot;totalItems\&quot;: 2, \&quot;skipCount\&quot;: 0,
     * \&quot;maxItems\&quot;: 100 }, \&quot;entries\&quot;: [ {
     * \&quot;entry\&quot;: { ... } }, { \&quot;entry\&quot;: { ... } } ] } }
     * &#x60;&#x60;&#x60;
     *
     * @param recordCategoryId The identifier of a record category. (required)
     * @param nodeBodyCreate The node information to create. (required)
     * @return RecordCategoryChildEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}/children")
    Observable<RMNodeRepresentation> createRecordCategoryChildObservable(
            @Path(RECORD_CATEGORY_ID) String recordCategoryId, @Body NodeBodyCreate nodeBodyCreate);

    /**
     * Create a record category or a record folder Create a record category or a
     * record folder as a primary child of **recordCategoryId**. You can set the
     * **autoRename** boolean field to automatically resolve name clashes. If
     * there is a name clash, then the API method tries to create a unique name
     * using an integer suffix. Any field in the JSON body defined below can
     * also be passed as a form-data field. This API method also supports record
     * category or record folder creation using application/json. You must
     * specify at least a **name** and **nodeType**. You can create a category
     * like this: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordCategory\&quot;
     * } &#x60;&#x60;&#x60; You can create a record folder like this:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Folder\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordFolder\&quot; }
     * &#x60;&#x60;&#x60; You can create a record folder inside a container
     * hierarchy (applies to record categories as well): &#x60;&#x60;&#x60;JSON
     * { \&quot;name\&quot;:\&quot;My Fileplan Component\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:recordFolder\&quot;,
     * \&quot;relativePath\&quot;:\&quot;X/Y/Z\&quot; } &#x60;&#x60;&#x60; The
     * **relativePath** specifies the container structure to create relative to
     * the node (record category or record folder). Containers in the
     * **relativePath** that do not exist are created before the node is
     * created. The container type is decided considering the type of the parent
     * container and the type of the node to be created. You can set properties
     * when creating a record category (applies to record folders as well):
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordCategory\&quot;,
     * \&quot;properties\&quot;: {
     * \&quot;rma:vitalRecordIndicator\&quot;:\&quot;true\&quot;,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|1\&quot; } }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record category and a record folder inside the specified **categoryId**:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;name\&quot;:\&quot;My Record
     * Category\&quot;, \&quot;nodeType\&quot;:\&quot;rma:recordCategory\&quot;
     * }, { \&quot;name\&quot;:\&quot;My Record Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:recordFolder\&quot; } ]
     * &#x60;&#x60;&#x60; If you specify a list as input, then a paginated list
     * rather than an entry is returned in the response body. For example:
     * &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: { \&quot;pagination\&quot;:
     * { \&quot;count\&quot;: 2, \&quot;hasMoreItems\&quot;: false,
     * \&quot;totalItems\&quot;: 2, \&quot;skipCount\&quot;: 0,
     * \&quot;maxItems\&quot;: 100 }, \&quot;entries\&quot;: [ {
     * \&quot;entry\&quot;: { ... } }, { \&quot;entry\&quot;: { ... } } ] } }
     * &#x60;&#x60;&#x60;
     *
     * @param recordCategoryId The identifier of a record category. (required)
     * @param nodeBodyCreate The node information to create. (required)
     * @param autoRename If true, then a name clash will cause an attempt to
     *            auto rename by finding a unique name using an integer suffix.
     *            (optional)
     * @param include Returns additional information about the record category.
     *            Any optional field from the response model can be requested.
     *            For example: * allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordCategoryChildEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-categories/{recordCategoryId}/children")
    Observable<RMNodeRepresentation> createRecordCategoryChildObservable(
            @Path(RECORD_CATEGORY_ID) String recordCategoryId, @Body NodeBodyCreate nodeBodyCreate,
            @Query(AUTO_RENAME) boolean autoRename, @Query(INCLUDE) IncludeParam include,
            @Query(FIELDS) FieldsParam fields);

}
