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

import java.util.Date;
import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

/**
 * Favorite
 */
public class FavoriteRepresentation<T> extends AbstractRepresentation
{
    @SerializedName("targetGuid")
    protected String targetGuid = null;

    @SerializedName("createdAt")
    protected Date createdAt = null;

    @SerializedName("target")
    protected T target = null;

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * The guid of the object that is a favorite.
     * 
     * @return targetGuid
     **/
    public String getTargetGuid()
    {
        return targetGuid;
    }

    public void setTargetGuid(String targetGuid)
    {
        this.targetGuid = targetGuid;
    }

    /**
     * The time the object was made a favorite.
     * 
     * @return createdAt
     **/
    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    /**
     * Get target
     * 
     * @return target
     **/
    public T getTarget()
    {
        return target;
    }

    public void setTarget(T target)
    {
        this.target = target;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        FavoriteRepresentation favorite = (FavoriteRepresentation) o;
        return Objects.equals(this.targetGuid, favorite.targetGuid)
                && Objects.equals(this.createdAt, favorite.createdAt) && Objects.equals(this.target, favorite.target);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(targetGuid, createdAt, target);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Favorite {\n");

        sb.append("    targetGuid: ").append(toIndentedString(targetGuid)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    target: ").append(toIndentedString(target)).append("\n");
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
