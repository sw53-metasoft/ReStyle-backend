package com.metasoft.restyle.platform.tracking.domain.services;

import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Requirements;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateRequirementsCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.DeleteRequirementsCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.UpdateRequirementsCommand;
import java.util.Optional;
public interface RequirementsCommandService {
    Long handle(CreateRequirementsCommand command);
    Optional<Requirements> handle(DeleteRequirementsCommand command);
}
