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
    @GET("api/enterprise/process-definitions")
    Call<ResultList<ProcessDefinitionRepresentation>> getProcessDefinitionsCall();

    @GET("api/enterprise/process-definitions")
    Call<ResultList<ProcessDefinitionRepresentation>> getProcessDefinitionsCall(
            @Query("appDefinitionId") Long appDefinitionId, @Query("latest") Boolean latest,
            @Query("deploymentId") String deploymentId);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/forms")
    Call<ResultList<RuntimeFormRepresentation>> getProcessDefinitionFormsCall(
            @Path("processDefinitionId") Long processDefinitionId);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/start-form")
    Call<FormDefinitionRepresentation> getProcessDefinitionStartFormCall(
            @Path("processDefinitionId") Long processDefinitionId);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/start-form-values/{field}")
    Call<List<FormValueRepresentation>> getRestFieldValuesCall(@Path("processDefinitionId") Long processDefinitionId,
            @Path("field") String field);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/start-form-values/{field}/{column}")
    Call<List<FormValueRepresentation>> getRestTableFieldValuesCall(
            @Path("processDefinitionId") Long processDefinitionId, @Path("field") String field,
            @Path("column") String column);

    // IDENTITY LINKS
    // ///////////////////////////////////////////////////////////////////

    @GET("api/enterprise/process-instances/{processDefinitionId}/identitylinks")
    Call<ResultList<IdentityLinkRepresentation>> getIdentityLinksCall(
            @Path("processDefinitionId") String processDefinitionId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/process-instances/{processDefinitionId}/identitylinks")
    Call<IdentityLinkRepresentation> createIdentityLinkCall(@Path("processDefinitionId") String processDefinitionId,
            @Body IdentityLinkRepresentation representation);

    @GET("api/enterprise/process-instances/{processDefinitionId}/identitylinks/{family}")
    Call<List<IdentityLinkRepresentation>> getIdentityLinksForFamilyCall(
            @Path("processDefinitionId") String processDefinitionId, @Path("family") String family);

    @GET("api/enterprise/process-instances/{processDefinitionId}/identitylinks/{family}/{identityId}")
    Call<ResultList<IdentityLinkRepresentation>> getIdentityLinkTypeCall(
            @Path("processDefinitionId") String processDefinitionId, @Path("family") String family,
            @Path("identityId") String identityId);

    @DELETE("api/enterprise/process-instances/{processDefinitionId}/identitylinks/{family}/{identityId}")
    Call<Void> deleteIdentityLinkCall(@Path("processDefinitionId") String processDefinitionId,
            @Path("family") String family, @Path("identityId") String identityId);

    // DECISION TABLES
    // ///////////////////////////////////////////////////////////////////

    @GET("api/enterprise/process-definitions/{processDefinitionId}/decision-tables")
    Call<ResultList<RuntimeDecisionTableRepresentation>> getProcessDefinitionDecisionTablesCall(
            @Path("processDefinitionId") Long processDefinitionId);

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

    @GET("api/enterprise/process-definitions")
    Observable<ResultList<ProcessDefinitionRepresentation>> getProcessDefinitionsObservable();

    @GET("api/enterprise/process-definitions")
    Observable<ResultList<ProcessDefinitionRepresentation>> getProcessDefinitionsObservable(
            @Query("appDefinitionId") Long appDefinitionId);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/start-form")
    Observable<FormDefinitionRepresentation> getProcessDefinitionStartFormObservable(
            @Path("processDefinitionId") Long processDefinitionId);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/start-form-values/{field}")
    Observable<List<FormValueRepresentation>> getRestFieldValuesObservable(
            @Path("processDefinitionId") Long processDefinitionId, @Path("field") String field);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/start-form-values/{field}/{column}")
    Observable<List<FormValueRepresentation>> getRestTableFieldValuesObservable(
            @Path("processDefinitionId") Long processDefinitionId, @Path("field") String field,
            @Path("column") String column);

}
