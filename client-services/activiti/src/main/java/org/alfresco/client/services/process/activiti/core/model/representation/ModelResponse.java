package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Date;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * ModelResponse
 */
public class ModelResponse
{
    @SerializedName("name")
    private String name = null;

    @SerializedName("key")
    private String key = null;

    @SerializedName("category")
    private String category = null;

    @SerializedName("version")
    private Integer version = null;

    @SerializedName("metaInfo")
    private String metaInfo = null;

    @SerializedName("deploymentId")
    private String deploymentId = null;

    @SerializedName("tenantId")
    private String tenantId = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("createTime")
    private Date createTime = null;

    @SerializedName("lastUpdateTime")
    private Date lastUpdateTime = null;

    @SerializedName("deploymentUrl")
    private String deploymentUrl = null;

    @SerializedName("sourceUrl")
    private String sourceUrl = null;

    @SerializedName("sourceExtraUrl")
    private String sourceExtraUrl = null;

    public ModelResponse name(String name)
    {
        this.name = name;
        return this;
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
     * Get category
     * 
     * @return category
     **/
    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    /**
     * Get version
     * 
     * @return version
     **/
    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    /**
     * Get metaInfo
     * 
     * @return metaInfo
     **/
    public String getMetaInfo()
    {
        return metaInfo;
    }

    public void setMetaInfo(String metaInfo)
    {
        this.metaInfo = metaInfo;
    }

    /**
     * Get deploymentId
     * 
     * @return deploymentId
     **/
    public String getDeploymentId()
    {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId)
    {
        this.deploymentId = deploymentId;
    }

    /**
     * Get tenantId
     * 
     * @return tenantId
     **/
    public String getTenantId()
    {
        return tenantId;
    }

    public void setTenantId(String tenantId)
    {
        this.tenantId = tenantId;
    }

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
     * Get createTime
     * 
     * @return createTime
     **/
    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    /**
     * Get lastUpdateTime
     * 
     * @return lastUpdateTime
     **/
    public Date getLastUpdateTime()
    {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime)
    {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * Get deploymentUrl
     * 
     * @return deploymentUrl
     **/
    public String getDeploymentUrl()
    {
        return deploymentUrl;
    }

    public void setDeploymentUrl(String deploymentUrl)
    {
        this.deploymentUrl = deploymentUrl;
    }

    /**
     * Get sourceUrl
     * 
     * @return sourceUrl
     **/
    public String getSourceUrl()
    {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl)
    {
        this.sourceUrl = sourceUrl;
    }

    /**
     * Get sourceExtraUrl
     * 
     * @return sourceExtraUrl
     **/
    public String getSourceExtraUrl()
    {
        return sourceExtraUrl;
    }

    public void setSourceExtraUrl(String sourceExtraUrl)
    {
        this.sourceExtraUrl = sourceExtraUrl;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ModelResponse modelResponse = (ModelResponse) o;
        return Objects.equals(this.name, modelResponse.name) && Objects.equals(this.key, modelResponse.key)
                && Objects.equals(this.category, modelResponse.category)
                && Objects.equals(this.version, modelResponse.version)
                && Objects.equals(this.metaInfo, modelResponse.metaInfo)
                && Objects.equals(this.deploymentId, modelResponse.deploymentId)
                && Objects.equals(this.tenantId, modelResponse.tenantId) && Objects.equals(this.id, modelResponse.id)
                && Objects.equals(this.url, modelResponse.url)
                && Objects.equals(this.createTime, modelResponse.createTime)
                && Objects.equals(this.lastUpdateTime, modelResponse.lastUpdateTime)
                && Objects.equals(this.deploymentUrl, modelResponse.deploymentUrl)
                && Objects.equals(this.sourceUrl, modelResponse.sourceUrl)
                && Objects.equals(this.sourceExtraUrl, modelResponse.sourceExtraUrl);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, key, category, version, metaInfo, deploymentId, tenantId, id, url, createTime,
                lastUpdateTime, deploymentUrl, sourceUrl, sourceExtraUrl);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModelResponse {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    metaInfo: ").append(toIndentedString(metaInfo)).append("\n");
        sb.append("    deploymentId: ").append(toIndentedString(deploymentId)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("    lastUpdateTime: ").append(toIndentedString(lastUpdateTime)).append("\n");
        sb.append("    deploymentUrl: ").append(toIndentedString(deploymentUrl)).append("\n");
        sb.append("    sourceUrl: ").append(toIndentedString(sourceUrl)).append("\n");
        sb.append("    sourceExtraUrl: ").append(toIndentedString(sourceExtraUrl)).append("\n");
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
