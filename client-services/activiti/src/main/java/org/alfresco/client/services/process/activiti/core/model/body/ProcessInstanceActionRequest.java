package org.alfresco.client.services.process.activiti.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * ProcessInstanceActionRequest
 */
public class ProcessInstanceActionRequest
{
    @SerializedName("action")
    public final String action;

    public ProcessInstanceActionRequest(String action)
    {
        this.action = action;
    }
}
