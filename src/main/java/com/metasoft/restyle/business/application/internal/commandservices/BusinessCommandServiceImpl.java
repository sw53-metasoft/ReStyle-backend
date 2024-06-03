package com.metasoft.restyle.business.application.internal.commandservices;

import com.metasoft.restyle.business.infrastructure.persistance.jpa.BusinessRepository;
import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.model.aggregates.Business;
import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.model.commands.CreateBusinessCommand;
import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.services.BusinessCommandService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusinessCommandServiceImpl implements BusinessCommandService {

    private final BusinessRepository businessRepository;

    public BusinessCommandServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public Optional<Business> handle(CreateBusinessCommand command) {
        if (businessRepository.existsByBusinessName(command.name())) {
            throw new IllegalArgumentException("Business with same name already exists");
        }
        var business = new Business(command);
        var createdBusiness = businessRepository.save(business);
        return Optional.of(createdBusiness);
    }
}
