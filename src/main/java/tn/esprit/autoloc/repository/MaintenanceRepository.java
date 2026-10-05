package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.autoloc.domaine.maintenance;

public interface MaintenanceRepository extends CrudRepository<maintenance, Long> {

}
