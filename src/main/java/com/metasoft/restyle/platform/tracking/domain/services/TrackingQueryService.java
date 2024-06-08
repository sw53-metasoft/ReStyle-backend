package com.metasoft.restyle.platform.tracking.domain.services;

import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Tracking;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetAllTrackingQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetTrackingByContractorIdQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetTrackingByIdQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetTrackingByRemodelerIdQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetTrackingByContractorIdAndRemodelerIdQuery;

import java.util.List;
import java.util.Optional;

public interface TrackingQueryService {
    List<Tracking> handle(GetAllTrackingQuery query);
    Optional<Tracking> handle(GetTrackingByIdQuery query);
    Optional<Tracking> handle(GetTrackingByContractorIdQuery query);
    Optional<Tracking> handle(GetTrackingByRemodelerIdQuery query);
    Optional<Tracking>  handle(GetTrackingByContractorIdAndRemodelerIdQuery query);
}
