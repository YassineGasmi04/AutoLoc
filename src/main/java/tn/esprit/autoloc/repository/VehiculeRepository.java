package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehiculeRepository extends CrudRepository<Vehicule,Long> {
    List<Vehicule> findByMarque(String marque);
    List<Vehicule> findByCategorie(CategorieVehicule categorie);
    List<Vehicule> findByStatut(StatutVehicule statut);
    List<Vehicule> findByMarqueContaining(String marque);
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);
    List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);

    @Query("SELECT v FROM Vehicule v WHERE v.agence.id = :idAgence")
    List<Vehicule> getVehiculesByAgence(@Param("idAgence") Long idAgence);


    @Query("SELECT a.nom, COUNT(v) FROM Agence a LEFT JOIN a.vehicules v GROUP BY a.id, a.nom")
    List<Object[]> countVehiculesByAgence();
}
