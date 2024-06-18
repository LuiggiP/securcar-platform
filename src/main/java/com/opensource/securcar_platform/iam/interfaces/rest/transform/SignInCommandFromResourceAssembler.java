package com.opensource.securcar_platform.iam.interfaces.rest.transform;

import com.opensource.securcar_platform.iam.domain.model.commands.SignInCommand;
import com.opensource.securcar_platform.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
