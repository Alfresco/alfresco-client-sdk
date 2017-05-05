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
    @GET(PROCESS_SERVICE_PATH + "/decisions/audits/{auditTrailId}")
    Call<DecisionAuditRepresentation> getAuditTrailCall(@Path(AUDIT_TRAIL_ID) Long auditTrailId);

    @GET(PROCESS_SERVICE_PATH + "/decisions/audits")
    Call<ResultList<DecisionAuditRepresentation>> getDecisionAuditTrailsCall(@Query(DECISION_KEY) String decisionKey,
            @Query("dmnDeploymentId") Long dmnDeploymentId);

    @GET(PROCESS_SERVICE_PATH + "/decisions/decision-tables")
    Call<ResultList<RuntimeDecisionTableRepresentation>> getDecisionTablesCall(@Query(NAME_LIKE) String nameLike,
            @Query(KEY_LIKE) String keyLike, @Query(TENANT_ID_LIKE) String tenantIdLike,
            @Query(DEPLOYMENT_ID) Long deploymentId, @Query(SORT) String sort, @Query(ORDER) String order,
            @Query(START) Integer start, @Query("size") Integer size);

    @GET(PROCESS_SERVICE_PATH + "/decisions/decision-tables/{decisionTableId}")
    Call<RuntimeDecisionTableRepresentation> getDecisionTableCall(@Path(DECISION_TABLE_ID) Long auditTrailId);

    @GET(PROCESS_SERVICE_PATH + "/decisions/decision-tables/{decisionTableId}")
    Call<ResponseBody> getDecisionTableEditorJsonCall(@Path(DECISION_TABLE_ID) Long auditTrailId);

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

    @GET(PROCESS_SERVICE_PATH + "/decisions/audits/{auditTrailId}")
    Observable<DecisionAuditRepresentation> getAuditTrailObservable(@Path(AUDIT_TRAIL_ID) Long auditTrailId);

    @GET(PROCESS_SERVICE_PATH + "/decisions/audits")
    Observable<ResultList<DecisionAuditRepresentation>> getDecisionAuditTrailsObservable(
            @Query(DECISION_KEY) String decisionKey, @Query("dmnDeploymentId") Long dmnDeploymentId);

    @GET(PROCESS_SERVICE_PATH + "/decisions/decision-tables")
    Observable<ResultList<RuntimeDecisionTableRepresentation>> getDecisionTablesObservable(
            @Query(NAME_LIKE) String nameLike, @Query(KEY_LIKE) String keyLike,
            @Query(TENANT_ID_LIKE) String tenantIdLike, @Query(DEPLOYMENT_ID) Long deploymentId,
            @Query(SORT) String sort, @Query(ORDER) String order, @Query(START) Integer start,
            @Query("size") Integer size);

    @GET(PROCESS_SERVICE_PATH + "/decisions/decision-tables/{decisionTableId}")
    Observable<RuntimeDecisionTableRepresentation> getDecisionTableObservable(
            @Path(DECISION_TABLE_ID) Long auditTrailId);

    @GET(PROCESS_SERVICE_PATH + "/decisions/decision-tables/{decisionTableId}")
    Observable<ResponseBody> getDecisionTableEditorJsonObservable(@Path(DECISION_TABLE_ID) Long auditTrailId);

}
