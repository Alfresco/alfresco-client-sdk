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

package org.alfresco.client.services.process.enterprise.discovery.api;

import static org.alfresco.client.services.process.enterprise.ProcessServicesConstant.PROCESS_SERVICE_PATH;
import static org.alfresco.client.services.process.enterprise.common.constant.RequestConstant.TENANT_ID;

import org.alfresco.client.services.process.enterprise.discovery.model.runtime.AppVersionRepresentation;
import org.alfresco.client.services.process.enterprise.discovery.model.runtime.GlobalDateFormatRepresentation;
import org.alfresco.client.services.process.enterprise.discovery.model.runtime.PasswordValidationConstraints;
import org.alfresco.client.services.process.enterprise.discovery.model.runtime.SystemPropertiesRepresentation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by jpascal on 23/03/2015.
 */
public interface DiscoveryAPI
{
    @GET(PROCESS_SERVICE_PATH + "/app-version")
    Call<AppVersionRepresentation> getAppVersionCall();

    @GET(PROCESS_SERVICE_PATH + "/system/properties")
    Call<SystemPropertiesRepresentation> getPropertiesCall();

    @GET(PROCESS_SERVICE_PATH + "/system/properties/password-validation-constraints/{tenantId}")
    Call<PasswordValidationConstraints> getPasswordValidationConstraintsCall(@Path(TENANT_ID) String tenantI);

    @GET(PROCESS_SERVICE_PATH + "/system/properties/involved-users-can-edit-forms/{tenantId}")
    Call<Boolean> involvedUsersCanEditFormsCall(@Path(TENANT_ID) String tenantId);

    @GET(PROCESS_SERVICE_PATH + "/system/properties/global-date-format/{tenantId}")
    Call<GlobalDateFormatRepresentation> getGlobalDateFormatCall(@Path(TENANT_ID) String tenantId);

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

    @GET(PROCESS_SERVICE_PATH + "/app-version")
    Observable<AppVersionRepresentation> getAppVersionObservable();

    @GET(PROCESS_SERVICE_PATH + "/system/properties")
    Observable<SystemPropertiesRepresentation> getPropertiesObservable();

    @GET(PROCESS_SERVICE_PATH + "/system/properties/password-validation-constraints/{tenantId}")
    Observable<PasswordValidationConstraints> getPasswordValidationConstraintsObservable(
            @Path(TENANT_ID) String tenantI);

    @GET(PROCESS_SERVICE_PATH + "/system/properties/involved-users-can-edit-forms/{tenantId}")
    Observable<Boolean> involvedUsersCanEditFormsObservable(@Path(TENANT_ID) String tenantId);

    @GET(PROCESS_SERVICE_PATH + "/system/properties/global-date-format/{tenantId}")
    Observable<GlobalDateFormatRepresentation> getGlobalDateFormatObservable(@Path(TENANT_ID) String tenantId);
}
