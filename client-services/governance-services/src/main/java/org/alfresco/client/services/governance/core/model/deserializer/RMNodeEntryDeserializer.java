/*
 *   Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *   This file is part of Alfresco Java Client.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.alfresco.client.services.governance.core.model.deserializer;

import static org.alfresco.client.services.common.constant.ApiConstant.ENTRY;

import java.lang.reflect.Type;

import org.alfresco.client.services.common.model.deserializer.EntryDeserializer;
import org.alfresco.client.services.governance.core.model.RecordsManagementModel;
import org.alfresco.client.services.governance.core.model.representation.*;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Created by jpascal on 19/01/2016.
 */
public class RMNodeEntryDeserializer extends EntryDeserializer<RMNodeRepresentation>
{
    @Override
    public RMNodeRepresentation deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException
    {
        JsonElement entry = je;
        if (je.getAsJsonObject().has(ENTRY))
        {
            entry = je.getAsJsonObject().get(ENTRY);
        }

        // Based on nodeType
        if (entry.getAsJsonObject().has("isRecord") && entry.getAsJsonObject().get("isRecord").getAsBoolean())
        {
            return jdc.deserialize(entry, RecordRepresentation.class);
        }
        else if (entry.getAsJsonObject().has("isRecordCategory")
                && entry.getAsJsonObject().get("isRecordCategory").getAsBoolean())
        {
            return jdc.deserialize(entry, RecordCategoryRepresentation.class);
        }
        else if (entry.getAsJsonObject().has("isRecordFolder")
                && entry.getAsJsonObject().get("isRecordFolder").getAsBoolean())
        {
            return jdc.deserialize(entry, RecordFolderRepresentation.class);
        }
        else if (entry.getAsJsonObject().has("isUnfiledRecordFolder")
                && entry.getAsJsonObject().get("isUnfiledRecordFolder").getAsBoolean())
        {
            return jdc.deserialize(entry, UnfiledRecordFolderRepresentation.class);
        }
        else if (entry.getAsJsonObject().has("isRecord") && entry.getAsJsonObject().get("isRecord").getAsBoolean())
        {
            return jdc.deserialize(entry, RecordRepresentation.class);
        }
        else
        {
            String nodeType = entry.getAsJsonObject().get("nodeType").getAsString();
            if (nodeType.equals(RecordsManagementModel.TYPE_RECORD_CATEGORY))
            {
                return jdc.deserialize(entry, RecordCategoryRepresentation.class);
            }
            else if (nodeType.equals(RecordsManagementModel.TYPE_RECORD_FOLDER))
            {
                return jdc.deserialize(entry, RecordFolderRepresentation.class);
            }
            else if (nodeType.equals(RecordsManagementModel.TYPE_UNFILED_RECORD_FOLDER)) { return jdc.deserialize(entry,
                    UnfiledRecordFolderRepresentation.class); }
        }
        return null;
    }
}
