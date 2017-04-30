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

import java.util.Date;
import java.util.List;

import org.alfresco.client.services.process.core.model.common.AbstractRepresentation;
import org.alfresco.client.services.process.core.model.idm.LightUserRepresentation;

/**
 * Created by jpascal on 12/12/2014.
 */
public class TaskRepresentation extends AbstractRepresentation
{
    protected String id;

    protected String name;

    protected String description;

    protected String category;

    protected LightUserRepresentation assignee;

    protected Date created;

    protected Date dueDate;

    protected Date endDate;

    protected Long duration;

    protected Integer priority;

    protected String processInstanceId;

    protected String processInstanceName;

    protected String processDefinitionId;

    protected String processDefinitionName;

    protected String processDefinitionDescription;

    protected String processDefinitionKey;

    protected String processDefinitionCategory;

    protected Integer processDefinitionVersion;

    protected String processDefinitionDeploymentId;

    protected String formKey;

    protected String processInstanceStartUserId;

    protected Boolean initiatorCanCompleteTask;

    protected Boolean isMemberOfCandidateGroup;

    protected Boolean isMemberOfCandidateUsers;

    protected String parentTaskId;

    protected String parentTaskName;

    protected Boolean adhocTaskCanBeReassigned;

    protected List<LightUserRepresentation> involvedPeople;

    public TaskRepresentation()
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public LightUserRepresentation getAssignee()
    {
        return assignee;
    }

    public void setAssignee(LightUserRepresentation assignee)
    {
        this.assignee = assignee;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public Date getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }

    public Integer getPriority()
    {
        return priority;
    }

    public void setPriority(Integer priority)
    {
        this.priority = priority;
    }

    public String getProcessInstanceId()
    {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId)
    {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessInstanceName()
    {
        return processInstanceName;
    }

    public void setProcessInstanceName(String processInstanceName)
    {
        this.processInstanceName = processInstanceName;
    }

    public String getProcessDefinitionId()
    {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId)
    {
        this.processDefinitionId = processDefinitionId;
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

    public Integer getProcessDefinitionVersion()
    {
        return processDefinitionVersion;
    }

    public void setProcessDefinitionVersion(Integer processDefinitionVersion)
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

    public String getFormKey()
    {
        return formKey;
    }

    public void setFormKey(String formKey)
    {
        this.formKey = formKey;
    }

    public String getProcessInstanceStartUserId()
    {
        return processInstanceStartUserId;
    }

    public void setProcessInstanceStartUserId(String processInstanceStartUserId)
    {
        this.processInstanceStartUserId = processInstanceStartUserId;
    }

    public Boolean isInitiatorCanCompleteTask()
    {
        return initiatorCanCompleteTask;
    }

    public void setInitiatorCanCompleteTask(Boolean initiatorCanCompleteTask)
    {
        this.initiatorCanCompleteTask = initiatorCanCompleteTask;
    }

    public Boolean isMemberOfCandidateGroup()
    {
        return isMemberOfCandidateGroup;
    }

    public void setMemberOfCandidateGroup(Boolean isMemberOfCandidateGroup)
    {
        this.isMemberOfCandidateGroup = isMemberOfCandidateGroup;
    }

    public Boolean isMemberOfCandidateUsers()
    {
        return isMemberOfCandidateUsers;
    }

    public void setMemberOfCandidateUsers(Boolean isMemberOfCandidateUsers)
    {
        this.isMemberOfCandidateUsers = isMemberOfCandidateUsers;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public Long getDuration()
    {
        return duration;
    }

    public void setDuration(Long duration)
    {
        this.duration = duration;
    }

    public List<LightUserRepresentation> getInvolvedPeople()
    {
        return involvedPeople;
    }

    public void setInvolvedPeople(List<LightUserRepresentation> involvedPeople)
    {
        this.involvedPeople = involvedPeople;
    }

    public String getParentTaskId()
    {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId)
    {
        this.parentTaskId = parentTaskId;
    }

    public String getParentTaskName()
    {
        return parentTaskName;
    }

    public void setParentTaskName(String parentTaskName)
    {
        this.parentTaskName = parentTaskName;
    }

    public Boolean isAdhocTaskCanBeReassigned()
    {
        return adhocTaskCanBeReassigned;
    }

    public void setAdhocTaskCanBeReassigned(boolean adhocTaskCanBeReassigned)
    {
        this.adhocTaskCanBeReassigned = adhocTaskCanBeReassigned;
    }
}
