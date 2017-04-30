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

/**
 * @author Joram Barrez
 */
public class FormFieldRepresentation
{
    protected String id;

    protected String name;

    protected String type;

    protected Object value;

    protected boolean required;

    protected boolean readOnly;

    protected boolean overrideId;

    protected int colspan = 1;

    protected String placeholder;

    protected int minLength;

    protected int maxLength;

    protected String minValue;

    protected String maxValue;

    protected String regexPattern;

    protected String optionType;

    protected Boolean hasEmptyValue; // Needs to be Boolean with a big B for
                                     // backwards compatibility

    protected List<OptionRepresentation> options;

    protected String restUrl;

    protected String restResponsePath;

    protected String restIdProperty;

    protected String restLabelProperty;

    protected String tab;

    protected String className;

    protected Map<String, Object> params;

    protected LayoutRepresentation layout;

    protected int sizeX;

    protected int sizeY;

    protected int row;

    protected int col;

    public FormFieldRepresentation()
    {
    }

    /**
     * Constructor for creating a field based on the information from another
     * one. Note that it does NOT go deep into objects, but only copies the
     * first level of attributes.
     *
     * @param formField
     */

    protected ConditionRepresentation visibilityCondition;

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

    public boolean isRequired()
    {
        return required;
    }

    public void setRequired(boolean required)
    {
        this.required = required;
    }

    public boolean isReadOnly()
    {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly)
    {
        this.readOnly = readOnly;
    }

    public boolean isOverrideId()
    {
        return overrideId;
    }

    public void setOverrideId(boolean overrideId)
    {
        this.overrideId = overrideId;
    }

    public int getColspan()
    {
        return colspan;
    }

    public void setColspan(int colspan)
    {
        this.colspan = colspan;
    }

    public String getOptionType()
    {
        return optionType;
    }

    public void setOptionType(String optionType)
    {
        this.optionType = optionType;
    }

    public Boolean getHasEmptyValue()
    {
        return hasEmptyValue;
    }

    public void setHasEmptyValue(Boolean hasEmptyValue)
    {
        this.hasEmptyValue = hasEmptyValue;
    }

    public List<OptionRepresentation> getOptions()
    {
        return options;
    }

    public void setOptions(List<OptionRepresentation> options)
    {
        this.options = options;
    }

    public String getPlaceholder()
    {
        return placeholder;
    }

    public void setPlaceholder(String placeholder)
    {
        this.placeholder = placeholder;
    }

    public int getMinLength()
    {
        return minLength;
    }

    public void setMinLength(int minLength)
    {
        this.minLength = minLength;
    }

    public int getMaxLength()
    {
        return maxLength;
    }

    public void setMaxLength(int maxLength)
    {
        this.maxLength = maxLength;
    }

    public String getRegexPattern()
    {
        return regexPattern;
    }

    public void setRegexPattern(String regexPattern)
    {
        this.regexPattern = regexPattern;
    }

    public String getMinValue()
    {
        return minValue;
    }

    public void setMinValue(String minValue)
    {
        this.minValue = minValue;
    }

    public String getMaxValue()
    {
        return maxValue;
    }

    public void setMaxValue(String maxValue)
    {
        this.maxValue = maxValue;
    }

    public String getRestUrl()
    {
        return restUrl;
    }

    public void setRestUrl(String restUrl)
    {
        this.restUrl = restUrl;
    }

    public String getRestResponsePath()
    {
        return restResponsePath;
    }

    public void setRestResponsePath(String restResponsePath)
    {
        this.restResponsePath = restResponsePath;
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

    public String getTab()
    {
        return tab;
    }

    public void setTab(String tab)
    {
        this.tab = tab;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public LayoutRepresentation getLayout()
    {
        return layout;
    }

    public void setLayout(LayoutRepresentation layout)
    {
        this.layout = layout;
    }

    public int getSizeX()
    {
        return sizeX;
    }

    public void setSizeX(int sizeX)
    {
        this.sizeX = sizeX;
    }

    public int getSizeY()
    {
        return sizeY;
    }

    public void setSizeY(int sizeY)
    {
        this.sizeY = sizeY;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getCol()
    {
        return col;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    public ConditionRepresentation getVisibilityCondition()
    {
        return visibilityCondition;
    }

    public boolean hasVisibilityCondition()
    {
        return visibilityCondition != null ? true : false;
    }

    public void setVisibilityCondition(ConditionRepresentation visibilityCondition)
    {
        this.visibilityCondition = visibilityCondition;
    }

    public Map<String, Object> getParams()
    {
        return params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }

    public Object getParam(String name)
    {
        if (params != null) { return params.get(name); }
        return null;
    }

    public boolean isDisplayOnly()
    {
        return FormFieldTypes.DISPLAY_ONLY_TYPES.contains(type);
    }

    public boolean isFieldTypeText()
    {
        return FormFieldTypes.BOOLEAN.equals(type) || FormFieldTypes.SINGLE_LINE_TEXT.equals(type)
                || FormFieldTypes.MULTI_LINE_TEXT.equals(type) || FormFieldTypes.INTEGER.equals(type)
                || FormFieldTypes.AMOUNT.equals(type);
    }

    public boolean isFieldTypeDate()
    {
        return FormFieldTypes.DATE.equals(type);
    }

    public boolean isFieldTypeHashMap()
    {
        return FormFieldTypes.DROPDOWN.equals(type) || FormFieldTypes.TYPEAHEAD.equals(type)
                || FormFieldTypes.RADIO_BUTTONS.equals(type);
    }

    private String getROFieldType()
    {
        return (getParams() != null && getParams().get("field") != null
                && ((HashMap) getParams().get("field")).get("type") != null)
                        ? (String) ((HashMap) getParams().get("field")).get("type") : null;
    }

    public String getReadOnlyFieldType()
    {
        String type = getROFieldType();
        // For readonly getRO is null so we switch to get default type.
        return (type == null || type.isEmpty()) ? getType() : type;
    }
}
