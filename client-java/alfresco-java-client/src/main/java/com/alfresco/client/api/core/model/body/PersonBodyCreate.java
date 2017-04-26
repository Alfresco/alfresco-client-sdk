package com.alfresco.client.api.core.model.body;

import java.util.*;

import com.google.gson.annotations.SerializedName;

/**
 * PersonBodyCreate
 */
public class PersonBodyCreate
{
    @SerializedName("id")
    private String id = null;

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
    private Boolean enabled = true;

    @SerializedName("emailNotificationsEnabled")
    private Boolean emailNotificationsEnabled = true;

    @SerializedName("password")
    private String password = null;

    @SerializedName("aspectNames")
    private List<String> aspectNames = new ArrayList<>();

    @SerializedName("properties")
    private Map<String, String> properties = new HashMap<>();

    public PersonBodyCreate(String id){
        this.id = id;
    }


    public PersonBodyCreate(String id, String firstName, String email, Boolean enabled)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = null;
        this.description = null;
        this.email = email;
        this.skypeId = null;
        this.googleId = null;
        this.instantMessageId = null;
        this.jobTitle = null;
        this.location = null;
        this.company = null;
        this.mobile = null;
        this.telephone = null;
        this.userStatus = null;
        this.enabled = (enabled == null) ? true : enabled;
        this.emailNotificationsEnabled = null;
        this.password = null;
    }

    public PersonBodyCreate id(String id)
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

    public PersonBodyCreate firstName(String firstName)
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

    public PersonBodyCreate lastName(String lastName)
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

    public PersonBodyCreate description(String description)
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

    public PersonBodyCreate email(String email)
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

    public PersonBodyCreate skypeId(String skypeId)
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

    public PersonBodyCreate googleId(String googleId)
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

    public PersonBodyCreate instantMessageId(String instantMessageId)
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

    public PersonBodyCreate jobTitle(String jobTitle)
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

    public PersonBodyCreate location(String location)
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

    public PersonBodyCreate company(CompanyBody company)
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

    public PersonBodyCreate mobile(String mobile)
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

    public PersonBodyCreate telephone(String telephone)
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

    public PersonBodyCreate userStatus(String userStatus)
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

    public PersonBodyCreate enabled(Boolean enabled)
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

    public PersonBodyCreate emailNotificationsEnabled(Boolean emailNotificationsEnabled)
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

    public PersonBodyCreate password(String password)
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

    public PersonBodyCreate aspectNames(List<String> aspectNames)
    {
        this.aspectNames = aspectNames;
        return this;
    }

    public PersonBodyCreate addAspectNamesItem(String aspectNamesItem)
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

    public PersonBodyCreate properties(Map<String, String> properties)
    {
        this.properties = properties;
        return this;
    }

    public PersonBodyCreate putPropertiesItem(String key, String propertiesItem)
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
        PersonBodyCreate personBodyCreate = (PersonBodyCreate) o;
        return Objects.equals(this.id, personBodyCreate.id)
                && Objects.equals(this.firstName, personBodyCreate.firstName)
                && Objects.equals(this.lastName, personBodyCreate.lastName)
                && Objects.equals(this.description, personBodyCreate.description)
                && Objects.equals(this.email, personBodyCreate.email)
                && Objects.equals(this.skypeId, personBodyCreate.skypeId)
                && Objects.equals(this.googleId, personBodyCreate.googleId)
                && Objects.equals(this.instantMessageId, personBodyCreate.instantMessageId)
                && Objects.equals(this.jobTitle, personBodyCreate.jobTitle)
                && Objects.equals(this.location, personBodyCreate.location)
                && Objects.equals(this.company, personBodyCreate.company)
                && Objects.equals(this.mobile, personBodyCreate.mobile)
                && Objects.equals(this.telephone, personBodyCreate.telephone)
                && Objects.equals(this.userStatus, personBodyCreate.userStatus)
                && Objects.equals(this.enabled, personBodyCreate.enabled)
                && Objects.equals(this.emailNotificationsEnabled, personBodyCreate.emailNotificationsEnabled)
                && Objects.equals(this.password, personBodyCreate.password)
                && Objects.equals(this.aspectNames, personBodyCreate.aspectNames)
                && Objects.equals(this.properties, personBodyCreate.properties);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, firstName, lastName, description, email, skypeId, googleId, instantMessageId, jobTitle,
                location, company, mobile, telephone, userStatus, enabled, emailNotificationsEnabled, password,
                aspectNames, properties);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class PersonBodyCreate {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
