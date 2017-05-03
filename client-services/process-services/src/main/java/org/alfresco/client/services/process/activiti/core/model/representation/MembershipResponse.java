package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * MembershipResponse
 */
public class MembershipResponse
{
    @SerializedName("userId")
    private String userId = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("groupId")
    private String groupId = null;

    /**
     * Get userId
     * 
     * @return userId
     **/
    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    /**
     * Get url
     * 
     * @return url
     **/
    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Get groupId
     * 
     * @return groupId
     **/
    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MembershipResponse membershipResponse = (MembershipResponse) o;
        return Objects.equals(this.userId, membershipResponse.userId)
                && Objects.equals(this.url, membershipResponse.url)
                && Objects.equals(this.groupId, membershipResponse.groupId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(userId, url, groupId);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class MembershipResponse {\n");

        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
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
