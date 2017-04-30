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

package org.alfresco.client;

import java.util.ArrayList;
import java.util.HashMap;

import org.alfresco.client.services.common.ServicesClient;
import org.alfresco.client.services.content.CSClient;
import org.alfresco.client.services.content.ContentServicesRegistry;
import org.alfresco.client.services.governance.GSAPIRegistry;
import org.alfresco.client.services.governance.GSClient;
import org.alfresco.client.services.process.PSAPIRegistry;
import org.alfresco.client.services.process.PSClient;

public class AlfrescoClient
{
    protected static final Object LOCK = new Object();

    protected static AlfrescoClient mInstance;

    protected CSClient csClient;

    protected PSClient psClient;

    protected GSClient gsClient;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    // ///////////////////////////////////////////////////////////////////////////
    public static AlfrescoClient getInstance()
    {
        synchronized (LOCK)
        {
            return mInstance;
        }
    }

    private AlfrescoClient(CSClient csClient, GSClient gsClient, PSClient psClient)
    {
        this.csClient = csClient;
        this.gsClient = gsClient;
        this.psClient = psClient;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // API REGISTRY
    // ///////////////////////////////////////////////////////////////////////////
    public ContentServicesRegistry getContentServices()
    {
        return csClient != null ? csClient.getCsAPIRegistry() : null;
    }

    public GSAPIRegistry getGovernanceServices()
    {
        return gsClient != null ? gsClient.getGSAPIRegistry() : null;
    }

    public PSAPIRegistry getProcessServices()
    {
        return psClient != null ? psClient.getPSAPIRegistry() : null;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // BUILDER
    // ///////////////////////////////////////////////////////////////////////////
    public static class Builder
    {
        // ///////////////////////////////////////////////////////////////////////////
        // MEMBERS
        // ///////////////////////////////////////////////////////////////////////////
        protected HashMap<ServicesEnum, ServicesClient.Builder> builderHashMap = new HashMap<>(3);

        protected HashMap<ServicesEnum, String> endpointHashMap = new HashMap<>(3);

        protected ArrayList<ServicesEnum> services = new ArrayList<>(3);

        protected String endpoint, username, password;

        protected String ticket, token;

        // ///////////////////////////////////////////////////////////////////////////
        // PUBLIC METHODS
        // ///////////////////////////////////////////////////////////////////////////
        public Builder connectTo(String endpoint)
        {
            this.endpoint = endpoint;
            return this;
        }

        public Builder connectTo(String endpoint, ServicesEnum serviceId)
        {
            endpointHashMap.put(serviceId, endpoint);
            return this;
        }

        public Builder addService(ServicesEnum serviceId)
        {
            services.add(serviceId);
            return this;
        }

        public Builder addServiceClientBuilder(ServicesClient.Builder builder)
        {
            if (builder instanceof CSClient.Builder)
            {
                builderHashMap.put(ServicesEnum.CONTENT_SERVICES, builder);
            }
            else if (builder instanceof GSClient.Builder)
            {
                builderHashMap.put(ServicesEnum.GOVERNANCE_SERVICES, builder);
            }
            else if (builder instanceof PSClient.Builder)
            {
                builderHashMap.put(ServicesEnum.PROCESS_SERVICES, builder);
            }
            return this;
        }

        public Builder withTicket(String ticket)
        {
            this.ticket = ticket;
            return this;
        }

        public Builder withToken(String token)
        {
            this.token = token;
            return this;
        }

        public Builder withUser(String username, String password)
        {
            this.username = username;
            this.password = password;
            return this;
        }

        // ///////////////////////////////////////////////////////////////////////////
        // GENERATE ALFRESCO CLIENT
        // ///////////////////////////////////////////////////////////////////////////
        public AlfrescoClient build()
        {
            CSClient.Builder csClient;
            PSClient.Builder psClient;
            GSClient.Builder gsClient;

            // Create Content Services
            csClient = (CSClient.Builder) generate(ServicesEnum.CONTENT_SERVICES);
            psClient = (PSClient.Builder) generate(ServicesEnum.PROCESS_SERVICES);
            gsClient = (GSClient.Builder) generate(ServicesEnum.GOVERNANCE_SERVICES);

            return new AlfrescoClient((csClient != null) ? csClient.build() : null,
                    (gsClient != null) ? gsClient.build() : null, (psClient != null) ? psClient.build() : null);
        }

        public ServicesClient.Builder generate(ServicesEnum servicesEnum)
        {
            ServicesClient.Builder clientBuilder = null;
            String localEndpoint = endpoint;

            // Create Content Services
            if (builderHashMap.containsKey(servicesEnum))
            {
                return builderHashMap.get(servicesEnum);
            }
            else if (endpointHashMap.containsKey(servicesEnum))
            {
                localEndpoint = endpointHashMap.get(servicesEnum);
            }
            else
            {
                return null;
            }

            switch (servicesEnum)
            {
                case CONTENT_SERVICES:
                    clientBuilder = new CSClient.Builder();
                    break;
                case GOVERNANCE_SERVICES:
                    clientBuilder = new GSClient.Builder();
                    break;
                case PROCESS_SERVICES:
                    clientBuilder = new PSClient.Builder();
                    break;
            }

            if (username != null)
            {
                clientBuilder.connect(localEndpoint, username, password).build();
            }
            else if (ticket != null)
            {
                clientBuilder.connectWithTicket(localEndpoint, ticket).build();
            }
            else if (token != null)
            {
                clientBuilder.connectWithToken(localEndpoint, token).build();
            }

            return clientBuilder;
        }
    }

}
