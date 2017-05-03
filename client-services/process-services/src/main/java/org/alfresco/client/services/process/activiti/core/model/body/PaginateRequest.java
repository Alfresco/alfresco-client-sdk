package org.alfresco.client.services.process.activiti.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 03/05/2017.
 */
public class PaginateRequest
{
    @SerializedName("start")
    public final Integer start;

    @SerializedName("size")
    public final Integer size;

    @SerializedName("sort")
    public final String sort;

    @SerializedName("order")
    public final String order;

    public PaginateRequest(Integer start, Integer size, String sort, String order)
    {
        this.start = start;
        this.size = size;
        this.sort = sort;
        this.order = order;
    }
}
