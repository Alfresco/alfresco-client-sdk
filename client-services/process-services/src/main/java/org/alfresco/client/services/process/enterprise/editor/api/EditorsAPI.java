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

package org.alfresco.client.services.process.enterprise.editor.api;

import java.util.List;

import org.alfresco.client.services.process.enterprise.admin.model.representation.EndpointConfigurationRepresentation;
import org.alfresco.client.services.process.enterprise.common.model.representation.ResultList;
import org.alfresco.client.services.process.enterprise.core.model.editor.form.FormRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.editor.form.FormSaveRepresentation;
import org.alfresco.client.services.process.enterprise.editor.model.DataSourceRepresentation;

import retrofit2.Call;
import retrofit2.http.*;

public interface EditorsAPI
{
    @GET("api/enterprise/editor/data-sources")
    Call<DataSourceRepresentation> getDataSourcesCall(@Path("modelId") String modelId);

    @GET("api/enterprise/editor/endpoints")
    Call<List<EndpointConfigurationRepresentation>> getEndpointConfigurationsCall();

    @GET("api/enterprise/editor/endpoints/{endpointConfigurationId}")
    Call<EndpointConfigurationRepresentation> getEndpointConfigurationsCall(
            @Path("endpointConfigurationId") String endpointConfigurationId);

    // ///////////////////////////////////////////////////////////////////////////
    // FORM MODELS
    // ///////////////////////////////////////////////////////////////////////////
    @GET("api/enterprise/editor/form-models")
    Call<ResultList<FormRepresentation>> getFormsCall();

    @GET("api/enterprise/editor/form-models/values")
    Call<List<FormRepresentation>> getFormsCall(@Query("formId") String[] formId);

    @GET("api/enterprise/editor/form-models/{formId}")
    Call<FormRepresentation> getFormCall(@Path("formId") Long formId);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/editor/form-models/{formId}")
    Call<FormRepresentation> saveFormCall(@Path("formId") Long formId, @Body FormSaveRepresentation saveRepresentation);

    @GET("api/enterprise/editor/form-models/{formId}/history/{formHistoryId}")
    Call<FormRepresentation> getFormHistoryCall(@Path("formId") Long formId, @Path("formHistoryId") Long formHistoryId);

    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/editor/form-models/{formId}/validate")
    Call<FormRepresentation> validateCall(@Path("formId") Long formId, @Body FormSaveRepresentation saveRepresentation);

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

}
