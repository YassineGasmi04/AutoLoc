package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface IvehiculeService {
    List<Vehicule> retrieveAllVehicules();
    Vehicule addVehicule( Vehicule c);
    Vehicule updateVehicule( Vehicule c);
    Vehicule retrieveVehicule(Long idVehicule);
    void removeVehicule(Long idVehicule);
    List< Vehicule> addVehicules (List< Vehicule>  Vehicules);
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence);
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);

    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);

    List<Vehicule> getByMarque(String marque);
    List<Vehicule> getByCategorie(CategorieVehicule categorie);
    List<Vehicule> getDisponibles();
    List<Vehicule> getByMarqueContient(String marque);
    List<Vehicule> getTarifSup100();
    List<Vehicule> getByMarqueDisponible(String marque);

}
