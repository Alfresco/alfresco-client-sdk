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
    @GET(PROCESS_SERVICE_PATH + "/admin/endpoints")
    Call<List<OptionRepresentation>> getEndpointConfigurationsCall(@Query(TENANT_ID) String tenantId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/endpoints")
    Call<EndpointConfigurationRepresentation> createEndpointConfigurationCall(
            @Body EndpointConfigurationRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/admin/endpoints/{endpointConfigurationId}")
    Call<EndpointConfigurationRepresentation> createEndpointConfigurationCall(
            @Path(ENDPOINT_CONFIGURATION_ID) String endpointConfig, @Query(TENANT_ID) String tenantId);

    @PUT(PROCESS_SERVICE_PATH + "/admin/endpoints/{endpointConfigurationId}")
    Call<EndpointConfigurationRepresentation> updateEndpointConfigurationCall(
            @Path(ENDPOINT_CONFIGURATION_ID) String endpointConfig,
            @Body EndpointConfigurationRepresentation representation);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/endpoints/{endpointConfigurationId}")
    Call<Void> removeEndpointConfigurationCall(@Path(ENDPOINT_CONFIGURATION_ID) String endpointConfig,
            @Query(TENANT_ID) String tenantId);

    // BASIC AUTHS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/admin/basic-auths")
    Call<List<EndpointBasicAuthRepresentation>> getBasicAuthConfigurationsCall(@Query(TENANT_ID) String tenantId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/basic-auths")
    Call<EndpointBasicAuthRepresentation> createBasicAuthConfigurationCall(
            @Body CreateEndpointBasicAuthRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/admin/basic-auths/{basicAuthId}")
    Call<EndpointConfigurationRepresentation> getBasicAuthConfigurationCall(@Path(BASIC_AUTH_ID) String basicAuthId,
            @Query(TENANT_ID) String tenantId);

    @PUT(PROCESS_SERVICE_PATH + "/admin/basic-auths/{basicAuthId}")
    Call<EndpointConfigurationRepresentation> updateBasicAuthConfigurationCall(@Path(BASIC_AUTH_ID) String basicAuthId,
            @Body CreateEndpointBasicAuthRepresentation representation);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/basic-auths/{basicAuthId}")
    Call<Void> removeBasicAuthonfigurationCall(@Path(BASIC_AUTH_ID) String basicAuthId,
            @Query(TENANT_ID) String tenantId);

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

    @GET(PROCESS_SERVICE_PATH + "/admin/endpoints")
    Observable<List<OptionRepresentation>> getEndpointConfigurationsObservable(@Query(TENANT_ID) String tenantId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/endpoints")
    Observable<EndpointConfigurationRepresentation> createEndpointConfigurationObservable(
            @Body EndpointConfigurationRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/admin/endpoints/{endpointConfigurationId}")
    Observable<EndpointConfigurationRepresentation> createEndpointConfigurationObservable(
            @Path(ENDPOINT_CONFIGURATION_ID) String endpointConfig, @Query(TENANT_ID) String tenantId);

    @PUT(PROCESS_SERVICE_PATH + "/admin/endpoints/{endpointConfigurationId}")
    Observable<EndpointConfigurationRepresentation> updateEndpointConfigurationObservable(
            @Path(ENDPOINT_CONFIGURATION_ID) String endpointConfig,
            @Body EndpointConfigurationRepresentation representation);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/endpoints/{endpointConfigurationId}")
    Observable<Void> removeEndpointConfigurationObservable(@Path(ENDPOINT_CONFIGURATION_ID) String endpointConfig,
            @Query(TENANT_ID) String tenantId);

    // BASIC AUTHS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/admin/basic-auths")
    Observable<List<EndpointBasicAuthRepresentation>> getBasicAuthConfigurationsObservable(
            @Query(TENANT_ID) String tenantId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/basic-auths")
    Observable<EndpointBasicAuthRepresentation> createBasicAuthConfigurationObservable(
            @Body CreateEndpointBasicAuthRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/admin/basic-auths/{basicAuthId}")
    Observable<EndpointConfigurationRepresentation> getBasicAuthConfigurationObservable(
            @Path(BASIC_AUTH_ID) String basicAuthId, @Query(TENANT_ID) String tenantId);

    @PUT(PROCESS_SERVICE_PATH + "/admin/basic-auths/{basicAuthId}")
    Observable<EndpointConfigurationRepresentation> updateBasicAuthConfigurationObservable(
            @Path(BASIC_AUTH_ID) String basicAuthId, @Body CreateEndpointBasicAuthRepresentation representation);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/basic-auths/{basicAuthId}")
    Observable<Void> removeBasicAuthonfigurationObservable(@Path(BASIC_AUTH_ID) String basicAuthId,
            @Query(TENANT_ID) String tenantId);

}
