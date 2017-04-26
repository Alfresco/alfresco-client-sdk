package com.alfresco.client.api.search.body;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Common query defaults
 */
public class RequestDefaults
{
    @SerializedName("textAttributes")
    private List<String> textAttributes = new ArrayList<String>();

    /**
     * The default way to combine query parts when AND or OR is not explicitly
     * stated - includes ! - + one two three (one two three)
     */
    public enum DefaultFTSOperatorEnum
    {
        @SerializedName("AND") AND("AND"),

        @SerializedName("OR") OR("OR");

        private String value;

        DefaultFTSOperatorEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    @SerializedName("defaultFTSOperator")
    private DefaultFTSOperatorEnum defaultFTSOperator = DefaultFTSOperatorEnum.AND;

    /**
     * The default way to combine query parts in field query groups when AND or
     * OR is not explicitly stated - includes ! - + FIELD:(one two three)
     */
    public enum DefaultFTSFieldOperatorEnum
    {
        @SerializedName("AND") AND("AND"),

        @SerializedName("OR") OR("OR");

        private String value;

        DefaultFTSFieldOperatorEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    @SerializedName("defaultFTSFieldOperator")
    private DefaultFTSFieldOperatorEnum defaultFTSFieldOperator = DefaultFTSFieldOperatorEnum.AND;

    @SerializedName("namespace")
    private String namespace = "cm";

    @SerializedName("defaultFieldName")
    private String defaultFieldName = "TEXT";

    public RequestDefaults textAttributes(List<String> textAttributes)
    {
        this.textAttributes = textAttributes;
        return this;
    }

    public RequestDefaults addTextAttributesItem(String textAttributesItem)
    {
        this.textAttributes.add(textAttributesItem);
        return this;
    }

    /**
     * A list of query fields/properties used to expand TEXT: queries. The
     * default is cm:content. You could include all content properties using
     * d:content or list all individual content properties or types. As more
     * terms are included the query size, complexity, memory impact and query
     * time will increase.
     * 
     * @return textAttributes
     **/
    public List<String> getTextAttributes()
    {
        return textAttributes;
    }

    public void setTextAttributes(List<String> textAttributes)
    {
        this.textAttributes = textAttributes;
    }

    public RequestDefaults defaultFTSOperator(DefaultFTSOperatorEnum defaultFTSOperator)
    {
        this.defaultFTSOperator = defaultFTSOperator;
        return this;
    }

    /**
     * The default way to combine query parts when AND or OR is not explicitly
     * stated - includes ! - + one two three (one two three)
     * 
     * @return defaultFTSOperator
     **/
    public DefaultFTSOperatorEnum getDefaultFTSOperator()
    {
        return defaultFTSOperator;
    }

    public void setDefaultFTSOperator(DefaultFTSOperatorEnum defaultFTSOperator)
    {
        this.defaultFTSOperator = defaultFTSOperator;
    }

    public RequestDefaults defaultFTSFieldOperator(DefaultFTSFieldOperatorEnum defaultFTSFieldOperator)
    {
        this.defaultFTSFieldOperator = defaultFTSFieldOperator;
        return this;
    }

    /**
     * The default way to combine query parts in field query groups when AND or
     * OR is not explicitly stated - includes ! - + FIELD:(one two three)
     * 
     * @return defaultFTSFieldOperator
     **/
    public DefaultFTSFieldOperatorEnum getDefaultFTSFieldOperator()
    {
        return defaultFTSFieldOperator;
    }

    public void setDefaultFTSFieldOperator(DefaultFTSFieldOperatorEnum defaultFTSFieldOperator)
    {
        this.defaultFTSFieldOperator = defaultFTSFieldOperator;
    }

    public RequestDefaults namespace(String namespace)
    {
        this.namespace = namespace;
        return this;
    }

    /**
     * The default name space to use if one is not provided
     * 
     * @return namespace
     **/
    public String getNamespace()
    {
        return namespace;
    }

    public void setNamespace(String namespace)
    {
        this.namespace = namespace;
    }

    public RequestDefaults defaultFieldName(String defaultFieldName)
    {
        this.defaultFieldName = defaultFieldName;
        return this;
    }

    /**
     * Get defaultFieldName
     * 
     * @return defaultFieldName
     **/
    public String getDefaultFieldName()
    {
        return defaultFieldName;
    }

    public void setDefaultFieldName(String defaultFieldName)
    {
        this.defaultFieldName = defaultFieldName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RequestDefaults requestDefaults = (RequestDefaults) o;
        return Objects.equals(this.textAttributes, requestDefaults.textAttributes)
                && Objects.equals(this.defaultFTSOperator, requestDefaults.defaultFTSOperator)
                && Objects.equals(this.defaultFTSFieldOperator, requestDefaults.defaultFTSFieldOperator)
                && Objects.equals(this.namespace, requestDefaults.namespace)
                && Objects.equals(this.defaultFieldName, requestDefaults.defaultFieldName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(textAttributes, defaultFTSOperator, defaultFTSFieldOperator, namespace, defaultFieldName);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestDefaults {\n");

        sb.append("    textAttributes: ").append(toIndentedString(textAttributes)).append("\n");
        sb.append("    defaultFTSOperator: ").append(toIndentedString(defaultFTSOperator)).append("\n");
        sb.append("    defaultFTSFieldOperator: ").append(toIndentedString(defaultFTSFieldOperator)).append("\n");
        sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
        sb.append("    defaultFieldName: ").append(toIndentedString(defaultFieldName)).append("\n");
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
