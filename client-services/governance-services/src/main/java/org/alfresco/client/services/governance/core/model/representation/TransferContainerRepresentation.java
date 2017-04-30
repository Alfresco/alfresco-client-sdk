package org.alfresco.client.services.governance.core.model.representation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.alfresco.client.services.common.model.representation.AbstractRepresentation;
import org.alfresco.client.services.content.core.model.representation.UserInfoRepresentation;

import com.google.gson.annotations.SerializedName;

/**
 * TransferContainer
 */
public class TransferContainerRepresentation extends AbstractRepresentation
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("parentId")
    private String parentId = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("nodeType")
    private String nodeType = null;

    @SerializedName("modifiedAt")
    private Date modifiedAt = null;

    @SerializedName("modifiedByUser")
    private UserInfoRepresentation modifiedByUser = null;

    @SerializedName("createdAt")
    private Date createdAt = null;

    @SerializedName("createdByUser")
    private UserInfoRepresentation createdByUser = null;

    @SerializedName("aspectNames")
    private List<String> aspectNames = new ArrayList<String>();

    @SerializedName("properties")
    private Object properties = null;

    @SerializedName("allowableOperations")
    private List<String> allowableOperations = new ArrayList<String>();

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
    public Object getProperties()
    {
        return properties;
    }

    public void setProperties(Object properties)
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TransferContainerRepresentation transferContainer = (TransferContainerRepresentation) o;
        return Objects.equals(this.id, transferContainer.id)
                && Objects.equals(this.parentId, transferContainer.parentId)
                && Objects.equals(this.name, transferContainer.name)
                && Objects.equals(this.nodeType, transferContainer.nodeType)
                && Objects.equals(this.modifiedAt, transferContainer.modifiedAt)
                && Objects.equals(this.modifiedByUser, transferContainer.modifiedByUser)
                && Objects.equals(this.createdAt, transferContainer.createdAt)
                && Objects.equals(this.createdByUser, transferContainer.createdByUser)
                && Objects.equals(this.aspectNames, transferContainer.aspectNames)
                && Objects.equals(this.properties, transferContainer.properties)
                && Objects.equals(this.allowableOperations, transferContainer.allowableOperations);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, parentId, name, nodeType, modifiedAt, modifiedByUser, createdAt, createdByUser,
                aspectNames, properties, allowableOperations);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransferContainer {\n");

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
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o)
    {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }
}
