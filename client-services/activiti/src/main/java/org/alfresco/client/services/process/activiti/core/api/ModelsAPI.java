package org.alfresco.client.services.process.activiti.core.api;

import static org.alfresco.client.services.process.activiti.common.constant.RequestConstant.*;
import static org.alfresco.client.services.process.activiti.core.ActivitiConstant.ACTIVITI_SERVICE_PATH;

import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;
import org.alfresco.client.services.process.activiti.core.model.body.ModelRequest;
import org.alfresco.client.services.process.activiti.core.model.representation.ModelResponse;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 03/05/2017.
 */
public interface ModelsAPI
{

    /**
     * Create a model All request values are optional. For example, you can only
     * include the name attribute in the request body JSON-object, only setting
     * the name of the model, leaving all other fields null.
     * 
     * @param body (optional)
     * @return ModelResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/repository/models")
    Call<ModelResponse> createModelCall(@Body ModelRequest body);

    /**
     * Delete a model
     *
     * @param modelId The id of the model to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/repository/models/{modelId}")
    Call<Void> deleteModelCall(@Path(MODEL_ID) String modelId);

    /**
     * Get a model
     *
     * @param modelId The id of the model to get. (required)
     * @return ModelResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/models/{modelId}")
    Call<ModelResponse> getModelCall(@Path(MODEL_ID) String modelId);

    /**
     * Get a list of models
     *
     * @param id Only return models with the given version. (optional)
     * @param category Only return models with the given category. (optional)
     * @param categoryLike Only return models with a category like the given
     *            name. (optional)
     * @param categoryNotEquals Only return models which don?t have the given
     *            category. (optional)
     * @param name Only return models with the given name. (optional)
     * @param nameLike Only return models with a name like the given name.
     *            (optional)
     * @param key Only return models with the given key. (optional)
     * @param deploymentId Only return models with the given category.
     *            (optional)
     * @param version Only return models with the given version. (optional)
     * @param latestVersion If true, only return models which are the latest
     *            version. Best used in combination with key. If false is passed
     *            in as value, this is ignored and all versions are returned.
     *            (optional)
     * @param deployed If true, only deployed models are returned. If false,
     *            only undeployed models are returned (deploymentId is null).
     *            (optional)
     * @param tenantId Only return models with the given tenantId. (optional)
     * @param tenantIdLike Only return models with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns models without a tenantId
     *            set. If false, the withoutTenantId parameter is ignored.
     *            (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/models")
    Call<ResultList<ModelResponse>> getModelsCall(@Query(ID) String id, @Query(CATEGORY) String category,
            @Query(CATEGORY_LIKE) String categoryLike, @Query(CATEGORY_NOT_EQUALS) String categoryNotEquals,
            @Query(NAME) String name, @Query(NAME_LIKE) String nameLike, @Query(KEY) String key,
            @Query(DEPLOYMENT_ID) String deploymentId, @Query(VERSION) Integer version,
            @Query(LATEST_VERSION) Boolean latestVersion, @Query(DEPLOYED) Boolean deployed,
            @Query(TENANT_ID) String tenantId, @Query(TENANT_ID_LIKE) String tenantIdLike,
            @Query(WITHOUT_TENANT_ID) Boolean withoutTenantId, @Query(SORT) Boolean sort);

    /**
     * Update a model All request values are optional. For example, you can only
     * include the name attribute in the request body JSON-object, only updating
     * the name of the model, leaving all other fields unaffected. When an
     * attribute is explicitly included and is set to null, the model-value will
     * be updated to null. Example: &#x60;&#x60;&#x60;JSON
     * {\&quot;metaInfo\&quot; : null}&#x60;&#x60;&#x60; will clear the metaInfo
     * of the model).
     * 
     * @param modelId (required)
     * @param body (optional)
     * @return ModelResponse
     */
    @PUT(ACTIVITI_SERVICE_PATH + "/repository/models/{modelId}")
    Call<ModelResponse> updateModelCall(@Path(MODEL_ID) String modelId, @Body ModelRequest body);

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
     * Create a model All request values are optional. For example, you can only
     * include the name attribute in the request body JSON-object, only setting
     * the name of the model, leaving all other fields null.
     *
     * @param body (optional)
     * @return ModelResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/repository/models")
    Observable<ModelResponse> createModelObservable(@Body ModelRequest body);

    /**
     * Delete a model
     *
     * @param modelId The id of the model to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/repository/models/{modelId}")
    Observable<Void> deleteModelObservable(@Path(MODEL_ID) String modelId);

    /**
     * Get a model
     *
     * @param modelId The id of the model to get. (required)
     * @return ModelResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/models/{modelId}")
    Observable<ModelResponse> getModelObservable(@Path(MODEL_ID) String modelId);

    /**
     * Get a list of models
     *
     * @param id Only return models with the given version. (optional)
     * @param category Only return models with the given category. (optional)
     * @param categoryLike Only return models with a category like the given
     *            name. (optional)
     * @param categoryNotEquals Only return models which don?t have the given
     *            category. (optional)
     * @param name Only return models with the given name. (optional)
     * @param nameLike Only return models with a name like the given name.
     *            (optional)
     * @param key Only return models with the given key. (optional)
     * @param deploymentId Only return models with the given category.
     *            (optional)
     * @param version Only return models with the given version. (optional)
     * @param latestVersion If true, only return models which are the latest
     *            version. Best used in combination with key. If false is passed
     *            in as value, this is ignored and all versions are returned.
     *            (optional)
     * @param deployed If true, only deployed models are returned. If false,
     *            only undeployed models are returned (deploymentId is null).
     *            (optional)
     * @param tenantId Only return models with the given tenantId. (optional)
     * @param tenantIdLike Only return models with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns models without a tenantId
     *            set. If false, the withoutTenantId parameter is ignored.
     *            (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/models")
    Observable<ResultList<ModelResponse>> getModelsObservable(@Query(ID) String id, @Query(CATEGORY) String category,
            @Query(CATEGORY_LIKE) String categoryLike, @Query(CATEGORY_NOT_EQUALS) String categoryNotEquals,
            @Query(NAME) String name, @Query(NAME_LIKE) String nameLike, @Query(KEY) String key,
            @Query(DEPLOYMENT_ID) String deploymentId, @Query(VERSION) Integer version,
            @Query(LATEST_VERSION) Boolean latestVersion, @Query("deployed") Boolean deployed,
            @Query(TENANT_ID) String tenantId, @Query(TENANT_ID_LIKE) String tenantIdLike,
            @Query(WITHOUT_TENANT_ID) Boolean withoutTenantId, @Query(SORT) Boolean sort);

    /**
     * Update a model All request values are optional. For example, you can only
     * include the name attribute in the request body JSON-object, only updating
     * the name of the model, leaving all other fields unaffected. When an
     * attribute is explicitly included and is set to null, the model-value will
     * be updated to null. Example: &#x60;&#x60;&#x60;JSON
     * {\&quot;metaInfo\&quot; : null}&#x60;&#x60;&#x60; will clear the metaInfo
     * of the model).
     *
     * @param modelId (required)
     * @param body (optional)
     * @return ModelResponse
     */
    @PUT(ACTIVITI_SERVICE_PATH + "/repository/models/{modelId}")
    Observable<ModelResponse> updateModelObservable(@Path(MODEL_ID) String modelId, @Body ModelRequest body);

}
