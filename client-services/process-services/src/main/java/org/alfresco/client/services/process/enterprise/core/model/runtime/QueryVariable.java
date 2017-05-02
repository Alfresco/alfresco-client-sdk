/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.runtime;

/**
 * @author Frederik Heremans
 */
public class QueryVariable
{

    private String name;

    private String operation;

    private Object value;

    private String type;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public QueryVariableOperation getVariableOperation()
    {
        if (operation == null) { return null; }
        return QueryVariableOperation.forFriendlyName(operation);
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public enum QueryVariableOperation
    {
        EQUALS("equals"), NOT_EQUALS("notEquals"), EQUALS_IGNORE_CASE("equalsIgnoreCase"), NOT_EQUALS_IGNORE_CASE(
                "notEqualsIgnoreCase"), LIKE("like"), LIKE_IGNORE_CASE("likeIgnoreCase"), GREATER_THAN(
                        "greaterThan"), GREATER_THAN_OR_EQUALS(
                                "greaterThanOrEquals"), LESS_THAN("lessThan"), LESS_THAN_OR_EQUALS("lessThanOrEquals");

        private String friendlyName;

        private QueryVariableOperation(String friendlyName)
        {
            this.friendlyName = friendlyName;
        }

        public String getFriendlyName()
        {
            return friendlyName;
        }

        public static QueryVariableOperation forFriendlyName(String friendlyName)
        {
            for (QueryVariableOperation type : values())
            {
                if (type.friendlyName.equals(friendlyName)) { return type; }
            }
            return null;
        }
    }

}
