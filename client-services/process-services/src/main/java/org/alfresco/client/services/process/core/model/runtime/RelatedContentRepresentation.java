/*
 *  Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *  This file is part of Alfresco Activiti Client.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.alfresco.client.services.process.core.model.runtime;

import java.util.Date;

import org.alfresco.client.services.common.model.representation.AbstractRepresentation;
import org.alfresco.client.services.process.core.model.idm.LightUserRepresentation;

import com.google.gson.internal.LinkedTreeMap;

/**
 * @author Frederik Heremans
 */
public class RelatedContentRepresentation extends AbstractRepresentation
{

    protected Long id;

    protected String name;

    protected Date created;

    protected LightUserRepresentation createdBy;

    protected boolean contentAvailable;

    protected boolean link;

    protected String source;

    protected String sourceId;

    protected String mimeType;

    protected String simpleType;

    protected String linkUrl;

    public String previewStatus = "queued";

    public String thumbnailStatus = "queued";

    public RelatedContentRepresentation()
    {

    }

    public static RelatedContentRepresentation parse(String uri, String name, String mimetype)
    {
        RelatedContentRepresentation content = new RelatedContentRepresentation();
        content.name = name;
        content.mimeType = mimetype;
        content.id = -1L;
        content.linkUrl = uri;
        return content;
    }

    public static RelatedContentRepresentation parse(Object jsonObject)
    {
        if (jsonObject instanceof LinkedTreeMap)
        {
            RelatedContentRepresentation content = new RelatedContentRepresentation();
            content.id = ((Double) ((LinkedTreeMap) jsonObject).get("id")).longValue();
            content.createdBy = LightUserRepresentation.parse(((LinkedTreeMap) jsonObject).get("createdBy"));
            content.name = (String) ((LinkedTreeMap) jsonObject).get("name");
            content.source = (String) ((LinkedTreeMap) jsonObject).get("source");
            content.sourceId = (String) ((LinkedTreeMap) jsonObject).get("sourceId");
            content.mimeType = (String) ((LinkedTreeMap) jsonObject).get("mimeType");
            content.simpleType = (String) ((LinkedTreeMap) jsonObject).get("simpleType");
            content.link = (Boolean) ((LinkedTreeMap) jsonObject).get("link");
            content.linkUrl = (String) ((LinkedTreeMap) jsonObject).get("linkUrl");
            return content;
        }
        return null;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public LightUserRepresentation getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(LightUserRepresentation createdBy)
    {
        this.createdBy = createdBy;
    }

    public boolean isContentAvailable()
    {
        return contentAvailable;
    }

    public void setContentAvailable(boolean contentAvailable)
    {
        this.contentAvailable = contentAvailable;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSourceId()
    {
        return sourceId;
    }

    public void setSourceId(String sourceId)
    {
        this.sourceId = sourceId;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    public String getSimpleType()
    {
        return simpleType;
    }

    public void setSimpleType(String simpleType)
    {
        this.simpleType = simpleType;
    }

    public void setLink(boolean link)
    {
        this.link = link;
    }

    public boolean isLink()
    {
        return link;
    }

    public String getLinkUrl()
    {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl)
    {
        this.linkUrl = linkUrl;
    }

    public String getThumbnailStatus()
    {
        return thumbnailStatus;
    }

    public void setThumbnailStatus(String thumbnailStatus)
    {
        this.thumbnailStatus = thumbnailStatus;
    }

    public String getPreviewStatus()
    {
        return previewStatus;
    }

    public void setPreviewStatus(String previewStatus)
    {
        this.previewStatus = previewStatus;
    }
}
