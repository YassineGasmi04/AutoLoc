package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    List<Reservation> findByDateDebutAfter(Date date);

    @Query("SELECT r FROM Reservation r WHERE r.client.idClient = :idClient")
    List<Reservation> getReservationsByClient(@Param("idClient") Long idClient);


    @Query("SELECT c.nom, c.prenom, COUNT(r) FROM Client c LEFT JOIN c.reservations r GROUP BY c.idClient, c.nom, c.prenom")
    List<Object[]> countReservationsByClient();
}
