package org.alfresco.client.services.process.activiti.core.api;

import static org.alfresco.client.services.process.activiti.core.ActivitiConstant.ACTIVITI_SERVICE_PATH;

import java.util.List;

import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;
import org.alfresco.client.services.process.activiti.core.model.body.UserInfoRequest;
import org.alfresco.client.services.process.activiti.core.model.body.UserRequest;
import org.alfresco.client.services.process.activiti.core.model.representation.UserInfoResponse;
import org.alfresco.client.services.process.activiti.core.model.representation.UserResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 03/05/2017.
 */
public interface UsersAPI
{

    /**
     * Create a user
     *
     * @param body (optional)
     * @return UserResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/identity/users")
    Call<UserResponse> createUserCall(@Body UserRequest body);

    /**
     * Create a new user's info entry
     *
     * @param userId The id of the user to create the info for. (required)
     * @param body (optional)
     * @return UserInfoResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/info")
    Call<UserResponse> createUserInfoCall(@Path("userId") String userId, @Body UserInfoRequest body);

    /**
     * Delete a user
     *
     * @param userId The id of the user to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}")
    Call<Void> deleteUserCall(@Path("userId") String userId);

    /**
     * Delete a user"s info
     *
     * @param userId The id of the user to delete the info for. (required)
     * @param key The key of the user info to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/info/{key}")
    Call<Void> deleteUserInfoCall(@Path("userId") String userId, @Path("key") String key);

    /**
     * Get a single user
     *
     * @param userId The id of the user to get. (required)
     * @return UserResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}")
    Call<UserResponse> getUserCall(@Path("userId") String userId);

    /**
     * Get a user's info
     *
     * @param userId The id of the user to get the info for. (required)
     * @param key The key of the user info to get. (required)
     * @return UserInfoResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/info/{key}")
    Call<UserInfoResponse> getUserInfoCall(@Path("userId") String userId, @Path("key") String key);

    /**
     * Get a user's picture The response body contains the raw picture data,
     * representing the user?s picture. The Content-type of the response
     * corresponds to the mimeType that was set when creating the picture.
     * 
     * @param userId The id of the user to get the picture for. (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/picture")
    Call<RequestBody> getUserPictureCall(@Path("userId") String userId);

    /**
     * Get a list of users
     *
     * @param id Only return group with the given id (optional)
     * @param firstName Only return users with the given firstname (optional)
     * @param lastName Only return users with the given lastname (optional)
     * @param email Only return users with the given email (optional)
     * @param firstNameLike Only return userswith a firstname like the given
     *            value. Use % as wildcard-character. (optional)
     * @param lastNameLike Only return users with a lastname like the given
     *            value. Use % as wildcard-character. (optional)
     * @param emailLike Only return users with an email like the given value.
     *            Use % as wildcard-character. (optional)
     * @param memberOfGroup Only return users which are a member of the given
     *            group. (optional)
     * @param potentialStarter Only return users which members are potential
     *            starters for a process-definition with the given id.
     *            (optional)
     * @param sort Field to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/identity/users")
    Call<ResultList<UserResponse>> getUsersCall(@Query("id") String id, @Query("firstName") String firstName,
            @Query("lastName") String lastName, @Query("email") String email,
            @Query("firstNameLike") String firstNameLike, @Query("lastNameLike") String lastNameLike,
            @Query("emailLike") String emailLike, @Query("memberOfGroup") String memberOfGroup,
            @Query("potentialStarter") String potentialStarter, @Query("sort") String sort);

    /**
     * List a user?s info
     *
     * @param userId The id of the user to get the info for. (required)
     * @return List&lt;UserInfoResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/info")
    Call<List<UserInfoResponse>> listUsersInfoCall(@Path("userId") String userId);

    /**
     * Update a user All request values are optional. For example, you can only
     * include the firstName attribute in the request body JSON-object, only
     * updating the firstName of the user, leaving all other fields unaffected.
     * When an attribute is explicitly included and is set to null, the
     * user-value will be updated to null. Example: {\&quot;firstName\&quot; :
     * null} will clear the firstName of the user).
     * 
     * @param userId (required)
     * @param body (optional)
     * @return UserResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}")
    Call<UserResponse> updateUserCall(@Path("userId") String userId, @Body UserRequest body);

    /**
     * Update a user?s info
     *
     * @param userId The id of the user to update the info for. (required)
     * @param key The key of the user info to update. (required)
     * @param body (optional)
     * @return UserInfoResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/info/{key}")
    Call<UserInfoResponse> updateUserInfoCall(@Path("userId") String userId, @Path("key") String key,
            @Body UserInfoRequest body);

    /**
     * Updating a user?s picture The request should be of type
     * multipart/form-data. There should be a single file-part included with the
     * binary value of the picture. On top of that, the following additional
     * form-fields can be present: mimeType: Optional mime-type for the uploaded
     * picture. If omitted, the default of image/jpeg is used as a mime-type for
     * the picture.
     * 
     * @param userId The id of the user to get the picture for. (required)
     */
    @Multipart
    @PUT(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/picture")
    Call<Void> updateUserInfoCall(@Path("userId") String userId, @Part("filedata") RequestBody file);

    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////

    /**
     * Create a user
     *
     * @param body (optional)
     * @return UserResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/identity/users")
    Observable<UserResponse> createUserObservable(@Body UserRequest body);

    /**
     * Create a new user's info entry
     *
     * @param userId The id of the user to create the info for. (required)
     * @param body (optional)
     * @return UserInfoResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/info")
    Observable<UserResponse> createUserInfoObservable(@Path("userId") String userId, @Body UserInfoRequest body);

    /**
     * Delete a user
     *
     * @param userId The id of the user to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}")
    Observable<Void> deleteUserObservable(@Path("userId") String userId);

    /**
     * Delete a user"s info
     *
     * @param userId The id of the user to delete the info for. (required)
     * @param key The key of the user info to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/info/{key}")
    Observable<Void> deleteUserInfoObservable(@Path("userId") String userId, @Path("key") String key);

    /**
     * Get a single user
     *
     * @param userId The id of the user to get. (required)
     * @return UserResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}")
    Observable<UserResponse> getUserObservable(@Path("userId") String userId);

    /**
     * Get a user's info
     *
     * @param userId The id of the user to get the info for. (required)
     * @param key The key of the user info to get. (required)
     * @return UserInfoResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/info/{key}")
    Observable<UserInfoResponse> getUserInfoObservable(@Path("userId") String userId, @Path("key") String key);

    /**
     * Get a user's picture The response body contains the raw picture data,
     * representing the user?s picture. The Content-type of the response
     * corresponds to the mimeType that was set when creating the picture.
     *
     * @param userId The id of the user to get the picture for. (required)
     * @return List&lt;byte[]&gt;
     */
    @Streaming
    @GET(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/picture")
    Observable<RequestBody> getUserPictureObservable(@Path("userId") String userId);

    /**
     * Get a list of users
     *
     * @param id Only return group with the given id (optional)
     * @param firstName Only return users with the given firstname (optional)
     * @param lastName Only return users with the given lastname (optional)
     * @param email Only return users with the given email (optional)
     * @param firstNameLike Only return userswith a firstname like the given
     *            value. Use % as wildcard-character. (optional)
     * @param lastNameLike Only return users with a lastname like the given
     *            value. Use % as wildcard-character. (optional)
     * @param emailLike Only return users with an email like the given value.
     *            Use % as wildcard-character. (optional)
     * @param memberOfGroup Only return users which are a member of the given
     *            group. (optional)
     * @param potentialStarter Only return users which members are potential
     *            starters for a process-definition with the given id.
     *            (optional)
     * @param sort Field to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/identity/users")
    Observable<ResultList<UserResponse>> getUsersObservable(@Query("id") String id,
            @Query("firstName") String firstName, @Query("lastName") String lastName, @Query("email") String email,
            @Query("firstNameLike") String firstNameLike, @Query("lastNameLike") String lastNameLike,
            @Query("emailLike") String emailLike, @Query("memberOfGroup") String memberOfGroup,
            @Query("potentialStarter") String potentialStarter, @Query("sort") String sort);

    /**
     * List a user?s info
     *
     * @param userId The id of the user to get the info for. (required)
     * @return List&lt;UserInfoResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/info")
    Observable<List<UserInfoResponse>> listUsersInfoObservable(@Path("userId") String userId);

    /**
     * Update a user All request values are optional. For example, you can only
     * include the firstName attribute in the request body JSON-object, only
     * updating the firstName of the user, leaving all other fields unaffected.
     * When an attribute is explicitly included and is set to null, the
     * user-value will be updated to null. Example: {\&quot;firstName\&quot; :
     * null} will clear the firstName of the user).
     *
     * @param userId (required)
     * @param body (optional)
     * @return UserResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}")
    Observable<UserResponse> updateUserObservable(@Path("userId") String userId, @Body UserRequest body);

    /**
     * Update a user?s info
     *
     * @param userId The id of the user to update the info for. (required)
     * @param key The key of the user info to update. (required)
     * @param body (optional)
     * @return UserInfoResponse
     */
    @Headers({ "Content-type: application/json" })
    @PUT(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/info/{key}")
    Observable<UserInfoResponse> updateUserInfoObservable(@Path("userId") String userId, @Path("key") String key,
            @Body UserInfoRequest body);

    /**
     * Updating a user?s picture The request should be of type
     * multipart/form-data. There should be a single file-part included with the
     * binary value of the picture. On top of that, the following additional
     * form-fields can be present: mimeType: Optional mime-type for the uploaded
     * picture. If omitted, the default of image/jpeg is used as a mime-type for
     * the picture.
     *
     * @param userId The id of the user to get the picture for. (required)
     */
    @Multipart
    @PUT(ACTIVITI_SERVICE_PATH + "/identity/users/{userId}/picture")
    Observable<Void> updateUserInfoObservable(@Path("userId") String userId, @Part("filedata") RequestBody file);

}
