
package org.alfresco.client.services.governance.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * RequestBodyFile
 */
public class RecordBodyFile
{

    @SerializedName("targetParentId")
    public final String targetParentId;

    public RecordBodyFile(String targetParentId)
    {
        this.targetParentId = targetParentId;
    }
}
