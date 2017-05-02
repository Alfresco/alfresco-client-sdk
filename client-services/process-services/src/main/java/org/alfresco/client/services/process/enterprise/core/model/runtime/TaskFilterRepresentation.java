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

import java.util.Date;

/**
 * @author Bassam Al-Sarori Filter representation for saved or dynamic task
 *         filters' parameters.
 */
public class TaskFilterRepresentation extends FilterRepresentation
{

    protected String name;

    protected String state;

    protected String assignment;

    protected String processDefinitionId;

    protected String processDefinitionKey;

    protected Date dueBefore;

    protected Date dueAfter;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getAssignment()
    {
        return assignment;
    }

    public void setAssignment(String assignment)
    {
        this.assignment = assignment;
    }

    public Date getDueBefore()
    {
        return dueBefore;
    }

    public void setDueBefore(Date dueBefore)
    {
        this.dueBefore = dueBefore;
    }

    public Date getDueAfter()
    {
        return dueAfter;
    }

    public void setDueAfter(Date dueAfter)
    {
        this.dueAfter = dueAfter;
    }

    public String getProcessDefinitionId()
    {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId)
    {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessDefinitionKey()
    {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey)
    {
        this.processDefinitionKey = processDefinitionKey;
    }

}
