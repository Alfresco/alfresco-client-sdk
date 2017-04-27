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

public class SharedLinkRepresentation extends AbstractRepresentation
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("expiresAt")
    private Date expiresAt = null;

    @SerializedName("nodeId")
    private String nodeId = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("modifiedAt")
    private Date modifiedAt = null;

    @SerializedName("modifiedByUser")
    private UserInfoRepresentation modifiedByUser = null;

    @SerializedName("sharedByUser")
    private UserInfoRepresentation sharedByUser = null;

    @SerializedName("content")
    private ContentInfoRepresentation content = null;

    @SerializedName("allowableOperations")
    private List<String> allowableOperations = new ArrayList<>();

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
     * Get nodeId
     * 
     * @return nodeId
     **/
    public String getNodeId()
    {
        return nodeId;
    }

    public void setNodeId(String nodeId)
    {
        this.nodeId = nodeId;
    }

    /**
     * Get expiresAt
     * 
     * @return expiresAt
     **/
    public Date getExpiresAt()
    {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt)
    {
        this.expiresAt = expiresAt;
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
        return modifiedByUser;
    }

    public void setModifiedByUser(UserInfoRepresentation modifiedByUser)
    {
        this.modifiedByUser = modifiedByUser;
    }

    /**
     * Get sharedByUser
     * 
     * @return sharedByUser
     **/
    public UserInfoRepresentation getSharedByUser()
    {
        return sharedByUser;
    }

    public void setSharedByUser(UserInfoRepresentation sharedByUser)
    {
        this.sharedByUser = sharedByUser;
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

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SharedLinkRepresentation nodeSharedLink = (SharedLinkRepresentation) o;
        return Objects.equals(this.id, nodeSharedLink.id) && Objects.equals(this.nodeId, nodeSharedLink.nodeId)
                && Objects.equals(this.name, nodeSharedLink.name)
                && Objects.equals(this.expiresAt, nodeSharedLink.expiresAt)
                && Objects.equals(this.modifiedAt, nodeSharedLink.modifiedAt)
                && Objects.equals(this.modifiedByUser, nodeSharedLink.modifiedByUser)
                && Objects.equals(this.sharedByUser, nodeSharedLink.sharedByUser)
                && Objects.equals(this.content, nodeSharedLink.content)
                && Objects.equals(this.allowableOperations, nodeSharedLink.allowableOperations);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, expiresAt, nodeId, name, modifiedAt, modifiedByUser, sharedByUser, content,
                allowableOperations);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class NodeSharedLink {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
        sb.append("    nodeId: ").append(toIndentedString(nodeId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
        sb.append("    modifiedByUser: ").append(toIndentedString(modifiedByUser)).append("\n");
        sb.append("    sharedByUser: ").append(toIndentedString(sharedByUser)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    allowableOperations: ").append(toIndentedString(allowableOperations)).append("\n");
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
