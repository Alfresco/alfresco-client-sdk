package org.alfresco.client.services.process.activiti;

import org.alfresco.client.services.common.APIRegistry;
import org.alfresco.client.services.process.activiti.core.api.*;

/**
 * Created by jpascal on 30/04/2017.
 */
public interface ActivitiServicesRegistry extends APIRegistry
{
    DatabaseTablesAPI getDatabaseTablesAPI();

    DeploymentsAPI getDeploymentsAPI();

    EngineAPI geEngineAPI();

    ExecutionsAPI getExecutionsAPI();

    FormsAPI getFormsAPI();

    GroupsAPI getGroupsAPI();

    HistoryAPI getHistoryAPI();

    JobsAPI getJobsAPI();

    ModelsAPI getModelsAPI();

    ProcessDefinitionsAPI getProcessDefinitionsAPI();

    ProcessInstancesAPI getProcessInstancesAPI();

    RuntimeAPI getRuntimeAPI();

    TasksAPI getTasksAPI();

    UsersAPI getUsersAPI();
}
