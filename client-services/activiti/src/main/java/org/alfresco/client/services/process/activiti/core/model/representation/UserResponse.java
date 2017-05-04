package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * UserResponse
 */
public class UserResponse
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("firstName")
    private String firstName = null;

    @SerializedName("lastName")
    private String lastName = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("email")
    private String email = null;

    @SerializedName("pictureUrl")
    private String pictureUrl = null;

    @SerializedName("password")
    private String password = null;

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
     * Get firstName
     * 
     * @return firstName
     **/
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public UserResponse lastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     * 
     * @return lastName
     **/
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
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
     * Get email
     * 
     * @return email
     **/
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Get pictureUrl
     * 
     * @return pictureUrl
     **/
    public String getPictureUrl()
    {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl)
    {
        this.pictureUrl = pictureUrl;
    }

    /**
     * Get password
     * 
     * @return password
     **/
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UserResponse userResponse = (UserResponse) o;
        return Objects.equals(this.id, userResponse.id) && Objects.equals(this.firstName, userResponse.firstName)
                && Objects.equals(this.lastName, userResponse.lastName) && Objects.equals(this.url, userResponse.url)
                && Objects.equals(this.email, userResponse.email)
                && Objects.equals(this.pictureUrl, userResponse.pictureUrl)
                && Objects.equals(this.password, userResponse.password);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, firstName, lastName, url, email, pictureUrl, password);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    pictureUrl: ").append(toIndentedString(pictureUrl)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
