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

import org.alfresco.client.services.process.enterprise.common.model.representation.ResultList;
import org.alfresco.client.services.process.enterprise.core.model.runtime.DecisionAuditRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.runtime.RuntimeDecisionTableRepresentation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface DecisionsAPI
{
    @GET("api/enterprise/decisions/audits/{auditTrailId}")
    Call<DecisionAuditRepresentation> getAuditTrailCall(@Path("auditTrailId") Long auditTrailId);

    @GET("api/enterprise/decisions/audits")
    Call<ResultList<DecisionAuditRepresentation>> getDecisionAuditTrailsCall(@Query("decisionKey") String decisionKey,
            @Query("dmnDeploymentId") Long dmnDeploymentId);

    @GET("api/enterprise/decisions/decision-tables")
    Call<ResultList<RuntimeDecisionTableRepresentation>> getDecisionTablesCall(@Query("nameLike") String nameLike,
            @Query("keyLike") String keyLike, @Query("tenantIdLike") String tenantIdLike,
            @Query("deploymentId") Long deploymentId, @Query("sort") String sort, @Query("order") String order,
            @Query("start") Integer start, @Query("size") Integer size);

    @GET("api/enterprise/decisions/decision-tables/{decisionTableId}")
    Call<RuntimeDecisionTableRepresentation> getDecisionTableCall(@Path("decisionTableId") Long auditTrailId);

    @GET("api/enterprise/decisions/decision-tables/{decisionTableId}")
    Call<ResponseBody> getDecisionTableEditorJsonCall(@Path("decisionTableId") Long auditTrailId);

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

    @GET("api/enterprise/decisions/audits/{auditTrailId}")
    Observable<DecisionAuditRepresentation> getAuditTrailObservable(@Path("auditTrailId") Long auditTrailId);

    @GET("api/enterprise/decisions/audits")
    Observable<ResultList<DecisionAuditRepresentation>> getDecisionAuditTrailsObservable(
            @Query("decisionKey") String decisionKey, @Query("dmnDeploymentId") Long dmnDeploymentId);

    @GET("api/enterprise/decisions/decision-tables")
    Observable<ResultList<RuntimeDecisionTableRepresentation>> getDecisionTablesObservable(
            @Query("nameLike") String nameLike, @Query("keyLike") String keyLike,
            @Query("tenantIdLike") String tenantIdLike, @Query("deploymentId") Long deploymentId,
            @Query("sort") String sort, @Query("order") String order, @Query("start") Integer start,
            @Query("size") Integer size);

    @GET("api/enterprise/decisions/decision-tables/{decisionTableId}")
    Observable<RuntimeDecisionTableRepresentation> getDecisionTableObservable(
            @Path("decisionTableId") Long auditTrailId);

    @GET("api/enterprise/decisions/decision-tables/{decisionTableId}")
    Observable<ResponseBody> getDecisionTableEditorJsonObservable(@Path("decisionTableId") Long auditTrailId);

}
