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
public class ChildAssociationRepresentation
{
    @SerializedName("childId")
    private String childId = null;

    @SerializedName("assocType")
    private String assocType = null;

    /**
     * Get childId
     * 
     * @return childId
     **/
    public String getChildId()
    {
        return childId;
    }

    public void setChildId(String childId)
    {
        this.childId = childId;
    }

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

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ChildAssociationRepresentation assocChild = (ChildAssociationRepresentation) o;
        return Objects.equals(this.childId, assocChild.childId) && Objects.equals(this.assocType, assocChild.assocType);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(childId, assocType);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssocChild {\n");

        sb.append("    childId: ").append(toIndentedString(childId)).append("\n");
        sb.append("    assocType: ").append(toIndentedString(assocType)).append("\n");
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
