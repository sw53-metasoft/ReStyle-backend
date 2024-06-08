package com.metasoft.restyle.platform.tracking.interfaces.rest;
import com.metasoft.restyle.platform.tracking.domain.model.commands.DeleteTrackingCommand;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetTrackingByIdQuery;
import com.metasoft.restyle.platform.tracking.domain.model.valueobjects.RemodelerId;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateTrackingCommand;

import com.metasoft.restyle.platform.tracking.domain.model.queries.GetAllTrackingQuery;

import com.metasoft.restyle.platform.tracking.domain.services.TrackingQueryService;
import com.metasoft.restyle.platform.tracking.domain.services.TrackingCommandService;

import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.TrackingResource;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.CreateTrackingResource;

import com.metasoft.restyle.platform.tracking.interfaces.rest.transform.CreateTrackingCommandFromResourceAssembler;

import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateQuotesCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.DeleteQuotesCommand;

import com.metasoft.restyle.platform.tracking.domain.model.queries.GetQuotesByIdQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetAllQuotesQuery;

import com.metasoft.restyle.platform.tracking.domain.services.QuotesQueryService;
import com.metasoft.restyle.platform.tracking.domain.services.QuotesCommandService;

import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.QuotesResource;
import com.metasoft.restyle.platform.tracking.interfaces.rest.resources.CreateQuotesResource;

import com.metasoft.restyle.platform.tracking.interfaces.rest.transform.CreateQuotesCommandFromResourceAssembler;
import com.metasoft.restyle.platform.tracking.interfaces.rest.transform.QuotesResourceFromEntityAssembler;

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

import com.metasoft.restyle.platform.tracking.interfaces.rest.transform.TrackingResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tracking", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "tracking")

public class TrackingController {
    private final TrackingQueryService trackingQueryService;
    private final TrackingCommandService trackingCommandService;
    public TrackingController(TrackingQueryService trackingQueryService, TrackingCommandService trackingCommandService) {
        this.trackingQueryService = trackingQueryService;
        this.trackingCommandService = trackingCommandService;
    }
    @PostMapping
    public ResponseEntity<TrackingResource> createTracking(@RequestBody CreateTrackingResource resource) {
        var createTrackingCommand = CreateTrackingCommandFromResourceAssembler.toCommandResource(resource);
        var trackingId = trackingCommandService.handle(createTrackingCommand);
        if (trackingId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getTrackingByIdQuery =new GetTrackingByIdQuery(trackingId);
        var tracking =trackingQueryService.handle(getTrackingByIdQuery);
        if (tracking.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var trackingResource = TrackingResourceFromEntityAssembler.toResourceFromEntity(tracking.get());
        return new ResponseEntity<>(trackingResource, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TrackingResource>> getAllTracking() {
        var getAllTrackingQuery =new GetAllTrackingQuery();
        var tracking =trackingQueryService.handle(getAllTrackingQuery);
        var trackingResources= tracking.stream().map(TrackingResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(trackingResources);
    }

    @DeleteMapping("/{trackingId}")
        public ResponseEntity<String> deleteTracking(@PathVariable Long trackingId) {
        try {
            var deleteTrackingCommand = new DeleteTrackingCommand(trackingId);
            trackingCommandService.handle(deleteTrackingCommand);
            return ResponseEntity.ok("Deleted successfully");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }




}



