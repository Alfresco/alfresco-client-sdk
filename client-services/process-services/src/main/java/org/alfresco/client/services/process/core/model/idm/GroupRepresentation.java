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

package org.alfresco.client.services.process.core.model.idm;

import java.util.Date;
import java.util.List;

/**
 * @author Joram Barrez
 */
public class GroupRepresentation
{

    protected Long id;

    protected String name;

    protected Long tenantId;

    protected int type;

    protected Long parentGroupId;

    protected String status;

    protected String externalId;

    protected Date lastSyncTimeStamp;

    protected Long userCount;

    protected List<UserRepresentation> users;

    protected List<GroupCapabilityRepresentation> capabilities;

    protected List<GroupRepresentation> groups;

    public GroupRepresentation()
    {

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getTenantId()
    {
        return tenantId;
    }

    public void setTenantId(Long tenantId)
    {
        this.tenantId = tenantId;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public Long getParentGroupId()
    {
        return parentGroupId;
    }

    public void setParentGroupId(Long parentGroupId)
    {
        this.parentGroupId = parentGroupId;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getExternalId()
    {
        return externalId;
    }

    public void setExternalId(String externalId)
    {
        this.externalId = externalId;
    }

    public Date getLastSyncTimeStamp()
    {
        return lastSyncTimeStamp;
    }

    public void setLastSyncTimeStamp(Date lastSyncTimeStamp)
    {
        this.lastSyncTimeStamp = lastSyncTimeStamp;
    }

    public Long getUserCount()
    {
        return userCount;
    }

    public void setUserCount(Long userCount)
    {
        this.userCount = userCount;
    }

    public List<UserRepresentation> getUsers()
    {
        return users;
    }

    public void setUsers(List<UserRepresentation> users)
    {
        this.users = users;
    }

    public List<GroupCapabilityRepresentation> getCapabilities()
    {
        return capabilities;
    }

    public void setCapabilities(List<GroupCapabilityRepresentation> capabilities)
    {
        this.capabilities = capabilities;
    }

    public List<GroupRepresentation> getGroups()
    {
        return groups;
    }

    public void setGroups(List<GroupRepresentation> groups)
    {
        this.groups = groups;
    }

}
