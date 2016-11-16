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
import com.google.gson.internal.LinkedTreeMap;

/**
 * Activities describe any past activity in a site, for example creating an item
 * of content, commenting on a node, liking an item of content.
 */
public class ActivityRepresentation extends AbstractRepresentation
{
    @SerializedName("postPersonId")
    private String postPersonId = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("siteId")
    private String siteId = null;

    @SerializedName("postedAt")
    private Date postedAt = null;

    @SerializedName("feedPersonId")
    private String feedPersonId = null;

    @SerializedName("activitySummary")
    private LinkedTreeMap<String, Object> activitySummary;

    @SerializedName("activityType")
    private String activityType = null;

    /**
     * The id of the person who performed the activity
     * 
     * @return postPersonId
     **/
    public String getPostPersonId()
    {
        return postPersonId;
    }

    public void setPostPersonId(String postPersonId)
    {
        this.postPersonId = postPersonId;
    }

    /**
     * The unique id of the activity
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
     * The unique id of the site on which the activity was performed
     * 
     * @return siteId
     **/
    public String getSiteId()
    {
        return siteId;
    }

    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }

    /**
     * The date time at which the activity was performed
     * 
     * @return postedAt
     **/
    public Date getPostedAt()
    {
        return postedAt;
    }

    public void setPostedAt(Date postedAt)
    {
        this.postedAt = postedAt;
    }

    /**
     * The feed on which this activity was posted
     * 
     * @return feedPersonId
     **/
    public String getFeedPersonId()
    {
        return feedPersonId;
    }

    public void setFeedPersonId(String feedPersonId)
    {
        this.feedPersonId = feedPersonId;
    }

    /**
     * Get activitySummary
     * 
     * @return activitySummary
     **/
    public LinkedTreeMap<String, Object> getActivitySummary()
    {
        return activitySummary;
    }

    public void setActivitySummary(LinkedTreeMap<String, Object> activitySummary)
    {
        this.activitySummary = activitySummary;
    }

    /**
     * The type of the activity posted
     * 
     * @return activityType
     **/
    public String getActivityType()
    {
        return activityType;
    }

    public void setActivityType(String activityType)
    {
        this.activityType = activityType;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ActivityRepresentation activity = (ActivityRepresentation) o;
        return Objects.equals(this.postPersonId, activity.postPersonId) && Objects.equals(this.id, activity.id)
                && Objects.equals(this.siteId, activity.siteId) && Objects.equals(this.postedAt, activity.postedAt)
                && Objects.equals(this.feedPersonId, activity.feedPersonId)
                && Objects.equals(this.activitySummary, activity.activitySummary)
                && Objects.equals(this.activityType, activity.activityType);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(postPersonId, id, siteId, postedAt, feedPersonId, activitySummary, activityType);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Activity {\n");

        sb.append("    postPersonId: ").append(toIndentedString(postPersonId)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    siteId: ").append(toIndentedString(siteId)).append("\n");
        sb.append("    postedAt: ").append(toIndentedString(postedAt)).append("\n");
        sb.append("    feedPersonId: ").append(toIndentedString(feedPersonId)).append("\n");
        sb.append("    activitySummary: ").append(toIndentedString(activitySummary)).append("\n");
        sb.append("    activityType: ").append(toIndentedString(activityType)).append("\n");
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
