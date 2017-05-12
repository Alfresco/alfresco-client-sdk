package org.alfresco.client.services.content.discovery.model.representation;

import java.util.List;

/**
 * Created by jpascal on 04/10/2016.
 */
public interface RepositoryInfoRepresentation
{

    /**
     * Get edition
     * 
     * @return edition
     **/
    public String getEdition();

    /**
     * Get version
     * 
     * @return version
     **/
    public VersionInfoRepresentation getVersion();

    /**
     * Get status
     * 
     * @return status
     **/
    public StatusInfoRepresentation getStatus();

    /**
     * Get license
     * 
     * @return license
     **/
    public LicenseInfoRepresentation getLicense();

    /**
     * Get modules
     * 
     * @return modules
     **/
    public List<ModuleInfoRepresentation> getModules();

}
