package org.alfresco.client.services.process.activiti.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * RestActionRequest
 */
public class RestActionRequest
{
    @SerializedName("action")
    public final String action;

    public RestActionRequest(String action)
    {
        this.action = action;
    }
}
