package org.alfresco.client.services.process.activiti.core.api;

import static org.alfresco.client.services.process.activiti.common.constant.RequestConstant.*;
import static org.alfresco.client.services.process.activiti.core.ActivitiConstant.ACTIVITI_SERVICE_PATH;

import java.util.List;
import java.util.Map;

import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;
import org.alfresco.client.services.process.activiti.core.model.body.*;
import org.alfresco.client.services.process.activiti.core.model.representation.*;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 03/05/2017.
 */
public interface TasksAPI
{

    /**
     * Create a new attachment on a task, containing a link to an external
     * resource or an attached file ## Create a new attachment on a task,
     * containing a link to an external resource &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;Simple attachment\&quot;,
     * \&quot;description\&quot;:\&quot;Simple attachment description\&quot;,
     * \&quot;type\&quot;:\&quot;simpleType\&quot;,
     * \&quot;externalUrl\&quot;:\&quot;http://activiti.org\&quot; }
     * &#x60;&#x60;&#x60; Only the attachment name is required to create a new
     * attachment. ## Create a new attachment on a task, with an attached file
     * The request should be of type multipart/form-data. There should be a
     * single file-part included with the binary value of the variable. On top
     * of that, the following additional form-fields can be present: - *name*:
     * Required name of the variable. - *description*: Description of the
     * attachment, optional. - *type*: Type of attachment, optional. Supports
     * any arbitrary string or a valid HTTP content-type.
     * 
     * @param taskId The id of the task to create the attachment for. (required)
     * @return AttachmentResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/attachments")
    Call<AttachmentResponse> createAttachmentCall(@Path(TASK_ID) String taskId, @Body AttachmentRequest request);

    @Multipart
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/attachments")
    Call<AttachmentResponse> createAttachmentCall(@Path(TASK_ID) String taskId,
            @PartMap() Map<String, RequestBody> partMap);

    /**
     * Create Task
     *
     * @param body (optional)
     * @return TaskResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks")
    Call<TaskResponse> createTaskCall(@Body TaskRequest body);

    /**
     * Create a new comment on a task
     *
     * @param taskId The id of the task to create the comment for. (required)
     * @param body (optional)
     * @return CommentResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/comments")
    Call<CommentResponse> createTaskCommentsCall(@Path(TASK_ID) String taskId, @Body CommentRequest body);

    /**
     * Create an identity link on a task ## Request body (user)
     * &#x60;&#x60;&#x60;JSON { \&quot;userId\&quot; : \&quot;kermit\&quot;,
     * \&quot;type\&quot; : \&quot;candidate\&quot;, } &#x60;&#x60;&#x60; ##
     * Request body (group) &#x60;&#x60;&#x60;JSON { \&quot;groupId\&quot; :
     * \&quot;sales\&quot;, \&quot;type\&quot; : \&quot;candidate\&quot;, }
     * &#x60;&#x60;&#x60;
     * 
     * @param taskId The id of the task . (required)
     * @param body (optional)
     * @return RestIdentityLink
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/identitylinks")
    Call<RestIdentityLink> createTaskInstanceIdentityLinksCall(@Path(TASK_ID) String taskId,
            @Body RestIdentityLink body);

    /**
     * Create new variables on a task ## Request body for creating simple
     * (non-binary) variables &#x60;&#x60;&#x60;JSON [ { \&quot;name\&quot; :
     * \&quot;myTaskVariable\&quot;, \&quot;scope\&quot; : \&quot;local\&quot;,
     * \&quot;type\&quot; : \&quot;string\&quot;, \&quot;value\&quot; :
     * \&quot;Hello my friend\&quot; }, { } ] &#x60;&#x60;&#x60; The request
     * body should be an array containing one or more JSON-objects representing
     * the variables that should be created. - *name*: Required name of the
     * variable scope: Scope of variable that is created. If omitted, local is
     * assumed. - *type*: Type of variable that is created. If omitted, reverts
     * to raw JSON-value type (string, boolean, integer or double). - *value*:
     * Variable value. More information about the variable format can be found
     * in the REST variables section. ## Request body for Creating a new binary
     * variable The request should be of type multipart/form-data. There should
     * be a single file-part included with the binary value of the variable. On
     * top of that, the following additional form-fields can be present: -
     * *name*: Required name of the variable. scope: Scope of variable that is
     * created. If omitted, local is assumed. - *type*: Type of variable that is
     * created. If omitted, binary is assumed and the binary data in the request
     * will be stored as an array of bytes.
     * 
     * @param taskId The id of the task to create the new variable for.
     *            (required)
     * @return Object
     */
    // FIXME multiple signature
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/variables")
    Call<List<RestVariable>> createTaskVariableCall(@Path(TASK_ID) String taskId, @Body List<RestVariable> body);

    /**
     * Delete all local variables on a task
     *
     * @param taskId The id of the task the variable to delete belongs to.
     *            (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/variables")
    Call<Void> deleteAllLocalTaskVariablesCall(@Path(TASK_ID) String taskId);

    /**
     * Delete an attachment on a task
     *
     * @param taskId The id of the task to delete the attachment for. (required)
     * @param attachmentId The id of the attachment. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/attachment/{attachmentId}")
    Call<Void> deleteAttachmentCall(@Path(TASK_ID) String taskId, @Path(ATTACHMENT_ID) String attachmentId);

    /**
     * Delete an event on a task
     *
     * @param taskId (required)
     * @param eventId (required)
     * @return ApiResponse&lt;Void&gt;
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/events/{eventId}")
    Call<Void> deleteEventCall(@Path(TASK_ID) String taskId, @Path(EVENT_ID) String eventId);

    /**
     * Delete a task
     *
     * @param taskId The id of the task to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}")
    Call<Void> deleteTaskCall(@Path(TASK_ID) String taskId);

    /**
     * Delete a comment on a task
     *
     * @param taskId The id of the task to delete the comment for. (required)
     * @param commentId The id of the comment. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/comments/{commentId}")
    Call<Void> deleteTaskCommentCall(@Path(TASK_ID) String taskId, @Path(COMMENT_ID) String commentId);

    /**
     * Delete an identity link on a task
     *
     * @param taskId The id of the task. (required)
     * @param family Either groups or users, depending on what kind of identity
     *            is targeted. (required)
     * @param identityId The id of the identity. (required)
     * @param type The type of identity link. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}")
    Call<Void> deleteTaskInstanceIdentityLinksCall(@Path(TASK_ID) String taskId, @Path(FAMILY) String family,
            @Path(IDENTITY_ID) String identityId, @Path(TYPE) String type);

    /**
     * Delete a variable on a task
     *
     * @param taskId The id of the task the variable to delete belongs to.
     *            (required)
     * @param variableName The name of the variable to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/variables/{variableName}")
    Call<Void> deleteTaskInstanceVariableCall(@Path(TASK_ID) String taskId, @Path(VARIABLE_NAME) String variableName);

    /**
     * Tasks actions ## Complete a task - Request Body &#x60;&#x60;&#x60;JSON {
     * \&quot;action\&quot; : \&quot;complete\&quot;, \&quot;variables\&quot; :
     * [] } &#x60;&#x60;&#x60;Completes the task. Optional variable array can be
     * passed in using the variables property. More information about the
     * variable format can be found in the REST variables section. Note that the
     * variable-scope that is supplied is ignored and the variables are set on
     * the parent-scope unless a variable exists in a local scope, which is
     * overridden in this case. This is the same behavior as the
     * TaskService.completeTask(taskId, variables) invocation. Note that also a
     * transientVariables property is accepted as part of this json, that
     * follows the same structure as the variables property. ## Claim a task -
     * Request Body &#x60;&#x60;&#x60;JSON { \&quot;action\&quot; :
     * \&quot;claim\&quot;, \&quot;assignee\&quot; : \&quot;userWhoClaims\&quot;
     * } &#x60;&#x60;&#x60; Claims the task by the given assignee. If the
     * assignee is null, the task is assigned to no-one, claimable again. ##
     * Delegate a task - Request Body &#x60;&#x60;&#x60;JSON {
     * \&quot;action\&quot; : \&quot;delegate\&quot;, \&quot;assignee\&quot; :
     * \&quot;userToDelegateTo\&quot; } &#x60;&#x60;&#x60; Delegates the task to
     * the given assignee. The assignee is required. ## Suspend a process
     * instance &#x60;&#x60;&#x60;JSON { \&quot;action\&quot; :
     * \&quot;resolve\&quot; } &#x60;&#x60;&#x60; Resolves the task delegation.
     * The task is assigned back to the task owner (if any).
     * 
     * @param taskId (required)
     * @param body (optional)
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}")
    Call<Void> executeTaskActionCall(@Path(TASK_ID) String taskId, @Body TaskActionRequest body);

    /**
     * Get the binary data for a variable The response body contains the binary
     * value of the variable. When the variable is of type binary, the
     * content-type of the response is set to application/octet-stream,
     * regardless of the content of the variable or the request accept-type
     * header. In case of serializable, application/x-java-serialized-object is
     * used as content-type.
     * 
     * @param taskId The id of the task to get a variable data for. (required)
     * @param variableName The name of the variable to get data for. Only
     *            variables of type binary and serializable can be used. If any
     *            other type of variable is used, a 404 is returned. (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/variables/{variableName}/data")
    Call<RequestBody> geTaskVariableDataCall(@Path(TASK_ID) String taskId, @Path(VARIABLE_NAME) String variableName);

    /**
     * Get an attachment on a task
     *
     * @param taskId The id of the task to get the attachment for. (required)
     * @param attachmentId The id of the attachment. (required)
     * @return AttachmentResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/attachments/{attachmentId}")
    Call<AttachmentResponse> getAttachmentCall(@Path(TASK_ID) String taskId, @Path(ATTACHMENT_ID) String attachmentId);

    /**
     * Get the content for an attachment The response body contains the binary
     * content. By default, the content-type of the response is set to
     * application/octet-stream unless the attachment type contains a valid
     * Content-type.
     * 
     * @param taskId The id of the task to get a variable data for. (required)
     * @param attachmentId The id of the attachment, a 404 is returned when the
     *            attachment points to an external URL rather than content
     *            attached in Activiti. (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/attachments/{attachmentId}/content")
    Call<RequestBody> getAttachmentContentCall(@Path(TASK_ID) String taskId, @Path(ATTACHMENT_ID) String attachmentId);

    /**
     * Get all attachments on a task
     *
     * @param taskId The id of the task to get the attachments for. (required)
     * @return List&lt;AttachmentResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/attachments")
    Call<List<AttachmentResponse>> getAttachmentsCall(@Path(TASK_ID) String taskId);

    /**
     * Get an event on a task
     *
     * @param taskId The id of the task to get the event for. (required)
     * @param eventId The id of the event. (required)
     * @return EventResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/events/{eventId}")
    Call<EventResponse> getEventCall(@Path(TASK_ID) String taskId, @Path(EVENT_ID) String eventId);

    /**
     * Get all events for a task
     *
     * @param taskId The id of the task to get the events for. (required)
     * @return List&lt;EventResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/events")
    Call<List<EventResponse>> getEventsCall(@Path(TASK_ID) String taskId);

    /**
     * Get all identitylinks for a task for either groups or users ## Get all
     * identitylinks for a task URL &#x60;&#x60;&#x60; GET
     * runtime/tasks/{taskId}/identitylinks/users GET
     * runtime/tasks/{taskId}/identitylinks/groups &#x60;&#x60;&#x60; Returns
     * only identity links targetting either users or groups. Response body and
     * status-codes are exactly the same as when getting the full list of
     * identity links for a task.
     * 
     * @param taskId (required)
     * @param family (required)
     * @return List&lt;RestIdentityLink&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/identitylinks/{family}")
    Call<List<RestIdentityLink>> getIdentityLinksForFamilyCall(@Path(TASK_ID) String taskId,
            @Path(FAMILY) String family);

    /**
     * Query for tasks All supported JSON parameter fields allowed are exactly
     * the same as the parameters found for getting a collection of tasks
     * (except for candidateGroupIn which is only available in this POST task
     * query REST service), but passed in as JSON-body arguments rather than
     * URL-parameters to allow for more advanced querying and preventing errors
     * with request-uri?s that are too long. On top of that, the query allows
     * for filtering based on task and process variables. The taskVariables and
     * processInstanceVariables are both JSON-arrays containing objects with the
     * format as described here.
     * 
     * @param body (optional)
     * @return DataResponse
     */
    @POST(ACTIVITI_SERVICE_PATH + "/query/tasks")
    Call<ResultList<TaskResponse>> getQueryResultCall(@Body TaskQueryRequest body);

    /**
     * Get list of sub tasks for a task
     *
     * @param taskId (required)
     * @return List&lt;TaskResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/subtasks")
    Call<List<TaskResponse>> getSubTasksCall(@Path(TASK_ID) String taskId);

    /**
     * Get a task
     *
     * @param taskId The id of the task to get. (required)
     * @return TaskResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}")
    Call<TaskResponse> getTaskCall(@Path(TASK_ID) String taskId);

    /**
     * Get a comment on a task
     *
     * @param taskId The id of the task to get the comment for. (required)
     * @param commentId The id of the comment. (required)
     * @return CommentResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/comments/{commentId}")
    Call<CommentResponse> getTaskCommentCall(@Path(TASK_ID) String taskId, @Path(COMMENT_ID) String commentId);

    /**
     * Get a single identity link on a task
     *
     * @param taskId The id of the task . (required)
     * @param family Either groups or users, depending on what kind of identity
     *            is targeted. (required)
     * @param identityId The id of the identity. (required)
     * @param type The type of identity link. (required)
     * @return RestIdentityLink
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}")
    Call<RestIdentityLink> getTaskInstanceIdentityLinksCall(@Path(TASK_ID) String taskId, @Path(FAMILY) String family,
            @Path(IDENTITY_ID) String identityId, @Path(TYPE) String type);

    /**
     * Get a variable from a task
     *
     * @param taskId The id of the task to get a variable for. (required)
     * @param variableName The name of the variable to get. (required)
     * @param scope Scope of variable to be returned. When local, only
     *            task-local variable value is returned. When global, only
     *            variable value from the task?s parent execution-hierarchy are
     *            returned. When the parameter is omitted, a local variable will
     *            be returned if it exists, otherwise a global variable.
     *            (optional)
     * @return RestVariable
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/variables/{variableName}")
    Call<RestVariable> getTaskInstanceVariableCall(@Path(TASK_ID) String taskId,
            @Path(VARIABLE_NAME) String variableName, @Query(SCOPE) String scope);

    /**
     * List of tasks
     *
     * @param name Only return models with the given version. (optional)
     * @param nameLike Only return tasks with a name like the given name.
     *            (optional)
     * @param description Only return tasks with the given description.
     *            (optional)
     * @param priority Only return tasks with the given priority. (optional)
     * @param minimumPriority Only return tasks with a priority greater than the
     *            given value. (optional)
     * @param maximumPriority Only return tasks with a priority lower than the
     *            given value. (optional)
     * @param assignee Only return tasks assigned to the given user. (optional)
     * @param assigneeLike Only return tasks assigned with an assignee like the
     *            given value. (optional)
     * @param owner Only return tasks owned by the given user. (optional)
     * @param ownerLike Only return tasks assigned with an owner like the given
     *            value. (optional)
     * @param unassigned Only return tasks that are not assigned to anyone. If
     *            false is passed, the value is ignored. (optional)
     * @param delegationState Only return tasks that have the given delegation
     *            state. Possible values are pending and resolved. (optional)
     * @param candidateUser Only return tasks that can be claimed by the given
     *            user. This includes both tasks where the user is an explicit
     *            candidate for and task that are claimable by a group that the
     *            user is a member of. (optional)
     * @param candidateGroup Only return tasks that can be claimed by a user in
     *            the given group. (optional)
     * @param candidateGroups Only return tasks that can be claimed by a user in
     *            the given groups. Values split by comma. (optional)
     * @param involvedUser Only return tasks in which the given user is
     *            involved. (optional)
     * @param taskDefinitionKey Only return tasks with the given task definition
     *            id. (optional)
     * @param taskDefinitionKeyLike Only return tasks with a given task
     *            definition id like the given value. (optional)
     * @param processInstanceId Only return tasks which are part of the process
     *            instance with the given id. (optional)
     * @param processInstanceBusinessKey Only return tasks which are part of the
     *            process instance with the given business key. (optional)
     * @param processInstanceBusinessKeyLike Only return tasks which are part of
     *            the process instance which has a business key like the given
     *            value. (optional)
     * @param processDefinitionId Only return tasks which are part of a process
     *            instance which has a process definition with the given id.
     *            (optional)
     * @param processDefinitionKey Only return tasks which are part of a process
     *            instance which has a process definition with the given key.
     *            (optional)
     * @param processDefinitionKeyLike Only return tasks which are part of a
     *            process instance which has a process definition with a key
     *            like the given value. (optional)
     * @param processDefinitionName Only return tasks which are part of a
     *            process instance which has a process definition with the given
     *            name. (optional)
     * @param processDefinitionNameLike Only return tasks which are part of a
     *            process instance which has a process definition with a name
     *            like the given value. (optional)
     * @param executionId Only return tasks which are part of the execution with
     *            the given id. (optional)
     * @param createdOn Only return tasks which are created on the given date.
     *            (optional)
     * @param createdBefore Only return tasks which are created before the given
     *            date. (optional)
     * @param createdAfter Only return tasks which are created after the given
     *            date. (optional)
     * @param dueOn Only return tasks which are due on the given date.
     *            (optional)
     * @param dueBefore Only return tasks which are due before the given date.
     *            (optional)
     * @param dueAfter Only return tasks which are due after the given date.
     *            (optional)
     * @param withoutDueDate Only return tasks which don?t have a due date. The
     *            property is ignored if the value is false. (optional)
     * @param excludeSubTasks Only return tasks that are not a subtask of
     *            another task. (optional)
     * @param active If true, only return tasks that are not suspended (either
     *            part of a process that is not suspended or not part of a
     *            process at all). If false, only tasks that are part of
     *            suspended process instances are returned. (optional)
     * @param includeTaskLocalVariables Indication to include task local
     *            variables in the result. (optional)
     * @param includeProcessVariables Indication to include process variables in
     *            the result. (optional)
     * @param tenantId Only return tasks with the given tenantId. (optional)
     * @param tenantIdLike Only return tasks with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns tasks without a tenantId
     *            set. If false, the withoutTenantId parameter is ignored.
     *            (optional)
     * @param candidateOrAssigned Select tasks that has been claimed or assigned
     *            to user or waiting to claim by user (candidate user or
     *            groups). (optional)
     * @param category Select tasks with the given category. Note that this is
     *            the task category, not the category of the process definition
     *            (namespace within the BPMN Xml). (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks")
    Call<ResultList<TaskResponse>> getTasksCall(@Query(NAME) String name, @Query(NAME_LIKE) String nameLike,
            @Query(DESCRIPTION) String description, @Query(PRIORITY) String priority,
            @Query(MINIMUM_PRIORITY) String minimumPriority, @Query(MAXIMUM_PRIORITY) String maximumPriority,
            @Query(ASSIGNEE) String assignee, @Query(ASSIGNEE_LIKE) String assigneeLike, @Query(OWNER) String owner,
            @Query(OWNER_LIKE) String ownerLike, @Query(UNASSIGNED) String unassigned,
            @Query(DELEGATION_STATE) String delegationState, @Query(CANDIDATE_USER) String candidateUser,
            @Query(CANDIDATE_GROUP) String candidateGroup, @Query(CANDIDATE_GROUPS) String candidateGroups,
            @Query(INVOLVED_USER) String involvedUser, @Query(TASK_DEFINITION_KEY) String taskDefinitionKey,
            @Query(TASK_DEFINITION_KEY_LIKE) String taskDefinitionKeyLike,
            @Query(PROCESS_INSTANCE_ID) String processInstanceId,
            @Query(PROCESS_INSTANCE_BUSINESS_KEY) String processInstanceBusinessKey,
            @Query(PROCESS_INSTANCE_BUSINESS_KEY_LIKE) String processInstanceBusinessKeyLike,
            @Query(PROCESS_DEFINITION_ID) String processDefinitionId,
            @Query(PROCESS_DEFINITION_KEY) String processDefinitionKey,
            @Query(PROCESS_DEFINITION_KEY_LIKE) String processDefinitionKeyLike,
            @Query(PROCESS_DEFINITION_NAME) String processDefinitionName,
            @Query(PROCESS_DEFINITION_NAME_LIKE) String processDefinitionNameLike,
            @Query(EXECUTION_ID) String executionId, @Query(CREATED_ON) String createdOn,
            @Query(CREATED_BEFORE) String createdBefore, @Query(CREATED_AFTER) String createdAfter,
            @Query(DUE_ON) String dueOn, @Query(DUE_BEFORE) String dueBefore, @Query(DUE_AFTER) String dueAfter,
            @Query(WITHOUT_DUE_DATE) String withoutDueDate, @Query(EXCLUDE_SUB_TASKS) String excludeSubTasks,
            @Query(ACTIVE) String active, @Query(INCLUDE_TASK_LOCAL_VARIABLES) String includeTaskLocalVariables,
            @Query(INCLUDE_PROCESS_VARIABLES) String includeProcessVariables, @Query(TENANT_ID) String tenantId,
            @Query(TENANT_ID_LIKE) String tenantIdLike, @Query(WITHOUT_TENANT_ID) String withoutTenantId,
            @Query(CANDIDATE_OR_ASSIGNED) String candidateOrAssigned, @Query(CATEGORY) String category);

    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks")
    Call<ResultList<TaskResponse>> getTasksCall();

    /**
     * Get all comments on a task
     *
     * @param taskId The id of the task to get the comments for. (required)
     * @return List&lt;CommentResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/comments")
    Call<List<CommentResponse>> listTaskCommentsCall(@Path(TASK_ID) String taskId);

    /**
     * Get all variables for a task
     *
     * @param taskId The id of the task to get variables for. (required)
     * @return List&lt;RestVariable&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/variables")
    Call<List<RestVariable>> listTaskVariablesCall(@Path(TASK_ID) String taskId);

    /**
     * Get all identity links for a task
     *
     * @param taskId The id of the task to get the identity links for.
     *            (required)
     * @return List&lt;RestIdentityLink&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/identitylinks")
    Call<List<RestIdentityLink>> listTasksInstanceIdentityLinksCall(@Path(TASK_ID) String taskId);

    /**
     * Update a task All request values are optional. For example, you can only
     * include the assignee attribute in the request body JSON-object, only
     * updating the assignee of the task, leaving all other fields unaffected.
     * When an attribute is explicitly included and is set to null, the
     * task-value will be updated to null. Example: {\&quot;dueDate\&quot; :
     * null} will clear the duedate of the task).
     *
     * @param taskId (required)
     * @param body (optional)
     * @return TaskResponse
     */
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}")
    Call<TaskResponse> updateTaskCall(@Path(TASK_ID) String taskId, @Body TaskRequest body);

    /**
     * Update an existing variable on a task ## Request body for updating simple
     * (non-binary) variables &#x60;&#x60;&#x60;JSON { \&quot;name\&quot; :
     * \&quot;myTaskVariable\&quot;, \&quot;scope\&quot; : \&quot;local\&quot;,
     * \&quot;type\&quot; : \&quot;string\&quot;, \&quot;value\&quot; :
     * \&quot;Hello my friend\&quot; } &#x60;&#x60;&#x60; - *name*: Required
     * name of the variable - *scope*: Scope of variable that is updated. If
     * omitted, local is assumed. - *type*: Type of variable that is updated. If
     * omitted, reverts to raw JSON-value type (string, boolean, integer or
     * double). - *value*: Variable value. ## Request body for updating simple
     * (non-binary) variables The request should be of type multipart/form-data.
     * There should be a single file-part included with the binary value of the
     * variable. On top of that, the following additional form-fields can be
     * present: - *name*: Required name of the variable. - *scope*: Scope of
     * variable that is updated. If omitted, local is assumed. - *type*: Type of
     * variable that is updated. If omitted, binary is assumed and the binary
     * data in the request will be stored as an array of bytes.
     *
     * @param taskId The id of the task to update the variable for. (required)
     * @param variableName The name of the variable to update. (required)
     * @return RestVariable
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/identitylinks")
    Call<RestVariable> updateTaskInstanceVariableCall(@Path(TASK_ID) String taskId,
            @Path(VARIABLE_NAME) String variableName);

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
     * Create a new attachment on a task, containing a link to an external
     * resource or an attached file ## Create a new attachment on a task,
     * containing a link to an external resource &#x60;&#x60;&#x60;JSON {
     * \&quot;name\&quot;:\&quot;Simple attachment\&quot;,
     * \&quot;description\&quot;:\&quot;Simple attachment description\&quot;,
     * \&quot;type\&quot;:\&quot;simpleType\&quot;,
     * \&quot;externalUrl\&quot;:\&quot;http://activiti.org\&quot; }
     * &#x60;&#x60;&#x60; Only the attachment name is required to create a new
     * attachment. ## Create a new attachment on a task, with an attached file
     * The request should be of type multipart/form-data. There should be a
     * single file-part included with the binary value of the variable. On top
     * of that, the following additional form-fields can be present: - *name*:
     * Required name of the variable. - *description*: Description of the
     * attachment, optional. - *type*: Type of attachment, optional. Supports
     * any arbitrary string or a valid HTTP content-type.
     *
     * @param taskId The id of the task to create the attachment for. (required)
     * @return AttachmentResponse
     */
    @Multipart
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/attachments")
    Observable<AttachmentResponse> createAttachmentObservable(@Path(TASK_ID) String taskId,
            @Part("filedata") RequestBody file);

    @Multipart
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/attachments")
    Observable<AttachmentResponse> createAttachmentObservable(@Path(TASK_ID) String taskId,
            @PartMap() Map<String, RequestBody> partMap);

    /**
     * Create Task
     *
     * @param body (optional)
     * @return TaskResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks")
    Observable<TaskResponse> createTaskObservable(@Body TaskRequest body);

    /**
     * Create a new comment on a task
     *
     * @param taskId The id of the task to create the comment for. (required)
     * @param body (optional)
     * @return CommentResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/comments")
    Observable<CommentResponse> createTaskCommentsObservable(@Path(TASK_ID) String taskId, @Body CommentRequest body);

    /**
     * Create an identity link on a task ## Request body (user)
     * &#x60;&#x60;&#x60;JSON { \&quot;userId\&quot; : \&quot;kermit\&quot;,
     * \&quot;type\&quot; : \&quot;candidate\&quot;, } &#x60;&#x60;&#x60; ##
     * Request body (group) &#x60;&#x60;&#x60;JSON { \&quot;groupId\&quot; :
     * \&quot;sales\&quot;, \&quot;type\&quot; : \&quot;candidate\&quot;, }
     * &#x60;&#x60;&#x60;
     *
     * @param taskId The id of the task . (required)
     * @param body (optional)
     * @return RestIdentityLink
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/identitylinks")
    Observable<RestIdentityLink> createTaskInstanceIdentityLinksObservable(@Path(TASK_ID) String taskId,
            @Body RestIdentityLink body);

    /**
     * Create new variables on a task ## Request body for creating simple
     * (non-binary) variables &#x60;&#x60;&#x60;JSON [ { \&quot;name\&quot; :
     * \&quot;myTaskVariable\&quot;, \&quot;scope\&quot; : \&quot;local\&quot;,
     * \&quot;type\&quot; : \&quot;string\&quot;, \&quot;value\&quot; :
     * \&quot;Hello my friend\&quot; }, { } ] &#x60;&#x60;&#x60; The request
     * body should be an array containing one or more JSON-objects representing
     * the variables that should be created. - *name*: Required name of the
     * variable scope: Scope of variable that is created. If omitted, local is
     * assumed. - *type*: Type of variable that is created. If omitted, reverts
     * to raw JSON-value type (string, boolean, integer or double). - *value*:
     * Variable value. More information about the variable format can be found
     * in the REST variables section. ## Request body for Creating a new binary
     * variable The request should be of type multipart/form-data. There should
     * be a single file-part included with the binary value of the variable. On
     * top of that, the following additional form-fields can be present: -
     * *name*: Required name of the variable. scope: Scope of variable that is
     * created. If omitted, local is assumed. - *type*: Type of variable that is
     * created. If omitted, binary is assumed and the binary data in the request
     * will be stored as an array of bytes.
     *
     * @param taskId The id of the task to create the new variable for.
     *            (required)
     * @return Object
     */
    // FIXME multiple signature
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/variables")
    Observable<List<RestVariable>> createTaskVariableObservable(@Path(TASK_ID) String taskId,
            @Body List<RestVariable> body);

    /**
     * Delete all local variables on a task
     *
     * @param taskId The id of the task the variable to delete belongs to.
     *            (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/variables")
    Observable<Void> deleteAllLocalTaskVariablesObservable(@Path(TASK_ID) String taskId);

    /**
     * Delete an attachment on a task
     *
     * @param taskId The id of the task to delete the attachment for. (required)
     * @param attachmentId The id of the attachment. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/attachment/{attachmentId}")
    Observable<Void> deleteAttachmentObservable(@Path(TASK_ID) String taskId, @Path(ATTACHMENT_ID) String attachmentId);

    /**
     * Delete an event on a task
     *
     * @param taskId (required)
     * @param eventId (required)
     * @return ApiResponse&lt;Void&gt;
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/events/{eventId}")
    Observable<Void> deleteEventObservable(@Path(TASK_ID) String taskId, @Path(EVENT_ID) String eventId);

    /**
     * Delete a task
     *
     * @param taskId The id of the task to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}")
    Observable<Void> deleteTaskObservable(@Path(TASK_ID) String taskId);

    /**
     * Delete a comment on a task
     *
     * @param taskId The id of the task to delete the comment for. (required)
     * @param commentId The id of the comment. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/comments/{commentId}")
    Observable<Void> deleteTaskCommentObservable(@Path(TASK_ID) String taskId, @Path(COMMENT_ID) String commentId);

    /**
     * Delete an identity link on a task
     *
     * @param taskId The id of the task. (required)
     * @param family Either groups or users, depending on what kind of identity
     *            is targeted. (required)
     * @param identityId The id of the identity. (required)
     * @param type The type of identity link. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}")
    Observable<Void> deleteTaskInstanceIdentityLinksObservable(@Path(TASK_ID) String taskId,
            @Path(FAMILY) String family, @Path(IDENTITY_ID) String identityId, @Path(TYPE) String type);

    /**
     * Delete a variable on a task
     *
     * @param taskId The id of the task the variable to delete belongs to.
     *            (required)
     * @param variableName The name of the variable to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/variables/{variableName}")
    Observable<Void> deleteTaskInstanceVariableObservable(@Path(TASK_ID) String taskId,
            @Path(VARIABLE_NAME) String variableName);

    /**
     * Tasks actions ## Complete a task - Request Body &#x60;&#x60;&#x60;JSON {
     * \&quot;action\&quot; : \&quot;complete\&quot;, \&quot;variables\&quot; :
     * [] } &#x60;&#x60;&#x60;Completes the task. Optional variable array can be
     * passed in using the variables property. More information about the
     * variable format can be found in the REST variables section. Note that the
     * variable-scope that is supplied is ignored and the variables are set on
     * the parent-scope unless a variable exists in a local scope, which is
     * overridden in this case. This is the same behavior as the
     * TaskService.completeTask(taskId, variables) invocation. Note that also a
     * transientVariables property is accepted as part of this json, that
     * follows the same structure as the variables property. ## Claim a task -
     * Request Body &#x60;&#x60;&#x60;JSON { \&quot;action\&quot; :
     * \&quot;claim\&quot;, \&quot;assignee\&quot; : \&quot;userWhoClaims\&quot;
     * } &#x60;&#x60;&#x60; Claims the task by the given assignee. If the
     * assignee is null, the task is assigned to no-one, claimable again. ##
     * Delegate a task - Request Body &#x60;&#x60;&#x60;JSON {
     * \&quot;action\&quot; : \&quot;delegate\&quot;, \&quot;assignee\&quot; :
     * \&quot;userToDelegateTo\&quot; } &#x60;&#x60;&#x60; Delegates the task to
     * the given assignee. The assignee is required. ## Suspend a process
     * instance &#x60;&#x60;&#x60;JSON { \&quot;action\&quot; :
     * \&quot;resolve\&quot; } &#x60;&#x60;&#x60; Resolves the task delegation.
     * The task is assigned back to the task owner (if any).
     *
     * @param taskId (required)
     * @param body (optional)
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}")
    Observable<Void> executeTaskActionObservable(@Path(TASK_ID) String taskId, @Body TaskActionRequest body);

    /**
     * Get the binary data for a variable The response body contains the binary
     * value of the variable. When the variable is of type binary, the
     * content-type of the response is set to application/octet-stream,
     * regardless of the content of the variable or the request accept-type
     * header. In case of serializable, application/x-java-serialized-object is
     * used as content-type.
     *
     * @param taskId The id of the task to get a variable data for. (required)
     * @param variableName The name of the variable to get data for. Only
     *            variables of type binary and serializable can be used. If any
     *            other type of variable is used, a 404 is returned. (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/variables/{variableName}/data")
    Observable<RequestBody> geTaskVariableDataObservable(@Path(TASK_ID) String taskId,
            @Path(VARIABLE_NAME) String variableName);

    /**
     * Get an attachment on a task
     *
     * @param taskId The id of the task to get the attachment for. (required)
     * @param attachmentId The id of the attachment. (required)
     * @return AttachmentResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/attachments/{attachmentId}")
    Observable<AttachmentResponse> getAttachmentObservable(@Path(TASK_ID) String taskId,
            @Path(ATTACHMENT_ID) String attachmentId);

    /**
     * Get the content for an attachment The response body contains the binary
     * content. By default, the content-type of the response is set to
     * application/octet-stream unless the attachment type contains a valid
     * Content-type.
     *
     * @param taskId The id of the task to get a variable data for. (required)
     * @param attachmentId The id of the attachment, a 404 is returned when the
     *            attachment points to an external URL rather than content
     *            attached in Activiti. (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/attachments/{attachmentId}/content")
    Observable<RequestBody> getAttachmentContentObservable(@Path(TASK_ID) String taskId,
            @Path(ATTACHMENT_ID) String attachmentId);

    /**
     * Get all attachments on a task
     *
     * @param taskId The id of the task to get the attachments for. (required)
     * @return List&lt;AttachmentResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/attachments")
    Observable<List<AttachmentResponse>> getAttachmentsObservable(@Path(TASK_ID) String taskId);

    /**
     * Get an event on a task
     *
     * @param taskId The id of the task to get the event for. (required)
     * @param eventId The id of the event. (required)
     * @return EventResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/events/{eventId}")
    Observable<EventResponse> getEventObservable(@Path(TASK_ID) String taskId, @Path(EVENT_ID) String eventId);

    /**
     * Get all events for a task
     *
     * @param taskId The id of the task to get the events for. (required)
     * @return List&lt;EventResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/events")
    Observable<List<EventResponse>> getEventsObservable(@Path(TASK_ID) String taskId);

    /**
     * Get all identitylinks for a task for either groups or users ## Get all
     * identitylinks for a task URL &#x60;&#x60;&#x60; GET
     * runtime/tasks/{taskId}/identitylinks/users GET
     * runtime/tasks/{taskId}/identitylinks/groups &#x60;&#x60;&#x60; Returns
     * only identity links targetting either users or groups. Response body and
     * status-codes are exactly the same as when getting the full list of
     * identity links for a task.
     *
     * @param taskId (required)
     * @param family (required)
     * @return List&lt;RestIdentityLink&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/identitylinks/{family}")
    Observable<List<RestIdentityLink>> getIdentityLinksForFamilyObservable(@Path(TASK_ID) String taskId,
            @Path(FAMILY) String family);

    /**
     * Query for tasks All supported JSON parameter fields allowed are exactly
     * the same as the parameters found for getting a collection of tasks
     * (except for candidateGroupIn which is only available in this POST task
     * query REST service), but passed in as JSON-body arguments rather than
     * URL-parameters to allow for more advanced querying and preventing errors
     * with request-uri?s that are too long. On top of that, the query allows
     * for filtering based on task and process variables. The taskVariables and
     * processInstanceVariables are both JSON-arrays containing objects with the
     * format as described here.
     *
     * @param body (optional)
     * @return DataResponse
     */
    @POST(ACTIVITI_SERVICE_PATH + "/query/tasks")
    Observable<ResultList<TaskResponse>> getQueryResultObservable(@Body TaskQueryRequest body);

    /**
     * Get list of sub tasks for a task
     *
     * @param taskId (required)
     * @return List&lt;TaskResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/subtasks")
    Observable<List<TaskResponse>> getSubTasksObservable(@Path(TASK_ID) String taskId);

    /**
     * Get a task
     *
     * @param taskId The id of the task to get. (required)
     * @return TaskResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}")
    Observable<TaskResponse> getTaskObservable(@Path(TASK_ID) String taskId);

    /**
     * Get a comment on a task
     *
     * @param taskId The id of the task to get the comment for. (required)
     * @param commentId The id of the comment. (required)
     * @return CommentResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/comments/{commentId}")
    Observable<CommentResponse> getTaskCommentObservable(@Path(TASK_ID) String taskId,
            @Path(COMMENT_ID) String commentId);

    /**
     * Get a single identity link on a task
     *
     * @param taskId The id of the task . (required)
     * @param family Either groups or users, depending on what kind of identity
     *            is targeted. (required)
     * @param identityId The id of the identity. (required)
     * @param type The type of identity link. (required)
     * @return RestIdentityLink
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}")
    Observable<RestIdentityLink> getTaskInstanceIdentityLinksObservable(@Path(TASK_ID) String taskId,
            @Path(FAMILY) String family, @Path(IDENTITY_ID) String identityId, @Path(TYPE) String type);

    /**
     * Get a variable from a task
     *
     * @param taskId The id of the task to get a variable for. (required)
     * @param variableName The name of the variable to get. (required)
     * @param scope Scope of variable to be returned. When local, only
     *            task-local variable value is returned. When global, only
     *            variable value from the task?s parent execution-hierarchy are
     *            returned. When the parameter is omitted, a local variable will
     *            be returned if it exists, otherwise a global variable.
     *            (optional)
     * @return RestVariable
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/variables/{variableName}")
    Observable<RestVariable> getTaskInstanceVariableObservable(@Path(TASK_ID) String taskId,
            @Path(VARIABLE_NAME) String variableName, @Query(SCOPE) String scope);

    /**
     * List of tasks
     *
     * @param name Only return models with the given version. (optional)
     * @param nameLike Only return tasks with a name like the given name.
     *            (optional)
     * @param description Only return tasks with the given description.
     *            (optional)
     * @param priority Only return tasks with the given priority. (optional)
     * @param minimumPriority Only return tasks with a priority greater than the
     *            given value. (optional)
     * @param maximumPriority Only return tasks with a priority lower than the
     *            given value. (optional)
     * @param assignee Only return tasks assigned to the given user. (optional)
     * @param assigneeLike Only return tasks assigned with an assignee like the
     *            given value. (optional)
     * @param owner Only return tasks owned by the given user. (optional)
     * @param ownerLike Only return tasks assigned with an owner like the given
     *            value. (optional)
     * @param unassigned Only return tasks that are not assigned to anyone. If
     *            false is passed, the value is ignored. (optional)
     * @param delegationState Only return tasks that have the given delegation
     *            state. Possible values are pending and resolved. (optional)
     * @param candidateUser Only return tasks that can be claimed by the given
     *            user. This includes both tasks where the user is an explicit
     *            candidate for and task that are claimable by a group that the
     *            user is a member of. (optional)
     * @param candidateGroup Only return tasks that can be claimed by a user in
     *            the given group. (optional)
     * @param candidateGroups Only return tasks that can be claimed by a user in
     *            the given groups. Values split by comma. (optional)
     * @param involvedUser Only return tasks in which the given user is
     *            involved. (optional)
     * @param taskDefinitionKey Only return tasks with the given task definition
     *            id. (optional)
     * @param taskDefinitionKeyLike Only return tasks with a given task
     *            definition id like the given value. (optional)
     * @param processInstanceId Only return tasks which are part of the process
     *            instance with the given id. (optional)
     * @param processInstanceBusinessKey Only return tasks which are part of the
     *            process instance with the given business key. (optional)
     * @param processInstanceBusinessKeyLike Only return tasks which are part of
     *            the process instance which has a business key like the given
     *            value. (optional)
     * @param processDefinitionId Only return tasks which are part of a process
     *            instance which has a process definition with the given id.
     *            (optional)
     * @param processDefinitionKey Only return tasks which are part of a process
     *            instance which has a process definition with the given key.
     *            (optional)
     * @param processDefinitionKeyLike Only return tasks which are part of a
     *            process instance which has a process definition with a key
     *            like the given value. (optional)
     * @param processDefinitionName Only return tasks which are part of a
     *            process instance which has a process definition with the given
     *            name. (optional)
     * @param processDefinitionNameLike Only return tasks which are part of a
     *            process instance which has a process definition with a name
     *            like the given value. (optional)
     * @param executionId Only return tasks which are part of the execution with
     *            the given id. (optional)
     * @param createdOn Only return tasks which are created on the given date.
     *            (optional)
     * @param createdBefore Only return tasks which are created before the given
     *            date. (optional)
     * @param createdAfter Only return tasks which are created after the given
     *            date. (optional)
     * @param dueOn Only return tasks which are due on the given date.
     *            (optional)
     * @param dueBefore Only return tasks which are due before the given date.
     *            (optional)
     * @param dueAfter Only return tasks which are due after the given date.
     *            (optional)
     * @param withoutDueDate Only return tasks which don?t have a due date. The
     *            property is ignored if the value is false. (optional)
     * @param excludeSubTasks Only return tasks that are not a subtask of
     *            another task. (optional)
     * @param active If true, only return tasks that are not suspended (either
     *            part of a process that is not suspended or not part of a
     *            process at all). If false, only tasks that are part of
     *            suspended process instances are returned. (optional)
     * @param includeTaskLocalVariables Indication to include task local
     *            variables in the result. (optional)
     * @param includeProcessVariables Indication to include process variables in
     *            the result. (optional)
     * @param tenantId Only return tasks with the given tenantId. (optional)
     * @param tenantIdLike Only return tasks with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns tasks without a tenantId
     *            set. If false, the withoutTenantId parameter is ignored.
     *            (optional)
     * @param candidateOrAssigned Select tasks that has been claimed or assigned
     *            to user or waiting to claim by user (candidate user or
     *            groups). (optional)
     * @param category Select tasks with the given category. Note that this is
     *            the task category, not the category of the process definition
     *            (namespace within the BPMN Xml). (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks")
    Observable<ResultList<TaskResponse>> getTasksObservable(@Query(NAME) String name, @Query(NAME_LIKE) String nameLike,
            @Query(DESCRIPTION) String description, @Query(PRIORITY) String priority,
            @Query(MINIMUM_PRIORITY) String minimumPriority, @Query(MAXIMUM_PRIORITY) String maximumPriority,
            @Query(ASSIGNEE) String assignee, @Query(ASSIGNEE_LIKE) String assigneeLike, @Query(OWNER) String owner,
            @Query(OWNER_LIKE) String ownerLike, @Query(UNASSIGNED) String unassigned,
            @Query(DELEGATION_STATE) String delegationState, @Query(CANDIDATE_USER) String candidateUser,
            @Query(CANDIDATE_GROUP) String candidateGroup, @Query(CANDIDATE_GROUPS) String candidateGroups,
            @Query(INVOLVED_USER) String involvedUser, @Query(TASK_DEFINITION_KEY) String taskDefinitionKey,
            @Query(TASK_DEFINITION_KEY_LIKE) String taskDefinitionKeyLike,
            @Query(PROCESS_INSTANCE_ID) String processInstanceId,
            @Query(PROCESS_INSTANCE_BUSINESS_KEY) String processInstanceBusinessKey,
            @Query(PROCESS_INSTANCE_BUSINESS_KEY_LIKE) String processInstanceBusinessKeyLike,
            @Query(PROCESS_DEFINITION_ID) String processDefinitionId,
            @Query(PROCESS_DEFINITION_KEY) String processDefinitionKey,
            @Query(PROCESS_DEFINITION_KEY_LIKE) String processDefinitionKeyLike,
            @Query(PROCESS_DEFINITION_NAME) String processDefinitionName,
            @Query(PROCESS_DEFINITION_NAME_LIKE) String processDefinitionNameLike,
            @Query(EXECUTION_ID) String executionId, @Query(CREATED_ON) String createdOn,
            @Query(CREATED_BEFORE) String createdBefore, @Query(CREATED_AFTER) String createdAfter,
            @Query(DUE_ON) String dueOn, @Query(DUE_BEFORE) String dueBefore, @Query(DUE_AFTER) String dueAfter,
            @Query(WITHOUT_DUE_DATE) String withoutDueDate, @Query(EXCLUDE_SUB_TASKS) String excludeSubTasks,
            @Query(ACTIVE) String active, @Query(INCLUDE_TASK_LOCAL_VARIABLES) String includeTaskLocalVariables,
            @Query(INCLUDE_PROCESS_VARIABLES) String includeProcessVariables, @Query(TENANT_ID) String tenantId,
            @Query(TENANT_ID_LIKE) String tenantIdLike, @Query(WITHOUT_TENANT_ID) String withoutTenantId,
            @Query(CANDIDATE_OR_ASSIGNED) String candidateOrAssigned, @Query(CATEGORY) String category);

    /**
     * Get all comments on a task
     *
     * @param taskId The id of the task to get the comments for. (required)
     * @return List&lt;CommentResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/comments")
    Observable<List<CommentResponse>> listTaskCommentsObservable(@Path(TASK_ID) String taskId);

    /**
     * Get all variables for a task
     *
     * @param taskId The id of the task to get variables for. (required)
     * @return List&lt;RestVariable&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/variables")
    Observable<List<RestVariable>> listTaskVariablesObservable(@Path(TASK_ID) String taskId);

    /**
     * Get all identity links for a task
     *
     * @param taskId The id of the task to get the identity links for.
     *            (required)
     * @return List&lt;RestIdentityLink&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/identitylinks")
    Observable<List<RestIdentityLink>> listTasksInstanceIdentityLinksObservable(@Path(TASK_ID) String taskId);

    /**
     * Update a task All request values are optional. For example, you can only
     * include the assignee attribute in the request body JSON-object, only
     * updating the assignee of the task, leaving all other fields unaffected.
     * When an attribute is explicitly included and is set to null, the
     * task-value will be updated to null. Example: {\&quot;dueDate\&quot; :
     * null} will clear the duedate of the task).
     *
     * @param taskId (required)
     * @param body (optional)
     * @return TaskResponse
     */
    @PUT(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}")
    Observable<TaskResponse> updateTaskObservable(@Path(TASK_ID) String taskId, @Body TaskRequest body);

    /**
     * Update an existing variable on a task ## Request body for updating simple
     * (non-binary) variables &#x60;&#x60;&#x60;JSON { \&quot;name\&quot; :
     * \&quot;myTaskVariable\&quot;, \&quot;scope\&quot; : \&quot;local\&quot;,
     * \&quot;type\&quot; : \&quot;string\&quot;, \&quot;value\&quot; :
     * \&quot;Hello my friend\&quot; } &#x60;&#x60;&#x60; - *name*: Required
     * name of the variable - *scope*: Scope of variable that is updated. If
     * omitted, local is assumed. - *type*: Type of variable that is updated. If
     * omitted, reverts to raw JSON-value type (string, boolean, integer or
     * double). - *value*: Variable value. ## Request body for updating simple
     * (non-binary) variables The request should be of type multipart/form-data.
     * There should be a single file-part included with the binary value of the
     * variable. On top of that, the following additional form-fields can be
     * present: - *name*: Required name of the variable. - *scope*: Scope of
     * variable that is updated. If omitted, local is assumed. - *type*: Type of
     * variable that is updated. If omitted, binary is assumed and the binary
     * data in the request will be stored as an array of bytes.
     *
     * @param taskId The id of the task to update the variable for. (required)
     * @param variableName The name of the variable to update. (required)
     * @return RestVariable
     */
    @GET(ACTIVITI_SERVICE_PATH + "/runtime/tasks/{taskId}/identitylinks")
    Observable<RestVariable> updateTaskInstanceVariableObservable(@Path(TASK_ID) String taskId,
            @Path(VARIABLE_NAME) String variableName);

}
