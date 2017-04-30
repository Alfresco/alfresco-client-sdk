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

package org.alfresco.client.services.process.core.model.editor.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.alfresco.client.services.process.core.model.idm.EndpointConfigurationRepresentation;

/**
 * @author Yvo Swillens
 */
public class ColumnDefinitionRepresentation
{

    protected String id;

    protected String name;

    protected String type;

    protected Object value;

    protected String optionType;

    protected List<OptionRepresentation> options;

    protected String restResponsePath;

    protected String restUrl;

    protected String restIdProperty;

    protected String restLabelProperty;

    protected String amountCurrency;

    protected boolean amountEnableFractions;

    protected boolean required;

    protected boolean editable;

    protected boolean sortable;

    protected boolean visible;

    protected EndpointConfigurationRepresentation endpoint;

    protected List<RequestHeaderRepresentation> requestHeaders;

    public ColumnDefinitionRepresentation(String id)
    {
        this.id = id;
    }

    public ColumnDefinitionRepresentation()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public String getOptionType()
    {
        return optionType;
    }

    public void setOptionType(String optionType)
    {
        this.optionType = optionType;
    }

    public List<OptionRepresentation> getOptions()
    {
        return options;
    }

    public void setOptions(List<OptionRepresentation> options)
    {
        this.options = options;
    }

    public String getRestResponsePath()
    {
        return restResponsePath;
    }

    public void setRestResponsePath(String restResponsePath)
    {
        this.restResponsePath = restResponsePath;
    }

    public String getRestUrl()
    {
        return restUrl;
    }

    public void setRestUrl(String restUrl)
    {
        this.restUrl = restUrl;
    }

    public String getRestIdProperty()
    {
        return restIdProperty;
    }

    public void setRestIdProperty(String restIdProperty)
    {
        this.restIdProperty = restIdProperty;
    }

    public String getRestLabelProperty()
    {
        return restLabelProperty;
    }

    public void setRestLabelProperty(String restLabelProperty)
    {
        this.restLabelProperty = restLabelProperty;
    }

    public boolean isRequired()
    {
        return required;
    }

    public void setRequired(boolean required)
    {
        this.required = required;
    }

    public boolean isEditable()
    {
        return editable;
    }

    public void setEditable(boolean editable)
    {
        this.editable = editable;
    }

    public boolean isSortable()
    {
        return sortable;
    }

    public void setSortable(boolean sortable)
    {
        this.sortable = sortable;
    }

    public boolean isVisible()
    {
        return visible;
    }

    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }

    public EndpointConfigurationRepresentation getEndpoint()
    {
        return endpoint;
    }

    public void setEndpoint(EndpointConfigurationRepresentation endpoint)
    {
        this.endpoint = endpoint;
    }

    public String getAmountCurrency()
    {
        return amountCurrency;
    }

    public void setAmountCurrency(String amountCurrency)
    {
        this.amountCurrency = amountCurrency;
    }

    public boolean isAmountEnableFractions()
    {
        return amountEnableFractions;
    }

    public void setAmountEnableFractions(boolean amountEnableFractions)
    {
        this.amountEnableFractions = amountEnableFractions;
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
}
