package com.metasoft.restyle.platform.tracking.aplication.internal.commandservices;

import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Requirements;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateRequirementsCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.DeleteRequirementsCommand;

import com.metasoft.restyle.platform.tracking.domain.services.RequirementsCommandService;
import com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories.RequirementsRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class RequirementsCommandServiceImpl implements RequirementsCommandService {

    private final RequirementsRepository requirementsRepository;
    public RequirementsCommandServiceImpl(RequirementsRepository requirementsRepository) {
        this.requirementsRepository = requirementsRepository;
    }


    @Override
    public Long handle(CreateRequirementsCommand command) {
        var requirements=new Requirements(
                command.jobTitle(),
                command.jobDescription(),
                command.jobRequirement01(),
                command.jobRequirement02(),
                command.jobRequirement03(),
                command.jobRequirement04(),
                command.jobRequirement05(),
                command.jobRequirement06(),
                command.jobRequirement07(),
                command.jobRequirement08(),
                command.jobRequirement09(),
                command.jobRequirement10(),
                command.jobRequirement11(),
                command.jobRequirement12(),
                command.jobRequirement13(),
                command.jobRequirement14(),
                command.jobRequirement15()
        );
        requirementsRepository.save(requirements);
        return requirements.getId();
    }

    @Override
    public Optional<Requirements> handle(DeleteRequirementsCommand command) {
        var requirements=requirementsRepository.findById(command.requirementsId())
                .orElseThrow(() -> new IllegalArgumentException("Not found"));
        requirementsRepository.delete(requirements);
        return Optional.of(requirements);
    }
}
