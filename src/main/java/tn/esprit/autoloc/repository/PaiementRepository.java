package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.autoloc.domaine.paiement;

public interface PaiementRepository extends CrudRepository<paiement, Long> {

}
