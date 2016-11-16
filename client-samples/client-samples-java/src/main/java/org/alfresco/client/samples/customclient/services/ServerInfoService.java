package org.alfresco.client.samples.customclient.services;

import com.alfresco.client.api.core.model.representation.ServerInfoRepresentation;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerInfoService
{
    @GET("service/api/server")
    Call<ServerInfoRepresentation> getInfo();
}
