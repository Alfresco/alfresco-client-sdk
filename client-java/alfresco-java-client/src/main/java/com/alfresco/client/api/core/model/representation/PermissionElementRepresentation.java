package com.alfresco.client.api.core.model.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * PermissionElement
 */
public class PermissionElementRepresentation
{
    @SerializedName("authorityId")
    private String authorityId = null;

    @SerializedName("name")
    private String name = null;

    /**
     * Gets or Sets accessStatus
     */
    public enum AccessStatusEnum
    {
        @SerializedName("ALLOWED") ALLOWED("ALLOWED"),

        @SerializedName("DENIED") DENIED("DENIED");

        private String value;

        AccessStatusEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    @SerializedName("accessStatus")
    private AccessStatusEnum accessStatus = AccessStatusEnum.ALLOWED;

    /**
     * Get authorityId
     * 
     * @return authorityId
     **/
    public String getAuthorityId()
    {
        return authorityId;
    }

    public void setAuthorityId(String authorityId)
    {
        this.authorityId = authorityId;
    }

    /**
     * Get name
     * 
     * @return name
     **/
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get accessStatus
     * 
     * @return accessStatus
     **/
    public AccessStatusEnum getAccessStatus()
    {
        return accessStatus;
    }

    public void setAccessStatus(AccessStatusEnum accessStatus)
    {
        this.accessStatus = accessStatus;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PermissionElementRepresentation permissionElement = (PermissionElementRepresentation) o;
        return Objects.equals(this.authorityId, permissionElement.authorityId)
                && Objects.equals(this.name, permissionElement.name)
                && Objects.equals(this.accessStatus, permissionElement.accessStatus);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(authorityId, name, accessStatus);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class PermissionElement {\n");

        sb.append("    authorityId: ").append(toIndentedString(authorityId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    accessStatus: ").append(toIndentedString(accessStatus)).append("\n");
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
