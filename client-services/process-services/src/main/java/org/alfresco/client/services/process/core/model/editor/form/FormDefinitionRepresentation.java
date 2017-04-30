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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Joram Barrez
 */
public class FormDefinitionRepresentation
{

    protected Long id;

    protected String name;

    protected String processDefinitionId;

    protected String processDefinitionName;

    protected String processDefinitionKey;

    protected String taskId;

    protected String taskName;

    protected String taskDefinitionKey;

    protected List<FormTabRepresentation> tabs;

    protected List<FormFieldRepresentation> fields;

    protected String outcomeTarget;

    protected List<FormOutcomeRepresentation> outcomes;

    protected List<FormJavascriptEventRepresentation> javascriptEvents;

    protected String selectedOutcome;

    protected String className;

    protected String style;

    protected Map<String, String> customFieldTemplates = new HashMap<>();

    protected Map<String, String> metadata = new HashMap<>();

    protected boolean gridsterForm = true;

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

    public String getProcessDefinitionId()
    {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId)
    {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessDefinitionName()
    {
        return processDefinitionName;
    }

    public void setProcessDefinitionName(String processDefinitionName)
    {
        this.processDefinitionName = processDefinitionName;
    }

    public String getProcessDefinitionKey()
    {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey)
    {
        this.processDefinitionKey = processDefinitionKey;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getTaskDefinitionKey()
    {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey)
    {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    /**
     * Do not use this method for logical operations since it only return the
     * top level fields. I.e. A "container" field's sub fields are not returned.
     * For verifying and listing all fields from a form use instead
     * listAllFields().
     *
     * @return The top level fields, a container's sub fields are not returned.
     */
    public List<FormFieldRepresentation> getFields()
    {
        return fields;
    }

    public void setFields(List<FormFieldRepresentation> fields)
    {
        this.fields = fields;
    }

    public List<FormTabRepresentation> getTabs()
    {
        return tabs;
    }

    public void setTabs(List<FormTabRepresentation> tabs)
    {
        this.tabs = tabs;
    }

    public String getOutcomeTarget()
    {
        return outcomeTarget;
    }

    public void setOutcomeTarget(String outcomeTarget)
    {
        this.outcomeTarget = outcomeTarget;
    }

    public List<FormOutcomeRepresentation> getOutcomes()
    {
        return outcomes;
    }

    public void setOutcomes(List<FormOutcomeRepresentation> outcomes)
    {
        this.outcomes = outcomes;
    }

    public List<FormJavascriptEventRepresentation> getJavascriptEvents()
    {
        return javascriptEvents;
    }

    public void setJavascriptEvents(List<FormJavascriptEventRepresentation> javascriptEvents)
    {
        this.javascriptEvents = javascriptEvents;
    }

    public String getSelectedOutcome()
    {
        return selectedOutcome;
    }

    public void setSelectedOutcome(String selectedOutcome)
    {
        this.selectedOutcome = selectedOutcome;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getStyle()
    {
        return style;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }

    public Map<String, String> getCustomFieldTemplates()
    {
        return customFieldTemplates;
    }

    public void setCustomFieldTemplates(Map<String, String> customFieldTemplates)
    {
        this.customFieldTemplates = customFieldTemplates;
    }

    public Map<String, String> getMetadata()
    {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata)
    {
        this.metadata = metadata;
    }

    public boolean isGridsterForm()
    {
        return gridsterForm;
    }

    public void setGridsterForm(boolean gridsterForm)
    {
        this.gridsterForm = gridsterForm;
    }

    /*
     * Helper methods
     */
    public Map<String, FormFieldRepresentation> allFieldsAsMap()
    {
        Map<String, FormFieldRepresentation> result = new HashMap<String, FormFieldRepresentation>();
        List<FormFieldRepresentation> allFields = listAllFields();
        if (allFields != null)
        {
            for (FormFieldRepresentation field : allFields)
            {
                if (result.containsKey(field.getId()) == false || ("readonly".equals(field.getType()) == false
                        && "readonly-text".equals(field.getType()) == false))
                {

                    result.put(field.getId(), field);
                }
            }
        }
        return result;
    }

    public List<FormFieldRepresentation> listAllFields()
    {
        List<FormFieldRepresentation> listOfAllFields = new ArrayList<FormFieldRepresentation>();
        collectSubFields(fields, listOfAllFields);
        return listOfAllFields;
    }

    protected void collectSubFields(List<FormFieldRepresentation> fields, List<FormFieldRepresentation> listOfAllFields)
    {
        if (fields != null && !fields.isEmpty())
        {
            for (FormFieldRepresentation field : fields)
            {
                listOfAllFields.add(field);
                if (field instanceof ContainerRepresentation)
                {
                    ContainerRepresentation container = (ContainerRepresentation) field;
                    Map<String, List<FormFieldRepresentation>> subFieldMap = container.getFields();
                    if (subFieldMap != null)
                    {
                        for (List<FormFieldRepresentation> subFields : subFieldMap.values())
                        {
                            if (subFields != null)
                            {
                                collectSubFields(subFields, listOfAllFields);
                            }
                        }
                    }
                }
            }
        }
    }

}
