package com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Quotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface QuotesRepository extends JpaRepository<Quotes, Long> {
    Optional<Quotes> findById(Long id);
}
