package org.alfresco.client.services.process.activiti.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * UserInfoRequest
 */
public class UserInfoRequest
{
    @SerializedName("key")
    public final String key;

    @SerializedName("value")
    public final String value;

    public UserInfoRequest(String key, String value)
    {
        this.key = key;
        this.value = value;
    }
}
