package org.alfresco.client.services.process.activiti;

import org.alfresco.client.services.common.AbstractAPIRegistry;
import org.alfresco.client.services.common.RestClient;
import org.alfresco.client.services.process.activiti.core.api.*;

/**
 * Created by jpascal on 30/04/2017.
 */
public class ActivitiAPIRegistry extends AbstractAPIRegistry implements ActivitiServicesRegistry
{
    protected DatabaseTablesAPI databaseTablesAPI;

    protected DeploymentsAPI deploymentsAPI;

    protected EngineAPI engineAPI;

    protected ExecutionsAPI executionsAPI;

    protected FormsAPI formsAPI;

    protected GroupsAPI groupsAPI;

    protected HistoryAPI historyAPI;

    protected JobsAPI jobsAPI;

    protected ModelsAPI modelsAPI;

    protected ProcessDefinitionsAPI processDefinitionsAPI;

    protected ProcessInstancesAPI processInstancesAPI;

    protected RuntimeAPI runtimeAPI;

    protected TasksAPI tasksAPI;

    protected UsersAPI usersAPI;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    // ///////////////////////////////////////////////////////////////////////////
    public ActivitiAPIRegistry(RestClient restClient)
    {
        this.restClient = restClient;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS
    // ///////////////////////////////////////////////////////////////////////////
    @Override
    public DatabaseTablesAPI getDatabaseTablesAPI()
    {
        return databaseTablesAPI = (databaseTablesAPI == null) ? getAPI(DatabaseTablesAPI.class) : databaseTablesAPI;
    }

    @Override
    public DeploymentsAPI getDeploymentsAPI()
    {
        return deploymentsAPI = (deploymentsAPI == null) ? getAPI(DeploymentsAPI.class) : deploymentsAPI;
    }

    @Override
    public EngineAPI geEngineAPI()
    {
        return engineAPI = (engineAPI == null) ? getAPI(EngineAPI.class) : engineAPI;
    }

    @Override
    public ExecutionsAPI getExecutionsAPI()
    {
        return executionsAPI = (executionsAPI == null) ? getAPI(ExecutionsAPI.class) : executionsAPI;
    }

    @Override
    public FormsAPI getFormsAPI()
    {
        return formsAPI = (formsAPI == null) ? getAPI(FormsAPI.class) : formsAPI;
    }

    @Override
    public GroupsAPI getGroupsAPI()
    {
        return groupsAPI = (groupsAPI == null) ? getAPI(GroupsAPI.class) : groupsAPI;
    }

    @Override
    public HistoryAPI getHistoryAPI()
    {
        return historyAPI = (historyAPI == null) ? getAPI(HistoryAPI.class) : historyAPI;
    }

    @Override
    public JobsAPI getJobsAPI()
    {
        return jobsAPI = (jobsAPI == null) ? getAPI(JobsAPI.class) : jobsAPI;
    }

    @Override
    public ModelsAPI getModelsAPI()
    {
        return modelsAPI = (modelsAPI == null) ? getAPI(ModelsAPI.class) : modelsAPI;
    }

    @Override
    public ProcessDefinitionsAPI getProcessDefinitionsAPI()
    {
        return processDefinitionsAPI = (processDefinitionsAPI == null) ? getAPI(ProcessDefinitionsAPI.class)
                : processDefinitionsAPI;
    }

    @Override
    public ProcessInstancesAPI getProcessInstancesAPI()
    {
        return processInstancesAPI = (processInstancesAPI == null) ? getAPI(ProcessInstancesAPI.class)
                : processInstancesAPI;
    }

    @Override
    public RuntimeAPI getRuntimeAPI()
    {
        return runtimeAPI = (runtimeAPI == null) ? getAPI(RuntimeAPI.class) : runtimeAPI;
    }

    @Override
    public TasksAPI getTasksAPI()
    {
        return tasksAPI = (tasksAPI == null) ? getAPI(TasksAPI.class) : tasksAPI;
    }

    @Override
    public UsersAPI getUsersAPI()
    {
        return usersAPI = (usersAPI == null) ? getAPI(UsersAPI.class) : usersAPI;
    }
}
