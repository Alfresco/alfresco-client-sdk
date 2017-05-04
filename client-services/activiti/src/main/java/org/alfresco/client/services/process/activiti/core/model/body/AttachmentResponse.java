package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.Date;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * AttachmentResponse
 */
public class AttachmentResponse
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("userId")
    private String userId = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("type")
    private String type = null;

    @SerializedName("taskUrl")
    private String taskUrl = null;

    @SerializedName("processInstanceUrl")
    private String processInstanceUrl = null;

    @SerializedName("externalUrl")
    private String externalUrl = null;

    @SerializedName("contentUrl")
    private String contentUrl = null;

    @SerializedName("time")
    private Date time = null;

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
     * Get userId
     * 
     * @return userId
     **/
    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
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
     * Can be any arbitrary value. When a valid formatted media-type (e.g.
     * application/xml, text/plain) is included, the binary content HTTP
     * response content-type will be set the the given value.
     * 
     * @return type
     **/
    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Get taskUrl
     * 
     * @return taskUrl
     **/
    public String getTaskUrl()
    {
        return taskUrl;
    }

    public void setTaskUrl(String taskUrl)
    {
        this.taskUrl = taskUrl;
    }

    /**
     * Get processInstanceUrl
     * 
     * @return processInstanceUrl
     **/
    public String getProcessInstanceUrl()
    {
        return processInstanceUrl;
    }

    public void setProcessInstanceUrl(String processInstanceUrl)
    {
        this.processInstanceUrl = processInstanceUrl;
    }

    /**
     * contentUrl:In case the attachment is a link to an external resource, the
     * externalUrl contains the URL to the external content. If the attachment
     * content is present in the Activiti engine, the contentUrl will contain an
     * URL where the binary content can be streamed from.
     * 
     * @return externalUrl
     **/
    public String getExternalUrl()
    {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl)
    {
        this.externalUrl = externalUrl;
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
     * Get time
     * 
     * @return time
     **/
    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AttachmentResponse attachmentResponse = (AttachmentResponse) o;
        return Objects.equals(this.id, attachmentResponse.id) && Objects.equals(this.url, attachmentResponse.url)
                && Objects.equals(this.name, attachmentResponse.name)
                && Objects.equals(this.userId, attachmentResponse.userId)
                && Objects.equals(this.description, attachmentResponse.description)
                && Objects.equals(this.type, attachmentResponse.type)
                && Objects.equals(this.taskUrl, attachmentResponse.taskUrl)
                && Objects.equals(this.processInstanceUrl, attachmentResponse.processInstanceUrl)
                && Objects.equals(this.externalUrl, attachmentResponse.externalUrl)
                && Objects.equals(this.contentUrl, attachmentResponse.contentUrl)
                && Objects.equals(this.time, attachmentResponse.time);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, url, name, userId, description, type, taskUrl, processInstanceUrl, externalUrl,
                contentUrl, time);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class AttachmentResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    taskUrl: ").append(toIndentedString(taskUrl)).append("\n");
        sb.append("    processInstanceUrl: ").append(toIndentedString(processInstanceUrl)).append("\n");
        sb.append("    externalUrl: ").append(toIndentedString(externalUrl)).append("\n");
        sb.append("    contentUrl: ").append(toIndentedString(contentUrl)).append("\n");
        sb.append("    time: ").append(toIndentedString(time)).append("\n");
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
