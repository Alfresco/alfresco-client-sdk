package org.alfresco.client.services.process.activiti.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * UserRequest
 */
public class UserRequest
{
    @SerializedName("id")
    public final String id;

    @SerializedName("firstName")
    public final String firstName;

    @SerializedName("lastName")
    public final String lastName;

    @SerializedName("url")
    public final String url;

    @SerializedName("email")
    public final String email;

    @SerializedName("pictureUrl")
    public final String pictureUrl;

    @SerializedName("password")
    public final String password;

    public UserRequest(String id, String firstName, String lastName, String url, String email, String pictureUrl,
            String password)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.url = url;
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.password = password;
    }
}
