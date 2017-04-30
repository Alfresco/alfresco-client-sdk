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

package org.alfresco.client.services.process.core.model.runtime;

import java.io.Serializable;

import org.alfresco.client.services.process.core.model.common.AbstractRepresentation;

/**
 * Created by jpascal on 12/12/2014.
 */
public class AppVersionRepresentation extends AbstractRepresentation implements Serializable
{
    protected String type;

    protected String majorVersion;

    protected String minorVersion;

    protected String revisionVersion;

    protected String edition;

    protected String gitVersion;

    public AppVersionRepresentation()
    {
    }

    public String getGitVersion()
    {
        return gitVersion;
    }

    public void setGitVersion(String gitVersion)
    {
        this.gitVersion = gitVersion;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getMajorVersion()
    {
        return majorVersion;
    }

    public void setMajorVersion(String majorVersion)
    {
        this.majorVersion = majorVersion;
    }

    public String getMinorVersion()
    {
        return minorVersion;
    }

    public void setMinorVersion(String minorVersion)
    {
        this.minorVersion = minorVersion;
    }

    public String getRevisionVersion()
    {
        return revisionVersion;
    }

    public void setRevisionVersion(String revisionVersion)
    {
        this.revisionVersion = revisionVersion;
    }

    public String getEdition()
    {
        return edition;
    }

    public void setEdition(String edition)
    {
        this.edition = edition;
    }

    public String getFullVersion()
    {
        return getMajorVersion().concat(".").concat(getMinorVersion()).concat(".").concat(getRevisionVersion());
    }
}
