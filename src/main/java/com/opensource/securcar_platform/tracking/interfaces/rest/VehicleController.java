package com.opensource.securcar_platform.tracking.interfaces.rest;

import com.opensource.securcar_platform.tracking.application.internal.commandservices.VehicleCommandServiceImpl;
import com.opensource.securcar_platform.tracking.application.internal.queryservices.VehicleQueryServiceImpl;
import com.opensource.securcar_platform.tracking.domain.model.commands.CreateVehicleCommand;
import com.opensource.securcar_platform.tracking.domain.model.commands.DeleteVehicleCommand;
import com.opensource.securcar_platform.tracking.domain.model.commands.UpdateVehicleNameCommand;
import com.opensource.securcar_platform.tracking.domain.model.entities.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    private final VehicleCommandServiceImpl vehicleCommandService;
    private final VehicleQueryServiceImpl vehicleQueryService;

    public VehicleController(VehicleCommandServiceImpl vehicleCommandService, VehicleQueryServiceImpl vehicleQueryService) {
        this.vehicleCommandService = vehicleCommandService;
        this.vehicleQueryService = vehicleQueryService;
    }

    @PostMapping
    public ResponseEntity<Long> createVehicle(@RequestBody CreateVehicleCommand command) {
        Vehicle vehicle = vehicleCommandService.handleCreateVehicle(command);
        return new ResponseEntity<>(vehicle.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<Vehicle> updateVehicleName(@PathVariable Long id, @RequestBody UpdateVehicleNameCommand command) {
        Vehicle updatedVehicle = vehicleCommandService.handleUpdateVehicleName(new UpdateVehicleNameCommand(id, command.name()));
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleCommandService.handleDeleteVehicle(new DeleteVehicleCommand(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleQueryService.getVehicleById(id);
        return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleQueryService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }
}

