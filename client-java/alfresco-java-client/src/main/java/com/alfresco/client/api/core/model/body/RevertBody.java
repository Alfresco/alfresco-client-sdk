package com.alfresco.client.api.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 30/09/2016.
 */
public class RevertBody
{
    @SerializedName("comment")
    public final String comment;

    @SerializedName("majorVersion")
    public final Boolean majorVersion;

    public RevertBody(String comment, Boolean majorVersion)
    {
        this.comment = comment;
        this.majorVersion = majorVersion;
    }
}
