package com.alfresco.client.api.discovery;

import com.alfresco.client.api.discovery.model.RepositoryInfoRepresentation;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by jpascal on 04/10/2016.
 */
public interface DiscoveryAPI
{

    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get repository information **Note:** this endpoint is available in
     * Alfresco 5.2 and newer versions. Retrieves the capabilities and detailed
     * version information from the repository.
     * 
     * @return RepositoryInfoRepresentation
     */
    @GET(DiscoveryConstant.DISCOVERY_PUBLIC_API_V1 + "/discovery")
    Call<RepositoryInfoRepresentation> getRepositoryInformationCall();

    /**
     * Get repository information **Note:** this endpoint is available in
     * Alfresco 5.2 and newer versions. Retrieves the capabilities and detailed
     * version information from the repository.
     * 
     * @return RepositoryInfoRepresentation
     */
    @GET(DiscoveryConstant.DISCOVERY_PUBLIC_API_V1 + "/discovery")
    Observable<RepositoryInfoRepresentation> getRepositoryInformationObservable();

}
