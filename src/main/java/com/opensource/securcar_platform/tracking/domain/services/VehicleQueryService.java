package com.opensource.securcar_platform.tracking.domain.services;

import com.opensource.securcar_platform.tracking.domain.model.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleQueryService {
    Optional<Vehicle> getVehicleById(Long id);
    List<Vehicle> getAllVehicles();
}
