/*
 *   Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *   This file is part of Alfresco Java Client.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.alfresco.client.services.governance.core.api;

import org.alfresco.client.services.common.constant.PublicAPIConstant;
import org.alfresco.client.services.content.core.model.parameters.FieldsParam;
import org.alfresco.client.services.content.core.model.parameters.IncludeParam;
import org.alfresco.client.services.governance.core.GovernanceConstant;
import org.alfresco.client.services.governance.core.model.representation.RecordRepresentation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface FilesAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // ACTIONS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Declare as record Declares the file **fileId** in the unfiled record
     * container.
     * 
     * @param fileId The identifier of a non-record file. (required)
     * @return RecordRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/files/{fileId}/declare")
    Call<RecordRepresentation> declareRecordCall(@Path("fileId") String fileId);

    /**
     * Declare as record Declares the file **fileId** in the unfiled record
     * container.
     * 
     * @param fileId The identifier of a non-record file. (required)
     * @param hideRecord Flag to indicate whether the record should be hidden
     *            from the current parent folder. (optional, default to false)
     * @param include Returns additional information about the record. Any
     *            optional field from the response model can be requested. For
     *            example: * isCompleted * content * allowableOperations * path
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/files/{fileId}/declare")
    Call<RecordRepresentation> declareRecordCall(@Path("fileId") String fileId, @Query("hideRecord") boolean hideRecord,
            @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

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

    // ///////////////////////////////////////////////////////////////////////////
    // ACTIONS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Declare as record Declares the file **fileId** in the unfiled record
     * container.
     *
     * @param fileId The identifier of a non-record file. (required)
     * @return RecordRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/files/{fileId}/declare")
    Observable<RecordRepresentation> declareRecordObservable(@Path("fileId") String fileId);

    /**
     * Declare as record Declares the file **fileId** in the unfiled record
     * container.
     *
     * @param fileId The identifier of a non-record file. (required)
     * @param hideRecord Flag to indicate whether the record should be hidden
     *            from the current parent folder. (optional, default to false)
     * @param include Returns additional information about the record. Any
     *            optional field from the response model can be requested. For
     *            example: * isCompleted * content * allowableOperations * path
     *            (optional)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RecordRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/files/{fileId}/declare")
    Observable<RecordRepresentation> declareRecordObservable(@Path("fileId") String fileId,
            @Query("hideRecord") boolean hideRecord, @Query(PublicAPIConstant.INCLUDE_VALUE) IncludeParam include,
            @Query(PublicAPIConstant.FIELDS_VALUE) FieldsParam fields);

}
