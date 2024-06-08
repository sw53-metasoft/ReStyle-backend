package com.metasoft.restyle.platform.tracking.aplication.internal.queryservices;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.TechnicalVisit;

import com.metasoft.restyle.platform.tracking.domain.model.queries.GetAllTechnicalVisitsQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetTechnicalVisitByIdQuery;

import com.metasoft.restyle.platform.tracking.domain.services.TechnicalVisitCommandService;
import com.metasoft.restyle.platform.tracking.domain.services.TechnicalVisitQueryService;
import com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories.TechnicalVisitRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class TechnicalVisitQueryServiceImpl implements TechnicalVisitQueryService {

    private TechnicalVisitRepository technicalVisitRepository;
    public TechnicalVisitQueryServiceImpl(TechnicalVisitRepository technicalVisitRepository) {
        this.technicalVisitRepository = technicalVisitRepository;
    }

    @Override
    public List<TechnicalVisit> handle(GetAllTechnicalVisitsQuery query) {
            return technicalVisitRepository.findAll();
    }

    @Override
    public Optional<TechnicalVisit> handle(GetTechnicalVisitByIdQuery query) {
        return technicalVisitRepository.findById(query.technicalVisitId());
    }
}
