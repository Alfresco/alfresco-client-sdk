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
import org.alfresco.client.services.content.core.model.body.RatingBody;
import org.alfresco.client.services.content.core.model.representation.RatingRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface RatingsAPI
{
    String FIVE_STAR = "fiveStar";

    String LIKES = "likes";

    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get ratings Get the ratings for node **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @return ResultPaging<RatingRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings")
    Call<ResultPaging<RatingRepresentation>> listRatingsCall(@Path(NODE_ID) String nodeId);

    /**
     * Get ratings Get the ratings for node **nodeId**.
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
     * @return RatingPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings")
    Call<ResultPaging<RatingRepresentation>> listRatingsCall(@Path(NODE_ID) String nodeId,
            @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Rate Rate the node with identifier **nodeId**
     *
     * @param nodeId The identifier of a node. (required)
     * @param ratingBody For \&quot;myRating\&quot; the type is specific to the
     *            rating scheme, boolean for the likes and an integer for the
     *            fiveStar. For example, to \&quot;like\&quot; a file the
     *            following body would be used: &#x60;&#x60;&#x60;JSON {
     *            \&quot;id\&quot;: \&quot;likes\&quot;, \&quot;myRating\&quot;:
     *            true } &#x60;&#x60;&#x60; (required)
     * @return RatingRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings")
    Call<RatingRepresentation> rateNodeCall(@Path(NODE_ID) String nodeId, @Body RatingBody ratingBody);

    /**
     * Rate Rate the node with identifier **nodeId**
     * 
     * @param nodeId The identifier of a node. (required)
     * @param ratingBody For \&quot;myRating\&quot; the type is specific to the
     *            rating scheme, boolean for the likes and an integer for the
     *            fiveStar. For example, to \&quot;like\&quot; a file the
     *            following body would be used: &#x60;&#x60;&#x60;JSON {
     *            \&quot;id\&quot;: \&quot;likes\&quot;, \&quot;myRating\&quot;:
     *            true } &#x60;&#x60;&#x60; (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RatingRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings")
    Call<RatingRepresentation> rateNodeCall(@Path(NODE_ID) String nodeId, @Body RatingBody ratingBody,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // GET
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a rating Get the specific rating **ratingId** on node **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param ratingId The identifier of a rating. (required)
     * @return RatingEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings/{ratingId}")
    Call<RatingRepresentation> getRatingCall(@Path(NODE_ID) String nodeId, @Path(RATING_ID) String ratingId);

    /**
     * Get a rating Get the specific rating **ratingId** on node **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param ratingId The identifier of a rating. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RatingEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings/{ratingId}")
    Call<RatingRepresentation> getRatingCall(@Path(NODE_ID) String nodeId, @Path(RATING_ID) String ratingId,
            String fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete a rating Removes rating **ratingId** from node **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param ratingId The identifier of a rating. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings/{ratingId}")
    Call<Void> deleteRatingCall(@Path(NODE_ID) String nodeId, @Path(RATING_ID) String ratingId);

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
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Get ratings Get the ratings for node **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @return ResultPaging<RatingRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings")
    Observable<ResultPaging<RatingRepresentation>> listRatingsObservable(@Path(NODE_ID) String nodeId);

    /**
     * Get ratings Get the ratings for node **nodeId**.
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
     * @return RatingPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings")
    Observable<ResultPaging<RatingRepresentation>> listRatingsObservable(@Path(NODE_ID) String nodeId,
            @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Rate Rate the node with identifier **nodeId**
     *
     * @param nodeId The identifier of a node. (required)
     * @param ratingBody For \&quot;myRating\&quot; the type is specific to the
     *            rating scheme, boolean for the likes and an integer for the
     *            fiveStar. For example, to \&quot;like\&quot; a file the
     *            following body would be used: &#x60;&#x60;&#x60;JSON {
     *            \&quot;id\&quot;: \&quot;likes\&quot;, \&quot;myRating\&quot;:
     *            true } &#x60;&#x60;&#x60; (required)
     * @return RatingRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings")
    Observable<RatingRepresentation> rateNodeObservable(@Path(NODE_ID) String nodeId, @Body RatingBody ratingBody);

    /**
     * Rate Rate the node with identifier **nodeId**
     *
     * @param nodeId The identifier of a node. (required)
     * @param ratingBody For \&quot;myRating\&quot; the type is specific to the
     *            rating scheme, boolean for the likes and an integer for the
     *            fiveStar. For example, to \&quot;like\&quot; a file the
     *            following body would be used: &#x60;&#x60;&#x60;JSON {
     *            \&quot;id\&quot;: \&quot;likes\&quot;, \&quot;myRating\&quot;:
     *            true } &#x60;&#x60;&#x60; (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RatingRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings")
    Observable<RatingRepresentation> rateNodeObservable(@Path(NODE_ID) String nodeId, @Body RatingBody ratingBody,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // GET
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Get a rating Get the specific rating **ratingId** on node **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @param ratingId The identifier of a rating. (required)
     * @return RatingEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings/{ratingId}")
    Observable<RatingRepresentation> getRatingObservable(@Path(NODE_ID) String nodeId,
            @Path(RATING_ID) String ratingId);

    /**
     * Get a rating Get the specific rating **ratingId** on node **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @param ratingId The identifier of a rating. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RatingEntry
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings/{ratingId}")
    Observable<RatingRepresentation> getRatingObservable(@Path(NODE_ID) String nodeId, @Path(RATING_ID) String ratingId,
            String fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Delete a rating Removes rating **ratingId** from node **nodeId**.
     *
     * @param nodeId The identifier of a node. (required)
     * @param ratingId The identifier of a rating. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/ratings/{ratingId}")
    Observable<Void> deleteRatingObservable(@Path(NODE_ID) String nodeId, @Path(RATING_ID) String ratingId);

}
