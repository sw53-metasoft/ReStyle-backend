package com.metasoft.restyle.platform.rating.domain.model.commands;

public record CreateReviewCommand(Integer contractorId, Integer projectId, String duration, Integer rating, String comment, String image) {

}
