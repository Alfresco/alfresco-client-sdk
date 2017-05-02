/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.runtime;

import java.util.Date;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

/**
 * REST representation of a decision task.
 *
 * @author Yvo Swillens
 */
public class DecisionTaskRepresentation extends AbstractRepresentation
{

    protected Long id;

    protected String activityId;

    protected String activityName;

    protected String executionId;

    protected String processInstanceId;

    protected String processDefinitionId;

    protected Long dmnDeploymentId;

    protected String decisionKey;

    protected String decisionName;

    protected Boolean decisionExecutionFailed;

    protected Date decisionExecutionEnded;

    public DecisionTaskRepresentation()
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

    public void setActivityId(String id)
    {
        this.activityId = activityId;
    }

    public String getActivityName()
    {
        return activityName;
    }

    public void setActivityName(String name)
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

    public String getProcessDefinitionKey()
    {
        return executionId;
    }

    public void setProcessDefinitionKey(String processDefinitionKey)
    {
        this.executionId = processDefinitionKey;
    }

    public Long getDmnDeploymentId()
    {
        return dmnDeploymentId;
    }

    public void setDmnDeploymentId(Long dmnDeploymentId)
    {
        this.dmnDeploymentId = dmnDeploymentId;
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

    public Boolean getDecisionExecutionFailed()
    {
        return decisionExecutionFailed;
    }

    public void setDecisionExecutionFailed(Boolean decisionExecutionFailed)
    {
        this.decisionExecutionFailed = decisionExecutionFailed;
    }

    public Date getDecisionExecutionEnded()
    {
        return decisionExecutionEnded;
    }

    public void setDecisionExecutionEnded(Date decisionExecutionEnded)
    {
        this.decisionExecutionEnded = decisionExecutionEnded;
    }
}
