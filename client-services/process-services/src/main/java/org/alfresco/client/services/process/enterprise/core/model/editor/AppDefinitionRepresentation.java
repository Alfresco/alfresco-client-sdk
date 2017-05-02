/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.editor;

import java.util.Date;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

/**
 * Pojo representation of an app definition: the metadata (name, description,
 * etc) and the actual model ({@link AppDefinition} instance member).
 */
public class AppDefinitionRepresentation extends AbstractRepresentation
{

    private Long id;

    private String name;

    private String description;

    private Integer version;

    private Date created;

    private AppDefinition definition;

    public AppDefinitionRepresentation()
    {
        // Empty constructor for Jackson
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

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public AppDefinition getDefinition()
    {
        return definition;
    }

    public void setDefinition(AppDefinition definition)
    {
        this.definition = definition;
    }
}