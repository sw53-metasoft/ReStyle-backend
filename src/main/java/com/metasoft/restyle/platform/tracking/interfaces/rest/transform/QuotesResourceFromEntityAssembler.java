package com.metasoft.restyle.platform.tracking.interfaces.rest.transform;

import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Quotes;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.QuotesResource;
public class QuotesResourceFromEntityAssembler {
    public static QuotesResource toResourceFromEntity(Quotes entity) {
        return new QuotesResource(
                entity.getId(),
                entity.getDescription01(),
                entity.getPrice01(),
                entity.getDetails01(),
                entity.getDescription02(),
                entity.getPrice02(),
                entity.getDetails02(),
                entity.getDescription03(),
                entity.getPrice03(),
                entity.getDetails03()
        );
    }
}
