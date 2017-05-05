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
    Call<TaskRepresentation> getTaskCall(@Path(TASK_ID) String taskId);

    @POST(PROCESS_SERVICE_PATH + "/tasks")
    Call<TaskRepresentation> createNewTaskCall(@Body TaskRepresentation task);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}")
    Call<TaskRepresentation> updateTaskCall(@Path(TASK_ID) String taskId, @Body UpdateTaskRepresentation request);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}")
    Call<Void> deleteTaskCall(@Path(TASK_ID) String taskId);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/complete")
    Call<Void> completeTaskCall(@Path(TASK_ID) String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/involve")
    Call<Void> involveUserCall(@Path(TASK_ID) String taskId, @Body InvolveTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/remove-involved")
    Call<Void> removeInvolvedUserCall(@Path(TASK_ID) String taskId, @Body InvolveTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/assign")
    Call<TaskRepresentation> assignTaskCall(@Path(TASK_ID) String taskId, @Body AssignTaskRepresentation request);

    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/claim")
    Call<Void> claimTaskCall(@Path(TASK_ID) String taskId);

    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/unclaim")
    Call<Void> unClaimTaskCall(@Path(TASK_ID) String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/attach-form")
    Call<Void> attachFormCall(@Path(TASK_ID) String taskId, @Body AttachFormTaskRepresentation requestNode);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/remove-form")
    Call<Void> removeFormCall(@Path(TASK_ID) String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/delegate")
    Call<Void> delegateCall(@Path(TASK_ID) String taskId, @Body DelegateTaskRepresentation requestNode);

    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/resolve")
    Call<Void> resolveCall(@Path(TASK_ID) String taskId);

    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/groups/{groupId}")
    Call<Void> involveGroupCall(@Path(TASK_ID) String taskId, @Path(GROUP_ID) String groupId);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/groups/{groupId}")
    Call<Void> removeInvolvedGroupCall(@Path(TASK_ID) String taskId, @Path(GROUP_ID) String groupId);

    // FORMS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/")
    Call<FormDefinitionRepresentation> getTaskFormCall(@Path(TASK_ID) String taskId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/task-forms/{taskId}")
    Call<Void> completeTaskFormCall(@Path(TASK_ID) String taskId, @Body CompleteFormRepresentation request);

    @GET(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/form-values/{field}")
    Call<List<FormValueRepresentation>> getRestFieldValuesCall(@Path(TASK_ID) String taskId, @Path(FIELD) String field);

    @GET(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/form-values/{fieldId}/{column}")
    Call<List<FormValueRepresentation>> getRestFieldValuesCall(@Path(TASK_ID) String taskId,
            @Path(FIELD_ID) String fieldId, @Path("column") String column);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/save-form")
    Call<Void> saveTaskFormCall(@Path(TASK_ID) String taskId, @Body SaveFormRepresentation request);

    // CHECKLIST
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/checklist")
    Call<ResultList<TaskRepresentation>> getChecklistCall(@Path(TASK_ID) String taskId);

    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/checklist")
    Call<TaskRepresentation> addSubtaskCall(@Path(TASK_ID) String taskId, @Body TaskRepresentation task);

    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/checklist")
    Call<Void> orderChecklistCall(@Path(TASK_ID) String taskId, @Body ChecklistOrderRepresentation task);

    // COMMENTS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/comments")
    Call<ResultList<CommentRepresentation>> getTaskCommentsCall(@Path(TASK_ID) String taskId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/comments")
    Call<CommentRepresentation> addTaskCommentCall(@Path(TASK_ID) String taskId, @Body CommentRepresentation request);

    // CONTENTS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/content")
    Call<ResultList<RelatedContentRepresentation>> getRelatedContentForTaskCall(@Path(TASK_ID) String taskId);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/raw-content?isRelatedContent=true")
    Call<RelatedContentRepresentation> createRelatedContentOnTaskCall(@Path(TASK_ID) String taskId,
            @Part("file") RequestBody resource);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/raw-content")
    Call<RelatedContentRepresentation> createContentOnTaskCall(@Path(TASK_ID) String taskId,
            @Part("file") RequestBody resource, @Query("isRelatedContent") Boolean isRelatedContent);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/content")
    Call<RelatedContentRepresentation> linkRelatedContentOnTaskCall(@Path(TASK_ID) String taskId,
            @Body AddContentRelatedRepresentation representation);

    // IDENTITY LINKS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks")
    Call<ResultList<IdentityLinkRepresentation>> getIdentityLinksCall(@Path(TASK_ID) String taskId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks")
    Call<IdentityLinkRepresentation> createIdentityLinkCall(@Path(TASK_ID) String taskId,
            @Body IdentityLinkRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks/{family}")
    Call<List<IdentityLinkRepresentation>> getIdentityLinksForFamilyCall(@Path(TASK_ID) String taskId,
            @Path(FAMILY) String family);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}")
    Call<ResultList<IdentityLinkRepresentation>> getIdentityLinkTypeCall(@Path(TASK_ID) String taskId,
            @Path(FAMILY) String family, @Path(IDENTITY_ID) String identityId, @Path(TYPE) String type);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}")
    Call<Void> deleteIdentityLinkCall(@Path(TASK_ID) String taskId, @Path(FAMILY) String family,
            @Path(IDENTITY_ID) String identityId, @Path(TYPE) String type);

    // AUDIT
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/audit")
    Call<TaskAuditInfoRepresentation> getTaskAuditLogCall(@Path(TASK_ID) String taskId);

    // VARIABLES
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables")
    Call<List<RestVariable>> getVariablesCall(@Path(TASK_ID) String taskId, @Query(SCOPE) String scope);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables")
    Call<Void> createTaskVariableCall(@Path(TASK_ID) String taskId, @Body List<RestVariable> restVariables);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables")
    Call<Void> deleteAllLocalTaskVariablesCall(@Path(TASK_ID) String taskId);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables/{variableName}")
    Call<RestVariable> getVariableCall(@Path(TASK_ID) String taskId, @Path(VARIABLE_NAME) String variableName,
            @Query(SCOPE) String scope);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables/{variableName}")
    Call<RestVariable> updateVariableCall(@Path(TASK_ID) String taskId, @Path(VARIABLE_NAME) String variableName,
            @Body RestVariable restVariable);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables/{variableName}")
    Call<Void> deleteVariableCall(@Path(TASK_ID) String taskId, @Path(VARIABLE_NAME) String variableName,
            @Query(SCOPE) String scope);

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
    Observable<TaskRepresentation> getTaskObservable(@Path(TASK_ID) String taskId);

    @POST(PROCESS_SERVICE_PATH + "/tasks")
    Observable<TaskRepresentation> createNewTaskObservable(@Body TaskRepresentation task);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}")
    Observable<TaskRepresentation> updateTaskObservable(@Path(TASK_ID) String taskId,
            @Body UpdateTaskRepresentation request);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}")
    Observable<Void> deleteTaskObservable(@Path(TASK_ID) String taskId);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/complete")
    Observable<Void> completeTaskObservable(@Path(TASK_ID) String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/involve")
    Observable<Void> involveUserObservable(@Path(TASK_ID) String taskId, @Body InvolveTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/remove-involved")
    Observable<Void> removeInvolvedUserObservable(@Path(TASK_ID) String taskId,
            @Body InvolveTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/assign")
    Observable<TaskRepresentation> assignTaskObservable(@Path(TASK_ID) String taskId,
            @Body AssignTaskRepresentation request);

    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/claim")
    Observable<Void> claimTaskObservable(@Path(TASK_ID) String taskId);

    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/unclaim")
    Observable<Void> unClaimTaskObservable(@Path(TASK_ID) String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/attach-form")
    Observable<Void> attachFormObservable(@Path(TASK_ID) String taskId,
            @Body AttachFormTaskRepresentation requestNode);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/remove-form")
    Observable<Void> removeFormObservable(@Path(TASK_ID) String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/delegate")
    Observable<Void> delegateObservable(@Path(TASK_ID) String taskId, @Body DelegateTaskRepresentation requestNode);

    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/action/resolve")
    Observable<Void> resolveObservable(@Path(TASK_ID) String taskId);

    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/groups/{groupId}")
    Observable<Void> involveGroupObservable(@Path(TASK_ID) String taskId, @Path(GROUP_ID) String groupId);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/groups/{groupId}")
    Observable<Void> removeInvolvedGroupObservable(@Path(TASK_ID) String taskId, @Path(GROUP_ID) String groupId);

    // FORMS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/")
    Observable<FormDefinitionRepresentation> getTaskFormObservable(@Path(TASK_ID) String taskId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/task-forms/{taskId}")
    Observable<Void> completeTaskFormObservable(@Path(TASK_ID) String taskId,
            @Body CompleteFormRepresentation request);

    @GET(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/form-values/{field}")
    Observable<List<FormValueRepresentation>> getRestFieldValuesObservable(@Path(TASK_ID) String taskId,
            @Path(FIELD) String field);

    @GET(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/form-values/{fieldId}/{column}")
    Observable<List<FormValueRepresentation>> getRestFieldValuesObservable(@Path(TASK_ID) String taskId,
            @Path(FIELD_ID) String fieldId, @Path("column") String column);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/task-forms/{taskId}/save-form")
    Observable<Void> saveTaskFormObservable(@Path(TASK_ID) String taskId, @Body SaveFormRepresentation request);

    // CHECKLIST
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/checklist")
    Observable<ResultList<TaskRepresentation>> getChecklistObservable(@Path(TASK_ID) String taskId);

    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/checklist")
    Observable<TaskRepresentation> addSubtaskObservable(@Path(TASK_ID) String taskId, @Body TaskRepresentation task);

    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/checklist")
    Observable<Void> orderChecklistObservable(@Path(TASK_ID) String taskId, @Body ChecklistOrderRepresentation task);

    // COMMENTS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/comments")
    Observable<ResultList<CommentRepresentation>> getTaskCommentsObservable(@Path(TASK_ID) String taskId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/comments")
    Observable<CommentRepresentation> addTaskCommentObservable(@Path(TASK_ID) String taskId,
            @Body CommentRepresentation request);

    // CONTENTS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/content")
    Observable<ResultList<RelatedContentRepresentation>> getRelatedContentForTaskObservable(
            @Path(TASK_ID) String taskId);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/raw-content?isRelatedContent=true")
    Observable<RelatedContentRepresentation> createRelatedContentOnTaskObservable(@Path(TASK_ID) String taskId,
            @Part("file") RequestBody resource);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/raw-content")
    Observable<RelatedContentRepresentation> createContentOnTaskObservable(@Path(TASK_ID) String taskId,
            @Part("file") RequestBody resource, @Query("isRelatedContent") Boolean isRelatedContent);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/content")
    Observable<RelatedContentRepresentation> linkRelatedContentOnTaskObservable(@Path(TASK_ID) String taskId,
            @Body AddContentRelatedRepresentation representation);

    // IDENTITY LINKS
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks")
    Observable<ResultList<IdentityLinkRepresentation>> getIdentityLinksObservable(@Path(TASK_ID) String taskId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks")
    Observable<IdentityLinkRepresentation> createIdentityLinkObservable(@Path(TASK_ID) String taskId,
            @Body IdentityLinkRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks/{family}")
    Observable<List<IdentityLinkRepresentation>> getIdentityLinksForFamilyObservable(@Path(TASK_ID) String taskId,
            @Path(FAMILY) String family);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}")
    Observable<ResultList<IdentityLinkRepresentation>> getIdentityLinkTypeObservable(@Path(TASK_ID) String taskId,
            @Path(FAMILY) String family, @Path(IDENTITY_ID) String identityId, @Path(TYPE) String type);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}")
    Observable<Void> deleteIdentityLinkObservable(@Path(TASK_ID) String taskId, @Path(FAMILY) String family,
            @Path(IDENTITY_ID) String identityId, @Path(TYPE) String type);

    // AUDIT
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/audit")
    Observable<TaskAuditInfoRepresentation> getTaskAuditLogObservable(@Path(TASK_ID) String taskId);

    // VARIABLES
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables")
    Observable<List<RestVariable>> getVariablesObservable(@Path(TASK_ID) String taskId, @Query(SCOPE) String scope);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables")
    Observable<Void> createTaskVariableObservable(@Path(TASK_ID) String taskId,
            @Body List<RestVariable> restVariables);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables")
    Observable<Void> deleteAllLocalTaskVariablesObservable(@Path(TASK_ID) String taskId);

    @GET(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables/{variableName}")
    Observable<RestVariable> getVariableObservable(@Path(TASK_ID) String taskId,
            @Path(VARIABLE_NAME) String variableName, @Query(SCOPE) String scope);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables/{variableName}")
    Observable<RestVariable> updateVariableObservable(@Path(TASK_ID) String taskId,
            @Path(VARIABLE_NAME) String variableName, @Body RestVariable restVariable);

    @DELETE(PROCESS_SERVICE_PATH + "/tasks/{taskId}/variables/{variableName}")
    Observable<Void> deleteVariableObservable(@Path(TASK_ID) String taskId, @Path(VARIABLE_NAME) String variableName,
            @Query(SCOPE) String scope);

}
