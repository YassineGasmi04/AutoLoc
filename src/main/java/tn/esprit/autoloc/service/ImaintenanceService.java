package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domaine.maintenance;

import java.util.List;

public interface ImaintenanceService {
    List<maintenance> retrieveAllMaintenances();
    maintenance addMaintenance(maintenance m);
    maintenance updateMaintenance(maintenance m);
    maintenance retrieveMaintenance(Long idMaintenance);
    void removeMaintenance(Long idMaintenance);
    List<maintenance> addMaintenances(List<maintenance> maintenances);
}
