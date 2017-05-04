package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.List;

import org.alfresco.client.services.process.activiti.core.model.representation.RestVariable;

import com.google.gson.annotations.SerializedName;

/**
 * TaskActionRequest
 */
public class TaskActionRequest
{
    public static final String ACTION_COMPLETE = "complete";

    public static final String ACTION_CLAIM = "claim";

    public static final String ACTION_DELEGATE = "delegate";

    public static final String ACTION_RESOLVE = "resolve";

    @SerializedName("action")
    public final String action;

    @SerializedName("assignee")
    public final String assignee;

    @SerializedName("variables")
    public final List<RestVariable> variables;

    @SerializedName("transientVariables")
    public final List<RestVariable> transientVariables;

    public TaskActionRequest(String action)
    {
        this.action = action;
        this.assignee = null;
        this.variables = null;
        this.transientVariables = null;
    }

    public TaskActionRequest(String action, String assignee, List<RestVariable> variables,
            List<RestVariable> transientVariables)
    {
        this.action = action;
        this.assignee = assignee;
        this.variables = variables;
        this.transientVariables = transientVariables;
    }
}
