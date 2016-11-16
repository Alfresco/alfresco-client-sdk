package com.alfresco.client.api.authentication;

import com.alfresco.client.api.authentication.body.TicketBody;
import com.alfresco.client.api.authentication.representation.TicketRepresentation;
import com.alfresco.client.api.authentication.representation.ValidTicketRepresentation;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by jpascal on 04/10/2016.
 */
public interface AuthenticationAPI
{

    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Create ticket (login) **Note:** this endpoint is available in Alfresco
     * 5.2 and newer versions. Logs in and returns the new authentication
     * ticket. The userId and password properties are mandatory in the request
     * body. For example: &#x60;&#x60;&#x60;JSON { \&quot;userId\&quot;:
     * \&quot;jbloggs\&quot;, \&quot;password\&quot;: \&quot;password\&quot; }
     * &#x60;&#x60;&#x60; To use the ticket in future requests you should pass
     * it in the request header. For example using Javascript:
     * &#x60;&#x60;&#x60;Javascript request.setRequestHeader
     * (\&quot;Authorization\&quot;, \&quot;Basic \&quot; + btoa(ticket));
     * &#x60;&#x60;&#x60;
     * 
     * @param ticketBodyCreate The user credential. (required)
     * @return TicketRepresentation
     */
    @POST(AuthenticationConstant.AUTHENTICATION_PUBLIC_API_V1 + "/tickets")
    Call<TicketRepresentation> createTicketCall(@Body TicketBody ticketBodyCreate);

    /**
     * Create ticket (login) **Note:** this endpoint is available in Alfresco
     * 5.2 and newer versions. Logs in and returns the new authentication
     * ticket. The userId and password properties are mandatory in the request
     * body. For example: &#x60;&#x60;&#x60;JSON { \&quot;userId\&quot;:
     * \&quot;jbloggs\&quot;, \&quot;password\&quot;: \&quot;password\&quot; }
     * &#x60;&#x60;&#x60; To use the ticket in future requests you should pass
     * it in the request header. For example using Javascript:
     * &#x60;&#x60;&#x60;Javascript request.setRequestHeader
     * (\&quot;Authorization\&quot;, \&quot;Basic \&quot; + btoa(ticket));
     * &#x60;&#x60;&#x60;
     *
     * @param ticketBodyCreate The user credential. (required)
     * @return TicketRepresentation
     */
    @POST(AuthenticationConstant.AUTHENTICATION_PUBLIC_API_V1 + "/tickets")
    Observable<TicketRepresentation> createTicketObservable(@Body TicketBody ticketBodyCreate);

    /**
     * Validate ticket **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. Validates the specified ticket (derived from
     * Authorization header) is still valid. For example, you can pass the
     * Authorization request header using Javascript:
     * &#x60;&#x60;&#x60;Javascript request.setRequestHeader
     * (\&quot;Authorization\&quot;, \&quot;Basic \&quot; + btoa(ticket));
     * &#x60;&#x60;&#x60;
     * 
     * @return ValidTicketRepresentation
     */
    @GET(AuthenticationConstant.AUTHENTICATION_PUBLIC_API_V1 + "/tickets/-me-")
    Call<ValidTicketRepresentation> validateTicketCall();

    /**
     * Validate ticket **Note:** this endpoint is available in Alfresco 5.2 and
     * newer versions. Validates the specified ticket (derived from
     * Authorization header) is still valid. For example, you can pass the
     * Authorization request header using Javascript:
     * &#x60;&#x60;&#x60;Javascript request.setRequestHeader
     * (\&quot;Authorization\&quot;, \&quot;Basic \&quot; + btoa(ticket));
     * &#x60;&#x60;&#x60;
     *
     * @return ValidTicketRepresentation
     */
    @GET(AuthenticationConstant.AUTHENTICATION_PUBLIC_API_V1 + "/tickets/-me-")
    Observable<ValidTicketRepresentation> validateTicketObservable();

    /**
     * Delete ticket (logout) **Note:** this endpoint is available in Alfresco
     * 5.2 and newer versions. Deletes logged in ticket (logout).
     */
    @DELETE(AuthenticationConstant.AUTHENTICATION_PUBLIC_API_V1 + "/tickets/-me-")
    Call<Void> deleteTicketCall();

    /**
     * Delete ticket (logout) **Note:** this endpoint is available in Alfresco
     * 5.2 and newer versions. Deletes logged in ticket (logout).
     */
    @DELETE(AuthenticationConstant.AUTHENTICATION_PUBLIC_API_V1 + "/tickets/-me-")
    Observable<Void> deleteTicketObservable();

}
