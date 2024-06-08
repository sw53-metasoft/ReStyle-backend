package com.metasoft.restyle.platform.tracking.interfaces.rest.transform;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateTechnicalVisitCommand;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.CreateTechnicalVisitResource;

public class CreateTechnicalVisitCommandFromResourceAssembler {
    public static CreateTechnicalVisitCommand toCommandResource (CreateTechnicalVisitResource resource){
        return new CreateTechnicalVisitCommand(
                resource.price(),
                resource.date(),
                resource.additionalDetails()
        ) ;
    }
}
