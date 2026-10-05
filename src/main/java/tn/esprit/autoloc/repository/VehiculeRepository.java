package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.autoloc.domaine.Vehicule;

public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {

}
