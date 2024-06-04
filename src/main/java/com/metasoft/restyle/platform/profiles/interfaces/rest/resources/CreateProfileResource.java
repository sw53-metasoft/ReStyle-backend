package com.metasoft.restyle.platform.profiles.interfaces.rest.resources;

public record CreateProfileResource(
        String email,
        String typeUser,
        String firstName,
        String paternalSurname,
        String maternalSurname
) {
}