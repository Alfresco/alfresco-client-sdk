package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.Date;
import java.util.List;

import org.alfresco.client.services.process.activiti.core.model.representation.QueryVariable;

import com.google.gson.annotations.SerializedName;

/**
 * TaskQueryRequest
 */
public class TaskQueryRequest
{
    @SerializedName("start")
    public final Integer start;

    @SerializedName("size")
    public final Integer size;

    @SerializedName("sort")
    public final String sort;

    @SerializedName("order")
    public final String order;

    @SerializedName("name")
    public final String name;

    @SerializedName("nameLike")
    public final String nameLike;

    @SerializedName("description")
    public final String description;

    @SerializedName("descriptionLike")
    public final String descriptionLike;

    @SerializedName("priority")
    public final Integer priority;

    @SerializedName("minimumPriority")
    public final Integer minimumPriority;

    @SerializedName("maximumPriority")
    public final Integer maximumPriority;

    @SerializedName("assignee")
    public final String assignee;

    @SerializedName("assigneeLike")
    public final String assigneeLike;

    @SerializedName("owner")
    public final String owner;

    @SerializedName("ownerLike")
    public final String ownerLike;

    @SerializedName("unassigned")
    public final Boolean unassigned;

    @SerializedName("delegationState")
    public final String delegationState;

    @SerializedName("candidateUser")
    public final String candidateUser;

    @SerializedName("candidateGroup")
    public final String candidateGroup;

    @SerializedName("candidateGroupIn")
    public final List<String> candidateGroupIn;

    @SerializedName("involvedUser")
    public final String involvedUser;

    @SerializedName("processInstanceId")
    public final String processInstanceId;

    @SerializedName("processInstanceBusinessKey")
    public final String processInstanceBusinessKey;

    @SerializedName("processInstanceBusinessKeyLike")
    public final String processInstanceBusinessKeyLike;

    @SerializedName("processInstanceIdIn")
    public final List<String> processInstanceIdIn;

    @SerializedName("processDefinitionId")
    public final String processDefinitionId;

    @SerializedName("processDefinitionKey")
    public final String processDefinitionKey;

    @SerializedName("processDefinitionName")
    public final String processDefinitionName;

    @SerializedName("processDefinitionKeyLike")
    public final String processDefinitionKeyLike;

    @SerializedName("processDefinitionNameLike")
    public final String processDefinitionNameLike;

    @SerializedName("executionId")
    public final String executionId;

    @SerializedName("createdOn")
    public final Date createdOn;

    @SerializedName("createdBefore")
    public final Date createdBefore;

    @SerializedName("createdAfter")
    public final Date createdAfter;

    @SerializedName("excludeSubTasks")
    public final Boolean excludeSubTasks;

    @SerializedName("taskDefinitionKey")
    public final String taskDefinitionKey;

    @SerializedName("taskDefinitionKeyLike")
    public final String taskDefinitionKeyLike;

    @SerializedName("dueDate")
    public final Date dueDate;

    @SerializedName("dueBefore")
    public final Date dueBefore;

    @SerializedName("dueAfter")
    public final Date dueAfter;

    @SerializedName("withoutDueDate")
    public final Boolean withoutDueDate;

    @SerializedName("active")
    public final Boolean active;

    @SerializedName("includeTaskLocalVariables")
    public final Boolean includeTaskLocalVariables;

    @SerializedName("includeProcessVariables")
    public final Boolean includeProcessVariables;

    @SerializedName("tenantId")
    public final String tenantId;

    @SerializedName("tenantIdLike")
    public final String tenantIdLike;

    @SerializedName("withoutTenantId")
    public final Boolean withoutTenantId;

    @SerializedName("candidateOrAssigned")
    public final String candidateOrAssigned;

    @SerializedName("category")
    public final String category;

    @SerializedName("taskVariables")
    public final List<QueryVariable> taskVariables;

    @SerializedName("processInstanceVariables")
    public final List<QueryVariable> processInstanceVariables;

    public TaskQueryRequest(Integer start, Integer size, String sort, String order, String name, String nameLike,
            String description, String descriptionLike, Integer priority, Integer minimumPriority,
            Integer maximumPriority, String assignee, String assigneeLike, String owner, String ownerLike,
            Boolean unassigned, String delegationState, String candidateUser, String candidateGroup,
            List<String> candidateGroupIn, String involvedUser, String processInstanceId,
            String processInstanceBusinessKey, String processInstanceBusinessKeyLike, List<String> processInstanceIdIn,
            String processDefinitionId, String processDefinitionKey, String processDefinitionName,
            String processDefinitionKeyLike, String processDefinitionNameLike, String executionId, Date createdOn,
            Date createdBefore, Date createdAfter, Boolean excludeSubTasks, String taskDefinitionKey,
            String taskDefinitionKeyLike, Date dueDate, Date dueBefore, Date dueAfter, Boolean withoutDueDate,
            Boolean active, Boolean includeTaskLocalVariables, Boolean includeProcessVariables, String tenantId,
            String tenantIdLike, Boolean withoutTenantId, String candidateOrAssigned, String category,
            List<QueryVariable> taskVariables, List<QueryVariable> processInstanceVariables)
    {
        this.start = start;
        this.size = size;
        this.sort = sort;
        this.order = order;
        this.name = name;
        this.nameLike = nameLike;
        this.description = description;
        this.descriptionLike = descriptionLike;
        this.priority = priority;
        this.minimumPriority = minimumPriority;
        this.maximumPriority = maximumPriority;
        this.assignee = assignee;
        this.assigneeLike = assigneeLike;
        this.owner = owner;
        this.ownerLike = ownerLike;
        this.unassigned = unassigned;
        this.delegationState = delegationState;
        this.candidateUser = candidateUser;
        this.candidateGroup = candidateGroup;
        this.candidateGroupIn = candidateGroupIn;
        this.involvedUser = involvedUser;
        this.processInstanceId = processInstanceId;
        this.processInstanceBusinessKey = processInstanceBusinessKey;
        this.processInstanceBusinessKeyLike = processInstanceBusinessKeyLike;
        this.processInstanceIdIn = processInstanceIdIn;
        this.processDefinitionId = processDefinitionId;
        this.processDefinitionKey = processDefinitionKey;
        this.processDefinitionName = processDefinitionName;
        this.processDefinitionKeyLike = processDefinitionKeyLike;
        this.processDefinitionNameLike = processDefinitionNameLike;
        this.executionId = executionId;
        this.createdOn = createdOn;
        this.createdBefore = createdBefore;
        this.createdAfter = createdAfter;
        this.excludeSubTasks = excludeSubTasks;
        this.taskDefinitionKey = taskDefinitionKey;
        this.taskDefinitionKeyLike = taskDefinitionKeyLike;
        this.dueDate = dueDate;
        this.dueBefore = dueBefore;
        this.dueAfter = dueAfter;
        this.withoutDueDate = withoutDueDate;
        this.active = active;
        this.includeTaskLocalVariables = includeTaskLocalVariables;
        this.includeProcessVariables = includeProcessVariables;
        this.tenantId = tenantId;
        this.tenantIdLike = tenantIdLike;
        this.withoutTenantId = withoutTenantId;
        this.candidateOrAssigned = candidateOrAssigned;
        this.category = category;
        this.taskVariables = taskVariables;
        this.processInstanceVariables = processInstanceVariables;
    }
}
