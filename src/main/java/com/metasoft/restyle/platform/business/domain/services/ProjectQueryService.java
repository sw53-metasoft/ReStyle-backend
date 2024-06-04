package com.metasoft.restyle.platform.business.domain.services;

import com.metasoft.restyle.platform.business.domain.model.aggregates.Project;
import com.metasoft.restyle.platform.business.domain.model.queries.GetAllProjectsByBusinessIdQuery;
import com.metasoft.restyle.platform.business.domain.model.queries.GetProjectByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProjectQueryService {

    List<Project> handle(GetAllProjectsByBusinessIdQuery query);

    Optional<Project> handle(GetProjectByIdQuery query);
}
