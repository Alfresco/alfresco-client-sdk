/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.integration.model.representation;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

public class GoogleDriveContent extends AbstractRepresentation
{

    private static final String FOLDER_MIME_TYPE = "application/vnd.google-apps.folder";

    private String id;

    private String title;

    private String mimeType;

    private String simpleType;

    private boolean folder;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    public boolean isFolder()
    {
        return folder;
    }

    public void setFolder(boolean folder)
    {
        this.folder = folder;
    }

    public String getSimpleType()
    {
        return simpleType;
    }

    public void setSimpleType(String simpleType)
    {
        this.simpleType = simpleType;
    }

}
