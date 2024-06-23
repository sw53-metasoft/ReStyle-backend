package com.metasoft.restyle.platform.profiles.domain.model.commands;

public record CreateProfileCommand(
        String email,
        String firstName,
        String paternalSurname,
        String maternalSurname,
        String phone,
        String description,
        String imageUrl
) {}
