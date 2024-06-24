package com.opensource.securcar_platform.tracking.domain.model.entities;

import com.opensource.securcar_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a device associated with a vehicle.
 */
@Getter
@Setter
@Entity
public class Device extends AuditableAbstractAggregateRoot<Device> {

    /**
     * Unique identifier for the device.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the device.
     */
    private String name;

    /**
     * Unique identifier for the device.
     */
    private String deviceId;

    /**
     * Status of the device.
     */
    private String status;

    /**
     * The vehicle associated with this device.
     */
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}


