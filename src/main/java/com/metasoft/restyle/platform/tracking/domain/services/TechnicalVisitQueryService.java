package com.metasoft.restyle.platform.tracking.domain.services;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.TechnicalVisit;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetAllTechnicalVisitsQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetTechnicalVisitByIdQuery;
import java.util.List;
import java.util.Optional;

public interface TechnicalVisitQueryService {
    List<TechnicalVisit> handle(GetAllTechnicalVisitsQuery query);
    Optional<TechnicalVisit> handle(GetTechnicalVisitByIdQuery query);
}
