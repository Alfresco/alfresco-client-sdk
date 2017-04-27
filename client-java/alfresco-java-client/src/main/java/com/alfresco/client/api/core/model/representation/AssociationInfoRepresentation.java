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

import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 29/07/2016.
 */
public class AssociationInfoRepresentation
{
    @SerializedName("assocType")
    protected String assocType = null;

    // High simplification to get same object for getParent or getAssoc
    @SerializedName("isPrimary")
    private Boolean isPrimary = null;

    /**
     * Get assocType
     *
     * @return assocType
     **/
    public String getAssocType()
    {
        return assocType;
    }

    public void setAssocType(String assocType)
    {
        this.assocType = assocType;
    }

    public Boolean getIsPrimary()
    {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary)
    {
        this.isPrimary = isPrimary;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssociationInfoRepresentation assocChild = (AssociationInfoRepresentation) o;
        return Objects.equals(this.assocType, assocChild.assocType)
                && Objects.equals(this.isPrimary, assocChild.isPrimary);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(assocType);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssocChild {\n");

        sb.append("    assocType: ").append(toIndentedString(assocType)).append("\n");
        sb.append("    isPrimary: ").append(toIndentedString(isPrimary)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o)
    {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
