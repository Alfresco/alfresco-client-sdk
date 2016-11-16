package com.alfresco.client.utils.authentication.saml.models;

import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SamlEnabledRepresentation
{

    @SerializedName("isSamlEnabled")
    @Expose
    private Boolean isSamlEnabled;

    @SerializedName("isSamlEnforced")
    @Expose
    private Boolean isSamlEnforced;

    @SerializedName("idpDescription")
    @Expose
    private String idpDescription;

    @SerializedName("tenantDomain")
    @Expose
    private String tenantDomain;

    /**
     * @return The isSamlEnabled
     */
    public Boolean getIsSamlEnabled()
    {
        return isSamlEnabled;
    }

    /**
     * @param isSamlEnabled The isSamlEnabled
     */
    public void setIsSamlEnabled(Boolean isSamlEnabled)
    {
        this.isSamlEnabled = isSamlEnabled;
    }

    /**
     * @return The isSamlEnforced
     */
    public Boolean getIsSamlEnforced()
    {
        return isSamlEnforced;
    }

    /**
     * @param isSamlEnforced The isSamlEnforced
     */
    public void setIsSamlEnforced(Boolean isSamlEnforced)
    {
        this.isSamlEnforced = isSamlEnforced;
    }

    /**
     * @return The idpDescription
     */
    public String getIdpDescription()
    {
        return idpDescription;
    }

    /**
     * @param idpDescription The idpDescription
     */
    public void setIdpDescription(String idpDescription)
    {
        this.idpDescription = idpDescription;
    }

    /**
     * @return The tenantDomain
     */
    public String getTenantDomain()
    {
        return tenantDomain;
    }

    /**
     * @param tenantDomain The tenantDomain
     */
    public void setTenantDomain(String tenantDomain)
    {
        this.tenantDomain = tenantDomain;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(isSamlEnabled, isSamlEnforced, idpDescription, tenantDomain);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class SAMLEnabledRepresentation {\n");
        sb.append("    isSamlEnabled: ").append(toIndentedString(isSamlEnabled)).append("\n");
        sb.append("    isSamlEnforced: ").append(toIndentedString(isSamlEnforced)).append("\n");
        sb.append("    idpDescription: ").append(toIndentedString(idpDescription)).append("\n");
        sb.append("    tenantDomain: ").append(toIndentedString(tenantDomain)).append("\n");
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
