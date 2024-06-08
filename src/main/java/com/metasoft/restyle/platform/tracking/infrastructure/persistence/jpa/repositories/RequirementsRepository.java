package com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RequirementsRepository extends JpaRepository<Requirements, Long> {
    Optional<Requirements> findById(String id);
}
