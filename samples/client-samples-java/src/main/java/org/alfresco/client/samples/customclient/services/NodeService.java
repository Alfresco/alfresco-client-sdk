package org.alfresco.client.samples.customclient.services;

import static org.alfresco.client.services.common.constant.ApiConstant.*;

import org.alfresco.client.samples.customclient.model.Node;
import org.alfresco.client.services.common.model.parameters.OrderByParam;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.core.CoreConstant;
import org.alfresco.client.services.content.core.model.body.NodeBodyCreate;
import org.alfresco.client.services.content.core.model.body.NodeBodyUpdate;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface NodeService
{
    String FOLDER_ROOT = "-root-";

    String FOLDER_MY = "-my-";

    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/-root-")
    Call<Node> getRootNode();

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/-root")
    Observable<Node> getRootNodeObservable();

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Call<Node> getNodeByIdentifier(@Path(NODE_ID) String nodeId);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Observable<Node> getNodeByIdentifierObservable(@Path(NODE_ID) String nodeId);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<ResultPaging<Node>> getChildren(@Path(NODE_ID) String nodeId);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<ResultPaging<Node>> getChildrenObservable(@Path(NODE_ID) String nodeId);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<ResultPaging<Node>> getChildren(@Path(NODE_ID) String nodeId, @Query(SKIP_COUNT) Integer skipCount,
            @Query(MAX_ITEMS) Integer maxItems, @Query(ORDER_BY) OrderByParam orderBy);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<ResultPaging<Node>> getChildrenObservable(@Path(NODE_ID) String nodeId,
            @Query(SKIP_COUNT) Integer skipCount, @Query(MAX_ITEMS) Integer maxItems,
            @Query(ORDER_BY) OrderByParam orderBy);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<ResultPaging<Node>> getChildren(@Path(NODE_ID) String nodeId, @Query(SKIP_COUNT) Integer skipCount,
            @Query(MAX_ITEMS) Integer maxItems, @Query(ORDER_BY) OrderByParam orderBy, @Query(WHERE) String where,
            @Query(FIELDS) String fields);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<ResultPaging<Node>> getChildrenObservable(@Path(NODE_ID) String nodeId, @Query(SKIP_COUNT) int skipCount,
            @Query(MAX_ITEMS) int maxItems, @Query(ORDER_BY) OrderByParam orderBy, @Query(WHERE) String where,
            @Query(FIELDS) String fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<Node> createNode(@Path(NODE_ID) String nodeId, @Body NodeBodyCreate body);

    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<Node> createNodeObservable(@Path(NODE_ID) String nodeId, @Body NodeBodyCreate body);

    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<Node> createNode(@Path(NODE_ID) String nodeId, @Body NodeBodyCreate body,
            @Query(AUTO_RENAME) boolean autoRename, @Query(FIELDS) String fields);

    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<Node> createNodeObservable(@Path(NODE_ID) String nodeId, @Body NodeBodyCreate body,
            @Query(AUTO_RENAME) boolean autoRename, @Query(FIELDS) String fields);

    @Multipart
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<Node> createFile(@Path(NODE_ID) String nodeId, @Part(FILEDATA) RequestBody file);

    @Multipart
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<Node> createFileObservable(@Path(NODE_ID) String nodeId, @Part(FILEDATA) RequestBody file);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Call<Node> updateProperties(@Path(NODE_ID) String nodeId, @Body NodeBodyUpdate body);

    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Observable<Node> updatePropertiesObservable(@Path(NODE_ID) String nodeId, @Body NodeBodyUpdate body);

    @Multipart
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Call<Node> updateContent(@Path(NODE_ID) String nodeId, @Part(FILEDATA) RequestBody file);

    @Multipart
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Observable<Node> updateContentObservable(@Path(NODE_ID) String nodeId, @Part(FILEDATA) RequestBody file);

    // ///////////////////////////////////////////////////////////////////////////
    // DOWNLOAD
    // ///////////////////////////////////////////////////////////////////////////
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Call<ResponseBody> getContent(@Path(NODE_ID) String nodeId);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Observable<ResponseBody> getContentObservable(@Path(NODE_ID) String nodeId);

    // ///////////////////////////////////////////////////////////////////////////
    // REMOVE
    // ///////////////////////////////////////////////////////////////////////////
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Call<Void> deleteNode(@Path(NODE_ID) String nodeId);

    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Observable<Void> deleteNodeObservable(@Path(NODE_ID) String nodeId);

}
