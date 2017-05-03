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
import org.alfresco.client.services.process.enterprise.core.model.editor.form.FormDefinitionRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.runtime.RuntimeFormRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.runtime.SubmittedFormRepresentation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface FormsAPI
{
    @GET("api/enterprise/forms")
    Call<ResultList<RuntimeFormRepresentation>> getFormsCall(@Query("nameLike") String nameLike,
            @Query("appId") Long appId, @Query("tenantId") Long tenantId, @Query("sort") String sort,
            @Query("order") String order, @Query("start") Integer start, @Query("size") Integer size);

    @GET("api/enterprise/forms/{formId}")
    Call<RuntimeFormRepresentation> getFormCall(@Path("formId") Long formId);

    @GET("api/enterprise/forms/{formId}/editorJson")
    Call<FormDefinitionRepresentation> getFormEditorJsonCall(@Path("formId") Long formId);

    // SUBMITTED FORMS
    // ///////////////////////////////////////////////////////////////////////////
    @GET("api/enterprise/form-submitted-forms/{formId}")
    Call<ResultList<SubmittedFormRepresentation>> getFormSubmittedFromsCall(@Path("formId") Long formId,
            @Query("submittedBy") Long submittedBy, @Query("start") Integer start, @Query("size") Integer size);

    @GET("api/enterprise/task-submitted-form/{taskId}")
    Call<SubmittedFormRepresentation> getTaskSubmittedFromsCall(@Path("taskId") String taskId);

    @GET("api/enterprise/process-submitted-forms/{processId}")
    Call<ResultList<SubmittedFormRepresentation>> getProcessSubmittedFromsCall(@Path("processId") String processId);

    @GET("api/enterprise//submitted-forms/{submittedFormId]")
    Call<SubmittedFormRepresentation> getSubmittedFromCall(@Path("submittedFormId") String submittedFormId);

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

    @GET("api/enterprise/forms")
    Observable<ResultList<RuntimeFormRepresentation>> getFormsObservable(@Query("nameLike") String nameLike,
            @Query("appId") Long appId, @Query("tenantId") Long tenantId, @Query("sort") String sort,
            @Query("order") String order, @Query("start") Integer start, @Query("size") Integer size);

    @GET("api/enterprise/forms/{formId}")
    Observable<RuntimeFormRepresentation> getFormObservable(@Path("formId") Long formId);

    @GET("api/enterprise/forms/{formId}/editorJson")
    Observable<FormDefinitionRepresentation> getFormEditorJsonObservable(@Path("formId") Long formId);

    // SUBMITTED FORMS
    // ///////////////////////////////////////////////////////////////////////////
    @GET("api/enterprise/form-submitted-forms/{formId}")
    Observable<ResultList<SubmittedFormRepresentation>> getFormSubmittedFromsObservable(@Path("formId") Long formId,
            @Query("submittedBy") Long submittedBy, @Query("start") Integer start, @Query("size") Integer size);

    @GET("api/enterprise/task-submitted-form/{taskId}")
    Observable<SubmittedFormRepresentation> getTaskSubmittedFromsObservable(@Path("taskId") String taskId);

    @GET("api/enterprise/process-submitted-forms/{processId}")
    Observable<ResultList<SubmittedFormRepresentation>> getProcessSubmittedFromsObservable(
            @Path("processId") String processId);

    @GET("api/enterprise//submitted-forms/{submittedFormId]")
    Observable<SubmittedFormRepresentation> getSubmittedFromObservable(@Path("submittedFormId") String submittedFormId);
}
