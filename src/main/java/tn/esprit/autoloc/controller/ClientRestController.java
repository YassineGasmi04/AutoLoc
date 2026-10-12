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
import tn.esprit.autoloc.domaine.client;
import tn.esprit.autoloc.service.IclientService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@Tag(name = "Clients", description = "Gestion des clients (CRUD)")
public class ClientRestController {

    private final IclientService clientService;

    @Operation(summary = "Lister tous les clients")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Liste récupérée",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = client.class))))
    })
    @GetMapping
    public List<client> getAll() {
        return clientService.retrieveAllClients();
    }

    @Operation(summary = "Récupérer un client par id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client trouvé",
                    content = @Content(schema = @Schema(implementation = client.class))),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<client> getById(
            @Parameter(description = "Identifiant du client") @PathVariable Long id) {
        client c = clientService.retrieveClient(id);
        return c == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(c);
    }

    @Operation(summary = "Ajouter un client",
            description = "Si dateInscription n'est pas fournie, la date du jour est utilisée.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Client créé",
                    content = @Content(schema = @Schema(implementation = client.class)))
    })
    @PostMapping
    public ResponseEntity<client> add(@RequestBody client c) {
        if (c.getDateInscription() == null) {
            c.setDateInscription(LocalDate.now());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.addClient(c));
    }

    @Operation(summary = "Modifier un client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client modifié",
                    content = @Content(schema = @Schema(implementation = client.class))),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<client> update(
            @Parameter(description = "Identifiant du client") @PathVariable Long id,
            @RequestBody client c) {
        client existant = clientService.retrieveClient(id);
        if (existant == null) {
            return ResponseEntity.notFound().build();
        }
        c.setIdClient(id);
        if (c.getDateInscription() == null) {
            c.setDateInscription(existant.getDateInscription());
        }
        return ResponseEntity.ok(clientService.updateClient(c));
    }

    @Operation(summary = "Supprimer un client")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Client supprimé", content = @Content),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Identifiant du client") @PathVariable Long id) {
        if (clientService.retrieveClient(id) == null) {
            return ResponseEntity.notFound().build();
        }
        clientService.removeClient(id);
        return ResponseEntity.noContent().build();
    }
}