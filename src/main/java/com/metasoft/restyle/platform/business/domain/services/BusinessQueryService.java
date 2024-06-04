package com.metasoft.restyle.platform.business.domain.services;

import com.metasoft.restyle.platform.business.domain.model.aggregates.Business;
import com.metasoft.restyle.platform.business.domain.model.queries.GetBusinessByIdQuery;

import java.util.Optional;

public interface BusinessQueryService {

    Optional<Business> handle(GetBusinessByIdQuery query);
}
