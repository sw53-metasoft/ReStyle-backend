package com.metasoft.restyle.platform.business.interfaces.rest.transform;

import com.metasoft.restyle.platform.business.domain.model.aggregates.Project;
import com.metasoft.restyle.platform.business.interfaces.rest.resources.ProjectResource;

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
