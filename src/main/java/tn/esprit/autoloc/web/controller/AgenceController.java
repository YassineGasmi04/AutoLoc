package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IagenceService;
import tn.esprit.autoloc.service.IclientService;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/agence")

public class AgenceController {

    private final IagenceService agenceService;
    @PostMapping("/addAgence")
    public Agence addAgence(@RequestBody Agence a){
        return agenceService.addAgence(a);
    }
    @GetMapping("/getAgences")
    public List<Agence> getAllAgences(){
        return agenceService.retrieveAllAgences();
    }
    @GetMapping("/getClientId/{ida}")
    public Agence getAgenceById(@PathVariable long ida){
        return agenceService.retrieveAgence(ida);
    }
    @DeleteMapping("/deleteClient/{idc}")
    public void deleteClient(@PathVariable long idc){
        agenceService.removeAgence(idc);
    }

    @PutMapping("/updateAgence")
    public Agence updateAgence(@RequestBody Agence a){
        return agenceService.updateAgence(a);
    }

    @GetMapping("/ville/{ville}")
    public List<Agence> getByVille(@PathVariable String ville){
        return agenceService.getByVille(ville);
    }




}
