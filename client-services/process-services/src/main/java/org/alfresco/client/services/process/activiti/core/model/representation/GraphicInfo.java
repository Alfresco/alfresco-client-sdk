package org.alfresco.client.services.process.activiti.core.model.representation;

import java.util.Objects;

import org.alfresco.client.services.process.activiti.core.model.representation.bpmn.BaseElement;

import com.google.gson.annotations.SerializedName;

/**
 * GraphicInfo
 */
public class GraphicInfo
{
    @SerializedName("x")
    private Double x = null;

    @SerializedName("y")
    private Double y = null;

    @SerializedName("height")
    private Double height = null;

    @SerializedName("width")
    private Double width = null;

    @SerializedName("element")
    private BaseElement element = null;

    @SerializedName("expanded")
    private Boolean expanded = false;

    @SerializedName("xmlRowNumber")
    private Integer xmlRowNumber = null;

    @SerializedName("xmlColumnNumber")
    private Integer xmlColumnNumber = null;

    /**
     * Get x
     * 
     * @return x
     **/
    public Double getX()
    {
        return x;
    }

    public void setX(Double x)
    {
        this.x = x;
    }

    /**
     * Get y
     * 
     * @return y
     **/
    public Double getY()
    {
        return y;
    }

    public void setY(Double y)
    {
        this.y = y;
    }

    /**
     * Get height
     * 
     * @return height
     **/
    public Double getHeight()
    {
        return height;
    }

    public void setHeight(Double height)
    {
        this.height = height;
    }

    /**
     * Get width
     * 
     * @return width
     **/
    public Double getWidth()
    {
        return width;
    }

    public void setWidth(Double width)
    {
        this.width = width;
    }

    /**
     * Get element
     * 
     * @return element
     **/
    public BaseElement getElement()
    {
        return element;
    }

    public void setElement(BaseElement element)
    {
        this.element = element;
    }

    /**
     * Get expanded
     * 
     * @return expanded
     **/
    public Boolean getExpanded()
    {
        return expanded;
    }

    public void setExpanded(Boolean expanded)
    {
        this.expanded = expanded;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GraphicInfo graphicInfo = (GraphicInfo) o;
        return Objects.equals(this.x, graphicInfo.x) && Objects.equals(this.y, graphicInfo.y)
                && Objects.equals(this.height, graphicInfo.height) && Objects.equals(this.width, graphicInfo.width)
                && Objects.equals(this.element, graphicInfo.element)
                && Objects.equals(this.expanded, graphicInfo.expanded)
                && Objects.equals(this.xmlRowNumber, graphicInfo.xmlRowNumber)
                && Objects.equals(this.xmlColumnNumber, graphicInfo.xmlColumnNumber);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y, height, width, element, expanded, xmlRowNumber, xmlColumnNumber);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class GraphicInfo {\n");

        sb.append("    x: ").append(toIndentedString(x)).append("\n");
        sb.append("    y: ").append(toIndentedString(y)).append("\n");
        sb.append("    height: ").append(toIndentedString(height)).append("\n");
        sb.append("    width: ").append(toIndentedString(width)).append("\n");
        sb.append("    element: ").append(toIndentedString(element)).append("\n");
        sb.append("    expanded: ").append(toIndentedString(expanded)).append("\n");
        sb.append("    xmlRowNumber: ").append(toIndentedString(xmlRowNumber)).append("\n");
        sb.append("    xmlColumnNumber: ").append(toIndentedString(xmlColumnNumber)).append("\n");
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
