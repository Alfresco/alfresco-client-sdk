package com.alfresco.client.api.discovery.model;

import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 04/10/2016.
 */
public class VersionInfoRepresentation extends AbstractRepresentation
{

    @SerializedName("major")
    private String major = null;

    @SerializedName("minor")
    private String minor = null;

    @SerializedName("patch")
    private String patch = null;

    @SerializedName("hotfix")
    private String hotfix = null;

    @SerializedName("schema")
    private Integer schema = null;

    @SerializedName("label")
    private String label = null;

    @SerializedName("display")
    private String display = null;

    /**
     * Get major
     * 
     * @return major
     **/
    public String getMajor()
    {
        return major;
    }

    public void setMajor(String major)
    {
        this.major = major;
    }

    /**
     * Get minor
     * 
     * @return minor
     **/
    public String getMinor()
    {
        return minor;
    }

    public void setMinor(String minor)
    {
        this.minor = minor;
    }

    /**
     * Get patch
     * 
     * @return patch
     **/
    public String getPatch()
    {
        return patch;
    }

    public void setPatch(String patch)
    {
        this.patch = patch;
    }

    /**
     * Get hotfix
     * 
     * @return hotfix
     **/
    public String getHotfix()
    {
        return hotfix;
    }

    public void setHotfix(String hotfix)
    {
        this.hotfix = hotfix;
    }

    /**
     * Get schema
     * 
     * @return schema
     **/
    public Integer getSchema()
    {
        return schema;
    }

    public void setSchema(Integer schema)
    {
        this.schema = schema;
    }

    /**
     * Get label
     * 
     * @return label
     **/
    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    /**
     * Get display
     * 
     * @return display
     **/
    public String getDisplay()
    {
        return display;
    }

    public void setDisplay(String display)
    {
        this.display = display;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        VersionInfoRepresentation versionInfo = (VersionInfoRepresentation) o;
        return Objects.equals(this.major, versionInfo.major) && Objects.equals(this.minor, versionInfo.minor)
                && Objects.equals(this.patch, versionInfo.patch) && Objects.equals(this.hotfix, versionInfo.hotfix)
                && Objects.equals(this.schema, versionInfo.schema) && Objects.equals(this.label, versionInfo.label)
                && Objects.equals(this.display, versionInfo.display);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(major, minor, patch, hotfix, schema, label, display);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class VersionInfo {\n");

        sb.append("    major: ").append(toIndentedString(major)).append("\n");
        sb.append("    minor: ").append(toIndentedString(minor)).append("\n");
        sb.append("    patch: ").append(toIndentedString(patch)).append("\n");
        sb.append("    hotfix: ").append(toIndentedString(hotfix)).append("\n");
        sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    display: ").append(toIndentedString(display)).append("\n");
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
