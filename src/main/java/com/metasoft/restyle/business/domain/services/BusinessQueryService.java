package com.metasoft.restyle.business.domain.services;

import com.metasoft.restyle.business.domain.model.aggregates.Business;
import com.metasoft.restyle.business.domain.model.queries.GetBusinessByIdQuery;

import java.util.Optional;

public interface BusinessQueryService {

    Optional<Business> handle(GetBusinessByIdQuery query);
}
