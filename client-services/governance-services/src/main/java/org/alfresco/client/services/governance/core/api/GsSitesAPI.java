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

import static org.alfresco.client.services.common.constant.ApiConstant.FIELDS;
import static org.alfresco.client.services.common.constant.ApiConstant.SKIP_ADD_TO_FAVORITES;

import org.alfresco.client.services.common.model.parameters.FieldsParam;
import org.alfresco.client.services.governance.core.GovernanceConstant;
import org.alfresco.client.services.governance.core.model.body.RMSiteBodyCreate;
import org.alfresco.client.services.governance.core.model.body.RMSiteBodyUpdate;
import org.alfresco.client.services.governance.core.model.representation.RMSiteRepresentation;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface GsSitesAPI
{
    // ///////////////////////////////////////////////////////////////////////////
    // GET
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get the RM site **Note:** this endpoint is available in RM 2.6 and newer
     * versions. Gets information for RM site.
     * 
     * @return ApiResponse&lt;RMSiteEntry&gt;
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites/rm")
    Call<RMSiteRepresentation> getRMSiteCall();

    /**
     * Get the RM site **Note:** this endpoint is available in RM 2.6 and newer
     * versions. Gets information for RM site.
     * 
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RMSiteRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites/rm")
    Call<RMSiteRepresentation> getRMSiteCall(@Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create the RM site **Note:** this endpoint is available in RM 2.6 and
     * newer versions. Creates the RM site with the given details. **Note:** the
     * id of a site cannot be updated once the site has been created. For
     * example, to create the RM site named \&quot;Records Management
     * Title\&quot; with \&quot;Records Management Description\&quot; as
     * description, the following body could be used: &#x60;&#x60;&#x60;JSON {
     * \&quot;title\&quot;: \&quot;Records Management Title\&quot;,
     * \&quot;description\&quot;: \&quot;Records Management Description\&quot; }
     * &#x60;&#x60;&#x60; The creator will be added as a member with Site
     * Manager role. When you create the RM site, the **filePlan** structure is
     * also created.
     * 
     * @param siteBodyCreate The site details (required)
     * @return RMSiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites")
    Call<RMSiteRepresentation> createRMSiteCall(@Body RMSiteBodyCreate siteBodyCreate);

    /**
     * Create the RM site **Note:** this endpoint is available in RM 2.6 and
     * newer versions. Creates the RM site with the given details. **Note:** the
     * id of a site cannot be updated once the site has been created. For
     * example, to create the RM site named \&quot;Records Management
     * Title\&quot; with \&quot;Records Management Description\&quot; as
     * description, the following body could be used: &#x60;&#x60;&#x60;JSON {
     * \&quot;title\&quot;: \&quot;Records Management Title\&quot;,
     * \&quot;description\&quot;: \&quot;Records Management Description\&quot; }
     * &#x60;&#x60;&#x60; The creator will be added as a member with Site
     * Manager role. When you create the RM site, the **filePlan** structure is
     * also created.
     * 
     * @param siteBodyCreate The site details (required)
     * @param skipAddToFavorites Flag to indicate whether the RM site should not
     *            be added to the user&#39;s site favorites. (optional, default
     *            to false)
     * @return RMSiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites")
    Call<RMSiteRepresentation> createRMSiteCall(@Body RMSiteBodyCreate siteBodyCreate,
            @Query(SKIP_ADD_TO_FAVORITES) boolean skipAddToFavorites);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update the RM site **Note:** this endpoint is available in RM 2.6 and
     * newer versions. Update the details for the RM site. Site Manager or
     * otherwise a (site) admin can update title or description. **Note**: the
     * id, site visibility or compliance of the RM site cannot be updated once
     * the RM site has been created.
     * 
     * @param siteBodyUpdate The RM site information to update. (required)
     * @return RMSiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites/rm")
    Call<RMSiteRepresentation> updateRMSiteCall(@Body RMSiteBodyUpdate siteBodyUpdate);

    /**
     * Update the RM site **Note:** this endpoint is available in RM 2.6 and
     * newer versions. Update the details for the RM site. Site Manager or
     * otherwise a (site) admin can update title or description. **Note**: the
     * id, site visibility or compliance of the RM site cannot be updated once
     * the RM site has been created.
     * 
     * @param siteBodyUpdate The RM site information to update. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RMSiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites/rm")
    Call<RMSiteRepresentation> updateRMSiteCall(@Body RMSiteBodyUpdate siteBodyUpdate,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete the RM site **Note:** this endpoint is available in RM 2.6 and
     * newer versions. Deletes the RM site.
     * 
     * @return Void
     */
    @DELETE(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites/rm")
    Call<Void> deleteRMSiteCall();

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
    // GET
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get the RM site **Note:** this endpoint is available in RM 2.6 and newer
     * versions. Gets information for RM site.
     *
     * @return ApiResponse&lt;RMSiteEntry&gt;
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites/rm")
    Observable<RMSiteRepresentation> getRMSiteObservable();

    /**
     * Get the RM site **Note:** this endpoint is available in RM 2.6 and newer
     * versions. Gets information for RM site.
     *
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RMSiteRepresentation
     */
    @GET(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites/rm")
    Observable<RMSiteRepresentation> getRMSiteObservable(@Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create the RM site **Note:** this endpoint is available in RM 2.6 and
     * newer versions. Creates the RM site with the given details. **Note:** the
     * id of a site cannot be updated once the site has been created. For
     * example, to create the RM site named \&quot;Records Management
     * Title\&quot; with \&quot;Records Management Description\&quot; as
     * description, the following body could be used: &#x60;&#x60;&#x60;JSON {
     * \&quot;title\&quot;: \&quot;Records Management Title\&quot;,
     * \&quot;description\&quot;: \&quot;Records Management Description\&quot; }
     * &#x60;&#x60;&#x60; The creator will be added as a member with Site
     * Manager role. When you create the RM site, the **filePlan** structure is
     * also created.
     *
     * @param siteBodyCreate The site details (required)
     * @return RMSiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites")
    Observable<RMSiteRepresentation> createRMSiteObservable(@Body RMSiteBodyCreate siteBodyCreate);

    /**
     * Create the RM site **Note:** this endpoint is available in RM 2.6 and
     * newer versions. Creates the RM site with the given details. **Note:** the
     * id of a site cannot be updated once the site has been created. For
     * example, to create the RM site named \&quot;Records Management
     * Title\&quot; with \&quot;Records Management Description\&quot; as
     * description, the following body could be used: &#x60;&#x60;&#x60;JSON {
     * \&quot;title\&quot;: \&quot;Records Management Title\&quot;,
     * \&quot;description\&quot;: \&quot;Records Management Description\&quot; }
     * &#x60;&#x60;&#x60; The creator will be added as a member with Site
     * Manager role. When you create the RM site, the **filePlan** structure is
     * also created.
     *
     * @param siteBodyCreate The site details (required)
     * @param skipAddToFavorites Flag to indicate whether the RM site should not
     *            be added to the user&#39;s site favorites. (optional, default
     *            to false)
     * @return RMSiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @POST(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites")
    Observable<RMSiteRepresentation> createRMSiteObservable(@Body RMSiteBodyCreate siteBodyCreate,
            @Query(SKIP_ADD_TO_FAVORITES) boolean skipAddToFavorites);

    // ///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Update the RM site **Note:** this endpoint is available in RM 2.6 and
     * newer versions. Update the details for the RM site. Site Manager or
     * otherwise a (site) admin can update title or description. **Note**: the
     * id, site visibility or compliance of the RM site cannot be updated once
     * the RM site has been created.
     *
     * @param siteBodyUpdate The RM site information to update. (required)
     * @return RMSiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites/rm")
    Observable<RMSiteRepresentation> updateRMSiteObservable(@Body RMSiteBodyUpdate siteBodyUpdate);

    /**
     * Update the RM site **Note:** this endpoint is available in RM 2.6 and
     * newer versions. Update the details for the RM site. Site Manager or
     * otherwise a (site) admin can update title or description. **Note**: the
     * id, site visibility or compliance of the RM site cannot be updated once
     * the RM site has been created.
     *
     * @param siteBodyUpdate The RM site information to update. (required)
     * @param fields A list of field names. You can use this parameter to
     *            restrict the fields returned within a response if, for
     *            example, you want to save on overall bandwidth. The list
     *            applies to a returned individual entity or entries within a
     *            collection. If the API method also supports the **include**
     *            parameter, then the fields specified in the **include**
     *            parameter are returned in addition to those specified in the
     *            **fields** parameter. (optional)
     * @return RMSiteRepresentation
     */
    @Headers({ "Content-type: application/json" })
    @PUT(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites/rm")
    Observable<RMSiteRepresentation> updateRMSiteObservable(@Body RMSiteBodyUpdate siteBodyUpdate,
            @Query(FIELDS) FieldsParam fields);

    // ///////////////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Delete the RM site **Note:** this endpoint is available in RM 2.6 and
     * newer versions. Deletes the RM site.
     *
     * @return Void
     */
    @DELETE(GovernanceConstant.GS_PUBLIC_API_V1 + "/gs-sites/rm")
    Observable<Void> deleteRMSiteObservable();

}
