package org.alfresco.client.services.process.activiti.core.model.representation.bpmn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * MessageFlow
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-03T15:39:02.168+02:00")
public class MessageFlow
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

    @SerializedName("sourceRef")
    private String sourceRef = null;

    @SerializedName("targetRef")
    private String targetRef = null;

    @SerializedName("messageRef")
    private String messageRef = null;

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
     * Get sourceRef
     * 
     * @return sourceRef
     **/
    public String getSourceRef()
    {
        return sourceRef;
    }

    public void setSourceRef(String sourceRef)
    {
        this.sourceRef = sourceRef;
    }

    /**
     * Get targetRef
     * 
     * @return targetRef
     **/
    public String getTargetRef()
    {
        return targetRef;
    }

    public void setTargetRef(String targetRef)
    {
        this.targetRef = targetRef;
    }

    /**
     * Get messageRef
     * 
     * @return messageRef
     **/
    public String getMessageRef()
    {
        return messageRef;
    }

    public void setMessageRef(String messageRef)
    {
        this.messageRef = messageRef;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MessageFlow messageFlow = (MessageFlow) o;
        return Objects.equals(this.id, messageFlow.id) && Objects.equals(this.xmlRowNumber, messageFlow.xmlRowNumber)
                && Objects.equals(this.xmlColumnNumber, messageFlow.xmlColumnNumber)
                && Objects.equals(this.extensionElements, messageFlow.extensionElements)
                && Objects.equals(this.attributes, messageFlow.attributes)
                && Objects.equals(this.name, messageFlow.name) && Objects.equals(this.sourceRef, messageFlow.sourceRef)
                && Objects.equals(this.targetRef, messageFlow.targetRef)
                && Objects.equals(this.messageRef, messageFlow.messageRef);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, xmlRowNumber, xmlColumnNumber, extensionElements, attributes, name, sourceRef,
                targetRef, messageRef);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class MessageFlow {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    xmlRowNumber: ").append(toIndentedString(xmlRowNumber)).append("\n");
        sb.append("    xmlColumnNumber: ").append(toIndentedString(xmlColumnNumber)).append("\n");
        sb.append("    extensionElements: ").append(toIndentedString(extensionElements)).append("\n");
        sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    sourceRef: ").append(toIndentedString(sourceRef)).append("\n");
        sb.append("    targetRef: ").append(toIndentedString(targetRef)).append("\n");
        sb.append("    messageRef: ").append(toIndentedString(messageRef)).append("\n");
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
