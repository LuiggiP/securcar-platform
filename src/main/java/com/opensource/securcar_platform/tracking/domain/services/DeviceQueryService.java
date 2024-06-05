package com.opensource.securcar_platform.tracking.domain.services;

import com.opensource.securcar_platform.tracking.domain.model.entities.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceQueryService {
    Optional<Device> getDeviceById(Long id);
    List<Device> getAllDevices();
}

