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

package com.alfresco.client.api.tests.core;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alfresco.client.api.AlfrescoAPITestCase;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.PeopleAPI;
import com.alfresco.client.api.core.SitesAPI;
import com.alfresco.client.api.core.model.body.SiteBodyCreate;
import com.alfresco.client.api.core.model.body.SiteMembershipRequestBodyCreate;
import com.alfresco.client.api.core.model.representation.*;

import retrofit2.Response;

public class SiteApiTest extends AlfrescoAPITestCase
{
    public static final String SWSDP_ID = "swsdp";

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void siteApiTests() throws IOException
    {
        //
        SitesAPI siteService = client.getAPI(SitesAPI.class);

        // Request Site By Id
        Response<SiteRepresentation> response = siteService.getSiteCall(SWSDP_ID).execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        SiteRepresentation siteRepresentation = response.body();
        Assert.assertNotNull(siteRepresentation, "Response is empty");
        Assert.assertEquals(siteRepresentation.getId(), SWSDP_ID, "Site Id seems wrong.");
        Assert.assertEquals(siteRepresentation.getDescription(), "This is a Sample Alfresco Team site.",
                "Site description seems wrong.");
        Assert.assertEquals(siteRepresentation.getVisibility(), "PUBLIC", "Site visibility seems wrong.");
        Assert.assertEquals(siteRepresentation.getTitle(), "Sample: Web Site Design Project",
                "Site title seems wrong.");
        Assert.assertEquals(siteRepresentation.getGuid(), "b4cff62a-664d-4d45-9302-98723eac1319",
                "Site guid seems wrong.");
    }

    @Test
    public void siteContainersApiTests() throws IOException
    {
        SitesAPI siteService = client.getAPI(SitesAPI.class);

        // Request Site Containers
        Response<ResultPaging<SiteContainerRepresentation>> containersResponse = siteService
                .listSiteContainersCall(SWSDP_ID).execute();
        Assert.assertNotNull(containersResponse);
        Assert.assertEquals(containersResponse.isSuccessful(), true);

        // Check Response
        ResultPaging<SiteContainerRepresentation> siteContainerResponse = containersResponse.body();
        Assert.assertNotNull(siteContainerResponse, "Response is empty");
        Assert.assertNotNull(siteContainerResponse.getList(), "Response has no data");
        Assert.assertNotNull(siteContainerResponse.getPagination(), "Response has no pagination");
        Assert.assertEquals(siteContainerResponse.getPagination().getCount(), 5, "Pagination count is wrong.");
        Assert.assertFalse(siteContainerResponse.getPagination().getHasMoreItems(), "Pagination HasMoreItem is wrong.");
        Assert.assertEquals(siteContainerResponse.getPagination().getSkipCount(), 0, "Pagination SkipCount is wrong.");
        Assert.assertEquals(siteContainerResponse.getPagination().getTotalItems(), 5, "Pagination TotalItem is wrong.");

        // Loop over Container Information
        for (int i = 0; i < siteContainerResponse.getPagination().getCount(); i++)
        {
            Assert.assertNotNull(siteContainerResponse.getList().get(i).getId(), "Container ID is empty");
            Assert.assertNotNull(siteContainerResponse.getList().get(i).getFolderId(), "Container Folder ID is empty");
        }
    }

    public static final String SITE_TEST_ID = "AClientSiteTest";

    public static final String SITE_TEST_DESCRIPTION = "ClientSiteTest";

    public static final String SITE_TEST_TITLE = "ClientSiteTest";

    public static final SiteVisibilityEnum SITE_TEST_VISIBILITY = SiteVisibilityEnum.PUBLIC;

    @Test
    public void siteLifecyleTest() throws IOException, InterruptedException
    {
        SitesAPI siteService = client.getSitesAPI();

        // Check Test site is not present
        Response<SiteRepresentation> siteResponse = siteService.getSiteCall(SITE_TEST_ID).execute();
        if (siteResponse.isSuccessful())
        {
            // Delete Site
            siteService.deleteSiteCall(SITE_TEST_ID, true).execute();
            for (int i = 0; i < 5; i++)
            {
                // Deleting site might takes time so we have to wait few
                // moments
                Thread.sleep(5000);
                // Retrieve by its Id
                siteResponse = siteService.getSiteCall(SITE_TEST_ID).execute();
                if (!siteResponse.isSuccessful())
                {
                    break;
                }

                if (i == 5)
                {
                    Assert.fail("Unable to delete site even after waiting");
                }
            }
        }
        else
        {
            // Check Error
            Assert.assertFalse(siteResponse.isSuccessful());
            Assert.assertNotNull(siteResponse.errorBody());
        }

        // Create Test Site
        siteResponse = siteService
                .createSiteCall(
                        new SiteBodyCreate(SITE_TEST_ID, SITE_TEST_TITLE, SITE_TEST_DESCRIPTION, SITE_TEST_VISIBILITY))
                .execute();
        Assert.assertTrue(siteResponse.isSuccessful());
        Assert.assertNotNull(siteResponse.body());
        SiteRepresentation siteRepresentation = siteResponse.body();

        Assert.assertEquals(siteRepresentation.getId(), SITE_TEST_ID, "Site Id seems wrong.");
        Assert.assertEquals(siteRepresentation.getDescription(), SITE_TEST_DESCRIPTION,
                "Site description seems wrong.");
        Assert.assertEquals(siteRepresentation.getVisibility(), SITE_TEST_VISIBILITY.toString(),
                "Site visibility seems wrong.");
        Assert.assertEquals(siteRepresentation.getVisibilityEnum(), SiteVisibilityEnum.PUBLIC,
                "Site visibility seems wrong.");
        Assert.assertEquals(siteRepresentation.getTitle(), SITE_TEST_TITLE, "Site title seems wrong.");
        Assert.assertNotNull(siteRepresentation.getGuid(), "Site guid seems wrong.");

        // Delete Site
        // Delete Site
        siteService.deleteSiteCall(SITE_TEST_ID, true).execute();
        for (int i = 0; i < 5; i++)
        {
            // Deleting site might takes time so we have to wait few
            // moments
            Thread.sleep(5000);
            // Retrieve by its Id
            siteResponse = siteService.getSiteCall(SITE_TEST_ID).execute();
            if (!siteResponse.isSuccessful()) { return; }
        }
        Assert.fail("Unable to delete site even after waiting");
    }

    @Test
    public void siteMembersApiTests() throws IOException
    {
        //
        SitesAPI siteService = client.getAPI(SitesAPI.class);

        // Request Site By Id
        Response<ResultPaging<SiteMemberRepresentation>> response = siteService.listSiteMembershipsCall(SWSDP_ID)
                .execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        ResultPaging<SiteMemberRepresentation> membersResponse = response.body();
        Assert.assertNotNull(membersResponse, "Response is empty");
        Assert.assertNotNull(membersResponse.getList(), "Response has no data");
        Assert.assertNotNull(membersResponse.getPagination(), "Response has no pagination");
        Assert.assertEquals(membersResponse.getPagination().getCount(), 3, "Pagination count is wrong.");
        Assert.assertFalse(membersResponse.getPagination().getHasMoreItems(), "Pagination HasMoreItem is wrong.");
        Assert.assertEquals(membersResponse.getPagination().getSkipCount(), 0, "Pagination SkipCount is wrong.");

        // Loop over Container Information
        for (SiteMemberRepresentation member : membersResponse.getList())
        {
            Assert.assertNotNull(member.getId(), "Member ID is empty");
            Assert.assertNotNull(member.getRole(), "Member Role is empty");
            Assert.assertNotNull(member.getPerson(), "Member PersonInfo is empty");

            PersonRepresentation person = member.getPerson();
            Assert.assertNotNull(person.getFirstName(), "Person Firstname is empty");
            // Assert.assertNotNull(person.getLastName(), "Person LastName is
            // empty");
            Assert.assertNotNull(person.getEmail(), "Person Email is empty");
            // Assert.assertTrue(person.isEnabled(), "Person IsEnabled is
            // False");
            Assert.assertTrue(person.isEmailNotificationsEnabled(), "Person EmailNotificationsEnabled is False");

            // Request One Member Info
            Response<SiteMemberRepresentation> memberInfoResponse = siteService
                    .getSiteMembershipCall(SWSDP_ID, person.getId()).execute();
            SiteMemberRepresentation memberInfo = memberInfoResponse.body();
            PersonRepresentation personInfo = memberInfo.getPerson();

            // Member Info Comparison
            Assert.assertEquals(member.getId(), memberInfo.getId());
            Assert.assertEquals(member.getRole(), memberInfo.getRole());

            // Person Info Comparison
            Assert.assertEquals(person.getId(), personInfo.getId());
            Assert.assertEquals(person.getFirstName(), personInfo.getFirstName());
            Assert.assertEquals(person.getLastName(), personInfo.getLastName());
            Assert.assertEquals(person.getEmail(), personInfo.getEmail());
        }
    }

    @Test
    public void retrieveAllSitesTest() throws IOException
    {
        // Request All Sites
        Response<ResultPaging<SiteRepresentation>> response = client.getAPI(SitesAPI.class).listSitesCall().execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        ResultPaging<SiteRepresentation> sitesResponse = response.body();
        Assert.assertNotNull(sitesResponse, "Response is empty");
        Assert.assertNotNull(sitesResponse.getList(), "Response has no listActivitiesForPersonCall of sites");

        // Check Pagination & Entries
        List<SiteRepresentation> sitesRepresentation = sitesResponse.getList();
        // Assert.assertNotNull(sitesRepresentation.getEntries(), "Response has
        // no listActivitiesForPersonCall of sites");
        Assert.assertNotNull(sitesResponse.getPagination(), "Response has no pagination");

        // Retrieve SWSDP Site and check we have the information
        for (int i = 0; i < sitesResponse.getPagination().getCount(); i++)
        {
            SiteRepresentation siteRepresentation = sitesRepresentation.get(i);
            if (SWSDP_ID.equals(siteRepresentation.getId()))
            {
                Assert.assertEquals(siteRepresentation.getId(), SWSDP_ID, "Site Id seems wrong.");
                Assert.assertEquals(siteRepresentation.getDescription(), "This is a Sample Alfresco Team site.",
                        "Site description seems wrong.");
                Assert.assertEquals(siteRepresentation.getVisibility(), "PUBLIC", "Site visibility seems wrong.");
                Assert.assertEquals(siteRepresentation.getVisibilityEnum(), SiteVisibilityEnum.PUBLIC,
                        "Site visibility seems wrong.");
                Assert.assertEquals(siteRepresentation.getTitle(), "Sample: Web Site Design Project",
                        "Site title seems wrong.");
                Assert.assertEquals(siteRepresentation.getGuid(), "b4cff62a-664d-4d45-9302-98723eac1319",
                        "Site guid seems wrong.");
            }
        }
    }

    @Test(enabled = false)
    public void siteMemberships() throws IOException
    {
        PeopleAPI peopleAPI = client.getPeopleAPI();
        SitesAPI siteAPI = client.getSitesAPI();

        // LIST MEMBERSHIP REQUEST
        Response<ResultPaging<SiteMembershipRequestRepresentation>> response = siteAPI
                .listSiteMembershipRequestsForPersonCall(TEST_USERNAME).execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        ResultPaging<SiteMembershipRequestRepresentation> siteMembership = response.body();
        Assert.assertNotNull(siteMembership, "Response is empty");
        Assert.assertNotNull(siteMembership.getList(), "Response has no listActivitiesForPersonCall of body");
        Assert.assertEquals(siteMembership.getPagination().getCount(), 0);

        // CREATE MEMBERSHIP REQUEST
        SiteMembershipRequestBodyCreate request = new SiteMembershipRequestBodyCreate("moderatedsite", "Name", "Title");
        Response<SiteMembershipRequestRepresentation> respM = siteAPI
                .createSiteMembershipRequestForPersonCall(TEST_USERNAME, request, null).execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        SiteMembershipRequestRepresentation siteMembershipR = respM.body();
        Assert.assertNotNull(siteMembershipR, "Response is empty");
        Assert.assertNotNull(siteMembershipR.getId(), "Response has no Id");
        Assert.assertNotNull(siteMembershipR.getSite(), "Response has no Site");
        Assert.assertEquals(siteMembershipR.getSite().getId(), "moderatedsite", "Wrong site");
        Assert.assertNotNull(siteMembershipR.getCreatedAt(), "Response has no Creation Date");

        // LIST MEMBERSHIP REQUEST
        response = siteAPI.listSiteMembershipRequestsForPersonCall(TEST_USERNAME).execute();
        Assert.assertEquals(response.isSuccessful(), true);
        Assert.assertEquals(response.body().getPagination().getCount(), 1);

        // REMOVE MEMBERSHIP REQUEST
        Response<Void> responseRemove = siteAPI.deleteSiteMembershipRequestCall(TEST_USERNAME, "moderatedsite")
                .execute();
        Assert.assertEquals(responseRemove.isSuccessful(), true);
    }
}
