package org.alfresco.client.services.process.activiti.core.model.representation.bpmn;

import java.util.*;

import com.google.gson.annotations.SerializedName;

/**
 * IOSpecification
 */
public class IOSpecification
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

    @SerializedName("dataInputs")
    private List<DataSpec> dataInputs = new ArrayList<DataSpec>();

    @SerializedName("dataOutputs")
    private List<DataSpec> dataOutputs = new ArrayList<DataSpec>();

    @SerializedName("dataInputRefs")
    private List<String> dataInputRefs = new ArrayList<String>();

    @SerializedName("dataOutputRefs")
    private List<String> dataOutputRefs = new ArrayList<String>();

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
     * Get dataInputs
     * 
     * @return dataInputs
     **/
    public List<DataSpec> getDataInputs()
    {
        return dataInputs;
    }

    public void setDataInputs(List<DataSpec> dataInputs)
    {
        this.dataInputs = dataInputs;
    }

    /**
     * Get dataOutputs
     * 
     * @return dataOutputs
     **/
    public List<DataSpec> getDataOutputs()
    {
        return dataOutputs;
    }

    public void setDataOutputs(List<DataSpec> dataOutputs)
    {
        this.dataOutputs = dataOutputs;
    }

    /**
     * Get dataInputRefs
     * 
     * @return dataInputRefs
     **/
    public List<String> getDataInputRefs()
    {
        return dataInputRefs;
    }

    public void setDataInputRefs(List<String> dataInputRefs)
    {
        this.dataInputRefs = dataInputRefs;
    }

    /**
     * Get dataOutputRefs
     * 
     * @return dataOutputRefs
     **/
    public List<String> getDataOutputRefs()
    {
        return dataOutputRefs;
    }

    public void setDataOutputRefs(List<String> dataOutputRefs)
    {
        this.dataOutputRefs = dataOutputRefs;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        IOSpecification iOSpecification = (IOSpecification) o;
        return Objects.equals(this.id, iOSpecification.id)
                && Objects.equals(this.xmlRowNumber, iOSpecification.xmlRowNumber)
                && Objects.equals(this.xmlColumnNumber, iOSpecification.xmlColumnNumber)
                && Objects.equals(this.extensionElements, iOSpecification.extensionElements)
                && Objects.equals(this.attributes, iOSpecification.attributes)
                && Objects.equals(this.dataInputs, iOSpecification.dataInputs)
                && Objects.equals(this.dataOutputs, iOSpecification.dataOutputs)
                && Objects.equals(this.dataInputRefs, iOSpecification.dataInputRefs)
                && Objects.equals(this.dataOutputRefs, iOSpecification.dataOutputRefs);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, xmlRowNumber, xmlColumnNumber, extensionElements, attributes, dataInputs, dataOutputs,
                dataInputRefs, dataOutputRefs);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class IOSpecification {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    xmlRowNumber: ").append(toIndentedString(xmlRowNumber)).append("\n");
        sb.append("    xmlColumnNumber: ").append(toIndentedString(xmlColumnNumber)).append("\n");
        sb.append("    extensionElements: ").append(toIndentedString(extensionElements)).append("\n");
        sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
        sb.append("    dataInputs: ").append(toIndentedString(dataInputs)).append("\n");
        sb.append("    dataOutputs: ").append(toIndentedString(dataOutputs)).append("\n");
        sb.append("    dataInputRefs: ").append(toIndentedString(dataInputRefs)).append("\n");
        sb.append("    dataOutputRefs: ").append(toIndentedString(dataOutputRefs)).append("\n");
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
