package com.metasoft.restyle.platform.tracking.aplication.internal.queryservices;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Tracking;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetAllTrackingQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetTrackingByContractorIdQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetTrackingByRemodelerIdQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetTrackingByContractorIdAndRemodelerIdQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetTrackingByIdQuery;
import com.metasoft.restyle.platform.tracking.domain.services.TrackingQueryService;
import com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories.TrackingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TrackingQueryServiceImpl implements TrackingQueryService {
    private final TrackingRepository trackingRepository;
    public TrackingQueryServiceImpl(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }

    @Override
    public List<Tracking> handle(GetAllTrackingQuery query) {
        return trackingRepository.findAll();
    }

    @Override
    public Optional<Tracking> handle(GetTrackingByIdQuery query) {
        return Optional.empty();
    }

    @Override
    public Optional<Tracking> handle(GetTrackingByContractorIdQuery query) {
        return trackingRepository.findByContractorId(query.contractorId());
    }

    @Override
    public Optional<Tracking> handle(GetTrackingByRemodelerIdQuery query) {
        return trackingRepository.findByRemodelerId(query.remodelerId());
    }

    @Override
    public Optional<Tracking> handle(GetTrackingByContractorIdAndRemodelerIdQuery query) {
        return trackingRepository.findByRemodelerIdAndContractorId(query.remodelerId(),query.contractorId());
    }
}
