package org.alfresco.client.services.process;

import org.alfresco.client.services.process.core.model.common.ResultList;
import org.alfresco.client.services.process.core.model.deserializer.ResultListDeserializer;
import org.alfresco.client.services.process.core.model.runtime.ProcessDefinitionRepresentation;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Created by jpascal on 30/04/2017.
 */
public class PSGsonBuilder
{
    public static GsonBuilder registerPSConfig(GsonBuilder builder)
    {

        return builder.registerTypeAdapter(new TypeToken<ResultList<ProcessDefinitionRepresentation>>()
        {
        }.getType(), new ResultListDeserializer<>(ProcessDefinitionRepresentation.class));

    }
}
