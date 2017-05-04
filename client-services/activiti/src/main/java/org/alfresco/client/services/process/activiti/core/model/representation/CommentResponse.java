package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Date;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * CommentResponse
 */
public class CommentResponse
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("author")
    private String author = null;

    @SerializedName("message")
    private String message = null;

    @SerializedName("time")
    private Date time = null;

    @SerializedName("taskId")
    private String taskId = null;

    @SerializedName("taskUrl")
    private String taskUrl = null;

    @SerializedName("processInstanceId")
    private String processInstanceId = null;

    @SerializedName("processInstanceUrl")
    private String processInstanceUrl = null;

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
     * Get author
     * 
     * @return author
     **/
    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    /**
     * Get message
     * 
     * @return message
     **/
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
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

    /**
     * Get taskId
     * 
     * @return taskId
     **/
    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
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
     * Get processInstanceId
     * 
     * @return processInstanceId
     **/
    public String getProcessInstanceId()
    {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId)
    {
        this.processInstanceId = processInstanceId;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CommentResponse commentResponse = (CommentResponse) o;
        return Objects.equals(this.id, commentResponse.id) && Objects.equals(this.author, commentResponse.author)
                && Objects.equals(this.message, commentResponse.message)
                && Objects.equals(this.time, commentResponse.time)
                && Objects.equals(this.taskId, commentResponse.taskId)
                && Objects.equals(this.taskUrl, commentResponse.taskUrl)
                && Objects.equals(this.processInstanceId, commentResponse.processInstanceId)
                && Objects.equals(this.processInstanceUrl, commentResponse.processInstanceUrl);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, author, message, time, taskId, taskUrl, processInstanceId, processInstanceUrl);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommentResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    author: ").append(toIndentedString(author)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    time: ").append(toIndentedString(time)).append("\n");
        sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
        sb.append("    taskUrl: ").append(toIndentedString(taskUrl)).append("\n");
        sb.append("    processInstanceId: ").append(toIndentedString(processInstanceId)).append("\n");
        sb.append("    processInstanceUrl: ").append(toIndentedString(processInstanceUrl)).append("\n");
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
