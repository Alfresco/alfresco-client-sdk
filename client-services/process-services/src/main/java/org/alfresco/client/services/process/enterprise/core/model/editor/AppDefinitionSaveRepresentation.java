/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.editor;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

public class AppDefinitionSaveRepresentation extends AbstractRepresentation
{

    protected AppDefinitionRepresentation appDefinition;

    protected boolean publish;

    protected Boolean force;

    public AppDefinitionRepresentation getAppDefinition()
    {
        return appDefinition;
    }

    public void setAppDefinition(AppDefinitionRepresentation appDefinition)
    {
        this.appDefinition = appDefinition;
    }

    public boolean isPublish()
    {
        return publish;
    }

    public void setPublish(boolean publish)
    {
        this.publish = publish;
    }

    public Boolean getForce()
    {
        return force;
    }

    public void setForce(Boolean force)
    {
        this.force = force;
    }
}
