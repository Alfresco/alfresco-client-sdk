package com.alfresco.client.api.discovery.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 04/10/2016.
 */
public class RepositoryInfoRepresentation extends AbstractRepresentation
{

    @SerializedName("edition")
    private String edition = null;

    @SerializedName("version")
    private VersionInfoRepresentation version = null;

    @SerializedName("status")
    private StatusInfoRepresentation status = null;

    @SerializedName("license")
    private LicenseInfoRepresentation license = null;

    @SerializedName("modules")
    private List<ModuleInfoRepresentation> modules = new ArrayList<>();

    /**
     * Get edition
     * 
     * @return edition
     **/
    public String getEdition()
    {
        return edition;
    }

    public void setEdition(String edition)
    {
        this.edition = edition;
    }

    /**
     * Get version
     * 
     * @return version
     **/
    public VersionInfoRepresentation getVersion()
    {
        return version;
    }

    public void setVersion(VersionInfoRepresentation version)
    {
        this.version = version;
    }

    /**
     * Get status
     * 
     * @return status
     **/
    public StatusInfoRepresentation getStatus()
    {
        return status;
    }

    public void setStatus(StatusInfoRepresentation status)
    {
        this.status = status;
    }

    /**
     * Get license
     * 
     * @return license
     **/
    public LicenseInfoRepresentation getLicense()
    {
        return license;
    }

    public void setLicense(LicenseInfoRepresentation license)
    {
        this.license = license;
    }

    /**
     * Get modules
     * 
     * @return modules
     **/
    public List<ModuleInfoRepresentation> getModules()
    {
        return modules;
    }

    public void setModules(List<ModuleInfoRepresentation> modules)
    {
        this.modules = modules;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RepositoryInfoRepresentation repositoryInfo = (RepositoryInfoRepresentation) o;
        return Objects.equals(this.edition, repositoryInfo.edition)
                && Objects.equals(this.version, repositoryInfo.version)
                && Objects.equals(this.status, repositoryInfo.status)
                && Objects.equals(this.license, repositoryInfo.license)
                && Objects.equals(this.modules, repositoryInfo.modules);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(edition, version, status, license, modules);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RepositoryInfo {\n");

        sb.append("    edition: ").append(toIndentedString(edition)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    license: ").append(toIndentedString(license)).append("\n");
        sb.append("    modules: ").append(toIndentedString(modules)).append("\n");
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
