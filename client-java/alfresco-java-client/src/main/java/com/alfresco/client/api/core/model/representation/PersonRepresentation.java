/*
 *   Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *   This file is part of Alfresco Java Client.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.alfresco.client.api.core.model.representation;

import java.util.*;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

public class PersonRepresentation extends AbstractRepresentation
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("firstName")
    private String firstName = null;

    @SerializedName("lastName")
    private String lastName = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("avatarId")
    private String avatarId = null;

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
    private CompanyRepresentation company = null;

    @SerializedName("mobile")
    private String mobile = null;

    @SerializedName("telephone")
    private String telephone = null;

    @SerializedName("statusUpdatedAt")
    private Date statusUpdatedAt = null;

    @SerializedName("userStatus")
    private String userStatus = null;

    @SerializedName("enabled")
    private Boolean enabled = true;

    @SerializedName("emailNotificationsEnabled")
    private Boolean emailNotificationsEnabled = null;

    @SerializedName("aspectNames")
    private List<String> aspectNames = new ArrayList<>();

    @SerializedName("properties")
    private Map<String, String> properties = new HashMap<>();

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
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
     * Get firstName
     * 
     * @return firstName
     **/
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
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

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
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
     * Get avatarId
     * 
     * @return avatarId
     **/
    public String getAvatarId()
    {
        return avatarId;
    }

    public void setAvatarId(String avatarId)
    {
        this.avatarId = avatarId;
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

    public void setEmail(String email)
    {
        this.email = email;
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

    public void setSkypeId(String skypeId)
    {
        this.skypeId = skypeId;
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

    public void setGoogleId(String googleId)
    {
        this.googleId = googleId;
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

    public void setInstantMessageId(String instantMessageId)
    {
        this.instantMessageId = instantMessageId;
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

    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
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

    public void setLocation(String location)
    {
        this.location = location;
    }

    /**
     * Get company
     * 
     * @return company
     **/
    public CompanyRepresentation getCompany()
    {
        return company;
    }

    public void setCompany(CompanyRepresentation company)
    {
        this.company = company;
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

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
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

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    /**
     * Get statusUpdatedAt
     * 
     * @return statusUpdatedAt
     **/
    public Date getStatusUpdatedAt()
    {
        return statusUpdatedAt;
    }

    public void setStatusUpdatedAt(Date statusUpdatedAt)
    {
        this.statusUpdatedAt = statusUpdatedAt;
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

    public void setUserStatus(String userStatus)
    {
        this.userStatus = userStatus;
    }

    /**
     * Get enabled
     * 
     * @return enabled
     **/
    public Boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
    }

    /**
     * Get emailNotificationsEnabled
     * 
     * @return emailNotificationsEnabled
     **/
    public Boolean isEmailNotificationsEnabled()
    {
        return emailNotificationsEnabled;
    }

    public void setEmailNotificationsEnabled(Boolean emailNotificationsEnabled)
    {
        this.emailNotificationsEnabled = emailNotificationsEnabled;
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

    public void setAspectNames(List<String> aspectNames)
    {
        this.aspectNames = aspectNames;
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

    public void setProperties(Map<String, String> properties)
    {
        this.properties = properties;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PersonRepresentation person = (PersonRepresentation) o;
        return Objects.equals(this.id, person.id) && Objects.equals(this.firstName, person.firstName)
                && Objects.equals(this.lastName, person.lastName)
                && Objects.equals(this.description, person.description)
                && Objects.equals(this.avatarId, person.avatarId) && Objects.equals(this.email, person.email)
                && Objects.equals(this.skypeId, person.skypeId) && Objects.equals(this.googleId, person.googleId)
                && Objects.equals(this.instantMessageId, person.instantMessageId)
                && Objects.equals(this.jobTitle, person.jobTitle) && Objects.equals(this.location, person.location)
                && Objects.equals(this.company, person.company) && Objects.equals(this.mobile, person.mobile)
                && Objects.equals(this.telephone, person.telephone)
                && Objects.equals(this.statusUpdatedAt, person.statusUpdatedAt)
                && Objects.equals(this.userStatus, person.userStatus) && Objects.equals(this.enabled, person.enabled)
                && Objects.equals(this.emailNotificationsEnabled, person.emailNotificationsEnabled)
                && Objects.equals(this.aspectNames, person.aspectNames)
                && Objects.equals(this.properties, person.properties);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, firstName, lastName, description, avatarId, email, skypeId, googleId, instantMessageId,
                jobTitle, location, company, mobile, telephone, statusUpdatedAt, userStatus, enabled,
                emailNotificationsEnabled, aspectNames, properties);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Person {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    avatarId: ").append(toIndentedString(avatarId)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    skypeId: ").append(toIndentedString(skypeId)).append("\n");
        sb.append("    googleId: ").append(toIndentedString(googleId)).append("\n");
        sb.append("    instantMessageId: ").append(toIndentedString(instantMessageId)).append("\n");
        sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    company: ").append(toIndentedString(company)).append("\n");
        sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
        sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
        sb.append("    statusUpdatedAt: ").append(toIndentedString(statusUpdatedAt)).append("\n");
        sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    emailNotificationsEnabled: ").append(toIndentedString(emailNotificationsEnabled)).append("\n");
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
