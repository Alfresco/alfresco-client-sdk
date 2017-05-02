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

import java.util.List;

/**
 * @author Yvo Swillens
 */
public class EndpointConfigurationRepresentation
{

    private Long id;

    private Long tenantId;

    private String name;

    private String protocol;

    private String host;

    private String port;

    private String path;

    private Long basicAuthId;

    private String basicAuthName;

    private List<EndpointRequestHeaderRepresentation> requestHeaders;

    public EndpointConfigurationRepresentation()
    {

    }

    public EndpointConfigurationRepresentation(Long tenantId, String name, String protocol, String host, String port,
            String path, Long basicAuth, String basicAuthName)
    {
        this.tenantId = tenantId;
        this.name = name;
        this.protocol = protocol;
        this.host = host;
        this.path = path;
        this.basicAuthId = basicAuth;
        this.basicAuthName = basicAuthName;
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getProtocol()
    {
        return protocol;
    }

    public void setProtocol(String protocol)
    {
        this.protocol = protocol;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public String getPort()
    {
        return port;
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public Long getBasicAuthId()
    {
        return basicAuthId;
    }

    public void setBasicAuthId(Long basicAuthId)
    {
        this.basicAuthId = basicAuthId;
    }

    public String getBasicAuthName()
    {
        return basicAuthName;
    }

    public void setBasicAuthName(String basicAuthName)
    {
        this.basicAuthName = basicAuthName;
    }

    public List<EndpointRequestHeaderRepresentation> getRequestHeaders()
    {
        return requestHeaders;
    }

    public void setRequestHeaders(List<EndpointRequestHeaderRepresentation> requestHeaders)
    {
        this.requestHeaders = requestHeaders;
    }
}
