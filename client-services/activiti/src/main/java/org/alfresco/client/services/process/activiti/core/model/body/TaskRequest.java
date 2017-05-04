package org.alfresco.client.services.process.activiti.core.model.body;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * TaskRequest
 */
public class TaskRequest
{
    @SerializedName("owner")
    public final String owner;

    @SerializedName("assignee")
    public final String assignee;

    @SerializedName("delegationState")
    public final String delegationState;

    @SerializedName("name")
    public final String name;

    @SerializedName("description")
    public final String description;

    @SerializedName("dueDate")
    public final Date dueDate;

    @SerializedName("priority")
    public final Integer priority;

    @SerializedName("parentTaskId")
    public final String parentTaskId;

    @SerializedName("category")
    public final String category;

    @SerializedName("tenantId")
    public final String tenantId;

    @SerializedName("formKey")
    public final String formKey;

    @SerializedName("ownerSet")
    public final Boolean ownerSet;

    @SerializedName("assigneeSet")
    public final Boolean assigneeSet;

    @SerializedName("delegationStateSet")
    public final Boolean delegationStateSet;

    @SerializedName("nameSet")
    public final Boolean nameSet;

    @SerializedName("descriptionSet")
    public final Boolean descriptionSet;

    @SerializedName("duedateSet")
    public final Boolean duedateSet;

    @SerializedName("prioritySet")
    public final Boolean prioritySet;

    @SerializedName("parentTaskIdSet")
    public final Boolean parentTaskIdSet;

    @SerializedName("categorySet")
    public final Boolean categorySet;

    @SerializedName("tenantIdSet")
    public final Boolean tenantIdSet;

    @SerializedName("formKeySet")
    public final Boolean formKeySet;

    public TaskRequest(String name, String description, String owner, String assignee)
    {
        this.owner = owner;
        this.assignee = assignee;
        this.delegationState = null;
        this.name = name;
        this.description = description;
        this.dueDate = null;
        this.priority = null;
        this.parentTaskId = null;
        this.category = null;
        this.tenantId = null;
        this.formKey = null;
        this.ownerSet = null;
        this.assigneeSet = null;
        this.delegationStateSet = null;
        this.nameSet = null;
        this.descriptionSet = null;
        this.duedateSet = null;
        this.prioritySet = null;
        this.parentTaskIdSet = null;
        this.categorySet = null;
        this.tenantIdSet = null;
        this.formKeySet = null;
    }

    public TaskRequest(String owner, String assignee, String delegationState, String name, String description,
            Date dueDate, Integer priority, String parentTaskId, String category, String tenantId, String formKey,
            Boolean ownerSet, Boolean assigneeSet, Boolean delegationStateSet, Boolean nameSet, Boolean descriptionSet,
            Boolean duedateSet, Boolean prioritySet, Boolean parentTaskIdSet, Boolean categorySet, Boolean tenantIdSet,
            Boolean formKeySet)
    {
        this.owner = owner;
        this.assignee = assignee;
        this.delegationState = delegationState;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.parentTaskId = parentTaskId;
        this.category = category;
        this.tenantId = tenantId;
        this.formKey = formKey;
        this.ownerSet = ownerSet;
        this.assigneeSet = assigneeSet;
        this.delegationStateSet = delegationStateSet;
        this.nameSet = nameSet;
        this.descriptionSet = descriptionSet;
        this.duedateSet = duedateSet;
        this.prioritySet = prioritySet;
        this.parentTaskIdSet = parentTaskIdSet;
        this.categorySet = categorySet;
        this.tenantIdSet = tenantIdSet;
        this.formKeySet = formKeySet;
    }
}
