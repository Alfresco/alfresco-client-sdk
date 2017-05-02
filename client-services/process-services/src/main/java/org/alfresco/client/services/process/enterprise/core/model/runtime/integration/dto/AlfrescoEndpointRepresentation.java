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

package org.alfresco.client.services.process.enterprise.core.model.runtime.integration.dto;

import java.util.Date;

import org.alfresco.client.services.process.enterprise.common.model.representation.AbstractRepresentation;

public class AlfrescoEndpointRepresentation extends AbstractRepresentation
{
    private Long id;

    private Long tenantId;

    private Date created;

    private Date lastUpdated;

    private String alfrescoTenantId;

    private String repositoryUrl;

    private String shareUrl;

    private String name;

    private String accountUsername;

    public AlfrescoEndpointRepresentation()
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

    public Long getTenantId()
    {
        return tenantId;
    }

    public void setTenantId(Long tenantId)
    {
        this.tenantId = tenantId;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public Date getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public String getAlfrescoTenantId()
    {
        return alfrescoTenantId;
    }

    public void setAlfrescoTenantId(String alfrescoTenantId)
    {
        this.alfrescoTenantId = alfrescoTenantId;
    }

    public String getRepositoryUrl()
    {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl)
    {
        this.repositoryUrl = repositoryUrl;
    }

    public String getShareUrl()
    {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl)
    {
        this.shareUrl = shareUrl;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAccountUsername()
    {
        return accountUsername;
    }

    public void setAccountUsername(String accountUserName)
    {
        this.accountUsername = accountUserName;
    }

}
