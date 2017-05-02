/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.runtime;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

/**
 * REST representation of a runtime form
 *
 * @author Yvo Swillens
 */
public class RuntimeFormRepresentation extends AbstractRepresentation
{

    protected Long id;

    protected String name;

    protected String description;

    protected Long modelId;

    protected Long appDefinitionId;

    protected Long appDeploymentId;

    protected Long tenantId;

    public RuntimeFormRepresentation()
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

    public Long getModelId()
    {
        return modelId;
    }

    public void setModelId(Long modelId)
    {
        this.modelId = modelId;
    }

    public Long getAppDefinitionId()
    {
        return appDefinitionId;
    }

    public void setAppDefinitionId(Long appDefinitionId)
    {
        this.appDefinitionId = appDefinitionId;
    }

    public Long getAppDeploymentId()
    {
        return appDeploymentId;
    }

    public void setAppDeploymentId(Long appDeploymentId)
    {
        this.appDeploymentId = appDeploymentId;
    }

    public Long getTenantId()
    {
        return tenantId;
    }

    public void setTenantId(Long tenantId)
    {
        this.tenantId = tenantId;
    }

}