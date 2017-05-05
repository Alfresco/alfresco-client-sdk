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
    @GET(PROCESS_SERVICE_PATH + "/forms")
    Call<ResultList<RuntimeFormRepresentation>> getFormsCall(@Query(NAME_LIKE) String nameLike,
            @Query(APP_ID) Long appId, @Query(TENANT_ID) Long tenantId, @Query(SORT) String sort,
            @Query(ORDER) String order, @Query(START) Integer start, @Query(SIZE) Integer size);

    @GET(PROCESS_SERVICE_PATH + "/forms/{formId}")
    Call<RuntimeFormRepresentation> getFormCall(@Path(FORM_ID) Long formId);

    @GET(PROCESS_SERVICE_PATH + "/forms/{formId}/editorJson")
    Call<FormDefinitionRepresentation> getFormEditorJsonCall(@Path(FORM_ID) Long formId);

    // SUBMITTED FORMS
    // ///////////////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/form-submitted-forms/{formId}")
    Call<ResultList<SubmittedFormRepresentation>> getFormSubmittedFromsCall(@Path(FORM_ID) Long formId,
            @Query("submittedBy") Long submittedBy, @Query(START) Integer start, @Query(SIZE) Integer size);

    @GET(PROCESS_SERVICE_PATH + "/task-submitted-form/{taskId}")
    Call<SubmittedFormRepresentation> getTaskSubmittedFromsCall(@Path(TASK_ID) String taskId);

    @GET(PROCESS_SERVICE_PATH + "/process-submitted-forms/{processId}")
    Call<ResultList<SubmittedFormRepresentation>> getProcessSubmittedFromsCall(@Path(PROCESS_ID) String processId);

    @GET(PROCESS_SERVICE_PATH + "//submitted-forms/{submittedFormId]")
    Call<SubmittedFormRepresentation> getSubmittedFromCall(@Path(SUBMITTED_FORM_ID) String submittedFormId);

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

    @GET(PROCESS_SERVICE_PATH + "/forms")
    Observable<ResultList<RuntimeFormRepresentation>> getFormsObservable(@Query(NAME_LIKE) String nameLike,
            @Query(APP_ID) Long appId, @Query(TENANT_ID) Long tenantId, @Query(SORT) String sort,
            @Query(ORDER) String order, @Query(START) Integer start, @Query(SIZE) Integer size);

    @GET(PROCESS_SERVICE_PATH + "/forms/{formId}")
    Observable<RuntimeFormRepresentation> getFormObservable(@Path(FORM_ID) Long formId);

    @GET(PROCESS_SERVICE_PATH + "/forms/{formId}/editorJson")
    Observable<FormDefinitionRepresentation> getFormEditorJsonObservable(@Path(FORM_ID) Long formId);

    // SUBMITTED FORMS
    // ///////////////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/form-submitted-forms/{formId}")
    Observable<ResultList<SubmittedFormRepresentation>> getFormSubmittedFromsObservable(@Path(FORM_ID) Long formId,
            @Query("submittedBy") Long submittedBy, @Query(START) Integer start, @Query(SIZE) Integer size);

    @GET(PROCESS_SERVICE_PATH + "/task-submitted-form/{taskId}")
    Observable<SubmittedFormRepresentation> getTaskSubmittedFromsObservable(@Path(TASK_ID) String taskId);

    @GET(PROCESS_SERVICE_PATH + "/process-submitted-forms/{processId}")
    Observable<ResultList<SubmittedFormRepresentation>> getProcessSubmittedFromsObservable(
            @Path(PROCESS_ID) String processId);

    @GET(PROCESS_SERVICE_PATH + "//submitted-forms/{submittedFormId]")
    Observable<SubmittedFormRepresentation> getSubmittedFromObservable(@Path(SUBMITTED_FORM_ID) String submittedFormId);
}
