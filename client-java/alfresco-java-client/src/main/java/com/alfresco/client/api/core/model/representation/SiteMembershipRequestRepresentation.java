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

import java.util.Date;
import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

public class SiteMembershipRequestRepresentation extends AbstractRepresentation
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("createdAt")
    private Date createdAt = null;

    @SerializedName("site")
    private SiteRepresentation site = null;

    @SerializedName("message")
    private String message = null;

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
     * Get createdAt
     * 
     * @return createdAt
     **/
    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    /**
     * Get site
     * 
     * @return site
     **/
    public SiteRepresentation getSite()
    {
        return site;
    }

    public void setSite(SiteRepresentation site)
    {
        this.site = site;
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

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SiteMembershipRequestRepresentation siteMembershipRequest = (SiteMembershipRequestRepresentation) o;
        return Objects.equals(this.id, siteMembershipRequest.id)
                && Objects.equals(this.createdAt, siteMembershipRequest.createdAt)
                && Objects.equals(this.site, siteMembershipRequest.site)
                && Objects.equals(this.message, siteMembershipRequest.message);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, createdAt, site, message);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class SiteMembershipRequestBodyCreate {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    site: ").append(toIndentedString(site)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
