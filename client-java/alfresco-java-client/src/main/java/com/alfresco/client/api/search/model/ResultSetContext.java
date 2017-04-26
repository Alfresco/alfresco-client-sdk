package com.alfresco.client.api.search.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Context that applies to the whole result set
 */
public class ResultSetContext
{
    @SerializedName("consistency")
    private ResponseConsistency consistency = null;

    @SerializedName("facetQueries")
    private List<ResultSetContextFacetQueries> facetQueries = new ArrayList<ResultSetContextFacetQueries>();

    @SerializedName("facetsFields")
    private List<ResultSetContextFacetFields> facetFields = new ArrayList<ResultSetContextFacetFields>();

    @SerializedName("spellcheck")
    private List<ResultSetContextSpellcheck> spellcheck = new ArrayList<ResultSetContextSpellcheck>();

    public ResultSetContext consistency(ResponseConsistency consistency)
    {
        this.consistency = consistency;
        return this;
    }

    /**
     * Get consistency
     * 
     * @return consistency
     **/
    public ResponseConsistency getConsistency()
    {
        return consistency;
    }

    public void setConsistency(ResponseConsistency consistency)
    {
        this.consistency = consistency;
    }

    public ResultSetContext facetQueries(List<ResultSetContextFacetQueries> facetQueries)
    {
        this.facetQueries = facetQueries;
        return this;
    }

    public ResultSetContext addFacetQueriesItem(ResultSetContextFacetQueries facetQueriesItem)
    {
        this.facetQueries.add(facetQueriesItem);
        return this;
    }

    /**
     * The counts from facet queries
     * 
     * @return facetQueries
     **/
    public List<ResultSetContextFacetQueries> getFacetQueries()
    {
        return facetQueries;
    }

    public void setFacetQueries(List<ResultSetContextFacetQueries> facetQueries)
    {
        this.facetQueries = facetQueries;
    }

    public ResultSetContext facetFields(List<ResultSetContextFacetFields> facetFields)
    {
        this.facetFields = facetFields;
        return this;
    }

    public ResultSetContext addFacetFieldsItem(ResultSetContextFacetFields facetFieldsItem)
    {
        this.facetFields.add(facetFieldsItem);
        return this;
    }

    /**
     * The counts from field facets
     * 
     * @return facetFields
     **/
    public List<ResultSetContextFacetFields> getFacetFields()
    {
        return facetFields;
    }

    public void setFacetFields(List<ResultSetContextFacetFields> facetFields)
    {
        this.facetFields = facetFields;
    }

    public ResultSetContext spellcheck(List<ResultSetContextSpellcheck> spellcheck)
    {
        this.spellcheck = spellcheck;
        return this;
    }

    public ResultSetContext addSpellcheckItem(ResultSetContextSpellcheck spellcheckItem)
    {
        this.spellcheck.add(spellcheckItem);
        return this;
    }

    /**
     * Suggested corrections If zero results were found for the original query
     * then a single entry of type \
     * "searchInsteadFor\" will be returned. If alternatives were found that return more results than the original query they are returned as \"didYouMean\"
     * options. The highest quality suggestion is first.
     * 
     * @return spellcheck
     **/
    public List<ResultSetContextSpellcheck> getSpellcheck()
    {
        return spellcheck;
    }

    public void setSpellcheck(List<ResultSetContextSpellcheck> spellcheck)
    {
        this.spellcheck = spellcheck;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResultSetContext resultSetContext = (ResultSetContext) o;
        return Objects.equals(this.consistency, resultSetContext.consistency)
                && Objects.equals(this.facetQueries, resultSetContext.facetQueries)
                && Objects.equals(this.facetFields, resultSetContext.facetFields)
                && Objects.equals(this.spellcheck, resultSetContext.spellcheck);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(consistency, facetQueries, facetFields, spellcheck);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResultSetContext {\n");

        sb.append("    consistency: ").append(toIndentedString(consistency)).append("\n");
        sb.append("    facetQueries: ").append(toIndentedString(facetQueries)).append("\n");
        sb.append("    facetFields: ").append(toIndentedString(facetFields)).append("\n");
        sb.append("    spellcheck: ").append(toIndentedString(spellcheck)).append("\n");
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
