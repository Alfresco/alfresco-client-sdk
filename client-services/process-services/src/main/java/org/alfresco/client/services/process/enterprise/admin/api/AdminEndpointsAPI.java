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

import org.alfresco.client.services.process.enterprise.admin.model.body.CreateEndpointBasicAuthRepresentation;
import org.alfresco.client.services.process.enterprise.admin.model.representation.EndpointBasicAuthRepresentation;
import org.alfresco.client.services.process.enterprise.admin.model.representation.EndpointConfigurationRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.editor.form.OptionRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 *
 */
public interface AdminEndpointsAPI
{
    // ENDPOINTS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/endpoints")
    Call<List<OptionRepresentation>> getEndpointConfigurationsCall(@Query("tenantId") String tenantId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/endpoints")
    Call<EndpointConfigurationRepresentation> createEndpointConfigurationCall(
            @Body EndpointConfigurationRepresentation representation);

    @GET("api/enterprise/admin/endpoints/{endpointConfigurationId}")
    Call<EndpointConfigurationRepresentation> createEndpointConfigurationCall(
            @Path("endpointConfigurationId") String endpointConfig, @Query("tenantId") String tenantId);

    @PUT("api/enterprise/admin/endpoints/{endpointConfigurationId}")
    Call<EndpointConfigurationRepresentation> updateEndpointConfigurationCall(
            @Path("endpointConfigurationId") String endpointConfig,
            @Body EndpointConfigurationRepresentation representation);

    @DELETE("api/enterprise/admin/endpoints/{endpointConfigurationId}")
    Call<Void> removeEndpointConfigurationCall(@Path("endpointConfigurationId") String endpointConfig,
            @Query("tenantId") String tenantId);

    // BASIC AUTHS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/basic-auths")
    Call<List<EndpointBasicAuthRepresentation>> getBasicAuthConfigurationsCall(@Query("tenantId") String tenantId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/basic-auths")
    Call<EndpointBasicAuthRepresentation> createBasicAuthConfigurationCall(
            @Body CreateEndpointBasicAuthRepresentation representation);

    @GET("api/enterprise/admin/basic-auths/{basicAuthId}")
    Call<EndpointConfigurationRepresentation> getBasicAuthConfigurationCall(@Path("basicAuthId") String basicAuthId,
            @Query("tenantId") String tenantId);

    @PUT("api/enterprise/admin/basic-auths/{basicAuthId}")
    Call<EndpointConfigurationRepresentation> updateBasicAuthConfigurationCall(@Path("basicAuthId") String basicAuthId,
            @Body CreateEndpointBasicAuthRepresentation representation);

    @DELETE("api/enterprise/admin/basic-auths/{basicAuthId}")
    Call<Void> removeBasicAuthonfigurationCall(@Path("basicAuthId") String basicAuthId,
            @Query("tenantId") String tenantId);

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

    // ENDPOINTS
    // ///////////////////////////////////////////////////////////////////

    @GET("api/enterprise/admin/endpoints")
    Observable<List<OptionRepresentation>> getEndpointConfigurationsObservable(@Query("tenantId") String tenantId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/endpoints")
    Observable<EndpointConfigurationRepresentation> createEndpointConfigurationObservable(
            @Body EndpointConfigurationRepresentation representation);

    @GET("api/enterprise/admin/endpoints/{endpointConfigurationId}")
    Observable<EndpointConfigurationRepresentation> createEndpointConfigurationObservable(
            @Path("endpointConfigurationId") String endpointConfig, @Query("tenantId") String tenantId);

    @PUT("api/enterprise/admin/endpoints/{endpointConfigurationId}")
    Observable<EndpointConfigurationRepresentation> updateEndpointConfigurationObservable(
            @Path("endpointConfigurationId") String endpointConfig,
            @Body EndpointConfigurationRepresentation representation);

    @DELETE("api/enterprise/admin/endpoints/{endpointConfigurationId}")
    Observable<Void> removeEndpointConfigurationObservable(@Path("endpointConfigurationId") String endpointConfig,
            @Query("tenantId") String tenantId);

    // BASIC AUTHS
    // ///////////////////////////////////////////////////////////////////

    @GET("api/enterprise/admin/basic-auths")
    Observable<List<EndpointBasicAuthRepresentation>> getBasicAuthConfigurationsObservable(
            @Query("tenantId") String tenantId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/basic-auths")
    Observable<EndpointBasicAuthRepresentation> createBasicAuthConfigurationObservable(
            @Body CreateEndpointBasicAuthRepresentation representation);

    @GET("api/enterprise/admin/basic-auths/{basicAuthId}")
    Observable<EndpointConfigurationRepresentation> getBasicAuthConfigurationObservable(
            @Path("basicAuthId") String basicAuthId, @Query("tenantId") String tenantId);

    @PUT("api/enterprise/admin/basic-auths/{basicAuthId}")
    Observable<EndpointConfigurationRepresentation> updateBasicAuthConfigurationObservable(
            @Path("basicAuthId") String basicAuthId, @Body CreateEndpointBasicAuthRepresentation representation);

    @DELETE("api/enterprise/admin/basic-auths/{basicAuthId}")
    Observable<Void> removeBasicAuthonfigurationObservable(@Path("basicAuthId") String basicAuthId,
            @Query("tenantId") String tenantId);

}
