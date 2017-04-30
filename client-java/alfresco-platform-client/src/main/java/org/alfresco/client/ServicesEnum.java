package org.alfresco.client;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 01/05/2017.
 */
public enum ServicesEnum
{
    @SerializedName("CONTENT_SERVICES") CONTENT_SERVICES("CONTENT_SERVICES"),

    @SerializedName("PROCESS_SERVICES") PROCESS_SERVICES("PROCESS_SERVICES"),

    @SerializedName("GOVERNANCE_SERVICES") GOVERNANCE_SERVICES("GOVERNANCE_SERVICES");

    private String value;

    ServicesEnum(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return String.valueOf(value);
    }
}
