package com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.model.queries;

public record GetBusinessByIdQuery(Long id) {
    public GetBusinessByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }
}
