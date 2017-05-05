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

import java.util.List;

import org.alfresco.client.services.process.enterprise.common.model.representation.ResultList;
import org.alfresco.client.services.process.enterprise.core.model.editor.form.FormDefinitionRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.runtime.*;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 11/12/2014.
 */
public interface ProcessDefinitionsAPI
{
    @GET(PROCESS_SERVICE_PATH + "/process-definitions")
    Call<ResultList<ProcessDefinitionRepresentation>> getProcessDefinitionsCall();

    @GET(PROCESS_SERVICE_PATH + "/process-definitions")
    Call<ResultList<ProcessDefinitionRepresentation>> getProcessDefinitionsCall(
            @Query(APP_DEFINITION_ID) Long appDefinitionId, @Query(LATEST) Boolean latest,
            @Query(DEPLOYMENT_ID) String deploymentId);

    @GET(PROCESS_SERVICE_PATH + "/process-definitions/{processDefinitionId}/forms")
    Call<ResultList<RuntimeFormRepresentation>> getProcessDefinitionFormsCall(
            @Path(PROCESSDEFINITION_ID) Long processDefinitionId);

    @GET(PROCESS_SERVICE_PATH + "/process-definitions/{processDefinitionId}/start-form")
    Call<FormDefinitionRepresentation> getProcessDefinitionStartFormCall(
            @Path(PROCESSDEFINITION_ID) Long processDefinitionId);

    @GET(PROCESS_SERVICE_PATH + "/process-definitions/{processDefinitionId}/start-form-values/{field}")
    Call<List<FormValueRepresentation>> getRestFieldValuesCall(@Path(PROCESSDEFINITION_ID) Long processDefinitionId,
            @Path(FIELD) String field);

    @GET(PROCESS_SERVICE_PATH + "/process-definitions/{processDefinitionId}/start-form-values/{field}/{column}")
    Call<List<FormValueRepresentation>> getRestTableFieldValuesCall(
            @Path(PROCESSDEFINITION_ID) Long processDefinitionId, @Path(FIELD) String field,
            @Path(COLUMN) String column);

    // IDENTITY LINKS
    // ///////////////////////////////////////////////////////////////////

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processDefinitionId}/identitylinks")
    Call<ResultList<IdentityLinkRepresentation>> getIdentityLinksCall(
            @Path(PROCESSDEFINITION_ID) String processDefinitionId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processDefinitionId}/identitylinks")
    Call<IdentityLinkRepresentation> createIdentityLinkCall(@Path(PROCESSDEFINITION_ID) String processDefinitionId,
            @Body IdentityLinkRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processDefinitionId}/identitylinks/{family}")
    Call<List<IdentityLinkRepresentation>> getIdentityLinksForFamilyCall(
            @Path(PROCESSDEFINITION_ID) String processDefinitionId, @Path(FAMILY) String family);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processDefinitionId}/identitylinks/{family}/{identityId}")
    Call<ResultList<IdentityLinkRepresentation>> getIdentityLinkTypeCall(
            @Path(PROCESSDEFINITION_ID) String processDefinitionId, @Path(FAMILY) String family,
            @Path(IDENTITY_ID) String identityId);

    @DELETE(PROCESS_SERVICE_PATH + "/process-instances/{processDefinitionId}/identitylinks/{family}/{identityId}")
    Call<Void> deleteIdentityLinkCall(@Path(PROCESSDEFINITION_ID) String processDefinitionId,
            @Path(FAMILY) String family, @Path(IDENTITY_ID) String identityId);

    // DECISION TABLES
    // ///////////////////////////////////////////////////////////////////

    @GET(PROCESS_SERVICE_PATH + "/process-definitions/{processDefinitionId}/decision-tables")
    Call<ResultList<RuntimeDecisionTableRepresentation>> getProcessDefinitionDecisionTablesCall(
            @Path(PROCESSDEFINITION_ID) Long processDefinitionId);

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

    @GET(PROCESS_SERVICE_PATH + "/process-definitions")
    Observable<ResultList<ProcessDefinitionRepresentation>> getProcessDefinitionsObservable();

    @GET(PROCESS_SERVICE_PATH + "/process-definitions")
    Observable<ResultList<ProcessDefinitionRepresentation>> getProcessDefinitionsObservable(
            @Query(APP_DEFINITION_ID) Long appDefinitionId, @Query(LATEST) Boolean latest,
            @Query(DEPLOYMENT_ID) String deploymentId);

    @GET(PROCESS_SERVICE_PATH + "/process-definitions/{processDefinitionId}/forms")
    Observable<ResultList<RuntimeFormRepresentation>> getProcessDefinitionFormsObservable(
            @Path(PROCESSDEFINITION_ID) Long processDefinitionId);

    @GET(PROCESS_SERVICE_PATH + "/process-definitions/{processDefinitionId}/start-form")
    Observable<FormDefinitionRepresentation> getProcessDefinitionStartFormObservable(
            @Path(PROCESSDEFINITION_ID) Long processDefinitionId);

    @GET(PROCESS_SERVICE_PATH + "/process-definitions/{processDefinitionId}/start-form-values/{field}")
    Observable<List<FormValueRepresentation>> getRestFieldValuesObservable(
            @Path(PROCESSDEFINITION_ID) Long processDefinitionId, @Path(FIELD) String field);

    @GET(PROCESS_SERVICE_PATH + "/process-definitions/{processDefinitionId}/start-form-values/{field}/{column}")
    Observable<List<FormValueRepresentation>> getRestTableFieldValuesObservable(
            @Path(PROCESSDEFINITION_ID) Long processDefinitionId, @Path(FIELD) String field,
            @Path(COLUMN) String column);

    // IDENTITY LINKS
    // ///////////////////////////////////////////////////////////////////

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processDefinitionId}/identitylinks")
    Observable<ResultList<IdentityLinkRepresentation>> getIdentityLinksObservable(
            @Path(PROCESSDEFINITION_ID) String processDefinitionId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processDefinitionId}/identitylinks")
    Observable<IdentityLinkRepresentation> createIdentityLinkObservable(
            @Path(PROCESSDEFINITION_ID) String processDefinitionId, @Body IdentityLinkRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processDefinitionId}/identitylinks/{family}")
    Observable<List<IdentityLinkRepresentation>> getIdentityLinksForFamilyObservable(
            @Path(PROCESSDEFINITION_ID) String processDefinitionId, @Path(FAMILY) String family);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processDefinitionId}/identitylinks/{family}/{identityId}")
    Observable<ResultList<IdentityLinkRepresentation>> getIdentityLinkTypeObservable(
            @Path(PROCESSDEFINITION_ID) String processDefinitionId, @Path(FAMILY) String family,
            @Path(IDENTITY_ID) String identityId);

    @DELETE(PROCESS_SERVICE_PATH + "/process-instances/{processDefinitionId}/identitylinks/{family}/{identityId}")
    Observable<Void> deleteIdentityLinkObservable(@Path(PROCESSDEFINITION_ID) String processDefinitionId,
            @Path(FAMILY) String family, @Path(IDENTITY_ID) String identityId);

    // DECISION TABLES
    // ///////////////////////////////////////////////////////////////////

    @GET(PROCESS_SERVICE_PATH + "/process-definitions/{processDefinitionId}/decision-tables")
    Observable<ResultList<RuntimeDecisionTableRepresentation>> getProcessDefinitionDecisionTablesObservable(
            @Path(PROCESSDEFINITION_ID) Long processDefinitionId);

}
