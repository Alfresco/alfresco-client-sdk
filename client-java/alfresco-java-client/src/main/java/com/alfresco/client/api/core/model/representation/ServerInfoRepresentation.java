/*
 *   Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *   This file is part of Alfresco Java Client.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.alfresco.client.api.core.model.representation;

import com.alfresco.client.api.common.representation.AbstractRepresentation;

public class ServerInfoRepresentation extends AbstractRepresentation
{
    private String edition;

    private String version;

    private String schema;

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
    public String getEdition()
    {
        return edition;
    }

    public void setEdition(String edition)
    {
        this.edition = edition;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getSchema()
    {
        return schema;
    }

    public void setSchema(String schema)
    {
        this.schema = schema;
    }

}
