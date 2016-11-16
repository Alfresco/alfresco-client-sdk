
package com.alfresco.client.api.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * PersonBodyUpdate
 */
public class PersonBodyUpdate
{
    @SerializedName("firstName")
    public final String firstName;

    @SerializedName("lastName")
    public final String lastName;

    @SerializedName("description")
    public final String description;

    @SerializedName("email")
    public final String email;

    @SerializedName("skypeId")
    public final String skypeId;

    @SerializedName("googleId")
    public final String googleId;

    @SerializedName("instantMessageId")
    public final String instantMessageId;

    @SerializedName("jobTitle")
    public final String jobTitle;

    @SerializedName("location")
    public final String location;

    @SerializedName("company")
    public final CompanyBody company;

    @SerializedName("mobile")
    public final String mobile;

    @SerializedName("telephone")
    public final String telephone;

    @SerializedName("userStatus")
    public final String userStatus;

    @SerializedName("enabled")
    public final Boolean enabled;

    @SerializedName("emailNotificationsEnabled")
    public final Boolean emailNotificationsEnabled;

    @SerializedName("password")
    public final String password;

    public PersonBodyUpdate(String firstName, String lastName, String description, String email,
            String skypeId, String googleId, String instantMessageId, String jobTitle, String location,
            CompanyBody company, String mobile, String telephone, String userStatus, Boolean enabled,
            Boolean emailNotificationsEnabled, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.email = email;
        this.skypeId = skypeId;
        this.googleId = googleId;
        this.instantMessageId = instantMessageId;
        this.jobTitle = jobTitle;
        this.location = location;
        this.company = company;
        this.mobile = mobile;
        this.telephone = telephone;
        this.userStatus = userStatus;
        this.enabled = enabled;
        this.emailNotificationsEnabled = emailNotificationsEnabled;
        this.password = password;
    }
}
