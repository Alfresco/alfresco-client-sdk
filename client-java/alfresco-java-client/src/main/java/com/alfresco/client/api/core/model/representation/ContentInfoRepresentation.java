/*
 *   Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *   This file is part of Alfresco Java Client.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.alfresco.client.api.core.model.representation;

import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

public class ContentInfoRepresentation extends AbstractRepresentation
{
    @SerializedName("mimeType")
    private String mimeType = null;

    @SerializedName("mimeTypeName")
    private String mimeTypeName = null;

    @SerializedName("sizeInBytes")
    private Long sizeInBytes = null;

    @SerializedName("encoding")
    private String encoding = null;

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get mimeType
     * 
     * @return mimeType
     **/
    public String getMimeType()
    {
        return mimeType;
    }

    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    /**
     * Get mimeTypeName
     * 
     * @return mimeTypeName
     **/
    public String getMimeTypeName()
    {
        return mimeTypeName;
    }

    public void setMimeTypeName(String mimeTypeName)
    {
        this.mimeTypeName = mimeTypeName;
    }

    /**
     * Get sizeInBytes
     * 
     * @return sizeInBytes
     **/
    public long getSizeInBytes()
    {
        return sizeInBytes;
    }

    public void setSizeInBytes(long sizeInBytes)
    {
        this.sizeInBytes = sizeInBytes;
    }

    /**
     * Get encoding
     * 
     * @return encoding
     **/
    public String getEncoding()
    {
        return encoding;
    }

    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ContentInfoRepresentation contentInfo = (ContentInfoRepresentation) o;
        return Objects.equals(this.mimeType, contentInfo.mimeType)
                && Objects.equals(this.mimeTypeName, contentInfo.mimeTypeName)
                && Objects.equals(this.sizeInBytes, contentInfo.sizeInBytes)
                && Objects.equals(this.encoding, contentInfo.encoding);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(mimeType, mimeTypeName, sizeInBytes, encoding);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContentInfo {\n");

        sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
        sb.append("    mimeTypeName: ").append(toIndentedString(mimeTypeName)).append("\n");
        sb.append("    sizeInBytes: ").append(toIndentedString(sizeInBytes)).append("\n");
        sb.append("    encoding: ").append(toIndentedString(encoding)).append("\n");
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
