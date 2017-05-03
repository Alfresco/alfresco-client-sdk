package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * ProcessEngineInfoResponse
 */
public class ProcessEngineInfoResponse
{
    @SerializedName("name")
    private String name = null;

    @SerializedName("resourceUrl")
    private String resourceUrl = null;

    @SerializedName("exception")
    private String exception = null;

    @SerializedName("version")
    private String version = null;

    public ProcessEngineInfoResponse name(String name)
    {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * 
     * @return name
     **/
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get resourceUrl
     * 
     * @return resourceUrl
     **/
    public String getResourceUrl()
    {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl)
    {
        this.resourceUrl = resourceUrl;
    }

    /**
     * Get exception
     * 
     * @return exception
     **/
    public String getException()
    {
        return exception;
    }

    public void setException(String exception)
    {
        this.exception = exception;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ProcessEngineInfoResponse processEngineInfoResponse = (ProcessEngineInfoResponse) o;
        return Objects.equals(this.name, processEngineInfoResponse.name)
                && Objects.equals(this.resourceUrl, processEngineInfoResponse.resourceUrl)
                && Objects.equals(this.exception, processEngineInfoResponse.exception)
                && Objects.equals(this.version, processEngineInfoResponse.version);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, resourceUrl, exception, version);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessEngineInfoResponse {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    resourceUrl: ").append(toIndentedString(resourceUrl)).append("\n");
        sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
