package org.alfresco.client.services.content;

import org.alfresco.client.services.common.AbstractAPIRegistry;
import org.alfresco.client.services.common.RestClient;
import org.alfresco.client.services.content.authentication.api.AuthenticationAPI;
import org.alfresco.client.services.content.core.api.*;
import org.alfresco.client.services.content.discovery.api.DiscoveryAPI;
import org.alfresco.client.services.content.search.api.SearchAPI;

/**
 * Created by jpascal on 30/04/2017.
 */
public class CSApiRegistry extends AbstractAPIRegistry implements ContentServicesRegistry
{

    protected ActivitiesAPI activitiesAPI;

    protected CommentsAPI commentsAPI;

    protected NodesAPI nodesAPI;

    protected NetworksAPI networksAPI;

    protected PeopleAPI peopleAPI;

    protected QueriesAPI queriesAPI;

    protected RatingsAPI ratingsAPI;

    protected RenditionsAPI renditionsAPI;

    protected SharedLinksAPI sharedLinksAPI;

    protected SitesAPI sitesAPI;

    protected TagsAPI tagsAPI;

    protected TrashcanAPI trashcanAPI;

    protected FavoritesAPI favoritesAPI;

    protected VersionAPI versionAPI;

    protected DiscoveryAPI discoveryAPI;

    protected AuthenticationAPI authenticationAPI;

    protected SearchAPI searchAPI;

    protected PreferencesAPI preferencesAPI;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    // ///////////////////////////////////////////////////////////////////////////
    public CSApiRegistry(RestClient restClient)
    {
        this.restClient = restClient;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS
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

    public NetworksAPI getNetworksAPI()
    {
        if (networksAPI == null)
        {
            networksAPI = getAPI(NetworksAPI.class);
        }
        return networksAPI;
    }

    public PreferencesAPI getPreferencesAPI()
    {
        if (preferencesAPI == null)
        {
            preferencesAPI = getAPI(PreferencesAPI.class);
        }
        return preferencesAPI;
    }
}
