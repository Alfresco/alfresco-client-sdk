/**
 * Copyright 2005-2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */
package org.alfresco.client.services.process.enterprise.core.model.runtime;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasile Dirla
 */
public class AuditDecisionInfoRepresentation
{

    protected List<AuditCalculatedValueRepresentation> calculatedValues = new ArrayList<>();

    protected List<AuditDecisionRuleInfoRepresentation> appliedRules = new ArrayList<>();

    public List<AuditCalculatedValueRepresentation> getCalculatedValues()
    {
        return calculatedValues;
    }

    public void setCalculatedValues(List<AuditCalculatedValueRepresentation> calculatedValues)
    {
        this.calculatedValues = calculatedValues;
    }

    public void addCalculatedValue(AuditCalculatedValueRepresentation value)
    {
        this.calculatedValues.add(value);
    }

    public List<AuditDecisionRuleInfoRepresentation> getAppliedRules()
    {
        return appliedRules;
    }

    public void setAppliedRules(List<AuditDecisionRuleInfoRepresentation> appliedRules)
    {
        this.appliedRules = appliedRules;
    }

    public void addAppliedRule(AuditDecisionRuleInfoRepresentation rule)
    {
        this.appliedRules.add(rule);
    }

}
