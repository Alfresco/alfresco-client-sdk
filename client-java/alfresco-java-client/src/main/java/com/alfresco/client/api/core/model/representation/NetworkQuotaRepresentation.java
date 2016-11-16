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
 * Created by jpascal on 16/01/2016.
 */
public class NetworkQuotaRepresentation
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("limit")
    private Long limit = null;

    @SerializedName("usage")
    private Long usage = null;

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get id
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
     * Get limit
     * 
     * @return limit
     **/
    public Long getLimit()
    {
        return limit;
    }

    public void setLimit(Long limit)
    {
        this.limit = limit;
    }

    /**
     * Get usage
     * 
     * @return usage
     **/
    public Long getUsage()
    {
        return usage;
    }

    public void setUsage(Long usage)
    {
        this.usage = usage;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        NetworkQuotaRepresentation networkQuota = (NetworkQuotaRepresentation) o;
        return Objects.equals(this.id, networkQuota.id) && Objects.equals(this.limit, networkQuota.limit)
                && Objects.equals(this.usage, networkQuota.usage);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, limit, usage);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class NetworkQuota {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
        sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
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
