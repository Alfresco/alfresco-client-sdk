package com.alfresco.client.api.discovery.model;

import java.util.Date;
import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 04/10/2016.
 */
public class ModuleInfoRepresentation extends AbstractRepresentation
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("version")
    private String version = null;

    @SerializedName("installDate")
    private Date installDate = null;

    @SerializedName("installState")
    private String installState = null;

    @SerializedName("versionMin")
    private String versionMin = null;

    @SerializedName("versionMax")
    private String versionMax = null;

    /**
     * Get id
     * 
     * @return id
     **/
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * Get title
     * 
     * @return title
     **/
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Get description
     * 
     * @return description
     **/
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Get version
     * 
     * @return version
     **/
    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    /**
     * Get installDate
     * 
     * @return installDate
     **/
    public Date getInstallDate()
    {
        return installDate;
    }

    public void setInstallDate(Date installDate)
    {
        this.installDate = installDate;
    }

    /**
     * Get installState
     * 
     * @return installState
     **/
    public String getInstallState()
    {
        return installState;
    }

    public void setInstallState(String installState)
    {
        this.installState = installState;
    }

    /**
     * Get versionMin
     * 
     * @return versionMin
     **/
    public String getVersionMin()
    {
        return versionMin;
    }

    public void setVersionMin(String versionMin)
    {
        this.versionMin = versionMin;
    }

    /**
     * Get versionMax
     * 
     * @return versionMax
     **/
    public String getVersionMax()
    {
        return versionMax;
    }

    public void setVersionMax(String versionMax)
    {
        this.versionMax = versionMax;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ModuleInfoRepresentation moduleInfo = (ModuleInfoRepresentation) o;
        return Objects.equals(this.id, moduleInfo.id) && Objects.equals(this.title, moduleInfo.title)
                && Objects.equals(this.description, moduleInfo.description)
                && Objects.equals(this.version, moduleInfo.version)
                && Objects.equals(this.installDate, moduleInfo.installDate)
                && Objects.equals(this.installState, moduleInfo.installState)
                && Objects.equals(this.versionMin, moduleInfo.versionMin)
                && Objects.equals(this.versionMax, moduleInfo.versionMax);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, title, description, version, installDate, installState, versionMin, versionMax);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModuleInfo {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    installDate: ").append(toIndentedString(installDate)).append("\n");
        sb.append("    installState: ").append(toIndentedString(installState)).append("\n");
        sb.append("    versionMin: ").append(toIndentedString(versionMin)).append("\n");
        sb.append("    versionMax: ").append(toIndentedString(versionMax)).append("\n");
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
