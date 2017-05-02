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

package org.alfresco.client.services.process.enterprise.core.model.editor.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.alfresco.client.services.process.enterprise.admin.model.representation.EndpointConfigurationRepresentation;

/**
 * @author Yvo Swillens
 */
public class RestFieldRepresentation extends FormFieldRepresentation
{

    protected EndpointConfigurationRepresentation endpoint;

    protected DataSourceConfigurationRepresentation dataSource;

    protected List<RequestHeaderRepresentation> requestHeaders;

    public EndpointConfigurationRepresentation getEndpoint()
    {
        return endpoint;
    }

    public void setEndpoint(EndpointConfigurationRepresentation endpoint)
    {
        this.endpoint = endpoint;
    }

    public List<RequestHeaderRepresentation> getRequestHeaders()
    {
        return requestHeaders;
    }

    public void setRequestHeaders(List<RequestHeaderRepresentation> requestHeaders)
    {
        this.requestHeaders = requestHeaders;
    }

    public Map<String, String> requestHeadersAsMap()
    {
        Map<String, String> requestHeadersMap = new HashMap<String, String>();

        if (requestHeaders != null)
        {
            for (RequestHeaderRepresentation requestHeader : requestHeaders)
            {
                requestHeadersMap.put(requestHeader.getName(), requestHeader.getValue());
            }
        }

        return requestHeadersMap;
    }

    public DataSourceConfigurationRepresentation getDataSource()
    {
        return dataSource;
    }

    public void setDataSource(DataSourceConfigurationRepresentation dataSource)
    {
        this.dataSource = dataSource;
    }

}