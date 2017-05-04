package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.Date;
import java.util.List;

import org.alfresco.client.services.process.activiti.core.model.representation.QueryVariable;

import com.google.gson.annotations.SerializedName;

/**
 * HistoricProcessInstanceQueryRequest
 */
public class HistoricProcessInstanceQueryRequest extends PaginateRequest
{

    @SerializedName("processInstanceId")
    public final String processInstanceId;

    @SerializedName("processInstanceIds")
    public final List<String> processInstanceIds;

    @SerializedName("processBusinessKey")
    public final String processBusinessKey;

    @SerializedName("processDefinitionId")
    public final String processDefinitionId;

    @SerializedName("processDefinitionKey")
    public final String processDefinitionKey;

    @SerializedName("superProcessInstanceId")
    public final String superProcessInstanceId;

    @SerializedName("excludeSubprocesses")
    public final Boolean excludeSubprocesses;

    @SerializedName("finished")
    public final Boolean finished;

    @SerializedName("involvedUser")
    public final String involvedUser;

    @SerializedName("finishedAfter")
    public final Date finishedAfter;

    @SerializedName("finishedBefore")
    public final Date finishedBefore;

    @SerializedName("startedAfter")
    public final Date startedAfter;

    @SerializedName("startedBefore")
    public final Date startedBefore;

    @SerializedName("startedBy")
    public final String startedBy;

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

    public HistoricProcessInstanceQueryRequest(Integer start, Integer size, String sort, String order,
            String processInstanceId, List<String> processInstanceIds, String processBusinessKey,
            String processDefinitionId, String processDefinitionKey, String superProcessInstanceId,
            Boolean excludeSubprocesses, Boolean finished, String involvedUser, Date finishedAfter, Date finishedBefore,
            Date startedAfter, Date startedBefore, String startedBy, Boolean includeProcessVariables,
            List<QueryVariable> variables, String tenantId, String tenantIdLike, Boolean withoutTenantId)
    {
        super(start, size, sort, order);
        this.processInstanceId = processInstanceId;
        this.processInstanceIds = processInstanceIds;
        this.processBusinessKey = processBusinessKey;
        this.processDefinitionId = processDefinitionId;
        this.processDefinitionKey = processDefinitionKey;
        this.superProcessInstanceId = superProcessInstanceId;
        this.excludeSubprocesses = excludeSubprocesses;
        this.finished = finished;
        this.involvedUser = involvedUser;
        this.finishedAfter = finishedAfter;
        this.finishedBefore = finishedBefore;
        this.startedAfter = startedAfter;
        this.startedBefore = startedBefore;
        this.startedBy = startedBy;
        this.includeProcessVariables = includeProcessVariables;
        this.variables = variables;
        this.tenantId = tenantId;
        this.tenantIdLike = tenantIdLike;
        this.withoutTenantId = withoutTenantId;
    }
}
