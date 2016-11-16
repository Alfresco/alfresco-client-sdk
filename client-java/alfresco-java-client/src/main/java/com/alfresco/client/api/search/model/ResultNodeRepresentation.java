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

package com.alfresco.client.api.search.model;

import com.alfresco.client.api.core.model.representation.NodeRepresentation;
import com.google.gson.annotations.SerializedName;

public class ResultNodeRepresentation extends NodeRepresentation
{
    @SerializedName("search")
    private SearchScore search = null;

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * The score for this row
     * 
     * @return score
     **/
    public SearchScore getSearch()
    {
        return search;
    }

    public void setSearch(SearchScore search)
    {
        this.search = search;
    }
}
