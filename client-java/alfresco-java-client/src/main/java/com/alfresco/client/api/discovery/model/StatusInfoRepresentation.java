package com.alfresco.client.api.discovery.model;

import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 04/10/2016.
 */
public class StatusInfoRepresentation extends AbstractRepresentation
{

    @SerializedName("isReadOnly")
    private Boolean isReadOnly = false;

    @SerializedName("isAuditEnabled")
    private Boolean isAuditEnabled = null;

    @SerializedName("isQuickShareEnabled")
    private Boolean isQuickShareEnabled = null;

    /**
     * Get isReadOnly
     * 
     * @return isReadOnly
     **/
    public Boolean getIsReadOnly()
    {
        return isReadOnly;
    }

    public void setIsReadOnly(Boolean isReadOnly)
    {
        this.isReadOnly = isReadOnly;
    }

    /**
     * Get isAuditEnabled
     * 
     * @return isAuditEnabled
     **/
    public Boolean isAuditEnabled()
    {
        return isAuditEnabled;
    }

    public void setIsAuditEnabled(Boolean isAuditEnabled)
    {
        this.isAuditEnabled = isAuditEnabled;
    }

    /**
     * Get isQuickShareEnabled
     * 
     * @return isQuickShareEnabled
     **/
    public Boolean getIsQuickShareEnabled()
    {
        return isQuickShareEnabled;
    }

    public void setIsQuickShareEnabled(Boolean isQuickShareEnabled)
    {
        this.isQuickShareEnabled = isQuickShareEnabled;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        StatusInfoRepresentation statusInfo = (StatusInfoRepresentation) o;
        return Objects.equals(this.isReadOnly, statusInfo.isReadOnly)
                && Objects.equals(this.isAuditEnabled, statusInfo.isAuditEnabled)
                && Objects.equals(this.isQuickShareEnabled, statusInfo.isQuickShareEnabled);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(isReadOnly, isAuditEnabled, isQuickShareEnabled);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class StatusInfo {\n");

        sb.append("    isReadOnly: ").append(toIndentedString(isReadOnly)).append("\n");
        sb.append("    isAuditEnabled: ").append(toIndentedString(isAuditEnabled)).append("\n");
        sb.append("    isQuickShareEnabled: ").append(toIndentedString(isQuickShareEnabled)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o)
    {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
