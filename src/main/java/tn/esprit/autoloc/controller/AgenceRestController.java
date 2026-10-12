package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domaine.agence;
import tn.esprit.autoloc.service.IagenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
@Tag(name = "Agences", description = "Gestion des agences (CRUD)")
public class AgenceRestController {

    private final IagenceService agenceService;

    @Operation(summary = "Lister toutes les agences")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Liste récupérée",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = agence.class))))
    })
    @GetMapping
    public List<agence> getAll() {
        return agenceService.retrieveAllAgences();
    }

    @Operation(summary = "Récupérer une agence par id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence trouvée",
                    content = @Content(schema = @Schema(implementation = agence.class))),
            @ApiResponse(responseCode = "404", description = "Agence introuvable", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<agence> getById(
            @Parameter(description = "Identifiant de l'agence") @PathVariable Long id) {
        agence a = agenceService.retrieveAgence(id);
        return a == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(a);
    }

    @Operation(summary = "Ajouter une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Agence créée",
                    content = @Content(schema = @Schema(implementation = agence.class)))
    })
    @PostMapping
    public ResponseEntity<agence> add(@RequestBody agence a) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agenceService.addAgence(a));
    }

    @Operation(summary = "Modifier une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence modifiée",
                    content = @Content(schema = @Schema(implementation = agence.class))),
            @ApiResponse(responseCode = "404", description = "Agence introuvable", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<agence> update(
            @Parameter(description = "Identifiant de l'agence") @PathVariable Long id,
            @RequestBody agence a) {
        if (agenceService.retrieveAgence(id) == null) {
            return ResponseEntity.notFound().build();
        }
        a.setIdAgence(id);
        return ResponseEntity.ok(agenceService.updateAgence(a));
    }

    @Operation(summary = "Supprimer une agence",
            description = "Impossible si l'agence possède encore des véhicules ou des employés.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Agence supprimée", content = @Content),
            @ApiResponse(responseCode = "404", description = "Agence introuvable", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Identifiant de l'agence") @PathVariable Long id) {
        if (agenceService.retrieveAgence(id) == null) {
            return ResponseEntity.notFound().build();
        }
        agenceService.removeAgence(id);
        return ResponseEntity.noContent().build();
    }
}