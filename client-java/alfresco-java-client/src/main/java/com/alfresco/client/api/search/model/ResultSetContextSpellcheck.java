package com.alfresco.client.api.search.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * ResultSetContextSpellcheck
 */
public class ResultSetContextSpellcheck
{
    /**
     * Gets or Sets type
     */
    public enum TypeEnum
    {
        @SerializedName("searchInsteadFor") SEARCHINSTEADFOR("searchInsteadFor"),

        @SerializedName("didYouMean") DIDYOUMEAN("didYouMean");

        private String value;

        TypeEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    @SerializedName("type")
    private TypeEnum type = null;

    @SerializedName("suggestion")
    private List<String> suggestion = new ArrayList<String>();

    public ResultSetContextSpellcheck type(TypeEnum type)
    {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * 
     * @return type
     **/
    public TypeEnum getType()
    {
        return type;
    }

    public void setType(TypeEnum type)
    {
        this.type = type;
    }

    public ResultSetContextSpellcheck suggestion(List<String> suggestion)
    {
        this.suggestion = suggestion;
        return this;
    }

    public ResultSetContextSpellcheck addSuggestionItem(String suggestionItem)
    {
        this.suggestion.add(suggestionItem);
        return this;
    }

    /**
     * A suggested alternative query
     * 
     * @return suggestion
     **/
    public List<String> getSuggestion()
    {
        return suggestion;
    }

    public void setSuggestion(List<String> suggestion)
    {
        this.suggestion = suggestion;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResultSetContextSpellcheck resultSetContextSpellcheck = (ResultSetContextSpellcheck) o;
        return Objects.equals(this.type, resultSetContextSpellcheck.type)
                && Objects.equals(this.suggestion, resultSetContextSpellcheck.suggestion);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(type, suggestion);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResultSetContextSpellcheck {\n");

        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    suggestion: ").append(toIndentedString(suggestion)).append("\n");
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
