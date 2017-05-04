package org.alfresco.client.services.process.activiti.core.model.representation.bpmn;

import java.util.*;

import com.google.gson.annotations.SerializedName;

/**
 * FlowElement
 */
public class FlowElement
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

    @SerializedName("documentation")
    private String documentation = null;

    @SerializedName("executionListeners")
    private List<ActivitiListener> executionListeners = new ArrayList<ActivitiListener>();

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
     * Get documentation
     * 
     * @return documentation
     **/
    public String getDocumentation()
    {
        return documentation;
    }

    public void setDocumentation(String documentation)
    {
        this.documentation = documentation;
    }

    /**
     * Get executionListeners
     * 
     * @return executionListeners
     **/
    public List<ActivitiListener> getExecutionListeners()
    {
        return executionListeners;
    }

    public void setExecutionListeners(List<ActivitiListener> executionListeners)
    {
        this.executionListeners = executionListeners;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        FlowElement flowElement = (FlowElement) o;
        return Objects.equals(this.id, flowElement.id) && Objects.equals(this.xmlRowNumber, flowElement.xmlRowNumber)
                && Objects.equals(this.xmlColumnNumber, flowElement.xmlColumnNumber)
                && Objects.equals(this.extensionElements, flowElement.extensionElements)
                && Objects.equals(this.attributes, flowElement.attributes)
                && Objects.equals(this.name, flowElement.name)
                && Objects.equals(this.documentation, flowElement.documentation)
                && Objects.equals(this.executionListeners, flowElement.executionListeners);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, xmlRowNumber, xmlColumnNumber, extensionElements, attributes, name, documentation,
                executionListeners);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class FlowElement {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    xmlRowNumber: ").append(toIndentedString(xmlRowNumber)).append("\n");
        sb.append("    xmlColumnNumber: ").append(toIndentedString(xmlColumnNumber)).append("\n");
        sb.append("    extensionElements: ").append(toIndentedString(extensionElements)).append("\n");
        sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    documentation: ").append(toIndentedString(documentation)).append("\n");
        sb.append("    executionListeners: ").append(toIndentedString(executionListeners)).append("\n");
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
