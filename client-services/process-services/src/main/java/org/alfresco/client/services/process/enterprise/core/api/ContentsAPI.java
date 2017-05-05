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

    @GET(PROCESS_SERVICE_PATH + "/content/{contentId}")
    Call<RelatedContentRepresentation> getContentCall(@Path(CONTENT_ID) String contentId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/content")
    Call<RelatedContentRepresentation> createTemporaryRelatedContentCall(
            @Body AddContentRelatedRepresentation representation);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/content/raw")
    Call<RelatedContentRepresentation> createTemporaryRawRelatedContentCall(@Part(FILE) RequestBody body);

    @DELETE(PROCESS_SERVICE_PATH + "/content/{contentId}")
    Call<Void> deleteContentCall(@Path(CONTENT_ID) String contentId);

    @GET(PROCESS_SERVICE_PATH + "/content/{contentId}/raw")
    Call<ResponseBody> getRawContentCall(@Path(CONTENT_ID) String contentId);

    @GET(PROCESS_SERVICE_PATH + "/content/{contentId}/rendition/{renditionType}")
    Call<ResponseBody> getContentRenditionCall(@Path(CONTENT_ID) String contentId,
            @Path(RENDITION_TYPE) String renditionType);

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

    @GET(PROCESS_SERVICE_PATH + "/content/{contentId}")
    Observable<RelatedContentRepresentation> getContentObservable(@Path(CONTENT_ID) String contentId);

    @Headers({ "Content-type: application/json" })
    @POST(PROCESS_SERVICE_PATH + "/content")
    Observable<RelatedContentRepresentation> createTemporaryRelatedContentObservable(
            @Body AddContentRelatedRepresentation representation);

    @Multipart
    @POST(PROCESS_SERVICE_PATH + "/content/raw")
    Observable<RelatedContentRepresentation> createTemporaryRawRelatedContentObservable(@Part(FILE) RequestBody body);

    @DELETE(PROCESS_SERVICE_PATH + "/content/{contentId}")
    Observable<Void> deleteContentObservable(@Path(CONTENT_ID) String contentId);

    @GET(PROCESS_SERVICE_PATH + "/content/{contentId}/raw")
    Observable<ResponseBody> getRawContentObservable(@Path(CONTENT_ID) String contentId);

    @GET(PROCESS_SERVICE_PATH + "/content/{contentId}/rendition/{renditionType}")
    Observable<ResponseBody> getContentRenditionObservable(@Path(CONTENT_ID) String contentId,
            @Path(RENDITION_TYPE) String renditionType);

}
