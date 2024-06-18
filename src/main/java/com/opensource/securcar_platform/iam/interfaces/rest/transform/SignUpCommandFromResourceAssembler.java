package com.opensource.securcar_platform.iam.interfaces.rest.transform;

import com.opensource.securcar_platform.iam.domain.model.commands.SignUpCommand;
import com.opensource.securcar_platform.iam.domain.model.entities.Role;
import com.opensource.securcar_platform.iam.interfaces.rest.resources.SignUpResource;

import java.util.*;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null ? resource.roles().stream().map(Role::toRoleFromName).toList() : new ArrayList<Role>();
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }
}
