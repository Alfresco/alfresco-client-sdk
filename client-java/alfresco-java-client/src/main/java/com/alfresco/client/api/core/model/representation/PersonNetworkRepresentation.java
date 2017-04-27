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
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 16/01/2016.
 */
public class PersonNetworkRepresentation
{
    @SerializedName("id")
    private String id;

    @SerializedName("homeNetwork")
    private Boolean homeNetwork;

    @SerializedName("isEnabled")
    private Boolean isEnabled;

    @SerializedName("createdAt")
    private Date createdAt;

    @SerializedName("paidNetwork")
    private Boolean paidNetwork;

    @SerializedName("subscriptionLevel")
    private String subscriptionLevel;

    @SerializedName("quotas")
    private List<NetworkQuotaRepresentation> quotas;

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * This network's unique id
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
     * Is this the home network?
     * 
     * @return homeNetwork
     **/
    public Boolean getHomeNetwork()
    {
        return homeNetwork;
    }

    public void setHomeNetwork(Boolean homeNetwork)
    {
        this.homeNetwork = homeNetwork;
    }

    /**
     * Get isEnabled
     * 
     * @return isEnabled
     **/
    public Boolean getIsEnabled()
    {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled)
    {
        this.isEnabled = isEnabled;
    }

    /**
     * Get createdAt
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
     * Get paidNetwork
     * 
     * @return paidNetwork
     **/
    public Boolean getPaidNetwork()
    {
        return paidNetwork;
    }

    public void setPaidNetwork(Boolean paidNetwork)
    {
        this.paidNetwork = paidNetwork;
    }

    /**
     * Get subscriptionLevel
     * 
     * @return subscriptionLevel
     **/
    public String getSubscriptionLevel()
    {
        return subscriptionLevel;
    }

    public void setSubscriptionLevel(String subscriptionLevel)
    {
        this.subscriptionLevel = subscriptionLevel;
    }

    public SubscriptionLevelEnum getSubscriptionLevelEnum()
    {
        return subscriptionLevel != null ? SubscriptionLevelEnum.fromString(subscriptionLevel) : null;
    }

    public void setSubscriptionLevelEnum(SubscriptionLevelEnum subscriptionLevel)
    {
        this.subscriptionLevel = subscriptionLevel.toString();
    }

    /**
     * Get quotas
     * 
     * @return quotas
     **/
    public List<NetworkQuotaRepresentation> getQuotas()
    {
        return quotas;
    }

    public void setQuotas(List<NetworkQuotaRepresentation> quotas)
    {
        this.quotas = quotas;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PersonNetworkRepresentation personNetwork = (PersonNetworkRepresentation) o;
        return Objects.equals(this.id, personNetwork.id) && Objects.equals(this.homeNetwork, personNetwork.homeNetwork)
                && Objects.equals(this.isEnabled, personNetwork.isEnabled)
                && Objects.equals(this.createdAt, personNetwork.createdAt)
                && Objects.equals(this.paidNetwork, personNetwork.paidNetwork)
                && Objects.equals(this.subscriptionLevel, personNetwork.subscriptionLevel)
                && Objects.equals(this.quotas, personNetwork.quotas);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, homeNetwork, isEnabled, createdAt, paidNetwork, subscriptionLevel, quotas);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class PersonNetwork {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    homeNetwork: ").append(toIndentedString(homeNetwork)).append("\n");
        sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    paidNetwork: ").append(toIndentedString(paidNetwork)).append("\n");
        sb.append("    subscriptionLevel: ").append(toIndentedString(subscriptionLevel)).append("\n");
        sb.append("    quotas: ").append(toIndentedString(quotas)).append("\n");
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
