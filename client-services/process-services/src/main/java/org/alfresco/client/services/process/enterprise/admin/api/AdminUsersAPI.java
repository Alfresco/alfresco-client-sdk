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

import org.alfresco.client.services.process.enterprise.admin.model.body.BulkUserUpdateRepresentation;
import org.alfresco.client.services.process.enterprise.admin.model.representation.LightTenantRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.idm.UserRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 *
 */
public interface AdminUsersAPI
{
    // USERS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/users")
    Call<List<LightTenantRepresentation>> getUsersCall(@Query("filter") String filter, @Query("status") String status,
            @Query("accountType") String accountType, @Query("sort") String sort, @Query("company") String company,
            @Query("start") String start, @Query("page") String page, @Query("size") String size,
            @Query("groupId") String groupId, @Query("tenantId") String tenantId, @Query("summary") Boolean summary);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/users")
    Call<UserRepresentation> bulkUpdateUsersCall(@Body BulkUserUpdateRepresentation userRepresentation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/users")
    Call<UserRepresentation> createNewUserCall(@Body UserRepresentation userRepresentation);

    @GET("api/enterprise/admin/users/{userId}")
    Call<UserRepresentation> getUserCall(@Path("userId") String userId, @Query("summary") Boolean summary);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/admin/users/{userId}")
    Call<UserRepresentation> updateUserDetailsCall(@Path("userId") String tenantId,
            @Body UserRepresentation userRepresentation);

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

    // USERS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/users")
    Observable<List<LightTenantRepresentation>> getUsersObservable(@Query("filter") String filter,
            @Query("status") String status, @Query("accountType") String accountType, @Query("sort") String sort,
            @Query("company") String company, @Query("start") String start, @Query("page") String page,
            @Query("size") String size, @Query("groupId") String groupId, @Query("tenantId") String tenantId,
            @Query("summary") Boolean summary);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/users")
    Observable<UserRepresentation> bulkUpdateUsersObservable(@Body BulkUserUpdateRepresentation userRepresentation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/users")
    Observable<UserRepresentation> createNewUserObservable(@Body UserRepresentation userRepresentation);

    @GET("api/enterprise/admin/users/{userId}")
    Observable<UserRepresentation> getUserObservable(@Path("userId") String userId, @Query("summary") Boolean summary);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/admin/users/{userId}")
    Observable<UserRepresentation> updateUserDetailsObservable(@Path("userId") String tenantId,
            @Body UserRepresentation userRepresentation);

}
