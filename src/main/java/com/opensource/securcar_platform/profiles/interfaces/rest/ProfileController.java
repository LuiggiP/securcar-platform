package com.opensource.securcar_platform.profiles.interfaces.rest;

import com.opensource.securcar_platform.profiles.application.internal.commandservices.ProfileCommandServiceImpl;
import com.opensource.securcar_platform.profiles.application.internal.queryservices.ProfileQueryServiceImpl;
import com.opensource.securcar_platform.profiles.domain.model.commands.CreateProfileCommand;
import com.opensource.securcar_platform.profiles.domain.model.commands.UpdateProfileEmailCommand;
import com.opensource.securcar_platform.profiles.domain.model.entities.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    private final ProfileCommandServiceImpl profileCommandService;
    private final ProfileQueryServiceImpl profileQueryService;

    public ProfileController(ProfileCommandServiceImpl profileCommandService, ProfileQueryServiceImpl profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody CreateProfileCommand command) {
        Profile profile = profileCommandService.handle(command);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<Profile> updateProfileEmail(@PathVariable Long id, @RequestBody UpdateProfileEmailCommand command) {
        Profile updatedProfile = profileCommandService.handle(new UpdateProfileEmailCommand(id, command.newEmail()));
        return ResponseEntity.ok(updatedProfile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Optional<Profile> profile = profileQueryService.getProfileById(id);
        return profile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Profile> getProfileByEmail(@PathVariable String email) {
        Optional<Profile> profile = profileQueryService.getProfileByEmail(email);
        return profile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileQueryService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }
}

