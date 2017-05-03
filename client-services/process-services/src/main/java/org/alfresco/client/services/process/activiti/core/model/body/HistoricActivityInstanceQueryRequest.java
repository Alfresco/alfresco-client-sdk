package org.alfresco.client.services.process.activiti.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * HistoricActivityInstanceQueryRequest
 */
public class HistoricActivityInstanceQueryRequest extends PaginateRequest
{
    @SerializedName("activityId")
    public final String activityId;

    @SerializedName("activityInstanceId")
    public final String activityInstanceId;

    @SerializedName("activityName")
    public final String activityName;

    @SerializedName("activityType")
    public final String activityType;

    @SerializedName("executionId")
    public final String executionId;

    @SerializedName("finished")
    public final Boolean finished;

    @SerializedName("taskAssignee")
    public final String taskAssignee;

    @SerializedName("processInstanceId")
    public final String processInstanceId;

    @SerializedName("processDefinitionId")
    public final String processDefinitionId;

    @SerializedName("tenantId")
    public final String tenantId;

    @SerializedName("tenantIdLike")
    public final String tenantIdLike;

    @SerializedName("withoutTenantId")
    public final Boolean withoutTenantId;

    public HistoricActivityInstanceQueryRequest(Integer start, Integer size, String sort, String order,
            String activityId, String activityInstanceId, String activityName, String activityType, String executionId,
            Boolean finished, String taskAssignee, String processInstanceId, String processDefinitionId,
            String tenantId, String tenantIdLike, Boolean withoutTenantId)
    {
        super(start, size, sort, order);
        this.activityId = activityId;
        this.activityInstanceId = activityInstanceId;
        this.activityName = activityName;
        this.activityType = activityType;
        this.executionId = executionId;
        this.finished = finished;
        this.taskAssignee = taskAssignee;
        this.processInstanceId = processInstanceId;
        this.processDefinitionId = processDefinitionId;
        this.tenantId = tenantId;
        this.tenantIdLike = tenantIdLike;
        this.withoutTenantId = withoutTenantId;
    }
}
