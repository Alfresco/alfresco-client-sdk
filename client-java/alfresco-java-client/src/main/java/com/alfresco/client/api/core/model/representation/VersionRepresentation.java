package com.alfresco.client.api.core.model.representation;

import java.util.*;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 30/09/2016.
 */
public class VersionRepresentation
{

    @SerializedName("id")
    private String id = null;

    @SerializedName("versionComment")
    private String versionComment = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("nodeType")
    private String nodeType = null;

    @SerializedName("isFolder")
    private Boolean isFolder = null;

    @SerializedName("isFile")
    private Boolean isFile = null;

    @SerializedName("modifiedAt")
    private Date modifiedAt = null;

    @SerializedName("modifiedByUser")
    private UserInfoRepresentation modifiedByUser = null;

    @SerializedName("content")
    private ContentInfoRepresentation content = null;

    @SerializedName("aspectNames")
    private List<String> aspectNames = new ArrayList<>();

    @SerializedName("properties")
    private Map<String, String> properties = new HashMap<String, String>();

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

    /**
     * The name must not contain spaces or the following special characters: *
     * \" < > \\ / ? : and |. The character . must not be used at the end of the
     * name.
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
     * Get nodeType
     * 
     * @return nodeType
     **/
    public String getNodeType()
    {
        return nodeType;
    }

    public void setNodeType(String nodeType)
    {
        this.nodeType = nodeType;
    }

    /**
     * Get isFolder
     * 
     * @return isFolder
     **/
    public Boolean getIsFolder()
    {
        return isFolder;
    }

    public void setIsFolder(Boolean isFolder)
    {
        this.isFolder = isFolder;
    }

    /**
     * Get isFile
     * 
     * @return isFile
     **/
    public Boolean getIsFile()
    {
        return isFile;
    }

    public void setIsFile(Boolean isFile)
    {
        this.isFile = isFile;
    }

    /**
     * Get modifiedAt
     * 
     * @return modifiedAt
     **/
    public Date getModifiedAt()
    {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt)
    {
        this.modifiedAt = modifiedAt;
    }

    /**
     * Get modifiedByUser
     * 
     * @return modifiedByUser
     **/
    public UserInfoRepresentation getModifiedByUser()
    {
        return modifiedByUser;
    }

    public void setModifiedByUser(UserInfoRepresentation modifiedByUser)
    {
        this.modifiedByUser = modifiedByUser;
    }

    /**
     * Get content
     * 
     * @return content
     **/
    public ContentInfoRepresentation getContent()
    {
        return content;
    }

    public void setContent(ContentInfoRepresentation content)
    {
        this.content = content;
    }

    /**
     * Get aspectNames
     * 
     * @return aspectNames
     **/
    public List<String> getAspectNames()
    {
        return aspectNames;
    }

    public void setAspectNames(List<String> aspectNames)
    {
        this.aspectNames = aspectNames;
    }

    /**
     * Get properties
     * 
     * @return properties
     **/
    public Map<String, String> getProperties()
    {
        return properties;
    }

    public void setProperties(Map<String, String> properties)
    {
        this.properties = properties;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        VersionRepresentation version = (VersionRepresentation) o;
        return Objects.equals(this.id, version.id) && Objects.equals(this.versionComment, version.versionComment)
                && Objects.equals(this.name, version.name) && Objects.equals(this.nodeType, version.nodeType)
                && Objects.equals(this.isFolder, version.isFolder) && Objects.equals(this.isFile, version.isFile)
                && Objects.equals(this.modifiedAt, version.modifiedAt)
                && Objects.equals(this.modifiedByUser, version.modifiedByUser)
                && Objects.equals(this.content, version.content)
                && Objects.equals(this.aspectNames, version.aspectNames)
                && Objects.equals(this.properties, version.properties);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, versionComment, name, nodeType, isFolder, isFile, modifiedAt, modifiedByUser, content,
                aspectNames, properties);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Version {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    versionComment: ").append(toIndentedString(versionComment)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
        sb.append("    isFolder: ").append(toIndentedString(isFolder)).append("\n");
        sb.append("    isFile: ").append(toIndentedString(isFile)).append("\n");
        sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
        sb.append("    modifiedByUser: ").append(toIndentedString(modifiedByUser)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    aspectNames: ").append(toIndentedString(aspectNames)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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
