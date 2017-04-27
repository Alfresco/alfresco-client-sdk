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

import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

public class SiteRoleRepresentation extends AbstractRepresentation
{
    @SerializedName("site")
    private SiteRepresentation site = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("guid")
    private String guid = null;

    // TODO RoleEnum ?
    @SerializedName("role")
    private String role = null;

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
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
     * Get guid
     * 
     * @return guid
     **/
    public String getGuid()
    {
        return guid;
    }

    public void setGuid(String guid)
    {
        this.guid = guid;
    }

    /**
     * Get role
     * 
     * @return role
     **/
    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public SiteRoleEnum getRoleEnum()
    {
        return role != null ? SiteRoleEnum.fromString(role) : null;
    }

    public void setRoleEnum(SiteRoleEnum siteRoleEnum)
    {
        this.role = siteRoleEnum.toString();
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SiteRoleRepresentation siteRole = (SiteRoleRepresentation) o;
        return Objects.equals(this.site, siteRole.site) && Objects.equals(this.id, siteRole.id)
                && Objects.equals(this.guid, siteRole.guid) && Objects.equals(this.role, siteRole.role);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(site, id, guid, role);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class SiteRole {\n");

        sb.append("    site: ").append(toIndentedString(site)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
