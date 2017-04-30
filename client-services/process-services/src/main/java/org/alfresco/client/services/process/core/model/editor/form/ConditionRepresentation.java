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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.alfresco.client.services.process.core.model.utils.StringUtils;

/**
 * @author Joram Barrez
 */
public class ConditionRepresentation implements Iterable<ConditionRepresentation>
{

    // Condition
    private String leftFormFieldId;

    private String leftRestResponseId;

    private String operator;

    private Object rightValue;

    private String rightType;

    private String rightFormFieldId;

    private String rightRestResponseId;

    // Next condition
    private String nextConditionOperator;

    private ConditionRepresentation nextCondition;

    public String getLeftFormFieldId()
    {
        return leftFormFieldId;
    }

    public ConditionRepresentation setLeftFormFieldId(String leftFormFieldId)
    {
        this.leftFormFieldId = leftFormFieldId;
        return this;
    }

    public String getLeftRestResponseId()
    {
        return leftRestResponseId;
    }

    public void setLeftRestResponseId(String leftRestResponseId)
    {
        this.leftRestResponseId = leftRestResponseId;
    }

    public String getOperator()
    {
        return operator;
    }

    public ConditionRepresentation setOperator(String operator)
    {
        this.operator = operator;
        return this;
    }

    public Object getRightValue()
    {
        return rightValue;
    }

    public ConditionRepresentation setRightValue(Object value)
    {
        this.rightValue = value;
        return this;
    }

    public String getRightType()
    {
        return rightType;
    }

    public ConditionRepresentation setRightType(String rightType)
    {
        this.rightType = rightType;
        return this;
    }

    public String getRightFormFieldId()
    {
        return rightFormFieldId;
    }

    public ConditionRepresentation setRightFormFieldId(String rightFormFieldId)
    {
        this.rightFormFieldId = rightFormFieldId;
        return this;
    }

    public String getRightRestResponseId()
    {
        return rightRestResponseId;
    }

    public void setRightRestResponseId(String rightRestResponseId)
    {
        this.rightRestResponseId = rightRestResponseId;
    }

    public String getNextConditionOperator()
    {
        return nextConditionOperator;
    }

    public ConditionRepresentation getNextCondition()
    {
        return nextCondition;
    }

    public ConditionRepresentation setNextCondition(String operator, ConditionRepresentation nextCondition)
    {
        this.nextConditionOperator = operator;
        this.nextCondition = nextCondition;
        return this;
    }

    protected String getFieldValueFromForm(String fieldId, Map<String, Object> values,
            Map<String, FormFieldRepresentation> fieldsRepresentation)
    {
        String fieldIdWithoutSuffix = removeLabelSuffixFromTheId(fieldId);

        FormFieldRepresentation formFieldDefinition = fieldsRepresentation.get(fieldIdWithoutSuffix);

        if (formFieldDefinition != null)
        {
            Object formFieldValue = values.get(fieldIdWithoutSuffix);
            if (formFieldDefinition.isFieldTypeHashMap()) { return getFieldValueFromHashMap(formFieldValue, fieldId); }
            if (formFieldDefinition.isFieldTypeText()) { return String.valueOf(formFieldValue); }
            if (formFieldDefinition.isFieldTypeDate()) { return getFieldValueFromDate(formFieldValue); }

        }
        else if (values.get(fieldId) != null) { return String.valueOf(values.get(fieldId)); }

        return StringUtils.EMPTY;
    }

    protected String removeLabelSuffixFromTheId(String fieldId)
    {
        if (isLabelField(fieldId))
        {
            return fieldId.substring(0, fieldId.indexOf("_LABEL"));
        }
        else
        {
            return fieldId;
        }
    }

    protected String getFieldValueFromDate(Object fieldForm)
    {
        if (fieldForm != null && StringUtils.isNotEmpty((String) fieldForm))
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try
            {
                Date dateLeft = formatter.parse((String) fieldForm);
                return String.valueOf(dateLeft.getTime());
            }
            catch (ParseException e)
            {
                return StringUtils.EMPTY;
            }
        }
        else
        {
            return StringUtils.EMPTY;
        }
    }

    protected String getFieldValueFromHashMap(Object fieldForm, String fieldId)
    {
        HashMap<?, ?> formValuelist = (LinkedHashMap<?, ?>) fieldForm;
        if (isLabelField(fieldId))
        {
            return (String) formValuelist.get("name");
        }
        else
        {
            return String.valueOf(formValuelist.get("id"));
        }
    }

    protected boolean isLabelField(String fieldId)
    {
        return fieldId.indexOf("_LABEL") > 0;
    }

    public String getLeftFieldValueToCompare(Map<String, Object> values, Map<String, FormFieldRepresentation> fieldMap)
    {
        if (StringUtils.isNotEmpty(getLeftFormFieldId()))
        {
            return getFieldValueFromForm(getLeftFormFieldId(), values, fieldMap);
        }
        else
        {
            return getFieldValueFromForm(getLeftRestResponseId(), values, fieldMap);
        }
    }

    public String getRigthValueToCompare(Map<String, Object> values, Map<String, FormFieldRepresentation> fieldMap)
    {
        if (StringUtils.isNotEmpty(getRightFormFieldId()))
        {
            return getFieldValueFromForm(getRightFormFieldId(), values, fieldMap);
        }
        else
        {
            if (StringUtils.isNotEmpty(getRightRestResponseId()))
            {
                return getFieldValueFromForm(getRightRestResponseId(), values, fieldMap);
            }
            else if (getRightValue() != null)
            {
                String leftFieldType = getLeftFieldType(fieldMap);
                if (FormFieldTypes.DATE.equals(leftFieldType))
                {
                    return getFieldValueFromDate(getRightValue());
                }
                else
                {
                    return String.valueOf(getRightValue());
                }
            }
            return StringUtils.EMPTY;
        }
    }

    public String getLeftFieldType(Map<String, FormFieldRepresentation> fieldMap)
    {
        if (StringUtils.isNotEmpty(getLeftFormFieldId()))
        {
            String fieldIWithoutSuffix = removeLabelSuffixFromTheId(getLeftFormFieldId());
            FormFieldRepresentation formFieldRep = fieldMap.get(fieldIWithoutSuffix);
            return formFieldRep != null ? formFieldRep.getType() : StringUtils.EMPTY;
        }
        return StringUtils.EMPTY;
    }

    public Iterator<ConditionRepresentation> iterator()
    {
        return new Iterator<ConditionRepresentation>()
        {

            ConditionRepresentation head = null;

            @Override
            public ConditionRepresentation next()
            {
                if (head == null)
                {
                    head = ConditionRepresentation.this;
                }
                else
                {
                    head = head.getNextCondition();
                }
                return head;
            }

            @Override
            public boolean hasNext()
            {
                if (head == null)
                {
                    return true;
                }
                else
                {
                    return head.getNextCondition() != null;
                }
            }

            @Override
            public void remove()
            {
                // not implemented
            }

        };
    }

}
