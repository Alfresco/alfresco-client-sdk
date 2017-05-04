package org.alfresco.client.services.process.activiti.core.api;

import static org.alfresco.client.services.process.activiti.core.ActivitiConstant.ACTIVITI_SERVICE_PATH;

import java.util.List;

import org.alfresco.client.services.process.activiti.core.model.body.ProcessInstanceActionRequest;
import org.alfresco.client.services.process.activiti.core.model.body.ProcessInstanceCreateRequest;
import org.alfresco.client.services.process.activiti.core.model.body.ProcessInstanceQueryRequest;
import org.alfresco.client.services.process.activiti.core.model.representation.ProcessInstanceResponse;
import org.alfresco.client.services.process.activiti.core.model.representation.RestIdentityLink;
import org.alfresco.client.services.process.activiti.core.model.representation.RestVariable;
import org.alfresco.client.services.process.enterprise.common.model.representation.ResultList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 03/05/2017.
 */
public interface ProcessInstancesAPI
{
    /**
     * Update a single or binary variable or multiple variables on a process
     * instance ## Update multiples variables &#x60;&#x60;&#x60;JSON [ {
     * \&quot;name\&quot;:\&quot;intProcVar\&quot;
     * \&quot;type\&quot;:\&quot;integer\&quot; \&quot;value\&quot;:123 }, ... ]
     * &#x60;&#x60;&#x60; Any number of variables can be passed into the request
     * body array. More information about the variable format can be found in
     * the REST variables section. Note that scope is ignored, only local
     * variables can be set in a process instance. ## Update a single variable
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;intProcVar\&quot;
     * \&quot;type\&quot;:\&quot;integer\&quot; \&quot;value\&quot;:123 }
     * &#x60;&#x60;&#x60; ## Update an existing binary variable The request
     * should be of type multipart/form-data. There should be a single file-part
     * included with the binary value of the variable. On top of that, the
     * following additional form-fields can be present: name: Required name of
     * the variable. type: Type of variable that is created. If omitted, binary
     * is assumed and the binary data in the request will be stored as an array
     * of bytes.
     * 
     * @param processInstanceId The id of the process instance to create the new
     *            variable for. (required)
     * @return Object
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables")
    Call<List<RestVariable>> createOrUpdateProcessVariableCall(@Path("processInstanceId") String processInstanceId);

    /**
     * Start a process instance ## Request body (start by process definition id)
     * &#x60;&#x60;&#x60;JSON {
     * \&quot;processDefinitionId\&quot;:\&quot;oneTaskProcess:1:158\&quot;,
     * \&quot;businessKey\&quot;:\&quot;myBusinessKey\&quot;,
     * \&quot;variables\&quot;: [ { \&quot;name\&quot;:\&quot;myVar\&quot;,
     * \&quot;value\&quot;:\&quot;This is a variable\&quot;, } ]
     * }&#x60;&#x60;&#x60; ## Request body (start by process definition key)
     * &#x60;&#x60;&#x60;JSON {
     * \&quot;processDefinitionKey\&quot;:\&quot;oneTaskProcess\&quot;,
     * \&quot;businessKey\&quot;:\&quot;myBusinessKey\&quot;,
     * \&quot;tenantId\&quot;: \&quot;tenant1\&quot;, \&quot;variables\&quot;: [
     * { \&quot;name\&quot;:\&quot;myVar\&quot;, \&quot;value\&quot;:\&quot;This
     * is a variable\&quot;, } ] }&#x60;&#x60;&#x60; ## Request body (start by
     * message) &#x60;&#x60;&#x60;JSON {
     * \&quot;message\&quot;:\&quot;newOrderMessage\&quot;,
     * \&quot;businessKey\&quot;:\&quot;myBusinessKey\&quot;,
     * \&quot;tenantId\&quot;: \&quot;tenant1\&quot;, \&quot;variables\&quot;: [
     * { \&quot;name\&quot;:\&quot;myVar\&quot;, \&quot;value\&quot;:\&quot;This
     * is a variable\&quot;, } ] }&#x60;&#x60;&#x60; Note that also a
     * *transientVariables* property is accepted as part of this json, that
     * follows the same structure as the *variables* property. Only one of
     * *processDefinitionId*, *processDefinitionKey* or *message* can be used in
     * the request body. Parameters *businessKey*, *variables* and *tenantId*
     * are optional. If tenantId is omitted, the default tenant will be used.
     * More information about the variable format can be found in the REST
     * variables section. Note that the variable-scope that is supplied is
     * ignored, process-variables are always local.
     * 
     * @param body (optional)
     * @return ProcessInstanceResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/process-instances")
    Call<ProcessInstanceResponse> createProcessInstanceCall(@Body ProcessInstanceCreateRequest body);

    /**
     * Add an involved user to a process instance Note that the groupId in
     * Response Body will always be null, as it?s only possible to involve users
     * with a process-instance.
     * 
     * @param processInstanceId The id of the process instance to the links for.
     *            (required)
     * @param body (optional)
     * @return RestIdentityLink
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/identitylinks")
    Call<RestIdentityLink> createProcessInstanceIdentityLinksCall(@Path("processInstanceId") String processInstanceId,
            @Body RestIdentityLink body);

    /**
     * Create variables or new binary variable on a process instance ## Update
     * multiples variables &#x60;&#x60;&#x60;JSON [ {
     * \&quot;name\&quot;:\&quot;intProcVar\&quot;
     * \&quot;type\&quot;:\&quot;integer\&quot; \&quot;value\&quot;:123 }, ... ]
     * &#x60;&#x60;&#x60; Any number of variables can be passed into the request
     * body array. More information about the variable format can be found in
     * the REST variables section. Note that scope is ignored, only local
     * variables can be set in a process instance. The request should be of type
     * multipart/form-data. There should be a single file-part included with the
     * binary value of the variable. On top of that, the following additional
     * form-fields can be present: name: Required name of the variable. type:
     * Type of variable that is created. If omitted, binary is assumed and the
     * binary data in the request will be stored as an array of bytes.
     * 
     * @param processInstanceId The id of the process instance to create the new
     *            variable for (required)
     * @return Object
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables")
    Call<List<RestVariable>> createProcessInstanceVariableCall(@Path("processInstanceId") String processInstanceId,
            @Body List<RestVariable> body);

    /**
     * Delete all variables
     *
     * @param processInstanceId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables")
    Call<Void> deleteLocalProcessVariableCall(@Path("processInstanceId") String processInstanceId);

    /**
     * Delete a process instance
     *
     * @param processInstanceId The id of the process instance to delete.
     *            (required)
     * @param deleteReason (optional)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}")
    Call<Void> deleteProcessInstanceCall(@Path("processInstanceId") String processInstanceId,
            @Query("deleteReason") String deleteReason);

    /**
     * Remove an involved user to from process instance
     *
     * @param processInstanceId The id of the process instance. (required)
     * @param identityId The id of the user to delete link for. (required)
     * @param type Type of link to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH
            + "/runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}")
    Call<Void> deleteProcessInstanceIdentityLinksCall(@Path("processInstanceId") String processInstanceId,
            @Path("identityId") String identityId, @Path("type") String type);

    /**
     * Delete a variable
     *
     * @param processInstanceId (required)
     * @param variableName (required)
     * @param scope (optional)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables/{variableName}")
    Call<Void> deleteProcessInstanceVariableCall(@Path("processInstanceId") String processInstanceId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * Get a process instance
     *
     * @param processInstanceId The id of the process instance to get.
     *            (required)
     * @return ProcessInstanceResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}")
    Call<ProcessInstanceResponse> getProcessInstanceCall(@Path("processInstanceId") String processInstanceId);

    /**
     * Get diagram for a process instance
     *
     * @param processInstanceId The id of the process instance to get the
     *            diagram for. (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/diagram")
    Call<RequestBody> getProcessInstanceDiagramCall(@Path("processInstanceId") String processInstanceId);

    /**
     * Get a specific involved people from process instance
     *
     * @param processInstanceId The id of the process instance to get.
     *            (required)
     * @param identityId (required)
     * @param type (required)
     * @return RestIdentityLink
     */
    @GET(ACTIVITI_SERVICE_PATH
            + "/runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}")
    Call<RestIdentityLink> getProcessInstanceIdentityLinksCall(@Path("processInstanceId") String processInstanceId,
            @Path("identityId") String identityId, @Path("type") String type);

    /**
     * Get a variable for a process instance
     *
     * @param processInstanceId The id of the process instance to the variables
     *            for. (required)
     * @param variableName Name of the variable to get. (required)
     * @param scope (optional)
     * @return RestVariable
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables/{variableName}")
    Call<RestVariable> getProcessInstanceVariableCall(@Path("processInstanceId") String processInstanceId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * Get the binary data for a variable
     *
     * @param processInstanceId (required)
     * @param variableName (required)
     * @param scope (optional)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables/{variableName}/data")
    Call<RequestBody> getProcessInstanceVariableDataCall(@Path("processInstanceId") String processInstanceId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * List of process instances
     *
     * @param id Only return models with the given version. (optional)
     * @param processDefinitionKey Only return process instances with the given
     *            process definition key. (optional)
     * @param processDefinitionId Only return process instances with the given
     *            process definition id. (optional)
     * @param businessKey Only return process instances with the given
     *            businessKey. (optional)
     * @param involvedUser Only return process instances in which the given user
     *            is involved. (optional)
     * @param suspended If true, only return process instance which are
     *            suspended. If false, only return process instances which are
     *            not suspended (active). (optional)
     * @param superProcessInstanceId Only return process instances which have
     *            the given super process-instance id (for processes that have a
     *            call-activities). (optional)
     * @param subProcessInstanceId Only return process instances which have the
     *            given sub process-instance id (for processes started as a
     *            call-activity). (optional)
     * @param excludeSubprocesses Return only process instances which aren?t sub
     *            processes. (optional)
     * @param includeProcessVariables Indication to include process variables in
     *            the result. (optional)
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
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances")
    Call<ResultList<ProcessInstanceResponse>> getProcessInstancesCall(@Query("id") String id,
            @Query("processDefinitionKey") String processDefinitionKey,
            @Query("processDefinitionId") String processDefinitionId, @Query("businessKey") String businessKey,
            @Query("involvedUser") String involvedUser, @Query("suspended") Boolean suspended,
            @Query("superProcessInstanceId") String superProcessInstanceId,
            @Query("subProcessInstanceId") String subProcessInstanceId,
            @Query("excludeSubprocesses") Boolean excludeSubprocesses,
            @Query("includeProcessVariables") Boolean includeProcessVariables, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId,
            @Query("sort") String sort);

    /**
     * List of variables for a process instance In case the variable is a binary
     * variable or serializable, the valueUrl points to an URL to fetch the raw
     * value. If it?s a plain variable, the value is present in the response.
     * Note that only local scoped variables are returned, as there is no global
     * scope for process-instance variables.
     * 
     * @param processInstanceId The id of the process instance to the variables
     *            for. (required)
     * @param scope (optional)
     * @return List&lt;RestVariable&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables")
    Call<List<RestVariable>> getVariablesCall(@Path("processInstanceId") String processInstanceId,
            @Query("scope") String scope);

    /**
     * Get involved people for process instance Note that the groupId in
     * Response Body will always be null, as it?s only possible to involve users
     * with a process-instance.
     * 
     * @param processInstanceId The id of the process instance to the links for.
     *            (required)
     * @return List&lt;RestIdentityLink&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/identitylinks")
    Call<List<RestIdentityLink>> listProcessInstanceIdentityLinksCall(
            @Path("processInstanceId") String processInstanceId);

    /**
     * Activate or suspend a process instance ## Activate a process instance
     * &#x60;&#x60;&#x60;JSON { \&quot;action\&quot; : \&quot;suspend\&quot; }
     * &#x60;&#x60;&#x60; ## Suspend a process instance &#x60;&#x60;&#x60;JSON {
     * \&quot;action\&quot; : \&quot;activate\&quot; } &#x60;&#x60;&#x60;
     * 
     * @param processInstanceId The id of the process instance to
     *            activate/suspend. (required)
     * @param body (optional)
     * @return ProcessInstanceResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}")
    Call<ProcessInstanceResponse> performProcessInstanceActionCall(@Path("processInstanceId") String processInstanceId,
            @Body ProcessInstanceActionRequest body);

    /**
     * Query process instances The request body can contain all possible filters
     * that can be used in the List process instances URL query. On top of
     * these, it?s possible to provide an array of variables to include in the
     * query, with their format described here. The general paging and sorting
     * query-parameters can be used for this URL.
     * 
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/query/process-instances")
    Call<ResultList<ProcessInstanceResponse>> queryProcessInstancesCall(@Body ProcessInstanceQueryRequest body);

    /**
     * Update a single variable on a process instance
     *
     * @param processInstanceId The id of the process instance to the variables
     *            for. (required)
     * @param variableName Name of the variable to get. (required)
     * @return RestVariable
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables/{variableName}")
    Call<RestVariable> updateProcessInstanceVariableCall(@Path("processInstanceId") String processInstanceId,
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

    /**
     * Update a single or binary variable or multiple variables on a process
     * instance ## Update multiples variables &#x60;&#x60;&#x60;JSON [ {
     * \&quot;name\&quot;:\&quot;intProcVar\&quot;
     * \&quot;type\&quot;:\&quot;integer\&quot; \&quot;value\&quot;:123 }, ... ]
     * &#x60;&#x60;&#x60; Any number of variables can be passed into the request
     * body array. More information about the variable format can be found in
     * the REST variables section. Note that scope is ignored, only local
     * variables can be set in a process instance. ## Update a single variable
     * &#x60;&#x60;&#x60;JSON { \&quot;name\&quot;:\&quot;intProcVar\&quot;
     * \&quot;type\&quot;:\&quot;integer\&quot; \&quot;value\&quot;:123 }
     * &#x60;&#x60;&#x60; ## Update an existing binary variable The request
     * should be of type multipart/form-data. There should be a single file-part
     * included with the binary value of the variable. On top of that, the
     * following additional form-fields can be present: name: Required name of
     * the variable. type: Type of variable that is created. If omitted, binary
     * is assumed and the binary data in the request will be stored as an array
     * of bytes.
     *
     * @param processInstanceId The id of the process instance to create the new
     *            variable for. (required)
     * @return Object
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables")
    Observable<List<RestVariable>> createOrUpdateProcessVariableObservable(
            @Path("processInstanceId") String processInstanceId);

    /**
     * Start a process instance ## Request body (start by process definition id)
     * &#x60;&#x60;&#x60;JSON {
     * \&quot;processDefinitionId\&quot;:\&quot;oneTaskProcess:1:158\&quot;,
     * \&quot;businessKey\&quot;:\&quot;myBusinessKey\&quot;,
     * \&quot;variables\&quot;: [ { \&quot;name\&quot;:\&quot;myVar\&quot;,
     * \&quot;value\&quot;:\&quot;This is a variable\&quot;, } ]
     * }&#x60;&#x60;&#x60; ## Request body (start by process definition key)
     * &#x60;&#x60;&#x60;JSON {
     * \&quot;processDefinitionKey\&quot;:\&quot;oneTaskProcess\&quot;,
     * \&quot;businessKey\&quot;:\&quot;myBusinessKey\&quot;,
     * \&quot;tenantId\&quot;: \&quot;tenant1\&quot;, \&quot;variables\&quot;: [
     * { \&quot;name\&quot;:\&quot;myVar\&quot;, \&quot;value\&quot;:\&quot;This
     * is a variable\&quot;, } ] }&#x60;&#x60;&#x60; ## Request body (start by
     * message) &#x60;&#x60;&#x60;JSON {
     * \&quot;message\&quot;:\&quot;newOrderMessage\&quot;,
     * \&quot;businessKey\&quot;:\&quot;myBusinessKey\&quot;,
     * \&quot;tenantId\&quot;: \&quot;tenant1\&quot;, \&quot;variables\&quot;: [
     * { \&quot;name\&quot;:\&quot;myVar\&quot;, \&quot;value\&quot;:\&quot;This
     * is a variable\&quot;, } ] }&#x60;&#x60;&#x60; Note that also a
     * *transientVariables* property is accepted as part of this json, that
     * follows the same structure as the *variables* property. Only one of
     * *processDefinitionId*, *processDefinitionKey* or *message* can be used in
     * the request body. Parameters *businessKey*, *variables* and *tenantId*
     * are optional. If tenantId is omitted, the default tenant will be used.
     * More information about the variable format can be found in the REST
     * variables section. Note that the variable-scope that is supplied is
     * ignored, process-variables are always local.
     *
     * @param body (optional)
     * @return ProcessInstanceResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/process-instances")
    Observable<ProcessInstanceResponse> createProcessInstanceObservable(@Body ProcessInstanceCreateRequest body);

    /**
     * Add an involved user to a process instance Note that the groupId in
     * Response Body will always be null, as it?s only possible to involve users
     * with a process-instance.
     *
     * @param processInstanceId The id of the process instance to the links for.
     *            (required)
     * @param body (optional)
     * @return RestIdentityLink
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/identitylinks")
    Observable<RestIdentityLink> createProcessInstanceIdentityLinksObservable(
            @Path("processInstanceId") String processInstanceId, @Body RestIdentityLink body);

    /**
     * Create variables or new binary variable on a process instance ## Update
     * multiples variables &#x60;&#x60;&#x60;JSON [ {
     * \&quot;name\&quot;:\&quot;intProcVar\&quot;
     * \&quot;type\&quot;:\&quot;integer\&quot; \&quot;value\&quot;:123 }, ... ]
     * &#x60;&#x60;&#x60; Any number of variables can be passed into the request
     * body array. More information about the variable format can be found in
     * the REST variables section. Note that scope is ignored, only local
     * variables can be set in a process instance. The request should be of type
     * multipart/form-data. There should be a single file-part included with the
     * binary value of the variable. On top of that, the following additional
     * form-fields can be present: name: Required name of the variable. type:
     * Type of variable that is created. If omitted, binary is assumed and the
     * binary data in the request will be stored as an array of bytes.
     *
     * @param processInstanceId The id of the process instance to create the new
     *            variable for (required)
     * @return Object
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables")
    Observable<List<RestVariable>> createProcessInstanceVariableObservable(
            @Path("processInstanceId") String processInstanceId, @Body List<RestVariable> body);

    /**
     * Delete all variables
     *
     * @param processInstanceId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables")
    Observable<Void> deleteLocalProcessVariableObservable(@Path("processInstanceId") String processInstanceId);

    /**
     * Delete a process instance
     *
     * @param processInstanceId The id of the process instance to delete.
     *            (required)
     * @param deleteReason (optional)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}")
    Observable<Void> deleteProcessInstanceObservable(@Path("processInstanceId") String processInstanceId,
            @Query("deleteReason") String deleteReason);

    /**
     * Remove an involved user to from process instance
     *
     * @param processInstanceId The id of the process instance. (required)
     * @param identityId The id of the user to delete link for. (required)
     * @param type Type of link to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH
            + "/runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}")
    Observable<Void> deleteProcessInstanceIdentityLinksObservable(@Path("processInstanceId") String processInstanceId,
            @Path("identityId") String identityId, @Path("type") String type);

    /**
     * Delete a variable
     *
     * @param processInstanceId (required)
     * @param variableName (required)
     * @param scope (optional)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables/{variableName}")
    Observable<Void> deleteProcessInstanceVariableObservable(@Path("processInstanceId") String processInstanceId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * Get a process instance
     *
     * @param processInstanceId The id of the process instance to get.
     *            (required)
     * @return ProcessInstanceResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}")
    Observable<ProcessInstanceResponse> getProcessInstanceObservable(
            @Path("processInstanceId") String processInstanceId);

    /**
     * Get diagram for a process instance
     *
     * @param processInstanceId The id of the process instance to get the
     *            diagram for. (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/diagram")
    Observable<RequestBody> getProcessInstanceDiagramObservable(@Path("processInstanceId") String processInstanceId);

    /**
     * Get a specific involved people from process instance
     *
     * @param processInstanceId The id of the process instance to get.
     *            (required)
     * @param identityId (required)
     * @param type (required)
     * @return RestIdentityLink
     */
    @GET(ACTIVITI_SERVICE_PATH
            + "/runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}")
    Observable<RestIdentityLink> getProcessInstanceIdentityLinksObservable(
            @Path("processInstanceId") String processInstanceId, @Path("identityId") String identityId,
            @Path("type") String type);

    /**
     * Get a variable for a process instance
     *
     * @param processInstanceId The id of the process instance to the variables
     *            for. (required)
     * @param variableName Name of the variable to get. (required)
     * @param scope (optional)
     * @return RestVariable
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables/{variableName}")
    Observable<RestVariable> getProcessInstanceVariableObservable(@Path("processInstanceId") String processInstanceId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * Get the binary data for a variable
     *
     * @param processInstanceId (required)
     * @param variableName (required)
     * @param scope (optional)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables/{variableName}/data")
    Observable<RequestBody> getProcessInstanceVariableDataObservable(
            @Path("processInstanceId") String processInstanceId, @Path("variableName") String variableName,
            @Query("scope") String scope);

    /**
     * List of process instances
     *
     * @param id Only return models with the given version. (optional)
     * @param processDefinitionKey Only return process instances with the given
     *            process definition key. (optional)
     * @param processDefinitionId Only return process instances with the given
     *            process definition id. (optional)
     * @param businessKey Only return process instances with the given
     *            businessKey. (optional)
     * @param involvedUser Only return process instances in which the given user
     *            is involved. (optional)
     * @param suspended If true, only return process instance which are
     *            suspended. If false, only return process instances which are
     *            not suspended (active). (optional)
     * @param superProcessInstanceId Only return process instances which have
     *            the given super process-instance id (for processes that have a
     *            call-activities). (optional)
     * @param subProcessInstanceId Only return process instances which have the
     *            given sub process-instance id (for processes started as a
     *            call-activity). (optional)
     * @param excludeSubprocesses Return only process instances which aren?t sub
     *            processes. (optional)
     * @param includeProcessVariables Indication to include process variables in
     *            the result. (optional)
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
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances")
    Observable<ResultList<ProcessInstanceResponse>> getProcessInstancesObservable(@Query("id") String id,
            @Query("processDefinitionKey") String processDefinitionKey,
            @Query("processDefinitionId") String processDefinitionId, @Query("businessKey") String businessKey,
            @Query("involvedUser") String involvedUser, @Query("suspended") Boolean suspended,
            @Query("superProcessInstanceId") String superProcessInstanceId,
            @Query("subProcessInstanceId") String subProcessInstanceId,
            @Query("excludeSubprocesses") Boolean excludeSubprocesses,
            @Query("includeProcessVariables") Boolean includeProcessVariables, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId,
            @Query("sort") String sort);

    /**
     * List of variables for a process instance In case the variable is a binary
     * variable or serializable, the valueUrl points to an URL to fetch the raw
     * value. If it?s a plain variable, the value is present in the response.
     * Note that only local scoped variables are returned, as there is no global
     * scope for process-instance variables.
     *
     * @param processInstanceId The id of the process instance to the variables
     *            for. (required)
     * @param scope (optional)
     * @return List&lt;RestVariable&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables")
    Observable<List<RestVariable>> getVariablesObservable(@Path("processInstanceId") String processInstanceId,
            @Query("scope") String scope);

    /**
     * Get involved people for process instance Note that the groupId in
     * Response Body will always be null, as it?s only possible to involve users
     * with a process-instance.
     *
     * @param processInstanceId The id of the process instance to the links for.
     *            (required)
     * @return List&lt;RestIdentityLink&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/identitylinks")
    Observable<List<RestIdentityLink>> listProcessInstanceIdentityLinksObservable(
            @Path("processInstanceId") String processInstanceId);

    /**
     * Activate or suspend a process instance ## Activate a process instance
     * &#x60;&#x60;&#x60;JSON { \&quot;action\&quot; : \&quot;suspend\&quot; }
     * &#x60;&#x60;&#x60; ## Suspend a process instance &#x60;&#x60;&#x60;JSON {
     * \&quot;action\&quot; : \&quot;activate\&quot; } &#x60;&#x60;&#x60;
     *
     * @param processInstanceId The id of the process instance to
     *            activate/suspend. (required)
     * @param body (optional)
     * @return ProcessInstanceResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}")
    Observable<ProcessInstanceResponse> performProcessInstanceActionObservable(
            @Path("processInstanceId") String processInstanceId, @Body ProcessInstanceActionRequest body);

    /**
     * Query process instances The request body can contain all possible filters
     * that can be used in the List process instances URL query. On top of
     * these, it?s possible to provide an array of variables to include in the
     * query, with their format described here. The general paging and sorting
     * query-parameters can be used for this URL.
     *
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/query/process-instances")
    Observable<ResultList<ProcessInstanceResponse>> queryProcessInstancesObservable(
            @Body ProcessInstanceQueryRequest body);

    /**
     * Update a single variable on a process instance
     *
     * @param processInstanceId The id of the process instance to the variables
     *            for. (required)
     * @param variableName Name of the variable to get. (required)
     * @return RestVariable
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/process-instances/{processInstanceId}/variables/{variableName}")
    Observable<RestVariable> updateProcessInstanceVariableObservable(
            @Path("processInstanceId") String processInstanceId, @Path("variableName") String variableName);

}
