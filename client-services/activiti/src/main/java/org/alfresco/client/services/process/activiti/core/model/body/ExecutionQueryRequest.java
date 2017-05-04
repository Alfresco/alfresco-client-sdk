package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.List;

import org.alfresco.client.services.process.activiti.core.model.representation.QueryVariable;

import com.google.gson.annotations.SerializedName;

/**
 * ExecutionQueryRequest
 */
public class ExecutionQueryRequest
{
    @SerializedName("start")
    public final Integer start;

    @SerializedName("size")
    public final Integer size;

    @SerializedName("sort")
    public final String sort;

    @SerializedName("order")
    public final String order;

    @SerializedName("id")
    public final String id;

    @SerializedName("activityId")
    public final String activityId;

    @SerializedName("parentId")
    public final String parentId;

    @SerializedName("processInstanceId")
    public final String processInstanceId;

    @SerializedName("processBusinessKey")
    public final String processBusinessKey;

    @SerializedName("processDefinitionId")
    public final String processDefinitionId;

    @SerializedName("processDefinitionKey")
    public final String processDefinitionKey;

    @SerializedName("signalEventSubscriptionName")
    public final String signalEventSubscriptionName;

    @SerializedName("messageEventSubscriptionName")
    public final String messageEventSubscriptionName;

    @SerializedName("variables")
    public final List<QueryVariable> variables;

    @SerializedName("processInstanceVariables")
    public final List<QueryVariable> processInstanceVariables;

    @SerializedName("tenantId")
    public final String tenantId;

    @SerializedName("tenantIdLike")
    public final String tenantIdLike;

    @SerializedName("withoutTenantId")
    public final Boolean withoutTenantId;

    public ExecutionQueryRequest(Integer start, Integer size, String sort, String order, String id, String activityId,
            String parentId, String processInstanceId, String processBusinessKey, String processDefinitionId,
            String processDefinitionKey, String signalEventSubscriptionName, String messageEventSubscriptionName,
            List<QueryVariable> variables, List<QueryVariable> processInstanceVariables, String tenantId,
            String tenantIdLike, Boolean withoutTenantId)
    {
        this.start = start;
        this.size = size;
        this.sort = sort;
        this.order = order;
        this.id = id;
        this.activityId = activityId;
        this.parentId = parentId;
        this.processInstanceId = processInstanceId;
        this.processBusinessKey = processBusinessKey;
        this.processDefinitionId = processDefinitionId;
        this.processDefinitionKey = processDefinitionKey;
        this.signalEventSubscriptionName = signalEventSubscriptionName;
        this.messageEventSubscriptionName = messageEventSubscriptionName;
        this.variables = variables;
        this.processInstanceVariables = processInstanceVariables;
        this.tenantId = tenantId;
        this.tenantIdLike = tenantIdLike;
        this.withoutTenantId = withoutTenantId;
    }
}
