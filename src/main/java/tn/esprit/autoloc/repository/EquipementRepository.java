package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.autoloc.domaine.equipement;

public interface EquipementRepository extends CrudRepository<equipement, Long> {

}
