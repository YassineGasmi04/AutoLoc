package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.autoloc.domaine.employe;

public interface EmployeRepository extends CrudRepository<employe, Long> {

}
