package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domaine.equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementService implements IequipementService {

    private final EquipementRepository eRepo;

    @Override
    public List<equipement> retrieveAllEquipements() {
        return (List<equipement>) eRepo.findAll();
    }

    @Override
    public equipement addEquipement(equipement e) {
        return eRepo.save(e);
    }

    @Override
    public equipement updateEquipement(equipement e) {
        return eRepo.save(e);
    }

    @Override
    public equipement retrieveEquipement(Long idEquipement) {
        return eRepo.findById(idEquipement).orElse(null);
    }

    @Override
    public void removeEquipement(Long idEquipement) {
        eRepo.deleteById(idEquipement);
    }

    @Override
    public List<equipement> addEquipements(List<equipement> equipements) {
        return (List<equipement>) eRepo.saveAll(equipements);
    }
}
