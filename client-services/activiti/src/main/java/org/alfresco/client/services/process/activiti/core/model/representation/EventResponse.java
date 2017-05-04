package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * EventResponse
 */
public class EventResponse
{
    @SerializedName("url")
    private String url = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("action")
    private String action = null;

    @SerializedName("userId")
    private String userId = null;

    @SerializedName("time")
    private Date time = null;

    @SerializedName("taskUrl")
    private String taskUrl = null;

    @SerializedName("processInstanceUrl")
    private String processInstanceUrl = null;

    @SerializedName("message")
    private List<String> message = new ArrayList<String>();

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
     * Get action
     * 
     * @return action
     **/
    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
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
     * Get message
     * 
     * @return message
     **/
    public List<String> getMessage()
    {
        return message;
    }

    public void setMessage(List<String> message)
    {
        this.message = message;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        EventResponse eventResponse = (EventResponse) o;
        return Objects.equals(this.url, eventResponse.url) && Objects.equals(this.id, eventResponse.id)
                && Objects.equals(this.action, eventResponse.action)
                && Objects.equals(this.userId, eventResponse.userId) && Objects.equals(this.time, eventResponse.time)
                && Objects.equals(this.taskUrl, eventResponse.taskUrl)
                && Objects.equals(this.processInstanceUrl, eventResponse.processInstanceUrl)
                && Objects.equals(this.message, eventResponse.message);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(url, id, action, userId, time, taskUrl, processInstanceUrl, message);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class EventResponse {\n");

        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    time: ").append(toIndentedString(time)).append("\n");
        sb.append("    taskUrl: ").append(toIndentedString(taskUrl)).append("\n");
        sb.append("    processInstanceUrl: ").append(toIndentedString(processInstanceUrl)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
