package com.alfresco.client.api.search.model;

import com.google.gson.annotations.SerializedName;

/**
 * SearchEntry
 */
public class SearchScore
{
    @SerializedName("score")
    private Float score = null;

    /**
     * The score for this row
     * 
     * @return score
     **/
    public Float getScore()
    {
        return score;
    }

    public void setScore(Float score)
    {
        this.score = score;
    }
}
