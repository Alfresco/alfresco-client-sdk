/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.runtime;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasile Dirla
 */
public class ProcessInstanceAuditInfoRepresentation
{

    protected String processInstanceId;

    protected String processInstanceName;

    protected String processDefinitionName;

    protected String processDefinitionVersion;

    protected String processInstanceStartTime;

    protected String processInstanceEndTime;

    protected Long processInstanceDurationInMillis;

    protected String processInstanceInitiator;

    protected List<AuditLogEntryRepresentation> entries = new ArrayList<AuditLogEntryRepresentation>();

    protected AuditDecisionInfoRepresentation decisionInfo = new AuditDecisionInfoRepresentation();

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

    public String getProcessDefinitionName()
    {
        return processDefinitionName;
    }

    public void setProcessDefinitionName(String processDefinitionName)
    {
        this.processDefinitionName = processDefinitionName;
    }

    public String getProcessDefinitionVersion()
    {
        return processDefinitionVersion;
    }

    public void setProcessDefinitionVersion(String processDefinitionVersion)
    {
        this.processDefinitionVersion = processDefinitionVersion;
    }

    public String getProcessInstanceStartTime()
    {
        return processInstanceStartTime;
    }

    public void setProcessInstanceStartTime(String processInstanceStartTime)
    {
        this.processInstanceStartTime = processInstanceStartTime;
    }

    public String getProcessInstanceEndTime()
    {
        return processInstanceEndTime;
    }

    public void setProcessInstanceEndTime(String processInstanceEndTime)
    {
        this.processInstanceEndTime = processInstanceEndTime;
    }

    public String getProcessInstanceInitiator()
    {
        return processInstanceInitiator;
    }

    public void setProcessInstanceInitiator(String processInstanceInitiator)
    {
        this.processInstanceInitiator = processInstanceInitiator;
    }

    public List<AuditLogEntryRepresentation> getEntries()
    {
        return entries;
    }

    public void setEntries(List<AuditLogEntryRepresentation> entries)
    {
        this.entries = entries;
    }

    public AuditDecisionInfoRepresentation getDecisionInfo()
    {
        return decisionInfo;
    }

    public void setDecisionInfo(AuditDecisionInfoRepresentation decisionInfo)
    {
        this.decisionInfo = decisionInfo;
    }

    public void setProcessInstanceDurationInMillis(Long durationInMillis)
    {
        this.processInstanceDurationInMillis = durationInMillis;
    }

    public Long getProcessInstanceDurationInMillis()
    {
        return processInstanceDurationInMillis;
    }
}
