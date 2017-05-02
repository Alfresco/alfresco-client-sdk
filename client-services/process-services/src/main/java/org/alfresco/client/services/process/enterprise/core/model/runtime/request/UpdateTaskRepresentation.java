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

package org.alfresco.client.services.process.enterprise.core.model.runtime.request;

import java.util.Date;

import org.alfresco.client.services.common.utils.ISO8601Utils;
import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

public class UpdateTaskRepresentation extends AbstractRepresentation
{
    protected String name;

    protected String description;

    protected String dueDate;

    public UpdateTaskRepresentation(String name, String description, Date dueDate)
    {
        setName(name);
        setDescription(description);
        if (name == null)
        {
            this.name = "";
        }
        if (description == null)
        {
            this.description = "";
        }
        if (dueDate != null)
        {
            this.dueDate = ISO8601Utils.format(dueDate);
        }
        else
        {
            this.dueDate = "";
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(String dueDate)
    {
        this.dueDate = dueDate;
    }
}
