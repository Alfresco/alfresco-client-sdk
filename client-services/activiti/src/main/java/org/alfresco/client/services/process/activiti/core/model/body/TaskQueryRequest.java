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
    private Integer start;

    @SerializedName("size")
    private Integer size;

    @SerializedName("sort")
    private String sort;

    @SerializedName("order")
    private String order;

    @SerializedName("name")
    private String name;

    @SerializedName("nameLike")
    private String nameLike;

    @SerializedName("description")
    private String description;

    @SerializedName("descriptionLike")
    private String descriptionLike;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("minimumPriority")
    private Integer minimumPriority;

    @SerializedName("maximumPriority")
    private Integer maximumPriority;

    @SerializedName("assignee")
    private String assignee;

    @SerializedName("assigneeLike")
    private String assigneeLike;

    @SerializedName("owner")
    private String owner;

    @SerializedName("ownerLike")
    private String ownerLike;

    @SerializedName("unassigned")
    private Boolean unassigned;

    @SerializedName("delegationState")
    private String delegationState;

    @SerializedName("candidateUser")
    private String candidateUser;

    @SerializedName("candidateGroup")
    private String candidateGroup;

    @SerializedName("candidateGroupIn")
    private List<String> candidateGroupIn;

    @SerializedName("involvedUser")
    private String involvedUser;

    @SerializedName("processInstanceId")
    private String processInstanceId;

    @SerializedName("processInstanceBusinessKey")
    private String processInstanceBusinessKey;

    @SerializedName("processInstanceBusinessKeyLike")
    private String processInstanceBusinessKeyLike;

    @SerializedName("processInstanceIdIn")
    private List<String> processInstanceIdIn;

    @SerializedName("processDefinitionId")
    private String processDefinitionId;

    @SerializedName("processDefinitionKey")
    private String processDefinitionKey;

    @SerializedName("processDefinitionName")
    private String processDefinitionName;

    @SerializedName("processDefinitionKeyLike")
    private String processDefinitionKeyLike;

    @SerializedName("processDefinitionNameLike")
    private String processDefinitionNameLike;

    @SerializedName("executionId")
    private String executionId;

    @SerializedName("createdOn")
    private Date createdOn;

    @SerializedName("createdBefore")
    private Date createdBefore;

    @SerializedName("createdAfter")
    private Date createdAfter;

    @SerializedName("excludeSubTasks")
    private Boolean excludeSubTasks;

    @SerializedName("taskDefinitionKey")
    private String taskDefinitionKey;

    @SerializedName("taskDefinitionKeyLike")
    private String taskDefinitionKeyLike;

    @SerializedName("dueDate")
    private Date dueDate;

    @SerializedName("dueBefore")
    private Date dueBefore;

    @SerializedName("dueAfter")
    private Date dueAfter;

    @SerializedName("withoutDueDate")
    private Boolean withoutDueDate;

    @SerializedName("active")
    private Boolean active;

    @SerializedName("includeTaskLocalVariables")
    private Boolean includeTaskLocalVariables;

    @SerializedName("includeProcessVariables")
    private Boolean includeProcessVariables;

    @SerializedName("tenantId")
    private String tenantId;

    @SerializedName("tenantIdLike")
    private String tenantIdLike;

    @SerializedName("withoutTenantId")
    private Boolean withoutTenantId;

    @SerializedName("candidateOrAssigned")
    private String candidateOrAssigned;

    @SerializedName("category")
    private String category;

    @SerializedName("taskVariables")
    private List<QueryVariable> taskVariables;

    @SerializedName("processInstanceVariables")
    private List<QueryVariable> processInstanceVariables;

    public TaskQueryRequest()
    {

    }

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

    public TaskQueryRequest start(Integer start)
    {
        this.start = start;
        return this;
    }

    public TaskQueryRequest size(Integer size)
    {
        this.size = size;
        return this;
    }

    public TaskQueryRequest sort(String sort)
    {
        this.sort = sort;
        return this;
    }

    public TaskQueryRequest order(String order)
    {
        this.order = order;
        return this;
    }

    public TaskQueryRequest name(String name)
    {
        this.name = name;
        return this;
    }

    public TaskQueryRequest nameLike(String nameLike)
    {
        this.nameLike = nameLike;
        return this;
    }

    public TaskQueryRequest description(String description)
    {
        this.description = description;
        return this;
    }

    public TaskQueryRequest descriptionLike(String descriptionLike)
    {
        this.descriptionLike = descriptionLike;
        return this;
    }

    public TaskQueryRequest priority(Integer priority)
    {
        this.priority = priority;
        return this;
    }

    public TaskQueryRequest minimumPriority(Integer minimumPriority)
    {
        this.minimumPriority = minimumPriority;
        return this;
    }

    public TaskQueryRequest maximumPriority(Integer maximumPriority)
    {
        this.maximumPriority = maximumPriority;
        return this;
    }

    public TaskQueryRequest assignee(String assignee)
    {
        this.assignee = assignee;
        return this;
    }

    public TaskQueryRequest assigneeLike(String assigneeLike)
    {
        this.assigneeLike = assigneeLike;
        return this;
    }

    public TaskQueryRequest owner(String owner)
    {
        this.owner = owner;
        return this;
    }

    public TaskQueryRequest ownerLike(String ownerLike)
    {
        this.ownerLike = ownerLike;
        return this;
    }

    public TaskQueryRequest unassigned(Boolean unassigned)
    {
        this.unassigned = unassigned;
        return this;
    }

    public TaskQueryRequest delegationState(String delegationState)
    {
        this.delegationState = delegationState;
        return this;
    }

    public void setDelegationState(String delegationState)
    {
        this.delegationState = delegationState;
    }

    public TaskQueryRequest candidateUser(String candidateUser)
    {
        this.candidateUser = candidateUser;
        return this;
    }

    public TaskQueryRequest candidateGroup(String candidateGroup)
    {
        this.candidateGroup = candidateGroup;
        return this;
    }

    public TaskQueryRequest candidateGroupIn(List<String> candidateGroupIn)
    {
        this.candidateGroupIn = candidateGroupIn;
        return this;
    }

    public TaskQueryRequest addCandidateGroupInItem(String candidateGroupInItem)
    {
        this.candidateGroupIn.add(candidateGroupInItem);
        return this;
    }

    public TaskQueryRequest involvedUser(String involvedUser)
    {
        this.involvedUser = involvedUser;
        return this;
    }

    public TaskQueryRequest processInstanceId(String processInstanceId)
    {
        this.processInstanceId = processInstanceId;
        return this;
    }

    public TaskQueryRequest processInstanceBusinessKey(String processInstanceBusinessKey)
    {
        this.processInstanceBusinessKey = processInstanceBusinessKey;
        return this;
    }

    public TaskQueryRequest processInstanceBusinessKeyLike(String processInstanceBusinessKeyLike)
    {
        this.processInstanceBusinessKeyLike = processInstanceBusinessKeyLike;
        return this;
    }

    public TaskQueryRequest processInstanceIdIn(List<String> processInstanceIdIn)
    {
        this.processInstanceIdIn = processInstanceIdIn;
        return this;
    }

    public TaskQueryRequest addProcessInstanceIdInItem(String processInstanceIdInItem)
    {
        this.processInstanceIdIn.add(processInstanceIdInItem);
        return this;
    }

    public TaskQueryRequest processDefinitionId(String processDefinitionId)
    {
        this.processDefinitionId = processDefinitionId;
        return this;
    }

    public TaskQueryRequest processDefinitionKey(String processDefinitionKey)
    {
        this.processDefinitionKey = processDefinitionKey;
        return this;
    }

    public TaskQueryRequest processDefinitionName(String processDefinitionName)
    {
        this.processDefinitionName = processDefinitionName;
        return this;
    }

    public TaskQueryRequest processDefinitionKeyLike(String processDefinitionKeyLike)
    {
        this.processDefinitionKeyLike = processDefinitionKeyLike;
        return this;
    }

    public TaskQueryRequest processDefinitionNameLike(String processDefinitionNameLike)
    {
        this.processDefinitionNameLike = processDefinitionNameLike;
        return this;
    }

    public TaskQueryRequest executionId(String executionId)
    {
        this.executionId = executionId;
        return this;
    }

    public TaskQueryRequest createdOn(Date createdOn)
    {
        this.createdOn = createdOn;
        return this;
    }

    public TaskQueryRequest createdBefore(Date createdBefore)
    {
        this.createdBefore = createdBefore;
        return this;
    }

    public TaskQueryRequest createdAfter(Date createdAfter)
    {
        this.createdAfter = createdAfter;
        return this;
    }

    public TaskQueryRequest excludeSubTasks(Boolean excludeSubTasks)
    {
        this.excludeSubTasks = excludeSubTasks;
        return this;
    }

    public TaskQueryRequest taskDefinitionKey(String taskDefinitionKey)
    {
        this.taskDefinitionKey = taskDefinitionKey;
        return this;
    }

    public TaskQueryRequest taskDefinitionKeyLike(String taskDefinitionKeyLike)
    {
        this.taskDefinitionKeyLike = taskDefinitionKeyLike;
        return this;
    }

    public TaskQueryRequest dueDate(Date dueDate)
    {
        this.dueDate = dueDate;
        return this;
    }

    public TaskQueryRequest dueBefore(Date dueBefore)
    {
        this.dueBefore = dueBefore;
        return this;
    }

    public TaskQueryRequest dueAfter(Date dueAfter)
    {
        this.dueAfter = dueAfter;
        return this;
    }

    public TaskQueryRequest withoutDueDate(Boolean withoutDueDate)
    {
        this.withoutDueDate = withoutDueDate;
        return this;
    }

    public TaskQueryRequest active(Boolean active)
    {
        this.active = active;
        return this;
    }

    public TaskQueryRequest includeTaskLocalVariables(Boolean includeTaskLocalVariables)
    {
        this.includeTaskLocalVariables = includeTaskLocalVariables;
        return this;
    }

    public TaskQueryRequest includeProcessVariables(Boolean includeProcessVariables)
    {
        this.includeProcessVariables = includeProcessVariables;
        return this;
    }

    public TaskQueryRequest tenantId(String tenantId)
    {
        this.tenantId = tenantId;
        return this;
    }

    public TaskQueryRequest tenantIdLike(String tenantIdLike)
    {
        this.tenantIdLike = tenantIdLike;
        return this;
    }

    public TaskQueryRequest withoutTenantId(Boolean withoutTenantId)
    {
        this.withoutTenantId = withoutTenantId;
        return this;
    }

    public TaskQueryRequest candidateOrAssigned(String candidateOrAssigned)
    {
        this.candidateOrAssigned = candidateOrAssigned;
        return this;
    }

    public TaskQueryRequest category(String category)
    {
        this.category = category;
        return this;
    }

    public TaskQueryRequest taskVariables(List<QueryVariable> taskVariables)
    {
        this.taskVariables = taskVariables;
        return this;
    }

    public TaskQueryRequest addTaskVariablesItem(QueryVariable taskVariablesItem)
    {
        this.taskVariables.add(taskVariablesItem);
        return this;
    }

    public TaskQueryRequest processInstanceVariables(List<QueryVariable> processInstanceVariables)
    {
        this.processInstanceVariables = processInstanceVariables;
        return this;
    }

    public TaskQueryRequest addProcessInstanceVariablesItem(QueryVariable processInstanceVariablesItem)
    {
        this.processInstanceVariables.add(processInstanceVariablesItem);
        return this;
    }

}
