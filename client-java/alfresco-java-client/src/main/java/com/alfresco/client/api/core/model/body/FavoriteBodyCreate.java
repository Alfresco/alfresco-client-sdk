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
 * Created by jpascal on 25/08/2016.
 */
public class FavoriteBodyCreate
{
    @SerializedName("target")
    public final Object target;

    public enum FavoriteTypeEnum
    {
        SITE("SITE"),

        FILE("FILE"),

        FOLDER("FOLDER");

        private String value;

        FavoriteTypeEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }

        public String value()
        {
            return value;
        }
    }

    public FavoriteBodyCreate(FavoriteTypeEnum type, String guid)
    {
        switch (type)
        {
            case FILE:
                this.target = new FavoriteFileRequest(new FavoriteGuid(guid));
                break;
            case FOLDER:
                this.target = new FavoriteFolderRequest(new FavoriteGuid(guid));
                break;
            case SITE:
                this.target = new FavoriteSiteRequest(new FavoriteGuid(guid));
                break;
            default:
                this.target = null;
        }
    }

    private class FavoriteGuid
    {
        @SerializedName("guid")
        public final String guid;

        public FavoriteGuid(String guid)
        {
            this.guid = guid;
        }
    }

    private class FavoriteSiteRequest
    {
        @SerializedName("site")
        public final FavoriteGuid site;

        public FavoriteSiteRequest(FavoriteGuid site)
        {
            this.site = site;
        }
    }

    private class FavoriteFileRequest
    {
        @SerializedName("file")
        public final FavoriteGuid site;

        public FavoriteFileRequest(FavoriteGuid site)
        {
            this.site = site;
        }
    }

    private class FavoriteFolderRequest
    {
        @SerializedName("folder")
        public final FavoriteGuid site;

        public FavoriteFolderRequest(FavoriteGuid site)
        {
            this.site = site;
        }
    }
}
