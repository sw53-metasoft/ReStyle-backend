package com.metasoft.restyle.platform.profiles.interfaces.rest.resources;

public record UpdateProfileResource(String email, String phone, String description, String imageUrl) {
}
