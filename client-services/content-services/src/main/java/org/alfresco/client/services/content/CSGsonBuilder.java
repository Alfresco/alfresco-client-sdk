package org.alfresco.client.services.content;

import org.alfresco.client.services.common.model.deserializer.EntryDeserializer;
import org.alfresco.client.services.common.model.deserializer.PagingDeserializer;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.authentication.model.representation.TicketRepresentation;
import org.alfresco.client.services.content.authentication.model.representation.ValidTicketRepresentation;
import org.alfresco.client.services.content.core.model.deserializer.DeletedNodeEntryDeserializer;
import org.alfresco.client.services.content.core.model.deserializer.FavoriteEntryDeserializer;
import org.alfresco.client.services.content.core.model.deserializer.NodeEntryDeserializer;
import org.alfresco.client.services.content.core.model.representation.*;
import org.alfresco.client.services.content.discovery.model.RepositoryInfoRepresentation;
import org.alfresco.client.services.content.search.deserializer.ResultSetPagingDeserializer;
import org.alfresco.client.services.content.search.model.ResultNodeRepresentation;
import org.alfresco.client.services.content.search.model.ResultSetRepresentation;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Created by jpascal on 30/04/2017.
 */
public class CSGsonBuilder
{
    public static GsonBuilder registerCSConfig(GsonBuilder builder)
    {

        return builder
                // Entry
                .registerTypeAdapter(ActivityRepresentation.class, new EntryDeserializer<ActivityRepresentation>())
                .registerTypeAdapter(CommentRepresentation.class, new EntryDeserializer<CommentRepresentation>())
                .registerTypeAdapter(SiteMemberRepresentation.class, new EntryDeserializer<SiteMemberRepresentation>())
                .registerTypeAdapter(NodeRepresentation.class, new NodeEntryDeserializer())
                .registerTypeAdapter(DeletedNodeRepresentation.class, new DeletedNodeEntryDeserializer())
                .registerTypeAdapter(PreferenceRepresentation.class, new EntryDeserializer<PreferenceRepresentation>())
                .registerTypeAdapter(RatingRepresentation.class, new EntryDeserializer<RatingRepresentation>())
                .registerTypeAdapter(PersonRepresentation.class, new EntryDeserializer<PersonRepresentation>())
                .registerTypeAdapter(SharedLinkRepresentation.class, new EntryDeserializer<SharedLinkRepresentation>())
                .registerTypeAdapter(RenditionRepresentation.class, new EntryDeserializer<RenditionRepresentation>())
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

                // Discovery
                .registerTypeAdapter(RepositoryInfoRepresentation.class,
                        new EntryDeserializer<RepositoryInfoRepresentation>())

                // Authentication
                .registerTypeAdapter(TicketRepresentation.class, new EntryDeserializer<TicketRepresentation>())
                .registerTypeAdapter(ValidTicketRepresentation.class,
                        new EntryDeserializer<ValidTicketRepresentation>())

                // Search
                .registerTypeAdapter(ResultNodeRepresentation.class, new EntryDeserializer<ResultNodeRepresentation>())
                .registerTypeAdapter(new TypeToken<ResultSetRepresentation<ResultNodeRepresentation>>()
                {
                }.getType(), new ResultSetPagingDeserializer<>(ResultNodeRepresentation.class));
    }
}
