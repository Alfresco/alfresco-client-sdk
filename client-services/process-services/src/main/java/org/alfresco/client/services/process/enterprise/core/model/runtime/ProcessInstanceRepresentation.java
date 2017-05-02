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

package org.alfresco.client.services.process.enterprise.core.model.runtime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.idm.LightUserRepresentation;

/**
 * Created by jpascal on 12/12/2014.
 */
public class ProcessInstanceRepresentation extends AbstractRepresentation
{
    protected String id;

    protected String name;

    protected String businessKey;

    protected String processDefinitionId;

    protected String tenantId;

    protected Date started;

    protected Date ended;

    protected LightUserRepresentation startedBy;

    protected String processDefinitionName;

    protected String processDefinitionDescription;

    protected String processDefinitionKey;

    protected String processDefinitionCategory;

    protected int processDefinitionVersion;

    protected String processDefinitionDeploymentId;

    protected boolean graphicalNotationDefined;

    protected boolean startFormDefined;

    protected List<RestVariable> variables = new ArrayList<RestVariable>();

    public ProcessInstanceRepresentation()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
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

    public LightUserRepresentation getStartedBy()
    {
        return startedBy;
    }

    public void setStartedBy(LightUserRepresentation startedBy)
    {
        this.startedBy = startedBy;
    }

    public String getBusinessKey()
    {
        return businessKey;
    }

    public void setBusinessKey(String businessKey)
    {
        this.businessKey = businessKey;
    }

    public String getProcessDefinitionId()
    {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId)
    {
        this.processDefinitionId = processDefinitionId;
    }

    public String getTenantId()
    {
        return tenantId;
    }

    public void setTenantId(String tenantId)
    {
        this.tenantId = tenantId;
    }

    public Date getStarted()
    {
        return started;
    }

    public void setStarted(Date started)
    {
        this.started = started;
    }

    public Date getEnded()
    {
        return ended;
    }

    public void setEnded(Date ended)
    {
        this.ended = ended;
    }

    public String getProcessDefinitionName()
    {
        return processDefinitionName;
    }

    public void setProcessDefinitionName(String processDefinitionName)
    {
        this.processDefinitionName = processDefinitionName;
    }

    public String getProcessDefinitionDescription()
    {
        return processDefinitionDescription;
    }

    public void setProcessDefinitionDescription(String processDefinitionDescription)
    {
        this.processDefinitionDescription = processDefinitionDescription;
    }

    public String getProcessDefinitionKey()
    {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey)
    {
        this.processDefinitionKey = processDefinitionKey;
    }

    public String getProcessDefinitionCategory()
    {
        return processDefinitionCategory;
    }

    public void setProcessDefinitionCategory(String processDefinitionCategory)
    {
        this.processDefinitionCategory = processDefinitionCategory;
    }

    public int getProcessDefinitionVersion()
    {
        return processDefinitionVersion;
    }

    public void setProcessDefinitionVersion(int processDefinitionVersion)
    {
        this.processDefinitionVersion = processDefinitionVersion;
    }

    public String getProcessDefinitionDeploymentId()
    {
        return processDefinitionDeploymentId;
    }

    public void setProcessDefinitionDeploymentId(String processDefinitionDeploymentId)
    {
        this.processDefinitionDeploymentId = processDefinitionDeploymentId;
    }

    public List<RestVariable> getVariables()
    {
        return variables;
    }

    public void setVariables(List<RestVariable> variables)
    {
        this.variables = variables;
    }

    public void addVariable(RestVariable variable)
    {
        variables.add(variable);
    }

    public boolean isGraphicalNotationDefined()
    {
        return graphicalNotationDefined;
    }

    public void setGraphicalNotationDefined(boolean graphicalNotationDefined)
    {
        this.graphicalNotationDefined = graphicalNotationDefined;
    }

    public boolean isStartFormDefined()
    {
        return startFormDefined;
    }

    public void setStartFormDefined(boolean startFormDefined)
    {
        this.startFormDefined = startFormDefined;
    }
}
