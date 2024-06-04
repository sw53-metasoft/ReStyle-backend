package com.metasoft.restyle.platform.business.domain.services;

import com.metasoft.restyle.platform.business.domain.model.aggregates.Project;
import com.metasoft.restyle.platform.business.domain.model.commands.CreateProjectCommand;

import java.util.Optional;

public interface ProjectCommandService {

    Optional<Project> handle(CreateProjectCommand command);
}
