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
package org.alfresco.client.services.process.enterprise.common.constant;

import org.alfresco.client.services.common.constant.ApiConstant;

/**
 * Created by jpascal on 22/12/2014.
 */
public interface RequestConstant extends ApiConstant
{
    String APPDEFINITION_ID = "appDefinitionId";

    String PROCESSDEFINITION_ID = "processDefinitionId";

    String PROCESS_INSTANCE_ID = "processInstanceId";

    String CURRENT_FOLDER_ID = "currentFolderOnly";

    String PARENT = "parent";

    String CODE = "code";

    String FOLDER_ID = "folderId";

    String REPOSITORY_ID = "repositoryId";

    String FORM_HISTORY_ID = "formHistoryId";

    String EXCLUDE_PROCESS_ID = "excludeProcessId";

    String EXCLUDE_TASK_ID = "excludeTaskId";

    String EXTERNAL_ID = "externalId";

    String EMAIL = "email";

    String USER_FILTER_ID = "userFilterId";

    String FIELD_ID = "fieldId";

    String APP_DEPLOYMENT_ID = "variableName";

    String VARIABLE_NAME = "variableName";

    String SCOPE = "scope";

    String TYPE = "type";

    String FAMILY = "family";

    String IDENTITY_ID = "identityId";

    String COLUMN = "column";

    String FIELD = "field";

    String LATEST = "latest";

    String APP_DEFINITION_ID = "appDefinitionId";

    String PROCESS_MODEL_ID = "processModelId";

    String MODEL_HISTORY_ID = "modelHistoryId";

    String DELETE_RUNTIME_APP = "deleteRuntimeApp";

    String CASCADE = "cascade";

    String REFERENCE_ID = "referenceId";

    String MODEL_TYPE = "modelType";

    String DECISION_TABLE_ID = "decisionTableId";

    String ORDER = "order";

    String APP_ID = "appId";

    String SUBMITTED_FORM_ID = "submittedFormId";

    String PROCESS_ID = "processId";

    String TASK_ID = "taskId";

    String FORM_ID = "formId";

    String NAME_LIKE = "nameLike";

    String KEY_LIKE = "keyLike";

    String DEPLOYMENT_ID = "deploymentId";

    String TENANT_ID_LIKE = "tenantIdLike";

    String DECISION_KEY = "decisionKey";

    String AUDIT_TRAIL_ID = "auditTrailId";

    String RENDITION_TYPE = "renditionType";

    String CONTENT_ID = "contentId";

    String ACCOUNT_TYPE = "accountType";

    String SORT = "sort";

    String COMPANY = "company";

    String USER_ID = "userId";

    String MODEL_ID = "modelId";

    // ///////////////////////////////////////////////
    // ADMIN API
    // ///////////////////////////////////////////////
    String FILE = "file";

    String PAGE = "page";

    String PAGE_SIZE = "pageSize";

    String FILTER = "filter";

    String STATUS = "status";

    String TENANT_ID = "tenantId";

    String ENDPOINT_CONFIGURATION_ID = "endpointConfigurationId";

    String BASIC_AUTH_ID = "basicAuthId";

    String FUNCTIONAL = "functional";

    String SUMMARY = "summary";

    String GROUP_ID = "groupId";

    String RELATED_GROUP_ID = "relatedGroupId";

    String GROUP_CAPABILITY_ID = "groupCapabilityId";

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
