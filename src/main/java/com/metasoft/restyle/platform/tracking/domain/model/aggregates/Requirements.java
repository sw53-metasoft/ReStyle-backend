package com.metasoft.restyle.platform.tracking.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity

public class Requirements extends AbstractAggregateRoot<Requirements> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTitle;
    private String jobDescription;
    private String jobRequirement01;
    private String jobRequirement02;
    private String jobRequirement03;
    private String jobRequirement04;
    private String jobRequirement05;
    private String jobRequirement06;
    private String jobRequirement07;
    private String jobRequirement08;
    private String jobRequirement09;
    private String jobRequirement10;
    private String jobRequirement11;
    private String jobRequirement12;
    private String jobRequirement13;
    private String jobRequirement14;
    private String jobRequirement15;

    public Requirements(
            String jobTitle,
            String jobDescription,
            String jobRequirement01,
            String jobRequirement02,
            String jobRequirement03,
            String jobRequirement04,
            String jobRequirement05,
            String jobRequirement06,
            String jobRequirement07,
            String jobRequirement08,
            String jobRequirement09,
            String jobRequirement10,
            String jobRequirement11,
            String jobRequirement12,
            String jobRequirement13,
            String jobRequirement14,
            String jobRequirement15
            ){
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobRequirement01 = jobRequirement01;
        this.jobRequirement02 = jobRequirement02;
        this.jobRequirement03 = jobRequirement03;
        this.jobRequirement04 = jobRequirement04;
        this.jobRequirement05 = jobRequirement05;
        this.jobRequirement06 = jobRequirement06;
        this.jobRequirement07 = jobRequirement07;
        this.jobRequirement08 = jobRequirement08;
        this.jobRequirement09 = jobRequirement09;
        this.jobRequirement10 = jobRequirement10;
        this.jobRequirement11 = jobRequirement11;
        this.jobRequirement12 = jobRequirement12;
        this.jobRequirement13 = jobRequirement13;
        this.jobRequirement14 = jobRequirement14;
        this.jobRequirement15 = jobRequirement15;
    }
    public Requirements(){}
    void updateJobTitle(String jobTitle) {this.jobTitle = jobTitle;}
    void updateJobDescription(String jobDescription) {this.jobDescription = jobDescription;}
    void updateJobRequirement01(String jobRequirement01){this.jobRequirement01 = jobRequirement01;}
    void updateJobRequirement02(String jobRequirement02){this.jobRequirement02 = jobRequirement02;}
    void updateJobRequirement03(String jobRequirement03){this.jobRequirement03 = jobRequirement03;}
    void updateJobRequirement04(String jobRequirement04){this.jobRequirement04 = jobRequirement04;}
    void updateJobRequirement05(String jobRequirement05){this.jobRequirement05 = jobRequirement05;}
    void updateJobRequirement06(String jobRequirement06){this.jobRequirement06 = jobRequirement06;}
    void updateJobRequirement07(String jobRequirement07){this.jobRequirement07 = jobRequirement07;}
    void updateJobRequirement08(String jobRequirement08){this.jobRequirement08 = jobRequirement08;}
    void updateJobRequirement09(String jobRequirement09){this.jobRequirement09 = jobRequirement09;}
    void updateJobRequirement10(String jobRequirement10){this.jobRequirement10 = jobRequirement10;}
    void updateJobRequirement11(String jobRequirement11){this.jobRequirement11 = jobRequirement11;}
    void updateJobRequirement12(String jobRequirement12){this.jobRequirement12 = jobRequirement12;}
    void updateJobRequirement13(String jobRequirement13){this.jobRequirement13 = jobRequirement13;}
    void updateJobRequirement14(String jobRequirement14){this.jobRequirement14 = jobRequirement14;}
    void updateJobRequirement15(String jobRequirement15){this.jobRequirement15 = jobRequirement15;}

}
