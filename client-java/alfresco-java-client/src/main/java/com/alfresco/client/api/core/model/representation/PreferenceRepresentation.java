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

import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

/**
 * A specific preference.
 */
public class PreferenceRepresentation extends AbstractRepresentation
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("value")
    private String value = null;

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * The unique id of the preference
     * 
     * @return id
     **/
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * The value of the preference. Note that this can be of any JSON type.
     * 
     * @return value
     **/
    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PreferenceRepresentation preference = (PreferenceRepresentation) o;
        return Objects.equals(this.id, preference.id) && Objects.equals(this.value, preference.value);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, value);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Preference {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o)
    {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }
}
