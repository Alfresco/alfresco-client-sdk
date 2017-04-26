package com.alfresco.client.api.search.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * SearchEntry
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-26T16:18:20.726+02:00")
public class SearchEntry
{
    @SerializedName("score")
    private Float score = null;

    @SerializedName("highlight")
    private List<SearchEntryHighlight> highlight = new ArrayList<SearchEntryHighlight>();

    public SearchEntry score(Float score)
    {
        this.score = score;
        return this;
    }

    /**
     * The score for this row
     * 
     * @return score
     **/
    public Float getScore()
    {
        return score;
    }

    public void setScore(Float score)
    {
        this.score = score;
    }

    public SearchEntry highlight(List<SearchEntryHighlight> highlight)
    {
        this.highlight = highlight;
        return this;
    }

    public SearchEntry addHighlightItem(SearchEntryHighlight highlightItem)
    {
        this.highlight.add(highlightItem);
        return this;
    }

    /**
     * Highlight fragments if requested and available. A match can happen in any
     * of the requested field.
     * 
     * @return highlight
     **/
    public List<SearchEntryHighlight> getHighlight()
    {
        return highlight;
    }

    public void setHighlight(List<SearchEntryHighlight> highlight)
    {
        this.highlight = highlight;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SearchEntry searchEntry = (SearchEntry) o;
        return Objects.equals(this.score, searchEntry.score) && Objects.equals(this.highlight, searchEntry.highlight);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(score, highlight);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class SearchEntry {\n");

        sb.append("    score: ").append(toIndentedString(score)).append("\n");
        sb.append("    highlight: ").append(toIndentedString(highlight)).append("\n");
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
