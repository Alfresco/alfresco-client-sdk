package com.alfresco.client.utils.authentication.saml.models;

import java.io.Serializable;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SamlTicketRepresentation implements Serializable
{

    @SerializedName("ticket")
    @Expose
    private String ticket;

    @SerializedName("userId")
    @Expose
    private String userId;

    public String getTicket()
    {
        return ticket;
    }

    public void setTicket(String ticket)
    {
        this.ticket = ticket;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(ticket, userId);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class SamlTicketRepresentation {\n");
        sb.append("    ticket: ").append(toIndentedString(ticket)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o)
    {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }
}
