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

import org.alfresco.client.services.process.core.model.common.AbstractRepresentation;

/**
 * @author Bassam Al-Sarori Base class representation for saved filters.
 */
public abstract class UserFilterRepresentation<T extends FilterRepresentation> extends AbstractRepresentation
{

    public static final String TASK_FILTER = "task";

    public static final String PROCESS_FILTER = "process";

    protected Long id;

    protected String name;

    protected Long appId;

    protected Boolean recent;

    protected Integer index;

    protected String icon;

    protected T filter;

    public UserFilterRepresentation()
    {
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

    public Long getAppId()
    {
        return appId;
    }

    public void setAppId(Long appId)
    {
        this.appId = appId;
    }

    public Boolean getRecent()
    {
        return recent;
    }

    public void setRecent(Boolean recent)
    {
        this.recent = recent;
    }

    public Integer getIndex()
    {
        return index;
    }

    public void setIndex(Integer index)
    {
        this.index = index;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public T getFilter()
    {
        return filter;
    }

    public void setFilter(T filter)
    {
        this.filter = filter;
    }

    public abstract String getType();
}
