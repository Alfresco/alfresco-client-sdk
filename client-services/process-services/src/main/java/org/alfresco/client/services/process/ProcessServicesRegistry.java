package org.alfresco.client.services.process;

import org.alfresco.client.services.common.APIRegistry;
import org.alfresco.client.services.process.core.api.*;

/**
 * Created by jpascal on 30/04/2017.
 */
public interface ProcessServicesRegistry extends APIRegistry
{
    AboutAPI getAboutAPI();

    AdminAPI getAdmiAPI();

    ContentAPI getContentAPI();

    ModelsAPI getModelsAPI();

    ProcessDefinitionAPI getProcessDefinitionAPI();

    ProcessInstanceAPI getProcessInstanceAPI();

    ProfileAPI getProfileAPI();

    RuntimeAppDefinitionAPI getRuntimeAppDefinitionAPI();

    TaskAPI getTaskAPI();

    UserFiltersAPI getUserFiltersAPI();

    UserGroupAPI getUserGroupAPI();

}
