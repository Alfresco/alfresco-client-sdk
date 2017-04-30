package org.alfresco.client.services.governance.core.model.representation;

import java.util.Objects;

import org.alfresco.client.services.content.core.model.representation.AssociationInfoRepresentation;

import com.google.gson.annotations.SerializedName;

/**
 * RecordCategory
 */
public class RecordCategoryRepresentation extends RMNodeRepresentation
{
    @SerializedName("hasRetentionSchedule")
    private Boolean hasRetentionSchedule;

    @SerializedName("association")
    protected AssociationInfoRepresentation association;

    /**
     * Indicates if the record category has a retention schedule defined
     * 
     * @return hasRetentionSchedule
     **/
    public Boolean hasRetentionSchedule()
    {
        return hasRetentionSchedule;
    }

    public void setHasRetentionSchedule(Boolean hasRetentionSchedule)
    {
        this.hasRetentionSchedule = hasRetentionSchedule;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RecordCategoryRepresentation recordCategory = (RecordCategoryRepresentation) o;
        return Objects.equals(this.id, recordCategory.id) && Objects.equals(this.parentId, recordCategory.parentId)
                && Objects.equals(this.name, recordCategory.name)
                && Objects.equals(this.nodeType, recordCategory.nodeType)
                && Objects.equals(this.hasRetentionSchedule, recordCategory.hasRetentionSchedule)
                && Objects.equals(this.modifiedAt, recordCategory.modifiedAt)
                && Objects.equals(this.modifiedByUser, recordCategory.modifiedByUser)
                && Objects.equals(this.createdAt, recordCategory.createdAt)
                && Objects.equals(this.createdByUser, recordCategory.createdByUser)
                && Objects.equals(this.aspectNames, recordCategory.aspectNames)
                && Objects.equals(this.properties, recordCategory.properties)
                && Objects.equals(this.allowableOperations, recordCategory.allowableOperations)
                && Objects.equals(this.path, recordCategory.path)
                && Objects.equals(this.association, recordCategory.association);

    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, parentId, name, nodeType, hasRetentionSchedule, modifiedAt, modifiedByUser, createdAt,
                createdByUser, aspectNames, properties, allowableOperations, path, association);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecordCategory {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
        sb.append("    hasRetentionSchedule: ").append(toIndentedString(hasRetentionSchedule)).append("\n");
        sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
        sb.append("    modifiedByUser: ").append(toIndentedString(modifiedByUser)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    createdByUser: ").append(toIndentedString(createdByUser)).append("\n");
        sb.append("    aspectNames: ").append(toIndentedString(aspectNames)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    allowableOperations: ").append(toIndentedString(allowableOperations)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    association: ").append(toIndentedString(association)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
