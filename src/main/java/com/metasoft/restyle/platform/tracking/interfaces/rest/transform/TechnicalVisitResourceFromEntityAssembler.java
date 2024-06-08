package com.metasoft.restyle.platform.tracking.interfaces.rest.transform;

import com.metasoft.restyle.platform.tracking.domain.model.aggregates.TechnicalVisit;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.TechnicalVisitResource;
public class TechnicalVisitResourceFromEntityAssembler {
    public static TechnicalVisitResource toResourceFromEntity( TechnicalVisit entity) {
        return new TechnicalVisitResource(
                entity.getId(),
                entity.getPrice(),
                entity.getDate(),
                entity.getAdditionalDetails()
        );
    }
}
