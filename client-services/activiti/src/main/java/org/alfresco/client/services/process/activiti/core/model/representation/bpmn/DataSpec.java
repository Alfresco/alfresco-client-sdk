package org.alfresco.client.services.process.activiti.core.model.representation.bpmn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * DataSpec
 */
public class DataSpec
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

    @SerializedName("itemSubjectRef")
    private String itemSubjectRef = null;

    @SerializedName("collection")
    private Boolean collection = false;

    public DataSpec id(String id)
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
     * Get itemSubjectRef
     * 
     * @return itemSubjectRef
     **/
    public String getItemSubjectRef()
    {
        return itemSubjectRef;
    }

    public void setItemSubjectRef(String itemSubjectRef)
    {
        this.itemSubjectRef = itemSubjectRef;
    }

    /**
     * Get collection
     * 
     * @return collection
     **/
    public Boolean getCollection()
    {
        return collection;
    }

    public void setCollection(Boolean collection)
    {
        this.collection = collection;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DataSpec dataSpec = (DataSpec) o;
        return Objects.equals(this.id, dataSpec.id) && Objects.equals(this.xmlRowNumber, dataSpec.xmlRowNumber)
                && Objects.equals(this.xmlColumnNumber, dataSpec.xmlColumnNumber)
                && Objects.equals(this.extensionElements, dataSpec.extensionElements)
                && Objects.equals(this.attributes, dataSpec.attributes) && Objects.equals(this.name, dataSpec.name)
                && Objects.equals(this.itemSubjectRef, dataSpec.itemSubjectRef)
                && Objects.equals(this.collection, dataSpec.collection);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, xmlRowNumber, xmlColumnNumber, extensionElements, attributes, name, itemSubjectRef,
                collection);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataSpec {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    xmlRowNumber: ").append(toIndentedString(xmlRowNumber)).append("\n");
        sb.append("    xmlColumnNumber: ").append(toIndentedString(xmlColumnNumber)).append("\n");
        sb.append("    extensionElements: ").append(toIndentedString(extensionElements)).append("\n");
        sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    itemSubjectRef: ").append(toIndentedString(itemSubjectRef)).append("\n");
        sb.append("    collection: ").append(toIndentedString(collection)).append("\n");
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
