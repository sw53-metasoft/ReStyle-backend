package com.metasoft.restyle.platform.profiles.interfaces.rest.resources;

public record CreateProfileResource(
        String email,
        String firstName,
        String paternalSurname,
        String maternalSurname,
        String phone,
        String description,
        String imageUrl
) {
}