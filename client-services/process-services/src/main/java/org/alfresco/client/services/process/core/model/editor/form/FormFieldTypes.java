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

import java.util.Arrays;
import java.util.List;

/**
 * @author Joram Barrez
 */
public interface FormFieldTypes
{

    String SINGLE_LINE_TEXT = "text";

    String MULTI_LINE_TEXT = "multi-line-text";

    String INTEGER = "integer";

    String AMOUNT = "amount";

    String DATE = "date";

    String BOOLEAN = "boolean";

    String RADIO_BUTTONS = "radio-buttons";

    String DROPDOWN = "dropdown";

    String TYPEAHEAD = "typeahead";

    String UPLOAD = "upload";

    String DOCUMENT = "document";

    String GROUP = "group";

    String READONLY = "readonly";

    String READONLY_TEXT = "readonly-text";

    String PEOPLE = "people";

    String FUNCTIONAL_GROUP = "functional-group";

    String DYNAMIC_TABLE = "dynamic-table";

    String HYPERLINK = "hyperlink";

    String CONTAINER = "container";

    List<String> DISPLAY_ONLY_TYPES = Arrays.asList(READONLY, READONLY_TEXT, GROUP, CONTAINER);
}
