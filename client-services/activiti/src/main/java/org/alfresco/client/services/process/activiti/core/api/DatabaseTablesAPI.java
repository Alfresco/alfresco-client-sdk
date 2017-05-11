package org.alfresco.client.services.process.activiti.core.api;

import static org.alfresco.client.services.process.activiti.common.constant.RequestConstant.*;
import static org.alfresco.client.services.process.activiti.core.ActivitiConstant.ACTIVITI_SERVICE_PATH;

import java.util.List;
import java.util.Map;

import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;
import org.alfresco.client.services.process.activiti.core.model.representation.TableMetaData;
import org.alfresco.client.services.process.activiti.core.model.representation.TableResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jpascal on 03/05/2017.
 */
public interface DatabaseTablesAPI
{

    /**
     * Get a single table
     *
     * @param tableName The name of the table to get. (required)
     * @return TableResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/tables/{tableName}")
    Call<TableResponse> getTableCall(@Path(TABLE_NAME) String tableName);

    /**
     * Get row data for a single table
     *
     * @param tableName The name of the table to get. (required)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/tables/{tableName}/data")
    Call<ResultList<Map<String, Object>>> listTableDataCall(@Path(TABLE_NAME) String tableName);

    /**
     * Get row data for a single table
     *
     * @param tableName The name of the table to get. (required)
     * @param start Index of the first row to fetch. Defaults to 0. (optional)
     * @param size Number of rows to fetch, starting from start. Defaults to 10.
     *            (optional)
     * @param orderAscendingColumn Name of the column to sort the resulting rows
     *            on, ascending. (optional)
     * @param orderDescendingColumn Name of the column to sort the resulting
     *            rows on, descending. (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/tables/{tableName}/data")
    Call<ResultList<Map<String, Object>>> listTableDataCall(@Path(TABLE_NAME) String tableName,
            @Query(START) String start, @Query(SIZE) String size,
            @Query(ORDER_ASCENDING_COLUMN) String orderAscendingColumn,
            @Query(ORDER_DESCENDING_COLUMN) String orderDescendingColumn);

    /**
     * Get column info for a single table
     *
     * @param tableName The name of the table to get. (required)
     * @return TableMetaData
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/tables/{tableName}/columns")
    Call<TableMetaData> getTableDataCall(@Path(TABLE_NAME) String tableName);

    /**
     * List of tables
     *
     * @return List&lt;TableResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/tables")
    Call<List<TableResponse>> listTablesCall();

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
     * Get a single table
     *
     * @param tableName The name of the table to get. (required)
     * @return TableResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/tables/{tableName}")
    Observable<TableResponse> getTableObservable(@Path(TABLE_NAME) String tableName);

    /**
     * Get row data for a single table
     *
     * @param tableName The name of the table to get. (required)
     * @param start Index of the first row to fetch. Defaults to 0. (optional)
     * @param size Number of rows to fetch, starting from start. Defaults to 10.
     *            (optional)
     * @param orderAscendingColumn Name of the column to sort the resulting rows
     *            on, ascending. (optional)
     * @param orderDescendingColumn Name of the column to sort the resulting
     *            rows on, descending. (optional)
     * @return DataResponse
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/tables/{tableName}/data")
    Observable<ResultList<Map<String, Object>>> listTableDataObservable(@Path(TABLE_NAME) String tableName,
            @Query(START) String start, @Query(SIZE) String size,
            @Query(ORDER_ASCENDING_COLUMN) String orderAscendingColumn,
            @Query(ORDER_DESCENDING_COLUMN) String orderDescendingColumn);

    /**
     * Get column info for a single table
     *
     * @param tableName The name of the table to get. (required)
     * @return TableMetaData
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/tables/{tableName}/columns")
    Observable<TableMetaData> getTableDataObservable(@Path(TABLE_NAME) String tableName);

    /**
     * List of tables
     *
     * @return List&lt;TableResponse&gt;
     */
    @GET(ACTIVITI_SERVICE_PATH + "/management/tables")
    Observable<List<TableResponse>> listTablesObservable();

}
