package com.alfresco.client.api.search.model;

import java.util.Date;
import java.util.Objects;

import com.alfresco.client.api.core.model.representation.NodeRepresentation;
import com.alfresco.client.api.core.model.representation.UserInfoRepresentation;
import com.google.gson.annotations.SerializedName;

/**
 * ResultNodeRepresentation
 */
public class ResultNodeRepresentation extends NodeRepresentation
{
    @SerializedName("search")
    private SearchEntry search = null;

    @SerializedName("archivedByUser")
    private UserInfoRepresentation archivedByUser = null;

    @SerializedName("archivedAt")
    private Date archivedAt = null;

    @SerializedName("versionLabel")
    private String versionLabel = null;

    @SerializedName("versionComment")
    private String versionComment = null;

    public ResultNodeRepresentation search(SearchEntry search)
    {
        this.search = search;
        return this;
    }

    /**
     * Get search
     * 
     * @return search
     **/
    public SearchEntry getSearch()
    {
        return search;
    }

    public void setSearch(SearchEntry search)
    {
        this.search = search;
    }

    public ResultNodeRepresentation archivedByUser(UserInfoRepresentation archivedByUser)
    {
        this.archivedByUser = archivedByUser;
        return this;
    }

    /**
     * Get archivedByUser
     * 
     * @return archivedByUser
     **/
    public UserInfoRepresentation getArchivedByUser()
    {
        return archivedByUser;
    }

    public void setArchivedByUser(UserInfoRepresentation archivedByUser)
    {
        this.archivedByUser = archivedByUser;
    }

    public ResultNodeRepresentation archivedAt(Date archivedAt)
    {
        this.archivedAt = archivedAt;
        return this;
    }

    /**
     * Get archivedAt
     * 
     * @return archivedAt
     **/
    public Date getArchivedAt()
    {
        return archivedAt;
    }

    public void setArchivedAt(Date archivedAt)
    {
        this.archivedAt = archivedAt;
    }

    public ResultNodeRepresentation versionLabel(String versionLabel)
    {
        this.versionLabel = versionLabel;
        return this;
    }

    /**
     * Get versionLabel
     * 
     * @return versionLabel
     **/
    public String getVersionLabel()
    {
        return versionLabel;
    }

    public void setVersionLabel(String versionLabel)
    {
        this.versionLabel = versionLabel;
    }

    public ResultNodeRepresentation versionComment(String versionComment)
    {
        this.versionComment = versionComment;
        return this;
    }

    /**
     * Get versionComment
     * 
     * @return versionComment
     **/
    public String getVersionComment()
    {
        return versionComment;
    }

    public void setVersionComment(String versionComment)
    {
        this.versionComment = versionComment;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResultNodeRepresentation ResultNodeRepresentation = (ResultNodeRepresentation) o;
        return Objects.equals(this.search, ResultNodeRepresentation.search)
                && Objects.equals(this.archivedByUser, ResultNodeRepresentation.archivedByUser)
                && Objects.equals(this.archivedAt, ResultNodeRepresentation.archivedAt)
                && Objects.equals(this.versionLabel, ResultNodeRepresentation.versionLabel)
                && Objects.equals(this.versionComment, ResultNodeRepresentation.versionComment);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(search, archivedByUser, archivedAt, versionLabel, versionComment);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResultNodeRepresentation {\n");

        sb.append("    search: ").append(toIndentedString(search)).append("\n");
        sb.append("    archivedByUser: ").append(toIndentedString(archivedByUser)).append("\n");
        sb.append("    archivedAt: ").append(toIndentedString(archivedAt)).append("\n");
        sb.append("    versionLabel: ").append(toIndentedString(versionLabel)).append("\n");
        sb.append("    versionComment: ").append(toIndentedString(versionComment)).append("\n");
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
