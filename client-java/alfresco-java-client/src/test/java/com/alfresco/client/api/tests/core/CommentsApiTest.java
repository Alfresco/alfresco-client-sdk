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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alfresco.client.api.AlfrescoAPITestCase;
import com.alfresco.client.api.common.representation.ResultPaging;
import com.alfresco.client.api.core.CommentsAPI;
import com.alfresco.client.api.core.model.body.CommentBody;
import com.alfresco.client.api.core.model.parameters.FieldsParam;
import com.alfresco.client.api.core.model.representation.CommentRepresentation;
import com.alfresco.client.api.core.model.representation.NodeRepresentation;

import retrofit2.Response;

public class CommentsApiTest extends AlfrescoAPITestCase
{
    public static final String COMMENT_1 = "<p>This is a comment.</p>";

    public static final String COMMENT_2 = "<p>2</p>";

    public static final String COMMENT_3 = "<p>3</p>";

    public static final ArrayList<String> COMMENT_VALUES = new ArrayList<String>(3)
    {
        {
            add(COMMENT_1);
            add(COMMENT_2);
            add(COMMENT_3);
        }
    };

    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void retrieveComments() throws IOException
    {
        CommentsAPI commentsAPI = client.getCommentsAPI();

        // Create a file
        NodeRepresentation dummyNode = createDummyFile();

        // Check No Comment
        Response<ResultPaging<CommentRepresentation>> response = commentsAPI.listCommentsCall(dummyNode.getId())
                .execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);
        Assert.assertEquals(response.body().getCount(), 0, "Comment already present?");

        // Add Comment
        CommentBody request = new CommentBody(COMMENT_1);
        Response<CommentRepresentation> commentResponse = commentsAPI
                .createCommentCall(dummyNode.getId(), request, null)
                .execute();
        Assert.assertEquals(commentResponse.isSuccessful(), true);
        Assert.assertEquals(commentResponse.body().getContent(), COMMENT_1,
                "Comment is not same as defined after addition");

        // Add 2 others comments
        List<CommentBody> comments = new ArrayList<>(2);
        comments.add(new CommentBody(COMMENT_2));
        comments.add(new CommentBody(COMMENT_3));
        commentsAPI.createCommentsCall(dummyNode.getId(), comments, null).execute();

        // Request All Comments for a document
        response = commentsAPI.listCommentsCall(dummyNode.getId()).execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true);

        // Check Response
        ResultPaging<CommentRepresentation> commentsResponse = response.body();
        Assert.assertNotNull(commentsResponse, "Response is empty");
        Assert.assertNotNull(commentsResponse.getList(), "Response has no comments");

        // Check Pagination & Entries
        List<CommentRepresentation> commentList = commentsResponse.getList();
        for (CommentRepresentation rep : commentList)
        {
            Assert.assertNotNull(rep);
            Assert.assertTrue(COMMENT_VALUES.contains(rep.getContent()));
        }

        // Edit all Comments
        for (CommentRepresentation rep : commentList)
        {
            commentsAPI.updateCommentCall(dummyNode.getId(), rep.getId(), request).execute();
        }

        // Check everything has changed
        FieldsParam fields = new FieldsParam(Arrays.asList("id", "content"));

        response = commentsAPI.listCommentsCall(dummyNode.getId(), 0, 5, fields).execute();
        commentList = response.body().getList();
        for (CommentRepresentation rep : commentList)
        {
            Assert.assertNotNull(rep);
            Assert.assertTrue(COMMENT_1.contains(rep.getContent()));
        }

        // Remove all Comments
        for (CommentRepresentation rep : commentList)
        {
            commentsAPI.deleteCommentCall(dummyNode.getId(), rep.getId()).execute();
        }

        // Check everything has been erased
        response = commentsAPI.listCommentsCall(dummyNode.getId()).execute();
        Assert.assertEquals(response.body().getCount(), 0);
        Assert.assertEquals(response.body().getList().size(), 0);

    }
}
