package com.metasoft.restyle.platform.tracking.interfaces.rest.transform;

import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateQuotesCommand;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.CreateQuotesResource;

public class CreateQuotesCommandFromResourceAssembler {
    public static CreateQuotesCommand toCommandResource(CreateQuotesResource resource) {
        return new CreateQuotesCommand(
                resource.description01(),
                resource.price01(),
                resource.details01(),
                resource.description02(),
                resource.price02(),
                resource.details02(),
                resource.description03(),
                resource.price03(),
                resource.details03()
        );
    }
}
