package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * TableMetaData
 */
public class TableMetaData
{
    @SerializedName("tableName")
    private String tableName = null;

    @SerializedName("columnNames")
    private List<String> columnNames = new ArrayList<String>();

    @SerializedName("columnTypes")
    private List<String> columnTypes = new ArrayList<String>();

    /**
     * Get tableName
     * 
     * @return tableName
     **/
    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    /**
     * Get columnNames
     * 
     * @return columnNames
     **/
    public List<String> getColumnNames()
    {
        return columnNames;
    }

    public void setColumnNames(List<String> columnNames)
    {
        this.columnNames = columnNames;
    }

    /**
     * Get columnTypes
     * 
     * @return columnTypes
     **/
    public List<String> getColumnTypes()
    {
        return columnTypes;
    }

    public void setColumnTypes(List<String> columnTypes)
    {
        this.columnTypes = columnTypes;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TableMetaData tableMetaData = (TableMetaData) o;
        return Objects.equals(this.tableName, tableMetaData.tableName)
                && Objects.equals(this.columnNames, tableMetaData.columnNames)
                && Objects.equals(this.columnTypes, tableMetaData.columnTypes);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(tableName, columnNames, columnTypes);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class TableMetaData {\n");

        sb.append("    tableName: ").append(toIndentedString(tableName)).append("\n");
        sb.append("    columnNames: ").append(toIndentedString(columnNames)).append("\n");
        sb.append("    columnTypes: ").append(toIndentedString(columnTypes)).append("\n");
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
