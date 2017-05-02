/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.runtime;

import java.util.Date;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.editor.form.FormDefinitionRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.idm.LightUserRepresentation;

/**
 * @author Bassam Al-Sarori
 */
public class SubmittedFormRepresentation extends AbstractRepresentation
{

    protected Long id;

    protected Long formId;

    protected String name;

    protected String taskId;

    protected String processId;

    protected Date submitted;

    protected LightUserRepresentation submittedBy;

    protected FormDefinitionRepresentation form;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getFormId()
    {
        return formId;
    }

    public void setFormId(Long formId)
    {
        this.formId = formId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getProcessId()
    {
        return processId;
    }

    public void setProcessId(String processId)
    {
        this.processId = processId;
    }

    public Date getSubmitted()
    {
        return submitted;
    }

    public void setSubmittedOn(Date submitted)
    {
        this.submitted = submitted;
    }

    public LightUserRepresentation getSubmittedBy()
    {
        return submittedBy;
    }

    public void setSubmittedBy(LightUserRepresentation submittedBy)
    {
        this.submittedBy = submittedBy;
    }

    public FormDefinitionRepresentation getForm()
    {
        return form;
    }

    public void setForm(FormDefinitionRepresentation form)
    {
        this.form = form;
    }
}
