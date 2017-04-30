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

import org.alfresco.client.services.process.core.model.common.ResultList;
import org.alfresco.client.services.process.core.model.editor.ModelRepresentation;

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
    Call<ResultList<ModelRepresentation>> getModels(@Query("filter") String filter,
            @Query("modelType") String modelType, @Query("sort") String sort, @Query("sort") String referenceId);

    @GET("api/enterprise/models")
    Observable<ResultList<ModelRepresentation>> getModelsObservable(@Query("filter") String filter,
            @Query("modelType") String modelType, @Query("sort") String sort, @Query("sort") String referenceId);

    // LIFECYCLE
    // ///////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/models")
    Call<ModelRepresentation> createModel(@Body ModelRepresentation representation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/models")
    Observable<ModelRepresentation> createModelObservable(@Body ModelRepresentation representation);

    @GET("api/enterprise/models/{modelId}")
    Call<ModelRepresentation> getById(@Path("modelId") String modelId);

    @GET("api/enterprise/models/{modelId}")
    Observable<ModelRepresentation> getByIdObservable(@Path("modelId") String modelId);

    // Since 1.3
    @GET("api/enterprise/models/{modelId}")
    @Streaming
    Call<ModelRepresentation> getModel(@Path("modelId") String processInstanceId,
            @Query("includePermissions") String includePermissions);

    @GET("api/enterprise/models/{modelId}")
    @Streaming
    Observable<ModelRepresentation> getModelObservable(@Path("modelId") String processInstanceId,
            @Query("includePermissions") String includePermissions);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/models/{modelId}")
    Call<ModelRepresentation> updateModel(@Path("modelId") String modelId, @Body ModelRepresentation representation);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/models/{modelId}")
    Observable<ModelRepresentation> updateModelObservable(@Path("modelId") String modelId,
            @Body ModelRepresentation representation);

    @DELETE("api/enterprise/models/{modelId}")
    Call<ModelRepresentation> deleteModel(@Path("modelId") String modelId, @Query("cascade") Boolean cascade,
            @Query("deleteRuntimeApp") Boolean deleteRuntimeApp);

    @DELETE("api/enterprise/models/{modelId}")
    Observable<ModelRepresentation> deleteModelObservable(@Path("modelId") String modelId,
            @Query("cascade") Boolean cascade, @Query("deleteRuntimeApp") Boolean deleteRuntimeApp);

    // Since 1.3
    @GET("api/enterprise/models/{modelId}/thumbnail")
    Call<ResponseBody> getModelThumbnail(@Path("modelId") String modelId);

    // Since 1.3
    @GET("api/enterprise/models/{modelId}/thumbnail")
    Observable<ResponseBody> getModelThumbnailObservable(@Path("modelId") String modelId);

    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/models/{modelId}/clone")
    Call<ModelRepresentation> duplicateModel(@Path("modelId") String modelId, @Body ModelRepresentation representation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/models/{modelId}/clone")
    Observable<ModelRepresentation> duplicateModelObservable(@Path("modelId") String modelId,
            @Body ModelRepresentation representation);

    @Multipart
    @POST("api/enterprise/models/{modelId}/newversion")
    Call<ModelRepresentation> importNewVersion(@Path("modelId") String modelId, @Part("file") RequestBody file);

    @Multipart
    @POST("api/enterprise/models/{modelId}/newversion")
    Observable<ModelRepresentation> importNewVersionObservable(@Path("modelId") String modelId,
            @Part("file") RequestBody file);

    // EDITOR
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/models/{modelId}/editor/json")
    Call<ResponseBody> getModelJSON(@Path("modelId") String modelId);

    @GET("api/enterprise/models/{modelId}/editor/json")
    Observable<ResponseBody> getModelJSONObservable(@Path("modelId") String modelId);

    // HISTORY
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/models/{modelId}/history")
    Call<ResultList<ModelRepresentation>> getModelHistoryCollection(@Path("modelId") String modelId);

    @GET("api/enterprise/models/{modelId}/history")
    Observable<ResultList<ModelRepresentation>> getModelHistoryCollectionObservable(@Path("modelId") String modelId);

    @GET("api/enterprise/models/{modelId}/history/{modelHistoryId}")
    Call<ModelRepresentation> getProcessModelHistory(@Path("modelId") String modelId,
            @Path("modelHistoryId") String modelHistoryId);

    @GET("api/enterprise/models/{modelId}/history/{modelHistoryId}")
    Observable<ModelRepresentation> getProcessModelHistoryObservable(@Path("modelId") String modelId,
            @Path("modelHistoryId") String modelHistoryId);

}
