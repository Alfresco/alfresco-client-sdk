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

import org.alfresco.client.services.process.enterprise.core.model.editor.kickstart.TypedObject;

/**
 * @author Tijs Rademakers
 */
public class QueryParameterConfigurationRepresentation
{

    protected String column;

    protected String valueType;

    protected String value;

    protected TypedObject valueObject;

    public String getColumn()
    {
        return column;
    }

    public void setColumn(String column)
    {
        this.column = column;
    }

    public String getValueType()
    {
        return valueType;
    }

    public void setValueType(String valueType)
    {
        this.valueType = valueType;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public TypedObject getValueObject()
    {
        return valueObject;
    }

    public void setValueObject(TypedObject valueObject)
    {
        this.valueObject = valueObject;
    }
}
