package org.alfresco.client.services.process.activiti.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * ModelRequest
 */
public class ModelRequest
{
    @SerializedName("name")
    public final String name;

    @SerializedName("key")
    public final String key;

    @SerializedName("category")
    public final String category;

    @SerializedName("version")
    public final Integer version;

    @SerializedName("metaInfo")
    public final String metaInfo;

    @SerializedName("deploymentId")
    public final String deploymentId;

    @SerializedName("tenantId")
    public final String tenantId;

    public ModelRequest(String name, String key, String category, Integer version, String metaInfo, String deploymentId,
            String tenantId)
    {
        this.name = name;
        this.key = key;
        this.category = category;
        this.version = version;
        this.metaInfo = metaInfo;
        this.deploymentId = deploymentId;
        this.tenantId = tenantId;
    }
}
