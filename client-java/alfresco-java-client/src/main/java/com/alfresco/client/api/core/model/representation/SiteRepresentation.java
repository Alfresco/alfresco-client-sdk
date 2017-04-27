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

public class SiteRepresentation extends AbstractRepresentation
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("guid")
    private String guid = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("visibility")
    private SiteVisibilityEnum visibility = null;

    @SerializedName("role")
    private String role = null;

    @SerializedName("preset")
    private String preset = null;

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
     * Get title
     * 
     * @return title
     **/
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
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
     * Get visibility
     * 
     * @return visibility
     **/
    public SiteVisibilityEnum getVisibilityEnum()
    {
        return visibility;
    }

    public String getVisibility()
    {
        return visibility != null ? visibility.value() : null;
    }

    public void setVisibility(SiteVisibilityEnum visibility)
    {
        this.visibility = visibility;
    }

    public void setVisibilityEnum(String visibility)
    {
        this.visibility = SiteVisibilityEnum.valueOf(visibility);
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

    /**
     * Get preset
     * 
     * @return preset
     **/
    public String getPreset()
    {
        return preset;
    }

    public void setPreset(String preset)
    {
        this.preset = preset;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SiteRepresentation site = (SiteRepresentation) o;
        return Objects.equals(this.id, site.id) && Objects.equals(this.guid, site.guid)
                && Objects.equals(this.title, site.title) && Objects.equals(this.description, site.description)
                && Objects.equals(this.visibility, site.visibility) && Objects.equals(this.preset, site.preset)
                && Objects.equals(this.role, site.role);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, guid, title, description, visibility, preset, role);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class SiteRepresentation {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    visibility: ").append(toIndentedString(visibility)).append("\n");
        sb.append("    preset: ").append(toIndentedString(preset)).append("\n");
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
