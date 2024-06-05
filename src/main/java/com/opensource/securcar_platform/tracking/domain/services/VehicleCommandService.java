package com.opensource.securcar_platform.tracking.domain.services;

import com.opensource.securcar_platform.tracking.domain.model.commands.CreateVehicleCommand;
import com.opensource.securcar_platform.tracking.domain.model.commands.DeleteVehicleCommand;
import com.opensource.securcar_platform.tracking.domain.model.commands.UpdateVehicleNameCommand;
import com.opensource.securcar_platform.tracking.domain.model.entities.Vehicle;

public interface VehicleCommandService {
    Vehicle handleCreateVehicle(CreateVehicleCommand command);
    void handleDeleteVehicle(DeleteVehicleCommand command);
    Vehicle handleUpdateVehicleName(UpdateVehicleNameCommand command);
}

