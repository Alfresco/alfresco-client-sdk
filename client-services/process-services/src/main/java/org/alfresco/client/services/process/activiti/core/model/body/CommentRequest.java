package org.alfresco.client.services.process.activiti.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * CommentRequest
 */
public class CommentRequest
{
    @SerializedName("id")
    public final String id;

    @SerializedName("url")
    public final String url;

    @SerializedName("author")
    public final String author;

    @SerializedName("message")
    public final String message;

    @SerializedName("type")
    public final String type;

    @SerializedName("saveProcessInstanceId")
    public final Boolean saveProcessInstanceId;

    public CommentRequest(String id, String url, String author, String message, String type,
            Boolean saveProcessInstanceId)
    {
        this.id = id;
        this.url = url;
        this.author = author;
        this.message = message;
        this.type = type;
        this.saveProcessInstanceId = saveProcessInstanceId;
    }
}
