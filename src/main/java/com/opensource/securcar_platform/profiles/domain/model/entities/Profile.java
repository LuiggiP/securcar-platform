package com.opensource.securcar_platform.profiles.domain.model.entities;

import com.opensource.securcar_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Entity representing a profile.
 */
@Getter
@Setter
@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    /**
     * Unique identifier for the profile.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Full name of the profile.
     */
    private String fullName;

    /**
     * DNI (Document Number Identifier) of the profile.
     */
    private String dni;

    /**
     * Email of the profile.
     */
    private String email;

    /**
     * Birthdate of the profile.
     */
    private Date birthDate;

    /**
     * Phone number of the profile.
     */
    private String phone;

    /**
     * Affiliated company of the profile. This field can be empty.
     */
    private String affiliatedCompany;
}


