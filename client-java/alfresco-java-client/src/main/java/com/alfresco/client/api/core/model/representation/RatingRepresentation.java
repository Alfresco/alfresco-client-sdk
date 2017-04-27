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
 * A person can rate an item of content by liking it. They can also remove their
 * like of an item of content. API methods exist to get a list of ratings and to
 * add a new rating.
 */
public class RatingRepresentation extends AbstractRepresentation
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("aggregate")
    private RatingAggregateRepresentation aggregate = null;

    @SerializedName("ratedAt")
    private Date ratedAt = null;

    @SerializedName("myRating")
    private Object myRating = null;

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
     * Get aggregate
     * 
     * @return aggregate
     **/
    public RatingAggregateRepresentation getAggregate()
    {
        return aggregate;
    }

    public void setAggregate(RatingAggregateRepresentation aggregate)
    {
        this.aggregate = aggregate;
    }

    /**
     * Get ratedAt
     * 
     * @return ratedAt
     **/
    public Date getRatedAt()
    {
        return ratedAt;
    }

    public void setRatedAt(Date ratedAt)
    {
        this.ratedAt = ratedAt;
    }

    /**
     * The rating. The type is specific to the rating scheme, boolean for the
     * likes and an integer for the fiveStar.
     * 
     * @return myRating
     **/
    public Object getMyRating()
    {
        return myRating;
    }

    public void setMyRating(Object myRating)
    {
        this.myRating = myRating;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RatingRepresentation rating = (RatingRepresentation) o;
        return Objects.equals(this.id, rating.id) && Objects.equals(this.aggregate, rating.aggregate)
                && Objects.equals(this.ratedAt, rating.ratedAt) && Objects.equals(this.myRating, rating.myRating);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, aggregate, ratedAt, myRating);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Rating {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    aggregate: ").append(toIndentedString(aggregate)).append("\n");
        sb.append("    ratedAt: ").append(toIndentedString(ratedAt)).append("\n");
        sb.append("    myRating: ").append(toIndentedString(myRating)).append("\n");
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
