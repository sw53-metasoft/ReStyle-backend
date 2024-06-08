package com.metasoft.restyle.platform.tracking.domain.services;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Tracking;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateTrackingCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.DeleteTrackingCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.UpdateTrackingCommand;
import java.util.Optional;

public interface TrackingCommandService {
    Long handle(CreateTrackingCommand command);

    Long createTracking(CreateTrackingCommand command);
    Optional<Tracking> handle(UpdateTrackingCommand command);
    Optional<Tracking> handle(DeleteTrackingCommand command);
}
