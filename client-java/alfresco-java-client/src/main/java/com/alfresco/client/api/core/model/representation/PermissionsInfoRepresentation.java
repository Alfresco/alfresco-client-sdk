package com.alfresco.client.api.core.model.representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * PermissionsInfo
 */
public class PermissionsInfoRepresentation
{
    @SerializedName("isInheritanceEnabled")
    private Boolean isInheritanceEnabled = null;

    @SerializedName("inherited")
    private List<PermissionElementRepresentation> inherited = new ArrayList<>();

    @SerializedName("locallySet")
    private List<PermissionElementRepresentation> locallySet = new ArrayList<>();

    @SerializedName("settable")
    private List<String> settable = new ArrayList<String>();

    /**
     * Get isInheritanceEnabled
     * 
     * @return isInheritanceEnabled
     **/
    public Boolean getIsInheritanceEnabled()
    {
        return isInheritanceEnabled;
    }

    public void setIsInheritanceEnabled(Boolean isInheritanceEnabled)
    {
        this.isInheritanceEnabled = isInheritanceEnabled;
    }

    /**
     * Get inherited
     * 
     * @return inherited
     **/
    public List<PermissionElementRepresentation> getInherited()
    {
        return inherited;
    }

    public void setInherited(List<PermissionElementRepresentation> inherited)
    {
        this.inherited = inherited;
    }

    /**
     * Get locallySet
     * 
     * @return locallySet
     **/
    public List<PermissionElementRepresentation> getLocallySet()
    {
        return locallySet;
    }

    public void setLocallySet(List<PermissionElementRepresentation> locallySet)
    {
        this.locallySet = locallySet;
    }

    /**
     * Get settable
     * 
     * @return settable
     **/
    public List<String> getSettable()
    {
        return settable;
    }

    public void setSettable(List<String> settable)
    {
        this.settable = settable;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PermissionsInfoRepresentation permissionsInfo = (PermissionsInfoRepresentation) o;
        return Objects.equals(this.isInheritanceEnabled, permissionsInfo.isInheritanceEnabled)
                && Objects.equals(this.inherited, permissionsInfo.inherited)
                && Objects.equals(this.locallySet, permissionsInfo.locallySet)
                && Objects.equals(this.settable, permissionsInfo.settable);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(isInheritanceEnabled, inherited, locallySet, settable);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class PermissionsInfo {\n");

        sb.append("    isInheritanceEnabled: ").append(toIndentedString(isInheritanceEnabled)).append("\n");
        sb.append("    inherited: ").append(toIndentedString(inherited)).append("\n");
        sb.append("    locallySet: ").append(toIndentedString(locallySet)).append("\n");
        sb.append("    settable: ").append(toIndentedString(settable)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o)
    {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }
}
