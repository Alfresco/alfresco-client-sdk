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
import java.util.Map;

import com.alfresco.client.api.common.constant.PublicAPIConstant;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.model.body.*;
import com.alfresco.client.api.core.model.parameters.FieldsParam;
import com.alfresco.client.api.core.model.parameters.IncludeParam;
import com.alfresco.client.api.core.model.parameters.OrderByParam;
import com.alfresco.client.api.core.model.representation.AssociationRepresentation;
import com.alfresco.client.api.core.model.representation.ChildAssociationRepresentation;
import com.alfresco.client.api.core.model.representation.NodeRepresentation;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface NodesAPI
{
    String FOLDER_ROOT = "-root-";

    String FOLDER_MY = "-my-";

    String FOLDER_SHARED = "-shared-";

    // ///////////////////////////////////////////////////////////////////////////
    // INFO
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get a node Get information for the node with identifier **nodeId**.
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @return NodeRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Call<NodeRepresentation> getNodeCall(@Path("nodeId") String nodeId);

    /**
     * Get a node Get information for the node with identifier **nodeId**.
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @return NodeRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Observable<NodeRepresentation> getNodeObservable(@Path("nodeId") String nodeId);

    /**
     * Get a node Get information for the node with identifier **nodeId**.
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param relativePath If specified, returns information on the node
     *            resolved by this path. The path is relative to the specified
     *            **nodeId** (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Call<NodeRepresentation> getNodeCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.RELATIVE_PATH_VALUE) String relativePath,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Get a node Get information for the node with identifier **nodeId**.
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param relativePath If specified, returns information on the node
     *            resolved by this path. The path is relative to the specified
     *            **nodeId** (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Observable<NodeRepresentation> getNodeObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.RELATIVE_PATH_VALUE) String relativePath,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get node children Returns the children of the parent node with identifier
     * **nodeId**. Minimal information for each child is returned by default.
     * You can use the **include** parameter to return addtional information.
     * The list of child nodes includes primary children and also secondary
     * children, if any. You can use the **include** parameter
     * (include&#x3D;association) to return child association details for each
     * child, including the assocType and the isPrimary flag.
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @return ResultPaging<NodeRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<ResultPaging<NodeRepresentation>> listNodeChildrenCall(@Path("nodeId") String nodeId);

    /**
     * Get node children Returns the children of the parent node with identifier
     * **nodeId**. Minimal information for each child is returned by default.
     * You can use the **include** parameter to return addtional information.
     * The list of child nodes includes primary children and also secondary
     * children, if any. You can use the **include** parameter
     * (include&#x3D;association) to return child association details for each
     * child, including the assocType and the isPrimary flag.
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @return ResultPaging<NodeRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<ResultPaging<NodeRepresentation>> listNodeChildrenObservable(@Path("nodeId") String nodeId);

    /**
     * Get node children Returns the children of the parent node with identifier
     * **nodeId**. Minimal information for each child is returned by default.
     * You can use the **include** parameter to return addtional information.
     * The list of child nodes includes primary children and also secondary
     * children, if any. You can use the **include** parameter
     * (include&#x3D;association) to return child association details for each
     * child, including the assocType and the isPrimary flag.
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param orderBy If not specified then default sort is for folders to be
     *            sorted before files, and by ascending name i.e.
     *            \&quot;orderBy&#x3D;isFolder DESC,name ASC\&quot;. This
     *            default can be completely overridden by specifying a specific
     *            orderBy consisting of one, two or three comma-separated list
     *            of properties (with optional ASCending or DESCending), for
     *            example, specifying “orderBy&#x3D;name DESC” would return a
     *            mixed folder/file list. The following properties can be used
     *            to order the results: * isFolder * name * mimeType * nodeType
     *            * sizeInBytes * modifiedAt * createdAt * modifiedByUser *
     *            createdByUser (optional)
     * @return ResultPaging<NodeRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<ResultPaging<NodeRepresentation>> listNodeChildrenCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy);

    /**
     * Get node children Returns the children of the parent node with identifier
     * **nodeId**. Minimal information for each child is returned by default.
     * You can use the **include** parameter to return addtional information.
     * The list of child nodes includes primary children and also secondary
     * children, if any. You can use the **include** parameter
     * (include&#x3D;association) to return child association details for each
     * child, including the assocType and the isPrimary flag.
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param orderBy If not specified then default sort is for folders to be
     *            sorted before files, and by ascending name i.e.
     *            \&quot;orderBy&#x3D;isFolder DESC,name ASC\&quot;. This
     *            default can be completely overridden by specifying a specific
     *            orderBy consisting of one, two or three comma-separated list
     *            of properties (with optional ASCending or DESCending), for
     *            example, specifying “orderBy&#x3D;name DESC” would return a
     *            mixed folder/file list. The following properties can be used
     *            to order the results: * isFolder * name * mimeType * nodeType
     *            * sizeInBytes * modifiedAt * createdAt * modifiedByUser *
     *            createdByUser (optional)
     * @return ResultPaging<NodeRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<ResultPaging<NodeRepresentation>> listNodeChildrenObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy);

    /**
     * Get node children Returns the children of the parent node with identifier
     * **nodeId**. Minimal information for each child is returned by default.
     * You can use the **include** parameter to return addtional information.
     * The list of child nodes includes primary children and also secondary
     * children, if any. You can use the **include** parameter
     * (include&#x3D;association) to return child association details for each
     * child, including the assocType and the isPrimary flag.
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param orderBy If not specified then default sort is for folders to be
     *            sorted before files, and by ascending name i.e.
     *            \&quot;orderBy&#x3D;isFolder DESC,name ASC\&quot;. This
     *            default can be completely overridden by specifying a specific
     *            orderBy consisting of one, two or three comma-separated list
     *            of properties (with optional ASCending or DESCending), for
     *            example, specifying “orderBy&#x3D;name DESC” would return a
     *            mixed folder/file list. The following properties can be used
     *            to order the results: * isFolder * name * mimeType * nodeType
     *            * sizeInBytes * modifiedAt * createdAt * modifiedByUser *
     *            createdByUser (optional)
     * @param where Optionally filter the list. Here are some examples: *
     *            where&#x3D;(isFolder&#x3D;true) *
     *            where&#x3D;(isFile&#x3D;true) *
     *            where&#x3D;(nodeType&#x3D;&#39;my:specialNodeType&#39;) *
     *            where&#x3D;(nodeType&#x3D;&#39;my:specialNodeType&#39;
     *            INCLUDESUBTYPES) * where&#x3D;(isPrimary&#x3D;true) *
     *            where&#x3D;(assocType&#x3D;&#39;my:specialAssocType&#39;)
     *            (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames * path * isLink * allowableOperations *
     *            association (optional)
     * @param relativePath Return information on children within the folder
     *            resolved by this path (relative to specified nodeId as the
     *            starting parent folder) (optional)
     * @param includeSource Also include \&quot;source\&quot; (in addition to
     *            \&quot;entries\&quot;) with folder information on parent node
     *            (either the specified parent \&quot;nodeId\&quot; or as
     *            resolved by \&quot;relativePath\&quot;) (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return ResultPaging<NodeRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<ResultPaging<NodeRepresentation>> listNodeChildrenCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.RELATIVE_PATH_VALUE) String relativePath,
            @Query(PublicAPIConstant.INCLUDE_SOURCE_VALUE) String includeSource,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Get node children Returns the children of the parent node with identifier
     * **nodeId**. Minimal information for each child is returned by default.
     * You can use the **include** parameter to return addtional information.
     * The list of child nodes includes primary children and also secondary
     * children, if any. You can use the **include** parameter
     * (include&#x3D;association) to return child association details for each
     * child, including the assocType and the isPrimary flag.
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @param orderBy If not specified then default sort is for folders to be
     *            sorted before files, and by ascending name i.e.
     *            \&quot;orderBy&#x3D;isFolder DESC,name ASC\&quot;. This
     *            default can be completely overridden by specifying a specific
     *            orderBy consisting of one, two or three comma-separated list
     *            of properties (with optional ASCending or DESCending), for
     *            example, specifying “orderBy&#x3D;name DESC” would return a
     *            mixed folder/file list. The following properties can be used
     *            to order the results: * isFolder * name * mimeType * nodeType
     *            * sizeInBytes * modifiedAt * createdAt * modifiedByUser *
     *            createdByUser (optional)
     * @param where Optionally filter the list. Here are some examples: *
     *            where&#x3D;(isFolder&#x3D;true) *
     *            where&#x3D;(isFile&#x3D;true) *
     *            where&#x3D;(nodeType&#x3D;&#39;my:specialNodeType&#39;) *
     *            where&#x3D;(nodeType&#x3D;&#39;my:specialNodeType&#39;
     *            INCLUDESUBTYPES) * where&#x3D;(isPrimary&#x3D;true) *
     *            where&#x3D;(assocType&#x3D;&#39;my:specialAssocType&#39;)
     *            (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames * path * isLink * allowableOperations *
     *            association (optional)
     * @param relativePath Return information on children within the folder
     *            resolved by this path (relative to specified nodeId as the
     *            starting parent folder) (optional)
     * @param includeSource Also include \&quot;source\&quot; (in addition to
     *            \&quot;entries\&quot;) with folder information on parent node
     *            (either the specified parent \&quot;nodeId\&quot; or as
     *            resolved by \&quot;relativePath\&quot;) (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return ResultPaging<NodeRepresentation>
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<ResultPaging<NodeRepresentation>> listNodeChildrenObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.RELATIVE_PATH_VALUE) String relativePath,
            @Query(PublicAPIConstant.INCLUDE_SOURCE_VALUE) String includeSource,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create a node Creates a node as a (primary) child of the node with
     * identifier **nodeId**. This API method supports file upload using
     * multipart/form-data. Use the **filedata** field to represent the content
     * to upload. You can use a **name** field to give an alternative name for
     * the new file. For multipart/form-data upload you can use the
     * **renditions** field to create renditions (e.g. doclib) asynchronously
     * upon upload. Note that currently only one rendition can be requested.
     * Also, as requesting rendition is a background process, any rendition
     * failure (e.g. No transformer is currently available) will not fail the
     * whole upload and has the potential to silently fail. Use **overwrite** to
     * overwrite an existing file, matched by name. If the file is versionable,
     * the existing content is replaced. When you overwrite existing content,
     * you can set the **majorVersion** boolean field to **true** to indicate a
     * major version should be created. The default for **majorVersion** is
     * **false**. Setting **majorVersion** enables versioning of the node, if it
     * is not already versioned. When you overwrite existing content, you can
     * use the **comment** field to add a version comment that appears in the
     * version history. This also enables versioning of this node, if it is not
     * already versioned. You can set the **autoRename** boolean field to
     * automatically resolve name clashes. If there is a name clash, then the
     * API method tries to create a unique name using an integer suffix. Any
     * field in the JSON body defined below can also be passed as a form-data
     * field. This API method also supports node creation using
     * application/json. You must specify at least a **name** and **nodeType**.
     * For example, to create a folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot; } &#x60;&#x60;&#x60; You
     * can create an empty file like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My text file.txt\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot;, \&quot;content\&quot;: {
     * \&quot;mimeType\&quot;:\&quot;text/plain\&quot; } } &#x60;&#x60;&#x60;
     * You can update binary content using the &#x60;&#x60;&#x60;PUT
     * /nodes/{nodeId}&#x60;&#x60;&#x60; API method. You can create a folder, or
     * other node, inside a folder hierarchy: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Special Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;relativePath\&quot;:\&quot;X/Y/Z\&quot; } &#x60;&#x60;&#x60; The
     * **relativePath** specifies the folder structure to create relative to the
     * node identified by **nodeId**. Folders in the **relativePath** that do
     * not exist are created before the node is created. You can set properties
     * when you create a new node: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Other Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;, \&quot;properties\&quot;:
     * { \&quot;cm:title\&quot;:\&quot;Folder title\&quot;,
     * \&quot;cm:description\&quot;:\&quot;This is an important folder\&quot; }
     * } &#x60;&#x60;&#x60; Any missing aspects are auto-applied. For example,
     * **cm:titled** in the JSON shown above. You can set aspects explicitly
     * set, if needed, using an **aspectNames** field. Typically, for files and
     * folders, the primary children are created within the parent folder using
     * the default \&quot;cm:contains\&quot; assocType. If the content model
     * allows then it is also possible to create primary children with a
     * different assoc type. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Node\&quot;,
     * \&quot;nodeType\&quot;:\&quot;my:specialNodeType\&quot;,
     * \&quot;association\&quot;: {
     * \&quot;assocType\&quot;:\&quot;my:specialAssocType\&quot; } }
     * &#x60;&#x60;&#x60; Additional association can usually be added after
     * creating a node. However, it is also possible to add association at time
     * of create. This is required, for example, if the content model specifies
     * that a node has mandatory association to one or more other existing
     * nodes. You can optionally specify an array of **secondaryChildren** to
     * create one or more secondary child association, such that the newly
     * created node acts as a parent node. You can optionally specify an array
     * of **targets** to create one or more peer association such that the newly
     * created node acts as a source node. For example, to associate one or more
     * secondary children at time of creation: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;secondaryChildren\&quot;: [
     * {\&quot;childId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialChildAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60; For example, to associate one or more targets at time
     * of creation: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My
     * Folder\&quot;, \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;targets\&quot;: [
     * {\&quot;targetId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialPeerAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60;
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param nodeBody The node information to create. (required)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<NodeRepresentation> createNodeCall(@Path("nodeId") String nodeId, @Body NodeBodyCreate nodeBody);

    /**
     * Create a node Creates a node as a (primary) child of the node with
     * identifier **nodeId**. This API method supports file upload using
     * multipart/form-data. Use the **filedata** field to represent the content
     * to upload. You can use a **name** field to give an alternative name for
     * the new file. For multipart/form-data upload you can use the
     * **renditions** field to create renditions (e.g. doclib) asynchronously
     * upon upload. Note that currently only one rendition can be requested.
     * Also, as requesting rendition is a background process, any rendition
     * failure (e.g. No transformer is currently available) will not fail the
     * whole upload and has the potential to silently fail. Use **overwrite** to
     * overwrite an existing file, matched by name. If the file is versionable,
     * the existing content is replaced. When you overwrite existing content,
     * you can set the **majorVersion** boolean field to **true** to indicate a
     * major version should be created. The default for **majorVersion** is
     * **false**. Setting **majorVersion** enables versioning of the node, if it
     * is not already versioned. When you overwrite existing content, you can
     * use the **comment** field to add a version comment that appears in the
     * version history. This also enables versioning of this node, if it is not
     * already versioned. You can set the **autoRename** boolean field to
     * automatically resolve name clashes. If there is a name clash, then the
     * API method tries to create a unique name using an integer suffix. Any
     * field in the JSON body defined below can also be passed as a form-data
     * field. This API method also supports node creation using
     * application/json. You must specify at least a **name** and **nodeType**.
     * For example, to create a folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot; } &#x60;&#x60;&#x60; You
     * can create an empty file like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My text file.txt\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot;, \&quot;content\&quot;: {
     * \&quot;mimeType\&quot;:\&quot;text/plain\&quot; } } &#x60;&#x60;&#x60;
     * You can update binary content using the &#x60;&#x60;&#x60;PUT
     * /nodes/{nodeId}&#x60;&#x60;&#x60; API method. You can create a folder, or
     * other node, inside a folder hierarchy: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Special Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;relativePath\&quot;:\&quot;X/Y/Z\&quot; } &#x60;&#x60;&#x60; The
     * **relativePath** specifies the folder structure to create relative to the
     * node identified by **nodeId**. Folders in the **relativePath** that do
     * not exist are created before the node is created. You can set properties
     * when you create a new node: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Other Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;, \&quot;properties\&quot;:
     * { \&quot;cm:title\&quot;:\&quot;Folder title\&quot;,
     * \&quot;cm:description\&quot;:\&quot;This is an important folder\&quot; }
     * } &#x60;&#x60;&#x60; Any missing aspects are auto-applied. For example,
     * **cm:titled** in the JSON shown above. You can set aspects explicitly
     * set, if needed, using an **aspectNames** field. Typically, for files and
     * folders, the primary children are created within the parent folder using
     * the default \&quot;cm:contains\&quot; assocType. If the content model
     * allows then it is also possible to create primary children with a
     * different assoc type. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Node\&quot;,
     * \&quot;nodeType\&quot;:\&quot;my:specialNodeType\&quot;,
     * \&quot;association\&quot;: {
     * \&quot;assocType\&quot;:\&quot;my:specialAssocType\&quot; } }
     * &#x60;&#x60;&#x60; Additional association can usually be added after
     * creating a node. However, it is also possible to add association at time
     * of create. This is required, for example, if the content model specifies
     * that a node has mandatory association to one or more other existing
     * nodes. You can optionally specify an array of **secondaryChildren** to
     * create one or more secondary child association, such that the newly
     * created node acts as a parent node. You can optionally specify an array
     * of **targets** to create one or more peer association such that the newly
     * created node acts as a source node. For example, to associate one or more
     * secondary children at time of creation: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;secondaryChildren\&quot;: [
     * {\&quot;childId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialChildAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60; For example, to associate one or more targets at time
     * of creation: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My
     * Folder\&quot;, \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;targets\&quot;: [
     * {\&quot;targetId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialPeerAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param nodeBody The node information to create. (required)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<NodeRepresentation> createNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyCreate nodeBody);

    /**
     * Create a node Creates a node as a (primary) child of the node with
     * identifier **nodeId**. This API method supports file upload using
     * multipart/form-data. Use the **filedata** field to represent the content
     * to upload. You can use a **name** field to give an alternative name for
     * the new file. For multipart/form-data upload you can use the
     * **renditions** field to create renditions (e.g. doclib) asynchronously
     * upon upload. Note that currently only one rendition can be requested.
     * Also, as requesting rendition is a background process, any rendition
     * failure (e.g. No transformer is currently available) will not fail the
     * whole upload and has the potential to silently fail. Use **overwrite** to
     * overwrite an existing file, matched by name. If the file is versionable,
     * the existing content is replaced. When you overwrite existing content,
     * you can set the **majorVersion** boolean field to **true** to indicate a
     * major version should be created. The default for **majorVersion** is
     * **false**. Setting **majorVersion** enables versioning of the node, if it
     * is not already versioned. When you overwrite existing content, you can
     * use the **comment** field to add a version comment that appears in the
     * version history. This also enables versioning of this node, if it is not
     * already versioned. You can set the **autoRename** boolean field to
     * automatically resolve name clashes. If there is a name clash, then the
     * API method tries to create a unique name using an integer suffix. Any
     * field in the JSON body defined below can also be passed as a form-data
     * field. This API method also supports node creation using
     * application/json. You must specify at least a **name** and **nodeType**.
     * For example, to create a folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot; } &#x60;&#x60;&#x60; You
     * can create an empty file like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My text file.txt\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot;, \&quot;content\&quot;: {
     * \&quot;mimeType\&quot;:\&quot;text/plain\&quot; } } &#x60;&#x60;&#x60;
     * You can update binary content using the &#x60;&#x60;&#x60;PUT
     * /nodes/{nodeId}&#x60;&#x60;&#x60; API method. You can create a folder, or
     * other node, inside a folder hierarchy: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Special Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;relativePath\&quot;:\&quot;X/Y/Z\&quot; } &#x60;&#x60;&#x60; The
     * **relativePath** specifies the folder structure to create relative to the
     * node identified by **nodeId**. Folders in the **relativePath** that do
     * not exist are created before the node is created. You can set properties
     * when you create a new node: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Other Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;, \&quot;properties\&quot;:
     * { \&quot;cm:title\&quot;:\&quot;Folder title\&quot;,
     * \&quot;cm:description\&quot;:\&quot;This is an important folder\&quot; }
     * } &#x60;&#x60;&#x60; Any missing aspects are auto-applied. For example,
     * **cm:titled** in the JSON shown above. You can set aspects explicitly
     * set, if needed, using an **aspectNames** field. Typically, for files and
     * folders, the primary children are created within the parent folder using
     * the default \&quot;cm:contains\&quot; assocType. If the content model
     * allows then it is also possible to create primary children with a
     * different assoc type. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Node\&quot;,
     * \&quot;nodeType\&quot;:\&quot;my:specialNodeType\&quot;,
     * \&quot;association\&quot;: {
     * \&quot;assocType\&quot;:\&quot;my:specialAssocType\&quot; } }
     * &#x60;&#x60;&#x60; Additional association can usually be added after
     * creating a node. However, it is also possible to add association at time
     * of create. This is required, for example, if the content model specifies
     * that a node has mandatory association to one or more other existing
     * nodes. You can optionally specify an array of **secondaryChildren** to
     * create one or more secondary child association, such that the newly
     * created node acts as a parent node. You can optionally specify an array
     * of **targets** to create one or more peer association such that the newly
     * created node acts as a source node. For example, to associate one or more
     * secondary children at time of creation: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;secondaryChildren\&quot;: [
     * {\&quot;childId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialChildAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60; For example, to associate one or more targets at time
     * of creation: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My
     * Folder\&quot;, \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;targets\&quot;: [
     * {\&quot;targetId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialPeerAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60;
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param nodeBody The node information to create. (required)
     * @param autoRename If true, then a name clash will cause an attempt to
     *            auto rename by finding a unique name using an integer suffix.
     *            (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<NodeRepresentation> createNodeCall(@Path("nodeId") String nodeId, @Body NodeBodyCreate nodeBody,
            @Query(PublicAPIConstant.AUTO_RENAME_VALUE) boolean autoRename,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Create a node Creates a node as a (primary) child of the node with
     * identifier **nodeId**. This API method supports file upload using
     * multipart/form-data. Use the **filedata** field to represent the content
     * to upload. You can use a **name** field to give an alternative name for
     * the new file. For multipart/form-data upload you can use the
     * **renditions** field to create renditions (e.g. doclib) asynchronously
     * upon upload. Note that currently only one rendition can be requested.
     * Also, as requesting rendition is a background process, any rendition
     * failure (e.g. No transformer is currently available) will not fail the
     * whole upload and has the potential to silently fail. Use **overwrite** to
     * overwrite an existing file, matched by name. If the file is versionable,
     * the existing content is replaced. When you overwrite existing content,
     * you can set the **majorVersion** boolean field to **true** to indicate a
     * major version should be created. The default for **majorVersion** is
     * **false**. Setting **majorVersion** enables versioning of the node, if it
     * is not already versioned. When you overwrite existing content, you can
     * use the **comment** field to add a version comment that appears in the
     * version history. This also enables versioning of this node, if it is not
     * already versioned. You can set the **autoRename** boolean field to
     * automatically resolve name clashes. If there is a name clash, then the
     * API method tries to create a unique name using an integer suffix. Any
     * field in the JSON body defined below can also be passed as a form-data
     * field. This API method also supports node creation using
     * application/json. You must specify at least a **name** and **nodeType**.
     * For example, to create a folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot; } &#x60;&#x60;&#x60; You
     * can create an empty file like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My text file.txt\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot;, \&quot;content\&quot;: {
     * \&quot;mimeType\&quot;:\&quot;text/plain\&quot; } } &#x60;&#x60;&#x60;
     * You can update binary content using the &#x60;&#x60;&#x60;PUT
     * /nodes/{nodeId}&#x60;&#x60;&#x60; API method. You can create a folder, or
     * other node, inside a folder hierarchy: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Special Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;relativePath\&quot;:\&quot;X/Y/Z\&quot; } &#x60;&#x60;&#x60; The
     * **relativePath** specifies the folder structure to create relative to the
     * node identified by **nodeId**. Folders in the **relativePath** that do
     * not exist are created before the node is created. You can set properties
     * when you create a new node: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Other Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;, \&quot;properties\&quot;:
     * { \&quot;cm:title\&quot;:\&quot;Folder title\&quot;,
     * \&quot;cm:description\&quot;:\&quot;This is an important folder\&quot; }
     * } &#x60;&#x60;&#x60; Any missing aspects are auto-applied. For example,
     * **cm:titled** in the JSON shown above. You can set aspects explicitly
     * set, if needed, using an **aspectNames** field. Typically, for files and
     * folders, the primary children are created within the parent folder using
     * the default \&quot;cm:contains\&quot; assocType. If the content model
     * allows then it is also possible to create primary children with a
     * different assoc type. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Node\&quot;,
     * \&quot;nodeType\&quot;:\&quot;my:specialNodeType\&quot;,
     * \&quot;association\&quot;: {
     * \&quot;assocType\&quot;:\&quot;my:specialAssocType\&quot; } }
     * &#x60;&#x60;&#x60; Additional association can usually be added after
     * creating a node. However, it is also possible to add association at time
     * of create. This is required, for example, if the content model specifies
     * that a node has mandatory association to one or more other existing
     * nodes. You can optionally specify an array of **secondaryChildren** to
     * create one or more secondary child association, such that the newly
     * created node acts as a parent node. You can optionally specify an array
     * of **targets** to create one or more peer association such that the newly
     * created node acts as a source node. For example, to associate one or more
     * secondary children at time of creation: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;secondaryChildren\&quot;: [
     * {\&quot;childId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialChildAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60; For example, to associate one or more targets at time
     * of creation: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My
     * Folder\&quot;, \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;targets\&quot;: [
     * {\&quot;targetId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialPeerAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param nodeBody The node information to create. (required)
     * @param autoRename If true, then a name clash will cause an attempt to
     *            auto rename by finding a unique name using an integer suffix.
     *            (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<NodeRepresentation> createNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyCreate nodeBody,
            @Query(PublicAPIConstant.AUTO_RENAME_VALUE) boolean autoRename,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Create a node Creates a node as a (primary) child of the node with
     * identifier **nodeId**. This API method supports file upload using
     * multipart/form-data. Use the **filedata** field to represent the content
     * to upload. You can use a **name** field to give an alternative name for
     * the new file. For multipart/form-data upload you can use the
     * **renditions** field to create renditions (e.g. doclib) asynchronously
     * upon upload. Note that currently only one rendition can be requested.
     * Also, as requesting rendition is a background process, any rendition
     * failure (e.g. No transformer is currently available) will not fail the
     * whole upload and has the potential to silently fail. Use **overwrite** to
     * overwrite an existing file, matched by name. If the file is versionable,
     * the existing content is replaced. When you overwrite existing content,
     * you can set the **majorVersion** boolean field to **true** to indicate a
     * major version should be created. The default for **majorVersion** is
     * **false**. Setting **majorVersion** enables versioning of the node, if it
     * is not already versioned. When you overwrite existing content, you can
     * use the **comment** field to add a version comment that appears in the
     * version history. This also enables versioning of this node, if it is not
     * already versioned. You can set the **autoRename** boolean field to
     * automatically resolve name clashes. If there is a name clash, then the
     * API method tries to create a unique name using an integer suffix. Any
     * field in the JSON body defined below can also be passed as a form-data
     * field. This API method also supports node creation using
     * application/json. You must specify at least a **name** and **nodeType**.
     * For example, to create a folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot; } &#x60;&#x60;&#x60; You
     * can create an empty file like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My text file.txt\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot;, \&quot;content\&quot;: {
     * \&quot;mimeType\&quot;:\&quot;text/plain\&quot; } } &#x60;&#x60;&#x60;
     * You can update binary content using the &#x60;&#x60;&#x60;PUT
     * /nodes/{nodeId}&#x60;&#x60;&#x60; API method. You can create a folder, or
     * other node, inside a folder hierarchy: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Special Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;relativePath\&quot;:\&quot;X/Y/Z\&quot; } &#x60;&#x60;&#x60; The
     * **relativePath** specifies the folder structure to create relative to the
     * node identified by **nodeId**. Folders in the **relativePath** that do
     * not exist are created before the node is created. You can set properties
     * when you create a new node: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Other Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;, \&quot;properties\&quot;:
     * { \&quot;cm:title\&quot;:\&quot;Folder title\&quot;,
     * \&quot;cm:description\&quot;:\&quot;This is an important folder\&quot; }
     * } &#x60;&#x60;&#x60; Any missing aspects are auto-applied. For example,
     * **cm:titled** in the JSON shown above. You can set aspects explicitly
     * set, if needed, using an **aspectNames** field. Typically, for files and
     * folders, the primary children are created within the parent folder using
     * the default \&quot;cm:contains\&quot; assocType. If the content model
     * allows then it is also possible to create primary children with a
     * different assoc type. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Node\&quot;,
     * \&quot;nodeType\&quot;:\&quot;my:specialNodeType\&quot;,
     * \&quot;association\&quot;: {
     * \&quot;assocType\&quot;:\&quot;my:specialAssocType\&quot; } }
     * &#x60;&#x60;&#x60; Additional association can usually be added after
     * creating a node. However, it is also possible to add association at time
     * of create. This is required, for example, if the content model specifies
     * that a node has mandatory association to one or more other existing
     * nodes. You can optionally specify an array of **secondaryChildren** to
     * create one or more secondary child association, such that the newly
     * created node acts as a parent node. You can optionally specify an array
     * of **targets** to create one or more peer association such that the newly
     * created node acts as a source node. For example, to associate one or more
     * secondary children at time of creation: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;secondaryChildren\&quot;: [
     * {\&quot;childId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialChildAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60; For example, to associate one or more targets at time
     * of creation: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My
     * Folder\&quot;, \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;targets\&quot;: [
     * {\&quot;targetId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialPeerAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60;
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param file The node information to create. (required)
     * @return NodeRepresentation
     */
    @Multipart
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<NodeRepresentation> createNodeCall(@Path("nodeId") String nodeId, @Part("filedata") RequestBody file);

    @Multipart
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<NodeRepresentation> createNodeCall(@Path("nodeId") String nodeId, @PartMap() Map<String, RequestBody> partMap);

    /**
     * Create a node Creates a node as a (primary) child of the node with
     * identifier **nodeId**. This API method supports file upload using
     * multipart/form-data. Use the **filedata** field to represent the content
     * to upload. You can use a **name** field to give an alternative name for
     * the new file. For multipart/form-data upload you can use the
     * **renditions** field to create renditions (e.g. doclib) asynchronously
     * upon upload. Note that currently only one rendition can be requested.
     * Also, as requesting rendition is a background process, any rendition
     * failure (e.g. No transformer is currently available) will not fail the
     * whole upload and has the potential to silently fail. Use **overwrite** to
     * overwrite an existing file, matched by name. If the file is versionable,
     * the existing content is replaced. When you overwrite existing content,
     * you can set the **majorVersion** boolean field to **true** to indicate a
     * major version should be created. The default for **majorVersion** is
     * **false**. Setting **majorVersion** enables versioning of the node, if it
     * is not already versioned. When you overwrite existing content, you can
     * use the **comment** field to add a version comment that appears in the
     * version history. This also enables versioning of this node, if it is not
     * already versioned. You can set the **autoRename** boolean field to
     * automatically resolve name clashes. If there is a name clash, then the
     * API method tries to create a unique name using an integer suffix. Any
     * field in the JSON body defined below can also be passed as a form-data
     * field. This API method also supports node creation using
     * application/json. You must specify at least a **name** and **nodeType**.
     * For example, to create a folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot; } &#x60;&#x60;&#x60; You
     * can create an empty file like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My text file.txt\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot;, \&quot;content\&quot;: {
     * \&quot;mimeType\&quot;:\&quot;text/plain\&quot; } } &#x60;&#x60;&#x60;
     * You can update binary content using the &#x60;&#x60;&#x60;PUT
     * /nodes/{nodeId}&#x60;&#x60;&#x60; API method. You can create a folder, or
     * other node, inside a folder hierarchy: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Special Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;relativePath\&quot;:\&quot;X/Y/Z\&quot; } &#x60;&#x60;&#x60; The
     * **relativePath** specifies the folder structure to create relative to the
     * node identified by **nodeId**. Folders in the **relativePath** that do
     * not exist are created before the node is created. You can set properties
     * when you create a new node: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Other Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;, \&quot;properties\&quot;:
     * { \&quot;cm:title\&quot;:\&quot;Folder title\&quot;,
     * \&quot;cm:description\&quot;:\&quot;This is an important folder\&quot; }
     * } &#x60;&#x60;&#x60; Any missing aspects are auto-applied. For example,
     * **cm:titled** in the JSON shown above. You can set aspects explicitly
     * set, if needed, using an **aspectNames** field. Typically, for files and
     * folders, the primary children are created within the parent folder using
     * the default \&quot;cm:contains\&quot; assocType. If the content model
     * allows then it is also possible to create primary children with a
     * different assoc type. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Node\&quot;,
     * \&quot;nodeType\&quot;:\&quot;my:specialNodeType\&quot;,
     * \&quot;association\&quot;: {
     * \&quot;assocType\&quot;:\&quot;my:specialAssocType\&quot; } }
     * &#x60;&#x60;&#x60; Additional association can usually be added after
     * creating a node. However, it is also possible to add association at time
     * of create. This is required, for example, if the content model specifies
     * that a node has mandatory association to one or more other existing
     * nodes. You can optionally specify an array of **secondaryChildren** to
     * create one or more secondary child association, such that the newly
     * created node acts as a parent node. You can optionally specify an array
     * of **targets** to create one or more peer association such that the newly
     * created node acts as a source node. For example, to associate one or more
     * secondary children at time of creation: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;secondaryChildren\&quot;: [
     * {\&quot;childId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialChildAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60; For example, to associate one or more targets at time
     * of creation: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My
     * Folder\&quot;, \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;targets\&quot;: [
     * {\&quot;targetId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialPeerAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param file The node information to create. (required)
     * @return NodeRepresentation
     */
    @Multipart
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<NodeRepresentation> createNodeObservable(@Path("nodeId") String nodeId,
            @Part("filedata") RequestBody file);

    @Multipart
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<NodeRepresentation> createNodeObservable(@Path("nodeId") String nodeId,
            @PartMap() Map<String, RequestBody> partMap);

    /**
     * Create a node Creates a node as a (primary) child of the node with
     * identifier **nodeId**. This API method supports file upload using
     * multipart/form-data. Use the **filedata** field to represent the content
     * to upload. You can use a **name** field to give an alternative name for
     * the new file. For multipart/form-data upload you can use the
     * **renditions** field to create renditions (e.g. doclib) asynchronously
     * upon upload. Note that currently only one rendition can be requested.
     * Also, as requesting rendition is a background process, any rendition
     * failure (e.g. No transformer is currently available) will not fail the
     * whole upload and has the potential to silently fail. Use **overwrite** to
     * overwrite an existing file, matched by name. If the file is versionable,
     * the existing content is replaced. When you overwrite existing content,
     * you can set the **majorVersion** boolean field to **true** to indicate a
     * major version should be created. The default for **majorVersion** is
     * **false**. Setting **majorVersion** enables versioning of the node, if it
     * is not already versioned. When you overwrite existing content, you can
     * use the **comment** field to add a version comment that appears in the
     * version history. This also enables versioning of this node, if it is not
     * already versioned. You can set the **autoRename** boolean field to
     * automatically resolve name clashes. If there is a name clash, then the
     * API method tries to create a unique name using an integer suffix. Any
     * field in the JSON body defined below can also be passed as a form-data
     * field. This API method also supports node creation using
     * application/json. You must specify at least a **name** and **nodeType**.
     * For example, to create a folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot; } &#x60;&#x60;&#x60; You
     * can create an empty file like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My text file.txt\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot;, \&quot;content\&quot;: {
     * \&quot;mimeType\&quot;:\&quot;text/plain\&quot; } } &#x60;&#x60;&#x60;
     * You can update binary content using the &#x60;&#x60;&#x60;PUT
     * /nodes/{nodeId}&#x60;&#x60;&#x60; API method. You can create a folder, or
     * other node, inside a folder hierarchy: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Special Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;relativePath\&quot;:\&quot;X/Y/Z\&quot; } &#x60;&#x60;&#x60; The
     * **relativePath** specifies the folder structure to create relative to the
     * node identified by **nodeId**. Folders in the **relativePath** that do
     * not exist are created before the node is created. You can set properties
     * when you create a new node: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Other Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;, \&quot;properties\&quot;:
     * { \&quot;cm:title\&quot;:\&quot;Folder title\&quot;,
     * \&quot;cm:description\&quot;:\&quot;This is an important folder\&quot; }
     * } &#x60;&#x60;&#x60; Any missing aspects are auto-applied. For example,
     * **cm:titled** in the JSON shown above. You can set aspects explicitly
     * set, if needed, using an **aspectNames** field. Typically, for files and
     * folders, the primary children are created within the parent folder using
     * the default \&quot;cm:contains\&quot; assocType. If the content model
     * allows then it is also possible to create primary children with a
     * different assoc type. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Node\&quot;,
     * \&quot;nodeType\&quot;:\&quot;my:specialNodeType\&quot;,
     * \&quot;association\&quot;: {
     * \&quot;assocType\&quot;:\&quot;my:specialAssocType\&quot; } }
     * &#x60;&#x60;&#x60; Additional association can usually be added after
     * creating a node. However, it is also possible to add association at time
     * of create. This is required, for example, if the content model specifies
     * that a node has mandatory association to one or more other existing
     * nodes. You can optionally specify an array of **secondaryChildren** to
     * create one or more secondary child association, such that the newly
     * created node acts as a parent node. You can optionally specify an array
     * of **targets** to create one or more peer association such that the newly
     * created node acts as a source node. For example, to associate one or more
     * secondary children at time of creation: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;secondaryChildren\&quot;: [
     * {\&quot;childId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialChildAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60; For example, to associate one or more targets at time
     * of creation: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My
     * Folder\&quot;, \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;targets\&quot;: [
     * {\&quot;targetId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialPeerAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60;
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param file The node information to create. (required)
     * @param autoRename If true, then a name clash will cause an attempt to
     *            auto rename by finding a unique name using an integer suffix.
     *            (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @Multipart
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<NodeRepresentation> createNodeCall(@Path("nodeId") String nodeId, @Part("filedata") RequestBody file,
            @Query(PublicAPIConstant.AUTO_RENAME_VALUE) boolean autoRename,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Create a node Creates a node as a (primary) child of the node with
     * identifier **nodeId**. This API method supports file upload using
     * multipart/form-data. Use the **filedata** field to represent the content
     * to upload. You can use a **name** field to give an alternative name for
     * the new file. For multipart/form-data upload you can use the
     * **renditions** field to create renditions (e.g. doclib) asynchronously
     * upon upload. Note that currently only one rendition can be requested.
     * Also, as requesting rendition is a background process, any rendition
     * failure (e.g. No transformer is currently available) will not fail the
     * whole upload and has the potential to silently fail. Use **overwrite** to
     * overwrite an existing file, matched by name. If the file is versionable,
     * the existing content is replaced. When you overwrite existing content,
     * you can set the **majorVersion** boolean field to **true** to indicate a
     * major version should be created. The default for **majorVersion** is
     * **false**. Setting **majorVersion** enables versioning of the node, if it
     * is not already versioned. When you overwrite existing content, you can
     * use the **comment** field to add a version comment that appears in the
     * version history. This also enables versioning of this node, if it is not
     * already versioned. You can set the **autoRename** boolean field to
     * automatically resolve name clashes. If there is a name clash, then the
     * API method tries to create a unique name using an integer suffix. Any
     * field in the JSON body defined below can also be passed as a form-data
     * field. This API method also supports node creation using
     * application/json. You must specify at least a **name** and **nodeType**.
     * For example, to create a folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot; } &#x60;&#x60;&#x60; You
     * can create an empty file like this: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My text file.txt\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:content\&quot;, \&quot;content\&quot;: {
     * \&quot;mimeType\&quot;:\&quot;text/plain\&quot; } } &#x60;&#x60;&#x60;
     * You can update binary content using the &#x60;&#x60;&#x60;PUT
     * /nodes/{nodeId}&#x60;&#x60;&#x60; API method. You can create a folder, or
     * other node, inside a folder hierarchy: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Special Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;relativePath\&quot;:\&quot;X/Y/Z\&quot; } &#x60;&#x60;&#x60; The
     * **relativePath** specifies the folder structure to create relative to the
     * node identified by **nodeId**. Folders in the **relativePath** that do
     * not exist are created before the node is created. You can set properties
     * when you create a new node: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Other Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;, \&quot;properties\&quot;:
     * { \&quot;cm:title\&quot;:\&quot;Folder title\&quot;,
     * \&quot;cm:description\&quot;:\&quot;This is an important folder\&quot; }
     * } &#x60;&#x60;&#x60; Any missing aspects are auto-applied. For example,
     * **cm:titled** in the JSON shown above. You can set aspects explicitly
     * set, if needed, using an **aspectNames** field. Typically, for files and
     * folders, the primary children are created within the parent folder using
     * the default \&quot;cm:contains\&quot; assocType. If the content model
     * allows then it is also possible to create primary children with a
     * different assoc type. For example: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Node\&quot;,
     * \&quot;nodeType\&quot;:\&quot;my:specialNodeType\&quot;,
     * \&quot;association\&quot;: {
     * \&quot;assocType\&quot;:\&quot;my:specialAssocType\&quot; } }
     * &#x60;&#x60;&#x60; Additional association can usually be added after
     * creating a node. However, it is also possible to add association at time
     * of create. This is required, for example, if the content model specifies
     * that a node has mandatory association to one or more other existing
     * nodes. You can optionally specify an array of **secondaryChildren** to
     * create one or more secondary child association, such that the newly
     * created node acts as a parent node. You can optionally specify an array
     * of **targets** to create one or more peer association such that the newly
     * created node acts as a source node. For example, to associate one or more
     * secondary children at time of creation: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My Folder\&quot;,
     * \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;secondaryChildren\&quot;: [
     * {\&quot;childId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialChildAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60; For example, to associate one or more targets at time
     * of creation: &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;My
     * Folder\&quot;, \&quot;nodeType\&quot;:\&quot;cm:folder\&quot;,
     * \&quot;targets\&quot;: [
     * {\&quot;targetId\&quot;:\&quot;abcde-01234-...\&quot;,
     * \&quot;assocType\&quot;:\&quot;my:specialPeerAssocType\&quot;} ] }
     * &#x60;&#x60;&#x60;
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param file The node information to create. (required)
     * @param autoRename If true, then a name clash will cause an attempt to
     *            auto rename by finding a unique name using an integer suffix.
     *            (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @Multipart
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<NodeRepresentation> createNodeObservable(@Path("nodeId") String nodeId,
            @Part("filedata") RequestBody file, @Query(PublicAPIConstant.AUTO_RENAME_VALUE) boolean autoRename,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update a node Updates the node with identifier **nodeId**. For example,
     * you can rename a file or folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My new name\&quot;, } &#x60;&#x60;&#x60; You
     * can also set or update one or more properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;cm:title\&quot;:\&quot;Folder
     * title\&quot; } } &#x60;&#x60;&#x60; **Note:** if you want to add or
     * remove aspects, then you must use **GET /nodes/{nodeId}** first to get
     * the complete set of *aspectNames*. **Note:** Currently there is no
     * optimistic locking for updates, so they are applied in \&quot;last one
     * wins\&quot; order.
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param nodeBody The node information to update. (required)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Call<NodeRepresentation> updateNodeCall(@Path("nodeId") String nodeId, @Body NodeBodyUpdate nodeBody);

    /**
     * Update a node Updates the node with identifier **nodeId**. For example,
     * you can rename a file or folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My new name\&quot;, } &#x60;&#x60;&#x60; You
     * can also set or update one or more properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;cm:title\&quot;:\&quot;Folder
     * title\&quot; } } &#x60;&#x60;&#x60; **Note:** if you want to add or
     * remove aspects, then you must use **GET /nodes/{nodeId}** first to get
     * the complete set of *aspectNames*. **Note:** Currently there is no
     * optimistic locking for updates, so they are applied in \&quot;last one
     * wins\&quot; order.
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param nodeBody The node information to update. (required)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Observable<NodeRepresentation> updateNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyUpdate nodeBody);

    /**
     * Update a node Updates the node with identifier **nodeId**. For example,
     * you can rename a file or folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My new name\&quot;, } &#x60;&#x60;&#x60; You
     * can also set or update one or more properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;cm:title\&quot;:\&quot;Folder
     * title\&quot; } } &#x60;&#x60;&#x60; **Note:** if you want to add or
     * remove aspects, then you must use **GET /nodes/{nodeId}** first to get
     * the complete set of *aspectNames*. **Note:** Currently there is no
     * optimistic locking for updates, so they are applied in \&quot;last one
     * wins\&quot; order.
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param nodeBody The node information to update. (required)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Call<NodeRepresentation> updateNodeCall(@Path("nodeId") String nodeId, @Body NodeBodyUpdate nodeBody,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Update a node Updates the node with identifier **nodeId**. For example,
     * you can rename a file or folder: &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;My new name\&quot;, } &#x60;&#x60;&#x60; You
     * can also set or update one or more properties: &#x60;&#x60;&#x60;JSON {
     * \&quot;properties\&quot;: { \&quot;cm:title\&quot;:\&quot;Folder
     * title\&quot; } } &#x60;&#x60;&#x60; **Note:** if you want to add or
     * remove aspects, then you must use **GET /nodes/{nodeId}** first to get
     * the complete set of *aspectNames*. **Note:** Currently there is no
     * optimistic locking for updates, so they are applied in \&quot;last one
     * wins\&quot; order.
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param nodeBody The node information to update. (required)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Observable<NodeRepresentation> updateNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyUpdate nodeBody,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Update file content Updates the content of the node with identifier
     * **nodeId**. The body body for this endpoint can be any text or binary
     * stream. The Content-Type header should be set correctly for the type of
     * content being updated. The Content-Type header is used to set the
     * mimetype in the repository. The **majorVersion** and **comment**
     * parameters can be used to control versioning behaviour. If the content is
     * versionable, a new minor version is created by default. **Note:** This
     * API method accepts any content type, but for testing with this tool text
     * based content can be provided. This is because the OpenAPI Specification
     * does not allow a wildcard to be provided or the ability for tooling to
     * accept an arbitary file.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param contentBody The binary content (required)
     * @return NodeRepresentation
     */
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Call<NodeRepresentation> updateNodeContentCall(@Path("nodeId") String nodeId, @Body RequestBody contentBody);

    /**
     * Update file content Updates the content of the node with identifier
     * **nodeId**. The body body for this endpoint can be any text or binary
     * stream. The Content-Type header should be set correctly for the type of
     * content being updated. The Content-Type header is used to set the
     * mimetype in the repository. The **majorVersion** and **comment**
     * parameters can be used to control versioning behaviour. If the content is
     * versionable, a new minor version is created by default. **Note:** This
     * API method accepts any content type, but for testing with this tool text
     * based content can be provided. This is because the OpenAPI Specification
     * does not allow a wildcard to be provided or the ability for tooling to
     * accept an arbitary file.
     *
     * @param nodeId The identifier of a node. (required)
     * @param contentBody The binary content (required)
     * @return NodeRepresentation
     */
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Observable<NodeRepresentation> updateNodeContentObservable(@Path("nodeId") String nodeId,
            @Body RequestBody contentBody);

    /**
     * Update file content Updates the content of the node with identifier
     * **nodeId**. The body body for this endpoint can be any text or binary
     * stream. The Content-Type header should be set correctly for the type of
     * content being updated. The Content-Type header is used to set the
     * mimetype in the repository. The **majorVersion** and **comment**
     * parameters can be used to control versioning behaviour. If the content is
     * versionable, a new minor version is created by default. **Note:** This
     * API method accepts any content type, but for testing with this tool text
     * based content can be provided. This is because the OpenAPI Specification
     * does not allow a wildcard to be provided or the ability for tooling to
     * accept an arbitary file.
     *
     * @param nodeId The identifier of a node. (required)
     * @param contentBody The binary content (required)
     * @param majorVersion If **true**, create a major version. Setting this
     *            parameter also enables versioning of this node, if it is not
     *            already versioned. (optional, default to false)
     * @param comment Add a version comment which will appear in version
     *            history. Setting this parameter also enables versioning of
     *            this node, if it is not already versioned. (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Call<NodeRepresentation> updateNodeContentCall(@Path("nodeId") String nodeId, @Body RequestBody contentBody,
            @Query("majorVersion") Boolean majorVersion, @Query("comment") String comment,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Update file content Updates the content of the node with identifier
     * **nodeId**. The body body for this endpoint can be any text or binary
     * stream. The Content-Type header should be set correctly for the type of
     * content being updated. The Content-Type header is used to set the
     * mimetype in the repository. The **majorVersion** and **comment**
     * parameters can be used to control versioning behaviour. If the content is
     * versionable, a new minor version is created by default. **Note:** This
     * API method accepts any content type, but for testing with this tool text
     * based content can be provided. This is because the OpenAPI Specification
     * does not allow a wildcard to be provided or the ability for tooling to
     * accept an arbitary file.
     *
     * @param nodeId The identifier of a node. (required)
     * @param contentBody The binary content (required)
     * @param majorVersion If **true**, create a major version. Setting this
     *            parameter also enables versioning of this node, if it is not
     *            already versioned. (optional, default to false)
     * @param comment Add a version comment which will appear in version
     *            history. Setting this parameter also enables versioning of
     *            this node, if it is not already versioned. (optional)
     * @return NodeRepresentation
     */
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Call<NodeRepresentation> updateNodeContentCall(@Path("nodeId") String nodeId, @Body RequestBody contentBody,
            @Query("majorVersion") Boolean majorVersion, @Query("comment") String comment);

    /**
     * Update file content Updates the content of the node with identifier
     * **nodeId**. The body body for this endpoint can be any text or binary
     * stream. The Content-Type header should be set correctly for the type of
     * content being updated. The Content-Type header is used to set the
     * mimetype in the repository. The **majorVersion** and **comment**
     * parameters can be used to control versioning behaviour. If the content is
     * versionable, a new minor version is created by default. **Note:** This
     * API method accepts any content type, but for testing with this tool text
     * based content can be provided. This is because the OpenAPI Specification
     * does not allow a wildcard to be provided or the ability for tooling to
     * accept an arbitary file.
     *
     * @param nodeId The identifier of a node. (required)
     * @param contentBody The binary content (required)
     * @param majorVersion If **true**, create a major version. Setting this
     *            parameter also enables versioning of this node, if it is not
     *            already versioned. (optional, default to false)
     * @param comment Add a version comment which will appear in version
     *            history. Setting this parameter also enables versioning of
     *            this node, if it is not already versioned. (optional)
     * @return NodeRepresentation
     */
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Observable<NodeRepresentation> updateNodeContentObservable(@Path("nodeId") String nodeId,
            @Body RequestBody contentBody, @Query("majorVersion") Boolean majorVersion,
            @Query("comment") String comment);

    /**
     * Update file content Updates the content of the node with identifier
     * **nodeId**. The body body for this endpoint can be any text or binary
     * stream. The Content-Type header should be set correctly for the type of
     * content being updated. The Content-Type header is used to set the
     * mimetype in the repository. The **majorVersion** and **comment**
     * parameters can be used to control versioning behaviour. If the content is
     * versionable, a new minor version is created by default. **Note:** This
     * API method accepts any content type, but for testing with this tool text
     * based content can be provided. This is because the OpenAPI Specification
     * does not allow a wildcard to be provided or the ability for tooling to
     * accept an arbitary file.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param contentBody The binary content (required)
     * @param majorVersion If **true**, create a major version. Setting this
     *            parameter also enables versioning of this node, if it is not
     *            already versioned. (optional, default to false)
     * @param comment Add a version comment which will appear in version
     *            history. Setting this parameter also enables versioning of
     *            this node, if it is not already versioned. (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Observable<NodeRepresentation> updateNodeContentObservable(@Path("nodeId") String nodeId,
            @Body RequestBody contentBody, @Query("majorVersion") Boolean majorVersion,
            @Query("comment") String comment, @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DOWNLOAD
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get file content Returns the file content of the node with identifier
     * **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     */
    @Streaming
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Call<ResponseBody> getNodeContentCall(@Path("nodeId") String nodeId);

    /**
     * Get file content Returns the file content of the node with identifier
     * **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
     */
    @Streaming
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Observable<ResponseBody> getNodeContentObservable(@Path("nodeId") String nodeId);

    /**
     * Get file content Returns the file content of the node with identifier
     * **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
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
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Call<ResponseBody> getNodeContentCall(@Path("nodeId") String nodeId, @Query("attachment") Boolean attachment,
            @Header("If-Modified-Since") Date ifModifiedSince);

    /**
     * Get file content Returns the file content of the node with identifier
     * **nodeId**.
     * 
     * @param nodeId The identifier of a node. (required)
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
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Observable<ResponseBody> getNodeContentObservable(@Path("nodeId") String nodeId,
            @Query("attachment") Boolean attachment, @Header("If-Modified-Since") Date ifModifiedSince);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete a node Deletes the node with identifier **nodeId**. If the
     * **nodeId** is a folder, then its children are also deleted. Deleted nodes
     * moveNodeCall to the trashcan unless the **permanent** query parameter is
     * true, and the current user is the owner or an admin. Deleting a node
     * removes it from it&#39;s primary parent and also from any other secondary
     * parents. Also, peer association are removed, where the deleted node is
     * either a source or target. The same also applies recursively to any
     * hierarchy of primary children of the deleted node. It should be noted
     * that if the node is not permanently deleted and later successfully
     * restored to it&#39;s former primary parent, then only the primary child
     * association will be restored, including recursively for any primary
     * children. It should be noted that no other secondary child association or
     * peer association will be restored, for any of the nodes within the
     * primary parent-child hierarchy of restored nodes, irrespective of whether
     * these association were to nodes within or outside of the restored
     * hierarchy.
     * 
     * @param nodeId The identifier of a node. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Call<Void> deleteNodeCall(@Path("nodeId") String nodeId);

    /**
     * Delete a node Deletes the node with identifier **nodeId**. If the
     * **nodeId** is a folder, then its children are also deleted. Deleted nodes
     * moveNodeCall to the trashcan unless the **permanent** query parameter is
     * true, and the current user is the owner or an admin. Deleting a node
     * removes it from it&#39;s primary parent and also from any other secondary
     * parents. Also, peer association are removed, where the deleted node is
     * either a source or target. The same also applies recursively to any
     * hierarchy of primary children of the deleted node. It should be noted
     * that if the node is not permanently deleted and later successfully
     * restored to it&#39;s former primary parent, then only the primary child
     * association will be restored, including recursively for any primary
     * children. It should be noted that no other secondary child association or
     * peer association will be restored, for any of the nodes within the
     * primary parent-child hierarchy of restored nodes, irrespective of whether
     * these association were to nodes within or outside of the restored
     * hierarchy.
     *
     * @param nodeId The identifier of a node. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Observable<Void> deleteNodeObservable(@Path("nodeId") String nodeId);

    /**
     * Delete a node Deletes the node with identifier **nodeId**. If the
     * **nodeId** is a folder, then its children are also deleted. Deleted nodes
     * moveNodeCall to the trashcan unless the **permanent** query parameter is
     * true, and the current user is the owner or an admin. Deleting a node
     * removes it from it&#39;s primary parent and also from any other secondary
     * parents. Also, peer association are removed, where the deleted node is
     * either a source or target. The same also applies recursively to any
     * hierarchy of primary children of the deleted node. It should be noted
     * that if the node is not permanently deleted and later successfully
     * restored to it&#39;s former primary parent, then only the primary child
     * association will be restored, including recursively for any primary
     * children. It should be noted that no other secondary child association or
     * peer association will be restored, for any of the nodes within the
     * primary parent-child hierarchy of restored nodes, irrespective of whether
     * these association were to nodes within or outside of the restored
     * hierarchy.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param permanent If **true** then the node is deleted permanently,
     *            without it moving to the trashcan. You must be the owner or an
     *            admin to permanently delete the node. (optional, default to
     *            false)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Call<Void> deleteNodeCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.PERMANENT_VALUE) Boolean permanent);

    /**
     * Delete a node Deletes the node with identifier **nodeId**. If the
     * **nodeId** is a folder, then its children are also deleted. Deleted nodes
     * moveNodeCall to the trashcan unless the **permanent** query parameter is
     * true, and the current user is the owner or an admin. Deleting a node
     * removes it from it&#39;s primary parent and also from any other secondary
     * parents. Also, peer association are removed, where the deleted node is
     * either a source or target. The same also applies recursively to any
     * hierarchy of primary children of the deleted node. It should be noted
     * that if the node is not permanently deleted and later successfully
     * restored to it&#39;s former primary parent, then only the primary child
     * association will be restored, including recursively for any primary
     * children. It should be noted that no other secondary child association or
     * peer association will be restored, for any of the nodes within the
     * primary parent-child hierarchy of restored nodes, irrespective of whether
     * these association were to nodes within or outside of the restored
     * hierarchy.
     *
     * @param nodeId The identifier of a node. (required)
     * @param permanent If **true** then the node is deleted permanently,
     *            without it moving to the trashcan. You must be the owner or an
     *            admin to permanently delete the node. (optional, default to
     *            false)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Observable<Void> deleteNodeObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.PERMANENT_VALUE) Boolean permanent);

    // ///////////////////////////////////////////////////////////////////////////
    // PARENT
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List parents Returns a list of parent nodes that point to (ie. are
     * associated with) the current child **nodeId**. This inclues both the
     * primary parent and also secondary parents, if any.
     * 
     * @param nodeId The identifier of a node. (required)
     * @return ApiResponse&lt;NodeAssocPaging&gt;
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/parents")
    Call<ResultPaging<NodeRepresentation>> listParentsCall(@Path("nodeId") String nodeId);

    /**
     * List parents Returns a list of parent nodes that point to (ie. are
     * associated with) the current child **nodeId**. This inclues both the
     * primary parent and also secondary parents, if any.
     *
     * @param nodeId The identifier of a node. (required)
     * @return ApiResponse&lt;NodeAssocPaging&gt;
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/parents")
    Observable<ResultPaging<NodeRepresentation>> listParentsObservable(@Path("nodeId") String nodeId);

    /**
     * List parents Returns a list of parent nodes that point to (ie. are
     * associated with) the current child **nodeId**. This inclues both the
     * primary parent and also secondary parents, if any.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @return ApiResponse&lt;NodeAssocPaging&gt;
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/parents")
    Call<ResultPaging<NodeRepresentation>> listParentsCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems);

    /**
     * List parents Returns a list of parent nodes that point to (ie. are
     * associated with) the current child **nodeId**. This inclues both the
     * primary parent and also secondary parents, if any.
     *
     * @param nodeId The identifier of a node. (required)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @return ApiResponse&lt;NodeAssocPaging&gt;
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/parents")
    Observable<ResultPaging<NodeRepresentation>> listParentsObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems);

    /**
     * List parents Returns a list of parent nodes that point to (ie. are
     * associated with) the current child **nodeId**. This inclues both the
     * primary parent and also secondary parents, if any.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param where Optionally filter the list by assocType and/or isPrimary.
     *            Here are some examples: *
     *            where&#x3D;(assocType&#x3D;&#39;my:specialAssocType&#39;) *
     *            where&#x3D;(isPrimary&#x3D;true) *
     *            where&#x3D;(isPrimary&#x3D;false and
     *            assocType&#x3D;&#39;my:specialAssocType&#39;) (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames * path * isLink * allowableOperations (optional)
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
     * @return ApiResponse&lt;NodeAssocPaging&gt;
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/parents")
    Call<ResultPaging<NodeRepresentation>> listParentsCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * List parents Returns a list of parent nodes that point to (ie. are
     * associated with) the current child **nodeId**. This inclues both the
     * primary parent and also secondary parents, if any.
     *
     * @param nodeId The identifier of a node. (required)
     * @param where Optionally filter the list by assocType and/or isPrimary.
     *            Here are some examples: *
     *            where&#x3D;(assocType&#x3D;&#39;my:specialAssocType&#39;) *
     *            where&#x3D;(isPrimary&#x3D;true) *
     *            where&#x3D;(isPrimary&#x3D;false and
     *            assocType&#x3D;&#39;my:specialAssocType&#39;) (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames * path * isLink * allowableOperations (optional)
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
     * @return ApiResponse&lt;NodeAssocPaging&gt;
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/parents")
    Observable<ResultPaging<NodeRepresentation>> listParentsObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // ASSOCIATIONS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List secondary children Returns a list of secondary child nodes that are
     * associated with the current parent **nodeId**, via a secondary child
     * association.
     * 
     * @param nodeId The identifier of a parent node. (required)
     * @return NodeChildAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/secondary-children")
    Call<ResultPaging<NodeRepresentation>> listSecondaryChildrenCall(@Path("nodeId") String nodeId);

    /**
     * List secondary children Returns a list of secondary child nodes that are
     * associated with the current parent **nodeId**, via a secondary child
     * association.
     *
     * @param nodeId The identifier of a parent node. (required)
     * @return NodeChildAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/secondary-children")
    Observable<ResultPaging<NodeRepresentation>> listSecondaryChildrenObservable(@Path("nodeId") String nodeId);

    /**
     * List secondary children Returns a list of secondary child nodes that are
     * associated with the current parent **nodeId**, via a secondary child
     * association.
     * 
     * @param nodeId The identifier of a parent node. (required)
     * @param assocType Restrict the returned results to only those of the given
     *            association type (optional)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @return NodeChildAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/secondary-children")
    Call<ResultPaging<NodeRepresentation>> listSecondaryChildrenCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.ASSOC_TYPE_VALUE) String assocType,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems);

    /**
     * List secondary children Returns a list of secondary child nodes that are
     * associated with the current parent **nodeId**, via a secondary child
     * association.
     *
     * @param nodeId The identifier of a parent node. (required)
     * @param assocType Restrict the returned results to only those of the given
     *            association type (optional)
     * @param skipCount The number of entities that exist in the collection
     *            before those included in this list. (optional)
     * @param maxItems The maximum number of items to return in the list.
     *            (optional)
     * @return NodeChildAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/secondary-children")
    Observable<ResultPaging<NodeRepresentation>> listSecondaryChildrenObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.ASSOC_TYPE_VALUE) String assocType,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems);

    /**
     * List secondary children Returns a list of secondary child nodes that are
     * associated with the current parent **nodeId**, via a secondary child
     * association.
     * 
     * @param nodeId The identifier of a parent node. (required)
     * @param assocType Restrict the returned results to only those of the given
     *            association type (optional)
     * @param where Optionally filter the list by assocType. Here&#39;s an
     *            example: *
     *            where&#x3D;(assocType&#x3D;&#39;my:specialAssocType&#39;)
     *            (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames * path * isLink * allowableOperations (optional)
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
     * @return NodeChildAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/secondary-children")
    Call<ResultPaging<NodeRepresentation>> listSecondaryChildrenCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.ASSOC_TYPE_VALUE) String assocType,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * List secondary children Returns a list of secondary child nodes that are
     * associated with the current parent **nodeId**, via a secondary child
     * association.
     *
     * @param nodeId The identifier of a parent node. (required)
     * @param assocType Restrict the returned results to only those of the given
     *            association type (optional)
     * @param where Optionally filter the list by assocType. Here&#39;s an
     *            example: *
     *            where&#x3D;(assocType&#x3D;&#39;my:specialAssocType&#39;)
     *            (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames * path * isLink * allowableOperations (optional)
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
     * @return NodeChildAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/secondary-children")
    Observable<ResultPaging<NodeRepresentation>> listSecondaryChildrenObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.ASSOC_TYPE_VALUE) String assocType,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) Integer skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) Integer maxItems,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Add secondary child Add secondary child association, with given
     * association type, between parent **nodeId** and child node.
     * 
     * @param nodeId The identifier of a parent node. (required)
     * @param childAssociationBody The child node id and assoc type. (required)
     * @return NodeChildAssocEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/secondary-children")
    Call<ChildAssociationRepresentation> createSecondaryChildAssocationCall(@Path("nodeId") String nodeId,
            @Body ChildAssociationBody childAssociationBody, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Add secondary child Add secondary child association, with given
     * association type, between parent **nodeId** and child node.
     *
     * @param nodeId The identifier of a parent node. (required)
     * @param childAssociationBody The child node id and assoc type. (required)
     * @return NodeChildAssocEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/secondary-children")
    Observable<ChildAssociationRepresentation> createSecondaryChildAssocationObservable(@Path("nodeId") String nodeId,
            @Body ChildAssociationBody childAssociationBody, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Remove secondary child (or children) Remove secondary child
     * association(s) between parent **nodeId** and child node for given
     * association type. If association type is not specified then multiple
     * secondary child association, of any type, will be removed specifically in
     * the direction from parent to secondary child. The child will still have a
     * primary parent and may still be associated as a secondary child with
     * other secondary parents.
     *
     * @param nodeId The identifier of a parent node. (required)
     * @param childId The identifier of a child node. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/secondary-children/{childId}")
    Call<Void> deleteSecondaryChildAssocationCall(@Path("nodeId") String nodeId, @Path("childId") String childId);

    /**
     * Remove secondary child (or children) Remove secondary child
     * association(s) between parent **nodeId** and child node for given
     * association type. If association type is not specified then multiple
     * secondary child association, of any type, will be removed specifically in
     * the direction from parent to secondary child. The child will still have a
     * primary parent and may still be associated as a secondary child with
     * other secondary parents.
     *
     * @param nodeId The identifier of a parent node. (required)
     * @param childId The identifier of a child node. (required)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/secondary-children/{childId}")
    Observable<Void> deleteSecondaryChildAssocationObservable(@Path("nodeId") String nodeId,
            @Path("childId") String childId);

    /**
     * Remove secondary child (or children) Remove secondary child
     * association(s) between parent **nodeId** and child node for given
     * association type. If association type is not specified then multiple
     * secondary child association, of any type, will be removed specifically in
     * the direction from parent to secondary child. The child will still have a
     * primary parent and may still be associated as a secondary child with
     * other secondary parents.
     * 
     * @param nodeId The identifier of a parent node. (required)
     * @param childId The identifier of a child node. (required)
     * @param assocType Restrict the delete to only those of the given
     *            association type (optional)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/secondary-children/{childId}")
    Call<Void> deleteSecondaryChildAssocationCall(@Path("nodeId") String nodeId, @Path("childId") String childId,
            @Query("assocType") String assocType);

    /**
     * Remove secondary child (or children) Remove secondary child
     * association(s) between parent **nodeId** and child node for given
     * association type. If association type is not specified then multiple
     * secondary child association, of any type, will be removed specifically in
     * the direction from parent to secondary child. The child will still have a
     * primary parent and may still be associated as a secondary child with
     * other secondary parents.
     *
     * @param nodeId The identifier of a parent node. (required)
     * @param childId The identifier of a child node. (required)
     * @param assocType Restrict the delete to only those of the given
     *            association type (optional)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/secondary-children/{childId}")
    Observable<Void> deleteSecondaryChildAssocationObservable(@Path("nodeId") String nodeId,
            @Path("childId") String childId, @Query("assocType") String assocType);

    // ///////////////////////////////////////////////////////////////////////////
    // ASSOCIATION SOURCES & TARGETS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * List node association Returns a list of source nodes that point to (ie.
     * are associated with) the current target **nodeId**.
     * 
     * @param nodeId The identifier of a target node. (required)
     * @return NodeAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/sources")
    Call<ResultPaging<NodeRepresentation>> listSourceAssociationsCall(@Path("nodeId") String nodeId);

    /**
     * List node association Returns a list of source nodes that point to (ie.
     * are associated with) the current target **nodeId**.
     *
     * @param nodeId The identifier of a target node. (required)
     * @return NodeAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/sources")
    Observable<ResultPaging<NodeRepresentation>> listSourceAssociationsObservable(@Path("nodeId") String nodeId);

    /**
     * List node association Returns a list of source nodes that point to (ie.
     * are associated with) the current target **nodeId**.
     * 
     * @param nodeId The identifier of a target node. (required)
     * @param where Optionally filter the list by assocType. Here&#39;s an
     *            example: *
     *            where&#x3D;(assocType&#x3D;&#39;my:specialAssocType&#39;)
     *            (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames * path * isLink * allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/sources")
    Call<ResultPaging<NodeRepresentation>> listSourceAssociationsCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * List node association Returns a list of source nodes that point to (ie.
     * are associated with) the current target **nodeId**.
     *
     * @param nodeId The identifier of a target node. (required)
     * @param where Optionally filter the list by assocType. Here&#39;s an
     *            example: *
     *            where&#x3D;(assocType&#x3D;&#39;my:specialAssocType&#39;)
     *            (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames * path * isLink * allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/sources")
    Observable<ResultPaging<NodeRepresentation>> listSourceAssociationsObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * List node association Returns a list of target nodes that are pointed to
     * (ie. are associated with) the current source **nodeId**.
     * 
     * @param nodeId The identifier of a source node. (required)
     * @return NodeAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/targets")
    Call<ResultPaging<NodeRepresentation>> listTargetAssociationsCall(@Path("nodeId") String nodeId);

    /**
     * List node association Returns a list of target nodes that are pointed to
     * (ie. are associated with) the current source **nodeId**.
     *
     * @param nodeId The identifier of a source node. (required)
     * @return NodeAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/targets")
    Observable<ResultPaging<NodeRepresentation>> listTargetAssociationsObservable(@Path("nodeId") String nodeId);

    /**
     * List node association Returns a list of target nodes that are pointed to
     * (ie. are associated with) the current source **nodeId**.
     * 
     * @param nodeId The identifier of a source node. (required)
     * @param where Optionally filter the list by assocType. Here&#39;s an
     *            example: *
     *            where&#x3D;(assocType&#x3D;&#39;my:specialAssocType&#39;)
     *            (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames * path * isLink * allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/targets")
    Call<ResultPaging<NodeRepresentation>> listTargetAssociationsCall(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * List node association Returns a list of target nodes that are pointed to
     * (ie. are associated with) the current source **nodeId**.
     *
     * @param nodeId The identifier of a source node. (required)
     * @param where Optionally filter the list by assocType. Here&#39;s an
     *            example: *
     *            where&#x3D;(assocType&#x3D;&#39;my:specialAssocType&#39;)
     *            (optional)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * properties *
     *            aspectNames * path * isLink * allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeAssocPaging
     */
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/targets")
    Observable<ResultPaging<NodeRepresentation>> listTargetAssociationsObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.WHERE_VALUE) String where,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Add node association Add association, with given association type,
     * between source **nodeId** and target node.
     * 
     * @param nodeId The identifier of a source node. (required)
     * @param associationBody The target node id and assoc type. (required)
     * @return NodeAssocEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/targets")
    Call<AssociationRepresentation> createAssocationCall(@Path("nodeId") String nodeId,
            @Body AssociationBody associationBody, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Add node association Add association, with given association type,
     * between source **nodeId** and target node.
     *
     * @param nodeId The identifier of a source node. (required)
     * @param associationBody The target node id and assoc type. (required)
     * @return NodeAssocEntry
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/targets")
    Observable<AssociationRepresentation> createAssociationObservable(@Path("nodeId") String nodeId,
            @Body AssociationBody associationBody, @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Remove node association(s) Remove association(s) from source **nodeId* to
     * target node for given association type. If association type is not
     * specified then multiple peer association, of any type, will be removed
     * specifically in the direction from source to target. It should be noted
     * that after removal of the peer association(s) from source to target, the
     * two nodes may still have peer association in the other direction.
     * 
     * @param nodeId The identifier of a source node. (required)
     * @param targetId The identifier of a target node. (required)
     * @param assocType Restrict the delete to only those of the given
     *            association type (optional)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/targets/{targetId}")
    Call<Void> deleteAssocationCall(@Path("nodeId") String nodeId, @Path("targetId") String targetId,
            @Query("assocType") String assocType);

    /**
     * Remove node association(s) Remove association(s) from source **nodeId* to
     * target node for given association type. If association type is not
     * specified then multiple peer association, of any type, will be removed
     * specifically in the direction from source to target. It should be noted
     * that after removal of the peer association(s) from source to target, the
     * two nodes may still have peer association in the other direction.
     *
     * @param nodeId The identifier of a source node. (required)
     * @param targetId The identifier of a target node. (required)
     * @param assocType Restrict the delete to only those of the given
     *            association type (optional)
     */
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/targets/{targetId}")
    Observable<Void> deleteAssociationObservable(@Path("nodeId") String nodeId, @Path("targetId") String targetId,
            @Query("assocType") String assocType);

    // ///////////////////////////////////////////////////////////////////////////
    // COPY / PASTE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Copy a node Copy the node **nodeId** to the parent folder node
     * **targetParentId**. The **targetParentId** is specified in the body body.
     * The new node has the same name as the source node unless you specify a
     * new **name** in the body body. If the source **nodeId** is a folder, then
     * all of its children are also copied.
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param copyBody The targetParentId and, optionally, a new name.
     *            (required)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/copy")
    Call<NodeRepresentation> copyNodeCall(@Path("nodeId") String nodeId, @Body NodeBodyCopy copyBody);

    /**
     * Copy a node Copy the node **nodeId** to the parent folder node
     * **targetParentId**. The **targetParentId** is specified in the body body.
     * The new node has the same name as the source node unless you specify a
     * new **name** in the body body. If the source **nodeId** is a folder, then
     * all of its children are also copied.
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param copyBody The targetParentId and, optionally, a new name.
     *            (required)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/copy")
    Observable<NodeRepresentation> copyNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyCopy copyBody);

    /**
     * Copy a node Copy the node **nodeId** to the parent folder node
     * **targetParentId**. The **targetParentId** is specified in the body body.
     * The new node has the same name as the source node unless you specify a
     * new **name** in the body body. If the source **nodeId** is a folder, then
     * all of its children are also copied.
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param copyBody The targetParentId and, optionally, a new name.
     *            (required)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{sourceNodeId}/copy")
    Call<NodeRepresentation> copyNodeCall(@Path("nodeId") String nodeId, @Body NodeBodyCopy copyBody,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Copy a node Copy the node **nodeId** to the parent folder node
     * **targetParentId**. The **targetParentId** is specified in the body body.
     * The new node has the same name as the source node unless you specify a
     * new **name** in the body body. If the source **nodeId** is a folder, then
     * all of its children are also copied.
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param copyBody The targetParentId and, optionally, a new name.
     *            (required)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{sourceNodeId}/copy")
    Observable<NodeRepresentation> copyNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyCopy copyBody,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Move a node Move the node **nodeId** to the parent folder node
     * **targetParentId**. in body body. The **targetParentId** is specified in
     * the in body body. The moved node retains its name unless you specify a
     * new **name** in the body body. If the source **nodeId** is a folder, then
     * all of its children are also moved. The moveNodeCall will effectively
     * change the primary parent
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param moveBody The targetParentId and, optionally, a new name.
     *            (required)
     * @return ApiResponse&lt;NodeRepresentation&gt;
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/move")
    Call<NodeRepresentation> moveNodeCall(@Path("nodeId") String nodeId, @Body NodeBodyCopy moveBody);

    /**
     * Move a node Move the node **nodeId** to the parent folder node
     * **targetParentId**. in body body. The **targetParentId** is specified in
     * the in body body. The moved node retains its name unless you specify a
     * new **name** in the body body. If the source **nodeId** is a folder, then
     * all of its children are also moved. The moveNodeCall will effectively
     * change the primary parent
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param moveBody The targetParentId and, optionally, a new name.
     *            (required)
     * @return ApiResponse&lt;NodeRepresentation&gt;
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/move")
    Observable<NodeRepresentation> moveNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyCopy moveBody);

    /**
     * Move a node Move the node **nodeId** to the parent folder node
     * **targetParentId**. in body body. The **targetParentId** is specified in
     * the in body body. The moved node retains its name unless you specify a
     * new **name** in the body body. If the source **nodeId** is a folder, then
     * all of its children are also moved. The moveNodeCall will effectively
     * change the primary parent
     * 
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param moveBody The targetParentId and, optionally, a new name.
     *            (required)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return ApiResponse&lt;NodeRepresentation&gt;
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/move")
    Call<NodeRepresentation> moveNodeCall(@Path("nodeId") String nodeId, @Body NodeBodyCopy moveBody,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Move a node Move the node **nodeId** to the parent folder node
     * **targetParentId**. in body body. The **targetParentId** is specified in
     * the in body body. The moved node retains its name unless you specify a
     * new **name** in the body body. If the source **nodeId** is a folder, then
     * all of its children are also moved. The moveNodeCall will effectively
     * change the primary parent
     *
     * @param nodeId The identifier of a node. You can also use one of these
     *            well-known aliases: * -my- * -shared- * -root- (required)
     * @param moveBody The targetParentId and, optionally, a new name.
     *            (required)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: * path * isLink *
     *            allowableOperations (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return ApiResponse&lt;NodeRepresentation&gt;
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/moveNodeCall")
    Observable<NodeRepresentation> moveNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyCopy moveBody,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // LOCK / UNLOCK
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Lock a node Places a lock on node **nodeId**. If **includeChildren** is
     * true, locks are also recursively placed on all of **nodeId**&#39;s
     * children. If any one of the child locks can&#39;t be taken then an
     * exception is raised and all locks canceled. The lock is owned by the
     * current user, and prevents other users or processes from making updates
     * to the node until the lock is released. If the **timeToExpire** is not
     * sent or is zero, then the lock never expires. Otherwise, the
     * **timeToExpire** is the number of seconds before the lock expires. When a
     * lock expires, the lock is released. If the node is already locked, and
     * the user is the lock owner, then the lock is renewed with the new
     * **timeToExpire**. By default, a lock is applied that allows the owner to
     * update, delete, and add children to the node. You can use **type** to
     * change the lock type to one of the following: * **FULL** no changes by
     * any user are allowed * **ALLOW_ADD_CHILDREN** children can be added but
     * the node itself cannot be updated or deleted by any user *
     * **ALLOW_OWNER_CHANGES** changes to the node can be made only by the lock
     * owner By default, a lock is persisted in the database. You can create a
     * volatile in-memory lock by setting the **lifetime** property to
     * EPHEMERAL.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param lockBody Lock details. (required)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/lock")
    Call<NodeRepresentation> lockNodeCall(@Path("nodeId") String nodeId, @Body NodeBodyLock lockBody);

    /**
     * Lock a node Places a lock on node **nodeId**. If **includeChildren** is
     * true, locks are also recursively placed on all of **nodeId**&#39;s
     * children. If any one of the child locks can&#39;t be taken then an
     * exception is raised and all locks canceled. The lock is owned by the
     * current user, and prevents other users or processes from making updates
     * to the node until the lock is released. If the **timeToExpire** is not
     * sent or is zero, then the lock never expires. Otherwise, the
     * **timeToExpire** is the number of seconds before the lock expires. When a
     * lock expires, the lock is released. If the node is already locked, and
     * the user is the lock owner, then the lock is renewed with the new
     * **timeToExpire**. By default, a lock is applied that allows the owner to
     * update, delete, and add children to the node. You can use **type** to
     * change the lock type to one of the following: * **FULL** no changes by
     * any user are allowed * **ALLOW_ADD_CHILDREN** children can be added but
     * the node itself cannot be updated or deleted by any user *
     * **ALLOW_OWNER_CHANGES** changes to the node can be made only by the lock
     * owner By default, a lock is persisted in the database. You can create a
     * volatile in-memory lock by setting the **lifetime** property to
     * EPHEMERAL.
     *
     * @param nodeId The identifier of a node. (required)
     * @param lockBody Lock details. (required)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/lock")
    Observable<NodeRepresentation> lockNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyLock lockBody);

    /**
     * Lock a node Places a lock on node **nodeId**. If **includeChildren** is
     * true, locks are also recursively placed on all of **nodeId**&#39;s
     * children. If any one of the child locks can&#39;t be taken then an
     * exception is raised and all locks canceled. The lock is owned by the
     * current user, and prevents other users or processes from making updates
     * to the node until the lock is released. If the **timeToExpire** is not
     * sent or is zero, then the lock never expires. Otherwise, the
     * **timeToExpire** is the number of seconds before the lock expires. When a
     * lock expires, the lock is released. If the node is already locked, and
     * the user is the lock owner, then the lock is renewed with the new
     * **timeToExpire**. By default, a lock is applied that allows the owner to
     * update, delete, and add children to the node. You can use **type** to
     * change the lock type to one of the following: * **FULL** no changes by
     * any user are allowed * **ALLOW_ADD_CHILDREN** children can be added but
     * the node itself cannot be updated or deleted by any user *
     * **ALLOW_OWNER_CHANGES** changes to the node can be made only by the lock
     * owner By default, a lock is persisted in the database. You can create a
     * volatile in-memory lock by setting the **lifetime** property to
     * EPHEMERAL.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param lockBody Lock details. (required)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: *
     *            allowableOperations * isLink * isLocked * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/lock")
    Call<NodeRepresentation> lockNodeCall(@Path("nodeId") String nodeId, @Body NodeBodyLock lockBody,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Lock a node Places a lock on node **nodeId**. If **includeChildren** is
     * true, locks are also recursively placed on all of **nodeId**&#39;s
     * children. If any one of the child locks can&#39;t be taken then an
     * exception is raised and all locks canceled. The lock is owned by the
     * current user, and prevents other users or processes from making updates
     * to the node until the lock is released. If the **timeToExpire** is not
     * sent or is zero, then the lock never expires. Otherwise, the
     * **timeToExpire** is the number of seconds before the lock expires. When a
     * lock expires, the lock is released. If the node is already locked, and
     * the user is the lock owner, then the lock is renewed with the new
     * **timeToExpire**. By default, a lock is applied that allows the owner to
     * update, delete, and add children to the node. You can use **type** to
     * change the lock type to one of the following: * **FULL** no changes by
     * any user are allowed * **ALLOW_ADD_CHILDREN** children can be added but
     * the node itself cannot be updated or deleted by any user *
     * **ALLOW_OWNER_CHANGES** changes to the node can be made only by the lock
     * owner By default, a lock is persisted in the database. You can create a
     * volatile in-memory lock by setting the **lifetime** property to
     * EPHEMERAL.
     *
     * @param nodeId The identifier of a node. (required)
     * @param lockBody Lock details. (required)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: *
     *            allowableOperations * isLink * isLocked * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/lock")
    Observable<NodeRepresentation> lockNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyLock lockBody,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Unlock a node Removes a lock on node **nodeId**. If **includeChildren**
     * is true, all **nodeId&#39;s** children are also unlocked recursively. Any
     * children without locks are ignored, and the operation continues for all
     * other children. If the node or any of its children are currently
     * checked-out, then an error is returned. You can override this behaviour
     * by setting **allowCheckedOut**. The current user must be the owner of the
     * locks or have admin rights, otherwise an error is returned. If a lock on
     * the node, or on any child node if unlocking children, cannot be released,
     * then an error is returned.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param unlockBody Unlock details. (required)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/unlock")
    Call<NodeRepresentation> unlockNodeCall(@Path("nodeId") String nodeId, @Body NodeBodyUnLock unlockBody);

    /**
     * Unlock a node Removes a lock on node **nodeId**. If **includeChildren**
     * is true, all **nodeId&#39;s** children are also unlocked recursively. Any
     * children without locks are ignored, and the operation continues for all
     * other children. If the node or any of its children are currently
     * checked-out, then an error is returned. You can override this behaviour
     * by setting **allowCheckedOut**. The current user must be the owner of the
     * locks or have admin rights, otherwise an error is returned. If a lock on
     * the node, or on any child node if unlocking children, cannot be released,
     * then an error is returned.
     *
     * @param nodeId The identifier of a node. (required)
     * @param unlockBody Unlock details. (required)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/unlock")
    Observable<NodeRepresentation> unlockNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyUnLock unlockBody);

    /**
     * Unlock a node Removes a lock on node **nodeId**. If **includeChildren**
     * is true, all **nodeId&#39;s** children are also unlocked recursively. Any
     * children without locks are ignored, and the operation continues for all
     * other children. If the node or any of its children are currently
     * checked-out, then an error is returned. You can override this behaviour
     * by setting **allowCheckedOut**. The current user must be the owner of the
     * locks or have admin rights, otherwise an error is returned. If a lock on
     * the node, or on any child node if unlocking children, cannot be released,
     * then an error is returned.
     * 
     * @param nodeId The identifier of a node. (required)
     * @param unlockBody Unlock details. (required)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: *
     *            allowableOperations * isLink * isLocked * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/unlock")
    Call<NodeRepresentation> unlockNodeCall(@Path("nodeId") String nodeId, @Body NodeBodyUnLock unlockBody,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

    /**
     * Unlock a node Removes a lock on node **nodeId**. If **includeChildren**
     * is true, all **nodeId&#39;s** children are also unlocked recursively. Any
     * children without locks are ignored, and the operation continues for all
     * other children. If the node or any of its children are currently
     * checked-out, then an error is returned. You can override this behaviour
     * by setting **allowCheckedOut**. The current user must be the owner of the
     * locks or have admin rights, otherwise an error is returned. If a lock on
     * the node, or on any child node if unlocking children, cannot be released,
     * then an error is returned.
     *
     * @param nodeId The identifier of a node. (required)
     * @param unlockBody Unlock details. (required)
     * @param include Returns additional information about the node. The
     *            following optional fields can be requested: *
     *            allowableOperations * isLink * isLocked * path (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return NodeRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/unlock")
    Observable<NodeRepresentation> unlockNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyUnLock unlockBody,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

}
