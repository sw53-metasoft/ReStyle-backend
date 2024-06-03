package com.metasoft.restyle.business.infrastructure.persistance.jpa;

import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.model.aggregates.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusinessRepository extends JpaRepository<Business, Long> {

    List<Business> findAllByBusinessName(String businessName);

    boolean existsByBusinessName(String businessName);

    Optional<Business> findByBusinessName(String businessName);
}
