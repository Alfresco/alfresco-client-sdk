/*
 *  Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *  This file is part of Alfresco Activiti Client.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.alfresco.client.services.process.enterprise.admin.api;

import java.util.List;

import org.alfresco.client.services.process.enterprise.admin.model.body.AddGroupCapabilitiesRepresentation;
import org.alfresco.client.services.process.enterprise.common.model.representation.ResultList;
import org.alfresco.client.services.process.enterprise.core.model.idm.GroupRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.idm.LightGroupRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.idm.LightUserRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 *
 */
public interface AdminGroupsAPI
{
    // GROUPS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/groups")
    Call<List<LightGroupRepresentation>> getGroupsCall(@Query("tenantId") String tenantId,
            @Query("functional") String functional, @Query("summary") String summary);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups")
    Call<GroupRepresentation> createNewGroupCall(@Body GroupRepresentation representation);

    @GET("api/enterprise/admin/groups/{groupId}")
    Call<LightGroupRepresentation> getGroupCall(@Path("groupId") String groupId,
            @Query("includeAllUsers") String includeAllUsers, @Query("summary") String summary);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/admin/groups/{groupId}")
    Call<GroupRepresentation> updateGroupCall(@Path("groupId") String groupId,
            @Body GroupRepresentation representation);

    @DELETE("api/enterprise/admin/groups/{groupId}")
    Call<Void> deleteGroupCall(@Path("groupId") String groupId, @Query("tenantId") String tenantId);

    // GROUPS CAPABILITIES
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/groups/{groupId}/potential-capabilities")
    Call<List<String>> getCapabilitiesCall(@Path("groupId") String groupId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/capabilities")
    Call<Void> addGroupCapabilitiesCall(@Path("groupId") String groupId,
            @Body AddGroupCapabilitiesRepresentation addGroupCapabilitiesRepresentation);

    @DELETE("api/enterprise/admin/groups/{groupId}/capabilities/{groupCapabilityId}")
    Call<Void> addGroupCapabilitiesCall(@Path("groupId") String groupId,
            @Path("groupCapabilityId") String groupCapabilityId);

    // RELATED GROUPS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/groups/{groupId}/related-groups")
    Call<List<LightGroupRepresentation>> getRelatedGroupsCall(@Path("groupId") String groupId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/related-groups/{relatedGroupId}")
    Call<Void> addRelatedGroupCall(@Path("groupId") String groupId, @Path("relatedGroupId") String relatedGroupId);

    @DELETE("api/enterprise/admin/groups/{groupId}/related-groups/{relatedGroupId}")
    Call<Void> deleteRelatedGroupCall(@Path("groupId") String groupId, @Path("relatedGroupId") String relatedGroupId);

    // GROUPS ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @POST("api/enterprise/admin/groups/{groupId}/action/activate")
    Call<Void> activateGroupCall(@Path("groupId") String groupId);

    // MEMBERS
    // ///////////////////////////////////////////////////////////////////
    @POST("api/enterprise/admin/groups/{groupId}/add-all-users")
    Call<Void> addAllUsersToGroupCall(@Path("groupId") String groupId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/users}")
    Call<ResultList<LightUserRepresentation>> getGroupMembersCall(@Path("groupId") String groupId,
            @Query("filter") String filter, @Query("page") String page, @Query("pageSize") String pageSize);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/members/{userId}")
    Call<Void> addGroupMemberCall(@Path("groupId") String groupId, @Path("userId") String userId);

    @DELETE("api/enterprise/admin/groups/{groupId}/members/{userId}")
    Call<Void> deleteGroupMemberCall(@Path("groupId") String groupId, @Path("userId") String userId);

    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////

    // GROUPS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/groups")
    Observable<List<LightGroupRepresentation>> getGroupsObservable(@Query("tenantId") String tenantId,
            @Query("functional") String functional, @Query("summary") String summary);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups")
    Observable<GroupRepresentation> createNewGroupObservable(@Body GroupRepresentation representation);

    @GET("api/enterprise/admin/groups/{groupId}")
    Observable<LightGroupRepresentation> getGroupObservable(@Path("groupId") String groupId,
            @Query("includeAllUsers") String includeAllUsers, @Query("summary") String summary);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/admin/groups/{groupId}")
    Observable<GroupRepresentation> updateGroupObservable(@Path("groupId") String groupId,
            @Body GroupRepresentation representation);

    @DELETE("api/enterprise/admin/groups/{groupId}")
    Observable<Void> deleteGroupObservable(@Path("groupId") String groupId, @Query("tenantId") String tenantId);

    // GROUPS CAPABILITIES
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/groups/{groupId}/potential-capabilities")
    Observable<List<String>> getCapabilitiesObservable(@Path("groupId") String groupId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/capabilities")
    Observable<Void> addGroupCapabilitiesObservable(@Path("groupId") String groupId,
            @Body AddGroupCapabilitiesRepresentation addGroupCapabilitiesRepresentation);

    @DELETE("api/enterprise/admin/groups/{groupId}/capabilities/{groupCapabilityId}")
    Observable<Void> addGroupCapabilitiesObservable(@Path("groupId") String groupId,
            @Path("groupCapabilityId") String groupCapabilityId);

    // RELATED GROUPS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/groups/{groupId}/related-groups")
    Observable<List<LightGroupRepresentation>> getRelatedGroupsObservable(@Path("groupId") String groupId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/related-groups/{relatedGroupId}")
    Observable<Void> addRelatedGroupObservable(@Path("groupId") String groupId,
            @Path("relatedGroupId") String relatedGroupId);

    @DELETE("api/enterprise/admin/groups/{groupId}/related-groups/{relatedGroupId}")
    Observable<Void> deleteRelatedGroupObservable(@Path("groupId") String groupId,
            @Path("relatedGroupId") String relatedGroupId);

    // GROUPS ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @POST("api/enterprise/admin/groups/{groupId}/action/activate")
    Observable<Void> activateGroupObservable(@Path("groupId") String groupId);

    // MEMBERS
    // ///////////////////////////////////////////////////////////////////
    @POST("api/enterprise/admin/groups/{groupId}/add-all-users")
    Observable<Void> addAllUsersToGroupObservable(@Path("groupId") String groupId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/users}")
    Observable<ResultList<LightUserRepresentation>> getGroupMembersObservable(@Path("groupId") String groupId,
            @Query("filter") String filter, @Query("page") String page, @Query("pageSize") String pageSize);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/members/{userId}")
    Observable<Void> addGroupMemberObservable(@Path("groupId") String groupId, @Path("userId") String userId);

    @DELETE("api/enterprise/admin/groups/{groupId}/members/{userId}")
    Observable<Void> deleteGroupMemberObservable(@Path("groupId") String groupId, @Path("userId") String userId);

}
