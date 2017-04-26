
package com.alfresco.client.api.core.model.body;

import java.util.*;

import com.google.gson.annotations.SerializedName;

/**
 * PersonBodyUpdate
 */
public class PersonBodyUpdate
{
    @SerializedName("firstName")
    private String firstName = null;

    @SerializedName("lastName")
    private String lastName = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("email")
    private String email = null;

    @SerializedName("skypeId")
    private String skypeId = null;

    @SerializedName("googleId")
    private String googleId = null;

    @SerializedName("instantMessageId")
    private String instantMessageId = null;

    @SerializedName("jobTitle")
    private String jobTitle = null;

    @SerializedName("location")
    private String location = null;

    @SerializedName("company")
    private CompanyBody company = null;

    @SerializedName("mobile")
    private String mobile = null;

    @SerializedName("telephone")
    private String telephone = null;

    @SerializedName("userStatus")
    private String userStatus = null;

    @SerializedName("enabled")
    private Boolean enabled = null;

    @SerializedName("emailNotificationsEnabled")
    private Boolean emailNotificationsEnabled = null;

    @SerializedName("password")
    private String password = null;

    @SerializedName("oldPassword")
    private String oldPassword = null;

    @SerializedName("aspectNames")
    private List<String> aspectNames = new ArrayList<String>();

    @SerializedName("properties")
    private Map<String, String> properties = new HashMap<String, String>();

    public PersonBodyUpdate firstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    /**
     * Get firstName
     * 
     * @return firstName
     **/
    public String getFirstName()
    {
        return firstName;
    }

    public PersonBodyUpdate lastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     * 
     * @return lastName
     **/
    public String getLastName()
    {
        return lastName;
    }

    public PersonBodyUpdate description(String description)
    {
        this.description = description;
        return this;
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

    public PersonBodyUpdate email(String email)
    {
        this.email = email;
        return this;
    }

    /**
     * Get email
     * 
     * @return email
     **/
    public String getEmail()
    {
        return email;
    }

    public PersonBodyUpdate skypeId(String skypeId)
    {
        this.skypeId = skypeId;
        return this;
    }

    /**
     * Get skypeId
     * 
     * @return skypeId
     **/
    public String getSkypeId()
    {
        return skypeId;
    }

    public PersonBodyUpdate googleId(String googleId)
    {
        this.googleId = googleId;
        return this;
    }

    /**
     * Get googleId
     * 
     * @return googleId
     **/
    public String getGoogleId()
    {
        return googleId;
    }

    public PersonBodyUpdate instantMessageId(String instantMessageId)
    {
        this.instantMessageId = instantMessageId;
        return this;
    }

    /**
     * Get instantMessageId
     * 
     * @return instantMessageId
     **/
    public String getInstantMessageId()
    {
        return instantMessageId;
    }

    public PersonBodyUpdate jobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
        return this;
    }

    /**
     * Get jobTitle
     * 
     * @return jobTitle
     **/
    public String getJobTitle()
    {
        return jobTitle;
    }

    public PersonBodyUpdate location(String location)
    {
        this.location = location;
        return this;
    }

    /**
     * Get location
     * 
     * @return location
     **/
    public String getLocation()
    {
        return location;
    }

    public PersonBodyUpdate company(CompanyBody company)
    {
        this.company = company;
        return this;
    }

    /**
     * Get company
     * 
     * @return company
     **/
    public CompanyBody getCompany()
    {
        return company;
    }

    public PersonBodyUpdate mobile(String mobile)
    {
        this.mobile = mobile;
        return this;
    }

    /**
     * Get mobile
     * 
     * @return mobile
     **/
    public String getMobile()
    {
        return mobile;
    }

    public PersonBodyUpdate telephone(String telephone)
    {
        this.telephone = telephone;
        return this;
    }

    /**
     * Get telephone
     * 
     * @return telephone
     **/
    public String getTelephone()
    {
        return telephone;
    }

    public PersonBodyUpdate userStatus(String userStatus)
    {
        this.userStatus = userStatus;
        return this;
    }

    /**
     * Get userStatus
     * 
     * @return userStatus
     **/
    public String getUserStatus()
    {
        return userStatus;
    }

    public PersonBodyUpdate enabled(Boolean enabled)
    {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get enabled
     * 
     * @return enabled
     **/
    public Boolean getEnabled()
    {
        return enabled;
    }

    public PersonBodyUpdate emailNotificationsEnabled(Boolean emailNotificationsEnabled)
    {
        this.emailNotificationsEnabled = emailNotificationsEnabled;
        return this;
    }

    /**
     * Get emailNotificationsEnabled
     * 
     * @return emailNotificationsEnabled
     **/
    public Boolean getEmailNotificationsEnabled()
    {
        return emailNotificationsEnabled;
    }

    public PersonBodyUpdate password(String password)
    {
        this.password = password;
        return this;
    }

    /**
     * Get password
     * 
     * @return password
     **/
    public String getPassword()
    {
        return password;
    }

    public PersonBodyUpdate oldPassword(String oldPassword)
    {
        this.oldPassword = oldPassword;
        return this;
    }

    /**
     * Get oldPassword
     * 
     * @return oldPassword
     **/
    public String getOldPassword()
    {
        return oldPassword;
    }

    public PersonBodyUpdate aspectNames(List<String> aspectNames)
    {
        this.aspectNames = aspectNames;
        return this;
    }

    public PersonBodyUpdate addAspectNamesItem(String aspectNamesItem)
    {
        this.aspectNames.add(aspectNamesItem);
        return this;
    }

    /**
     * Get aspectNames
     * 
     * @return aspectNames
     **/
    public List<String> getAspectNames()
    {
        return aspectNames;
    }

    public PersonBodyUpdate properties(Map<String, String> properties)
    {
        this.properties = properties;
        return this;
    }

    public PersonBodyUpdate putPropertiesItem(String key, String propertiesItem)
    {
        this.properties.put(key, propertiesItem);
        return this;
    }

    /**
     * Get properties
     * 
     * @return properties
     **/
    public Map<String, String> getProperties()
    {
        return properties;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PersonBodyUpdate personBodyUpdate = (PersonBodyUpdate) o;
        return Objects.equals(this.firstName, personBodyUpdate.firstName)
                && Objects.equals(this.lastName, personBodyUpdate.lastName)
                && Objects.equals(this.description, personBodyUpdate.description)
                && Objects.equals(this.email, personBodyUpdate.email)
                && Objects.equals(this.skypeId, personBodyUpdate.skypeId)
                && Objects.equals(this.googleId, personBodyUpdate.googleId)
                && Objects.equals(this.instantMessageId, personBodyUpdate.instantMessageId)
                && Objects.equals(this.jobTitle, personBodyUpdate.jobTitle)
                && Objects.equals(this.location, personBodyUpdate.location)
                && Objects.equals(this.company, personBodyUpdate.company)
                && Objects.equals(this.mobile, personBodyUpdate.mobile)
                && Objects.equals(this.telephone, personBodyUpdate.telephone)
                && Objects.equals(this.userStatus, personBodyUpdate.userStatus)
                && Objects.equals(this.enabled, personBodyUpdate.enabled)
                && Objects.equals(this.emailNotificationsEnabled, personBodyUpdate.emailNotificationsEnabled)
                && Objects.equals(this.password, personBodyUpdate.password)
                && Objects.equals(this.oldPassword, personBodyUpdate.oldPassword)
                && Objects.equals(this.aspectNames, personBodyUpdate.aspectNames)
                && Objects.equals(this.properties, personBodyUpdate.properties);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(firstName, lastName, description, email, skypeId, googleId, instantMessageId, jobTitle,
                location, company, mobile, telephone, userStatus, enabled, emailNotificationsEnabled, password,
                oldPassword, aspectNames, properties);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class PersonBodyUpdate {\n");

        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    skypeId: ").append(toIndentedString(skypeId)).append("\n");
        sb.append("    googleId: ").append(toIndentedString(googleId)).append("\n");
        sb.append("    instantMessageId: ").append(toIndentedString(instantMessageId)).append("\n");
        sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    company: ").append(toIndentedString(company)).append("\n");
        sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
        sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
        sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    emailNotificationsEnabled: ").append(toIndentedString(emailNotificationsEnabled)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    oldPassword: ").append(toIndentedString(oldPassword)).append("\n");
        sb.append("    aspectNames: ").append(toIndentedString(aspectNames)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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
