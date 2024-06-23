package com.metasoft.restyle.platform.profiles.interfaces.rest.resources;

public record ProfileResource(
        Long id,
        String email,
        String fullName,
        String phone,
        String description,
        String imageUrl
) {
}
