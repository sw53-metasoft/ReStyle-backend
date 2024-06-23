package com.metasoft.restyle.platform.profiles.domain.model.commands;

public record UpdateProfileCommand(Long profileId, String email, String phone, String description, String imageUrl) {
}
