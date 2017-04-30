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
import org.alfresco.client.services.process.core.model.runtime.FormValueRepresentation;
import org.alfresco.client.services.process.core.model.runtime.ProcessDefinitionRepresentation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jpascal on 11/12/2014.
 */
public interface ProcessDefinitionAPI
{
    @GET("api/enterprise/process-definitions")
    Call<ResultList<ProcessDefinitionRepresentation>> getProcessDefinitions();

    @GET("api/enterprise/process-definitions")
    Observable<ResultList<ProcessDefinitionRepresentation>> getProcessDefinitionsObservable();

    @GET("api/enterprise/process-definitions")
    Call<ResultList<ProcessDefinitionRepresentation>> getProcessDefinitions(
            @Query("appDefinitionId") Long appDefinitionId);

    @GET("api/enterprise/process-definitions")
    Observable<ResultList<ProcessDefinitionRepresentation>> getProcessDefinitionsObservable(
            @Query("appDefinitionId") Long appDefinitionId);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/start-form")
    Call<FormDefinitionRepresentation> getProcessDefinitionStartForm(
            @Path("processDefinitionId") Long processDefinitionId);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/start-form")
    Observable<FormDefinitionRepresentation> getProcessDefinitionStartFormObservable(
            @Path("processDefinitionId") Long processDefinitionId);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/start-form-values/{field}")
    Call<List<FormValueRepresentation>> getRestFieldValues(@Path("processDefinitionId") Long processDefinitionId,
            @Path("field") String field);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/start-form-values/{field}")
    Observable<List<FormValueRepresentation>> getRestFieldValuesObservable(
            @Path("processDefinitionId") Long processDefinitionId, @Path("field") String field);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/start-form-values/{field}/{column}")
    Call<List<FormValueRepresentation>> getRestTableFieldValues(@Path("processDefinitionId") Long processDefinitionId,
            @Path("field") String field, @Path("column") String column);

    @GET("api/enterprise/process-definitions/{processDefinitionId}/start-form-values/{field}/{column}")
    Observable<List<FormValueRepresentation>> getRestTableFieldValuesObservable(
            @Path("processDefinitionId") Long processDefinitionId, @Path("field") String field,
            @Path("column") String column);

}
