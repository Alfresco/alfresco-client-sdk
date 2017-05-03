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

package org.alfresco.client.services.process.enterprise.integration.api;

import org.alfresco.client.services.process.enterprise.common.model.representation.ResultList;
import org.alfresco.client.services.process.enterprise.integration.model.body.UserAccountCredentialsRepresentation;
import org.alfresco.client.services.process.enterprise.integration.model.representation.BoxContent;
import org.alfresco.client.services.process.enterprise.integration.model.representation.BoxUserAccountCredentialsRepresentation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 11/12/2014.
 */
public interface BoxAPI
{
    @GET("api/enterprise/integration/box/confirm-auth-request")
    Call<ResponseBody> confirmAuthorisationCall(@Query("code") String authorizationCode);

    @GET("api/enterprise/integration/box/files")
    Call<ResultList<BoxContent>> getFilesCall(@Query("filter") String filter, @Query("parent") String parent);

    @GET("api/enterprise/integration/box/status")
    Call<Boolean> getBoxPluginStatus();

    @GET("api/enterprise/integration/box/{userId}/account")
    Call<BoxUserAccountCredentialsRepresentation> getRepositoryAccountCall(@Path("userId") Long userId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/integration/box/{userId}/account")
    Call<BoxUserAccountCredentialsRepresentation> createRepositoryAccountCall(@Path("userId") Long userId,
            @Body UserAccountCredentialsRepresentation credentials);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/integration/box/{userId}/account")
    Call<BoxUserAccountCredentialsRepresentation> updateRepositoryAccountCall(@Path("userId") Long userId,
            @Body UserAccountCredentialsRepresentation credentials);

    @DELETE("api/enterprise/integration/box/{userId}/account")
    Call<Void> deleteRepositoryAccountCall(@Path("userId") Long userId);

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
    @GET("api/enterprise/integration/box/confirm-auth-request")
    Observable<ResponseBody> confirmAuthorisationObservable(@Query("code") String authorizationCode);

    @GET("api/enterprise/integration/box/files")
    Observable<ResultList<BoxContent>> getFilesObservable(@Query("filter") String filter,
            @Query("parent") String parent);

    @GET("api/enterprise/integration/box/status")
    Observable<Boolean> getBoxPluginStatusObservable();

    @GET("api/enterprise/integration/box/{userId}/account")
    Observable<BoxUserAccountCredentialsRepresentation> getRepositoryAccountObservable(@Path("userId") Long userId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/integration/box/{userId}/account")
    Observable<BoxUserAccountCredentialsRepresentation> createRepositoryAccountObservable(@Path("userId") Long userId,
            @Body UserAccountCredentialsRepresentation credentials);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/integration/box/{userId}/account")
    Observable<BoxUserAccountCredentialsRepresentation> updateRepositoryAccountObservable(@Path("userId") Long userId,
            @Body UserAccountCredentialsRepresentation credentials);

    @DELETE("api/enterprise/integration/box/{userId}/account")
    Observable<Void> deleteRepositoryAccountObservable(@Path("userId") Long userId);
}
