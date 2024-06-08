package com.metasoft.restyle.platform.tracking.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity

public class TechnicalVisit extends AbstractAggregateRoot<TechnicalVisit>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float price;
    private String date;
    private String additionalDetails;

    public TechnicalVisit(Float price, String date, String additionalDetails) {
        this.price = price;
        this.date = date;
        this.additionalDetails = additionalDetails;
    }
    public TechnicalVisit() {}
    void updatePrice(Float price) { this.price = price;}
    void updateDate(String date) { this.date = date;}
    void updateAdditionalDetails(String additionalDetails) { this.additionalDetails = additionalDetails;}

}
