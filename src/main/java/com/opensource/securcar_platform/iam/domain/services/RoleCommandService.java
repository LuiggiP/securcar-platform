package com.opensource.securcar_platform.iam.domain.services;

import com.opensource.securcar_platform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
