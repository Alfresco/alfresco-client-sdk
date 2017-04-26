package com.alfresco.client.api.search.body;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * RequestSortDefinitionInner
 */
public class RequestSortDefinition
{
    /**
     * How to order - using a field, when position of the document in the index,
     * score/relevence.
     */
    public enum TypeEnum
    {
        @SerializedName("FIELD") FIELD("FIELD"),

        @SerializedName("DOCUMENT") DOCUMENT("DOCUMENT"),

        @SerializedName("SCORE") SCORE("SCORE");

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
    private TypeEnum type = TypeEnum.FIELD;

    @SerializedName("field")
    private String field = null;

    @SerializedName("ascending")
    private Boolean ascending = false;

    public RequestSortDefinition type(TypeEnum type)
    {
        this.type = type;
        return this;
    }

    /**
     * How to order - using a field, when position of the document in the index,
     * score/relevence.
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

    public RequestSortDefinition field(String field)
    {
        this.field = field;
        return this;
    }

    /**
     * The name of the field
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

    public RequestSortDefinition ascending(Boolean ascending)
    {
        this.ascending = ascending;
        return this;
    }

    /**
     * The sort order. (The ordering of nulls is determined by the SOLR
     * configuration)
     *
     * @return ascending
     **/
    public Boolean getAscending()
    {
        return ascending;
    }

    public void setAscending(Boolean ascending)
    {
        this.ascending = ascending;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RequestSortDefinition requestSortDefinition = (RequestSortDefinition) o;
        return Objects.equals(this.type, requestSortDefinition.type)
                && Objects.equals(this.field, requestSortDefinition.field)
                && Objects.equals(this.ascending, requestSortDefinition.ascending);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(type, field, ascending);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestSortDefinitionInner {\n");

        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    field: ").append(toIndentedString(field)).append("\n");
        sb.append("    ascending: ").append(toIndentedString(ascending)).append("\n");
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
