package com.alfresco.client.api.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * GroupMemberBodyAdd
 */
public class GroupMemberBodyAdd
{
    @SerializedName("groupMembmerId")
    public final String groupMembmerId;

    public GroupMemberBodyAdd(String groupMembmerId)
    {
        this.groupMembmerId = groupMembmerId;
    }
}
