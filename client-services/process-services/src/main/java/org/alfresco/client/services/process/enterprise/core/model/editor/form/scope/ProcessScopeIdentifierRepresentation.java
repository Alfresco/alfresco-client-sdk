/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.editor.form.scope;

/**
 * @author Erik Winlof
 */
public class ProcessScopeIdentifierRepresentation
{

    private Long processModelId;

    private String processActivityId;

    public ProcessScopeIdentifierRepresentation()
    {
    }

    public ProcessScopeIdentifierRepresentation(Long processModelId, String processActivityId)
    {
        this.processModelId = processModelId;
        this.processActivityId = processActivityId;
    }

    public Long getProcessModelId()
    {
        return processModelId;
    }

    public void setProcessModelId(Long processModelId)
    {
        this.processModelId = processModelId;
    }

    public String getProcessActivityId()
    {
        return processActivityId;
    }

    public void setProcessActivityId(String processActivityId)
    {
        this.processActivityId = processActivityId;
    }
}
