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

package org.alfresco.client.services.governance;

import org.alfresco.client.Version;
import org.alfresco.client.services.common.RestClient;
import org.alfresco.client.services.common.ServicesClient;
import org.alfresco.client.services.common.utils.ISO8601Utils;
import org.alfresco.client.services.governance.core.api.*;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;

public class GSClient extends ServicesClient<GSClient> implements GovernanceServicesRegistry
{
    protected static final Object LOCK = new Object();

    protected static GSClient mInstance;

    protected GSAPIRegistry GSAPIRegistry;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    // ///////////////////////////////////////////////////////////////////////////
    public static GSClient getInstance()
    {
        synchronized (LOCK)
        {
            return mInstance;
        }
    }

    private GSClient(RestClient restClient, OkHttpClient okHttpClient)
    {
        super(restClient, okHttpClient);
    }

    // ///////////////////////////////////////////////////////////////////////////
    // API REGISTRY
    // ///////////////////////////////////////////////////////////////////////////
    public GSAPIRegistry getGSAPIRegistry()
    {
        if (GSAPIRegistry == null)
        {
            GSAPIRegistry = new GSAPIRegistry(restClient);
        }
        return GSAPIRegistry;
    }

    @Override
    public GsSitesAPI getGsSitesAPI()
    {
        return GSAPIRegistry.getGsSitesAPI();
    }

    @Override
    public FilePlansAPI getFilePlansAPI()
    {
        return GSAPIRegistry.getFilePlansAPI();
    }

    @Override
    public RecordCategoriesAPI getRecordCategoriesAPI()
    {
        return GSAPIRegistry.getRecordCategoriesAPI();
    }

    @Override
    public RecordFoldersAPI getRecordFoldersAPI()
    {
        return GSAPIRegistry.getRecordFoldersAPI();
    }

    @Override
    public RecordsAPI getRecordsAPI()
    {
        return GSAPIRegistry.getRecordsAPI();
    }

    @Override
    public UnfiledContainersAPI getUnfiledContainersAPI()
    {
        return GSAPIRegistry.getUnfiledContainersAPI();
    }

    @Override
    public UnfiledRecordFoldersAPI getUnfiledRecordFoldersAPI()
    {
        return GSAPIRegistry.getUnfiledRecordFoldersAPI();
    }

    @Override
    public TransferContainersAPI getTransferContainersAPI()
    {
        return GSAPIRegistry.getTransferContainersAPI();
    }

    @Override
    public TransfersAPI getTransfersAPI()
    {
        return GSAPIRegistry.getTransfersAPI();
    }

    // ///////////////////////////////////////////////////////////////////////////
    // BUILDER
    // ///////////////////////////////////////////////////////////////////////////
    public static class Builder extends ServicesClient.Builder<GSClient>
    {

        @Override
        public String getUSerAgent()
        {
            return "Alfresco-Governance-Client/" + Version.SDK;
        }

        @Override
        public GSClient create(RestClient restClient, OkHttpClient okHttpClient)
        {
            GSClient client = new GSClient(new RestClient(endpoint, retrofit, username), okHttpClient);
            client.getGSAPIRegistry();
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
        public GSClient build()
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
        GSGsonBuilder.registerGSConfig(builder);
        return builder;
    }
}
