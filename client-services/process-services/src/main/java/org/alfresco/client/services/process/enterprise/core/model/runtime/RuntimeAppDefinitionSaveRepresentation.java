/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.runtime;

import java.util.List;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.editor.AppDefinitionRepresentation;

public class RuntimeAppDefinitionSaveRepresentation extends AbstractRepresentation
{

    private List<AppDefinitionRepresentation> appDefinitions;

    public List<AppDefinitionRepresentation> getAppDefinitions()
    {
        return appDefinitions;
    }

    public void setAppDefinitions(List<AppDefinitionRepresentation> appDefinitions)
    {
        this.appDefinitions = appDefinitions;
    }
}
