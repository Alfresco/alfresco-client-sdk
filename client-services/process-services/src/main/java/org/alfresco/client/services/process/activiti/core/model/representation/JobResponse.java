package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Date;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * JobResponse
 */
public class JobResponse
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("processInstanceId")
    private String processInstanceId = null;

    @SerializedName("processInstanceUrl")
    private String processInstanceUrl = null;

    @SerializedName("processDefinitionId")
    private String processDefinitionId = null;

    @SerializedName("processDefinitionUrl")
    private String processDefinitionUrl = null;

    @SerializedName("executionId")
    private String executionId = null;

    @SerializedName("executionUrl")
    private String executionUrl = null;

    @SerializedName("retries")
    private Integer retries = null;

    @SerializedName("exceptionMessage")
    private String exceptionMessage = null;

    @SerializedName("dueDate")
    private Date dueDate = null;

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
     * Get retries
     * 
     * @return retries
     **/
    public Integer getRetries()
    {
        return retries;
    }

    public void setRetries(Integer retries)
    {
        this.retries = retries;
    }

    /**
     * Get exceptionMessage
     * 
     * @return exceptionMessage
     **/
    public String getExceptionMessage()
    {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage)
    {
        this.exceptionMessage = exceptionMessage;
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
        JobResponse jobResponse = (JobResponse) o;
        return Objects.equals(this.id, jobResponse.id) && Objects.equals(this.url, jobResponse.url)
                && Objects.equals(this.processInstanceId, jobResponse.processInstanceId)
                && Objects.equals(this.processInstanceUrl, jobResponse.processInstanceUrl)
                && Objects.equals(this.processDefinitionId, jobResponse.processDefinitionId)
                && Objects.equals(this.processDefinitionUrl, jobResponse.processDefinitionUrl)
                && Objects.equals(this.executionId, jobResponse.executionId)
                && Objects.equals(this.executionUrl, jobResponse.executionUrl)
                && Objects.equals(this.retries, jobResponse.retries)
                && Objects.equals(this.exceptionMessage, jobResponse.exceptionMessage)
                && Objects.equals(this.dueDate, jobResponse.dueDate)
                && Objects.equals(this.tenantId, jobResponse.tenantId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, url, processInstanceId, processInstanceUrl, processDefinitionId, processDefinitionUrl,
                executionId, executionUrl, retries, exceptionMessage, dueDate, tenantId);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class JobResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    processInstanceId: ").append(toIndentedString(processInstanceId)).append("\n");
        sb.append("    processInstanceUrl: ").append(toIndentedString(processInstanceUrl)).append("\n");
        sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
        sb.append("    processDefinitionUrl: ").append(toIndentedString(processDefinitionUrl)).append("\n");
        sb.append("    executionId: ").append(toIndentedString(executionId)).append("\n");
        sb.append("    executionUrl: ").append(toIndentedString(executionUrl)).append("\n");
        sb.append("    retries: ").append(toIndentedString(retries)).append("\n");
        sb.append("    exceptionMessage: ").append(toIndentedString(exceptionMessage)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
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
