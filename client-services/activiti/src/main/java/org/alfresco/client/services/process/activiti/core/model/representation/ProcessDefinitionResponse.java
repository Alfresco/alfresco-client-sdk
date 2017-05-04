package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * ProcessDefinitionResponse
 */
public class ProcessDefinitionResponse
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("key")
    private String key = null;

    @SerializedName("version")
    private Integer version = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("tenantId")
    private String tenantId = null;

    @SerializedName("deploymentId")
    private String deploymentId = null;

    @SerializedName("deploymentUrl")
    private String deploymentUrl = null;

    @SerializedName("resource")
    private String resource = null;

    @SerializedName("diagramResource")
    private String diagramResource = null;

    @SerializedName("category")
    private String category = null;

    @SerializedName("graphicalNotationDefined")
    private Boolean graphicalNotationDefined = false;

    @SerializedName("suspended")
    private Boolean suspended = false;

    @SerializedName("startFormDefined")
    private Boolean startFormDefined = false;

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
     * Get description
     * 
     * @return description
     **/
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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
     * Get resource
     * 
     * @return resource
     **/
    public String getResource()
    {
        return resource;
    }

    public void setResource(String resource)
    {
        this.resource = resource;
    }

    /**
     * Get diagramResource
     * 
     * @return diagramResource
     **/
    public String getDiagramResource()
    {
        return diagramResource;
    }

    public void setDiagramResource(String diagramResource)
    {
        this.diagramResource = diagramResource;
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
     * Get graphicalNotationDefined
     * 
     * @return graphicalNotationDefined
     **/
    public Boolean getGraphicalNotationDefined()
    {
        return graphicalNotationDefined;
    }

    public void setGraphicalNotationDefined(Boolean graphicalNotationDefined)
    {
        this.graphicalNotationDefined = graphicalNotationDefined;
    }

    /**
     * Get suspended
     * 
     * @return suspended
     **/
    public Boolean getSuspended()
    {
        return suspended;
    }

    public void setSuspended(Boolean suspended)
    {
        this.suspended = suspended;
    }

    /**
     * Get startFormDefined
     * 
     * @return startFormDefined
     **/
    public Boolean getStartFormDefined()
    {
        return startFormDefined;
    }

    public void setStartFormDefined(Boolean startFormDefined)
    {
        this.startFormDefined = startFormDefined;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ProcessDefinitionResponse processDefinitionResponse = (ProcessDefinitionResponse) o;
        return Objects.equals(this.id, processDefinitionResponse.id)
                && Objects.equals(this.url, processDefinitionResponse.url)
                && Objects.equals(this.key, processDefinitionResponse.key)
                && Objects.equals(this.version, processDefinitionResponse.version)
                && Objects.equals(this.name, processDefinitionResponse.name)
                && Objects.equals(this.description, processDefinitionResponse.description)
                && Objects.equals(this.tenantId, processDefinitionResponse.tenantId)
                && Objects.equals(this.deploymentId, processDefinitionResponse.deploymentId)
                && Objects.equals(this.deploymentUrl, processDefinitionResponse.deploymentUrl)
                && Objects.equals(this.resource, processDefinitionResponse.resource)
                && Objects.equals(this.diagramResource, processDefinitionResponse.diagramResource)
                && Objects.equals(this.category, processDefinitionResponse.category)
                && Objects.equals(this.graphicalNotationDefined, processDefinitionResponse.graphicalNotationDefined)
                && Objects.equals(this.suspended, processDefinitionResponse.suspended)
                && Objects.equals(this.startFormDefined, processDefinitionResponse.startFormDefined);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, url, key, version, name, description, tenantId, deploymentId, deploymentUrl, resource,
                diagramResource, category, graphicalNotationDefined, suspended, startFormDefined);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessDefinitionResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("    deploymentId: ").append(toIndentedString(deploymentId)).append("\n");
        sb.append("    deploymentUrl: ").append(toIndentedString(deploymentUrl)).append("\n");
        sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
        sb.append("    diagramResource: ").append(toIndentedString(diagramResource)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    graphicalNotationDefined: ").append(toIndentedString(graphicalNotationDefined)).append("\n");
        sb.append("    suspended: ").append(toIndentedString(suspended)).append("\n");
        sb.append("    startFormDefined: ").append(toIndentedString(startFormDefined)).append("\n");
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
