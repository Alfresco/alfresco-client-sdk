package org.alfresco.client.services.governance.core.model.body;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * UnfiledRecordFolderBodyUpdate
 */
public class UnfiledRecordFolderBodyUpdate
{
    @SerializedName("name")
    public final String name;

    @SerializedName("properties")
    public final Map<String, Object> properties;

    public UnfiledRecordFolderBodyUpdate(String name, Map<String, Object> properties)
    {
        this.name = name;
        this.properties = properties;
    }
}
