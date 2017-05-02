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

import org.alfresco.client.services.process.enterprise.common.model.representation.PagingRequestRepresentation;

/**
 * Created by jpascal on 12/12/2014.
 */
public class QueryTasksRepresentation extends PagingRequestRepresentation
{
    final Long appDefinitionId;

    final String text;

    final String processDefinitionId;

    final String processInstanceId;

    final Long assignee;

    final String assignment;

    public QueryTasksRepresentation(Long appDefinitionId, String processDefinitionId, String keywords, String processId,
            Long assignee, String state, String assignment, String sort, Long page, Long size)
    {
        super(state, sort, page, size);
        this.text = keywords;
        this.appDefinitionId = appDefinitionId;
        this.processDefinitionId = processDefinitionId;
        this.assignee = assignee;
        this.assignment = assignment;
        this.processInstanceId = processId;
    }

    public QueryTasksRepresentation(Long appDefinitionId, Long assigneeId, String assignment)
    {
        super(null, null, null, null);
        this.appDefinitionId = appDefinitionId;
        this.assignee = assigneeId;
        this.assignment = assignment;
        this.processDefinitionId = null;
        this.processInstanceId = null;
        this.text = null;
    }
}
