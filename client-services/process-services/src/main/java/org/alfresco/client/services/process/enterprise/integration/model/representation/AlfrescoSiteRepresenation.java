/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.integration.model.representation;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

public class AlfrescoSiteRepresenation extends AbstractRepresentation
{

    private String id;

    private String title;

    public AlfrescoSiteRepresenation()
    {

    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
}
