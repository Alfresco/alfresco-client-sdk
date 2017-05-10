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
package org.alfresco.client.services.process.activiti.common.constant;

/**
 * Created by jpascal on 22/12/2014.
 */
public interface RequestConstant {
    String DESCRIPTION = "description";

    String PRIORITY = "priority";

    String MINIMUM_PRIORITY = "minimumPriority";

    String MAXIMUM_PRIORITY = "maximumPriority";

    String UNASSIGNED = "unassigned";

    String ASSIGNEE = "assignee";

    String ASSIGNEE_LIKE = "assigneeLike";

    String OWNER = "owner";

    String OWNER_LIKE = "ownerLike";

    String DELEGATION_STATE = "delegationState";


    String TABLE_NAME = "tableName";

    String ORDER_ASCENDING_COLUMN = "orderAscendingColumn";

    String ORDER_DESCENDING_COLUMN = "orderDescendingColumn";

    String RESOURCE_ID = "resourceId";

    String RESOURCE_NAME = "resourceName";

    String RESOURCE_NAME_LIKE = "resourceNameLike";

    String NAME = "name";

    String CATEGORY = "category";

    String CATEGORY_LIKE = "categoryLike";

    String CATEGORY_NOT_EQUALS = "categoryNotEquals";

    String TENANT_ID = "tenantId";

    String WITHOUT_TENANT_ID = "withoutTenantId";

    String FILE = "file";

    String EXECUTION_ID = "executionId";

    String ID = "id";

    String KEY = "key";

    String VERSION = "version";

    String LATEST_VERSION = "latestVersion";

    String DEPLOYED = "deployed";

    String STARTABLE_BY_USER = "startableByUser";

    String SUSPENDED = "suspended";

    String DELETE_REASON = "deleteReason";

    String SUB_PROCESS_INSTANCE_ID = "subProcessInstanceId";

    String EVENT_ID = "eventId";

    String ATTACHMENT_ID = "attachmentId";

    String ACTIVITY_ID = "activityId";

    String ACTIVITY_INSTANCE_ID = "activityInstanceId";

    String ACTIVITY_NAME = "activityName";

    String ACTIVITY_TYPE = "activityType";

    String FINISHED = "finished";

    String TASK_ASSIGNEE = "taskAssignee";

    String PROCESS_DEFINITION_KEY = "processDefinitionKey";

    String PROCESS_DEFINITION_ID = "processDefinitionId";

    String PROCESS_INSTANCE_ID = "processInstanceId";

    String MESSAGE_EVENT_SUBSCRIPTION_NAME = "messageEventSubscriptionName";

    String SIGNAL_EVENT_SUBSCRIPTION_NAME = "signalEventSubscriptionName";

    String PARENT_ID = "parentId";

    String GROUP_ID = "groupId";

    String MEMBER = "member";

    String COMMENT_ID = "commentId";

    String SELECT_ONLY_FORM_PROPERTIES = "selectOnlyFormProperties";

    String SELECT_ONLY_VARIABLE_UPDATES = "selectOnlyVariableUpdates";

    String DETAIL_ID = "detailId";

    String VAR_INSTANCE_ID = "varInstanceId";

    String EXCLUDE_TASK_VARIABLES = "excludeTaskVariables";

    String VARIABLE_NAME_LIKE = "variableNameLike";

    String INVOLVED_USER = "involvedUser";

    String SUPER_PROCESS_INSTANCE_ID = "superProcessInstanceId";

    String EXCLUDE_SUB_PROCESSES = "excludeSubprocesses";

    String BUSINESS_KEY = "businessKey";

    String FINISHED_AFTER = "finishedAfter";

    String FINISHED_BEFORE = "finishedBefore";

    String STARTED_AFTER = "startedAfter";

    String STARTED_BEFORE = "startedBefore";

    String STARTED_BY = "startedBy";

    String INCLUDE_PROCESS_VARIABLES = "includeProcessVariables";

    String INCLUDE_TASK_LOCAL_VARIABLES = "includeTaskLocalVariables";

    String TASK_CREATED_BEFORE = "taskCreatedBefore";

    String TASK_CREATED_AFTER = "taskCreatedAfter";

    String TASK_CREATED_ON = "taskCreatedOn";

    String TASK_COMPLETED_BEFORE = "taskCompletedBefore";

    String TASK_COMPLETED_AFTER = "taskCompletedAfter";

    String TASK_COMPLETED_ON = "taskCompletedOn";

    String CREATED_ON = "createdOn";

    String CREATED_BEFORE = "createdBefore";

    String CREATED_AFTER = "createdAfter";

    String COMPLETED_ON = "taskCompletedOn";

    String DUE_ON = "dueOn";

    String ACTIVE = "active";

    String DUE_DATE = "dueDate";

    String DUE_DATE_BEFORE = "dueDateBefore";

    String DUE_DATE_AFTER = "dueDateAfter";

    String WITHOUT_DUE_DATE = "withoutDueDate";

    String PARENT_TASK_ID = "parentTaskId";

    String CANDIDATE_GROUP = "candidateGroup";
    String CANDIDATE_GROUPS = "candidateGroups";
    String CANDIDATE_USER = "candidateUser";

    String CANDIDATE_OR_ASSIGNED = "candidateOrAssigned";
    String EXCLUDE_SUB_TASKS = "excludeSubTasks";


    String PROCESS_INSTANCE_BUSINESS_KEY = "processInstanceBusinessKey";
    String PROCESS_INSTANCE_BUSINESS_KEY_LIKE = "processInstanceBusinessKeyLike";
    String TASK_DEFINITION_KEY_LIKE = "taskDefinitionKeyLike";

    String PROCESS_FINISHED = "processFinished";
    String TASK_PRIORITY = "taskPriority";
    String TASK_OWNER_LIKE = "taskOwnerLike";
    String TASK_INVOLVED_USER = "taskInvolvedUser";
    String TASK_ASSIGNEE_LIKE = "taskAssigneeLike";
    String TASK_OWNER = "taskOwner";
    String TASK_DELETE_REASON_LIKE = "taskDeleteReasonLike";
    String TASK_DELETE_REASON = "taskDeleteReason";
    String TASK_DESCRIPTION_LIKE = "taskDescriptionLike";
    String TASK_CATEGORY = "taskCategory";
    String TASK_NAME_LIKE = "taskNameLike";
    String TASK_DESCRIPTION = "taskDescription";
    String TASK_NAME = "taskName";
    String TASK_DEFINITION_KEY = "taskDefinitionKey";
    String PROCESS_BUSINESS_KEY_LIKE = "processBusinessKeyLike";
    String PROCESS_BUSINESS_KEY = "processBusinessKey";
    String PROCESS_DEFINITION_NAME_LIKE = "processDefinitionNameLike";
    String PROCESS_DEFINITION_NAME = "processDefinitionName";
    String PROCESS_DEFINITION_KEY_LIKE = "processDefinitionKeyLike";


    String JOB_ID = "jobId";

    String TIMERS_ONLY = "timersOnly";
    String MESSAGES_ONLY = "messagesOnly";
    String WITH_EXCEPTION = "withException";
    String DUE_BEFORE = "dueBefore";
    String DUE_AFTER = "dueAfter";
    String EXCEPTION_MESSAGE = "exceptionMessage";
    String LOCKED = "locked";
    String UNLOCKED = "unlocked";

    String FIRST_NAME = "firstName";
    String FIRST_NAME_LIKE = "firstNameLike";
    String LAST_NAME = "lastName";
    String LAST_NAME_LIKE = "lastNameLike";

    String EMAIL_LIKE = "emailLike";

    String POTENTIAL_STARTER = "potentialStarter";
    String MEMBER_OF_GROUP = "memberOfGroup";
    String FILE_DATA = "fileData";


    String EMAIL = "email";


    String VARIABLE_NAME = "variableName";

    String SCOPE = "scope";

    String TYPE = "type";

    String FAMILY = "family";

    String IDENTITY_ID = "identityId";


    String LATEST = "latest";


    String CASCADE = "cascade";


    String TASK_ID = "taskId";


    String NAME_LIKE = "nameLike";

    String KEY_LIKE = "keyLike";

    String DEPLOYMENT_ID = "deploymentId";

    String TENANT_ID_LIKE = "tenantIdLike";


    String SORT = "sort";

    String USER_ID = "userId";

    String MODEL_ID = "modelId";

    // ///////////////////////////////////////////////
    // SORT
    // ///////////////////////////////////////////////
    String DATA = "data";

    String SIZE = "size";

    String START = "start";

    String TOTAL = "total";

}
