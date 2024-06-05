package com.opensource.securcar_platform.tracking.application.internal.queryservices;

import com.opensource.securcar_platform.tracking.domain.model.entities.Vehicle;
import com.opensource.securcar_platform.tracking.domain.services.VehicleQueryService;
import com.opensource.securcar_platform.tracking.infrastructure.persistence.jpa.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleQueryServiceImpl implements VehicleQueryService {
    private final VehicleRepository vehicleRepository;

    public VehicleQueryServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}

