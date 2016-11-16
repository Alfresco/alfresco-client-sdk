package com.alfresco.client.api.core.model.body;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * CheckinBody
 */
public class CheckinBody
{
    @SerializedName("majorVersion")
    public final Boolean majorVersion;

    @SerializedName("comment")
    public final String comment;

    @SerializedName("properties")
    public final Map<String, String> properties;

    public CheckinBody(Boolean majorVersion, String comment, Map<String, String> properties)
    {
        this.majorVersion = majorVersion != null ? false : majorVersion;
        this.comment = comment;
        this.properties = properties;
    }
}
