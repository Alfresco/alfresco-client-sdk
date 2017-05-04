package org.alfresco.client.services.process.activiti.core.model.representation.bpmn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * ExtensionElement
 */
public class ExtensionElement
{
    @SerializedName("id")
    private String id = null;

    @SerializedName("xmlRowNumber")
    private Integer xmlRowNumber = null;

    @SerializedName("xmlColumnNumber")
    private Integer xmlColumnNumber = null;

    @SerializedName("extensionElements")
    private Map<String, List<ExtensionElement>> extensionElements = new HashMap<String, List<ExtensionElement>>();

    @SerializedName("attributes")
    private Map<String, List<ExtensionAttribute>> attributes = new HashMap<String, List<ExtensionAttribute>>();

    @SerializedName("name")
    private String name = null;

    @SerializedName("namespacePrefix")
    private String namespacePrefix = null;

    @SerializedName("namespace")
    private String namespace = null;

    @SerializedName("elementText")
    private String elementText = null;

    @SerializedName("childElements")
    private Map<String, List<ExtensionElement>> childElements = new HashMap<String, List<ExtensionElement>>();

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
     * Get xmlRowNumber
     * 
     * @return xmlRowNumber
     **/
    public Integer getXmlRowNumber()
    {
        return xmlRowNumber;
    }

    public void setXmlRowNumber(Integer xmlRowNumber)
    {
        this.xmlRowNumber = xmlRowNumber;
    }

    /**
     * Get xmlColumnNumber
     * 
     * @return xmlColumnNumber
     **/
    public Integer getXmlColumnNumber()
    {
        return xmlColumnNumber;
    }

    public void setXmlColumnNumber(Integer xmlColumnNumber)
    {
        this.xmlColumnNumber = xmlColumnNumber;
    }

    /**
     * Get extensionElements
     * 
     * @return extensionElements
     **/
    public Map<String, List<ExtensionElement>> getExtensionElements()
    {
        return extensionElements;
    }

    public void setExtensionElements(Map<String, List<ExtensionElement>> extensionElements)
    {
        this.extensionElements = extensionElements;
    }

    /**
     * Get attributes
     * 
     * @return attributes
     **/
    public Map<String, List<ExtensionAttribute>> getAttributes()
    {
        return attributes;
    }

    public void setAttributes(Map<String, List<ExtensionAttribute>> attributes)
    {
        this.attributes = attributes;
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

    /**
     * Get elementText
     * 
     * @return elementText
     **/
    public String getElementText()
    {
        return elementText;
    }

    public void setElementText(String elementText)
    {
        this.elementText = elementText;
    }

    /**
     * Get childElements
     * 
     * @return childElements
     **/
    public Map<String, List<ExtensionElement>> getChildElements()
    {
        return childElements;
    }

    public void setChildElements(Map<String, List<ExtensionElement>> childElements)
    {
        this.childElements = childElements;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ExtensionElement extensionElement = (ExtensionElement) o;
        return Objects.equals(this.id, extensionElement.id)
                && Objects.equals(this.xmlRowNumber, extensionElement.xmlRowNumber)
                && Objects.equals(this.xmlColumnNumber, extensionElement.xmlColumnNumber)
                && Objects.equals(this.extensionElements, extensionElement.extensionElements)
                && Objects.equals(this.attributes, extensionElement.attributes)
                && Objects.equals(this.name, extensionElement.name)
                && Objects.equals(this.namespacePrefix, extensionElement.namespacePrefix)
                && Objects.equals(this.namespace, extensionElement.namespace)
                && Objects.equals(this.elementText, extensionElement.elementText)
                && Objects.equals(this.childElements, extensionElement.childElements);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, xmlRowNumber, xmlColumnNumber, extensionElements, attributes, name, namespacePrefix,
                namespace, elementText, childElements);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExtensionElement {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    xmlRowNumber: ").append(toIndentedString(xmlRowNumber)).append("\n");
        sb.append("    xmlColumnNumber: ").append(toIndentedString(xmlColumnNumber)).append("\n");
        sb.append("    extensionElements: ").append(toIndentedString(extensionElements)).append("\n");
        sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    namespacePrefix: ").append(toIndentedString(namespacePrefix)).append("\n");
        sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
        sb.append("    elementText: ").append(toIndentedString(elementText)).append("\n");
        sb.append("    childElements: ").append(toIndentedString(childElements)).append("\n");
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
