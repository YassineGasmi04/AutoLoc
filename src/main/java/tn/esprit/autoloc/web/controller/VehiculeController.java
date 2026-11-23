package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IvehiculeService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeController {
    private final IvehiculeService VehiculeService;
    @PostMapping("/addVehicule")
    public Vehicule addVehicule(@RequestBody Vehicule c){
        return VehiculeService.addVehicule(c);
    }
    @GetMapping("/getVehicules")
    public List<Vehicule> getAllVehicules(){
        return VehiculeService.retrieveAllVehicules();
    }
    @GetMapping("/getVehiculeId/{idc}")
    public Vehicule getVehiculeById(@PathVariable long idc){
        return VehiculeService.retrieveVehicule(idc);
    }
    @DeleteMapping("/deleteVehicule/{idc}")
    public void deleteVehicule(@PathVariable long idc){
        VehiculeService.removeVehicule(idc);
    }

    @PutMapping("/updateVehicule")
    public Vehicule updateVehicule(@RequestBody Vehicule c){
        return VehiculeService.updateVehicule(c);
    }

    @PutMapping("/affecterVehicule/{idVehicule}/{idAgence}")
    public Vehicule affecterVehicule(@PathVariable Long idVehicule, @PathVariable Long idAgence){
        return VehiculeService.affecterVehicule(idVehicule, idAgence);
    }

    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement){
        return VehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement){
        return VehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }

    @GetMapping("/marque/{marque}")
    public List<Vehicule> getByMarque(@PathVariable String marque){
        return VehiculeService.getByMarque(marque);
    }

    @GetMapping("/categorie/{categorie}")
    public List<Vehicule> getByCategorie(@PathVariable CategorieVehicule categorie){
        return VehiculeService.getByCategorie(categorie);
    }

    @GetMapping("/disponibles")
    public List<Vehicule> getDisponibles(){
        return VehiculeService.getDisponibles();
    }

    @GetMapping("/marqueContient/{marque}")
    public List<Vehicule> getByMarqueContient(@PathVariable String marque){
        return VehiculeService.getByMarqueContient(marque);
    }

    @GetMapping("/tarifSup100")
    public List<Vehicule> getTarifSup100(){
        return VehiculeService.getTarifSup100();
    }

    @GetMapping("/marqueDisponible/{marque}")
    public List<Vehicule> getByMarqueDisponible(@PathVariable String marque){
        return VehiculeService.getByMarqueDisponible(marque);
    }

}
