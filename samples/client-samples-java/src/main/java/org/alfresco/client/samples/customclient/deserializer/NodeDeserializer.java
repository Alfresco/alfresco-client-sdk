package org.alfresco.client.samples.customclient.deserializer;

import java.lang.reflect.Type;

import org.alfresco.client.samples.customclient.model.Node;
import org.alfresco.client.samples.customclient.model.NodeImpl;
import org.alfresco.client.services.common.constant.PublicAPIConstant;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Created by jpascal on 19/01/2016.
 */
public class NodeDeserializer implements JsonDeserializer<Node>
{
    @Override
    public Node deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException
    {
        JsonElement entry = je;
        if (je.getAsJsonObject().has(PublicAPIConstant.ENTRY_VALUE))
        {
            entry = je.getAsJsonObject().get(PublicAPIConstant.ENTRY_VALUE);
        }
        return jdc.deserialize(entry, NodeImpl.class);
    }
}
