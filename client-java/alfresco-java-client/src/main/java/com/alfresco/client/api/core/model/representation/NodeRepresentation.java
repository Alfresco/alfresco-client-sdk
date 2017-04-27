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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

public class NodeRepresentation extends AbstractRepresentation
{
    @SerializedName("id")
    protected String id = null;

    @SerializedName("parentId")
    protected String parentId = null;

    @SerializedName("name")
    protected String name = null;

    @SerializedName("nodeType")
    protected String nodeType = null;

    @SerializedName("isFolder")
    protected Boolean isFolder = null;

    @SerializedName("isFile")
    protected Boolean isFile = null;

    @SerializedName("isLocked")
    protected Boolean isLocked = null;

    @SerializedName("modifiedAt")
    protected Date modifiedAt = null;

    @SerializedName("modifiedByUser")
    protected UserInfoRepresentation modifiedBy = null;

    @SerializedName("createdAt")
    protected Date createdAt = null;

    @SerializedName("createdByUser")
    protected UserInfoRepresentation createdBy = null;

    @SerializedName("isLink")
    protected Boolean isLink = null;

    @SerializedName("content")
    protected ContentInfoRepresentation content = null;

    @SerializedName("aspectNames")
    protected List<String> aspects = new ArrayList<>();

    @SerializedName("properties")
    protected LinkedTreeMap<String, Object> properties;

    @SerializedName("allowableOperations")
    protected List<String> allowableOperations = new ArrayList<String>();

    @SerializedName("path")
    protected PathInfoRepresentation path;

    @SerializedName("association")
    protected AssociationInfoRepresentation association;

    @SerializedName("permissions")
    private PermissionsInfoRepresentation permissions = null;

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
     * Get parentId
     * 
     * @return parentId
     **/
    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    /**
     * Get name
     * 
     * @return name
     **/
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get nodeType
     * 
     * @return nodeType
     **/
    public String getNodeType()
    {
        return nodeType;
    }

    public void setNodeType(String nodeType)
    {
        this.nodeType = nodeType;
    }

    /**
     * Get isFolder
     * 
     * @return isFolder
     **/
    public Boolean isFolder()
    {
        return isFolder;
    }

    public void setIsFolder(Boolean isFolder)
    {
        this.isFolder = isFolder;
    }

    /**
     * Get isFile
     * 
     * @return isFile
     **/
    public Boolean isFile()
    {
        return isFile;
    }

    public void setIsFile(Boolean isFile)
    {
        this.isFile = isFile;
    }

    public Boolean isLocked()
    {
        return isLocked;
    }

    public void setIsLocked(Boolean locked)
    {
        isLocked = locked;
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
     * Get modifiedByUser
     * 
     * @return modifiedByUser
     **/
    public UserInfoRepresentation getModifiedByUser()
    {
        return modifiedBy;
    }

    public void setModifiedByUser(UserInfoRepresentation modifiedByUser)
    {
        this.modifiedBy = modifiedByUser;
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
     * Get createdByUser
     * 
     * @return createdByUser
     **/
    public UserInfoRepresentation getCreatedByUser()
    {
        return createdBy;
    }

    public void setCreatedByUser(UserInfoRepresentation createdByUser)
    {
        this.createdBy = createdByUser;
    }

    /**
     * Get content
     * 
     * @return content
     **/
    public ContentInfoRepresentation getContent()
    {
        return content;
    }

    public void setContent(ContentInfoRepresentation content)
    {
        this.content = content;
    }

    /**
     * Get aspects
     * 
     * @return aspects
     **/
    public List<String> getAspects()
    {
        return aspects;
    }

    public void setAspects(List<String> aspects)
    {
        this.aspects = aspects;
    }

    public boolean hasAspects(String aspectName)
    {
        return aspects != null && aspects.contains(aspectName);
    }

    /**
     * Get properties
     * 
     * @return properties
     **/
    public LinkedTreeMap<String, Object> getProperties()
    {
        return properties;
    }

    public void setProperties(LinkedTreeMap<String, Object> properties)
    {
        this.properties = properties;
    }

    /**
     * Get association
     * 
     * @return Associations
     **/
    public AssociationInfoRepresentation getAssociation()
    {
        return association;
    }

    public void setAssociation(AssociationInfoRepresentation association)
    {
        this.association = association;
    }

    /**
     * Get allowableOperations
     * 
     * @return allowableOperations
     **/
    public List<String> getAllowableOperations()
    {
        return allowableOperations;
    }

    public void setAllowableOperations(List<String> allowableOperations)
    {
        this.allowableOperations = allowableOperations;
    }

    public Boolean isLink()
    {
        return isLink;
    }

    public void setLink(Boolean link)
    {
        isLink = link;
    }

    public PathInfoRepresentation getPath()
    {
        return path;
    }

    public void setPath(PathInfoRepresentation path)
    {
        this.path = path;
    }

    /**
     * Get permissions
     * 
     * @return permissions
     **/
    public PermissionsInfoRepresentation getPermissions()
    {
        return permissions;
    }

    public void setPermissions(PermissionsInfoRepresentation permissions)
    {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        NodeRepresentation node = (NodeRepresentation) o;
        return Objects.equals(this.id, node.id) && Objects.equals(this.parentId, node.parentId)
                && Objects.equals(this.name, node.name) && Objects.equals(this.nodeType, node.nodeType)
                && Objects.equals(this.isFolder, node.isFolder) && Objects.equals(this.isFile, node.isFile)
                && Objects.equals(this.isLocked, node.isLocked) && Objects.equals(this.isLink, node.isLink)
                && Objects.equals(this.modifiedAt, node.modifiedAt) && Objects.equals(this.modifiedBy, node.modifiedBy)
                && Objects.equals(this.createdAt, node.createdAt) && Objects.equals(this.createdBy, node.createdBy)
                && Objects.equals(this.content, node.content) && Objects.equals(this.aspects, node.aspects)
                && Objects.equals(this.allowableOperations, node.allowableOperations)
                && Objects.equals(this.permissions, node.permissions);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, parentId, name, nodeType, isFolder, isFile, isLocked, isLink, modifiedAt, modifiedBy,
                createdAt, createdBy, content, aspects, properties, allowableOperations, association, permissions);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class NodeRepresentation {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
        sb.append("    isFolder: ").append(toIndentedString(isFolder)).append("\n");
        sb.append("    isFile: ").append(toIndentedString(isFile)).append("\n");
        sb.append("    isLocked: ").append(toIndentedString(isLocked)).append("\n");
        sb.append("    isLink: ").append(toIndentedString(isLink)).append("\n");
        sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
        sb.append("    modifiedByUser: ").append(toIndentedString(modifiedBy)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    createdByUser: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    aspects: ").append(toIndentedString(aspects)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    allowableOperations: ").append(toIndentedString(allowableOperations)).append("\n");
        sb.append("    association: ").append(toIndentedString(association)).append("\n");
        sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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
