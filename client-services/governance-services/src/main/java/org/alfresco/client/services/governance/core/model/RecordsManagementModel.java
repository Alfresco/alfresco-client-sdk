package org.alfresco.client.services.governance.core.model;

/**
 * Created by jpascal on 29/04/2017.
 */
public interface RecordsManagementModel
{

    // Namespace details
    String RM_URI = "http://www.alfresco.org/model/recordsmanagement/1.0";

    String RM_MODEL_PREFIX = "rma";

    // Model
    String RM_MODEL = RM_MODEL_PREFIX.concat(":recordsmanagement");

    // RM Site
    String TYPE_RM_SITE = RM_MODEL_PREFIX.concat(":rmsite");

    // Caveat config
    String TYPE_CAVEAT_CONFIG = RM_MODEL_PREFIX.concat(":caveatConfig");

    String ASPECT_CAVEAT_CONFIG_ROOT = RM_MODEL_PREFIX.concat(":caveatConfigRoot");

    String ASSOC_CAVEAT_CONFIG = RM_MODEL_PREFIX.concat(":caveatConfigAssoc");

    // Email config
    String TYPE_EMAIL_CONFIG = RM_MODEL_PREFIX.concat(":emailConfig");

    String ASPECT_EMAIL_CONFIG_ROOT = RM_MODEL_PREFIX.concat(":emailConfigRoot");

    String ASSOC_EMAIL_CONFIG = RM_MODEL_PREFIX.concat(":emailConfigAssoc");

    // Records management container
    String TYPE_RECORDS_MANAGEMENT_CONTAINER = RM_MODEL_PREFIX.concat(":recordsManagementContainer");

    // Record Category
    String TYPE_RECORD_CATEGORY = RM_MODEL_PREFIX.concat(":recordCategory");

    // Records management root container
    String TYPE_FILE_PLAN = RM_MODEL_PREFIX.concat(":filePlan");

    // Unfiled record container
    String TYPE_UNFILED_RECORD_CONTAINER = RM_MODEL_PREFIX.concat(":unfiledRecordContainer");

    // Unfiled record folder
    String TYPE_UNFILED_RECORD_FOLDER = RM_MODEL_PREFIX.concat(":unfiledRecordFolder");

    // Hold container
    String TYPE_HOLD_CONTAINER = RM_MODEL_PREFIX.concat(":holdContainer");

    // Transfer container
    String TYPE_TRANSFER_CONTAINER = RM_MODEL_PREFIX.concat(":transferContainer");

    // Disposition instructions aspect
    String ASPECT_SCHEDULED = RM_MODEL_PREFIX.concat(":scheduled");

    String ASSOC_DISPOSITION_SCHEDULE = RM_MODEL_PREFIX.concat(":dispositionSchedule");

    // Disposition definition type
    String TYPE_DISPOSITION_SCHEDULE = RM_MODEL_PREFIX.concat(":dispositionSchedule");

    String PROP_DISPOSITION_AUTHORITY = RM_MODEL_PREFIX.concat(":dispositionAuthority");

    String PROP_DISPOSITION_INSTRUCTIONS = RM_MODEL_PREFIX.concat(":dispositionInstructions");

    String PROP_RECORD_LEVEL_DISPOSITION = RM_MODEL_PREFIX.concat(":recordLevelDisposition");

    String ASSOC_DISPOSITION_ACTION_DEFINITIONS = RM_MODEL_PREFIX.concat(":dispositionActionDefinitions");

    // Disposition action type
    String TYPE_DISPOSITION_ACTION_DEFINITION = RM_MODEL_PREFIX.concat(":dispositionActionDefinition");

    String PROP_DISPOSITION_ACTION_NAME = RM_MODEL_PREFIX.concat(":dispositionActionName");

    String PROP_DISPOSITION_DESCRIPTION = RM_MODEL_PREFIX.concat(":dispositionDescription");

    String PROP_DISPOSITION_PERIOD = RM_MODEL_PREFIX.concat(":dispositionPeriod");

    String PROP_DISPOSITION_PERIOD_PROPERTY = RM_MODEL_PREFIX.concat(":dispositionPeriodProperty");

    String PROP_DISPOSITION_EVENT = RM_MODEL_PREFIX.concat(":dispositionEvent");

    String PROP_DISPOSITION_EVENT_COMBINATION = RM_MODEL_PREFIX.concat(":dispositionEventCombination");

    String PROP_DISPOSITION_LOCATION = RM_MODEL_PREFIX.concat(":dispositionLocation");

    String PROP_DISPOSITION_ACTION_GHOST_ON_DESTROY = RM_MODEL_PREFIX.concat(":dispositionActionGhostOnDestroy");

    // Records folder
    String TYPE_RECORD_FOLDER = RM_MODEL_PREFIX.concat(":recordFolder");

    String PROP_IS_CLOSED = RM_MODEL_PREFIX.concat(":isClosed");

    // Declared record aspect
    String ASPECT_DECLARED_RECORD = RM_MODEL_PREFIX.concat(":declaredRecord");

    String PROP_DECLARED_AT = RM_MODEL_PREFIX.concat(":declaredAt");

    String PROP_DECLARED_BY = RM_MODEL_PREFIX.concat(":declaredBy");

    // Record aspect
    String ASPECT_RECORD = RM_MODEL_PREFIX.concat(":record");

    String PROP_DATE_FILED = RM_MODEL_PREFIX.concat(":dateFiled");

    String PROP_ORIGIONAL_NAME = RM_MODEL_PREFIX.concat(":origionalName");

    // Common record details
    String ASPECT_COMMON_RECORD_DETAILS = RM_MODEL_PREFIX.concat(":commonRecordDetails");

    String PROP_LOCATION = RM_MODEL_PREFIX.concat(":location");

    // Fileable aspect
    String ASPECT_FILABLE = RM_MODEL_PREFIX.concat(":fileable");

    // Record component identifier aspect
    String ASPECT_RECORD_COMPONENT_ID = RM_MODEL_PREFIX.concat(":recordComponentIdentifier");

    String PROP_IDENTIFIER = RM_MODEL_PREFIX.concat(":identifier");

    String PROP_DB_UNIQUENESS_ID = RM_MODEL_PREFIX.concat(":dbUniquenessId");

    String PROP_ID_IS_TEMPORARILY_EDITABLE = RM_MODEL_PREFIX.concat(":idIsTemporarilyEditable");

    // Vital record definition aspect
    String ASPECT_VITAL_RECORD_DEFINITION = RM_MODEL_PREFIX.concat(":vitalRecordDefinition");

    String PROP_VITAL_RECORD_INDICATOR = RM_MODEL_PREFIX.concat(":vitalRecordIndicator");

    String PROP_REVIEW_PERIOD = RM_MODEL_PREFIX.concat(":reviewPeriod");

    // Vital record aspect
    String ASPECT_VITAL_RECORD = RM_MODEL_PREFIX.concat(":vitalRecord");

    String PROP_REVIEW_AS_OF = RM_MODEL_PREFIX.concat(":reviewAsOf");

    // Cut off aspect
    String ASPECT_CUT_OFF = RM_MODEL_PREFIX.concat(":cutOff");

    String PROP_CUT_OFF_DATE = RM_MODEL_PREFIX.concat(":cutOffDate");

    // Uncut off aspect
    String ASPECT_UNCUT_OFF = RM_MODEL_PREFIX.concat(":uncutOff");

    // Transferred aspect
    String ASPECT_TRANSFERRED = RM_MODEL_PREFIX.concat(":transferred");

    // Ascended aspect
    String ASPECT_ASCENDED = RM_MODEL_PREFIX.concat(":ascended");

    // Disposition schedule aspect
    String ASPECT_DISPOSITION_LIFECYCLE = RM_MODEL_PREFIX.concat(":dispositionLifecycle");

    String ASSOC_NEXT_DISPOSITION_ACTION = RM_MODEL_PREFIX.concat(":nextDispositionAction");

    String ASSOC_DISPOSITION_ACTION_HISTORY = RM_MODEL_PREFIX.concat(":dispositionActionHistory");

    // Disposition action type
    String TYPE_DISPOSITION_ACTION = RM_MODEL_PREFIX.concat(":dispositionAction");

    String PROP_DISPOSITION_ACTION_ID = RM_MODEL_PREFIX.concat(":dispositionActionId");

    String PROP_DISPOSITION_ACTION = RM_MODEL_PREFIX.concat(":dispositionAction");

    String PROP_DISPOSITION_AS_OF = RM_MODEL_PREFIX.concat(":dispositionAsOf");

    /**
     * A flag indicating that the "disposition as of" date has been manually set
     * and shouldn't be changed.
     */
    String PROP_MANUALLY_SET_AS_OF = RM_MODEL_PREFIX.concat(":manuallySetAsOf");

    String PROP_DISPOSITION_EVENTS_ELIGIBLE = RM_MODEL_PREFIX.concat(":dispositionEventsEligible");

    String PROP_DISPOSITION_ACTION_STARTED_AT = RM_MODEL_PREFIX.concat(":dispositionActionStartedAt");

    String PROP_DISPOSITION_ACTION_STARTED_BY = RM_MODEL_PREFIX.concat(":dispositionActionStartedBy");

    String PROP_DISPOSITION_ACTION_COMPLETED_AT = RM_MODEL_PREFIX.concat(":dispositionActionCompletedAt");

    String PROP_DISPOSITION_ACTION_COMPLETED_BY = RM_MODEL_PREFIX.concat(":dispositionActionCompletedBy");

    String ASSOC_EVENT_EXECUTIONS = RM_MODEL_PREFIX.concat(":eventExecutions");

    // Event execution type
    String TYPE_EVENT_EXECUTION = RM_MODEL_PREFIX.concat(":eventExecution");

    String PROP_EVENT_EXECUTION_NAME = RM_MODEL_PREFIX.concat(":eventExecutionName");

    String PROP_EVENT_EXECUTION_AUTOMATIC = RM_MODEL_PREFIX.concat(":eventExecutionAutomatic");

    String PROP_EVENT_EXECUTION_COMPLETE = RM_MODEL_PREFIX.concat(":eventExecutionComplete");

    String PROP_EVENT_EXECUTION_COMPLETED_BY = RM_MODEL_PREFIX.concat(":eventExecutionCompletedBy");

    String PROP_EVENT_EXECUTION_COMPLETED_AT = RM_MODEL_PREFIX.concat(":eventExecutionCompletedAt");

    // Custom RM data aspect
    String ASPECT_CUSTOM_RM_DATA = RM_MODEL_PREFIX.concat(":customRMData");

    // marker aspect on all RM objercts (except caveat root)
    String ASPECT_FILE_PLAN_COMPONENT = RM_MODEL_PREFIX.concat(":filePlanComponent");

    String PROP_ROOT_NODEREF = RM_MODEL_PREFIX.concat(":rootNodeRef");

    // Non-electronic document
    String TYPE_NON_ELECTRONIC_DOCUMENT = RM_MODEL_PREFIX.concat(":nonElectronicDocument");

    // Records management root aspect
    String ASPECT_RECORDS_MANAGEMENT_ROOT = RM_MODEL_PREFIX.concat(":recordsManagementRoot");

    // since 2.1
    @Deprecated
    String ASSOC_HOLDS = RM_MODEL_PREFIX.concat(":holds");

    // since 2.1
    @Deprecated
    String ASSOC_TRANSFERS = RM_MODEL_PREFIX.concat(":transfers");

    // Hold type
    String TYPE_HOLD = RM_MODEL_PREFIX.concat(":hold");

    String PROP_HOLD_REASON = RM_MODEL_PREFIX.concat(":holdReason");

    String ASSOC_FROZEN_RECORDS = RM_MODEL_PREFIX.concat(":frozenRecords");

    // Record meta data aspect
    String ASPECT_RECORD_META_DATA = RM_MODEL_PREFIX.concat(":recordMetaData");

    // Frozen aspect
    String ASPECT_FROZEN = RM_MODEL_PREFIX.concat(":frozen");

    String PROP_FROZEN_AT = RM_MODEL_PREFIX.concat(":frozenAt");

    String PROP_FROZEN_BY = RM_MODEL_PREFIX.concat(":frozenBy");

    // Transfer aspect
    String TYPE_TRANSFER = RM_MODEL_PREFIX.concat(":transfer");

    String PROP_TRANSFER_ACCESSION_INDICATOR = RM_MODEL_PREFIX.concat(":transferAccessionIndicator");

    String PROP_TRANSFER_PDF_INDICATOR = RM_MODEL_PREFIX.concat(":transferPDFIndicator");

    String PROP_TRANSFER_LOCATION = RM_MODEL_PREFIX.concat(":transferLocation");

    String ASSOC_TRANSFERRED = RM_MODEL_PREFIX.concat(":transferred");

    // Transferring aspect
    String ASPECT_TRANSFERRING = RM_MODEL_PREFIX.concat(":transferring");

    // Versioned record aspect
    String ASPECT_VERSIONED_RECORD = RM_MODEL_PREFIX.concat(":versionedRecord");

    // Unpublished update aspect
    String ASPECT_UNPUBLISHED_UPDATE = RM_MODEL_PREFIX.concat(":unpublishedUpdate");

    String PROP_UNPUBLISHED_UPDATE = RM_MODEL_PREFIX.concat(":unpublishedUpdate");

    String PROP_UPDATE_TO = RM_MODEL_PREFIX.concat(":updateTo");

    String PROP_UPDATED_PROPERTIES = RM_MODEL_PREFIX.concat(":updatedProperties");

    String PROP_PUBLISH_IN_PROGRESS = RM_MODEL_PREFIX.concat(":publishInProgress");

    String UPDATE_TO_DISPOSITION_ACTION_DEFINITION = "dispositionActionDefinition";

    // Ghosted aspect
    String ASPECT_GHOSTED = RM_MODEL_PREFIX.concat(":ghosted");

    // Search rollup aspect
    String ASPECT_RM_SEARCH = RM_MODEL_PREFIX.concat(":recordSearch");

    String PROP_RS_DISPOSITION_ACTION_NAME = RM_MODEL_PREFIX.concat(":recordSearchDispositionActionName");

    String PROP_RS_DISPOSITION_ACTION_AS_OF = RM_MODEL_PREFIX.concat(":recordSearchDispositionActionAsOf");

    String PROP_RS_DISPOSITION_EVENTS_ELIGIBLE = RM_MODEL_PREFIX.concat(":recordSearchDispositionEventsEligible");

    String PROP_RS_DISPOSITION_EVENTS = RM_MODEL_PREFIX.concat(":recordSearchDispositionEvents");

    String PROP_RS_VITAL_RECORD_REVIEW_PERIOD = RM_MODEL_PREFIX.concat(":recordSearchVitalRecordReviewPeriod");

    String PROP_RS_VITAL_RECORD_REVIEW_PERIOD_EXPRESSION = RM_MODEL_PREFIX
            .concat(":recordSearchVitalRecordReviewPeriodExpression");

    String PROP_RS_DISPOSITION_PERIOD = RM_MODEL_PREFIX.concat(":recordSearchDispositionPeriod");

    String PROP_RS_DISPOSITION_PERIOD_EXPRESSION = RM_MODEL_PREFIX.concat(":recordSearchDispositionPeriodExpression");

    String PROP_RS_HAS_DISPOITION_SCHEDULE = RM_MODEL_PREFIX.concat(":recordSearchHasDispositionSchedule");

    String PROP_RS_DISPOITION_INSTRUCTIONS = RM_MODEL_PREFIX.concat(":recordSearchDispositionInstructions");

    String PROP_RS_DISPOITION_AUTHORITY = RM_MODEL_PREFIX.concat(":recordSearchDispositionAuthority");

    /**
     * @depreacted as of 2.2, because disposable items can now be in multiple
     *             holds
     */
    @Deprecated
    String PROP_RS_HOLD_REASON = RM_MODEL_PREFIX.concat(":recordSearchHoldReason");

    // Loaded Data Set Ids
    String ASPECT_LOADED_DATA_SET_ID = RM_MODEL_PREFIX.concat(":loadedDataSetId");

    String PROP_LOADED_DATA_SET_IDS = RM_MODEL_PREFIX.concat(":loadedDataSetIds");

    // Extended security aspect
    // @deprecated as of 2.5, because of performance issues
    @Deprecated
    String ASPECT_EXTENDED_SECURITY = RM_MODEL_PREFIX.concat(":extendedSecurity");

    @Deprecated
    String PROP_READERS = RM_MODEL_PREFIX.concat(":readers");

    @Deprecated
    String PROP_WRITERS = RM_MODEL_PREFIX.concat(":writers");

    // Originating details of a record
    String ASPECT_RECORD_ORIGINATING_DETAILS = RM_MODEL_PREFIX.concat(":recordOriginatingDetails");

    String PROP_RECORD_ORIGINATING_USER_ID = RM_MODEL_PREFIX.concat(":recordOriginatingUserId");

    String PROP_RECORD_ORIGINATING_CREATION_DATE = RM_MODEL_PREFIX.concat(":recordOriginatingCreationDate");

    String PROP_RECORD_ORIGINATING_LOCATION = RM_MODEL_PREFIX.concat(":recordOriginatingLocation");

    // Rejection details of a record
    String ASPECT_RECORD_REJECTION_DETAILS = RM_MODEL_PREFIX.concat(":recordRejectionDetails");

    String PROP_RECORD_REJECTION_USER_ID = RM_MODEL_PREFIX.concat(":recordRejectionUserId");

    String PROP_RECORD_REJECTION_DATE = RM_MODEL_PREFIX.concat(":recordRejectionDate");

    String PROP_RECORD_REJECTION_REASON = RM_MODEL_PREFIX.concat(":recordRejectionReason");

    // Held children aspect
    // @since 2.2
    String ASPECT_HELD_CHILDREN = RM_MODEL_PREFIX.concat(":heldChildren");

    String PROP_HELD_CHILDREN_COUNT = RM_MODEL_PREFIX.concat(":heldChildrenCount");

    // Countable aspect
    String ASPECT_COUNTABLE = RM_MODEL_PREFIX.concat(":countable");

    String PROP_COUNT = RM_MODEL_PREFIX.concat(":count");

    /**
     * Common properties for file plans, record categories, record folders and
     * records
     */
    String PROP_ROOT_NODE_REF = RM_MODEL_PREFIX.concat(":rootNodeRef");

    /** Common properties for record folders and records */
    String PROP_RECORD_SEARCH_HAS_DISPOSITION_SCHEDULE = RM_MODEL_PREFIX.concat(":recordSearchHasDispositionSchedule");

    /** File plan properties */
    String PROP_COMPONENT_ID = "st:componentId";

    /** Record category properties */
    // All fields are shared with record folders

    String PROP_RECORD_SEARCH_VITAL_RECORD_REVIEW_PERIOD = RM_MODEL_PREFIX
            .concat(":recordSearchVitalRecordReviewPeriod");

    String PROP_RECORD_SEARCH_VITAL_RECORD_REVIEW_PERIOD_EXPRESSION = RM_MODEL_PREFIX
            .concat(":recordSearchVitalRecordReviewPeriodExpression");

    /** Record properties */
    String PROP_ORIGINAL_NAME = RM_MODEL_PREFIX.concat(":origionalName");

    /** Non-electronic record properties */
    String PROP_SHELF = RM_MODEL_PREFIX.concat(":shelf");

    String PROP_STORAGE_LOCATION = RM_MODEL_PREFIX.concat(":storageLocation");

    String PROP_FILE = RM_MODEL_PREFIX.concat(":file");

    String PROP_BOX = RM_MODEL_PREFIX.concat(":box");

    String PROP_NUMBER_OF_COPIES = RM_MODEL_PREFIX.concat(":numberOfCopies");

    String PROP_PHYSICAL_SIZE = RM_MODEL_PREFIX.concat(":physicalSize");

    /** Transfer properties */
    String PROP_PDF_INDICATOR = RM_MODEL_PREFIX.concat(":transferPDFIndicator");

    String PROP_ACCESSION_INDICATOR = RM_MODEL_PREFIX.concat(":transferAccessionIndicator");

}
