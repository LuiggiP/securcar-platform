package com.opensource.securcar_platform.tracking.application.internal.commandservices;

import com.opensource.securcar_platform.tracking.domain.model.commands.UpdateDeviceNameCommand;
import com.opensource.securcar_platform.tracking.domain.model.entities.Device;
import com.opensource.securcar_platform.tracking.domain.services.DeviceCommandService;
import com.opensource.securcar_platform.tracking.infrastructure.persistence.jpa.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceCommandServiceImpl implements DeviceCommandService {
    private final DeviceRepository deviceRepository;

    public DeviceCommandServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device handleUpdateDeviceName(UpdateDeviceNameCommand command) {
        Device device = deviceRepository.findById(command.id()).orElseThrow(() -> new RuntimeException("Device not found"));
        device.setName(command.name());
        return deviceRepository.save(device);
    }
}

