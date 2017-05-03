package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Date;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * DeploymentResponse
 */
public class DeploymentResponse
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("deploymentTime")
    private Date deploymentTime = null;

    @SerializedName("category")
    private String category = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("tenantId")
    private String tenantId = null;

    public DeploymentResponse id(String id)
    {
        this.id = id;
        return this;
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
     * Get deploymentTime
     * 
     * @return deploymentTime
     **/
    public Date getDeploymentTime()
    {
        return deploymentTime;
    }

    public void setDeploymentTime(Date deploymentTime)
    {
        this.deploymentTime = deploymentTime;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DeploymentResponse deploymentResponse = (DeploymentResponse) o;
        return Objects.equals(this.id, deploymentResponse.id) && Objects.equals(this.name, deploymentResponse.name)
                && Objects.equals(this.deploymentTime, deploymentResponse.deploymentTime)
                && Objects.equals(this.category, deploymentResponse.category)
                && Objects.equals(this.url, deploymentResponse.url)
                && Objects.equals(this.tenantId, deploymentResponse.tenantId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, deploymentTime, category, url, tenantId);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    deploymentTime: ").append(toIndentedString(deploymentTime)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
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
