package org.alfresco.client.services.content;

import org.alfresco.client.services.common.APIRegistry;
import org.alfresco.client.services.content.authentication.api.AuthenticationAPI;
import org.alfresco.client.services.content.core.api.*;
import org.alfresco.client.services.content.discovery.api.DiscoveryAPI;
import org.alfresco.client.services.content.search.api.SearchAPI;

/**
 * Created by jpascal on 30/04/2017.
 */
public interface ContentServicesRegistry extends APIRegistry
{
    ActivitiesAPI getActivitiesAPI();

    CommentsAPI getCommentsAPI();

    FavoritesAPI getFavoritesAPI();

    NodesAPI getNodesAPI();

    PeopleAPI getPeopleAPI();

    RatingsAPI getRatingsAPI();

    SitesAPI getSitesAPI();

    TagsAPI getTagsAPI();

    QueriesAPI getQueriesAPI();

    RenditionsAPI getRenditionsAPI();

    SharedLinksAPI getSharedLinksAPI();

    TrashcanAPI getTrashcanAPI();

    VersionAPI getVersionAPI();

    DiscoveryAPI getDiscoveryAPI();

    AuthenticationAPI getAuthenticationAPI();

    SearchAPI getSearchAPI();

    NetworksAPI getNetworksAPI();

    PreferencesAPI getPreferencesAPI();
}
