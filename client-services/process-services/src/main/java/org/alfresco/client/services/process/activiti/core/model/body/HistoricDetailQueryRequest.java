package org.alfresco.client.services.process.activiti.core.model.body;

import com.google.gson.annotations.SerializedName;

public class HistoricDetailQueryRequest extends PaginateRequest
{

    @SerializedName("id")
    public final String id;

    @SerializedName("processInstanceId")
    public final String processInstanceId;

    @SerializedName("executionId")
    public final String executionId;

    @SerializedName("activityInstanceId")
    public final String activityInstanceId;

    @SerializedName("taskId")
    public final String taskId;

    @SerializedName("selectOnlyFormProperties")
    public final Boolean selectOnlyFormProperties;

    @SerializedName("selectOnlyVariableUpdates")
    public final Boolean selectOnlyVariableUpdates;

    public HistoricDetailQueryRequest(Integer start, Integer size, String sort, String order, String id,
            String processInstanceId, String executionId, String activityInstanceId, String taskId,
            Boolean selectOnlyFormProperties, Boolean selectOnlyVariableUpdates)
    {
        super(start, size, sort, order);
        this.id = id;
        this.processInstanceId = processInstanceId;
        this.executionId = executionId;
        this.activityInstanceId = activityInstanceId;
        this.taskId = taskId;
        this.selectOnlyFormProperties = selectOnlyFormProperties;
        this.selectOnlyVariableUpdates = selectOnlyVariableUpdates;
    }
}
