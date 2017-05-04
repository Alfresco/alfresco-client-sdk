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

import java.util.List;

import org.alfresco.client.services.process.enterprise.common.model.representation.ResultList;
import org.alfresco.client.services.process.enterprise.core.model.editor.form.FormDefinitionRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.editor.form.request.CompleteFormRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.runtime.*;
import org.alfresco.client.services.process.enterprise.core.model.runtime.request.*;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 11/12/2014.
 */
public interface TasksAPI
{
    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/query")
    Call<ResultList<TaskRepresentation>> listTasksCall(@Body QueryTasksRepresentation filter);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/historic-tasks/query")
    Call<ResultList<TaskRepresentation>> listHistoricTasksCall(@Body HistoricTaskInstanceQueryRepresentation filter);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/filter")
    Call<ResultList<TaskRepresentation>> filterTasksCall(@Body TaskFilterRequestRepresentation filter);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}")
    Call<TaskRepresentation> getTaskCall(@Path("taskId") String taskId);

    @POST(PROCESS_SERVICE_PATH + "/tasks")
    Call<TaskRepresentation> createNewTaskCall(@Body TaskRepresentation task);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}")
    Call<TaskRepresentation> updateTaskCall(@Path("taskId") String taskId, @Body UpdateTaskRepresentation request);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}")
    Call<Void> deleteTaskCall(@Path("taskId") String taskId);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/complete")
    Call<Void> completeTaskCall(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/involve")
    Call<Void> involveUserCall(@Path("taskId") String taskId, @Body InvolveTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/remove-involved")
    Call<Void> removeInvolvedUserCall(@Path("taskId") String taskId, @Body InvolveTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/assign")
    Call<TaskRepresentation> assignTaskCall(@Path("taskId") String taskId, @Body AssignTaskRepresentation request);

    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/claim")
    Call<Void> claimTaskCall(@Path("taskId") String taskId);

    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/unclaim")
    Call<Void> unClaimTaskCall(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/attach-form")
    Call<Void> attachFormCall(@Path("taskId") String taskId, @Body AttachFormTaskRepresentation requestNode);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/remove-form")
    Call<Void> removeFormCall(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/delegate")
    Call<Void> delegateCall(@Path("taskId") String taskId, @Body DelegateTaskRepresentation requestNode);

    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/resolve")
    Call<Void> resolveCall(@Path("taskId") String taskId);

    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/groups/{groupId}")
    Call<Void> involveGroupCall(@Path("taskId") String taskId, @Path("groupId") String groupId);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/groups/{groupId}")
    Call<Void> removeInvolvedGroupCall(@Path("taskId") String taskId, @Path("groupId") String groupId);

    // FORMS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/")
    Call<FormDefinitionRepresentation> getTaskFormCall(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/task-forms/{taskId}")
    Call<Void> completeTaskFormCall(@Path("taskId") String taskId, @Body CompleteFormRepresentation request);

    @GET(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/form-values/{field}")
    Call<List<FormValueRepresentation>> getRestFieldValuesCall(@Path("taskId") String taskId,
            @Path("field") String field);

    @GET(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/form-values/{fieldId}/{column}")
    Call<List<FormValueRepresentation>> getRestFieldValuesCall(@Path("taskId") String taskId,
            @Path("fieldId") String fieldId, @Path("column") String column);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/save-form")
    Call<Void> saveTaskFormCall(@Path("taskId") String taskId, @Body SaveFormRepresentation request);

    // CHECKLIST
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/checklist")
    Call<ResultList<TaskRepresentation>> getChecklistCall(@Path("taskId") String taskId);

    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/checklist")
    Call<TaskRepresentation> addSubtaskCall(@Path("taskId") String taskId, @Body TaskRepresentation task);

    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/checklist")
    Call<Void> orderChecklistCall(@Path("taskId") String taskId, @Body ChecklistOrderRepresentation task);

    // COMMENTS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/comments")
    Call<ResultList<CommentRepresentation>> getTaskCommentsCall(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/comments")
    Call<CommentRepresentation> addTaskCommentCall(@Path("taskId") String taskId, @Body CommentRepresentation request);

    // CONTENTS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/content")
    Call<ResultList<RelatedContentRepresentation>> getRelatedContentForTaskCall(@Path("taskId") String taskId);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/raw-content?isRelatedContent=true")
    Call<RelatedContentRepresentation> createRelatedContentOnTaskCall(@Path("taskId") String taskId,
            @Part("file") RequestBody resource);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/raw-content")
    Call<RelatedContentRepresentation> createContentOnTaskCall(@Path("taskId") String taskId,
            @Part("file") RequestBody resource, @Query("isRelatedContent") Boolean isRelatedContent);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/content")
    Call<RelatedContentRepresentation> linkRelatedContentOnTaskCall(@Path("taskId") String taskId,
            @Body AddContentRelatedRepresentation representation);

    // IDENTITY LINKS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks")
    Call<ResultList<IdentityLinkRepresentation>> getIdentityLinksCall(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks")
    Call<IdentityLinkRepresentation> createIdentityLinkCall(@Path("taskId") String taskId,
            @Body IdentityLinkRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks/{family}")
    Call<List<IdentityLinkRepresentation>> getIdentityLinksForFamilyCall(@Path("taskId") String taskId,
            @Path("family") String family);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}")
    Call<ResultList<IdentityLinkRepresentation>> getIdentityLinkTypeCall(@Path("taskId") String taskId,
            @Path("family") String family, @Path("identityId") String identityId, @Path("type") String type);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}")
    Call<Void> deleteIdentityLinkCall(@Path("taskId") String taskId, @Path("family") String family,
            @Path("identityId") String identityId, @Path("type") String type);

    // AUDIT
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/audit")
    Call<TaskAuditInfoRepresentation> getTaskAuditLogCall(@Path("taskId") String taskId);

    // VARIABLES
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables")
    Call<List<RestVariable>> getVariablesCall(@Path("taskId") String taskId, @Query("scope") String scope);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables")
    Call<Void> createTaskVariableCall(@Path("taskId") String taskId, @Body List<RestVariable> restVariables);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables")
    Call<Void> deleteAllLocalTaskVariablesCall(@Path("taskId") String taskId);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables/{variableName}")
    Call<RestVariable> getVariableCall(@Path("taskId") String taskId, @Path("variableName") String variableName,
            @Query("scope") String scope);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables/{variableName}")
    Call<RestVariable> updateVariableCall(@Path("taskId") String taskId, @Path("variableName") String variableName,
            @Body RestVariable restVariable);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables/{variableName}")
    Call<Void> deleteVariableCall(@Path("taskId") String taskId, @Path("variableName") String variableName,
            @Query("scope") String scope);

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
    @POST(PROCESS_SERVICE_PATH + "/tasks/query")
    Observable<ResultList<TaskRepresentation>> listTasksObservable(@Body QueryTasksRepresentation filter);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/historic-tasks/query")
    Observable<ResultList<TaskRepresentation>> listHistoricTasksObservable(
            @Body HistoricTaskInstanceQueryRepresentation filter);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/filter")
    Observable<ResultList<TaskRepresentation>> filterTasksObservable(@Body TaskFilterRequestRepresentation filter);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}")
    Observable<TaskRepresentation> getTaskObservable(@Path("taskId") String taskId);

    @POST(PROCESS_SERVICE_PATH + "/tasks")
    Observable<TaskRepresentation> createNewTaskObservable(@Body TaskRepresentation task);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}")
    Observable<TaskRepresentation> updateTaskObservable(@Path("taskId") String taskId,
            @Body UpdateTaskRepresentation request);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}")
    Observable<Void> deleteTaskObservable(@Path("taskId") String taskId);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/complete")
    Observable<Void> completeTaskObservable(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/involve")
    Observable<Void> involveUserObservable(@Path("taskId") String taskId, @Body InvolveTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/remove-involved")
    Observable<Void> removeInvolvedUserObservable(@Path("taskId") String taskId,
            @Body InvolveTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/assign")
    Observable<TaskRepresentation> assignTaskObservable(@Path("taskId") String taskId,
            @Body AssignTaskRepresentation request);

    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/claim")
    Observable<Void> claimTaskObservable(@Path("taskId") String taskId);

    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/unclaim")
    Observable<Void> unClaimTaskObservable(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/attach-form")
    Observable<Void> attachFormObservable(@Path("taskId") String taskId,
            @Body AttachFormTaskRepresentation requestNode);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/remove-form")
    Observable<Void> removeFormObservable(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/delegate")
    Observable<Void> delegateObservable(@Path("taskId") String taskId, @Body DelegateTaskRepresentation requestNode);

    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/resolve")
    Observable<Void> resolveObservable(@Path("taskId") String taskId);

    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/groups/{groupId}")
    Observable<Void> involveGroupObservable(@Path("taskId") String taskId, @Path("groupId") String groupId);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/groups/{groupId}")
    Observable<Void> removeInvolvedGroupObservable(@Path("taskId") String taskId, @Path("groupId") String groupId);

    // FORMS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/")
    Observable<FormDefinitionRepresentation> getTaskFormObservable(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/task-forms/{taskId}")
    Observable<Void> completeTaskFormObservable(@Path("taskId") String taskId,
            @Body CompleteFormRepresentation request);

    @GET(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/form-values/{field}")
    Observable<List<FormValueRepresentation>> getRestFieldValuesObservable(@Path("taskId") String taskId,
            @Path("field") String field);

    @GET(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/form-values/{fieldId}/{column}")
    Observable<List<FormValueRepresentation>> getRestFieldValuesObservable(@Path("taskId") String taskId,
            @Path("fieldId") String fieldId, @Path("column") String column);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/save-form")
    Observable<Void> saveTaskFormObservable(@Path("taskId") String taskId, @Body SaveFormRepresentation request);

    // CHECKLIST
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/checklist")
    Observable<ResultList<TaskRepresentation>> getChecklistObservable(@Path("taskId") String taskId);

    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/checklist")
    Observable<TaskRepresentation> addSubtaskObservable(@Path("taskId") String taskId, @Body TaskRepresentation task);

    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/checklist")
    Observable<Void> orderChecklistObservable(@Path("taskId") String taskId, @Body ChecklistOrderRepresentation task);

    // COMMENTS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/comments")
    Observable<ResultList<CommentRepresentation>> getTaskCommentsObservable(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/comments")
    Observable<CommentRepresentation> addTaskCommentObservable(@Path("taskId") String taskId,
            @Body CommentRepresentation request);

    // CONTENTS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/content")
    Observable<ResultList<RelatedContentRepresentation>> getRelatedContentForTaskObservable(
            @Path("taskId") String taskId);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/raw-content?isRelatedContent=true")
    Observable<RelatedContentRepresentation> createRelatedContentOnTaskObservable(@Path("taskId") String taskId,
            @Part("file") RequestBody resource);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/raw-content")
    Observable<RelatedContentRepresentation> createContentOnTaskObservable(@Path("taskId") String taskId,
            @Part("file") RequestBody resource, @Query("isRelatedContent") Boolean isRelatedContent);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/content")
    Observable<RelatedContentRepresentation> linkRelatedContentOnTaskObservable(@Path("taskId") String taskId,
            @Body AddContentRelatedRepresentation representation);

    // IDENTITY LINKS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks")
    Observable<ResultList<IdentityLinkRepresentation>> getIdentityLinksObservable(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks")
    Observable<IdentityLinkRepresentation> createIdentityLinkObservable(@Path("taskId") String taskId,
            @Body IdentityLinkRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks/{family}")
    Observable<List<IdentityLinkRepresentation>> getIdentityLinksForFamilyObservable(@Path("taskId") String taskId,
            @Path("family") String family);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}")
    Observable<ResultList<IdentityLinkRepresentation>> getIdentityLinkTypeObservable(@Path("taskId") String taskId,
            @Path("family") String family, @Path("identityId") String identityId, @Path("type") String type);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}")
    Observable<Void> deleteIdentityLinkObservable(@Path("taskId") String taskId, @Path("family") String family,
            @Path("identityId") String identityId, @Path("type") String type);

    // AUDIT
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/audit")
    Observable<TaskAuditInfoRepresentation> getTaskAuditLogObservable(@Path("taskId") String taskId);

    // VARIABLES
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables")
    Observable<List<RestVariable>> getVariablesObservable(@Path("taskId") String taskId, @Query("scope") String scope);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables")
    Observable<Void> createTaskVariableObservable(@Path("taskId") String taskId,
            @Body List<RestVariable> restVariables);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables")
    Observable<Void> deleteAllLocalTaskVariablesObservable(@Path("taskId") String taskId);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables/{variableName}")
    Observable<RestVariable> getVariableObservable(@Path("taskId") String taskId,
            @Path("variableName") String variableName, @Query("scope") String scope);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables/{variableName}")
    Observable<RestVariable> updateVariableObservable(@Path("taskId") String taskId,
            @Path("variableName") String variableName, @Body RestVariable restVariable);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables/{variableName}")
    Observable<Void> deleteVariableObservable(@Path("taskId") String taskId, @Path("variableName") String variableName,
            @Query("scope") String scope);

}
