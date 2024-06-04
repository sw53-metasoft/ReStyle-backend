package com.metasoft.restyle.platform.business.application.internal.queryservices;

import com.metasoft.restyle.platform.business.domain.model.aggregates.Project;
import com.metasoft.restyle.platform.business.domain.model.queries.GetAllProjectsByBusinessIdQuery;
import com.metasoft.restyle.platform.business.domain.model.queries.GetProjectByIdQuery;
import com.metasoft.restyle.platform.business.domain.services.ProjectQueryService;
import com.metasoft.restyle.platform.business.infrastructure.persistance.jpa.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
