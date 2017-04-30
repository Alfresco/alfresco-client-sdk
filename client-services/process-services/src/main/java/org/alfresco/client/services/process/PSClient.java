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
import org.alfresco.client.services.process.core.api.*;

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

    @Override
    public AboutAPI getAboutAPI()
    {
        return psapiRegistry.getAboutAPI();
    }

    @Override
    public AdminAPI getAdmiAPI()
    {
        return psapiRegistry.getAdmiAPI();
    }

    @Override
    public ContentAPI getContentAPI()
    {
        return psapiRegistry.getContentAPI();
    }

    @Override
    public ModelsAPI getModelsAPI()
    {
        return psapiRegistry.getModelsAPI();
    }

    @Override
    public ProcessDefinitionAPI getProcessDefinitionAPI()
    {
        return psapiRegistry.getProcessDefinitionAPI();
    }

    @Override
    public ProcessInstanceAPI getProcessInstanceAPI()
    {
        return psapiRegistry.getProcessInstanceAPI();
    }

    @Override
    public ProfileAPI getProfileAPI()
    {
        return psapiRegistry.getProfileAPI();
    }

    @Override
    public RuntimeAppDefinitionAPI getRuntimeAppDefinitionAPI()
    {
        return psapiRegistry.getRuntimeAppDefinitionAPI();
    }

    @Override
    public TaskAPI getTaskAPI()
    {
        return psapiRegistry.getTaskAPI();
    }

    @Override
    public UserFiltersAPI getUserFiltersAPI()
    {
        return psapiRegistry.getUserFiltersAPI();
    }

    @Override
    public UserGroupAPI getUserGroupAPI()
    {
        return psapiRegistry.getUserGroupAPI();
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
