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
import static org.alfresco.client.services.process.enterprise.common.constant.RequestConstant.FILE;
import static org.alfresco.client.services.process.enterprise.common.constant.RequestConstant.TENANT_ID;

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
    @GET(PROCESS_SERVICE_PATH + "/admin/tenants")
    Call<List<LightTenantRepresentation>> getTenantsCall();

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/tenants")
    Call<LightTenantRepresentation> createTenantCall(@Body CreateTenantRepresentation createTenantRepresentation);

    @GET(PROCESS_SERVICE_PATH + "/admin/tenants/{tenantId}")
    Call<LightTenantRepresentation> getTenantCall(@Path(TENANT_ID) String tenantId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/admin/tenants/{tenantId}")
    Call<Void> updateTenantCall(@Path(TENANT_ID) String tenantId,
            @Body CreateTenantRepresentation createTenantRepresentation);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/tenants/{tenantId}")
    Call<Void> deleteTenantCall(@Path(TENANT_ID) String tenantId);

    @GET(PROCESS_SERVICE_PATH + "/admin/tenants/{tenantId}/logo")
    Call<ResponseBody> getTenantLogoCall(@Path(TENANT_ID) String tenantId);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/admin/tenants/{tenantId}/logo")
    Call<ImageUploadRepresentation> uploadTenantLogoCall(@Path(TENANT_ID) String tenantId,
            @Part(FILE) RequestBody body);

    @GET(PROCESS_SERVICE_PATH + "/admin/tenants/{tenantId}/events")
    Call<List<TenantEvent>> getTenantEventsCall(@Path(TENANT_ID) String tenantId);

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
    @GET(PROCESS_SERVICE_PATH + "/admin/tenants")
    Observable<List<LightTenantRepresentation>> getTenantsObservable();

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/admin/tenants")
    Observable<LightTenantRepresentation> createTenantObservable(
            @Body CreateTenantRepresentation createTenantRepresentation);

    @GET(PROCESS_SERVICE_PATH + "/admin/tenants/{tenantId}")
    Observable<LightTenantRepresentation> getTenantObservable(@Path(TENANT_ID) String tenantId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/admin/tenants/{tenantId}")
    Observable<Void> updateTenantObservable(@Path(TENANT_ID) String tenantId,
            @Body CreateTenantRepresentation createTenantRepresentation);

    @DELETE(PROCESS_SERVICE_PATH + "/admin/tenants/{tenantId}")
    Observable<Void> deleteTenantObservable(@Path(TENANT_ID) String tenantId);

    @GET(PROCESS_SERVICE_PATH + "/admin/tenants/{tenantId}/logo")
    Observable<ResponseBody> getTenantLogoObservable(@Path(TENANT_ID) String tenantId);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/admin/tenants/{tenantId}/logo")
    Observable<ImageUploadRepresentation> uploadTenantLogoObservable(@Path(TENANT_ID) String tenantId,
            @Part(FILE) RequestBody body);

    @GET(PROCESS_SERVICE_PATH + "/admin/tenants/{tenantId}/events")
    Observable<List<TenantEvent>> getTenantEventsObservable(@Path(TENANT_ID) String tenantId);
}
