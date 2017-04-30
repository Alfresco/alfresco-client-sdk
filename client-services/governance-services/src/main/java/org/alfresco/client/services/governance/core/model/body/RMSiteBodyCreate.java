package org.alfresco.client.services.governance.core.model.body;

import org.alfresco.client.services.governance.core.model.RMSiteCompliance;

import com.google.gson.annotations.SerializedName;

/**
 * RMSiteBodyCreate
 */
public class RMSiteBodyCreate
{
    @SerializedName("title")
    public final String title;

    @SerializedName("description")
    public final String description;

    @SerializedName("compliance")
    public final RMSiteCompliance compliance;

    public RMSiteBodyCreate(String title, String description, RMSiteCompliance compliance)
    {
        this.title = title;
        this.description = description;
        this.compliance = compliance == null ? RMSiteCompliance.STANDARD : compliance;
    }
}
