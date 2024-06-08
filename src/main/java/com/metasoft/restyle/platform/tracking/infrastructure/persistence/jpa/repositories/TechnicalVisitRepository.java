package com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.TechnicalVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TechnicalVisitRepository extends JpaRepository<TechnicalVisit, Long> {
Optional<TechnicalVisit> findByTechnicalVisitId(Long id);
}
