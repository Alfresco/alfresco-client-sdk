/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.runtime;

/**
 * @author Yvo Swillens
 */
public class ProcessInstanceVariableRepresentation
{

    private String id;

    private String type;

    private Object value;

    public ProcessInstanceVariableRepresentation()
    {
    }

    public ProcessInstanceVariableRepresentation(String id, String type, Object value)
    {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public String getId()
    {
        return id;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }
}
