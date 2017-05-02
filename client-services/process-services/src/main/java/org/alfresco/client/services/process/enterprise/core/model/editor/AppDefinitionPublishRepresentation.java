/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.editor;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

public class AppDefinitionPublishRepresentation extends AbstractRepresentation
{

    protected String comment;

    protected Boolean force;

    public AppDefinitionPublishRepresentation()
    {

    }

    public AppDefinitionPublishRepresentation(String comment, Boolean force)
    {
        this.comment = comment;
        this.force = force;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public Boolean getForce()
    {
        return force;
    }

    public void setForce(Boolean force)
    {
        this.force = force;
    }

}
