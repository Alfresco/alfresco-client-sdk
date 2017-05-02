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

import java.util.List;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.editor.NamedObject;

/**
 * Created by jpascal on 09/06/2015.
 */
public class ProcessContentRepresentation extends AbstractRepresentation
{

    private NamedObject field;

    private List<RelatedContentRepresentation> content;

    public ProcessContentRepresentation()
    {
    }

    public NamedObject getField()
    {
        return field;
    }

    public void setField(NamedObject field)
    {
        this.field = field;
    }

    public List<RelatedContentRepresentation> getContent()
    {
        return content;
    }

    public void setContent(List<RelatedContentRepresentation> content)
    {
        this.content = content;
    }

}
