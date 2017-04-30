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

import org.alfresco.client.services.process.core.model.common.ResultList;
import org.alfresco.client.services.process.core.model.runtime.UserFilterOrderRepresentation;
import org.alfresco.client.services.process.core.model.runtime.UserProcessInstanceFilterRepresentation;
import org.alfresco.client.services.process.core.model.runtime.UserTaskFilterRepresentation;

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
    @GET("api/enterprise/filters/tasks")
    Call<ResultList<UserTaskFilterRepresentation>> getUserTaskFilters(@Query("appId") Long appId);

    @GET("api/enterprise/filters/tasks")
    Observable<ResultList<UserTaskFilterRepresentation>> getUserTaskFiltersObservable(@Query("appId") Long appId);

    @GET("api/enterprise/filters/tasks/{userFilterId}")
    Call<UserTaskFilterRepresentation> getUserTaskFilter(@Path("userFilterId") Long userFilterId);

    @GET("api/enterprise/filters/tasks/{userFilterId}")
    Observable<UserTaskFilterRepresentation> getUserTaskFilterObservable(@Path("userFilterId") Long userFilterId);

    @POST("api/enterprise/filters/tasks")
    Call<UserTaskFilterRepresentation> createUserTaskFilter(
            @Body UserTaskFilterRepresentation userTaskFilterRepresentation);

    @POST("api/enterprise/filters/tasks")
    Observable<UserTaskFilterRepresentation> createUserTaskFilterObservable(
            @Body UserTaskFilterRepresentation userTaskFilterRepresentation);

    @PUT("api/enterprise/filters/tasks/{userFilterId}")
    Call<UserTaskFilterRepresentation> updateUserTaskFilter(@Path("userFilterId") Long userFilterId,
            @Body UserTaskFilterRepresentation userTaskFilterRepresentation);

    @PUT("api/enterprise/filters/tasks/{userFilterId}")
    Observable<UserTaskFilterRepresentation> updateUserTaskFilterObservable(@Path("userFilterId") Long userFilterId,
            @Body UserTaskFilterRepresentation userTaskFilterRepresentation);

    @PUT("api/enterprise/filters/tasks")
    Call<Void> orderUserTaskFilters(@Body UserFilterOrderRepresentation filterOrderRepresentation);

    @PUT("api/enterprise/filters/tasks")
    Observable<Void> orderUserTaskFiltersObservable(@Body UserFilterOrderRepresentation filterOrderRepresentation);

    @DELETE("api/enterprise/filters/tasks/{userFilterId}")
    Call<Void> deleteUserTaskFilter(@Path("userFilterId") Long userFilterId);

    @DELETE("api/enterprise/filters/tasks/{userFilterId}")
    Observable<Void> deleteUserTaskFilterObservable(@Path("userFilterId") Long userFilterId);

    // PROCESS FILTER
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/filters/processes")
    Call<ResultList<UserProcessInstanceFilterRepresentation>> getUserProcessInstanceFilters(@Query("appId") Long appId);

    @GET("api/enterprise/filters/processes")
    Observable<ResultList<UserProcessInstanceFilterRepresentation>> getUserProcessInstanceFiltersObservable(
            @Query("appId") Long appId);

    @GET("api/enterprise/filters/processes/{userFilterId}")
    Call<UserProcessInstanceFilterRepresentation> getUserProcessInstanceFilter(@Path("userFilterId") Long userFilterId);

    @GET("api/enterprise/filters/processes/{userFilterId}")
    Observable<UserProcessInstanceFilterRepresentation> getUserProcessInstanceFilterObservable(
            @Path("userFilterId") Long userFilterId);

    @POST("api/enterprise/filters/processes")
    Call<UserProcessInstanceFilterRepresentation> createUserProcessInstanceFilter(
            @Body UserProcessInstanceFilterRepresentation userTaskFilterRepresentation);

    @POST("api/enterprise/filters/processes")
    Observable<UserProcessInstanceFilterRepresentation> createUserProcessInstanceFilterObservable(
            @Body UserProcessInstanceFilterRepresentation userTaskFilterRepresentation);

    @PUT("api/enterprise/filters/processes/{userFilterId}")
    Call<UserProcessInstanceFilterRepresentation> updateUserProcessInstanceFilter(
            @Path("userFilterId") Long userFilterId,
            @Body UserProcessInstanceFilterRepresentation userTaskFilterRepresentation);

    @PUT("api/enterprise/filters/processes/{userFilterId}")
    Observable<UserProcessInstanceFilterRepresentation> updateUserProcessInstanceFilterObservable(
            @Path("userFilterId") Long userFilterId,
            @Body UserProcessInstanceFilterRepresentation userTaskFilterRepresentation);

    @PUT("api/enterprise/filters/processes")
    Call<Void> orderUserProcessInstanceFilters(@Body UserFilterOrderRepresentation filterOrderRepresentation);

    @PUT("api/enterprise/filters/processes")
    Observable<Void> orderUserProcessInstanceFiltersObservable(
            @Body UserFilterOrderRepresentation filterOrderRepresentation);

    @DELETE("api/enterprise/filters/processes/{userFilterId}")
    Call<Void> deleteUserProcessInstanceFilter(@Path("userFilterId") Long userFilterId);

    @DELETE("api/enterprise/filters/processes/{userFilterId}")
    Observable<Void> deleteUserProcessInstanceFilterObservable(@Path("userFilterId") Long userFilterId);
}
