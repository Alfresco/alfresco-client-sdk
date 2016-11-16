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

package com.alfresco.client.api.common.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class PaginationRepresentation extends AbstractRepresentation
{
    @SerializedName("count")
    private int count;

    @SerializedName("hasMoreItems")
    private Boolean hasMoreItems;

    @SerializedName("totalItems")
    private int totalItems;

    @SerializedName("skipCount")
    private int skipCount;

    @SerializedName("maxItems")
    private int maxItems;

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * The number of objects in the entries array.
     * 
     * @return count
     **/
    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    /**
     * A boolean value which is **true** if there are more entities in the
     * collection beyond those in this response. A true value means a body with
     * a larger value for the **skipCount** or the **maxItems** parameter will
     * return more entities.
     * 
     * @return hasMoreItems
     **/
    public Boolean getHasMoreItems()
    {
        return hasMoreItems;
    }

    public void setHasMoreItems(Boolean hasMoreItems)
    {
        this.hasMoreItems = hasMoreItems;
    }

    /**
     * An integer describing the total number of entities in the collection. The
     * API might not be able to determine this value, in which case this
     * property will not be present.
     * 
     * @return totalItems
     **/
    public int getTotalItems()
    {
        return totalItems;
    }

    public void setTotalItems(int totalItems)
    {
        this.totalItems = totalItems;
    }

    /**
     * An integer describing how many entities exist in the collection before
     * those included in this list.
     * 
     * @return skipCount
     **/
    public int getSkipCount()
    {
        return skipCount;
    }

    public void setSkipCount(int skipCount)
    {
        this.skipCount = skipCount;
    }

    /**
     * The value of the **maxItems** parameter used to generate this list, or if
     * there was no **maxItems** parameter the default value is 100
     * 
     * @return maxItems
     **/
    public int getMaxItems()
    {
        return maxItems;
    }

    public void setMaxItems(int maxItems)
    {
        this.maxItems = maxItems;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PaginationRepresentation pagination = (PaginationRepresentation) o;
        return Objects.equals(this.count, pagination.count)
                && Objects.equals(this.hasMoreItems, pagination.hasMoreItems)
                && Objects.equals(this.totalItems, pagination.totalItems)
                && Objects.equals(this.skipCount, pagination.skipCount)
                && Objects.equals(this.maxItems, pagination.maxItems);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(count, hasMoreItems, totalItems, skipCount, maxItems);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Pagination {\n");

        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    hasMoreItems: ").append(toIndentedString(hasMoreItems)).append("\n");
        sb.append("    totalItems: ").append(toIndentedString(totalItems)).append("\n");
        sb.append("    skipCount: ").append(toIndentedString(skipCount)).append("\n");
        sb.append("    maxItems: ").append(toIndentedString(maxItems)).append("\n");
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
