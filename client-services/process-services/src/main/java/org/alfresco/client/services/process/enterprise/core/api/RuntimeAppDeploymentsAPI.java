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
import org.alfresco.client.services.process.enterprise.core.model.runtime.AppDeploymentRepresentation;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jpascal on 12/12/2014.
 */
public interface RuntimeAppDeploymentsAPI
{
    @GET(PROCESS_SERVICE_PATH + "/runtime-app-deployments")
    Call<ResultList<AppDeploymentRepresentation>> getRuntimeAppDeploymentsCall(@Query("nameLike") String nameLike,
            @Query("tenantId") Long tenantId, @Query("latest") Boolean latest, @Query("sort") String sort,
            @Query("order") String order, @Query("start") Integer start, @Query("size") Integer size);

    @GET(PROCESS_SERVICE_PATH + "/runtime-app-deployments")
    Call<AppDeploymentRepresentation> getRuntimeAppDeploymentByDeploymentCall(
            @Query("deploymentId") String deploymentId, @Query("dmnDeploymentId") Long dmnDeploymentId);

    @GET(PROCESS_SERVICE_PATH + "/runtime-app-deployments/{appDeploymentId}")
    Call<AppDeploymentRepresentation> getAppDeploymentCall(@Path("appDeploymentId") Long appDeploymentId);

    @DELETE(PROCESS_SERVICE_PATH + "/runtime-app-deployments/{appDeploymentId}")
    Call<Void> deleteAppDeploymentCall(@Path("appDeploymentId") Long appDeploymentId);

    @GET(PROCESS_SERVICE_PATH + "/export-app-deployment/{deploymentId}")
    Call<RequestBody> exportAppDefinitionCall(@Path("deploymentId") String deploymentId);

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

    @GET(PROCESS_SERVICE_PATH + "/runtime-app-deployments")
    Observable<ResultList<AppDeploymentRepresentation>> getRuntimeAppDeploymentsObservable(
            @Query("nameLike") String nameLike, @Query("tenantId") Long tenantId, @Query("latest") Boolean latest,
            @Query("sort") String sort, @Query("order") String order, @Query("start") Integer start,
            @Query("size") Integer size);

    @GET(PROCESS_SERVICE_PATH + "/runtime-app-deployments")
    Observable<AppDeploymentRepresentation> getRuntimeAppDeploymentByDeploymentObservable(
            @Query("deploymentId") String deploymentId, @Query("dmnDeploymentId") Long dmnDeploymentId);

    @GET(PROCESS_SERVICE_PATH + "/runtime-app-deployments/{appDeploymentId}")
    Observable<AppDeploymentRepresentation> getAppDeploymentObservable(@Path("appDeploymentId") Long appDeploymentId);

    @DELETE(PROCESS_SERVICE_PATH + "/runtime-app-deployments/{appDeploymentId}")
    Observable<Void> deleteAppDeploymentObservable(@Path("appDeploymentId") Long appDeploymentId);

    @GET(PROCESS_SERVICE_PATH + "/export-app-deployment/{deploymentId}")
    Observable<RequestBody> exportAppDefinitionObservable(@Path("deploymentId") String deploymentId);
}
