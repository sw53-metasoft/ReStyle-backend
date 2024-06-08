package com.metasoft.restyle.platform.tracking.domain.services;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.TechnicalVisit;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateTechnicalVisitCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.DeleteTechnicalVisitCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.UpdateTechnicalVisitCommand;
import java.util.Optional;

public interface TechnicalVisitCommandService {
    Long handle(CreateTechnicalVisitCommand command);
    Optional<TechnicalVisit> handle(DeleteTechnicalVisitCommand command);
}
