package org.alfresco.client.services.governance.core.model.representation;

import java.util.Objects;

import org.alfresco.client.services.content.core.model.representation.ContentInfoRepresentation;

import com.google.gson.annotations.SerializedName;

/**
 * Record
 */
public class RecordRepresentation extends RMNodeRepresentation
{
    @SerializedName("isCompleted")
    private Boolean isCompleted = false;

    @SerializedName("content")
    private ContentInfoRepresentation content = null;

    /**
     * Present only for record nodes. Indicates if the record is completed
     * 
     * @return isCompleted
     **/
    public Boolean isCompleted()
    {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted)
    {
        this.isCompleted = isCompleted;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RecordRepresentation record = (RecordRepresentation) o;
        return Objects.equals(this.id, record.id) && Objects.equals(this.parentId, record.parentId)
                && Objects.equals(this.name, record.name) && Objects.equals(this.nodeType, record.nodeType)
                && Objects.equals(this.isCompleted, record.isCompleted)
                && Objects.equals(this.modifiedAt, record.modifiedAt)
                && Objects.equals(this.modifiedByUser, record.modifiedByUser)
                && Objects.equals(this.createdAt, record.createdAt)
                && Objects.equals(this.createdByUser, record.createdByUser)
                && Objects.equals(this.aspectNames, record.aspectNames)
                && Objects.equals(this.properties, record.properties)
                && Objects.equals(this.allowableOperations, record.allowableOperations)
                && Objects.equals(this.content, record.content) && Objects.equals(this.path, record.path);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, parentId, name, nodeType, isCompleted, modifiedAt, modifiedByUser, createdAt,
                createdByUser, aspectNames, properties, allowableOperations, content, path);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Record {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
        sb.append("    isCompleted: ").append(toIndentedString(isCompleted)).append("\n");
        sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
        sb.append("    modifiedByUser: ").append(toIndentedString(modifiedByUser)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    createdByUser: ").append(toIndentedString(createdByUser)).append("\n");
        sb.append("    aspectNames: ").append(toIndentedString(aspectNames)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    allowableOperations: ").append(toIndentedString(allowableOperations)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
