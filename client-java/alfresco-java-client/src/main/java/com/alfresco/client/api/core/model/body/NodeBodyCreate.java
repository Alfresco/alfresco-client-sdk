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

package com.alfresco.client.api.core.model.body;

import java.util.List;

import com.alfresco.client.api.core.model.representation.ContentInfoRepresentation;
import com.google.gson.internal.LinkedTreeMap;

/**
 * Created by jpascal on 15/12/2015.
 */
public class NodeBodyCreate
{
    public final String name;

    public final String nodeType;

    public final LinkedTreeMap<String, Object> properties;

    public final List<String> aspectNames;

    public final ContentInfoRepresentation content;

    public NodeBodyCreate(String name, String nodeType)
    {
        this.nodeType = nodeType;
        this.name = name;
        this.properties = null;
        this.content = null;
        this.aspectNames = null;
    }

    public NodeBodyCreate(String name, String nodeType, LinkedTreeMap<String, Object> properties,
            List<String> aspectNames, ContentInfoRepresentation content)
    {
        this.nodeType = nodeType;
        this.name = name;
        this.properties = properties;
        this.content = content;
        this.aspectNames = aspectNames;
    }

}
