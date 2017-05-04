package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * RestVariable
 */
public class RestVariable
{
    @SerializedName("name")
    private String name = null;

    @SerializedName("type")
    private String type = null;

    @SerializedName("value")
    private Object value = null;

    @SerializedName("valueUrl")
    private String valueUrl = null;

    @SerializedName("scope")
    private String scope = null;

    public RestVariable name(String name)
    {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * 
     * @return name
     **/
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get type
     * 
     * @return type
     **/
    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Get value
     * 
     * @return value
     **/
    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    /**
     * Get valueUrl
     * 
     * @return valueUrl
     **/
    public String getValueUrl()
    {
        return valueUrl;
    }

    public void setValueUrl(String valueUrl)
    {
        this.valueUrl = valueUrl;
    }

    /**
     * Get scope
     * 
     * @return scope
     **/
    public String getScope()
    {
        return scope;
    }

    public void setScope(String scope)
    {
        this.scope = scope;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RestVariable restVariable = (RestVariable) o;
        return Objects.equals(this.name, restVariable.name) && Objects.equals(this.type, restVariable.type)
                && Objects.equals(this.value, restVariable.value)
                && Objects.equals(this.valueUrl, restVariable.valueUrl)
                && Objects.equals(this.scope, restVariable.scope);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, type, value, valueUrl, scope);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestVariable {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    valueUrl: ").append(toIndentedString(valueUrl)).append("\n");
        sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
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
