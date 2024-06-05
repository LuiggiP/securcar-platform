package com.opensource.securcar_platform.tracking.application.internal.commandservices;

import com.opensource.securcar_platform.tracking.domain.model.commands.CreateVehicleCommand;
import com.opensource.securcar_platform.tracking.domain.model.commands.DeleteVehicleCommand;
import com.opensource.securcar_platform.tracking.domain.model.commands.UpdateVehicleNameCommand;
import com.opensource.securcar_platform.tracking.domain.model.entities.Device;
import com.opensource.securcar_platform.tracking.domain.model.entities.Vehicle;
import com.opensource.securcar_platform.tracking.domain.services.VehicleCommandService;
import com.opensource.securcar_platform.tracking.infrastructure.persistence.jpa.repositories.DeviceRepository;
import com.opensource.securcar_platform.tracking.infrastructure.persistence.jpa.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VehicleCommandServiceImpl implements VehicleCommandService {
    private final VehicleRepository vehicleRepository;
    private final DeviceRepository deviceRepository;

    public VehicleCommandServiceImpl(VehicleRepository vehicleRepository, DeviceRepository deviceRepository) {
        this.vehicleRepository = vehicleRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Vehicle handleCreateVehicle(CreateVehicleCommand command) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(command.name());
        vehicle.setLicensePlate(command.licensePlate());
        vehicle.setBrand(command.brand());
        vehicle.setModel(command.model());
        vehicle.setColor(command.color());
        vehicle.setYear(command.year());
        vehicleRepository.save(vehicle);

        Device device = new Device();
        device.setName("Default Device");
        device.setDeviceId(UUID.randomUUID().toString());
        device.setStatus("active");
        device.setVehicle(vehicle);
        deviceRepository.save(device);

        return vehicle;
    }

    @Override
    public void handleDeleteVehicle(DeleteVehicleCommand command) {
        Vehicle vehicle = vehicleRepository.findById(command.id()).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setDeleted(true);
        vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle handleUpdateVehicleName(UpdateVehicleNameCommand command) {
        Vehicle vehicle = vehicleRepository.findById(command.id()).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setName(command.name());
        return vehicleRepository.save(vehicle);
    }
}

