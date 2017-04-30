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

package org.alfresco.client.services.process.core.api;

import java.util.List;

import org.alfresco.client.services.process.core.model.common.ResultList;
import org.alfresco.client.services.process.core.model.editor.form.FormDefinitionRepresentation;
import org.alfresco.client.services.process.core.model.editor.form.OptionRepresentation;
import org.alfresco.client.services.process.core.model.editor.form.request.CompleteFormRepresentation;
import org.alfresco.client.services.process.core.model.runtime.*;
import org.alfresco.client.services.process.core.model.runtime.request.*;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 11/12/2014.
 */
public interface TaskAPI
{
    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/tasks/query")
    Call<ResultList<TaskRepresentation>> listTasks(@Body QueryTasksRepresentation filter);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/tasks/query")
    Observable<ResultList<TaskRepresentation>> listTasksObservable(@Body QueryTasksRepresentation filter);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/tasks/filter")
    Call<ResultList<TaskRepresentation>> filterTasks(@Body TaskFilterRequestRepresentation filter);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/tasks/filter")
    Observable<ResultList<TaskRepresentation>> filterTasksObservable(@Body TaskFilterRequestRepresentation filter);

    @GET("api/enterprise/tasks/{taskId}")
    Call<TaskRepresentation> getTask(@Path("taskId") String taskId);

    @GET("api/enterprise/tasks/{taskId}")
    Observable<TaskRepresentation> getTaskObservable(@Path("taskId") String taskId);

    @POST("api/enterprise/tasks")
    Call<TaskRepresentation> createNewTask(@Body TaskRepresentation task);

    @POST("api/enterprise/tasks")
    Observable<TaskRepresentation> createNewTaskObservable(@Body TaskRepresentation task);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/tasks/{taskId}")
    Call<TaskRepresentation> updateTask(@Path("taskId") String taskId, @Body UpdateTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/tasks/{taskId}")
    Observable<TaskRepresentation> updateTaskObservable(@Path("taskId") String taskId,
            @Body UpdateTaskRepresentation request);

    @DELETE("api/enterprise/tasks/{taskId}")
    Call<Void> deleteTask(@Path("taskId") String taskId);

    @DELETE("api/enterprise/tasks/{taskId}")
    Observable<Void> deleteTaskObservable(@Path("taskId") String taskId);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @PUT("api/enterprise/tasks/{taskId}/action/complete")
    Call<Void> completeTask(@Path("taskId") String taskId);

    @PUT("api/enterprise/tasks/{taskId}/action/complete")
    Observable<Void> completeTaskObservable(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/tasks/{taskId}/action/involve")
    Call<Void> involveUser(@Path("taskId") String taskId, @Body InvolveTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/tasks/{taskId}/action/involve")
    Observable<Void> involveUserObservable(@Path("taskId") String taskId, @Body InvolveTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/tasks/{taskId}/action/remove-involved")
    Call<Void> removeInvolvedUser(@Path("taskId") String taskId, @Body InvolveTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/tasks/{taskId}/action/remove-involved")
    Observable<Void> removeInvolvedUserObservable(@Path("taskId") String taskId,
            @Body InvolveTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/tasks/{taskId}/action/assign")
    Call<TaskRepresentation> assignTask(@Path("taskId") String taskId, @Body AssignTaskRepresentation request);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/tasks/{taskId}/action/assign")
    Observable<TaskRepresentation> assignTaskObservable(@Path("taskId") String taskId,
            @Body AssignTaskRepresentation request);

    @PUT("api/enterprise/tasks/{taskId}/action/claim")
    Call<Void> claimTask(@Path("taskId") String taskId);

    @PUT("api/enterprise/tasks/{taskId}/action/claim")
    Observable<Void> claimTaskObservable(@Path("taskId") String taskId);

    @PUT("api/enterprise/tasks/{taskId}/action/unclaim")
    Call<Void> unClaimTask(@Path("taskId") String taskId);

    @PUT("api/enterprise/tasks/{taskId}/action/unclaim")
    Observable<Void> unClaimTaskObservable(@Path("taskId") String taskId);

    @PUT("api/enterprise/tasks/{taskId}/action/attach-form")
    Call<Void> attachForm(@Path("taskId") String taskId, @Body AttachFormTaskRepresentation requestNode);

    @PUT("api/enterprise/tasks/{taskId}/action/attach-form")
    Observable<Void> attachFormObservable(@Path("taskId") String taskId,
            @Body AttachFormTaskRepresentation requestNode);

    @DELETE("api/enterprise/tasks/{taskId}/action/remove-form")
    Call<Void> removeForm(@Path("taskId") String taskId);

    @DELETE("api/enterprise/tasks/{taskId}/action/remove-form")
    Observable<Void> removeFormObservable(@Path("taskId") String taskId);

    // FORMS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/task-forms/{taskId}/form-values/{fieldId}")
    Call<List<OptionRepresentation>> getFormFieldValues(@Path("taskId") String taskId, @Path("fieldId") String fieldId);

    @GET("api/enterprise/task-forms/{taskId}/form-values/{fieldId}")
    Observable<List<OptionRepresentation>> getFormFieldValuesObservable(@Path("taskId") String taskId,
            @Path("fieldId") String fieldId);

    @GET("api/enterprise/task-forms/{taskId}/")
    Call<FormDefinitionRepresentation> getTaskForm(@Path("taskId") String taskId);

    @GET("api/enterprise/task-forms/{taskId}/")
    Observable<FormDefinitionRepresentation> getTaskFormObservable(@Path("taskId") String taskId);

    @POST("api/enterprise/task-forms/{taskId}")
    Call<Void> completeTaskForm(@Path("taskId") String taskId, @Body CompleteFormRepresentation request);

    @POST("api/enterprise/task-forms/{taskId}")
    Observable<Void> completeTaskFormObservable(@Path("taskId") String taskId,
            @Body CompleteFormRepresentation request);

    @POST("api/enterprise/task-forms/{taskId}/save-form")
    Call<Void> saveTaskForm(@Path("taskId") String taskId, @Body SaveFormRepresentation request);

    @POST("api/enterprise/task-forms/{taskId}/save-form")
    Observable<Void> saveTaskFormObservable(@Path("taskId") String taskId, @Body SaveFormRepresentation request);

    // CHECKLIST
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/tasks/{taskId}/checklist")
    Call<ResultList<TaskRepresentation>> getChecklist(@Path("taskId") String taskId);

    @GET("api/enterprise/tasks/{taskId}/checklist")
    Observable<ResultList<TaskRepresentation>> getChecklistObservable(@Path("taskId") String taskId);

    @POST("api/enterprise/tasks/{taskId}/checklist")
    Call<TaskRepresentation> addSubtask(@Path("taskId") String taskId, @Body TaskRepresentation task);

    @POST("api/enterprise/tasks/{taskId}/checklist")
    Observable<TaskRepresentation> addSubtaskObservable(@Path("taskId") String taskId, @Body TaskRepresentation task);

    @POST("api/enterprise/tasks/{taskId}/checklist")
    Call<Void> orderChecklist(@Path("taskId") String taskId, @Body ChecklistOrderRepresentation task);

    @POST("api/enterprise/tasks/{taskId}/checklist")
    Observable<Void> orderChecklistObservable(@Path("taskId") String taskId, @Body ChecklistOrderRepresentation task);

    // COMMENTS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/tasks/{taskId}/comments")
    Call<ResultList<CommentRepresentation>> getTaskComments(@Path("taskId") String taskId);

    @GET("api/enterprise/tasks/{taskId}/comments")
    Observable<ResultList<CommentRepresentation>> getTaskCommentsObservable(@Path("taskId") String taskId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/tasks/{taskId}/comments")
    Call<CommentRepresentation> addTaskComment(@Path("taskId") String taskId, @Body CommentRepresentation request);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/tasks/{taskId}/comments")
    Observable<CommentRepresentation> addTaskCommentObservable(@Path("taskId") String taskId,
            @Body CommentRepresentation request);

    // CONTENTS
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/tasks/{taskId}/content")
    Call<ResultList<RelatedContentRepresentation>> getRelatedContentForTask(@Path("taskId") String taskId);

    @GET("api/enterprise/tasks/{taskId}/content")
    Observable<ResultList<RelatedContentRepresentation>> getRelatedContentForTaskObservable(
            @Path("taskId") String taskId);

    @Multipart
    @POST("api/enterprise/tasks/{taskId}/raw-content?isRelatedContent=true")
    Call<RelatedContentRepresentation> createRelatedContentOnTask(@Path("taskId") String taskId,
            @Part("file") RequestBody resource);

    @Multipart
    @POST("api/enterprise/tasks/{taskId}/raw-content?isRelatedContent=true")
    Observable<RelatedContentRepresentation> createRelatedContentOnTaskObservable(@Path("taskId") String taskId,
            @Part("file") RequestBody resource);

    @Multipart
    @POST("api/enterprise/tasks/{taskId}/raw-content")
    Call<RelatedContentRepresentation> createContentOnTask(@Path("taskId") String taskId,
            @Part("file") RequestBody resource, @Query("isRelatedContent") Boolean isRelatedContent);

    @Multipart
    @POST("api/enterprise/tasks/{taskId}/raw-content")
    Observable<RelatedContentRepresentation> createContentOnTaskObservable(@Path("taskId") String taskId,
            @Part("file") RequestBody resource, @Query("isRelatedContent") Boolean isRelatedContent);

    @POST("api/enterprise/tasks/{taskId}/content")
    Call<RelatedContentRepresentation> linkRelatedContentOnTask(@Path("taskId") String taskId,
            @Body AddContentRelatedRepresentation representation);

    @POST("api/enterprise/tasks/{taskId}/content")
    Observable<RelatedContentRepresentation> linkRelatedContentOnTaskObservable(@Path("taskId") String taskId,
            @Body AddContentRelatedRepresentation representation);

}
