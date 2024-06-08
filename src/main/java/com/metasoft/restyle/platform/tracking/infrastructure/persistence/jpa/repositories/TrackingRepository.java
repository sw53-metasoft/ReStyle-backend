package com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Tracking;
import com.metasoft.restyle.platform.tracking.domain.model.valueobjects.ContractorId;
import com.metasoft.restyle.platform.tracking.domain.model.valueobjects.RemodelerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    Optional<Tracking> findTrackingId(Long id);
    Optional<Tracking> findByContractorId(ContractorId contractorId);
    Optional<Tracking> findByRemodelerId(RemodelerId remodelerId);
    Optional<Tracking>  findByRemodelerIdAndContractorId(RemodelerId remodelerId, ContractorId contractorId);
}
