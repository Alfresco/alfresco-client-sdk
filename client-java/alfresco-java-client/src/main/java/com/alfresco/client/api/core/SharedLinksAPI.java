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
import com.alfresco.client.api.core.model.body.SharedLinkBodyCreate;
import com.alfresco.client.api.core.model.body.SharedLinkBodyEmail;
import com.alfresco.client.api.core.model.parameters.FieldsParam;
import com.alfresco.client.api.core.model.parameters.IncludeParam;
import com.alfresco.client.api.core.model.representation.RenditionRepresentation;
import com.alfresco.client.api.core.model.representation.SharedLinkRepresentation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface SharedLinksAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Find shared links Find (search for) links that current user has read
     * permission on source node.
     * 
     * @return ResultPaging<SharedLinkRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links")
    Call<ResultPaging<SharedLinkRepresentation>> listSharedLinksCall();

    /**
     * Find shared links Find (search for) links that current user has read
     * permission on source node.
     *
     * @return ResultPaging<SharedLinkRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links")
    Observable<ResultPaging<SharedLinkRepresentation>> listSharedLinksObservable();

    /**
     * Find shared links Find (search for) links that current user has read
     * permission on source node.
     * 
     * @param where Optionally filter the list by \&quot;sharedByUser\&quot;
     *            userid of person who shared the link (can also use -me-) *
     *            where&#x3D;(sharedByUser&#x3D;&#39;jbloggs&#39;) *
     *            where&#x3D;(sharedByUser&#x3D;&#39;-me-&#39;) (optional)
     * @param include Returns additional information about the shared link, the
     *            following optional fields can be requested: *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return ResultPaging<SharedLinkRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links")
    Call<ResultPaging<SharedLinkRepresentation>> listSharedLinksCall(@Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Find shared links Find (search for) links that current user has read
     * permission on source node.
     *
     * @param where Optionally filter the list by \&quot;sharedByUser\&quot;
     *            userid of person who shared the link (can also use -me-) *
     *            where&#x3D;(sharedByUser&#x3D;&#39;jbloggs&#39;) *
     *            where&#x3D;(sharedByUser&#x3D;&#39;-me-&#39;) (optional)
     * @param include Returns additional information about the shared link, the
     *            following optional fields can be requested: *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return ResultPaging<SharedLinkRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links")
    Observable<ResultPaging<SharedLinkRepresentation>> listSharedLinksObservable(
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // INFO
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a shared link Returns minimal information for the file with shared
     * link identifier **sharedId**. **Note:** No authentication is required to
     * call this endpoint.
     * 
     * @param sharedId The identifier of a shared link to a file. (required)
     * @return SharedLinkRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}")
    Call<SharedLinkRepresentation> getSharedLinkCall(@Path("sharedId") String sharedId);

    /**
     * Get a shared link Returns minimal information for the file with shared
     * link identifier **sharedId**. **Note:** No authentication is required to
     * call this endpoint.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     * @return SharedLinkRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}")
    Observable<SharedLinkRepresentation> getSharedLinkObservable(@Path("sharedId") String sharedId);

    /**
     * Get a shared link Returns minimal information for the file with shared
     * link identifier **sharedId**. **Note:** No authentication is required to
     * call this endpoint.
     * 
     * @param sharedId The identifier of a shared link to a file. (required)
     * @param include Returns additional information about the shared link, the
     *            following optional fields can be requested: *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SharedLinkRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}")
    Call<SharedLinkRepresentation> getSharedLinkCall(@Path("sharedId") String sharedId,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Get a shared link Returns minimal information for the file with shared
     * link identifier **sharedId**. **Note:** No authentication is required to
     * call this endpoint.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     * @param include Returns additional information about the shared link, the
     *            following optional fields can be requested: *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SharedLinkRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}")
    Observable<SharedLinkRepresentation> getSharedLinkObservable(@Path("sharedId") String sharedId,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Get file content Returns the content of the file with shared link
     * identifier **sharedId**. **Note:** No authentication is required to call
     * this endpoint.
     * 
     * @param sharedId The identifier of a shared link to a file. (required)
     */
    @Streaming
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/content")
    Call<ResponseBody> getSharedLinkContentCall(@Path("sharedId") String sharedId);

    /**
     * Get file content Returns the content of the file with shared link
     * identifier **sharedId**. **Note:** No authentication is required to call
     * this endpoint.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     */
    @Streaming
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/content")
    Observable<ResponseBody> getSharedLinkContentObservable(@Path("sharedId") String sharedId);

    /**
     * Get file content Returns the content of the file with shared link
     * identifier **sharedId**. **Note:** No authentication is required to call
     * this endpoint.
     * 
     * @param sharedId The identifier of a shared link to a file. (required)
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
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/content")
    Call<ResponseBody> getSharedLinkContentCall(@Path("sharedId") String sharedId,
            @Query("attachment") Boolean attachment, @Header("If-Modified-Since") Date ifModifiedSince);

    /**
     * Get file content Returns the content of the file with shared link
     * identifier **sharedId**. **Note:** No authentication is required to call
     * this endpoint.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
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
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/content")
    Observable<ResponseBody> getSharedLinkContentObservable(@Path("sharedId") String sharedId,
            @Query("attachment") Boolean attachment, @Header("If-Modified-Since") Date ifModifiedSince);

    /**
     * Email shared link Sends email with app-specific url including identifier
     * **sharedId**. The client and recipientEmails properties are mandatory in
     * the body body. For example, to email a shared link with minimum info:
     * &#x60;&#x60;&#x60;JSON { \&quot;client\&quot;: \&quot;myClient\&quot;,
     * \&quot;recipientEmails\&quot;: [\&quot;john.doe@acme.com\&quot;,
     * joe.bloggs@acme.com] } &#x60;&#x60;&#x60; A plain text message property
     * can be optionally provided in the body body to customise the sent email.
     * Also, a locale property can be optionally provided in the body body to
     * send the emails in a particular language. For example, to email a shared
     * link with a messages and a locale: &#x60;&#x60;&#x60;JSON {
     * \&quot;client\&quot;: \&quot;myClient\&quot;,
     * \&quot;recipientEmails\&quot;: [\&quot;john.doe@acme.com\&quot;,
     * joe.bloggs@acme.com], \&quot;message\&quot;: \&quot;myMessage\&quot;,
     * \&quot;locale\&quot;:\&quot;en-GB\&quot; } &#x60;&#x60;&#x60; **Note:**
     * The client must be registered before you can send a shared link email.
     * See [server documentation]
     * 
     * @param sharedId The identifier of a shared link to a file. (required)
     * @param emailSharedLinkBody The shared link email to send. (required)
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/email")
    Call<Void> emailSharedLinkCall(@Path("sharedId") String sharedId, @Body SharedLinkBodyEmail emailSharedLinkBody);

    /**
     * Email shared link Sends email with app-specific url including identifier
     * **sharedId**. The client and recipientEmails properties are mandatory in
     * the body body. For example, to email a shared link with minimum info:
     * &#x60;&#x60;&#x60;JSON { \&quot;client\&quot;: \&quot;myClient\&quot;,
     * \&quot;recipientEmails\&quot;: [\&quot;john.doe@acme.com\&quot;,
     * joe.bloggs@acme.com] } &#x60;&#x60;&#x60; A plain text message property
     * can be optionally provided in the body body to customise the sent email.
     * Also, a locale property can be optionally provided in the body body to
     * send the emails in a particular language. For example, to email a shared
     * link with a messages and a locale: &#x60;&#x60;&#x60;JSON {
     * \&quot;client\&quot;: \&quot;myClient\&quot;,
     * \&quot;recipientEmails\&quot;: [\&quot;john.doe@acme.com\&quot;,
     * joe.bloggs@acme.com], \&quot;message\&quot;: \&quot;myMessage\&quot;,
     * \&quot;locale\&quot;:\&quot;en-GB\&quot; } &#x60;&#x60;&#x60; **Note:**
     * The client must be registered before you can send a shared link email.
     * See [server documentation]
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     * @param emailSharedLinkBody The shared link email to send. (required)
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/email")
    Observable<Void> emailSharedLinkObservable(@Path("sharedId") String sharedId,
            @Body SharedLinkBodyEmail emailSharedLinkBody);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create a shared link to a file Create a shared link to the file
     * **nodeId** in the body body. **Note:** You can create shared links to
     * more than one file specifying a list of **nodeId**s in the JSON body like
     * this: &#x60;&#x60;&#x60;JSON [ { \&quot;nodeId\&quot;:
     * \&quot;1ff9da1a-ee2f-4b9c-8c34-4444444444\&quot; }, {
     * \&quot;nodeId\&quot;: \&quot;1ff9da1a-ee2f-4b9c-8c34-5555555555\&quot; }
     * ] &#x60;&#x60;&#x60; If you specify a list as input, then a paginated
     * list rather than an entry is returned in the response body. For example:
     * &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: { \&quot;pagination\&quot;:
     * { \&quot;count\&quot;: 2, \&quot;hasMoreItems\&quot;: false,
     * \&quot;totalItems\&quot;: 2, \&quot;skipCount\&quot;: 0,
     * \&quot;maxItems\&quot;: 100 }, \&quot;entries\&quot;: [ {
     * \&quot;entry\&quot;: { ... } }, { \&quot;entry\&quot;: { ... } } ] } }
     * &#x60;&#x60;&#x60;
     * 
     * @param sharedLinkBody The nodeId to create a shared link for. (required)
     * @return SharedLinkRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links")
    Call<SharedLinkRepresentation> createSharedLinkCall(@Body SharedLinkBodyCreate sharedLinkBody);

    /**
     * Create a shared link to a file Create a shared link to the file
     * **nodeId** in the body body. **Note:** You can create shared links to
     * more than one file specifying a list of **nodeId**s in the JSON body like
     * this: &#x60;&#x60;&#x60;JSON [ { \&quot;nodeId\&quot;:
     * \&quot;1ff9da1a-ee2f-4b9c-8c34-4444444444\&quot; }, {
     * \&quot;nodeId\&quot;: \&quot;1ff9da1a-ee2f-4b9c-8c34-5555555555\&quot; }
     * ] &#x60;&#x60;&#x60; If you specify a list as input, then a paginated
     * list rather than an entry is returned in the response body. For example:
     * &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: { \&quot;pagination\&quot;:
     * { \&quot;count\&quot;: 2, \&quot;hasMoreItems\&quot;: false,
     * \&quot;totalItems\&quot;: 2, \&quot;skipCount\&quot;: 0,
     * \&quot;maxItems\&quot;: 100 }, \&quot;entries\&quot;: [ {
     * \&quot;entry\&quot;: { ... } }, { \&quot;entry\&quot;: { ... } } ] } }
     * &#x60;&#x60;&#x60;
     *
     * @param sharedLinkBody The nodeId to create a shared link for. (required)
     * @return SharedLinkRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links")
    Observable<SharedLinkRepresentation> createSharedLinkObservable(@Body SharedLinkBodyCreate sharedLinkBody);

    /**
     * Create a shared link to a file Create a shared link to the file
     * **nodeId** in the body body. **Note:** You can create shared links to
     * more than one file specifying a list of **nodeId**s in the JSON body like
     * this: &#x60;&#x60;&#x60;JSON [ { \&quot;nodeId":
     * \&quot;1ff9da1a-ee2f-4b9c-8c34-4444444444\&quot; }, {
     * \&quot;nodeId\&quot;: \&quot;1ff9da1a-ee2f-4b9c-8c34-5555555555\&quot; }
     * ] &#x60;&#x60;&#x60; If you specify a list as input, then a paginated
     * list rather than an entry is returned in the response body. For example:
     * &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: { \&quot;pagination\&quot;:
     * { \&quot;count\&quot;: 2, \&quot;hasMoreItems\&quot;: false,
     * \&quot;totalItems\&quot;: 2, \&quot;skipCount\&quot;: 0,
     * \&quot;maxItems\&quot;: 100 }, \&quot;entries\&quot;: [ {
     * \&quot;entry\&quot;: { ... } }, { \&quot;entry\&quot;: { ... } } ] } }
     * &#x60;&#x60;&#x60;
     * 
     * @param sharedLinkBody The nodeId to create a shared link for. (required)
     * @param include Returns additional information about the shared link, the
     *            following optional fields can be requested: *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SharedLinkRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links")
    Call<SharedLinkRepresentation> createSharedLinkCall(@Body SharedLinkBodyCreate sharedLinkBody,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Create a shared link to a file Create a shared link to the file
     * **nodeId** in the body body. **Note:** You can create shared links to
     * more than one file specifying a list of **nodeId**s in the JSON body like
     * this: &#x60;&#x60;&#x60;JSON [ { \&quot;nodeId":
     * \&quot;1ff9da1a-ee2f-4b9c-8c34-4444444444\&quot; }, {
     * \&quot;nodeId\&quot;: \&quot;1ff9da1a-ee2f-4b9c-8c34-5555555555\&quot; }
     * ] &#x60;&#x60;&#x60; If you specify a list as input, then a paginated
     * list rather than an entry is returned in the response body. For example:
     * &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: { \&quot;pagination\&quot;:
     * { \&quot;count\&quot;: 2, \&quot;hasMoreItems\&quot;: false,
     * \&quot;totalItems\&quot;: 2, \&quot;skipCount\&quot;: 0,
     * \&quot;maxItems\&quot;: 100 }, \&quot;entries\&quot;: [ {
     * \&quot;entry\&quot;: { ... } }, { \&quot;entry\&quot;: { ... } } ] } }
     * &#x60;&#x60;&#x60;
     *
     * @param sharedLinkBody The nodeId to create a shared link for. (required)
     * @param include Returns additional information about the shared link, the
     *            following optional fields can be requested: *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return SharedLinkRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links")
    Observable<SharedLinkRepresentation> createSharedLinkObservable(@Body SharedLinkBodyCreate sharedLinkBody,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Deletes a shared link Deletes the shared link with identifier
     * **sharedId**.
     * 
     * @param sharedId The identifier of a shared link to a file. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}")
    Call<Void> deleteSharedLinkCall(@Path("sharedId") String sharedId);

    /**
     * Deletes a shared link Deletes the shared link with identifier
     * **sharedId**.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}")
    Observable<Void> deleteSharedLinkObservable(@Path("sharedId") String sharedId);

    // ///////////////////////////////////////////////////////////////////////////
    // Shared Links Rendition
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List information for created renditions Returns the rendition information
     * for the file with shared link identifier **sharedId**. This will only
     * return rendition information, including the rendition id, for each
     * rendition where the rendition status is CREATED (ie. available to
     * view/download). **Note:** No authentication is required to call this
     * endpoint.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     * @return RenditionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/renditions")
    Call<RenditionRepresentation> listSharedLinkRenditionsCall(@Path("sharedId") String sharedId);

    /**
     * List information for created renditions Returns the rendition information
     * for the file with shared link identifier **sharedId**. This will only
     * return rendition information, including the rendition id, for each
     * rendition where the rendition status is CREATED (ie. available to
     * view/download). **Note:** No authentication is required to call this
     * endpoint.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     * @return RenditionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/renditions")
    Observable<RenditionRepresentation> listSharedLinkRenditionsObservable(@Path("sharedId") String sharedId);

    /**
     * Gets rendition information for the file with shared link identifier
     * **sharedId**. This API method returns rendition information where the
     * rendition status is CREATED, which means the rendition is available to
     * view/download. **Note:** No authentication is required to call this
     * endpoint.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     * @param renditionId The name of a thumbnail rendition, for example
     *            *doclib*, or *pdf*. (required)
     * @return RenditionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/renditions/{renditionId}")
    Call<RenditionRepresentation> getSharedLinkRenditionCall(@Path("sharedId") String sharedId,
            @Path("renditionId") String renditionId);

    /**
     * Gets rendition information for the file with shared link identifier
     * **sharedId**. This API method returns rendition information where the
     * rendition status is CREATED, which means the rendition is available to
     * view/download. **Note:** No authentication is required to call this
     * endpoint.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     * @param renditionId The name of a thumbnail rendition, for example
     *            *doclib*, or *pdf*. (required)
     * @return RenditionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/renditions/{renditionId}")
    Observable<RenditionRepresentation> getSharedLinkRenditionObservable(@Path("sharedId") String sharedId,
            @Path("renditionId") String renditionId);

    /**
     * Get shared link rendition content Returns the rendition content for file
     * with shared link identifier **sharedId**. **Note:** No authentication is
     * required to call this endpoint.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     * @param renditionId The name of a thumbnail rendition, for example
     *            *doclib*, or *pdf*. (required)
     */
    @Streaming
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/renditions/{renditionId}/content")
    Call<ResponseBody> getSharedLinkRenditionContentCall(@Path("sharedId") String sharedId,
            @Path("renditionId") String renditionId);

    /**
     * Get shared link rendition content Returns the rendition content for file
     * with shared link identifier **sharedId**. **Note:** No authentication is
     * required to call this endpoint.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     * @param renditionId The name of a thumbnail rendition, for example
     *            *doclib*, or *pdf*. (required)
     */
    @Streaming
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/renditions/{renditionId}/content")
    Observable<ResponseBody> getSharedLinkRenditionContentObservable(@Path("sharedId") String sharedId,
            @Path("renditionId") String renditionId);

    /**
     * Get shared link rendition content Returns the rendition content for file
     * with shared link identifier **sharedId**. **Note:** No authentication is
     * required to call this endpoint.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     * @param renditionId The name of a thumbnail rendition, for example
     *            *doclib*, or *pdf*. (required)
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
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/renditions/{renditionId}/content")
    Call<ResponseBody> getSharedLinkRenditionContentCall(@Path("sharedId") String sharedId,
            @Path("renditionId") String renditionId, @Query("attachment") Boolean attachment,
            @Header("If-Modified-Since") Date ifModifiedSince);

    /**
     * Get shared link rendition content Returns the rendition content for file
     * with shared link identifier **sharedId**. **Note:** No authentication is
     * required to call this endpoint.
     *
     * @param sharedId The identifier of a shared link to a file. (required)
     * @param renditionId The name of a thumbnail rendition, for example
     *            *doclib*, or *pdf*. (required)
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
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/shared-links/{sharedId}/renditions/{renditionId}/content")
    Observable<ResponseBody> getSharedLinkRenditionContentObservable(@Path("sharedId") String sharedId,
            @Path("renditionId") String renditionId, @Query("attachment") Boolean attachment,
            @Header("If-Modified-Since") Date ifModifiedSince);

}
