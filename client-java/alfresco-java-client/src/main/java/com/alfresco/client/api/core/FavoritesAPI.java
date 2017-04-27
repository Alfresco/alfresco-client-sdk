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
import com.alfresco.client.api.core.model.body.FavoriteBodyCreate;
import com.alfresco.client.api.core.model.parameters.FieldsParam;
import com.alfresco.client.api.core.model.representation.CommentRepresentation;
import com.alfresco.client.api.core.model.representation.FavoriteRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface FavoritesAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get favorites Returns a list of favorites for person **personId**. You
     * can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * You can use the **where** parameter to restrict the list in the response
     * to entries of a specific kind. The **where** parameter takes a value. The
     * value is a single predicate that can include one or more **EXISTS**
     * conditions. The **EXISTS** condition uses a single operand to limit the
     * list to include entries that include that one property. The property
     * values are: * &#x60;target/file&#x60; * &#x60;target/folder&#x60; *
     * &#x60;target/site&#x60; For example, the following **where** parameter
     * restricts the returned list to the file favorites for a person:
     * &#x60;&#x60;&#x60;SQL (EXISTS(target/file)) &#x60;&#x60;&#x60; You can
     * specify more than one condition using **OR**. The predicate must be
     * enclosed in parentheses. For example, the following **where** parameter
     * restricts the returned list to the file and folder favorites for a
     * person: &#x60;&#x60;&#x60;SQL (EXISTS(target/file) OR
     * EXISTS(target/folder)) &#x60;&#x60;&#x60;
     * 
     * @param personId The identifier of a person. (required)
     * @return FavoritePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/favorites")
    Call<ResultPaging<FavoriteRepresentation>> listFavoritesCall(@Path("personId") String personId);

    /**
     * Get favorites Returns a list of favorites for person **personId**. You
     * can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * You can use the **where** parameter to restrict the list in the response
     * to entries of a specific kind. The **where** parameter takes a value. The
     * value is a single predicate that can include one or more **EXISTS**
     * conditions. The **EXISTS** condition uses a single operand to limit the
     * list to include entries that include that one property. The property
     * values are: * &#x60;target/file&#x60; * &#x60;target/folder&#x60; *
     * &#x60;target/site&#x60; For example, the following **where** parameter
     * restricts the returned list to the file favorites for a person:
     * &#x60;&#x60;&#x60;SQL (EXISTS(target/file)) &#x60;&#x60;&#x60; You can
     * specify more than one condition using **OR**. The predicate must be
     * enclosed in parentheses. For example, the following **where** parameter
     * restricts the returned list to the file and folder favorites for a
     * person: &#x60;&#x60;&#x60;SQL (EXISTS(target/file) OR
     * EXISTS(target/folder)) &#x60;&#x60;&#x60;
     *
     * @param personId The identifier of a person. (required)
     * @return FavoritePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/favorites")
    Observable<ResultPaging<CommentRepresentation>> listFavoritesObservable(@Path("personId") String personId);

    /**
     * Get favorites Returns a list of favorites for person **personId**. You
     * can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * You can use the **where** parameter to restrict the list in the response
     * to entries of a specific kind. The **where** parameter takes a value. The
     * value is a single predicate that can include one or more **EXISTS**
     * conditions. The **EXISTS** condition uses a single operand to limit the
     * list to include entries that include that one property. The property
     * values are: * &#x60;target/file&#x60; * &#x60;target/folder&#x60; *
     * &#x60;target/site&#x60; For example, the following **where** parameter
     * restricts the returned list to the file favorites for a person:
     * &#x60;&#x60;&#x60;SQL (EXISTS(target/file)) &#x60;&#x60;&#x60; You can
     * specify more than one condition using **OR**. The predicate must be
     * enclosed in parentheses. For example, the following **where** parameter
     * restricts the returned list to the file and folder favorites for a
     * person: &#x60;&#x60;&#x60;SQL (EXISTS(target/file) OR
     * EXISTS(target/folder)) &#x60;&#x60;&#x60;
     * 
     * @param personId The identifier of a person. (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param where A string to restrict the returned objects by using a
     *            predicate. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return FavoritePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/favorites")
    Call<ResultPaging<FavoriteRepresentation>> listFavoritesCall(@Path("personId") String personId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Get favorites Returns a list of favorites for person **personId**. You
     * can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * You can use the **where** parameter to restrict the list in the response
     * to entries of a specific kind. The **where** parameter takes a value. The
     * value is a single predicate that can include one or more **EXISTS**
     * conditions. The **EXISTS** condition uses a single operand to limit the
     * list to include entries that include that one property. The property
     * values are: * &#x60;target/file&#x60; * &#x60;target/folder&#x60; *
     * &#x60;target/site&#x60; For example, the following **where** parameter
     * restricts the returned list to the file favorites for a person:
     * &#x60;&#x60;&#x60;SQL (EXISTS(target/file)) &#x60;&#x60;&#x60; You can
     * specify more than one condition using **OR**. The predicate must be
     * enclosed in parentheses. For example, the following **where** parameter
     * restricts the returned list to the file and folder favorites for a
     * person: &#x60;&#x60;&#x60;SQL (EXISTS(target/file) OR
     * EXISTS(target/folder)) &#x60;&#x60;&#x60;
     *
     * @param personId The identifier of a person. (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param where A string to restrict the returned objects by using a
     *            predicate. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return FavoritePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/favorites")
    Observable<ResultPaging<FavoriteRepresentation>> listFavoritesObservable(@Path("personId") String personId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // INFO
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a favorite Returns favorite **favoriteId** for person **personId**.
     * You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * 
     * @param personId The identifier of a person. (required)
     * @param favoriteId The identifier of a favorite. (required)
     * @return FavoriteRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/favorites/{favoriteId}")
    Call<FavoriteRepresentation> getFavoriteCall(@Path("personId") String personId,
            @Path("favoriteId") String favoriteId);

    /**
     * Get a favorite Returns favorite **favoriteId** for person **personId**.
     * You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * 
     * @param personId The identifier of a person. (required)
     * @param favoriteId The identifier of a favorite. (required)
     * @return FavoriteRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/favorites/{favoriteId}")
    Observable<FavoriteRepresentation> getFavoriteObservable(@Path("personId") String personId,
            @Path("favoriteId") String favoriteId);

    /**
     * Get a favorite Returns favorite **favoriteId** for person **personId**.
     * You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * 
     * @param personId The identifier of a person. (required)
     * @param favoriteId The identifier of a favorite. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return FavoriteRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/favorites/{favoriteId}")
    Call<FavoriteRepresentation> getFavoriteCall(@Path("personId") String personId,
            @Path("favoriteId") String favoriteId, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Get a favorite Returns favorite **favoriteId** for person **personId**.
     * You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * 
     * @param personId The identifier of a person. (required)
     * @param favoriteId The identifier of a favorite. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return FavoriteRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/favorites/{favoriteId}")
    Observable<FavoriteRepresentation> getFavoriteObservable(@Path("personId") String personId,
            @Path("favoriteId") String favoriteId, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Add a favorite Favorite a **site**, **file**, or **folder** in the
     * repository. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * **Note:** You can favorite more than one entity by specifying a list of
     * objects in the JSON body like this: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;target\&quot;: { \&quot;file\&quot;: { \&quot;guid\&quot;:
     * \&quot;abcde-01234-....\&quot; } } }, { \&quot;target\&quot;: {
     * \&quot;file\&quot;: { \&quot;guid\&quot;: \&quot;abcde-09863-....\&quot;
     * } } }, ] &#x60;&#x60;&#x60; If you specify a list as input, then a
     * paginated list rather than an entry is returned in the response body. For
     * example: &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: {
     * \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     * 
     * @param personId The identifier of a person. (required)
     * @param favoriteBodyCreate An object identifying the entity to be
     *            favorited. The object consists of a single property which is
     *            an object with the name &#x60;site&#x60;, &#x60;file&#x60;, or
     *            &#x60;folder&#x60;. The content of that object is the
     *            &#x60;guid&#x60; of the target entity. For example, to
     *            favorite a file the following body would be used:
     *            &#x60;&#x60;&#x60;JSON { \&quot;target\&quot;: {
     *            \&quot;file\&quot;: { \&quot;guid\&quot;:
     *            \&quot;abcde-01234-....\&quot; } } } &#x60;&#x60;&#x60;
     *            (required)
     * @return FavoriteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/favorites")
    Call<FavoriteRepresentation> createFavoriteCall(@Path("personId") String personId,
            @Body FavoriteBodyCreate favoriteBodyCreate,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Add a favorite Favorite a **site**, **file**, or **folder** in the
     * repository. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * **Note:** You can favorite more than one entity by specifying a list of
     * objects in the JSON body like this: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;target\&quot;: { \&quot;file\&quot;: { \&quot;guid\&quot;:
     * \&quot;abcde-01234-....\&quot; } } }, { \&quot;target\&quot;: {
     * \&quot;file\&quot;: { \&quot;guid\&quot;: \&quot;abcde-09863-....\&quot;
     * } } }, ] &#x60;&#x60;&#x60; If you specify a list as input, then a
     * paginated list rather than an entry is returned in the response body. For
     * example: &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: {
     * \&quot;pagination\&quot;: { \&quot;count\&quot;: 2,
     * \&quot;hasMoreItems\&quot;: false, \&quot;totalItems\&quot;: 2,
     * \&quot;skipCount\&quot;: 0, \&quot;maxItems\&quot;: 100 },
     * \&quot;entries\&quot;: [ { \&quot;entry\&quot;: { ... } }, {
     * \&quot;entry\&quot;: { ... } } ] } } &#x60;&#x60;&#x60;
     * 
     * @param personId The identifier of a person. (required)
     * @param favoriteBodyCreate An object identifying the entity to be
     *            favorited. The object consists of a single property which is
     *            an object with the name &#x60;site&#x60;, &#x60;file&#x60;, or
     *            &#x60;folder&#x60;. The content of that object is the
     *            &#x60;guid&#x60; of the target entity. For example, to
     *            favorite a file the following body would be used:
     *            &#x60;&#x60;&#x60;JSON { \&quot;target\&quot;: {
     *            \&quot;file\&quot;: { \&quot;guid\&quot;:
     *            \&quot;abcde-01234-....\&quot; } } } &#x60;&#x60;&#x60;
     *            (required)
     * @return FavoriteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/favorites")
    Observable<FavoriteRepresentation> createFavoriteObservable(@Path("personId") String personId,
            @Body FavoriteBodyCreate favoriteBodyCreate, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete a favorite Removes **favoriteId** as a favorite of person
     * **personId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * 
     * @param personId The identifier of a person. (required)
     * @param favoriteId The identifier of a favorite. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/favorites/{favoriteId}")
    Call<Void> deleteFavoriteCall(@Path("personId") String personId, @Path("favoriteId") String favoriteId);

    /**
     * Delete a favorite Removes **favoriteId** as a favorite of person
     * **personId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * 
     * @param personId The identifier of a person. (required)
     * @param favoriteId The identifier of a favorite. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/favorites/{favoriteId}")
    Observable<Void> deleteFavoriteObservable(@Path("personId") String personId, @Path("favoriteId") String favoriteId);
}
