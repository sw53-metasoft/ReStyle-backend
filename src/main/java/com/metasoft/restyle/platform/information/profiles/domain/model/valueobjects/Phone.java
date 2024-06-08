package com.metasoft.restyle.platform.information.profiles.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record Phone(Long number) {

    public Phone {
        if (number == null || number < 0) {
            throw new IllegalArgumentException("Phone number must not be null or negative");
        }
    }

    public String getFormattedPhoneNumber() {
        return String.format("(%s) %s-%s",
                number.toString().substring(0, 3),
                number.toString().substring(3, 6),
                number.toString().substring(6, 10));
    }

    public Long getNumber() {
        return number;
    }
}
