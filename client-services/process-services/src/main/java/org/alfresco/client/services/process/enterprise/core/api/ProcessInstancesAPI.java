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
import org.alfresco.client.services.process.enterprise.core.model.runtime.request.AddContentRelatedRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.runtime.request.CreateProcessInstanceRepresentation;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 11/12/2014.
 */
public interface ProcessInstancesAPI
{
    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/historic-process-instances/query")
    Call<ResultList<ProcessInstanceRepresentation>> getHistoricProcessInstancesCall(
            @Body HistoricProcessInstanceQueryRepresentation filter);

    @GET("api/enterprise/process-instances/{processInstanceId}")
    Call<ProcessInstanceRepresentation> getProcessInstanceCall(@Path("processInstanceId") String processInstanceId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/process-instances/query")
    Call<ResultList<ProcessInstanceRepresentation>> getProcessInstancesCall(@Body ProcessesRequestRepresentation body);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/process-instances/filter")
    Call<ResultList<ProcessInstanceRepresentation>> filterProcessInstancesCall(
            @Body ProcessInstanceFilterRequestRepresentation body);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/process-instances")
    Call<ProcessInstanceRepresentation> startNewProcessInstanceCall(@Body CreateProcessInstanceRepresentation request);

    @DELETE("api/enterprise/process-instances/{processInstanceId}")
    Call<Void> deleteProcessInstanceCall(@Path("processInstanceId") String processInstanceId);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @PUT("api/enterprise/process-instances/{processInstanceId}/activate")
    Call<ProcessInstanceRepresentation> activateProcessInstanceCall(
            @Path("processInstanceId") String processInstanceId);

    @PUT("api/enterprise/process-instances/{processInstanceId}/suspend")
    Call<ProcessInstanceRepresentation> suspendProcessInstanceCall(@Path("processInstanceId") String processInstanceId);

    @GET("api/enterprise/process-instances/{processInstanceId}/audit-log")
    Call<ProcessInstanceAuditInfoRepresentation> getProcessInstanceAuditLogCall(
            @Path("processInstanceId") String processInstanceId);

    @GET("api/enterprise/process-instances/{processInstanceId}/decision-tasks")
    Call<ResultList<DecisionTaskRepresentation>> getHistoricProcessInstanceDecisionTasksCall(
            @Path("processInstanceId") String processInstanceId);

    @Streaming
    @GET("api/enterprise/process-instances/{processInstanceId}/diagram")
    Call<RequestBody> getProcessInstanceDiagramCall(@Path("processInstanceId") String processInstanceId);

    @GET("api/enterprise/process-instances/{processInstanceId}/historic-variables")
    Call<List<ProcessInstanceVariableRepresentation>> getHistoricProcessInstanceVariablesCall(
            @Path("processInstanceId") String processInstanceId);

    @GET("api/enterprise/process-instances/{processInstanceId}/start-form")
    Call<FormDefinitionRepresentation> getProcessInstanceStartFormCall(
            @Path("processInstanceId") String processInstanceId);

    // COMMENTS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/process-instances/{processInstanceId}/comments")
    Call<ResultList<CommentRepresentation>> getProcessInstanceCommentsCall(
            @Path("processInstanceId") String processInstanceId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/process-instances/{processInstanceId}/comments")
    Call<CommentRepresentation> addProcessInstanceCommentCall(@Path("processInstanceId") String processInstanceId,
            @Body CommentRepresentation request);

    // CONTENTS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/process-instances/{processInstanceId}/content")
    Call<ResultList<RelatedContentRepresentation>> getRelatedContentForProcessInstanceCall(
            @Path("processInstanceId") String processInstanceId);

    @GET("api/enterprise/process-instances/{processInstanceId}/field-content")
    Call<ResultList<ProcessContentRepresentation>> getProcessInstanceContentCall(
            @Path("processInstanceId") String processInstanceId);

    @Multipart
    @POST("api/enterprise/process-instances/{processInstanceId}/raw-content?isRelatedContent=true")
    Call<RelatedContentRepresentation> createRelatedContentOnProcessInstanceCall(
            @Path("processInstanceId") String processInstanceId, @Part("file") RequestBody resource);

    @Multipart
    @POST("api/enterprise/process-instances/{processInstanceId}/raw-content")
    Call<RelatedContentRepresentation> createRelatedContentOnProcessInstanceCall(
            @Path("processInstanceId") String processInstanceId, @Part("file") RequestBody resource,
            @Query("isRelatedContent") Boolean isRelatedContent);

    @POST("api/enterprise/process-instances/{processInstanceId}/content")
    Call<RelatedContentRepresentation> linkRelatedContentOnProcessInstanceCall(
            @Path("processInstanceId") String processInstanceId, @Body AddContentRelatedRepresentation representation);

    // IDENTITY LINKS
    // ///////////////////////////////////////////////////////////////////

    @GET("api/enterprise/process-instances/{processInstanceId}/identitylinks")
    Call<ResultList<IdentityLinkRepresentation>> getIdentityLinksCall(
            @Path("processInstanceId") String processInstanceId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/process-instances/{processInstanceId}/identitylinks")
    Call<IdentityLinkRepresentation> createIdentityLinkCall(@Path("processInstanceId") String processInstanceId,
            @Body IdentityLinkRepresentation representation);

    @GET("api/enterprise/process-instances/{processInstanceId}/identitylinks/{family}")
    Call<List<IdentityLinkRepresentation>> getIdentityLinksForFamilyCall(
            @Path("processInstanceId") String processInstanceId, @Path("family") String family);

    @GET("api/enterprise/process-instances/{processInstanceId}/identitylinks/{family}/{identityId}/{type}")
    Call<ResultList<IdentityLinkRepresentation>> getIdentityLinkTypeCall(
            @Path("processInstanceId") String processInstanceId, @Path("family") String family,
            @Path("identityId") String identityId, @Path("type") String type);

    @DELETE("api/enterprise/process-instances/{processInstanceId}/identitylinks/{family}/{identityId}/{type}")
    Call<Void> deleteIdentityLinkCall(@Path("processInstanceId") String processInstanceId,
            @Path("family") String family,
            @Path("identityId") String identityId, @Path("type") String type);

    // PROCESS SCOPES
    // ///////////////////////////////////////////////////////////////////
    // TODO

    // VARIABLES
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/process-instances/{processInstanceId}/variables")
    Call<List<RestVariable>> getProcessInstanceVariablesCall(@Path("processInstanceId") String processInstanceId,
            @Query("scope") String scope);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/process-instances/{processInstanceId}/variables")
    Call<List<RestVariable>> createProcessInstanceVariablesCall(@Path("processInstanceId") String processInstanceId,
            @Body List<RestVariable> restVariables);

    @PUT("api/enterprise/process-instances/{processInstanceId}/variables")
    Call<List<RestVariable>> createOrUpdateProcessInstanceVariables(@Path("processInstanceId") String taskId,
            @Body List<RestVariable> restVariables);

    @GET("api/enterprise/process-instances/{processInstanceId}/variables/{variableName}")
    Call<RestVariable> getProcessInstanceVariable(@Path("processInstanceId") String processInstanceId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/process-instances/{processInstanceId}/variables/{variableName}")
    Call<RestVariable> updateProcessInstanceVariable(@Path("processInstanceId") String processInstanceId,
            @Path("variableName") String variableName, @Body RestVariable restVariable);

    @DELETE("api/enterprise/process-instances/{processInstanceId}/variables/{variableName}")
    Call<Void> deleteProcessInstanceVariable(@Path("processInstanceId") String processInstanceId,
            @Path("variableName") String variableName);

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

    @GET("api/enterprise/process-instances/{processInstanceId}")
    Observable<ProcessInstanceRepresentation> getProcessInstanceObservable(
            @Path("processInstanceId") String processInstanceId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/process-instances/query")
    Observable<ResultList<ProcessInstanceRepresentation>> getProcessInstancesObservable(
            @Body ProcessesRequestRepresentation body);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/process-instances/filter")
    Observable<ResultList<ProcessInstanceRepresentation>> filterProcessInstancesObservable(
            @Body ProcessInstanceFilterRequestRepresentation body);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/process-instances")
    Observable<ProcessInstanceRepresentation> startNewProcessInstanceObservable(
            @Body CreateProcessInstanceRepresentation request);

    @DELETE("api/enterprise/process-instances/{processInstanceId}")
    Observable<Void> deleteProcessInstanceObservable(@Path("processInstanceId") String processInstanceId);

    // COMMENTS
    // ///////////////////////////////////////////////////////////////////

    @GET("api/enterprise/process-instances/{processInstanceId}/comments")
    Observable<ResultList<CommentRepresentation>> getProcessInstanceCommentsObservable(
            @Path("processInstanceId") String processInstanceId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/process-instances/{processInstanceId}/comments")
    Observable<CommentRepresentation> addProcessInstanceCommentObservable(
            @Path("processInstanceId") String processInstanceId, @Body CommentRepresentation request);

    // CONTENTS
    // ///////////////////////////////////////////////////////////////////

    @GET("api/enterprise/process-instances/{processInstanceId}/content")
    Observable<ResultList<RelatedContentRepresentation>> getRelatedContentForProcessInstanceObservable(
            @Path("processInstanceId") String processInstanceId);

    @GET("api/enterprise/process-instances/{processInstanceId}/field-content")
    Observable<ResultList<ProcessContentRepresentation>> getProcessInstanceContentObservable(
            @Path("processInstanceId") String processInstanceId);

    @Multipart
    @POST("api/enterprise/process-instances/{processInstanceId}/raw-content?isRelatedContent=true")
    Observable<RelatedContentRepresentation> createRelatedContentOnProcessInstanceObservable(
            @Path("processInstanceId") String processInstanceId, @Part("file") RequestBody resource);

    @Multipart
    @POST("api/enterprise/process-instances/{processInstanceId}/raw-content")
    Observable<RelatedContentRepresentation> createRelatedContentOnProcessInstanceObservable(
            @Path("processInstanceId") String processInstanceId, @Part("file") RequestBody resource,
            @Query("isRelatedContent") Boolean isRelatedContent);

    @POST("api/enterprise/process-instances/{processInstanceId}/content")
    Observable<RelatedContentRepresentation> linkRelatedContentOnProcessInstanceObservable(
            @Path("processInstanceId") String processInstanceId, @Body AddContentRelatedRepresentation representation);

}
