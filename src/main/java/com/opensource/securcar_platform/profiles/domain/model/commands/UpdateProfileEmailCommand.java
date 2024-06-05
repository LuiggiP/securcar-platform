package com.opensource.securcar_platform.profiles.domain.model.commands;

public record UpdateProfileEmailCommand(Long profileId, String newEmail) {
}
