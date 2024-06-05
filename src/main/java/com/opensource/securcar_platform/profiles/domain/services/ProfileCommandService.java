package com.opensource.securcar_platform.profiles.domain.services;

import com.opensource.securcar_platform.profiles.domain.model.commands.CreateProfileCommand;
import com.opensource.securcar_platform.profiles.domain.model.commands.UpdateProfileEmailCommand;
import com.opensource.securcar_platform.profiles.domain.model.entities.Profile;

public interface ProfileCommandService {
    Profile handle(CreateProfileCommand command);
    Profile handle(UpdateProfileEmailCommand command);
}

