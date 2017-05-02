/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.runtime;

import java.util.Date;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.editor.AppDefinitionRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.idm.LightUserRepresentation;

/**
 * @author Yvo Swillens
 */
public class AppDeploymentRepresentation extends AbstractRepresentation
{

    protected Long id;

    protected String deploymentId;

    protected Long dmnDeploymentId;

    protected Date created;

    protected LightUserRepresentation createdBy;

    protected AppDefinitionRepresentation appDefinition;

    public AppDeploymentRepresentation()
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

    public String getDeploymentId()
    {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId)
    {
        this.deploymentId = deploymentId;
    }

    public Long getDmnDeploymentId()
    {
        return dmnDeploymentId;
    }

    public void setDmnDeploymentId(Long dmnDeploymentId)
    {
        this.dmnDeploymentId = dmnDeploymentId;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public LightUserRepresentation getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(LightUserRepresentation createdBy)
    {
        this.createdBy = createdBy;
    }

    public AppDefinitionRepresentation getAppDefinition()
    {
        return appDefinition;
    }

    public void setAppDefinition(AppDefinitionRepresentation appDefinition)
    {
        this.appDefinition = appDefinition;
    }

}
