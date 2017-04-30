package org.alfresco.client.services.governance;

import org.alfresco.client.services.common.model.deserializer.EntryDeserializer;
import org.alfresco.client.services.common.model.deserializer.PagingDeserializer;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.governance.core.model.deserializer.RMNodeEntryDeserializer;
import org.alfresco.client.services.governance.core.model.representation.*;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Created by jpascal on 30/04/2017.
 */
public class GSGsonBuilder
{
    public static GsonBuilder registerGSConfig(GsonBuilder builder)
    {

        return builder
                // Entry
                .registerTypeAdapter(TransferRepresentation.class, new EntryDeserializer<TransferRepresentation>())
                .registerTypeAdapter(TransferContainerRepresentation.class,
                        new EntryDeserializer<TransferContainerRepresentation>())
                .registerTypeAdapter(UnfiledContainerRepresentation.class,
                        new EntryDeserializer<UnfiledContainerRepresentation>())
                .registerTypeAdapter(RecordRepresentation.class, new EntryDeserializer<RecordRepresentation>())
                .registerTypeAdapter(RecordFolderRepresentation.class,
                        new EntryDeserializer<RecordFolderRepresentation>())
                .registerTypeAdapter(RMNodeRepresentation.class, new RMNodeEntryDeserializer())
                .registerTypeAdapter(RMSiteRepresentation.class, new EntryDeserializer<RMSiteRepresentation>())
                .registerTypeAdapter(FilePlanRepresentation.class, new EntryDeserializer<FilePlanRepresentation>())
                .registerTypeAdapter(RecordCategoryRepresentation.class,
                        new EntryDeserializer<RecordCategoryRepresentation>())
                .registerTypeAdapter(UnfiledRecordFolderRepresentation.class,
                        new EntryDeserializer<UnfiledRecordFolderRepresentation>())
                .registerTypeAdapter(new TypeToken<ResultPaging<RecordCategoryRepresentation>>()
                {
                }.getType(), new PagingDeserializer<>(RecordCategoryRepresentation.class))
                .registerTypeAdapter(new TypeToken<ResultPaging<RMNodeRepresentation>>()
                {
                }.getType(), new PagingDeserializer<>(RMNodeRepresentation.class))
                .registerTypeAdapter(new TypeToken<ResultPaging<RecordFolderRepresentation>>()
                {
                }.getType(), new PagingDeserializer<>(RecordFolderRepresentation.class))
                .registerTypeAdapter(new TypeToken<ResultPaging<UnfiledContainerRepresentation>>()
                {
                }.getType(), new PagingDeserializer<>(UnfiledContainerRepresentation.class))
                .registerTypeAdapter(new TypeToken<ResultPaging<TransferRepresentation>>()
                {
                }.getType(), new PagingDeserializer<>(TransferRepresentation.class))
                .registerTypeAdapter(new TypeToken<ResultPaging<RecordRepresentation>>()
                {
                }.getType(), new PagingDeserializer<>(RecordRepresentation.class));

    }
}
