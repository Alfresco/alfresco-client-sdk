package org.alfresco.client.services.process.activiti.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * GroupRequest
 */
public class GroupRequest
{
    @SerializedName("id")
    public final String id;

    @SerializedName("url")
    public final String url;

    @SerializedName("name")
    public final String name;

    @SerializedName("type")
    public final String type;

    @SerializedName("nameChanged")
    public final Boolean nameChanged;

    @SerializedName("typeChanged")
    public final Boolean typeChanged;

    public GroupRequest(String id, String url, String name, String type, Boolean nameChanged, Boolean typeChanged)
    {
        this.id = id;
        this.url = url;
        this.name = name;
        this.type = type;
        this.nameChanged = nameChanged;
        this.typeChanged = typeChanged;
    }
}
