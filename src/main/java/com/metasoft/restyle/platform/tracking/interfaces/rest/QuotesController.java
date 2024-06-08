package com.metasoft.restyle.platform.tracking.interfaces.rest;
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

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/quotes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="quotes")
public class QuotesController {
    private final QuotesQueryService quotesQueryService;
    private final QuotesCommandService quotesCommandService;

    public QuotesController(QuotesCommandService quotesCommandService, QuotesQueryService quotesQueryService) {
        this.quotesCommandService = quotesCommandService;
        this.quotesQueryService = quotesQueryService;
    }

    @PostMapping
    public ResponseEntity<QuotesResource> createQuotes(@RequestBody CreateQuotesResource resource) {
        var createQuoteCommand = CreateQuotesCommandFromResourceAssembler.toCommandResource(resource);
        var quotesId = quotesCommandService.handle(createQuoteCommand);

        var getQuotesByIdQuery = new GetQuotesByIdQuery(quotesId);
        var quotes = quotesQueryService.handle(getQuotesByIdQuery);

        if (quotes.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var quotesResource = QuotesResourceFromEntityAssembler.toResourceFromEntity(quotes.get());
        return new ResponseEntity<>(quotesResource, HttpStatus.CREATED);

    }
    // Get all quotes
    @GetMapping
    public ResponseEntity<List<QuotesResource>> getAllQuotes() {
        var getAllQuotesQuery = new GetAllQuotesQuery();
        var quotes = quotesQueryService.handle(getAllQuotesQuery);
        var quotesResources = quotes.stream().map(QuotesResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(quotesResources);
    }

    // Delete quotes by id
    @DeleteMapping("/{quotesId}")
    public ResponseEntity<String> deleteQuotes(@PathVariable Long quotesId) {
        try {
            var deleteQuotesCommand = new DeleteQuotesCommand(quotesId);
            quotesCommandService.handle(deleteQuotesCommand);
            return ResponseEntity.ok("Quotes deleted successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

}
