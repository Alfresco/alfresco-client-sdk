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

package org.alfresco.client.services.content.core.model.deserializer;

import static org.alfresco.client.services.common.constant.ApiConstant.ENTRY;

import java.lang.reflect.Type;

import org.alfresco.client.services.common.model.deserializer.EntryDeserializer;
import org.alfresco.client.services.content.core.model.representation.FileRepresentation;
import org.alfresco.client.services.content.core.model.representation.FolderRepresentation;
import org.alfresco.client.services.content.core.model.representation.LinkRepresentation;
import org.alfresco.client.services.content.core.model.representation.NodeRepresentation;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Created by jpascal on 19/01/2016.
 */
public class NodeEntryDeserializer extends EntryDeserializer<NodeRepresentation>
{
    @Override
    public NodeRepresentation deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException
    {
        JsonElement entry = je;
        if (je.getAsJsonObject().has(ENTRY))
        {
            entry = je.getAsJsonObject().get(ENTRY);
        }

        // Based on flags
        if (entry.getAsJsonObject().has("isFile") && entry.getAsJsonObject().get("isFile").getAsBoolean())
        {
            return jdc.deserialize(entry, FileRepresentation.class);
        }
        else if (entry.getAsJsonObject().has("isFolder") && entry.getAsJsonObject().get("isFolder").getAsBoolean())
        {
            return jdc.deserialize(entry, FolderRepresentation.class);
        }
        else if (entry.getAsJsonObject().has("isLink") && entry.getAsJsonObject().get("isLink").getAsBoolean())
        {
            return jdc.deserialize(entry, LinkRepresentation.class);

        }
        else
        {
            return jdc.deserialize(entry, NodeRepresentation.class);
        }
    }
}
