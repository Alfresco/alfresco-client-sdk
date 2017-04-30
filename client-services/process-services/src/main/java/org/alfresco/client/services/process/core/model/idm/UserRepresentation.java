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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.alfresco.client.services.process.core.model.editor.LightAppRepresentation;

/**
 * Created by jpascal on 15/12/2014.
 */
public class UserRepresentation extends AbstractUserRepresentation
{

    protected String fullname;

    protected String password;

    protected String company;

    protected String type;

    protected String status;

    protected Date created;

    protected Date lastUpdate;

    protected Long tenantId;

    protected Date latestSyncTimeStamp;

    protected List<GroupRepresentation> groups;

    protected List<String> capabilities;

    protected List<LightAppRepresentation> apps = new ArrayList<LightAppRepresentation>();

    /**
     * These properties are not part of the user data, but they are filled by
     * some requests (eg the account request) because they avoid needing to do
     * multiple calls.
     */
    protected Long tenantPictureId;

    protected String tenantName;

    public UserRepresentation()
    {

    }

    public String getFullname()
    {
        return fullname;
    }

    public void setFullname(String fullname)
    {
        this.fullname = fullname;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public Date getCreated()
    {
        return created;
    }

    public Date getLastUpdate()
    {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }

    public Long getTenantId()
    {
        return tenantId;
    }

    public void setTenantId(Long tenantId)
    {
        this.tenantId = tenantId;
    }

    public String getTenantName()
    {
        return tenantName;
    }

    public void setTenantName(String tenantName)
    {
        this.tenantName = tenantName;
    }

    public List<GroupRepresentation> getGroups()
    {
        return groups;
    }

    public void setGroups(List<GroupRepresentation> groups)
    {
        this.groups = groups;
    }

    public List<String> getCapabilities()
    {
        return capabilities;
    }

    public void setCapabilities(List<String> capabilities)
    {
        this.capabilities = capabilities;
    }

    public Long getTenantPictureId()
    {
        return tenantPictureId;
    }

    public void setTenantPictureId(Long tenantPictureId)
    {
        this.tenantPictureId = tenantPictureId;
    }

    public String getExternalId()
    {
        return externalId;
    }

    public void setExternalId(String externalId)
    {
        this.externalId = externalId;
    }

    public Date getLatestSyncTimeStamp()
    {
        return latestSyncTimeStamp;
    }

    public void setLatestSyncTimeStamp(Date latestSyncTimeStamp)
    {
        this.latestSyncTimeStamp = latestSyncTimeStamp;
    }

    public List<LightAppRepresentation> getApps()
    {
        return apps;
    }

    public void setApps(List<LightAppRepresentation> apps)
    {
        this.apps = apps;
    }
}
