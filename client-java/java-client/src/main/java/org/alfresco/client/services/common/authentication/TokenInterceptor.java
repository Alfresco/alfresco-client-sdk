package org.alfresco.client.services.common.authentication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jpascal on 01/05/2017.
 */
public class TokenInterceptor implements Interceptor
{
    private static final String TOKEN_TYPE_BEARER = "Bearer";

    String auth;

    public TokenInterceptor(String accessToken)
    {
        if (accessToken != null && !accessToken.isEmpty())
        {
            auth = accessToken.startsWith(TOKEN_TYPE_BEARER) ? accessToken : TOKEN_TYPE_BEARER + " " + accessToken;
        }
    }

    @Override
    public Response intercept(Chain chain) throws IOException
    {
        Request newRequest = chain.request().newBuilder().addHeader("Authorization", auth).build();
        return chain.proceed(newRequest);
    }
}
