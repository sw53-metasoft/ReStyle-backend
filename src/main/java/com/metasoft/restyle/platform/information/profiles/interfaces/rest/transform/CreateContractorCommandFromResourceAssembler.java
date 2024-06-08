package com.metasoft.restyle.platform.information.profiles.interfaces.rest.transform;


import com.metasoft.restyle.platform.information.profiles.domain.model.commands.CreateContractorCommand;
import com.metasoft.restyle.platform.information.profiles.interfaces.rest.resources.CreateContractorResource;

public class CreateContractorCommandFromResourceAssembler {

        public static CreateContractorCommand toCommandFromResource(CreateContractorResource resource) {
            return new CreateContractorCommand(
                    resource.description(),
                    resource.phoneNumber()
            );
        }
}


/*
 public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(
                resource.email(),
                resource.password(),
                resource.typeUser(),
                resource.firstName(),
                resource.paternalSurname(),
                resource.maternalSurname()
        );
    }
 */