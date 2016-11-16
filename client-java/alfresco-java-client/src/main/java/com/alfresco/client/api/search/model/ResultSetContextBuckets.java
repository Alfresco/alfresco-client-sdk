package com.alfresco.client.api.search.model;

import java.math.BigDecimal;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * ResultSetContextBuckets
 */
public class ResultSetContextBuckets
{
    @SerializedName("label")
    private String label = null;

    @SerializedName("count")
    private BigDecimal count = null;

    @SerializedName("display")
    private Object display = null;

    /**
     * The bucket label
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

    /**
     * The count for the bucket
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

    public Object getDisplay()
    {
        return display;
    }

    public void setDisplay(Object display)
    {
        this.display = display;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResultSetContextBuckets resultSetContextBuckets = (ResultSetContextBuckets) o;
        return Objects.equals(this.label, resultSetContextBuckets.label)
                && Objects.equals(this.count, resultSetContextBuckets.count);
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
        sb.append("class ResultSetContextBuckets {\n");

        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    display: ").append(toIndentedString(count)).append("\n");
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
