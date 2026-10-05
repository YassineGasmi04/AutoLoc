package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domaine.equipement;

import java.util.List;

public interface IequipementService {
    List<equipement> retrieveAllEquipements();
    equipement addEquipement(equipement e);
    equipement updateEquipement(equipement e);
    equipement retrieveEquipement(Long idEquipement);
    void removeEquipement(Long idEquipement);
    List<equipement> addEquipements(List<equipement> equipements);
}
