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
package org.alfresco.client.services.process.enterprise.core.model.runtime;

/**
 * @author Bassam Al-Sarori Base class representation for executing filters. For
 *         executing user saved filter, the filter id should be set in
 *         {@link FilterRequestRepresentation#filterId} property. For executing
 *         dynamic filter, the filter representation should be set in
 *         {@link FilterRequestRepresentation#filter} property. Only
 *         {@link FilterRequestRepresentation#filter} or
 *         {@link FilterRequestRepresentation#filterId} should be set. The class
 *         includes parameters not included in filter, such as
 *         {@link FilterRequestRepresentation#page},
 *         {@link FilterRequestRepresentation#size}, and,
 *         {@link FilterRequestRepresentation#}. Subclasses can include
 *         additional parameters.
 */
public class FilterRequestRepresentation<T extends FilterRepresentation>
{

    public static final int DEFAULT_SIZE = 50;

    protected int page = 0;

    protected int size = DEFAULT_SIZE;

    protected Long appDefinitionId;

    protected Long filterId;

    protected T filter;

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public Long getAppDefinitionId()
    {
        return appDefinitionId;
    }

    public void setAppDefinitionId(Long appDefinitionId)
    {
        this.appDefinitionId = appDefinitionId;
    }

    public Long getFilterId()
    {
        return filterId;
    }

    public void setFilterId(Long filterId)
    {
        this.filterId = filterId;
    }

    public T getFilter()
    {
        return filter;
    }

    public void setFilter(T filter)
    {
        this.filter = filter;
    }

}
