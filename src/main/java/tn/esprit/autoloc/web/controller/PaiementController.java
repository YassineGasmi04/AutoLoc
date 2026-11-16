package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IpaiementService;
import tn.esprit.autoloc.service.PaiementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paiement")
public class PaiementController {
    private final IpaiementService paiementService;
    @PostMapping("/addPaiement")
    public Paiement addPaiement(@RequestBody Paiement p){
        return paiementService.addPaiement(p);
    }
    @GetMapping("/getPaiements")
    public List<Paiement> getAllPaiements(){
        return paiementService.retrieveAllPaiements();
    }
    @GetMapping("/getPaiementId/{idp}")
    public Paiement getPaiementById(@PathVariable long idp){
        return paiementService.retrievePaiement(idp);
    }
    @DeleteMapping("/deletePaiement/{idp}")
    public void deletePaiement(@PathVariable long idp){
        paiementService.removePaiement(idp);
    }

    @PutMapping("/updatePaiement")
    public Paiement updatePaiement(@RequestBody Paiement p){
        return paiementService.updatePaiement(p);
    }
}
