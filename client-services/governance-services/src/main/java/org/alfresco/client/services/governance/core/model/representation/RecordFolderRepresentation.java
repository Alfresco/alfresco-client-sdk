package org.alfresco.client.services.governance.core.model.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * RecordFolder
 */
public class RecordFolderRepresentation extends RMNodeRepresentation
{
    @SerializedName("isClosed")
    private Boolean isClosed = false;

    /**
     * Indicates if the record folder is closed
     * 
     * @return isClosed
     **/
    public Boolean getIsClosed()
    {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed)
    {
        this.isClosed = isClosed;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RecordFolderRepresentation recordFolder = (RecordFolderRepresentation) o;
        return Objects.equals(this.id, recordFolder.id) && Objects.equals(this.parentId, recordFolder.parentId)
                && Objects.equals(this.name, recordFolder.name) && Objects.equals(this.nodeType, recordFolder.nodeType)
                && Objects.equals(this.isClosed, recordFolder.isClosed)
                && Objects.equals(this.modifiedAt, recordFolder.modifiedAt)
                && Objects.equals(this.modifiedByUser, recordFolder.modifiedByUser)
                && Objects.equals(this.createdAt, recordFolder.createdAt)
                && Objects.equals(this.createdByUser, recordFolder.createdByUser)
                && Objects.equals(this.aspectNames, recordFolder.aspectNames)
                && Objects.equals(this.properties, recordFolder.properties)
                && Objects.equals(this.allowableOperations, recordFolder.allowableOperations)
                && Objects.equals(this.path, recordFolder.path);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, parentId, name, nodeType, isClosed, modifiedAt, modifiedByUser, createdAt,
                createdByUser, aspectNames, properties, allowableOperations, path);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecordFolder {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
        sb.append("    isClosed: ").append(toIndentedString(isClosed)).append("\n");
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
}
