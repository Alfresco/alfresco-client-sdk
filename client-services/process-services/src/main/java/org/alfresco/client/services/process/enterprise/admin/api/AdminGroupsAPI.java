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

import static org.alfresco.client.services.process.enterprise.ProcessServicesConstant.PROCESS_SERVICE_PATH;
import static org.alfresco.client.services.process.enterprise.common.constant.RequestConstant.*;

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
    @GET(PROCESS_SERVICE_PATH + "/admin/groups")
    Call<List<LightGroupRepresentation>> getGroupsCall(@Query(TENANT_ID) String tenantId,
            @Query(FUNCTIONAL) String functional, @Query(SUMMARY) String summary);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/groups")
    Call<GroupRepresentation> createNewGroupCall(@Body GroupRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}")
    Call<LightGroupRepresentation> getGroupCall(@Path(GROUP_ID) String groupId,
            @Query("includeAllUsers") String includeAllUsers, @Query(SUMMARY) String summary);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}")
    Call<GroupRepresentation> updateGroupCall(@Path(GROUP_ID) String groupId,
            @Body GroupRepresentation representation);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}")
    Call<Void> deleteGroupCall(@Path(GROUP_ID) String groupId, @Query(TENANT_ID) String tenantId);

    // GROUPS CAPABILITIES
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/potential-capabilities")
    Call<List<String>> getCapabilitiesCall(@Path(GROUP_ID) String groupId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/capabilities")
    Call<Void> addGroupCapabilitiesCall(@Path(GROUP_ID) String groupId,
            @Body AddGroupCapabilitiesRepresentation addGroupCapabilitiesRepresentation);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/capabilities/{groupCapabilityId}")
    Call<Void> addGroupCapabilitiesCall(@Path(GROUP_ID) String groupId,
            @Path(GROUP_CAPABILITY_ID) String groupCapabilityId);

    // RELATED GROUPS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/related-groups")
    Call<List<LightGroupRepresentation>> getRelatedGroupsCall(@Path(GROUP_ID) String groupId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/related-groups/{relatedGroupId}")
    Call<Void> addRelatedGroupCall(@Path(GROUP_ID) String groupId, @Path(RELATED_GROUP_ID) String relatedGroupId);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/related-groups/{relatedGroupId}")
    Call<Void> deleteRelatedGroupCall(@Path(GROUP_ID) String groupId, @Path(RELATED_GROUP_ID) String relatedGroupId);

    // GROUPS ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @POST(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/action/activate")
    Call<Void> activateGroupCall(@Path(GROUP_ID) String groupId);

    // MEMBERS
    // ///////////////////////////////////////////////////////////////////
    @POST(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/add-all-users")
    Call<Void> addAllUsersToGroupCall(@Path(GROUP_ID) String groupId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/users}")
    Call<ResultList<LightUserRepresentation>> getGroupMembersCall(@Path(GROUP_ID) String groupId,
            @Query(FILTER) String filter, @Query(PAGE) String page, @Query(PAGE_SIZE) String pageSize);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/members/{userId}")
    Call<Void> addGroupMemberCall(@Path(GROUP_ID) String groupId, @Path("userId") String userId);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/members/{userId}")
    Call<Void> deleteGroupMemberCall(@Path(GROUP_ID) String groupId, @Path("userId") String userId);

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
    @GET(PROCESS_SERVICE_PATH + "/admin/groups")
    Observable<List<LightGroupRepresentation>> getGroupsObservable(@Query(TENANT_ID) String tenantId,
            @Query(FUNCTIONAL) String functional, @Query(SUMMARY) String summary);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/groups")
    Observable<GroupRepresentation> createNewGroupObservable(@Body GroupRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}")
    Observable<LightGroupRepresentation> getGroupObservable(@Path(GROUP_ID) String groupId,
            @Query("includeAllUsers") String includeAllUsers, @Query(SUMMARY) String summary);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}")
    Observable<GroupRepresentation> updateGroupObservable(@Path(GROUP_ID) String groupId,
            @Body GroupRepresentation representation);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}")
    Observable<Void> deleteGroupObservable(@Path(GROUP_ID) String groupId, @Query(TENANT_ID) String tenantId);

    // GROUPS CAPABILITIES
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/potential-capabilities")
    Observable<List<String>> getCapabilitiesObservable(@Path(GROUP_ID) String groupId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/capabilities")
    Observable<Void> addGroupCapabilitiesObservable(@Path(GROUP_ID) String groupId,
            @Body AddGroupCapabilitiesRepresentation addGroupCapabilitiesRepresentation);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/capabilities/{groupCapabilityId}")
    Observable<Void> addGroupCapabilitiesObservable(@Path(GROUP_ID) String groupId,
            @Path(GROUP_CAPABILITY_ID) String groupCapabilityId);

    // RELATED GROUPS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/related-groups")
    Observable<List<LightGroupRepresentation>> getRelatedGroupsObservable(@Path(GROUP_ID) String groupId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/related-groups/{relatedGroupId}")
    Observable<Void> addRelatedGroupObservable(@Path(GROUP_ID) String groupId,
            @Path(RELATED_GROUP_ID) String relatedGroupId);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/related-groups/{relatedGroupId}")
    Observable<Void> deleteRelatedGroupObservable(@Path(GROUP_ID) String groupId,
            @Path(RELATED_GROUP_ID) String relatedGroupId);

    // GROUPS ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @POST(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/action/activate")
    Observable<Void> activateGroupObservable(@Path(GROUP_ID) String groupId);

    // MEMBERS
    // ///////////////////////////////////////////////////////////////////
    @POST(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/add-all-users")
    Observable<Void> addAllUsersToGroupObservable(@Path(GROUP_ID) String groupId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/users}")
    Observable<ResultList<LightUserRepresentation>> getGroupMembersObservable(@Path(GROUP_ID) String groupId,
            @Query(FILTER) String filter, @Query(PAGE) String page, @Query(PAGE_SIZE) String pageSize);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/members/{userId}")
    Observable<Void> addGroupMemberObservable(@Path(GROUP_ID) String groupId, @Path("userId") String userId);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/groups/{groupId}/members/{userId}")
    Observable<Void> deleteGroupMemberObservable(@Path(GROUP_ID) String groupId, @Path("userId") String userId);

}
