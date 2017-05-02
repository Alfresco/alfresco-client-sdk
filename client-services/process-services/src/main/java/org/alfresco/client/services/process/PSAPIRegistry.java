package org.alfresco.client.services.process;

import org.alfresco.client.services.common.AbstractAPIRegistry;
import org.alfresco.client.services.common.RestClient;
import org.alfresco.client.services.process.enterprise.admin.api.AdminEndpointsAPI;
import org.alfresco.client.services.process.enterprise.admin.api.AdminGroupsAPI;
import org.alfresco.client.services.process.enterprise.admin.api.AdminTenantsAPI;
import org.alfresco.client.services.process.enterprise.admin.api.AdminUsersAPI;
import org.alfresco.client.services.process.enterprise.core.api.*;
import org.alfresco.client.services.process.enterprise.discovery.api.DiscoveryAPI;

/**
 * Created by jpascal on 30/04/2017.
 */
public class PSAPIRegistry extends AbstractAPIRegistry implements ProcessServicesRegistry
{
    protected DiscoveryAPI discoveryAPI;

    protected AdminEndpointsAPI adminEndpointsAPI;

    protected AdminGroupsAPI adminGroupsAPI;

    protected AdminTenantsAPI adminTenantsAPI;

    protected AdminUsersAPI adminUsersAPI;

    protected ContentsAPI contentsAPI;

    protected ModelsAPI modelsAPI;

    protected ProcessDefinitionsAPI processDefinitionsAPI;

    protected ProcessInstancesAPI processInstancesAPI;

    protected UserProfileAPI profileAPI;

    protected RuntimeAppDefinitionsAPI runtimeAppDefinitionsAPI;

    protected TasksAPI tasksAPI;

    protected UserFiltersAPI userFiltersAPI;

    protected UsersGroupsAPI usersGroupsAPI;

    protected AppDefinitionsAPI appDefinitionsAPI;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    // ///////////////////////////////////////////////////////////////////////////
    public PSAPIRegistry(RestClient restClient)
    {
        this.restClient = restClient;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS
    // ///////////////////////////////////////////////////////////////////////////
    public DiscoveryAPI getDiscoveryAPI()
    {
        return discoveryAPI = (discoveryAPI == null) ? getAPI(DiscoveryAPI.class) : discoveryAPI;
    }

    public AdminUsersAPI geAdminUsersAPI()
    {
        return adminUsersAPI = (adminUsersAPI == null) ? getAPI(AdminUsersAPI.class) : adminUsersAPI;
    }

    public AdminEndpointsAPI getAdminEndpointsAPI()
    {
        return adminEndpointsAPI = (adminEndpointsAPI == null) ? getAPI(AdminEndpointsAPI.class) : adminEndpointsAPI;
    }

    public AdminTenantsAPI getAdminTenantsAPI()
    {
        return adminTenantsAPI = (adminTenantsAPI == null) ? getAPI(AdminTenantsAPI.class) : adminTenantsAPI;
    }

    public AdminGroupsAPI getAdminGroupsAPI()
    {
        return adminGroupsAPI = (adminGroupsAPI == null) ? getAPI(AdminGroupsAPI.class) : adminGroupsAPI;
    }

    public ContentsAPI getContentsAPI()
    {
        return contentsAPI = (contentsAPI == null) ? getAPI(ContentsAPI.class) : contentsAPI;
    }

    public ModelsAPI getModelsAPI()
    {
        return modelsAPI = (modelsAPI == null) ? getAPI(ModelsAPI.class) : modelsAPI;
    }

    public ProcessDefinitionsAPI getProcessDefinitionsAPI()
    {
        return processDefinitionsAPI = (processDefinitionsAPI == null) ? getAPI(ProcessDefinitionsAPI.class)
                : processDefinitionsAPI;
    }

    public ProcessInstancesAPI getProcessInstancesAPI()
    {
        return processInstancesAPI = (processInstancesAPI == null) ? getAPI(ProcessInstancesAPI.class)
                : processInstancesAPI;
    }

    public UserProfileAPI getProfileAPI()
    {
        return profileAPI = (profileAPI == null) ? getAPI(UserProfileAPI.class) : profileAPI;
    }

    public RuntimeAppDefinitionsAPI getRuntimeAppDefinitionsAPI()
    {
        return runtimeAppDefinitionsAPI = (runtimeAppDefinitionsAPI == null) ? getAPI(RuntimeAppDefinitionsAPI.class)
                : runtimeAppDefinitionsAPI;
    }

    public TasksAPI getTasksAPI()
    {
        return tasksAPI = (tasksAPI == null) ? getAPI(TasksAPI.class) : tasksAPI;
    }

    public UserFiltersAPI getUserFiltersAPI()
    {
        return userFiltersAPI = (userFiltersAPI == null) ? getAPI(UserFiltersAPI.class) : userFiltersAPI;
    }

    public UsersGroupsAPI getUsersGroupsAPI()
    {
        return usersGroupsAPI = (usersGroupsAPI == null) ? getAPI(UsersGroupsAPI.class) : usersGroupsAPI;
    }

    public AppDefinitionsAPI getAppDefinitionsAPI()
    {
        return appDefinitionsAPI = (appDefinitionsAPI == null) ? getAPI(AppDefinitionsAPI.class) : appDefinitionsAPI;
    }
}
