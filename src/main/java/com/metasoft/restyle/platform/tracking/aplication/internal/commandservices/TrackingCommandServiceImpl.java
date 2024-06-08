package com.metasoft.restyle.platform.tracking.aplication.internal.commandservices;

import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Tracking;
import com.metasoft.restyle.platform.tracking.domain.model.commands.DeleteTrackingCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateTrackingCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.UpdateTrackingCommand;

import com.metasoft.restyle.platform.tracking.domain.services.TrackingCommandService;
import com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories.TrackingRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class TrackingCommandServiceImpl implements TrackingCommandService {

    private final TrackingRepository trackingRepository;
    public TrackingCommandServiceImpl(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }

    @Override
    public Long handle(CreateTrackingCommand command){
        var tracking = new Tracking(
                command.contractorId(),
                command.remodelerId(),
                command.requirements(),
                command.technicalVisit(),
                command.quotes(),
                command.projectAproval()
        );
        trackingRepository.save(tracking);
        return tracking.getId();

    }

    @Override
    public Long createTracking(CreateTrackingCommand command) {
        var tracking = new Tracking(
                command.contractorId(),
                command.remodelerId(),
                command.requirements(),
                command.technicalVisit(),
                command.quotes(),
                command.projectAproval()
        );
        trackingRepository.save(tracking);
        return tracking.getId();
    }

    @Override
    public Optional<Tracking> handle(UpdateTrackingCommand command){
        var tracking=trackingRepository.findTrackingId(command.id())
                .orElseThrow(()-> new IllegalArgumentException("Not found"));
        tracking.updateProjectAproval(command.projectAproval());
        trackingRepository.save(tracking);
        return trackingRepository.findTrackingId(command.id());
    }


    @Override
    public Optional<Tracking> handle(DeleteTrackingCommand command) {
        var tracking=trackingRepository.findTrackingId(command.trackingId())
                .orElseThrow(()-> new IllegalArgumentException("Not found"));
        trackingRepository.delete(tracking);
        return Optional.of(tracking);
    }
}
