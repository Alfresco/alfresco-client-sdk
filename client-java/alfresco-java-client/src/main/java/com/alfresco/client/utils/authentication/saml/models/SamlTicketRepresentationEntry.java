package com.alfresco.client.utils.authentication.saml.models;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SamlTicketRepresentationEntry implements Serializable
{

    @SerializedName("entry")
    @Expose
    private SamlTicketRepresentation entry;

    public SamlTicketRepresentation getEntry()
    {
        return entry;
    }

    public void setEntry(SamlTicketRepresentation entry)
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
