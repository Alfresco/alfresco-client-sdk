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
package org.alfresco.client.services.process.enterprise.admin.model.representation;

import java.io.Serializable;
import java.util.Date;

/**
 * A tenant.
 * 
 * @author Joram Barrez
 */
public class TenantEvent implements Serializable
{

    public static final String SYSTEM = "system";

    public static final String TYPE_CREATED = "tenantCreated";

    public static final String TYPE_NAME_CHANGED = "tenantNameChanged";

    public static final String TYPE_ACTIVATED = "tenantActivated";

    public static final String TYPE_DEACTIVATED = "tenantDeactivated";

    public static final String TYPE_USER_ADDED = "userAdded";

    public static final String TYPE_USER_REMOVED = "userRemoved";

    public static final String TYPE_SYSTEM_GROUP_ADDED = "systemGroupAdded";

    public static final String TYPE_FUNCTIONAL_GROUP_ADDED = "functionalGroupAdded";

    public static final String TYPE_SYSTEM_GROUP_NAME_CHANGED = "systemGroupNameChanged";

    public static final String TYPE_FUNCTIONAL_GROUP_NAME_CHANGED = "functionalGroupNameChanged";

    public static final String TYPE_SYSTEM_GROUP_DELETED = "systemGroupDeleted";

    public static final String TYPE_FUNCTIONAL_GROUP_DELETED = "functionalGroupDeleted";

    public static final String TYPE_FUNCTIONAL_GROUP_DEACTIVATED = "functionalGroupDeactivated";

    public static final String TYPE_FUNCTIONAL_GROUP_ACTIVATED = "functionalGroupActivated";

    public static final String TYPE_USER_STATUS_CHANGED = "userStatusChanged";

    public static final String TYPE_USER_ACCOUNT_TYPE_CHANGED = "userAccountTypeChanged";

    public static final String TYPE_USER_EMAIL_CHANGED = "userEmailChanged";

    public static final String TYPE_USER_FIRST_NAME_CHANGED = "userFirstNameChanged";

    public static final String TYPE_USER_LAST_NAME_CHANGED = "userLastNameChanged";

    public static final String TYPE_USER_ADDED_TO_GROUP = "userAddedToGroup";

    public static final String TYPE_USER_REMOVED_FROM_GROUP = "userRemovedFromGroup";

    private static final long serialVersionUID = 1L;

    public TenantEvent()
    {

    }

    protected Long id;

    protected Date eventTime;

    protected Long tenantId;

    protected String eventType;

    protected String extraInfo;

    protected Long userId;

    protected String userName;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getEventTime()
    {
        return eventTime;
    }

    public void setEventTime(Date eventTime)
    {
        this.eventTime = eventTime;
    }

    public Long getTenantId()
    {
        return tenantId;
    }

    public void setTenantId(Long tenantId)
    {
        this.tenantId = tenantId;
    }

    public String getEventType()
    {
        return eventType;
    }

    public void setEventType(String eventType)
    {
        this.eventType = eventType;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getExtraInfo()
    {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo)
    {
        this.extraInfo = extraInfo;
    }
}
