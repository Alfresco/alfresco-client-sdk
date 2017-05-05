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

import java.util.Map;

import org.alfresco.client.services.common.model.parameters.FieldsParam;
import org.alfresco.client.services.common.model.parameters.IncludeParam;
import org.alfresco.client.services.common.model.parameters.OrderByParam;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.governance.core.GovernanceConstant;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyCreate;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyUpdate;
import org.alfresco.client.services.governance.core.model.representation.RecordFolderRepresentation;
import org.alfresco.client.services.governance.core.model.representation.RecordRepresentation;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface RecordFoldersAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // GET
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a record folder Get information for record folder **recordFolderId**
     * Besides mandatory fields the record folder&#39;s aspects and properties
     * are returned by default.
     * 
     * @param recordFolderId The identifier of a record folder. (required)
     * @return RecordRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}")
    Call<RecordFolderRepresentation> getRecordFolderCall(@Path(RECORD_FOLDER_ID) String recordFolderId);

    /**
     * Get a record folder Get information for record folder **recordFolderId**
     * Besides mandatory fields the record folder&#39;s aspects and properties
     * are returned by default.
     * 
     * @param recordFolderId The identifier of a record folder. (required)
     * @param include Returns additional information about the record folders.
     *            Any optional field from the response model can be requested.
     *            For example: * properties * aspectNames * isClosed *
     *            allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}")
    Call<RecordFolderRepresentation> getRecordFolderCall(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Query(INCLUDE) IncludeParam include, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update a record folder Updates record folder **recordFolderId**. For
     * example, you can rename a record folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My new name\&quot; } &#x60;&#x60;&#x60; You can
     * also set or update one or more properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;rma:vitalRecordIndicator\&quot;: true,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|6\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** if you want to add or remove aspects, then
     * you must use **GET /record-folders/{recordFolderId}** first to get the
     * complete set of *aspectNames*. **Note:** Currently there is no optimistic
     * locking for updates, so they are applied in \&quot;last one wins\&quot;
     * order.
     *
     * @param recordFolderId The identifier of a record folder. (required)
     * @param recordFolderBodyUpdate The record folder information to update.
     *            (required)
     * @return RecordFolderRepresentation
     */

    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}")
    Call<RecordFolderRepresentation> updateRecordFolderCall(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Body RMNodeBodyUpdate recordFolderBodyUpdate);

    /**
     * Update a record folder Updates record folder **recordFolderId**. For
     * example, you can rename a record folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My new name\&quot; } &#x60;&#x60;&#x60; You can
     * also set or update one or more properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;rma:vitalRecordIndicator\&quot;: true,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|6\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** if you want to add or remove aspects, then
     * you must use **GET /record-folders/{recordFolderId}** first to get the
     * complete set of *aspectNames*. **Note:** Currently there is no optimistic
     * locking for updates, so they are applied in \&quot;last one wins\&quot;
     * order.
     * 
     * @param recordFolderId The identifier of a record folder. (required)
     * @param recordFolderBodyUpdate The record folder information to update.
     *            (required)
     * @param include Returns additional information about the record folders.
     *            Any optional field from the response model can be requested.
     *            For example: * properties * aspectNames * isClosed *
     *            allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordFolderRepresentation
     */

    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}")
    Call<RecordFolderRepresentation> updateRecordFolderCall(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Body RMNodeBodyUpdate recordFolderBodyUpdate, @Query(INCLUDE) IncludeParam include,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete a record folder Deletes record folder **recordFolderId**.
     * 
     * @param recordFolderId The identifier of a record folder. (required)
     */
    @DELETE(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}")
    Call<Void> deleteRecordFolderCall(@Path(RECORD_FOLDER_ID) String recordFolderId);

    // ///////////////////////////////////////////////////////////////////////////
    // LIST RECORDS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List records Returns a list of records. Minimal information for each
     * record is returned by default. You can use the **include** parameter to
     * return additional information. The list of records includes primary
     * children and secondary children, if there are any. You can use the
     * **include** parameter (include&#x3D;association) to return child
     * association details for each child, including the **assocType** and the
     * **isPrimary** flag.
     * 
     * @param recordFolderId The identifier of a record folder. (required)
     * @return RecordFolderAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Call<ResultPaging<RecordRepresentation>> listRecordFolderChildrenCall(
            @Path(RECORD_FOLDER_ID) String recordFolderId);

    /**
     * List records Returns a list of records. Minimal information for each
     * record is returned by default. You can use the **include** parameter to
     * return additional information. The list of records includes primary
     * children and secondary children, if there are any. You can use the
     * **include** parameter (include&#x3D;association) to return child
     * association details for each child, including the **assocType** and the
     * **isPrimary** flag.
     * 
     * @param recordFolderId The identifier of a record folder. (required)
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
     *            &#x60;&#x60;&#x60;where&#x3D;(nodeType&#x3D;&#39;my:
     *            specialNodeType&#39;)&#x60;&#x60;&#x60; *
     *            &#x60;&#x60;&#x60;where&#x3D;(nodeType&#x3D;&#39;my:
     *            specialNodeType INCLUDESUBTYPES&#39;)&#x60;&#x60;&#x60; *
     *            &#x60;&#x60;&#x60;where&#x3D;(isPrimary&#x3D;true)&#x60;&#x60;
     *            &#x60; (optional)
     * @param include Returns additional information about the records. Any
     *            optional field from the response model can be requested. For
     *            example: * properties * aspectNames * isCompleted *
     *            allowableOperations * path (optional)
     * @param includeSource Also include **source** in addition to **entries**
     *            with record information on the parent folder � the specified
     *            parent **recordFolderId** (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordFolderAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Call<ResultPaging<RecordRepresentation>> listRecordFolderChildrenCall(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(ORDER_BY) OrderByParam orderBy, @Query(WHERE) String where, @Query(INCLUDE) IncludeParam include,
            @Query(INCLUDE_SOURCE) Boolean includeSource, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE A RECORD
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create a record Create a record as a primary child of **recordFolderId**.
     * This endpoint supports both JSON and multipart/form-data (file upload).
     * **Using multipart/form-data** Use the **filedata** field to represent the
     * content to upload, for example, the following curl command will create a
     * node with the contents of test.txt in the test user&#39;s home folder.
     * &#x60;&#x60;&#x60;curl -utest:test -X POST
     * host:port/alfresco/api/-default-/public/gs/versions/1/record-folders/{
     * recordFolderId}/records -F filedata&#x3D;@test.txt&#x60;&#x60;&#x60; This
     * API method also supports record creation using application/json. You must
     * specify at least a **name** and **nodeType**. You can create a
     * non-electronic record like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Non-electronic Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:nonElectronicDocument\&quot;,
     * \&quot;properties\&quot;: { \&quot;cm:description\&quot;:\&quot;My
     * Non-electronic Record Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;My Non-electronic Record Title\&quot;,
     * \&quot;rma:box\&quot;:\&quot;My Non-electronic Record Box\&quot;,
     * \&quot;rma:file\&quot;:\&quot;My Non-electronic Record File\&quot;,
     * \&quot;rma:numberOfCopies\&quot;:1, \&quot;rma:physicalSize\&quot;:30,
     * \&quot;rma:shelf\&quot;:\&quot;My Non-electronic Record Shelf\&quot;,
     * \&quot;rma:storageLocation\&quot;:\&quot;My Non-electronic Record
     * Location\&quot; } } &#x60;&#x60;&#x60; You can create an empty electronic
     * record: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Electronic
     * Record\&quot;, \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record category and a record folder inside the specified **categoryId**:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;name\&quot;:\&quot;Record 1\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }, {
     * \&quot;name\&quot;:\&quot;Record 2\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; } ] &#x60;&#x60;&#x60; If
     * you specify a list as input, then a paginated list rather than an entry
     * is returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param recordFolderId The identifier of a record folder. (required)
     * @param recordBodyCreate The record information to create. This field is
     *            ignored for multipart/form-data content uploads. (required)
     * @return RecordRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Call<RecordRepresentation> createRecordFolderChildCall(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Body RMNodeBodyCreate recordBodyCreate);

    /**
     * Create a record Create a record as a primary child of **recordFolderId**.
     * This endpoint supports both JSON and multipart/form-data (file upload).
     * **Using multipart/form-data** Use the **filedata** field to represent the
     * content to upload, for example, the following curl command will create a
     * node with the contents of test.txt in the test user&#39;s home folder.
     * &#x60;&#x60;&#x60;curl -utest:test -X POST
     * host:port/alfresco/api/-default-/public/gs/versions/1/record-folders/{
     * recordFolderId}/records -F filedata&#x3D;@test.txt&#x60;&#x60;&#x60; This
     * API method also supports record creation using application/json. You must
     * specify at least a **name** and **nodeType**. You can create a
     * non-electronic record like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Non-electronic Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:nonElectronicDocument\&quot;,
     * \&quot;properties\&quot;: { \&quot;cm:description\&quot;:\&quot;My
     * Non-electronic Record Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;My Non-electronic Record Title\&quot;,
     * \&quot;rma:box\&quot;:\&quot;My Non-electronic Record Box\&quot;,
     * \&quot;rma:file\&quot;:\&quot;My Non-electronic Record File\&quot;,
     * \&quot;rma:numberOfCopies\&quot;:1, \&quot;rma:physicalSize\&quot;:30,
     * \&quot;rma:shelf\&quot;:\&quot;My Non-electronic Record Shelf\&quot;,
     * \&quot;rma:storageLocation\&quot;:\&quot;My Non-electronic Record
     * Location\&quot; } } &#x60;&#x60;&#x60; You can create an empty electronic
     * record: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Electronic
     * Record\&quot;, \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record category and a record folder inside the specified **categoryId**:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;name\&quot;:\&quot;Record 1\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }, {
     * \&quot;name\&quot;:\&quot;Record 2\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; } ] &#x60;&#x60;&#x60; If
     * you specify a list as input, then a paginated list rather than an entry
     * is returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     * 
     * @param recordFolderId The identifier of a record folder. (required)
     * @param recordBodyCreate The record information to create. This field is
     *            ignored for multipart/form-data content uploads. (required)
     * @param include Returns additional information about the records. Any
     *            optional field from the response model can be requested. For
     *            example: * properties * aspectNames * isCompleted *
     *            allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Call<RecordRepresentation> createRecordFolderChildCall(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Body RMNodeBodyCreate recordBodyCreate, @Query(INCLUDE) IncludeParam include,
            @Query(FIELDS) FieldsParam fields);

    /**
     * Create a record Create a record as a primary child of **recordFolderId**.
     * This endpoint supports both JSON and multipart/form-data (file upload).
     * **Using multipart/form-data** Use the **filedata** field to represent the
     * content to upload, for example, the following curl command will create a
     * node with the contents of test.txt in the test user&#39;s home folder.
     * &#x60;&#x60;&#x60;curl -utest:test -X POST
     * host:port/alfresco/api/-default-/public/gs/versions/1/record-folders/{
     * recordFolderId}/records -F filedata&#x3D;@test.txt&#x60;&#x60;&#x60; This
     * API method also supports record creation using application/json. You must
     * specify at least a **name** and **nodeType**. You can create a
     * non-electronic record like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Non-electronic Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:nonElectronicDocument\&quot;,
     * \&quot;properties\&quot;: { \&quot;cm:description\&quot;:\&quot;My
     * Non-electronic Record Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;My Non-electronic Record Title\&quot;,
     * \&quot;rma:box\&quot;:\&quot;My Non-electronic Record Box\&quot;,
     * \&quot;rma:file\&quot;:\&quot;My Non-electronic Record File\&quot;,
     * \&quot;rma:numberOfCopies\&quot;:1, \&quot;rma:physicalSize\&quot;:30,
     * \&quot;rma:shelf\&quot;:\&quot;My Non-electronic Record Shelf\&quot;,
     * \&quot;rma:storageLocation\&quot;:\&quot;My Non-electronic Record
     * Location\&quot; } } &#x60;&#x60;&#x60; You can create an empty electronic
     * record: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Electronic
     * Record\&quot;, \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record category and a record folder inside the specified **categoryId**:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;name\&quot;:\&quot;Record 1\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }, {
     * \&quot;name\&quot;:\&quot;Record 2\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; } ] &#x60;&#x60;&#x60; If
     * you specify a list as input, then a paginated list rather than an entry
     * is returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param recordFolderId The identifier of a record folder. (required)
     * @param include Returns additional information about the records. Any
     *            optional field from the response model can be requested. For
     *            example: * properties * aspectNames * isCompleted *
     *            allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordRepresentation
     */
    @Multipart
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Call<RecordRepresentation> createRecordFolderChildCall(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Part(FILEDATA) RequestBody file, @Query(INCLUDE) IncludeParam include, @Query(FIELDS) FieldsParam fields);

    @Multipart
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Call<RecordRepresentation> createRecordFolderChildCall(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @PartMap() Map<String, RequestBody> partMap);

    @Multipart
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Call<RecordRepresentation> createRecordFolderChildCall(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @PartMap() Map<String, RequestBody> partMap, @Query(INCLUDE) IncludeParam include,
            @Query(FIELDS) FieldsParam fields);

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
     * Get a record folder Get information for record folder **recordFolderId**
     * Besides mandatory fields the record folder&#39;s aspects and properties
     * are returned by default.
     *
     * @param recordFolderId The identifier of a record folder. (required)
     * @return RecordRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}")
    Observable<RecordFolderRepresentation> getRecordFolderObservable(@Path(RECORD_FOLDER_ID) String recordFolderId);

    /**
     * Get a record folder Get information for record folder **recordFolderId**
     * Besides mandatory fields the record folder&#39;s aspects and properties
     * are returned by default.
     *
     * @param recordFolderId The identifier of a record folder. (required)
     * @param include Returns additional information about the record folders.
     *            Any optional field from the response model can be requested.
     *            For example: * properties * aspectNames * isClosed *
     *            allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}")
    Observable<RecordFolderRepresentation> getRecordFolderObservable(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Query(INCLUDE) IncludeParam include, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update a record folder Updates record folder **recordFolderId**. For
     * example, you can rename a record folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My new name\&quot; } &#x60;&#x60;&#x60; You can
     * also set or update one or more properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;rma:vitalRecordIndicator\&quot;: true,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|6\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** if you want to add or remove aspects, then
     * you must use **GET /record-folders/{recordFolderId}** first to get the
     * complete set of *aspectNames*. **Note:** Currently there is no optimistic
     * locking for updates, so they are applied in \&quot;last one wins\&quot;
     * order.
     *
     * @param recordFolderId The identifier of a record folder. (required)
     * @param recordFolderBodyUpdate The record folder information to update.
     *            (required)
     * @return RecordFolderRepresentation
     */

    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}")
    Observable<RecordFolderRepresentation> updateRecordFolderObservable(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Body RMNodeBodyUpdate recordFolderBodyUpdate);

    /**
     * Update a record folder Updates record folder **recordFolderId**. For
     * example, you can rename a record folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My new name\&quot; } &#x60;&#x60;&#x60; You can
     * also set or update one or more properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;rma:vitalRecordIndicator\&quot;: true,
     * \&quot;rma:reviewPeriod\&quot;:\&quot;month|6\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** if you want to add or remove aspects, then
     * you must use **GET /record-folders/{recordFolderId}** first to get the
     * complete set of *aspectNames*. **Note:** Currently there is no optimistic
     * locking for updates, so they are applied in \&quot;last one wins\&quot;
     * order.
     *
     * @param recordFolderId The identifier of a record folder. (required)
     * @param recordFolderBodyUpdate The record folder information to update.
     *            (required)
     * @param include Returns additional information about the record folders.
     *            Any optional field from the response model can be requested.
     *            For example: * properties * aspectNames * isClosed *
     *            allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordFolderRepresentation
     */

    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}")
    Observable<RecordFolderRepresentation> updateRecordFolderObservable(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Body RMNodeBodyUpdate recordFolderBodyUpdate, @Query(INCLUDE) IncludeParam include,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete a record folder Deletes record folder **recordFolderId**.
     *
     * @param recordFolderId The identifier of a record folder. (required)
     */
    @DELETE(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}")
    Observable<Void> deleteRecordFolderObservable(@Path(RECORD_FOLDER_ID) String recordFolderId);

    // ///////////////////////////////////////////////////////////////////////////
    // LIST RECORDS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List records Returns a list of records. Minimal information for each
     * record is returned by default. You can use the **include** parameter to
     * return additional information. The list of records includes primary
     * children and secondary children, if there are any. You can use the
     * **include** parameter (include&#x3D;association) to return child
     * association details for each child, including the **assocType** and the
     * **isPrimary** flag.
     *
     * @param recordFolderId The identifier of a record folder. (required)
     * @return RecordFolderAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Observable<ResultPaging<RecordRepresentation>> listRecordFolderChildrenObservable(
            @Path(RECORD_FOLDER_ID) String recordFolderId);

    /**
     * List records Returns a list of records. Minimal information for each
     * record is returned by default. You can use the **include** parameter to
     * return additional information. The list of records includes primary
     * children and secondary children, if there are any. You can use the
     * **include** parameter (include&#x3D;association) to return child
     * association details for each child, including the **assocType** and the
     * **isPrimary** flag.
     *
     * @param recordFolderId The identifier of a record folder. (required)
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
     *            &#x60;&#x60;&#x60;where&#x3D;(nodeType&#x3D;&#39;my:
     *            specialNodeType&#39;)&#x60;&#x60;&#x60; *
     *            &#x60;&#x60;&#x60;where&#x3D;(nodeType&#x3D;&#39;my:
     *            specialNodeType INCLUDESUBTYPES&#39;)&#x60;&#x60;&#x60; *
     *            &#x60;&#x60;&#x60;where&#x3D;(isPrimary&#x3D;true)&#x60;&#x60;
     *            &#x60; (optional)
     * @param include Returns additional information about the records. Any
     *            optional field from the response model can be requested. For
     *            example: * properties * aspectNames * isCompleted *
     *            allowableOperations * path (optional)
     * @param includeSource Also include **source** in addition to **entries**
     *            with record information on the parent folder � the specified
     *            parent **recordFolderId** (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordFolderAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Observable<ResultPaging<RecordRepresentation>> listRecordFolderChildrenObservable(
            @Path(RECORD_FOLDER_ID) String recordFolderId, @Query(SKIP_COUNT) Integer skipCount,
            @Query(MAX_ITEMS) Integer maxItems, @Query(ORDER_BY) OrderByParam orderBy, @Query(WHERE) String where,
            @Query(INCLUDE) IncludeParam include, @Query(INCLUDE_SOURCE) Boolean includeSource,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE A RECORD
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create a record Create a record as a primary child of **recordFolderId**.
     * This endpoint supports both JSON and multipart/form-data (file upload).
     * **Using multipart/form-data** Use the **filedata** field to represent the
     * content to upload, for example, the following curl command will create a
     * node with the contents of test.txt in the test user&#39;s home folder.
     * &#x60;&#x60;&#x60;curl -utest:test -X POST
     * host:port/alfresco/api/-default-/public/gs/versions/1/record-folders/{
     * recordFolderId}/records -F filedata&#x3D;@test.txt&#x60;&#x60;&#x60; This
     * API method also supports record creation using application/json. You must
     * specify at least a **name** and **nodeType**. You can create a
     * non-electronic record like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Non-electronic Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:nonElectronicDocument\&quot;,
     * \&quot;properties\&quot;: { \&quot;cm:description\&quot;:\&quot;My
     * Non-electronic Record Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;My Non-electronic Record Title\&quot;,
     * \&quot;rma:box\&quot;:\&quot;My Non-electronic Record Box\&quot;,
     * \&quot;rma:file\&quot;:\&quot;My Non-electronic Record File\&quot;,
     * \&quot;rma:numberOfCopies\&quot;:1, \&quot;rma:physicalSize\&quot;:30,
     * \&quot;rma:shelf\&quot;:\&quot;My Non-electronic Record Shelf\&quot;,
     * \&quot;rma:storageLocation\&quot;:\&quot;My Non-electronic Record
     * Location\&quot; } } &#x60;&#x60;&#x60; You can create an empty electronic
     * record: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Electronic
     * Record\&quot;, \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatiObservabley.
     * You can set aspects explicitly, if needed, using an **aspectNames**
     * field. **Note:** You can create more than one child by specifying a list
     * of nodes in the JSON body. For example, the following JSON body creates a
     * record category and a record folder inside the specified **categoryId**:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;name\&quot;:\&quot;Record 1\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }, {
     * \&quot;name\&quot;:\&quot;Record 2\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; } ] &#x60;&#x60;&#x60; If
     * you specify a list as input, then a paginated list rather than an entry
     * is returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param recordFolderId The identifier of a record folder. (required)
     * @param recordBodyCreate The record information to create. This field is
     *            ignored for multipart/form-data content uploads. (required)
     * @return RecordRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Observable<RecordRepresentation> createRecordFolderChildObservable(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Body RMNodeBodyCreate recordBodyCreate);

    /**
     * Create a record Create a record as a primary child of **recordFolderId**.
     * This endpoint supports both JSON and multipart/form-data (file upload).
     * **Using multipart/form-data** Use the **filedata** field to represent the
     * content to upload, for example, the following curl command will create a
     * node with the contents of test.txt in the test user&#39;s home folder.
     * &#x60;&#x60;&#x60;curl -utest:test -X POST
     * host:port/alfresco/api/-default-/public/gs/versions/1/record-folders/{
     * recordFolderId}/records -F filedata&#x3D;@test.txt&#x60;&#x60;&#x60; This
     * API method also supports record creation using application/json. You must
     * specify at least a **name** and **nodeType**. You can create a
     * non-electronic record like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Non-electronic Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:nonElectronicDocument\&quot;,
     * \&quot;properties\&quot;: { \&quot;cm:description\&quot;:\&quot;My
     * Non-electronic Record Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;My Non-electronic Record Title\&quot;,
     * \&quot;rma:box\&quot;:\&quot;My Non-electronic Record Box\&quot;,
     * \&quot;rma:file\&quot;:\&quot;My Non-electronic Record File\&quot;,
     * \&quot;rma:numberOfCopies\&quot;:1, \&quot;rma:physicalSize\&quot;:30,
     * \&quot;rma:shelf\&quot;:\&quot;My Non-electronic Record Shelf\&quot;,
     * \&quot;rma:storageLocation\&quot;:\&quot;My Non-electronic Record
     * Location\&quot; } } &#x60;&#x60;&#x60; You can create an empty electronic
     * record: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Electronic
     * Record\&quot;, \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record category and a record folder inside the specified **categoryId**:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;name\&quot;:\&quot;Record 1\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }, {
     * \&quot;name\&quot;:\&quot;Record 2\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; } ] &#x60;&#x60;&#x60; If
     * you specify a list as input, then a paginated list rather than an entry
     * is returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param recordFolderId The identifier of a record folder. (required)
     * @param recordBodyCreate The record information to create. This field is
     *            ignored for multipart/form-data content uploads. (required)
     * @param include Returns additional information about the records. Any
     *            optional field from the response model can be requested. For
     *            example: * properties * aspectNames * isCompleted *
     *            allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Observable<RecordRepresentation> createRecordFolderChildObservable(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Body RMNodeBodyCreate recordBodyCreate, @Query(INCLUDE) IncludeParam include,
            @Query(FIELDS) FieldsParam fields);

    /**
     * Create a record Create a record as a primary child of **recordFolderId**.
     * This endpoint supports both JSON and multipart/form-data (file upload).
     * **Using multipart/form-data** Use the **filedata** field to represent the
     * content to upload, for example, the following curl command will create a
     * node with the contents of test.txt in the test user&#39;s home folder.
     * &#x60;&#x60;&#x60;curl -utest:test -X POST
     * host:port/alfresco/api/-default-/public/gs/versions/1/record-folders/{
     * recordFolderId}/records -F filedata&#x3D;@test.txt&#x60;&#x60;&#x60; This
     * API method also supports record creation using application/json. You must
     * specify at least a **name** and **nodeType**. You can create a
     * non-electronic record like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Non-electronic Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:nonElectronicDocument\&quot;,
     * \&quot;properties\&quot;: { \&quot;cm:description\&quot;:\&quot;My
     * Non-electronic Record Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;My Non-electronic Record Title\&quot;,
     * \&quot;rma:box\&quot;:\&quot;My Non-electronic Record Box\&quot;,
     * \&quot;rma:file\&quot;:\&quot;My Non-electronic Record File\&quot;,
     * \&quot;rma:numberOfCopies\&quot;:1, \&quot;rma:physicalSize\&quot;:30,
     * \&quot;rma:shelf\&quot;:\&quot;My Non-electronic Record Shelf\&quot;,
     * \&quot;rma:storageLocation\&quot;:\&quot;My Non-electronic Record
     * Location\&quot; } } &#x60;&#x60;&#x60; You can create an empty electronic
     * record: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Electronic
     * Record\&quot;, \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record category and a record folder inside the specified **categoryId**:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;name\&quot;:\&quot;Record 1\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }, {
     * \&quot;name\&quot;:\&quot;Record 2\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; } ] &#x60;&#x60;&#x60; If
     * you specify a list as input, then a paginated list rather than an entry
     * is returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param recordFolderId The identifier of a record folder. (required)
     * @param include Returns additional information about the records. Any
     *            optional field from the response model can be requested. For
     *            example: * properties * aspectNames * isCompleted *
     *            allowableOperations * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordRepresentation
     */
    @Multipart
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Observable<RecordRepresentation> createRecordFolderChildObservable(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @Part(FILEDATA) RequestBody file, @Query(INCLUDE) IncludeParam include, @Query(FIELDS) FieldsParam fields);

    @Multipart
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Observable<RecordRepresentation> createRecordFolderChildObservable(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @PartMap() Map<String, RequestBody> partMap);

    @Multipart
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/record-folders/{recordFolderId}/records")
    Observable<RecordRepresentation> createRecordFolderChildObservable(@Path(RECORD_FOLDER_ID) String recordFolderId,
            @PartMap() Map<String, RequestBody> partMap, @Query(INCLUDE) IncludeParam include,
            @Query(FIELDS) FieldsParam fields);
}
