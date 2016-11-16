package com.alfresco.client.api.core.model.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * GroupMember
 */
public class GroupMemberRepresentation
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("displayName")
    private String displayName = null;

    /**
     * Gets or Sets memberType
     */
    public enum MemberTypeEnum
    {
        @SerializedName("PERSON") PERSON("PERSON"),

        @SerializedName("GROUP") GROUP("GROUP");

        private String value;

        MemberTypeEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    @SerializedName("memberType")
    private MemberTypeEnum memberType = null;

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
     * Get displayName
     * 
     * @return displayName
     **/
    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    /**
     * Get memberType
     * 
     * @return memberType
     **/
    public MemberTypeEnum getMemberType()
    {
        return memberType;
    }

    public void setMemberType(MemberTypeEnum memberType)
    {
        this.memberType = memberType;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GroupMemberRepresentation groupMember = (GroupMemberRepresentation) o;
        return Objects.equals(this.id, groupMember.id) && Objects.equals(this.displayName, groupMember.displayName)
                && Objects.equals(this.memberType, groupMember.memberType);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, displayName, memberType);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class GroupMember {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    memberType: ").append(toIndentedString(memberType)).append("\n");
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
