package com.metasoft.restyle.platform.tracking.domain.model.commands;

public record UpdateTechnicalVisitCommand(Long tecnicalVisitId, Float price, String date, String additionalDetails) {
}
