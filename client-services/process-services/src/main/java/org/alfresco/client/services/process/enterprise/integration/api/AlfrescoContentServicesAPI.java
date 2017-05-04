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
import org.alfresco.client.services.process.enterprise.core.model.runtime.integration.dto.AlfrescoEndpointRepresentation;
import org.alfresco.client.services.process.enterprise.integration.model.representation.AlfrescoContentRepresentation;
import org.alfresco.client.services.process.enterprise.integration.model.representation.AlfrescoSiteRepresenation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by jpascal on 11/12/2014.
 */
public interface AlfrescoContentServicesAPI
{
    @GET(PROCESS_SERVICE_PATH + "/profile/accounts/alfresco")
    Call<ResultList<AlfrescoEndpointRepresentation>> getRepositoriesCall();

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco/{repositoryId}/sites")
    Call<ResultList<AlfrescoSiteRepresenation>> getAllSitesCall(@Path("repositoryId") String repositoryId);

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco/{repositoryId}/sites/{siteId}/content")
    Call<ResultList<AlfrescoContentRepresentation>> getContentInSiteCall(@Path("repositoryId") String repositoryId,
            @Path("siteId") String siteId);

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco/{repositoryId}/folders/{folderId}/content")
    Call<ResultList<AlfrescoContentRepresentation>> getContentInFolderCall(@Path("repositoryId") String repositoryId,
            @Path("siteId") String siteId);

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

    @GET(PROCESS_SERVICE_PATH + "/profile/accounts/alfresco")
    Observable<ResultList<AlfrescoEndpointRepresentation>> getRepositoriesObservable();

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco/{repositoryId}/sites")
    Observable<ResultList<AlfrescoSiteRepresenation>> getAllSitesObservable(@Path("repositoryId") String repositoryId);

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco/{repositoryId}/sites/{siteId}/content")
    Observable<ResultList<AlfrescoContentRepresentation>> getContentInSiteObservable(
            @Path("repositoryId") String repositoryId, @Path("siteId") String siteId);

    @GET(PROCESS_SERVICE_PATH + "/integration/alfresco/{repositoryId}/folders/{folderId}/content")
    Observable<ResultList<AlfrescoContentRepresentation>> getContentInFolderObservable(
            @Path("repositoryId") String repositoryId, @Path("siteId") String siteId);
}
