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

package org.alfresco.client.services.process.enterprise.core.model.idm;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.internal.LinkedTreeMap;

/**
 * @author Joram Barrez
 */
public class LightGroupRepresentation extends AbstractGroupRepresentation
{
    protected List<LightGroupRepresentation> groups;

    public LightGroupRepresentation()
    {

    }

    public static LightGroupRepresentation parse(Object jsonObject)
    {
        if (jsonObject instanceof LinkedTreeMap)
        {
            LightGroupRepresentation user = new LightGroupRepresentation();
            user.name = (String) ((LinkedTreeMap) jsonObject).get("name");
            user.externalId = (String) ((LinkedTreeMap) jsonObject).get("externalId");
            user.status = (String) ((LinkedTreeMap) jsonObject).get("status");
            user.id = ((Double) ((LinkedTreeMap) jsonObject).get("id")).longValue();
            return user;
        }
        return null;
    }

    public void addGroup(LightGroupRepresentation group)
    {
        if (groups == null)
        {
            groups = new ArrayList<LightGroupRepresentation>();
        }
        groups.add(group);
    }

    public List<LightGroupRepresentation> getGroups()
    {
        return groups;
    }

    public void setGroups(List<LightGroupRepresentation> groups)
    {
        this.groups = groups;
    }

}
