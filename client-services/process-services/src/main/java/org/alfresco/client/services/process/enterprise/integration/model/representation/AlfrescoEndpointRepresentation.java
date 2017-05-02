/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.integration.model.representation;

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

    private String secret;

    private boolean useShareConnector;

    private String version;

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

    public String getSecret()
    {
        return secret;
    }

    public void setSecret(String secret)
    {
        this.secret = secret;
    }

    public boolean getUseShareConnector()
    {
        return useShareConnector;
    }

    public void setUseShareConnector(boolean useShareConnector)
    {
        this.useShareConnector = useShareConnector;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
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
