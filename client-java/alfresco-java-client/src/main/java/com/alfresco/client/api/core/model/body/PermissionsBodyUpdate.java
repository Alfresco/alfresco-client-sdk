package com.alfresco.client.api.core.model.body;

import java.util.List;

import com.alfresco.client.api.core.model.representation.PermissionElementRepresentation;
import com.google.gson.annotations.SerializedName;

/**
 * PermissionsBodyUpdate
 */
public class PermissionsBodyUpdate
{
    @SerializedName("isInheritanceEnabled")
    public final Boolean isInheritanceEnabled;

    @SerializedName("locallySet")
    public final List<PermissionElementRepresentation> locallySet;

    public PermissionsBodyUpdate(Boolean isInheritanceEnabled, List<PermissionElementRepresentation> locallySet)
    {
        this.isInheritanceEnabled = isInheritanceEnabled;
        this.locallySet = locallySet;
    }
}
