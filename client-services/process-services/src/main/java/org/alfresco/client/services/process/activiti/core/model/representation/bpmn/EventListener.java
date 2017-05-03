package org.alfresco.client.services.process.activiti.core.model.representation.bpmn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * EventListener
 */
public class EventListener
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

    @SerializedName("events")
    private String events = null;

    @SerializedName("implementationType")
    private String implementationType = null;

    @SerializedName("implementation")
    private String implementation = null;

    @SerializedName("entityType")
    private String entityType = null;

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
     * Get events
     * 
     * @return events
     **/
    public String getEvents()
    {
        return events;
    }

    public void setEvents(String events)
    {
        this.events = events;
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
     * Get entityType
     * 
     * @return entityType
     **/
    public String getEntityType()
    {
        return entityType;
    }

    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        EventListener eventListener = (EventListener) o;
        return Objects.equals(this.id, eventListener.id)
                && Objects.equals(this.xmlRowNumber, eventListener.xmlRowNumber)
                && Objects.equals(this.xmlColumnNumber, eventListener.xmlColumnNumber)
                && Objects.equals(this.extensionElements, eventListener.extensionElements)
                && Objects.equals(this.attributes, eventListener.attributes)
                && Objects.equals(this.events, eventListener.events)
                && Objects.equals(this.implementationType, eventListener.implementationType)
                && Objects.equals(this.implementation, eventListener.implementation)
                && Objects.equals(this.entityType, eventListener.entityType);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, xmlRowNumber, xmlColumnNumber, extensionElements, attributes, events,
                implementationType, implementation, entityType);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class EventListener {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    xmlRowNumber: ").append(toIndentedString(xmlRowNumber)).append("\n");
        sb.append("    xmlColumnNumber: ").append(toIndentedString(xmlColumnNumber)).append("\n");
        sb.append("    extensionElements: ").append(toIndentedString(extensionElements)).append("\n");
        sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
        sb.append("    events: ").append(toIndentedString(events)).append("\n");
        sb.append("    implementationType: ").append(toIndentedString(implementationType)).append("\n");
        sb.append("    implementation: ").append(toIndentedString(implementation)).append("\n");
        sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
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
