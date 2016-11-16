package com.alfresco.client.api.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * GroupBodyCreate
 */
public class GroupBodyCreate
{
    @SerializedName("id")
    public final String id;

    @SerializedName("displayName")
    public final String displayName;

    @SerializedName("parentGroupId")
    public final String parentGroupId;

    public GroupBodyCreate(String id, String displayName, String parentGroupId)
    {
        this.id = id;
        this.displayName = displayName;
        this.parentGroupId = parentGroupId;
    }
}
