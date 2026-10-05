package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.autoloc.domaine.reservation;

public interface ReservationRepository extends CrudRepository<reservation, Long> {

}
