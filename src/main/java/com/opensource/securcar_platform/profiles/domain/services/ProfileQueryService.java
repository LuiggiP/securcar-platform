package com.opensource.securcar_platform.profiles.domain.services;

import com.opensource.securcar_platform.profiles.domain.model.entities.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> getProfileById(Long id);
    Optional<Profile> getProfileByEmail(String email);
    List<Profile> getAllProfiles();
}

