package com.metasoft.restyle.platform.tracking.interfaces.rest.transform;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Requirements;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateTrackingCommand;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.CreateTrackingResource;
public class CreateTrackingCommandFromResourceAssembler {
    public static CreateTrackingCommand toCommandResource (CreateTrackingResource resource){
        return new CreateTrackingCommand(
                resource.remodelerId(),
                resource.contractorId(),
                resource.requirements(),
                resource.technicalVisit(),
                resource.quotes(),
                resource.projectAproval()
    );
}}
