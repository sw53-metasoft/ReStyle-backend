package com.metasoft.restyle.platform.profiles.interfaces.rest;

import com.metasoft.restyle.platform.profiles.domain.model.queries.GetAllProfilesQuery;
import com.metasoft.restyle.platform.profiles.domain.model.queries.GetProfileByIdQuery;
import com.metasoft.restyle.platform.profiles.domain.services.ProfileCommandService;
import com.metasoft.restyle.platform.profiles.domain.services.ProfileQueryService;
import com.metasoft.restyle.platform.profiles.interfaces.rest.resources.CreateProfileResource;
import com.metasoft.restyle.platform.profiles.interfaces.rest.resources.ProfileResource;
import com.metasoft.restyle.platform.profiles.interfaces.rest.resources.UpdateProfileResource;
import com.metasoft.restyle.platform.profiles.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import com.metasoft.restyle.platform.profiles.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import com.metasoft.restyle.platform.profiles.interfaces.rest.transform.UpdateProfileCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ProfilesController
 * <p>
 *     This class is the entry point for all the REST endpoints related to the Profile entity.
 * </p>
 */
@RestController
@RequestMapping(value = "/api/v1/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Profiles", description = "Profile Management Endpoints")
public class ProfilesController {
    private final ProfileQueryService profileQueryService;
    private final ProfileCommandService profileCommandService;

    public ProfilesController(ProfileQueryService profileQueryService, ProfileCommandService profileCommandService) {
        this.profileQueryService = profileQueryService;
        this.profileCommandService = profileCommandService;
    }

    @PostMapping
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreateProfileResource resource) {
        var createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var profile = profileCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return ResponseEntity.badRequest().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    /**
     * Gets a Profile by its id
     * @param profileId the id of the Profile to get
     * @return the Profile resource associated to given Profile id
     */
    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable Long profileId) {
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) return ResponseEntity.badRequest().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }

    /**
     * Gets all the Profiles
     * @return a list of all the Profile resources currently stored
     */
    @GetMapping
    public ResponseEntity<List<ProfileResource>> getAllProfiles() {
        var getAllProfilesQuery = new GetAllProfilesQuery();
        var profiles = profileQueryService.handle(getAllProfilesQuery);
        var profileResources = profiles.stream().map(ProfileResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(profileResources);
    }

    /**
      Updates a Profile
      @param profileId the id of the Profile to update
     * @return the updated Profile resource
     */
    @PutMapping("/{profileId}")
    public ResponseEntity<ProfileResource> updateProfile(@PathVariable Long profileId, @RequestBody UpdateProfileResource resource) {
        var updateProfileCommand = UpdateProfileCommandFromResourceAssembler.toCommandFromResource(profileId, resource);
        profileCommandService.handle(updateProfileCommand);

        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);

        if (profile.isEmpty()) return ResponseEntity.notFound().build();

        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }
}
