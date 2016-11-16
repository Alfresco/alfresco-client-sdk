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

public class RatingAggregateRepresentation extends AbstractRepresentation
{
    @SerializedName("average")
    private Integer average = null;

    @SerializedName("numberOfRatings")
    private Integer numberOfRatings = null;

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get average
     * 
     * @return average
     **/
    public Integer getAverage()
    {
        return average;
    }

    public void setAverage(Integer average)
    {
        this.average = average;
    }

    /**
     * Get numberOfRatings
     * 
     * @return numberOfRatings
     **/
    public Integer getNumberOfRatings()
    {
        return numberOfRatings;
    }

    public void setNumberOfRatings(Integer numberOfRatings)
    {
        this.numberOfRatings = numberOfRatings;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RatingAggregateRepresentation ratingAggregate = (RatingAggregateRepresentation) o;
        return Objects.equals(this.average, ratingAggregate.average)
                && Objects.equals(this.numberOfRatings, ratingAggregate.numberOfRatings);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(average, numberOfRatings);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RatingAggregate {\n");

        sb.append("    average: ").append(toIndentedString(average)).append("\n");
        sb.append("    numberOfRatings: ").append(toIndentedString(numberOfRatings)).append("\n");
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
