package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.ImaintenanceService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceController {
    private final ImaintenanceService maintenanceService;
    @PostMapping("/addMaintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance c){
        return maintenanceService.addMaintenance(c);
    }
    @GetMapping("/getMaintenances")
    public List<Maintenance> getAllMaintenances(){
        return maintenanceService.retrieveAllMaintenances();
    }
    @GetMapping("/getMaintenanceId/{idc}")
    public Maintenance getMaintenanceById(@PathVariable long idc){
        return maintenanceService.retrieveMaintenance(idc);
    }
    @DeleteMapping("/deleteMaintenance/{idc}")
    public void deleteMaintenance(@PathVariable long idc){
        maintenanceService.removeMaintenance(idc);
    }

    @PutMapping("/updateMaintenance")
    public Maintenance updateMaintenance(@RequestBody Maintenance c){
        return maintenanceService.updateMaintenance(c);
    }
}
