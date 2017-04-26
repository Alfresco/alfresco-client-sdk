package com.alfresco.client.api.search.body;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Request that highlight fragments to be added to result set rows The
 * properties reflect SOLR highlighting parameters.
 */
public class RequestHighlight
{
    @SerializedName("prefix")
    private String prefix = null;

    @SerializedName("postfix")
    private String postfix = null;

    @SerializedName("snippetCount")
    private BigDecimal snippetCount = null;

    @SerializedName("fragmentSize")
    private BigDecimal fragmentSize = null;

    @SerializedName("maxAnalyzedChars")
    private BigDecimal maxAnalyzedChars = null;

    @SerializedName("mergeContiguous")
    private Boolean mergeContiguous = null;

    @SerializedName("usePhraseHighlighter")
    private Boolean usePhraseHighlighter = null;

    @SerializedName("fields")
    private List<RequestHighlightField> fields = new ArrayList<RequestHighlightField>();

    public RequestHighlight prefix(String prefix)
    {
        this.prefix = prefix;
        return this;
    }

    /**
     * The string used to mark the start of a highlight in a fragment.
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

    public RequestHighlight postfix(String postfix)
    {
        this.postfix = postfix;
        return this;
    }

    /**
     * The string used to mark the end of a highlight in a fragment.
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

    public RequestHighlight snippetCount(BigDecimal snippetCount)
    {
        this.snippetCount = snippetCount;
        return this;
    }

    /**
     * The maximum number of distinct highlight snippets to return for each
     * highlight field.
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

    public RequestHighlight fragmentSize(BigDecimal fragmentSize)
    {
        this.fragmentSize = fragmentSize;
        return this;
    }

    /**
     * The character length of each snippet.
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

    public RequestHighlight maxAnalyzedChars(BigDecimal maxAnalyzedChars)
    {
        this.maxAnalyzedChars = maxAnalyzedChars;
        return this;
    }

    /**
     * The number of characters to be considered for highlighting. Matches after
     * this count will not be shown.
     * 
     * @return maxAnalyzedChars
     **/
    public BigDecimal getMaxAnalyzedChars()
    {
        return maxAnalyzedChars;
    }

    public void setMaxAnalyzedChars(BigDecimal maxAnalyzedChars)
    {
        this.maxAnalyzedChars = maxAnalyzedChars;
    }

    public RequestHighlight mergeContiguous(Boolean mergeContiguous)
    {
        this.mergeContiguous = mergeContiguous;
        return this;
    }

    /**
     * If fragments over lap they can be merged into one larger fragment
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

    public RequestHighlight usePhraseHighlighter(Boolean usePhraseHighlighter)
    {
        this.usePhraseHighlighter = usePhraseHighlighter;
        return this;
    }

    /**
     * Should phrases be identified.
     * 
     * @return usePhraseHighlighter
     **/
    public Boolean getUsePhraseHighlighter()
    {
        return usePhraseHighlighter;
    }

    public void setUsePhraseHighlighter(Boolean usePhraseHighlighter)
    {
        this.usePhraseHighlighter = usePhraseHighlighter;
    }

    public RequestHighlight fields(List<RequestHighlightField> fields)
    {
        this.fields = fields;
        return this;
    }

    public RequestHighlight addFieldsItem(RequestHighlightField fieldsItem)
    {
        this.fields.add(fieldsItem);
        return this;
    }

    /**
     * The fields to highlight and field specific configuration properties for
     * each field
     * 
     * @return fields
     **/
    public List<RequestHighlightField> getFields()
    {
        return fields;
    }

    public void setFields(List<RequestHighlightField> fields)
    {
        this.fields = fields;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RequestHighlight requestHighlight = (RequestHighlight) o;
        return Objects.equals(this.prefix, requestHighlight.prefix)
                && Objects.equals(this.postfix, requestHighlight.postfix)
                && Objects.equals(this.snippetCount, requestHighlight.snippetCount)
                && Objects.equals(this.fragmentSize, requestHighlight.fragmentSize)
                && Objects.equals(this.maxAnalyzedChars, requestHighlight.maxAnalyzedChars)
                && Objects.equals(this.mergeContiguous, requestHighlight.mergeContiguous)
                && Objects.equals(this.usePhraseHighlighter, requestHighlight.usePhraseHighlighter)
                && Objects.equals(this.fields, requestHighlight.fields);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(prefix, postfix, snippetCount, fragmentSize, maxAnalyzedChars, mergeContiguous,
                usePhraseHighlighter, fields);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestHighlight {\n");

        sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
        sb.append("    postfix: ").append(toIndentedString(postfix)).append("\n");
        sb.append("    snippetCount: ").append(toIndentedString(snippetCount)).append("\n");
        sb.append("    fragmentSize: ").append(toIndentedString(fragmentSize)).append("\n");
        sb.append("    maxAnalyzedChars: ").append(toIndentedString(maxAnalyzedChars)).append("\n");
        sb.append("    mergeContiguous: ").append(toIndentedString(mergeContiguous)).append("\n");
        sb.append("    usePhraseHighlighter: ").append(toIndentedString(usePhraseHighlighter)).append("\n");
        sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
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
