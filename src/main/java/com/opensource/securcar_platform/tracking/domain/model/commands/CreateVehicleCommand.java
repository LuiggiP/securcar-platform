package com.opensource.securcar_platform.tracking.domain.model.commands;

public record CreateVehicleCommand(String name, String licensePlate, String brand, String model, String color, int year) {
}

