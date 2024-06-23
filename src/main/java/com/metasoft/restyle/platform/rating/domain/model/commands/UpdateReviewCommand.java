package com.metasoft.restyle.platform.rating.domain.model.commands;

public record UpdateReviewCommand(Long reviewId, String duration, String comment, String image) {
}
