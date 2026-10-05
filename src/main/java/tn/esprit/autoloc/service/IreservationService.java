package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domaine.reservation;

import java.util.List;

public interface IreservationService {
    List<reservation> retrieveAllReservations();
    reservation addReservation(reservation r);
    reservation updateReservation(reservation r);
    reservation retrieveReservation(Long idReservation);
    void removeReservation(Long idReservation);
    List<reservation> addReservations(List<reservation> reservations);
}
