package org.alfresco.client.services.process.activiti.core.model.representation.bpmn;

import java.util.*;

import com.google.gson.annotations.SerializedName;

/**
 * Operation
 */
public class Operation
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

    @SerializedName("implementationRef")
    private String implementationRef = null;

    @SerializedName("inMessageRef")
    private String inMessageRef = null;

    @SerializedName("outMessageRef")
    private String outMessageRef = null;

    @SerializedName("errorMessageRef")
    private List<String> errorMessageRef = new ArrayList<String>();

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
     * Get implementationRef
     * 
     * @return implementationRef
     **/
    public String getImplementationRef()
    {
        return implementationRef;
    }

    public void setImplementationRef(String implementationRef)
    {
        this.implementationRef = implementationRef;
    }

    /**
     * Get inMessageRef
     * 
     * @return inMessageRef
     **/
    public String getInMessageRef()
    {
        return inMessageRef;
    }

    public void setInMessageRef(String inMessageRef)
    {
        this.inMessageRef = inMessageRef;
    }

    /**
     * Get outMessageRef
     * 
     * @return outMessageRef
     **/
    public String getOutMessageRef()
    {
        return outMessageRef;
    }

    public void setOutMessageRef(String outMessageRef)
    {
        this.outMessageRef = outMessageRef;
    }

    /**
     * Get errorMessageRef
     * 
     * @return errorMessageRef
     **/
    public List<String> getErrorMessageRef()
    {
        return errorMessageRef;
    }

    public void setErrorMessageRef(List<String> errorMessageRef)
    {
        this.errorMessageRef = errorMessageRef;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Operation operation = (Operation) o;
        return Objects.equals(this.id, operation.id) && Objects.equals(this.xmlRowNumber, operation.xmlRowNumber)
                && Objects.equals(this.xmlColumnNumber, operation.xmlColumnNumber)
                && Objects.equals(this.extensionElements, operation.extensionElements)
                && Objects.equals(this.attributes, operation.attributes) && Objects.equals(this.name, operation.name)
                && Objects.equals(this.implementationRef, operation.implementationRef)
                && Objects.equals(this.inMessageRef, operation.inMessageRef)
                && Objects.equals(this.outMessageRef, operation.outMessageRef)
                && Objects.equals(this.errorMessageRef, operation.errorMessageRef);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, xmlRowNumber, xmlColumnNumber, extensionElements, attributes, name, implementationRef,
                inMessageRef, outMessageRef, errorMessageRef);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Operation {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    xmlRowNumber: ").append(toIndentedString(xmlRowNumber)).append("\n");
        sb.append("    xmlColumnNumber: ").append(toIndentedString(xmlColumnNumber)).append("\n");
        sb.append("    extensionElements: ").append(toIndentedString(extensionElements)).append("\n");
        sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    implementationRef: ").append(toIndentedString(implementationRef)).append("\n");
        sb.append("    inMessageRef: ").append(toIndentedString(inMessageRef)).append("\n");
        sb.append("    outMessageRef: ").append(toIndentedString(outMessageRef)).append("\n");
        sb.append("    errorMessageRef: ").append(toIndentedString(errorMessageRef)).append("\n");
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
