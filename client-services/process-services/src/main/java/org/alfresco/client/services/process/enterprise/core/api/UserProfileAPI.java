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
import org.alfresco.client.services.process.enterprise.core.model.idm.ResetPasswordRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.idm.UserRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.idm.request.ChangePasswordRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.idm.request.UpdateProfileRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.runtime.integration.dto.AlfrescoEndpointRepresentation;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 11/12/2014.
 */
public interface UserProfileAPI
{
    @GET("api/enterprise/profile")
    Call<UserRepresentation> getProfileCall();

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/profile")
    Call<UserRepresentation> updateUserCall(@Body UpdateProfileRepresentation request);

    @GET("api/enterprise/profile-picture")
    Call<Void> getProfilePictureCall();

    @Multipart
    @POST("api/enterprise/profile-picture")
    Call<ResponseBody> uploadProfilePictureCall(@Part("file") RequestBody resource);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/profile-password")
    Call<UserRepresentation> changePasswordCall(@Body ChangePasswordRepresentation request);

    @GET("api/enterprise/profile/accounts/alfresco")
    Call<ResultList<AlfrescoEndpointRepresentation>> getRepositories();

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/idm/passwords")
    Call<Void> requestPasswordResetCall(@Body ResetPasswordRepresentation request);

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

    @GET("api/enterprise/profile")
    Observable<UserRepresentation> getProfileObservable();

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/profile")
    Observable<UserRepresentation> updateUserObservable(@Body UpdateProfileRepresentation request);

    @GET("api/enterprise/profile-picture")
    Observable<Void> getProfilePictureObservable();

    @Multipart
    @POST("api/enterprise/profile-picture")
    Observable<ResponseBody> uploadProfilePictureObservable(@Part("file") RequestBody resource);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/profile-password")
    Observable<UserRepresentation> changePasswordObservable(@Body ChangePasswordRepresentation request);

    @GET("api/enterprise/profile/accounts/alfresco")
    Observable<ResultList<AlfrescoEndpointRepresentation>> getRepositoriesObservable();

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/idm/passwords")
    Observable<Void> requestPasswordResetObservable(@Body ResetPasswordRepresentation request);
}
