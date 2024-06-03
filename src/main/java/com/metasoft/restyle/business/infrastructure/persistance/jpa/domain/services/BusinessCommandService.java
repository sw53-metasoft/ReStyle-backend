package com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.services;

import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.model.aggregates.Business;
import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.model.commands.CreateBusinessCommand;

import java.util.Optional;

public interface BusinessCommandService {

    Optional<Business> handle(CreateBusinessCommand command);
}
