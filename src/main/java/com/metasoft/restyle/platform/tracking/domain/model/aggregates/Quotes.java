package com.metasoft.restyle.platform.tracking.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity

public class Quotes extends AbstractAggregateRoot<Quotes> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description01;
    private Float price01;
    private String details01;
    private String description02;
    private Float price02;
    private String details02;
    private String description03;
    private Float price03;
    private String details03;

    public Quotes() {}
    public Quotes(
            String description01,
            Float price01,
            String details01,
            String description02,
            Float price02,
            String details02,
            String description03,
            Float price03,
            String details03
            ){
        this.description01 = description01;
        this.price01 = price01;
        this.details01 = details01;
        this.description02 = description02;
        this.price02 = price02;
        this.details02 = details02;
        this.description03 = description03;
        this.price03 = price03;
        this.details03 = details03;
    }

    void updateDescription01(String description01) { this.description01 = description01; }
    void updatePrice01(Float price01) { this.price01 = price01; }
    void updateDetails01(String details01) { this.details01 = details01; }
    void updatePrice02(Float price02) { this.price02 = price02; }
    void updateDetails02(String details02) { this.details02 = details02; }
    void updateDescription03(String description03) { this.description03 = description03; }
    void updatePrice03(Float price03) { this.price03 = price03; }
    void updateDetails03(String details03) { this.details03 = details03; }

}
