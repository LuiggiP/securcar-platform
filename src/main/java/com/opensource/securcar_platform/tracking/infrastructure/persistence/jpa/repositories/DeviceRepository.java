package com.opensource.securcar_platform.tracking.infrastructure.persistence.jpa.repositories;

import com.opensource.securcar_platform.tracking.domain.model.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
