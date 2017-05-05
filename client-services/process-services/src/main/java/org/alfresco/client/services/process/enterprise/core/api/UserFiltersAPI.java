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
import static org.alfresco.client.services.process.enterprise.common.constant.RequestConstant.APP_ID;
import static org.alfresco.client.services.process.enterprise.common.constant.RequestConstant.USER_FILTER_ID;

import org.alfresco.client.services.process.enterprise.common.model.representation.ResultList;
import org.alfresco.client.services.process.enterprise.core.model.runtime.UserFilterOrderRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.runtime.UserProcessInstanceFilterRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.runtime.UserTaskFilterRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 *
 */
public interface UserFiltersAPI
{
    // TASK FILTER
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/filters/tasks")
    Call<ResultList<UserTaskFilterRepresentation>> getUserTaskFiltersCall(@Query(APP_ID) Long appId);

    @GET(PROCESS_SERVICE_PATH + "/filters/tasks/{userFilterId}")
    Call<UserTaskFilterRepresentation> getUserTaskFilterCall(@Path(USER_FILTER_ID) Long userFilterId);

    @POST(PROCESS_SERVICE_PATH + "/filters/tasks")
    Call<UserTaskFilterRepresentation> createUserTaskFilterCall(
            @Body UserTaskFilterRepresentation userTaskFilterRepresentation);

    @PUT(PROCESS_SERVICE_PATH + "/filters/tasks/{userFilterId}")
    Call<UserTaskFilterRepresentation> updateUserTaskFilterCall(@Path(USER_FILTER_ID) Long userFilterId,
            @Body UserTaskFilterRepresentation userTaskFilterRepresentation);

    @PUT(PROCESS_SERVICE_PATH + "/filters/tasks")
    Call<Void> orderUserTaskFiltersCall(@Body UserFilterOrderRepresentation filterOrderRepresentation);

    @DELETE(PROCESS_SERVICE_PATH + "/filters/tasks/{userFilterId}")
    Call<Void> deleteUserTaskFilterCall(@Path(USER_FILTER_ID) Long userFilterId);

    // PROCESS FILTER
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/filters/processes")
    Call<ResultList<UserProcessInstanceFilterRepresentation>> getUserProcessInstanceFiltersCall(
            @Query(APP_ID) Long appId);

    @GET(PROCESS_SERVICE_PATH + "/filters/processes/{userFilterId}")
    Call<UserProcessInstanceFilterRepresentation> getUserProcessInstanceFilterCall(
            @Path(USER_FILTER_ID) Long userFilterId);

    @POST(PROCESS_SERVICE_PATH + "/filters/processes")
    Call<UserProcessInstanceFilterRepresentation> createUserProcessInstanceFilterCall(
            @Body UserProcessInstanceFilterRepresentation userTaskFilterRepresentation);

    @PUT(PROCESS_SERVICE_PATH + "/filters/processes/{userFilterId}")
    Call<UserProcessInstanceFilterRepresentation> updateUserProcessInstanceFilterCall(
            @Path(USER_FILTER_ID) Long userFilterId,
            @Body UserProcessInstanceFilterRepresentation userTaskFilterRepresentation);

    @PUT(PROCESS_SERVICE_PATH + "/filters/processes")
    Call<Void> orderUserProcessInstanceFiltersCall(@Body UserFilterOrderRepresentation filterOrderRepresentation);

    @DELETE(PROCESS_SERVICE_PATH + "/filters/processes/{userFilterId}")
    Call<Void> deleteUserProcessInstanceFilterCall(@Path(USER_FILTER_ID) Long userFilterId);

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

    // TASK FILTER
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/filters/tasks")
    Observable<ResultList<UserTaskFilterRepresentation>> getUserTaskFiltersObservable(@Query(APP_ID) Long appId);

    @GET(PROCESS_SERVICE_PATH + "/filters/tasks/{userFilterId}")
    Observable<UserTaskFilterRepresentation> getUserTaskFilterObservable(@Path(USER_FILTER_ID) Long userFilterId);

    @POST(PROCESS_SERVICE_PATH + "/filters/tasks")
    Observable<UserTaskFilterRepresentation> createUserTaskFilterObservable(
            @Body UserTaskFilterRepresentation userTaskFilterRepresentation);

    @PUT(PROCESS_SERVICE_PATH + "/filters/tasks/{userFilterId}")
    Observable<UserTaskFilterRepresentation> updateUserTaskFilterObservable(@Path(USER_FILTER_ID) Long userFilterId,
            @Body UserTaskFilterRepresentation userTaskFilterRepresentation);

    @PUT(PROCESS_SERVICE_PATH + "/filters/tasks")
    Observable<Void> orderUserTaskFiltersObservable(@Body UserFilterOrderRepresentation filterOrderRepresentation);

    @DELETE(PROCESS_SERVICE_PATH + "/filters/tasks/{userFilterId}")
    Observable<Void> deleteUserTaskFilterObservable(@Path(USER_FILTER_ID) Long userFilterId);

    // PROCESS FILTER
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/filters/processes")
    Observable<ResultList<UserProcessInstanceFilterRepresentation>> getUserProcessInstanceFiltersObservable(
            @Query(APP_ID) Long appId);

    @GET(PROCESS_SERVICE_PATH + "/filters/processes/{userFilterId}")
    Observable<UserProcessInstanceFilterRepresentation> getUserProcessInstanceFilterObservable(
            @Path(USER_FILTER_ID) Long userFilterId);

    @POST(PROCESS_SERVICE_PATH + "/filters/processes")
    Observable<UserProcessInstanceFilterRepresentation> createUserProcessInstanceFilterObservable(
            @Body UserProcessInstanceFilterRepresentation userTaskFilterRepresentation);

    @PUT(PROCESS_SERVICE_PATH + "/filters/processes/{userFilterId}")
    Observable<UserProcessInstanceFilterRepresentation> updateUserProcessInstanceFilterObservable(
            @Path(USER_FILTER_ID) Long userFilterId,
            @Body UserProcessInstanceFilterRepresentation userTaskFilterRepresentation);

    @PUT(PROCESS_SERVICE_PATH + "/filters/processes")
    Observable<Void> orderUserProcessInstanceFiltersObservable(
            @Body UserFilterOrderRepresentation filterOrderRepresentation);

    @DELETE(PROCESS_SERVICE_PATH + "/filters/processes/{userFilterId}")
    Observable<Void> deleteUserProcessInstanceFilterObservable(@Path(USER_FILTER_ID) Long userFilterId);

}
