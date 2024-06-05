package com.opensource.securcar_platform.tracking.interfaces.rest;

import com.opensource.securcar_platform.tracking.application.internal.commandservices.DeviceCommandServiceImpl;
import com.opensource.securcar_platform.tracking.application.internal.queryservices.DeviceQueryServiceImpl;
import com.opensource.securcar_platform.tracking.domain.model.commands.UpdateDeviceNameCommand;
import com.opensource.securcar_platform.tracking.domain.model.entities.Device;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController {
    private final DeviceCommandServiceImpl deviceCommandService;
    private final DeviceQueryServiceImpl deviceQueryService;

    public DeviceController(DeviceCommandServiceImpl deviceCommandService, DeviceQueryServiceImpl deviceQueryService) {
        this.deviceCommandService = deviceCommandService;
        this.deviceQueryService = deviceQueryService;
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<Device> updateDeviceName(@PathVariable Long id, @RequestBody UpdateDeviceNameCommand command) {
        Device updatedDevice = deviceCommandService.handleUpdateDeviceName(new UpdateDeviceNameCommand(id, command.name()));
        return ResponseEntity.ok(updatedDevice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Optional<Device> device = deviceQueryService.getDeviceById(id);
        return device.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceQueryService.getAllDevices();
        return ResponseEntity.ok(devices);
    }
}

