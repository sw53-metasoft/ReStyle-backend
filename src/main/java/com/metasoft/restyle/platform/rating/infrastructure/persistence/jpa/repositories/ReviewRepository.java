package com.metasoft.restyle.platform.rating.infrastructure.persistence.jpa.repositories;

import com.metasoft.restyle.platform.rating.domain.model.aggregates.Review;
import com.metasoft.restyle.platform.rating.domain.model.valueobjects.ContractorId;
import com.metasoft.restyle.platform.rating.domain.model.valueobjects.ProjectId;
import com.metasoft.restyle.platform.rating.domain.model.valueobjects.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByContractorIdAndProjectId(ContractorId contractorId, ProjectId projectId);
    Boolean existsByRating(Rating rating);
}
