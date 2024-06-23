package com.metasoft.restyle.platform.remodeling.infrastructure.persistence.jpa.repositories;

import com.metasoft.restyle.platform.remodeling.domain.model.aggregates.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByBusinessId(Long businessId);

    boolean existsByName(String name);

    Optional<Project> findById(Long id);
}
