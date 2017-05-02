package org.alfresco.client.services.process;

import org.alfresco.client.services.common.APIRegistry;
import org.alfresco.client.services.process.enterprise.admin.api.AdminEndpointsAPI;
import org.alfresco.client.services.process.enterprise.admin.api.AdminGroupsAPI;
import org.alfresco.client.services.process.enterprise.admin.api.AdminTenantsAPI;
import org.alfresco.client.services.process.enterprise.admin.api.AdminUsersAPI;
import org.alfresco.client.services.process.enterprise.core.api.*;
import org.alfresco.client.services.process.enterprise.discovery.api.DiscoveryAPI;

/**
 * Created by jpascal on 30/04/2017.
 */
public interface ProcessServicesRegistry extends APIRegistry
{
    AppDefinitionsAPI getAppDefinitionsAPI();

    DiscoveryAPI getDiscoveryAPI();

    AdminUsersAPI geAdminUsersAPI();

    AdminEndpointsAPI getAdminEndpointsAPI();

    AdminTenantsAPI getAdminTenantsAPI();

    AdminGroupsAPI getAdminGroupsAPI();

    ContentsAPI getContentsAPI();

    ModelsAPI getModelsAPI();

    ProcessDefinitionsAPI getProcessDefinitionsAPI();

    ProcessInstancesAPI getProcessInstancesAPI();

    UserProfileAPI getProfileAPI();

    RuntimeAppDefinitionsAPI getRuntimeAppDefinitionsAPI();

    TasksAPI getTasksAPI();

    UserFiltersAPI getUserFiltersAPI();

    UsersGroupsAPI getUsersGroupsAPI();

}
