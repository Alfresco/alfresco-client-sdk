/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.editor;

import java.util.Map;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

public class AppDefinitionUpdateResultRepresentation extends AbstractRepresentation
{

    public static final int CUSTOM_STENCIL_ITEM = 1;

    public static final int MODEL_VALIDATION_ERRORS = 2;

    protected AppDefinitionRepresentation appDefinition;

    protected String message;

    protected String messageKey;

    protected boolean error;

    protected int errorType;

    protected String errorDescription;

    protected Map<String, Object> customData;

    public AppDefinitionRepresentation getAppDefinition()
    {
        return appDefinition;
    }

    public void setAppDefinition(AppDefinitionRepresentation appDefinition)
    {
        this.appDefinition = appDefinition;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessageKey()
    {
        return messageKey;
    }

    public void setMessageKey(String messageKey)
    {
        this.messageKey = messageKey;
    }

    public boolean isError()
    {
        return error;
    }

    public void setError(boolean error)
    {
        this.error = error;
    }

    public int getErrorType()
    {
        return errorType;
    }

    public void setErrorType(int errorType)
    {
        this.errorType = errorType;
    }

    public String getErrorDescription()
    {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription)
    {
        this.errorDescription = errorDescription;
    }

    public Map<String, Object> getCustomData()
    {
        return customData;
    }

    public void setCustomData(Map<String, Object> customData)
    {
        this.customData = customData;
    }
}
