package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IequipementService;
import tn.esprit.autoloc.service.ImaintenanceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipement")
public class EquipementController {
    private final IequipementService equipementService;
    @PostMapping("/addEquipement")
    public Equipement addEquipement(@RequestBody Equipement c){
        return equipementService.addEquipement(c);
    }
    @GetMapping("/getEquipements")
    public List<Equipement> getAllEquipements(){
        return equipementService.retrieveAllEquipements();
    }
    @GetMapping("/getEquipementId/{idc}")
    public Equipement getEquipementById(@PathVariable long idc){
        return equipementService.retrieveEquipement(idc);
    }
    @DeleteMapping("/deleteEquipement/{idc}")
    public void deleteEquipement(@PathVariable long idc){
        equipementService.removeEquipement(idc);
    }

    @PutMapping("/updateEquipement")
    public Equipement updateEquipement(@RequestBody Equipement c){
        return equipementService.updateEquipement(c);
    }
    
}
