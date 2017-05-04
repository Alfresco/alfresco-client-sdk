
package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.List;

import org.alfresco.client.services.process.activiti.core.model.representation.QueryVariable;

import com.google.gson.annotations.SerializedName;

/**
 * ProcessInstanceQueryRequest
 */
public class ProcessInstanceQueryRequest
{
    @SerializedName("start")
    public final Integer start;

    @SerializedName("size")
    public final Integer size;

    @SerializedName("sort")
    public final String sort;

    @SerializedName("order")
    public final String order;

    @SerializedName("processInstanceId")
    public final String processInstanceId;

    @SerializedName("processBusinessKey")
    public final String processBusinessKey;

    @SerializedName("processDefinitionId")
    public final String processDefinitionId;

    @SerializedName("processDefinitionKey")
    public final String processDefinitionKey;

    @SerializedName("superProcessInstanceId")
    public final String superProcessInstanceId;

    @SerializedName("subProcessInstanceId")
    public final String subProcessInstanceId;

    @SerializedName("excludeSubprocesses")
    public final Boolean excludeSubprocesses;

    @SerializedName("involvedUser")
    public final String involvedUser;

    @SerializedName("suspended")
    public final Boolean suspended;

    @SerializedName("includeProcessVariables")
    public final Boolean includeProcessVariables;

    @SerializedName("variables")
    public final List<QueryVariable> variables;

    @SerializedName("tenantId")
    public final String tenantId;

    @SerializedName("tenantIdLike")
    public final String tenantIdLike;

    @SerializedName("withoutTenantId")
    public final Boolean withoutTenantId;

    public ProcessInstanceQueryRequest(Integer start, Integer size, String sort, String order, String processInstanceId,
            String processBusinessKey, String processDefinitionId, String processDefinitionKey,
            String superProcessInstanceId, String subProcessInstanceId, Boolean excludeSubprocesses,
            String involvedUser, Boolean suspended, Boolean includeProcessVariables, List<QueryVariable> variables,
            String tenantId, String tenantIdLike, Boolean withoutTenantId)
    {
        this.start = start;
        this.size = size;
        this.sort = sort;
        this.order = order;
        this.processInstanceId = processInstanceId;
        this.processBusinessKey = processBusinessKey;
        this.processDefinitionId = processDefinitionId;
        this.processDefinitionKey = processDefinitionKey;
        this.superProcessInstanceId = superProcessInstanceId;
        this.subProcessInstanceId = subProcessInstanceId;
        this.excludeSubprocesses = excludeSubprocesses;
        this.involvedUser = involvedUser;
        this.suspended = suspended;
        this.includeProcessVariables = includeProcessVariables;
        this.variables = variables;
        this.tenantId = tenantId;
        this.tenantIdLike = tenantIdLike;
        this.withoutTenantId = withoutTenantId;
    }
}
