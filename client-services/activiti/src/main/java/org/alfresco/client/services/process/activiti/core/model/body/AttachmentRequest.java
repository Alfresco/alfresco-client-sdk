package org.alfresco.client.services.process.activiti.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * AttachmentResponse
 */
public class AttachmentRequest
{
    @SerializedName("name")
    public final String name;

    @SerializedName("description")
    public final String description;

    @SerializedName("type")
    public final String type;

    @SerializedName("externalUrl")
    public final String externalUrl;

    public AttachmentRequest(String name, String description, String type, String externalUrl)
    {
        this.name = name;
        this.description = description;
        this.type = type;
        this.externalUrl = externalUrl;
    }
}
