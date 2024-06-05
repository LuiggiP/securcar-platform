package com.opensource.securcar_platform.profiles.domain.model.commands;

import java.util.Date;

public record CreateProfileCommand(String fullName, String dni, String email, Date birthDate, String phone, String affiliatedCompany) {
}

