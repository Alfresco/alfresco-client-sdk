package com.alfresco.client.api.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * GroupBodyUpdate
 */
public class GroupBodyUpdate
{
    @SerializedName("displayName")
    public final String displayName;

    public GroupBodyUpdate(String displayName)
    {
        this.displayName = displayName;
    }
}
