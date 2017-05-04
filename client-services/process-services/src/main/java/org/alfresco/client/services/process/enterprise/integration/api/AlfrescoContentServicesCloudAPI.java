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

import static org.alfresco.client.services.process.enterprise.ProcessServicesConstant.PROCESS_SERVICE_PATH;

import org.alfresco.client.services.process.enterprise.common.model.representation.ResultList;
import org.alfresco.client.services.process.enterprise.integration.model.representation.AlfrescoContentRepresentation;
import org.alfresco.client.services.process.enterprise.integration.model.representation.AlfrescoNetworkRepresenation;
import org.alfresco.client.services.process.enterprise.integration.model.representation.AlfrescoSiteRepresenation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jpascal on 11/12/2014.
 */
public interface AlfrescoContentServicesCloudAPI
{
    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco-cloud/confirm-auth-request")
    Call<ResponseBody> confirmAuthorisationCall(@Query("code") String authorizationCode);

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco-cloud/networks")
    Call<ResultList<AlfrescoNetworkRepresenation>> getAllNetworksCall();

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco-cloud/networks/{networkId}/sites")
    Call<ResultList<AlfrescoSiteRepresenation>> getAllSitesCall(@Path("networkId") String networkId);

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco-cloud/networks/{networkId}/sites/{siteId}/content")
    Call<ResultList<AlfrescoContentRepresentation>> getContentInSiteCall(@Path("networkId") String networkId,
            @Path("siteId") String siteId);

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco-cloud/networks/{networkId}/folders/{folderId}/content")
    Call<ResultList<AlfrescoContentRepresentation>> getContentInFolderCall(@Path("repositoryId") String repositoryId,
            @Path("folderId") String folderId);

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
    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco-cloud/confirm-auth-request")
    Observable<ResponseBody> confirmAuthorisationObservable(@Query("code") String authorizationCode);

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco-cloud/networks")
    Observable<ResultList<AlfrescoNetworkRepresenation>> getAllNetworksObservable();

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco-cloud/networks/{networkId}/sites")
    Observable<ResultList<AlfrescoSiteRepresenation>> getAllSitesObservable(@Path("networkId") String networkId);

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco-cloud/networks/{networkId}/sites/{siteId}/content")
    Observable<ResultList<AlfrescoContentRepresentation>> getContentInSiteObservable(
            @Path("networkId") String networkId, @Path("siteId") String siteId);

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco-cloud/networks/{networkId}/folders/{folderId}/content")
    Observable<ResultList<AlfrescoContentRepresentation>> getContentInFolderObservable(
            @Path("repositoryId") String repositoryId, @Path("folderId") String folderId);
}
