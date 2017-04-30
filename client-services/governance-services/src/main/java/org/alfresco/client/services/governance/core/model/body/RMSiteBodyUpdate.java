package org.alfresco.client.services.governance.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * RMSiteBodyUpdate
 */
public class RMSiteBodyUpdate
{
    @SerializedName("title")
    public final String title;

    @SerializedName("description")
    public final String description;

    public RMSiteBodyUpdate(String title, String description)
    {
        this.title = title;
        this.description = description;
    }
}
