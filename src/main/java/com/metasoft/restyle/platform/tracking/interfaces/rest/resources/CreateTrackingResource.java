package com.metasoft.restyle.platform.tracking.interfaces.rest.resources;

import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Quotes;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Requirements;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.TechnicalVisit;
import com.metasoft.restyle.platform.tracking.domain.model.valueobjects.ContractorId;
import com.metasoft.restyle.platform.tracking.domain.model.valueobjects.RemodelerId;
public record CreateTrackingResource(RemodelerId remodelerId,
                                     ContractorId contractorId,
                                     Requirements requirements,
                                     TechnicalVisit technicalVisit,
                                     Quotes quotes ,
                                     Boolean projectAproval){
}
