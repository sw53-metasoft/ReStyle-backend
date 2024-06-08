package com.metasoft.restyle.platform.tracking.aplication.internal.queryservices;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Requirements;

import com.metasoft.restyle.platform.tracking.domain.model.queries.GetAllRequirementsQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetRequirementsByIdQuery;

import com.metasoft.restyle.platform.tracking.domain.services.RequirementsQueryService;
import com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories.RequirementsRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service

public class RequirementQueryServiceImpl implements RequirementsQueryService{

    private final RequirementsRepository requirementsRepository;

    public RequirementQueryServiceImpl(RequirementsRepository requirementsRepository) {
        this.requirementsRepository = requirementsRepository;
    }

    @Override
    public List<Requirements> handle(GetAllRequirementsQuery query) {
        return requirementsRepository.findAll();
    }

    @Override
    public Optional<Requirements> handle(GetRequirementsByIdQuery query) {
        return requirementsRepository.findById(query.requirementId());
    }
}
