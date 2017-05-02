/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.runtime;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

/**
 * @author Bassam Al-Sarori
 */
public class IdentityLinkRepresentation extends AbstractRepresentation
{

    public static final String USERS = "users";

    public static final String GROUPS = "groups";

    protected String user;

    protected String group;

    protected String type;

    public IdentityLinkRepresentation()
    {
    }

    public IdentityLinkRepresentation(String user, String group, String type)
    {
        this.user = user;
        this.group = group;
        this.type = type;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getGroup()
    {
        return group;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

}
