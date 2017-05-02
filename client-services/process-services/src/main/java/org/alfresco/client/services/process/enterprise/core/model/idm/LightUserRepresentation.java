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

package org.alfresco.client.services.process.enterprise.core.model.idm;

import com.google.gson.internal.LinkedTreeMap;

/**
 * Created by jpascal on 12/12/2014.
 */
public class LightUserRepresentation extends AbstractUserRepresentation
{
    public LightUserRepresentation()
    {
    }

    public static LightUserRepresentation parse(Object jsonObject)
    {
        if (jsonObject instanceof LinkedTreeMap)
        {
            LightUserRepresentation user = new LightUserRepresentation();
            user.firstName = (String) ((LinkedTreeMap) jsonObject).get("firstName");
            user.lastName = (String) ((LinkedTreeMap) jsonObject).get("lastName");
            user.email = (String) ((LinkedTreeMap) jsonObject).get("email");
            user.id = ((Double) ((LinkedTreeMap) jsonObject).get("id")).longValue();
            return user;
        }
        return null;
    }

    public LightUserRepresentation(Long id)
    {
        this.id = id;
    }

    public LightUserRepresentation(Long id, String firstName, String lastName, String email)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public LightUserRepresentation(String firstName, String lastName, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFullname()
    {
        String fullName = "";
        if (firstName != null)
        {
            fullName = fullName.concat(firstName + " ");
        }

        if (lastName != null)
        {
            fullName = fullName.concat(lastName);
        }

        return (fullName.isEmpty()) ? "" : fullName;
    }

    public String getExternalId()
    {
        return externalId;
    }

    public Long getPictureId()
    {
        return pictureId;
    }

}
