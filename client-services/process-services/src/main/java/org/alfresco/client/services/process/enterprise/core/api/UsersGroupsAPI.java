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

package org.alfresco.client.services.process.enterprise.core.api;

import static org.alfresco.client.services.process.enterprise.ProcessServicesConstant.PROCESS_SERVICE_PATH;

import org.alfresco.client.services.process.enterprise.common.model.representation.ResultList;
import org.alfresco.client.services.process.enterprise.core.model.idm.LightGroupRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.idm.LightUserRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.idm.UserActionRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.idm.UserRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 11/12/2014.
 */
public interface UsersGroupsAPI
{
    @GET(PROCESS_SERVICE_PATH + "/users/{userId}")
    Call<UserRepresentation> getUserCall(@Path("userId") String userId);

    @PUT(PROCESS_SERVICE_PATH + "/users/{userId}")
    Call<UserRepresentation> updateUserCall(@Path("userId") String userId, @Body UserRepresentation userRequest);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/users/{userId}")
    Call<Void> executeActionCall(@Path("userId") String userId, @Body UserActionRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/users")
    Call<ResultList<LightUserRepresentation>> getUsersCall(@Query("filter") String filter, @Query("email") String email,
            @Query("externalId") String externalId, @Query("excludeTaskId") String excludeTaskId,
            @Query("excludeProcessId") String excludeProcessId, @Query("groupId") String groupId,
            @Query("tenantId") String tenantId);

    @GET(PROCESS_SERVICE_PATH + "/users")
    Call<ResultList<LightUserRepresentation>> getUsersCall(@Query("filter") String filter);

    @GET(PROCESS_SERVICE_PATH + "/groups")
    Call<ResultList<LightGroupRepresentation>> getGroupsCall(@Query("filter") String filter,
            @Query("groupId") String groupId);

    @GET(PROCESS_SERVICE_PATH + "/groups/{groupId}/users")
    Call<ResultList<LightUserRepresentation>> getUsersForGroupCall(@Path("groupId") String groupId);

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

    @GET(PROCESS_SERVICE_PATH + "/users/{userId}")
    Observable<UserRepresentation> getUserObservable(@Path("userId") String userId);

    @PUT(PROCESS_SERVICE_PATH + "/users/{userId}")
    Observable<UserRepresentation> updateUserObservable(@Path("userId") String userId,
            @Body UserRepresentation userRequest);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/users/{userId}")
    Observable<Void> executeActionObservable(@Path("userId") String userId,
            @Body UserActionRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/users")
    Observable<ResultList<LightUserRepresentation>> getUsersObservable(@Query("filter") String filter,
            @Query("email") String email, @Query("externalId") String externalId,
            @Query("excludeTaskId") String excludeTaskId, @Query("excludeProcessId") String excludeProcessId,
            @Query("groupId") String groupId, @Query("tenantId") String tenantId);

    @GET(PROCESS_SERVICE_PATH + "/users")
    Observable<ResultList<LightUserRepresentation>> getUsersObservable(@Query("filter") String filter);

    @GET(PROCESS_SERVICE_PATH + "/groups")
    Observable<ResultList<LightGroupRepresentation>> getGroupsObservable(@Query("filter") String filter,
            @Query("groupId") String groupId);

    @GET(PROCESS_SERVICE_PATH + "/groups/{groupId}/users")
    Observable<ResultList<LightUserRepresentation>> getUsersForGroupObservable(@Path("groupId") String groupId);
}
