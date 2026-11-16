package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;

import java.util.Date;
import java.util.List;

public interface IreservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation( Reservation c);
    Reservation updateReservation( Reservation c);
    Reservation retrieveReservation(Long idReservation);
    void removeReservation(Long idReservation);
    List< Reservation> addReservations (List< Reservation>  Reservations);
    List<Reservation> getDebutApres(Date date);
}
