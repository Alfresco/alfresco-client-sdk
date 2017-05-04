/*
 *   Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *   This file is part of Alfresco Java Client.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.alfresco.client.services.process.activiti;

import org.alfresco.client.Version;
import org.alfresco.client.services.common.RestClient;
import org.alfresco.client.services.common.ServicesClient;
import org.alfresco.client.services.common.utils.ISO8601Utils;
import org.alfresco.client.services.process.activiti.core.api.*;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;

public class ActivitiClient extends ServicesClient<ActivitiClient> implements ActivitiServicesRegistry
{
    protected static final Object LOCK = new Object();

    protected static ActivitiClient mInstance;

    protected ActivitiAPIRegistry activitiApiRegistry;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    // ///////////////////////////////////////////////////////////////////////////
    public static ActivitiClient getInstance()
    {
        synchronized (LOCK)
        {
            return mInstance;
        }
    }

    private ActivitiClient(RestClient restClient, OkHttpClient okHttpClient)
    {
        super(restClient, okHttpClient);
    }

    // ///////////////////////////////////////////////////////////////////////////
    // API REGISTRY
    // ///////////////////////////////////////////////////////////////////////////
    public ActivitiAPIRegistry getPSAPIRegistry()
    {
        if (activitiApiRegistry == null)
        {
            activitiApiRegistry = new ActivitiAPIRegistry(restClient);
        }
        return activitiApiRegistry;
    }

    @Override
    public DatabaseTablesAPI getDatabaseTablesAPI()
    {
        return activitiApiRegistry.getDatabaseTablesAPI();
    }

    @Override
    public DeploymentsAPI getDeploymentsAPI()
    {
        return activitiApiRegistry.getDeploymentsAPI();
    }

    @Override
    public EngineAPI geEngineAPI()
    {
        return activitiApiRegistry.geEngineAPI();
    }

    @Override
    public ExecutionsAPI getExecutionsAPI()
    {
        return activitiApiRegistry.getExecutionsAPI();
    }

    @Override
    public FormsAPI getFormsAPI()
    {
        return activitiApiRegistry.getFormsAPI();
    }

    @Override
    public GroupsAPI getGroupsAPI()
    {
        return activitiApiRegistry.getGroupsAPI();
    }

    @Override
    public HistoryAPI getHistoryAPI()
    {
        return activitiApiRegistry.getHistoryAPI();
    }

    @Override
    public JobsAPI getJobsAPI()
    {
        return activitiApiRegistry.getJobsAPI();
    }

    @Override
    public ModelsAPI getModelsAPI()
    {
        return activitiApiRegistry.getModelsAPI();
    }

    @Override
    public ProcessDefinitionsAPI getProcessDefinitionsAPI()
    {
        return activitiApiRegistry.getProcessDefinitionsAPI();
    }

    @Override
    public ProcessInstancesAPI getProcessInstancesAPI()
    {
        return activitiApiRegistry.getProcessInstancesAPI();
    }

    @Override
    public RuntimeAPI getRuntimeAPI()
    {
        return activitiApiRegistry.getRuntimeAPI();
    }

    @Override
    public TasksAPI getTasksAPI()
    {
        return activitiApiRegistry.getTasksAPI();
    }

    @Override
    public UsersAPI getUsersAPI()
    {
        return activitiApiRegistry.getUsersAPI();
    }

    // ///////////////////////////////////////////////////////////////////////////
    // BUILDER
    // ///////////////////////////////////////////////////////////////////////////
    public static class Builder extends ServicesClient.Builder<ActivitiClient>
    {

        @Override
        public String getUSerAgent()
        {
            return "Alfresco-Activiti-Client/" + Version.SDK;
        }

        @Override
        public ActivitiClient create(RestClient restClient, OkHttpClient okHttpClient)
        {
            ActivitiClient client = new ActivitiClient(new RestClient(endpoint, retrofit, username), okHttpClient);
            client.getPSAPIRegistry();
            return client;
        }

        @Override
        public GsonBuilder getDefaultGsonBuilder()
        {
            GsonBuilder builder = new GsonBuilder().setDateFormat(ISO8601Utils.DATE_ISO_FORMAT);

            registerDefaultConfig(builder);

            return builder;
        }

        // BUILD
        // ///////////////////////////////////////////////////////////////////////////
        public ActivitiClient build()
        {
            // Create Client
            mInstance = super.build();
            return mInstance;
        }
    }

    // ///////////////////////////////////////////////////////////////////////////
    // UTILS
    // ///////////////////////////////////////////////////////////////////////////
    public static GsonBuilder registerDefaultConfig(GsonBuilder builder)
    {

        return builder;
    }
}
