package com.metasoft.restyle.platform.business.application.internal.commandservices;

import com.metasoft.restyle.platform.business.domain.model.aggregates.Project;
import com.metasoft.restyle.platform.business.domain.model.commands.CreateProjectCommand;
import com.metasoft.restyle.platform.business.domain.services.ProjectCommandService;
import com.metasoft.restyle.platform.business.infrastructure.persistance.jpa.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectCommandServiceImpl implements ProjectCommandService {

    private final ProjectRepository projectRepository;

    public ProjectCommandServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> handle(CreateProjectCommand command){
        if(projectRepository.existsByName(command.name())){
            throw new IllegalArgumentException("Project with same name already exists");
        }
        var project = new Project(command);
        var createdProject = projectRepository.save(project);
        return Optional.of(createdProject);
    }
}
