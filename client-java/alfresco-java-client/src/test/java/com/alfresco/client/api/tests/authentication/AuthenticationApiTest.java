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

package com.alfresco.client.api.tests.authentication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alfresco.client.api.AlfrescoAPITestCase;
import com.alfresco.client.api.authentication.AuthenticationAPI;
import com.alfresco.client.api.authentication.body.TicketBody;
import com.alfresco.client.api.authentication.representation.TicketRepresentation;
import com.alfresco.client.api.authentication.representation.ValidTicketRepresentation;
import com.alfresco.client.api.core.NodesAPI;
import com.alfresco.client.api.core.model.representation.NodeRepresentation;

import retrofit2.Response;

public class AuthenticationApiTest extends AlfrescoAPITestCase
{

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void authenticate() throws IOException
    {

        AuthenticationAPI authAPI = client.getAuthenticationAPI();

        // Validate undefined ticket
        Response<ValidTicketRepresentation> validate = authAPI.validateTicketCall().execute();
        Assert.assertFalse(validate.isSuccessful());

        // Create Ticket
        Response<TicketRepresentation> ticketResponse = authAPI
                .createTicketCall(new TicketBody(TEST_USERNAME, TEST_PASSWORD)).execute();
        Assert.assertTrue(ticketResponse.isSuccessful());

        TicketRepresentation ticket = ticketResponse.body();
        Assert.assertTrue(ticket.getId().startsWith("TICKET_"), "Ticket value doesn't start with TICKET_ prefix");
        Assert.assertEquals(TEST_USERNAME, ticket.getUserId(), "Ticket userId is not " + TEST_USERNAME);

        // Get Ticket
        // Need to refresh client object with new credentials
        client = prepareClientTicket(TEST_ENDPOINT, ticket.getId());
        authAPI = client.getAuthenticationAPI();

        // Check it works
        Response<NodeRepresentation> nodeResponse = client.getNodesAPI().getNodeCall(NodesAPI.FOLDER_MY).execute();
        Assert.assertTrue(nodeResponse.isSuccessful());

        // Validate again
        validate = authAPI.validateTicketCall().execute();
        Assert.assertTrue(validate.isSuccessful());
    }
}
