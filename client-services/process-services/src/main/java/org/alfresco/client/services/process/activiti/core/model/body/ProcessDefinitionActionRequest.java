package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * ProcessDefinitionActionRequest
 */
public class ProcessDefinitionActionRequest
{
    @SerializedName("action")
    public final String action;

    @SerializedName("includeProcessInstances")
    public final Boolean includeProcessInstances;

    @SerializedName("date")
    public final Date date;

    @SerializedName("category")
    public final String category;

    public ProcessDefinitionActionRequest(String action, Boolean includeProcessInstances, Date date, String category)
    {
        this.action = action;
        this.includeProcessInstances = includeProcessInstances;
        this.date = date;
        this.category = category;
    }
}
