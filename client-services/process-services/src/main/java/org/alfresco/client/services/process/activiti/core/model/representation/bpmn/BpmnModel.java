package org.alfresco.client.services.process.activiti.core.model.representation.bpmn;

import java.util.*;

import org.alfresco.client.services.process.activiti.core.model.representation.GraphicInfo;
import org.alfresco.client.services.process.activiti.core.model.representation.ModelImport;
import org.alfresco.client.services.process.activiti.core.model.representation.ModelInterface;

import com.google.gson.annotations.SerializedName;

/**
 * BpmnModel
 */
public class BpmnModel
{
    @SerializedName("definitionsAttributes")
    private Map<String, List<ExtensionAttribute>> definitionsAttributes = new HashMap<String, List<ExtensionAttribute>>();

    @SerializedName("processes")
    private List<Process> processes = new ArrayList<Process>();

    @SerializedName("locationMap")
    private Map<String, GraphicInfo> locationMap = new HashMap<String, GraphicInfo>();

    @SerializedName("labelLocationMap")
    private Map<String, GraphicInfo> labelLocationMap = new HashMap<String, GraphicInfo>();

    @SerializedName("flowLocationMap")
    private Map<String, List<GraphicInfo>> flowLocationMap = new HashMap<String, List<GraphicInfo>>();

    @SerializedName("signals")
    private List<Signal> signals = new ArrayList<Signal>();

    @SerializedName("pools")
    private List<Pool> pools = new ArrayList<Pool>();

    @SerializedName("imports")
    private List<ModelImport> imports = new ArrayList<ModelImport>();

    @SerializedName("interfaces")
    private List<ModelInterface> interfaces = new ArrayList<ModelInterface>();

    @SerializedName("globalArtifacts")
    private List<Artifact> globalArtifacts = new ArrayList<Artifact>();

    @SerializedName("resources")
    private List<Resource> resources = new ArrayList<Resource>();

    @SerializedName("targetNamespace")
    private String targetNamespace = null;

    @SerializedName("sourceSystemId")
    private String sourceSystemId = null;

    @SerializedName("userTaskFormTypes")
    private List<String> userTaskFormTypes = new ArrayList<String>();

    @SerializedName("startEventFormTypes")
    private List<String> startEventFormTypes = new ArrayList<String>();

    @SerializedName("errors")
    private Map<String, String> errors = new HashMap<String, String>();

    @SerializedName("messages")
    private List<Message> messages = new ArrayList<Message>();

    @SerializedName("itemDefinitions")
    private Map<String, ItemDefinition> itemDefinitions = new HashMap<String, ItemDefinition>();

    @SerializedName("mainProcess")
    private Process mainProcess = null;

    @SerializedName("messageFlows")
    private Map<String, MessageFlow> messageFlows = new HashMap<String, MessageFlow>();

    @SerializedName("dataStores")
    private Map<String, DataStore> dataStores = new HashMap<String, DataStore>();

    @SerializedName("namespaces")
    private Map<String, String> namespaces = new HashMap<String, String>();

    /**
     * Get definitionsAttributes
     * 
     * @return definitionsAttributes
     **/
    public Map<String, List<ExtensionAttribute>> getDefinitionsAttributes()
    {
        return definitionsAttributes;
    }

    public void setDefinitionsAttributes(Map<String, List<ExtensionAttribute>> definitionsAttributes)
    {
        this.definitionsAttributes = definitionsAttributes;
    }

    /**
     * Get processes
     * 
     * @return processes
     **/
    public List<Process> getProcesses()
    {
        return processes;
    }

    public void setProcesses(List<Process> processes)
    {
        this.processes = processes;
    }

    /**
     * Get locationMap
     * 
     * @return locationMap
     **/
    public Map<String, GraphicInfo> getLocationMap()
    {
        return locationMap;
    }

    public void setLocationMap(Map<String, GraphicInfo> locationMap)
    {
        this.locationMap = locationMap;
    }

    /**
     * Get labelLocationMap
     * 
     * @return labelLocationMap
     **/
    public Map<String, GraphicInfo> getLabelLocationMap()
    {
        return labelLocationMap;
    }

    public void setLabelLocationMap(Map<String, GraphicInfo> labelLocationMap)
    {
        this.labelLocationMap = labelLocationMap;
    }

    /**
     * Get flowLocationMap
     * 
     * @return flowLocationMap
     **/
    public Map<String, List<GraphicInfo>> getFlowLocationMap()
    {
        return flowLocationMap;
    }

    public void setFlowLocationMap(Map<String, List<GraphicInfo>> flowLocationMap)
    {
        this.flowLocationMap = flowLocationMap;
    }

    /**
     * Get signals
     * 
     * @return signals
     **/
    public List<Signal> getSignals()
    {
        return signals;
    }

    public void setSignals(List<Signal> signals)
    {
        this.signals = signals;
    }

    /**
     * Get pools
     * 
     * @return pools
     **/
    public List<Pool> getPools()
    {
        return pools;
    }

    public void setPools(List<Pool> pools)
    {
        this.pools = pools;
    }

    /**
     * Get imports
     * 
     * @return imports
     **/
    public List<ModelImport> getImports()
    {
        return imports;
    }

    public void setImports(List<ModelImport> imports)
    {
        this.imports = imports;
    }

    /**
     * Get interfaces
     * 
     * @return interfaces
     **/
    public List<ModelInterface> getInterfaces()
    {
        return interfaces;
    }

    public void setInterfaces(List<ModelInterface> interfaces)
    {
        this.interfaces = interfaces;
    }

    /**
     * Get globalArtifacts
     * 
     * @return globalArtifacts
     **/
    public List<Artifact> getGlobalArtifacts()
    {
        return globalArtifacts;
    }

    public void setGlobalArtifacts(List<Artifact> globalArtifacts)
    {
        this.globalArtifacts = globalArtifacts;
    }

    /**
     * Get resources
     * 
     * @return resources
     **/
    public List<Resource> getResources()
    {
        return resources;
    }

    public void setResources(List<Resource> resources)
    {
        this.resources = resources;
    }

    /**
     * Get targetNamespace
     * 
     * @return targetNamespace
     **/
    public String getTargetNamespace()
    {
        return targetNamespace;
    }

    public void setTargetNamespace(String targetNamespace)
    {
        this.targetNamespace = targetNamespace;
    }

    /**
     * Get sourceSystemId
     * 
     * @return sourceSystemId
     **/
    public String getSourceSystemId()
    {
        return sourceSystemId;
    }

    public void setSourceSystemId(String sourceSystemId)
    {
        this.sourceSystemId = sourceSystemId;
    }

    /**
     * Get userTaskFormTypes
     * 
     * @return userTaskFormTypes
     **/
    public List<String> getUserTaskFormTypes()
    {
        return userTaskFormTypes;
    }

    public void setUserTaskFormTypes(List<String> userTaskFormTypes)
    {
        this.userTaskFormTypes = userTaskFormTypes;
    }

    /**
     * Get startEventFormTypes
     * 
     * @return startEventFormTypes
     **/
    public List<String> getStartEventFormTypes()
    {
        return startEventFormTypes;
    }

    public void setStartEventFormTypes(List<String> startEventFormTypes)
    {
        this.startEventFormTypes = startEventFormTypes;
    }

    /**
     * Get errors
     * 
     * @return errors
     **/
    public Map<String, String> getErrors()
    {
        return errors;
    }

    public void setErrors(Map<String, String> errors)
    {
        this.errors = errors;
    }

    /**
     * Get messages
     * 
     * @return messages
     **/
    public List<Message> getMessages()
    {
        return messages;
    }

    public void setMessages(List<Message> messages)
    {
        this.messages = messages;
    }

    /**
     * Get itemDefinitions
     * 
     * @return itemDefinitions
     **/
    public Map<String, ItemDefinition> getItemDefinitions()
    {
        return itemDefinitions;
    }

    public void setItemDefinitions(Map<String, ItemDefinition> itemDefinitions)
    {
        this.itemDefinitions = itemDefinitions;
    }

    /**
     * Get mainProcess
     * 
     * @return mainProcess
     **/
    public Process getMainProcess()
    {
        return mainProcess;
    }

    public void setMainProcess(Process mainProcess)
    {
        this.mainProcess = mainProcess;
    }

    /**
     * Get messageFlows
     * 
     * @return messageFlows
     **/
    public Map<String, MessageFlow> getMessageFlows()
    {
        return messageFlows;
    }

    public void setMessageFlows(Map<String, MessageFlow> messageFlows)
    {
        this.messageFlows = messageFlows;
    }

    /**
     * Get dataStores
     * 
     * @return dataStores
     **/
    public Map<String, DataStore> getDataStores()
    {
        return dataStores;
    }

    public void setDataStores(Map<String, DataStore> dataStores)
    {
        this.dataStores = dataStores;
    }

    /**
     * Get namespaces
     * 
     * @return namespaces
     **/
    public Map<String, String> getNamespaces()
    {
        return namespaces;
    }

    public void setNamespaces(Map<String, String> namespaces)
    {
        this.namespaces = namespaces;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        BpmnModel bpmnModel = (BpmnModel) o;
        return Objects.equals(this.definitionsAttributes, bpmnModel.definitionsAttributes)
                && Objects.equals(this.processes, bpmnModel.processes)
                && Objects.equals(this.locationMap, bpmnModel.locationMap)
                && Objects.equals(this.labelLocationMap, bpmnModel.labelLocationMap)
                && Objects.equals(this.flowLocationMap, bpmnModel.flowLocationMap)
                && Objects.equals(this.signals, bpmnModel.signals) && Objects.equals(this.pools, bpmnModel.pools)
                && Objects.equals(this.imports, bpmnModel.imports)
                && Objects.equals(this.interfaces, bpmnModel.interfaces)
                && Objects.equals(this.globalArtifacts, bpmnModel.globalArtifacts)
                && Objects.equals(this.resources, bpmnModel.resources)
                && Objects.equals(this.targetNamespace, bpmnModel.targetNamespace)
                && Objects.equals(this.sourceSystemId, bpmnModel.sourceSystemId)
                && Objects.equals(this.userTaskFormTypes, bpmnModel.userTaskFormTypes)
                && Objects.equals(this.startEventFormTypes, bpmnModel.startEventFormTypes)
                && Objects.equals(this.errors, bpmnModel.errors) && Objects.equals(this.messages, bpmnModel.messages)
                && Objects.equals(this.itemDefinitions, bpmnModel.itemDefinitions)
                && Objects.equals(this.mainProcess, bpmnModel.mainProcess)
                && Objects.equals(this.messageFlows, bpmnModel.messageFlows)
                && Objects.equals(this.dataStores, bpmnModel.dataStores)
                && Objects.equals(this.namespaces, bpmnModel.namespaces);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(definitionsAttributes, processes, locationMap, labelLocationMap, flowLocationMap, signals,
                pools, imports, interfaces, globalArtifacts, resources, targetNamespace, sourceSystemId,
                userTaskFormTypes, startEventFormTypes, errors, messages, itemDefinitions, mainProcess, messageFlows,
                dataStores, namespaces);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class BpmnModel {\n");

        sb.append("    definitionsAttributes: ").append(toIndentedString(definitionsAttributes)).append("\n");
        sb.append("    processes: ").append(toIndentedString(processes)).append("\n");
        sb.append("    locationMap: ").append(toIndentedString(locationMap)).append("\n");
        sb.append("    labelLocationMap: ").append(toIndentedString(labelLocationMap)).append("\n");
        sb.append("    flowLocationMap: ").append(toIndentedString(flowLocationMap)).append("\n");
        sb.append("    signals: ").append(toIndentedString(signals)).append("\n");
        sb.append("    pools: ").append(toIndentedString(pools)).append("\n");
        sb.append("    imports: ").append(toIndentedString(imports)).append("\n");
        sb.append("    interfaces: ").append(toIndentedString(interfaces)).append("\n");
        sb.append("    globalArtifacts: ").append(toIndentedString(globalArtifacts)).append("\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("    targetNamespace: ").append(toIndentedString(targetNamespace)).append("\n");
        sb.append("    sourceSystemId: ").append(toIndentedString(sourceSystemId)).append("\n");
        sb.append("    userTaskFormTypes: ").append(toIndentedString(userTaskFormTypes)).append("\n");
        sb.append("    startEventFormTypes: ").append(toIndentedString(startEventFormTypes)).append("\n");
        sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
        sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
        sb.append("    itemDefinitions: ").append(toIndentedString(itemDefinitions)).append("\n");
        sb.append("    mainProcess: ").append(toIndentedString(mainProcess)).append("\n");
        sb.append("    messageFlows: ").append(toIndentedString(messageFlows)).append("\n");
        sb.append("    dataStores: ").append(toIndentedString(dataStores)).append("\n");
        sb.append("    namespaces: ").append(toIndentedString(namespaces)).append("\n");
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
