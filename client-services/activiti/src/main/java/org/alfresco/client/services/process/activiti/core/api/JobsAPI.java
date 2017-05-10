package org.alfresco.client.services.process.activiti.core.api;

import static org.alfresco.client.services.process.activiti.common.constant.RequestConstant.*;
import static org.alfresco.client.services.process.activiti.core.ActivitiConstant.ACTIVITI_SERVICE_PATH;

import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;
import org.alfresco.client.services.process.activiti.core.model.body.RestActionRequest;
import org.alfresco.client.services.process.activiti.core.model.representation.JobResponse;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 03/05/2017.
 */
public interface JobsAPI
{

    /**
     * Delete a deadletter job
     *
     * @param jobId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/management/deadletter-jobs/{jobId}")
    Call<Void> deleteDeadLetterJobCall(@Path(JOB_ID) String jobId);

    /**
     * Delete a job
     *
     * @param jobId The id of the job to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}")
    Call<Void> deleteJobCall(@Path(JOB_ID) String jobId);

    /**
     * Delete a timer job
     *
     * @param jobId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/management/timer-jobs/{jobId}")
    Call<Void> deleteTimerJobCall(@Path(JOB_ID) String jobId);

    /**
     * Execute a single job
     *
     * @param jobId (required)
     * @param actionRequest Action to perform. Only execute is supported.
     *            (optional)
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}")
    Call<Void> executeJobActionCall(@Path(JOB_ID) String jobId, @Body RestActionRequest actionRequest);

    /**
     * Get the exception stacktrace for a deadletter job
     *
     * @param jobId (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/deadletter-jobs/{jobId}/exception-stacktrace")
    Call<String> getDeadLetterJobStacktraceCall(@Path(JOB_ID) String jobId);

    /**
     * Get a single deadletter job
     *
     * @param jobId (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/deadletter-jobs/{jobId}")
    Call<JobResponse> getDeadletterJobCall(@Path(JOB_ID) String jobId);

    /**
     * Get a single job
     *
     * @param jobId The id of the job to get. (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}")
    Call<JobResponse> getJobCall(@Path(JOB_ID) String jobId);

    /**
     * Get the exception stacktrace for a job
     *
     * @param jobId Id of the job to get the stacktrace for. (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}/exception-stacktrace")
    Call<String> getJobStacktraceCall(@Path(JOB_ID) String jobId);

    /**
     * Get a single suspended job
     *
     * @param jobId (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/suspended-jobs/{jobId}")
    Call<JobResponse> getSuspendedJobCall(@Path(JOB_ID) String jobId);

    /**
     * Get the exception stacktrace for a suspended job
     *
     * @param jobId (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/suspended-jobs/{jobId}/exception-stacktrace")
    Call<String> getSuspendedJobStacktraceCall(@Path(JOB_ID) String jobId);

    /**
     * Get a single timer job
     *
     * @param jobId (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/timer-jobs/{jobId}")
    Call<JobResponse> getTimerJobCall(@Path(JOB_ID) String jobId);

    /**
     * Get the exception stacktrace for a timer job
     *
     * @param jobId (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/timer-jobs/{jobId}/exception-stacktrace")
    Call<String> getTimerJobStacktraceCall(@Path(JOB_ID) String jobId);

    /**
     * Get a list of deadletter jobs
     *
     * @param id Only return job with the given id (optional)
     * @param processInstanceId Only return jobs part of a process with the
     *            given id (optional)
     * @param executionId Only return jobs part of an execution with the given
     *            id (optional)
     * @param processDefinitionId Only return jobs with the given process
     *            definition id (optional)
     * @param timersOnly If true, only return jobs which are timers. If false,
     *            this parameter is ignored. Cannot be used together with
     *            &#39;messagesOnly&#39;. (optional)
     * @param messagesOnly If true, only return jobs which are messages. If
     *            false, this parameter is ignored. Cannot be used together with
     *            &#39;timersOnly&#39; (optional)
     * @param withException If true, only return jobs for which an exception
     *            occurred while executing it. If false, this parameter is
     *            ignored. (optional)
     * @param dueBefore Only return jobs which are due to be executed before the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param dueAfter Only return jobs which are due to be executed after the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param exceptionMessage Only return jobs with the given exception message
     *            (optional)
     * @param tenantId Only return jobs with the given tenantId. (optional)
     * @param tenantIdLike Only return jobs with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns jobs without a tenantId set.
     *            If false, the withoutTenantId parameter is ignored. (optional)
     * @param locked If true, only return jobs which are locked. If false, this
     *            parameter is ignored. (optional)
     * @param unlocked If true, only return jobs which are unlocked. If false,
     *            this parameter is ignored. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/deadletter-jobs")
    Call<ResultList<JobResponse>> listDeadLetterJobsCall(@Query("id") String id,
            @Query(PROCESS_INSTANCE_ID) String processInstanceId, @Query(EXECUTION_ID) String executionId,
            @Query(PROCESS_DEFINITION_ID) String processDefinitionId, @Query(TIMERS_ONLY) Boolean timersOnly,
            @Query(MESSAGES_ONLY) Boolean messagesOnly, @Query(WITH_EXCEPTION) Boolean withException,
            @Query(DUE_BEFORE) String dueBefore, @Query(DUE_AFTER) String dueAfter,
            @Query(EXCEPTION_MESSAGE) String exceptionMessage, @Query(TENANT_ID) String tenantId,
            @Query(TENANT_ID_LIKE) String tenantIdLike, @Query(WITHOUT_TENANT_ID) Boolean withoutTenantId,
            @Query(LOCKED) Boolean locked, @Query(UNLOCKED) Boolean unlocked, @Query(SORT) String sort);

    /**
     * Get a list of jobs
     *
     * @param id Only return job with the given id (optional)
     * @param processInstanceId Only return jobs part of a process with the
     *            given id (optional)
     * @param executionId Only return jobs part of an execution with the given
     *            id (optional)
     * @param processDefinitionId Only return jobs with the given process
     *            definition id (optional)
     * @param timersOnly If true, only return jobs which are timers. If false,
     *            this parameter is ignored. Cannot be used together with
     *            &#39;messagesOnly&#39;. (optional)
     * @param messagesOnly If true, only return jobs which are messages. If
     *            false, this parameter is ignored. Cannot be used together with
     *            &#39;timersOnly&#39; (optional)
     * @param withException If true, only return jobs for which an exception
     *            occurred while executing it. If false, this parameter is
     *            ignored. (optional)
     * @param dueBefore Only return jobs which are due to be executed before the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param dueAfter Only return jobs which are due to be executed after the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param exceptionMessage Only return jobs with the given exception message
     *            (optional)
     * @param tenantId Only return jobs with the given tenantId. (optional)
     * @param tenantIdLike Only return jobs with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns jobs without a tenantId set.
     *            If false, the withoutTenantId parameter is ignored. (optional)
     * @param locked If true, only return jobs which are locked. If false, this
     *            parameter is ignored. (optional)
     * @param unlocked If true, only return jobs which are unlocked. If false,
     *            this parameter is ignored. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/jobs")
    Call<ResultList<JobResponse>> listJobsCall(@Query("id") String id,
            @Query(PROCESS_INSTANCE_ID) String processInstanceId, @Query(EXECUTION_ID) String executionId,
            @Query(PROCESS_DEFINITION_ID) String processDefinitionId, @Query(TIMERS_ONLY) Boolean timersOnly,
            @Query(MESSAGES_ONLY) Boolean messagesOnly, @Query(WITH_EXCEPTION) Boolean withException,
            @Query(DUE_BEFORE) String dueBefore, @Query(DUE_AFTER) String dueAfter,
            @Query(EXCEPTION_MESSAGE) String exceptionMessage, @Query(TENANT_ID) String tenantId,
            @Query(TENANT_ID_LIKE) String tenantIdLike, @Query(WITHOUT_TENANT_ID) Boolean withoutTenantId,
            @Query(LOCKED) Boolean locked, @Query(UNLOCKED) Boolean unlocked, @Query(SORT) String sort);

    /**
     * Get a list of suspended jobs
     *
     * @param id Only return job with the given id (optional)
     * @param processInstanceId Only return jobs part of a process with the
     *            given id (optional)
     * @param executionId Only return jobs part of an execution with the given
     *            id (optional)
     * @param processDefinitionId Only return jobs with the given process
     *            definition id (optional)
     * @param timersOnly If true, only return jobs which are timers. If false,
     *            this parameter is ignored. Cannot be used together with
     *            &#39;messagesOnly&#39;. (optional)
     * @param messagesOnly If true, only return jobs which are messages. If
     *            false, this parameter is ignored. Cannot be used together with
     *            &#39;timersOnly&#39; (optional)
     * @param withException If true, only return jobs for which an exception
     *            occurred while executing it. If false, this parameter is
     *            ignored. (optional)
     * @param dueBefore Only return jobs which are due to be executed before the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param dueAfter Only return jobs which are due to be executed after the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param exceptionMessage Only return jobs with the given exception message
     *            (optional)
     * @param tenantId Only return jobs with the given tenantId. (optional)
     * @param tenantIdLike Only return jobs with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns jobs without a tenantId set.
     *            If false, the withoutTenantId parameter is ignored. (optional)
     * @param locked If true, only return jobs which are locked. If false, this
     *            parameter is ignored. (optional)
     * @param unlocked If true, only return jobs which are unlocked. If false,
     *            this parameter is ignored. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/suspended-jobs")
    Call<ResultList<JobResponse>> listSuspendedJobsCall(@Query("id") String id,
            @Query(PROCESS_INSTANCE_ID) String processInstanceId, @Query(EXECUTION_ID) String executionId,
            @Query(PROCESS_DEFINITION_ID) String processDefinitionId, @Query(TIMERS_ONLY) Boolean timersOnly,
            @Query(MESSAGES_ONLY) Boolean messagesOnly, @Query(WITH_EXCEPTION) Boolean withException,
            @Query(DUE_BEFORE) String dueBefore, @Query(DUE_AFTER) String dueAfter,
            @Query(EXCEPTION_MESSAGE) String exceptionMessage, @Query(TENANT_ID) String tenantId,
            @Query(TENANT_ID_LIKE) String tenantIdLike, @Query(WITHOUT_TENANT_ID) Boolean withoutTenantId,
            @Query(LOCKED) Boolean locked, @Query(UNLOCKED) Boolean unlocked, @Query(SORT) String sort);

    /**
     * Get a list of timer jobs
     *
     * @param id Only return job with the given id (optional)
     * @param processInstanceId Only return jobs part of a process with the
     *            given id (optional)
     * @param executionId Only return jobs part of an execution with the given
     *            id (optional)
     * @param processDefinitionId Only return jobs with the given process
     *            definition id (optional)
     * @param timersOnly If true, only return jobs which are timers. If false,
     *            this parameter is ignored. Cannot be used together with
     *            &#39;messagesOnly&#39;. (optional)
     * @param messagesOnly If true, only return jobs which are messages. If
     *            false, this parameter is ignored. Cannot be used together with
     *            &#39;timersOnly&#39; (optional)
     * @param withException If true, only return jobs for which an exception
     *            occurred while executing it. If false, this parameter is
     *            ignored. (optional)
     * @param dueBefore Only return jobs which are due to be executed before the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param dueAfter Only return jobs which are due to be executed after the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param exceptionMessage Only return jobs with the given exception message
     *            (optional)
     * @param tenantId Only return jobs with the given tenantId. (optional)
     * @param tenantIdLike Only return jobs with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns jobs without a tenantId set.
     *            If false, the withoutTenantId parameter is ignored. (optional)
     * @param locked If true, only return jobs which are locked. If false, this
     *            parameter is ignored. (optional)
     * @param unlocked If true, only return jobs which are unlocked. If false,
     *            this parameter is ignored. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/timer-jobs")
    Call<ResultList<JobResponse>> listTimerJobsCall(@Query("id") String id,
            @Query(PROCESS_INSTANCE_ID) String processInstanceId, @Query(EXECUTION_ID) String executionId,
            @Query(PROCESS_DEFINITION_ID) String processDefinitionId, @Query(TIMERS_ONLY) Boolean timersOnly,
            @Query(MESSAGES_ONLY) Boolean messagesOnly, @Query(WITH_EXCEPTION) Boolean withException,
            @Query(DUE_BEFORE) String dueBefore, @Query(DUE_AFTER) String dueAfter,
            @Query(EXCEPTION_MESSAGE) String exceptionMessage, @Query(TENANT_ID) String tenantId,
            @Query(TENANT_ID_LIKE) String tenantIdLike, @Query(WITHOUT_TENANT_ID) Boolean withoutTenantId,
            @Query(LOCKED) Boolean locked, @Query(UNLOCKED) Boolean unlocked, @Query(SORT) String sort);

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
     * Delete a deadletter job
     *
     * @param jobId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/management/deadletter-jobs/{jobId}")
    Observable<Void> deleteDeadLetterJobObservable(@Path(JOB_ID) String jobId);

    /**
     * Delete a job
     *
     * @param jobId The id of the job to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}")
    Observable<Void> deleteJobObservable(@Path(JOB_ID) String jobId);

    /**
     * Delete a timer job
     *
     * @param jobId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/management/timer-jobs/{jobId}")
    Observable<Void> deleteTimerJobObservable(@Path(JOB_ID) String jobId);

    /**
     * Execute a single job
     *
     * @param jobId (required)
     * @param actionRequest Action to perform. Only execute is supported.
     *            (optional)
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}")
    Observable<Void> executeJobActionObservable(@Path(JOB_ID) String jobId, @Body RestActionRequest actionRequest);

    /**
     * Get the exception stacktrace for a deadletter job
     *
     * @param jobId (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/deadletter-jobs/{jobId}/exception-stacktrace")
    Observable<String> getDeadLetterJobStacktraceObservable(@Path(JOB_ID) String jobId);

    /**
     * Get a single deadletter job
     *
     * @param jobId (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/deadletter-jobs/{jobId}")
    Observable<JobResponse> getDeadletterJobObservable(@Path(JOB_ID) String jobId);

    /**
     * Get a single job
     *
     * @param jobId The id of the job to get. (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}")
    Observable<JobResponse> getJobObservable(@Path(JOB_ID) String jobId);

    /**
     * Get the exception stacktrace for a job
     *
     * @param jobId Id of the job to get the stacktrace for. (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}/exception-stacktrace")
    Observable<String> getJobStacktraceObservable(@Path(JOB_ID) String jobId);

    /**
     * Get a single suspended job
     *
     * @param jobId (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/suspended-jobs/{jobId}")
    Observable<JobResponse> getSuspendedJobObservable(@Path(JOB_ID) String jobId);

    /**
     * Get the exception stacktrace for a suspended job
     *
     * @param jobId (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/suspended-jobs/{jobId}/exception-stacktrace")
    Observable<String> getSuspendedJobStacktraceObservable(@Path(JOB_ID) String jobId);

    /**
     * Get a single timer job
     *
     * @param jobId (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/timer-jobs/{jobId}")
    Observable<JobResponse> getTimerJobObservable(@Path(JOB_ID) String jobId);

    /**
     * Get the exception stacktrace for a timer job
     *
     * @param jobId (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/timer-jobs/{jobId}/exception-stacktrace")
    Observable<String> getTimerJobStacktraceObservable(@Path(JOB_ID) String jobId);

    /**
     * Get a list of deadletter jobs
     *
     * @param id Only return job with the given id (optional)
     * @param processInstanceId Only return jobs part of a process with the
     *            given id (optional)
     * @param executionId Only return jobs part of an execution with the given
     *            id (optional)
     * @param processDefinitionId Only return jobs with the given process
     *            definition id (optional)
     * @param timersOnly If true, only return jobs which are timers. If false,
     *            this parameter is ignored. Cannot be used together with
     *            &#39;messagesOnly&#39;. (optional)
     * @param messagesOnly If true, only return jobs which are messages. If
     *            false, this parameter is ignored. Cannot be used together with
     *            &#39;timersOnly&#39; (optional)
     * @param withException If true, only return jobs for which an exception
     *            occurred while executing it. If false, this parameter is
     *            ignored. (optional)
     * @param dueBefore Only return jobs which are due to be executed before the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param dueAfter Only return jobs which are due to be executed after the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param exceptionMessage Only return jobs with the given exception message
     *            (optional)
     * @param tenantId Only return jobs with the given tenantId. (optional)
     * @param tenantIdLike Only return jobs with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns jobs without a tenantId set.
     *            If false, the withoutTenantId parameter is ignored. (optional)
     * @param locked If true, only return jobs which are locked. If false, this
     *            parameter is ignored. (optional)
     * @param unlocked If true, only return jobs which are unlocked. If false,
     *            this parameter is ignored. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/deadletter-jobs")
    Observable<ResultList<JobResponse>> listDeadLetterJobsObservable(@Query("id") String id,
            @Query(PROCESS_INSTANCE_ID) String processInstanceId, @Query(EXECUTION_ID) String executionId,
            @Query(PROCESS_DEFINITION_ID) String processDefinitionId, @Query(TIMERS_ONLY) Boolean timersOnly,
            @Query(MESSAGES_ONLY) Boolean messagesOnly, @Query(WITH_EXCEPTION) Boolean withException,
            @Query(DUE_BEFORE) String dueBefore, @Query(DUE_AFTER) String dueAfter,
            @Query(EXCEPTION_MESSAGE) String exceptionMessage, @Query(TENANT_ID) String tenantId,
            @Query(TENANT_ID_LIKE) String tenantIdLike, @Query(WITHOUT_TENANT_ID) Boolean withoutTenantId,
            @Query(LOCKED) Boolean locked, @Query(UNLOCKED) Boolean unlocked, @Query(SORT) String sort);

    /**
     * Get a list of jobs
     *
     * @param id Only return job with the given id (optional)
     * @param processInstanceId Only return jobs part of a process with the
     *            given id (optional)
     * @param executionId Only return jobs part of an execution with the given
     *            id (optional)
     * @param processDefinitionId Only return jobs with the given process
     *            definition id (optional)
     * @param timersOnly If true, only return jobs which are timers. If false,
     *            this parameter is ignored. Cannot be used together with
     *            &#39;messagesOnly&#39;. (optional)
     * @param messagesOnly If true, only return jobs which are messages. If
     *            false, this parameter is ignored. Cannot be used together with
     *            &#39;timersOnly&#39; (optional)
     * @param withException If true, only return jobs for which an exception
     *            occurred while executing it. If false, this parameter is
     *            ignored. (optional)
     * @param dueBefore Only return jobs which are due to be executed before the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param dueAfter Only return jobs which are due to be executed after the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param exceptionMessage Only return jobs with the given exception message
     *            (optional)
     * @param tenantId Only return jobs with the given tenantId. (optional)
     * @param tenantIdLike Only return jobs with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns jobs without a tenantId set.
     *            If false, the withoutTenantId parameter is ignored. (optional)
     * @param locked If true, only return jobs which are locked. If false, this
     *            parameter is ignored. (optional)
     * @param unlocked If true, only return jobs which are unlocked. If false,
     *            this parameter is ignored. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/jobs")
    Observable<ResultList<JobResponse>> listJobsObservable(@Query("id") String id,
            @Query(PROCESS_INSTANCE_ID) String processInstanceId, @Query(EXECUTION_ID) String executionId,
            @Query(PROCESS_DEFINITION_ID) String processDefinitionId, @Query(TIMERS_ONLY) Boolean timersOnly,
            @Query(MESSAGES_ONLY) Boolean messagesOnly, @Query(WITH_EXCEPTION) Boolean withException,
            @Query(DUE_BEFORE) String dueBefore, @Query(DUE_AFTER) String dueAfter,
            @Query(EXCEPTION_MESSAGE) String exceptionMessage, @Query(TENANT_ID) String tenantId,
            @Query(TENANT_ID_LIKE) String tenantIdLike, @Query(WITHOUT_TENANT_ID) Boolean withoutTenantId,
            @Query(LOCKED) Boolean locked, @Query(UNLOCKED) Boolean unlocked, @Query(SORT) String sort);

    /**
     * Get a list of suspended jobs
     *
     * @param id Only return job with the given id (optional)
     * @param processInstanceId Only return jobs part of a process with the
     *            given id (optional)
     * @param executionId Only return jobs part of an execution with the given
     *            id (optional)
     * @param processDefinitionId Only return jobs with the given process
     *            definition id (optional)
     * @param timersOnly If true, only return jobs which are timers. If false,
     *            this parameter is ignored. Cannot be used together with
     *            &#39;messagesOnly&#39;. (optional)
     * @param messagesOnly If true, only return jobs which are messages. If
     *            false, this parameter is ignored. Cannot be used together with
     *            &#39;timersOnly&#39; (optional)
     * @param withException If true, only return jobs for which an exception
     *            occurred while executing it. If false, this parameter is
     *            ignored. (optional)
     * @param dueBefore Only return jobs which are due to be executed before the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param dueAfter Only return jobs which are due to be executed after the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param exceptionMessage Only return jobs with the given exception message
     *            (optional)
     * @param tenantId Only return jobs with the given tenantId. (optional)
     * @param tenantIdLike Only return jobs with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns jobs without a tenantId set.
     *            If false, the withoutTenantId parameter is ignored. (optional)
     * @param locked If true, only return jobs which are locked. If false, this
     *            parameter is ignored. (optional)
     * @param unlocked If true, only return jobs which are unlocked. If false,
     *            this parameter is ignored. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/suspended-jobs")
    Observable<ResultList<JobResponse>> listSuspendedJobsObservable(@Query("id") String id,
            @Query(PROCESS_INSTANCE_ID) String processInstanceId, @Query(EXECUTION_ID) String executionId,
            @Query(PROCESS_DEFINITION_ID) String processDefinitionId, @Query(TIMERS_ONLY) Boolean timersOnly,
            @Query(MESSAGES_ONLY) Boolean messagesOnly, @Query(WITH_EXCEPTION) Boolean withException,
            @Query(DUE_BEFORE) String dueBefore, @Query(DUE_AFTER) String dueAfter,
            @Query(EXCEPTION_MESSAGE) String exceptionMessage, @Query(TENANT_ID) String tenantId,
            @Query(TENANT_ID_LIKE) String tenantIdLike, @Query(WITHOUT_TENANT_ID) Boolean withoutTenantId,
            @Query(LOCKED) Boolean locked, @Query(UNLOCKED) Boolean unlocked, @Query(SORT) String sort);

    /**
     * Get a list of timer jobs
     *
     * @param id Only return job with the given id (optional)
     * @param processInstanceId Only return jobs part of a process with the
     *            given id (optional)
     * @param executionId Only return jobs part of an execution with the given
     *            id (optional)
     * @param processDefinitionId Only return jobs with the given process
     *            definition id (optional)
     * @param timersOnly If true, only return jobs which are timers. If false,
     *            this parameter is ignored. Cannot be used together with
     *            &#39;messagesOnly&#39;. (optional)
     * @param messagesOnly If true, only return jobs which are messages. If
     *            false, this parameter is ignored. Cannot be used together with
     *            &#39;timersOnly&#39; (optional)
     * @param withException If true, only return jobs for which an exception
     *            occurred while executing it. If false, this parameter is
     *            ignored. (optional)
     * @param dueBefore Only return jobs which are due to be executed before the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param dueAfter Only return jobs which are due to be executed after the
     *            given date. Jobs without duedate are never returned using this
     *            parameter. (optional)
     * @param exceptionMessage Only return jobs with the given exception message
     *            (optional)
     * @param tenantId Only return jobs with the given tenantId. (optional)
     * @param tenantIdLike Only return jobs with a tenantId like the given
     *            value. (optional)
     * @param withoutTenantId If true, only returns jobs without a tenantId set.
     *            If false, the withoutTenantId parameter is ignored. (optional)
     * @param locked If true, only return jobs which are locked. If false, this
     *            parameter is ignored. (optional)
     * @param unlocked If true, only return jobs which are unlocked. If false,
     *            this parameter is ignored. (optional)
     * @param sort Property to sort on, to be used together with the order.
     *            (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/timer-jobs")
    Observable<ResultList<JobResponse>> listTimerJobsObservable(@Query("id") String id,
            @Query(PROCESS_INSTANCE_ID) String processInstanceId, @Query(EXECUTION_ID) String executionId,
            @Query(PROCESS_DEFINITION_ID) String processDefinitionId, @Query(TIMERS_ONLY) Boolean timersOnly,
            @Query(MESSAGES_ONLY) Boolean messagesOnly, @Query(WITH_EXCEPTION) Boolean withException,
            @Query(DUE_BEFORE) String dueBefore, @Query(DUE_AFTER) String dueAfter,
            @Query(EXCEPTION_MESSAGE) String exceptionMessage, @Query(TENANT_ID) String tenantId,
            @Query(TENANT_ID_LIKE) String tenantIdLike, @Query(WITHOUT_TENANT_ID) Boolean withoutTenantId,
            @Query(LOCKED) Boolean locked, @Query(UNLOCKED) Boolean unlocked, @Query(SORT) String sort);

}
