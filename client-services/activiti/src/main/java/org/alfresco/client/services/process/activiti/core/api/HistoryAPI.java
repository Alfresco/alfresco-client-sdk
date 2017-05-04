package org.alfresco.client.services.process.activiti.core.api;

import static org.alfresco.client.services.process.activiti.core.ActivitiConstant.ACTIVITI_SERVICE_PATH;

import java.util.List;

import org.alfresco.client.services.process.activiti.core.model.body.*;
import org.alfresco.client.services.process.activiti.core.model.representation.*;
import org.alfresco.client.services.process.enterprise.common.model.representation.ResultList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 03/05/2017.
 */
public interface HistoryAPI
{

    /**
     * Create a new comment on a historic process instance Parameter
     * saveProcessInstanceId is optional, if true save process instance id of
     * task with comment.
     * 
     * @param processInstanceId (required)
     * @param body (optional)
     * @return CommentResponse
     */
    @POST(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}/comments")
    Call<CommentResponse> createCommentCall(@Path("processInstanceId") String processInstanceId,
            @Body CommentRequest body);

    /**
     * Delete a comment on a historic process instance
     *
     * @param processInstanceId The id of the historic process instance to
     *            delete the comment for. (required)
     * @param commentId The id of the comment. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}/comments/{commentId}")
    Call<Void> deleteCommentCall(@Path("processInstanceId") String processInstanceId,
            @Path("commentId") String commentId);

    /**
     * Delete a historic process instance
     *
     * @param processInstanceId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}")
    Call<Void> deleteHitoricProcessInstanceCall(@Path("processInstanceId") String processInstanceId);

    /**
     * Delete a historic task instance
     *
     * @param taskId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/history/historic-task-instances/{taskId}")
    Call<Void> deleteTaskInstanceCall(@Path("taskId") String taskId);

    /**
     * Get a comment on a historic process instance
     *
     * @param processInstanceId The id of the historic process instance to get
     *            the comment for. (required)
     * @param commentId The id of the comment. (required)
     * @return CommentResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}/comments/{commentId}")
    Call<CommentResponse> getCommentCall(@Path("processInstanceId") String processInstanceId,
            @Path("commentId") String commentId);

    /**
     * Get all comments on a historic process instance
     *
     * @param processInstanceId The id of the process instance to get the
     *            comments for. (required)
     * @return List&lt;CommentResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}/comments")
    Call<List<CommentResponse>> getCommentsCall(@Path("processInstanceId") String processInstanceId);

    /**
     * Get historic activity instances
     *
     * @param activityId An id of the activity instance. (optional)
     * @param activityInstanceId An id of the historic activity instance.
     *            (optional)
     * @param activityName The name of the historic activity instance.
     *            (optional)
     * @param activityType The element type of the historic activity instance.
     *            (optional)
     * @param executionId The execution id of the historic activity instance.
     *            (optional)
     * @param finished Indication if the historic activity instance is finished.
     *            (optional)
     * @param taskAssignee The assignee of the historic activity instance.
     *            (optional)
     * @param processInstanceId The process instance id of the historic activity
     *            instance. (optional)
     * @param processDefinitionId The process definition id of the historic
     *            activity instance. (optional)
     * @param tenantId Only return instances with the given tenantId. (optional)
     * @param tenantIdLike Only return instances with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns instances without a tenantId
     *            set. If false, the withoutTenantId parameter is ignored.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-activity-instances")
    Call<ResultList<HistoricActivityInstanceResponse>> getHistoricActivityInstancesCall(
            @Query("activityId") String activityId, @Query("activityInstanceId") String activityInstanceId,
            @Query("activityName") String activityName, @Query("activityType") String activityType,
            @Query("executionId") String executionId, @Query("finished") Boolean finished,
            @Query("taskAssignee") String taskAssignee, @Query("processInstanceId") String processInstanceId,
            @Query("processDefinitionId") String processDefinitionId, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId);

    /**
     * Get historic detail
     *
     * @param id The id of the historic detail. (optional)
     * @param processInstanceId The process instance id of the historic detail.
     *            (optional)
     * @param executionId The execution id of the historic detail. (optional)
     * @param activityInstanceId The activity instance id of the historic
     *            detail. (optional)
     * @param taskId The task id of the historic detail. (optional)
     * @param selectOnlyFormProperties Indication to only return form properties
     *            in the result. (optional)
     * @param selectOnlyVariableUpdates Indication to only return variable
     *            updates in the result. (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-detail")
    Call<ResultList<HistoricDetailResponse>> getHistoricDetailInfoCall(@Query("id") String id,
            @Query("processInstanceId") String processInstanceId, @Query("executionId") String executionId,
            @Query("activityInstanceId") String activityInstanceId, @Query("taskId") String taskId,
            @Query("selectOnlyFormProperties") Boolean selectOnlyFormProperties,
            @Query("selectOnlyVariableUpdates") Boolean selectOnlyVariableUpdates);

    /**
     * Get the binary data for a historic detail variable The response body
     * contains the binary value of the variable. When the variable is of type
     * binary, the content-type of the response is set to
     * application/octet-stream, regardless of the content of the variable or
     * the request accept-type header. In case of serializable,
     * application/x-java-serialized-object is used as content-type.
     * 
     * @param detailId (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-detail/{detailId}/data")
    Call<RequestBody> getHistoricDetailVariableDataCall(@Path("detailId") String detailId);

    /**
     * Get the binary data for a historic task instance variable The response
     * body contains the binary value of the variable. When the variable is of
     * type binary, the content-type of the response is set to
     * application/octet-stream, regardless of the content of the variable or
     * the request accept-type header. In case of serializable,
     * application/x-java-serialized-object is used as content-type.
     * 
     * @param varInstanceId (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-variable-instances/{varInstanceId}/data")
    Call<RequestBody> getHistoricInstanceVariableDataCall(@Path("varInstanceId") String varInstanceId);

    /**
     * Get a historic process instance
     *
     * @param processInstanceId (required)
     * @return HistoricProcessInstanceResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}")
    Call<HistoricProcessInstanceResponse> getHistoricProcessInstanceCall(
            @Path("processInstanceId") String processInstanceId);

    /**
     * Get the binary data for a historic process instance variable The response
     * body contains the binary value of the variable. When the variable is of
     * type binary, the content-type of the response is set to
     * application/octet-stream, regardless of the content of the variable or
     * the request accept-type header. In case of serializable,
     * application/x-java-serialized-object is used as content-type.
     * 
     * @param processInstanceId (required)
     * @param variableName (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH
            + "/history/historic-process-instances/{processInstanceId}/variables/{variableName}/data")
    Call<RequestBody> getHistoricProcessInstanceVariableDataCall(@Path("processInstanceId") String processInstanceId,
            @Path("variableName") String variableName);

    /**
     * Get the binary data for a historic task instance variable The response
     * body contains the binary value of the variable. When the variable is of
     * type binary, the content-type of the response is set to
     * application/octet-stream, regardless of the content of the variable or
     * the request accept-type header. In case of serializable,
     * application/x-java-serialized-object is used as content-type.
     * 
     * @param taskId (required)
     * @param variableName (required)
     * @param scope (optional)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-task-instances/{taskId}/variables/{variableName}/data")
    Call<RequestBody> getHistoricTaskInstanceVariableDataCall(@Path("taskId") String taskId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * List of historic variable instances
     *
     * @param processInstanceId The process instance id of the historic variable
     *            instance. (optional)
     * @param taskId The task id of the historic variable instance. (optional)
     * @param excludeTaskVariables Indication to exclude the task variables from
     *            the result. (optional)
     * @param variableName The variable name of the historic variable instance.
     *            (optional)
     * @param variableNameLike The variable name using the like operator for the
     *            historic variable instance. (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-variable-instances")
    Call<ResultList<HistoricVariableInstanceResponse>> getHistoricVariableInstancesCall(
            @Query("processInstanceId") String processInstanceId, @Query("taskId") String taskId,
            @Query("excludeTaskVariables") Boolean excludeTaskVariables, @Query("variableName") String variableName,
            @Query("variableNameLike") String variableNameLike);

    /**
     * Get the identity links of a historic process instance
     *
     * @param processInstanceId (required)
     * @return List&lt;HistoricIdentityLinkResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}/identitylinks")
    Call<List<HistoricIdentityLinkResponse>> getProcessIdentityLinksCall(
            @Path("processInstanceId") String processInstanceId);

    /**
     * Get the identity links of a historic task instance
     *
     * @param taskId (required)
     * @return List&lt;HistoricIdentityLinkResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-task-instances/{taskId}/identitylinks")
    Call<List<HistoricIdentityLinkResponse>> getTaskIdentityLinksCall(@Path("taskId") String taskId);

    /**
     * Get a single historic task instance
     *
     * @param taskId (required)
     * @return HistoricTaskInstanceResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-task-instances/{taskId}")
    Call<HistoricTaskInstanceResponse> getTaskInstanceCall(@Path("taskId") String taskId);

    /**
     * List of historic process instances
     *
     * @param processInstanceId An id of the historic process instance.
     *            (optional)
     * @param processDefinitionKey The process definition key of the historic
     *            process instance. (optional)
     * @param processDefinitionId The process definition id of the historic
     *            process instance. (optional)
     * @param businessKey The business key of the historic process instance.
     *            (optional)
     * @param involvedUser An involved user of the historic process instance.
     *            (optional)
     * @param finished Indication if the historic process instance is finished.
     *            (optional)
     * @param superProcessInstanceId An optional parent process id of the
     *            historic process instance. (optional)
     * @param excludeSubprocesses Return only historic process instances which
     *            aren?t sub processes. (optional)
     * @param finishedAfter Return only historic process instances that were
     *            finished after this date. (optional)
     * @param finishedBefore Return only historic process instances that were
     *            finished before this date. (optional)
     * @param startedAfter Return only historic process instances that were
     *            started after this date. (optional)
     * @param startedBefore Return only historic process instances that were
     *            started before this date. (optional)
     * @param startedBy Return only historic process instances that were started
     *            by this user. (optional)
     * @param includeProcessVariables An indication if the historic process
     *            instance variables should be returned as well. (optional)
     * @param tenantId Only return instances with the given tenantId. (optional)
     * @param tenantIdLike Only return instances with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns instances without a tenantId
     *            set. If false, the withoutTenantId parameter is ignored.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances")
    Call<ResultList<HistoricProcessInstanceResponse>> listHistoricProcessInstancesCall(
            @Query("processInstanceId") String processInstanceId,
            @Query("processDefinitionKey") String processDefinitionKey,
            @Query("processDefinitionId") String processDefinitionId, @Query("businessKey") String businessKey,
            @Query("involvedUser") String involvedUser, @Query("finished") Boolean finished,
            @Query("superProcessInstanceId") String superProcessInstanceId,
            @Query("excludeSubprocesses") Boolean excludeSubprocesses, @Query("finishedAfter") String finishedAfter,
            @Query("finishedBefore") String finishedBefore, @Query("startedAfter") String startedAfter,
            @Query("startedBefore") String startedBefore, @Query("startedBy") String startedBy,
            @Query("includeProcessVariables") Boolean includeProcessVariables, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("tenantId") Boolean withoutTenantId);

    /**
     * Get historic task instances
     *
     * @param taskId An id of the historic task instance. (optional)
     * @param processInstanceId The process instance id of the historic task
     *            instance. (optional)
     * @param processDefinitionKey The process definition key of the historic
     *            task instance. (optional)
     * @param processDefinitionKeyLike The process definition key of the
     *            historic task instance, which matches the given value.
     *            (optional)
     * @param processDefinitionId The process definition id of the historic task
     *            instance. (optional)
     * @param processDefinitionName The process definition name of the historic
     *            task instance. (optional)
     * @param processDefinitionNameLike The process definition name of the
     *            historic task instance, which matches the given value.
     *            (optional)
     * @param processBusinessKey The process instance business key of the
     *            historic task instance. (optional)
     * @param processBusinessKeyLike The process instance business key of the
     *            historic task instance that matches the given value.
     *            (optional)
     * @param executionId The execution id of the historic task instance.
     *            (optional)
     * @param taskDefinitionKey The task definition key for tasks part of a
     *            process (optional)
     * @param taskName The task name of the historic task instance. (optional)
     * @param taskNameLike The task name with like operator for the historic
     *            task instance. (optional)
     * @param taskDescription The task description of the historic task
     *            instance. (optional)
     * @param taskDescriptionLike The task description with like operator for
     *            the historic task instance. (optional)
     * @param taskCategory Select tasks with the given category. Note that this
     *            is the task category, not the category of the process
     *            definition (namespace within the BPMN Xml). (optional)
     * @param taskDeleteReason The task delete reason of the historic task
     *            instance. (optional)
     * @param taskDeleteReasonLike The task delete reason with like operator for
     *            the historic task instance. (optional)
     * @param taskAssignee The assignee of the historic task instance.
     *            (optional)
     * @param taskAssigneeLike The assignee with like operator for the historic
     *            task instance. (optional)
     * @param taskOwner The owner of the historic task instance. (optional)
     * @param taskOwnerLike The owner with like operator for the historic task
     *            instance. (optional)
     * @param taskInvolvedUser An involved user of the historic task instance
     *            (optional)
     * @param taskPriority The priority of the historic task instance.
     *            (optional)
     * @param finished Indication if the historic task instance is finished.
     *            (optional)
     * @param processFinished Indication if the process instance of the historic
     *            task instance is finished. (optional)
     * @param parentTaskId An optional parent task id of the historic task
     *            instance. (optional)
     * @param dueDate Return only historic task instances that have a due date
     *            equal this date. (optional)
     * @param dueDateAfter Return only historic task instances that have a due
     *            date after this date. (optional)
     * @param dueDateBefore Return only historic task instances that have a due
     *            date before this date. (optional)
     * @param withoutDueDate Return only historic task instances that have no
     *            due-date. When false is provided as value, this parameter is
     *            ignored. (optional)
     * @param taskCompletedOn Return only historic task instances that have been
     *            completed on this date. (optional)
     * @param taskCompletedAfter Return only historic task instances that have
     *            been completed after this date. (optional)
     * @param taskCompletedBefore Return only historic task instances that have
     *            been completed before this date. (optional)
     * @param taskCreatedOn Return only historic task instances that were
     *            created on this date. (optional)
     * @param taskCreatedBefore Return only historic task instances that were
     *            created before this date. (optional)
     * @param taskCreatedAfter Return only historic task instances that were
     *            created after this date. (optional)
     * @param includeTaskLocalVariables An indication if the historic task
     *            instance local variables should be returned as well.
     *            (optional)
     * @param includeProcessVariables An indication if the historic task
     *            instance global variables should be returned as well.
     *            (optional)
     * @param tenantId Only return historic task instances with the given
     *            tenantId. (optional)
     * @param tenantIdLike Only return historic task instances with a tenantId
     *            like the given value. (optional)
     * @param withoutTenantId If true, only returns historic task instances
     *            without a tenantId set. If false, the withoutTenantId
     *            parameter is ignored. (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-task-instances")
    Call<ResultList<HistoricTaskInstanceResponse>> listHistoricTaskInstancesCall(
            @Query("processInstanceId") String taskId, @Query("processInstanceId") String processInstanceId,
            @Query("processDefinitionKey") String processDefinitionKey,
            @Query("processDefinitionKeyLike") String processDefinitionKeyLike,
            @Query("processDefinitionId") String processDefinitionId,
            @Query("processDefinitionName") String processDefinitionName,
            @Query("processDefinitionNameLike") String processDefinitionNameLike,
            @Query("processBusinessKey") String processBusinessKey,
            @Query("processBusinessKeyLike") String processBusinessKeyLike, @Query("executionId") String executionId,
            @Query("taskDefinitionKey") String taskDefinitionKey, @Query("taskName") String taskName,
            @Query("taskNameLike") String taskNameLike, @Query("taskDescription") String taskDescription,
            @Query("taskDescriptionLike") String taskDescriptionLike, @Query("taskCategory") String taskCategory,
            @Query("taskDeleteReason") String taskDeleteReason,
            @Query("taskDeleteReasonLike") String taskDeleteReasonLike, @Query("taskAssignee") String taskAssignee,
            @Query("taskAssigneeLike") String taskAssigneeLike, @Query("taskOwner") String taskOwner,
            @Query("taskOwnerLike") String taskOwnerLike, @Query("taskInvolvedUser") String taskInvolvedUser,
            @Query("taskPriority") String taskPriority, @Query("finished") Boolean finished,
            @Query("processFinished") Boolean processFinished, @Query("parentTaskId") String parentTaskId,
            @Query("dueDate") String dueDate, @Query("dueDateAfter") String dueDateAfter,
            @Query("dueDateBefore") String dueDateBefore, @Query("withoutDueDate") Boolean withoutDueDate,
            @Query("taskCompletedOn") String taskCompletedOn, @Query("taskCompletedAfter") String taskCompletedAfter,
            @Query("taskCompletedBefore") String taskCompletedBefore, @Query("taskCreatedOn") String taskCreatedOn,
            @Query("taskCreatedBefore") String taskCreatedBefore, @Query("taskCreatedAfter") String taskCreatedAfter,
            @Query("includeTaskLocalVariables") String includeTaskLocalVariables,
            @Query("includeProcessVariables") Boolean includeProcessVariables, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("tenantId") Boolean withoutTenantId);

    /**
     * Query for historic activity instances All supported JSON parameter fields
     * allowed are exactly the same as the parameters found for getting a
     * collection of historic task instances, but passed in as JSON-body
     * arguments rather than URL-parameters to allow for more advanced querying
     * and preventing errors with request-uri?s that are too long.
     * 
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/query/historic-activity-instances")
    Call<ResultList<HistoricActivityInstanceResponse>> queryActivityInstancesCall(
            @Body HistoricActivityInstanceQueryRequest body);

    /**
     * Query for historic details All supported JSON parameter fields allowed
     * are exactly the same as the parameters found for getting a collection of
     * historic process instances, but passed in as JSON-body arguments rather
     * than URL-parameters to allow for more advanced querying and preventing
     * errors with request-uri?s that are too long.
     * 
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/query/historic-detail")
    Call<ResultList<HistoricDetailResponse>> queryHistoricDetailCall(@Body HistoricDetailQueryRequest body);

    /**
     * Query for historic process instances All supported JSON parameter fields
     * allowed are exactly the same as the parameters found for getting a
     * collection of historic process instances, but passed in as JSON-body
     * arguments rather than URL-parameters to allow for more advanced querying
     * and preventing errors with request-uri?s that are too long. On top of
     * that, the query allows for filtering based on process variables. The
     * variables property is a JSON-array containing objects with the format as
     * described here.
     * 
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/query/historic-process-instances")
    Call<ResultList<HistoricProcessInstanceResponse>> queryHistoricProcessInstanceCall(
            @Body HistoricProcessInstanceQueryRequest body);

    /**
     * Query for historic task instances All supported JSON parameter fields
     * allowed are exactly the same as the parameters found for getting a
     * collection of historic task instances, but passed in as JSON-body
     * arguments rather than URL-parameters to allow for more advanced querying
     * and preventing errors with request-uri?s that are too long. On top of
     * that, the query allows for filtering based on process variables. The
     * taskVariables and processVariables properties are JSON-arrays containing
     * objects with the format as described here.
     * 
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/query/historic-task-instances")
    Call<ResultList<HistoricTaskInstanceResponse>> queryHistoricTaskInstanceCall(
            @Body HistoricProcessInstanceQueryRequest body);

    /**
     * Query for historic task instances All supported JSON parameter fields
     * allowed are exactly the same as the parameters found for getting a
     * collection of historic task instances, but passed in as JSON-body
     * arguments rather than URL-parameters to allow for more advanced querying
     * and preventing errors with request-uri?s that are too long. On top of
     * that, the query allows for filtering based on process variables. The
     * taskVariables and processVariables properties are JSON-arrays containing
     * objects with the format as described here.
     * 
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/query/historic-variable-instances")
    Call<ResultList<HistoricVariableInstanceResponse>> queryVariableInstancesCall(
            @Body HistoricVariableInstanceQueryRequest body);

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
     * Create a new comment on a historic process instance Parameter
     * saveProcessInstanceId is optional, if true save process instance id of
     * task with comment.
     *
     * @param processInstanceId (required)
     * @param body (optional)
     * @return CommentResponse
     */
    @POST(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}/comments")
    Observable<CommentResponse> createCommentObservable(@Path("processInstanceId") String processInstanceId,
            @Body CommentRequest body);

    /**
     * Delete a comment on a historic process instance
     *
     * @param processInstanceId The id of the historic process instance to
     *            delete the comment for. (required)
     * @param commentId The id of the comment. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}/comments/{commentId}")
    Observable<Void> deleteCommentObservable(@Path("processInstanceId") String processInstanceId,
            @Path("commentId") String commentId);

    /**
     * Delete a historic process instance
     *
     * @param processInstanceId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}")
    Observable<Void> deleteHitoricProcessInstanceObservable(@Path("processInstanceId") String processInstanceId);

    /**
     * Delete a historic task instance
     *
     * @param taskId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/history/historic-task-instances/{taskId}")
    Observable<Void> deleteTaskInstanceObservable(@Path("taskId") String taskId);

    /**
     * Get a comment on a historic process instance
     *
     * @param processInstanceId The id of the historic process instance to get
     *            the comment for. (required)
     * @param commentId The id of the comment. (required)
     * @return CommentResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}/comments/{commentId}")
    Observable<CommentResponse> getCommentObservable(@Path("processInstanceId") String processInstanceId,
            @Path("commentId") String commentId);

    /**
     * Get all comments on a historic process instance
     *
     * @param processInstanceId The id of the process instance to get the
     *            comments for. (required)
     * @return List&lt;CommentResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}/comments")
    Observable<List<CommentResponse>> getCommentsObservable(@Path("processInstanceId") String processInstanceId);

    /**
     * Get historic activity instances
     *
     * @param activityId An id of the activity instance. (optional)
     * @param activityInstanceId An id of the historic activity instance.
     *            (optional)
     * @param activityName The name of the historic activity instance.
     *            (optional)
     * @param activityType The element type of the historic activity instance.
     *            (optional)
     * @param executionId The execution id of the historic activity instance.
     *            (optional)
     * @param finished Indication if the historic activity instance is finished.
     *            (optional)
     * @param taskAssignee The assignee of the historic activity instance.
     *            (optional)
     * @param processInstanceId The process instance id of the historic activity
     *            instance. (optional)
     * @param processDefinitionId The process definition id of the historic
     *            activity instance. (optional)
     * @param tenantId Only return instances with the given tenantId. (optional)
     * @param tenantIdLike Only return instances with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns instances without a tenantId
     *            set. If false, the withoutTenantId parameter is ignored.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-activity-instances")
    Observable<ResultList<HistoricActivityInstanceResponse>> getHistoricActivityInstancesObservable(
            @Query("activityId") String activityId, @Query("activityInstanceId") String activityInstanceId,
            @Query("activityName") String activityName, @Query("activityType") String activityType,
            @Query("executionId") String executionId, @Query("finished") Boolean finished,
            @Query("taskAssignee") String taskAssignee, @Query("processInstanceId") String processInstanceId,
            @Query("processDefinitionId") String processDefinitionId, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId);

    /**
     * Get historic detail
     *
     * @param id The id of the historic detail. (optional)
     * @param processInstanceId The process instance id of the historic detail.
     *            (optional)
     * @param executionId The execution id of the historic detail. (optional)
     * @param activityInstanceId The activity instance id of the historic
     *            detail. (optional)
     * @param taskId The task id of the historic detail. (optional)
     * @param selectOnlyFormProperties Indication to only return form properties
     *            in the result. (optional)
     * @param selectOnlyVariableUpdates Indication to only return variable
     *            updates in the result. (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-detail")
    Observable<ResultList<HistoricDetailResponse>> getHistoricDetailInfoObservable(@Query("id") String id,
            @Query("processInstanceId") String processInstanceId, @Query("executionId") String executionId,
            @Query("activityInstanceId") String activityInstanceId, @Query("taskId") String taskId,
            @Query("selectOnlyFormProperties") Boolean selectOnlyFormProperties,
            @Query("selectOnlyVariableUpdates") Boolean selectOnlyVariableUpdates);

    /**
     * Get the binary data for a historic detail variable The response body
     * contains the binary value of the variable. When the variable is of type
     * binary, the content-type of the response is set to
     * application/octet-stream, regardless of the content of the variable or
     * the request accept-type header. In case of serializable,
     * application/x-java-serialized-object is used as content-type.
     *
     * @param detailId (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-detail/{detailId}/data")
    Observable<RequestBody> getHistoricDetailVariableDataObservable(@Path("detailId") String detailId);

    /**
     * Get the binary data for a historic task instance variable The response
     * body contains the binary value of the variable. When the variable is of
     * type binary, the content-type of the response is set to
     * application/octet-stream, regardless of the content of the variable or
     * the request accept-type header. In case of serializable,
     * application/x-java-serialized-object is used as content-type.
     *
     * @param varInstanceId (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-variable-instances/{varInstanceId}/data")
    Observable<RequestBody> getHistoricInstanceVariableDataObservable(@Path("varInstanceId") String varInstanceId);

    /**
     * Get a historic process instance
     *
     * @param processInstanceId (required)
     * @return HistoricProcessInstanceResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}")
    Observable<HistoricProcessInstanceResponse> getHistoricProcessInstanceObservable(
            @Path("processInstanceId") String processInstanceId);

    /**
     * Get the binary data for a historic process instance variable The response
     * body contains the binary value of the variable. When the variable is of
     * type binary, the content-type of the response is set to
     * application/octet-stream, regardless of the content of the variable or
     * the request accept-type header. In case of serializable,
     * application/x-java-serialized-object is used as content-type.
     *
     * @param processInstanceId (required)
     * @param variableName (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH
            + "/history/historic-process-instances/{processInstanceId}/variables/{variableName}/data")
    Observable<RequestBody> getHistoricProcessInstanceVariableDataObservable(
            @Path("processInstanceId") String processInstanceId, @Path("variableName") String variableName);

    /**
     * Get the binary data for a historic task instance variable The response
     * body contains the binary value of the variable. When the variable is of
     * type binary, the content-type of the response is set to
     * application/octet-stream, regardless of the content of the variable or
     * the request accept-type header. In case of serializable,
     * application/x-java-serialized-object is used as content-type.
     *
     * @param taskId (required)
     * @param variableName (required)
     * @param scope (optional)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-task-instances/{taskId}/variables/{variableName}/data")
    Observable<RequestBody> getHistoricTaskInstanceVariableDataObservable(@Path("taskId") String taskId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    /**
     * List of historic variable instances
     *
     * @param processInstanceId The process instance id of the historic variable
     *            instance. (optional)
     * @param taskId The task id of the historic variable instance. (optional)
     * @param excludeTaskVariables Indication to exclude the task variables from
     *            the result. (optional)
     * @param variableName The variable name of the historic variable instance.
     *            (optional)
     * @param variableNameLike The variable name using the like operator for the
     *            historic variable instance. (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-variable-instances")
    Observable<ResultList<HistoricVariableInstanceResponse>> getHistoricVariableInstancesObservable(
            @Query("processInstanceId") String processInstanceId, @Query("taskId") String taskId,
            @Query("excludeTaskVariables") Boolean excludeTaskVariables, @Query("variableName") String variableName,
            @Query("variableNameLike") String variableNameLike);

    /**
     * Get the identity links of a historic process instance
     *
     * @param processInstanceId (required)
     * @return List&lt;HistoricIdentityLinkResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances/{processInstanceId}/identitylinks")
    Observable<List<HistoricIdentityLinkResponse>> getProcessIdentityLinksObservable(
            @Path("processInstanceId") String processInstanceId);

    /**
     * Get the identity links of a historic task instance
     *
     * @param taskId (required)
     * @return List&lt;HistoricIdentityLinkResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-task-instances/{taskId}/identitylinks")
    Observable<List<HistoricIdentityLinkResponse>> getTaskIdentityLinksObservable(@Path("taskId") String taskId);

    /**
     * Get a single historic task instance
     *
     * @param taskId (required)
     * @return HistoricTaskInstanceResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-task-instances/{taskId}")
    Observable<HistoricTaskInstanceResponse> getTaskInstanceObservable(@Path("taskId") String taskId);

    /**
     * List of historic process instances
     *
     * @param processInstanceId An id of the historic process instance.
     *            (optional)
     * @param processDefinitionKey The process definition key of the historic
     *            process instance. (optional)
     * @param processDefinitionId The process definition id of the historic
     *            process instance. (optional)
     * @param businessKey The business key of the historic process instance.
     *            (optional)
     * @param involvedUser An involved user of the historic process instance.
     *            (optional)
     * @param finished Indication if the historic process instance is finished.
     *            (optional)
     * @param superProcessInstanceId An optional parent process id of the
     *            historic process instance. (optional)
     * @param excludeSubprocesses Return only historic process instances which
     *            aren?t sub processes. (optional)
     * @param finishedAfter Return only historic process instances that were
     *            finished after this date. (optional)
     * @param finishedBefore Return only historic process instances that were
     *            finished before this date. (optional)
     * @param startedAfter Return only historic process instances that were
     *            started after this date. (optional)
     * @param startedBefore Return only historic process instances that were
     *            started before this date. (optional)
     * @param startedBy Return only historic process instances that were started
     *            by this user. (optional)
     * @param includeProcessVariables An indication if the historic process
     *            instance variables should be returned as well. (optional)
     * @param tenantId Only return instances with the given tenantId. (optional)
     * @param tenantIdLike Only return instances with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns instances without a tenantId
     *            set. If false, the withoutTenantId parameter is ignored.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-process-instances")
    Observable<ResultList<HistoricProcessInstanceResponse>> listHistoricProcessInstancesObservable(
            @Query("processInstanceId") String processInstanceId,
            @Query("processDefinitionKey") String processDefinitionKey,
            @Query("processDefinitionId") String processDefinitionId, @Query("businessKey") String businessKey,
            @Query("involvedUser") String involvedUser, @Query("finished") Boolean finished,
            @Query("superProcessInstanceId") String superProcessInstanceId,
            @Query("excludeSubprocesses") Boolean excludeSubprocesses, @Query("finishedAfter") String finishedAfter,
            @Query("finishedBefore") String finishedBefore, @Query("startedAfter") String startedAfter,
            @Query("startedBefore") String startedBefore, @Query("startedBy") String startedBy,
            @Query("includeProcessVariables") Boolean includeProcessVariables, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("tenantId") Boolean withoutTenantId);

    /**
     * Get historic task instances
     *
     * @param taskId An id of the historic task instance. (optional)
     * @param processInstanceId The process instance id of the historic task
     *            instance. (optional)
     * @param processDefinitionKey The process definition key of the historic
     *            task instance. (optional)
     * @param processDefinitionKeyLike The process definition key of the
     *            historic task instance, which matches the given value.
     *            (optional)
     * @param processDefinitionId The process definition id of the historic task
     *            instance. (optional)
     * @param processDefinitionName The process definition name of the historic
     *            task instance. (optional)
     * @param processDefinitionNameLike The process definition name of the
     *            historic task instance, which matches the given value.
     *            (optional)
     * @param processBusinessKey The process instance business key of the
     *            historic task instance. (optional)
     * @param processBusinessKeyLike The process instance business key of the
     *            historic task instance that matches the given value.
     *            (optional)
     * @param executionId The execution id of the historic task instance.
     *            (optional)
     * @param taskDefinitionKey The task definition key for tasks part of a
     *            process (optional)
     * @param taskName The task name of the historic task instance. (optional)
     * @param taskNameLike The task name with like operator for the historic
     *            task instance. (optional)
     * @param taskDescription The task description of the historic task
     *            instance. (optional)
     * @param taskDescriptionLike The task description with like operator for
     *            the historic task instance. (optional)
     * @param taskCategory Select tasks with the given category. Note that this
     *            is the task category, not the category of the process
     *            definition (namespace within the BPMN Xml). (optional)
     * @param taskDeleteReason The task delete reason of the historic task
     *            instance. (optional)
     * @param taskDeleteReasonLike The task delete reason with like operator for
     *            the historic task instance. (optional)
     * @param taskAssignee The assignee of the historic task instance.
     *            (optional)
     * @param taskAssigneeLike The assignee with like operator for the historic
     *            task instance. (optional)
     * @param taskOwner The owner of the historic task instance. (optional)
     * @param taskOwnerLike The owner with like operator for the historic task
     *            instance. (optional)
     * @param taskInvolvedUser An involved user of the historic task instance
     *            (optional)
     * @param taskPriority The priority of the historic task instance.
     *            (optional)
     * @param finished Indication if the historic task instance is finished.
     *            (optional)
     * @param processFinished Indication if the process instance of the historic
     *            task instance is finished. (optional)
     * @param parentTaskId An optional parent task id of the historic task
     *            instance. (optional)
     * @param dueDate Return only historic task instances that have a due date
     *            equal this date. (optional)
     * @param dueDateAfter Return only historic task instances that have a due
     *            date after this date. (optional)
     * @param dueDateBefore Return only historic task instances that have a due
     *            date before this date. (optional)
     * @param withoutDueDate Return only historic task instances that have no
     *            due-date. When false is provided as value, this parameter is
     *            ignored. (optional)
     * @param taskCompletedOn Return only historic task instances that have been
     *            completed on this date. (optional)
     * @param taskCompletedAfter Return only historic task instances that have
     *            been completed after this date. (optional)
     * @param taskCompletedBefore Return only historic task instances that have
     *            been completed before this date. (optional)
     * @param taskCreatedOn Return only historic task instances that were
     *            created on this date. (optional)
     * @param taskCreatedBefore Return only historic task instances that were
     *            created before this date. (optional)
     * @param taskCreatedAfter Return only historic task instances that were
     *            created after this date. (optional)
     * @param includeTaskLocalVariables An indication if the historic task
     *            instance local variables should be returned as well.
     *            (optional)
     * @param includeProcessVariables An indication if the historic task
     *            instance global variables should be returned as well.
     *            (optional)
     * @param tenantId Only return historic task instances with the given
     *            tenantId. (optional)
     * @param tenantIdLike Only return historic task instances with a tenantId
     *            like the given value. (optional)
     * @param withoutTenantId If true, only returns historic task instances
     *            without a tenantId set. If false, the withoutTenantId
     *            parameter is ignored. (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/history/historic-task-instances")
    Observable<ResultList<HistoricTaskInstanceResponse>> listHistoricTaskInstancesObservable(
            @Query("processInstanceId") String taskId, @Query("processInstanceId") String processInstanceId,
            @Query("processDefinitionKey") String processDefinitionKey,
            @Query("processDefinitionKeyLike") String processDefinitionKeyLike,
            @Query("processDefinitionId") String processDefinitionId,
            @Query("processDefinitionName") String processDefinitionName,
            @Query("processDefinitionNameLike") String processDefinitionNameLike,
            @Query("processBusinessKey") String processBusinessKey,
            @Query("processBusinessKeyLike") String processBusinessKeyLike, @Query("executionId") String executionId,
            @Query("taskDefinitionKey") String taskDefinitionKey, @Query("taskName") String taskName,
            @Query("taskNameLike") String taskNameLike, @Query("taskDescription") String taskDescription,
            @Query("taskDescriptionLike") String taskDescriptionLike, @Query("taskCategory") String taskCategory,
            @Query("taskDeleteReason") String taskDeleteReason,
            @Query("taskDeleteReasonLike") String taskDeleteReasonLike, @Query("taskAssignee") String taskAssignee,
            @Query("taskAssigneeLike") String taskAssigneeLike, @Query("taskOwner") String taskOwner,
            @Query("taskOwnerLike") String taskOwnerLike, @Query("taskInvolvedUser") String taskInvolvedUser,
            @Query("taskPriority") String taskPriority, @Query("finished") Boolean finished,
            @Query("processFinished") Boolean processFinished, @Query("parentTaskId") String parentTaskId,
            @Query("dueDate") String dueDate, @Query("dueDateAfter") String dueDateAfter,
            @Query("dueDateBefore") String dueDateBefore, @Query("withoutDueDate") Boolean withoutDueDate,
            @Query("taskCompletedOn") String taskCompletedOn, @Query("taskCompletedAfter") String taskCompletedAfter,
            @Query("taskCompletedBefore") String taskCompletedBefore, @Query("taskCreatedOn") String taskCreatedOn,
            @Query("taskCreatedBefore") String taskCreatedBefore, @Query("taskCreatedAfter") String taskCreatedAfter,
            @Query("includeTaskLocalVariables") String includeTaskLocalVariables,
            @Query("includeProcessVariables") Boolean includeProcessVariables, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("tenantId") Boolean withoutTenantId);

    /**
     * Query for historic activity instances All supported JSON parameter fields
     * allowed are exactly the same as the parameters found for getting a
     * collection of historic task instances, but passed in as JSON-body
     * arguments rather than URL-parameters to allow for more advanced querying
     * and preventing errors with request-uri?s that are too long.
     *
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/query/historic-activity-instances")
    Observable<ResultList<HistoricActivityInstanceResponse>> queryActivityInstancesObservable(
            @Body HistoricActivityInstanceQueryRequest body);

    /**
     * Query for historic details All supported JSON parameter fields allowed
     * are exactly the same as the parameters found for getting a collection of
     * historic process instances, but passed in as JSON-body arguments rather
     * than URL-parameters to allow for more advanced querying and preventing
     * errors with request-uri?s that are too long.
     *
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/query/historic-detail")
    Observable<ResultList<HistoricDetailResponse>> queryHistoricDetailObservable(@Body HistoricDetailQueryRequest body);

    /**
     * Query for historic process instances All supported JSON parameter fields
     * allowed are exactly the same as the parameters found for getting a
     * collection of historic process instances, but passed in as JSON-body
     * arguments rather than URL-parameters to allow for more advanced querying
     * and preventing errors with request-uri?s that are too long. On top of
     * that, the query allows for filtering based on process variables. The
     * variables property is a JSON-array containing objects with the format as
     * described here.
     *
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/query/historic-process-instances")
    Observable<ResultList<HistoricProcessInstanceResponse>> queryHistoricProcessInstanceObservable(
            @Body HistoricProcessInstanceQueryRequest body);

    /**
     * Query for historic task instances All supported JSON parameter fields
     * allowed are exactly the same as the parameters found for getting a
     * collection of historic task instances, but passed in as JSON-body
     * arguments rather than URL-parameters to allow for more advanced querying
     * and preventing errors with request-uri?s that are too long. On top of
     * that, the query allows for filtering based on process variables. The
     * taskVariables and processVariables properties are JSON-arrays containing
     * objects with the format as described here.
     *
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/query/historic-task-instances")
    Observable<ResultList<HistoricTaskInstanceResponse>> queryHistoricTaskInstanceObservable(
            @Body HistoricProcessInstanceQueryRequest body);

    /**
     * Query for historic task instances All supported JSON parameter fields
     * allowed are exactly the same as the parameters found for getting a
     * collection of historic task instances, but passed in as JSON-body
     * arguments rather than URL-parameters to allow for more advanced querying
     * and preventing errors with request-uri?s that are too long. On top of
     * that, the query allows for filtering based on process variables. The
     * taskVariables and processVariables properties are JSON-arrays containing
     * objects with the format as described here.
     *
     * @param body (optional)
     * @return DataResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/query/historic-variable-instances")
    Observable<ResultList<HistoricVariableInstanceResponse>> queryVariableInstancesObservable(
            @Body HistoricVariableInstanceQueryRequest body);

}
