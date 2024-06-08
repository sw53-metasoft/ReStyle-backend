package com.metasoft.restyle.platform.tracking.interfaces.rest.transform;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateRequirementsCommand;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.CreateRequirementsResource;

public class CreateRequirementsCommandFromResourceAssembler {
    public static CreateRequirementsCommand toCommandResource(CreateRequirementsResource resource){
        return new CreateRequirementsCommand(
                resource.jobTitle(),
                resource.jobDescription(),
                resource.jobRequirement01(),
                resource.jobRequirement02(),
                resource.jobRequirement03(),
                resource.jobRequirement04(),
                resource.jobRequirement05(),
                resource.jobRequirement06(),
                resource.jobRequirement07(),
                resource.jobRequirement08(),
                resource.jobRequirement09(),
                resource.jobRequirement10(),
                resource.jobRequirement11(),
                resource.jobRequirement12(),
                resource.jobRequirement13(),
                resource.jobRequirement14(),
                resource.jobRequirement15()
        );
    }
}
