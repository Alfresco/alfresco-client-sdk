package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.List;

import org.alfresco.client.services.process.activiti.core.model.representation.RestFormProperty;

import com.google.gson.annotations.SerializedName;

/**
 * SubmitFormRequest
 */
public class SubmitFormRequest
{
    @SerializedName("action")
    public final String action;

    @SerializedName("processDefinitionId")
    public final String processDefinitionId;

    @SerializedName("taskId")
    public final String taskId;

    @SerializedName("businessKey")
    public final String businessKey;

    @SerializedName("properties")
    public final List<RestFormProperty> properties;

    public SubmitFormRequest(String action, String processDefinitionId, String taskId, String businessKey,
            List<RestFormProperty> properties)
    {
        this.action = action;
        this.processDefinitionId = processDefinitionId;
        this.taskId = taskId;
        this.businessKey = businessKey;
        this.properties = properties;
    }
}
