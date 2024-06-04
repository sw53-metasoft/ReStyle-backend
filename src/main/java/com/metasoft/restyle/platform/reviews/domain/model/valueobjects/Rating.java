package com.metasoft.restyle.platform.reviews.domain.model.valueobjects;

public record Rating(Integer stars) {
    //validate quantity between 1 and 5
    public Rating {
        if (stars < 1 || stars > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }
}
