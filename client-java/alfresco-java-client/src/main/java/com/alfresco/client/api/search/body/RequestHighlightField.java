package com.alfresco.client.api.search.body;

import java.math.BigDecimal;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * RequestHighlightFields
 */
public class RequestHighlightField
{
    @SerializedName("field")
    private String field = null;

    @SerializedName("snippetCount")
    private BigDecimal snippetCount = null;

    @SerializedName("fragmentSize")
    private BigDecimal fragmentSize = null;

    @SerializedName("mergeContiguous")
    private Boolean mergeContiguous = null;

    @SerializedName("prefix")
    private String prefix = null;

    @SerializedName("postfix")
    private String postfix = null;

    public RequestHighlightField field(String field)
    {
        this.field = field;
        return this;
    }

    /**
     * The name of the field to highlight.
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

    public RequestHighlightField snippetCount(BigDecimal snippetCount)
    {
        this.snippetCount = snippetCount;
        return this;
    }

    /**
     * Get snippetCount
     * 
     * @return snippetCount
     **/
    public BigDecimal getSnippetCount()
    {
        return snippetCount;
    }

    public void setSnippetCount(BigDecimal snippetCount)
    {
        this.snippetCount = snippetCount;
    }

    public RequestHighlightField fragmentSize(BigDecimal fragmentSize)
    {
        this.fragmentSize = fragmentSize;
        return this;
    }

    /**
     * Get fragmentSize
     * 
     * @return fragmentSize
     **/
    public BigDecimal getFragmentSize()
    {
        return fragmentSize;
    }

    public void setFragmentSize(BigDecimal fragmentSize)
    {
        this.fragmentSize = fragmentSize;
    }

    public RequestHighlightField mergeContiguous(Boolean mergeContiguous)
    {
        this.mergeContiguous = mergeContiguous;
        return this;
    }

    /**
     * Get mergeContiguous
     * 
     * @return mergeContiguous
     **/
    public Boolean getMergeContiguous()
    {
        return mergeContiguous;
    }

    public void setMergeContiguous(Boolean mergeContiguous)
    {
        this.mergeContiguous = mergeContiguous;
    }

    public RequestHighlightField prefix(String prefix)
    {
        this.prefix = prefix;
        return this;
    }

    /**
     * Get prefix
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

    public RequestHighlightField postfix(String postfix)
    {
        this.postfix = postfix;
        return this;
    }

    /**
     * Get postfix
     * 
     * @return postfix
     **/
    public String getPostfix()
    {
        return postfix;
    }

    public void setPostfix(String postfix)
    {
        this.postfix = postfix;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RequestHighlightField requestHighlightField = (RequestHighlightField) o;
        return Objects.equals(this.field, requestHighlightField.field)
                && Objects.equals(this.snippetCount, requestHighlightField.snippetCount)
                && Objects.equals(this.fragmentSize, requestHighlightField.fragmentSize)
                && Objects.equals(this.mergeContiguous, requestHighlightField.mergeContiguous)
                && Objects.equals(this.prefix, requestHighlightField.prefix)
                && Objects.equals(this.postfix, requestHighlightField.postfix);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(field, snippetCount, fragmentSize, mergeContiguous, prefix, postfix);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestHighlightFields {\n");

        sb.append("    field: ").append(toIndentedString(field)).append("\n");
        sb.append("    snippetCount: ").append(toIndentedString(snippetCount)).append("\n");
        sb.append("    fragmentSize: ").append(toIndentedString(fragmentSize)).append("\n");
        sb.append("    mergeContiguous: ").append(toIndentedString(mergeContiguous)).append("\n");
        sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
        sb.append("    postfix: ").append(toIndentedString(postfix)).append("\n");
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
