package org.alfresco.client.services.process.activiti.core.model.representation.bpmn;

import java.util.*;

import com.google.gson.annotations.SerializedName;

/**
 * ActivitiListener
 */
public class ActivitiListener
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

    @SerializedName("event")
    private String event = null;

    @SerializedName("implementationType")
    private String implementationType = null;

    @SerializedName("implementation")
    private String implementation = null;

    @SerializedName("fieldExtensions")
    private List<FieldExtension> fieldExtensions = new ArrayList<FieldExtension>();

    @SerializedName("onTransaction")
    private String onTransaction = null;

    @SerializedName("customPropertiesResolverImplementationType")
    private String customPropertiesResolverImplementationType = null;

    @SerializedName("customPropertiesResolverImplementation")
    private String customPropertiesResolverImplementation = null;

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
     * Get event
     * 
     * @return event
     **/
    public String getEvent()
    {
        return event;
    }

    public void setEvent(String event)
    {
        this.event = event;
    }

    /**
     * Get implementationType
     * 
     * @return implementationType
     **/
    public String getImplementationType()
    {
        return implementationType;
    }

    public void setImplementationType(String implementationType)
    {
        this.implementationType = implementationType;
    }

    /**
     * Get implementation
     * 
     * @return implementation
     **/
    public String getImplementation()
    {
        return implementation;
    }

    public void setImplementation(String implementation)
    {
        this.implementation = implementation;
    }

    /**
     * Get fieldExtensions
     * 
     * @return fieldExtensions
     **/
    public List<FieldExtension> getFieldExtensions()
    {
        return fieldExtensions;
    }

    public void setFieldExtensions(List<FieldExtension> fieldExtensions)
    {
        this.fieldExtensions = fieldExtensions;
    }

    /**
     * Get onTransaction
     * 
     * @return onTransaction
     **/
    public String getOnTransaction()
    {
        return onTransaction;
    }

    public void setOnTransaction(String onTransaction)
    {
        this.onTransaction = onTransaction;
    }

    /**
     * Get customPropertiesResolverImplementationType
     * 
     * @return customPropertiesResolverImplementationType
     **/
    public String getCustomPropertiesResolverImplementationType()
    {
        return customPropertiesResolverImplementationType;
    }

    public void setCustomPropertiesResolverImplementationType(String customPropertiesResolverImplementationType)
    {
        this.customPropertiesResolverImplementationType = customPropertiesResolverImplementationType;
    }

    /**
     * Get customPropertiesResolverImplementation
     * 
     * @return customPropertiesResolverImplementation
     **/
    public String getCustomPropertiesResolverImplementation()
    {
        return customPropertiesResolverImplementation;
    }

    public void setCustomPropertiesResolverImplementation(String customPropertiesResolverImplementation)
    {
        this.customPropertiesResolverImplementation = customPropertiesResolverImplementation;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ActivitiListener activitiListener = (ActivitiListener) o;
        return Objects.equals(this.id, activitiListener.id)
                && Objects.equals(this.xmlRowNumber, activitiListener.xmlRowNumber)
                && Objects.equals(this.xmlColumnNumber, activitiListener.xmlColumnNumber)
                && Objects.equals(this.extensionElements, activitiListener.extensionElements)
                && Objects.equals(this.attributes, activitiListener.attributes)
                && Objects.equals(this.event, activitiListener.event)
                && Objects.equals(this.implementationType, activitiListener.implementationType)
                && Objects.equals(this.implementation, activitiListener.implementation)
                && Objects.equals(this.fieldExtensions, activitiListener.fieldExtensions)
                && Objects.equals(this.onTransaction, activitiListener.onTransaction)
                && Objects.equals(this.customPropertiesResolverImplementationType,
                        activitiListener.customPropertiesResolverImplementationType)
                && Objects.equals(this.customPropertiesResolverImplementation,
                        activitiListener.customPropertiesResolverImplementation);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, xmlRowNumber, xmlColumnNumber, extensionElements, attributes, event, implementationType,
                implementation, fieldExtensions, onTransaction, customPropertiesResolverImplementationType,
                customPropertiesResolverImplementation);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActivitiListener {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    xmlRowNumber: ").append(toIndentedString(xmlRowNumber)).append("\n");
        sb.append("    xmlColumnNumber: ").append(toIndentedString(xmlColumnNumber)).append("\n");
        sb.append("    extensionElements: ").append(toIndentedString(extensionElements)).append("\n");
        sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
        sb.append("    event: ").append(toIndentedString(event)).append("\n");
        sb.append("    implementationType: ").append(toIndentedString(implementationType)).append("\n");
        sb.append("    implementation: ").append(toIndentedString(implementation)).append("\n");
        sb.append("    fieldExtensions: ").append(toIndentedString(fieldExtensions)).append("\n");
        sb.append("    onTransaction: ").append(toIndentedString(onTransaction)).append("\n");
        sb.append("    customPropertiesResolverImplementationType: ")
                .append(toIndentedString(customPropertiesResolverImplementationType)).append("\n");
        sb.append("    customPropertiesResolverImplementation: ")
                .append(toIndentedString(customPropertiesResolverImplementation)).append("\n");
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
