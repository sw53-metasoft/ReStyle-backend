package com.metasoft.restyle.platform.tracking.domain.model.queries;
import com.metasoft.restyle.platform.tracking.domain.model.valueobjects.ContractorId;
import com.metasoft.restyle.platform.tracking.domain.model.valueobjects.RemodelerId;


public record GetTrackingByContractorIdAndRemodelerIdQuery(ContractorId contractorId, RemodelerId remodelerId) {
}
