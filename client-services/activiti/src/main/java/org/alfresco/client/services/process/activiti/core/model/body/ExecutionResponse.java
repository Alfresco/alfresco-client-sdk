package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * ExecutionResponse
 */
public class ExecutionResponse
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("parentId")
    private String parentId = null;

    @SerializedName("parentUrl")
    private String parentUrl = null;

    @SerializedName("superExecutionId")
    private String superExecutionId = null;

    @SerializedName("superExecutionUrl")
    private String superExecutionUrl = null;

    @SerializedName("processInstanceId")
    private String processInstanceId = null;

    @SerializedName("processInstanceUrl")
    private String processInstanceUrl = null;

    @SerializedName("suspended")
    private Boolean suspended = false;

    @SerializedName("activityId")
    private String activityId = null;

    @SerializedName("tenantId")
    private String tenantId = null;

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
     * Get parentId
     * 
     * @return parentId
     **/
    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    /**
     * Get parentUrl
     * 
     * @return parentUrl
     **/
    public String getParentUrl()
    {
        return parentUrl;
    }

    public void setParentUrl(String parentUrl)
    {
        this.parentUrl = parentUrl;
    }

    /**
     * Get superExecutionId
     * 
     * @return superExecutionId
     **/
    public String getSuperExecutionId()
    {
        return superExecutionId;
    }

    public void setSuperExecutionId(String superExecutionId)
    {
        this.superExecutionId = superExecutionId;
    }

    /**
     * Get superExecutionUrl
     * 
     * @return superExecutionUrl
     **/
    public String getSuperExecutionUrl()
    {
        return superExecutionUrl;
    }

    public void setSuperExecutionUrl(String superExecutionUrl)
    {
        this.superExecutionUrl = superExecutionUrl;
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
     * Get activityId
     * 
     * @return activityId
     **/
    public String getActivityId()
    {
        return activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ExecutionResponse executionResponse = (ExecutionResponse) o;
        return Objects.equals(this.id, executionResponse.id) && Objects.equals(this.url, executionResponse.url)
                && Objects.equals(this.parentId, executionResponse.parentId)
                && Objects.equals(this.parentUrl, executionResponse.parentUrl)
                && Objects.equals(this.superExecutionId, executionResponse.superExecutionId)
                && Objects.equals(this.superExecutionUrl, executionResponse.superExecutionUrl)
                && Objects.equals(this.processInstanceId, executionResponse.processInstanceId)
                && Objects.equals(this.processInstanceUrl, executionResponse.processInstanceUrl)
                && Objects.equals(this.suspended, executionResponse.suspended)
                && Objects.equals(this.activityId, executionResponse.activityId)
                && Objects.equals(this.tenantId, executionResponse.tenantId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, url, parentId, parentUrl, superExecutionId, superExecutionUrl, processInstanceId,
                processInstanceUrl, suspended, activityId, tenantId);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExecutionResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    parentUrl: ").append(toIndentedString(parentUrl)).append("\n");
        sb.append("    superExecutionId: ").append(toIndentedString(superExecutionId)).append("\n");
        sb.append("    superExecutionUrl: ").append(toIndentedString(superExecutionUrl)).append("\n");
        sb.append("    processInstanceId: ").append(toIndentedString(processInstanceId)).append("\n");
        sb.append("    processInstanceUrl: ").append(toIndentedString(processInstanceUrl)).append("\n");
        sb.append("    suspended: ").append(toIndentedString(suspended)).append("\n");
        sb.append("    activityId: ").append(toIndentedString(activityId)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
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
