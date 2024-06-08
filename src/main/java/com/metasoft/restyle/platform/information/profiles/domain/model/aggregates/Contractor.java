package com.metasoft.restyle.platform.information.profiles.domain.model.aggregates;

import com.metasoft.restyle.platform.information.profiles.domain.model.valueobjects.Phone;
import com.metasoft.restyle.platform.profiles.domain.model.aggregates.Profile;
import com.metasoft.restyle.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
public class Contractor extends AuditableAbstractAggregateRoot<Contractor> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @OneToOne
    @JoinColumn(name = "user_id")
    private Profile profile;

    @Getter
    @Column(name = "phone")
    private Phone phoneNumber;


    @Getter
    private String description;



    public Contractor(String description, Long number) {
        this.description = description;
        this.phoneNumber = new Phone(number);
    }

    public Contractor() {}

    public Long getFormattedPhoneNumber() {
        return this.phoneNumber.getNumber();
    }

}
