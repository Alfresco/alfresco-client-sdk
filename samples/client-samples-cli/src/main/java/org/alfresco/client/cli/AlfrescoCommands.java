package org.alfresco.client.cli;

import java.io.IOException;

import org.alfresco.client.services.common.model.representation.ResultPaging;
import org.alfresco.client.services.content.CSClient;
import org.alfresco.client.services.content.core.api.NodesAPI;
import org.alfresco.client.services.content.core.model.representation.NodeRepresentation;
import org.alfresco.client.services.content.core.model.representation.PersonRepresentation;

import io.airlift.airline.Command;

/**
 * Created by jpascal on 02/03/2016.
 */
public class AlfrescoCommands
{

    @Command(name = "list-root", description = "List Company Home")
    public static class listRoot extends AlfrescoCLI.BaseCommand
    {
        @Override
        public void run()
        {
            try
            {
                final CSClient client = new CSClient.Builder().connect(hostname, username, password)
                        .build();
                ResultPaging<NodeRepresentation> nodes = client.getNodesAPI().listNodeChildrenCall(NodesAPI.FOLDER_ROOT)
                        .execute().body();

                System.out.println("");
                System.out.println("---------------------------------------------");
                System.out.println("COMPANY HOME CHILDREN");
                System.out.println("---------------------------------------------");
                for (NodeRepresentation node : nodes.getList())
                {
                    if (node.isFolder())
                    {
                        System.out.println(" + " + node.getName());
                    }
                    else
                    {
                        System.out.println(" - " + node.getName());
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Command(name = "user-info", description = "Person Info")
    public static class infoUser extends AlfrescoCLI.BaseCommand
    {
        @Override
        public void run()
        {
            try
            {
                final CSClient client = new CSClient.Builder().connect(hostname, username, password)
                        .build();
                PersonRepresentation person = client.getPeopleAPI().getPersonCall(username).execute().body();

                System.out.println("");
                System.out.println("---------------------------------------------");
                System.out.println("PERSON INFO");
                System.out.println("---------------------------------------------");
                System.out.println("First Name:" + person.getFirstName());
                System.out.println("Last Name:" + person.getLastName());
                System.out.println("Email:" + person.getEmail());
                System.out.println("Location:" + person.getLocation());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}
