/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.runtime;

/**
 * @author Vasile Dirla
 */
public class AuditLogFormDataRepresentation
{

    protected String fieldName;

    protected String fieldId;

    protected String value;

    public AuditLogFormDataRepresentation()
    {

    }

    public AuditLogFormDataRepresentation(String fieldName, String fieldId, String value)
    {
        this.fieldName = fieldName;
        this.fieldId = fieldId;
        this.value = value;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public String getFieldId()
    {
        return fieldId;
    }

    public void setFieldId(String fieldId)
    {
        this.fieldId = fieldId;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}