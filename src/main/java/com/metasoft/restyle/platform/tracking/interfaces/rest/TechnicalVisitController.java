package com.metasoft.restyle.platform.tracking.interfaces.rest;

import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateTechnicalVisitCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.DeleteTechnicalVisitCommand;

import com.metasoft.restyle.platform.tracking.domain.model.queries.GetTechnicalVisitByIdQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetAllTechnicalVisitsQuery;

import com.metasoft.restyle.platform.tracking.domain.services.TechnicalVisitQueryService;
import com.metasoft.restyle.platform.tracking.domain.services.TechnicalVisitCommandService;

import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.TechnicalVisitResource;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.CreateTechnicalVisitResource;

import com.metasoft.restyle.platform.tracking.interfaces.rest.transform.CreateTechnicalVisitCommandFromResourceAssembler;
import com.metasoft.restyle.platform.tracking.interfaces.rest.transform.TechnicalVisitResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/technicalVisits", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="technicalVisits")
public class TechnicalVisitController {
    private final TechnicalVisitQueryService technicalVisitQueryService;
    private final TechnicalVisitCommandService technicalVisitCommandService;

    public TechnicalVisitController(TechnicalVisitCommandService technicalVisitCommandService, TechnicalVisitQueryService technicalVisitQueryService) {
        this.technicalVisitCommandService = technicalVisitCommandService;
        this.technicalVisitQueryService = technicalVisitQueryService;
    }

    @PostMapping
    public  ResponseEntity<TechnicalVisitResource> createTechnicalVisit(@RequestBody CreateTechnicalVisitResource resource) {
        var createTechnicalVisitCommand = CreateTechnicalVisitCommandFromResourceAssembler.toCommandResource(resource);
        var technicalVisitId = technicalVisitCommandService.handle(createTechnicalVisitCommand);

        var getTechnicalVisitByIdQuery = new GetTechnicalVisitByIdQuery(technicalVisitId);
        var technicalVisit = technicalVisitQueryService.handle(getTechnicalVisitByIdQuery);

        if (technicalVisit.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var technicalVisitResource = TechnicalVisitResourceFromEntityAssembler.toResourceFromEntity(technicalVisit.get());
        return new ResponseEntity<>(technicalVisitResource, HttpStatus.CREATED);
    }

    // Get all technical visits
    @GetMapping
    public ResponseEntity<List<TechnicalVisitResource>> getAllTechnicalVisits() {
        var getAllTechnicalVisitsQuery = new GetAllTechnicalVisitsQuery();
        var technicalVisits = technicalVisitQueryService.handle(getAllTechnicalVisitsQuery);
        var technicalVisitResources = technicalVisits.stream().map(TechnicalVisitResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(technicalVisitResources);
    }

    // Delete technical visit by id
    @DeleteMapping("/{technicalVisitId}")
    public ResponseEntity<String> deleteTechnicalVisit(@PathVariable Long technicalVisitId) {
        try {
            var deleteTechnicalVisitCommand = new DeleteTechnicalVisitCommand(technicalVisitId);
            technicalVisitCommandService.handle(deleteTechnicalVisitCommand);
            return ResponseEntity.ok("Technical Visit deleted successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}

