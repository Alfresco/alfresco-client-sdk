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
import com.alfresco.client.api.core.model.body.PersonBodyCreate;
import com.alfresco.client.api.core.model.body.PersonBodyUpdate;
import com.alfresco.client.api.core.model.parameters.FieldsParam;
import com.alfresco.client.api.core.model.parameters.OrderByParam;
import com.alfresco.client.api.core.model.representation.PersonRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface PeopleAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // LIST PEOPLE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List people **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. List people. The default sort order for the returned list
     * is for people to be sorted by ascending id. You can override the default
     * specify one or more fields in the **orderBy** parameter. For example: *
     * id * firstName * lastName
     *
     * @return PeoplePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people")
    Call<ResultPaging<PersonRepresentation>> listPeopleCall();

    /**
     * List people **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. List people. The default sort order for the returned list
     * is for people to be sorted by ascending id. You can override the default
     * specify one or more fields in the **orderBy** parameter. For example: *
     * id * firstName * lastName
     *
     * @return PeoplePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people")
    Observable<ResultPaging<PersonRepresentation>> listPeopleObservable();

    /**
     * List people **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. List people. The default sort order for the returned list
     * is for people to be sorted by ascending id. You can override the default
     * specify one or more fields in the **orderBy** parameter. For example: *
     * id * firstName * lastName
     * 
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
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return PeoplePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people")
    Call<ResultPaging<PersonRepresentation>> listPeopleCall(
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * List people **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. List people. The default sort order for the returned list
     * is for people to be sorted by ascending id. You can override the default
     * specify one or more fields in the **orderBy** parameter. For example: *
     * id * firstName * lastName
     *
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
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return PeoplePaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people")
    Observable<ResultPaging<PersonRepresentation>> listPeopleObservable(
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // INFO PERSON
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a person Gets information for the person **personId**. You can use
     * the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @return PersonRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}")
    Call<PersonRepresentation> getPersonCall(@Path("personId") String personId);

    /**
     * Get a person Gets information for the person **personId**. You can use
     * the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @return PersonRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}")
    Observable<PersonRepresentation> getPersonObservable(@Path("personId") String personId);

    /**
     * Get a person Gets information for the person **personId**. You can use
     * the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return PersonRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}")
    Call<PersonRepresentation> getPersonCall(@Path("personId") String personId,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Get a person Gets information for the person **personId**. You can use
     * the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return PersonRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}")
    Observable<PersonRepresentation> getPersonObservable(@Path("personId") String personId,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE PERSON
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create person **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. Create a person.
     *
     * @param personBodyCreate The person details. (required)
     * @return PersonRepresentation
     */
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/people")
    Call<PersonRepresentation> createPersonCall(@Body() PersonBodyCreate personBodyCreate);

    /**
     * Create person **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. Create a person.
     * 
     * @param personBodyCreate The person details. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return PersonRepresentation
     */
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/people")
    Call<PersonRepresentation> createPersonCall(@Body() PersonBodyCreate personBodyCreate,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Create person **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. Create a person.
     *
     * @param personBodyCreate The person details. (required)
     * @return PersonRepresentation
     */
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/people")
    Observable<PersonRepresentation> createPersonObservable(@Body() PersonBodyCreate personBodyCreate);

    /**
     * Create person **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. Create a person.
     *
     * @param personBodyCreate The person details. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return PersonRepresentation
     */
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/people")
    Observable<PersonRepresentation> createPersonObservable(@Body() PersonBodyCreate personBodyCreate,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE PERSON
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update person **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. Update the given person&#39;s details. If applicable, the
     * given person&#39;s login access can also be optionally disabled (or
     * re-enabled), eg. by an admin.
     * 
     * @param personId The identifier of a person. (required)
     * @param personBodyUpdate The person details. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return PersonEntry
     */
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}")
    Call<PersonRepresentation> updatePersonCall(@Path("personId") String personId,
            @Body() PersonBodyUpdate personBodyUpdate, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Update person **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. Update the given person&#39;s details. If applicable, the
     * given person&#39;s login access can also be optionally disabled (or
     * re-enabled), eg. by an admin.
     *
     * @param personId The identifier of a person. (required)
     * @param personBodyUpdate The person details. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return PersonEntry
     */
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}")
    Observable<PersonRepresentation> updatePersonObservable(@Path("personId") String personId,
            @Body() PersonBodyUpdate personBodyUpdate, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

}
