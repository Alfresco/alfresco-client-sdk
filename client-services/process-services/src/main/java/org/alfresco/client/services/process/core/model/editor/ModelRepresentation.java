/*
 *  Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *  This file is part of Alfresco Activiti Client.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.alfresco.client.services.process.core.model.editor;

import java.util.Date;

import org.alfresco.client.services.process.core.model.common.AbstractRepresentation;

/**
 * Representation of process-models, both current and historic models.
 * 
 * @author Tijs Rademakers
 */
public class ModelRepresentation extends AbstractRepresentation
{

    protected Long id;

    protected String name;

    protected String description;

    protected Long createdBy;

    protected String createdByFullName;

    protected Long lastUpdatedBy;

    protected String lastUpdatedByFullName;

    protected Date lastUpdated;

    protected boolean latestVersion;

    protected int version;

    protected String comment;

    protected Long stencilSet;

    protected Long referenceId;

    protected Integer modelType;

    protected Boolean favorite;

    protected String permission;

    public ModelRepresentation()
    {

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public Long getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy)
    {
        this.createdBy = createdBy;
    }

    public String getCreatedByFullName()
    {
        return createdByFullName;
    }

    public void setCreatedByFullName(String createdByFullName)
    {
        this.createdByFullName = createdByFullName;
    }

    public void setLatestVersion(boolean latestVersion)
    {
        this.latestVersion = latestVersion;
    }

    public boolean isLatestVersion()
    {
        return latestVersion;
    }

    public int getVersion()
    {
        return version;
    }

    public void setVersion(int version)
    {
        this.version = version;
    }

    public Long getLastUpdatedBy()
    {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy)
    {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedByFullName()
    {
        return lastUpdatedByFullName;
    }

    public void setLastUpdatedByFullName(String lastUpdatedByFullName)
    {
        this.lastUpdatedByFullName = lastUpdatedByFullName;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getComment()
    {
        return comment;
    }

    public Long getStencilSet()
    {
        return stencilSet;
    }

    public void setStencilSet(Long stencilSet)
    {
        this.stencilSet = stencilSet;
    }

    public Long getReferenceId()
    {
        return referenceId;
    }

    public void setReferenceId(Long referenceId)
    {
        this.referenceId = referenceId;
    }

    public Integer getModelType()
    {
        return modelType;
    }

    public void setModelType(Integer modelType)
    {
        this.modelType = modelType;
    }

    public void setFavorite(Boolean favorite)
    {
        this.favorite = favorite;
    }

    public Boolean getFavorite()
    {
        return favorite;
    }

    public String getPermission()
    {
        return permission;
    }

    public void setPermission(String permission)
    {
        this.permission = permission;
    }

    public void setSharePermission(SharePermission permission)
    {
        if (permission != null)
        {
            this.permission = permission.toString().toLowerCase();
        }
    }
    /**
     * public Model toModel() { Model model = new Model(); model.setName(name);
     * model.setDescription(description); return model; } Update all editable
     * properties of the given {@link Model} based on the values in this
     * instance. public void updateModel(Model model) {
     * model.setDescription(this.description); model.setName(this.name); }
     */
}
