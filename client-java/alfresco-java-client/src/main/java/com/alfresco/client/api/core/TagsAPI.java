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

import com.alfresco.client.api.common.constant.PublicAPIConstant;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.model.body.TagBody;
import com.alfresco.client.api.core.model.parameters.FieldsParam;
import com.alfresco.client.api.core.model.representation.TagRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface TagsAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // LISTING BY NODE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get tags Returns a list of tags for node **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @return ResultPaging<TagRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags")
    Call<ResultPaging<TagRepresentation>> listTagsForNodeCall(@Path("nodeId") String nodeId);

    /**
     * Get tags Returns a list of tags for node **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @return ResultPaging<TagRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags")
    Observable<ResultPaging<TagRepresentation>> ListTagsForNodeObservable(@Path("nodeId") String nodeId);

    /**
     * Get tags Returns a list of tags for node **nodeId**.
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
     * @return ResultPaging<TagRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags")
    Call<ResultPaging<TagRepresentation>> listTagsForNodeCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Get tags Returns a list of tags for node **nodeId**.
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
     * @return ResultPaging<TagRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags")
    Observable<ResultPaging<TagRepresentation>> ListTagsForNodeObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get tags Returns a list of tags in this repository.
     * 
     * @return ResultPaging<TagRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/tags")
    Call<ResultPaging<TagRepresentation>> listTagsCall();

    /**
     * Get tags Returns a list of tags in this repository.
     *
     * @return ResultPaging<TagRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/tags")
    Observable<ResultPaging<TagRepresentation>> listTagsObservable();

    /**
     * Get tags Returns a list of tags in this repository.
     * 
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
     * @return ResultPaging<TagRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/tags")
    Call<ResultPaging<TagRepresentation>> listTagsCall(@Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Get tags Returns a list of tags in this repository.
     *
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
     * @return ResultPaging<TagRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/tags")
    Observable<ResultPaging<TagRepresentation>> listTagsObservable(
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Add a tag Adds a tag to the node **nodeId**. You specify the tag in a
     * JSON body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; } &#x60;&#x60;&#x60; **Note:**
     * You can create more than one tag by specifying a list of tags in the JSON
     * body like this: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; }, {
     * \&quot;tag\&quot;:\&quot;test-tag-2\&quot; } ] &#x60;&#x60;&#x60; If you
     * specify a list as input, then a paginated list rather than an entry is
     * returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. (required)
     * @param tagBody The new tag (required)
     * @return TagRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags")
    Call<TagRepresentation> createTagForNodeCall(@Path("nodeId") String nodeId, @Body TagBody tagBody);

    /**
     * Add a tag Adds a tag to the node **nodeId**. You specify the tag in a
     * JSON body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; } &#x60;&#x60;&#x60; **Note:**
     * You can create more than one tag by specifying a list of tags in the JSON
     * body like this: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; }, {
     * \&quot;tag\&quot;:\&quot;test-tag-2\&quot; } ] &#x60;&#x60;&#x60; If you
     * specify a list as input, then a paginated list rather than an entry is
     * returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     * 
     * @param nodeId The identifier of a node. (required)
     * @param tagBody The new tag (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return TagRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags")
    Call<TagRepresentation> createTagForNodeCall(@Path("nodeId") String nodeId, @Body TagBody tagBody,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Add a tag Adds a tag to the node **nodeId**. You specify the tag in a
     * JSON body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; } &#x60;&#x60;&#x60; **Note:**
     * You can create more than one tag by specifying a list of tags in the JSON
     * body like this: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; }, {
     * \&quot;tag\&quot;:\&quot;test-tag-2\&quot; } ] &#x60;&#x60;&#x60; If you
     * specify a list as input, then a paginated list rather than an entry is
     * returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. (required)
     * @param tagBody The new tag (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return TagRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags")
    Observable<TagRepresentation> createTagForNodeObservable(@Path("nodeId") String nodeId, @Body TagBody tagBody,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Add a tag Adds a tag to the node **nodeId**. You specify the tag in a
     * JSON body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; } &#x60;&#x60;&#x60; **Note:**
     * You can create more than one tag by specifying a list of tags in the JSON
     * body like this: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; }, {
     * \&quot;tag\&quot;:\&quot;test-tag-2\&quot; } ] &#x60;&#x60;&#x60; If you
     * specify a list as input, then a paginated list rather than an entry is
     * returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. (required)
     * @param tagBody The new tag (required)
     * @return TagRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags")
    Observable<TagRepresentation> createTagForNodeObservable(@Path("nodeId") String nodeId, @Body TagBody tagBody);

    /**
     * Add tags Adds a tag to the node **nodeId**. You specify the tag in a JSON
     * body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; } &#x60;&#x60;&#x60; **Note:**
     * You can create more than one tag by specifying a list of tags in the JSON
     * body like this: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; }, {
     * \&quot;tag\&quot;:\&quot;test-tag-2\&quot; } ] &#x60;&#x60;&#x60; If you
     * specify a list as input, then a paginated list rather than an entry is
     * returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     * 
     * @param nodeId The identifier of a node. (required)
     * @param tagBody List of new tags (required)
     * @return TagRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags")
    Call<ResultPaging<TagRepresentation>> createTagsForNodeCall(@Path("nodeId") String nodeId, @Body TagBody[] tagBody);

    /**
     * Add tags Adds a tag to the node **nodeId**. You specify the tag in a JSON
     * body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; } &#x60;&#x60;&#x60; **Note:**
     * You can create more than one tag by specifying a list of tags in the JSON
     * body like this: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; }, {
     * \&quot;tag\&quot;:\&quot;test-tag-2\&quot; } ] &#x60;&#x60;&#x60; If you
     * specify a list as input, then a paginated list rather than an entry is
     * returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. (required)
     * @param tagBody List of new tags (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return TagRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags")
    Call<ResultPaging<TagRepresentation>> createTagsForNodeCall(@Path("nodeId") String nodeId, @Body TagBody[] tagBody,
                                                                @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Add tags Adds a tag to the node **nodeId**. You specify the tag in a JSON
     * body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; } &#x60;&#x60;&#x60; **Note:**
     * You can create more than one tag by specifying a list of tags in the JSON
     * body like this: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; }, {
     * \&quot;tag\&quot;:\&quot;test-tag-2\&quot; } ] &#x60;&#x60;&#x60; If you
     * specify a list as input, then a paginated list rather than an entry is
     * returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. (required)
     * @param tagBody List of new tags (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return TagRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags")
    Observable<ResultPaging<TagRepresentation>> createTagsForNodeObservable(@Path("nodeId") String nodeId,
            @Body TagBody[] tagBody, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Add tags Adds a tag to the node **nodeId**. You specify the tag in a JSON
     * body like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; } &#x60;&#x60;&#x60; **Note:**
     * You can create more than one tag by specifying a list of tags in the JSON
     * body like this: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;tag\&quot;:\&quot;test-tag-1\&quot; }, {
     * \&quot;tag\&quot;:\&quot;test-tag-2\&quot; } ] &#x60;&#x60;&#x60; If you
     * specify a list as input, then a paginated list rather than an entry is
     * returned in the response body. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;list\&quot;: { \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. (required)
     * @param tagBody List of new tags (required)
     * @return TagRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags")
    Observable<ResultPaging<TagRepresentation>> createTagsForNodeObservable(@Path("nodeId") String nodeId,
                                                                            @Body TagBody[] tagBody);

    // ///////////////////////////////////////////////////////////////////////////
    // INFO
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a tag Return a specific tag with **tagId**.
     * 
     * @param tagId The identifier of a tag. (required)
     * @return TagRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/tags/{tagId}")
    Call<TagRepresentation> getTagCall(@Path("tagId") String tagId);

    /**
     * Get a tag Return a specific tag with **tagId**.
     *
     * @param tagId The identifier of a tag. (required)
     * @return TagRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/tags/{tagId}")
    Observable<TagRepresentation> getTagObservable(@Path("tagId") String tagId);

    /**
     * Get a tag Return a specific tag with **tagId**.
     * 
     * @param tagId The identifier of a tag. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return TagRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/tags/{tagId}")
    Call<TagRepresentation> getTagCall(@Path("tagId") String tagId,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Get a tag Return a specific tag with **tagId**.
     *
     * @param tagId The identifier of a tag. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return TagRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/tags/{tagId}")
    Observable<TagRepresentation> getTagObservable(@Path("tagId") String tagId,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // EDIT
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update a tag Updates the tag **tagId**.
     * 
     * @param tagId The identifier of a tag. (required)
     * @param tagBody The updated tag (required)
     * @return TagRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/tags/{tagId}")
    Call<TagRepresentation> updateTagCall(@Path("tagId") String tagId, @Body TagBody tagBody,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Update a tag Updates the tag **tagId**.
     *
     * @param tagId The identifier of a tag. (required)
     * @param tagBody The updated tag (required)
     * @return TagRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/tags/{tagId}")
    Observable<TagRepresentation> updateTagObservable(@Path("tagId") String tagId, @Body TagBody tagBody,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete a tag Removes tag **tagId** from node **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param tagId The identifier of a tag. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags/{tagId}")
    Call<Void> deleteTagFromNodeCall(@Path("nodeId") String nodeId, @Path("tagId") String tagId);

    /**
     * Delete a tag Removes tag **tagId** from node **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @param tagId The identifier of a tag. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/tags/{tagId}")
    Observable<Void> deleteTagFromNodeObservable(@Path("nodeId") String nodeId, @Path("tagId") String tagId);
}
