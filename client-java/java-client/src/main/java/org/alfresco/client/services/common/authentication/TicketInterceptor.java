package org.alfresco.client.services.common.authentication;

import java.io.IOException;

import org.alfresco.client.services.common.utils.Base64;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jpascal on 01/05/2017.
 */
public class TicketInterceptor implements Interceptor
{
    String auth;

    public TicketInterceptor(String ticket)
    {
        auth = "Basic " + Base64.encodeBytes(ticket.getBytes());
    }

    @Override
    public Response intercept(Chain chain) throws IOException
    {
        Request newRequest = chain.request().newBuilder().addHeader("Authorization", auth).build();
        return chain.proceed(newRequest);
    }
}