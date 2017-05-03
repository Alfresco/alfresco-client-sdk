package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * HistoricTaskInstanceResponse
 */
public class HistoricTaskInstanceResponse
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("processDefinitionId")
    private String processDefinitionId = null;

    @SerializedName("processDefinitionUrl")
    private String processDefinitionUrl = null;

    @SerializedName("processInstanceId")
    private String processInstanceId = null;

    @SerializedName("processInstanceUrl")
    private String processInstanceUrl = null;

    @SerializedName("executionId")
    private String executionId = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("deleteReason")
    private String deleteReason = null;

    @SerializedName("owner")
    private String owner = null;

    @SerializedName("assignee")
    private String assignee = null;

    @SerializedName("startTime")
    private Date startTime = null;

    @SerializedName("endTime")
    private Date endTime = null;

    @SerializedName("durationInMillis")
    private Long durationInMillis = null;

    @SerializedName("workTimeInMillis")
    private Long workTimeInMillis = null;

    @SerializedName("claimTime")
    private Date claimTime = null;

    @SerializedName("taskDefinitionKey")
    private String taskDefinitionKey = null;

    @SerializedName("formKey")
    private String formKey = null;

    @SerializedName("priority")
    private Integer priority = null;

    @SerializedName("dueDate")
    private Date dueDate = null;

    @SerializedName("parentTaskId")
    private String parentTaskId = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("variables")
    private List<RestVariable> variables = new ArrayList<RestVariable>();

    @SerializedName("tenantId")
    private String tenantId = null;

    @SerializedName("category")
    private String category = null;

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
     * Get deleteReason
     * 
     * @return deleteReason
     **/
    public String getDeleteReason()
    {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason)
    {
        this.deleteReason = deleteReason;
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
     * Get startTime
     * 
     * @return startTime
     **/
    public Date getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    /**
     * Get endTime
     * 
     * @return endTime
     **/
    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    /**
     * Get durationInMillis
     * 
     * @return durationInMillis
     **/
    public Long getDurationInMillis()
    {
        return durationInMillis;
    }

    public void setDurationInMillis(Long durationInMillis)
    {
        this.durationInMillis = durationInMillis;
    }

    /**
     * Get workTimeInMillis
     * 
     * @return workTimeInMillis
     **/
    public Long getWorkTimeInMillis()
    {
        return workTimeInMillis;
    }

    public void setWorkTimeInMillis(Long workTimeInMillis)
    {
        this.workTimeInMillis = workTimeInMillis;
    }

    /**
     * Get claimTime
     * 
     * @return claimTime
     **/
    public Date getClaimTime()
    {
        return claimTime;
    }

    public void setClaimTime(Date claimTime)
    {
        this.claimTime = claimTime;
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

    public HistoricTaskInstanceResponse addVariablesItem(RestVariable variablesItem)
    {
        this.variables.add(variablesItem);
        return this;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        HistoricTaskInstanceResponse historicTaskInstanceResponse = (HistoricTaskInstanceResponse) o;
        return Objects.equals(this.id, historicTaskInstanceResponse.id)
                && Objects.equals(this.processDefinitionId, historicTaskInstanceResponse.processDefinitionId)
                && Objects.equals(this.processDefinitionUrl, historicTaskInstanceResponse.processDefinitionUrl)
                && Objects.equals(this.processInstanceId, historicTaskInstanceResponse.processInstanceId)
                && Objects.equals(this.processInstanceUrl, historicTaskInstanceResponse.processInstanceUrl)
                && Objects.equals(this.executionId, historicTaskInstanceResponse.executionId)
                && Objects.equals(this.name, historicTaskInstanceResponse.name)
                && Objects.equals(this.description, historicTaskInstanceResponse.description)
                && Objects.equals(this.deleteReason, historicTaskInstanceResponse.deleteReason)
                && Objects.equals(this.owner, historicTaskInstanceResponse.owner)
                && Objects.equals(this.assignee, historicTaskInstanceResponse.assignee)
                && Objects.equals(this.startTime, historicTaskInstanceResponse.startTime)
                && Objects.equals(this.endTime, historicTaskInstanceResponse.endTime)
                && Objects.equals(this.durationInMillis, historicTaskInstanceResponse.durationInMillis)
                && Objects.equals(this.workTimeInMillis, historicTaskInstanceResponse.workTimeInMillis)
                && Objects.equals(this.claimTime, historicTaskInstanceResponse.claimTime)
                && Objects.equals(this.taskDefinitionKey, historicTaskInstanceResponse.taskDefinitionKey)
                && Objects.equals(this.formKey, historicTaskInstanceResponse.formKey)
                && Objects.equals(this.priority, historicTaskInstanceResponse.priority)
                && Objects.equals(this.dueDate, historicTaskInstanceResponse.dueDate)
                && Objects.equals(this.parentTaskId, historicTaskInstanceResponse.parentTaskId)
                && Objects.equals(this.url, historicTaskInstanceResponse.url)
                && Objects.equals(this.variables, historicTaskInstanceResponse.variables)
                && Objects.equals(this.tenantId, historicTaskInstanceResponse.tenantId)
                && Objects.equals(this.category, historicTaskInstanceResponse.category);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, processDefinitionId, processDefinitionUrl, processInstanceId, processInstanceUrl,
                executionId, name, description, deleteReason, owner, assignee, startTime, endTime, durationInMillis,
                workTimeInMillis, claimTime, taskDefinitionKey, formKey, priority, dueDate, parentTaskId, url,
                variables, tenantId, category);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class HistoricTaskInstanceResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
        sb.append("    processDefinitionUrl: ").append(toIndentedString(processDefinitionUrl)).append("\n");
        sb.append("    processInstanceId: ").append(toIndentedString(processInstanceId)).append("\n");
        sb.append("    processInstanceUrl: ").append(toIndentedString(processInstanceUrl)).append("\n");
        sb.append("    executionId: ").append(toIndentedString(executionId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    deleteReason: ").append(toIndentedString(deleteReason)).append("\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    durationInMillis: ").append(toIndentedString(durationInMillis)).append("\n");
        sb.append("    workTimeInMillis: ").append(toIndentedString(workTimeInMillis)).append("\n");
        sb.append("    claimTime: ").append(toIndentedString(claimTime)).append("\n");
        sb.append("    taskDefinitionKey: ").append(toIndentedString(taskDefinitionKey)).append("\n");
        sb.append("    formKey: ").append(toIndentedString(formKey)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
        sb.append("    parentTaskId: ").append(toIndentedString(parentTaskId)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
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
