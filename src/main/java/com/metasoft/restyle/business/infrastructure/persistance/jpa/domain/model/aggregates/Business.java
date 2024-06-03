package com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.model.aggregates;

import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.model.commands.CreateBusinessCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Business  extends AbstractAggregateRoot<Business> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String name;

    @Getter
    private String image;

    @Getter
    @Column(nullable = false)
    private String expertise;

    @Column(nullable = false)
    @Getter
    private String address;

    @Column(nullable = false)
    @Getter
    private String city;

    @Column(nullable = false)
    @Getter
    private String description;

    @Column(nullable = false)
    @Getter
    private Integer remodelerId;

    protected Business(){}

    public Business(CreateBusinessCommand command){
        this.name = command.name();
        this.image = command.image();
        this.expertise = command.expertise();
        this.address = command.address();
        this.city = command.city();
        this.description = command.description();
        this.remodelerId = command.remodelerId();
    }

}
