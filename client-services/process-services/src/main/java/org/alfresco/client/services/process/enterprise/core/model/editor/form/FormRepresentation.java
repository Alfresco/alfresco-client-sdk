/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.editor.form;

import java.util.Date;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

public class FormRepresentation extends AbstractRepresentation
{

    protected Long id;

    protected String name;

    protected String description;

    protected Integer version;

    protected Long lastUpdatedBy;

    protected String lastUpdatedByFullName;

    protected Date lastUpdated;

    protected Long stencilSetId;

    protected Long referenceId;

    protected FormDefinitionRepresentation formDefinition;

    public FormRepresentation()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public Long getLastUpdatedBy()
    {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy)
    {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedByFullName()
    {
        return lastUpdatedByFullName;
    }

    public void setLastUpdatedByFullName(String lastUpdatedByFullName)
    {
        this.lastUpdatedByFullName = lastUpdatedByFullName;
    }

    public Date getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public Long getStencilSetId()
    {
        return stencilSetId;
    }

    public void setStencilSetId(Long stencilSetId)
    {
        this.stencilSetId = stencilSetId;
    }

    public Long getReferenceId()
    {
        return referenceId;
    }

    public void setReferenceId(Long referenceId)
    {
        this.referenceId = referenceId;
    }

    public FormDefinitionRepresentation getFormDefinition()
    {
        return formDefinition;
    }

    public void setFormDefinition(FormDefinitionRepresentation formDefinition)
    {
        this.formDefinition = formDefinition;
    }
}
