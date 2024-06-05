package com.opensource.securcar_platform.profiles.application.internal.commandservices;

import com.opensource.securcar_platform.profiles.domain.model.commands.CreateProfileCommand;
import com.opensource.securcar_platform.profiles.domain.model.commands.UpdateProfileEmailCommand;
import com.opensource.securcar_platform.profiles.domain.model.entities.Profile;
import com.opensource.securcar_platform.profiles.domain.services.ProfileCommandService;
import com.opensource.securcar_platform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile handle(CreateProfileCommand command) {
        Profile profile = new Profile();
        profile.setFullName(command.fullName());
        profile.setDni(command.dni());
        profile.setEmail(command.email());
        profile.setBirthDate(command.birthDate());
        profile.setPhone(command.phone());
        profile.setAffiliatedCompany(command.affiliatedCompany());
        return profileRepository.save(profile);
    }

    @Override
    public Profile handle(UpdateProfileEmailCommand command) {
        Profile profile = profileRepository.findById(command.profileId()).orElseThrow(() -> new RuntimeException("Profile not found"));
        profile.setEmail(command.newEmail());
        return profileRepository.save(profile);
    }
}

