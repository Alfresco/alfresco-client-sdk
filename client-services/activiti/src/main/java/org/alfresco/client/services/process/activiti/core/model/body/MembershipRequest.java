package org.alfresco.client.services.process.activiti.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * MembershipRequest
 */
public class MembershipRequest
{
    @SerializedName("userId")
    public final String userId;

    public MembershipRequest(String userId)
    {
        this.userId = userId;
    }
}
