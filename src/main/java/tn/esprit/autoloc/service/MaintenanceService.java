package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MaintenanceService implements ImaintenanceService{
    final MaintenanceRepository maintRepo;
    @Override
    public List<Maintenance> retrieveAllMaintenances() {
        return (List<Maintenance>) maintRepo.findAll();
    }

    @Override
    public Maintenance addMaintenance(Maintenance c) {
        return maintRepo.save(c);
    }

    @Override
    public Maintenance updateMaintenance(Maintenance c) {
        return maintRepo.save(c);
    }

    @Override
    public Maintenance retrieveMaintenance(Long idMaintenance) {

        return maintRepo.findById(idMaintenance).orElse(null);

    }

    @Override
    public void removeMaintenance(Long idMaintenance) {
        maintRepo.deleteById(idMaintenance);

    }

    @Override
    public List<Maintenance> addMaintenances(List<Maintenance> Maintenances) {
        return (List<Maintenance>) maintRepo.saveAll(Maintenances);
    }
}
