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

/**
 * Comment
 */
public class CommentRepresentation extends AbstractRepresentation
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("content")
    private String content = null;

    @SerializedName("createdBy")
    private PersonRepresentation createdBy = null;

    @SerializedName("createdAt")
    private Date createdAt = null;

    @SerializedName("edited")
    private Boolean edited = null;

    @SerializedName("modifiedBy")
    private PersonRepresentation modifiedBy = null;

    @SerializedName("modifiedAt")
    private Date modifiedAt = null;

    @SerializedName("canEdit")
    private Boolean canEdit = null;

    @SerializedName("canDelete")
    private Boolean canDelete = null;

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
     * Get content
     * 
     * @return content
     **/
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    /**
     * Get createdBy
     * 
     * @return createdBy
     **/
    public PersonRepresentation getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(PersonRepresentation createdBy)
    {
        this.createdBy = createdBy;
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
     * Get edited
     * 
     * @return edited
     **/
    public Boolean isEdited()
    {
        return edited;
    }

    public void setEdited(Boolean edited)
    {
        this.edited = edited;
    }

    /**
     * Get modifiedBy
     * 
     * @return modifiedBy
     **/
    public PersonRepresentation getModifiedBy()
    {
        return modifiedBy;
    }

    public void setModifiedBy(PersonRepresentation modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }

    /**
     * Get modifiedAt
     * 
     * @return modifiedAt
     **/
    public Date getModifiedAt()
    {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt)
    {
        this.modifiedAt = modifiedAt;
    }

    /**
     * Get canEdit
     * 
     * @return canEdit
     **/
    public Boolean getCanEdit()
    {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit)
    {
        this.canEdit = canEdit;
    }

    /**
     * Get canDelete
     * 
     * @return canDelete
     **/
    public Boolean getCanDelete()
    {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete)
    {
        this.canDelete = canDelete;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CommentRepresentation comment = (CommentRepresentation) o;
        return Objects.equals(this.id, comment.id) && Objects.equals(this.content, comment.content)
                && Objects.equals(this.createdBy, comment.createdBy)
                && Objects.equals(this.createdAt, comment.createdAt) && Objects.equals(this.edited, comment.edited)
                && Objects.equals(this.modifiedBy, comment.modifiedBy)
                && Objects.equals(this.modifiedAt, comment.modifiedAt) && Objects.equals(this.canEdit, comment.canEdit)
                && Objects.equals(this.canDelete, comment.canDelete);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, content, createdBy, createdAt, edited, modifiedBy, modifiedAt, canEdit,
                canDelete);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Comment {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    edited: ").append(toIndentedString(edited)).append("\n");
        sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
        sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
        sb.append("    canEdit: ").append(toIndentedString(canEdit)).append("\n");
        sb.append("    canDelete: ").append(toIndentedString(canDelete)).append("\n");
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
