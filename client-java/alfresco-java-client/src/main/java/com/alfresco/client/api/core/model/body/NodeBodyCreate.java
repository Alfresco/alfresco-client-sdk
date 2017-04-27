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
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 15/12/2015.
 */
public class NodeBodyCreate
{
    @SerializedName("name")
    public final String name;

    @SerializedName("nodeType")
    public final String nodeType;

    @SerializedName("properties")
    public final Map<String, Object> properties;

    @SerializedName("aspectNames")
    public final List<String> aspectNames;

    @SerializedName("relativePath")
    public final String relativePath;

    @SerializedName("association")
    public final NodeBodyCreateAssociation association;

    @SerializedName("secondaryChildren")
    public final List<ChildAssociationBody> secondaryChildren;

    @SerializedName("targets")
    public final List<AssociationBody> targets;

    public NodeBodyCreate(String name, String nodeType)
    {
        this.nodeType = nodeType;
        this.name = name;
        this.properties = null;
        this.aspectNames = null;
        this.relativePath = null;
        this.association = null;
        this.secondaryChildren = null;
        this.targets = null;
    }

    public NodeBodyCreate(String name, String nodeType, Map<String, Object> properties, List<String> aspectNames)
    {
        this.nodeType = nodeType;
        this.name = name;
        this.properties = properties;
        this.aspectNames = aspectNames;
        this.relativePath = null;
        this.association = null;
        this.secondaryChildren = null;
        this.targets = null;
    }

    public NodeBodyCreate(String name, String nodeType, Map<String, Object> properties, List<String> aspectNames,
            String relativePath)
    {
        this.nodeType = nodeType;
        this.name = name;
        this.properties = properties;
        this.aspectNames = aspectNames;
        this.relativePath = relativePath;
        this.association = null;
        this.secondaryChildren = null;
        this.targets = null;
    }

    public NodeBodyCreate(String name, String nodeType, Map<String, Object> properties, List<String> aspectNames,
            String relativePath, NodeBodyCreateAssociation association, List<ChildAssociationBody> secondaryChildren,
            List<AssociationBody> targets)
    {
        this.nodeType = nodeType;
        this.name = name;
        this.properties = properties;
        this.aspectNames = aspectNames;
        this.relativePath = relativePath;
        this.association = association;
        this.secondaryChildren = secondaryChildren;
        this.targets = targets;
    }

}
