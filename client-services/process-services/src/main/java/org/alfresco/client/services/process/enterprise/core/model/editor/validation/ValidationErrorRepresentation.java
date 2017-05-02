/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.editor.validation;

/**
 * Representation of validation errors of a model.
 * 
 * @author Tijs Rademakers
 */
public class ValidationErrorRepresentation
{

    protected String id;

    protected String name;

    protected String validatorSetName;

    protected String problem;

    protected String problemReference;

    // Default description in english.
    // Other languages can map the validatorSetName/validatorName to the
    // translated version.
    protected String defaultDescription;

    protected boolean isWarning;

    public ValidationErrorRepresentation()
    {

    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getValidatorSetName()
    {
        return validatorSetName;
    }

    public void setValidatorSetName(String validatorSetName)
    {
        this.validatorSetName = validatorSetName;
    }

    public String getProblem()
    {
        return problem;
    }

    public void setProblem(String problem)
    {
        this.problem = problem;
    }

    public String getProblemReference()
    {
        return problemReference;
    }

    public void setProblemReference(String problemReference)
    {
        this.problemReference = problemReference;
    }

    public String getDefaultDescription()
    {
        return defaultDescription;
    }

    public void setDefaultDescription(String defaultDescription)
    {
        this.defaultDescription = defaultDescription;
    }

    public boolean isWarning()
    {
        return isWarning;
    }

    public void setWarning(boolean isWarning)
    {
        this.isWarning = isWarning;
    }
}
