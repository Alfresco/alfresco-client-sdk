/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.discovery.model.runtime;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

/**
 * REST representation of the system properties
 * 
 * @author Vasile Dirla
 */
public class SystemPropertiesRepresentation extends AbstractRepresentation
{

    protected boolean allowInvolveByEmail = true;

    protected boolean disableJavaScriptEventsInFormEditor = false;

    // Needed for serialization!
    public SystemPropertiesRepresentation()
    {
    }

    public void setAllowInvolveByEmail(boolean allowInvolveByEmail)
    {
        this.allowInvolveByEmail = allowInvolveByEmail;
    }

    public boolean getAllowInvolveByEmail()
    {
        return allowInvolveByEmail;
    }

    public boolean isDisableJavaScriptEventsInFormEditor()
    {
        return disableJavaScriptEventsInFormEditor;
    }

    public void setDisableJavaScriptEventsInFormEditor(boolean disableJavaScriptEventsInFormEditor)
    {
        this.disableJavaScriptEventsInFormEditor = disableJavaScriptEventsInFormEditor;
    }
}
