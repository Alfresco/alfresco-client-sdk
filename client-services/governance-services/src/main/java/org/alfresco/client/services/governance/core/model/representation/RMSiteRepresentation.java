package org.alfresco.client.services.governance.core.model.representation;

import java.util.Objects;

import org.alfresco.client.services.content.core.model.representation.SiteRepresentation;

import com.google.gson.annotations.SerializedName;

/**
 * RMSite
 */
public class RMSiteRepresentation extends SiteRepresentation
{
    /**
     * Gets or Sets compliance
     */
    public enum ComplianceEnum
    {
        @SerializedName("STANDARD") STANDARD("STANDARD"),

        @SerializedName("DOD5015") DOD5015("DOD5015");

        private String value;

        ComplianceEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    @SerializedName("compliance")
    private ComplianceEnum compliance = null;

    /**
     * Get compliance
     * 
     * @return compliance
     **/
    public ComplianceEnum getCompliance()
    {
        return compliance;
    }

    public void setCompliance(ComplianceEnum compliance)
    {
        this.compliance = compliance;
    }

    /**
     * Get preset
     *
     * @return preset
     **/
    public String getPreset()
    {
        return null;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RMSiteRepresentation rMSite = (RMSiteRepresentation) o;
        return Objects.equals(this.id, rMSite.id) && Objects.equals(this.guid, rMSite.guid)
                && Objects.equals(this.title, rMSite.title) && Objects.equals(this.description, rMSite.description)
                && Objects.equals(this.visibility, rMSite.visibility)
                && Objects.equals(this.compliance, rMSite.compliance) && Objects.equals(this.role, rMSite.role);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, guid, title, description, visibility, compliance, role);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RMSite {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    visibility: ").append(toIndentedString(visibility)).append("\n");
        sb.append("    compliance: ").append(toIndentedString(compliance)).append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
