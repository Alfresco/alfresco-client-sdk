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

package org.alfresco.client.services.governance.api;

import java.io.IOException;

import org.alfresco.client.services.GSAPITestCase;
import org.alfresco.client.services.governance.GSAPIRegistry;
import org.alfresco.client.services.governance.core.model.RMSiteCompliance;
import org.alfresco.client.services.governance.core.model.body.RMSiteBodyCreate;
import org.alfresco.client.services.governance.core.model.body.RMSiteBodyUpdate;
import org.alfresco.client.services.governance.core.model.representation.RMSiteRepresentation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retrofit2.Response;

public class RMSiteApiTest extends GSAPITestCase
{

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test(enabled = true)
    public void rmsiteLifecycle() throws IOException
    {
        GSAPIRegistry gsRegistry = client.getGSAPIRegistry();

        // Delete preventively
        gsRegistry.getGsSitesAPI().deleteRMSiteCall().execute();

        // Get RM Site
        Response<RMSiteRepresentation> rmSiteResponse = gsRegistry.getGsSitesAPI().getRMSiteCall().execute();
        Assert.assertFalse(rmSiteResponse.isSuccessful());

        // Create RM Site
        RMSiteBodyCreate rmSiteBodyCreate = new RMSiteBodyCreate("RM Test", "RM Test Side Made by Client SDK",
                RMSiteCompliance.STANDARD);
        Response<RMSiteRepresentation> rmCreateSiteResponse = gsRegistry.getGsSitesAPI()
                .createRMSiteCall(rmSiteBodyCreate, false).execute();
        Assert.assertTrue(rmCreateSiteResponse.isSuccessful());

        RMSiteRepresentation rmSite = rmCreateSiteResponse.body();
        Assert.assertEquals(rmSite.getCompliance().toString(), RMSiteCompliance.STANDARD.toString());
        Assert.assertEquals(rmSite.getDescription(), "RM Test Side Made by Client SDK");
        Assert.assertEquals(rmSite.getTitle(), "RM Test");

        // Get RM Site
        RMSiteRepresentation rmSiteRep = gsRegistry.getGsSitesAPI().getRMSiteCall().execute().body();
        Assert.assertEquals(rmSiteRep.getId(), rmSite.getId());

        // Update RM Site
        RMSiteBodyUpdate rmSiteBodyUpdate = new RMSiteBodyUpdate("RM Site", "RM Test Description");
        RMSiteRepresentation updatedSite = gsRegistry.getGsSitesAPI().updateRMSiteCall(rmSiteBodyUpdate).execute()
                .body();
        Assert.assertEquals(updatedSite.getDescription(), "RM Test Description");
        Assert.assertEquals(updatedSite.getTitle(), "RM Site");

        // Delete RM Site
        gsRegistry.getGsSitesAPI().deleteRMSiteCall().execute();
        Assert.assertFalse(gsRegistry.getGsSitesAPI().getRMSiteCall().execute().isSuccessful());
    }

}
