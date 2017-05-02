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
public class AuditDecisionRuleInfoRepresentation
{

    protected String title = "Rule";

    protected List<AuditDecisionExpressionInfoRepresentation> expressions = new ArrayList<>();

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public List<AuditDecisionExpressionInfoRepresentation> getExpressions()
    {
        return expressions;
    }

    public void setExpressions(List<AuditDecisionExpressionInfoRepresentation> expressions)
    {
        this.expressions = expressions;
    }

    public void addExpression(AuditDecisionExpressionInfoRepresentation expression)
    {
        this.expressions.add(expression);
    }
}
