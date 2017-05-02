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

import org.alfresco.client.services.process.enterprise.core.model.runtime.RelatedContentRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.runtime.request.AddContentRelatedRepresentation;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 11/12/2014.
 */
public interface ContentsAPI
{

    @GET("api/enterprise/content/{contentId}")
    Call<RelatedContentRepresentation> getContentCall(@Path("contentId") String contentId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/content")
    Call<RelatedContentRepresentation> createTemporaryRelatedContentCall(
            @Body AddContentRelatedRepresentation representation);

    @Multipart
    @POST("api/enterprise/content/raw")
    Call<RelatedContentRepresentation> createTemporaryRawRelatedContentCall(@Part("file") RequestBody body);

    @DELETE("api/enterprise/content/{contentId}")
    Call<Void> deleteContentCall(@Path("contentId") String contentId);

    @GET("api/enterprise/content/{contentId}/raw")
    Call<ResponseBody> getRawContentCall(@Path("contentId") String contentId);

    @GET("api/enterprise/content/{contentId}/rendition/{renditionType}")
    Call<ResponseBody> getContentRenditionCall(@Path("contentId") String contentId,
            @Path("renditionType") String renditionType);

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

    @GET("api/enterprise/content/{contentId}")
    Observable<RelatedContentRepresentation> getContentObservable(@Path("contentId") String contentId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/content")
    Observable<RelatedContentRepresentation> createTemporaryRelatedContentObservable(
            @Body AddContentRelatedRepresentation representation);

    @Multipart
    @POST("api/enterprise/content/raw")
    Observable<RelatedContentRepresentation> createTemporaryRawRelatedContentObservable(@Part("file") RequestBody body);

    @DELETE("api/enterprise/content/{contentId}")
    Observable<Void> deleteContentObservable(@Path("contentId") String contentId);

    @GET("api/enterprise/content/{contentId}/raw")
    Observable<ResponseBody> getRawContentObservable(@Path("contentId") String contentId);

    @GET("api/enterprise/content/{contentId}/rendition/{renditionType}")
    Observable<ResponseBody> getContentRenditionObservable(@Path("contentId") String contentId,
            @Path("renditionType") String renditionType);

}
