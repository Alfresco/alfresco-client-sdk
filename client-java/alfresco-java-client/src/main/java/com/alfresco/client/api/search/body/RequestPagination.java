package com.alfresco.client.api.search.body;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * RequestPagination
 */
public class RequestPagination
{
    @SerializedName("maxItems")
    private Integer maxItems = null;

    @SerializedName("skipCount")
    private Integer skipCount = null;

    public RequestPagination maxItems(Integer maxItems)
    {
        this.maxItems = maxItems;
        return this;
    }

    /**
     * The maximum number of items to return in the query results minimum: 1.0
     * 
     * @return maxItems
     **/
    public Integer getMaxItems()
    {
        return maxItems;
    }

    public void setMaxItems(Integer maxItems)
    {
        this.maxItems = maxItems;
    }

    public RequestPagination skipCount(Integer skipCount)
    {
        this.skipCount = skipCount;
        return this;
    }

    /**
     * The number of items to skip from the start of the query set minimum: 0.0
     * 
     * @return skipCount
     **/
    public Integer getSkipCount()
    {
        return skipCount;
    }

    public void setSkipCount(Integer skipCount)
    {
        this.skipCount = skipCount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RequestPagination requestPagination = (RequestPagination) o;
        return Objects.equals(this.maxItems, requestPagination.maxItems)
                && Objects.equals(this.skipCount, requestPagination.skipCount);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(maxItems, skipCount);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestPagination {\n");

        sb.append("    maxItems: ").append(toIndentedString(maxItems)).append("\n");
        sb.append("    skipCount: ").append(toIndentedString(skipCount)).append("\n");
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
