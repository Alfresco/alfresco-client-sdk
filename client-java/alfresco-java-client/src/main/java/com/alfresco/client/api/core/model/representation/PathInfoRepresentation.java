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

package com.alfresco.client.api.core.model.representation;

import java.util.List;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

public class PathInfoRepresentation extends AbstractRepresentation
{
    @SerializedName("name")
    private String name;

    @SerializedName("isComplete")
    private Boolean isComplete;

    @SerializedName("elements")
    private List<PathElementRepresentation> element;

    public class PathElementRepresentation
    {
        @SerializedName("id")
        private String id;

        @SerializedName("name")
        private String name;

        public String getId()
        {
            return id;
        }

        public void setId(String id)
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
    }

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Boolean getComplete()
    {
        return isComplete;
    }

    public void setComplete(Boolean complete)
    {
        isComplete = complete;
    }

    public List<PathElementRepresentation> getElement()
    {
        return element;
    }

    public void setElement(List<PathElementRepresentation> path)
    {
        this.element = path;
    }
}
