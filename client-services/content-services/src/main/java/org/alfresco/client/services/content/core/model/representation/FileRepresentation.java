package org.alfresco.client.services.content.core.model.representation;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 29/04/2017.
 */
public class FileRepresentation extends NodeRepresentation
{

    @SerializedName("content")
    protected ContentInfoRepresentation content = null;

    /**
     * Get content
     *
     * @return content
     **/
    public ContentInfoRepresentation getContent()
    {
        return content;
    }

    public void setContent(ContentInfoRepresentation content)
    {
        this.content = content;
    }
}
