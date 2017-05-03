package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * RestIdentityLink
 */
public class RestIdentityLink
{
    @SerializedName("url")
    private String url = null;

    @SerializedName("user")
    private String user = null;

    @SerializedName("group")
    private String group = null;

    @SerializedName("type")
    private String type = null;

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
     * Get user
     * 
     * @return user
     **/
    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    /**
     * Get group
     * 
     * @return group
     **/
    public String getGroup()
    {
        return group;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    /**
     * Get type
     * 
     * @return type
     **/
    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RestIdentityLink restIdentityLink = (RestIdentityLink) o;
        return Objects.equals(this.url, restIdentityLink.url) && Objects.equals(this.user, restIdentityLink.user)
                && Objects.equals(this.group, restIdentityLink.group)
                && Objects.equals(this.type, restIdentityLink.type);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(url, user, group, type);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestIdentityLink {\n");

        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    group: ").append(toIndentedString(group)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
