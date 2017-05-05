package org.alfresco.client.samples.customclient.deserializer;

import static org.alfresco.client.services.common.constant.ApiConstant.DATA;

import java.lang.reflect.Type;

import org.alfresco.client.services.common.utils.ISO8601Utils;
import org.alfresco.client.services.content.core.model.representation.ServerInfoRepresentation;

import com.google.gson.*;

/**
 * Created by jpascal on 19/01/2016.
 */
public class ServerInfoDeserializer implements JsonDeserializer<ServerInfoRepresentation>
{
    @Override
    public ServerInfoRepresentation deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException
    {
        JsonElement entry = je;
        if (je.getAsJsonObject().has(DATA))
        {
            entry = je.getAsJsonObject().get(DATA);
        }
        return new GsonBuilder().setDateFormat(ISO8601Utils.DATE_ISO_FORMAT).create().fromJson(entry, type);
    }
}
