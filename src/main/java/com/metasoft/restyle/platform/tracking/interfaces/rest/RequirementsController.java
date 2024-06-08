package com.metasoft.restyle.platform.tracking.interfaces.rest;

import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateRequirementsCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.DeleteRequirementsCommand;

import com.metasoft.restyle.platform.tracking.domain.model.queries.GetRequirementsByIdQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetAllRequirementsQuery;

import com.metasoft.restyle.platform.tracking.domain.services.RequirementsQueryService;
import com.metasoft.restyle.platform.tracking.domain.services.RequirementsCommandService;

import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.RequirementsResource;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.CreateRequirementsResource;

import com.metasoft.restyle.platform.tracking.interfaces.rest.transform.CreateRequirementsCommandFromResourceAssembler;
import com.metasoft.restyle.platform.tracking.interfaces.rest.transform.RequirementsResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/requirements", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="requirements")
public class RequirementsController {
    private final RequirementsQueryService requirementsQueryService;
    private final RequirementsCommandService requirementsCommandService;

    public RequirementsController(RequirementsCommandService requirementsCommandService, RequirementsQueryService requirementsQueryService) {
        this.requirementsCommandService = requirementsCommandService;
        this.requirementsQueryService = requirementsQueryService;
    }

    @PostMapping
    public ResponseEntity<RequirementsResource> createRequirements(@RequestBody CreateRequirementsResource resource) {
        var createRequirementsCommand = CreateRequirementsCommandFromResourceAssembler.toCommandResource(resource);
        var requirementsId = requirementsCommandService.handle(createRequirementsCommand);

        var getRequirementsByIdQuery = new GetRequirementsByIdQuery(requirementsId);
        var requirements = requirementsQueryService.handle(getRequirementsByIdQuery);

        if (requirements.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var requirementsResource = RequirementsResourceFromEntityAssembler.toResourceFromEntity(requirements.get());
        return new ResponseEntity<>(requirementsResource, HttpStatus.CREATED);
    }

    // Get all requirements
    @GetMapping
    public ResponseEntity<List<RequirementsResource>> getAllRequirements() {
        var getAllRequirementsQuery = new GetAllRequirementsQuery();
        var requirements = requirementsQueryService.handle(getAllRequirementsQuery);
        var requirementsResources = requirements.stream().map(RequirementsResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(requirementsResources);
    }

    // Delete requirements by id
    @DeleteMapping("/{requirementsId}")
    public ResponseEntity<String> deleteRequirements(@PathVariable Long requirementsId) {
        try {
            var deleteRequirementsCommand = new DeleteRequirementsCommand(requirementsId);
            requirementsCommandService.handle(deleteRequirementsCommand);
            return ResponseEntity.ok("Requirements deleted successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
