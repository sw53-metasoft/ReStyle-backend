package com.metasoft.restyle.business.application.internal.queryservices;

import com.metasoft.restyle.business.infrastructure.persistance.jpa.BusinessRepository;
import com.metasoft.restyle.business.domain.model.aggregates.Business;
import com.metasoft.restyle.business.domain.model.queries.GetBusinessByIdQuery;
import com.metasoft.restyle.business.domain.services.BusinessQueryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusinessQueryServiceImpl implements BusinessQueryService {

    private final BusinessRepository businessRepository;

    public BusinessQueryServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public Optional<Business> handle(GetBusinessByIdQuery query) {
        return businessRepository.findById(query.id());
    }
}
