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
public class AuditLogEntryRepresentation
{

    // Generic
    protected int index;

    protected String type;

    protected String timestamp;

    // Start form and task
    protected String selectedOutcome;

    protected List<AuditLogFormDataRepresentation> formData = new ArrayList<AuditLogFormDataRepresentation>();

    // task completed
    protected String taskName;

    protected String taskAssignee;

    // Activity executed
    protected String activityId;

    protected String activityName;

    protected String activityType;

    // time related information
    protected String startTime;

    protected String endTime;

    protected Long durationInMillis;

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getSelectedOutcome()
    {
        return selectedOutcome;
    }

    public void setSelectedOutcome(String selectedOutcome)
    {
        this.selectedOutcome = selectedOutcome;
    }

    public List<AuditLogFormDataRepresentation> getFormData()
    {
        return formData;
    }

    public void setFormData(List<AuditLogFormDataRepresentation> formData)
    {
        this.formData = formData;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getTaskAssignee()
    {
        return taskAssignee;
    }

    public void setTaskAssignee(String taskAssignee)
    {
        this.taskAssignee = taskAssignee;
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

    public String getActivityType()
    {
        return activityType;
    }

    public void setActivityType(String activityType)
    {
        this.activityType = activityType;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public Long getDurationInMillis()
    {
        return durationInMillis;
    }

    public void setDurationInMillis(Long durationInMillis)
    {
        this.durationInMillis = durationInMillis;
    }
}