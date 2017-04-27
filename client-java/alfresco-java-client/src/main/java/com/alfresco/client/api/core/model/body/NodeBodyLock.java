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

package com.alfresco.client.api.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jpascal on 22/08/2016.
 */
public class NodeBodyLock
{
    /**
     * Gets or Sets type
     */
    public enum TypeEnum
    {
        @SerializedName("FULL") FULL("FULL"),

        @SerializedName("ALLOW_ADD_CHILDREN") ALLOW_ADD_CHILDREN("ALLOW_ADD_CHILDREN"),

        @SerializedName("ALLOW_OWNER_CHANGES") ALLOW_OWNER_CHANGES("ALLOW_OWNER_CHANGES");

        private String value;

        TypeEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    /**
     * Gets or Sets lifetime
     */
    public enum LifetimeEnum
    {
        @SerializedName("PERSISTENT") PERSISTENT("PERSISTENT"),

        @SerializedName("EPHEMERAL") EPHEMERAL("EPHEMERAL");

        private String value;

        LifetimeEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    @SerializedName("timeToExpire")
    public final Integer timeToExpire;

    @SerializedName("type")
    public final TypeEnum type;

    @SerializedName("lifetime")
    public final LifetimeEnum lifetime;

    public NodeBodyLock()
    {
        this.timeToExpire = null;
        this.type = null;
        this.lifetime = null;
    }

    public NodeBodyLock(Integer timeToExpire, TypeEnum type, LifetimeEnum lifetime)
    {
        this.timeToExpire = timeToExpire;
        this.type = type != null ? type : TypeEnum.ALLOW_OWNER_CHANGES;
        this.lifetime = lifetime != null ? lifetime : LifetimeEnum.PERSISTENT;
    }

}
