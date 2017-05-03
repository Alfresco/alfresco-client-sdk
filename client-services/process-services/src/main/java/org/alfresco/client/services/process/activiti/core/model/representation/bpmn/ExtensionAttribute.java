package org.alfresco.client.services.process.activiti.core.model.representation.bpmn;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * ExtensionAttribute
 */
public class ExtensionAttribute
{
    @SerializedName("name")
    private String name = null;

    @SerializedName("value")
    private String value = null;

    @SerializedName("namespacePrefix")
    private String namespacePrefix = null;

    @SerializedName("namespace")
    private String namespace = null;

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
     * Get namespacePrefix
     * 
     * @return namespacePrefix
     **/
    public String getNamespacePrefix()
    {
        return namespacePrefix;
    }

    public void setNamespacePrefix(String namespacePrefix)
    {
        this.namespacePrefix = namespacePrefix;
    }

    /**
     * Get namespace
     * 
     * @return namespace
     **/
    public String getNamespace()
    {
        return namespace;
    }

    public void setNamespace(String namespace)
    {
        this.namespace = namespace;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ExtensionAttribute extensionAttribute = (ExtensionAttribute) o;
        return Objects.equals(this.name, extensionAttribute.name)
                && Objects.equals(this.value, extensionAttribute.value)
                && Objects.equals(this.namespacePrefix, extensionAttribute.namespacePrefix)
                && Objects.equals(this.namespace, extensionAttribute.namespace);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, value, namespacePrefix, namespace);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExtensionAttribute {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    namespacePrefix: ").append(toIndentedString(namespacePrefix)).append("\n");
        sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
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
