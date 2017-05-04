package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.List;

import org.alfresco.client.services.process.activiti.core.model.representation.RestVariable;

import com.google.gson.annotations.SerializedName;

/**
 * ExecutionActionRequest
 */
public class ExecutionActionRequest
{
    @SerializedName("action")
    public final String action;

    @SerializedName("signalName")
    public final String signalName;

    @SerializedName("messageName")
    public final String messageName;

    @SerializedName("variables")
    public final List<RestVariable> variables;

    @SerializedName("transientVariables")
    public final List<RestVariable> transientVariables;

    public ExecutionActionRequest(String action, String signalName, String messageName, List<RestVariable> variables,
            List<RestVariable> transientVariables)
    {
        this.action = action;
        this.signalName = signalName;
        this.messageName = messageName;
        this.variables = variables;
        this.transientVariables = transientVariables;
    }
}
