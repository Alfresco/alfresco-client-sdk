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
    @GET(PROCESS_SERVICE_PATH + "/models")
    Call<ResultList<ModelRepresentation>> getModelsCall(@Query(FILTER) String filter,
            @Query(MODEL_TYPE) String modelType, @Query(SORT) String sort, @Query(REFERENCE_ID) String referenceId);

    @GET(PROCESS_SERVICE_PATH + "/models-for-app-definition")
    Call<ResultList<ModelRepresentation>> getModelsToIncludeInAppDefinitionCall();

    // LIFECYCLE
    // ///////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/models")
    Call<ModelRepresentation> createModelCall(@Body ModelRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/models/{modelId}")
    Call<ModelRepresentation> getByIdCall(@Path(MODEL_ID) String modelId);

    // Since 1.3
    @GET(PROCESS_SERVICE_PATH + "/models/{modelId}")
    @Streaming
    Call<ModelRepresentation> getModelCall(@Path(MODEL_ID) String processInstanceId,
            @Query("includePermissions") String includePermissions);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/models/{modelId}")
    Call<ModelRepresentation> updateModelCall(@Path(MODEL_ID) String modelId,
            @Body ModelRepresentation representation);

    @DELETE(PROCESS_SERVICE_PATH + "/models/{modelId}")
    Call<ModelRepresentation> deleteModelCall(@Path(MODEL_ID) String modelId, @Query(CASCADE) Boolean cascade,
            @Query(DELETE_RUNTIME_APP) Boolean deleteRuntimeApp);

    // Since 1.3
    @GET(PROCESS_SERVICE_PATH + "/models/{modelId}/thumbnail")
    Call<ResponseBody> getModelThumbnailCall(@Path(MODEL_ID) String modelId);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/process-models/import")
    Call<ModelRepresentation> importProcessModelCall(@Part(FILE) RequestBody file);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/models/{modelId}/clone")
    Call<ModelRepresentation> duplicateModelCall(@Path(MODEL_ID) String modelId,
            @Body ModelRepresentation representation);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/models/{modelId}/newversion")
    Call<ModelRepresentation> importNewVersionCall(@Path(MODEL_ID) String modelId, @Part(FILE) RequestBody file);

    // EDITOR
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/models/{modelId}/editor/json")
    Call<ResponseBody> getModelJSONCall(@Path(MODEL_ID) String modelId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/models/{modelId}/editor/json")
    Call<ModelRepresentation> saveModelCall(@Path(MODEL_ID) String modelId, @Body Map<String, List<String>> values);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/models/{modelId}/editor/validate")
    Call<List<ValidationErrorRepresentation>> validateModelCall(@Path(MODEL_ID) String modelId,
            @Body Map<String, List<String>> values);

    // HISTORY
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/models/{modelId}/history")
    Call<ResultList<ModelRepresentation>> getModelHistoryCollectionCall(@Path(MODEL_ID) String modelId);

    @GET(PROCESS_SERVICE_PATH + "/models/{modelId}/history/{modelHistoryId}")
    Call<ModelRepresentation> getProcessModelHistoryCall(@Path(MODEL_ID) String modelId,
            @Path(MODEL_HISTORY_ID) String modelHistoryId);

    // MODELS BPMN
    // ///////////////////////////////////////////////////////////////////
    @Streaming
    @GET(PROCESS_SERVICE_PATH + "/models/{processModelId}/bpmn20")
    Call<RequestBody> getProcessModelBpmn20XmlCall(@Path(PROCESS_MODEL_ID) String processModelId);

    @Streaming
    @GET(PROCESS_SERVICE_PATH + "/models/{processModelId}/history/{processModelHistoryId}/bpmn20")
    Call<RequestBody> getHistoricProcessModelBpmn20XmlCall(@Path(PROCESS_MODEL_ID) String processModelId,
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
    @GET(PROCESS_SERVICE_PATH + "/models")
    Observable<ResultList<ModelRepresentation>> getModelsObservable(@Query(FILTER) String filter,
            @Query(MODEL_TYPE) String modelType, @Query(SORT) String sort, @Query(SORT) String referenceId);

    @GET(PROCESS_SERVICE_PATH + "/models-for-app-definition")
    Observable<ResultList<ModelRepresentation>> getModelsToIncludeInAppDefinitionObservable();

    // LIFECYCLE
    // ///////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/models")
    Observable<ModelRepresentation> createModelObservable(@Body ModelRepresentation representation);

    @GET(PROCESS_SERVICE_PATH + "/models/{modelId}")
    Observable<ModelRepresentation> getByIdObservable(@Path(MODEL_ID) String modelId);

    // Since 1.3
    @GET(PROCESS_SERVICE_PATH + "/models/{modelId}")
    @Streaming
    Observable<ModelRepresentation> getModelObservable(@Path(MODEL_ID) String processInstanceId,
            @Query("includePermissions") String includePermissions);

    @Headers({ "Content-type: application/json" })
    @PUT(PROCESS_SERVICE_PATH + "/models/{modelId}")
    Observable<ModelRepresentation> updateModelObservable(@Path(MODEL_ID) String modelId,
            @Body ModelRepresentation representation);

    @DELETE(PROCESS_SERVICE_PATH + "/models/{modelId}")
    Observable<ModelRepresentation> deleteModelObservable(@Path(MODEL_ID) String modelId,
            @Query(CASCADE) Boolean cascade, @Query(DELETE_RUNTIME_APP) Boolean deleteRuntimeApp);

    // Since 1.3
    @GET(PROCESS_SERVICE_PATH + "/models/{modelId}/thumbnail")
    Observable<ResponseBody> getModelThumbnailObservable(@Path(MODEL_ID) String modelId);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/process-models/import")
    Observable<ModelRepresentation> importProcessModelObservable(@Part(FILE) RequestBody file);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/models/{modelId}/clone")
    Observable<ModelRepresentation> duplicateModelObservable(@Path(MODEL_ID) String modelId,
            @Body ModelRepresentation representation);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/models/{modelId}/newversion")
    Observable<ModelRepresentation> importNewVersionObservable(@Path(MODEL_ID) String modelId,
            @Part(FILE) RequestBody file);

    // EDITOR
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/models/{modelId}/editor/json")
    Observable<ResponseBody> getModelJSONObservable(@Path(MODEL_ID) String modelId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/models/{modelId}/editor/json")
    Observable<ModelRepresentation> saveModelObservable(@Path(MODEL_ID) String modelId,
            @Body Map<String, List<String>> values);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/models/{modelId}/editor/validate")
    Observable<List<ValidationErrorRepresentation>> validateModelObservable(@Path(MODEL_ID) String modelId,
            @Body Map<String, List<String>> values);

    // HISTORY
    // ///////////////////////////////////////////////////////////////////
    @GET(PROCESS_SERVICE_PATH + "/models/{modelId}/history")
    Observable<ResultList<ModelRepresentation>> getModelHistoryCollectionObservable(@Path(MODEL_ID) String modelId);

    @GET(PROCESS_SERVICE_PATH + "/models/{modelId}/history/{modelHistoryId}")
    Observable<ModelRepresentation> getProcessModelHistoryObservable(@Path(MODEL_ID) String modelId,
            @Path(MODEL_HISTORY_ID) String modelHistoryId);

    // MODELS BPMN
    // ///////////////////////////////////////////////////////////////////
    @Streaming
    @GET(PROCESS_SERVICE_PATH + "/models/{processModelId}/bpmn20")
    Observable<RequestBody> getProcessModelBpmn20XmlObservable(@Path(PROCESS_MODEL_ID) String processModelId);

    @Streaming
    @GET(PROCESS_SERVICE_PATH + "/models/{processModelId}/history/{processModelHistoryId}/bpmn20")
    Observable<RequestBody> getHistoricProcessModelBpmn20XmlObservable(@Path(PROCESS_MODEL_ID) String processModelId,
            @Path("processModelHistoryId") String processModelHistoryId);

}
