package com.metasoft.restyle.platform.tracking.domain.services;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Requirements;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetAllRequirementsQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetRequirementsByIdQuery;
import java.util.List;
import java.util.Optional;
public interface RequirementsQueryService {
    List<Requirements> handle(GetAllRequirementsQuery query);
    Optional<Requirements> handle(GetRequirementsByIdQuery query);
}
