package org.alfresco.client.services.governance.core.model.representation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.alfresco.client.services.common.model.representation.AbstractRepresentation;
import org.alfresco.client.services.content.core.model.representation.UserInfoRepresentation;

import com.google.gson.annotations.SerializedName;

/**
 * Transfer
 */
public class TransferRepresentation extends AbstractRepresentation
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("parentId")
    private String parentId = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("nodeType")
    private String nodeType = null;

    @SerializedName("createdAt")
    private Date createdAt = null;

    @SerializedName("createdByUser")
    private UserInfoRepresentation createdByUser = null;

    @SerializedName("transferPDFIndicator")
    private Boolean transferPDFIndicator = false;

    @SerializedName("transferLocation")
    private String transferLocation = null;

    @SerializedName("transferAccessionIndicator")
    private Boolean transferAccessionIndicator = false;

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
     * Present only for transfer nodes.
     * 
     * @return transferPDFIndicator
     **/
    public Boolean getTransferPDFIndicator()
    {
        return transferPDFIndicator;
    }

    public void setTransferPDFIndicator(Boolean transferPDFIndicator)
    {
        this.transferPDFIndicator = transferPDFIndicator;
    }

    /**
     * Present only for transfer nodes.
     * 
     * @return transferLocation
     **/
    public String getTransferLocation()
    {
        return transferLocation;
    }

    public void setTransferLocation(String transferLocation)
    {
        this.transferLocation = transferLocation;
    }

    /**
     * Present only for transfer nodes.
     * 
     * @return transferAccessionIndicator
     **/
    public Boolean getTransferAccessionIndicator()
    {
        return transferAccessionIndicator;
    }

    public void setTransferAccessionIndicator(Boolean transferAccessionIndicator)
    {
        this.transferAccessionIndicator = transferAccessionIndicator;
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
        TransferRepresentation transfer = (TransferRepresentation) o;
        return Objects.equals(this.id, transfer.id) && Objects.equals(this.parentId, transfer.parentId)
                && Objects.equals(this.name, transfer.name) && Objects.equals(this.nodeType, transfer.nodeType)
                && Objects.equals(this.createdAt, transfer.createdAt)
                && Objects.equals(this.createdByUser, transfer.createdByUser)
                && Objects.equals(this.transferPDFIndicator, transfer.transferPDFIndicator)
                && Objects.equals(this.transferLocation, transfer.transferLocation)
                && Objects.equals(this.transferAccessionIndicator, transfer.transferAccessionIndicator)
                && Objects.equals(this.aspectNames, transfer.aspectNames)
                && Objects.equals(this.properties, transfer.properties)
                && Objects.equals(this.allowableOperations, transfer.allowableOperations);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, parentId, name, nodeType, createdAt, createdByUser, transferPDFIndicator,
                transferLocation, transferAccessionIndicator, aspectNames, properties, allowableOperations);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Transfer {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    createdByUser: ").append(toIndentedString(createdByUser)).append("\n");
        sb.append("    transferPDFIndicator: ").append(toIndentedString(transferPDFIndicator)).append("\n");
        sb.append("    transferLocation: ").append(toIndentedString(transferLocation)).append("\n");
        sb.append("    transferAccessionIndicator: ").append(toIndentedString(transferAccessionIndicator)).append("\n");
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
