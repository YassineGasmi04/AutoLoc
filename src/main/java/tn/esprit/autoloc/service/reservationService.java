package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class reservationService implements IreservationService {
   final ReservationRepository resRepo;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return (List<Reservation>) resRepo.findAll();
    }

    @Override
    public Reservation addReservation(Reservation c) {
        return resRepo.save(c);
    }

    @Override
    public Reservation updateReservation(Reservation c) {
        return resRepo.save(c);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {

        return resRepo.findById(idReservation).orElse(null);

    }

    @Override
    public void removeReservation(Long idReservation) {
        resRepo.deleteById(idReservation);

    }

    @Override
    public List<Reservation> addReservations(List<Reservation> Reservations) {
        return (List<Reservation>) resRepo.saveAll(Reservations);
    }

    @Override
    public List<Reservation> getDebutApres(Date date) {
        return resRepo.findByDateDebutAfter(date);
    }
}
