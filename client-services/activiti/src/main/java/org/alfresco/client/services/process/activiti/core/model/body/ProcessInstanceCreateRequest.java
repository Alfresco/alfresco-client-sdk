package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.List;

import org.alfresco.client.services.process.activiti.core.model.representation.RestVariable;

import com.google.gson.annotations.SerializedName;

/**
 * ProcessInstanceCreateRequest
 */
public class ProcessInstanceCreateRequest
{
    @SerializedName("processDefinitionId")
    public final String processDefinitionId;

    @SerializedName("processDefinitionKey")
    public final String processDefinitionKey;

    @SerializedName("message")
    public final String message;

    @SerializedName("businessKey")
    public final String businessKey;

    @SerializedName("variables")
    public final List<RestVariable> variables;

    @SerializedName("transientVariables")
    public final List<RestVariable> transientVariables;

    @SerializedName("tenantId")
    public final String tenantId;

    @SerializedName("returnVariables")
    public final Boolean returnVariables;

    public ProcessInstanceCreateRequest(String processDefinitionId, String processDefinitionKey, String message,
            String businessKey, List<RestVariable> variables, List<RestVariable> transientVariables, String tenantId,
            Boolean returnVariables)
    {
        this.processDefinitionId = processDefinitionId;
        this.processDefinitionKey = processDefinitionKey;
        this.message = message;
        this.businessKey = businessKey;
        this.variables = variables;
        this.transientVariables = transientVariables;
        this.tenantId = tenantId;
        this.returnVariables = returnVariables;
    }
}
