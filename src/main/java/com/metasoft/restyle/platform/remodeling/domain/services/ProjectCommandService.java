package com.metasoft.restyle.platform.remodeling.domain.services;

import com.metasoft.restyle.platform.remodeling.domain.model.aggregates.Project;
import com.metasoft.restyle.platform.remodeling.domain.model.commands.CreateProjectCommand;

import java.util.Optional;

public interface ProjectCommandService {

    Optional<Project> handle(CreateProjectCommand command);
}
