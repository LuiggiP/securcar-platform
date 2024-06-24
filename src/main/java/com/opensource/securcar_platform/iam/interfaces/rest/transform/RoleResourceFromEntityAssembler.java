package com.opensource.securcar_platform.iam.interfaces.rest.transform;

import com.opensource.securcar_platform.iam.domain.model.entities.Role;
import com.opensource.securcar_platform.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
