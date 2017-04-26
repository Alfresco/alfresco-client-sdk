package com.alfresco.client.api.search.body;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * RequestFilterQueriesInner
 */
public class RequestFilterQuery
{
    @SerializedName("query")
    private String query = null;

    @SerializedName("tags")
    private List<String> tags = new ArrayList<String>();

    public RequestFilterQuery query(String query)
    {
        this.query = query;
        return this;
    }

    /**
     * The filter query expression. For multi-select facets selected facets must
     * be order together
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

    public RequestFilterQuery tags(List<String> tags)
    {
        this.tags = tags;
        return this;
    }

    public RequestFilterQuery addTagsItem(String tagsItem)
    {
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Tags used exclude the filters from facet evaluation for multi-select
     * facet support
     *
     * @return tags
     **/
    public List<String> getTags()
    {
        return tags;
    }

    public void setTags(List<String> tags)
    {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RequestFilterQuery requestFilterQuery = (RequestFilterQuery) o;
        return Objects.equals(this.query, requestFilterQuery.query)
                && Objects.equals(this.tags, requestFilterQuery.tags);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(query);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestFilterQueriesInner {\n");

        sb.append("    query: ").append(toIndentedString(query)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
