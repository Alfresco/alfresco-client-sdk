package org.alfresco.client.services.governance.core.model;

import com.google.gson.annotations.SerializedName;

/**
 * Gets or Sets compliance
 */
public enum RMSiteCompliance
{
    @SerializedName("STANDARD") STANDARD("STANDARD"),

    @SerializedName("DOD5015") DOD5015("DOD5015");

    private String value;

    RMSiteCompliance(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return String.valueOf(value);
    }
}
