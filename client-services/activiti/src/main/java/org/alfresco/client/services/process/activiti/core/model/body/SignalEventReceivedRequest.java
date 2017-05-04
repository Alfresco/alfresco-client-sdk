package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.List;

import org.alfresco.client.services.process.activiti.core.model.representation.RestVariable;

import com.google.gson.annotations.SerializedName;

/**
 * SignalEventReceivedRequest
 */
public class SignalEventReceivedRequest
{
    @SerializedName("signalName")
    public final String signalName;

    @SerializedName("variables")
    public final List<RestVariable> variables;

    @SerializedName("tenantId")
    public final String tenantId;

    @SerializedName("async")
    public final Boolean async;

    public SignalEventReceivedRequest(String signalName, List<RestVariable> variables, String tenantId, Boolean async)
    {
        this.signalName = signalName;
        this.variables = variables;
        this.tenantId = tenantId;
        this.async = async;
    }
}
