package com.metasoft.restyle.platform.tracking.aplication.internal.commandservices;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.TechnicalVisit;
import com.metasoft.restyle.platform.tracking.domain.services.TechnicalVisitCommandService;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateTechnicalVisitCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.DeleteTechnicalVisitCommand;
import com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories.TechnicalVisitRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class TechnicalVisitCommandServiceImpl implements TechnicalVisitCommandService {
   private final TechnicalVisitRepository technicalVisitRepository;
   public TechnicalVisitCommandServiceImpl(TechnicalVisitRepository technicalVisitRepository) {
       this.technicalVisitRepository = technicalVisitRepository;
   }

    @Override
    public Long handle(CreateTechnicalVisitCommand command) {
        var technicalVisit = new TechnicalVisit(
                command.price(),
                command.date(),
                command.additionalDetails()
        );
        technicalVisitRepository.save(technicalVisit);
        return technicalVisit.getId();
    }

    @Override
    public Optional<TechnicalVisit> handle(DeleteTechnicalVisitCommand command) {
        var technicalVisit = technicalVisitRepository.findByTechnicalVisitId(command.technicalVisitId())
                .orElseThrow(()-> new IllegalArgumentException("Not found"));
        technicalVisitRepository.delete(technicalVisit);
        return Optional.of(technicalVisit);
    }
}
