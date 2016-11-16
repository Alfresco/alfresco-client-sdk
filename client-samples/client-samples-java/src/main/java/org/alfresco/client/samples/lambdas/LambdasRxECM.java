package org.alfresco.client.samples.lambdas;

import java.io.IOException;

import org.testng.Assert;

import com.alfresco.client.AlfrescoClient;
import com.alfresco.client.api.core.NodesAPI;

import rx.Observable;

/**
 * Created by jpascal on 18/01/2016.
 */
public class LambdasRxECM
{
    public static void main(String[] args) throws IOException
    {
        // Create AlfrescoClient
        AlfrescoClient client = new AlfrescoClient.Builder()
                .connect("http://localhost:8080/alfresco/", "admin", "admin").build();

        NodesAPI nodesAPI = client.getNodesAPI();

        // Retrieve Company Home via Observable
        nodesAPI.getNodeObservable(NodesAPI.FOLDER_ROOT)
                .subscribe(root -> Assert.assertEquals(root.getName(), "Company Home"));

        // Get the folder Root and list all its children
        // Then get the Data Dictionary Folder and list its children
        // Then Print the number of children
        nodesAPI.getNodeObservable(NodesAPI.FOLDER_ROOT)
                .flatMap(node -> nodesAPI.listNodeChildrenObservable(node.getId()))
                .flatMap(nodes -> Observable.from(nodes.getList()))
                .filter(node -> node.isFolder() && "Data Dictionary".equals(node.getName()))
                .flatMap(dataDictionaryFolder -> nodesAPI.listNodeChildrenObservable(dataDictionaryFolder.getId()))
                .subscribe(sites -> System.out.println(sites.getPagination().getTotalItems()));
    }
}
