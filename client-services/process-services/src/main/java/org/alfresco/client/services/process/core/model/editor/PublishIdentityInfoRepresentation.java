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

import org.alfresco.client.services.process.core.model.common.AbstractRepresentation;
import org.alfresco.client.services.process.core.model.idm.LightGroupRepresentation;
import org.alfresco.client.services.process.core.model.idm.LightUserRepresentation;

/**
 * @author Tijs Rademakers
 */
public class PublishIdentityInfoRepresentation extends AbstractRepresentation
{

    protected String type;

    protected LightUserRepresentation person;

    protected LightGroupRepresentation group;

    public LightUserRepresentation getPerson()
    {
        return person;
    }

    public void setPerson(LightUserRepresentation person)
    {
        this.person = person;
    }

    public LightGroupRepresentation getGroup()
    {
        return group;
    }

    public void setGroup(LightGroupRepresentation group)
    {
        this.group = group;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
