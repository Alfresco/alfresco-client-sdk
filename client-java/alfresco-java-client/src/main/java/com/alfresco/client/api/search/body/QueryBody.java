package com.alfresco.client.api.search.body;

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * QueryBody
 */
public class QueryBody
{
    @SerializedName("query")
    private RequestQuery query = null;

    @SerializedName("paging")
    private RequestPagination paging = null;

    @SerializedName("include")
    private List<String> include = null;

    @SerializedName("fields")
    private List<String> fields = null;

    @SerializedName("sort")
    private List<RequestSortDefinition> sort = null;

    @SerializedName("templates")
    private List<RequestTemplate> templates = null;

    @SerializedName("defaults")
    private RequestDefaults defaults = null;

    @SerializedName("filterQueries")
    private List<RequestFilterQuery> filterQueries = null;

    @SerializedName("facetQueries")
    private List<RequestFacetQuery> facetQueries = null;

    @SerializedName("facetFields")
    private RequestFacetFields facetFields = null;

    @SerializedName("spellcheck")
    private RequestSpellcheck spellcheck = null;

    @SerializedName("scope")
    private RequestScope scope = null;

    @SerializedName("limits")
    private RequestLimits limits = null;

    @SerializedName("highlight")
    private RequestHighlight highlight = null;

    public QueryBody query(RequestQuery query)
    {
        this.query = query;
        return this;
    }

    /**
     * Get query
     * 
     * @return query
     **/
    public RequestQuery getQuery()
    {
        return query;
    }

    public void setQuery(RequestQuery query)
    {
        this.query = query;
    }

    public QueryBody paging(RequestPagination paging)
    {
        this.paging = paging;
        return this;
    }

    /**
     * Get paging
     * 
     * @return paging
     **/
    public RequestPagination getPaging()
    {
        return paging;
    }

    public void setPaging(RequestPagination paging)
    {
        this.paging = paging;
    }

    public QueryBody include(List<String> include)
    {
        this.include = include;
        return this;
    }

    /**
     * Get include
     * 
     * @return include
     **/
    public List<String> getInclude()
    {
        return include;
    }

    public void setInclude(List<String> include)
    {
        this.include = include;
    }

    public QueryBody fields(List<String> fields)
    {
        this.fields = fields;
        return this;
    }

    /**
     * Get fields
     * 
     * @return fields
     **/
    public List<String> getFields()
    {
        return fields;
    }

    public void setFields(List<String> fields)
    {
        this.fields = fields;
    }

    public QueryBody sort(List<RequestSortDefinition> sort)
    {
        this.sort = sort;
        return this;
    }

    /**
     * Get sort
     * 
     * @return sort
     **/
    public List<RequestSortDefinition> getSort()
    {
        return sort;
    }

    public void setSort(List<RequestSortDefinition> sort)
    {
        this.sort = sort;
    }

    public QueryBody templates(List<RequestTemplate> templates)
    {
        this.templates = templates;
        return this;
    }

    /**
     * Get templates
     * 
     * @return templates
     **/
    public List<RequestTemplate> getTemplates()
    {
        return templates;
    }

    public void setTemplates(List<RequestTemplate> templates)
    {
        this.templates = templates;
    }

    public QueryBody defaults(RequestDefaults defaults)
    {
        this.defaults = defaults;
        return this;
    }

    /**
     * Get defaults
     * 
     * @return defaults
     **/
    public RequestDefaults getDefaults()
    {
        return defaults;
    }

    public void setDefaults(RequestDefaults defaults)
    {
        this.defaults = defaults;
    }

    public QueryBody filterQueries(List<RequestFilterQuery> filterQueries)
    {
        this.filterQueries = filterQueries;
        return this;
    }

    /**
     * Get filterQueries
     * 
     * @return filterQueries
     **/
    public List<RequestFilterQuery> getFilterQueries()
    {
        return filterQueries;
    }

    public void setFilterQueries(List<RequestFilterQuery> filterQueries)
    {
        this.filterQueries = filterQueries;
    }

    public QueryBody facetQueries(List<RequestFacetQuery> facetQueries)
    {
        this.facetQueries = facetQueries;
        return this;
    }

    /**
     * Get facetQueries
     * 
     * @return facetQueries
     **/
    public List<RequestFacetQuery> getFacetQueries()
    {
        return facetQueries;
    }

    public void setFacetQueries(List<RequestFacetQuery> facetQueries)
    {
        this.facetQueries = facetQueries;
    }

    public QueryBody facetFields(RequestFacetFields facetFields)
    {
        this.facetFields = facetFields;
        return this;
    }

    /**
     * Get facetFields
     * 
     * @return facetFields
     **/
    public RequestFacetFields getFacetFields()
    {
        return facetFields;
    }

    public void setFacetFields(RequestFacetFields facetFields)
    {
        this.facetFields = facetFields;
    }

    public QueryBody spellcheck(RequestSpellcheck spellcheck)
    {
        this.spellcheck = spellcheck;
        return this;
    }

    /**
     * Get spellcheck
     * 
     * @return spellcheck
     **/
    public RequestSpellcheck getSpellcheck()
    {
        return spellcheck;
    }

    public void setSpellcheck(RequestSpellcheck spellcheck)
    {
        this.spellcheck = spellcheck;
    }

    public QueryBody scope(RequestScope scope)
    {
        this.scope = scope;
        return this;
    }

    /**
     * Get scope
     * 
     * @return scope
     **/
    public RequestScope getScope()
    {
        return scope;
    }

    public void setScope(RequestScope scope)
    {
        this.scope = scope;
    }

    public QueryBody limits(RequestLimits limits)
    {
        this.limits = limits;
        return this;
    }

    /**
     * Get limits
     * 
     * @return limits
     **/
    public RequestLimits getLimits()
    {
        return limits;
    }

    public void setLimits(RequestLimits limits)
    {
        this.limits = limits;
    }

    public QueryBody highlight(RequestHighlight highlight)
    {
        this.highlight = highlight;
        return this;
    }

    /**
     * Get highlight
     * 
     * @return highlight
     **/
    public RequestHighlight getHighlight()
    {
        return highlight;
    }

    public void setHighlight(RequestHighlight highlight)
    {
        this.highlight = highlight;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        QueryBody queryBody = (QueryBody) o;
        return Objects.equals(this.query, queryBody.query) && Objects.equals(this.paging, queryBody.paging)
                && Objects.equals(this.include, queryBody.include) && Objects.equals(this.fields, queryBody.fields)
                && Objects.equals(this.sort, queryBody.sort) && Objects.equals(this.templates, queryBody.templates)
                && Objects.equals(this.defaults, queryBody.defaults)
                && Objects.equals(this.filterQueries, queryBody.filterQueries)
                && Objects.equals(this.facetQueries, queryBody.facetQueries)
                && Objects.equals(this.facetFields, queryBody.facetFields)
                && Objects.equals(this.spellcheck, queryBody.spellcheck) && Objects.equals(this.scope, queryBody.scope)
                && Objects.equals(this.limits, queryBody.limits) && Objects.equals(this.highlight, queryBody.highlight);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(query, paging, include, fields, sort, templates, defaults, filterQueries, facetQueries,
                facetFields, spellcheck, scope, limits, highlight);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class QueryBody {\n");

        sb.append("    query: ").append(toIndentedString(query)).append("\n");
        sb.append("    paging: ").append(toIndentedString(paging)).append("\n");
        sb.append("    include: ").append(toIndentedString(include)).append("\n");
        sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
        sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
        sb.append("    templates: ").append(toIndentedString(templates)).append("\n");
        sb.append("    defaults: ").append(toIndentedString(defaults)).append("\n");
        sb.append("    filterQueries: ").append(toIndentedString(filterQueries)).append("\n");
        sb.append("    facetQueries: ").append(toIndentedString(facetQueries)).append("\n");
        sb.append("    facetFields: ").append(toIndentedString(facetFields)).append("\n");
        sb.append("    spellcheck: ").append(toIndentedString(spellcheck)).append("\n");
        sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
        sb.append("    limits: ").append(toIndentedString(limits)).append("\n");
        sb.append("    highlight: ").append(toIndentedString(highlight)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o)
    {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
