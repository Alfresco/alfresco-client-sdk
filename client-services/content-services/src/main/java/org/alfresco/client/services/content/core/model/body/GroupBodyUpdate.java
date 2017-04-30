package org.alfresco.client.services.content.core.model.body;

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
