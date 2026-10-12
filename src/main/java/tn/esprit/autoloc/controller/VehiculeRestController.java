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
import tn.esprit.autoloc.domaine.Vehicule;
import tn.esprit.autoloc.service.IvehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
@Tag(name = "Véhicules", description = "Gestion des véhicules (CRUD)")
public class VehiculeRestController {

    private final IvehiculeService vehiculeService;

    @Operation(summary = "Lister tous les véhicules")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Liste récupérée",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Vehicule.class))))
    })
    @GetMapping
    public List<Vehicule> getAll() {
        return vehiculeService.retrieveAllVehicules();
    }

    @Operation(summary = "Récupérer un véhicule par id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé",
                    content = @Content(schema = @Schema(implementation = Vehicule.class))),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getById(
            @Parameter(description = "Identifiant du véhicule") @PathVariable Long id) {
        Vehicule v = vehiculeService.retrieveVehicule(id);
        return v == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(v);
    }

    @Operation(summary = "Ajouter un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Véhicule créé",
                    content = @Content(schema = @Schema(implementation = Vehicule.class)))
    })
    @PostMapping
    public ResponseEntity<Vehicule> add(@RequestBody Vehicule v) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeService.addVehicule(v));
    }

    @Operation(summary = "Modifier un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule modifié",
                    content = @Content(schema = @Schema(implementation = Vehicule.class))),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> update(@PathVariable Long id, @RequestBody Vehicule v) {
        if (vehiculeService.retrieveVehicule(id) == null) {
            return ResponseEntity.notFound().build();
        }
        v.setIdVehicule(id);
        return ResponseEntity.ok(vehiculeService.updateVehicule(v));
    }

    @Operation(summary = "Supprimer un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Véhicule supprimé", content = @Content),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (vehiculeService.retrieveVehicule(id) == null) {
            return ResponseEntity.notFound().build();
        }
        vehiculeService.removeVehicule(id);
        return ResponseEntity.noContent().build();
    }
}