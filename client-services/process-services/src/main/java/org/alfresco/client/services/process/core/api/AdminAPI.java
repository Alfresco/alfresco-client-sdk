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

package org.alfresco.client.services.process.core.api;

import java.util.List;

import org.alfresco.client.services.process.core.model.common.ImageUploadRepresentation;
import org.alfresco.client.services.process.core.model.common.ResultList;
import org.alfresco.client.services.process.core.model.editor.form.OptionRepresentation;
import org.alfresco.client.services.process.core.model.idm.*;
import org.alfresco.client.services.process.core.model.idm.request.AddGroupCapabilitiesRepresentation;
import org.alfresco.client.services.process.core.model.idm.request.BulkUserUpdateRepresentation;
import org.alfresco.client.services.process.core.model.idm.request.CreateEndpointBasicAuthRepresentation;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 *
 */
public interface AdminAPI
{
    // Only relevant way to know if user is an admin
    @GET("api/enterprise/admin/tenants")
    Call<ResponseBody> isAdmin();

    // ENDPOINTS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/endpoints")
    Call<List<OptionRepresentation>> getEndpointConfigurations(@Query("tenantId") String tenantId);

    @GET("api/enterprise/admin/endpoints")
    Observable<List<OptionRepresentation>> getEndpointConfigurationsObservable(@Query("tenantId") String tenantId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/endpoints")
    Call<EndpointConfigurationRepresentation> createEndpointConfiguration(
            @Body EndpointConfigurationRepresentation representation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/endpoints")
    Observable<EndpointConfigurationRepresentation> createEndpointConfigurationObservable(
            @Body EndpointConfigurationRepresentation representation);

    @GET("api/enterprise/admin/endpoints/{endpointConfigurationId}")
    Call<EndpointConfigurationRepresentation> createEndpointConfiguration(
            @Path("endpointConfigurationId") String endpointConfig, @Query("tenantId") String tenantId);

    @GET("api/enterprise/admin/endpoints/{endpointConfigurationId}")
    Observable<EndpointConfigurationRepresentation> createEndpointConfigurationObservable(
            @Path("endpointConfigurationId") String endpointConfig, @Query("tenantId") String tenantId);

    @PUT("api/enterprise/admin/endpoints/{endpointConfigurationId}")
    Call<EndpointConfigurationRepresentation> updateEndpointConfiguration(
            @Path("endpointConfigurationId") String endpointConfig,
            @Body EndpointConfigurationRepresentation representation);

    @PUT("api/enterprise/admin/endpoints/{endpointConfigurationId}")
    Observable<EndpointConfigurationRepresentation> updateEndpointConfigurationObservable(
            @Path("endpointConfigurationId") String endpointConfig,
            @Body EndpointConfigurationRepresentation representation);

    @DELETE("api/enterprise/admin/endpoints/{endpointConfigurationId}")
    Call<Void> removeEndpointConfiguration(@Path("endpointConfigurationId") String endpointConfig,
            @Query("tenantId") String tenantId);

    @DELETE("api/enterprise/admin/endpoints/{endpointConfigurationId}")
    Observable<Void> removeEndpointConfigurationObservable(@Path("endpointConfigurationId") String endpointConfig,
            @Query("tenantId") String tenantId);

    // BASIC AUTHS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/basic-auths")
    Call<List<EndpointBasicAuthRepresentation>> getBasicAuthConfigurations(@Query("tenantId") String tenantId);

    @GET("api/enterprise/admin/basic-auths")
    Observable<List<EndpointBasicAuthRepresentation>> getBasicAuthConfigurationsObservable(
            @Query("tenantId") String tenantId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/basic-auths")
    Call<EndpointBasicAuthRepresentation> createBasicAuthConfiguration(
            @Body CreateEndpointBasicAuthRepresentation representation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/basic-auths")
    Observable<EndpointBasicAuthRepresentation> createBasicAuthConfigurationObservable(
            @Body CreateEndpointBasicAuthRepresentation representation);

    @GET("api/enterprise/admin/basic-auths/{basicAuthId}")
    Call<EndpointConfigurationRepresentation> getBasicAuthConfiguration(@Path("basicAuthId") String basicAuthId,
            @Query("tenantId") String tenantId);

    @GET("api/enterprise/admin/basic-auths/{basicAuthId}")
    Observable<EndpointConfigurationRepresentation> getBasicAuthConfigurationObservable(
            @Path("basicAuthId") String basicAuthId, @Query("tenantId") String tenantId);

    @PUT("api/enterprise/admin/basic-auths/{basicAuthId}")
    Call<EndpointConfigurationRepresentation> updateBasicAuthConfiguration(@Path("basicAuthId") String basicAuthId,
            @Body CreateEndpointBasicAuthRepresentation representation);

    @PUT("api/enterprise/admin/basic-auths/{basicAuthId}")
    Observable<EndpointConfigurationRepresentation> updateBasicAuthConfigurationObservable(
            @Path("basicAuthId") String basicAuthId, @Body CreateEndpointBasicAuthRepresentation representation);

    @DELETE("api/enterprise/admin/basic-auths/{basicAuthId}")
    Call<Void> removeBasicAuthonfiguration(@Path("basicAuthId") String basicAuthId, @Query("tenantId") String tenantId);

    @DELETE("api/enterprise/admin/basic-auths/{basicAuthId}")
    Observable<Void> removeBasicAuthonfigurationObservable(@Path("basicAuthId") String basicAuthId,
            @Query("tenantId") String tenantId);

    // GROUPS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/groups")
    Call<List<LightGroupRepresentation>> getGroups(@Query("tenantId") String tenantId,
            @Query("functional") String functional, @Query("summary") String summary);

    @GET("api/enterprise/admin/groups")
    Observable<List<LightGroupRepresentation>> getGroupsObservable(@Query("tenantId") String tenantId,
            @Query("functional") String functional, @Query("summary") String summary);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups")
    Call<GroupRepresentation> createNewGroup(@Body GroupRepresentation representation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups")
    Observable<GroupRepresentation> createNewGroupObservable(@Body GroupRepresentation representation);

    @GET("api/enterprise/admin/groups/{groupId}")
    Call<LightGroupRepresentation> getGroup(@Path("groupId") String groupId,
            @Query("includeAllUsers") String includeAllUsers, @Query("summary") String summary);

    @GET("api/enterprise/admin/groups/{groupId}")
    Observable<LightGroupRepresentation> getGroupObservable(@Path("groupId") String groupId,
            @Query("includeAllUsers") String includeAllUsers, @Query("summary") String summary);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/admin/groups/{groupId}")
    Call<GroupRepresentation> updateGroup(@Path("groupId") String groupId, @Body GroupRepresentation representation);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/admin/groups/{groupId}")
    Observable<GroupRepresentation> updateGroupObservable(@Path("groupId") String groupId,
            @Body GroupRepresentation representation);

    @DELETE("api/enterprise/admin/groups/{groupId}")
    Call<Void> deleteGroup(@Path("groupId") String groupId, @Query("tenantId") String tenantId);

    @DELETE("api/enterprise/admin/groups/{groupId}")
    Observable<Void> deleteGroupObservable(@Path("groupId") String groupId, @Query("tenantId") String tenantId);

    // GROUPS CAPABILITIES
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/groups/{groupId}/potential-capabilities")
    Call<List<String>> getCapabilities(@Path("groupId") String groupId);

    @GET("api/enterprise/admin/groups/{groupId}/potential-capabilities")
    Observable<List<String>> getCapabilitiesObservable(@Path("groupId") String groupId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/capabilities")
    Call<Void> addGroupCapabilities(@Path("groupId") String groupId,
            @Body AddGroupCapabilitiesRepresentation addGroupCapabilitiesRepresentation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/capabilities")
    Observable<Void> addGroupCapabilitiesObservable(@Path("groupId") String groupId,
            @Body AddGroupCapabilitiesRepresentation addGroupCapabilitiesRepresentation);

    @DELETE("api/enterprise/admin/groups/{groupId}/capabilities/{groupCapabilityId}")
    Call<Void> addGroupCapabilities(@Path("groupId") String groupId,
            @Path("groupCapabilityId") String groupCapabilityId);

    @DELETE("api/enterprise/admin/groups/{groupId}/capabilities/{groupCapabilityId}")
    Observable<Void> addGroupCapabilitiesObservable(@Path("groupId") String groupId,
            @Path("groupCapabilityId") String groupCapabilityId);

    // RELATED GROUPS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/groups/{groupId}/related-groups")
    Call<List<LightGroupRepresentation>> getRelatedGroups(@Path("groupId") String groupId);

    @GET("api/enterprise/admin/groups/{groupId}/related-groups")
    Observable<List<LightGroupRepresentation>> getRelatedGroupsObservable(@Path("groupId") String groupId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/related-groups/{relatedGroupId}")
    Call<Void> addRelatedGroup(@Path("groupId") String groupId, @Path("relatedGroupId") String relatedGroupId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/related-groups/{relatedGroupId}")
    Observable<Void> addRelatedGroupObservable(@Path("groupId") String groupId,
            @Path("relatedGroupId") String relatedGroupId);

    @DELETE("api/enterprise/admin/groups/{groupId}/related-groups/{relatedGroupId}")
    Call<Void> deleteRelatedGroup(@Path("groupId") String groupId, @Path("relatedGroupId") String relatedGroupId);

    @DELETE("api/enterprise/admin/groups/{groupId}/related-groups/{relatedGroupId}")
    Observable<Void> deleteRelatedGroupObservable(@Path("groupId") String groupId,
            @Path("relatedGroupId") String relatedGroupId);

    // GROUPS ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @POST("api/enterprise/admin/groups/{groupId}/action/activate")
    Call<Void> activateGroup(@Path("groupId") String groupId);

    @POST("api/enterprise/admin/groups/{groupId}/action/activate")
    Observable<Void> activateGroupObservable(@Path("groupId") String groupId);

    // MEMBERS
    // ///////////////////////////////////////////////////////////////////
    @POST("api/enterprise/admin/groups/{groupId}/add-all-users")
    Call<Void> addAllUsersToGroup(@Path("groupId") String groupId);

    @POST("api/enterprise/admin/groups/{groupId}/add-all-users")
    Observable<Void> addAllUsersToGroupObservable(@Path("groupId") String groupId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/users}")
    Call<ResultList<LightUserRepresentation>> getGroupMembers(@Path("groupId") String groupId,
            @Query("filter") String filter, @Query("page") String page, @Query("pageSize") String pageSize);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/users}")
    Observable<ResultList<LightUserRepresentation>> getGroupMembersObservable(@Path("groupId") String groupId,
            @Query("filter") String filter, @Query("page") String page, @Query("pageSize") String pageSize);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/members/{userId}")
    Call<Void> addGroupMember(@Path("groupId") String groupId, @Path("userId") String userId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/groups/{groupId}/members/{userId}")
    Observable<Void> addGroupMemberObservable(@Path("groupId") String groupId, @Path("userId") String userId);

    @DELETE("api/enterprise/admin/groups/{groupId}/members/{userId}")
    Call<Void> deleteGroupMember(@Path("groupId") String groupId, @Path("userId") String userId);

    @DELETE("api/enterprise/admin/groups/{groupId}/members/{userId}")
    Observable<Void> deleteGroupMemberObservable(@Path("groupId") String groupId, @Path("userId") String userId);

    // TENANTS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/tenants")
    Call<List<LightTenantRepresentation>> getTenants();

    @GET("api/enterprise/admin/tenants")
    Observable<List<LightTenantRepresentation>> getTenantsObservable();

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/tenants")
    Call<LightTenantRepresentation> createTenant(@Body CreateTenantRepresentation createTenantRepresentation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/tenants")
    Observable<LightTenantRepresentation> createTenantObservable(
            @Body CreateTenantRepresentation createTenantRepresentation);

    @GET("api/enterprise/admin/tenants/{tenantId}")
    Call<LightTenantRepresentation> getTenant(@Path("tenantId") String tenantId);

    @GET("api/enterprise/admin/tenants/{tenantId}")
    Observable<LightTenantRepresentation> getTenantObservable(@Path("tenantId") String tenantId);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/admin/tenants/{tenantId}")
    Call<Void> updateTenant(@Path("tenantId") String tenantId,
            @Body CreateTenantRepresentation createTenantRepresentation);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/admin/tenants/{tenantId}")
    Observable<Void> updateTenantObservable(@Path("tenantId") String tenantId,
            @Body CreateTenantRepresentation createTenantRepresentation);

    @DELETE("api/enterprise/admin/tenants/{tenantId}")
    Call<Void> deleteTenant(@Path("tenantId") String tenantId);

    @DELETE("api/enterprise/admin/tenants/{tenantId}")
    Observable<Void> deleteTenantObservable(@Path("tenantId") String tenantId);

    @GET("api/enterprise/admin/tenants/{tenantId}/logo")
    Call<ResponseBody> getTenantLogo(@Path("tenantId") String tenantId);

    @GET("api/enterprise/admin/tenants/{tenantId}/logo")
    Observable<ResponseBody> getTenantLogoObservable(@Path("tenantId") String tenantId);

    @Multipart
    @POST("api/enterprise/admin/tenants/{tenantId}/logo")
    Call<ImageUploadRepresentation> uploadTenantLogo(@Path("tenantId") String tenantId, @Part("file") RequestBody body);

    @Multipart
    @POST("api/enterprise/admin/tenants/{tenantId}/logo")
    Observable<ImageUploadRepresentation> uploadTenantLogoObservable(@Path("tenantId") String tenantId,
            @Part("file") RequestBody body);

    @GET("api/enterprise/admin/tenants/{tenantId}/events")
    Call<List<TenantEvent>> getTenantEvents(@Path("tenantId") String tenantId);

    @GET("api/enterprise/admin/tenants/{tenantId}/events")
    Observable<List<TenantEvent>> getTenantEventsObservable(@Path("tenantId") String tenantId);

    // USERS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/users")
    Call<List<LightTenantRepresentation>> getUsers(@Query("filter") String filter, @Query("status") String status,
            @Query("accountType") String accountType, @Query("sort") String sort, @Query("company") String company,
            @Query("start") String start, @Query("page") String page, @Query("size") String size,
            @Query("groupId") String groupId, @Query("tenantId") String tenantId, @Query("summary") Boolean summary);

    @GET("api/enterprise/admin/users")
    Observable<List<LightTenantRepresentation>> getUsersObservable(@Query("filter") String filter,
            @Query("status") String status, @Query("accountType") String accountType, @Query("sort") String sort,
            @Query("company") String company, @Query("start") String start, @Query("page") String page,
            @Query("size") String size, @Query("groupId") String groupId, @Query("tenantId") String tenantId,
            @Query("summary") Boolean summary);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/users")
    Call<UserRepresentation> bulkUpdateUsers(@Body BulkUserUpdateRepresentation userRepresentation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/users")
    Observable<UserRepresentation> bulkUpdateUsersObservable(@Body BulkUserUpdateRepresentation userRepresentation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/users")
    Call<UserRepresentation> createNewUser(@Body UserRepresentation userRepresentation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/users")
    Observable<UserRepresentation> createNewUserObservable(@Body UserRepresentation userRepresentation);

    @GET("api/enterprise/admin/users/{userId}")
    Call<UserRepresentation> getUser(@Path("userId") String userId, @Query("summary") Boolean summary);

    @GET("api/enterprise/admin/users/{userId}")
    Observable<UserRepresentation> getUserObservable(@Path("userId") String userId, @Query("summary") Boolean summary);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/admin/users/{userId}")
    Call<UserRepresentation> updateUserDetails(@Path("userId") String tenantId,
            @Body UserRepresentation userRepresentation);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/admin/users/{userId}")
    Observable<UserRepresentation> updateUserDetailsObservable(@Path("userId") String tenantId,
            @Body UserRepresentation userRepresentation);

}
