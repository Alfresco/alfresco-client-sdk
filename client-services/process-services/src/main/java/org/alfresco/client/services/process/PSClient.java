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

package org.alfresco.client.services.process;

import org.alfresco.client.Version;
import org.alfresco.client.services.common.RestClient;
import org.alfresco.client.services.common.ServicesClient;
import org.alfresco.client.services.common.utils.ISO8601Utils;
import org.alfresco.client.services.process.enterprise.admin.api.AdminEndpointsAPI;
import org.alfresco.client.services.process.enterprise.admin.api.AdminGroupsAPI;
import org.alfresco.client.services.process.enterprise.admin.api.AdminTenantsAPI;
import org.alfresco.client.services.process.enterprise.admin.api.AdminUsersAPI;
import org.alfresco.client.services.process.enterprise.core.api.*;
import org.alfresco.client.services.process.enterprise.discovery.api.DiscoveryAPI;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;

public class PSClient extends ServicesClient<PSClient> implements ProcessServicesRegistry
{
    protected static final Object LOCK = new Object();

    protected static PSClient mInstance;

    protected PSAPIRegistry psapiRegistry;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    // ///////////////////////////////////////////////////////////////////////////
    public static PSClient getInstance()
    {
        synchronized (LOCK)
        {
            return mInstance;
        }
    }

    private PSClient(RestClient restClient, OkHttpClient okHttpClient)
    {
        super(restClient, okHttpClient);
    }

    // ///////////////////////////////////////////////////////////////////////////
    // API REGISTRY
    // ///////////////////////////////////////////////////////////////////////////
    public PSAPIRegistry getPSAPIRegistry()
    {
        if (psapiRegistry == null)
        {
            psapiRegistry = new PSAPIRegistry(restClient);
        }
        return psapiRegistry;
    }

    public DiscoveryAPI getDiscoveryAPI()
    {
        return psapiRegistry.getDiscoveryAPI();
    }

    @Override
    public AdminUsersAPI geAdminUsersAPI()
    {
        return psapiRegistry.geAdminUsersAPI();
    }

    @Override
    public AdminEndpointsAPI getAdminEndpointsAPI()
    {
        return psapiRegistry.getAdminEndpointsAPI();
    }

    @Override
    public AdminTenantsAPI getAdminTenantsAPI()
    {
        return psapiRegistry.getAdminTenantsAPI();
    }

    @Override
    public AdminGroupsAPI getAdminGroupsAPI()
    {
        return psapiRegistry.getAdminGroupsAPI();
    }

    public ContentsAPI getContentsAPI()
    {
        return psapiRegistry.getContentsAPI();
    }

    @Override
    public ModelsAPI getModelsAPI()
    {
        return psapiRegistry.getModelsAPI();
    }

    public ProcessDefinitionsAPI getProcessDefinitionsAPI()
    {
        return psapiRegistry.getProcessDefinitionsAPI();
    }

    public ProcessInstancesAPI getProcessInstancesAPI()
    {
        return psapiRegistry.getProcessInstancesAPI();
    }

    @Override
    public UserProfileAPI getProfileAPI()
    {
        return psapiRegistry.getProfileAPI();
    }

    public RuntimeAppDefinitionsAPI getRuntimeAppDefinitionsAPI()
    {
        return psapiRegistry.getRuntimeAppDefinitionsAPI();
    }

    public TasksAPI getTasksAPI()
    {
        return psapiRegistry.getTasksAPI();
    }

    @Override
    public UserFiltersAPI getUserFiltersAPI()
    {
        return psapiRegistry.getUserFiltersAPI();
    }

    public UsersGroupsAPI getUsersGroupsAPI()
    {
        return psapiRegistry.getUsersGroupsAPI();
    }

    @Override
    public AppDefinitionsAPI getAppDefinitionsAPI()
    {
        return psapiRegistry.getAppDefinitionsAPI();
    }

    // ///////////////////////////////////////////////////////////////////////////
    // BUILDER
    // ///////////////////////////////////////////////////////////////////////////
    public static class Builder extends ServicesClient.Builder<PSClient>
    {

        @Override
        public String getUSerAgent()
        {
            return "Alfresco-PS-Client/" + Version.SDK;
        }

        @Override
        public PSClient create(RestClient restClient, OkHttpClient okHttpClient)
        {
            PSClient client = new PSClient(new RestClient(endpoint, retrofit, username), okHttpClient);
            client.getPSAPIRegistry();
            return client;
        }

        @Override
        public GsonBuilder getDefaultGsonBuilder()
        {
            GsonBuilder builder = new GsonBuilder().setDateFormat(ISO8601Utils.DATE_ISO_FORMAT);

            registerDefaultConfig(builder);
            PSGsonBuilder.registerPSConfig(builder);

            return builder;
        }

        // BUILD
        // ///////////////////////////////////////////////////////////////////////////
        public PSClient build()
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
