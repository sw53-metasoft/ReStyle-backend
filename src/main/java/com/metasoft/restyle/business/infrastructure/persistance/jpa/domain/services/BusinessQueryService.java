package com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.services;

import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.model.aggregates.Business;
import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.model.queries.GetBusinessByIdQuery;

import java.util.Optional;

public interface BusinessQueryService {

    Optional<Business> handle(GetBusinessByIdQuery query);
}
