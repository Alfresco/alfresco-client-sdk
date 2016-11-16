package org.alfresco.client.samples.customclient.deserializer;

import java.lang.reflect.Type;

import com.alfresco.client.api.common.constant.PublicAPIConstant;
import com.alfresco.client.api.core.model.representation.ServerInfoRepresentation;
import com.alfresco.client.utils.ISO8601Utils;
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
        if (je.getAsJsonObject().has(PublicAPIConstant.DATA_VALUE))
        {
            entry = je.getAsJsonObject().get(PublicAPIConstant.DATA_VALUE);
        }
        return new GsonBuilder().setDateFormat(ISO8601Utils.DATE_ISO_FORMAT).create().fromJson(entry, type);
    }
}
