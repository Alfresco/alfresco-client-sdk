package com.alfresco.client.api.search.model;

import java.math.BigDecimal;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * ResultSetContextFacetQueries
 */
public class ResultSetContextFacetQueries
{
    @SerializedName("label")
    private String label = null;

    @SerializedName("count")
    private BigDecimal count = null;

    public ResultSetContextFacetQueries label(String label)
    {
        this.label = label;
        return this;
    }

    /**
     * Get label
     * 
     * @return label
     **/
    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public ResultSetContextFacetQueries count(BigDecimal count)
    {
        this.count = count;
        return this;
    }

    /**
     * Get count
     * 
     * @return count
     **/
    public BigDecimal getCount()
    {
        return count;
    }

    public void setCount(BigDecimal count)
    {
        this.count = count;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResultSetContextFacetQueries resultSetContextFacetQueries = (ResultSetContextFacetQueries) o;
        return Objects.equals(this.label, resultSetContextFacetQueries.label)
                && Objects.equals(this.count, resultSetContextFacetQueries.count);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(label, count);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResultSetContextFacetQueries {\n");

        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
