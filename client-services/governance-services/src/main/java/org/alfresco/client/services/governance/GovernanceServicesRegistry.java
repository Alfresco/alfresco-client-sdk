package org.alfresco.client.services.governance;

import org.alfresco.client.services.common.APIRegistry;
import org.alfresco.client.services.governance.core.api.*;

/**
 * Created by jpascal on 30/04/2017.
 */
public interface GovernanceServicesRegistry extends APIRegistry
{
    GsSitesAPI getGsSitesAPI();

    FilePlansAPI getFilePlansAPI();

    RecordCategoriesAPI getRecordCategoriesAPI();

    RecordFoldersAPI getRecordFoldersAPI();

    RecordsAPI getRecordsAPI();

    UnfiledContainersAPI getUnfiledContainersAPI();

    UnfiledRecordFoldersAPI getUnfiledRecordFoldersAPI();

    TransferContainersAPI getTransferContainersAPI();

    TransfersAPI getTransfersAPI();

}
