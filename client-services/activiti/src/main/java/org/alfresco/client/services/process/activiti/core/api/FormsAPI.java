package org.alfresco.client.services.process.activiti.core.api;

import static org.alfresco.client.services.process.activiti.common.constant.RequestConstant.PROCESS_DEFINITION_ID;
import static org.alfresco.client.services.process.activiti.common.constant.RequestConstant.TASK_ID;
import static org.alfresco.client.services.process.activiti.core.ActivitiConstant.ACTIVITI_SERVICE_PATH;

import org.alfresco.client.services.process.activiti.core.model.body.SubmitFormRequest;
import org.alfresco.client.services.process.activiti.core.model.representation.FormDataResponse;
import org.alfresco.client.services.process.activiti.core.model.representation.ProcessInstanceResponse;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by jpascal on 03/05/2017.
 */
public interface FormsAPI
{

    /**
     * Get form data
     *
     * @param taskId The task id corresponding to the form data that needs to be
     *            retrieved. (optional)
     * @param processDefinitionId The process definition id corresponding to the
     *            start event form data that needs to be retrieved. (optional)
     * @return FormDataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/form/form-data")
    Call<FormDataResponse> getFormDataCall(@Query(TASK_ID) String taskId,
            @Query(PROCESS_DEFINITION_ID) String processDefinitionId);

    /**
     * Submit task form data
     *
     * @param body (optional)
     * @return ProcessInstanceResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/form/form-data")
    Call<ProcessInstanceResponse> getPropertiesCall(@Body SubmitFormRequest body);

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
     * Get form data
     *
     * @param taskId The task id corresponding to the form data that needs to be
     *            retrieved. (optional)
     * @param processDefinitionId The process definition id corresponding to the
     *            start event form data that needs to be retrieved. (optional)
     * @return FormDataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/form/form-data")
    Observable<FormDataResponse> getFormDataObservable(@Query(TASK_ID) String taskId,
            @Query(PROCESS_DEFINITION_ID) String processDefinitionId);

    /**
     * Submit task form data
     *
     * @param body (optional)
     * @return ProcessInstanceResponse
     */
    @Headers({ "Content-type: application/json" })
    @POST(ACTIVITI_SERVICE_PATH + "/form/form-data")
    Observable<ProcessInstanceResponse> getPropertiesObservable(@Body SubmitFormRequest body);
}
