package com.metasoft.restyle.platform.business.interfaces.rest.resources;

import java.util.Date;

public record ProjectResource(
        Long id,
        String name,
        String description,
        Integer businessId,
        Integer contractorId,
        Date startDate,
        Date finishDate,
        String Image
) {
}
