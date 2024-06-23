package com.metasoft.restyle.platform.rating.interfaces.rest.transform;

import com.metasoft.restyle.platform.rating.domain.model.commands.CreateReviewCommand;
import com.metasoft.restyle.platform.rating.interfaces.rest.resources.CreateReviewResource;

public class CreateReviewCommandFromResourceAssembler {
    public static CreateReviewCommand toCommandResource(CreateReviewResource resource) {
        return new CreateReviewCommand(
            resource.contractorId(),
            resource.projectId(),
            resource.duration(),
            resource.rating(),
            resource.comment(),
            resource.image()
        );
    }
}
