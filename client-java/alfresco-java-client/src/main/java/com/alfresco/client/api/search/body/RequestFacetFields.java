package com.alfresco.client.api.search.body;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Simple facet fields to include The Properties reflect the global properties
 * related to field facts in SOLR. They are descripbed in detail by the SOLR
 * documentation
 */
public class RequestFacetFields
{
    @SerializedName("facets")
    private List<RequestFacetFieldsFacets> facets = new ArrayList<RequestFacetFieldsFacets>();

    public RequestFacetFields facets(List<RequestFacetFieldsFacets> facets)
    {
        this.facets = facets;
        return this;
    }

    public RequestFacetFields addFacetsItem(RequestFacetFieldsFacets facetsItem)
    {
        this.facets.add(facetsItem);
        return this;
    }

    /**
     * Define specifc fields on which to facet (adds SOLR facet.field and f.
     * <field>.facet.* options)
     * 
     * @return facets
     **/
    public List<RequestFacetFieldsFacets> getFacets()
    {
        return facets;
    }

    public void setFacets(List<RequestFacetFieldsFacets> facets)
    {
        this.facets = facets;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RequestFacetFields requestFacetFields = (RequestFacetFields) o;
        return Objects.equals(this.facets, requestFacetFields.facets);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(facets);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestFacetFields {\n");

        sb.append("    facets: ").append(toIndentedString(facets)).append("\n");
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
