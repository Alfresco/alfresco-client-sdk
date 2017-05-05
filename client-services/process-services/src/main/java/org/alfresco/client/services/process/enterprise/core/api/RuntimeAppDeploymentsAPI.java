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
import static org.alfresco.client.services.process.enterprise.common.constant.RequestConstant.*;

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
    Call<ResultList<AppDeploymentRepresentation>> getRuntimeAppDeploymentsCall(@Query(NAME_LIKE) String nameLike,
            @Query(TENANT_ID) Long tenantId, @Query(LATEST) Boolean latest, @Query(SORT) String sort,
            @Query(ORDER) String order, @Query(START) Integer start, @Query(SIZE) Integer size);

    @GET(PROCESS_SERVICE_PATH + "/runtime-app-deployments")
    Call<AppDeploymentRepresentation> getRuntimeAppDeploymentByDeploymentCall(
            @Query(DEPLOYMENT_ID) String deploymentId, @Query("dmnDeploymentId") Long dmnDeploymentId);

    @GET(PROCESS_SERVICE_PATH + "/runtime-app-deployments/{appDeploymentId}")
    Call<AppDeploymentRepresentation> getAppDeploymentCall(@Path(APP_DEPLOYMENT_ID) Long appDeploymentId);

    @DELETE(PROCESS_SERVICE_PATH + "/runtime-app-deployments/{appDeploymentId}")
    Call<Void> deleteAppDeploymentCall(@Path(APP_DEPLOYMENT_ID) Long appDeploymentId);

    @GET(PROCESS_SERVICE_PATH + "/export-app-deployment/{deploymentId}")
    Call<RequestBody> exportAppDefinitionCall(@Path(DEPLOYMENT_ID) String deploymentId);

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
            @Query(NAME_LIKE) String nameLike, @Query(TENANT_ID) Long tenantId, @Query(LATEST) Boolean latest,
            @Query(SORT) String sort, @Query(ORDER) String order, @Query(START) Integer start,
            @Query(SIZE) Integer size);

    @GET(PROCESS_SERVICE_PATH + "/runtime-app-deployments")
    Observable<AppDeploymentRepresentation> getRuntimeAppDeploymentByDeploymentObservable(
            @Query(DEPLOYMENT_ID) String deploymentId, @Query("dmnDeploymentId") Long dmnDeploymentId);

    @GET(PROCESS_SERVICE_PATH + "/runtime-app-deployments/{appDeploymentId}")
    Observable<AppDeploymentRepresentation> getAppDeploymentObservable(@Path(APP_DEPLOYMENT_ID) Long appDeploymentId);

    @DELETE(PROCESS_SERVICE_PATH + "/runtime-app-deployments/{appDeploymentId}")
    Observable<Void> deleteAppDeploymentObservable(@Path(APP_DEPLOYMENT_ID) Long appDeploymentId);

    @GET(PROCESS_SERVICE_PATH + "/export-app-deployment/{deploymentId}")
    Observable<RequestBody> exportAppDefinitionObservable(@Path(DEPLOYMENT_ID) String deploymentId);
}
