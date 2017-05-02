/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.discovery.model.runtime;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

public class PasswordValidationConstraints extends AbstractRepresentation
{

    protected int minLength;

    protected String regularExpression;

    public int getMinLength()
    {
        return minLength;
    }

    public void setMinLength(int minLength)
    {
        this.minLength = minLength;
    }

    public String getRegularExpression()
    {
        return regularExpression;
    }

    public void setRegularExpression(String regularExpression)
    {
        this.regularExpression = regularExpression;
    }
}
