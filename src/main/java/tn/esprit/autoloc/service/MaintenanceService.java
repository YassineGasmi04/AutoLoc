package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domaine.maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceService implements ImaintenanceService {

    private final MaintenanceRepository mRepo;

    @Override
    public List<maintenance> retrieveAllMaintenances() {
        return (List<maintenance>) mRepo.findAll();
    }

    @Override
    public maintenance addMaintenance(maintenance m) {
        return mRepo.save(m);
    }

    @Override
    public maintenance updateMaintenance(maintenance m) {
        return mRepo.save(m);
    }

    @Override
    public maintenance retrieveMaintenance(Long idMaintenance) {
        return mRepo.findById(idMaintenance).orElse(null);
    }

    @Override
    public void removeMaintenance(Long idMaintenance) {
        mRepo.deleteById(idMaintenance);
    }

    @Override
    public List<maintenance> addMaintenances(List<maintenance> maintenances) {
        return (List<maintenance>) mRepo.saveAll(maintenances);
    }
}
