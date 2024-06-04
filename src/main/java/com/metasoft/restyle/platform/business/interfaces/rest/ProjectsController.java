package com.metasoft.restyle.platform.business.interfaces.rest;

import com.metasoft.restyle.platform.business.domain.model.aggregates.Project;
import com.metasoft.restyle.platform.business.domain.model.queries.GetAllProjectsByBusinessIdQuery;
import com.metasoft.restyle.platform.business.domain.model.queries.GetProjectByIdQuery;
import com.metasoft.restyle.platform.business.domain.services.ProjectCommandService;
import com.metasoft.restyle.platform.business.domain.services.ProjectQueryService;
import com.metasoft.restyle.platform.business.interfaces.rest.resources.CreateProjectResource;
import com.metasoft.restyle.platform.business.interfaces.rest.resources.ProjectResource;
import com.metasoft.restyle.platform.business.interfaces.rest.transform.CreateProjectCommandFromResourceAssembler;
import com.metasoft.restyle.platform.business.interfaces.rest.transform.ProjectResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectsController {

    private final ProjectCommandService projectCommandService;
    private final ProjectQueryService projectQueryService;

    public ProjectsController(ProjectCommandService projectCommandService, ProjectQueryService projectQueryService) {
        this.projectCommandService = projectCommandService;
        this.projectQueryService = projectQueryService;
    }

    @PostMapping
    public ResponseEntity<ProjectResource> createProject(@RequestBody CreateProjectResource resource){
        Optional<Project> project = projectCommandService.handle(CreateProjectCommandFromResourceAssembler.toCommandFromResource(resource));
        return project.map(p-> new ResponseEntity<>(ProjectResourceFromEntityAssembler.toResourceFromEntity(p), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProjectResource> getProjectById(@PathVariable Long id){
        Optional<Project> project = projectQueryService.handle(new GetProjectByIdQuery(id));
        return project.map(p -> ResponseEntity.ok(ProjectResourceFromEntityAssembler.toResourceFromEntity(p))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<List<ProjectResource>> getAllProjectsByBusinessId(Long businessId){
        var getAllProjectsByBusinessIdQuery = new GetAllProjectsByBusinessIdQuery(businessId);
        var projects = projectQueryService.handle(getAllProjectsByBusinessIdQuery);
        if(projects.isEmpty()) return ResponseEntity.notFound().build();
        var projectResources = projects.stream().map(ProjectResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(projectResources);
    }

    @GetMapping
    public ResponseEntity<?> getProjectsWithParameters(@RequestParam Map<String, String> parameters){
        if(parameters.containsKey("businessId")){
            return getAllProjectsByBusinessId(Long.parseLong(parameters.get("businessId")));
        }
        return ResponseEntity.badRequest().build();
    }

}
