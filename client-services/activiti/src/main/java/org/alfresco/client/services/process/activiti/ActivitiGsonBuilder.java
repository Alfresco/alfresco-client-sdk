package org.alfresco.client.services.process.activiti;

import com.google.gson.GsonBuilder;

/**
 * Created by jpascal on 30/04/2017.
 */
public class ActivitiGsonBuilder
{
    public static GsonBuilder registerActivitiConfig(GsonBuilder builder)
    {
        return builder;
        /*
         * return builder.registerTypeAdapter(new
         * TypeToken<ResultList<DeploymentResourceResponse>>() { }.getType(),
         * new ResultListDeserializer<>(DeploymentResourceResponse.class));
         */

    }
}
