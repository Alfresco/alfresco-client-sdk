/*
 *  Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *  This file is part of Alfresco Activiti Client.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.alfresco.client.services.process.core.model.runtime;

import org.alfresco.client.services.process.core.model.common.AbstractRepresentation;

/**
 * Created by jpascal on 12/12/2014.
 */
public class ProcessDefinitionRepresentation extends AbstractRepresentation
{
    protected String id;

    protected String url;

    protected int version;

    protected String key;

    protected String category;

    protected boolean suspended;

    protected String name;

    protected String description;

    protected String deploymentId;

    protected String deploymentUrl;

    protected String graphicalNotationDefined;

    protected String resource;

    protected String diagramResource;

    protected boolean startFormDefined;

    public String getId()
    {
        return id;
    }

    public String getCategory()
    {
        return category;
    }

    public String getName()
    {
        return name;
    }

    public String getKey()
    {
        return key;
    }

    public String getDescription()
    {
        return description;
    }

    public int getVersion()
    {
        return version;
    }

    public String getResourceName()
    {
        return resource;
    }

    public String getDeploymentId()
    {
        return deploymentId;
    }

    public String getDiagramResourceName()
    {
        return diagramResource;
    }

    public boolean hasStartFormKey()
    {
        return startFormDefined;
    }

    public boolean hasGraphicalNotation()
    {
        return graphicalNotationDefined != null;
    }

    public boolean isSuspended()
    {
        return suspended;
    }

    public String getTenantId()
    {
        return null;
    }
}
