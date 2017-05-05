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
    @POST(PROCESS_SERVICE_PATH + "/historic-process-instances/query")
    Call<ResultList<ProcessInstanceRepresentation>> getHistoricProcessInstancesCall(
            @Body HistoricProcessInstanceQueryRepresentation filter);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}")
    Call<ProcessInstanceRepresentation> getProcessInstanceCall(@Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances/query")
    Call<ResultList<ProcessInstanceRepresentation>> getProcessInstancesCall(@Body ProcessesRequestRepresentation body);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances/filter")
    Call<ResultList<ProcessInstanceRepresentation>> filterProcessInstancesCall(
            @Body ProcessInstanceFilterRequestRepresentation body);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances")
    Call<ProcessInstanceRepresentation> startNewProcessInstanceCall(@Body CreateProcessInstanceRepresentation request);

    @DELETE(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}")
    Call<Void> deleteProcessInstanceCall(@Path(PROCESS_INSTANCE_ID) String processInstanceId);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @PUT(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/activate")
    Call<ProcessInstanceRepresentation> activateProcessInstanceCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @PUT(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/suspend")
    Call<ProcessInstanceRepresentation> suspendProcessInstanceCall(@Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/audit-log")
    Call<ProcessInstanceAuditInfoRepresentation> getProcessInstanceAuditLogCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/decision-tasks")
    Call<ResultList<DecisionTaskRepresentation>> getHistoricProcessInstanceDecisionTasksCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @Streaming
    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/diagram")
    Call<RequestBody> getProcessInstanceDiagramCall(@Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/historic-variables")
    Call<List<ProcessInstanceVariableRepresentation>> getHistoricProcessInstanceVariablesCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/start-form")
    Call<FormDefinitionRepresentation> getProcessInstanceStartFormCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    // COMMENTS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/comments")
    Call<ResultList<CommentRepresentation>> getProcessInstanceCommentsCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/comments")
    Call<CommentRepresentation> addProcessInstanceCommentCall(@Path(PROCESS_INSTANCE_ID) String processInstanceId,
            @Body CommentRepresentation request);

    // CONTENTS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/content")
    Call<ResultList<RelatedContentRepresentation>> getRelatedContentForProcessInstanceCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/field-content")
    Call<ResultList<ProcessContentRepresentation>> getProcessInstanceContentCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/raw-content?isRelatedContent=true")
    Call<RelatedContentRepresentation> createRelatedContentOnProcessInstanceCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Part(FILE) RequestBody resource);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/raw-content")
    Call<RelatedContentRepresentation> createRelatedContentOnProcessInstanceCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Part(FILE) RequestBody resource,
            @Query("isRelatedContent") Boolean isRelatedContent);

    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/content")
    Call<RelatedContentRepresentation> linkRelatedContentOnProcessInstanceCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Body AddContentRelatedRepresentation representation);

    // IDENTITY LINKS
    // ///////////////////////////////////////////////////////////////////

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/identitylinks")
    Call<ResultList<IdentityLinkRepresentation>> getIdentityLinksCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/identitylinks")
    Call<IdentityLinkRepresentation> createIdentityLinkCall(@Path(PROCESS_INSTANCE_ID) String processInstanceId,
            @Body IdentityLinkRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/identitylinks/{family}")
    Call<List<IdentityLinkRepresentation>> getIdentityLinksForFamilyCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Path(FAMILY) String family);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/identitylinks/{family}/{identityId}/{type}")
    Call<ResultList<IdentityLinkRepresentation>> getIdentityLinkTypeCall(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Path(FAMILY) String family,
            @Path(IDENTITY_ID) String identityId, @Path(TYPE) String type);

    @DELETE(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/identitylinks/{family}/{identityId}/{type}")
    Call<Void> deleteIdentityLinkCall(@Path(PROCESS_INSTANCE_ID) String processInstanceId, @Path(FAMILY) String family,
            @Path(IDENTITY_ID) String identityId, @Path(TYPE) String type);

    // PROCESS SCOPES
    // ///////////////////////////////////////////////////////////////////
    // TODO

    // VARIABLES
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/variables")
    Call<List<RestVariable>> getProcessInstanceVariablesCall(@Path(PROCESS_INSTANCE_ID) String processInstanceId,
            @Query(SCOPE) String scope);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/variables")
    Call<List<RestVariable>> createProcessInstanceVariablesCall(@Path(PROCESS_INSTANCE_ID) String processInstanceId,
            @Body List<RestVariable> restVariables);

    @PUT(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/variables")
    Call<List<RestVariable>> createOrUpdateProcessInstanceVariablesCall(@Path(PROCESS_INSTANCE_ID) String taskId,
            @Body List<RestVariable> restVariables);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/variables/{variableName}")
    Call<RestVariable> getProcessInstanceVariableCall(@Path(PROCESS_INSTANCE_ID) String processInstanceId,
            @Path(VARIABLE_NAME) String variableName, @Query(SCOPE) String scope);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/variables/{variableName}")
    Call<RestVariable> updateProcessInstanceVariableCall(@Path(PROCESS_INSTANCE_ID) String processInstanceId,
            @Path(VARIABLE_NAME) String variableName, @Body RestVariable restVariable);

    @DELETE(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/variables/{variableName}")
    Call<Void> deleteProcessInstanceVariableCall(@Path(PROCESS_INSTANCE_ID) String processInstanceId,
            @Path(VARIABLE_NAME) String variableName);

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

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/historic-process-instances/query")
    Observable<ResultList<ProcessInstanceRepresentation>> getHistoricProcessInstancesObservable(
            @Body HistoricProcessInstanceQueryRepresentation filter);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}")
    Observable<ProcessInstanceRepresentation> getProcessInstanceObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances/query")
    Observable<ResultList<ProcessInstanceRepresentation>> getProcessInstancesObservable(
            @Body ProcessesRequestRepresentation body);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances/filter")
    Observable<ResultList<ProcessInstanceRepresentation>> filterProcessInstancesObservable(
            @Body ProcessInstanceFilterRequestRepresentation body);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances")
    Observable<ProcessInstanceRepresentation> startNewProcessInstanceObservable(
            @Body CreateProcessInstanceRepresentation request);

    @DELETE(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}")
    Observable<Void> deleteProcessInstanceObservable(@Path(PROCESS_INSTANCE_ID) String processInstanceId);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @PUT(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/activate")
    Observable<ProcessInstanceRepresentation> activateProcessInstanceObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @PUT(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/suspend")
    Observable<ProcessInstanceRepresentation> suspendProcessInstanceObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/audit-log")
    Observable<ProcessInstanceAuditInfoRepresentation> getProcessInstanceAuditLogObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/decision-tasks")
    Observable<ResultList<DecisionTaskRepresentation>> getHistoricProcessInstanceDecisionTasksObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @Streaming
    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/diagram")
    Observable<RequestBody> getProcessInstanceDiagramObservable(@Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/historic-variables")
    Observable<List<ProcessInstanceVariableRepresentation>> getHistoricProcessInstanceVariablesObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/start-form")
    Observable<FormDefinitionRepresentation> getProcessInstanceStartFormObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    // COMMENTS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/comments")
    Observable<ResultList<CommentRepresentation>> getProcessInstanceCommentsObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/comments")
    Observable<CommentRepresentation> addProcessInstanceCommentObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Body CommentRepresentation request);

    // CONTENTS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/content")
    Observable<ResultList<RelatedContentRepresentation>> getRelatedContentForProcessInstanceObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/field-content")
    Observable<ResultList<ProcessContentRepresentation>> getProcessInstanceContentObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/raw-content?isRelatedContent=true")
    Observable<RelatedContentRepresentation> createRelatedContentOnProcessInstanceObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Part(FILE) RequestBody resource);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/raw-content")
    Observable<RelatedContentRepresentation> createRelatedContentOnProcessInstanceObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Part(FILE) RequestBody resource,
            @Query("isRelatedContent") Boolean isRelatedContent);

    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/content")
    Observable<RelatedContentRepresentation> linkRelatedContentOnProcessInstanceObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Body AddContentRelatedRepresentation representation);

    // IDENTITY LINKS
    // ///////////////////////////////////////////////////////////////////

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/identitylinks")
    Observable<ResultList<IdentityLinkRepresentation>> getIdentityLinksObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/identitylinks")
    Observable<IdentityLinkRepresentation> createIdentityLinkObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Body IdentityLinkRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/identitylinks/{family}")
    Observable<List<IdentityLinkRepresentation>> getIdentityLinksForFamilyObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Path(FAMILY) String family);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/identitylinks/{family}/{identityId}/{type}")
    Observable<ResultList<IdentityLinkRepresentation>> getIdentityLinkTypeObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Path(FAMILY) String family,
            @Path(IDENTITY_ID) String identityId, @Path(TYPE) String type);

    @DELETE(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/identitylinks/{family}/{identityId}/{type}")
    Observable<Void> deleteIdentityLinkObservable(@Path(PROCESS_INSTANCE_ID) String processInstanceId,
            @Path(FAMILY) String family, @Path(IDENTITY_ID) String identityId, @Path(TYPE) String type);

    // PROCESS SCOPES
    // ///////////////////////////////////////////////////////////////////
    // TODO

    // VARIABLES
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/variables")
    Observable<List<RestVariable>> getProcessInstanceVariablesObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Query(SCOPE) String scope);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/variables")
    Observable<List<RestVariable>> createProcessInstanceVariablesObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Body List<RestVariable> restVariables);

    @PUT(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/variables")
    Observable<List<RestVariable>> createOrUpdateProcessInstanceVariablesObservable(
            @Path(PROCESS_INSTANCE_ID) String taskId, @Body List<RestVariable> restVariables);

    @GET(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/variables/{variableName}")
    Observable<RestVariable> getProcessInstanceVariableObservable(@Path(PROCESS_INSTANCE_ID) String processInstanceId,
            @Path(VARIABLE_NAME) String variableName, @Query(SCOPE) String scope);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/variables/{variableName}")
    Observable<RestVariable> updateProcessInstanceVariableObservable(
            @Path(PROCESS_INSTANCE_ID) String processInstanceId, @Path(VARIABLE_NAME) String variableName,
            @Body RestVariable restVariable);

    @DELETE(PROCESS_SERVICE_PATH + "/process-instances/{processInstanceId}/variables/{variableName}")
    Observable<Void> deleteProcessInstanceVariableObservable(@Path(PROCESS_INSTANCE_ID) String processInstanceId,
            @Path(VARIABLE_NAME) String variableName);

}
