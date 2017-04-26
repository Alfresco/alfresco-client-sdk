package com.alfresco.client.api.search.body;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * RequestFacetFieldsFacets
 */
public class RequestFacetFieldsFacets
{
    @SerializedName("field")
    private String field = null;

    @SerializedName("prefix")
    private String prefix = null;

    /**
     * Gets or Sets sort
     */
    public enum SortEnum
    {
        @SerializedName("COUNT") COUNT("COUNT"),

        @SerializedName("INDEX") INDEX("INDEX");

        private String value;

        SortEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    @SerializedName("sort")
    private SortEnum sort = null;

    /**
     * Gets or Sets method
     */
    public enum MethodEnum
    {
        @SerializedName("ENUM") ENUM("ENUM"),

        @SerializedName("FC") FC("FC");

        private String value;

        MethodEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    @SerializedName("method")
    private MethodEnum method = null;

    @SerializedName("missing")
    private Boolean missing = false;

    @SerializedName("limit")
    private Integer limit = null;

    @SerializedName("offset")
    private Integer offset = null;

    @SerializedName("mincount")
    private Integer mincount = null;

    @SerializedName("facetEnumCacheMinDf")
    private Integer facetEnumCacheMinDf = null;

    @SerializedName("excludeFilters")
    private List<String> excludeFilters = new ArrayList<>();

    public RequestFacetFieldsFacets field(String field)
    {
        this.field = field;
        return this;
    }

    /**
     * The facet field
     * 
     * @return field
     **/
    public String getField()
    {
        return field;
    }

    public void setField(String field)
    {
        this.field = field;
    }

    public RequestFacetFieldsFacets prefix(String prefix)
    {
        this.prefix = prefix;
        return this;
    }

    /**
     * Restricts the possible constraints to only indexed values with a
     * specified prefix.
     * 
     * @return prefix
     **/
    public String getPrefix()
    {
        return prefix;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    public RequestFacetFieldsFacets sort(SortEnum sort)
    {
        this.sort = sort;
        return this;
    }

    /**
     * Get sort
     * 
     * @return sort
     **/
    public SortEnum getSort()
    {
        return sort;
    }

    public void setSort(SortEnum sort)
    {
        this.sort = sort;
    }

    public RequestFacetFieldsFacets method(MethodEnum method)
    {
        this.method = method;
        return this;
    }

    /**
     * Get method
     * 
     * @return method
     **/
    public MethodEnum getMethod()
    {
        return method;
    }

    public void setMethod(MethodEnum method)
    {
        this.method = method;
    }

    public RequestFacetFieldsFacets missing(Boolean missing)
    {
        this.missing = missing;
        return this;
    }

    /**
     * When true, count results that match the query but which have no facet
     * value for the field (in addition to the Term-based constraints).
     * 
     * @return missing
     **/
    public Boolean getMissing()
    {
        return missing;
    }

    public void setMissing(Boolean missing)
    {
        this.missing = missing;
    }

    public RequestFacetFieldsFacets limit(Integer limit)
    {
        this.limit = limit;
        return this;
    }

    /**
     * Get limit
     * 
     * @return limit
     **/
    public Integer getLimit()
    {
        return limit;
    }

    public void setLimit(Integer limit)
    {
        this.limit = limit;
    }

    public RequestFacetFieldsFacets offset(Integer offset)
    {
        this.offset = offset;
        return this;
    }

    /**
     * Get offset
     * 
     * @return offset
     **/
    public Integer getOffset()
    {
        return offset;
    }

    public void setOffset(Integer offset)
    {
        this.offset = offset;
    }

    public RequestFacetFieldsFacets mincount(Integer mincount)
    {
        this.mincount = mincount;
        return this;
    }

    /**
     * The minimum count required for a facet field to be included in the
     * response.
     * 
     * @return mincount
     **/
    public Integer getMincount()
    {
        return mincount;
    }

    public void setMincount(Integer mincount)
    {
        this.mincount = mincount;
    }

    public RequestFacetFieldsFacets facetEnumCacheMinDf(Integer facetEnumCacheMinDf)
    {
        this.facetEnumCacheMinDf = facetEnumCacheMinDf;
        return this;
    }

    /**
     * Get facetEnumCacheMinDf
     * 
     * @return facetEnumCacheMinDf
     **/
    public Integer getFacetEnumCacheMinDf()
    {
        return facetEnumCacheMinDf;
    }

    public void setFacetEnumCacheMinDf(Integer facetEnumCacheMinDf)
    {
        this.facetEnumCacheMinDf = facetEnumCacheMinDf;
    }

    public RequestFacetFieldsFacets excludeFilters(List<String> excludeFilters)
    {
        this.excludeFilters = excludeFilters;
        return this;
    }

    public RequestFacetFieldsFacets addExcludeFiltersItem(String excludeFiltersItem)
    {
        this.excludeFilters.add(excludeFiltersItem);
        return this;
    }

    /**
     * Filter Queries with tags listed here will not be included in facet
     * counts. This is used for multi-select facetting.
     * 
     * @return excludeFilters
     **/
    public List<String> getExcludeFilters()
    {
        return excludeFilters;
    }

    public void setExcludeFilters(List<String> excludeFilters)
    {
        this.excludeFilters = excludeFilters;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RequestFacetFieldsFacets requestFacetFieldsFacets = (RequestFacetFieldsFacets) o;
        return Objects.equals(this.field, requestFacetFieldsFacets.field)
                && Objects.equals(this.prefix, requestFacetFieldsFacets.prefix)
                && Objects.equals(this.sort, requestFacetFieldsFacets.sort)
                && Objects.equals(this.method, requestFacetFieldsFacets.method)
                && Objects.equals(this.missing, requestFacetFieldsFacets.missing)
                && Objects.equals(this.limit, requestFacetFieldsFacets.limit)
                && Objects.equals(this.offset, requestFacetFieldsFacets.offset)
                && Objects.equals(this.mincount, requestFacetFieldsFacets.mincount)
                && Objects.equals(this.facetEnumCacheMinDf, requestFacetFieldsFacets.facetEnumCacheMinDf)
                && Objects.equals(this.excludeFilters, requestFacetFieldsFacets.excludeFilters);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(field, prefix, sort, method, missing, limit, offset, mincount, facetEnumCacheMinDf,
                excludeFilters);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestFacetFieldsFacets {\n");

        sb.append("    field: ").append(toIndentedString(field)).append("\n");
        sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
        sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    missing: ").append(toIndentedString(missing)).append("\n");
        sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
        sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
        sb.append("    mincount: ").append(toIndentedString(mincount)).append("\n");
        sb.append("    facetEnumCacheMinDf: ").append(toIndentedString(facetEnumCacheMinDf)).append("\n");
        sb.append("    excludeFilters: ").append(toIndentedString(excludeFilters)).append("\n");
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
