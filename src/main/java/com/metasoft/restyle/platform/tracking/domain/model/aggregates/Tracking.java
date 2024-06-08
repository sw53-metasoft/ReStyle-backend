package com.metasoft.restyle.platform.tracking.domain.model.aggregates;
import com.metasoft.restyle.platform.tracking.domain.model.valueobjects.ContractorId;
import com.metasoft.restyle.platform.tracking.domain.model.valueobjects.RemodelerId;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity

public class Tracking extends AbstractAggregateRoot<Tracking> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    private ContractorId contractorId;
    @Embedded
    private RemodelerId remodelerId;

    private Boolean projectAproval;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quotes", referencedColumnName = "id")
    private Quotes quotes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requirementsId", referencedColumnName = "id")
    private Requirements requirements;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "technicalVisitId", referencedColumnName = "id")
    private TechnicalVisit technicalVisit;

    public Tracking(ContractorId contractorId, RemodelerId remodelerId, Requirements requirements, TechnicalVisit technicalVisit, Quotes quotes, Boolean projectAproval) {
        this.contractorId = contractorId;
        this.remodelerId = remodelerId;
        this.projectAproval = projectAproval;
        this.technicalVisit = technicalVisit;
        this.quotes = new Quotes();
        this.requirements = new Requirements();
    }

    public Tracking() {

    }

    public void updateProjectAproval( Boolean projectAproval ) {
        this.projectAproval = projectAproval;
    }

    public Integer getContractorId() {
        return contractorId.getContractorId();
    }
    public Integer getRemodelerId() {
        return remodelerId.getRemodelerId();
    }
    public void updateTechnicalVisit( TechnicalVisit technicalVisit ) { this.technicalVisit = technicalVisit; }
    public void updateRequirements( Requirements requirements ) { this.requirements = requirements;}
    public void updateQuotes( Quotes quotes ) { this.quotes = quotes; }

}
