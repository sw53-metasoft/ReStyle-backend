package com.metasoft.restyle.platform.tracking.interfaces.rest.transform;

import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Quotes;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Requirements;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.TechnicalVisit;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Tracking;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.TrackingResource;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.QuotesResource;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.RequirementsResource;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.TechnicalVisitResource;


public class TrackingResourceFromEntityAssembler {

    public static TrackingResource toResourceFromEntity(Tracking tracking){
return new TrackingResource(
        tracking.getId(),
        tracking.getRemodelerId(),
        tracking.getContractorId(),
        tracking.getRequirements().getId(),
        tracking.getTechnicalVisit().getId(),
        tracking.getQuotes().getId(),
        tracking.getProjectAproval()

);
    }

   /*
   return new PaymentResource(payment.getId(), payment.getDescription(), payment.getAmount(), payment.getStatus(), payment.getUser().getId(), payment.getExpense().getId());

   private final TechnicalVisitResourceFromEntityAssembler technicalVisitAssembler;
    private final RequirementsResourceFromEntityAssembler requirementsAssembler;
    private final QuotesResourceFromEntityAssembler quotesAssembler;

    public TrackingResourceFromEntityAssembler(
            TechnicalVisitResourceFromEntityAssembler technicalVisitAssembler,
            RequirementsResourceFromEntityAssembler requirementsAssembler,
            QuotesResourceFromEntityAssembler quotesAssembler) {
        this.technicalVisitAssembler = technicalVisitAssembler;
        this.requirementsAssembler = requirementsAssembler;
        this.quotesAssembler = quotesAssembler;
    }

    public static TrackingResource toResourceFromEntity(Tracking entity) {
        TechnicalVisit technicalVisit = entity.getTechnicalVisit();
        TechnicalVisitResource technicalVisitResource = null;
        if (technicalVisit != null) {
            technicalVisitResource = technicalVisitAssembler.toResourceFromEntity(technicalVisit);
        }

        Requirements requirements = entity.getRequirements();
        RequirementsResource requirementsResource = null;
        if (requirements != null) {
            requirementsResource = requirementsAssembler.toResourceFromEntity(requirements);
        }

        Quotes quotes = entity.getQuotes();
        QuotesResource quotesResource = null;
        if (quotes != null) {
            quotesResource = quotesAssembler.toResourceFromEntity(quotes);
        }

        return new TrackingResource(
                entity.getId(),
                entity.getRemodelerId(),
                entity.getContractorId(),
                requirements,
                technicalVisit,
                quotes,
                entity.getProjectAproval()
        );
    }*/
}