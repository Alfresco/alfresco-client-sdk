/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.discovery.model.runtime;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

/**
 * @author Yvo Swillens
 */
public class GlobalDateFormatRepresentation extends AbstractRepresentation
{

    protected String globalDateFormat;

    public String getGlobalDateFormat()
    {
        return globalDateFormat;
    }

    public void setGlobalDateFormat(String globalDateFormat)
    {
        this.globalDateFormat = globalDateFormat;
    }
}
