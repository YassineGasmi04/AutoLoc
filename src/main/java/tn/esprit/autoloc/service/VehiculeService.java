package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
@Service
@RequiredArgsConstructor
public class VehiculeService implements IvehiculeService {
    final VehiculeRepository vRepo;
    final AgenceRepository agenceRepo;
    final EquipementRepository equipementRepo;
    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return (List<Vehicule>) vRepo.findAll();
    }

    @Override
    public Vehicule addVehicule(Vehicule c) {
        return vRepo.save(c);
    }

    @Override
    public Vehicule updateVehicule(Vehicule c) {
        return vRepo.save(c);
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {

        return vRepo.findById(idVehicule).orElse(null);

    }

    @Override
    public void removeVehicule(Long idVehicule) {
        vRepo.deleteById(idVehicule);

    }

    @Override
    public List<Vehicule> addVehicules(List<Vehicule> Vehicules) {
        return (List<Vehicule>) vRepo.saveAll(Vehicules);
    }

    @Override
    @Transactional
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        Vehicule vehicule = vRepo.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable"));

        Agence agence = agenceRepo.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));

        vehicule.setAgence(agence);
        return vRepo.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vRepo.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable"));

        Equipement equipement = equipementRepo.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Équipement introuvable"));

        if (vehicule.getEquipements() == null) {
            vehicule.setEquipements(new HashSet<>());
        }
        vehicule.getEquipements().add(equipement); // Set : pas de doublon

        return vRepo.save(vehicule);
    }

    // Scénario 3 (retour) : l'équipement est retiré du véhicule (le lien disparaît, pas l'équipement)
    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vRepo.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable"));

        Equipement equipement = equipementRepo.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Équipement introuvable"));

        if (vehicule.getEquipements() != null) {
            vehicule.getEquipements().remove(equipement);
        }

        return vRepo.save(vehicule);
    }

    @Override
    public List<Vehicule> getByMarque(String marque) {
        return vRepo.findByMarque(marque);
    }

    @Override
    public List<Vehicule> getByCategorie(CategorieVehicule categorie) {
        return vRepo.findByCategorie(categorie);
    }

    @Override
    public List<Vehicule> getDisponibles() {
        return vRepo.findByStatut(StatutVehicule.DISPONIBLE);
    }

    @Override
    public List<Vehicule> getByMarqueContient(String marque) {
        return vRepo.findByMarqueContaining(marque);
    }

    @Override
    public List<Vehicule> getTarifSup100() {
        return vRepo.findByTarifJournalierGreaterThan(new BigDecimal("100"));
    }

    @Override
    public List<Vehicule> getByMarqueDisponible(String marque) {
        return vRepo.findByMarqueAndStatut(marque, StatutVehicule.DISPONIBLE);
    }
}
