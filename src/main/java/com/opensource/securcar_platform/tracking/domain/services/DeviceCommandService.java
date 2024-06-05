package com.opensource.securcar_platform.tracking.domain.services;

import com.opensource.securcar_platform.tracking.domain.model.commands.UpdateDeviceNameCommand;
import com.opensource.securcar_platform.tracking.domain.model.entities.Device;

public interface DeviceCommandService {
    Device handleUpdateDeviceName(UpdateDeviceNameCommand command);
}

