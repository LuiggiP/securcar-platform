package com.opensource.securcar_platform.tracking.domain.model.entities;

import com.opensource.securcar_platform.profiles.domain.model.entities.Profile;
import com.opensource.securcar_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vehicle extends AuditableAbstractAggregateRoot<Vehicle> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String licensePlate;
    private String brand;
    private String model;
    private String color;
    private int year;
    private boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}

