/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.runtime;

import java.util.Date;
import java.util.Map;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

/**
 * @author Yvo Swillens
 * @author Vasile Dirla
 */
public class DecisionAuditRepresentation extends AbstractRepresentation
{

    protected Long id;

    protected String activityId;

    protected String activityName;

    protected String executionId;

    protected String processInstanceId;

    protected String processDefinitionId;

    protected String decisionKey;

    protected String decisionName;

    protected Long dmnDeploymentId;

    protected boolean decisionExecutionFailed;

    protected Date created;

    protected String decisionModelJson;

    protected String auditTrailJson;

    protected Map<String, Object> renderedVariables;

    public DecisionAuditRepresentation()
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

    public String getActivityId()
    {
        return activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public String getActivityName()
    {
        return activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }

    public String getExecutionId()
    {
        return executionId;
    }

    public void setExecutionId(String executionId)
    {
        this.executionId = executionId;
    }

    public String getProcessInstanceId()
    {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId)
    {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessDefinitionId()
    {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId)
    {
        this.processDefinitionId = processDefinitionId;
    }

    public String getDecisionKey()
    {
        return decisionKey;
    }

    public void setDecisionKey(String decisionKey)
    {
        this.decisionKey = decisionKey;
    }

    public String getDecisionName()
    {
        return decisionName;
    }

    public void setDecisionName(String decisionName)
    {
        this.decisionName = decisionName;
    }

    public Long getDmnDeploymentId()
    {
        return dmnDeploymentId;
    }

    public void setDmnDeploymentId(Long dmnDeploymentId)
    {
        this.dmnDeploymentId = dmnDeploymentId;
    }

    public boolean isDecisionExecutionFailed()
    {
        return decisionExecutionFailed;
    }

    public void setDecisionExecutionFailed(boolean decisionExecutionFailed)
    {
        this.decisionExecutionFailed = decisionExecutionFailed;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public String getDecisionModelJson()
    {
        return decisionModelJson;
    }

    public void setDecisionModelJson(String decisionModelJson)
    {
        this.decisionModelJson = decisionModelJson;
    }

    public String getAuditTrailJson()
    {
        return auditTrailJson;
    }

    public void setAuditTrailJson(String auditTrailJson)
    {
        this.auditTrailJson = auditTrailJson;
    }

    public Map<String, Object> getRenderedVariables()
    {
        return renderedVariables;
    }

    public void setRenderedVariables(Map<String, Object> renderedVariables)
    {
        this.renderedVariables = renderedVariables;
    }
}
