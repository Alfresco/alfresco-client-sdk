package org.alfresco.client.services.governance.core.model.body;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * UnfiledRecordContainerBodyUpdate
 */
public class UnfiledContainerBodyUpdate
{
    @SerializedName("name")
    public final String name;

    @SerializedName("properties")
    public final Map<String, String> properties;

    public UnfiledContainerBodyUpdate(String name, Map<String, String> properties)
    {
        this.name = name;
        this.properties = properties;
    }
}
