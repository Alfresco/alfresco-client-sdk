package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * QueryVariable
 */
public class QueryVariable
{
    @SerializedName("name")
    private String name = null;

    @SerializedName("operation")
    private String operation = null;

    @SerializedName("value")
    private Object value = null;

    @SerializedName("type")
    private String type = null;

    /**
     * Gets or Sets variableOperation
     */
    public enum VariableOperationEnum
    {
        @SerializedName("EQUALS") EQUALS("EQUALS"),

        @SerializedName("NOT_EQUALS") NOT_EQUALS("NOT_EQUALS"),

        @SerializedName("EQUALS_IGNORE_CASE") EQUALS_IGNORE_CASE("EQUALS_IGNORE_CASE"),

        @SerializedName("NOT_EQUALS_IGNORE_CASE") NOT_EQUALS_IGNORE_CASE("NOT_EQUALS_IGNORE_CASE"),

        @SerializedName("LIKE") LIKE("LIKE"),

        @SerializedName("LIKE_IGNORE_CASE") LIKE_IGNORE_CASE("LIKE_IGNORE_CASE"),

        @SerializedName("GREATER_THAN") GREATER_THAN("GREATER_THAN"),

        @SerializedName("GREATER_THAN_OR_EQUALS") GREATER_THAN_OR_EQUALS("GREATER_THAN_OR_EQUALS"),

        @SerializedName("LESS_THAN") LESS_THAN("LESS_THAN"),

        @SerializedName("LESS_THAN_OR_EQUALS") LESS_THAN_OR_EQUALS("LESS_THAN_OR_EQUALS");

        private String value;

        VariableOperationEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    @SerializedName("variableOperation")
    private VariableOperationEnum variableOperation = null;

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
     * Get operation
     * 
     * @return operation
     **/
    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
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
     * Get variableOperation
     * 
     * @return variableOperation
     **/
    public VariableOperationEnum getVariableOperation()
    {
        return variableOperation;
    }

    public void setVariableOperation(VariableOperationEnum variableOperation)
    {
        this.variableOperation = variableOperation;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        QueryVariable queryVariable = (QueryVariable) o;
        return Objects.equals(this.name, queryVariable.name) && Objects.equals(this.operation, queryVariable.operation)
                && Objects.equals(this.value, queryVariable.value) && Objects.equals(this.type, queryVariable.type)
                && Objects.equals(this.variableOperation, queryVariable.variableOperation);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, operation, value, type, variableOperation);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class QueryVariable {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    variableOperation: ").append(toIndentedString(variableOperation)).append("\n");
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
