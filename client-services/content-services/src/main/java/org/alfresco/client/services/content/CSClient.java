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

package org.alfresco.client.services.content;

import org.alfresco.client.Version;
import org.alfresco.client.services.common.RestClient;
import org.alfresco.client.services.common.ServicesClient;
import org.alfresco.client.services.common.utils.ISO8601Utils;
import org.alfresco.client.services.content.authentication.api.AuthenticationAPI;
import org.alfresco.client.services.content.core.api.*;
import org.alfresco.client.services.content.discovery.api.DiscoveryAPI;
import org.alfresco.client.services.content.search.api.SearchAPI;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;

public class CSClient extends ServicesClient<CSClient> implements ContentServicesRegistry
{
    protected static final Object LOCK = new Object();

    protected static CSClient mInstance;

    protected ContentServicesRegistry csAPIRegistry;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    // ///////////////////////////////////////////////////////////////////////////
    public static CSClient getInstance()
    {
        synchronized (LOCK)
        {
            return mInstance;
        }
    }

    private CSClient(RestClient restClient, OkHttpClient okHttpClient)
    {
        super(restClient, okHttpClient);
    }

    // ///////////////////////////////////////////////////////////////////////////
    // API REGISTRY
    // ///////////////////////////////////////////////////////////////////////////
    public ContentServicesRegistry getApiRegistry()
    {
        if (csAPIRegistry == null)
        {
            csAPIRegistry = new CSApiRegistry(restClient);
        }
        return csAPIRegistry;
    }

    @Override
    public ActivitiesAPI getActivitiesAPI()
    {
        return csAPIRegistry.getActivitiesAPI();
    }

    @Override
    public CommentsAPI getCommentsAPI()
    {
        return csAPIRegistry.getCommentsAPI();
    }

    @Override
    public FavoritesAPI getFavoritesAPI()
    {
        return csAPIRegistry.getFavoritesAPI();
    }

    @Override
    public NodesAPI getNodesAPI()
    {
        return csAPIRegistry.getNodesAPI();
    }

    @Override
    public PeopleAPI getPeopleAPI()
    {
        return csAPIRegistry.getPeopleAPI();
    }

    @Override
    public RatingsAPI getRatingsAPI()
    {
        return csAPIRegistry.getRatingsAPI();
    }

    @Override
    public SitesAPI getSitesAPI()
    {
        return csAPIRegistry.getSitesAPI();
    }

    @Override
    public TagsAPI getTagsAPI()
    {
        return csAPIRegistry.getTagsAPI();
    }

    @Override
    public QueriesAPI getQueriesAPI()
    {
        return csAPIRegistry.getQueriesAPI();
    }

    @Override
    public RenditionsAPI getRenditionsAPI()
    {
        return csAPIRegistry.getRenditionsAPI();
    }

    @Override
    public SharedLinksAPI getSharedLinksAPI()
    {
        return csAPIRegistry.getSharedLinksAPI();
    }

    @Override
    public TrashcanAPI getTrashcanAPI()
    {
        return csAPIRegistry.getTrashcanAPI();
    }

    @Override
    public VersionAPI getVersionAPI()
    {
        return csAPIRegistry.getVersionAPI();
    }

    @Override
    public DiscoveryAPI getDiscoveryAPI()
    {
        return csAPIRegistry.getDiscoveryAPI();
    }

    @Override
    public AuthenticationAPI getAuthenticationAPI()
    {
        return csAPIRegistry.getAuthenticationAPI();
    }

    @Override
    public SearchAPI getSearchAPI()
    {
        return csAPIRegistry.getSearchAPI();
    }

    @Override
    public NetworksAPI getNetworksAPI()
    {
        return csAPIRegistry.getNetworksAPI();
    }

    @Override
    public PreferencesAPI getPreferencesAPI()
    {
        return csAPIRegistry.getPreferencesAPI();
    }

    // ///////////////////////////////////////////////////////////////////////////
    // BUILDER
    // ///////////////////////////////////////////////////////////////////////////
    public static class Builder extends ServicesClient.Builder<CSClient>
    {

        @Override
        public String getUSerAgent()
        {
            return "Alfresco-Content-Client/" + Version.SDK;
        }

        @Override
        public CSClient create(RestClient restClient, OkHttpClient okHttpClient)
        {
            CSClient client = new CSClient(new RestClient(endpoint, retrofit, username), okHttpClient);
            client.getApiRegistry();
            return client;
        }

        @Override
        public GsonBuilder getDefaultGsonBuilder()
        {
            GsonBuilder builder = new GsonBuilder().setDateFormat(ISO8601Utils.DATE_ISO_FORMAT);

            registerDefaultConfig(builder);
            CSGsonBuilder.registerCSConfig(builder);

            return builder;
        }

        // BUILD
        // ///////////////////////////////////////////////////////////////////////////
        public CSClient build()
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
