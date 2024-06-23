package com.metasoft.restyle.platform.rating.interfaces.rest.transform;

import com.metasoft.restyle.platform.rating.domain.model.aggregates.Review;
import com.metasoft.restyle.platform.rating.interfaces.rest.resources.ReviewResource;

public class ReviewResourceFromEntityAssembler {
    public static ReviewResource toResourceFromEntity(Review entity){
        return new ReviewResource(
            entity.getId(),
            entity.getContractorId(),
            entity.getProjectId(),
            entity.getDuration(),
            entity.getRating(),
            entity.getComment(),
            entity.getImage());
    }
}
