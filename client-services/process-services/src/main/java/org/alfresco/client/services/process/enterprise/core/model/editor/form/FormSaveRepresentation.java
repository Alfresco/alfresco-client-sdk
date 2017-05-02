/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.editor.form;

import java.util.List;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.editor.form.scope.ProcessScopeIdentifierRepresentation;

public class FormSaveRepresentation extends AbstractRepresentation
{

    protected boolean reusable;

    protected boolean newVersion;

    protected String comment;

    protected String formImageBase64;

    protected FormRepresentation formRepresentation;

    protected List<ProcessScopeIdentifierRepresentation> processScopeIdentifiers;

    public boolean isReusable()
    {
        return reusable;
    }

    public void setReusable(boolean reusable)
    {
        this.reusable = reusable;
    }

    public boolean isNewVersion()
    {
        return newVersion;
    }

    public void setNewVersion(boolean newVersion)
    {
        this.newVersion = newVersion;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getFormImageBase64()
    {
        return formImageBase64;
    }

    public void setFormImageBase64(String formImageBase64)
    {
        this.formImageBase64 = formImageBase64;
    }

    public FormRepresentation getFormRepresentation()
    {
        return formRepresentation;
    }

    public void setFormRepresentation(FormRepresentation formRepresentation)
    {
        this.formRepresentation = formRepresentation;
    }

    public List<ProcessScopeIdentifierRepresentation> getProcessScopeIdentifiers()
    {
        return processScopeIdentifiers;
    }

    public void setProcessScopeIdentifiers(List<ProcessScopeIdentifierRepresentation> processScopeIdentifiers)
    {
        this.processScopeIdentifiers = processScopeIdentifiers;
    }
}
