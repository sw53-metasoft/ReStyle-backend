package com.metasoft.restyle.platform.remodeling.interfaces.rest.transform;

import com.metasoft.restyle.platform.remodeling.domain.model.aggregates.Project;
import com.metasoft.restyle.platform.remodeling.interfaces.rest.resources.ProjectResource;

public class ProjectResourceFromEntityAssembler {

    public static ProjectResource toResourceFromEntity(Project entity){
        return new ProjectResource(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getBusinessId(),
                entity.getContractorId(),
                entity.getStartDate(),
                entity.getFinishDate(),
                entity.getImage()
        );
    }
}
