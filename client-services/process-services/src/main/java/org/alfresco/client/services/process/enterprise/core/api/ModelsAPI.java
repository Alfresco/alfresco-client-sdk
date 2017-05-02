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
import java.util.Map;

import org.alfresco.client.services.process.enterprise.common.model.representation.ResultList;
import org.alfresco.client.services.process.enterprise.core.model.editor.ModelRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.editor.validation.ValidationErrorRepresentation;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface ModelsAPI
{
    // LIST
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/models")
    Call<ResultList<ModelRepresentation>> getModelsCall(@Query("filter") String filter,
            @Query("modelType") String modelType, @Query("sort") String sort, @Query("sort") String referenceId);

    @GET("api/enterprise/models-for-app-definition")
    Call<ResultList<ModelRepresentation>> getModelsToIncludeInAppDefinition();

    // LIFECYCLE
    // ///////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/models")
    Call<ModelRepresentation> createModelCall(@Body ModelRepresentation representation);

    @GET("api/enterprise/models/{modelId}")
    Call<ModelRepresentation> getByIdCall(@Path("modelId") String modelId);

    // Since 1.3
    @GET("api/enterprise/models/{modelId}")
    @Streaming
    Call<ModelRepresentation> getModelCall(@Path("modelId") String processInstanceId,
            @Query("includePermissions") String includePermissions);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/models/{modelId}")
    Call<ModelRepresentation> updateModelCall(@Path("modelId") String modelId,
            @Body ModelRepresentation representation);

    @DELETE("api/enterprise/models/{modelId}")
    Call<ModelRepresentation> deleteModelCall(@Path("modelId") String modelId, @Query("cascade") Boolean cascade,
            @Query("deleteRuntimeApp") Boolean deleteRuntimeApp);

    // Since 1.3
    @GET("api/enterprise/models/{modelId}/thumbnail")
    Call<ResponseBody> getModelThumbnailCall(@Path("modelId") String modelId);

    @Multipart
    @POST("api/enterprise/process-models/import")
    Call<ModelRepresentation> importProcessModel(@Part("file") RequestBody file);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/models/{modelId}/clone")
    Call<ModelRepresentation> duplicateModelCall(@Path("modelId") String modelId,
            @Body ModelRepresentation representation);

    @Multipart
    @POST("api/enterprise/models/{modelId}/newversion")
    Call<ModelRepresentation> importNewVersionCall(@Path("modelId") String modelId, @Part("file") RequestBody file);

    // EDITOR
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/models/{modelId}/editor/json")
    Call<ResponseBody> getModelJSONCall(@Path("modelId") String modelId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/models/{modelId}/editor/json")
    Call<ModelRepresentation> saveModel(@Path("modelId") String modelId, @Body Map<String, List<String>> values);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/models/{modelId}/editor/validate")
    Call<List<ValidationErrorRepresentation>> validateModel(@Path("modelId") String modelId,
            @Body Map<String, List<String>> values);

    // HISTORY
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/models/{modelId}/history")
    Call<ResultList<ModelRepresentation>> getModelHistoryCollectionCall(@Path("modelId") String modelId);

    @GET("api/enterprise/models/{modelId}/history/{modelHistoryId}")
    Call<ModelRepresentation> getProcessModelHistoryCall(@Path("modelId") String modelId,
            @Path("modelHistoryId") String modelHistoryId);

    // MODELS BPMN
    // ///////////////////////////////////////////////////////////////////
    @Streaming
    @GET("api/enterprise/models/{processModelId}/bpmn20")
    Call<RequestBody> getProcessModelBpmn20Xml(@Path("processModelId") String processModelId);

    @Streaming
    @GET("api/enterprise/models/{processModelId}/history/{processModelHistoryId}/bpmn20")
    Call<RequestBody> getHistoricProcessModelBpmn20Xml(@Path("processModelId") String processModelId,
            @Path("processModelHistoryId") String processModelHistoryId);

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

    // LIST
    // ///////////////////////////////////////////////////////////////////

    @GET("api/enterprise/models")
    Observable<ResultList<ModelRepresentation>> getModelsObservable(@Query("filter") String filter,
            @Query("modelType") String modelType, @Query("sort") String sort, @Query("sort") String referenceId);

    // LIFECYCLE
    // ///////////////////////////////////////////////////////////////////

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/models")
    Observable<ModelRepresentation> createModelObservable(@Body ModelRepresentation representation);

    @GET("api/enterprise/models/{modelId}")
    Observable<ModelRepresentation> getByIdObservable(@Path("modelId") String modelId);

    // Since 1.3

    @GET("api/enterprise/models/{modelId}")
    @Streaming
    Observable<ModelRepresentation> getModelObservable(@Path("modelId") String processInstanceId,
            @Query("includePermissions") String includePermissions);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/models/{modelId}")
    Observable<ModelRepresentation> updateModelObservable(@Path("modelId") String modelId,
            @Body ModelRepresentation representation);

    @DELETE("api/enterprise/models/{modelId}")
    Observable<ModelRepresentation> deleteModelObservable(@Path("modelId") String modelId,
            @Query("cascade") Boolean cascade, @Query("deleteRuntimeApp") Boolean deleteRuntimeApp);

    // Since 1.3

    // Since 1.3
    @GET("api/enterprise/models/{modelId}/thumbnail")
    Observable<ResponseBody> getModelThumbnailObservable(@Path("modelId") String modelId);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/models/{modelId}/clone")
    Observable<ModelRepresentation> duplicateModelObservable(@Path("modelId") String modelId,
            @Body ModelRepresentation representation);

    @Multipart
    @POST("api/enterprise/models/{modelId}/newversion")
    Observable<ModelRepresentation> importNewVersionObservable(@Path("modelId") String modelId,
            @Part("file") RequestBody file);

    // EDITOR
    // ///////////////////////////////////////////////////////////////////

    @GET("api/enterprise/models/{modelId}/editor/json")
    Observable<ResponseBody> getModelJSONObservable(@Path("modelId") String modelId);

    // HISTORY
    // ///////////////////////////////////////////////////////////////////

    @GET("api/enterprise/models/{modelId}/history")
    Observable<ResultList<ModelRepresentation>> getModelHistoryCollectionObservable(@Path("modelId") String modelId);

    @GET("api/enterprise/models/{modelId}/history/{modelHistoryId}")
    Observable<ModelRepresentation> getProcessModelHistoryObservable(@Path("modelId") String modelId,
            @Path("modelHistoryId") String modelHistoryId);

}
