package com.metasoft.restyle.platform.information.profiles.domain.model.commands;

public record CreateRemodelerCommand(String description, Long phoneNumber, String subscription) {


    public Object PhoneNumber() {
        return null;
    }
}
