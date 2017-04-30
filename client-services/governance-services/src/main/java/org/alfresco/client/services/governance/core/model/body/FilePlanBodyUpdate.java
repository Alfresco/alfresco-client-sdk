package org.alfresco.client.services.governance.core.model.body;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * FilePlanBodyUpdate
 */
public class FilePlanBodyUpdate
{
    @SerializedName("name")
    public final String name;

    @SerializedName("properties")
    public final Map<String, Object> properties;

    public FilePlanBodyUpdate(String name, Map<String, Object> properties)
    {
        this.name = name;
        this.properties = properties;
    }
}
