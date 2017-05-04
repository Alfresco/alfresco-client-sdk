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
package org.alfresco.client.services.process.activiti.common.model.constant;

/**
 * Created by jpascal on 22/12/2014.
 */
public interface RequestConstant
{
    // ///////////////////////////////////////////////
    // USER SERVICE
    // ///////////////////////////////////////////////
    String ARGUMENT_APPDEFINITION = "appDefinition";

    String ARGUMENT_APPDEFINITION_ID = "appDefinitionId";

    String ARGUMENT_PROCESS_ID = "processId";

    String ARGUMENT_PROCESSDEFINITION_ID = "processDefinitionId";

    String ARGUMENT_TEXT = "text";

    String ARGUMENT_ASSIGNEE = "assignee";

    String ARGUMENT_ASSIGNMENT = "assignment";

    String ARGUMENT_STATE = "state";

    String ARGUMENT_SORT = "sort";

    String ARGUMENT_PAGE = "page";

    String ARGUMENT_SIZE = "size";

    String ARGUMENT_FILTER_ID = "filterId";

    // ///////////////////////////////////////////////
    // ASSIGNMENT
    // ///////////////////////////////////////////////
    String ASSIGNMENT_INVOLVED = "involved";

    String ASSIGNMENT_ASSIGNEE = "assignee";

    String ASSIGNMENT_CANDIDATE = "candidate";

    String ARGUMENT_TASK_ID = "taskId";

    // ///////////////////////////////////////////////
    // STATE
    // ///////////////////////////////////////////////
    String STATE_OPEN = "open";

    String STATE_ACTIVE = "active";

    String STATE_RUNNING = "running";

    String STATE_COMPLETED = "completed";

    String STATE_ALL = "all";

    // ///////////////////////////////////////////////
    // SORT
    // ///////////////////////////////////////////////
    String SORT_CREATED_ASC = "created-asc";

    String SORT_CREATED_DESC = "created-desc";

    String SORT_DUE_ASC = "due-asc";

    String SORT_DUE_DESC = "due-desc";

    // ///////////////////////////////////////////////
    // SORT
    // ///////////////////////////////////////////////
    String DATA = "data";

    String SIZE = "size";

    String START = "start";

    String TOTAL = "total";

}
