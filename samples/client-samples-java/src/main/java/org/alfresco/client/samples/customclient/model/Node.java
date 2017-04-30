package org.alfresco.client.samples.customclient.model;

import java.util.Date;
import java.util.List;

import org.alfresco.client.services.content.core.model.representation.ContentInfoRepresentation;
import org.alfresco.client.services.content.core.model.representation.PathInfoRepresentation;
import org.alfresco.client.services.content.core.model.representation.UserInfoRepresentation;

import com.google.gson.internal.LinkedTreeMap;

/**
 * Created by jpascal on 21/01/2016.
 */
public interface Node
{

    String getIdentifier();

    String getName();

    String getNodeType();

    String getDescription();

    Date getCreatedAt();

    UserInfoRepresentation getCreatedBy();

    boolean isFolder();

    Date getModifiedAt();

    UserInfoRepresentation getModifiedBy();

    String getParentId();

    PathInfoRepresentation getPath();

    ContentInfoRepresentation getContent();

    List<String> getAspects();

    boolean hasAspects(String aspectName);

    LinkedTreeMap<String, Object> getProperties();

}
