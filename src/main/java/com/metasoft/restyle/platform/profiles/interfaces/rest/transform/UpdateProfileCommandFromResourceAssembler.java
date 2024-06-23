package com.metasoft.restyle.platform.profiles.interfaces.rest.transform;

import com.metasoft.restyle.platform.profiles.domain.model.commands.UpdateProfileCommand;
import com.metasoft.restyle.platform.profiles.interfaces.rest.resources.UpdateProfileResource;

public class UpdateProfileCommandFromResourceAssembler {
    public static UpdateProfileCommand toCommandFromResource(Long profileId, UpdateProfileResource resource){
        return new UpdateProfileCommand(
            profileId,
            resource.email(),
            resource.phone(),
            resource.description(),
            resource.imageUrl());
    }
}
