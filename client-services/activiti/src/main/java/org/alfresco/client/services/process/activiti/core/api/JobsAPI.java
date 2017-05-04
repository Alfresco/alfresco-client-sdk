package org.alfresco.client.services.process.activiti.core.api;

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
    Call<Void> deleteDeadLetterJobCall(@Path("jobId") String jobId);

    /**
     * Delete a job
     *
     * @param jobId The id of the job to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}")
    Call<Void> deleteJobCall(@Path("jobId") String jobId);

    /**
     * Delete a timer job
     *
     * @param jobId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/management/timer-jobs/{jobId}")
    Call<Void> deleteTimerJobCall(@Path("jobId") String jobId);

    /**
     * Execute a single job
     *
     * @param jobId (required)
     * @param actionRequest Action to perform. Only execute is supported.
     *            (optional)
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}")
    Call<Void> executeJobActionCall(@Path("jobId") String jobId, @Body RestActionRequest actionRequest);

    /**
     * Get the exception stacktrace for a deadletter job
     *
     * @param jobId (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/deadletter-jobs/{jobId}/exception-stacktrace")
    Call<String> getDeadLetterJobStacktraceCall(@Path("jobId") String jobId);

    /**
     * Get a single deadletter job
     *
     * @param jobId (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/deadletter-jobs/{jobId}")
    Call<JobResponse> getDeadletterJobCall(@Path("jobId") String jobId);

    /**
     * Get a single job
     *
     * @param jobId The id of the job to get. (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}")
    Call<JobResponse> getJobCall(@Path("jobId") String jobId);

    /**
     * Get the exception stacktrace for a job
     *
     * @param jobId Id of the job to get the stacktrace for. (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}/exception-stacktrace")
    Call<String> getJobStacktraceCall(@Path("jobId") String jobId);

    /**
     * Get a single suspended job
     *
     * @param jobId (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/suspended-jobs/{jobId}")
    Call<JobResponse> getSuspendedJobCall(@Path("jobId") String jobId);

    /**
     * Get the exception stacktrace for a suspended job
     *
     * @param jobId (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/suspended-jobs/{jobId}/exception-stacktrace")
    Call<String> getSuspendedJobStacktraceCall(@Path("jobId") String jobId);

    /**
     * Get a single timer job
     *
     * @param jobId (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/timer-jobs/{jobId}")
    Call<JobResponse> getTimerJobCall(@Path("jobId") String jobId);

    /**
     * Get the exception stacktrace for a timer job
     *
     * @param jobId (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/timer-jobs/{jobId}/exception-stacktrace")
    Call<String> getTimerJobStacktraceCall(@Path("jobId") String jobId);

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
            @Query("processInstanceId") String processInstanceId, @Query("executionId") String executionId,
            @Query("processDefinitionId") String processDefinitionId, @Query("timersOnly") Boolean timersOnly,
            @Query("messagesOnly") Boolean messagesOnly, @Query("withException") Boolean withException,
            @Query("dueBefore") String dueBefore, @Query("dueAfter") String dueAfter,
            @Query("exceptionMessage") String exceptionMessage, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId,
            @Query("locked") Boolean locked, @Query("unlocked") Boolean unlocked, @Query("sort") String sort);

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
            @Query("processInstanceId") String processInstanceId, @Query("executionId") String executionId,
            @Query("processDefinitionId") String processDefinitionId, @Query("timersOnly") Boolean timersOnly,
            @Query("messagesOnly") Boolean messagesOnly, @Query("withException") Boolean withException,
            @Query("dueBefore") String dueBefore, @Query("dueAfter") String dueAfter,
            @Query("exceptionMessage") String exceptionMessage, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId,
            @Query("locked") Boolean locked, @Query("unlocked") Boolean unlocked, @Query("sort") String sort);

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
            @Query("processInstanceId") String processInstanceId, @Query("executionId") String executionId,
            @Query("processDefinitionId") String processDefinitionId, @Query("timersOnly") Boolean timersOnly,
            @Query("messagesOnly") Boolean messagesOnly, @Query("withException") Boolean withException,
            @Query("dueBefore") String dueBefore, @Query("dueAfter") String dueAfter,
            @Query("exceptionMessage") String exceptionMessage, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId,
            @Query("locked") Boolean locked, @Query("unlocked") Boolean unlocked, @Query("sort") String sort);

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
            @Query("processInstanceId") String processInstanceId, @Query("executionId") String executionId,
            @Query("processDefinitionId") String processDefinitionId, @Query("timersOnly") Boolean timersOnly,
            @Query("messagesOnly") Boolean messagesOnly, @Query("withException") Boolean withException,
            @Query("dueBefore") String dueBefore, @Query("dueAfter") String dueAfter,
            @Query("exceptionMessage") String exceptionMessage, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId,
            @Query("locked") Boolean locked, @Query("unlocked") Boolean unlocked, @Query("sort") String sort);

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
    Observable<Void> deleteDeadLetterJobObservable(@Path("jobId") String jobId);

    /**
     * Delete a job
     *
     * @param jobId The id of the job to delete. (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}")
    Observable<Void> deleteJobObservable(@Path("jobId") String jobId);

    /**
     * Delete a timer job
     *
     * @param jobId (required)
     */
    @DELETE(ACTIVITI_SERVICE_PATH + "/management/timer-jobs/{jobId}")
    Observable<Void> deleteTimerJobObservable(@Path("jobId") String jobId);

    /**
     * Execute a single job
     *
     * @param jobId (required)
     * @param actionRequest Action to perform. Only execute is supported.
     *            (optional)
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}")
    Observable<Void> executeJobActionObservable(@Path("jobId") String jobId, @Body RestActionRequest actionRequest);

    /**
     * Get the exception stacktrace for a deadletter job
     *
     * @param jobId (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/deadletter-jobs/{jobId}/exception-stacktrace")
    Observable<String> getDeadLetterJobStacktraceObservable(@Path("jobId") String jobId);

    /**
     * Get a single deadletter job
     *
     * @param jobId (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/deadletter-jobs/{jobId}")
    Observable<JobResponse> getDeadletterJobObservable(@Path("jobId") String jobId);

    /**
     * Get a single job
     *
     * @param jobId The id of the job to get. (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}")
    Observable<JobResponse> getJobObservable(@Path("jobId") String jobId);

    /**
     * Get the exception stacktrace for a job
     *
     * @param jobId Id of the job to get the stacktrace for. (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/jobs/{jobId}/exception-stacktrace")
    Observable<String> getJobStacktraceObservable(@Path("jobId") String jobId);

    /**
     * Get a single suspended job
     *
     * @param jobId (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/suspended-jobs/{jobId}")
    Observable<JobResponse> getSuspendedJobObservable(@Path("jobId") String jobId);

    /**
     * Get the exception stacktrace for a suspended job
     *
     * @param jobId (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/suspended-jobs/{jobId}/exception-stacktrace")
    Observable<String> getSuspendedJobStacktraceObservable(@Path("jobId") String jobId);

    /**
     * Get a single timer job
     *
     * @param jobId (required)
     * @return JobResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/timer-jobs/{jobId}")
    Observable<JobResponse> getTimerJobObservable(@Path("jobId") String jobId);

    /**
     * Get the exception stacktrace for a timer job
     *
     * @param jobId (required)
     * @return String
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/timer-jobs/{jobId}/exception-stacktrace")
    Observable<String> getTimerJobStacktraceObservable(@Path("jobId") String jobId);

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
            @Query("processInstanceId") String processInstanceId, @Query("executionId") String executionId,
            @Query("processDefinitionId") String processDefinitionId, @Query("timersOnly") Boolean timersOnly,
            @Query("messagesOnly") Boolean messagesOnly, @Query("withException") Boolean withException,
            @Query("dueBefore") String dueBefore, @Query("dueAfter") String dueAfter,
            @Query("exceptionMessage") String exceptionMessage, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId,
            @Query("locked") Boolean locked, @Query("unlocked") Boolean unlocked, @Query("sort") String sort);

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
            @Query("processInstanceId") String processInstanceId, @Query("executionId") String executionId,
            @Query("processDefinitionId") String processDefinitionId, @Query("timersOnly") Boolean timersOnly,
            @Query("messagesOnly") Boolean messagesOnly, @Query("withException") Boolean withException,
            @Query("dueBefore") String dueBefore, @Query("dueAfter") String dueAfter,
            @Query("exceptionMessage") String exceptionMessage, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId,
            @Query("locked") Boolean locked, @Query("unlocked") Boolean unlocked, @Query("sort") String sort);

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
            @Query("processInstanceId") String processInstanceId, @Query("executionId") String executionId,
            @Query("processDefinitionId") String processDefinitionId, @Query("timersOnly") Boolean timersOnly,
            @Query("messagesOnly") Boolean messagesOnly, @Query("withException") Boolean withException,
            @Query("dueBefore") String dueBefore, @Query("dueAfter") String dueAfter,
            @Query("exceptionMessage") String exceptionMessage, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId,
            @Query("locked") Boolean locked, @Query("unlocked") Boolean unlocked, @Query("sort") String sort);

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
            @Query("processInstanceId") String processInstanceId, @Query("executionId") String executionId,
            @Query("processDefinitionId") String processDefinitionId, @Query("timersOnly") Boolean timersOnly,
            @Query("messagesOnly") Boolean messagesOnly, @Query("withException") Boolean withException,
            @Query("dueBefore") String dueBefore, @Query("dueAfter") String dueAfter,
            @Query("exceptionMessage") String exceptionMessage, @Query("tenantId") String tenantId,
            @Query("tenantIdLike") String tenantIdLike, @Query("withoutTenantId") Boolean withoutTenantId,
            @Query("locked") Boolean locked, @Query("unlocked") Boolean unlocked, @Query("sort") String sort);

}
