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

package org.alfresco.client.services.content.core;

import java.io.IOException;

import org.alfresco.client.services.CSAPITestCase;
import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.core.api.FavoritesAPI;
import org.alfresco.client.services.content.core.model.body.FavoriteBodyCreate;
import org.alfresco.client.services.content.core.model.representation.FavoriteRepresentation;
import org.alfresco.client.services.content.core.model.representation.NodeRepresentation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retrofit2.Response;

public class FavoritesApiTest extends CSAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void retrieveFavorites() throws IOException
    {
        FavoritesAPI favoritesAPI = client.getFavoritesAPI();

        // Create File
        NodeRepresentation dummyNode = createDummyFile();

        // Check No Favorites
        Response<ResultPaging<FavoriteRepresentation>> response = favoritesAPI.listFavoritesCall(TEST_USERNAME)
                .execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);
        Assert.assertEquals(response.body().getCount(), 0, "Favorite already present?");

        // Add Favorite File
        Response<FavoriteRepresentation> favResponse = favoritesAPI.createFavoriteCall(TEST_USERNAME,
                new FavoriteBodyCreate(FavoriteBodyCreate.FavoriteTypeEnum.FILE, dummyNode.getId()), null).execute();
        Assert.assertNotNull(favResponse);
        Assert.assertEquals(favResponse.isSuccessful(), true);

        String favId = favResponse.body().getTargetGuid();

        // Check One Favorites
        response = favoritesAPI.listFavoritesCall(TEST_USERNAME).execute();
        Assert.assertEquals(response.body().getCount(), 1, "Favorite already present?");

        // Retrieve one favorite
        Response<FavoriteRepresentation> favResponse2 = favoritesAPI.getFavoriteCall(TEST_USERNAME, favId).execute();
        Assert.assertEquals(favResponse2.body(), favResponse.body(), "Favorite are not the same?");

        // Remove Favorite
        favoritesAPI.deleteFavoriteCall(TEST_USERNAME, favId).execute();

        // Check No Favorites
        response = favoritesAPI.listFavoritesCall(TEST_USERNAME).execute();
        Assert.assertEquals(response.body().getCount(), 0, "Favorite already present?");

    }
}
