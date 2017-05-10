package org.alfresco.client.services.process.activiti.common.model.deserializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.alfresco.client.services.process.activiti.common.constant.RequestConstant;
import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;

import com.google.gson.*;

/**
 * Created by jpascal on 04/05/2017.
 */
public class ResultListDeserializer<T> implements JsonDeserializer<ResultList<T>>
{
    protected Class<T> clazz;

    public ResultListDeserializer(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    @Override
    public ResultList<T> deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException
    {
        JsonArray entries = null;
        if (je.getAsJsonObject().has(RequestConstant.DATA))
        {
            entries = je.getAsJsonObject().get(RequestConstant.DATA).getAsJsonArray();
        }

        final List<T> result = new ArrayList<>();
        T obj = null;
        if (entries != null)
        {
            for (Object entry : entries)
            {
                obj = jdc.deserialize((JsonElement) entry, clazz);
                result.add(obj);
            }
        }

        ResultList<T> resultList = new ResultList<>();
        resultList.setList(result);
        resultList.setSize(je.getAsJsonObject().has(RequestConstant.SIZE)
                ? je.getAsJsonObject().get(RequestConstant.SIZE).getAsInt() : 0);
        resultList.setStart(je.getAsJsonObject().has(RequestConstant.START)
                ? je.getAsJsonObject().get(RequestConstant.START).getAsInt() : 0);
        resultList.setTotal(je.getAsJsonObject().has(RequestConstant.TOTAL)
                ? je.getAsJsonObject().get(RequestConstant.TOTAL).getAsInt() : 0);

        return resultList;
    }

}
