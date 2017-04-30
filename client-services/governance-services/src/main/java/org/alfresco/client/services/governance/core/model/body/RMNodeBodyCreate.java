package org.alfresco.client.services.governance.core.model.body;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * RMNodeBodyCreate
 */
public class RMNodeBodyCreate
{
    @SerializedName("name")
    public final String name;

    @SerializedName("nodeType")
    public final String nodeType;

    @SerializedName("aspectNames")
    public final List<String> aspectNames;

    @SerializedName("properties")
    public final Map<String, Object> properties;

    public RMNodeBodyCreate(String name, String nodeType, Map<String, Object> properties)
    {
        this.name = name;
        this.nodeType = nodeType;
        this.aspectNames = null;
        this.properties = properties;
    }

    public RMNodeBodyCreate(String name, String nodeType, List<String> aspectNames, Map<String, Object> properties)
    {
        this.name = name;
        this.nodeType = nodeType;
        this.aspectNames = aspectNames;
        this.properties = properties;
    }
}
