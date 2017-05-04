package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.List;

import org.alfresco.client.services.process.enterprise.core.model.runtime.QueryVariable;

import com.google.gson.annotations.SerializedName;

/**
 * HistoricVariableInstanceQueryRequest
 */
public class HistoricVariableInstanceQueryRequest
{
    @SerializedName("excludeTaskVariables")
    public final Boolean excludeTaskVariables;

    @SerializedName("taskId")
    public final String taskId;

    @SerializedName("executionId")
    public final String executionId;

    @SerializedName("processInstanceId")
    public final String processInstanceId;

    @SerializedName("variableName")
    public final String variableName;

    @SerializedName("variableNameLike")
    public final String variableNameLike;

    @SerializedName("variables")
    public final List<QueryVariable> variables;

    public HistoricVariableInstanceQueryRequest(Boolean excludeTaskVariables, String taskId, String executionId,
            String processInstanceId, String variableName, String variableNameLike, List<QueryVariable> variables)
    {
        this.excludeTaskVariables = excludeTaskVariables;
        this.taskId = taskId;
        this.executionId = executionId;
        this.processInstanceId = processInstanceId;
        this.variableName = variableName;
        this.variableNameLike = variableNameLike;
        this.variables = variables;
    }
}
