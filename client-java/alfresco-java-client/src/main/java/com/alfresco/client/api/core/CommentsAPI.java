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

import java.util.List;

import com.alfresco.client.api.common.constant.PublicAPIConstant;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.model.body.CommentBody;
import com.alfresco.client.api.core.model.parameters.FieldsParam;
import com.alfresco.client.api.core.model.representation.CommentRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface CommentsAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get comments Returns a list of comments for the node identified by
     * **nodeId**, sorted chronologically with the newest comment first.
     * 
     * @param nodeId The identifier of a node. (required)
     * @return Call
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments")
    Call<ResultPaging<CommentRepresentation>> listCommentsCall(@Path("nodeId") String nodeId);

    /**
     * Get comments Returns a list of comments for the node identified by
     * **nodeId**, sorted chronologically with the newest comment first.
     * 
     * @param nodeId The identifier of a node. (required)
     * @return Call
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments")
    Observable<ResultPaging<CommentRepresentation>> listCommentsObservable(@Path("nodeId") String nodeId);

    /**
     * Get comments Returns a list of comments for the node identified by
     * **nodeId**, sorted chronologically with the newest comment first.
     * 
     * @param nodeId The identifier of a node. (required)
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
     * @return Call
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments")
    Call<ResultPaging<CommentRepresentation>> listCommentsCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Get comments Returns a list of comments for the node identified by
     * **nodeId**, sorted chronologically with the newest comment first.
     * 
     * @param nodeId The identifier of a node. (required)
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
     * @return Call
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments")
    Observable<ResultPaging<CommentRepresentation>> listCommentsObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Add a comment Creates a comment on node **nodeId**. You specify the
     * comment in a JSON body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;content\&quot;: \&quot;This is a comment\&quot; }
     * &#x60;&#x60;&#x60; **Note:** You can create more than one comment by
     * specifying a list of comments in the JSON body like this:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;content\&quot;: \&quot;This is a
     * comment\&quot; }, { \&quot;content\&quot;: \&quot;This is another
     * comment\&quot; } ] &#x60;&#x60;&#x60; If you specify a list as input,
     * then a paginated list rather than an entry is returned in the response
     * body. For example: &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: {
     * \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. (required)
     * @param commentBody The comment text. Note that you can also provide a
     *            list of comments. (required)
     * @return CommentEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments")
    Call<CommentRepresentation> createCommentCall(@Path("nodeId") String nodeId, @Body CommentBody commentBody);

    /**
     * Add a comment Creates a comment on node **nodeId**. You specify the
     * comment in a JSON body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;content\&quot;: \&quot;This is a comment\&quot; }
     * &#x60;&#x60;&#x60; **Note:** You can create more than one comment by
     * specifying a list of comments in the JSON body like this:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;content\&quot;: \&quot;This is a
     * comment\&quot; }, { \&quot;content\&quot;: \&quot;This is another
     * comment\&quot; } ] &#x60;&#x60;&#x60; If you specify a list as input,
     * then a paginated list rather than an entry is returned in the response
     * body. For example: &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: {
     * \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     * 
     * @param nodeId The identifier of a node. (required)
     * @param commentBody The comment text. Note that you can also provide a
     *            list of comments. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return CommentEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments")
    Call<CommentRepresentation> createCommentCall(@Path("nodeId") String nodeId, @Body CommentBody commentBody,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Add a comment Creates a comment on node **nodeId**. You specify the
     * comment in a JSON body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;content\&quot;: \&quot;This is a comment\&quot; }
     * &#x60;&#x60;&#x60; **Note:** You can create more than one comment by
     * specifying a list of comments in the JSON body like this:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;content\&quot;: \&quot;This is a
     * comment\&quot; }, { \&quot;content\&quot;: \&quot;This is another
     * comment\&quot; } ] &#x60;&#x60;&#x60; If you specify a list as input,
     * then a paginated list rather than an entry is returned in the response
     * body. For example: &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: {
     * \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. (required)
     * @param commentBody The comment text. Note that you can also provide a
     *            list of comments. (required)
     * @return CommentEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments")
    Observable<CommentRepresentation> createCommentObservable(@Path("nodeId") String nodeId,
            @Body CommentBody commentBody);

    /**
     * Add a comment Creates a comment on node **nodeId**. You specify the
     * comment in a JSON body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;content\&quot;: \&quot;This is a comment\&quot; }
     * &#x60;&#x60;&#x60; **Note:** You can create more than one comment by
     * specifying a list of comments in the JSON body like this:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;content\&quot;: \&quot;This is a
     * comment\&quot; }, { \&quot;content\&quot;: \&quot;This is another
     * comment\&quot; } ] &#x60;&#x60;&#x60; If you specify a list as input,
     * then a paginated list rather than an entry is returned in the response
     * body. For example: &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: {
     * \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. (required)
     * @param commentBody The comment text. Note that you can also provide a
     *            list of comments. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return CommentEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments")
    Observable<CommentRepresentation> createCommentObservable(@Path("nodeId") String nodeId,
            @Body CommentBody commentBody, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Add a comment Creates a comment on node **nodeId**. You specify the
     * comment in a JSON body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;content\&quot;: \&quot;This is a comment\&quot; }
     * &#x60;&#x60;&#x60; **Note:** You can create more than one comment by
     * specifying a list of comments in the JSON body like this:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;content\&quot;: \&quot;This is a
     * comment\&quot; }, { \&quot;content\&quot;: \&quot;This is another
     * comment\&quot; } ] &#x60;&#x60;&#x60; If you specify a list as input,
     * then a paginated list rather than an entry is returned in the response
     * body. For example: &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: {
     * \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. (required)
     * @param commentBody The comment text. Note that you can also provide a
     *            list of comments. (required)
     * @return CommentEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments")
    Call<CommentRepresentation> createCommentsCall(@Path("nodeId") String nodeId, @Body List<CommentBody> commentBody,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Add a comment Creates a comment on node **nodeId**. You specify the
     * comment in a JSON body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;content\&quot;: \&quot;This is a comment\&quot; }
     * &#x60;&#x60;&#x60; **Note:** You can create more than one comment by
     * specifying a list of comments in the JSON body like this:
     * &#x60;&#x60;&#x60;JSON [ { \&quot;content\&quot;: \&quot;This is a
     * comment\&quot; }, { \&quot;content\&quot;: \&quot;This is another
     * comment\&quot; } ] &#x60;&#x60;&#x60; If you specify a list as input,
     * then a paginated list rather than an entry is returned in the response
     * body. For example: &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: {
     * \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. (required)
     * @param commentBody The comment text. Note that you can also provide a
     *            list of comments. (required)
     * @return CommentEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments")
    Observable<CommentRepresentation> createCommentsObservable(@Path("nodeId") String nodeId,
            @Body List<CommentBody> commentBody, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // EDIT
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update a comment Updates an existing comment **commentId** on node
     * **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @param commentId The identifier of a comment. (required)
     * @param commentBody The JSON representing the comment to be updated.
     *            (required)
     * @return CommentRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments/{commentId}")
    Call<CommentRepresentation> updateCommentCall(@Path("nodeId") String nodeId, @Path("commentId") String commentId,
            @Body CommentBody commentBody);

    /**
     * Update a comment Updates an existing comment **commentId** on node
     * **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param commentId The identifier of a comment. (required)
     * @param commentBody The JSON representing the comment to be updated.
     *            (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return CommentEntry
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments/{commentId}")
    Call<CommentRepresentation> updateCommentCall(@Path("nodeId") String nodeId, @Path("commentId") String commentId,
            @Body CommentBody commentBody, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Update a comment Updates an existing comment **commentId** on node
     * **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @param commentId The identifier of a comment. (required)
     * @param commentBody The JSON representing the comment to be updated.
     *            (required)
     * @return CommentEntry
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments/{commentId}")
    Observable<CommentRepresentation> updateCommentObservable(@Path("nodeId") String nodeId,
            @Path("commentId") String commentId, @Body CommentBody commentBody);

    /**
     * Update a comment Updates an existing comment **commentId** on node
     * **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param commentId The identifier of a comment. (required)
     * @param commentBody The JSON representing the comment to be updated.
     *            (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return CommentEntry
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments/{commentId}")
    Observable<CommentRepresentation> updateCommentObservable(@Path("nodeId") String nodeId,
            @Path("commentId") String commentId, @Body CommentBody commentBody,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete a comment Removes the comment **commentId** from node **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param commentId The identifier of a comment. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments/{commentId}")
    Call<Void> deleteCommentCall(@Path("nodeId") String nodeId, @Path("commentId") String commentId);

    /**
     * Delete a comment Removes the comment **commentId** from node **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param commentId The identifier of a comment. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/comments/{commentId}")
    Observable<Void> deleteCommentObservable(@Path("nodeId") String nodeId, @Path("commentId") String commentId);
}
