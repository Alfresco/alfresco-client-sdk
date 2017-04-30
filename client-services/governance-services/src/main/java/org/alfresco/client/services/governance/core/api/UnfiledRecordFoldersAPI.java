package org.alfresco.client.services.governance.core.api;

import org.alfresco.client.services.common.constant.PublicAPIConstant;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.core.model.parameters.FieldsParam;
import org.alfresco.client.services.content.core.model.parameters.IncludeParam;
import org.alfresco.client.services.content.core.model.parameters.OrderByParam;
import org.alfresco.client.services.governance.core.GovernanceConstant;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyCreate;
import org.alfresco.client.services.governance.core.model.body.RMNodeBodyUpdate;
import org.alfresco.client.services.governance.core.model.representation.RMNodeRepresentation;
import org.alfresco.client.services.governance.core.model.representation.UnfiledRecordFolderRepresentation;

import retrofit2.Call;
import retrofit2.http.*;

public interface UnfiledRecordFoldersAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // GET
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get the unfiled record folder Get information for unfiled record folder
     * id **unfiledRecordFolderId** Besides mandatory fields the unfiled record
     * folder&#39;s aspects and properties are returned by default.
     * 
     * @param unfiledRecordFolderId The identifier of a unfiled record folder.
     *            (required)
     * @return UnfiledRecordFolderRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-record-folders/{unfiledRecordFolderId}")
    Call<UnfiledRecordFolderRepresentation> getUnfiledRecordFolderCall(
            @Path("unfiledRecordFolderId") String unfiledRecordFolderId);

    /**
     * Get the unfiled record folder Get information for unfiled record folder
     * id **unfiledRecordFolderId** Besides mandatory fields the unfiled record
     * folder&#39;s aspects and properties are returned by default.
     * 
     * @param unfiledRecordFolderId The identifier of a unfiled record folder.
     *            (required)
     * @param include Returns additional information about the unfiled records
     *            container children. Any optional field from the response model
     *            can be requested. For example: * allowableOperations * path
     *            (optional)
     * @param relativePath Return information on children in the unfiled records
     *            container resolved by this path. The path is relative to
     *            **unfiledRecordFolderId**. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return UnfiledRecordFolderRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-record-folders/{unfiledRecordFolderId}")
    Call<UnfiledRecordFolderRepresentation> getUnfiledRecordFolderCall(
            @Path("unfiledRecordFolderId") String unfiledRecordFolderId,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.RELATIVE_PATH_VALUE) String relativePath,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update an unfiled record folder Updates unfiled record folder
     * **unfiledRecordFolderId**. For example, you can rename a record folder:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My new name\&quot; }
     * &#x60;&#x60;&#x60; You can also set or update one or more properties:
     * &#x60;&#x60;&#x60;JSON { \&quot;properties\&quot;: {
     * \&quot;cm:title\&quot;:\&quot;New title\&quot;,
     * \&quot;cm:description\&quot;:\&quot;New description\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** if you want to add or remove aspects, then
     * you must use **GET /unfiled-record-folders/{unfiledRecordFolderId}**
     * first to get the complete set of *aspectNames*. **Note:** Currently there
     * is no optimistic locking for updates, so they are applied in \&quot;last
     * one wins\&quot; order.
     * 
     * @param unfiledRecordFolderId The identifier of a unfiled record folder.
     *            (required)
     * @param unfiledRecordFolderBodyUpdate The record folder information to
     *            update. (required)
     * @return UnfiledRecordFolderEntry
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-record-folders/{unfiledRecordFolderId}")
    Call<UnfiledRecordFolderRepresentation> updateUnfiledRecordFolderCall(
            @Path("unfiledRecordFolderId") String unfiledRecordFolderId,
            @Body RMNodeBodyUpdate unfiledRecordFolderBodyUpdate);

    /**
     * Update an unfiled record folder Updates unfiled record folder
     * **unfiledRecordFolderId**. For example, you can rename a record folder:
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My new name\&quot; }
     * &#x60;&#x60;&#x60; You can also set or update one or more properties:
     * &#x60;&#x60;&#x60;JSON { \&quot;properties\&quot;: {
     * \&quot;cm:title\&quot;:\&quot;New title\&quot;,
     * \&quot;cm:description\&quot;:\&quot;New description\&quot; } }
     * &#x60;&#x60;&#x60; **Note:** if you want to add or remove aspects, then
     * you must use **GET /unfiled-record-folders/{unfiledRecordFolderId}**
     * first to get the complete set of *aspectNames*. **Note:** Currently there
     * is no optimistic locking for updates, so they are applied in \&quot;last
     * one wins\&quot; order.
     *
     * @param unfiledRecordFolderId The identifier of a unfiled record folder.
     *            (required)
     * @param unfiledRecordFolderBodyUpdate The record folder information to
     *            update. (required)
     * @param includeSource Also include **source** in addition to **entries**
     *            with folder information on the parent node � either the
     *            specified parent **unfiledRecordFolderId**, or as resolved by
     *            **relativePath**. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return UnfiledRecordFolderEntry
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-record-folders/{unfiledRecordFolderId}")
    Call<UnfiledRecordFolderRepresentation> updateUnfiledRecordFolderCall(
            @Path("unfiledRecordFolderId") String unfiledRecordFolderId,
            @Body RMNodeBodyUpdate unfiledRecordFolderBodyUpdate,
            @Query(PublicAPIConstant.INCLUDE_SOURCE_VALUE) Boolean includeSource,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete an unfiled record folder Deletes unfiled record folder
     * **unfiledRecordFolderId**.
     * 
     * @param unfiledRecordFolderId The identifier of a unfiled record folder.
     *            (required)
     */
    @DELETE(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-record-folders/{unfiledRecordFolderId}")
    Call<Void> deleteUnfiledRecordFolderCall(@Path("unfiledRecordFolderId") String unfiledRecordFolderId);

    // ///////////////////////////////////////////////////////////////////////////
    // CHILDREN LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List unfiled record folder&#39;s children Returns a list of records or
     * unfiled record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information.
     *
     * @param unfiledRecordFolderId The identifier of a unfiled record folder.
     *            (required)
     * @return UnfiledRecordFolderAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-record-folders/{unfiledRecordFolderId}/children")
    Call<ResultPaging<RMNodeRepresentation>> listUnfiledRecordFolderChildrenCall(
            @Path("unfiledRecordFolderId") String unfiledRecordFolderId);

    /**
     * List unfiled record folder&#39;s children Returns a list of records or
     * unfiled record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information.
     *
     * @param unfiledRecordFolderId The identifier of a unfiled record folder.
     *            (required)
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
     * @return UnfiledRecordFolderAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-record-folders/{unfiledRecordFolderId}/children")
    Call<ResultPaging<RMNodeRepresentation>> listUnfiledRecordFolderChildrenCall(
            @Path("unfiledRecordFolderId") String unfiledRecordFolderId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy);

    /**
     * List unfiled record folder&#39;s children Returns a list of records or
     * unfiled record folders. Minimal information for each child is returned by
     * default. You can use the **include** parameter to return additional
     * information.
     * 
     * @param unfiledRecordFolderId The identifier of a unfiled record folder.
     *            (required)
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
     * @param relativePath Return information on children in the unfiled records
     *            container resolved by this path. The path is relative to
     *            **unfiledRecordFolderId**. (optional)
     * @param includeSource Also include **source** in addition to **entries**
     *            with folder information on the parent node � either the
     *            specified parent **unfiledRecordFolderId**, or as resolved by
     *            **relativePath**. (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return UnfiledRecordFolderAssociationPaging
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-record-folders/{unfiledRecordFolderId}/children")
    Call<ResultPaging<RMNodeRepresentation>> listUnfiledRecordFolderChildrenCall(
            @Path("unfiledRecordFolderId") String unfiledRecordFolderId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.RELATIVE_PATH_VALUE) String relativePath,
            @Query(PublicAPIConstant.INCLUDE_SOURCE_VALUE) Boolean includeSource,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CHILDREN CREATION
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create a record or an unfiled record folder Create a record or an unfiled
     * record folder as a primary child of **unfiledRecordFolderId**. You can
     * set the **autoRename** boolean field to automatically resolve name
     * clashes. If there is a name clash, then the API method tries to create a
     * unique name using an integer suffix. This endpoint supports both JSON and
     * multipart/form-data (file upload). **Using multipart/form-data** Use the
     * **filedata** field to represent the content to upload, for example, the
     * following curl command will create a node with the contents of test.txt
     * in the test user&#39;s home folder. &#x60;&#x60;&#x60;curl -utest:test -X
     * POST
     * host:port/alfresco/api/-default-/public/gs/versions/1/unfiled-record-
     * folders/{unfiledRecordFolderId}/children -F
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
     * **unfiledRecordFolderId**: &#x60;&#x60;&#x60;JSON [ {
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
     * @param unfiledRecordFolderId The identifier of a unfiled record folder.
     *            (required)
     * @param nodeBodyCreate The node information to create. (required)
     * @return UnfiledRecordFolderAssociationPaging
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-record-folders/{unfiledRecordFolderId}/children")
    Call<RMNodeRepresentation> createUnfiledRecordFolderChildrenCall(
            @Path("unfiledRecordFolderId") String unfiledRecordFolderId, @Body RMNodeBodyCreate nodeBodyCreate);

    /**
     * Create a record or an unfiled record folder Create a record or an unfiled
     * record folder as a primary child of **unfiledRecordFolderId**. You can
     * set the **autoRename** boolean field to automatically resolve name
     * clashes. If there is a name clash, then the API method tries to create a
     * unique name using an integer suffix. This endpoint supports both JSON and
     * multipart/form-data (file upload). **Using multipart/form-data** Use the
     * **filedata** field to represent the content to upload, for example, the
     * following curl command will create a node with the contents of test.txt
     * in the test user&#39;s home folder. &#x60;&#x60;&#x60;curl -utest:test -X
     * POST
     * host:port/alfresco/api/-default-/public/gs/versions/1/unfiled-record-
     * folders/{unfiledRecordFolderId}/children -F
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
     * **unfiledRecordFolderId**: &#x60;&#x60;&#x60;JSON [ {
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
     * @param unfiledRecordFolderId The identifier of a unfiled record folder.
     *            (required)
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
     * @return UnfiledRecordFolderAssociationPaging
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/unfiled-record-folders/{unfiledRecordFolderId}/children")
    Call<RMNodeRepresentation> createUnfiledRecordFolderChildrenCall(
            @Path("unfiledRecordFolderId") String unfiledRecordFolderId, @Body RMNodeBodyCreate nodeBodyCreate,
            @Query(PublicAPIConstant.AUTO_RENAME_VALUE) boolean autoRename,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);
}
