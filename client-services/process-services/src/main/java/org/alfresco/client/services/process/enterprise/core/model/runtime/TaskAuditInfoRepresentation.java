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
public class TaskAuditInfoRepresentation
{

    private String taskId;

    private String taskName;

    private String processInstanceId;

    private String processDefinitionName;

    private int processDefinitionVersion;

    private String assignee;

    private String startTime;

    private String endTime;

    private List<AuditLogFormDataRepresentation> formData = new ArrayList<AuditLogFormDataRepresentation>();

    private String selectedOutcome;

    private List<CommentAuditInfo> comments = new ArrayList<CommentAuditInfo>();

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getProcessInstanceId()
    {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId)
    {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessDefinitionName()
    {
        return processDefinitionName;
    }

    public void setProcessDefinitionName(String processDefinitionName)
    {
        this.processDefinitionName = processDefinitionName;
    }

    public int getProcessDefinitionVersion()
    {
        return processDefinitionVersion;
    }

    public void setProcessDefinitionVersion(int processDefinitionVersion)
    {
        this.processDefinitionVersion = processDefinitionVersion;
    }

    public String getAssignee()
    {
        return assignee;
    }

    public void setAssignee(String assignee)
    {
        this.assignee = assignee;
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

    public List<AuditLogFormDataRepresentation> getFormData()
    {
        return formData;
    }

    public void setFormData(List<AuditLogFormDataRepresentation> formData)
    {
        this.formData = formData;
    }

    public String getSelectedOutcome()
    {
        return selectedOutcome;
    }

    public void setSelectedOutcome(String selectedOutcome)
    {
        this.selectedOutcome = selectedOutcome;
    }

    public List<CommentAuditInfo> getComments()
    {
        return comments;
    }

    public void setComments(List<CommentAuditInfo> comments)
    {
        this.comments = comments;
    }

    public static class CommentAuditInfo
    {

        private String author;

        private String message;

        public CommentAuditInfo(String author, String message)
        {
            this.author = author;
            this.message = message;
        }

        public String getAuthor()
        {
            return author;
        }

        public void setAuthor(String author)
        {
            this.author = author;
        }

        public String getMessage()
        {
            return message;
        }

        public void setMessage(String message)
        {
            this.message = message;
        }

    }

}
