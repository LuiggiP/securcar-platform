package com.opensource.securcar_platform.profiles.infrastructure.persistence.jpa.repositories;

import com.opensource.securcar_platform.profiles.domain.model.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(String email);
}

