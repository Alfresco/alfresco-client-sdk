package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.Date;
import java.util.List;

import org.alfresco.client.services.process.activiti.core.model.representation.QueryVariable;

import com.google.gson.annotations.SerializedName;

/**
 * HistoricTaskInstanceQueryRequest
 */
public class HistoricTaskInstanceQueryRequest extends PaginateRequest
{
    @SerializedName("taskId")
    public final String taskId;

    @SerializedName("processInstanceId")
    public final String processInstanceId;

    @SerializedName("processBusinessKey")
    public final String processBusinessKey;

    @SerializedName("processBusinessKeyLike")
    public final String processBusinessKeyLike;

    @SerializedName("processDefinitionId")
    public final String processDefinitionId;

    @SerializedName("processDefinitionKey")
    public final String processDefinitionKey;

    @SerializedName("processDefinitionKeyLike")
    public final String processDefinitionKeyLike;

    @SerializedName("processDefinitionName")
    public final String processDefinitionName;

    @SerializedName("processDefinitionNameLike")
    public final String processDefinitionNameLike;

    @SerializedName("executionId")
    public final String executionId;

    @SerializedName("taskName")
    public final String taskName;

    @SerializedName("taskNameLike")
    public final String taskNameLike;

    @SerializedName("taskDescription")
    public final String taskDescription;

    @SerializedName("taskDescriptionLike")
    public final String taskDescriptionLike;

    @SerializedName("taskDefinitionKey")
    public final String taskDefinitionKey;

    @SerializedName("taskDefinitionKeyLike")
    public final String taskDefinitionKeyLike;

    @SerializedName("taskCategory")
    public final String taskCategory;

    @SerializedName("taskDeleteReason")
    public final String taskDeleteReason;

    @SerializedName("taskDeleteReasonLike")
    public final String taskDeleteReasonLike;

    @SerializedName("taskAssignee")
    public final String taskAssignee;

    @SerializedName("taskAssigneeLike")
    public final String taskAssigneeLike;

    @SerializedName("taskOwner")
    public final String taskOwner;

    @SerializedName("taskOwnerLike")
    public final String taskOwnerLike;

    @SerializedName("taskInvolvedUser")
    public final String taskInvolvedUser;

    @SerializedName("taskPriority")
    public final Integer taskPriority;

    @SerializedName("taskMinPriority")
    public final Integer taskMinPriority;

    @SerializedName("taskMaxPriority")
    public final Integer taskMaxPriority;

    @SerializedName("finished")
    public final Boolean finished;

    @SerializedName("processFinished")
    public final Boolean processFinished;

    @SerializedName("parentTaskId")
    public final String parentTaskId;

    @SerializedName("dueDate")
    public final Date dueDate;

    @SerializedName("dueDateAfter")
    public final Date dueDateAfter;

    @SerializedName("dueDateBefore")
    public final Date dueDateBefore;

    @SerializedName("withoutDueDate")
    public final Boolean withoutDueDate;

    @SerializedName("taskCreatedOn")
    public final Date taskCreatedOn;

    @SerializedName("taskCreatedBefore")
    public final Date taskCreatedBefore;

    @SerializedName("taskCreatedAfter")
    public final Date taskCreatedAfter;

    @SerializedName("taskCompletedOn")
    public final Date taskCompletedOn;

    @SerializedName("taskCompletedBefore")
    public final Date taskCompletedBefore;

    @SerializedName("taskCompletedAfter")
    public final Date taskCompletedAfter;

    @SerializedName("includeTaskLocalVariables")
    public final Boolean includeTaskLocalVariables;

    @SerializedName("includeProcessVariables")
    public final Boolean includeProcessVariables;

    @SerializedName("taskVariables")
    public final List<QueryVariable> taskVariables;

    @SerializedName("processVariables")
    public final List<QueryVariable> processVariables;

    @SerializedName("tenantId")
    public final String tenantId;

    @SerializedName("tenantIdLike")
    public final String tenantIdLike;

    @SerializedName("withoutTenantId")
    public final Boolean withoutTenantId;

    @SerializedName("taskCandidateGroup")
    public final String taskCandidateGroup;

    public HistoricTaskInstanceQueryRequest(Integer start, Integer size, String sort, String order, String taskId,
            String processInstanceId, String processBusinessKey, String processBusinessKeyLike,
            String processDefinitionId, String processDefinitionKey, String processDefinitionKeyLike,
            String processDefinitionName, String processDefinitionNameLike, String executionId, String taskName,
            String taskNameLike, String taskDescription, String taskDescriptionLike, String taskDefinitionKey,
            String taskDefinitionKeyLike, String taskCategory, String taskDeleteReason, String taskDeleteReasonLike,
            String taskAssignee, String taskAssigneeLike, String taskOwner, String taskOwnerLike,
            String taskInvolvedUser, Integer taskPriority, Integer taskMinPriority, Integer taskMaxPriority,
            Boolean finished, Boolean processFinished, String parentTaskId, Date dueDate, Date dueDateAfter,
            Date dueDateBefore, Boolean withoutDueDate, Date taskCreatedOn, Date taskCreatedBefore,
            Date taskCreatedAfter, Date taskCompletedOn, Date taskCompletedBefore, Date taskCompletedAfter,
            Boolean includeTaskLocalVariables, Boolean includeProcessVariables, List<QueryVariable> taskVariables,
            List<QueryVariable> processVariables, String tenantId, String tenantIdLike, Boolean withoutTenantId,
            String taskCandidateGroup)
    {
        super(start, size, sort, order);
        this.taskId = taskId;
        this.processInstanceId = processInstanceId;
        this.processBusinessKey = processBusinessKey;
        this.processBusinessKeyLike = processBusinessKeyLike;
        this.processDefinitionId = processDefinitionId;
        this.processDefinitionKey = processDefinitionKey;
        this.processDefinitionKeyLike = processDefinitionKeyLike;
        this.processDefinitionName = processDefinitionName;
        this.processDefinitionNameLike = processDefinitionNameLike;
        this.executionId = executionId;
        this.taskName = taskName;
        this.taskNameLike = taskNameLike;
        this.taskDescription = taskDescription;
        this.taskDescriptionLike = taskDescriptionLike;
        this.taskDefinitionKey = taskDefinitionKey;
        this.taskDefinitionKeyLike = taskDefinitionKeyLike;
        this.taskCategory = taskCategory;
        this.taskDeleteReason = taskDeleteReason;
        this.taskDeleteReasonLike = taskDeleteReasonLike;
        this.taskAssignee = taskAssignee;
        this.taskAssigneeLike = taskAssigneeLike;
        this.taskOwner = taskOwner;
        this.taskOwnerLike = taskOwnerLike;
        this.taskInvolvedUser = taskInvolvedUser;
        this.taskPriority = taskPriority;
        this.taskMinPriority = taskMinPriority;
        this.taskMaxPriority = taskMaxPriority;
        this.finished = finished;
        this.processFinished = processFinished;
        this.parentTaskId = parentTaskId;
        this.dueDate = dueDate;
        this.dueDateAfter = dueDateAfter;
        this.dueDateBefore = dueDateBefore;
        this.withoutDueDate = withoutDueDate;
        this.taskCreatedOn = taskCreatedOn;
        this.taskCreatedBefore = taskCreatedBefore;
        this.taskCreatedAfter = taskCreatedAfter;
        this.taskCompletedOn = taskCompletedOn;
        this.taskCompletedBefore = taskCompletedBefore;
        this.taskCompletedAfter = taskCompletedAfter;
        this.includeTaskLocalVariables = includeTaskLocalVariables;
        this.includeProcessVariables = includeProcessVariables;
        this.taskVariables = taskVariables;
        this.processVariables = processVariables;
        this.tenantId = tenantId;
        this.tenantIdLike = tenantIdLike;
        this.withoutTenantId = withoutTenantId;
        this.taskCandidateGroup = taskCandidateGroup;
    }
}
