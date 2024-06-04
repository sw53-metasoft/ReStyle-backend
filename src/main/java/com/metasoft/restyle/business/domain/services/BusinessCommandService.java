package com.metasoft.restyle.business.domain.services;

import com.metasoft.restyle.business.domain.model.aggregates.Business;
import com.metasoft.restyle.business.domain.model.commands.CreateBusinessCommand;

import java.util.Optional;

public interface BusinessCommandService {

    Optional<Business> handle(CreateBusinessCommand command);
}
