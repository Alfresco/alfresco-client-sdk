package org.alfresco.client.services.process.activiti.core.api;

import static org.alfresco.client.services.process.activiti.core.ActivitiConstant.ACTIVITI_SERVICE_PATH;

import java.util.List;

import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;
import org.alfresco.client.services.process.activiti.core.model.body.ExecutionActionRequest;
import org.alfresco.client.services.process.activiti.core.model.body.ExecutionQueryRequest;
import org.alfresco.client.services.process.activiti.core.model.body.ExecutionResponse;
import org.alfresco.client.services.process.activiti.core.model.representation.ProcessEngineInfoResponse;
import org.alfresco.client.services.process.activiti.core.model.representation.RestVariable;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 03/05/2017.
 */
public interface ExecutionsAPI
{

    // FIXME type & Params
    /**
     * Create variables on an execution
     *
     * @param executionId The id of the execution to create the new variable
     *            for. (required)
     * @return Object
     */
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables")
    Call<Object> createExecutionVariableCall(@Path("executionId") String executionId);

    // FIXME type & Params
    /**
     * Update variables on an execution
     *
     * @param executionId The id of the execution to the variables for.
     *            (required)
     * @return Object
     */
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables")
    Call<ProcessEngineInfoResponse> createOrUpdateExecutionVariableCall(@Path("executionId") String executionId);

    /**
     * Delete all variables for an execution
     *
     * @param executionId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables")
    Call<Void> deleteLocalVariablesCall(@Path("executionId") String executionId);

    /**
     * Delete a variable for an execution
     *
     * @param executionId (required)
     * @param variableName (required)
     * @param scope (optional)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables/{variableName}")
    Call<Void> deletedExecutionVariableCall(@Path("executionId") String executionId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * Signal event received
     *
     * @param body (optional)
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/executions")
    Call<Void> executeExecutionActionCall(@Body ExecutionActionRequest body);

    /**
     * Get active activities in an execution Returns all activities which are
     * active in the execution and in all child-executions (and their children,
     * recursively), if any.
     * 
     * @param executionId The id of the execution to get activities for.
     *            (required)
     * @return List&lt;String&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/activities")
    Call<List<String>> getActiveActivitiesCall(@Path("executionId") String executionId);

    /**
     * Get an execution
     *
     * @param executionId The id of the execution to get. (required)
     * @return ExecutionResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}")
    Call<ExecutionResponse> getExecutionCall(@Path("executionId") String executionId);

    /**
     * Get a variable for an execution
     *
     * @param executionId The id of the execution to the variables for.
     *            (required)
     * @param variableName Name of the variable to get. (required)
     * @param scope Either local or global. If omitted, local variable is
     *            returned (if exists). If not, a global variable is returned
     *            (if exists). (optional)
     * @return RestVariable
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables/{variableName}")
    Call<RestVariable> getExecutionVariableCall(@Path("executionId") String executionId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * Get the binary data for an execution
     *
     * @param executionId (required)
     * @param variableName (required)
     * @param scope (optional)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables/{variableName}/data")
    Call<RequestBody> getExecutionVariableData(@Path("executionId") String executionId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * List of executions
     *
     * @param id Only return models with the given version. (optional)
     * @param activityId Only return executions with the given activity id.
     *            (optional)
     * @param processDefinitionKey Only return process instances with the given
     *            process definition key. (optional)
     * @param processDefinitionId Only return process instances with the given
     *            process definition id. (optional)
     * @param processInstanceId Only return executions which are part of the
     *            process instance with the given id. (optional)
     * @param messageEventSubscriptionName Only return executions which are
     *            subscribed to a message with the given name. (optional)
     * @param signalEventSubscriptionName Only return executions which are
     *            subscribed to a signal with the given name. (optional)
     * @param parentId Only return executions which are a direct child of the
     *            given execution. (optional)
     * @param tenantId Only return process instances with the given tenantId.
     *            (optional)
     * @param tenantIdLike Only return process instances with a tenantId like
     *            the given value. (optional)
     * @param withoutTenantId If true, only returns process instances without a
     *            tenantId set. If false, the withoutTenantId parameter is
     *            ignored. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/executions")
    Call<ResultList<ExecutionResponse>> getExecutionsCall(@Query("id") String id,
            @Query("activityId") String activityId, @Query("processDefinitionKey") String processDefinitionKey,
            @Query("processDefinitionId") String processDefinitionId,
            @Query("processInstanceId") String processInstanceId,
            @Query("messageEventSubscriptionName") String messageEventSubscriptionName,
            @Query("signalEventSubscriptionName") String signalEventSubscriptionName,
            @Query("parentId") String parentId, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId,
            @Query("sort") String sort);

    /**
     * List of variables for an execution
     *
     * @param executionId The id of the execution to the variables for.
     *            (required)
     * @param scope Either local or global. If omitted, both local and global
     *            scoped variables are returned. (optional)
     * @return List&lt;RestVariable&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variable")
    Call<List<RestVariable>> listExecutionVariablesCall(@Path("executionId") String executionId,
            @Query("scope") String scope);

    /**
     * Execute an action on an execution ## Request body (signal an execution):
     * &#x60;&#x60;&#x60;JSON { \&quot;action\&quot;:\&quot;signal\&quot; }
     * &#x60;&#x60;&#x60; Both a variables and transientVariables property is
     * accepted with following structure &#x60;&#x60;&#x60;JSON {
     * \&quot;action\&quot;:\&quot;signal\&quot;, \&quot;variables\&quot; : [ {
     * \&quot;name\&quot;: \&quot;myVar\&quot;, \&quot;value\&quot;:
     * \&quot;someValue\&quot; } ] }&#x60;&#x60;&#x60; ## Request body (signal
     * event received for execution) &#x60;&#x60;&#x60;JSON {
     * \&quot;action\&quot;:\&quot;signal\&quot; } &#x60;&#x60;&#x60; Notifies
     * the execution that a signal event has been received, requires a
     * signalName parameter. Optional variables can be passed that are set on
     * the execution before the action is executed.## Request body (signal event
     * received for execution) &#x60;&#x60;&#x60;JSON {
     * \&quot;action\&quot;:\&quot;messageEventReceived\&quot;,
     * \&quot;messageName\&quot;:\&quot;myMessage\&quot;
     * \&quot;variables\&quot;: [ ] } &#x60;&#x60;&#x60;
     * 
     * @param executionId The id of the execution to execute action on.
     *            (required)
     * @param body (optional)
     * @return ExecutionResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}")
    Call<ExecutionResponse> performExecutionActionCall(@Path("executionId") String executionId,
            @Body ExecutionActionRequest body);

    /**
     * Query executions The request body can contain all possible filters that
     * can be used in the List executions URL query. On top of these, it?s
     * possible to provide an array of variables and processInstanceVariables to
     * include in the query, with their format described here. The general
     * paging and sorting query-parameters can be used for this URL.
     * 
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/query/executions")
    Call<ResultList<ExecutionResponse>> queryExecutionsCall(@Body ExecutionQueryRequest body);

    // FIXME
    /**
     * Update a variable on an execution
     *
     * @param executionId The id of the execution to create the new variable
     *            for. (required)
     * @param variableName The name of the variable to update. (required)
     * @return RestVariable
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables/{variableName}")
    Call<ExecutionResponse> updateExecutionVariableCall(@Path("executionId") String executionId,
            @Path("variableName") String variableName);

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

    // FIXME type & Params
    /**
     * Create variables on an execution
     *
     * @param executionId The id of the execution to create the new variable
     *            for. (required)
     * @return Object
     */
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables")
    Observable<Object> createExecutionVariableObservable(@Path("executionId") String executionId);

    // FIXME type & Params
    /**
     * Update variables on an execution
     *
     * @param executionId The id of the execution to the variables for.
     *            (required)
     * @return Object
     */
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables")
    Observable<ProcessEngineInfoResponse> createOrUpdateExecutionVariableObservable(
            @Path("executionId") String executionId);

    /**
     * Delete all variables for an execution
     *
     * @param executionId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables")
    Observable<Void> deleteLocalVariablesObservable(@Path("executionId") String executionId);

    /**
     * Delete a variable for an execution
     *
     * @param executionId (required)
     * @param variableName (required)
     * @param scope (optional)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables/{variableName}")
    Observable<Void> deletedExecutionVariableObservable(@Path("executionId") String executionId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * Signal event received
     *
     * @param body (optional)
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/executions")
    Observable<Void> executeExecutionActionObservable(@Body ExecutionActionRequest body);

    /**
     * Get active activities in an execution Returns all activities which are
     * active in the execution and in all child-executions (and their children,
     * recursively), if any.
     *
     * @param executionId The id of the execution to get activities for.
     *            (required)
     * @return List&lt;String&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/activities")
    Observable<List<String>> getActiveActivitiesObservable(@Path("executionId") String executionId);

    /**
     * Get an execution
     *
     * @param executionId The id of the execution to get. (required)
     * @return ExecutionResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}")
    Observable<ExecutionResponse> getExecutionObservable(@Path("executionId") String executionId);

    /**
     * Get a variable for an execution
     *
     * @param executionId The id of the execution to the variables for.
     *            (required)
     * @param variableName Name of the variable to get. (required)
     * @param scope Either local or global. If omitted, local variable is
     *            returned (if exists). If not, a global variable is returned
     *            (if exists). (optional)
     * @return RestVariable
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables/{variableName}")
    Observable<RestVariable> getExecutionVariableObservable(@Path("executionId") String executionId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * Get the binary data for an execution
     *
     * @param executionId (required)
     * @param variableName (required)
     * @param scope (optional)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables/{variableName}/data")
    Observable<RequestBody> getExecutionVariableDataObservable(@Path("executionId") String executionId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * List of executions
     *
     * @param id Only return models with the given version. (optional)
     * @param activityId Only return executions with the given activity id.
     *            (optional)
     * @param processDefinitionKey Only return process instances with the given
     *            process definition key. (optional)
     * @param processDefinitionId Only return process instances with the given
     *            process definition id. (optional)
     * @param processInstanceId Only return executions which are part of the
     *            process instance with the given id. (optional)
     * @param messageEventSubscriptionName Only return executions which are
     *            subscribed to a message with the given name. (optional)
     * @param signalEventSubscriptionName Only return executions which are
     *            subscribed to a signal with the given name. (optional)
     * @param parentId Only return executions which are a direct child of the
     *            given execution. (optional)
     * @param tenantId Only return process instances with the given tenantId.
     *            (optional)
     * @param tenantIdLike Only return process instances with a tenantId like
     *            the given value. (optional)
     * @param withoutTenantId If true, only returns process instances without a
     *            tenantId set. If false, the withoutTenantId parameter is
     *            ignored. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/executions")
    Observable<ResultList<ExecutionResponse>> getExecutionsObservable(@Query("id") String id,
            @Query("activityId") String activityId, @Query("processDefinitionKey") String processDefinitionKey,
            @Query("processDefinitionId") String processDefinitionId,
            @Query("processInstanceId") String processInstanceId,
            @Query("messageEventSubscriptionName") String messageEventSubscriptionName,
            @Query("signalEventSubscriptionName") String signalEventSubscriptionName,
            @Query("parentId") String parentId, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId,
            @Query("sort") String sort);

    /**
     * List of variables for an execution
     *
     * @param executionId The id of the execution to the variables for.
     *            (required)
     * @param scope Either local or global. If omitted, both local and global
     *            scoped variables are returned. (optional)
     * @return List&lt;RestVariable&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variable")
    Observable<List<RestVariable>> listExecutionVariablesObservable(@Path("executionId") String executionId,
            @Query("scope") String scope);

    /**
     * Execute an action on an execution ## Request body (signal an execution):
     * &#x60;&#x60;&#x60;JSON { \&quot;action\&quot;:\&quot;signal\&quot; }
     * &#x60;&#x60;&#x60; Both a variables and transientVariables property is
     * accepted with following structure &#x60;&#x60;&#x60;JSON {
     * \&quot;action\&quot;:\&quot;signal\&quot;, \&quot;variables\&quot; : [ {
     * \&quot;name\&quot;: \&quot;myVar\&quot;, \&quot;value\&quot;:
     * \&quot;someValue\&quot; } ] }&#x60;&#x60;&#x60; ## Request body (signal
     * event received for execution) &#x60;&#x60;&#x60;JSON {
     * \&quot;action\&quot;:\&quot;signal\&quot; } &#x60;&#x60;&#x60; Notifies
     * the execution that a signal event has been received, requires a
     * signalName parameter. Optional variables can be passed that are set on
     * the execution before the action is executed.## Request body (signal event
     * received for execution) &#x60;&#x60;&#x60;JSON {
     * \&quot;action\&quot;:\&quot;messageEventReceived\&quot;,
     * \&quot;messageName\&quot;:\&quot;myMessage\&quot;
     * \&quot;variables\&quot;: [ ] } &#x60;&#x60;&#x60;
     * 
     * @param executionId The id of the execution to execute action on.
     *            (required)
     * @param body (optional)
     * @return ExecutionResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}")
    Observable<ExecutionResponse> performExecutionActionObservable(@Path("executionId") String executionId,
            @Body ExecutionActionRequest body);

    /**
     * Query executions The request body can contain all possible filters that
     * can be used in the List executions URL query. On top of these, it?s
     * possible to provide an array of variables and processInstanceVariables to
     * include in the query, with their format described here. The general
     * paging and sorting query-parameters can be used for this URL.
     * 
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/query/executions")
    Observable<ResultList<ExecutionResponse>> queryExecutionsObservable(@Body ExecutionQueryRequest body);

    // FIXME
    /**
     * Update a variable on an execution
     *
     * @param executionId The id of the execution to create the new variable
     *            for. (required)
     * @param variableName The name of the variable to update. (required)
     * @return RestVariable
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/executions/{executionId}/variables/{variableName}")
    Observable<ExecutionResponse> updateExecutionVariableObservable(@Path("executionId") String executionId,
            @Path("variableName") String variableName);
}
