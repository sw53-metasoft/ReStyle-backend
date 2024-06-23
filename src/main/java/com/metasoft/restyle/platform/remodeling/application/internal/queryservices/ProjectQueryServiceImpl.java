package com.metasoft.restyle.platform.remodeling.application.internal.queryservices;

import com.metasoft.restyle.platform.remodeling.domain.model.aggregates.Project;
import com.metasoft.restyle.platform.remodeling.domain.model.queries.GetAllProjectsByBusinessIdQuery;
import com.metasoft.restyle.platform.remodeling.domain.model.queries.GetProjectByIdQuery;
import com.metasoft.restyle.platform.remodeling.domain.services.ProjectQueryService;
import com.metasoft.restyle.platform.remodeling.infrastructure.persistence.jpa.repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Optional;

@Service("com.metasoft.restyle.platform.remodeling.application.internal.queryservices.ProjectQueryServiceImpl")
@Primary
public class ProjectQueryServiceImpl implements ProjectQueryService {

    private final ProjectRepository projectRepository;

    public ProjectQueryServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> handle(GetAllProjectsByBusinessIdQuery query){
        return projectRepository.findAllByBusinessId(query.businessId());
    }

    @Override
    public Optional<Project> handle(GetProjectByIdQuery query){
        return projectRepository.findById(query.id());
    }

}
