package org.alfresco.client.services.process.activiti.core.model.representation.bpmn;

import java.util.*;

import com.google.gson.annotations.SerializedName;

/**
 * Process
 */
public class Process
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

    @SerializedName("executable")
    private Boolean executable = false;

    @SerializedName("documentation")
    private String documentation = null;

    @SerializedName("ioSpecification")
    private IOSpecification ioSpecification = null;

    @SerializedName("executionListeners")
    private List<ActivitiListener> executionListeners = new ArrayList<ActivitiListener>();

    @SerializedName("lanes")
    private List<Lane> lanes = new ArrayList<Lane>();

    @SerializedName("dataObjects")
    private List<ValuedDataObject> dataObjects = new ArrayList<ValuedDataObject>();

    @SerializedName("candidateStarterUsers")
    private List<String> candidateStarterUsers = new ArrayList<String>();

    @SerializedName("candidateStarterGroups")
    private List<String> candidateStarterGroups = new ArrayList<String>();

    @SerializedName("eventListeners")
    private List<EventListener> eventListeners = new ArrayList<EventListener>();

    @SerializedName("flowElementMap")
    private Map<String, FlowElement> flowElementMap = new HashMap<String, FlowElement>();

    @SerializedName("initialFlowElement")
    private FlowElement initialFlowElement = null;

    @SerializedName("artifacts")
    private List<Artifact> artifacts = new ArrayList<Artifact>();

    @SerializedName("flowElements")
    private List<FlowElement> flowElements = new ArrayList<FlowElement>();

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
     * Get executable
     * 
     * @return executable
     **/
    public Boolean getExecutable()
    {
        return executable;
    }

    public void setExecutable(Boolean executable)
    {
        this.executable = executable;
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
     * Get ioSpecification
     * 
     * @return ioSpecification
     **/
    public IOSpecification getIoSpecification()
    {
        return ioSpecification;
    }

    public void setIoSpecification(IOSpecification ioSpecification)
    {
        this.ioSpecification = ioSpecification;
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

    /**
     * Get lanes
     * 
     * @return lanes
     **/
    public List<Lane> getLanes()
    {
        return lanes;
    }

    public void setLanes(List<Lane> lanes)
    {
        this.lanes = lanes;
    }

    /**
     * Get dataObjects
     * 
     * @return dataObjects
     **/
    public List<ValuedDataObject> getDataObjects()
    {
        return dataObjects;
    }

    public void setDataObjects(List<ValuedDataObject> dataObjects)
    {
        this.dataObjects = dataObjects;
    }

    /**
     * Get candidateStarterUsers
     * 
     * @return candidateStarterUsers
     **/
    public List<String> getCandidateStarterUsers()
    {
        return candidateStarterUsers;
    }

    public void setCandidateStarterUsers(List<String> candidateStarterUsers)
    {
        this.candidateStarterUsers = candidateStarterUsers;
    }

    /**
     * Get candidateStarterGroups
     * 
     * @return candidateStarterGroups
     **/
    public List<String> getCandidateStarterGroups()
    {
        return candidateStarterGroups;
    }

    public void setCandidateStarterGroups(List<String> candidateStarterGroups)
    {
        this.candidateStarterGroups = candidateStarterGroups;
    }

    /**
     * Get eventListeners
     * 
     * @return eventListeners
     **/
    public List<EventListener> getEventListeners()
    {
        return eventListeners;
    }

    public void setEventListeners(List<EventListener> eventListeners)
    {
        this.eventListeners = eventListeners;
    }

    /**
     * Get flowElementMap
     * 
     * @return flowElementMap
     **/
    public Map<String, FlowElement> getFlowElementMap()
    {
        return flowElementMap;
    }

    public void setFlowElementMap(Map<String, FlowElement> flowElementMap)
    {
        this.flowElementMap = flowElementMap;
    }

    /**
     * Get initialFlowElement
     * 
     * @return initialFlowElement
     **/
    public FlowElement getInitialFlowElement()
    {
        return initialFlowElement;
    }

    public void setInitialFlowElement(FlowElement initialFlowElement)
    {
        this.initialFlowElement = initialFlowElement;
    }

    /**
     * Get artifacts
     * 
     * @return artifacts
     **/
    public List<Artifact> getArtifacts()
    {
        return artifacts;
    }

    public void setArtifacts(List<Artifact> artifacts)
    {
        this.artifacts = artifacts;
    }

    /**
     * Get flowElements
     * 
     * @return flowElements
     **/
    public List<FlowElement> getFlowElements()
    {
        return flowElements;
    }

    public void setFlowElements(List<FlowElement> flowElements)
    {
        this.flowElements = flowElements;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Process process = (Process) o;
        return Objects.equals(this.id, process.id) && Objects.equals(this.xmlRowNumber, process.xmlRowNumber)
                && Objects.equals(this.xmlColumnNumber, process.xmlColumnNumber)
                && Objects.equals(this.extensionElements, process.extensionElements)
                && Objects.equals(this.attributes, process.attributes) && Objects.equals(this.name, process.name)
                && Objects.equals(this.executable, process.executable)
                && Objects.equals(this.documentation, process.documentation)
                && Objects.equals(this.ioSpecification, process.ioSpecification)
                && Objects.equals(this.executionListeners, process.executionListeners)
                && Objects.equals(this.lanes, process.lanes) && Objects.equals(this.dataObjects, process.dataObjects)
                && Objects.equals(this.candidateStarterUsers, process.candidateStarterUsers)
                && Objects.equals(this.candidateStarterGroups, process.candidateStarterGroups)
                && Objects.equals(this.eventListeners, process.eventListeners)
                && Objects.equals(this.flowElementMap, process.flowElementMap)
                && Objects.equals(this.initialFlowElement, process.initialFlowElement)
                && Objects.equals(this.artifacts, process.artifacts)
                && Objects.equals(this.flowElements, process.flowElements);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, xmlRowNumber, xmlColumnNumber, extensionElements, attributes, name, executable,
                documentation, ioSpecification, executionListeners, lanes, dataObjects, candidateStarterUsers,
                candidateStarterGroups, eventListeners, flowElementMap, initialFlowElement, artifacts, flowElements);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Process {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    xmlRowNumber: ").append(toIndentedString(xmlRowNumber)).append("\n");
        sb.append("    xmlColumnNumber: ").append(toIndentedString(xmlColumnNumber)).append("\n");
        sb.append("    extensionElements: ").append(toIndentedString(extensionElements)).append("\n");
        sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    executable: ").append(toIndentedString(executable)).append("\n");
        sb.append("    documentation: ").append(toIndentedString(documentation)).append("\n");
        sb.append("    ioSpecification: ").append(toIndentedString(ioSpecification)).append("\n");
        sb.append("    executionListeners: ").append(toIndentedString(executionListeners)).append("\n");
        sb.append("    lanes: ").append(toIndentedString(lanes)).append("\n");
        sb.append("    dataObjects: ").append(toIndentedString(dataObjects)).append("\n");
        sb.append("    candidateStarterUsers: ").append(toIndentedString(candidateStarterUsers)).append("\n");
        sb.append("    candidateStarterGroups: ").append(toIndentedString(candidateStarterGroups)).append("\n");
        sb.append("    eventListeners: ").append(toIndentedString(eventListeners)).append("\n");
        sb.append("    flowElementMap: ").append(toIndentedString(flowElementMap)).append("\n");
        sb.append("    initialFlowElement: ").append(toIndentedString(initialFlowElement)).append("\n");
        sb.append("    artifacts: ").append(toIndentedString(artifacts)).append("\n");
        sb.append("    flowElements: ").append(toIndentedString(flowElements)).append("\n");
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
