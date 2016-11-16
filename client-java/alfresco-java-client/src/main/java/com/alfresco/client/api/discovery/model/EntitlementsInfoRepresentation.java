package com.alfresco.client.api.discovery.model;

import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 04/10/2016.
 */
public class EntitlementsInfoRepresentation extends AbstractRepresentation
{
    @SerializedName("maxUsers")
    private Long maxUsers = null;

    @SerializedName("maxDocs")
    private Long maxDocs = null;

    @SerializedName("isClusterEnabled")
    private Boolean isClusterEnabled = false;

    @SerializedName("isCryptodocEnabled")
    private Boolean isCryptodocEnabled = false;

    /**
     * Get maxUsers
     * 
     * @return maxUsers
     **/
    public Long getMaxUsers()
    {
        return maxUsers;
    }

    public void setMaxUsers(Long maxUsers)
    {
        this.maxUsers = maxUsers;
    }

    /**
     * Get maxDocs
     * 
     * @return maxDocs
     **/
    public Long getMaxDocs()
    {
        return maxDocs;
    }

    public void setMaxDocs(Long maxDocs)
    {
        this.maxDocs = maxDocs;
    }

    /**
     * Get isClusterEnabled
     * 
     * @return isClusterEnabled
     **/
    public Boolean getIsClusterEnabled()
    {
        return isClusterEnabled;
    }

    public void setIsClusterEnabled(Boolean isClusterEnabled)
    {
        this.isClusterEnabled = isClusterEnabled;
    }

    /**
     * Get isCryptodocEnabled
     * 
     * @return isCryptodocEnabled
     **/
    public Boolean getIsCryptodocEnabled()
    {
        return isCryptodocEnabled;
    }

    public void setIsCryptodocEnabled(Boolean isCryptodocEnabled)
    {
        this.isCryptodocEnabled = isCryptodocEnabled;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        EntitlementsInfoRepresentation entitlementsInfo = (EntitlementsInfoRepresentation) o;
        return Objects.equals(this.maxUsers, entitlementsInfo.maxUsers)
                && Objects.equals(this.maxDocs, entitlementsInfo.maxDocs)
                && Objects.equals(this.isClusterEnabled, entitlementsInfo.isClusterEnabled)
                && Objects.equals(this.isCryptodocEnabled, entitlementsInfo.isCryptodocEnabled);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(maxUsers, maxDocs, isClusterEnabled, isCryptodocEnabled);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class EntitlementsInfo {\n");

        sb.append("    maxUsers: ").append(toIndentedString(maxUsers)).append("\n");
        sb.append("    maxDocs: ").append(toIndentedString(maxDocs)).append("\n");
        sb.append("    isClusterEnabled: ").append(toIndentedString(isClusterEnabled)).append("\n");
        sb.append("    isCryptodocEnabled: ").append(toIndentedString(isCryptodocEnabled)).append("\n");
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
