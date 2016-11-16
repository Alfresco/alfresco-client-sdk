package com.alfresco.client.api.search.body;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Limit the time and resources used for query execution
 */
public class RequestLimits
{
    @SerializedName("permissionEvaluationTime")
    private Integer permissionEvaluationTime = null;

    @SerializedName("permissionEvaluationCount")
    private Integer permissionEvaluationCount = null;

    public RequestLimits permissionEvaluationTime(Integer permissionEvaluationTime)
    {
        this.permissionEvaluationTime = permissionEvaluationTime;
        return this;
    }

    /**
     * Maximum time for post query permission evaluation
     * 
     * @return permissionEvaluationTime
     **/
    public Integer getPermissionEvaluationTime()
    {
        return permissionEvaluationTime;
    }

    public void setPermissionEvaluationTime(Integer permissionEvaluationTime)
    {
        this.permissionEvaluationTime = permissionEvaluationTime;
    }

    public RequestLimits permissionEvaluationCount(Integer permissionEvaluationCount)
    {
        this.permissionEvaluationCount = permissionEvaluationCount;
        return this;
    }

    /**
     * Maximum count of post query permission evaluations
     * 
     * @return permissionEvaluationCount
     **/
    public Integer getPermissionEvaluationCount()
    {
        return permissionEvaluationCount;
    }

    public void setPermissionEvaluationCount(Integer permissionEvaluationCount)
    {
        this.permissionEvaluationCount = permissionEvaluationCount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RequestLimits requestLimits = (RequestLimits) o;
        return Objects.equals(this.permissionEvaluationTime, requestLimits.permissionEvaluationTime)
                && Objects.equals(this.permissionEvaluationCount, requestLimits.permissionEvaluationCount);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(permissionEvaluationTime, permissionEvaluationCount);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestLimits {\n");

        sb.append("    permissionEvaluationTime: ").append(toIndentedString(permissionEvaluationTime)).append("\n");
        sb.append("    permissionEvaluationCount: ").append(toIndentedString(permissionEvaluationCount)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o)
    {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }
}
