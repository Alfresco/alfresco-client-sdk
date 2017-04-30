package org.alfresco.client.services.common;

/**
 * Created by jpascal on 30/04/2017.
 */
public class AbstractAPIRegistry implements APIRegistry
{
    protected RestClient restClient;

    public <T> T getAPI(final Class<T> service)
    {
        return restClient.retrofit.create(service);
    }
}
