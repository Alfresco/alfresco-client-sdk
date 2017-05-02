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

import org.alfresco.client.services.process.enterprise.common.model.representation.PagingRequestRepresentation;
import org.alfresco.client.services.process.enterprise.constant.RequestConstant;

/**
 * Created by jpascal on 12/12/2014.
 */
public class ProcessesRequestRepresentation extends PagingRequestRepresentation
{
    final String processDefinitionId;

    final Long appDefinitionId;

    /**
     * By Default State == Running
     */
    public ProcessesRequestRepresentation()
    {
        super(RequestConstant.STATE_RUNNING, null, null, null);
        this.processDefinitionId = null;
        this.appDefinitionId = null;
    }

    public ProcessesRequestRepresentation(Long appDefinitionId)
    {
        super(RequestConstant.STATE_RUNNING, null, null, null);
        this.appDefinitionId = appDefinitionId;
        this.processDefinitionId = null;
    }

    public ProcessesRequestRepresentation(String processDefinitionId, String state, String sort, Long page, Long size)
    {
        super(state, sort, page, size);
        this.processDefinitionId = processDefinitionId;
        this.appDefinitionId = null;
    }

    public ProcessesRequestRepresentation(Long appDefinitionId, String processDefinitionId, String state, String sort,
            Long page, Long size)
    {
        super(state, sort, page, size);
        this.processDefinitionId = processDefinitionId;
        this.appDefinitionId = appDefinitionId;
    }
}
