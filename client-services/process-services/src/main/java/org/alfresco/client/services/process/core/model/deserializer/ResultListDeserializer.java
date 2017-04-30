/*
 *  Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *  This file is part of Alfresco Activiti Client.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.alfresco.client.services.process.core.model.deserializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.alfresco.client.services.process.core.constant.RequestConstant;
import org.alfresco.client.services.process.core.model.common.ResultList;

import com.google.gson.*;

/**
 * Created by jpascal on 19/01/2016.
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
