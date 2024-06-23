package com.metasoft.restyle.platform.profiles.domain.model.aggregates;

import com.metasoft.restyle.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.metasoft.restyle.platform.profiles.domain.model.valueobjects.EmailAddress;
import com.metasoft.restyle.platform.profiles.domain.model.valueobjects.PersonName;
import com.metasoft.restyle.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Embedded
    private EmailAddress email;

    @Embedded
    private PersonName name;

    @Getter
    private String phone;

    @Getter
    private String description;

    @Getter
    private String imageUrl;

    public Profile(String email, String firstName, String paternalSurname, String maternalSurname, String phone, String description, String imageUrl) {
        this.email = new EmailAddress(email);
        this.name = new PersonName(firstName, paternalSurname, maternalSurname);
        this.phone = phone;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Profile(CreateProfileCommand command){
        this.email = new EmailAddress(command.email());
        this.name = new PersonName(command.firstName(), command.paternalSurname(), command.maternalSurname());
        this.phone = command.phone();
        this.description = command.description();
        this.imageUrl = command.imageUrl();
    }

    public Profile() {}

    public void updateName(String firstName, String paternalSurname, String maternalSurname) {
        this.name = new PersonName(firstName, paternalSurname, maternalSurname);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFullName() {
        return this.name.getFullName();
    }

    public String getEmailAddress() {
        return this.email.address();
    }

}
