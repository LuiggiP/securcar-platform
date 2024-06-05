package com.opensource.securcar_platform.tracking.domain.model.entities;

import com.opensource.securcar_platform.profiles.domain.model.entities.Profile;
import com.opensource.securcar_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a vehicle.
 */
@Getter
@Setter
@Entity
public class Vehicle extends AuditableAbstractAggregateRoot<Vehicle> {

    /**
     * Unique identifier for the vehicle.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the vehicle.
     */
    private String name;

    /**
     * License plate of the vehicle.
     */
    private String licensePlate;

    /**
     * Brand of the vehicle.
     */
    private String brand;

    /**
     * Model of the vehicle.
     */
    private String model;

    /**
     * Color of the vehicle.
     */
    private String color;

    /**
     * Year of the vehicle.
     */
    private int year;

    /**
     * Flag indicating if the vehicle is soft deleted.
     */
    private boolean deleted = false;

    /**
     * Profile associated with the vehicle.
     */
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}


