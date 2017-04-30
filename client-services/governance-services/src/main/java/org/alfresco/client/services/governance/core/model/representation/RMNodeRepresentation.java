package org.alfresco.client.services.governance.core.model.representation;

import java.util.*;

import org.alfresco.client.services.common.model.representation.AbstractRepresentation;
import org.alfresco.client.services.content.core.model.representation.PathInfoRepresentation;
import org.alfresco.client.services.content.core.model.representation.UserInfoRepresentation;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 29/04/2017.
 */
public class RMNodeRepresentation extends AbstractRepresentation
{

    @SerializedName("id")
    protected String id = null;

    @SerializedName("parentId")
    protected String parentId = null;

    @SerializedName("name")
    protected String name = null;

    @SerializedName("nodeType")
    protected String nodeType = null;

    @SerializedName("createdAt")
    protected Date createdAt = null;

    @SerializedName("createdByUser")
    protected UserInfoRepresentation createdByUser = null;

    @SerializedName("modifiedAt")
    protected Date modifiedAt = null;

    @SerializedName("modifiedByUser")
    protected UserInfoRepresentation modifiedByUser = null;

    @SerializedName("aspectNames")
    protected List<String> aspectNames = new ArrayList<>();

    @SerializedName("properties")
    protected Map<String, Object> properties = new HashMap<>();

    @SerializedName("path")
    protected PathInfoRepresentation path = null;

    @SerializedName("allowableOperations")
    protected List<String> allowableOperations = new ArrayList<>();

    public RMNodeRepresentation()
    {
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
     * The name must not contain spaces or the following special characters: *
     * \" < > \\ / ? : and |. The character . must not be used at the end of the
     * name.
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
        return createdByUser;
    }

    public void setCreatedByUser(UserInfoRepresentation createdByUser)
    {
        this.createdByUser = createdByUser;
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
    public Map<String, Object> getProperties()
    {
        return properties;
    }

    public void setProperties(Map<String, Object> properties)
    {
        this.properties = properties;
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

    /**
     * Get path
     *
     * @return path
     **/
    public PathInfoRepresentation getPath()
    {
        return path;
    }

    public void setPath(PathInfoRepresentation path)
    {
        this.path = path;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RMNodeRepresentation filePlan = (RMNodeRepresentation) o;
        return Objects.equals(this.id, filePlan.id) && Objects.equals(this.parentId, filePlan.parentId)
                && Objects.equals(this.name, filePlan.name) && Objects.equals(this.nodeType, filePlan.nodeType)
                && Objects.equals(this.modifiedAt, filePlan.modifiedAt)
                && Objects.equals(this.modifiedByUser, filePlan.modifiedByUser)
                && Objects.equals(this.createdAt, filePlan.createdAt)
                && Objects.equals(this.createdByUser, filePlan.createdByUser)
                && Objects.equals(this.aspectNames, filePlan.aspectNames)
                && Objects.equals(this.properties, filePlan.properties)
                && Objects.equals(this.allowableOperations, filePlan.allowableOperations)
                && Objects.equals(this.path, filePlan.path);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, parentId, name, nodeType, modifiedAt, modifiedByUser, createdAt, createdByUser,
                aspectNames, properties, allowableOperations, path);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RMNode {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
        sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
        sb.append("    modifiedByUser: ").append(toIndentedString(modifiedByUser)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    createdByUser: ").append(toIndentedString(createdByUser)).append("\n");
        sb.append("    aspectNames: ").append(toIndentedString(aspectNames)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    allowableOperations: ").append(toIndentedString(allowableOperations)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o)
    {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
