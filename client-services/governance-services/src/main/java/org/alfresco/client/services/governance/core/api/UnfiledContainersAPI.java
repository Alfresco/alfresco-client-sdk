package org.alfresco.client.services.governance.core.api;

import static org.alfresco.client.services.common.constant.ApiConstant.*;

import org.alfresco.client.services.common.model.parameters.FieldsParam;
import org.alfresco.client.services.common.model.parameters.IncludeParam;
import org.alfresco.client.services.common.model.parameters.OrderByParam;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.governance.core.GovernanceConstant;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyCreate;
import org.alfresco.client.services.governance.core.model.body.UnfiledContainerBodyUpdate;
import org.alfresco.client.services.governance.core.model.body.UnfiledRecordFolderBodyUpdate;
import org.alfresco.client.services.governance.core.model.representation.RMNodeRepresentation;
import org.alfresco.client.services.governance.core.model.representation.UnfiledContainerRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface UnfiledContainersAPI
{
    String DEFAULT_UNFILED = "-unfiled-";

    // ///////////////////////////////////////////////////////////////////////////
    // GET
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get the unfiled records container Get information for unfiled records
     * contianer **unfiledContainerId** Besides mandatory fields the unfiled
     * records container&#39;s aspects and properties are returned by default.
     * 
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @return UnfiledContainerEntry
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}")
    Call<UnfiledContainerRepresentation> getUnfiledContainerCall(@Path(UNFILED_CONTAINER_ID) String unfiledContainerId);

    /**
     * Get the unfiled records container Get information for unfiled records
     * contianer **unfiledContainerId** Besides mandatory fields the unfiled
     * records container&#39;s aspects and properties are returned by default.
     * 
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @param include Returns additional information about the unfiled records
     *            container children. Any optional field from the response model
     *            can be requested. For example: * allowableOperations * path
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return UnfiledContainerEntry
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}")
    Call<UnfiledContainerRepresentation> getUnfiledContainerCall(@Path(UNFILED_CONTAINER_ID) String unfiledContainerId,
            @Query(INCLUDE) IncludeParam include, @Query(RELATIVE_PATH) String relativePath,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update an unfiled record container Updates unfiled record container
     * **unfiledContainerId**. For example, you can rename an unfiled record
     * container: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My new
     * name\&quot; } &#x60;&#x60;&#x60; You can also set or update description
     * and title properties: &#x60;&#x60;&#x60;JSON { \&quot;properties\&quot;:
     * { \&quot;cm:description\&quot;: \&quot;New Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;New Title\&quot; } } &#x60;&#x60;&#x60;
     * **Note:** Currently there is no optimistic locking for updates, so they
     * are applied in \&quot;last one wins\&quot; order.
     * 
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @param unfiledContainerBodyUpdate The unfiled record container
     *            information to update. (required)
     * @return UnfiledContainerRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}")
    Call<UnfiledContainerRepresentation> updateUnfiledContainerCall(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId,
            @Body UnfiledContainerBodyUpdate unfiledContainerBodyUpdate);

    /**
     * Update an unfiled record container Updates unfiled record container
     * **unfiledContainerId**. For example, you can rename an unfiled record
     * container: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My new
     * name\&quot; } &#x60;&#x60;&#x60; You can also set or update description
     * and title properties: &#x60;&#x60;&#x60;JSON { \&quot;properties\&quot;:
     * { \&quot;cm:description\&quot;: \&quot;New Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;New Title\&quot; } } &#x60;&#x60;&#x60;
     * **Note:** Currently there is no optimistic locking for updates, so they
     * are applied in \&quot;last one wins\&quot; order.
     * 
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @param unfiledContainerBodyUpdate The unfiled record container
     *            information to update. (required)
     * @param include Returns additional information about the unfiled records
     *            container children. Any optional field from the response model
     *            can be requested. For example: * allowableOperations * path
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return UnfiledContainerRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}")
    Call<UnfiledContainerRepresentation> updateUnfiledContainerCall(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId,
            @Body UnfiledRecordFolderBodyUpdate unfiledContainerBodyUpdate,
            @Query(INCLUDE) IncludeParam include, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CHILDREN LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List unfiled record container&#39;s children Returns a list of records or
     * unfiled record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information.
     * 
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @return UnfiledContainerAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}/children")
    Call<ResultPaging<RMNodeRepresentation>> listUnfiledContainerChildrenCall(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId);

    /**
     * List unfiled record container&#39;s children Returns a list of records or
     * unfiled record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information.
     * 
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
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
     * @return UnfiledContainerAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}/children")
    Call<ResultPaging<RMNodeRepresentation>> listUnfiledContainerChildrenCall(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId, @Query(SKIP_COUNT) Integer skipCount,
            @Query(MAX_ITEMS) Integer maxItems, @Query(ORDER_BY) OrderByParam orderBy);

    /**
     * List unfiled record container&#39;s children Returns a list of records or
     * unfiled record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information.
     * 
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
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
     * @param where Optionally filter the list. Here are some examples: *
     *            &#x60;&#x60;&#x60;where&#x3D;(isRecord&#x3D;true)&#x60;&#x60;&
     *            #x60; *
     *            &#x60;&#x60;&#x60;where&#x3D;(isUnfiledRecordFolder&#x3D;false
     *            )&#x60;&#x60;&#x60; *
     *            &#x60;&#x60;&#x60;where&#x3D;(nodeType&#x3D;&#39;cm:content
     *            INCLUDESUBTYPES&#39;)&#x60;&#x60;&#x60; (optional)
     * @param include Returns additional information about the unfiled records
     *            container children. Any optional field from the response model
     *            can be requested. For example: * allowableOperations * path
     *            (optional)
     * @param includeSource Also include **source** in addition to **entries**
     *            with folder information on the parent node � the specified
     *            parent **unfiledContainerId** (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return UnfiledContainerAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}/children")
    Call<ResultPaging<RMNodeRepresentation>> listUnfiledContainerChildrenCall(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId, @Query(SKIP_COUNT) Integer skipCount,
            @Query(MAX_ITEMS) Integer maxItems, @Query(ORDER_BY) OrderByParam orderBy, @Query(WHERE) String where,
            @Query(INCLUDE) IncludeParam include, @Query(RELATIVE_PATH) String relativePath,
            @Query(INCLUDE_SOURCE) Boolean includeSource, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CHILDREN CREATION
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create a record or an unfiled record folder Create a record or an unfiled
     * record folder as a primary child of **unfiledContainerId**. You can set
     * the **autoRename** boolean field to automatically resolve name clashes.
     * If there is a name clash, then the API method tries to create a unique
     * name using an integer suffix. This endpoint supports both JSON and
     * multipart/form-data (file upload). **Using multipart/form-data** Use the
     * **filedata** field to represent the content to upload, for example, the
     * following curl command will create a node with the contents of test.txt
     * in the test user&#39;s home folder. &#x60;&#x60;&#x60;curl -utest:test -X
     * POST
     * host:port/alfresco/api/-default-/public/gs/versions/1/unfiled-containers/
     * {unfiledContainerId}/children -F
     * filedata&#x3D;@test.txt&#x60;&#x60;&#x60; This API method also supports
     * record and unfiled record folder creation using application/json. You
     * must specify at least a **name** and **nodeType**. You can create a
     * non-electronic record like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Non-electronic Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:nonElectronicDocument\&quot;,
     * \&quot;properties\&quot;: { \&quot;cm:description\&quot;:\&quot;My
     * Non-electronic Record Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;My Non-electronic Record Title\&quot;,
     * \&quot;rma:box\&quot;:\&quot;My Non-electronic Record Box\&quot;,
     * \&quot;rma:file\&quot;:\&quot;My Non-electronic Record File\&quot;,
     * \&quot;rma:numberOfCopies\&quot;:1, \&quot;rma:physicalSize\&quot;:30,
     * \&quot;rma:shelf\&quot;:\&quot;My Non-electronic Record Shelf\&quot;,
     * \&quot;rma:storageLocation\&quot;:\&quot;My Non-electronic Record
     * Location\&quot; } } &#x60;&#x60;&#x60; You can create an empty electronic
     * record: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Electronic
     * Record\&quot;, \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }
     * &#x60;&#x60;&#x60; You can create an unfiled record folder like this:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;: \&quot;My Unfiled Record
     * Folder\&quot;, \&quot;nodeType\&quot;:
     * \&quot;rma:unfiledRecordFolder\&quot;, \&quot;properties\&quot;: {
     * \&quot;cm:title\&quot;: \&quot;My Unfiled Record Folder Title\&quot; } }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record and an unfiled record folder inside the specified
     * **unfiledContainerId**: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;name\&quot;:\&quot;My Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }, {
     * \&quot;name\&quot;:\&quot;My Unfiled Record Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:unfiledRecordFolder\&quot; } ]
     * &#x60;&#x60;&#x60; If you specify a list as input, then a paginated list
     * rather than an entry is returned in the response body. For example:
     * &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: { \&quot;pagination\&quot;:
     * { \&quot;count\&quot;: 2, \&quot;hasMoreItems\&quot;: false,
     * \&quot;totalItems\&quot;: 2, \&quot;skipCount\&quot;: 0,
     * \&quot;maxItems\&quot;: 100 }, \&quot;entries\&quot;: [ {
     * \&quot;entry\&quot;: { ... } }, { \&quot;entry\&quot;: { ... } } ] } }
     * &#x60;&#x60;&#x60;
     * 
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @param nodeBodyCreate The node information to create. (required)
     * @return RMNodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}/children")
    Call<RMNodeRepresentation> createUnfiledContainerChildrenCall(@Path(UNFILED_CONTAINER_ID) String unfiledContainerId,
            @Body RMNodeBodyCreate nodeBodyCreate);

    /**
     * Create a record or an unfiled record folder Create a record or an unfiled
     * record folder as a primary child of **unfiledContainerId**. You can set
     * the **autoRename** boolean field to automatically resolve name clashes.
     * If there is a name clash, then the API method tries to create a unique
     * name using an integer suffix. This endpoint supports both JSON and
     * multipart/form-data (file upload). **Using multipart/form-data** Use the
     * **filedata** field to represent the content to upload, for example, the
     * following curl command will create a node with the contents of test.txt
     * in the test user&#39;s home folder. &#x60;&#x60;&#x60;curl -utest:test -X
     * POST
     * host:port/alfresco/api/-default-/public/gs/versions/1/unfiled-containers/
     * {unfiledContainerId}/children -F
     * filedata&#x3D;@test.txt&#x60;&#x60;&#x60; This API method also supports
     * record and unfiled record folder creation using application/json. You
     * must specify at least a **name** and **nodeType**. You can create a
     * non-electronic record like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Non-electronic Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:nonElectronicDocument\&quot;,
     * \&quot;properties\&quot;: { \&quot;cm:description\&quot;:\&quot;My
     * Non-electronic Record Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;My Non-electronic Record Title\&quot;,
     * \&quot;rma:box\&quot;:\&quot;My Non-electronic Record Box\&quot;,
     * \&quot;rma:file\&quot;:\&quot;My Non-electronic Record File\&quot;,
     * \&quot;rma:numberOfCopies\&quot;:1, \&quot;rma:physicalSize\&quot;:30,
     * \&quot;rma:shelf\&quot;:\&quot;My Non-electronic Record Shelf\&quot;,
     * \&quot;rma:storageLocation\&quot;:\&quot;My Non-electronic Record
     * Location\&quot; } } &#x60;&#x60;&#x60; You can create an empty electronic
     * record: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Electronic
     * Record\&quot;, \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }
     * &#x60;&#x60;&#x60; You can create an unfiled record folder like this:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;: \&quot;My Unfiled Record
     * Folder\&quot;, \&quot;nodeType\&quot;:
     * \&quot;rma:unfiledRecordFolder\&quot;, \&quot;properties\&quot;: {
     * \&quot;cm:title\&quot;: \&quot;My Unfiled Record Folder Title\&quot; } }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record and an unfiled record folder inside the specified
     * **unfiledContainerId**: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;name\&quot;:\&quot;My Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }, {
     * \&quot;name\&quot;:\&quot;My Unfiled Record Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:unfiledRecordFolder\&quot; } ]
     * &#x60;&#x60;&#x60; If you specify a list as input, then a paginated list
     * rather than an entry is returned in the response body. For example:
     * &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: { \&quot;pagination\&quot;:
     * { \&quot;count\&quot;: 2, \&quot;hasMoreItems\&quot;: false,
     * \&quot;totalItems\&quot;: 2, \&quot;skipCount\&quot;: 0,
     * \&quot;maxItems\&quot;: 100 }, \&quot;entries\&quot;: [ {
     * \&quot;entry\&quot;: { ... } }, { \&quot;entry\&quot;: { ... } } ] } }
     * &#x60;&#x60;&#x60;
     *
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @param nodeBodyCreate The node information to create. (required)
     * @param autoRename If true, then a name clash will cause an attempt to
     *            auto rename by finding a unique name using an integer suffix.
     *            (optional)
     * @param include Returns additional information about the unfiled records
     *            container children. Any optional field from the response model
     *            can be requested. For example: * allowableOperations * path
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return UnfiledContainerAssociationPaging
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}/children")
    Call<RMNodeRepresentation> createUnfiledContainerChildrenCall(@Path(UNFILED_CONTAINER_ID) String unfiledContainerId,
            @Body RMNodeBodyCreate nodeBodyCreate, @Query(AUTO_RENAME) boolean autoRename,
            @Query(INCLUDE) IncludeParam include, @Query(FIELDS) FieldsParam fields);

    // FIXME Support batch creation

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
     * Get the unfiled records container Get information for unfiled records
     * contianer **unfiledContainerId** Besides mandatory fields the unfiled
     * records container&#39;s aspects and properties are returned by default.
     *
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @return UnfiledContainerEntry
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}")
    Observable<UnfiledContainerRepresentation> getUnfiledContainerObservable(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId);

    /**
     * Get the unfiled records container Get information for unfiled records
     * contianer **unfiledContainerId** Besides mandatory fields the unfiled
     * records container&#39;s aspects and properties are returned by default.
     *
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @param include Returns additional information about the unfiled records
     *            container children. Any optional field from the response model
     *            can be requested. For example: * allowableOperations * path
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return UnfiledContainerEntry
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}")
    Observable<UnfiledContainerRepresentation> getUnfiledContainerObservable(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId, @Query(INCLUDE) IncludeParam include,
            @Query(RELATIVE_PATH) String relativePath, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update an unfiled record container Updates unfiled record container
     * **unfiledContainerId**. For example, you can rename an unfiled record
     * container: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My new
     * name\&quot; } &#x60;&#x60;&#x60; You can also set or update description
     * and title properties: &#x60;&#x60;&#x60;JSON { \&quot;properties\&quot;:
     * { \&quot;cm:description\&quot;: \&quot;New Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;New Title\&quot; } } &#x60;&#x60;&#x60;
     * **Note:** Currently there is no optimistic locking for updates, so they
     * are applied in \&quot;last one wins\&quot; order.
     *
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @param unfiledContainerBodyUpdate The unfiled record container
     *            information to update. (required)
     * @return UnfiledContainerRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}")
    Observable<UnfiledContainerRepresentation> updateUnfiledContainerObservable(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId,
            @Body UnfiledContainerBodyUpdate unfiledContainerBodyUpdate);

    /**
     * Update an unfiled record container Updates unfiled record container
     * **unfiledContainerId**. For example, you can rename an unfiled record
     * container: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My new
     * name\&quot; } &#x60;&#x60;&#x60; You can also set or update description
     * and title properties: &#x60;&#x60;&#x60;JSON { \&quot;properties\&quot;:
     * { \&quot;cm:description\&quot;: \&quot;New Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;New Title\&quot; } } &#x60;&#x60;&#x60;
     * **Note:** Currently there is no optimistic locking for updates, so they
     * are applied in \&quot;last one wins\&quot; order.
     *
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @param unfiledContainerBodyUpdate The unfiled record container
     *            information to update. (required)
     * @param include Returns additional information about the unfiled records
     *            container children. Any optional field from the response model
     *            can be requested. For example: * allowableOperations * path
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return UnfiledContainerRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}")
    Observable<UnfiledContainerRepresentation> updateUnfiledContainerObservable(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId,
            @Body UnfiledRecordFolderBodyUpdate unfiledContainerBodyUpdate,
            @Query(INCLUDE) IncludeParam include, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CHILDREN LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List unfiled record container&#39;s children Returns a list of records or
     * unfiled record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information.
     *
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @return UnfiledContainerAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}/children")
    Observable<ResultPaging<RMNodeRepresentation>> listUnfiledContainerChildrenObservable(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId);

    /**
     * List unfiled record container&#39;s children Returns a list of records or
     * unfiled record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information.
     *
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
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
     * @return UnfiledContainerAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}/children")
    Observable<ResultPaging<RMNodeRepresentation>> listUnfiledContainerChildrenObservable(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId, @Query(SKIP_COUNT) Integer skipCount,
            @Query(MAX_ITEMS) Integer maxItems, @Query(ORDER_BY) OrderByParam orderBy);

    /**
     * List unfiled record container&#39;s children Returns a list of records or
     * unfiled record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information.
     *
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
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
     * @param where Optionally filter the list. Here are some examples: *
     *            &#x60;&#x60;&#x60;where&#x3D;(isRecord&#x3D;true)&#x60;&#x60;&
     *            #x60; *
     *            &#x60;&#x60;&#x60;where&#x3D;(isUnfiledRecordFolder&#x3D;false
     *            )&#x60;&#x60;&#x60; *
     *            &#x60;&#x60;&#x60;where&#x3D;(nodeType&#x3D;&#39;cm:content
     *            INCLUDESUBTYPES&#39;)&#x60;&#x60;&#x60; (optional)
     * @param include Returns additional information about the unfiled records
     *            container children. Any optional field from the response model
     *            can be requested. For example: * allowableOperations * path
     *            (optional)
     * @param includeSource Also include **source** in addition to **entries**
     *            with folder information on the parent node � the specified
     *            parent **unfiledContainerId** (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return UnfiledContainerAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}/children")
    Observable<ResultPaging<RMNodeRepresentation>> listUnfiledContainerChildrenObservable(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId, @Query(SKIP_COUNT) Integer skipCount,
            @Query(MAX_ITEMS) Integer maxItems, @Query(ORDER_BY) OrderByParam orderBy, @Query(WHERE) String where,
            @Query(INCLUDE) IncludeParam include, @Query(RELATIVE_PATH) String relativePath,
            @Query(INCLUDE_SOURCE) Boolean includeSource, @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CHILDREN CREATION
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create a record or an unfiled record folder Create a record or an unfiled
     * record folder as a primary child of **unfiledContainerId**. You can set
     * the **autoRename** boolean field to automatically resolve name clashes.
     * If there is a name clash, then the API method tries to create a unique
     * name using an integer suffix. This endpoint supports both JSON and
     * multipart/form-data (file upload). **Using multipart/form-data** Use the
     * **filedata** field to represent the content to upload, for example, the
     * following curl command will create a node with the contents of test.txt
     * in the test user&#39;s home folder. &#x60;&#x60;&#x60;curl -utest:test -X
     * POST
     * host:port/alfresco/api/-default-/public/gs/versions/1/unfiled-containers/
     * {unfiledContainerId}/children -F
     * filedata&#x3D;@test.txt&#x60;&#x60;&#x60; This API method also supports
     * record and unfiled record folder creation using application/json. You
     * must specify at least a **name** and **nodeType**. You can create a
     * non-electronic record like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Non-electronic Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:nonElectronicDocument\&quot;,
     * \&quot;properties\&quot;: { \&quot;cm:description\&quot;:\&quot;My
     * Non-electronic Record Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;My Non-electronic Record Title\&quot;,
     * \&quot;rma:box\&quot;:\&quot;My Non-electronic Record Box\&quot;,
     * \&quot;rma:file\&quot;:\&quot;My Non-electronic Record File\&quot;,
     * \&quot;rma:numberOfCopies\&quot;:1, \&quot;rma:physicalSize\&quot;:30,
     * \&quot;rma:shelf\&quot;:\&quot;My Non-electronic Record Shelf\&quot;,
     * \&quot;rma:storageLocation\&quot;:\&quot;My Non-electronic Record
     * Location\&quot; } } &#x60;&#x60;&#x60; You can create an empty electronic
     * record: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Electronic
     * Record\&quot;, \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }
     * &#x60;&#x60;&#x60; You can create an unfiled record folder like this:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;: \&quot;My Unfiled Record
     * Folder\&quot;, \&quot;nodeType\&quot;:
     * \&quot;rma:unfiledRecordFolder\&quot;, \&quot;properties\&quot;: {
     * \&quot;cm:title\&quot;: \&quot;My Unfiled Record Folder Title\&quot; } }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record and an unfiled record folder inside the specified
     * **unfiledContainerId**: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;name\&quot;:\&quot;My Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }, {
     * \&quot;name\&quot;:\&quot;My Unfiled Record Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:unfiledRecordFolder\&quot; } ]
     * &#x60;&#x60;&#x60; If you specify a list as input, then a paginated list
     * rather than an entry is returned in the response body. For example:
     * &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: { \&quot;pagination\&quot;:
     * { \&quot;count\&quot;: 2, \&quot;hasMoreItems\&quot;: false,
     * \&quot;totalItems\&quot;: 2, \&quot;skipCount\&quot;: 0,
     * \&quot;maxItems\&quot;: 100 }, \&quot;entries\&quot;: [ {
     * \&quot;entry\&quot;: { ... } }, { \&quot;entry\&quot;: { ... } } ] } }
     * &#x60;&#x60;&#x60;
     *
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @param nodeBodyCreate The node information to create. (required)
     * @return RMNodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}/children")
    Observable<RMNodeRepresentation> createUnfiledContainerChildrenObservable(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId, @Body RMNodeBodyCreate nodeBodyCreate);

    /**
     * Create a record or an unfiled record folder Create a record or an unfiled
     * record folder as a primary child of **unfiledContainerId**. You can set
     * the **autoRename** boolean field to automatically resolve name clashes.
     * If there is a name clash, then the API method tries to create a unique
     * name using an integer suffix. This endpoint supports both JSON and
     * multipart/form-data (file upload). **Using multipart/form-data** Use the
     * **filedata** field to represent the content to upload, for example, the
     * following curl command will create a node with the contents of test.txt
     * in the test user&#39;s home folder. &#x60;&#x60;&#x60;curl -utest:test -X
     * POST
     * host:port/alfresco/api/-default-/public/gs/versions/1/unfiled-containers/
     * {unfiledContainerId}/children -F
     * filedata&#x3D;@test.txt&#x60;&#x60;&#x60; This API method also supports
     * record and unfiled record folder creation using application/json. You
     * must specify at least a **name** and **nodeType**. You can create a
     * non-electronic record like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Non-electronic Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:nonElectronicDocument\&quot;,
     * \&quot;properties\&quot;: { \&quot;cm:description\&quot;:\&quot;My
     * Non-electronic Record Description\&quot;,
     * \&quot;cm:title\&quot;:\&quot;My Non-electronic Record Title\&quot;,
     * \&quot;rma:box\&quot;:\&quot;My Non-electronic Record Box\&quot;,
     * \&quot;rma:file\&quot;:\&quot;My Non-electronic Record File\&quot;,
     * \&quot;rma:numberOfCopies\&quot;:1, \&quot;rma:physicalSize\&quot;:30,
     * \&quot;rma:shelf\&quot;:\&quot;My Non-electronic Record Shelf\&quot;,
     * \&quot;rma:storageLocation\&quot;:\&quot;My Non-electronic Record
     * Location\&quot; } } &#x60;&#x60;&#x60; You can create an empty electronic
     * record: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My Electronic
     * Record\&quot;, \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }
     * &#x60;&#x60;&#x60; You can create an unfiled record folder like this:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;: \&quot;My Unfiled Record
     * Folder\&quot;, \&quot;nodeType\&quot;:
     * \&quot;rma:unfiledRecordFolder\&quot;, \&quot;properties\&quot;: {
     * \&quot;cm:title\&quot;: \&quot;My Unfiled Record Folder Title\&quot; } }
     * &#x60;&#x60;&#x60; Any missing aspects are applied automatically. You can
     * set aspects explicitly, if needed, using an **aspectNames** field.
     * **Note:** You can create more than one child by specifying a list of
     * nodes in the JSON body. For example, the following JSON body creates a
     * record and an unfiled record folder inside the specified
     * **unfiledContainerId**: &#x60;&#x60;&#x60;JSON [ {
     * \&quot;name\&quot;:\&quot;My Record\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot; }, {
     * \&quot;name\&quot;:\&quot;My Unfiled Record Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;rma:unfiledRecordFolder\&quot; } ]
     * &#x60;&#x60;&#x60; If you specify a list as input, then a paginated list
     * rather than an entry is returned in the response body. For example:
     * &#x60;&#x60;&#x60;JSON { \&quot;list\&quot;: { \&quot;pagination\&quot;:
     * { \&quot;count\&quot;: 2, \&quot;hasMoreItems\&quot;: false,
     * \&quot;totalItems\&quot;: 2, \&quot;skipCount\&quot;: 0,
     * \&quot;maxItems\&quot;: 100 }, \&quot;entries\&quot;: [ {
     * \&quot;entry\&quot;: { ... } }, { \&quot;entry\&quot;: { ... } } ] } }
     * &#x60;&#x60;&#x60;
     *
     * @param unfiledContainerId The identifier of a unfiled records container.
     *            You can use the **-unfiled-** alias. (required)
     * @param nodeBodyCreate The node information to create. (required)
     * @param autoRename If true, then a name clash will cause an attempt to
     *            auto rename by finding a unique name using an integer suffix.
     *            (optional)
     * @param include Returns additional information about the unfiled records
     *            container children. Any optional field from the response model
     *            can be requested. For example: * allowableOperations * path
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return UnfiledContainerAssociationPaging
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-containers/{unfiledContainerId}/children")
    Observable<RMNodeRepresentation> createUnfiledContainerChildrenObservable(
            @Path(UNFILED_CONTAINER_ID) String unfiledContainerId, @Body RMNodeBodyCreate nodeBodyCreate,
            @Query(AUTO_RENAME) boolean autoRename, @Query(INCLUDE) IncludeParam include,
            @Query(FIELDS) FieldsParam fields);

    // FIXME Support batch creation
}
