package org.alfresco.client.services.process.activiti.core.api;

import static org.alfresco.client.services.process.activiti.common.constant.RequestConstant.*;
import static org.alfresco.client.services.process.activiti.core.ActivitiConstant.ACTIVITI_SERVICE_PATH;

import java.util.List;

import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;
import org.alfresco.client.services.process.activiti.core.model.body.ProcessDefinitionActionRequest;
import org.alfresco.client.services.process.activiti.core.model.representation.ProcessDefinitionResponse;
import org.alfresco.client.services.process.activiti.core.model.representation.RestIdentityLink;
import org.alfresco.client.services.process.activiti.core.model.representation.bpmn.BpmnModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 03/05/2017.
 */
public interface ProcessDefinitionsAPI
{

    /**
     * Add a candidate starter to a process definition ## For a User
     * &#x60;&#x60;&#x60;JSON { \&quot;user\&quot; : \&quot;kermit\&quot; }
     * &#x60;&#x60;&#x60; ## For a Group &#x60;&#x60;&#x60;JSON {
     * \&quot;groupId\&quot; : \&quot;sales\&quot; } &#x60;&#x60;&#x60;
     * 
     * @param processDefinitionId The id of the process definition. (required)
     * @param body (optional)
     * @return RestIdentityLink
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}/identitylinks")
    Call<RestIdentityLink> createIdentityLinkCall(@Path(PROCESS_DEFINITION_ID) String processDefinitionId,
            @Body RestIdentityLink body);

    /**
     * Delete a candidate starter from a process definition
     *
     * @param processDefinitionId The id of the process definition. (required)
     * @param family Either users or groups, depending on the type of identity
     *            link. (required)
     * @param identityId Either the user or group of the identity to remove as
     *            candidate starter. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH
            + "/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}")
    Call<Void> deleteIdentityLinkCall(@Path(PROCESS_DEFINITION_ID) String processDefinitionId,
            @Path(FAMILY) String family, @Path(IDENTITY_ID) String identityId);

    /**
     * Execute actions for a process definition (Update category, Suspend or
     * Activate) ## Update category for a process definition
     * &#x60;&#x60;&#x60;JSON { \&quot;category\&quot; :
     * \&quot;updatedcategory\&quot; } &#x60;&#x60;&#x60; ## Suspend a process
     * definition &#x60;&#x60;&#x60;JSON { \&quot;action\&quot; :
     * \&quot;suspend\&quot;, \&quot;includeProcessInstances\&quot; :
     * \&quot;false\&quot;, \&quot;date\&quot; :
     * \&quot;2013-04-15T00:42:12Z\&quot; } &#x60;&#x60;&#x60; ## Activate a
     * process definition &#x60;&#x60;&#x60;JSON { \&quot;action\&quot; :
     * \&quot;activate\&quot;, \&quot;includeProcessInstances\&quot; :
     * \&quot;true\&quot;, \&quot;date\&quot; :
     * \&quot;2013-04-15T00:42:12Z\&quot; } &#x60;&#x60;&#x60;
     * 
     * @param processDefinitionId (required)
     * @param body (required)
     * @return ProcessDefinitionResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}")
    Call<ProcessDefinitionResponse> executeProcessDefinitionActionCall(
            @Path(PROCESS_DEFINITION_ID) String processDefinitionId, @Body ProcessDefinitionActionRequest body);

    /**
     * Get a process definition BPMN model
     *
     * @param processDefinitionId The id of the process definition to get the
     *            model for. (required)
     * @return BpmnModel
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}/model")
    Call<BpmnModel> getBpmnModelResourceCall(@Path(PROCESS_DEFINITION_ID) String processDefinitionId);

    /**
     * Get a candidate starter from a process definition
     *
     * @param processDefinitionId The id of the process definition. (required)
     * @param family Either users or groups, depending on the type of identity
     *            link. (required)
     * @param identityId Either the user or group of the identity to get as
     *            candidate starter. (required)
     * @return RestIdentityLink
     */
    @GET(ACTIVITI_SERVICE_PATH
            + "/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}")
    Call<RestIdentityLink> getIdentityLinkCall(@Path(PROCESS_DEFINITION_ID) String processDefinitionId,
            @Path(FAMILY) String family, @Path(IDENTITY_ID) String identityId);

    /**
     * Get all candidate starters for a process-definition
     *
     * @param processDefinitionId The id of the process definition to get the
     *            identity links for. (required)
     * @return List&lt;RestIdentityLink&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}/identitylinks")
    Call<List<RestIdentityLink>> getIdentityLinksCall(@Path(PROCESS_DEFINITION_ID) String processDefinitionId);

    /**
     * Get a process definition image
     *
     * @param processDefinitionId (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}/image")
    Call<RequestBody> getModelResourceCall(@Path(PROCESS_DEFINITION_ID) String processDefinitionId);

    /**
     * Get a process definition
     *
     * @param processDefinitionId The id of the process definition to get.
     *            (required)
     * @return ProcessDefinitionResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}")
    Call<ProcessDefinitionResponse> getProcessDefinitionCall(@Path(PROCESS_DEFINITION_ID) String processDefinitionId);

    /**
     * Get a process definition resource content
     *
     * @param processDefinitionId The id of the process definition to get the
     *            resource data for. (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}/resourcedata")
    Call<RequestBody> getProcessDefinitionResourceCall(@Path(PROCESS_DEFINITION_ID) String processDefinitionId);

    /**
     * List of process definitions
     *
     * @param version Only return process definitions with the given version.
     *            (optional)
     * @param name Only return process definitions with the given name.
     *            (optional)
     * @param nameLike Only return process definitions with a name like the
     *            given name. (optional)
     * @param key Only return process definitions with the given key. (optional)
     * @param keyLike Only return process definitions with a name like the given
     *            key. (optional)
     * @param resourceName Only return process definitions with the given
     *            resource name. (optional)
     * @param resourceNameLike Only return process definitions with a name like
     *            the given resource name. (optional)
     * @param category Only return process definitions with the given category.
     *            (optional)
     * @param categoryLike Only return process definitions with a category like
     *            the given name. (optional)
     * @param categoryNotEquals Only return process definitions which don?t have
     *            the given category. (optional)
     * @param deploymentId Only return process definitions with the given
     *            category. (optional)
     * @param startableByUser Only return process definitions which are part of
     *            a deployment with the given id. (optional)
     * @param latest Only return the latest process definition versions. Can
     *            only be used together with key and keyLike parameters, using
     *            any other parameter will result in a 400-response. (optional)
     * @param suspended If true, only returns process definitions which are
     *            suspended. If false, only active process definitions (which
     *            are not suspended) are returned. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}/resourcedata")
    Call<ResultList<ProcessDefinitionResponse>> getProcessDefinitionsCall(@Query(VERSION) Integer version,
            @Query(NAME) String name, @Query(NAME_LIKE) String nameLike, @Query(KEY) String key,
            @Query(KEY_LIKE) String keyLike, @Query(RESOURCE_NAME) String resourceName,
            @Query(RESOURCE_NAME_LIKE) String resourceNameLike, @Query(CATEGORY) String category,
            @Query(CATEGORY_LIKE) String categoryLike, @Query(CATEGORY_NOT_EQUALS) String categoryNotEquals,
            @Query(DEPLOYMENT_ID) String deploymentId, @Query(STARTABLE_BY_USER) String startableByUser,
            @Query(LATEST) Boolean latest, @Query(SUSPENDED) Boolean suspended, @Query(SORT) Boolean sort);

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
     * Add a candidate starter to a process definition ## For a User
     * &#x60;&#x60;&#x60;JSON { \&quot;user\&quot; : \&quot;kermit\&quot; }
     * &#x60;&#x60;&#x60; ## For a Group &#x60;&#x60;&#x60;JSON {
     * \&quot;groupId\&quot; : \&quot;sales\&quot; } &#x60;&#x60;&#x60;
     *
     * @param processDefinitionId The id of the process definition. (required)
     * @param body (optional)
     * @return RestIdentityLink
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}/identitylinks")
    Observable<RestIdentityLink> createIdentityLinkObservable(@Path(PROCESS_DEFINITION_ID) String processDefinitionId,
            @Body RestIdentityLink body);

    /**
     * Delete a candidate starter from a process definition
     *
     * @param processDefinitionId The id of the process definition. (required)
     * @param family Either users or groups, depending on the type of identity
     *            link. (required)
     * @param identityId Either the user or group of the identity to remove as
     *            candidate starter. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH
            + "/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}")
    Observable<Void> deleteIdentityLinkObservable(@Path(PROCESS_DEFINITION_ID) String processDefinitionId,
            @Path(FAMILY) String family, @Path(IDENTITY_ID) String identityId);

    /**
     * Execute actions for a process definition (Update category, Suspend or
     * Activate) ## Update category for a process definition
     * &#x60;&#x60;&#x60;JSON { \&quot;category\&quot; :
     * \&quot;updatedcategory\&quot; } &#x60;&#x60;&#x60; ## Suspend a process
     * definition &#x60;&#x60;&#x60;JSON { \&quot;action\&quot; :
     * \&quot;suspend\&quot;, \&quot;includeProcessInstances\&quot; :
     * \&quot;false\&quot;, \&quot;date\&quot; :
     * \&quot;2013-04-15T00:42:12Z\&quot; } &#x60;&#x60;&#x60; ## Activate a
     * process definition &#x60;&#x60;&#x60;JSON { \&quot;action\&quot; :
     * \&quot;activate\&quot;, \&quot;includeProcessInstances\&quot; :
     * \&quot;true\&quot;, \&quot;date\&quot; :
     * \&quot;2013-04-15T00:42:12Z\&quot; } &#x60;&#x60;&#x60;
     *
     * @param processDefinitionId (required)
     * @param body (required)
     * @return ProcessDefinitionResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}")
    Observable<ProcessDefinitionResponse> executeProcessDefinitionActionObservable(
            @Path(PROCESS_DEFINITION_ID) String processDefinitionId, @Body ProcessDefinitionActionRequest body);

    /**
     * Get a process definition BPMN model
     *
     * @param processDefinitionId The id of the process definition to get the
     *            model for. (required)
     * @return BpmnModel
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}/model")
    Observable<BpmnModel> getBpmnModelResourceObservable(@Path(PROCESS_DEFINITION_ID) String processDefinitionId);

    /**
     * Get a candidate starter from a process definition
     *
     * @param processDefinitionId The id of the process definition. (required)
     * @param family Either users or groups, depending on the type of identity
     *            link. (required)
     * @param identityId Either the user or group of the identity to get as
     *            candidate starter. (required)
     * @return RestIdentityLink
     */
    @GET(ACTIVITI_SERVICE_PATH
            + "/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}")
    Observable<RestIdentityLink> getIdentityLinkObservable(@Path(PROCESS_DEFINITION_ID) String processDefinitionId,
            @Path(FAMILY) String family, @Path(IDENTITY_ID) String identityId);

    /**
     * Get all candidate starters for a process-definition
     *
     * @param processDefinitionId The id of the process definition to get the
     *            identity links for. (required)
     * @return List&lt;RestIdentityLink&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}/identitylinks")
    Observable<List<RestIdentityLink>> getIdentityLinksObservable(
            @Path(PROCESS_DEFINITION_ID) String processDefinitionId);

    /**
     * Get a process definition image
     *
     * @param processDefinitionId (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}/image")
    Observable<RequestBody> getModelResourceObservable(@Path(PROCESS_DEFINITION_ID) String processDefinitionId);

    /**
     * Get a process definition
     *
     * @param processDefinitionId The id of the process definition to get.
     *            (required)
     * @return ProcessDefinitionResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}")
    Observable<ProcessDefinitionResponse> getProcessDefinitionObservable(
            @Path(PROCESS_DEFINITION_ID) String processDefinitionId);

    /**
     * Get a process definition resource content
     *
     * @param processDefinitionId The id of the process definition to get the
     *            resource data for. (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}/resourcedata")
    Observable<RequestBody> getProcessDefinitionResourceObservable(
            @Path(PROCESS_DEFINITION_ID) String processDefinitionId);

    /**
     * List of process definitions
     *
     * @param version Only return process definitions with the given version.
     *            (optional)
     * @param name Only return process definitions with the given name.
     *            (optional)
     * @param nameLike Only return process definitions with a name like the
     *            given name. (optional)
     * @param key Only return process definitions with the given key. (optional)
     * @param keyLike Only return process definitions with a name like the given
     *            key. (optional)
     * @param resourceName Only return process definitions with the given
     *            resource name. (optional)
     * @param resourceNameLike Only return process definitions with a name like
     *            the given resource name. (optional)
     * @param category Only return process definitions with the given category.
     *            (optional)
     * @param categoryLike Only return process definitions with a category like
     *            the given name. (optional)
     * @param categoryNotEquals Only return process definitions which don?t have
     *            the given category. (optional)
     * @param deploymentId Only return process definitions with the given
     *            category. (optional)
     * @param startableByUser Only return process definitions which are part of
     *            a deployment with the given id. (optional)
     * @param latest Only return the latest process definition versions. Can
     *            only be used together with key and keyLike parameters, using
     *            any other parameter will result in a 400-response. (optional)
     * @param suspended If true, only returns process definitions which are
     *            suspended. If false, only active process definitions (which
     *            are not suspended) are returned. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/repository/process-definitions/{processDefinitionId}/resourcedata")
    Observable<ResultList<ProcessDefinitionResponse>> getProcessDefinitionsObservable(@Query(VERSION) Integer version,
            @Query(NAME) String name, @Query(NAME_LIKE) String nameLike, @Query(KEY) String key,
            @Query(KEY_LIKE) String keyLike, @Query(RESOURCE_NAME) String resourceName,
            @Query(RESOURCE_NAME_LIKE) String resourceNameLike, @Query(CATEGORY) String category,
            @Query(CATEGORY_LIKE) String categoryLike, @Query(CATEGORY_NOT_EQUALS) String categoryNotEquals,
            @Query(DEPLOYMENT_ID) String deploymentId, @Query("startableByUser") String startableByUser,
            @Query(LATEST) Boolean latest, @Query(SUSPENDED) Boolean suspended, @Query(SORT) Boolean sort);

}
