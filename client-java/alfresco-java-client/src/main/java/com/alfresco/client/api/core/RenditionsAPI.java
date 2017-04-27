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

import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.model.body.RenditionBodyCreate;
import com.alfresco.client.api.core.model.representation.RenditionRepresentation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface RenditionsAPI
{

    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List information for renditions Returns the rendition information for the
     * file **nodeId**. This will return rendition information, including the
     * rendition id, for each rendition. The rendition status is CREATED, which
     * means it is available to view or download; or NOT_CREATED, which means
     * the rendition can be requested.
     * 
     * @param nodeId The identifier of a node. (required)
     * @return RenditionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/renditions")
    Call<ResultPaging<RenditionRepresentation>> listRenditionsCall(@Path("nodeId") String nodeId);

    /**
     * List information for renditions Returns the rendition information for the
     * file **nodeId**. This will return rendition information, including the
     * rendition id, for each rendition. The rendition status is CREATED, which
     * means it is available to view or download; or NOT_CREATED, which means
     * the rendition can be requested.
     * 
     * @param nodeId The identifier of a node. (required)
     * @return RenditionPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/renditions")
    Observable<ResultPaging<RenditionRepresentation>> listRenditionsObservable(@Path("nodeId") String nodeId);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create rendition Async body to create a rendition for file with
     * identifier **nodeId**. The rendition is specified by name
     * \&quot;id\&quot; in the body body: &#x60;&#x60;&#x60;JSON {
     * \&quot;id\&quot;:\&quot;doclib\&quot; } &#x60;&#x60;&#x60;
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param renditionBodyCreate The rendition \&quot;id\&quot;. (required)
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/renditions")
    Call<Void> createRenditionCall(@Path("nodeId") String nodeId, @Body RenditionBodyCreate renditionBodyCreate);

    /**
     * Create rendition Async body to create a rendition for file with
     * identifier **nodeId**. The rendition is specified by name
     * \&quot;id\&quot; in the body body: &#x60;&#x60;&#x60;JSON {
     * \&quot;id\&quot;:\&quot;doclib\&quot; } &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param renditionBodyCreate The rendition \&quot;id\&quot;. (required)
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/renditions")
    Observable<Void> createRenditionObservable(@Path("nodeId") String nodeId,
            @Body RenditionBodyCreate renditionBodyCreate);

    // ///////////////////////////////////////////////////////////////////////////
    // INFO
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get rendition information Returns the rendition information for file node
     * with identifier **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param renditionId The name of a thumbnail rendition, for example
     *            *doclib*, or *pdf*. (required)
     * @return RenditionRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/renditions/{renditionId}")
    Call<RenditionRepresentation> getRenditionCall(@Path("nodeId") String nodeId,
            @Path("renditionId") String renditionId);

    /**
     * Get rendition information Returns the rendition information for file node
     * with identifier **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @param renditionId The name of a thumbnail rendition, for example
     *            *doclib*, or *pdf*. (required)
     * @return RenditionRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/renditions/{renditionId}")
    Observable<RenditionRepresentation> getRenditionObservable(@Path("nodeId") String nodeId,
            @Path("renditionId") String renditionId);

    // ///////////////////////////////////////////////////////////////////////////
    // CONTENT
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get rendition content Returns the rendition content for file node with
     * identifier **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @param renditionId The name of a thumbnail rendition, for example
     *            *doclib*, or *pdf*. (required)
     */
    @Streaming
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/renditions/{renditionId}/content")
    Call<ResponseBody> getRenditionContentCall(@Path("nodeId") String nodeId, @Path("renditionId") String renditionId);

    /**
     * Get rendition content Returns the rendition content for file node with
     * identifier **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @param renditionId The name of a thumbnail rendition, for example
     *            *doclib*, or *pdf*. (required)
     */
    @Streaming
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/renditions/{renditionId}/content")
    Observable<ResponseBody> getRenditionContentObservable(@Path("nodeId") String nodeId,
            @Path("renditionId") String renditionId);

    /**
     * Get rendition content Returns the rendition content for file node with
     * identifier **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
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
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/renditions/{renditionId}/content")
    Call<ResponseBody> getRenditionContentCall(@Path("nodeId") String nodeId, @Path("renditionId") String renditionId,
            @Query("attachment") Boolean attachment, @Header("If-Modified-Since") Date ifModifiedSince);

    /**
     * Get rendition content Returns the rendition content for file node with
     * identifier **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
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
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/renditions/{renditionId}/content")
    Observable<ResponseBody> getRenditionContentObservable(@Path("nodeId") String nodeId,
            @Path("renditionId") String renditionId, @Query("attachment") Boolean attachment,
            @Header("If-Modified-Since") Date ifModifiedSince);



}