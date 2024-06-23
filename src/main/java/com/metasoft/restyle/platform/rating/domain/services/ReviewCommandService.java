package com.metasoft.restyle.platform.rating.domain.services;

import com.metasoft.restyle.platform.rating.domain.model.aggregates.Review;
import com.metasoft.restyle.platform.rating.domain.model.commands.CreateReviewCommand;
import com.metasoft.restyle.platform.rating.domain.model.commands.DeleteReviewCommand;
import com.metasoft.restyle.platform.rating.domain.model.commands.UpdateReviewCommand;

import java.util.Optional;

public interface ReviewCommandService{
    Long handle(CreateReviewCommand command);
    Optional<Review> handle(UpdateReviewCommand command);
    Optional<Review> handle(DeleteReviewCommand command);
}
