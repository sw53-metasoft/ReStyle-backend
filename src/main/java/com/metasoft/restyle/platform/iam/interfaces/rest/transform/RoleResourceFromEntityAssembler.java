package com.metasoft.restyle.platform.iam.interfaces.rest.transform;

import com.metasoft.restyle.platform.iam.domain.model.entities.Role;
import com.metasoft.restyle.platform.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role entity) {
        return new RoleResource(entity.getId(), entity.getStringName());
    }
}
