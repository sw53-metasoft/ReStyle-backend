package com.metasoft.restyle.platform.remodeling.domain.model.aggregates;

import com.metasoft.restyle.platform.remodeling.domain.model.commands.CreateProjectCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
public class Project extends AbstractAggregateRoot<Project> {



    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 500)
    private String image;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private Integer businessId;

    @Column(nullable = false)
    private Integer contractorId;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date finishDate;
    @Id
    private Long id;

    protected Project(){}

    public Project(CreateProjectCommand command){
        this.name = command.name();
        this.image = command.image();
        this.description = command.description();
        this.businessId = command.businessId();
        this.contractorId = command.contractorId();
        this.startDate = command.startDate();
        this.finishDate = command.finishDate();
    }


}
