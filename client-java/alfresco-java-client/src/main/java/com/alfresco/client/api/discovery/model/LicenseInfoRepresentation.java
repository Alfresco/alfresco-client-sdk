package com.alfresco.client.api.discovery.model;

import java.util.Date;
import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 04/10/2016.
 */
public class LicenseInfoRepresentation extends AbstractRepresentation
{

    @SerializedName("issuedAt")
    private Date issuedAt = null;

    @SerializedName("expiresAt")
    private Date expiresAt = null;

    @SerializedName("remainingDays")
    private Integer remainingDays = null;

    @SerializedName("holder")
    private String holder = null;

    @SerializedName("mode")
    private String mode = null;

    @SerializedName("entitlements")
    private EntitlementsInfoRepresentation entitlements = null;

    /**
     * Get issuedAt
     * 
     * @return issuedAt
     **/
    public Date getIssuedAt()
    {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt)
    {
        this.issuedAt = issuedAt;
    }

    /**
     * Get expiresAt
     * 
     * @return expiresAt
     **/
    public Date getExpiresAt()
    {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt)
    {
        this.expiresAt = expiresAt;
    }

    /**
     * Get remainingDays
     * 
     * @return remainingDays
     **/
    public Integer getRemainingDays()
    {
        return remainingDays;
    }

    public void setRemainingDays(Integer remainingDays)
    {
        this.remainingDays = remainingDays;
    }

    /**
     * Get holder
     * 
     * @return holder
     **/
    public String getHolder()
    {
        return holder;
    }

    public void setHolder(String holder)
    {
        this.holder = holder;
    }

    /**
     * Get mode
     * 
     * @return mode
     **/
    public String getMode()
    {
        return mode;
    }

    public void setMode(String mode)
    {
        this.mode = mode;
    }

    /**
     * Get entitlements
     * 
     * @return entitlements
     **/
    public EntitlementsInfoRepresentation getEntitlements()
    {
        return entitlements;
    }

    public void setEntitlements(EntitlementsInfoRepresentation entitlements)
    {
        this.entitlements = entitlements;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        LicenseInfoRepresentation licenseInfo = (LicenseInfoRepresentation) o;
        return Objects.equals(this.issuedAt, licenseInfo.issuedAt)
                && Objects.equals(this.expiresAt, licenseInfo.expiresAt)
                && Objects.equals(this.remainingDays, licenseInfo.remainingDays)
                && Objects.equals(this.holder, licenseInfo.holder) && Objects.equals(this.mode, licenseInfo.mode)
                && Objects.equals(this.entitlements, licenseInfo.entitlements);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(issuedAt, expiresAt, remainingDays, holder, mode, entitlements);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class LicenseInfo {\n");

        sb.append("    issuedAt: ").append(toIndentedString(issuedAt)).append("\n");
        sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
        sb.append("    remainingDays: ").append(toIndentedString(remainingDays)).append("\n");
        sb.append("    holder: ").append(toIndentedString(holder)).append("\n");
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("    entitlements: ").append(toIndentedString(entitlements)).append("\n");
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
