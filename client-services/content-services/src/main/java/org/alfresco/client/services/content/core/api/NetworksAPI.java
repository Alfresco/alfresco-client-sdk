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

package org.alfresco.client.services.content.core.api;

import static org.alfresco.client.services.common.constant.ApiConstant.*;

import org.alfresco.client.services.common.model.parameters.FieldsParam;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.core.CoreConstant;
import org.alfresco.client.services.content.core.model.representation.PersonNetworkRepresentation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface NetworksAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // INFO NETWORK
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a network Returns information for a network **networkId**.
     * 
     * @param networkId The identifier of a network. (required)
     * @return PersonNetworkRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/networks/{networkId}/networks")
    Call<PersonNetworkRepresentation> getNetworkCall(@Path(NETWORK_ID) String networkId);

    /**
     * Get a network Returns information for a network **networkId**.
     * 
     * @param networkId The identifier of a network. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return PersonNetworkEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/networks/{networkId}/networks")
    Call<PersonNetworkRepresentation> getNetworkCall(@Path(NETWORK_ID) String networkId,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // LIST PERSON NETWORK
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get network membership Gets a list of network memberships for person
     * **personId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * 
     * @param personId The identifier of a person. (required)
     * @return ResultPaging<PersonNetworkRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/networks")
    Call<ResultPaging<PersonNetworkRepresentation>> listNetworksForPersonCall(@Path(PERSON_ID) String personId);

    /**
     * Get network membership Gets a list of network memberships for person
     * **personId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     * 
     * @param personId The identifier of a person. (required)
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
     * @return ResultPaging<PersonNetworkRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/networks")
    Call<ResultPaging<PersonNetworkRepresentation>> listNetworksForPersonCall(@Path(PERSON_ID) String personId,
            @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // INFO PERSON NETWORK
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get network information Returns network information on a single network
     * specified by **networkId** for **personId**. You can use the
     * &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     * 
     * @param personId The identifier of a person. (required)
     * @param networkId The identifier of a network. (required)
     * @return PersonNetworkEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/networks/{networkId}")
    Call<PersonNetworkRepresentation> getNetworkForPersonCall(@Path(PERSON_ID) String personId,
            @Path(NETWORK_ID) String networkId);

    /**
     * Get network information Returns network information on a single network
     * specified by **networkId** for **personId**. You can use the
     * &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     * 
     * @param personId The identifier of a person. (required)
     * @param networkId The identifier of a network. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return PersonNetworkEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/networks/{networkId}")
    Call<PersonNetworkRepresentation> getNetworkForPersonCall(@Path(PERSON_ID) String personId,
            @Path(NETWORK_ID) String networkId, @Query(FIELDS) FieldsParam fields);

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
    // INFO NETWORK
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Get a network Returns information for a network **networkId**.
     *
     * @param networkId The identifier of a network. (required)
     * @return PersonNetworkRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/networks/{networkId}/networks")
    Observable<PersonNetworkRepresentation> getNetworkObservable(@Path(NETWORK_ID) String networkId);

    /**
     * Get a network Returns information for a network **networkId**.
     *
     * @param networkId The identifier of a network. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return PersonNetworkRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/networks/{networkId}/networks")
    Observable<PersonNetworkRepresentation> getNetworkObservable(@Path(NETWORK_ID) String networkId,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // LIST PERSON NETWORK
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get network membership Gets a list of network memberships for person
     * **personId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @return ResultPaging<PersonNetworkRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/networks")
    Observable<ResultPaging<PersonNetworkRepresentation>> listNetworksForPersonObservable(
            @Path(PERSON_ID) String personId);

    /**
     * Get network membership Gets a list of network memberships for person
     * **personId**. You can use the &#x60;-me-&#x60; string in place of
     * &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
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
     * @return ResultPaging<PersonNetworkRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/networks")
    Observable<ResultPaging<PersonNetworkRepresentation>> listNetworksForPersonObservable(
            @Path(PERSON_ID) String personId, @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // INFO PERSON NETWORK
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Get network information Returns network information on a single network
     * specified by **networkId** for **personId**. You can use the
     * &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param networkId The identifier of a network. (required)
     * @return PersonNetworkRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/networks/{networkId}")
    Observable<PersonNetworkRepresentation> getNetworkForPersonObservable(@Path(PERSON_ID) String personId,
            @Path(NETWORK_ID) String networkId);

    /**
     * Get network information Returns network information on a single network
     * specified by **networkId** for **personId**. You can use the
     * &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to
     * specify the currently authenticated user.
     *
     * @param personId The identifier of a person. (required)
     * @param networkId The identifier of a network. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return PersonNetworkRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/people/{personId}/networks/{networkId}")
    Observable<PersonNetworkRepresentation> getNetworkForPersonObservable(@Path(PERSON_ID) String personId,
            @Path(NETWORK_ID) String networkId, @Query(FIELDS) FieldsParam fields);
}
