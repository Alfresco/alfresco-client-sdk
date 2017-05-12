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

package org.alfresco.client.services.common.constant;

/**
 * Provides all constants necessary used by Alfresco Public API. <br/>
 * Generally it's used for parsing data (json, atompub xml).
 * 
 * @author Jean Marie Pascal
 */
public interface ApiConstant
{

    // JSON LIST
    String DATA = "data";

    String LIST = "list";

    String PAGINATION = "pagination";

    String ENTRY = "entry";

    String ENTRIES = "entries";

    String CONTEXT = "context";


    // Paging
    String SKIP_COUNT = "skipCount";

    String ORDER_BY = "orderBy";

    String MAX_ITEMS = "maxItems";

    String INCLUDE = "include";

    String RELATIONS = "relations";

    String WHERE = "where";

    String FIELDS = "fields";

    String RELATIVE_PATH = "relativePath";

    String INCLUDE_SOURCE = "includeSource";

    // BODY MULTIPART
    String FILEDATA = "filedata";

    // CONTENT
    String ATTACHMENT = "attachment";

    String IF_MODIFIED_SINCE = "If-Modified-Since";

    // PARAMS CONTENT SERVICES
    String NODE_ID = "nodeId";

    String CHILD_ID = "childId";

    String ASSOC_TYPE = "assocType";

    String AUTO_RENAME = "autoRename";

    String MAJOR_VERSION = "majorVersion";

    String COMMENT = "comment";

    String COMMENT_ID = "commentId";

    String GROUP_ID = "groupId";

    String GROUP_MEMBER_ID = "groupMemberId";

    String PERMANENT_VALUE = "permanent";

    String ASSOC_TYPE_VALUE = "assocType";

    String PERSON_ID = "personId";

    String SITE_ID = "siteId";

    String WHO = "who";

    String NETWORK_ID = "networkId";

    String PREFERENCE_NAME = "preferenceName";

    String TERM = "term";

    String RATING_ID = "ratingId";

    String TAG_ID = "tagId";

    String RENDITION_ID = "renditionId";

    String SHARED_ID = "sharedId";

    String PERMANENT = "permanent";

    String CONTAINER_ID = "containerId";

    String SKIP_CONFIGURATION = "skipConfiguration";

    String SKIP_ADD_TO_FAVORITES = "skipAddToFavorites";

    String VERSION_ID = "versionId";

    // PARAMS GOVERNANCE SERVICES
    String FILEPLAN_ID = "filePlanId";

    String FILE_ID = "fileId";

    String HIDE_RECORD = "hideRecord";

    String RECORD_CATEGORY_ID = "recordCategoryId";

    String RECORD_FOLDER_ID = "recordFolderId";

    String RECORD_ID = "recordId";

    String TRANSFER_CONTAINER_ID = "transferContainerId";

    String TRANSFER_ID = "transferId";

    String UNFILED_CONTAINER_ID = "unfiledContainerId";

    String UNFILED_RECORD_FOLDER_ID = "unfiledRecordFolderId";

    String TOPIC_ID = "topicId";

    String CLASSIFICATION_GUIDE_ID = "classificationGuideId";


}
