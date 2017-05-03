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

import org.alfresco.client.services.process.enterprise.admin.model.body.CreateTenantRepresentation;
import org.alfresco.client.services.process.enterprise.admin.model.representation.LightTenantRepresentation;
import org.alfresco.client.services.process.enterprise.admin.model.representation.TenantEvent;
import org.alfresco.client.services.process.enterprise.common.model.representation.ImageUploadRepresentation;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 *
 */
public interface AdminTenantsAPI
{
    // TENANTS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/tenants")
    Call<List<LightTenantRepresentation>> getTenantsCall();

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/tenants")
    Call<LightTenantRepresentation> createTenantCall(@Body CreateTenantRepresentation createTenantRepresentation);

    @GET("api/enterprise/admin/tenants/{tenantId}")
    Call<LightTenantRepresentation> getTenantCall(@Path("tenantId") String tenantId);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/admin/tenants/{tenantId}")
    Call<Void> updateTenantCall(@Path("tenantId") String tenantId,
            @Body CreateTenantRepresentation createTenantRepresentation);

    @DELETE("api/enterprise/admin/tenants/{tenantId}")
    Call<Void> deleteTenantCall(@Path("tenantId") String tenantId);

    @GET("api/enterprise/admin/tenants/{tenantId}/logo")
    Call<ResponseBody> getTenantLogoCall(@Path("tenantId") String tenantId);

    @Multipart
    @POST("api/enterprise/admin/tenants/{tenantId}/logo")
    Call<ImageUploadRepresentation> uploadTenantLogoCall(@Path("tenantId") String tenantId,
            @Part("file") RequestBody body);

    @GET("api/enterprise/admin/tenants/{tenantId}/events")
    Call<List<TenantEvent>> getTenantEventsCall(@Path("tenantId") String tenantId);

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

    // TENANTS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/admin/tenants")
    Observable<List<LightTenantRepresentation>> getTenantsObservable();

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/admin/tenants")
    Observable<LightTenantRepresentation> createTenantObservable(
            @Body CreateTenantRepresentation createTenantRepresentation);

    @GET("api/enterprise/admin/tenants/{tenantId}")
    Observable<LightTenantRepresentation> getTenantObservable(@Path("tenantId") String tenantId);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/admin/tenants/{tenantId}")
    Observable<Void> updateTenantObservable(@Path("tenantId") String tenantId,
            @Body CreateTenantRepresentation createTenantRepresentation);

    @DELETE("api/enterprise/admin/tenants/{tenantId}")
    Observable<Void> deleteTenantObservable(@Path("tenantId") String tenantId);

    @GET("api/enterprise/admin/tenants/{tenantId}/logo")
    Observable<ResponseBody> getTenantLogoObservable(@Path("tenantId") String tenantId);

    @Multipart
    @POST("api/enterprise/admin/tenants/{tenantId}/logo")
    Observable<ImageUploadRepresentation> uploadTenantLogoObservable(@Path("tenantId") String tenantId,
            @Part("file") RequestBody body);

    @GET("api/enterprise/admin/tenants/{tenantId}/events")
    Observable<List<TenantEvent>> getTenantEventsObservable(@Path("tenantId") String tenantId);
}
