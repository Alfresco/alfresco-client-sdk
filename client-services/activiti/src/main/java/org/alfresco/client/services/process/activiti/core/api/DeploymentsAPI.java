package org.alfresco.client.services.process.activiti.core.api;

import static org.alfresco.client.services.process.activiti.common.constant.RequestConstant.*;
import static org.alfresco.client.services.process.activiti.core.ActivitiConstant.ACTIVITI_SERVICE_PATH;

import java.util.List;

import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;
import org.alfresco.client.services.process.activiti.core.model.representation.DeploymentResourceResponse;
import org.alfresco.client.services.process.activiti.core.model.representation.DeploymentResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 03/05/2017.
 */
public interface DeploymentsAPI
{

    /**
     * Delete a deployment
     *
     * @param deploymentId The id of the deployment to delete. (required)
     * @param cascade (optional)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/repository/deployments{deploymentId}")
    Call<Void> deleteDeploymentCall(@Path(DEPLOYMENT_ID) String deploymentId, @Query(CASCADE) Boolean cascade);

    /**
     * Get a deployment
     *
     * @param deploymentId The id of the deployment to get. (required)
     * @return DeploymentResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/deployments{deploymentId}")
    Call<DeploymentResponse> getDeploymentCall(@Path(DEPLOYMENT_ID) String deploymentId);

    /**
     * Get a deployment resource
     * 
     * @param deploymentId The id of the deployment the requested resource is
     *            part of. (required)
     * @param resourceId The id of the resource the requested resource is part
     *            of. (required)
     * @return DeploymentResourceResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/deployments/{deploymentId}/resources/{resourceId}")
    Call<DeploymentResourceResponse> getDeploymentResourceCall(@Path(DEPLOYMENT_ID) String deploymentId,
            @Path(RESOURCE_ID) String resourceId);

    /**
     * Get a deployment resource content The response body will contain the
     * binary resource-content for the requested resource. The response
     * content-type will be the same as the type returned in the resources
     * mimeType property. Also, a content-disposition header is set, allowing
     * browsers to download the file instead of displaying it.
     * 
     * @param deploymentId The id of the deployment the requested resource is
     *            part of. (required)
     * @param resourceId The id of the resource to get the data for. Make sure
     *            you URL-encode the resourceId in case it contains forward
     *            slashes. Eg: use diagrams%2Fmy-process.bpmn20.xml instead of
     *            diagrams/Fmy-process.bpmn20.xml. (required)
     * @return RequestBody
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/deployments/{deploymentId}/resourcedata/{resourceId}")
    Call<RequestBody> getDeploymentResourceDataCall(@Path(DEPLOYMENT_ID) String deploymentId,
            @Path(RESOURCE_ID) String resourceId);

    /**
     * List resources in a deployment The dataUrl property in the resulting JSON
     * for a single resource contains the actual URL to use for retrieving the
     * binary resource.
     * 
     * @param deploymentId The id of the deployment to get the resources for.
     *            (required)
     * @return List&lt;DeploymentResourceResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/deployments/{deploymentId}/resources")
    Call<List<DeploymentResourceResponse>> getDeploymentResourcesCall(@Path(DEPLOYMENT_ID) String deploymentId);

    /**
     * List of Deployments
     *
     * @param name Only return deployments with the given name. (optional)
     * @param nameLike Only return deployments with a name like the given name.
     *            (optional)
     * @param category Only return deployments with the given category.
     *            (optional)
     * @param categoryNotEquals Only return deployments which don?t have the
     *            given category. (optional)
     * @param tenantId Only return deployments with the given tenantId.
     *            (optional)
     * @param tenantIdLike Only return deployments with a tenantId like the
     *            given value. (optional)
     * @param withoutTenantId If true, only returns deployments without a
     *            tenantId set. If false, the withoutTenantId parameter is
     *            ignored. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/deployments")
    Call<ResultList<DeploymentResponse>> getDeploymentsCall(@Query(NAME) String name, @Query(NAME_LIKE) String nameLike,
            @Query(CATEGORY) String category, @Query(CATEGORY_NOT_EQUALS) String categoryNotEquals,
            @Query(TENANT_ID) String tenantId, @Query(TENANT_ID_LIKE) String tenantIdLike,
            @Query(WITHOUT_TENANT_ID) Boolean withoutTenantId, @Query(SORT) String sort);

    @GET(ACTIVITI_SERVICE_PATH + "/repository/deployments")
    Call<ResultList<DeploymentResponse>> getDeploymentsCall();

    /**
     * Create a new deployment The request body should contain data of type
     * multipart/form-data. There should be exactly one file in the request, any
     * additional files will be ignored. If multiple resources need to be
     * deployed in a single deployment, compress the resources in a zip and make
     * sure the file-name ends with .bar or .zip. An additional parameter
     * (form-field) can be passed in the request body with name tenantId. The
     * value of this field will be used as the id of the tenant this deployment
     * is done in.
     *
     * @param tenantId (optional)
     * @return DeploymentResponse
     */
    @Multipart
    @POST(ACTIVITI_SERVICE_PATH + "/repository/deployments")
    Call<DeploymentResponse> uploadDeploymentCall(@Part(FILE) RequestBody file, @Query(TENANT_ID) String tenantId);

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

    /**
     * Delete a deployment
     *
     * @param deploymentId The id of the deployment to delete. (required)
     * @param cascade (optional)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/repository/deployments{deploymentId}")
    Observable<Void> deleteDeploymentObservable(@Path(DEPLOYMENT_ID) String deploymentId,
            @Query(CASCADE) Boolean cascade);

    /**
     * Get a deployment
     *
     * @param deploymentId The id of the deployment to get. (required)
     * @return DeploymentResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/deployments{deploymentId}")
    Observable<DeploymentResponse> getDeploymentObservable(@Path(DEPLOYMENT_ID) String deploymentId);

    /**
     * Get a deployment resource
     *
     * @param deploymentId The id of the deployment the requested resource is
     *            part of. (required)
     * @param resourceId The id of the resource the requested resource is part
     *            of. (required)
     * @return DeploymentResourceResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/deployments/{deploymentId}/resources/{resourceId}")
    Observable<DeploymentResourceResponse> getDeploymentResourceObservable(@Path(DEPLOYMENT_ID) String deploymentId,
            @Path(RESOURCE_ID) String resourceId);

    /**
     * Get a deployment resource content The response body will contain the
     * binary resource-content for the requested resource. The response
     * content-type will be the same as the type returned in the resources
     * mimeType property. Also, a content-disposition header is set, allowing
     * browsers to download the file instead of displaying it.
     *
     * @param deploymentId The id of the deployment the requested resource is
     *            part of. (required)
     * @param resourceId The id of the resource to get the data for. Make sure
     *            you URL-encode the resourceId in case it contains forward
     *            slashes. Eg: use diagrams%2Fmy-process.bpmn20.xml instead of
     *            diagrams/Fmy-process.bpmn20.xml. (required)
     * @return RequestBody
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/deployments/{deploymentId}/resourcedata/{resourceId}")
    Observable<RequestBody> getDeploymentResourceDataObservable(@Path(DEPLOYMENT_ID) String deploymentId,
            @Path(RESOURCE_ID) String resourceId);

    /**
     * List resources in a deployment The dataUrl property in the resulting JSON
     * for a single resource contains the actual URL to use for retrieving the
     * binary resource.
     *
     * @param deploymentId The id of the deployment to get the resources for.
     *            (required)
     * @return List&lt;DeploymentResourceResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/deployments/{deploymentId}/resources")
    Observable<List<DeploymentResourceResponse>> getDeploymentResourcesObservable(
            @Path(DEPLOYMENT_ID) String deploymentId);

    /**
     * List of Deployments
     *
     * @param name Only return deployments with the given name. (optional)
     * @param nameLike Only return deployments with a name like the given name.
     *            (optional)
     * @param category Only return deployments with the given category.
     *            (optional)
     * @param categoryNotEquals Only return deployments which don?t have the
     *            given category. (optional)
     * @param tenantId Only return deployments with the given tenantId.
     *            (optional)
     * @param tenantIdLike Only return deployments with a tenantId like the
     *            given value. (optional)
     * @param withoutTenantId If true, only returns deployments without a
     *            tenantId set. If false, the withoutTenantId parameter is
     *            ignored. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/deployments")
    Observable<ResultList<DeploymentResourceResponse>> getDeploymentsObservable(@Query(NAME) String name,
            @Query(NAME_LIKE) String nameLike, @Query(CATEGORY) String category,
            @Query(CATEGORY_NOT_EQUALS) String categoryNotEquals, @Query(TENANT_ID) String tenantId,
            @Query(TENANT_ID_LIKE) String tenantIdLike, @Query(WITHOUT_TENANT_ID) String withoutTenantId,
            @Query(SORT) String sort);

    /**
     * Create a new deployment The request body should contain data of type
     * multipart/form-data. There should be exactly one file in the request, any
     * additional files will be ignored. If multiple resources need to be
     * deployed in a single deployment, compress the resources in a zip and make
     * sure the file-name ends with .bar or .zip. An additional parameter
     * (form-field) can be passed in the request body with name tenantId. The
     * value of this field will be used as the id of the tenant this deployment
     * is done in.
     *
     * @param tenantId (optional)
     * @return DeploymentResponse
     */
    @Multipart
    @POST(ACTIVITI_SERVICE_PATH + "/repository/deployments")
    Observable<DeploymentResponse> uploadDeploymentObservable(@Part(FILE) RequestBody file,
            @Query(TENANT_ID) String tenantId);

}
