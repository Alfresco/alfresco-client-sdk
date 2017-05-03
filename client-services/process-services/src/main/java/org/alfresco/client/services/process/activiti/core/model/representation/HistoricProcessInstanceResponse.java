package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * HistoricProcessInstanceResponse
 */
public class HistoricProcessInstanceResponse
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("businessKey")
    private String businessKey = null;

    @SerializedName("processDefinitionId")
    private String processDefinitionId = null;

    @SerializedName("processDefinitionUrl")
    private String processDefinitionUrl = null;

    @SerializedName("startTime")
    private Date startTime = null;

    @SerializedName("endTime")
    private Date endTime = null;

    @SerializedName("durationInMillis")
    private Long durationInMillis = null;

    @SerializedName("startUserId")
    private String startUserId = null;

    @SerializedName("startActivityId")
    private String startActivityId = null;

    @SerializedName("endActivityId")
    private String endActivityId = null;

    @SerializedName("deleteReason")
    private String deleteReason = null;

    @SerializedName("superProcessInstanceId")
    private String superProcessInstanceId = null;

    @SerializedName("variables")
    private List<RestVariable> variables = new ArrayList<RestVariable>();

    @SerializedName("tenantId")
    private String tenantId = null;

    @SerializedName("name")
    private String name = null;

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
     * Get businessKey
     * 
     * @return businessKey
     **/
    public String getBusinessKey()
    {
        return businessKey;
    }

    public void setBusinessKey(String businessKey)
    {
        this.businessKey = businessKey;
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
     * Get startUserId
     * 
     * @return startUserId
     **/
    public String getStartUserId()
    {
        return startUserId;
    }

    public void setStartUserId(String startUserId)
    {
        this.startUserId = startUserId;
    }

    /**
     * Get startActivityId
     * 
     * @return startActivityId
     **/
    public String getStartActivityId()
    {
        return startActivityId;
    }

    public void setStartActivityId(String startActivityId)
    {
        this.startActivityId = startActivityId;
    }

    /**
     * Get endActivityId
     * 
     * @return endActivityId
     **/
    public String getEndActivityId()
    {
        return endActivityId;
    }

    public void setEndActivityId(String endActivityId)
    {
        this.endActivityId = endActivityId;
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
     * Get superProcessInstanceId
     * 
     * @return superProcessInstanceId
     **/
    public String getSuperProcessInstanceId()
    {
        return superProcessInstanceId;
    }

    public void setSuperProcessInstanceId(String superProcessInstanceId)
    {
        this.superProcessInstanceId = superProcessInstanceId;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        HistoricProcessInstanceResponse historicProcessInstanceResponse = (HistoricProcessInstanceResponse) o;
        return Objects.equals(this.id, historicProcessInstanceResponse.id)
                && Objects.equals(this.url, historicProcessInstanceResponse.url)
                && Objects.equals(this.businessKey, historicProcessInstanceResponse.businessKey)
                && Objects.equals(this.processDefinitionId, historicProcessInstanceResponse.processDefinitionId)
                && Objects.equals(this.processDefinitionUrl, historicProcessInstanceResponse.processDefinitionUrl)
                && Objects.equals(this.startTime, historicProcessInstanceResponse.startTime)
                && Objects.equals(this.endTime, historicProcessInstanceResponse.endTime)
                && Objects.equals(this.durationInMillis, historicProcessInstanceResponse.durationInMillis)
                && Objects.equals(this.startUserId, historicProcessInstanceResponse.startUserId)
                && Objects.equals(this.startActivityId, historicProcessInstanceResponse.startActivityId)
                && Objects.equals(this.endActivityId, historicProcessInstanceResponse.endActivityId)
                && Objects.equals(this.deleteReason, historicProcessInstanceResponse.deleteReason)
                && Objects.equals(this.superProcessInstanceId, historicProcessInstanceResponse.superProcessInstanceId)
                && Objects.equals(this.variables, historicProcessInstanceResponse.variables)
                && Objects.equals(this.tenantId, historicProcessInstanceResponse.tenantId)
                && Objects.equals(this.name, historicProcessInstanceResponse.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, url, businessKey, processDefinitionId, processDefinitionUrl, startTime, endTime,
                durationInMillis, startUserId, startActivityId, endActivityId, deleteReason, superProcessInstanceId,
                variables, tenantId, name);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class HistoricProcessInstanceResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    businessKey: ").append(toIndentedString(businessKey)).append("\n");
        sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
        sb.append("    processDefinitionUrl: ").append(toIndentedString(processDefinitionUrl)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    durationInMillis: ").append(toIndentedString(durationInMillis)).append("\n");
        sb.append("    startUserId: ").append(toIndentedString(startUserId)).append("\n");
        sb.append("    startActivityId: ").append(toIndentedString(startActivityId)).append("\n");
        sb.append("    endActivityId: ").append(toIndentedString(endActivityId)).append("\n");
        sb.append("    deleteReason: ").append(toIndentedString(deleteReason)).append("\n");
        sb.append("    superProcessInstanceId: ").append(toIndentedString(superProcessInstanceId)).append("\n");
        sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
