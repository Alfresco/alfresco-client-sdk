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

package org.alfresco.client.services.process.enterprise.core.model.runtime.request;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

public class AddContentRelatedRepresentation extends AbstractRepresentation
{
    protected String name;

    protected boolean link;

    protected String source;

    protected String sourceId;

    protected String mimeType;

    public AddContentRelatedRepresentation(String name, boolean link, String source, String sourceId, String mimeType)
    {
        setName(name);
        setLink(link);
        setSource(source);
        setSourceId(sourceId);
        setMimeType(mimeType);
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isLink()
    {
        return link;
    }

    public void setLink(boolean link)
    {
        this.link = link;
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

}
