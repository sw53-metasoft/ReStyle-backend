package com.metasoft.restyle.business.interfaces.rest;

import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.model.aggregates.Business;
import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.model.queries.GetBusinessByIdQuery;
import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.services.BusinessCommandService;
import com.metasoft.restyle.business.infrastructure.persistance.jpa.domain.services.BusinessQueryService;
import com.metasoft.restyle.business.interfaces.rest.resources.BusinessResource;
import com.metasoft.restyle.business.interfaces.rest.resources.CreateBusinessResource;
import com.metasoft.restyle.business.interfaces.rest.transform.BusinessResourceFromEntityAssembler;
import com.metasoft.restyle.business.interfaces.rest.transform.CreateBusinessCommandFromResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/businesses")
public class BusinessesController {

    private final BusinessCommandService businessCommandService;

    private final BusinessQueryService businessQueryService;

    public BusinessesController(BusinessCommandService businessCommandService, BusinessQueryService businessQueryService) {
        this.businessCommandService = businessCommandService;
        this.businessQueryService = businessQueryService;
    }

    @PostMapping
    public ResponseEntity<BusinessResource> createBusiness(@RequestBody CreateBusinessResource resource) {
        Optional<Business> business = businessCommandService.handle(CreateBusinessCommandFromResourceAssembler.toCommandFromResource(resource));
        return business.map(b -> new ResponseEntity<>(BusinessResourceFromEntityAssembler.toResourceFromEntity(b), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<BusinessResource> getBusinessById(@PathVariable Long id) {
        Optional<Business> business = businessQueryService.handle(new GetBusinessByIdQuery(id));
        return business.map(b -> ResponseEntity.ok(BusinessResourceFromEntityAssembler.toResourceFromEntity(b))).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
