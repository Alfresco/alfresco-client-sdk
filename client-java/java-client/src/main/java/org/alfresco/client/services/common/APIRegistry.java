package org.alfresco.client.services.common;

/**
 * Created by jpascal on 01/05/2017.
 */
public interface APIRegistry
{
    <T> T getAPI(final Class<T> service);
}
