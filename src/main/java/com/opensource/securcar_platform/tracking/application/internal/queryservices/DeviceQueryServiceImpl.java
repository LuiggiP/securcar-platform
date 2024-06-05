package com.opensource.securcar_platform.tracking.application.internal.queryservices;

import com.opensource.securcar_platform.tracking.domain.model.entities.Device;
import com.opensource.securcar_platform.tracking.domain.services.DeviceQueryService;
import com.opensource.securcar_platform.tracking.infrastructure.persistence.jpa.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceQueryServiceImpl implements DeviceQueryService {
    private final DeviceRepository deviceRepository;

    public DeviceQueryServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
}
