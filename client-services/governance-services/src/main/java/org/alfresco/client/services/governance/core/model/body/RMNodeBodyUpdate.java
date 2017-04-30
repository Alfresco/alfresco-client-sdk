package org.alfresco.client.services.governance.core.model.body;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * FilePlanComponentBodyUpdate
 */
public class RMNodeBodyUpdate
{
    @SerializedName("name")
    public final String name;

    @SerializedName("aspectNames")
    public final List<String> aspectNames;

    @SerializedName("properties")
    public final Map<String, Object> properties;

    public RMNodeBodyUpdate(String name)
    {
        this.name = name;
        this.aspectNames = null;
        this.properties = null;
    }

    public RMNodeBodyUpdate(String name, Map<String, Object> properties)
    {
        this.name = name;
        this.aspectNames = null;
        this.properties = properties;
    }

    public RMNodeBodyUpdate(String name, List<String> aspectNames, Map<String, Object> properties)
    {
        this.name = name;
        this.aspectNames = aspectNames;
        this.properties = properties;
    }
}
