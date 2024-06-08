package com.metasoft.restyle.platform.tracking.interfaces.rest.resources;

public record TrackingResource (
        Long id,
        Integer remodelerId,
        Integer contractorId,
        Long requirementsId,
        Long technicalVisitId,
        Long quotesId,
        Boolean projectAproval) {
}
