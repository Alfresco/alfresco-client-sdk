package org.alfresco.client.services.process;

import org.alfresco.client.services.common.AbstractAPIRegistry;
import org.alfresco.client.services.common.RestClient;
import org.alfresco.client.services.process.core.api.*;

/**
 * Created by jpascal on 30/04/2017.
 */
public class PSAPIRegistry extends AbstractAPIRegistry implements ProcessServicesRegistry
{
    protected AboutAPI aboutAPI;

    protected AdminAPI admiAPI;

    protected ContentAPI contentAPI;

    protected ModelsAPI modelsAPI;

    protected ProcessDefinitionAPI processDefinitionAPI;

    protected ProcessInstanceAPI processInstanceAPI;

    protected ProfileAPI profileAPI;

    protected RuntimeAppDefinitionAPI runtimeAppDefinitionAPI;

    protected TaskAPI taskAPI;

    protected UserFiltersAPI userFiltersAPI;

    protected UserGroupAPI userGroupAPI;

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
    public AboutAPI getAboutAPI()
    {
        return aboutAPI = (aboutAPI == null) ? getAPI(AboutAPI.class) : aboutAPI;
    }

    public AdminAPI getAdmiAPI()
    {
        return admiAPI = (admiAPI == null) ? getAPI(AdminAPI.class) : admiAPI;
    }

    public ContentAPI getContentAPI()
    {
        return contentAPI = (contentAPI == null) ? getAPI(ContentAPI.class) : contentAPI;
    }

    public ModelsAPI getModelsAPI()
    {
        return modelsAPI = (modelsAPI == null) ? getAPI(ModelsAPI.class) : modelsAPI;
    }

    public ProcessDefinitionAPI getProcessDefinitionAPI()
    {
        return processDefinitionAPI = (processDefinitionAPI == null) ? getAPI(ProcessDefinitionAPI.class)
                : processDefinitionAPI;
    }

    public ProcessInstanceAPI getProcessInstanceAPI()
    {
        return processInstanceAPI = (processInstanceAPI == null) ? getAPI(ProcessInstanceAPI.class)
                : processInstanceAPI;
    }

    public ProfileAPI getProfileAPI()
    {
        return profileAPI = (profileAPI == null) ? getAPI(ProfileAPI.class) : profileAPI;
    }

    public RuntimeAppDefinitionAPI getRuntimeAppDefinitionAPI()
    {
        return runtimeAppDefinitionAPI = (runtimeAppDefinitionAPI == null) ? getAPI(RuntimeAppDefinitionAPI.class)
                : runtimeAppDefinitionAPI;
    }

    public TaskAPI getTaskAPI()
    {
        return taskAPI = (taskAPI == null) ? getAPI(TaskAPI.class) : taskAPI;
    }

    public UserFiltersAPI getUserFiltersAPI()
    {
        return userFiltersAPI = (userFiltersAPI == null) ? getAPI(UserFiltersAPI.class) : userFiltersAPI;
    }

    public UserGroupAPI getUserGroupAPI()
    {
        return userGroupAPI = (userGroupAPI == null) ? getAPI(UserGroupAPI.class) : userGroupAPI;
    }
}
