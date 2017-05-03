package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * FormDataResponse
 */
public class FormDataResponse
{
    @SerializedName("formKey")
    private String formKey = null;

    @SerializedName("deploymentId")
    private String deploymentId = null;

    @SerializedName("processDefinitionId")
    private String processDefinitionId = null;

    @SerializedName("processDefinitionUrl")
    private String processDefinitionUrl = null;

    @SerializedName("taskId")
    private String taskId = null;

    @SerializedName("taskUrl")
    private String taskUrl = null;

    @SerializedName("formProperties")
    private List<RestFormProperty> formProperties = new ArrayList<RestFormProperty>();

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
     * Get deploymentId
     * 
     * @return deploymentId
     **/
    public String getDeploymentId()
    {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId)
    {
        this.deploymentId = deploymentId;
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
     * Get taskId
     * 
     * @return taskId
     **/
    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    /**
     * Get taskUrl
     * 
     * @return taskUrl
     **/
    public String getTaskUrl()
    {
        return taskUrl;
    }

    public void setTaskUrl(String taskUrl)
    {
        this.taskUrl = taskUrl;
    }

    public FormDataResponse addFormPropertiesItem(RestFormProperty formPropertiesItem)
    {
        this.formProperties.add(formPropertiesItem);
        return this;
    }

    /**
     * Get formProperties
     * 
     * @return formProperties
     **/
    public List<RestFormProperty> getFormProperties()
    {
        return formProperties;
    }

    public void setFormProperties(List<RestFormProperty> formProperties)
    {
        this.formProperties = formProperties;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        FormDataResponse formDataResponse = (FormDataResponse) o;
        return Objects.equals(this.formKey, formDataResponse.formKey)
                && Objects.equals(this.deploymentId, formDataResponse.deploymentId)
                && Objects.equals(this.processDefinitionId, formDataResponse.processDefinitionId)
                && Objects.equals(this.processDefinitionUrl, formDataResponse.processDefinitionUrl)
                && Objects.equals(this.taskId, formDataResponse.taskId)
                && Objects.equals(this.taskUrl, formDataResponse.taskUrl)
                && Objects.equals(this.formProperties, formDataResponse.formProperties);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(formKey, deploymentId, processDefinitionId, processDefinitionUrl, taskId, taskUrl,
                formProperties);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class FormDataResponse {\n");

        sb.append("    formKey: ").append(toIndentedString(formKey)).append("\n");
        sb.append("    deploymentId: ").append(toIndentedString(deploymentId)).append("\n");
        sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
        sb.append("    processDefinitionUrl: ").append(toIndentedString(processDefinitionUrl)).append("\n");
        sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
        sb.append("    taskUrl: ").append(toIndentedString(taskUrl)).append("\n");
        sb.append("    formProperties: ").append(toIndentedString(formProperties)).append("\n");
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
