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

package org.alfresco.client.services.process.core.model.editor;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO representation of the app model JSON.
 * 
 * @author Tijs Rademakers
 */
public class AppDefinition
{

    protected List<AppModelDefinition> models;

    protected String theme;

    protected String icon;

    protected List<PublishIdentityInfoRepresentation> publishIdentityInfo = new ArrayList<PublishIdentityInfoRepresentation>();

    public String getTheme()
    {
        return theme;
    }

    public void setTheme(String theme)
    {
        this.theme = theme;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public List<AppModelDefinition> getModels()
    {
        return models;
    }

    public void setModels(List<AppModelDefinition> models)
    {
        this.models = models;
    }

    public List<PublishIdentityInfoRepresentation> getPublishIdentityInfo()
    {
        return publishIdentityInfo;
    }

    public void setPublishIdentityInfo(List<PublishIdentityInfoRepresentation> publishIdentityInfo)
    {
        this.publishIdentityInfo = publishIdentityInfo;
    }
}
