/*
 *   Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *   This file is part of Alfresco Java Client.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.alfresco.client.api.common.representation;

import java.util.List;

/**
 * Created by jpascal on 19/01/2016.
 */
public class ResultPaging<T>
{

    /** List of all object present in a page. */
    protected List<T> objects;

    protected PaginationRepresentation pagination;

    public ResultPaging(List<T> objects, PaginationRepresentation pagination)
    {
        this.objects = objects;
        this.pagination = pagination;
    }

    /** {@inheritDoc} */
    public List<T> getList()
    {
        return objects;
    }

    /** {@inheritDoc} */
    public Boolean hasMoreItems()
    {
        return pagination.getHasMoreItems();
    }

    /** {@inheritDoc} */
    public int getCount()
    {
        return pagination.getCount();
    }

    public PaginationRepresentation getPagination()
    {
        return pagination;
    }
}
