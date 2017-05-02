/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.editor.model;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

/**
 * @author Tijs Rademakers
 */
public class DataSourceRepresentation extends AbstractRepresentation
{

    protected Long id;

    protected Long tenantId;

    protected String name;

    protected DataSourceConfigRepresentation config;

    public DataSourceRepresentation()
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

    public Long getTenantId()
    {
        return tenantId;
    }

    public void setTenantId(Long tenantId)
    {
        this.tenantId = tenantId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public DataSourceConfigRepresentation getConfig()
    {
        return config;
    }

    public void setConfig(DataSourceConfigRepresentation config)
    {
        this.config = config;
    }
}
