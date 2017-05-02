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

import org.alfresco.client.services.common.constant.PublicAPIConstant;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.core.model.body.NodeBodyUpdate;
import org.alfresco.client.services.content.core.model.parameters.FieldsParam;
import org.alfresco.client.services.content.core.model.parameters.IncludeParam;
import org.alfresco.client.services.content.core.model.parameters.OrderByParam;
import org.alfresco.client.services.governance.core.GovernanceConstant;
import org.alfresco.client.services.governance.core.model.representation.TransferContainerRepresentation;
import org.alfresco.client.services.governance.core.model.representation.TransferRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface TransferContainersAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // GET
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a transfer container Get information for transfer container
     * **transferContainerId** Besides mandatory fields the transfer
     * container&#39;s aspects and properties are returned by default.
     * 
     * @param transferContainerId The identifier of a transfer container. You
     *            can also use the -transfers- alias. (required)
     * @return TransferContainerEntry
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/transfer-containers/{transferContainerId}")
    Call<TransferContainerRepresentation> getTransferContainerCall(
            @Path("transferContainerId") String transferContainerId);

    /**
     * Get a transfer container Get information for transfer container
     * **transferContainerId** Besides mandatory fields the transfer
     * container&#39;s aspects and properties are returned by default.
     * 
     * @param transferContainerId The identifier of a transfer container. You
     *            can also use the -transfers- alias. (required)
     * @param include Returns additional information about the transfer
     *            container. Any optional field from the response model can be
     *            requested. For example: * allowableOperations * path
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return TransferContainerEntry
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/transfer-containers/{transferContainerId}")
    Call<TransferContainerRepresentation> getTransferContainerCall(
            @Path("transferContainerId") String transferContainerId,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update transfer container Updates the transfer container
     * **transferContainerId**. For example, you can rename transfer container:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My new name\&quot; }
     * &#x60;&#x60;&#x60; You can also set or update description and title
     * properties: &#x60;&#x60;&#x60;JSON { \&quot;properties\&quot;: {
     * \&quot;cm:description\&quot;: \&quot;New Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;New Title\&quot; } } &#x60;&#x60;&#x60;
     * **Note:** Currently there is no optimistic locking for updates, so they
     * are applied in \&quot;last one wins\&quot; order.
     * 
     * @param transferContainerId The identifier of a transfer container. You
     *            can also use the -transfers- alias. (required)
     * @param nodeBodyUpdate The node information to update. (required)
     * @return TransferContainerEntry
     */
    @Headers({ "Content-type: application/json" })
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/transfer-containers/{transferContainerId}")
    Call<TransferContainerRepresentation> updateTransferContainerCall(
            @Path("transferContainerId") String transferContainerId, @Body NodeBodyUpdate nodeBodyUpdate);

    /**
     * Update transfer container Updates the transfer container
     * **transferContainerId**. For example, you can rename transfer container:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My new name\&quot; }
     * &#x60;&#x60;&#x60; You can also set or update description and title
     * properties: &#x60;&#x60;&#x60;JSON { \&quot;properties\&quot;: {
     * \&quot;cm:description\&quot;: \&quot;New Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;New Title\&quot; } } &#x60;&#x60;&#x60;
     * **Note:** Currently there is no optimistic locking for updates, so they
     * are applied in \&quot;last one wins\&quot; order.
     * 
     * @param transferContainerId The identifier of a transfer container. You
     *            can also use the -transfers- alias. (required)
     * @param nodeBodyUpdate The node information to update. (required)
     * @param include Returns additional information about the transfer
     *            container. Any optional field from the response model can be
     *            requested. For example: * allowableOperations * path
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return TransferContainerEntry
     */
    @Headers({ "Content-type: application/json" })
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/transfer-containers/{transferContainerId}")
    Call<TransferContainerRepresentation> updateTransferContainerCall(
            @Path("transferContainerId") String transferContainerId, @Body NodeBodyUpdate nodeBodyUpdate,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // LIST CHILDREN
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List transfer container&#39;s children Returns a list of transfers.
     * Minimal information for each child is returned by default. You can use
     * the **include** parameter to return additional information. You can use
     * the **include** parameter (include&#x3D;association) to return child
     * association details for each child, including the **assocType** and the
     * **isPrimary** flag.
     *
     * @param transferContainerId The identifier of a transfer container. You
     *            can also use the -transfers- alias. (required)
     * @return TransferContainerAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/transfer-containers/{transferContainerId}/children")
    Call<ResultPaging<TransferRepresentation>> listTransfersCall(
            @Path("transferContainerId") String transferContainerId);

    /**
     * List transfer container&#39;s children Returns a list of transfers.
     * Minimal information for each child is returned by default. You can use
     * the **include** parameter to return additional information. You can use
     * the **include** parameter (include&#x3D;association) to return child
     * association details for each child, including the **assocType** and the
     * **isPrimary** flag.
     * 
     * @param transferContainerId The identifier of a transfer container. You
     *            can also use the -transfers- alias. (required)
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
     * @param include Returns additional information about the transfer folder.
     *            Any optional field from the response model can be requested.
     *            For example: * transferPDFIndicator * transferLocation *
     *            transferAccessionIndicator * properties * aspectNames *
     *            allowableOperations (optional)
     * @param includeSource Also include **source** in addition to **entries**
     *            with folder information on the specified parent
     *            **transferContainerId**. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return TransferContainerAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/transfer-containers/{transferContainerId}/children")
    Call<ResultPaging<TransferRepresentation>> listTransfersCall(
            @Path("transferContainerId") String transferContainerId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.INCLUDE_SOURCE_VALUE) Boolean includeSource,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

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
    // GET
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a transfer container Get information for transfer container
     * **transferContainerId** Besides mandatory fields the transfer
     * container&#39;s aspects and properties are returned by default.
     *
     * @param transferContainerId The identifier of a transfer container. You
     *            can also use the -transfers- alias. (required)
     * @return TransferContainerEntry
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/transfer-containers/{transferContainerId}")
    Observable<TransferContainerRepresentation> getTransferContainerObservable(
            @Path("transferContainerId") String transferContainerId);

    /**
     * Get a transfer container Get information for transfer container
     * **transferContainerId** Besides mandatory fields the transfer
     * container&#39;s aspects and properties are returned by default.
     *
     * @param transferContainerId The identifier of a transfer container. You
     *            can also use the -transfers- alias. (required)
     * @param include Returns additional information about the transfer
     *            container. Any optional field from the response model can be
     *            requested. For example: * allowableOperations * path
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return TransferContainerEntry
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/transfer-containers/{transferContainerId}")
    Observable<TransferContainerRepresentation> getTransferContainerObservable(
            @Path("transferContainerId") String transferContainerId,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update transfer container Updates the transfer container
     * **transferContainerId**. For example, you can rename transfer container:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My new name\&quot; }
     * &#x60;&#x60;&#x60; You can also set or update description and title
     * properties: &#x60;&#x60;&#x60;JSON { \&quot;properties\&quot;: {
     * \&quot;cm:description\&quot;: \&quot;New Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;New Title\&quot; } } &#x60;&#x60;&#x60;
     * **Note:** Currently there is no optimistic locking for updates, so they
     * are applied in \&quot;last one wins\&quot; order.
     *
     * @param transferContainerId The identifier of a transfer container. You
     *            can also use the -transfers- alias. (required)
     * @param nodeBodyUpdate The node information to update. (required)
     * @return TransferContainerEntry
     */
    @Headers({ "Content-type: application/json" })
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/transfer-containers/{transferContainerId}")
    Observable<TransferContainerRepresentation> updateTransferContainerObservable(
            @Path("transferContainerId") String transferContainerId, @Body NodeBodyUpdate nodeBodyUpdate);

    /**
     * Update transfer container Updates the transfer container
     * **transferContainerId**. For example, you can rename transfer container:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My new name\&quot; }
     * &#x60;&#x60;&#x60; You can also set or update description and title
     * properties: &#x60;&#x60;&#x60;JSON { \&quot;properties\&quot;: {
     * \&quot;cm:description\&quot;: \&quot;New Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;New Title\&quot; } } &#x60;&#x60;&#x60;
     * **Note:** Currently there is no optimistic locking for updates, so they
     * are applied in \&quot;last one wins\&quot; order.
     *
     * @param transferContainerId The identifier of a transfer container. You
     *            can also use the -transfers- alias. (required)
     * @param nodeBodyUpdate The node information to update. (required)
     * @param include Returns additional information about the transfer
     *            container. Any optional field from the response model can be
     *            requested. For example: * allowableOperations * path
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return TransferContainerEntry
     */
    @Headers({ "Content-type: application/json" })
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/transfer-containers/{transferContainerId}")
    Observable<TransferContainerRepresentation> updateTransferContainerObservable(
            @Path("transferContainerId") String transferContainerId, @Body NodeBodyUpdate nodeBodyUpdate,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // LIST CHILDREN
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List transfer container&#39;s children Returns a list of transfers.
     * Minimal information for each child is returned by default. You can use
     * the **include** parameter to return additional information. You can use
     * the **include** parameter (include&#x3D;association) to return child
     * association details for each child, including the **assocType** and the
     * **isPrimary** flag.
     *
     * @param transferContainerId The identifier of a transfer container. You
     *            can also use the -transfers- alias. (required)
     * @return TransferContainerAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/transfer-containers/{transferContainerId}/children")
    Observable<ResultPaging<TransferRepresentation>> listTransfersObservable(
            @Path("transferContainerId") String transferContainerId);

    /**
     * List transfer container&#39;s children Returns a list of transfers.
     * Minimal information for each child is returned by default. You can use
     * the **include** parameter to return additional information. You can use
     * the **include** parameter (include&#x3D;association) to return child
     * association details for each child, including the **assocType** and the
     * **isPrimary** flag.
     *
     * @param transferContainerId The identifier of a transfer container. You
     *            can also use the -transfers- alias. (required)
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
     * @param include Returns additional information about the transfer folder.
     *            Any optional field from the response model can be requested.
     *            For example: * transferPDFIndicator * transferLocation *
     *            transferAccessionIndicator * properties * aspectNames *
     *            allowableOperations (optional)
     * @param includeSource Also include **source** in addition to **entries**
     *            with folder information on the specified parent
     *            **transferContainerId**. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return TransferContainerAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/transfer-containers/{transferContainerId}/children")
    Observable<ResultPaging<TransferRepresentation>> listTransfersObservable(
            @Path("transferContainerId") String transferContainerId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.INCLUDE_SOURCE_VALUE) Boolean includeSource,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

}
