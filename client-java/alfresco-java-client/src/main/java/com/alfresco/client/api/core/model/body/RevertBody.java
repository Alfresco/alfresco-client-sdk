package com.alfresco.client.api.core.model.body;

/**
 * Created by jpascal on 30/09/2016.
 */
public class RevertBody
{
    public final String comment;

    public final Boolean majorVersion;

    public RevertBody(String comment, Boolean majorVersion)
    {
        this.comment = comment;
        this.majorVersion = majorVersion;
    }
}
