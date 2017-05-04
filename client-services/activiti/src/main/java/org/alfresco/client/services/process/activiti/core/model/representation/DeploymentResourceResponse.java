package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * DeploymentResourceResponse
 */
public class DeploymentResourceResponse
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("contentUrl")
    private String contentUrl = null;

    @SerializedName("mediaType")
    private String mediaType = null;

    /**
     * Type of resource
     */
    public enum TypeEnum
    {
        @SerializedName("resource") RESOURCE("resource"),

        @SerializedName("processDefinition") PROCESSDEFINITION("processDefinition"),

        @SerializedName("processImage") PROCESSIMAGE("processImage");

        private String value;

        TypeEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    @SerializedName("type")
    private TypeEnum type = null;

    public DeploymentResourceResponse id(String id)
    {
        this.id = id;
        return this;
    }

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
     * Get url
     * 
     * @return url
     **/
    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Get contentUrl
     * 
     * @return contentUrl
     **/
    public String getContentUrl()
    {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl)
    {
        this.contentUrl = contentUrl;
    }

    /**
     * Contains the media-type the resource has. This is resolved using a
     * (pluggable) MediaTypeResolver and contains, by default, a limited number
     * of mime-type mappings.
     * 
     * @return mediaType
     **/
    public String getMediaType()
    {
        return mediaType;
    }

    public void setMediaType(String mediaType)
    {
        this.mediaType = mediaType;
    }

    /**
     * Type of resource
     * 
     * @return type
     **/
    public TypeEnum getType()
    {
        return type;
    }

    public void setType(TypeEnum type)
    {
        this.type = type;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DeploymentResourceResponse deploymentResourceResponse = (DeploymentResourceResponse) o;
        return Objects.equals(this.id, deploymentResourceResponse.id)
                && Objects.equals(this.url, deploymentResourceResponse.url)
                && Objects.equals(this.contentUrl, deploymentResourceResponse.contentUrl)
                && Objects.equals(this.mediaType, deploymentResourceResponse.mediaType)
                && Objects.equals(this.type, deploymentResourceResponse.type);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, url, contentUrl, mediaType, type);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentResourceResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    contentUrl: ").append(toIndentedString(contentUrl)).append("\n");
        sb.append("    mediaType: ").append(toIndentedString(mediaType)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
