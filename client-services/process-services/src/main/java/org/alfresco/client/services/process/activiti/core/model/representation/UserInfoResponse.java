package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * UserInfoResponse
 */
public class UserInfoResponse
{
    @SerializedName("key")
    private String key = null;

    @SerializedName("value")
    private String value = null;

    @SerializedName("url")
    private String url = null;

    /**
     * Get key
     * 
     * @return key
     **/
    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    /**
     * Get value
     * 
     * @return value
     **/
    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UserInfoResponse userInfoResponse = (UserInfoResponse) o;
        return Objects.equals(this.key, userInfoResponse.key) && Objects.equals(this.value, userInfoResponse.value)
                && Objects.equals(this.url, userInfoResponse.url);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(key, value, url);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserInfoResponse {\n");

        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
