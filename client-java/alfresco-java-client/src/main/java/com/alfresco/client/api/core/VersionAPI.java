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

package com.alfresco.client.api.core;

import java.util.Date;

import com.alfresco.client.api.common.constant.PublicAPIConstant;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.model.body.RevertBody;
import com.alfresco.client.api.core.model.parameters.FieldsParam;
import com.alfresco.client.api.core.model.parameters.IncludeParam;
import com.alfresco.client.api.core.model.representation.VersionRepresentation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface VersionAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List version history **Note:** this endpoint is available in Alfresco 5.2
     * and newer versions. Gets the version history as an ordered list of
     * versions for the specified **nodeId**. The list is ordered in descending
     * modified order. So the most recent version is first and the original
     * version is last in the list.
     * 
     * @param nodeId The identifier of a node. (required)
     * @return VersionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions")
    Call<ResultPaging<VersionRepresentation>> listVersionHistoryCall(@Path("nodeId") String nodeId);

    /**
     * List version history **Note:** this endpoint is available in Alfresco 5.2
     * and newer versions. Gets the version history as an ordered list of
     * versions for the specified **nodeId**. The list is ordered in descending
     * modified order. So the most recent version is first and the original
     * version is last in the list.
     * 
     * @param nodeId The identifier of a node. (required)
     * @return VersionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions")
    Observable<ResultPaging<VersionRepresentation>> listVersionHistoryObservable(@Path("nodeId") String nodeId);

    /**
     * List version history **Note:** this endpoint is available in Alfresco 5.2
     * and newer versions. Gets the version history as an ordered list of
     * versions for the specified **nodeId**. The list is ordered in descending
     * modified order. So the most recent version is first and the original
     * version is last in the list.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param include Returns additional information about the version node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @return VersionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions")
    Call<ResultPaging<VersionRepresentation>> listVersionHistoryCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * List version history **Note:** this endpoint is available in Alfresco 5.2
     * and newer versions. Gets the version history as an ordered list of
     * versions for the specified **nodeId**. The list is ordered in descending
     * modified order. So the most recent version is first and the original
     * version is last in the list.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param include Returns additional information about the version node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @return VersionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions")
    Observable<ResultPaging<VersionRepresentation>> listVersionHistoryObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // GET INFO
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List version history **Note:** this endpoint is available in Alfresco 5.2
     * and newer versions. Gets the version history as an ordered list of
     * versions for the specified **nodeId**. The list is ordered in descending
     * modified order. So the most recent version is first and the original
     * version is last in the list.
     * 
     * @param nodeId The identifier of a node. (required)
     * @return VersionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}")
    Call<ResultPaging<VersionRepresentation>> getVersionCall(@Path("nodeId") String nodeId,
            @Path("versionId") String versionId);

    /**
     * List version history **Note:** this endpoint is available in Alfresco 5.2
     * and newer versions. Gets the version history as an ordered list of
     * versions for the specified **nodeId**. The list is ordered in descending
     * modified order. So the most recent version is first and the original
     * version is last in the list.
     *
     * @param nodeId The identifier of a node. (required)
     * @return VersionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}")
    Observable<ResultPaging<VersionRepresentation>> getVersionObservable(@Path("nodeId") String nodeId,
            @Path("versionId") String versionId);

    /**
     * List version history **Note:** this endpoint is available in Alfresco 5.2
     * and newer versions. Gets the version history as an ordered list of
     * versions for the specified **nodeId**. The list is ordered in descending
     * modified order. So the most recent version is first and the original
     * version is last in the list.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param include Returns additional information about the version node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @return VersionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}")
    Call<ResultPaging<VersionRepresentation>> getVersionCall(@Path("nodeId") String nodeId,
            @Path("versionId") String versionId, @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * List version history **Note:** this endpoint is available in Alfresco 5.2
     * and newer versions. Gets the version history as an ordered list of
     * versions for the specified **nodeId**. The list is ordered in descending
     * modified order. So the most recent version is first and the original
     * version is last in the list.
     *
     * @param nodeId The identifier of a node. (required)
     * @param include Returns additional information about the version node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @return VersionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}")
    Observable<ResultPaging<VersionRepresentation>> getVersionObservable(@Path("nodeId") String nodeId,
            @Path("versionId") String versionId, @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // GET CONTENT
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get version content **Note:** this endpoint is available in Alfresco 5.2
     * and newer versions. Gets the version content for **versionId** of file
     * node **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param versionId The identifier of a version, ie. version label, within
     *            the version history of a node. (required)
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}/content")
    Call<ResponseBody> getVersionContentCall(@Path("nodeId") String nodeId, @Path("versionId") String versionId);

    /**
     * Get version content **Note:** this endpoint is available in Alfresco 5.2
     * and newer versions. Gets the version content for **versionId** of file
     * node **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @param versionId The identifier of a version, ie. version label, within
     *            the version history of a node. (required)
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}/content")
    Observable<ResponseBody> getVersionContentObservable(@Path("nodeId") String nodeId,
            @Path("versionId") String versionId);

    /**
     * Get version content **Note:** this endpoint is available in Alfresco 5.2
     * and newer versions. Gets the version content for **versionId** of file
     * node **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param versionId The identifier of a version, ie. version label, within
     *            the version history of a node. (required)
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
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}/content")
    Call<ResponseBody> getVersionContentCall(@Path("nodeId") String nodeId, @Path("versionId") String versionId,
            @Query("attachment") Boolean attachment, @Header("If-Modified-Since") Date ifModifiedSince);

    /**
     * Get version content **Note:** this endpoint is available in Alfresco 5.2
     * and newer versions. Gets the version content for **versionId** of file
     * node **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @param versionId The identifier of a version, ie. version label, within
     *            the version history of a node. (required)
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
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}/content")
    Observable<ResponseBody> getVersionContentObservable(@Path("nodeId") String nodeId,
            @Path("versionId") String versionId, @Query("attachment") Boolean attachment,
            @Header("If-Modified-Since") Date ifModifiedSince);

    // ///////////////////////////////////////////////////////////////////////////
    // REVERT
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Note: this endpoint is available in Alfresco 5.2 and newer versions.
     * Attempts to revert the version identified by **versionId** and **nodeId**
     * to the live node. If the node is successfully reverted then the content
     * and metadata for that versioned node will be promoted to the live node
     * and a new version will appear in the version history.
     *
     * @param nodeId The identifier of a node. (required)
     * @param versionId The identifier of a version, ie. version label, within
     *            the version history of a node. (required)
     * @param revertBody Optionally, specify a version comment and whether this
     *            should be a major version, or not.
     */
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}/revert")
    Call<VersionRepresentation> revertVersionCall(@Path("nodeId") String nodeId, @Path("versionId") String versionId,
            @Body RevertBody revertBody);

    /**
     * Note: this endpoint is available in Alfresco 5.2 and newer versions.
     * Attempts to revert the version identified by **versionId** and **nodeId**
     * to the live node. If the node is successfully reverted then the content
     * and metadata for that versioned node will be promoted to the live node
     * and a new version will appear in the version history.
     *
     * @param nodeId The identifier of a node. (required)
     * @param versionId The identifier of a version, ie. version label, within
     *            the version history of a node. (required)
     * @param revertBody Optionally, specify a version comment and whether this
     *            should be a major version, or not.
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     */
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}/revert")
    Call<VersionRepresentation> revertVersionCall(@Path("nodeId") String nodeId, @Path("versionId") String versionId,
            @Body RevertBody revertBody, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Note: this endpoint is available in Alfresco 5.2 and newer versions.
     * Attempts to revert the version identified by **versionId** and **nodeId**
     * to the live node. If the node is successfully reverted then the content
     * and metadata for that versioned node will be promoted to the live node
     * and a new version will appear in the version history.
     *
     * @param nodeId The identifier of a node. (required)
     * @param versionId The identifier of a version, ie. version label, within
     *            the version history of a node. (required)
     * @param revertBody Optionally, specify a version comment and whether this
     *            should be a major version, or not.
     */
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}/revert")
    Observable<VersionRepresentation> revertVersionObservable(@Path("nodeId") String nodeId,
            @Path("versionId") String versionId, @Body RevertBody revertBody);

    /**
     * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
     * Attempts to revert the version identified by **versionId** and **nodeId**
     * to the live node. If the node is successfully reverted then the content
     * and metadata for that versioned node will be promoted to the live node
     * and a new version will appear in the version history.
     *
     * @param nodeId The identifier of a node. (required)
     * @param versionId The identifier of a version, ie. version label, within
     *            the version history of a node. (required)
     * @param revertBody Optionally, specify a version comment and whether this
     *            should be a major version, or not.
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     */
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}/revert")
    Observable<VersionRepresentation> revertVersionObservable(@Path("nodeId") String nodeId,
            @Path("versionId") String versionId, @Body RevertBody revertBody,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete a version **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. Delete the version identified by **versionId** and
     * **nodeId*. If the version is successfully deleted then the content and
     * metadata for that versioned node will be deleted and will no longer
     * appear in the version history. This operation cannot be undone. If the
     * most recent version is deleted the live node will revert to the next most
     * recent version. We currently do not allow the last version to be deleted.
     * If you wish to clear the history then you can remove the
     * \&quot;cm:versionable\&quot; aspect (via update node) which will also
     * disable versioning. In this case, you can re-enable versioning by adding
     * back the \&quot;cm:versionable\&quot; aspect or using the version params
     * (majorVersion and comment) on a subsequent file content update.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param versionId The identifier of a version, ie. version label, within
     *            the version history of a node. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}")
    Call<ResultPaging<VersionRepresentation>> deleteVersionCall(@Path("nodeId") String nodeId,
            @Path("versionId") String versionId);

    /**
     * Delete a version **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. Delete the version identified by **versionId** and
     * **nodeId*. If the version is successfully deleted then the content and
     * metadata for that versioned node will be deleted and will no longer
     * appear in the version history. This operation cannot be undone. If the
     * most recent version is deleted the live node will revert to the next most
     * recent version. We currently do not allow the last version to be deleted.
     * If you wish to clear the history then you can remove the
     * \&quot;cm:versionable\&quot; aspect (via update node) which will also
     * disable versioning. In this case, you can re-enable versioning by adding
     * back the \&quot;cm:versionable\&quot; aspect or using the version params
     * (majorVersion and comment) on a subsequent file content update.
     *
     * @param nodeId The identifier of a node. (required)
     * @param versionId The identifier of a version, ie. version label, within
     *            the version history of a node. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/versions/{versionId}")
    Observable<ResultPaging<VersionRepresentation>> deleteVersionObservable(@Path("nodeId") String nodeId,
            @Path("versionId") String versionId);

}
