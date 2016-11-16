package com.alfresco.client.api.search.body;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * RequestFacetQueriesInner
 */
public class RequestFacetQuery
{
    @SerializedName("query")
    private String query = null;

    @SerializedName("label")
    private String label = null;

    public RequestFacetQuery query(String query)
    {
        this.query = query;
        return this;
    }

    /**
     * A facet query
     * 
     * @return query
     **/
    public String getQuery()
    {
        return query;
    }

    public void setQuery(String query)
    {
        this.query = query;
    }

    public RequestFacetQuery label(String label)
    {
        this.label = label;
        return this;
    }

    /**
     * A label to include in place of the facet query
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RequestFacetQuery requestFacetQuery = (RequestFacetQuery) o;
        return Objects.equals(this.query, requestFacetQuery.query)
                && Objects.equals(this.label, requestFacetQuery.label);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(query, label);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestFacetQueriesInner {\n");

        sb.append("    query: ").append(toIndentedString(query)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
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
