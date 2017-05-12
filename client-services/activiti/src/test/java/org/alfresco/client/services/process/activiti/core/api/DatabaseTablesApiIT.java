package org.alfresco.client.services.process.activiti.core.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.alfresco.client.services.process.activiti.common.model.representation.ResultList;
import org.alfresco.client.services.process.activiti.core.ActivitiAPITestCase;
import org.alfresco.client.services.process.activiti.core.model.representation.TableMetaData;
import org.alfresco.client.services.process.activiti.core.model.representation.TableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatabaseTablesApiIT extends ActivitiAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void tablesTest() throws IOException
    {
        DatabaseTablesAPI databaseTablesAPI = client.getDatabaseTablesAPI();

        // List Tables
        List<TableResponse> tables = databaseTablesAPI.listTablesCall().execute().body();
        Assert.assertNotNull(tables);

        // Get Table Info
        TableResponse table1 = tables.get(0);
        Assert.assertNotNull(table1);
        Assert.assertEquals(table1.getClass(), TableResponse.class);
        Assert.assertNotNull(table1.getName());
        Assert.assertNotNull(table1.getCount());
        Assert.assertNotNull(table1.getUrl());

        // Retrieve Table Info
        TableResponse tableResponse = databaseTablesAPI.getTableCall(table1.getName()).execute().body();
        Assert.assertEquals(table1.getClass(), tableResponse.getClass());
        Assert.assertEquals(table1.getUrl(), tableResponse.getUrl());
        Assert.assertEquals(table1.getCount(), tableResponse.getCount());
        Assert.assertEquals(table1.getName(), tableResponse.getName());

        // Retrieve Info for table column
        TableResponse tableUser = databaseTablesAPI.getTableCall("ACT_ID_USER").execute().body();
        Assert.assertEquals(tableUser.getClass(), TableResponse.class);
        Assert.assertTrue(tableUser.getCount() > 0, tableUser.getCount() + "");

        TableMetaData metaData = databaseTablesAPI.getTableDataCall(tableUser.getName()).execute().body();
        Assert.assertNotNull(metaData.getColumnNames());
        Assert.assertNotNull(metaData.getColumnTypes());
        Assert.assertEquals(metaData.getTableName(), tableUser.getName());
        Assert.assertEquals(metaData.getColumnNames().size(), metaData.getColumnTypes().size());

        // Retrieve Info for table column
        ResultList<Map<String, Object>> data = databaseTablesAPI.listTableDataCall(tableUser.getName()).execute()
                .body();
        Assert.assertNotNull(data);
        Assert.assertNotNull(data.getList());
        Assert.assertNotNull(data.getSize());
        Assert.assertNotNull(data.getStart());

    }
}
