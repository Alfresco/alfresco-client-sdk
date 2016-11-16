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

package org.alfresco.client.cli;

import io.airlift.airline.Cli;
import io.airlift.airline.Help;
import io.airlift.airline.Option;
import io.airlift.airline.OptionType;

/**
 * Created by jpascal on 18/01/2016.
 */
public class AlfrescoCLI
{
    public static void main(String[] args)
    {
        Cli.CliBuilder<Runnable> builder = Cli.<Runnable> builder("alfclient")
                .withDescription("Sample Alfresco Command Line Client").withDefaultCommand(Help.class)
                .withCommands(Help.class, AlfrescoCommands.infoUser.class)
                .withCommands(Help.class, AlfrescoCommands.listRoot.class);

        Cli<Runnable> gitParser = builder.build();

        gitParser.parse(args).run();
    }

    public static class BaseCommand implements Runnable
    {
        @Option(type = OptionType.GLOBAL, name = "-v", description = "Verbose mode")
        public boolean verbose;

        @Option(type = OptionType.GLOBAL, name = "-h", required = true, description = "Hostname")
        public String hostname;

        @Option(type = OptionType.GLOBAL, name = "-u", required = true, description = "Username")
        public String username;

        @Option(type = OptionType.GLOBAL, name = "-p", required = true, description = "Password")
        public String password;

        public void run()
        {
            System.out.println(getClass().getSimpleName());
        }
    }
}
