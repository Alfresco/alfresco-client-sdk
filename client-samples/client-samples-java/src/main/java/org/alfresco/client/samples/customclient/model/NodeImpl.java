package org.alfresco.client.samples.customclient.model;

import java.util.Date;
import java.util.List;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.alfresco.client.api.core.model.representation.ContentInfoRepresentation;
import com.alfresco.client.api.core.model.representation.PathInfoRepresentation;
import com.alfresco.client.api.core.model.representation.UserInfoRepresentation;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

public class NodeImpl extends AbstractRepresentation implements Node
{
    @SerializedName("id")
    private String identifier;

    private String name;

    private String nodeType;

    private String description;

    private Date createdAt;

    @SerializedName("createdByUser")
    private UserInfoRepresentation createdBy;

    private boolean isFolder;

    private Date modifiedAt;

    @SerializedName("modifiedByUser")
    private UserInfoRepresentation modifiedBy;

    private String parentId;

    private PathInfoRepresentation path;

    private ContentInfoRepresentation content;

    @SerializedName("aspectNames")
    private List<String> aspects;

    private LinkedTreeMap<String, Object> properties;

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
    public String getIdentifier()
    {
        return identifier;
    }

    public void setIdentifier(String identifier)
    {
        this.identifier = identifier;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNodeType()
    {
        return nodeType;
    }

    public void setNodeType(String nodeType)
    {
        this.nodeType = nodeType;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public UserInfoRepresentation getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(UserInfoRepresentation createdBy)
    {
        this.createdBy = createdBy;
    }

    public boolean isFolder()
    {
        return isFolder;
    }

    public void setIsFolder(boolean isFolder)
    {
        this.isFolder = isFolder;
    }

    public Date getModifiedAt()
    {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt)
    {
        this.modifiedAt = modifiedAt;
    }

    public UserInfoRepresentation getModifiedBy()
    {
        return modifiedBy;
    }

    public void setModifiedBy(UserInfoRepresentation modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    public PathInfoRepresentation getPath()
    {
        return path;
    }

    public void setPath(PathInfoRepresentation path)
    {
        this.path = path;
    }

    public ContentInfoRepresentation getContent()
    {
        return content;
    }

    public void setContent(ContentInfoRepresentation content)
    {
        this.content = content;
    }

    public List<String> getAspects()
    {
        return aspects;
    }

    public boolean hasAspects(String aspectName)
    {
        return aspects != null && aspects.contains(aspectName);
    }

    public void setAspects(List<String> aspects)
    {
        this.aspects = aspects;
    }

    public LinkedTreeMap<String, Object> getProperties()
    {
        return properties;
    }

    public void setProperties(LinkedTreeMap<String, Object> properties)
    {
        this.properties = properties;
    }
}
