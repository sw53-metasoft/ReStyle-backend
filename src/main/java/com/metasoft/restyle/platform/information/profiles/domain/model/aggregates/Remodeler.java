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
public class Remodeler extends AuditableAbstractAggregateRoot<Remodeler> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @OneToOne
    @JoinColumn(name = "user_id")
    private Profile profile;

    @Getter
    private Phone phoneNumber;

    @Getter
    private String description;

    @Getter
    private String SubscriptionType;


    public Remodeler() {
    }

    public Remodeler(String description, Long phoneNumber, String subscriptionType) {
        this.description = description;
        this.SubscriptionType = subscriptionType;
        this.phoneNumber = new Phone(phoneNumber);
    }

    public Remodeler(String description, Object o) {
        super();
    }

    public Long getFormattedPhoneNumber() {
        return this.phoneNumber.getNumber();
    }

}
