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

package com.alfresco.client;

import com.alfresco.client.api.authentication.AuthenticationAPI;
import com.alfresco.client.api.authentication.representation.TicketRepresentation;
import com.alfresco.client.api.authentication.representation.ValidTicketRepresentation;
import com.alfresco.client.api.common.deserializer.EntryDeserializer;
import com.alfresco.client.api.common.deserializer.PagingDeserializer;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.*;
import com.alfresco.client.api.core.model.deserializer.FavoriteEntryDeserializer;
import com.alfresco.client.api.core.model.representation.*;
import com.alfresco.client.api.discovery.DiscoveryAPI;
import com.alfresco.client.api.discovery.model.RepositoryInfoRepresentation;
import com.alfresco.client.api.search.SearchAPI;
import com.alfresco.client.api.search.deserializer.ResultSetPagingDeserializer;
import com.alfresco.client.api.search.model.ResultNodeRepresentation;
import com.alfresco.client.api.search.model.ResultSetRepresentation;
import com.alfresco.client.utils.ISO8601Utils;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import okhttp3.OkHttpClient;

public class AlfrescoClient extends AbstractClient<AlfrescoClient>
{
    protected static final Object LOCK = new Object();

    protected static AlfrescoClient mInstance;

    protected ActivitiesAPI activitiesAPI;

    protected CommentsAPI commentsAPI;

    protected NodesAPI nodesAPI;

    protected PeopleAPI peopleAPI;

    protected QueriesAPI queriesAPI;

    protected RatingsAPI ratingsAPI;

    protected RenditionsAPI renditionsAPI;

    protected SharedLinksAPI sharedLinksAPI;

    protected SitesAPI sitesAPI;

    protected TagsAPI tagsAPI;

    protected TrashcanAPI trashcanAPI;

    protected FavoritesAPI favoritesAPI;

    protected DiscoveryAPI discoveryAPI;

    protected AuthenticationAPI authenticationAPI;

    protected SearchAPI searchAPI;

    // protected GroupsAPI groupsAPI;

    protected VersionAPI versionAPI;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    // ///////////////////////////////////////////////////////////////////////////
    public static AlfrescoClient getInstance()
    {
        synchronized (LOCK)
        {
            return mInstance;
        }
    }

    private AlfrescoClient(RestClient restClient, OkHttpClient okHttpClient)
    {
        super(restClient, okHttpClient);
    }

    // ///////////////////////////////////////////////////////////////////////////
    // API REGISTRY
    // ///////////////////////////////////////////////////////////////////////////
    public ActivitiesAPI getActivitiesAPI()
    {
        if (activitiesAPI == null)
        {
            activitiesAPI = getAPI(ActivitiesAPI.class);
        }
        return activitiesAPI;
    }

    public CommentsAPI getCommentsAPI()
    {
        if (commentsAPI == null)
        {
            commentsAPI = getAPI(CommentsAPI.class);
        }
        return commentsAPI;
    }

    public FavoritesAPI getFavoritesAPI()
    {
        if (favoritesAPI == null)
        {
            favoritesAPI = getAPI(FavoritesAPI.class);
        }
        return favoritesAPI;
    }

    public NodesAPI getNodesAPI()
    {
        if (nodesAPI == null)
        {
            nodesAPI = getAPI(NodesAPI.class);
        }
        return nodesAPI;
    }

    public PeopleAPI getPeopleAPI()
    {
        if (peopleAPI == null)
        {
            peopleAPI = getAPI(PeopleAPI.class);
        }
        return peopleAPI;
    }

    public RatingsAPI getRatingsAPI()
    {
        if (ratingsAPI == null)
        {
            ratingsAPI = getAPI(RatingsAPI.class);
        }
        return ratingsAPI;
    }

    public SitesAPI getSitesAPI()
    {
        if (sitesAPI == null)
        {
            sitesAPI = getAPI(SitesAPI.class);
        }
        return sitesAPI;
    }

    public TagsAPI getTagsAPI()
    {
        if (tagsAPI == null)
        {
            tagsAPI = getAPI(TagsAPI.class);
        }
        return tagsAPI;
    }

    public QueriesAPI getQueriesAPI()
    {
        if (queriesAPI == null)
        {
            queriesAPI = getAPI(QueriesAPI.class);
        }
        return queriesAPI;
    }

    public RenditionsAPI getRenditionsAPI()
    {
        if (renditionsAPI == null)
        {
            renditionsAPI = getAPI(RenditionsAPI.class);
        }
        return renditionsAPI;
    }

    public SharedLinksAPI getSharedLinksAPI()
    {
        if (sharedLinksAPI == null)
        {
            sharedLinksAPI = getAPI(SharedLinksAPI.class);
        }
        return sharedLinksAPI;
    }

    public TrashcanAPI getTrashcanAPI()
    {
        if (trashcanAPI == null)
        {
            trashcanAPI = getAPI(TrashcanAPI.class);
        }
        return trashcanAPI;
    }

    public DiscoveryAPI getDiscoveryAPI()
    {
        if (discoveryAPI == null)
        {
            discoveryAPI = getAPI(DiscoveryAPI.class);
        }
        return discoveryAPI;
    }

    public AuthenticationAPI getAuthenticationAPI()
    {
        if (authenticationAPI == null)
        {
            authenticationAPI = getAPI(AuthenticationAPI.class);
        }
        return authenticationAPI;
    }

    public SearchAPI getSearchAPI()
    {
        if (searchAPI == null)
        {
            searchAPI = getAPI(SearchAPI.class);
        }
        return searchAPI;
    }

    // Not implemented
    /*
     * public GroupsAPI getGroupsAPI() { if (groupsAPI == null) { groupsAPI =
     * getAPI(GroupsAPI.class); } return groupsAPI; }
     */

    public VersionAPI getVersionAPI()
    {
        if (versionAPI == null)
        {
            versionAPI = getAPI(VersionAPI.class);
        }
        return versionAPI;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // AUTHENTICATION
    // ///////////////////////////////////////////////////////////////////////////
    public void setTicket(String ticket)
    {

        OkHttpClient.Builder builder = getOkHttpClient().newBuilder();

        // Remove old interceptor
        int index = 0;
        for (int i = 0; i < builder.interceptors().size(); i++)
        {
            if (builder.interceptors().get(i) instanceof BasicAuthInterceptor
                    || builder.interceptors().get(i) instanceof TicketInterceptor)
            {
                index = i;
            }
        }

        builder.interceptors().remove(index);
        builder.interceptors().add(new TicketInterceptor(ticket));
        okHttpClient = builder.build();
    }

    // ///////////////////////////////////////////////////////////////////////////
    // BUILDER
    // ///////////////////////////////////////////////////////////////////////////
    public static class Builder extends AbstractClient.Builder<AlfrescoClient>
    {

        @Override
        public String getUSerAgent()
        {
            return "Alfresco-ECM-Client/" + Version.SDK;
        }

        @Override
        public AlfrescoClient create(RestClient restClient, OkHttpClient okHttpClient)
        {
            return new AlfrescoClient(new RestClient(endpoint, retrofit, username), okHttpClient);
        }

        @Override
        public GsonBuilder getDefaultGsonBuilder()
        {
            return Utils.getDefaultGsonBuilder();
        }

        // BUILD
        // ///////////////////////////////////////////////////////////////////////////
        public AlfrescoClient build()
        {
            // Create Client
            mInstance = super.build();
            return mInstance;
        }
    }

    // ///////////////////////////////////////////////////////////////////////////
    // UTILS
    // ///////////////////////////////////////////////////////////////////////////
    public static class Utils
    {
        public static GsonBuilder getDefaultGsonBuilder()
        {
            return new GsonBuilder().setDateFormat(ISO8601Utils.DATE_ISO_FORMAT)
                    // Entry
                    .registerTypeAdapter(ActivityRepresentation.class, new EntryDeserializer<ActivityRepresentation>())
                    .registerTypeAdapter(CommentRepresentation.class, new EntryDeserializer<CommentRepresentation>())
                    .registerTypeAdapter(SiteMemberRepresentation.class,
                            new EntryDeserializer<SiteMemberRepresentation>())
                    .registerTypeAdapter(NodeRepresentation.class, new EntryDeserializer<NodeRepresentation>())
                    .registerTypeAdapter(DeletedNodeRepresentation.class,
                            new EntryDeserializer<DeletedNodeRepresentation>())
                    .registerTypeAdapter(PreferenceRepresentation.class,
                            new EntryDeserializer<PreferenceRepresentation>())
                    .registerTypeAdapter(RatingRepresentation.class, new EntryDeserializer<RatingRepresentation>())
                    .registerTypeAdapter(PersonRepresentation.class, new EntryDeserializer<PersonRepresentation>())
                    .registerTypeAdapter(SharedLinkRepresentation.class,
                            new EntryDeserializer<SharedLinkRepresentation>())
                    .registerTypeAdapter(RenditionRepresentation.class,
                            new EntryDeserializer<RenditionRepresentation>())
                    .registerTypeAdapter(SiteContainerRepresentation.class,
                            new EntryDeserializer<SiteContainerRepresentation>())
                    .registerTypeAdapter(SiteRoleRepresentation.class, new EntryDeserializer<SiteRoleRepresentation>())
                    .registerTypeAdapter(SiteMembershipRequestRepresentation.class,
                            new EntryDeserializer<SiteMembershipRequestRepresentation>())
                    .registerTypeAdapter(SiteRepresentation.class, new EntryDeserializer<SiteRepresentation>())
                    .registerTypeAdapter(TagRepresentation.class, new EntryDeserializer<TagRepresentation>())
                    .registerTypeAdapter(VersionRepresentation.class, new EntryDeserializer<VersionRepresentation>())
                    .registerTypeAdapter(FavoriteRepresentation.class, new FavoriteEntryDeserializer())

                    // Paging Results
                    .registerTypeAdapter(new TypeToken<ResultPaging<ActivityRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(ActivityRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<CommentRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(CommentRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<SiteMemberRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(SiteMemberRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<SharedLinkRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(SharedLinkRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<NodeRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(NodeRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<DeletedNodeRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(DeletedNodeRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<PreferenceRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(PreferenceRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<FavoriteRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(FavoriteRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<RatingRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(RatingRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<RenditionRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(RenditionRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<SiteContainerRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(SiteContainerRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<SiteRoleRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(SiteRoleRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<SiteMembershipRequestRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(SiteMembershipRequestRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<SiteRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(SiteRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<TagRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(TagRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<VersionRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(VersionRepresentation.class))

                    // People API
                    .registerTypeAdapter(PersonRepresentation.class, new EntryDeserializer<PersonRepresentation>())
                    .registerTypeAdapter(new TypeToken<ResultPaging<PersonRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(PersonRepresentation.class))

                    // Groups API
                    .registerTypeAdapter(GroupRepresentation.class, new EntryDeserializer<GroupRepresentation>())
                    .registerTypeAdapter(GroupMemberRepresentation.class,
                            new EntryDeserializer<GroupMemberRepresentation>())

                    .registerTypeAdapter(new TypeToken<ResultPaging<GroupRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(GroupRepresentation.class))
                    .registerTypeAdapter(new TypeToken<ResultPaging<GroupMemberRepresentation>>()
                    {
                    }.getType(), new PagingDeserializer<>(GroupMemberRepresentation.class))

                    // Authentication
                    .registerTypeAdapter(TicketRepresentation.class, new EntryDeserializer<TicketRepresentation>())
                    .registerTypeAdapter(ValidTicketRepresentation.class,
                            new EntryDeserializer<ValidTicketRepresentation>())

                    // Discovery
                    .registerTypeAdapter(RepositoryInfoRepresentation.class,
                            new EntryDeserializer<RepositoryInfoRepresentation>())

                    // Search
                    .registerTypeAdapter(ResultNodeRepresentation.class,
                            new EntryDeserializer<ResultNodeRepresentation>())
                    .registerTypeAdapter(new TypeToken<ResultSetRepresentation<ResultNodeRepresentation>>()
                    {
                    }.getType(), new ResultSetPagingDeserializer<>(ResultNodeRepresentation.class))

            // Workflow

            ;
        }
    }
}
