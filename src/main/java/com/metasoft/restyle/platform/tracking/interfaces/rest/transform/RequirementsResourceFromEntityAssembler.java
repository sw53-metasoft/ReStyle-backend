package com.metasoft.restyle.platform.tracking.interfaces.rest.transform;
 import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Requirements;
 import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.RequirementsResource;
public class RequirementsResourceFromEntityAssembler {
    public static RequirementsResource toResourceFromEntity(Requirements entity) {
        return new RequirementsResource(
                entity.getId(),
                entity.getJobTitle(),
                entity.getJobDescription(),
                entity.getJobRequirement01(),
                entity.getJobRequirement02(),
                entity.getJobRequirement03(),
                entity.getJobRequirement04(),
                entity.getJobRequirement05(),
                entity.getJobRequirement06(),
                entity.getJobRequirement07(),
                entity.getJobRequirement08(),
                entity.getJobRequirement09(),
                entity.getJobRequirement10(),
                entity.getJobRequirement11(),
                entity.getJobRequirement12(),
                entity.getJobRequirement13(),
                entity.getJobRequirement14(),
                entity.getJobRequirement15()
        );
    }
}
