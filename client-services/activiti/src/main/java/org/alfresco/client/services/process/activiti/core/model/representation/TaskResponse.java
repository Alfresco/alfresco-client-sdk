package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * TaskResponse
 */
public class TaskResponse
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("owner")
    private String owner = null;

    @SerializedName("assignee")
    private String assignee = null;

    @SerializedName("delegationState")
    private String delegationState = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("createTime")
    private Date createTime = null;

    @SerializedName("dueDate")
    private Date dueDate = null;

    @SerializedName("priority")
    private Integer priority = null;

    @SerializedName("suspended")
    private Boolean suspended = false;

    @SerializedName("taskDefinitionKey")
    private String taskDefinitionKey = null;

    @SerializedName("tenantId")
    private String tenantId = null;

    @SerializedName("category")
    private String category = null;

    @SerializedName("formKey")
    private String formKey = null;

    @SerializedName("parentTaskId")
    private String parentTaskId = null;

    @SerializedName("parentTaskUrl")
    private String parentTaskUrl = null;

    @SerializedName("executionId")
    private String executionId = null;

    @SerializedName("executionUrl")
    private String executionUrl = null;

    @SerializedName("processInstanceId")
    private String processInstanceId = null;

    @SerializedName("processInstanceUrl")
    private String processInstanceUrl = null;

    @SerializedName("processDefinitionId")
    private String processDefinitionId = null;

    @SerializedName("processDefinitionUrl")
    private String processDefinitionUrl = null;

    @SerializedName("variables")
    private List<RestVariable> variables = new ArrayList<RestVariable>();

    /**
     * Get id
     * 
     * @return id
     **/
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * Get url
     * 
     * @return url
     **/
    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Get owner
     * 
     * @return owner
     **/
    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    /**
     * Get assignee
     * 
     * @return assignee
     **/
    public String getAssignee()
    {
        return assignee;
    }

    public void setAssignee(String assignee)
    {
        this.assignee = assignee;
    }

    /**
     * Delegation-state of the task, can be null, \"pending\" or \"resolved\".
     * 
     * @return delegationState
     **/
    public String getDelegationState()
    {
        return delegationState;
    }

    public void setDelegationState(String delegationState)
    {
        this.delegationState = delegationState;
    }

    /**
     * Get name
     * 
     * @return name
     **/
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get description
     * 
     * @return description
     **/
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Get createTime
     * 
     * @return createTime
     **/
    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    /**
     * Get dueDate
     * 
     * @return dueDate
     **/
    public Date getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }

    /**
     * Get priority
     * 
     * @return priority
     **/
    public Integer getPriority()
    {
        return priority;
    }

    public void setPriority(Integer priority)
    {
        this.priority = priority;
    }

    /**
     * Get suspended
     * 
     * @return suspended
     **/
    public Boolean getSuspended()
    {
        return suspended;
    }

    public void setSuspended(Boolean suspended)
    {
        this.suspended = suspended;
    }

    /**
     * Get taskDefinitionKey
     * 
     * @return taskDefinitionKey
     **/
    public String getTaskDefinitionKey()
    {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey)
    {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    /**
     * Get tenantId
     * 
     * @return tenantId
     **/
    public String getTenantId()
    {
        return tenantId;
    }

    public void setTenantId(String tenantId)
    {
        this.tenantId = tenantId;
    }

    /**
     * Get category
     * 
     * @return category
     **/
    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    /**
     * Get formKey
     * 
     * @return formKey
     **/
    public String getFormKey()
    {
        return formKey;
    }

    public void setFormKey(String formKey)
    {
        this.formKey = formKey;
    }

    /**
     * Get parentTaskId
     * 
     * @return parentTaskId
     **/
    public String getParentTaskId()
    {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId)
    {
        this.parentTaskId = parentTaskId;
    }

    /**
     * Get parentTaskUrl
     * 
     * @return parentTaskUrl
     **/
    public String getParentTaskUrl()
    {
        return parentTaskUrl;
    }

    public void setParentTaskUrl(String parentTaskUrl)
    {
        this.parentTaskUrl = parentTaskUrl;
    }

    /**
     * Get executionId
     * 
     * @return executionId
     **/
    public String getExecutionId()
    {
        return executionId;
    }

    public void setExecutionId(String executionId)
    {
        this.executionId = executionId;
    }

    /**
     * Get executionUrl
     * 
     * @return executionUrl
     **/
    public String getExecutionUrl()
    {
        return executionUrl;
    }

    public void setExecutionUrl(String executionUrl)
    {
        this.executionUrl = executionUrl;
    }

    /**
     * Get processInstanceId
     * 
     * @return processInstanceId
     **/
    public String getProcessInstanceId()
    {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId)
    {
        this.processInstanceId = processInstanceId;
    }

    /**
     * Get processInstanceUrl
     * 
     * @return processInstanceUrl
     **/
    public String getProcessInstanceUrl()
    {
        return processInstanceUrl;
    }

    public void setProcessInstanceUrl(String processInstanceUrl)
    {
        this.processInstanceUrl = processInstanceUrl;
    }

    /**
     * Get processDefinitionId
     * 
     * @return processDefinitionId
     **/
    public String getProcessDefinitionId()
    {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId)
    {
        this.processDefinitionId = processDefinitionId;
    }

    /**
     * Get processDefinitionUrl
     * 
     * @return processDefinitionUrl
     **/
    public String getProcessDefinitionUrl()
    {
        return processDefinitionUrl;
    }

    public void setProcessDefinitionUrl(String processDefinitionUrl)
    {
        this.processDefinitionUrl = processDefinitionUrl;
    }

    /**
     * Get variables
     * 
     * @return variables
     **/
    public List<RestVariable> getVariables()
    {
        return variables;
    }

    public void setVariables(List<RestVariable> variables)
    {
        this.variables = variables;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TaskResponse taskResponse = (TaskResponse) o;
        return Objects.equals(this.id, taskResponse.id) && Objects.equals(this.url, taskResponse.url)
                && Objects.equals(this.owner, taskResponse.owner)
                && Objects.equals(this.assignee, taskResponse.assignee)
                && Objects.equals(this.delegationState, taskResponse.delegationState)
                && Objects.equals(this.name, taskResponse.name)
                && Objects.equals(this.description, taskResponse.description)
                && Objects.equals(this.createTime, taskResponse.createTime)
                && Objects.equals(this.dueDate, taskResponse.dueDate)
                && Objects.equals(this.priority, taskResponse.priority)
                && Objects.equals(this.suspended, taskResponse.suspended)
                && Objects.equals(this.taskDefinitionKey, taskResponse.taskDefinitionKey)
                && Objects.equals(this.tenantId, taskResponse.tenantId)
                && Objects.equals(this.category, taskResponse.category)
                && Objects.equals(this.formKey, taskResponse.formKey)
                && Objects.equals(this.parentTaskId, taskResponse.parentTaskId)
                && Objects.equals(this.parentTaskUrl, taskResponse.parentTaskUrl)
                && Objects.equals(this.executionId, taskResponse.executionId)
                && Objects.equals(this.executionUrl, taskResponse.executionUrl)
                && Objects.equals(this.processInstanceId, taskResponse.processInstanceId)
                && Objects.equals(this.processInstanceUrl, taskResponse.processInstanceUrl)
                && Objects.equals(this.processDefinitionId, taskResponse.processDefinitionId)
                && Objects.equals(this.processDefinitionUrl, taskResponse.processDefinitionUrl)
                && Objects.equals(this.variables, taskResponse.variables);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, url, owner, assignee, delegationState, name, description, createTime, dueDate, priority,
                suspended, taskDefinitionKey, tenantId, category, formKey, parentTaskId, parentTaskUrl, executionId,
                executionUrl, processInstanceId, processInstanceUrl, processDefinitionId, processDefinitionUrl,
                variables);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class TaskResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
        sb.append("    delegationState: ").append(toIndentedString(delegationState)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    suspended: ").append(toIndentedString(suspended)).append("\n");
        sb.append("    taskDefinitionKey: ").append(toIndentedString(taskDefinitionKey)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    formKey: ").append(toIndentedString(formKey)).append("\n");
        sb.append("    parentTaskId: ").append(toIndentedString(parentTaskId)).append("\n");
        sb.append("    parentTaskUrl: ").append(toIndentedString(parentTaskUrl)).append("\n");
        sb.append("    executionId: ").append(toIndentedString(executionId)).append("\n");
        sb.append("    executionUrl: ").append(toIndentedString(executionUrl)).append("\n");
        sb.append("    processInstanceId: ").append(toIndentedString(processInstanceId)).append("\n");
        sb.append("    processInstanceUrl: ").append(toIndentedString(processInstanceUrl)).append("\n");
        sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
        sb.append("    processDefinitionUrl: ").append(toIndentedString(processDefinitionUrl)).append("\n");
        sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o)
    {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }
}
