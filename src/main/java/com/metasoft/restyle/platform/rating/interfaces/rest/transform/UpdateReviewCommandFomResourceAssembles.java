package com.metasoft.restyle.platform.rating.interfaces.rest.transform;

import com.metasoft.restyle.platform.rating.domain.model.commands.UpdateReviewCommand;
import com.metasoft.restyle.platform.rating.interfaces.rest.resources.UpdateReviewResource;

public class UpdateReviewCommandFomResourceAssembles {
    public static UpdateReviewCommand toCommandFromResource(Long reviewId, UpdateReviewResource resource){
        return new UpdateReviewCommand(
            reviewId,
            resource.duration(),
            resource.comment(),
            resource.image());
    }
}
