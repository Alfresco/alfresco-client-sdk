package com.alfresco.client.utils.authentication.saml.models;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SamlEnabledRepresentationEntry implements Serializable
{

    @SerializedName("entry")
    @Expose
    private SamlEnabledRepresentation entry;

    public SamlEnabledRepresentation getEntry()
    {
        return entry;
    }

    public void setEntry(SamlEnabledRepresentation entry)
    {
        this.entry = entry;
    }

    @Override
    public int hashCode()
    {
        return entry.hashCode();
    }

    @Override
    public String toString()
    {
        return entry.toString();
    }
}
