package com.metasoft.restyle.platform.tracking.domain.model.queries;
import com.metasoft.restyle.platform.tracking.domain.model.valueobjects.ContractorId;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateTrackingCommand;

public record GetTrackingByContractorIdQuery(ContractorId contractorId) {
}

