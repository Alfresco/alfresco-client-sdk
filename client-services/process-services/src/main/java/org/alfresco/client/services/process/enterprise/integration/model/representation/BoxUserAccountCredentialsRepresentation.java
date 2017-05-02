/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.integration.model.representation;

import java.util.Date;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

public class BoxUserAccountCredentialsRepresentation extends AbstractRepresentation
{

    protected String authenticationURL;

    protected Date expireDate;

    protected String ownerEmail;

    public String getAuthenticationURL()
    {
        return authenticationURL;
    }

    public void setAuthenticationURL(String authenticationURL)
    {
        this.authenticationURL = authenticationURL;
    }

    public void setExpireDate(Date expireDate)
    {
        this.expireDate = expireDate;
    }

    public Date getExpireDate()
    {
        return expireDate;
    }

    public void setOwnerEmail(String ownerEmail)
    {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerEmail()
    {
        return ownerEmail;
    }
}
