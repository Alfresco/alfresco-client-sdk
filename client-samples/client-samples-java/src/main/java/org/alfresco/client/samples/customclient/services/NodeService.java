package org.alfresco.client.samples.customclient.services;

import org.alfresco.client.samples.customclient.model.Node;

import com.alfresco.client.api.common.constant.PublicAPIConstant;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.CoreConstant;
import com.alfresco.client.api.core.model.body.NodeBodyCreate;
import com.alfresco.client.api.core.model.body.NodeBodyUpdate;
import com.alfresco.client.api.core.model.parameters.OrderByParam;

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
    Call<Node> getNodeByIdentifier(@Path("nodeId") String nodeId);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Observable<Node> getNodeByIdentifierObservable(@Path("nodeId") String nodeId);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<ResultPaging<Node>> getChildren(@Path("nodeId") String nodeId);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<ResultPaging<Node>> getChildrenObservable(@Path("nodeId") String nodeId);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<ResultPaging<Node>> getChildren(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) int skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) int maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<ResultPaging<Node>> getChildrenObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) int skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) int maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<ResultPaging<Node>> getChildren(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) int skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) int maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy,
            @Query(PublicAPIConstant.WHERE_VALUE) String where, @Query(PublicAPIConstant.FIELDS_VALUE) String fields);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<ResultPaging<Node>> getChildrenObservable(@Path("nodeId") String nodeId,
            @Query(PublicAPIConstant.SKIP_COUNT_VALUE) int skipCount,
            @Query(PublicAPIConstant.MAX_ITEMS_VALUE) int maxItems,
            @Query(PublicAPIConstant.ORDER_BY_VALUE) OrderByParam orderBy,
            @Query(PublicAPIConstant.WHERE_VALUE) String where, @Query(PublicAPIConstant.FIELDS_VALUE) String fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<Node> createNode(@Path("nodeId") String nodeId, @Body NodeBodyCreate body);

    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<Node> createNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyCreate body);

    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<Node> createNode(@Path("nodeId") String nodeId, @Body NodeBodyCreate body,
            @Query(PublicAPIConstant.AUTO_RENAME_VALUE) boolean autoRename,
            @Query(PublicAPIConstant.FIELDS_VALUE) String fields);

    @Headers({ "Content-type: application/json" })
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<Node> createNodeObservable(@Path("nodeId") String nodeId, @Body NodeBodyCreate body,
            @Query(PublicAPIConstant.AUTO_RENAME_VALUE) boolean autoRename,
            @Query(PublicAPIConstant.FIELDS_VALUE) String fields);

    @Multipart
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Call<Node> createFile(@Path("nodeId") String nodeId, @Part("filedata") RequestBody file);

    @Multipart
    @POST(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/children")
    Observable<Node> createFileObservable(@Path("nodeId") String nodeId, @Part("filedata") RequestBody file);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Call<Node> updateProperties(@Path("nodeId") String nodeId, @Body NodeBodyUpdate body);

    @Headers({ "Content-type: application/json" })
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Observable<Node> updatePropertiesObservable(@Path("nodeId") String nodeId, @Body NodeBodyUpdate body);

    @Multipart
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Call<Node> updateContent(@Path("nodeId") String nodeId, @Part("filedata") RequestBody file);

    @Multipart
    @PUT(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Observable<Node> updateContentObservable(@Path("nodeId") String nodeId, @Part("filedata") RequestBody file);

    // ///////////////////////////////////////////////////////////////////////////
    // DOWNLOAD
    // ///////////////////////////////////////////////////////////////////////////
    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Call<ResponseBody> getContent(@Path("nodeId") String nodeId);

    @GET(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}/content")
    Observable<ResponseBody> getContentObservable(@Path("nodeId") String nodeId);

    // ///////////////////////////////////////////////////////////////////////////
    // REMOVE
    // ///////////////////////////////////////////////////////////////////////////
    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Call<Void> deleteNode(@Path("nodeId") String nodeId);

    @DELETE(CoreConstant.CORE_PUBLIC_API_V1 + "/nodes/{nodeId}")
    Observable<Void> deleteNodeObservable(@Path("nodeId") String nodeId);

}
