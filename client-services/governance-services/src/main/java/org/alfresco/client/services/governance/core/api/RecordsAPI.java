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

import java.util.Date;

import org.alfresco.client.services.common.constant.PublicAPIConstant;
import org.alfresco.client.services.content.core.CoreConstant;
import org.alfresco.client.services.content.core.model.parameters.FieldsParam;
import org.alfresco.client.services.content.core.model.parameters.IncludeParam;
import org.alfresco.client.services.governance.core.GovernanceConstant;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyUpdate;
import org.alfresco.client.services.governance.core.model.body.RecordBodyFile;
import org.alfresco.client.services.governance.core.model.representation.RecordRepresentation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface RecordsAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // GET
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a record Get information for record **recordId** Besides mandatory
     * fields the record&#39;s aspects and properties are returned by default.
     *
     * @param recordId The identifier of a record. (required)
     * @return RecordRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/records/{recordId}")
    Call<RecordRepresentation> getRecordCall(@Path("recordId") String recordId);

    /**
     * Get a record Get information for record **recordId** Besides mandatory
     * fields the record&#39;s aspects and properties are returned by default.
     *
     * @param recordId The identifier of a record. (required)
     * @param include Returns additional information about the record. Any
     *            optional field from the response model can be requested. For
     *            example: * isCompleted * content * allowableOperations * path
     *            (optional)
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
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/records/{recordId}")
    Call<RecordRepresentation> getRecordCall(@Path("recordId") String recordId,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // GET CONTENT
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get record content Gets the content of the record with identifier
     * **recordId**.
     *
     * @param recordId The identifier of a record. (required)
     */
    @Streaming
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/records/{recordId}/content")
    Call<ResponseBody> getRecordContentCall(@Path("recordId") String recordId);

    /**
     * Get record content Gets the content of the record with identifier
     * **recordId**.
     *
     * @param recordId The identifier of a record. (required)
     * @param attachment **true** enables a web browser to download the file as
     *            an attachment. **false** means a web browser may preview the
     *            file in a new tab or window, but not download the file. You
     *            can only set this parameter to **false** if the content type
     *            of the file is in the supported list; for example, certain
     *            image files and PDF files. If the content type is not
     *            supported for preview, then a value of **false** is ignored,
     *            and the attachment will be returned in the response.
     *            (optional, default to true)
     * @param ifModifiedSince Only returns the content if it has been modified
     *            since the date provided. Use the date format defined by HTTP.
     *            For example, &#x60;Wed, 09 Mar 2016 16:56:34 GMT&#x60;.
     *            (optional)
     */
    @Streaming
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/records/{recordId}/content")
    Call<ResponseBody> getRecordContentCall(@Path("recordId") String recordId, @Query("attachment") Boolean attachment,
            @Header("If-Modified-Since") Date ifModifiedSince);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * File a record Files the record **recordId** in the target record folder.
     * You can specify the target record folder by providing its id
     * **targetParentId** If the record is already filed, a link to the target
     * record folder is created.
     *
     * @param recordId The identifier of a record. (required)
     * @param nodeBodyFile The target record folder id (required)
     * @return RecordEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/records/{recordId}")
    Call<RecordRepresentation> fileRecordCall(@Path("recordId") String recordId, @Body RecordBodyFile nodeBodyFile);

    /**
     * File a record Files the record **recordId** in the target record folder.
     * You can specify the target record folder by providing its id
     * **targetParentId** If the record is already filed, a link to the target
     * record folder is created.
     *
     * @param recordId The identifier of a record. (required)
     * @param nodeBodyFile The target record folder id (required)
     * @param include Returns additional information about the record. Any
     *            optional field from the response model can be requested. For
     *            example: * isCompleted * content * allowableOperations * path
     *            (optional)
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
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/records/{recordId}")
    Call<RecordRepresentation> fileRecordCall(@Path("recordId") String recordId, @Body RecordBodyFile nodeBodyFile,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update record Updates the record **recordId**. For example, you can
     * rename a record: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My
     * new name\&quot; } &#x60;&#x60;&#x60; You can also set or update one or
     * more properties: &#x60;&#x60;&#x60;JSON { \&quot;properties\&quot;: {
     * \&quot;cm:title\&quot;:\&quot;New title\&quot;,
     * \&quot;cm:description\&quot;:\&quot;New description\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** if you want to add or remove aspects, then
     * you must use **GET /records/{recordId}** first to get the complete set of
     * *aspectNames*. **Note:** Currently there is no optimistic locking for
     * updates, so they are applied in \&quot;last one wins\&quot; order.
     *
     * @param recordId The identifier of a record. (required)
     * @param recordBodyUpdate The node information to update. (required)
     * @return RecordRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/records/{recordId}")
    Call<RecordRepresentation> updateRecordCall(@Path("recordId") String recordId,
            @Body RMNodeBodyUpdate recordBodyUpdate);

    /**
     * Update record Updates the record **recordId**. For example, you can
     * rename a record: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My
     * new name\&quot; } &#x60;&#x60;&#x60; You can also set or update one or
     * more properties: &#x60;&#x60;&#x60;JSON { \&quot;properties\&quot;: {
     * \&quot;cm:title\&quot;:\&quot;New title\&quot;,
     * \&quot;cm:description\&quot;:\&quot;New description\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** if you want to add or remove aspects, then
     * you must use **GET /records/{recordId}** first to get the complete set of
     * *aspectNames*. **Note:** Currently there is no optimistic locking for
     * updates, so they are applied in \&quot;last one wins\&quot; order.
     *
     * @param recordId The identifier of a record. (required)
     * @param recordBodyUpdate The node information to update. (required)
     * @param include Returns additional information about the record. Any
     *            optional field from the response model can be requested. For
     *            example: * isCompleted * content * allowableOperations * path
     *            (optional)
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
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/records/{recordId}")
    Call<RecordRepresentation> updateRecordCall(@Path("recordId") String recordId,
            @Body RMNodeBodyUpdate recordBodyUpdate, @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete a record Deletes the record **recordId**.
     *
     * @param recordId The identifier of a record. (required)
     */
    @DELETE(GovernanceConstant.GS_PUBLIC_API_V1 + "/records/{recordId}")
    Call<Void> deleteRecordCall(@Path("recordId") String recordId);

}
