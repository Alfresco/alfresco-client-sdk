package org.alfresco.client.services.governance;

import org.alfresco.client.services.common.AbstractAPIRegistry;
import org.alfresco.client.services.common.RestClient;
import org.alfresco.client.services.governance.core.api.*;

/**
 * Created by jpascal on 30/04/2017.
 */
public class GSAPIRegistry extends AbstractAPIRegistry implements GovernanceServicesRegistry
{
    protected FilesAPI filesAPI;

    protected GsSitesAPI gsSitesAPI;

    protected FilePlansAPI filePlansAPI;

    protected RecordCategoriesAPI recordCategoriesAPI;

    protected RecordFoldersAPI recordFoldersAPI;

    protected RecordsAPI recordsAPI;

    protected UnfiledContainersAPI unfiledContainersAPI;

    protected UnfiledRecordFoldersAPI unfiledRecordFoldersAPI;

    protected TransferContainersAPI transferContainersAPI;

    protected TransfersAPI transfersAPI;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    // ///////////////////////////////////////////////////////////////////////////
    public GSAPIRegistry(RestClient restClient)
    {
        this.restClient = restClient;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS
    // ///////////////////////////////////////////////////////////////////////////
    public FilesAPI getFilesAPI()
    {
        if (filesAPI == null)
        {
            filesAPI = getAPI(FilesAPI.class);
        }
        return filesAPI;
    }

    public GsSitesAPI getGsSitesAPI()
    {
        if (gsSitesAPI == null)
        {
            gsSitesAPI = getAPI(GsSitesAPI.class);
        }
        return gsSitesAPI;
    }

    public FilePlansAPI getFilePlansAPI()
    {
        if (filePlansAPI == null)
        {
            filePlansAPI = getAPI(FilePlansAPI.class);
        }
        return filePlansAPI;
    }

    public RecordCategoriesAPI getRecordCategoriesAPI()
    {
        if (recordCategoriesAPI == null)
        {
            recordCategoriesAPI = getAPI(RecordCategoriesAPI.class);
        }
        return recordCategoriesAPI;
    }

    public RecordFoldersAPI getRecordFoldersAPI()
    {
        if (recordFoldersAPI == null)
        {
            recordFoldersAPI = getAPI(RecordFoldersAPI.class);
        }
        return recordFoldersAPI;
    }

    public RecordsAPI getRecordsAPI()
    {
        if (recordsAPI == null)
        {
            recordsAPI = getAPI(RecordsAPI.class);
        }
        return recordsAPI;
    }

    public UnfiledContainersAPI getUnfiledContainersAPI()
    {
        if (unfiledContainersAPI == null)
        {
            unfiledContainersAPI = getAPI(UnfiledContainersAPI.class);
        }
        return unfiledContainersAPI;
    }

    public UnfiledRecordFoldersAPI getUnfiledRecordFoldersAPI()
    {
        if (unfiledRecordFoldersAPI == null)
        {
            unfiledRecordFoldersAPI = getAPI(UnfiledRecordFoldersAPI.class);
        }
        return unfiledRecordFoldersAPI;
    }

    public TransfersAPI getTransfersAPI()
    {
        if (transfersAPI == null)
        {
            transfersAPI = getAPI(TransfersAPI.class);
        }
        return transfersAPI;
    }

    public TransferContainersAPI getTransferContainersAPI()
    {
        if (transferContainersAPI == null)
        {
            transferContainersAPI = getAPI(TransferContainersAPI.class);
        }
        return transferContainersAPI;
    }

}
